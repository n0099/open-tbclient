package com.baidu.ar.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.ar.ARFragment;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.BrowserBean;
import com.baidu.ar.bean.TipBean;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.paddle.ARPaddleHelper;
import com.baidu.ar.paddle.PaddleController;
import com.baidu.ar.paddle.PaddleManager;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.ViewUtils;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public abstract class c implements View.OnClickListener, com.baidu.ar.c.c, OrientationManager.OrientationListener, k {
    private static long G = 300;
    private f A;
    private LinearLayout B;
    private k D;
    private com.baidu.ar.b E;
    private com.baidu.ar.c.c J;
    protected ViewGroup a;
    protected Timer b;
    protected TimerTask c;
    protected Timer d;
    protected TimerTask e;
    protected String g;
    protected String h;
    protected String i;
    protected String j;
    protected CaptureUI o;
    protected ARFragment q;
    protected Activity r;
    protected Context s;
    protected d t;
    protected b u;
    protected h v;
    protected o w;
    private Bitmap y;
    private boolean x = false;
    private boolean z = false;
    protected boolean f = false;
    protected int k = 0;
    protected int l = 0;
    protected int m = 1;
    protected int n = 2;
    private long F = 0;
    private boolean H = false;
    private boolean I = true;
    private a C = new a(this);
    protected l p = new l();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements DuMixCallback {
        private WeakReference<c> a;

        a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseChange(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onCaseChange result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreated(ARResource aRResource) {
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            if ((this.a != null && this.a.get() != null && this.a.get().s()) || this.a == null || this.a.get() == null) {
                return;
            }
            if (this.a.get().A != null) {
                this.a.get().A.a(hashMap);
            }
            if (this.a.get().t != null) {
                this.a.get().t.a(hashMap);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onPause(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onPause result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onRelease result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onReset(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onReset result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onResume(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onResume result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onSetup result: " + z);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onStateChange(final int i, final Object obj) {
            if (this.a == null || this.a.get() == null || !this.a.get().s()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a == null || a.this.a.get() == null || ((c) a.this.a.get()).D == null) {
                            return;
                        }
                        ((c) a.this.a.get()).D.a(i, obj);
                    }
                });
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onStateError(int i, String str) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().e("onStateError error: " + i + " msg:" + str);
        }
    }

    public c(ViewGroup viewGroup, com.baidu.ar.b bVar, ARResource aRResource) {
        this.a = viewGroup;
        this.E = bVar;
        this.q = bVar.h();
        this.r = this.q.getActivity();
        this.s = this.r.getApplicationContext();
        a((k) this);
        this.B = new LinearLayout(viewGroup.getContext());
        viewGroup.addView(this.B);
        this.A = new f(this.s, this.E, this.r);
        this.A.a(this.B);
        this.J = this;
        bVar.j().a(this.J);
        this.o = new CaptureUI(this.r, this.a, this.E, this, aRResource);
        this.o.a(new p() { // from class: com.baidu.ar.ui.c.1
            @Override // com.baidu.ar.ui.p
            public void a(boolean z) {
                ARLog.d("isFornt = " + z);
                c.this.H = z;
                if (c.this.A != null) {
                    if (c.this.H) {
                        c.this.A.a();
                    } else {
                        c.this.A.b();
                    }
                }
                PaddleManager.getInstance().notifyIsSharing(z);
            }
        });
        this.v = new h(this);
        this.t = new d(this);
        this.u = new b(this);
        this.w = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (!this.x) {
            p();
        } else if (this.y == null) {
            p();
        } else {
            this.p.f().setVisibility(0);
            this.p.f().setImageBitmap(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (s()) {
            return;
        }
        r();
        this.b = new Timer();
        if (this.c == null) {
            this.c = new TimerTask() { // from class: com.baidu.ar.ui.c.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.d(c.this.j);
                    c.this.y();
                }
            };
        }
        this.b.schedule(this.c, 5000L);
    }

    private void a(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10103);
        hashMap.put(ComponentMessageType.MSG_TRACK_TIPS_TYPE, Integer.valueOf(i));
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void a(TrackRes trackRes) {
        if (trackRes == null || trackRes.getTipBean() == null) {
            return;
        }
        TipBean tipBean = trackRes.getTipBean();
        if (TextUtils.isEmpty(tipBean.getHint())) {
            this.g = null;
        } else {
            this.g = tipBean.getHint();
        }
        if (TextUtils.isEmpty(tipBean.getTooFarHint())) {
            this.h = null;
        } else {
            this.h = tipBean.getTooFarHint();
        }
        if (TextUtils.isEmpty(tipBean.getTooNearHint())) {
            this.i = null;
        } else {
            this.i = tipBean.getTooNearHint();
        }
        if (TextUtils.isEmpty(tipBean.getNotFindHint())) {
            this.j = Res.getString("bdar_sdk_ar_track_target_not_finded");
        } else {
            this.j = tipBean.getNotFindHint();
        }
        this.f = tipBean.getShowTipsByCase() == 1;
        this.I = tipBean.getHideCaptureGroupImmediately() != 1;
    }

    private void a(String str, String str2) {
        PaddleManager.getInstance().initPaddle(this.s, str, str2, new ARPaddleHelper(), new PaddleController.ActionListener() { // from class: com.baidu.ar.ui.c.3
            @Override // com.baidu.ar.paddle.PaddleController.ActionListener
            public void onResult(HashMap hashMap) {
                c.this.a(hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap hashMap) {
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ViewUtils.setViewText(this.p.d(), str);
        if (this.q.getHostUI() != null) {
            this.q.getHostUI().hideLoadingView();
        }
        ViewUtils.setViewVisibility(this.p.c(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        o();
        this.d = new Timer();
        if (this.e == null) {
            this.e = new TimerTask() { // from class: com.baidu.ar.ui.c.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ViewUtils.setViewVisibility(c.this.p.c(), 8);
                }
            };
        }
        this.d.schedule(this.e, 3000L);
    }

    private void z() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.A();
                c.this.a(c.this.g);
                c.this.B();
            }
        });
    }

    @Override // com.baidu.ar.c.c
    public void a() {
        this.u.a(true);
        this.t.a(true);
        this.v.a(true);
        this.o.a(true);
        this.E.l().b(true);
    }

    @Override // com.baidu.ar.ui.k
    public void a(int i, Object obj) {
        if (s()) {
            return;
        }
        Log.e("BaseUI", "onStateChange, state = " + i + " msg = " + obj);
        if (i != -1 || System.currentTimeMillis() - 0 > 1000) {
            System.currentTimeMillis();
        }
        switch (i) {
            case MsgField.IMSG_SO_LOAD_SUCCESS /* 1201 */:
                e("so load success");
                return;
            case MsgField.IMSG_SO_LOAD_FAILED /* 1202 */:
                e("so load failed");
                return;
            case 1401:
            case MsgField.IMSG_RECGAR_NETWORT_ERROR /* 1402 */:
            case MsgField.IMSG_CLOUDAR_TOAST_ERROR /* 1403 */:
            case MsgField.IMSG_ON_DEVICE_IR_START /* 1806 */:
            case MsgField.IMSG_CLORD_ID_START /* 1807 */:
            case MsgField.IMSG_TRACK_MODEL_APPEAR /* 1809 */:
            case MsgField.IMSG_SLAM_MODEL_DISAPPEAR /* 1810 */:
            case MsgField.IMSG_IMU_MODEL_DISAPPEAR /* 1811 */:
            case MsgField.IMSG_TRACK_LOST /* 1812 */:
            case MsgField.IMSG_TRACK_FOUND /* 1813 */:
            case 2000:
            case 2001:
            case MsgField.MSG_SHARE /* 2502 */:
            case MsgField.IMSG_NO_NETWORK /* 2511 */:
            default:
                return;
            case MsgField.IMSG_TRACK_MODEL_NOT_SHOWING /* 1808 */:
                z();
                return;
            case MsgField.IMSG_TRACK_DISTANCE_TOO_FAR /* 1814 */:
                if (this.f) {
                    if (this.k != this.m) {
                        this.k = this.m;
                        a(1);
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(this.h)) {
                    ViewUtils.setViewVisibility(this.p.a(), 8);
                    return;
                } else {
                    b(this.h);
                    ViewUtils.setViewVisibility(this.p.a(), 0);
                    return;
                }
            case MsgField.IMSG_TRACK_DISTANCE_TOO_NEAR /* 1815 */:
                if (this.f) {
                    if (this.k != this.n) {
                        this.k = this.n;
                        a(2);
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(this.i)) {
                    ViewUtils.setViewVisibility(this.p.a(), 8);
                    return;
                } else {
                    b(this.i);
                    ViewUtils.setViewVisibility(this.p.a(), 0);
                    return;
                }
            case MsgField.IMSG_TRACK_DISTANCE_NORMAL /* 1816 */:
                if (this.f && this.k != this.l) {
                    this.k = this.l;
                    a(3);
                }
                ViewUtils.setViewVisibility(this.p.a(), 8);
                return;
            case MsgField.IMSG_MODEL_LOADED /* 1817 */:
                this.q.getHostUI().hideLoadingView();
                if (this.I) {
                    this.o.i();
                    this.E.l().c(true);
                    return;
                }
                return;
            case MsgField.IMSG_TRACK_HIDE_LOST_INFO /* 1880 */:
                ViewUtils.setViewVisibility(this.p.c(), 8);
                return;
            case MsgField.IMSG_MODE_SHOWING /* 2101 */:
                i();
                return;
            case MsgField.MSG_ID_TRACK_MODEL_CAN_DISAPPEARING /* 2104 */:
                if (((Boolean) obj).booleanValue()) {
                    a(this.g);
                    return;
                } else {
                    z();
                    return;
                }
            case MsgField.MSG_ID_TRACK_MSG_ID_TRACK_LOST /* 2105 */:
                a(this.g);
                return;
            case MsgField.MSG_PADDLE_INIT /* 2400 */:
                HashMap hashMap = (HashMap) obj;
                if (hashMap != null) {
                    String obj2String = MsgParamsUtil.obj2String(hashMap.get("path"), "");
                    String obj2String2 = MsgParamsUtil.obj2String(hashMap.get("secretKey"), "");
                    if (TextUtils.isEmpty(obj2String)) {
                        return;
                    }
                    a(obj2String, obj2String2);
                    return;
                }
                return;
            case MsgField.MSG_PADDLE_ENABLE /* 2401 */:
                PaddleManager.getInstance().enablePaddle(((Boolean) obj).booleanValue());
                return;
            case MsgField.MSG_OPEN_URL /* 2501 */:
                BrowserBean browserBean = (BrowserBean) obj;
                String url = browserBean.getUrl();
                int type = browserBean.getType();
                if (!ARConfig.isBox()) {
                    this.E.a().openUrl(url);
                    return;
                } else if (type == BrowserBean.OPENTYPE.DEFAULT_TYPE.ordinal()) {
                    this.E.a().executeCommand(this.s, url);
                    return;
                } else if (type == BrowserBean.OPENTYPE.SHOUBAI_O2O_TYPE.ordinal()) {
                    this.E.a().executeCommandWithO2O(this.s, url);
                    return;
                } else {
                    return;
                }
            case MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR /* 4202 */:
                c(Res.getString("bdar_error_unzip"));
                return;
            case MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR /* 4203 */:
                c(Res.getString("bdar_error_json_parser"));
                return;
            case MsgField.IMSG_TRACKED_TIPS_INFO /* 40001 */:
                a((TrackRes) obj);
                return;
            case MsgField.IMSG_TRACKED_TARGET_BITMAP_RES /* 40002 */:
                this.y = (Bitmap) obj;
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        this.D = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (this.f) {
            return;
        }
        b(str);
        if (TextUtils.isEmpty(str)) {
            ViewUtils.setViewVisibility(this.p.a(), 8);
        } else {
            ViewUtils.setViewVisibility(this.p.a(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.E.i().switchCamera(!z);
        PaddleManager.getInstance().notifyFrontCamera(z ? false : true);
    }

    @Override // com.baidu.ar.c.c
    public void b() {
        this.u.a(false);
        this.t.a(false);
        this.v.a(false);
        this.o.a(false);
        this.E.l().b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.p.b() == null || TextUtils.isEmpty(str)) {
                    return;
                }
                c.this.p.b().setText(str);
            }
        });
    }

    @Override // com.baidu.ar.c.c
    public void c() {
        this.u.a(true);
        this.t.a(true);
        this.v.a(true);
    }

    protected void c(String str) {
        this.q.getHostUI().hideLoadingView();
        FragmentActivity activity = this.q.getActivity();
        if (activity != null) {
            ToastCustom toastCustom = new ToastCustom(activity.getApplicationContext());
            toastCustom.makeText(str, 1);
            toastCustom.show();
        }
    }

    @Override // com.baidu.ar.c.c
    public void d() {
        this.u.a(false);
        this.t.a(false);
        this.v.a(false);
    }

    @Override // com.baidu.ar.c.c
    public void e() {
        this.E.l().b(true);
        this.o.a(true);
        this.w.c(true);
    }

    @Override // com.baidu.ar.c.c
    public void f() {
        this.E.l().b(false);
        this.o.a(false);
        this.w.c(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F < G) {
            return false;
        }
        this.F = currentTimeMillis;
        return true;
    }

    public a h() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.q.getHostUI().hideLoadingView();
        this.E.b().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.E.i().onClickCameraButton();
    }

    public void k() {
        if (this.A != null && !this.H) {
            this.A.b();
        }
        if (this.o != null) {
            this.o.b();
        }
    }

    public void l() {
        if (this.A != null) {
            this.A.a();
        }
        if (this.o != null) {
            this.o.c();
        }
    }

    public void m() {
        this.q.getHostUI().closeFlash();
        this.q.getHostUI().switchBackCameraForReleaseCase();
        n();
    }

    public void n() {
        this.z = true;
        this.J = null;
        this.t.a();
        this.a.removeView(this.B);
        if (this.A != null) {
            this.A.c();
            this.A = null;
        }
        if (this.o != null) {
            this.o.d();
            this.o = null;
        }
        q();
        this.p.g();
        r();
        o();
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        if (this.d != null) {
            this.d.cancel();
            this.d.purge();
            this.d = null;
        }
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.ar.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.A != null) {
            this.A.a(orientation);
        }
        if (this.t != null) {
            this.t.a(orientation);
        }
        if (this.o != null) {
            this.o.a(orientation);
        }
        if (this.p != null) {
            this.p.a(orientation);
        }
        if (this.w != null) {
            this.w.a(orientation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.p.e() != null) {
                    c.this.p.e().startScan();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.p.e() != null) {
                    c.this.p.e().dismissScan();
                }
            }
        });
    }

    public void r() {
        if (this.b != null) {
            this.b.cancel();
            this.b.purge();
            this.b = null;
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public boolean s() {
        return this.z;
    }

    public boolean t() {
        return this.o.e();
    }

    public com.baidu.ar.b u() {
        return this.E;
    }

    public void v() {
        if (this.A != null) {
            this.A.e();
        }
    }

    public void w() {
        if (this.A != null) {
            this.A.f();
        }
    }

    public void x() {
        if (this.A != null) {
            this.A.g();
        }
    }
}
