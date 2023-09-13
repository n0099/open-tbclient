package com.baidu.cyberplayer.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.searchbox.config.AppConfig;
import com.heytap.mcssdk.constant.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
@Keep
/* loaded from: classes3.dex */
public class DuplayerHandlerThreadPool {
    public static final int JELLY_BEAN_MR2 = 18;
    public static final int MAX_POOL_THREAD_SIZE = 3;
    public static final int MAX_THREAD_IDLE_TIME_LONG = 900000;
    public static final int MAX_THREAD_IDLE_TIME_SHORT = 120000;
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";
    public static final Object sPoolSync = new Object();
    public ArrayList<DuplayerHandlerThread> mBusyPool;
    public PrivateHandler mHandler;
    public DuplayerHandlerThreadFactory mHandlerThreadFactory;
    public ArrayList<DuplayerHandlerThread> mIdlePool;

    /* loaded from: classes3.dex */
    public static class DuplayerHandlerThreadFactory {
        public final String mNamePrefix;
        public int mPriority;
        public final AtomicInteger mThreadNumber = new AtomicInteger(1);

        public DuplayerHandlerThreadFactory(String str) {
            this.mPriority = 5;
            this.mNamePrefix = str + "-";
            this.mPriority = 5;
        }

        public DuplayerHandlerThreadFactory(String str, int i) {
            this.mPriority = 5;
            this.mNamePrefix = str + "-";
            this.mPriority = i;
        }

        public DuplayerHandlerThread newHandlerThread() {
            DuplayerHandlerThread duplayerHandlerThread = new DuplayerHandlerThread(this.mNamePrefix + this.mThreadNumber.getAndIncrement());
            duplayerHandlerThread.setPriority(this.mPriority);
            return duplayerHandlerThread;
        }
    }

    /* loaded from: classes3.dex */
    public static class Holder {
        public static DuplayerHandlerThreadPool sInstance = new DuplayerHandlerThreadPool();
    }

    /* loaded from: classes3.dex */
    public static class PrivateHandler extends Handler {
        public PrivateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                if (i != 101) {
                    return;
                }
                DuplayerHandlerThreadPool.getInstance().checkIdlePoolShortTimeNoUse();
                return;
            }
            DuplayerHandlerThreadPool.getInstance().checkIdlePoolLongTimeNoUse();
        }
    }

    public DuplayerHandlerThreadPool() {
        this.mIdlePool = new ArrayList<>();
        this.mBusyPool = new ArrayList<>();
        this.mHandlerThreadFactory = new DuplayerHandlerThreadFactory("duplayer-t");
        this.mHandler = new PrivateHandler(Looper.getMainLooper());
    }

    public static DuplayerHandlerThreadPool getInstance() {
        return Holder.sInstance;
    }

    private DuplayerHandlerThread newHandlerThread() {
        DuplayerHandlerThread newHandlerThread = this.mHandlerThreadFactory.newHandlerThread();
        newHandlerThread.start();
        return newHandlerThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIdlePoolShortTimeNoUse() {
        synchronized (sPoolSync) {
            int size = this.mIdlePool.size();
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int i = size - 3;
                Iterator<DuplayerHandlerThread> it = this.mIdlePool.iterator();
                while (it.hasNext() && i > 0) {
                    DuplayerHandlerThread next = it.next();
                    if (next != null) {
                        long idleBeginTime = next.getIdleBeginTime();
                        if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                            it.remove();
                            quitHandlerThread(next);
                            i += -1;
                        }
                    }
                }
                print();
            }
            CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse end");
        }
    }

    public void checkIdlePoolLongTimeNoUse() {
        synchronized (sPoolSync) {
            if (this.mIdlePool.size() <= 0) {
                return;
            }
            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse called size:" + this.mIdlePool.size());
            Iterator<DuplayerHandlerThread> it = this.mIdlePool.iterator();
            while (it.hasNext()) {
                DuplayerHandlerThread next = it.next();
                if (next != null) {
                    long idleBeginTime = next.getIdleBeginTime();
                    CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - idleBeginTime));
                    if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= a.h) {
                        CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use");
                        it.remove();
                        quitHandlerThread(next);
                    }
                }
            }
            print();
            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse  called end");
        }
    }

    public DuplayerHandlerThread obtain() {
        DuplayerHandlerThread duplayerHandlerThread;
        synchronized (sPoolSync) {
            if (this.mIdlePool.size() == 0) {
                duplayerHandlerThread = newHandlerThread();
            } else {
                int size = this.mIdlePool.size() - 1;
                DuplayerHandlerThread duplayerHandlerThread2 = this.mIdlePool.get(size);
                this.mIdlePool.remove(size);
                if (duplayerHandlerThread2 == null) {
                    duplayerHandlerThread = newHandlerThread();
                } else {
                    duplayerHandlerThread = duplayerHandlerThread2;
                }
            }
            duplayerHandlerThread.setRunState(1);
            duplayerHandlerThread.setIdleBeginTime(-1L);
            this.mBusyPool.add(duplayerHandlerThread);
            if (this.mIdlePool.size() <= 0) {
                this.mHandler.removeMessages(100);
            }
            if (this.mIdlePool.size() <= 3) {
                this.mHandler.removeMessages(101);
            }
            CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
            print();
        }
        return duplayerHandlerThread;
    }

    private void quitHandlerThread(DuplayerHandlerThread duplayerHandlerThread) {
        CyberLog.d(TAG, " quitHandlerThread handlerThread:" + duplayerHandlerThread);
        if (duplayerHandlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                if (duplayerHandlerThread != null) {
                    try {
                        duplayerHandlerThread.getLooper().quitSafely();
                        return;
                    } catch (NoSuchMethodError unused) {
                        duplayerHandlerThread.getLooper().quit();
                        return;
                    }
                }
                return;
            }
            duplayerHandlerThread.getLooper().quit();
        }
    }

    public void print() {
        synchronized (sPoolSync) {
            int size = this.mIdlePool.size();
            CyberLog.d(TAG, "-- mIdlePool size:" + size + "--");
            for (int i = 0; i < size; i++) {
                CyberLog.d(TAG, "-- mIdlePool i:" + i + " " + this.mIdlePool.get(i) + " --");
            }
            int size2 = this.mBusyPool.size();
            CyberLog.d(TAG, "-- mBusyPool size:" + size2 + " --");
            for (int i2 = 0; i2 < size2; i2++) {
                CyberLog.d(TAG, "-- mBusyPool i:" + i2 + " " + this.mBusyPool.get(i2) + " --");
            }
        }
    }

    public void recycle(DuplayerHandlerThread duplayerHandlerThread) {
        if (duplayerHandlerThread == null) {
            return;
        }
        CyberLog.d(TAG, " recycle handlerThread:" + duplayerHandlerThread);
        synchronized (sPoolSync) {
            duplayerHandlerThread.setIdleBeginTime(SystemClock.uptimeMillis());
            duplayerHandlerThread.setRunState(0);
            this.mBusyPool.remove(duplayerHandlerThread);
            this.mIdlePool.add(duplayerHandlerThread);
            if (this.mIdlePool.size() > 0) {
                this.mHandler.sendEmptyMessageDelayed(100, a.h);
            }
            if (this.mIdlePool.size() > 3) {
                this.mHandler.sendEmptyMessageDelayed(101, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
            print();
        }
        CyberLog.d(TAG, " recycle  end ");
    }
}
