package com.baidu.ar.slam;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.a;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.d;
import com.baidu.ar.bean.e;
import com.baidu.ar.d.b;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.f.f;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.ui.ARWebView;
import com.baidu.ar.ui.LoadingView;
import com.baidu.ar.ui.SlamPlaneLevelView;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.n;
import com.baidu.ar.util.o;
import com.baidu.baiduarsdk.ArBridge;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.c implements View.OnClickListener, View.OnLayoutChangeListener {
    private RelativeLayout aA;
    private TextView aB;
    private RelativeLayout aC;
    private LinearLayout aD;
    private ImageView aE;
    private int aF;
    private int aG;
    private Timer aH;
    private TimerTask aI;
    private Timer aJ;
    private TimerTask aK;
    private c aL;
    private boolean aM;
    private boolean aN;
    private String aO;
    private boolean aP;
    private String aQ;
    private String aR;
    private boolean aS;
    private boolean aT;
    private boolean aU;
    private com.baidu.slamlibrary.b aV;
    private boolean aW;
    private float aX;
    private C0036a aY;
    private b aZ;
    protected ARWebView ar;
    private RelativeLayout as;
    private LinearLayout at;
    private RotateImageView au;
    private RotateImageView av;
    private RotateImageView aw;
    private RotateImageView ax;
    private Button ay;
    private SlamPlaneLevelView az;
    private ARWebView.c ba;
    private boolean bb;
    private boolean bc;

    /* renamed from: com.baidu.ar.slam.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0036a implements com.baidu.ar.a.a.a {
        @Override // com.baidu.ar.a.a.a
        public void a(Bundle bundle) {
            SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_PLANE_LEVEL, bundle);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements com.baidu.ar.a.a.a {
        private int a = 0;

        public void a(int i) {
            this.a = i;
        }

        @Override // com.baidu.ar.a.a.a
        public void a(Bundle bundle) {
            SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_TRACK_QUALITY, bundle);
            if (this.a >= 3) {
                SlamStateMachine.a().a(bundle);
            } else {
                this.a++;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        private WeakReference<a> a;

        public c(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 500:
                    aVar.L.a(0);
                    return;
                case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                    aVar.as();
                    return;
                case HttpStatus.SC_BAD_GATEWAY /* 502 */:
                default:
                    return;
                case HttpStatus.SC_GATEWAY_TIMEOUT /* 504 */:
                    if (aVar.j != null) {
                        aVar.a((Bitmap) message.obj);
                        return;
                    }
                    return;
                case HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED /* 505 */:
                    if (aVar.d != null) {
                        aVar.d.a();
                    }
                    MediaScannerConnection.scanFile(aVar.ag, new String[]{o.b()}, null, null);
                    return;
                case 506:
                    aVar.y();
                    break;
                case 508:
                    aVar.L.a();
                    return;
                case 510:
                    aVar.aE();
                    return;
                case 512:
                    break;
                case InputDeviceCompat.SOURCE_DPAD /* 513 */:
                    aVar.ax.setVisibility(8);
                    aVar.aD();
                    aVar.aM = true;
                    if (!aVar.aM || aVar.aN) {
                        return;
                    }
                    aVar.x();
                    return;
                case 514:
                    aVar.g(Constants.SLAM_PLANE_ERROR);
                    return;
                case 515:
                    aVar.g(Constants.SLAM_PLANE_BAD);
                    return;
                case 516:
                    aVar.g(Constants.SLAM_PLANE_GOOD);
                    return;
                case 517:
                    if (aVar.aN) {
                        aVar.g(Constants.SLAM_PLANE_PERFECT);
                        return;
                    }
                    return;
                case 518:
                    aVar.h(aVar.aR);
                    return;
                case 519:
                    aVar.e(message.getData());
                    return;
                case 520:
                    if (aVar.aP || !aVar.aS) {
                        return;
                    }
                    aVar.h(aVar.aR);
                    aVar.az.b();
                    aVar.aw.setEnabled(false);
                    aVar.aS = false;
                    return;
                case 521:
                    if (aVar.aP || aVar.aS) {
                        return;
                    }
                    aVar.aS = true;
                    aVar.g(Constants.SLAM_PLANE_ERROR);
                    return;
                case 522:
                    com.baidu.ar.h.a.a().a("slam_track_loss_replace");
                    aVar.am();
                    aVar.aF();
                    return;
                case 523:
                    aVar.aT = true;
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
            }
            long unused = a.P = System.currentTimeMillis();
            aVar.y();
            if (aVar.ab) {
                aVar.as();
            }
        }
    }

    public a(BaseFragment baseFragment, a.C0024a c0024a) {
        super(baseFragment, c0024a);
        this.aM = false;
        this.aN = false;
        this.aP = false;
        this.aS = true;
        this.aT = false;
        this.aU = false;
        this.aY = new C0036a();
        this.aZ = new b();
        this.ba = new ARWebView.c() { // from class: com.baidu.ar.slam.a.3
            @Override // com.baidu.ar.ui.ARWebView.c
            public void b() {
                a.this.aA();
            }

            @Override // com.baidu.ar.ui.ARWebView.c
            public void c() {
                a.this.aA();
            }

            @Override // com.baidu.ar.ui.ARWebView.c
            public void d() {
                a.this.y();
                a.this.ar.setVisibility(0);
            }
        };
        this.bb = false;
        this.bc = true;
        Res.addResource(this.ag);
        SlamStateMachine.a().c();
        SlamStateMachine.a().a(this.Q);
        this.Q.a(new b.a() { // from class: com.baidu.ar.slam.a.1
            @Override // com.baidu.ar.d.b.a
            public void a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                SlamStateMachine.a().c(SlamStateMachine.EVENT.UPDATE_RT_MATRIX, bundle);
            }
        });
        this.Q.a(0);
        this.Q.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        this.as.removeView(this.at);
        this.at = null;
        this.ar = null;
    }

    private void aB() {
        ARConfiguration ac = ac();
        if (ac == null || this.K == null || this.K.b() == null) {
            return;
        }
        String aRKey = ac.getARKey();
        if (TextUtils.isEmpty(aRKey)) {
            return;
        }
        if (!com.baidu.ar.util.a.b.a(this.ag, aRKey)) {
            y();
            return;
        }
        ar();
        com.baidu.ar.util.a.b.a(this.ag, aRKey, false);
    }

    private void aC() {
        this.aH = new Timer();
        if (this.aI == null) {
            this.aI = new TimerTask() { // from class: com.baidu.ar.slam.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aL != null) {
                        a.this.aL.sendEmptyMessage(InputDeviceCompat.SOURCE_DPAD);
                    }
                }
            };
        }
        this.aH.schedule(this.aI, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD() {
        if (this.aH != null) {
            this.aH.cancel();
            this.aH.purge();
            this.aH = null;
        }
        if (this.aI != null) {
            this.aI.cancel();
            this.aI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        this.aJ = new Timer();
        if (this.aK == null) {
            this.aK = new TimerTask() { // from class: com.baidu.ar.slam.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aL != null) {
                        a.this.aL.sendEmptyMessage(522);
                    }
                }
            };
        }
        this.aJ.schedule(this.aK, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        if (this.aJ != null) {
            this.aJ.cancel();
            this.aJ.purge();
            this.aJ = null;
        }
        if (this.aK != null) {
            this.aK.cancel();
            this.aK = null;
        }
    }

    private void aw() {
        this.g = (RotateImageView) this.as.findViewById(Res.id("bdar_titlebar_back"));
        this.g.setOnClickListener(this);
        this.au = (RotateImageView) this.as.findViewById(Res.id("bdar_titlebar_help_tip"));
        this.au.setOnClickListener(this);
        this.av = (RotateImageView) this.as.findViewById(Res.id("bdar_gui_reset"));
        this.av.setOnClickListener(this);
        this.av.setVisibility(8);
        this.w = (RotateViewGroup) this.as.findViewById(Res.id("bdar_id_loading_group"));
        this.x = (LoadingView) this.as.findViewById(Res.id("bdar_id_loading"));
        this.w.a();
        y();
        this.aC = (RelativeLayout) this.as.findViewById(Res.id("bdar_gesture_guide_layout"));
        this.aC.setOnClickListener(this);
        this.aD = (LinearLayout) this.as.findViewById(Res.id("bdar_wrapper_gesture_guide_layout"));
        this.aE = (ImageView) this.as.findViewById(Res.id("bdar_gesture_guide"));
        this.ay = (Button) this.as.findViewById(Res.id("bdar_btn_dismiss_gesture"));
        this.ay.setOnClickListener(this);
        this.aw = (RotateImageView) this.as.findViewById(Res.id("bdar_gui_place_model"));
        this.aw.setOnClickListener(this);
        this.aw.setEnabled(false);
        this.az = (SlamPlaneLevelView) this.as.findViewById(Res.id("bdar_slam_plane_level_light"));
        this.aA = (RelativeLayout) this.as.findViewById(Res.id("bdar_slam_indicate_relativelayout"));
        this.aB = (TextView) this.as.findViewById(Res.id("bdar_slam_track_lost_tip"));
        this.ax = (RotateImageView) this.as.findViewById(Res.id("bdar_rotate_screen"));
        this.j = (RotateImageView) this.as.findViewById(Res.id("bdar_gui_capture"));
        this.j.setOnClickListener(this);
        this.j.setEnabled(false);
        ax();
        az();
        this.aC.addOnLayoutChangeListener(this);
    }

    private void ax() {
        this.g.b();
        this.au.b();
        this.av.b();
        this.aw.b();
        this.j.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        this.aF = this.as.getWidth();
        this.aG = this.as.getHeight();
    }

    private void az() {
        this.ax.setVisibility(0);
        this.aM = false;
        aC();
    }

    @Override // com.baidu.ar.c
    protected void A() {
        if (this.R) {
            if (this.aL != null) {
                this.aL.sendEmptyMessage(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
            }
        } else if (this.S) {
            SlamStateMachine.a().d(SlamStateMachine.EVENT.VIDEO_PREVIEW_IMAGE_CAPTURE_FINISH, null);
        }
    }

    @Override // com.baidu.ar.c
    protected void U() {
        SlamStateMachine.a().d(SlamStateMachine.EVENT.VIDEO_RECORD_STOP_AND_ABANDON, null);
    }

    @Override // com.baidu.ar.c
    protected void V() {
        if (this.W) {
            SlamStateMachine.a().d(SlamStateMachine.EVENT.VIDEO_RECORD_STOP_AND_SAVE_FINISH, null);
        }
    }

    @Override // com.baidu.ar.c
    public void W() {
        if (this.aL != null) {
            this.aL.sendEmptyMessage(601);
        }
    }

    public void a(float f) {
        this.aX = f;
        if (this.aV != null) {
            this.aV.a(this.aX);
        }
    }

    @Override // com.baidu.ar.c
    protected void a(Activity activity, FrameLayout frameLayout) {
        this.as = (RelativeLayout) Res.inflate("bdar_layout_gui_slam");
        this.a = this.as;
        frameLayout.addView(this.as, new FrameLayout.LayoutParams(-1, -1));
        aw();
        frameLayout.post(new Runnable() { // from class: com.baidu.ar.slam.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.ay();
            }
        });
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d, com.baidu.ar.h.b
    public void a(ARResource aRResource) {
        super.a(aRResource);
        this.J.a(aRResource);
        if (this.j != null) {
            this.j.setOnClickListener(this);
        }
        SlamStateMachine.a().a(SlamStateMachine.EVENT.QUERY_RES_SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(f fVar) {
        super.a(fVar);
        if (this.aP) {
            if (this.ab) {
                this.ab = false;
            } else {
                ak();
            }
        }
    }

    @Override // com.baidu.ar.h.b
    public void ai() {
        SlamStateMachine.a().a(SlamStateMachine.EVENT.QUERY_RES_START);
    }

    public void aj() {
        if (this.aL != null) {
            this.aL.removeCallbacksAndMessages(null);
            this.aL.a();
            this.aL = null;
        }
    }

    public void ak() {
        av();
        this.aw.setEnabled(true);
        this.ap.a(false);
        ArBridge.getInstance().reset();
        this.aP = false;
        this.aZ.a(0);
        SlamStateMachine.a().b(true);
        this.bc = true;
    }

    public void al() {
        ap();
        this.av.setVisibility(8);
        this.aw.setEnabled(true);
        this.aw.setVisibility(0);
        this.j.setVisibility(8);
        this.j.setEnabled(false);
        this.au.setVisibility(0);
        this.i.setVisibility(8);
    }

    public void am() {
        if (this.S) {
            return;
        }
        com.baidu.ar.h.a.a().a("slam_replace");
        al();
        av();
        this.aw.setEnabled(true);
        this.ap.a(false);
        ArBridge.getInstance().reset();
        this.aP = false;
        this.aZ.a(0);
        SlamStateMachine.a().b(true);
        this.bc = true;
        if (this.i != null) {
            this.i.setVisibility(8);
        }
    }

    public void an() {
        com.baidu.ar.h.a.a().a("slam_placeBtn_click");
        this.aP = true;
        h(true);
        ArBridge.getInstance().setRenderMode(0);
        SlamStateMachine.a().b(false);
        a(this.Q.f());
        this.ap.a(true);
        this.av.setVisibility(0);
        this.av.setEnabled(true);
        aq();
        this.aw.setEnabled(false);
        this.aw.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setEnabled(true);
        at();
        ao();
        this.au.setVisibility(8);
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    public void ao() {
        ARConfiguration ac = ac();
        if (ac == null || this.K == null || this.K.b() == null) {
            return;
        }
        String aRKey = ac.getARKey();
        if (TextUtils.isEmpty(aRKey)) {
            return;
        }
        String str = aRKey + "_show_guesture_guide";
        if (com.baidu.ar.util.a.b.b(this.ag, str)) {
            b(this.aC, 90);
            this.aC.setVisibility(0);
            com.baidu.ar.util.a.b.b(this.ag, str, false);
        }
    }

    public void ap() {
        b(this.aA, 90);
        this.az.setVisibility(0);
        this.aB.setVisibility(0);
        this.aB.setText(this.aQ);
    }

    public void aq() {
        this.az.setVisibility(4);
    }

    public void ar() {
        com.baidu.ar.h.a.a().a("slam_userguide_click");
        ARConfiguration ac = ac();
        if (ac == null || this.K == null || this.K.b() == null || TextUtils.isEmpty(ac.getARKey()) || TextUtils.isEmpty(this.aO) || !Patterns.WEB_URL.matcher(this.aO).matches()) {
            return;
        }
        h();
        b(this.ar, 90);
    }

    public void as() {
        this.aN = true;
        if (this.ax.getVisibility() == 0) {
            this.ax.setVisibility(8);
        }
        au();
        y();
        aB();
        ap();
        this.au.setVisibility(0);
        this.aw.setEnabled(true);
    }

    public void at() {
        this.aB.setVisibility(8);
    }

    public void au() {
        if (this.aV == null) {
            this.aV = new com.baidu.slamlibrary.b(this.c.a, this.c.b, false);
        }
        this.aV.a();
    }

    public void av() {
        h(false);
        this.aV.b();
        ArBridge.getInstance().setRenderMode(1);
    }

    @Override // com.baidu.ar.c
    protected void b(Bitmap bitmap) {
        if (this.aL != null) {
            Message message = new Message();
            message.what = HttpStatus.SC_GATEWAY_TIMEOUT;
            message.obj = bitmap;
            this.aL.sendMessage(message);
        }
    }

    public void b(View view2, int i) {
        view2.setLayoutParams(new LinearLayout.LayoutParams(this.aG, this.aF));
        view2.setRotation(i);
        view2.setY((this.aG - this.aF) / 2);
        view2.setX((this.aF - this.aG) / 2);
    }

    public void b(e eVar) {
        if (eVar == null || eVar.b() == null) {
            return;
        }
        d b2 = eVar.b();
        if (TextUtils.isEmpty(b2.h())) {
            this.aQ = Res.getString("bdar_find_perfect_plane");
        } else {
            this.aQ = b2.h();
        }
        if (TextUtils.isEmpty(b2.i())) {
            this.aR = Res.getString("bdar_align_plane");
        } else {
            this.aR = b2.i();
        }
        if (TextUtils.isEmpty(b2.g())) {
            return;
        }
        this.aO = b2.g();
    }

    @Override // com.baidu.ar.c
    public void b(f fVar) {
        a(this.aL, fVar);
    }

    @Override // com.baidu.ar.c
    protected void c(int i) {
        if (this.aL != null) {
            Message obtainMessage = this.aL.obtainMessage();
            obtainMessage.what = 600;
            Bundle bundle = new Bundle();
            bundle.putInt(WBPageConstants.ParamKey.COUNT, i);
            obtainMessage.setData(bundle);
            this.aL.sendMessage(obtainMessage);
        }
    }

    @Override // com.baidu.ar.c
    protected void c(byte[] bArr, f fVar) {
        if (this.aV != null) {
            if (this.aW) {
                com.baidu.ar.a.a.a(bArr, this.c.a, this.c.b, this.aV, this.aZ);
            } else {
                com.baidu.ar.a.a.a(bArr, this.c.a, this.c.b, this.aY);
            }
        }
    }

    @Override // com.baidu.ar.c
    protected void d() {
        SlamStateMachine.a().a(SlamStateMachine.EVENT.QUERY_RES_START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void d(boolean z) {
        super.d(z);
        if (!z) {
            a(this.g, 0);
            a(this.av, 0);
            return;
        }
        a(this.g, 4);
        a(this.av, 4);
        SlamStateMachine.a().d(SlamStateMachine.EVENT.VIDEO_RECORD_START, null);
    }

    public void e(Bundle bundle) {
        int i = bundle.getInt(Constants.SLAM_TRACK_QUALITY);
        int i2 = (int) (1000.0f / bundle.getFloat(Constants.SLAM_PROCESS_TIME));
        if (i != 1) {
            if (this.bb) {
                return;
            }
            this.bb = true;
            aE();
            com.baidu.ar.h.a.a().a("slam_track_loss");
        } else if (this.bb) {
            this.bb = false;
            aF();
            com.baidu.ar.h.a.a().a("slam_retrack_on");
        } else if (this.bc) {
            com.baidu.ar.h.a.a().a("slam_track_on");
            this.bc = false;
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
                    b(a);
                    if (this.K != null && this.K.a() != null) {
                        try {
                            HashMap<String, Object> a2 = com.baidu.ar.c.a(this.K.a().get(0));
                            System.out.print("initCase in track: " + Arrays.toString(a2.entrySet().toArray()) + "\n");
                            com.baidu.ar.h.a.a().a("start_loading_3d_model");
                            ArBridge.getInstance().createCase(str2, a2, this.Z, this.Y);
                            SlamStateMachine.a().b(true);
                            this.ap.a(false);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            com.baidu.ar.util.b.d("NullPointerException When parseResource!!!!!");
                        }
                    }
                    com.baidu.ar.arspeech.b.a(this.ag).a(concat2);
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.DOWNLOAD_RES_FINISH);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void g() {
        super.g();
    }

    public void g(int i) {
        if (this.aS) {
            if (i == Constants.SLAM_PLANE_ERROR) {
                this.aP = false;
                this.az.b();
                h(this.aQ);
                this.aw.setEnabled(false);
            } else if (i == Constants.SLAM_PLANE_BAD) {
                this.az.c();
                this.aP = false;
                this.aw.setEnabled(false);
                h(this.aQ);
            } else if (i == Constants.SLAM_PLANE_GOOD) {
                this.aP = false;
                this.aw.setEnabled(false);
                this.az.d();
                h(this.aQ);
            } else if (i == Constants.SLAM_PLANE_PERFECT && this.aS) {
                this.aP = true;
                this.aw.setEnabled(true);
                this.az.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.at == null) {
            this.at = new LinearLayout(this.ag);
            this.as.addView(this.at, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            this.ar = new ARWebView(this.ag);
            this.at.addView(this.ar, layoutParams2);
            this.ar.setWebViewCallcack(this.ba);
            this.ar.a(this.aO);
        }
    }

    public void h(String str) {
        this.aB.setText(str);
        this.aB.setVisibility(0);
    }

    public void h(boolean z) {
        if (this.aW != z) {
            SlamStateMachine.a().a(z);
        }
        this.aW = z;
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void l() {
        super.l();
        if (this.aL == null) {
            this.aL = new c(this);
        }
        SlamStateMachine.a().a(this.aL);
        SlamStateMachine.a();
        SlamStateMachine.a(SlamStateMachine.STATE.RESUME);
        if (!this.aP || this.ab) {
            return;
        }
        al();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void m() {
        super.m();
        SlamStateMachine.a().a((Handler) null);
        SlamStateMachine.a(SlamStateMachine.STATE.PAUSE);
        D();
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public void n() {
        super.n();
        if (this.aV != null) {
            this.aV.c();
            this.aV = null;
        }
        SlamStateMachine.a(SlamStateMachine.STATE.DESTROY);
        SlamStateMachine.d();
        aj();
        if (this.as != null) {
            this.as.setBackgroundColor(0);
        }
        aF();
        aD();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == Res.id("bdar_titlebar_back")) {
            v();
        } else if (id == Res.id("bdar_titlebar_help_tip")) {
            ar();
        } else if (id == Res.id("bdar_gui_reset")) {
            com.baidu.ar.h.a.a().a("slam_replaceBtn_click");
            am();
        } else if (id == Res.id("bdar_btn_dismiss_gesture")) {
            this.aC.setVisibility(8);
        } else if (id == Res.id("bdar_gui_place_model")) {
            an();
        } else if (id == Res.id("bdar_gui_capture")) {
            P();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ay();
        this.aC.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aD.requestLayout();
        b(this.aC, 90);
    }

    @Override // com.baidu.ar.c, com.baidu.ar.d
    public boolean v() {
        if (super.v()) {
            return true;
        }
        u();
        return true;
    }

    @Override // com.baidu.ar.c, com.baidu.ar.h.b
    public void x() {
        if (!this.aM || this.aN || this.aT) {
            return;
        }
        n.a(new Runnable() { // from class: com.baidu.ar.slam.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.x != null) {
                    a.this.x.setMsg(Res.getString("bdar_loading"));
                    a.this.x.show();
                }
            }
        });
    }
}
