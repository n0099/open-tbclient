package com.baidu.ar.external.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.f;
import com.baidu.graph.sdk.framework.IExtFragmentCallback;
/* loaded from: classes3.dex */
public class BaseFragment extends Fragment implements a {
    private IExtFragmentCallback a;
    protected IARCallback b;

    private void b() {
        if (f.d(getActivity().getApplicationContext())) {
            this.b = createGraphARCallback(this.a);
            if (this.a != null) {
                Res.addResource(getActivity(), "com.baidu.searchbox.godeye");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.b != null && (this.b instanceof com.baidu.ar.external.a)) {
            ((com.baidu.ar.external.a) this.b).a();
        }
        this.b = null;
        this.a = null;
    }

    public IARCallback createGraphARCallback(IExtFragmentCallback iExtFragmentCallback) {
        return new com.baidu.ar.external.a(iExtFragmentCallback);
    }

    @Override // com.baidu.graph.sdk.ui.IRootFragment
    public Fragment getFragment() {
        return this;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a();
    }

    public boolean onFragmentBackPressed() {
        return false;
    }

    public void setARCallback(IARCallback iARCallback) {
        this.b = iARCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.graph.sdk.ui.IRootFragment
    public void setFragmentCallback(IExtFragmentCallback iExtFragmentCallback) {
        this.a = iExtFragmentCallback;
    }

    public void switchToBarcode() {
    }
}
