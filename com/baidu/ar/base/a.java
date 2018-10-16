package com.baidu.ar.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.baidu.ar.ProjectParams;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.easy.EasyAudio;
import com.baidu.ar.audio.easy.EasyAudioCallback;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.ar.recorder.filter.FilterManager;
import com.baidu.ar.util.ARLog;
import com.baidu.baiduarsdk.blend.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;
/* loaded from: classes3.dex */
public class a implements b.c {
    private static final String b = a.class.getSimpleName();
    private com.baidu.ar.recorder.b.a c;
    private final Context e;
    private FilterManager.FilterType f;
    private com.baidu.ar.recorder.d.d i;
    private MovieRecorderCallback j;
    private boolean k;
    private int l;
    private EasyAudio m;
    private AudioParams n;
    private EasyAudioCallback o;
    private int d = -1;
    private boolean g = false;
    float[] a = new float[16];
    private com.baidu.ar.recorder.a h = com.baidu.ar.recorder.a.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0037a implements EasyAudioCallback {
        private WeakReference<a> a;

        public C0037a(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // com.baidu.ar.audio.easy.EasyAudioCallback
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.a.get() != null) {
                this.a.get().a(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.ar.audio.easy.EasyAudioCallback
        public void onAudioStart(boolean z, AudioParams audioParams) {
            if (this.a.get() != null) {
                this.a.get().a(z);
            }
        }

        @Override // com.baidu.ar.audio.easy.EasyAudioCallback
        public void onAudioStop(boolean z) {
        }
    }

    public a(Context context) {
        this.e = context;
        Matrix.setIdentityM(this.a, 0);
    }

    private void a(int i, float[] fArr, long j) {
        if (this.k && this.i != null) {
            switch (this.l) {
                case 0:
                    d();
                    this.h.a(this.e, this.i, this.j);
                    this.l = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.c.a(i);
                    this.c.a(this.f);
                    this.h.b(this.c);
                    this.l = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.l);
            }
        }
        if (this.h != null) {
            this.h.a(fArr, j);
        }
    }

    private void a(AudioParams audioParams) {
        if (this.o == null) {
            f();
        }
        if (audioParams == null) {
            this.n = new AudioParams();
            if (ProjectParams.isHuaweiProject()) {
                this.n.setSampleRate(32000);
                this.n.setFrameSize(1280);
            }
        } else {
            this.n = audioParams;
        }
        this.m = EasyAudio.getInstance();
        this.m.startAudio(this.n, this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (this.h == null || !this.k || byteBuffer == null || i <= 0) {
            return;
        }
        this.h.a(byteBuffer, i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.baidu.ar.util.a.a(this.i, this.n);
        this.i.a(z);
        this.k = true;
    }

    private void d() {
        if (this.i == null || this.c == null) {
            return;
        }
        int f = this.i.f();
        int e = this.i.e();
        if (f > e) {
            f = (this.i.e() * this.c.g().b()) / this.c.g().a();
        } else {
            e = (this.i.f() * this.c.g().b()) / this.c.g().a();
        }
        this.i.a(e);
        this.i.b(f);
    }

    private void e() {
        if (this.g) {
            if (this.h != null) {
                this.h.a(this.f);
            }
            this.g = false;
        }
    }

    private void f() {
        if (this.o != null) {
            return;
        }
        this.o = new C0037a(this);
    }

    @Override // com.baidu.baiduarsdk.blend.b.c
    public void a() {
        a((AudioParams) null);
    }

    @Override // com.baidu.baiduarsdk.blend.b.c
    public void a(int i) {
        if (this.c == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.d != i) {
            ARLog.d("bdar: onFrameAvailable textureId = " + i);
            this.c.a(i);
            com.baidu.ar.recorder.a.a().a(this.c.a(), i);
            this.d = i;
        }
        e();
        a(this.d, this.a, System.nanoTime());
        ARLog.d("bdar: onFrameAvailable time is = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(com.baidu.ar.recorder.d.d dVar) {
        this.i = dVar;
    }

    public void a(com.baidu.ar.recorder.d.d dVar, MovieRecorderCallback movieRecorderCallback) {
        a(dVar);
        this.j = movieRecorderCallback;
    }

    @Override // com.baidu.baiduarsdk.blend.b.c
    public void a(EGLContext eGLContext, int i, int i2) {
        ARLog.d("bdar: onContextChanged width*height = " + i + " * " + i2);
        if (eGLContext == null) {
            return;
        }
        if (this.c == null) {
            this.c = new com.baidu.ar.recorder.b.a(EGL14.eglGetCurrentContext(), 0, true, false);
        } else {
            this.c.a(EGL14.eglGetCurrentContext());
        }
        com.baidu.ar.recorder.b.d dVar = new com.baidu.ar.recorder.b.d();
        dVar.a(i);
        dVar.b(i2);
        this.c.a(dVar);
        com.baidu.ar.recorder.a.a().a(this.c);
    }

    @Override // com.baidu.baiduarsdk.blend.b.c
    public void b() {
        this.k = false;
        switch (this.l) {
            case 0:
                return;
            case 1:
            case 2:
                this.l = 0;
                if (this.m != null) {
                    this.m.stopAudio(this.o);
                }
                if (this.h != null) {
                    this.h.b();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.l);
        }
    }

    public void b(int i) {
        this.h.a(i);
    }

    public void c() {
        if (this.h != null) {
            this.h.c();
            this.h = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }
}
