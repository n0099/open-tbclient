package com.baidu.pass.ecommerce.common.mvp;

import android.os.Bundle;
import com.baidu.pass.ecommerce.common.mvp.IPresenter;
import com.baidu.sapi2.activity.BaseOptionActivity;
/* loaded from: classes2.dex */
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseOptionActivity implements IBaseView {
    public P presenter;

    public abstract P createPresenter();

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        P p = this.presenter;
        if (p != null) {
            p.destroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i, int i2, String str) {
        doFailure(i, i2, str, null);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i, String str) {
        doFailure(Integer.MIN_VALUE, i, str);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(int i, Object obj) {
        doResult(i, obj, null);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(Object obj) {
        doResult(Integer.MIN_VALUE, obj);
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        P createPresenter = createPresenter();
        this.presenter = createPresenter;
        createPresenter.attachView(this);
    }
}
