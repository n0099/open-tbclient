package com.baidu.ar.track;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.ar.a;
import com.baidu.ar.a.c.d;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.e;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.f.f;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.ui.LoadingView;
import com.baidu.ar.ui.ScanView;
import com.baidu.ar.ui.ToastView;
import com.baidu.ar.ui.rotateview.Orientation;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.o;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class a extends c implements View.OnClickListener {
    private C0037a aA;
    private View ar;
    private RotateViewGroup as;
    private View at;
    private View au;
    private RotateImageView av;
    private Bitmap aw;
    private b ax;
    private boolean ay;
    private com.baidu.ar.a.c.b az;

    /* renamed from: com.baidu.ar.track.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0037a implements com.baidu.ar.a.a.a {
        @Override // com.baidu.ar.a.a.a
        public void a(Bundle bundle) {
            if (bundle == null || bundle.getInt("track2D_method_type") == 0) {
                return;
            }
            boolean z = bundle.getBoolean("isTracked");
            bundle.getBoolean("isTrackStatusValid");
            boolean z2 = bundle.getBoolean("trackedFromTrackLost");
            boolean z3 = bundle.getBoolean("trackLostFromTracked");
            com.baidu.ar.h.a.a().a(z);
            if (z) {
                if (z2) {
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.TRACK_SUCCESS);
                }
            } else if (z3) {
                TrackStateMachine.a().a(TrackStateMachine.EVENT.TRACK_FAILED);
            }
            TrackStateMachine.a().b(TrackStateMachine.EVENT.UPDATE_RT_MATRIX, bundle);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private WeakReference<a> a;

        public b(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 300:
                    com.baidu.ar.h.a.a().a("start_download_3d_res");
                    aVar.L.a(0);
                    return;
                case 301:
                    com.baidu.ar.h.a.a().a("loading_3d_model_success");
                    aVar.J();
                    aVar.y();
                    aVar.ab();
                    return;
                case 302:
                    aVar.a(message.getData());
                    if (aVar.ay) {
                        return;
                    }
                    aVar.ay = true;
                    return;
                case 303:
                    aVar.g(aVar.D);
                    aVar.ap();
                    return;
                case 304:
                    aVar.a((Bitmap) message.obj);
                    return;
                case HttpStatus.SC_USE_PROXY /* 305 */:
                    if (aVar.d != null) {
                        aVar.d.a();
                    }
                    MediaScannerConnection.scanFile(aVar.ag, new String[]{o.b()}, null, null);
                    return;
                case 306:
                    long unused = a.P = System.currentTimeMillis();
                    com.baidu.ar.h.a.a().a("start_loading_3d_model");
                    if (!aVar.O) {
                        com.baidu.ar.h.a.a().a("start_animation");
                        aVar.O = true;
                    }
                    aVar.j();
                    aVar.am();
                    if (TrackStateMachine.a().c() == TrackStateMachine.STATE.TRACKED) {
                        aVar.a(8);
                    } else {
                        aVar.f(aVar.A);
                    }
                    aVar.B();
                    aVar.C();
                    aVar.b(8);
                    return;
                case HttpStatus.SC_TEMPORARY_REDIRECT /* 307 */:
                    aVar.an();
                    return;
                case 308:
                    aVar.L.a();
                    return;
                case 309:
                    aVar.b(8);
                    return;
                case 310:
                    aVar.f(aVar.A);
                    return;
                case 311:
                    if (message.getData() == null || TextUtils.isEmpty(message.getData().getString("url"))) {
                        return;
                    }
                    ArBridge.getInstance().onPauseByUser();
                    aVar.h();
                    aVar.N.a(message.getData().getString("url"));
                    com.baidu.ar.h.a.a().a("open_url", message.getData().getString("url"));
                    return;
                case 312:
                    if (message.getData() != null && message.getData().getInt("show_immediately") == 1) {
                        z = true;
                    }
                    if (!z) {
                        aVar.an();
                        return;
                    }
                    aVar.c(true);
                    aVar.f(aVar.A);
                    return;
                case 313:
                    if (message.getData().getInt("type") == 1) {
                        aVar.ag();
                        return;
                    }
                    return;
                case 314:
                    aVar.ab();
                    return;
                case 600:
                    aVar.d(message.getData().getInt(WBPageConstants.ParamKey.COUNT));
                    return;
                case 601:
                    aVar.V();
                    return;
                case 602:
                    aVar.T();
                    return;
                case 603:
                    aVar.a(message);
                    return;
                default:
                    return;
            }
        }
    }

    public a(BaseFragment baseFragment, a.C0024a c0024a) {
        super(baseFragment, c0024a);
        this.ax = null;
        this.ay = false;
        this.aA = new C0037a();
        this.E = new com.baidu.ar.a.c.a();
        TrackStateMachine.a().b();
        TrackStateMachine.a().a(this.Q);
        this.Q.a(new b.a() { // from class: com.baidu.ar.track.a.1
            @Override // com.baidu.ar.d.b.a
            public void a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                TrackStateMachine.a().c(TrackStateMachine.EVENT.UPDATE_RT_MATRIX, bundle);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0030, B:12:0x0046, B:14:0x0053, B:19:0x0060), top: B:25:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap a(e eVar, String str) {
        Bitmap a;
        boolean z = false;
        if (eVar != null) {
            try {
                if (eVar.b() != null) {
                    String str2 = str + File.separator + eVar.b().j();
                    if (!TextUtils.isEmpty(str2)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        Bitmap decodeFile = BitmapFactory.decodeFile(str2, options);
                        int i = options.outWidth;
                        int i2 = options.outHeight;
                        if (i2 > i) {
                            if (i2 > 900) {
                                options.inJustDecodeBounds = false;
                                a = a(options, false, str2);
                                z = true;
                                if (!z) {
                                    options.inJustDecodeBounds = false;
                                    a = BitmapFactory.decodeFile(str2, options);
                                }
                            }
                            a = decodeFile;
                            if (!z) {
                            }
                        } else {
                            if (i > 500) {
                                options.inJustDecodeBounds = false;
                                a = a(options, true, str2);
                                z = true;
                                if (!z) {
                                }
                            }
                            a = decodeFile;
                            if (!z) {
                            }
                        }
                        return a;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        a = null;
        return a;
    }

    private void a(final View view2) {
        final BaseFragment baseFragment = this.ae.get();
        final boolean isNeedLastPreview = this.am.isNeedLastPreview();
        if (baseFragment != null) {
            a(new com.baidu.ar.f.c() { // from class: com.baidu.ar.track.a.5
                @Override // com.baidu.ar.f.c
                public void a(boolean z) {
                    if (view2 != null) {
                        view2.setEnabled(true);
                    }
                    if (a.this.ak != null) {
                        if (isNeedLastPreview) {
                            a.this.ak.setPreviewBitmap(a.this.ap != null ? a.this.ap.e() : null);
                        }
                        com.baidu.ar.util.b.c("bdar: close camera and rescan");
                        a.this.ak.rescan(baseFragment);
                        com.baidu.ar.h.a.a().a("rescan");
                    } else if (isNeedLastPreview) {
                        Bitmap e = a.this.ap != null ? a.this.ap.e() : null;
                        if (e != null) {
                            e.recycle();
                        }
                    }
                }
            }, isNeedLastPreview);
            if (view2 != null) {
                view2.setEnabled(false);
            }
        }
    }

    private void a(d dVar) {
        com.baidu.ar.util.b.a("enableArTracking");
        b(dVar);
    }

    private void aj() {
        this.v = (ScanView) this.a.findViewById(Res.id("bdar_gui_scan_view"));
        this.q = (RotateViewGroup) this.a.findViewById(Res.id("bdar_gui_tips_group"));
        this.r = (TextView) this.a.findViewById(Res.id("bdar_gui_tips_text"));
        this.t = (RotateViewGroup) this.a.findViewById(Res.id("bdar_gui_exception_tips_group"));
        this.u = (TextView) this.a.findViewById(Res.id("bdar_gui_excteption_tips_text"));
        this.w = (RotateViewGroup) this.a.findViewById(Res.id("bdar_id_loading_group"));
        this.x = (LoadingView) this.a.findViewById(Res.id("bdar_id_loading"));
        this.y = (RotateViewGroup) this.a.findViewById(Res.id("bdar_gui_loading_overtime_tips_group"));
        this.z = (ToastView) this.a.findViewById(Res.id("bdar_gui_loading_overtime_tips_text"));
    }

    private void ak() {
        this.ar = this.a.findViewById(Res.id("bdar_titlebar_more_pop"));
        this.as = (RotateViewGroup) this.a.findViewById(Res.id("bdar_menu_bg_pop_window"));
        this.at = this.a.findViewById(Res.id("bdar_popmenu_item1"));
        this.at.setOnClickListener(this);
        this.au = this.a.findViewById(Res.id("bdar_popmenu_item2"));
        this.au.setOnClickListener(this);
        this.h = (RotateImageView) this.a.findViewById(Res.id("bdar_titlebar_more"));
        this.h.setOnClickListener(this);
        this.g = (RotateImageView) this.a.findViewById(Res.id("bdar_titlebar_back"));
        this.g.setOnClickListener(this);
        this.e = (RotateImageView) this.a.findViewById(Res.id("bdar_titlebar_flash"));
        this.e.setOnClickListener(this);
        this.p = (RotateImageView) this.a.findViewById(Res.id("bdar_gui_rescan"));
        this.p.setOnClickListener(this);
    }

    private void al() {
        if (!this.ay) {
            i();
        } else if (this.aw == null) {
            i();
        } else {
            this.av.setVisibility(0);
            this.av.setImageBitmap(this.aw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        this.av.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        al();
        f(this.A);
        ao();
    }

    private void ao() {
        B();
        this.F = new Timer();
        if (this.G == null) {
            this.G = new TimerTask() { // from class: com.baidu.ar.track.a.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.ax != null) {
                        a.this.ax.sendEmptyMessage(303);
                    }
                }
            };
        }
        this.F.schedule(this.G, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        C();
        this.H = new Timer();
        if (this.I == null) {
            this.I = new TimerTask() { // from class: com.baidu.ar.track.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.ax != null) {
                        a.this.ax.sendEmptyMessage(309);
                    }
                }
            };
        }
        this.H.schedule(this.I, 3000L);
    }

    private void aq() {
        a(this.g, Orientation.PORTRAIT, true);
        a(this.j, Orientation.PORTRAIT, true);
        a(this.h, Orientation.PORTRAIT, true);
        a(this.e, Orientation.PORTRAIT, true);
        a(this.p, Orientation.PORTRAIT, true);
        o.a(0);
        ar();
    }

    private void ar() {
        if (this.q != null) {
            this.q.setAngle(0);
            this.s = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            this.s.gravity = 81;
            this.s.bottomMargin = this.V;
            this.s.leftMargin = 0;
            this.s.rightMargin = 0;
        }
        if (this.t != null) {
            this.t.setAngle(0);
        }
        if (this.as != null) {
            this.as.setAngle(0);
        }
        if (this.w != null) {
            this.w.setAngle(0);
        }
        if (this.y != null) {
            this.y.setAngle(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = this.V;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void as() {
        a(this.g, Orientation.LANDSCAPE, true);
        a(this.j, Orientation.LANDSCAPE, true);
        a(this.h, Orientation.LANDSCAPE, true);
        a(this.e, Orientation.LANDSCAPE, true);
        a(this.p, Orientation.LANDSCAPE, true);
        o.a(-90);
        at();
    }

    private void at() {
        if (this.q != null) {
            this.q.setAngle(-90);
            this.s = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            this.s.gravity = 16;
            this.s.leftMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            this.s.bottomMargin = 0;
        }
        if (this.t != null) {
            this.t.setAngle(-90);
        }
        if (this.as != null) {
            this.as.setAngle(-90);
        }
        if (this.w != null) {
            this.w.setAngle(-90);
        }
        if (this.y != null) {
            this.y.setAngle(-90);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams.gravity = 16;
            layoutParams.leftMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            layoutParams.bottomMargin = 0;
        }
    }

    private void au() {
        a(this.g, Orientation.LANDSCAPE_REVERSE, true);
        a(this.j, Orientation.LANDSCAPE_REVERSE, true);
        a(this.h, Orientation.LANDSCAPE_REVERSE, true);
        a(this.e, Orientation.LANDSCAPE_REVERSE, true);
        a(this.p, Orientation.LANDSCAPE_REVERSE, true);
        o.a(90);
        av();
    }

    private void av() {
        if (this.q != null) {
            this.q.setAngle(90);
            this.s = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            this.s.gravity = 21;
            this.s.rightMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            this.s.bottomMargin = 0;
        }
        if (this.t != null) {
            this.t.setAngle(90);
        }
        if (this.as != null) {
            this.as.setAngle(90);
        }
        if (this.w != null) {
            this.w.setAngle(90);
        }
        if (this.y != null) {
            this.y.setAngle(90);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams.gravity = 21;
            layoutParams.rightMargin = Res.getDimensionPixelSize("bdar_icon_margin_edge");
            layoutParams.bottomMargin = 0;
        }
    }

    private d b(com.baidu.ar.bean.b bVar) {
        d dVar = new d();
        String str = bVar.a() + File.separator + bVar.b();
        com.baidu.ar.util.b.a("szModelFile = " + str);
        int c = bVar.c();
        int d = bVar.d();
        int[] iArr = {(int) (bVar.g().a - (bVar.c() / 2)), (int) (bVar.g().b - (bVar.d() / 2)), bVar.c(), bVar.d()};
        dVar.c = c;
        dVar.d = d;
        dVar.b = str;
        dVar.a = iArr;
        return dVar;
    }

    private void b(d dVar) {
        if (this.az == null) {
            this.az = new com.baidu.ar.a.c.b(dVar);
        }
    }

    @Override // com.baidu.ar.c
    protected void A() {
        if (this.R) {
            if (this.ax != null) {
                this.ax.sendEmptyMessage(HttpStatus.SC_USE_PROXY);
            }
        } else if (this.S) {
            TrackStateMachine.a().d(TrackStateMachine.EVENT.VIDEO_PREVIEW_IMAGE_CAPTURE_FINISH, null);
        }
    }

    @Override // com.baidu.ar.c
    protected void U() {
        TrackStateMachine.a().d(TrackStateMachine.EVENT.VIDEO_RECORD_STOP_AND_ABANDON, null);
    }

    @Override // com.baidu.ar.c
    protected void V() {
        if (this.W) {
            TrackStateMachine.a().d(TrackStateMachine.EVENT.VIDEO_RECORD_STOP_AND_SAVE_FINISH, null);
        }
    }

    @Override // com.baidu.ar.c
    public void W() {
        if (this.ax != null) {
            this.ax.sendEmptyMessage(601);
        }
    }

    public Bitmap a(BitmapFactory.Options options, boolean z, String str) {
        float f;
        int i;
        int i2;
        float f2 = ((options.outWidth * 1.0f) / options.outHeight) * 1.0f;
        if (z) {
            f = options.outWidth / 500;
            i2 = 500;
            i = (int) (500 / f2);
        } else {
            f = options.outHeight / 900;
            i = 900;
            i2 = (int) (900 * f2);
        }
        options.outWidth = i2;
        options.outHeight = i;
        options.inSampleSize = (int) f;
        return BitmapFactory.decodeFile(str, options);
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void a(int i, String[] strArr, int[] iArr) {
        super.a(i, strArr, iArr);
    }

    @Override // com.baidu.ar.c
    protected void a(Activity activity, FrameLayout frameLayout) {
        this.a = Res.inflate("bdar_layout_gui_track");
        frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        aj();
        ak();
        this.av = (RotateImageView) this.a.findViewById(Res.id("bdar_gui_image_trigger_picture"));
        this.a.findViewById(Res.id("bdar_transparent_layer")).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.track.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (a.this.ar == null || !a.this.ar.isShown()) {
                    return false;
                }
                a.this.ar.setVisibility(8);
                return false;
            }
        });
        com.baidu.ar.util.b.c("bdar: launchMode = " + this.am.getARLaunchMode());
        if (this.am.getARLaunchMode() == 2) {
            if (this.h != null) {
                this.h.setVisibility(8);
            }
            if (this.p != null) {
                this.p.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.ay) {
            return;
        }
        this.ay = true;
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d, com.baidu.ar.h.b
    public void a(ARResource aRResource) {
        super.a(aRResource);
        this.J.a(aRResource);
        if (this.j != null) {
            this.j.setOnClickListener(this);
        }
        TrackStateMachine.a().a(TrackStateMachine.EVENT.QUERY_RES_SUCCESS);
    }

    @Override // com.baidu.ar.h.b
    public void ai() {
        TrackStateMachine.a().a(TrackStateMachine.EVENT.QUERY_RES_START);
    }

    @Override // com.baidu.ar.c
    protected void b(Bitmap bitmap) {
        if (this.ax != null) {
            Message message = new Message();
            message.what = 304;
            message.obj = bitmap;
            this.ax.sendMessage(message);
        }
    }

    @Override // com.baidu.ar.c
    public void b(f fVar) {
        a(this.ax, fVar);
    }

    @Override // com.baidu.ar.c
    protected void c(int i) {
        if (this.ax != null) {
            Message obtainMessage = this.ax.obtainMessage();
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            bundle.putInt(WBPageConstants.ParamKey.COUNT, i);
            obtainMessage.setData(bundle);
            this.ax.sendMessage(obtainMessage);
        }
    }

    @Override // com.baidu.ar.c
    protected void c(byte[] bArr, f fVar) {
        if (this.az != null) {
            com.baidu.ar.a.a.a(bArr, this.c.a, this.c.b, this.az, this.aA);
        }
    }

    @Override // com.baidu.ar.c
    protected void d() {
        TrackStateMachine.a().a(TrackStateMachine.EVENT.QUERY_RES_START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void d(boolean z) {
        super.d(z);
        if (z) {
            a(this.g, 4);
            a(this.e, 4);
            if (this.am.getARLaunchMode() == 2) {
                a(this.p, 4);
            } else {
                a(this.h, 4);
            }
            TrackStateMachine.a().d(TrackStateMachine.EVENT.VIDEO_RECORD_START, null);
            return;
        }
        a(this.g, 0);
        a(this.e, 0);
        if (this.am.getARLaunchMode() == 2) {
            a(this.p, 0);
        } else {
            a(this.h, 0);
        }
    }

    @Override // com.baidu.ar.c, com.baidu.ar.h.b
    public void e(String str) {
        com.baidu.ar.h.a.a().a("download_3d_res_success");
        if (TextUtils.isEmpty(str)) {
            y();
            J();
            Activity activity = this.af != null ? this.af.get() : null;
            if (activity != null) {
                com.baidu.ar.ui.c.a(this.ag, activity, Res.getString("bdar_error_unzip"), 1).a();
                return;
            }
            return;
        }
        String str2 = str + File.separator + Constants.AR_UNZIP_ROOT_DIR;
        String concat = str2.concat(File.separator).concat(Constants.TARGET_FILE);
        String concat2 = str2.concat(File.separator).concat(Constants.VOICE_FILE);
        if (concat != null) {
            try {
                if (new File(concat).exists()) {
                    e a = com.baidu.ar.e.a.a(com.baidu.ar.util.d.a(this.ag, concat), concat);
                    this.K = a;
                    a(a);
                    this.aw = a(a, str2);
                    if (this.K != null && this.K.a() != null) {
                        try {
                            HashMap<String, Object> a2 = c.a(this.K.a().get(0));
                            System.out.print("initCase in track: " + Arrays.toString(a2.entrySet().toArray()) + "\n");
                            com.baidu.ar.h.a.a().a("start_loading_3d_model");
                            ArBridge.getInstance().createCase(str2, a2, this.c.b, this.c.a);
                            a(b(this.K.a().get(0)));
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            com.baidu.ar.util.b.d("NullPointerException When parseResource!!!!!");
                        }
                    }
                    com.baidu.ar.arspeech.b.a(this.ag).a(concat2);
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                y();
                J();
                Activity activity2 = this.af != null ? this.af.get() : null;
                if (activity2 != null) {
                    com.baidu.ar.ui.c.a(this.ag, activity2, Res.getString("bdar_error_json_parser"), 1).a();
                    return;
                }
                return;
            }
        }
        y();
        J();
        Activity activity3 = this.af != null ? this.af.get() : null;
        if (activity3 != null) {
            com.baidu.ar.ui.c.a(this.ag, activity3, Res.getString("bdar_error_json_parser"), 1).a();
        }
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void l() {
        super.l();
        if (this.ax == null) {
            this.ax = new b(this);
        }
        TrackStateMachine.a().a(this.ax);
        TrackStateMachine.a(TrackStateMachine.STATE.RESUME);
        if (this.O) {
            com.baidu.ar.h.a.a().a("resume_ar");
        }
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void m() {
        super.m();
        if (this.ax != null) {
            this.ax.removeCallbacksAndMessages(null);
            this.ax.a();
            this.ax = null;
        }
        TrackStateMachine.a().a((Handler) null);
        TrackStateMachine.a(TrackStateMachine.STATE.PAUSE);
        if (this.O) {
            com.baidu.ar.h.a.a().a("interrupt_ar");
        }
        D();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void n() {
        super.n();
        TrackStateMachine.a(TrackStateMachine.STATE.DESTROY);
        TrackStateMachine.d();
        if (this.a != null) {
            this.a.setBackgroundColor(0);
        }
        if (this.aw != null) {
            this.aw.recycle();
            this.aw = null;
        }
        if (this.az != null) {
            this.az.a();
            this.az = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == Res.id("bdar_titlebar_back")) {
            v();
        }
        if (K()) {
            if (view2.getId() == Res.id("bdar_titlebar_close")) {
                this.ar.setVisibility(8);
                u();
            } else if (view2.getId() == Res.id("bdar_titlebar_flash")) {
                this.ar.setVisibility(8);
                w();
            } else if (view2.getId() == Res.id("bdar_gui_capture")) {
                P();
            } else if (view2.getId() == Res.id("bdar_popmenu_item1")) {
                this.ar.setVisibility(8);
                b("https://dusee.baidu.com/artrack/article/articlelist");
            } else if (view2.getId() == Res.id("bdar_popmenu_item2")) {
                this.ar.setVisibility(8);
                b("https://dusee.baidu.com/static/site/pages/intro/index.html");
            } else if (view2.getId() != Res.id("bdar_titlebar_more")) {
                if (view2.getId() == Res.id("bdar_gui_rescan")) {
                    a(view2);
                }
            } else if (TextUtils.isEmpty(ARConfiguration.getAccessKey())) {
                this.ar.setVisibility(this.ar.isShown() ? 8 : 0);
            } else {
                String string = Res.getString("bdar_more_information_url");
                if (Patterns.WEB_URL.matcher(string).matches()) {
                    b(string);
                } else {
                    com.baidu.ar.util.b.d("url is error");
                }
            }
        }
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void r() {
        super.r();
        aq();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void s() {
        super.s();
        as();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void t() {
        super.t();
        au();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public boolean v() {
        if (super.v()) {
            return true;
        }
        u();
        return true;
    }
}
