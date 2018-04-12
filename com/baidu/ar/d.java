package com.baidu.ar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import android.view.View;
import com.baidu.ar.a;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.h;
import com.baidu.ar.util.Res;
import com.baidu.baiduarsdk.ArBridge;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public abstract class d implements h.b {
    private View a;
    protected WeakReference<BaseFragment> ae;
    protected WeakReference<Activity> af;
    protected Context ag;
    protected String ah;
    protected ARResource ai;
    protected Bundle aj;
    protected IARCallback ak;
    protected ARConfiguration am;
    protected a ao;
    protected a.C0024a ap;
    protected b aq;
    protected boolean al = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    protected boolean an = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends OrientationEventListener {
        int a;
        ArBridge.TouchOrientation b;
        private d c;
        private ArBridge.TouchOrientation d;
        private boolean e;

        a(Context context, d dVar) {
            super(context);
            this.e = false;
            this.c = dVar;
        }

        void a() {
            this.c = null;
        }

        void a(int i) {
            if (i < 0) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
            } else if (ArBridge.getInstance().getImuType() == 1) {
                int i2 = ((i + 360) + this.a) % 360;
                if (i2 <= 45 || i2 > 315) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i2 > 45 && i2 <= 135) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i2 > 135 && i2 <= 225) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (i2 > 225 && i2 <= 315) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
                }
                if (!this.e && ArBridge.getInstance().getImuType() == 1) {
                    this.e = true;
                    this.d = this.b;
                    b();
                }
            } else if (ArBridge.getInstance().getImuType() == 0) {
                if (i <= 45 || i > 315) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i > 45 && i <= 135) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i > 135 && i <= 225) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (i > 225 && i <= 315) {
                    this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
                }
            }
            if (this.c.ac().getARType() != 5) {
                ArBridge.getInstance().setTouchOrientation(this.b);
            }
        }

        public void b() {
            this.a = c();
        }

        int c() {
            if (this.d == ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                return 90;
            }
            if (this.d == ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
                return -90;
            }
            if (this.d == ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT) {
                return SubsamplingScaleImageView.ORIENTATION_180;
            }
            return 0;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (this.c != null) {
                this.c.a(i);
            }
            a(i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements com.baidu.ar.f.e {
        d a;

        b(d dVar) {
            this.a = dVar;
        }

        public void a() {
            this.a = null;
        }

        @Override // com.baidu.ar.f.e
        public void a(byte[] bArr, com.baidu.ar.f.f fVar) {
            if (this.a != null) {
                this.a.d(bArr, fVar);
            }
        }

        @Override // com.baidu.ar.f.e
        public void b() {
            if (this.a != null) {
                this.a.L();
            }
        }

        @Override // com.baidu.ar.f.e
        public void c() {
            if (this.a != null) {
                this.a.M();
            }
        }

        @Override // com.baidu.ar.f.e
        public void d() {
            if (this.a != null) {
                this.a.N();
            }
        }

        @Override // com.baidu.ar.f.e
        public void e() {
            if (this.a != null) {
                this.a.O();
            }
        }
    }

    public d(BaseFragment baseFragment, a.C0024a c0024a) {
        this.ao = null;
        this.ae = new WeakReference<>(baseFragment);
        FragmentActivity activity = baseFragment.getActivity();
        this.af = new WeakReference<>(activity);
        this.ag = activity.getApplicationContext();
        this.ah = this.ag.getPackageName();
        this.ao = new a(this.ag, this);
        this.ap = c0024a;
        this.aq = new b(this);
        Res.addResource(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if ((i >= 0 && i <= 10) || (i >= 350 && i <= 359)) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.c = false;
            this.d = false;
            this.e = false;
            r();
        } else if (i >= 80 && i <= 100) {
            if (this.c) {
                return;
            }
            this.b = false;
            this.c = true;
            this.d = false;
            this.e = false;
            t();
        } else if (i >= 170 && i <= 190) {
            if (this.e) {
                return;
            }
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = true;
            r();
        } else if (i < 260 || i > 280 || this.d) {
        } else {
            this.b = false;
            this.c = false;
            this.d = true;
            this.e = false;
            s();
        }
    }

    public abstract void L();

    public abstract void M();

    public abstract void N();

    public abstract void O();

    public abstract void X();

    public abstract View a(Activity activity);

    public void a(int i, String[] strArr, int[] iArr) {
    }

    public void a(ARConfiguration aRConfiguration) {
        this.am = aRConfiguration;
    }

    @Override // com.baidu.ar.h.b
    public void a(ARResource aRResource) {
        this.ai = aRResource;
    }

    public void a(IARCallback iARCallback) {
        if (iARCallback instanceof e) {
            this.ak = iARCallback;
            return;
        }
        if (this.ak == null) {
            this.ak = new e();
        }
        ((e) this.ak).setARCallbackClient(iARCallback);
    }

    @Override // com.baidu.ar.h.b
    public ARConfiguration ac() {
        return this.am;
    }

    public void ad() {
    }

    public void ae() {
        if (this.ao != null) {
            this.ao.enable();
        }
    }

    public void af() {
        if (this.ao != null) {
            this.ao.disable();
        }
    }

    public void ag() {
        if (this.ao != null) {
            this.ao.b();
        }
    }

    public com.baidu.ar.f.e ah() {
        return this.aq;
    }

    public void c(Bundle bundle) {
        this.aj = bundle;
        d(bundle);
    }

    protected void d(Bundle bundle) {
        if (bundle != null) {
            String string = this.aj.getString(ARFragment.AR_PACKAGE_NAME);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.ah = string;
        }
    }

    public abstract void d(byte[] bArr, com.baidu.ar.f.f fVar);

    public View e(Activity activity) {
        this.a = a(activity);
        return this.a;
    }

    public abstract void k();

    public void l() {
        this.al = true;
    }

    public void m() {
        this.al = false;
    }

    public void n() {
        if (this.ae != null) {
            this.ae.clear();
        }
        if (this.af != null) {
            this.af.clear();
        }
        if (this.ao != null) {
            this.ao.a();
            this.ao = null;
        }
        this.ak = null;
        this.ap = null;
        if (this.aq != null) {
            this.aq.a();
        }
    }

    public abstract void r();

    public abstract void s();

    public abstract void t();

    @Override // com.baidu.ar.h.b
    public boolean u() {
        if (this.ak == null || this.ae == null) {
            return true;
        }
        this.ak.quitAR(this.ae.get(), IARCallback.ARAction.BACK);
        return true;
    }

    public boolean v() {
        return false;
    }
}
