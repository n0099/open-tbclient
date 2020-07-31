package com.baidu.cyberplayer.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
@Keep
/* loaded from: classes10.dex */
public class DuplayerHandlerThreadPool {
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";
    private static final Object b = new Object();
    a a;
    private ArrayList<DuplayerHandlerThread> c;
    private ArrayList<DuplayerHandlerThread> d;
    private c e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private final AtomicInteger a = new AtomicInteger(1);
        private final String b;
        private int c;

        a(String str) {
            this.c = 5;
            this.b = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            this.c = 5;
        }

        public DuplayerHandlerThread a() {
            DuplayerHandlerThread duplayerHandlerThread = new DuplayerHandlerThread(this.b + this.a.getAndIncrement());
            duplayerHandlerThread.setPriority(this.c);
            return duplayerHandlerThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static DuplayerHandlerThreadPool a = new DuplayerHandlerThreadPool();
    }

    /* loaded from: classes10.dex */
    private static class c extends Handler {
        private c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    DuplayerHandlerThreadPool.getInstance().checkIdlePoolLongTimeNoUse();
                    return;
                case 101:
                    DuplayerHandlerThreadPool.getInstance().b();
                    return;
                default:
                    return;
            }
        }
    }

    private DuplayerHandlerThreadPool() {
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
            if (Build.VERSION.SDK_INT < 18) {
                duplayerHandlerThread.getLooper().quit();
            } else if (duplayerHandlerThread != null) {
                try {
                    duplayerHandlerThread.getLooper().quitSafely();
                } catch (NoSuchMethodError e) {
                    duplayerHandlerThread.getLooper().quit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i;
        synchronized (b) {
            int size = this.c.size();
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int i2 = size - 3;
                Iterator<DuplayerHandlerThread> it = this.c.iterator();
                while (it.hasNext() && i2 > 0) {
                    DuplayerHandlerThread next = it.next();
                    if (next != null) {
                        long idleBeginTime = next.getIdleBeginTime();
                        if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= 120000) {
                            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                            it.remove();
                            a(next);
                            i = i2 - 1;
                            i2 = i;
                        }
                    }
                    i = i2;
                    i2 = i;
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

    public DuplayerHandlerThread obtain() {
        DuplayerHandlerThread duplayerHandlerThread;
        synchronized (b) {
            if (this.c.size() == 0) {
                duplayerHandlerThread = a();
            } else {
                int size = this.c.size() - 1;
                duplayerHandlerThread = this.c.get(size);
                this.c.remove(size);
                if (duplayerHandlerThread == null) {
                    duplayerHandlerThread = a();
                }
            }
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
                this.e.sendEmptyMessageDelayed(100, 900000L);
            }
            if (this.c.size() > 3) {
                this.e.sendEmptyMessageDelayed(101, 120000L);
            }
            print();
        }
        CyberLog.d(TAG, " recycle  end ");
    }
}
