package com.baidu.ar.recorder;

import android.content.Context;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.recorder.d.c;
import com.baidu.ar.recorder.d.d;
import com.baidu.ar.recorder.d.e;
import com.baidu.ar.recorder.d.f;
import com.baidu.ar.recorder.filter.FilterManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private static volatile int b = 0;
    private static volatile boolean k = false;
    private static volatile a t;
    private d e;
    private MovieRecorderCallback f;
    private HandlerC0039a g;
    private b h;
    private e i;
    private f j;
    private com.baidu.ar.recorder.f.a l;
    private c m;
    private com.baidu.ar.recorder.f.b o;
    private c p;
    private ArrayList<com.baidu.ar.recorder.b.a> r;
    private int s;
    private int c = 0;
    private volatile boolean d = false;
    private volatile boolean n = false;
    private volatile boolean q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.recorder.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0039a extends Handler {
        public HandlerC0039a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6901:
                    a.this.d = false;
                    a.this.b();
                    break;
                case 7001:
                    if (a.this.f != null) {
                        a.this.f.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    a.this.d = false;
                    break;
                case 7002:
                    if (a.this.f != null) {
                        a.this.f.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (a.this.f != null) {
                        a.this.f.onRecorderComplete(((Boolean) message.obj).booleanValue(), a.this.e != null ? a.this.e.a() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (a.this.f != null) {
                        a.this.f.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    private a() {
    }

    public static a a() {
        if (t == null) {
            synchronized (a.class) {
                if (t == null) {
                    t = new a();
                }
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, boolean z) {
        Log.d(a, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        b(i, z);
        Log.d(a, "checkMovieRecordStartState sMovieRecordState = " + b);
        if (k() && this.g != null) {
            this.g.sendMessage(this.g.obtainMessage(7001, Boolean.valueOf(l())));
        }
    }

    private void a(long j) {
        if (!this.h.a()) {
            this.h.a(j);
            return;
        }
        int b2 = this.h.b(j);
        if (b2 <= 0 || this.g == null) {
            return;
        }
        this.g.sendMessage(this.g.obtainMessage(7002, Integer.valueOf(b2)));
    }

    private void a(Context context) {
        i();
        this.o.a(context, this.r, this.e, this.i, this.p);
    }

    private static void b(int i) {
        b = i;
    }

    private void b(int i, boolean z) {
        if (z) {
            b |= i;
        }
        this.c++;
    }

    private void b(Context context, d dVar, MovieRecorderCallback movieRecorderCallback) {
        this.e = dVar;
        this.f = movieRecorderCallback;
        if (Build.VERSION.SDK_INT >= 18) {
            this.i = e.a();
        }
        if (dVar.k()) {
            this.l = com.baidu.ar.recorder.f.a.a();
        } else {
            k = true;
        }
        this.o = com.baidu.ar.recorder.f.b.a();
        this.c = 0;
        this.g = new HandlerC0039a(context.getMainLooper());
        this.h = new b(dVar.c());
    }

    private static void b(boolean z) {
        k = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, boolean z) {
        Log.d(a, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        d(i, z);
        Log.d(a, "checkMovieRecordStopState sMovieRecordState = " + b);
        if (m() && this.g != null) {
            this.g.sendMessage(this.g.obtainMessage(7003, Boolean.valueOf(n())));
        }
    }

    private static void d() {
        t = null;
    }

    private void d(int i, boolean z) {
        if (z) {
            b ^= i;
        }
        this.c--;
    }

    private void e() {
        if (this.g != null) {
            this.g.sendMessageDelayed(this.g.obtainMessage(7001, false), 1000L);
        }
    }

    private void f() {
        this.p = new c() { // from class: com.baidu.ar.recorder.a.1
            @Override // com.baidu.ar.recorder.d.c
            public void a(boolean z) {
                if (z) {
                    a.this.o.c();
                }
            }

            @Override // com.baidu.ar.recorder.d.c
            public void b(boolean z) {
                a.this.q = z;
                a.this.a(2, z);
            }

            @Override // com.baidu.ar.recorder.d.c
            public void c(boolean z) {
            }

            @Override // com.baidu.ar.recorder.d.c
            public void d(boolean z) {
                a.this.o.e();
                a.this.o = null;
                a.this.p = null;
                a.this.c(2, z);
            }
        };
        this.m = new c() { // from class: com.baidu.ar.recorder.a.2
            @Override // com.baidu.ar.recorder.d.c
            public void a(boolean z) {
                if (z) {
                    a.this.l.c();
                }
            }

            @Override // com.baidu.ar.recorder.d.c
            public void b(boolean z) {
                a.this.n = z;
                a.this.a(4, z);
            }

            @Override // com.baidu.ar.recorder.d.c
            public void c(boolean z) {
                boolean unused = a.k = z;
            }

            @Override // com.baidu.ar.recorder.d.c
            public void d(boolean z) {
                a.this.l.e();
                a.this.l = null;
                a.this.m = null;
                a.this.c(4, z);
            }
        };
        this.j = new f() { // from class: com.baidu.ar.recorder.a.3
            @Override // com.baidu.ar.recorder.d.f
            public void a(boolean z) {
                a.this.a(1, z);
            }

            @Override // com.baidu.ar.recorder.d.f
            public void b(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    a.this.i.e();
                    a.this.i = null;
                }
                a.this.j = null;
                a.this.c(1, z);
            }
        };
    }

    private boolean g() {
        if (this.l != null && this.l.b()) {
            Log.e(a, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            return false;
        } else if (this.o.b()) {
            Log.e(a, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            return false;
        } else if (this.e == null || this.i.a(this.e.a(), this.e.b(), this.j)) {
            return true;
        } else {
            Log.e(a, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
    }

    private void h() {
        if (this.l != null) {
            this.l.a(this.e, this.i, this.m);
        }
    }

    private void i() {
        j();
    }

    private void j() {
        if (this.r == null) {
            return;
        }
        Iterator<com.baidu.ar.recorder.b.a> it = this.r.iterator();
        while (it.hasNext()) {
            com.baidu.ar.recorder.b.a next = it.next();
            next.b(this.s);
            if (next.g().f() == 0) {
                next.g().c(next.i() - next.j());
            } else {
                next.g().c(next.j() + next.i());
            }
        }
    }

    private boolean k() {
        if (this.e == null) {
            return false;
        }
        return this.e.k() ? this.c == 3 : this.c == 2;
    }

    private synchronized boolean l() {
        int i;
        Log.d(a, "isMovieRecordStarted sMovieRecordState = " + b);
        i = (b ^ 1) ^ 2;
        if (this.e != null) {
            if (this.e.k()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    private boolean m() {
        return this.c == 0;
    }

    private synchronized boolean n() {
        return b == 0;
    }

    public void a(int i) {
        this.s = i;
    }

    public void a(Context context, d dVar, MovieRecorderCallback movieRecorderCallback) {
        if (this.d) {
            e();
            return;
        }
        this.d = true;
        b(context, dVar, movieRecorderCallback);
        f();
        if (!g()) {
            e();
            return;
        }
        h();
        a(context);
    }

    public void a(EGLContext eGLContext, int i) {
        if (eGLContext == null || this.r == null) {
            return;
        }
        com.baidu.ar.recorder.b.a aVar = null;
        Iterator<com.baidu.ar.recorder.b.a> it = this.r.iterator();
        while (it.hasNext()) {
            com.baidu.ar.recorder.b.a next = it.next();
            if (!eGLContext.equals(next.a())) {
                next = aVar;
            }
            aVar = next;
        }
        if (aVar == null || !aVar.k()) {
            return;
        }
        aVar.a(i);
    }

    public void a(com.baidu.ar.recorder.b.a aVar) {
        a(aVar, true);
    }

    public void a(com.baidu.ar.recorder.b.a aVar, boolean z) {
        if (aVar == null || aVar.a() == null) {
            return;
        }
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 >= this.r.size()) {
                break;
            }
            if (this.r.get(i3).d() == aVar.d()) {
                i2 = i3;
            }
            i = i3 + 1;
        }
        if (i2 >= 0 && i2 < this.r.size()) {
            if (this.r.get(i2).a() == aVar.a()) {
                return;
            }
            this.r.remove(i2);
        }
        if (z) {
            this.r.add((com.baidu.ar.recorder.b.a) aVar.clone());
        } else {
            this.r.add(aVar);
        }
        Collections.sort(this.r);
    }

    public void a(FilterManager.FilterType filterType) {
        if (this.o == null || !this.o.b() || filterType == null) {
            return;
        }
        this.o.a(filterType);
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (this.n && this.l != null && this.l.b()) {
            this.l.a(byteBuffer, i, j);
        }
    }

    public void a(float[] fArr, long j) {
        if (this.o != null && this.o.b() && this.q && k) {
            this.o.a(fArr, j);
            a(j / 1000000);
        }
    }

    public void b() {
        if (this.d) {
            Log.d(a, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.g != null) {
                this.g.sendMessageDelayed(this.g.obtainMessage(6901), 500L);
                return;
            }
            return;
        }
        this.n = false;
        this.q = false;
        if (this.l != null && this.l.b()) {
            this.l.d();
        }
        if (this.o != null && this.o.b()) {
            this.o.d();
        }
        b(false);
    }

    public void b(com.baidu.ar.recorder.b.a aVar) {
        b(aVar, true);
    }

    public void b(com.baidu.ar.recorder.b.a aVar, boolean z) {
        if (this.o != null) {
            a(aVar, z);
            this.o.a(this.r);
        }
    }

    public void c() {
        if (this.r != null) {
            this.r.clear();
            this.r = null;
        }
        this.h = null;
        this.e = null;
        this.f = null;
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
            this.g = null;
        }
        b(0);
        d();
    }
}
