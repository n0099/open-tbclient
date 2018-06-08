package com.baidu.ar.recorder.f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.recorder.b.e;
import com.baidu.ar.recorder.d.c;
import com.baidu.ar.recorder.d.d;
import com.baidu.ar.recorder.d.g;
import com.baidu.ar.recorder.filter.FilterManager;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements com.baidu.ar.recorder.a.a {
    private static final String a = b.class.getSimpleName();
    private static volatile b i;
    private Context b;
    private HandlerThread c;
    private Handler d;
    private e e;
    private g f;
    private com.baidu.ar.recorder.d.e g;
    private volatile boolean h = false;

    /* loaded from: classes3.dex */
    private class a {
        ArrayList<com.baidu.ar.recorder.b.a> a;
        d b;

        public a(ArrayList<com.baidu.ar.recorder.b.a> arrayList, d dVar) {
            this.a = arrayList;
            this.b = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.recorder.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0041b extends Handler {
        private com.baidu.ar.recorder.a.a a;

        public HandlerC0041b(Looper looper, com.baidu.ar.recorder.a.a aVar) {
            super(looper);
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    private b() {
    }

    public static b a() {
        if (i == null) {
            synchronized (b.class) {
                if (i == null) {
                    i = new b();
                }
            }
        }
        return i;
    }

    private void a(com.baidu.ar.recorder.d.e eVar, c cVar) {
        this.c = new HandlerThread("VideoRecorderThread");
        this.c.start();
        this.d = new HandlerC0041b(this.c.getLooper(), this);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f = new g();
            this.f.a(cVar);
            this.g = eVar;
        }
    }

    private void a(ArrayList<com.baidu.ar.recorder.b.a> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f.a(dVar, this.g);
            if (this.e == null) {
                this.e = new e(this.b, this.f.e(), arrayList);
            }
        }
    }

    private void b(FilterManager.FilterType filterType) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.e.a(this.b, filterType);
        }
    }

    private void b(ArrayList<com.baidu.ar.recorder.b.a> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.e.a(this.b, arrayList);
        }
    }

    private void b(float[] fArr, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f.a(false);
            this.e.a(fArr, j);
        }
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f.d();
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f.a(true);
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f.c();
            this.f.b();
            this.f = null;
            this.g = null;
            this.e.a();
            this.e = null;
            this.b = null;
        }
    }

    private void i() {
        this.c.getLooper().quit();
        this.c = null;
        this.d = null;
        i = null;
    }

    @Override // com.baidu.ar.recorder.a.a
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                a aVar = (a) message.obj;
                a(aVar.a, aVar.b);
                return;
            case 1002:
                f();
                return;
            case 1003:
                b((ArrayList) message.obj);
                return;
            case 1004:
                b((FilterManager.FilterType) message.obj);
                return;
            case 1005:
                b((float[]) message.obj, (message.arg2 & 4294967295L) | (message.arg1 << 32));
                return;
            case 1006:
                g();
                return;
            case 1007:
                h();
                return;
            case 1008:
                i();
                return;
            default:
                return;
        }
    }

    public void a(FilterManager.FilterType filterType) {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1004, filterType));
        }
    }

    public void a(ArrayList<com.baidu.ar.recorder.b.a> arrayList) {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1003, arrayList));
        }
    }

    public void a(float[] fArr, long j) {
        int i2 = (int) (j >> 32);
        int i3 = (int) j;
        if (this.d == null || !this.h) {
            return;
        }
        this.d.sendMessage(this.d.obtainMessage(1005, i2, i3, fArr));
    }

    public boolean a(Context context, ArrayList<com.baidu.ar.recorder.b.a> arrayList, d dVar, com.baidu.ar.recorder.d.e eVar, c cVar) {
        if (b()) {
            Log.e(a, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        this.b = context;
        a(eVar, cVar);
        this.d.sendMessage(this.d.obtainMessage(1001, new a(arrayList, dVar)));
        this.h = true;
        return true;
    }

    public boolean b() {
        return this.c != null && this.c.isAlive();
    }

    public void c() {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1002));
        }
    }

    public void d() {
        if (this.d == null || !this.h) {
            return;
        }
        this.h = false;
        this.d.removeCallbacksAndMessages(null);
        this.d.sendMessage(this.d.obtainMessage(1006));
    }

    public void e() {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1007));
            this.d.sendMessage(this.d.obtainMessage(1008));
        }
    }
}
