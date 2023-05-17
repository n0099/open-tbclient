package com.baidu.cyberplayer.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
@Keep
/* loaded from: classes3.dex */
public class DuplayerHandlerThreadPool {
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";
    public static final Object b = new Object();
    public a a;
    public ArrayList<DuplayerHandlerThread> c;
    public ArrayList<DuplayerHandlerThread> d;
    public c e;

    /* loaded from: classes3.dex */
    public static class a {
        public final AtomicInteger a = new AtomicInteger(1);
        public final String b;
        public int c;

        public a(String str) {
            this.c = 5;
            this.b = str + "-";
            this.c = 5;
        }

        public DuplayerHandlerThread a() {
            DuplayerHandlerThread duplayerHandlerThread = new DuplayerHandlerThread(this.b + this.a.getAndIncrement());
            duplayerHandlerThread.setPriority(this.c);
            return duplayerHandlerThread;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static DuplayerHandlerThreadPool a = new DuplayerHandlerThreadPool();
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 100) {
                DuplayerHandlerThreadPool.getInstance().checkIdlePoolLongTimeNoUse();
            } else if (i != 101) {
            } else {
                DuplayerHandlerThreadPool.getInstance().b();
            }
        }
    }

    public DuplayerHandlerThreadPool() {
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.a = new a("duplayer-t");
        this.e = new c(Looper.getMainLooper());
    }

    private DuplayerHandlerThread a() {
        DuplayerHandlerThread a2 = this.a.a();
        a2.start();
        return a2;
    }

    private void a(DuplayerHandlerThread duplayerHandlerThread) {
        CyberLog.d(TAG, " quitHandlerThread handlerThread:" + duplayerHandlerThread);
        if (duplayerHandlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                if (duplayerHandlerThread == null) {
                    return;
                }
                try {
                    duplayerHandlerThread.getLooper().quitSafely();
                    return;
                } catch (NoSuchMethodError unused) {
                }
            }
            duplayerHandlerThread.getLooper().quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (b) {
            int size = this.c.size();
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int i = size - 3;
                Iterator<DuplayerHandlerThread> it = this.c.iterator();
                while (it.hasNext() && i > 0) {
                    DuplayerHandlerThread next = it.next();
                    if (next != null) {
                        long idleBeginTime = next.getIdleBeginTime();
                        if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                            it.remove();
                            a(next);
                            i += -1;
                        }
                    }
                }
                print();
            }
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse end");
        }
    }

    public static DuplayerHandlerThreadPool getInstance() {
        return b.a;
    }

    public void checkIdlePoolLongTimeNoUse() {
        synchronized (b) {
            if (this.c.size() <= 0) {
                return;
            }
            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse called size:" + this.c.size());
            Iterator<DuplayerHandlerThread> it = this.c.iterator();
            while (it.hasNext()) {
                DuplayerHandlerThread next = it.next();
                if (next != null) {
                    long idleBeginTime = next.getIdleBeginTime();
                    CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - idleBeginTime));
                    if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= com.heytap.mcssdk.constant.a.h) {
                        CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use");
                        it.remove();
                        a(next);
                    }
                }
            }
            print();
            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse  called end");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:11:0x0029, B:13:0x003e, B:14:0x0045, B:16:0x004e, B:17:0x0055, B:18:0x006e, B:7:0x0011), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:11:0x0029, B:13:0x003e, B:14:0x0045, B:16:0x004e, B:17:0x0055, B:18:0x006e, B:7:0x0011), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DuplayerHandlerThread obtain() {
        DuplayerHandlerThread duplayerHandlerThread;
        synchronized (b) {
            if (this.c.size() != 0) {
                int size = this.c.size() - 1;
                DuplayerHandlerThread duplayerHandlerThread2 = this.c.get(size);
                this.c.remove(size);
                if (duplayerHandlerThread2 != null) {
                    duplayerHandlerThread = duplayerHandlerThread2;
                    duplayerHandlerThread.setRunState(1);
                    duplayerHandlerThread.setIdleBeginTime(-1L);
                    this.d.add(duplayerHandlerThread);
                    if (this.c.size() <= 0) {
                        this.e.removeMessages(100);
                    }
                    if (this.c.size() <= 3) {
                        this.e.removeMessages(101);
                    }
                    CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
                    print();
                }
            }
            duplayerHandlerThread = a();
            duplayerHandlerThread.setRunState(1);
            duplayerHandlerThread.setIdleBeginTime(-1L);
            this.d.add(duplayerHandlerThread);
            if (this.c.size() <= 0) {
            }
            if (this.c.size() <= 3) {
            }
            CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
            print();
        }
        return duplayerHandlerThread;
    }

    public void print() {
        synchronized (b) {
            int size = this.c.size();
            CyberLog.d(TAG, "-- mIdlePool size:" + size + "--");
            for (int i = 0; i < size; i++) {
                CyberLog.d(TAG, "-- mIdlePool i:" + i + " " + this.c.get(i) + " --");
            }
            int size2 = this.d.size();
            CyberLog.d(TAG, "-- mBusyPool size:" + size2 + " --");
            for (int i2 = 0; i2 < size2; i2++) {
                CyberLog.d(TAG, "-- mBusyPool i:" + i2 + " " + this.d.get(i2) + " --");
            }
        }
    }

    public void recycle(DuplayerHandlerThread duplayerHandlerThread) {
        if (duplayerHandlerThread == null) {
            return;
        }
        CyberLog.d(TAG, " recycle handlerThread:" + duplayerHandlerThread);
        synchronized (b) {
            duplayerHandlerThread.setIdleBeginTime(SystemClock.uptimeMillis());
            duplayerHandlerThread.setRunState(0);
            this.d.remove(duplayerHandlerThread);
            this.c.add(duplayerHandlerThread);
            if (this.c.size() > 0) {
                this.e.sendEmptyMessageDelayed(100, com.heytap.mcssdk.constant.a.h);
            }
            if (this.c.size() > 3) {
                this.e.sendEmptyMessageDelayed(101, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
            print();
        }
        CyberLog.d(TAG, " recycle  end ");
    }
}
