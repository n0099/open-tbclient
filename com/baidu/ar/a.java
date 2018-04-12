package com.baidu.ar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.opengl.BaiduArView;
import com.baidu.ar.util.Constants;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a {
    private WeakReference<BaseFragment> b;
    private Activity c;
    private Bundle d;
    private ARConfiguration e;
    private ViewGroup f;
    private ViewGroup g;
    private d h;
    private IARCallback i;
    private View k;
    private b l;
    private C0024a m;
    boolean a = false;
    private com.baidu.ar.f.a j = new com.baidu.ar.f.a();

    /* renamed from: com.baidu.ar.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0024a {
        a a;

        C0024a(a aVar) {
            this.a = aVar;
        }

        public void a() {
            this.a = null;
        }

        public void a(com.baidu.ar.f.c cVar, String str) {
            if (this.a != null) {
                this.a.a(cVar, str);
            }
        }

        public void a(com.baidu.ar.f.c cVar, boolean z) {
            if (this.a != null) {
                this.a.a(cVar, z);
            }
        }

        public void a(BaiduArView.a aVar) {
            if (this.a != null) {
                this.a.a(aVar);
            }
        }

        public void a(com.baidu.ar.recorder.b bVar, long j) {
            if (this.a != null) {
                this.a.a(bVar, j);
            }
        }

        public void a(boolean z) {
            if (this.a != null) {
                this.a.a(z);
            }
        }

        public boolean b() {
            if (this.a != null) {
                return this.a.m();
            }
            return false;
        }

        public boolean c() {
            if (this.a != null) {
                return this.a.g();
            }
            return false;
        }

        public int d() {
            if (this.a != null) {
                return this.a.n();
            }
            return -1;
        }

        public Bitmap e() {
            if (this.a != null) {
                return this.a.h();
            }
            return null;
        }

        public void f() {
            if (this.a != null) {
                this.a.j();
            }
        }

        public void g() {
            if (this.a != null) {
                this.a.k();
            }
        }
    }

    public a(BaseFragment baseFragment) {
        this.b = new WeakReference<>(baseFragment);
        this.c = baseFragment.getActivity();
        this.j.a(this.c);
        this.j.a(baseFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.f.c cVar, boolean z) {
        if (this.j != null) {
            com.baidu.ar.util.b.a("bdar: Camera close in ARController closeCamera");
            this.j.a(cVar, z);
        }
    }

    private void b(Bundle bundle) {
        String string = bundle.getString(Constants.AR_VALUE);
        if (string == null || string.isEmpty()) {
            return;
        }
        this.e = ARConfiguration.createARConfiguration(string);
        com.baidu.ar.h.a.a().a(this.e);
        com.baidu.ar.h.a.a().a(this.c.getApplicationContext(), string);
    }

    private boolean l() {
        return (this.d == null || this.e == null || (TextUtils.isEmpty(this.e.getARKey()) && TextUtils.isEmpty(this.e.getARId()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        BaiduArView h;
        if (this.j == null || (h = this.j.h()) == null) {
            return false;
        }
        h.setEnginSoLoaded(true);
        ArBridge.getInstance().setDensity(this.c.getApplication().getResources().getDisplayMetrics().density);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        if (this.j != null) {
            return this.j.f();
        }
        return -1;
    }

    public View a(ViewGroup viewGroup, Bundle bundle) {
        this.f = viewGroup;
        if (l()) {
            this.g = new FrameLayout(viewGroup.getContext());
            this.f.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
            this.j.a(this.f, this.g, this.i);
            this.m = new C0024a(this);
            a(this.f, this.m);
            return this.f;
        }
        return this.f;
    }

    public void a() {
        if (this.j != null) {
            this.j.d();
        }
        if (this.h != null) {
            this.h.k();
        }
    }

    public void a(int i, String[] strArr, int[] iArr) {
        if (this.h != null) {
            this.h.a(i, strArr, iArr);
        }
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            com.baidu.ar.util.b.d("error: arguments is null!");
            return;
        }
        this.d = bundle;
        b(bundle);
    }

    public void a(ViewGroup viewGroup, C0024a c0024a) {
        com.baidu.ar.external.a.a.a.a().a(this.e.getARType());
        switch (this.e.getARType()) {
            case 0:
                this.h = new com.baidu.ar.track.a(this.b.get(), c0024a);
                break;
            case 1:
            case 2:
            case 4:
            default:
                com.baidu.ar.util.b.d("Resource Type error, not defined!");
                this.h = new com.baidu.ar.track.a(this.b.get(), c0024a);
                break;
            case 3:
                com.baidu.ar.ui.c.a(this.c.getApplicationContext(), this.c, "AR type error!!!", 1).a();
                if (this.i != null) {
                    this.i.quitAR(this.b.get(), IARCallback.ARAction.BACK);
                    return;
                }
                return;
            case 5:
                this.h = new com.baidu.ar.slam.a(this.b.get(), c0024a);
                break;
        }
        this.h.a(this.e);
        this.h.c(this.d);
        this.h.a(this.i);
        View e = this.h.e(this.c);
        ViewGroup viewGroup2 = (ViewGroup) e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(e);
        }
        this.k = e;
        viewGroup.addView(this.k);
    }

    public void a(IARCallback iARCallback) {
        if (iARCallback instanceof e) {
            this.i = iARCallback;
            return;
        }
        if (this.i == null) {
            this.i = new e();
        }
        ((e) this.i).setARCallbackClient(iARCallback);
    }

    public void a(com.baidu.ar.f.c cVar, String str) {
        if (this.j != null) {
            this.j.a(cVar, str);
        }
    }

    public void a(BaiduArView.a aVar) {
        if (this.j != null) {
            this.j.a(aVar);
        }
    }

    public void a(com.baidu.ar.recorder.b bVar, long j) {
        if (this.j != null) {
            this.j.a(bVar, j);
        }
    }

    public void a(boolean z) {
        if (this.j == null || this.j.h() == null) {
            return;
        }
        this.j.h().setUserInteractionEnabled(z);
    }

    public void b() {
        boolean z;
        if (this.a) {
            return;
        }
        this.a = true;
        if (!l()) {
            com.baidu.ar.ui.c.a(this.c.getApplicationContext(), this.c, "AR params error!!!", 1).a();
            if (this.i != null) {
                this.i.quitAR(this.b.get(), IARCallback.ARAction.BACK);
                return;
            }
            return;
        }
        com.baidu.ar.f.e ah = this.h != null ? this.h.ah() : null;
        if (this.j != null) {
            z = this.j.a(ah);
            com.baidu.ar.util.b.a("bdar: Camera open in ARController onResume");
        } else {
            z = false;
        }
        if (!z || this.h == null) {
            return;
        }
        this.h.l();
    }

    public void c() {
        boolean z;
        this.a = false;
        if (this.j != null) {
            com.baidu.ar.util.b.a("bdar: Camera close in ARController onPause");
            z = this.j.a((com.baidu.ar.f.c) null, false);
        } else {
            z = false;
        }
        if (z && (this.h != null)) {
            this.h.m();
        }
    }

    public void d() {
        if (this.h != null) {
            this.h.ad();
        }
    }

    public void e() {
        if (this.h != null) {
            this.h.n();
            this.h = null;
        }
        if (this.j != null) {
            this.j.e();
            this.j = null;
        }
        this.b.clear();
        this.i = null;
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        ArBridge.getInstance().releaseAREngine();
        com.baidu.ar.util.b.d("bdar: releaseAREngine");
    }

    public boolean f() {
        if (this.h != null) {
            return this.h.v();
        }
        return false;
    }

    public boolean g() {
        return (this.j == null || this.j.h() == null || !this.j.h().a()) ? false : true;
    }

    public Bitmap h() {
        if (this.j != null) {
            return this.j.g();
        }
        return null;
    }

    public void i() {
        if (this.h != null) {
            this.h.X();
        }
    }

    public void j() {
        if (this.j != null) {
            this.j.b();
        }
    }

    public void k() {
        if (this.j != null) {
            this.j.a();
        }
    }
}
