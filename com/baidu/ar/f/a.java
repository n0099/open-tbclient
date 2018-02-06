package com.baidu.ar.f;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.baidu.ar.camera.CameraCallback;
import com.baidu.ar.camera.CameraParams;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.opengl.BaiduArView;
import com.baidu.ar.recorder.encoder.EncoderParams;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.n;
import com.baidu.ar.util.o;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class a {
    public static WeakReference<Camera> e;
    private static final String l = a.class.getSimpleName();
    protected d a;
    protected BaiduArView b;
    protected View c;
    protected c h;
    protected c i;
    private Activity m;
    private e n;
    private Fragment o;
    private CameraParams p;
    private Bitmap q;
    private com.baidu.ar.b r;
    private Timer s;
    private TimerTask t;
    private f u;
    private boolean v;
    protected boolean d = true;
    byte[] f = null;
    protected Handler g = new Handler() { // from class: com.baidu.ar.f.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmap;
            switch (message.what) {
                case 1001:
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    com.baidu.ar.util.b.a("bdar: Camera open Camera callback result = " + booleanValue);
                    if (!booleanValue) {
                        a.this.v = false;
                        if (a.this.n != null) {
                            a.this.n.c();
                            break;
                        }
                    } else {
                        com.baidu.ar.h.a.a().a("open_camera_success");
                        if (a.this.n != null) {
                            a.this.n.b();
                        }
                        a.this.b(a.this.n);
                        break;
                    }
                    break;
                case 1002:
                    if (!((Boolean) message.obj).booleanValue()) {
                        if (a.this.c != null) {
                            Drawable background = a.this.c.getBackground();
                            a.this.c.setBackgroundColor(0);
                            if ((background instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) background).getBitmap()) != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        }
                        if (a.this.n != null) {
                            a.this.n.e();
                        }
                        a.this.v = false;
                        break;
                    } else {
                        if (a.this.n != null) {
                            a.this.n.d();
                        }
                        a.this.v = true;
                        break;
                    }
                    break;
                case 1003:
                    if (a.this.h != null) {
                        a.this.h.a(((Boolean) message.obj).booleanValue());
                        break;
                    }
                    break;
                case 1004:
                    if (a.this.i != null) {
                        a.this.i.a(((Boolean) message.obj).booleanValue());
                        break;
                    }
                    break;
                case 1005:
                    if (a.this.i != null) {
                        a.this.i.a(((Boolean) message.obj).booleanValue());
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    protected CameraCallback j = new CameraCallback() { // from class: com.baidu.ar.f.a.2
        @Override // com.baidu.ar.camera.CameraCallback
        public void onCameraRelease(boolean z) {
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onCameraSetup(boolean z) {
            a.this.g.sendMessage(a.this.g.obtainMessage(1001, Boolean.valueOf(z)));
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onFlashClose(boolean z) {
            a.this.g.sendMessage(a.this.g.obtainMessage(1005, Boolean.valueOf(z)));
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onFlashOpen(boolean z) {
            a.this.g.sendMessage(a.this.g.obtainMessage(1004, Boolean.valueOf(z)));
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onPreviewCallbackSet(boolean z) {
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onPreviewStart(boolean z) {
            a.this.g.sendMessage(a.this.g.obtainMessage(1002, Boolean.valueOf(z)));
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onPreviewStop(boolean z) {
            a.this.g.sendMessage(a.this.g.obtainMessage(1003, Boolean.valueOf(z)));
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onSurfaceHolderSet(boolean z) {
        }

        @Override // com.baidu.ar.camera.CameraCallback
        public void onSurfaceTextureSet(boolean z) {
        }
    };
    protected C0040a k = new C0040a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0040a implements Camera.PreviewCallback {
        a a;

        C0040a(a aVar) {
            this.a = aVar;
        }

        void a() {
            this.a = null;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            com.baidu.ar.util.b.a("bdar: Camera onPreviewFrame in ARCameraController");
            camera.addCallbackBuffer(bArr);
            if (a.e == null) {
                a.e = new WeakReference<>(camera);
            }
            if (this.a != null) {
                this.a.a(bArr, camera);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        Bitmap bitmap;
        try {
            if (e == null || e.get() == null) {
                bitmap = null;
            } else {
                Camera.Size previewSize = e.get().getParameters().getPreviewSize();
                bitmap = o.a(previewSize.width, previewSize.height, bArr);
            }
            return bitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            com.baidu.ar.util.b.d("save preview data OOM error");
            return null;
        }
    }

    private void a(byte[] bArr, f fVar) {
        if (this.b != null) {
            BaiduArView baiduArView = this.b;
            BaiduArView.a(bArr, fVar);
            this.b.requestRender();
        }
        if (this.n != null) {
            this.n.a(bArr, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.a != null) {
            this.k = new C0040a(this);
            this.a.a((Camera.PreviewCallback) this.k, true);
        }
    }

    public View a(ViewGroup viewGroup, ViewGroup viewGroup2, IARCallback iARCallback) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            Context applicationContext = this.m.getApplicationContext();
            if (this.a == null) {
                this.a = new d();
            }
            if (this.b == null) {
                this.b = new BaiduArView(applicationContext);
                this.b.setRenderMode(0);
                this.b.setNeedClearScreenOnPause(false);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.b.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(this.b);
            }
            viewGroup2.addView(this.b, layoutParams);
            com.baidu.ar.h.a.a().a(applicationContext);
            com.baidu.ar.h.a.a().a("start_ar");
            this.c = new View(applicationContext);
            this.c.setBackgroundColor(0);
            viewGroup.addView(this.c, layoutParams);
            Bitmap previewBitmap = iARCallback != null ? iARCallback.getPreviewBitmap() : null;
            if (this.c != null && previewBitmap != null && !previewBitmap.isRecycled()) {
                if (com.baidu.ar.util.a.a()) {
                    this.c.setBackground(new BitmapDrawable(previewBitmap));
                } else {
                    this.c.setBackgroundDrawable(new BitmapDrawable(previewBitmap));
                }
            }
            this.r = new com.baidu.ar.b(applicationContext);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        return this.b;
    }

    public void a() {
        if (this.b != null) {
            this.b.a(this.r);
        }
    }

    public void a(Activity activity) {
        this.m = activity;
        Res.addResource(this.m);
    }

    public void a(Fragment fragment) {
        this.o = fragment;
    }

    public void a(c cVar, String str) {
        this.i = cVar;
        if (this.a != null) {
            if ("torch".equals(str)) {
                this.a.b();
            } else {
                this.a.c();
            }
        }
    }

    public void a(BaiduArView.a aVar) {
        if (this.b != null) {
            this.b.a(aVar);
        }
    }

    public void a(com.baidu.ar.recorder.b bVar, long j) {
        int i;
        int i2 = 720;
        EncoderParams encoderParams = new EncoderParams();
        encoderParams.a(o.e());
        int i3 = 0;
        int a = o.a();
        if (a == 90 || a == -90) {
            i3 = a;
            i = 720;
            i2 = 1280;
        } else {
            i = 1280;
        }
        encoderParams.a(i2);
        encoderParams.b(i);
        encoderParams.a(j);
        if (this.r != null) {
            this.r.b(encoderParams);
            this.r.b(i3);
        }
        if (this.b != null) {
            this.b.a(this.r, bVar);
        }
    }

    protected void a(byte[] bArr, Camera camera) {
        if (this.v) {
            if (this.d) {
                this.d = false;
                n.a(new Runnable() { // from class: com.baidu.ar.f.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.c != null) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a.this.c, "alpha", 1.0f, 0.0f);
                            ofFloat.setDuration(1000L);
                            ofFloat.setInterpolator(new DecelerateInterpolator());
                            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.ar.f.a.3.1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    Bitmap bitmap;
                                    try {
                                        Drawable background = a.this.c.getBackground();
                                        a.this.c.setBackgroundColor(0);
                                        if (!(background instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) background).getBitmap()) == null || bitmap.isRecycled()) {
                                            return;
                                        }
                                        bitmap.recycle();
                                    } catch (NullPointerException e2) {
                                        e2.printStackTrace();
                                    }
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            });
                            ofFloat.start();
                        }
                    }
                });
            }
            if (camera != null) {
                this.f = bArr;
            }
            if (this.u == null) {
                try {
                    Camera.Size previewSize = camera.getParameters().getPreviewSize();
                    this.u = new f(previewSize.width, previewSize.height);
                    this.u.c = bArr.length;
                    com.baidu.ar.util.b.d("bdar: camera preview size Width = " + previewSize.width + ", height = " + previewSize.height);
                    if (this.b != null) {
                        this.b.a(this.u);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            a(bArr, this.u);
        }
    }

    public boolean a(c cVar, boolean z) {
        this.h = cVar;
        if (this.k != null) {
            this.k.a();
            this.k = null;
        }
        if (this.a != null) {
            this.a.a();
            this.a.d();
            com.baidu.ar.util.b.a("bdar: Camera releaseCamera in ARCameraController close");
        }
        this.n = null;
        this.p = null;
        if (z) {
            this.q = a(this.f);
        }
        this.v = false;
        if (this.b != null) {
            this.b.onPause();
        }
        c();
        this.u = null;
        return true;
    }

    public boolean a(e eVar) {
        this.n = eVar;
        if (this.p == null) {
            this.p = new CameraParams();
            this.p.setPreviewWidth(1280);
            this.p.setPreviewHeight(720);
        }
        if (this.a != null) {
            this.a.a(this.p, this.j);
            com.baidu.ar.util.b.a("bdar: Camera setupCamera in ARCameraController open");
        }
        com.baidu.ar.h.a.a().a("open_camera");
        if (this.b != null) {
            this.b.onResume();
            return true;
        }
        return true;
    }

    public void b() {
        if (this.b != null) {
            this.b.setRecorder(null);
        }
    }

    public void c() {
        if (this.s != null) {
            this.s.cancel();
            this.s.purge();
            this.s = null;
        }
        if (this.t != null) {
            this.t.cancel();
            this.t = null;
        }
    }

    public void d() {
    }

    public void e() {
        if (this.j != null) {
            this.j = null;
        }
        this.m = null;
        this.n = null;
        c();
        BaiduArView.b();
        b.a().b();
    }

    public int f() {
        return -1;
    }

    public Bitmap g() {
        return this.q;
    }

    public BaiduArView h() {
        return this.b;
    }
}
