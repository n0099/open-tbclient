package com.baidu.media.duplayer.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b {
    private static final Object b = new Object();
    a aLO;
    private c aLP;
    private ArrayList<com.baidu.media.duplayer.a.a> c;
    private ArrayList<com.baidu.media.duplayer.a.a> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final AtomicInteger a = new AtomicInteger(1);
        private final String b;
        private int c;

        a(String str) {
            this.c = 5;
            this.b = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            this.c = 5;
        }

        public com.baidu.media.duplayer.a.a DK() {
            com.baidu.media.duplayer.a.a aVar = new com.baidu.media.duplayer.a.a(this.b + this.a.getAndIncrement());
            aVar.setPriority(this.c);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.media.duplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0125b {
        private static b aLQ = new b();
    }

    /* loaded from: classes.dex */
    private static class c extends Handler {
        private c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    b.DH().c();
                    return;
                case 101:
                    b.DH().f();
                    return;
                default:
                    return;
            }
        }
    }

    private b() {
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.aLO = new a("duplayer-t");
        this.aLP = new c(Looper.getMainLooper());
    }

    public static b DH() {
        return C0125b.aLQ;
    }

    private com.baidu.media.duplayer.a.a DI() {
        com.baidu.media.duplayer.a.a DK = this.aLO.DK();
        DK.start();
        return DK;
    }

    private void b(com.baidu.media.duplayer.a.a aVar) {
        CyberLog.d("DuplayerHandlerThreadPool", " quitHandlerThread handlerThread:" + aVar);
        if (aVar != null) {
            if (Build.VERSION.SDK_INT < 18) {
                aVar.getLooper().quit();
            } else if (aVar != null) {
                try {
                    aVar.getLooper().quitSafely();
                } catch (NoSuchMethodError e) {
                    aVar.getLooper().quit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i;
        synchronized (b) {
            int size = this.c.size();
            CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolShortTimeNoUse size:" + size);
            if (size > 3) {
                int i2 = size - 3;
                Iterator<com.baidu.media.duplayer.a.a> it = this.c.iterator();
                while (it.hasNext() && i2 > 0) {
                    com.baidu.media.duplayer.a.a next = it.next();
                    if (next != null) {
                        long a2 = next.a();
                        if (a2 > 0 && SystemClock.uptimeMillis() - a2 >= 120000) {
                            CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                            it.remove();
                            b(next);
                            i = i2 - 1;
                            i2 = i;
                        }
                    }
                    i = i2;
                    i2 = i;
                }
                d();
            }
            CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolShortTimeNoUse end");
        }
    }

    public com.baidu.media.duplayer.a.a DJ() {
        com.baidu.media.duplayer.a.a aVar;
        synchronized (b) {
            if (this.c.size() == 0) {
                aVar = DI();
            } else {
                int size = this.c.size() - 1;
                aVar = this.c.get(size);
                this.c.remove(size);
                if (aVar == null) {
                    aVar = DI();
                }
            }
            aVar.a(1);
            aVar.a(-1L);
            this.d.add(aVar);
            if (this.c.size() <= 0) {
                this.aLP.removeMessages(100);
            }
            if (this.c.size() <= 3) {
                this.aLP.removeMessages(101);
            }
            CyberLog.d("DuplayerHandlerThreadPool", " obtain handlerThread:" + aVar);
            d();
        }
        return aVar;
    }

    public void a(com.baidu.media.duplayer.a.a aVar) {
        if (aVar == null) {
            return;
        }
        CyberLog.d("DuplayerHandlerThreadPool", " recycle handlerThread:" + aVar);
        synchronized (b) {
            aVar.a(SystemClock.uptimeMillis());
            aVar.a(0);
            this.d.remove(aVar);
            this.c.add(aVar);
            if (this.c.size() > 0) {
                this.aLP.sendEmptyMessageDelayed(100, 900000L);
            }
            if (this.c.size() > 3) {
                this.aLP.sendEmptyMessageDelayed(101, 120000L);
            }
            d();
        }
        CyberLog.d("DuplayerHandlerThreadPool", " recycle  end ");
    }

    public void c() {
        synchronized (b) {
            if (this.c.size() <= 0) {
                return;
            }
            CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolLongTimeNoUse called size:" + this.c.size());
            Iterator<com.baidu.media.duplayer.a.a> it = this.c.iterator();
            while (it.hasNext()) {
                com.baidu.media.duplayer.a.a next = it.next();
                if (next != null) {
                    long a2 = next.a();
                    CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - a2));
                    if (a2 > 0 && SystemClock.uptimeMillis() - a2 >= 900000) {
                        CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolLongTimeNoUse long time no use");
                        it.remove();
                        b(next);
                    }
                }
            }
            d();
            CyberLog.d("DuplayerHandlerThreadPool", "checkIdlePoolLongTimeNoUse  called end");
        }
    }

    public void d() {
        synchronized (b) {
            int size = this.c.size();
            CyberLog.d("DuplayerHandlerThreadPool", "-- mIdlePool size:" + size + "--");
            for (int i = 0; i < size; i++) {
                CyberLog.d("DuplayerHandlerThreadPool", "-- mIdlePool i:" + i + HanziToPinyin.Token.SEPARATOR + this.c.get(i) + " --");
            }
            int size2 = this.d.size();
            CyberLog.d("DuplayerHandlerThreadPool", "-- mBusyPool size:" + size2 + " --");
            for (int i2 = 0; i2 < size2; i2++) {
                CyberLog.d("DuplayerHandlerThreadPool", "-- mBusyPool i:" + i2 + HanziToPinyin.Token.SEPARATOR + this.d.get(i2) + " --");
            }
        }
    }
}
