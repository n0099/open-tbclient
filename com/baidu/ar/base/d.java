package com.baidu.ar.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.DuMixCallback;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d implements c {
    private static final String a = d.class.getSimpleName();
    private static volatile d e;
    private HandlerThread b = new HandlerThread("MsgLoopHandler");
    private Handler c;
    private DuMixCallback d;

    /* loaded from: classes3.dex */
    private static class a extends Handler {
        private c a;

        public a(Looper looper, c cVar) {
            super(looper);
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    private d(DuMixCallback duMixCallback) {
        this.d = duMixCallback;
        this.b.start();
        this.c = new a(this.b.getLooper(), this);
    }

    public static void a() {
        if (e != null) {
            e.c();
        }
        e = null;
    }

    public static void a(int i) {
        a(i, "");
    }

    public static void a(int i, Object obj) {
        Log.d(a, "send id = " + i);
        if (e == null || !e.b()) {
            return;
        }
        e.c.sendMessage(e.c.obtainMessage(i, obj));
    }

    public static void a(int i, String str) {
        Log.d(a, "send id = " + i + " && msg = " + str);
        if (e == null || !e.b()) {
            return;
        }
        e.c.sendMessage(e.c.obtainMessage(i, str));
    }

    public static void a(DuMixCallback duMixCallback) {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d(duMixCallback);
                }
            }
        }
    }

    public static void a(HashMap<String, Object> hashMap) {
        Log.d(a, "send luaMsg = " + hashMap.toString());
        if (e == null || !e.b()) {
            return;
        }
        e.c.sendMessage(e.c.obtainMessage(1001, hashMap));
    }

    private boolean b() {
        return this.b.isAlive();
    }

    private void c() {
        if (b()) {
            this.b.quitSafely();
        }
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // com.baidu.ar.base.c
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                if (this.d != null) {
                    this.d.onLuaMessage((HashMap) message.obj);
                    return;
                }
                return;
            default:
                Log.d(a, "onStateChange state = " + message.what);
                if (this.d != null) {
                    this.d.onStateChange(message.what, message.obj);
                    return;
                }
                return;
        }
    }
}
