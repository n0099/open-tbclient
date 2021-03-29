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
/* loaded from: classes.dex */
public class DuplayerHandlerThreadPool {
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";

    /* renamed from: b  reason: collision with root package name */
    public static final Object f5087b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public a f5088a;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<DuplayerHandlerThread> f5089c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<DuplayerHandlerThread> f5090d;

    /* renamed from: e  reason: collision with root package name */
    public c f5091e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f5092a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f5093b;

        /* renamed from: c  reason: collision with root package name */
        public int f5094c;

        public a(String str) {
            this.f5094c = 5;
            this.f5093b = str + "-";
            this.f5094c = 5;
        }

        public DuplayerHandlerThread a() {
            DuplayerHandlerThread duplayerHandlerThread = new DuplayerHandlerThread(this.f5093b + this.f5092a.getAndIncrement());
            duplayerHandlerThread.setPriority(this.f5094c);
            return duplayerHandlerThread;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static DuplayerHandlerThreadPool f5095a = new DuplayerHandlerThreadPool();
    }

    /* loaded from: classes.dex */
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
        this.f5089c = new ArrayList<>();
        this.f5090d = new ArrayList<>();
        this.f5088a = new a("duplayer-t");
        this.f5091e = new c(Looper.getMainLooper());
    }

    private DuplayerHandlerThread a() {
        DuplayerHandlerThread a2 = this.f5088a.a();
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
        synchronized (f5087b) {
            int size = this.f5089c.size();
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int i = size - 3;
                Iterator<DuplayerHandlerThread> it = this.f5089c.iterator();
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
        return b.f5095a;
    }

    public void checkIdlePoolLongTimeNoUse() {
        synchronized (f5087b) {
            if (this.f5089c.size() <= 0) {
                return;
            }
            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse called size:" + this.f5089c.size());
            Iterator<DuplayerHandlerThread> it = this.f5089c.iterator();
            while (it.hasNext()) {
                DuplayerHandlerThread next = it.next();
                if (next != null) {
                    long idleBeginTime = next.getIdleBeginTime();
                    CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - idleBeginTime));
                    if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= 900000) {
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
        synchronized (f5087b) {
            if (this.f5089c.size() != 0) {
                int size = this.f5089c.size() - 1;
                DuplayerHandlerThread duplayerHandlerThread2 = this.f5089c.get(size);
                this.f5089c.remove(size);
                if (duplayerHandlerThread2 != null) {
                    duplayerHandlerThread = duplayerHandlerThread2;
                    duplayerHandlerThread.setRunState(1);
                    duplayerHandlerThread.setIdleBeginTime(-1L);
                    this.f5090d.add(duplayerHandlerThread);
                    if (this.f5089c.size() <= 0) {
                        this.f5091e.removeMessages(100);
                    }
                    if (this.f5089c.size() <= 3) {
                        this.f5091e.removeMessages(101);
                    }
                    CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
                    print();
                }
            }
            duplayerHandlerThread = a();
            duplayerHandlerThread.setRunState(1);
            duplayerHandlerThread.setIdleBeginTime(-1L);
            this.f5090d.add(duplayerHandlerThread);
            if (this.f5089c.size() <= 0) {
            }
            if (this.f5089c.size() <= 3) {
            }
            CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
            print();
        }
        return duplayerHandlerThread;
    }

    public void print() {
        synchronized (f5087b) {
            int size = this.f5089c.size();
            CyberLog.d(TAG, "-- mIdlePool size:" + size + "--");
            for (int i = 0; i < size; i++) {
                CyberLog.d(TAG, "-- mIdlePool i:" + i + " " + this.f5089c.get(i) + " --");
            }
            int size2 = this.f5090d.size();
            CyberLog.d(TAG, "-- mBusyPool size:" + size2 + " --");
            for (int i2 = 0; i2 < size2; i2++) {
                CyberLog.d(TAG, "-- mBusyPool i:" + i2 + " " + this.f5090d.get(i2) + " --");
            }
        }
    }

    public void recycle(DuplayerHandlerThread duplayerHandlerThread) {
        if (duplayerHandlerThread == null) {
            return;
        }
        CyberLog.d(TAG, " recycle handlerThread:" + duplayerHandlerThread);
        synchronized (f5087b) {
            duplayerHandlerThread.setIdleBeginTime(SystemClock.uptimeMillis());
            duplayerHandlerThread.setRunState(0);
            this.f5090d.remove(duplayerHandlerThread);
            this.f5089c.add(duplayerHandlerThread);
            if (this.f5089c.size() > 0) {
                this.f5091e.sendEmptyMessageDelayed(100, 900000L);
            }
            if (this.f5089c.size() > 3) {
                this.f5091e.sendEmptyMessageDelayed(101, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
            print();
        }
        CyberLog.d(TAG, " recycle  end ");
    }
}
