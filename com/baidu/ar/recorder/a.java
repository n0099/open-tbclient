package com.baidu.ar.recorder;

import android.content.Context;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.recorder.encoder.EncoderParams;
import com.baidu.ar.recorder.encoder.d;
import com.baidu.ar.recorder.encoder.e;
import com.baidu.ar.recorder.filter.FilterManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements com.baidu.ar.audio.a {
    private static final String a = a.class.getSimpleName();
    private static volatile int b = 0;
    private static volatile boolean m = false;
    private static volatile a v;
    private com.baidu.ar.audio.b e;
    private AudioParams f;
    private EncoderParams g;
    private b h;
    private HandlerC0042a i;
    private c j;
    private d k;
    private e l;
    private com.baidu.ar.recorder.d.a n;
    private com.baidu.ar.recorder.encoder.c o;
    private com.baidu.ar.recorder.d.b q;
    private com.baidu.ar.recorder.encoder.c r;
    private ArrayList<com.baidu.ar.recorder.drawer.b> t;
    private int u;
    private int c = 0;
    private volatile boolean d = false;
    private volatile boolean p = false;
    private volatile boolean s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.recorder.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0042a extends Handler {
        public HandlerC0042a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7001:
                    if (a.this.h != null) {
                        a.this.h.f(((Boolean) message.obj).booleanValue());
                    }
                    a.this.d = false;
                    break;
                case 7002:
                    if (a.this.h != null) {
                        a.this.h.e(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (a.this.h != null) {
                        a.this.h.g(((Boolean) message.obj).booleanValue());
                        break;
                    }
                    break;
                case 7004:
                    if (a.this.h != null) {
                        a.this.h.f(((Integer) message.obj).intValue());
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
        if (v == null) {
            synchronized (a.class) {
                if (v == null) {
                    v = new a();
                }
            }
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, boolean z) {
        b(i, z);
        if (i()) {
            this.i.sendMessage(this.i.obtainMessage(7001, Boolean.valueOf(j())));
        }
    }

    private void a(long j) {
        if (!this.j.a()) {
            this.j.a(j);
            return;
        }
        int b2 = this.j.b(j);
        if (b2 > 0) {
            this.i.sendMessage(this.i.obtainMessage(7002, Integer.valueOf(b2)));
        }
    }

    private void a(Context context) {
        if (!this.e.a(context)) {
            this.g.a(false);
            m = true;
            this.i.sendMessage(this.i.obtainMessage(7004, 9001));
            return;
        }
        this.f = new AudioParams();
        this.e.a(this.f, this);
        this.e.c();
        com.baidu.ar.recorder.e.b.a(this.g, this.f);
        this.g.a(true);
        m = false;
    }

    private void b(int i, boolean z) {
        if (z) {
            b |= i;
        }
        this.c++;
    }

    private void b(Context context) {
        g();
        this.q.a(context, this.t, this.g, this.k, this.r);
    }

    private void b(Context context, EncoderParams encoderParams, b bVar) {
        this.g = encoderParams;
        this.h = bVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.k = d.a();
        }
        this.e = com.baidu.ar.audio.b.a();
        this.n = com.baidu.ar.recorder.d.a.a();
        this.q = com.baidu.ar.recorder.d.b.a();
        this.c = 0;
        this.i = new HandlerC0042a(context.getMainLooper());
        this.j = new c(encoderParams.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, boolean z) {
        d(i, z);
        if (k() && this.i != null) {
            this.i.sendMessage(this.i.obtainMessage(7003, Boolean.valueOf(l())));
        }
    }

    private void d() {
        if (this.i != null) {
            this.i.sendMessageDelayed(this.i.obtainMessage(7001, false), 1000L);
        }
    }

    private void d(int i, boolean z) {
        if (z) {
            b ^= i;
        }
        this.c--;
    }

    private void e() {
        this.r = new com.baidu.ar.recorder.encoder.c() { // from class: com.baidu.ar.recorder.a.1
            @Override // com.baidu.ar.recorder.encoder.c
            public void a(boolean z) {
                if (z) {
                    a.this.q.c();
                }
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void b(boolean z) {
                a.this.s = z;
                a.this.a(2, z);
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void c(boolean z) {
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void d(boolean z) {
                a.this.q.e();
                a.this.q = null;
                a.this.r = null;
                a.this.c(2, z);
            }
        };
        this.o = new com.baidu.ar.recorder.encoder.c() { // from class: com.baidu.ar.recorder.a.2
            @Override // com.baidu.ar.recorder.encoder.c
            public void a(boolean z) {
                if (z) {
                    a.this.n.c();
                }
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void b(boolean z) {
                a.this.p = z;
                a.this.a(8, z);
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void c(boolean z) {
                boolean unused = a.m = z;
            }

            @Override // com.baidu.ar.recorder.encoder.c
            public void d(boolean z) {
                a.this.n.e();
                a.this.n = null;
                a.this.o = null;
                a.this.c(8, z);
            }
        };
        this.l = new e() { // from class: com.baidu.ar.recorder.a.3
            @Override // com.baidu.ar.recorder.encoder.e
            public void a(boolean z) {
                a.this.a(1, z);
            }

            @Override // com.baidu.ar.recorder.encoder.e
            public void b(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    a.this.k.e();
                    a.this.k = null;
                }
                a.this.l = null;
                a.this.c(1, z);
            }
        };
    }

    private boolean f() {
        if (this.e.b()) {
            Log.e(a, "prepareMovieRecorder mAudioController.isRunning !!!");
            return false;
        } else if (this.n.b()) {
            Log.e(a, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            return false;
        } else if (this.q.b()) {
            Log.e(a, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            return false;
        } else if (Build.VERSION.SDK_INT < 18 || this.k.a(this.g.a(), this.g.b(), this.l)) {
            return true;
        } else {
            Log.e(a, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
    }

    private void g() {
        h();
    }

    private void h() {
        Iterator<com.baidu.ar.recorder.drawer.b> it = this.t.iterator();
        while (it.hasNext()) {
            com.baidu.ar.recorder.drawer.b next = it.next();
            next.b(this.u);
            if (next.g().i() == 0) {
                next.g().e(next.i() - next.j());
            } else {
                next.g().e(next.j() + next.i());
            }
        }
    }

    private boolean i() {
        if (this.g == null) {
            return false;
        }
        return this.g.k() ? this.c == 4 : this.c == 2;
    }

    private synchronized boolean j() {
        int i;
        i = (b ^ 1) ^ 2;
        if (this.g.k()) {
            i = (i ^ 4) ^ 8;
        }
        return i == 0;
    }

    private boolean k() {
        return this.c == 0;
    }

    private synchronized boolean l() {
        return b == 0;
    }

    public void a(int i) {
        this.u = i;
    }

    public void a(Context context, EncoderParams encoderParams, b bVar) {
        if (this.d) {
            d();
            return;
        }
        this.d = true;
        b(context, encoderParams, bVar);
        e();
        if (!f()) {
            d();
            return;
        }
        a(context);
        b(context);
    }

    public void a(EGLContext eGLContext, int i) {
        if (eGLContext == null || this.t == null) {
            return;
        }
        com.baidu.ar.recorder.drawer.b bVar = null;
        Iterator<com.baidu.ar.recorder.drawer.b> it = this.t.iterator();
        while (it.hasNext()) {
            com.baidu.ar.recorder.drawer.b next = it.next();
            if (!eGLContext.equals(next.a())) {
                next = bVar;
            }
            bVar = next;
        }
        if (bVar == null || !bVar.k()) {
            return;
        }
        bVar.a(i);
    }

    public void a(com.baidu.ar.recorder.drawer.b bVar) {
        a(bVar, true);
    }

    public void a(com.baidu.ar.recorder.drawer.b bVar, boolean z) {
        if (bVar == null || bVar.a() == null) {
            return;
        }
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 >= this.t.size()) {
                break;
            }
            if (this.t.get(i3).d() == bVar.d()) {
                i2 = i3;
            }
            i = i3 + 1;
        }
        if (i2 >= 0 && i2 < this.t.size()) {
            if (this.t.get(i2).a() == bVar.a()) {
                return;
            }
            this.t.remove(i2);
        }
        if (z) {
            this.t.add((com.baidu.ar.recorder.drawer.b) bVar.clone());
        } else {
            this.t.add(bVar);
        }
        Collections.sort(this.t);
    }

    public void a(FilterManager.FilterType filterType) {
        if (this.q == null || !this.q.b() || filterType == null) {
            return;
        }
        this.q.a(filterType);
    }

    @Override // com.baidu.ar.audio.a
    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (this.p && this.n != null && this.n.b()) {
            this.n.a(byteBuffer, i, j);
        }
    }

    @Override // com.baidu.ar.audio.a
    public void a(boolean z) {
        Log.d(a, "onAudioEngineStart !!! result = " + z);
        if (!z || this.n == null) {
            this.e.d();
            this.g.a(false);
            m = true;
            this.i.sendMessage(this.i.obtainMessage(7004, 9002));
        } else {
            this.n.a(this.g, this.k, this.o);
        }
        a(4, z);
    }

    public void a(float[] fArr, long j) {
        if (this.q != null && this.q.b() && this.s && m) {
            this.q.a(fArr, j);
            a(j / 1000000);
        }
    }

    public void b(com.baidu.ar.recorder.drawer.b bVar) {
        b(bVar, true);
    }

    public void b(com.baidu.ar.recorder.drawer.b bVar, boolean z) {
        if (this.q != null) {
            a(bVar, z);
            this.q.a(this.t);
        }
    }

    @Override // com.baidu.ar.audio.a
    public void b(boolean z) {
        Log.d(a, "onAudioEngineStop !!! result = " + z);
        if (z) {
            this.e.e();
            this.e = null;
        }
        c(4, z);
    }

    public boolean b() {
        return this.q != null && this.q.b();
    }

    public void c() {
        if (!j()) {
            Log.e(a, "stopRecorder error!!! movie record not started.");
            this.i.sendMessage(this.i.obtainMessage(7003, false));
            return;
        }
        this.p = false;
        this.s = false;
        if (this.n.b()) {
            this.n.d();
        }
        if (this.q.b()) {
            this.q.d();
        }
        if (this.e.b()) {
            this.e.d();
        }
        m = false;
        this.j = null;
        this.f = null;
        this.g = null;
    }
}
