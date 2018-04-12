package com.baidu.ar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.a;
import com.baidu.ar.b.a;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.CaptureState;
import com.baidu.ar.bean.FunctionType;
import com.baidu.ar.camera.CameraController;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.opengl.BaiduArView;
import com.baidu.ar.resloader.b;
import com.baidu.ar.speech.SpeechManager;
import com.baidu.ar.ui.ARWebView;
import com.baidu.ar.ui.CategoryView;
import com.baidu.ar.ui.LoadingView;
import com.baidu.ar.ui.RoundProgressBar;
import com.baidu.ar.ui.ScanView;
import com.baidu.ar.ui.ShareView;
import com.baidu.ar.ui.ToastView;
import com.baidu.ar.ui.a;
import com.baidu.ar.ui.adapter.a;
import com.baidu.ar.ui.b;
import com.baidu.ar.ui.rotateview.Orientation;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.j;
import com.baidu.ar.util.l;
import com.baidu.ar.util.m;
import com.baidu.ar.util.n;
import com.baidu.ar.util.o;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public abstract class c extends d implements com.baidu.ar.recorder.b {
    protected static long P = 0;
    private static long aA = 300;
    protected String A;
    protected String B;
    protected String C;
    protected String D;
    protected com.baidu.ar.a.c.a E;
    protected Timer F;
    protected TimerTask G;
    protected Timer H;
    protected TimerTask I;
    protected g J;
    protected com.baidu.ar.bean.e K;
    public h L;
    protected com.baidu.ar.c.a M;
    protected ARWebView N;
    protected boolean O;
    protected com.baidu.ar.d.b Q;
    protected boolean R;
    protected boolean S;
    protected int T;
    protected int U;
    protected int V;
    protected boolean W;
    protected boolean X;
    protected int Y;
    protected int Z;
    protected View a;
    private int aB;
    private int aC;
    private boolean aD;
    private volatile boolean aE;
    private boolean aF;
    private boolean aG;
    private com.baidu.ar.ui.b aH;
    private a aI;
    private boolean aJ;
    private boolean aK;
    private b.a aL;
    protected boolean aa;
    public boolean ab;
    CategoryView.a ac;
    com.baidu.ar.arspeech.a ad;
    private FrameLayout ar;
    private byte[] as;
    private boolean at;
    private boolean au;
    private BaiduArView.a av;
    private b aw;
    private Timer ax;
    private TimerTask ay;
    private long az;
    protected int b;
    protected com.baidu.ar.f.f c;
    protected ShareView d;
    protected RotateImageView e;
    protected RotateImageView f;
    protected RotateImageView g;
    protected RotateImageView h;
    protected RelativeLayout i;
    protected RotateImageView j;
    protected ImageView k;
    protected CategoryView l;
    protected String m;
    protected RoundProgressBar n;
    protected RotateViewGroup o;
    protected RotateImageView p;
    protected RotateViewGroup q;
    protected TextView r;
    protected FrameLayout.LayoutParams s;
    protected RotateViewGroup t;
    protected TextView u;
    protected ScanView v;
    protected RotateViewGroup w;
    protected LoadingView x;
    protected RotateViewGroup y;
    protected ToastView z;

    /* loaded from: classes3.dex */
    private static class a implements ARWebView.c {
        c a;

        a(c cVar) {
            this.a = cVar;
        }

        public void a() {
            this.a = null;
        }

        @Override // com.baidu.ar.ui.ARWebView.c
        public void b() {
            if (this.a != null) {
                this.a.ar.removeView(this.a.N);
            }
        }

        @Override // com.baidu.ar.ui.ARWebView.c
        public void c() {
            if (this.a != null) {
                this.a.ar.removeView(this.a.N);
            }
        }

        @Override // com.baidu.ar.ui.ARWebView.c
        public void d() {
            this.a.y();
            this.a.N.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends AsyncTask<Object, Integer, String> {
        private SoftReference<c> a;
        private Bitmap b;

        public b(c cVar) {
            this.a = new SoftReference<>(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00f2  */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(Object... objArr) {
            Bitmap bitmap;
            OutOfMemoryError outOfMemoryError;
            Exception exc;
            Bitmap bitmap2 = null;
            try {
                if (objArr != null) {
                    try {
                    } catch (Exception e) {
                        exc = e;
                        bitmap = null;
                    } catch (OutOfMemoryError e2) {
                        outOfMemoryError = e2;
                        bitmap = null;
                    } catch (Throwable th) {
                        th = th;
                        bitmap = null;
                    }
                    if (objArr.length > 0) {
                        Bitmap a = o.a((int[]) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                        try {
                            this.b = o.a(o.a(), o.c(a));
                            boolean z = this.a.get().R;
                            if (z) {
                                this.a.get().b(this.b);
                            }
                            if (Constants.DEBUG_CAPTURE) {
                                com.baidu.ar.util.b.d("bdar: captureScreenFinish");
                            }
                            o.b(this.b);
                            if (!z && this.b != null) {
                                this.b.recycle();
                                this.b = null;
                            }
                            this.a.get().A();
                            if (Constants.DEBUG_CAPTURE) {
                                com.baidu.ar.util.b.d("bdar: saveScreenBitmapFinish");
                            }
                            if (a != null) {
                                a.recycle();
                            }
                        } catch (Exception e3) {
                            bitmap = a;
                            exc = e3;
                            if (Constants.DEBUG_CAPTURE) {
                                try {
                                    com.baidu.ar.ui.c.a(this.a.get().ag, this.a.get().af.get(), "capture screen exception: " + exc.getClass().getName(), 1);
                                } catch (NullPointerException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            com.baidu.ar.util.b.d("capture screen exception: " + exc.getMessage());
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            return null;
                        } catch (OutOfMemoryError e5) {
                            bitmap = a;
                            outOfMemoryError = e5;
                            if (Constants.DEBUG_CAPTURE) {
                                try {
                                    com.baidu.ar.ui.c.a(this.a.get().ag, this.a.get().af.get(), "capture screen exception: OutOfMemoryError", 1);
                                } catch (NullPointerException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            com.baidu.ar.util.b.d("capture screen error: " + outOfMemoryError.getMessage());
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap = a;
                            if (bitmap != null) {
                            }
                            throw th;
                        }
                        return null;
                    }
                }
                if (0 != 0) {
                    bitmap2.recycle();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        }

        public void a() {
            if (this.b != null) {
                this.b.recycle();
                this.b = null;
            }
        }

        public void b() {
            if (this.a != null) {
                this.a.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnTouchListenerC0027c implements View.OnTouchListener {
        float a;
        float b;

        private View$OnTouchListenerC0027c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            CaptureState captureState = (CaptureState) view2.getTag();
            switch (motionEvent.getAction()) {
                case 0:
                    if (captureState == CaptureState.VIDEO_UNSTART) {
                        ((RotateImageView) view2).setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_recording"));
                    } else if (captureState == CaptureState.VIDEO_CAPTUREING) {
                        ((RotateImageView) view2).setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_capture_normal"));
                    }
                    this.a = rawX;
                    this.b = rawY;
                    break;
                case 1:
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    int width = view2.getWidth();
                    int height = view2.getHeight();
                    boolean z = rawX > ((float) iArr[0]) && rawX < ((float) (iArr[0] + width)) && rawY > ((float) iArr[1]) && rawY < ((float) (iArr[1] + height));
                    if (this.a <= iArr[0] || this.a >= width + iArr[0] || this.b <= iArr[1] || this.b < iArr[1] + height) {
                    }
                    if (!z) {
                        if (captureState != CaptureState.VIDEO_UNSTART) {
                            if (captureState == CaptureState.VIDEO_CAPTUREING) {
                                ((RotateImageView) view2).setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_recording"));
                                break;
                            }
                        } else {
                            ((RotateImageView) view2).setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_capture_normal"));
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    }

    public c(BaseFragment baseFragment, a.C0024a c0024a) {
        super(baseFragment, c0024a);
        this.b = 0;
        this.at = false;
        this.au = true;
        this.J = g.a();
        this.az = 0L;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.W = false;
        this.X = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aa = false;
        this.aG = false;
        this.ab = false;
        this.aI = new a(this);
        this.ac = new CategoryView.a() { // from class: com.baidu.ar.c.11
            @Override // com.baidu.ar.ui.CategoryView.a
            public void a() {
                c.this.aG = true;
                c.this.j.setEnabled(false);
            }

            @Override // com.baidu.ar.ui.CategoryView.a
            public void a(int i) {
                c.this.aG = false;
                c.this.j.setEnabled(true);
            }
        };
        this.aJ = false;
        this.aK = false;
        this.aL = new b.a() { // from class: com.baidu.ar.c.12
            @Override // com.baidu.ar.ui.b.a
            public void a() {
                c.this.u();
                com.baidu.ar.h.a.a().a("user_camera_permission_deny");
            }

            @Override // com.baidu.ar.ui.b.a
            public void b() {
                o.a(c.this.af.get());
                com.baidu.ar.h.a.a().a("user_setting_camera_permission");
            }
        };
        this.ad = new com.baidu.ar.arspeech.a() { // from class: com.baidu.ar.c.13
            @Override // com.baidu.ar.arspeech.a
            public void a() {
                if (c.this.ao()) {
                    c.this.g(102);
                } else {
                    c.this.au();
                }
            }

            @Override // com.baidu.ar.arspeech.a
            public void b() {
                c.this.av();
            }
        };
        this.L = new h(this.af, this);
        this.M = new com.baidu.ar.c.a(this.ag, this.ad);
        this.Q = new com.baidu.ar.d.b(this.ag);
        this.L.a(new b.a() { // from class: com.baidu.ar.c.1
            @Override // com.baidu.ar.resloader.b.a
            public void a(boolean z) {
                c.this.aa = z;
                if (!z) {
                    c.this.at();
                    return;
                }
                c.this.a();
                c.this.f();
                c.this.E();
                c.this.c(true);
            }
        });
    }

    public static HashMap<String, Object> a(com.baidu.ar.bean.b bVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("template_width", Integer.valueOf(bVar.e()));
        hashMap.put("template_height", Integer.valueOf(bVar.f()));
        hashMap.put("target_width", Integer.valueOf(bVar.c()));
        hashMap.put("target_height", Integer.valueOf(bVar.d()));
        hashMap.put("centre_pos", bVar.g().b());
        return hashMap;
    }

    private void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.ar.util.a.b()) {
                try {
                    if (this.af != null) {
                        if ((Build.VERSION.SDK_INT >= 23 ? this.af.get().checkSelfPermission(str) : 0) != 0) {
                            if (this.aJ) {
                                Y();
                                return;
                            }
                            this.ae.get().requestPermissions(new String[]{str}, i);
                            com.baidu.ar.h.a.a().a("system_request_camera_permission");
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(RotateImageView rotateImageView, Orientation orientation, boolean z) {
        if (rotateImageView != null) {
            rotateImageView.a(orientation, z);
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        aa();
        if (this.aH == null) {
            this.aH = new com.baidu.ar.ui.b(this.af.get());
            this.aH.a(this.aL);
            this.aH.show();
            this.aH.a(str);
            if (com.baidu.ar.util.a.b()) {
                this.aH.a(true);
                this.aH.b(str2);
                this.aH.c(str4);
                return;
            }
            this.aH.a(false);
            this.aH.b(str3);
            this.aH.c(str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        this.R = false;
        this.S = false;
        h(false);
        this.T = 0;
        ak();
        if (this.d != null) {
            this.d.c();
        }
        this.a.startAnimation(Res.loadAnimation("bdar_anim_slide_in_from_left"));
        Animation loadAnimation = Res.loadAnimation("bdar_anim_slide_out_to_right");
        if (this.d != null) {
            this.d.startAnimation(loadAnimation);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.ar.c.18
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.d != null) {
                    c.this.d.d();
                    c.this.ar.removeView(c.this.d);
                    c.this.d = null;
                    c.this.al();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ArBridge.getInstance().onResumeByUser();
    }

    private void ak() {
        if (this.aw != null && !this.aw.isCancelled()) {
            this.aw.cancel(true);
            this.aw.b();
        }
        this.av = null;
        this.R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.aw != null) {
            this.aw.a();
            this.aw = null;
        }
    }

    private boolean am() {
        if (this.af.get() != null) {
            return this.af.get().getSharedPreferences("ar_share_pres", 0).getBoolean("audio_dialog_show", false);
        }
        return false;
    }

    private void an() {
        if (this.af.get() != null) {
            this.af.get().getSharedPreferences("ar_share_pres", 0).edit().putBoolean("audio_dialog_show", true).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public boolean ao() {
        if (!com.baidu.ar.util.a.b() || this.af == null || this.af.get() == null) {
            return true;
        }
        return this.af.get().checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
    }

    private void ap() {
        if (this.ai == null || !this.ai.h()) {
            g(101);
        } else {
            aq();
        }
        an();
    }

    private void aq() {
        a.C0039a c0039a = new a.C0039a(this.af.get());
        c0039a.a((CharSequence) Res.getString("plugin_bdar_audio_permission_dialog_title"));
        c0039a.a(l.e(this.af.get()) + Res.getString("plugin_bdar_audio_permission_dialog_context"));
        c0039a.a(Res.getString("bdar_ok"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.c.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.g(101);
                com.baidu.ar.h.a.a().a("audio_dialog_yes");
            }
        });
        c0039a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.ar();
                com.baidu.ar.h.a.a().a("audio_dialog_no");
            }
        });
        com.baidu.ar.ui.a a2 = c0039a.a();
        a2.setCanceledOnTouchOutside(false);
        a2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.ar.c.8
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    c.this.au();
                    dialogInterface.dismiss();
                    return true;
                }
                return false;
            }
        });
        an();
        a2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar() {
        if (this.ap != null) {
            this.ap.a(this, 10000L);
        }
    }

    private boolean as() {
        if ((this.n != null ? this.n.getProgress() : 0) <= 10) {
            Activity activity = this.af.get();
            if (activity != null) {
                com.baidu.ar.ui.c a2 = com.baidu.ar.ui.c.a(this.ag, activity, Res.getString("bdar_video_recording_too_short"), 1);
                a2.b(2);
                a2.a();
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        y();
        J();
        if (this.ai == null || TextUtils.isEmpty(this.ai.d())) {
            a("https://dusee.baidu.com/static/site/pages/intro/ar_help.html");
        } else {
            a(this.ai.d());
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        n.a(new Runnable() { // from class: com.baidu.ar.c.14
            @Override // java.lang.Runnable
            public void run() {
                SpeechManager.getInstance(c.this.ag).startARListener(new Intent());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        n.a(new Runnable() { // from class: com.baidu.ar.c.15
            @Override // java.lang.Runnable
            public void run() {
                SpeechManager.getInstance(c.this.ag).stopARListening();
            }
        });
    }

    private void b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.ar.util.a.b()) {
                try {
                    if (this.af != null) {
                        if ((Build.VERSION.SDK_INT >= 23 ? this.af.get().checkSelfPermission(str) : 0) != 0) {
                            if (this.aK) {
                                Z();
                            } else {
                                this.ae.get().requestPermissions(new String[]{str}, i);
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        if (this.ae != null) {
            this.ae.get().requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, i);
        }
    }

    private void h(boolean z) {
        if (z) {
            a(this.l, 4);
            a(this.k, 4);
            return;
        }
        a(this.l, 0);
        a(this.k, 0);
    }

    protected abstract void A();

    public void B() {
        if (this.F != null) {
            this.F.cancel();
            this.F.purge();
            this.F = null;
        }
        if (this.G != null) {
            this.G.cancel();
            this.G = null;
        }
    }

    public void C() {
        if (this.H != null) {
            this.H.cancel();
            this.H.purge();
            this.H = null;
        }
        if (this.I != null) {
            this.I.cancel();
            this.I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        this.L.b();
        C();
        B();
    }

    protected void E() {
        if (Constants.AR_IS_NEED_PRINT_FRAME_LOG) {
            this.ax = new Timer();
            this.ay = new TimerTask() { // from class: com.baidu.ar.c.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.G();
                }
            };
            this.ax.schedule(this.ay, 0L, Constants.PRINT_FPS_INTERVAL);
        }
    }

    protected void F() {
        if (this.ax != null) {
            this.ax.cancel();
            this.ax.purge();
            this.ax = null;
        }
        if (this.ay != null) {
            this.ay.cancel();
            this.ay = null;
        }
    }

    protected void G() {
        if (Constants.AR_IS_NEED_PRINT_FRAME_LOG) {
            com.baidu.ar.util.b.d("the engine fps is : " + ArBridge.getInstance().getFps());
        }
    }

    @Override // com.baidu.ar.h.b
    public void H() {
        if (this.z != null) {
            this.z.a(7000, 2000);
        }
    }

    @Override // com.baidu.ar.h.b
    public void I() {
        b(601, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.ar.h.b
    public void J() {
        if (this.z != null) {
            this.z.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean K() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.az < aA) {
            return false;
        }
        this.az = currentTimeMillis;
        return true;
    }

    @Override // com.baidu.ar.d
    public void L() {
        this.aF = true;
        c();
        b(true);
    }

    @Override // com.baidu.ar.d
    public void M() {
        this.aF = false;
        b();
        b(false);
        a(false);
        y();
    }

    @Override // com.baidu.ar.d
    public void N() {
    }

    @Override // com.baidu.ar.d
    public void O() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        CaptureState captureState;
        if (this.aC == 0 || this.aB == 0) {
            this.aB = this.ar.getWidth();
            this.aC = this.ar.getHeight();
        }
        h(true);
        if (this.aG || (captureState = (CaptureState) this.j.getTag()) == null) {
            return;
        }
        if (captureState == CaptureState.PICTURE) {
            Q();
        } else if (captureState == CaptureState.VIDEO_UNSTART) {
            R();
        } else if (captureState == CaptureState.VIDEO_CAPTUREING) {
            S();
        }
    }

    protected void Q() {
        if (this.R) {
            return;
        }
        this.R = true;
        if (this.j != null) {
            this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_capture_selector"));
        }
        z();
        com.baidu.ar.h.a.a().a("capture_screen");
    }

    protected void R() {
        if (this.S) {
            return;
        }
        c(false);
        if (!ao() || am()) {
            ar();
        } else {
            ap();
        }
        this.at = false;
    }

    protected void S() {
        e(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T() {
        if (this.W) {
            this.W = false;
            if (this.x != null) {
                this.x.dismiss();
            }
            if (o.f()) {
                a((Bitmap) null);
                if (this.d != null) {
                    this.d.a();
                }
                return true;
            }
            Activity activity = this.af.get();
            if (activity != null) {
                com.baidu.ar.ui.c a2 = com.baidu.ar.ui.c.a(this.ag, activity, Res.getString("bdar_record_error"), 1);
                a2.b(2);
                a2.a();
            }
            h(false);
            return false;
        }
        return false;
    }

    protected abstract void U();

    protected abstract void V();

    protected abstract void W();

    @Override // com.baidu.ar.d
    public void X() {
        final BaseFragment baseFragment = this.ae.get();
        if (baseFragment != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            a(new com.baidu.ar.f.c() { // from class: com.baidu.ar.c.9
                @Override // com.baidu.ar.f.c
                public void a(boolean z) {
                    if (c.this.ak != null) {
                        com.baidu.ar.util.b.a("close camera and quit, spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                        c.this.ak.quitAR(baseFragment, IARCallback.ARAction.SWITCHTOBARCODE);
                    }
                }
            }, false);
        }
        com.baidu.ar.h.a.a().a("end_ar");
    }

    protected void Y() {
        com.baidu.ar.h.a.a().a("user_request_camera_permission");
        a(Res.getString("bdar_open_camera_permision"), Res.getString("bdar_open_camera_description_for_android_m_above"), Res.getString("bdar_open_camera_description_for_android_m_under"), Res.getString("bdar_go_setting"), Res.getString("bdar_got_it"));
    }

    protected void Z() {
        a(Res.getString("bdar_open_storage_permision"), Res.getString("bdar_open_storage_description_for_android_m_above"), Res.getString("bdar_open_storage_description_for_android_m_under"), Res.getString("bdar_go_setting"), Res.getString("bdar_got_it"));
    }

    @Override // com.baidu.ar.d
    public View a(Activity activity) {
        this.aC = 0;
        this.aB = 0;
        this.ar = new FrameLayout(this.ag);
        b(activity);
        a(activity, this.ar);
        return this.ar;
    }

    public void a() {
        this.M.a();
    }

    public void a(int i) {
        if (this.q != null) {
            this.q.setVisibility(i);
        }
    }

    @Override // com.baidu.ar.d
    public void a(int i, String[] strArr, int[] iArr) {
        super.a(i, strArr, iArr);
        if (i == 600) {
            if (iArr[0] != -1) {
                this.aJ = false;
                com.baidu.ar.h.a.a().a("system_camera_permission_granted");
                return;
            }
            com.baidu.ar.h.a.a().a("system_camera_permission_deny");
            this.aJ = true;
            if (this.d == null) {
                Y();
            } else if (this.d.getVisibility() != 0) {
                Y();
            }
        } else if (i == 101 && iArr.length > 0) {
            boolean z = iArr[0] == 0;
            com.baidu.ar.util.b.b("onRequestPermissionsResult granted = " + z);
            if (z) {
                com.baidu.ar.h.a.a().a("audio_has_permission");
            } else {
                com.baidu.ar.h.a.a().a("audio_no_permission");
            }
            this.ab = true;
            ar();
        } else if (i != 601) {
            if (i != 102 || iArr.length <= 0) {
                return;
            }
            if (iArr[0] == 0) {
                au();
            }
        } else {
            if (iArr[0] == 0) {
                this.aK = false;
                return;
            }
            this.aK = true;
            if (this.d == null) {
                Z();
            } else if (this.d.getVisibility() != 0) {
                Z();
            }
        }
    }

    protected abstract void a(Activity activity, FrameLayout frameLayout);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        Activity activity = this.af.get();
        if (activity == null) {
            com.baidu.ar.util.b.d("activity is null!");
            return;
        }
        if (this.ap != null) {
            this.ap.a(new com.baidu.ar.f.c() { // from class: com.baidu.ar.c.16
                @Override // com.baidu.ar.f.c
                public void a(boolean z) {
                    if (!z || c.this.e == null) {
                        return;
                    }
                    c.this.au = true;
                    if (c.this.au) {
                        c.this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_disable_selector"));
                    } else {
                        c.this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_enable_selector"));
                    }
                }
            }, "off");
        }
        ArBridge.getInstance().onPauseByUser();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.d = new ShareView(activity);
        this.d.setARConfig(this.am);
        if (bitmap != null) {
            this.d.setShareBitmap(bitmap);
        } else {
            this.d.setVideoPath(o.e());
        }
        this.ar.addView(this.d, layoutParams);
        this.d.setOnShareClickListener(new ShareView.b() { // from class: com.baidu.ar.c.17
            @Override // com.baidu.ar.ui.ShareView.b
            public void a() {
                c.this.aj();
                c.this.g();
            }

            @Override // com.baidu.ar.ui.ShareView.b
            public void a(String str, String str2, String str3, Bitmap bitmap2, String str4, String str5, boolean z, boolean z2, com.baidu.ar.external.a.a.e eVar) {
                com.baidu.ar.h.a.a().a("share");
                if (c.this.ak != null) {
                    c.this.ak.shareSyncForPlugin(c.this.ag, str, str2, str3, bitmap2, str4, str5, z, z2, null);
                    c.this.ak.share(str, str2, str3, str5, c.this.d.b);
                }
            }
        });
        this.d.startAnimation(Res.loadAnimation("bdar_anim_slide_in_from_right"));
        this.a.startAnimation(Res.loadAnimation("bdar_anim_slide_out_to_left"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
        b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Handler handler, com.baidu.ar.f.f fVar) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 603;
            obtainMessage.obj = new Object[]{fVar};
            handler.sendMessage(obtainMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Message message) {
        if (message != null) {
            try {
                if (message.what != 603 || message.obj == null) {
                    return;
                }
                a((com.baidu.ar.f.f) ((Object[]) message.obj)[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, int i) {
        if (view2 != null) {
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.h.b
    public void a(ARResource aRResource) {
        super.a(aRResource);
        Activity activity = this.af.get();
        if (activity != null) {
            c(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.ar.bean.e eVar) {
        if (eVar == null || eVar.b() == null) {
            return;
        }
        com.baidu.ar.bean.d b2 = eVar.b();
        if (TextUtils.isEmpty(b2.a())) {
            this.A = null;
        } else {
            this.A = b2.a();
        }
        if (TextUtils.isEmpty(b2.b())) {
            this.B = null;
        } else {
            this.B = b2.b();
        }
        if (TextUtils.isEmpty(b2.c())) {
            this.C = null;
        } else {
            this.C = b2.c();
        }
        if (TextUtils.isEmpty(b2.d())) {
            this.D = Res.getString("bdar_sdk_ar_track_target_not_finded");
        } else {
            this.D = b2.d();
        }
    }

    @Override // com.baidu.ar.d
    public void a(IARCallback iARCallback) {
        super.a(iARCallback);
        if (this.M != null) {
            this.M.a(iARCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.ar.f.c cVar, boolean z) {
        if (this.ap != null) {
            this.ap.a(cVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.ar.f.f fVar) {
        if (this.ap != null && this.ap.c()) {
            com.baidu.ar.c.a.b(o.a());
        }
        d();
    }

    @Override // com.baidu.ar.h.b
    public void a(String str) {
        if (this.ak != null) {
            this.ak.executeCommand(this.ag, str);
            com.baidu.ar.h.a.a().a("open_url", str);
        }
    }

    public void a(boolean z) {
        if (this.e != null) {
            this.e.setEnabled(z);
        }
    }

    protected void a(byte[] bArr, com.baidu.ar.f.f fVar) {
        if (this.al && bArr != null) {
            this.as = bArr;
            if (this.c == null) {
                try {
                    this.c = fVar;
                    this.Y = this.c.a;
                    this.Z = this.c.b;
                    if (this.X) {
                        this.Y = 640;
                        this.Z = 360;
                    }
                    com.baidu.ar.util.b.a("bdar: width = " + this.c.a + ", height = " + this.c.b);
                    b(this.c);
                    com.baidu.ar.a.a.a(this.c.a, this.c.b, bArr.length);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (this.S) {
                this.T++;
                if (this.T == 5) {
                    n.a(new Runnable() { // from class: com.baidu.ar.c.10
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.z();
                        }
                    });
                }
            }
            b(bArr, fVar);
        }
    }

    protected void aa() {
        if (this.aH == null || !this.aH.isShowing()) {
            return;
        }
        this.aH.dismiss();
        this.aH = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab() {
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    protected void b() {
        a(8);
        b(8);
        j();
        this.L.f();
        if (CameraController.getInstance().hasPermission(this.af.get())) {
            return;
        }
        a(600, "android.permission.CAMERA");
    }

    public void b(int i) {
        if (i == 0) {
            y();
        }
        if (this.t != null) {
            this.t.setVisibility(i);
        }
    }

    public void b(Activity activity) {
        m.b = Res.getString("bdar_capture_pic");
        m.a = Res.getString("bdar_capture_video");
        this.U = Res.getDimensionPixelSize("bdar_hint_margin_bottom");
        this.V = this.U;
    }

    protected abstract void b(Bitmap bitmap);

    protected void b(Bundle bundle) {
        com.baidu.ar.util.b.c("tracked");
        if (bundle == null) {
            com.baidu.ar.util.b.d("track result is null!");
            return;
        }
        float f = bundle.getFloat("distance");
        try {
            com.baidu.ar.bean.d b2 = this.K.b();
            if (Float.isNaN(b2.e()) || Float.isNaN(b2.f())) {
                a(8);
            } else if (f > b2.e()) {
                if (TextUtils.isEmpty(this.B)) {
                    a(8);
                } else {
                    c(this.B);
                    a(0);
                }
            } else if (f >= b2.f()) {
                a(8);
            } else if (TextUtils.isEmpty(this.C)) {
                a(8);
            } else {
                c(this.C);
                a(0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    protected abstract void b(com.baidu.ar.f.f fVar);

    public void b(String str) {
        if (this.ak != null) {
            ARConfiguration aRConfiguration = this.am;
            if (TextUtils.isEmpty(ARConfiguration.getAccessKey())) {
                this.ak.executeCommandWithO2O(this.ag, str);
            } else {
                this.ak.transparentLink(str);
            }
            com.baidu.ar.h.a.a().a("open_url", str);
        }
    }

    public void b(boolean z) {
        if (this.f != null) {
            this.f.setEnabled(z);
        }
    }

    protected void b(byte[] bArr, com.baidu.ar.f.f fVar) {
        com.baidu.ar.util.b.a("bdar: mSoLoaded = " + this.aa);
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        if (this.aa) {
            c(bArr, fVar);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: processPreviewFrame time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    protected void c() {
        if (e() != 0) {
            a(8);
        }
        aa();
    }

    protected abstract void c(int i);

    public void c(Activity activity) {
        this.i = (RelativeLayout) activity.findViewById(Res.id("bdar_gui_capture_group"));
        if (this.i == null) {
            return;
        }
        Map<FunctionType, Boolean> j = this.ai != null ? this.ai.j() : null;
        if ((j == null || !j.containsKey(FunctionType.VIDEO) || j.get(FunctionType.VIDEO).booleanValue()) && j.a(this.ag)) {
            this.j = (RotateImageView) this.i.findViewById(Res.id("bdar_gui_capture"));
            this.k = (ImageView) this.i.findViewById(Res.id("bdar_id_triangle"));
            this.k.setVisibility(0);
            this.l = (CategoryView) this.i.findViewById(Res.id("bdar_capture_category"));
            this.l.setVisibility(0);
            this.l.setCategoryListener(new a.InterfaceC0040a() { // from class: com.baidu.ar.c.5
                @Override // com.baidu.ar.ui.adapter.a.InterfaceC0040a
                public void a(com.baidu.ar.ui.adapter.a aVar, String str) {
                    c.this.m = str;
                    if (str.equals(m.b)) {
                        c.this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_capture_selector"));
                        c.this.j.setTag(CaptureState.PICTURE);
                    } else if (str.equals(m.a)) {
                        c.this.j.setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_capture_normal"));
                        c.this.j.setTag(CaptureState.VIDEO_UNSTART);
                    }
                }
            });
            this.o = (RotateViewGroup) this.i.findViewById(Res.id("bdar_gui_capture_loading_group"));
            this.o.setAngle(o.a());
            this.n = (RoundProgressBar) this.i.findViewById(Res.id("bdar_gui_capture_loading"));
            this.n.setTextColor(0);
            this.n.setCricleProgressColor(Res.getColor("bdar_capture_btn_pressed"));
            this.n.setCricleColor(0);
            this.n.setRoundWidth(o.a(activity, 1.0f));
            this.m = m.b;
            this.l.setCurrentItem(this.m);
            this.j.setTag(CaptureState.PICTURE);
            this.j.setOnTouchListener(new View$OnTouchListenerC0027c());
            this.l.setItemChangeListener(this.ac);
        } else {
            this.i.removeAllViews();
            this.j = new RotateImageView(activity);
            this.j.setId(Res.id("bdar_gui_capture"));
            int dimensionPixelSize = Res.getDimensionPixelSize("bdar_icon_capture_size");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_capture_selector"));
            this.j.setTag(CaptureState.PICTURE);
            this.m = m.b;
            this.i.addView(this.j, layoutParams);
            this.i.setPadding(0, 0, 0, o.a(activity, 10.0f));
            this.U = Res.getDimensionPixelSize("bdar_hint_margin_bottom_only_capture");
            this.V = this.U;
            d(activity);
        }
        c(false);
    }

    protected void c(String str) {
        if (this.r == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.r.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z) {
        if (this.j != null) {
            this.j.setEnabled(z);
        }
    }

    protected void c(byte[] bArr, com.baidu.ar.f.f fVar) {
    }

    protected abstract void d();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i) {
        if (i > 0 && i < 100) {
            int i2 = 100 - i;
            if (this.n != null) {
                this.n.setProgress(i2);
            }
        } else if (i == 0) {
            if (this.n != null) {
                this.n.setProgress(100);
            }
            e(true);
        }
    }

    protected void d(Activity activity) {
        if (activity == null || o.a() != 0 || this.q == null) {
            return;
        }
        this.q.setAngle(0);
        this.s = (FrameLayout.LayoutParams) this.q.getLayoutParams();
        this.s.gravity = 81;
        this.s.bottomMargin = this.V;
        this.s.leftMargin = 0;
        this.s.rightMargin = 0;
    }

    public void d(String str) {
        if (this.u != null) {
            this.u.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z) {
    }

    @Override // com.baidu.ar.d
    public void d(byte[] bArr, com.baidu.ar.f.f fVar) {
        a(bArr, fVar);
    }

    public int e() {
        if (this.ap != null) {
            return this.ap.d();
        }
        return -1;
    }

    @Override // com.baidu.ar.recorder.b
    public void e(int i) {
        int i2 = 100 - i;
        if (i2 <= 0 && !this.at) {
            i2 = 0;
            this.at = true;
        }
        c(i2);
    }

    @Override // com.baidu.ar.h.b
    public void e(String str) {
    }

    protected void e(boolean z) {
        boolean z2 = true;
        if (this.S && this.aD && !this.aE) {
            this.aE = true;
            if (!z || !as()) {
                z2 = false;
            }
            this.W = z2;
            if (this.j != null) {
                this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_video_selector"));
                this.j.setTag(CaptureState.VIDEO_UNSTART);
                c(false);
            }
            if (this.n != null) {
                this.n.setVisibility(8);
                this.n.setProgress(0);
            }
            d(false);
            if (!this.W) {
                o();
                this.S = false;
                this.T = 0;
                h(false);
                U();
                if (this.x != null) {
                    this.x.dismiss();
                }
            } else if (this.x != null) {
                this.x.setMsg(Res.getString("bdar_record_completing"));
                this.x.show();
            }
            if (this.ap != null) {
                this.ap.g();
            }
        }
    }

    protected void f() {
        if (this.ap != null) {
            this.ap.b();
        }
    }

    @Override // com.baidu.ar.recorder.b
    public void f(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str) {
        c(str);
        if (TextUtils.isEmpty(str)) {
            a(8);
        } else {
            a(0);
        }
    }

    @Override // com.baidu.ar.recorder.b
    public void f(boolean z) {
        this.aD = z;
        if (z) {
            this.T = 0;
            if (this.n != null) {
                this.n.setProgress(0);
                this.n.setVisibility(0);
            }
            if (this.j != null) {
                this.j.setImageDrawable(Res.getDrawable("bdar_drawable_icon_video_recording"));
                this.j.setTag(CaptureState.VIDEO_CAPTUREING);
            }
            h(true);
            d(true);
        } else {
            if (this.ap != null) {
                this.ap.g();
            }
            if (this.j != null) {
                this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_video_selector"));
                this.j.setTag(CaptureState.VIDEO_UNSTART);
            }
        }
        c(true);
        this.S = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d(str);
        b(0);
    }

    @Override // com.baidu.ar.recorder.b
    public void g(boolean z) {
        com.baidu.ar.util.b.b("bdar: onRecorderComplete result = " + z);
        W();
        this.aD = !z;
        c(true);
        this.aE = false;
        if (this.ap != null) {
            this.ap.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.N = new ARWebView(this.ag);
        this.ar.addView(this.N, layoutParams);
        this.N.setWebViewCallcack(this.aI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        if (this.v != null) {
            this.v.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.v != null) {
            this.v.b();
        }
    }

    @Override // com.baidu.ar.d
    public void k() {
    }

    @Override // com.baidu.ar.d
    public void l() {
        super.l();
        if (this.L != null) {
            this.L.h();
        }
        if (this.d != null) {
            this.d.b();
        } else if (!T()) {
            ArBridge.getInstance().onResumeByUser();
        }
        ae();
        if (this.e != null) {
            if (this.au) {
                this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_disable_selector"));
            } else {
                this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_enable_selector"));
            }
        }
        if (this.l != null) {
            this.l.setCurrentItem(this.m);
            if (this.j != null) {
                if (this.m.equals(m.b)) {
                    this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_capture_selector"));
                    this.j.setTag(CaptureState.PICTURE);
                } else if (this.m.equals(m.a)) {
                    this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_video_selector"));
                    this.j.setTag(CaptureState.VIDEO_UNSTART);
                }
            }
        }
        h(false);
        com.baidu.ar.b.b.a(this.ag).a(true);
    }

    @Override // com.baidu.ar.d
    public void m() {
        super.m();
        if (this.d != null) {
            this.d.c();
        } else {
            o();
        }
        af();
        if (this.L != null) {
            this.L.i();
            this.L.g();
            this.L.f();
            this.L.c();
            this.L.b();
        }
        this.c = null;
        this.au = true;
        y();
        J();
        if (this.aD) {
            e(true);
        }
        this.R = false;
        this.S = false;
        com.baidu.ar.b.b.a(this.ag).a(false);
    }

    @Override // com.baidu.ar.d
    public void n() {
        if (this.ap != null && this.ap.c()) {
            ArBridge.getInstance().destroyCase();
            com.baidu.ar.util.b.d("bdar: destroyCase");
        }
        super.n();
        if (this.d != null) {
            this.d.d();
            this.d = null;
        }
        o();
        this.L = null;
        p();
        q();
        if (this.M != null) {
            this.M.b();
            this.M = null;
        }
        if (this.aI != null) {
            this.aI.a();
            this.aI = null;
        }
        com.baidu.ar.h.a.a().b();
        F();
        this.Q.a();
        com.baidu.ar.ui.c.b();
        com.baidu.ar.b.b.a(this.ag).a();
        com.baidu.ar.a.a.a();
        if (this.Q != null) {
            this.Q.b();
        }
    }

    protected void o() {
        ak();
        al();
    }

    protected void p() {
        com.baidu.ar.b.a.a().a(new a.InterfaceC0026a() { // from class: com.baidu.ar.c.19
            @Override // com.baidu.ar.b.a.InterfaceC0026a
            public void a(Exception exc) {
                com.baidu.ar.b.a.b();
            }

            @Override // com.baidu.ar.b.a.InterfaceC0026a
            public void a(boolean z) {
                com.baidu.ar.b.a.b();
            }
        });
    }

    protected void q() {
        com.baidu.ar.b.d.a().b();
    }

    @Override // com.baidu.ar.d
    public void r() {
        if (this.ap != null && this.ap.c()) {
            com.baidu.ar.c.a.b(0);
        }
        o.a(0);
        if (this.d != null && this.d.isShown()) {
            this.d.f();
        }
        if (this.o != null) {
            this.o.setAngle(0);
        }
    }

    @Override // com.baidu.ar.d
    public void s() {
        if (this.ap != null && this.ap.c()) {
            com.baidu.ar.c.a.b(-90);
        }
        o.a(-90);
        if (this.d != null && this.d.isShown()) {
            this.d.g();
        }
        if (this.o != null) {
            this.o.setAngle(-90);
        }
    }

    @Override // com.baidu.ar.d
    public void t() {
        if (this.ap != null && this.ap.c()) {
            com.baidu.ar.c.a.b(90);
        }
        o.a(90);
        if (this.d != null && this.d.isShown()) {
            this.d.h();
        }
        if (this.o != null) {
            this.o.setAngle(90);
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.h.b
    public boolean u() {
        final BaseFragment baseFragment = this.ae.get();
        if (baseFragment != null) {
            if (this.aF) {
                final long currentTimeMillis = System.currentTimeMillis();
                a(new com.baidu.ar.f.c() { // from class: com.baidu.ar.c.20
                    @Override // com.baidu.ar.f.c
                    public void a(boolean z) {
                        if (c.this.ak != null) {
                            com.baidu.ar.util.b.a("close camera and quit, spend time = " + (System.currentTimeMillis() - currentTimeMillis));
                            c.this.ak.quitAR(baseFragment, IARCallback.ARAction.BACK);
                        }
                    }
                }, false);
            } else {
                this.ak.quitAR(baseFragment, IARCallback.ARAction.BACK);
            }
        }
        com.baidu.ar.h.a.a().a("end_ar");
        if (P <= 0 || System.currentTimeMillis() - P <= 1000) {
            return true;
        }
        P = 0L;
        com.baidu.ar.h.a.a().a("model_show_1s");
        return true;
    }

    @Override // com.baidu.ar.d
    public boolean v() {
        if (K()) {
            if (this.d != null && this.d.isShown()) {
                aj();
                g();
                return true;
            } else if (this.aD) {
                e(false);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public void w() {
        if (this.ap != null) {
            this.ap.a(new com.baidu.ar.f.c() { // from class: com.baidu.ar.c.21
                @Override // com.baidu.ar.f.c
                public void a(boolean z) {
                    if (z) {
                        c.this.au = !c.this.au;
                        if (c.this.au) {
                            c.this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_disable_selector"));
                        } else {
                            c.this.e.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_enable_selector"));
                        }
                    }
                }
            }, this.au ? "torch" : "off");
        }
    }

    @Override // com.baidu.ar.h.b
    public void x() {
        n.a(new Runnable() { // from class: com.baidu.ar.c.22
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.x != null) {
                    c.this.x.setMsg(Res.getString("bdar_loading"));
                    c.this.x.show();
                }
            }
        });
    }

    @Override // com.baidu.ar.h.b
    public void y() {
        n.a(new Runnable() { // from class: com.baidu.ar.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.x != null) {
                    c.this.x.dismiss();
                }
            }
        });
    }

    protected void z() {
        if (Constants.DEBUG_CAPTURE) {
            com.baidu.ar.util.b.d("bdar: doCaptureScreen");
        }
        if (this.av == null) {
            this.av = new BaiduArView.a() { // from class: com.baidu.ar.c.3
                @Override // com.baidu.ar.opengl.BaiduArView.a
                public void a(int[] iArr, int i, int i2) {
                    c.this.aw = new b(c.this);
                    c.this.aw.execute(iArr, Integer.valueOf(i), Integer.valueOf(i2));
                }
            };
        }
        if (this.ap != null) {
            this.ap.a(this.av);
        }
    }
}
