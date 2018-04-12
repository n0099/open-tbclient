package com.baidu.ar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.external.app.BaseFragment;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class ARFragment extends BaseFragment {
    public static final String AR_PACKAGE_NAME = "ar_package_name";
    protected IARCallback a;
    private a d;
    private Context e;
    private boolean c = false;
    private boolean f = false;

    private void b() {
        this.e = getActivity().getApplicationContext();
        com.baidu.ar.util.i.a(this.e.getPackageName());
        if (this.a == null) {
            setARCallbackClient(this.b);
        }
        this.d = new a(this);
        this.d.a(this.a);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d.a(arguments);
        }
    }

    @Override // com.baidu.ar.external.app.BaseFragment
    protected void a() {
        if (this.c) {
            return;
        }
        super.a();
        com.baidu.ar.util.b.a("bdar: ARFragment releaseResources, hashCode = " + hashCode() + ", mIsReleased:" + this.c);
        if (this.d != null) {
            this.d.e();
        }
        com.baidu.ar.external.a.a.a.c();
        this.d = null;
        this.a = null;
        this.c = true;
    }

    @Override // com.baidu.ar.external.app.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.ar.util.b.a("bdar: ARFragment onCreate, hashCode = " + hashCode());
        b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.baidu.ar.util.b.a("bdar: ARFragment onCreateView, hashCode = " + hashCode());
        Res.addResource(getActivity());
        View inflate = Res.inflate("bdar_layout_root");
        if (inflate == null) {
            com.baidu.ar.ui.c.a(getActivity().getApplicationContext(), getActivity(), "layout id is error!!", 1).a();
            return null;
        } else if (this.d != null) {
            this.d.a((ViewGroup) inflate, bundle);
            return inflate;
        } else {
            return inflate;
        }
    }

    @Override // com.baidu.ar.external.app.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.c) {
            com.baidu.ar.util.b.a("[released]bdar: ARFragment onDestory, hashCode = " + hashCode());
        }
    }

    @Override // com.baidu.ar.external.app.BaseFragment, com.baidu.graph.sdk.ui.IRootFragment
    public boolean onFragmentBackPressed() {
        if (this.d != null) {
            return this.d.f();
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.c) {
            com.baidu.ar.util.b.a("[released]bdar: ARFragment onPause, hashCode = " + hashCode());
            return;
        }
        com.baidu.ar.util.b.a("bdar: ARFragment onPause, hashCode = " + hashCode());
        if (this.d != null) {
            this.d.c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.d != null) {
            this.d.a(i, strArr, iArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.c) {
            com.baidu.ar.util.b.a("[released]bdar: ARFragment onResume, hashCode = " + hashCode());
            return;
        }
        com.baidu.ar.util.b.a("bdar: ARFragment onResume, hashCode = " + hashCode());
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        com.baidu.ar.util.b.a("bdar: ARFragment onStart, hashCode = " + hashCode());
        if (this.c) {
            com.baidu.ar.util.b.a("[released]bdar: ARFragment onStart, hashCode = " + hashCode());
        } else if (this.d != null) {
            this.d.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.c) {
            com.baidu.ar.util.b.a("[released]bdar: ARFragment onStop, hashCode = " + hashCode());
            return;
        }
        com.baidu.ar.util.b.a("bdar: ARFragment onStop, hashCode = " + hashCode());
        if (this.d != null) {
            this.d.d();
        }
    }

    public void release() {
        if (this.f) {
            return;
        }
        a();
    }

    public void setARCallbackClient(IARCallback iARCallback) {
        if (iARCallback instanceof e) {
            this.a = iARCallback;
        } else {
            if (this.a == null) {
                this.a = new e();
            }
            ((e) this.a).setARCallbackClient(iARCallback);
        }
        com.baidu.ar.external.a.a.a.a().a(iARCallback);
    }

    public void setWillQuitAR() {
        this.f = true;
    }

    @Override // com.baidu.ar.external.app.BaseFragment
    public void switchToBarcode() {
        if (this.d != null) {
            this.d.i();
        }
    }
}
