package com.baidu.android.lbspay.activity;

import android.os.Bundle;
import com.baidu.android.lbspay.presenter.LBSTransPresenter;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes.dex */
public class LBSTransActivity extends LBSBaseActivity {
    public static final String BEAN_TAG = "LBSTransActivity";
    public static final String PRESENTER_TYPE = "presentertype";
    public LBSTransPresenter mPresenter;

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_juhe_trans_layout"));
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i, int i2, String str) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.handleFailure(i, i2, str);
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i, Object obj, String str) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.handleResponse(i, obj, str);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.cancelBean();
        }
        onBackPressedWithoutAnim();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPresenter = LBSTransPresenterFactory.getInstance().getTransPresenter(this, getIntent().getExtras().getString(PRESENTER_TYPE));
        initView();
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.init(bundle);
            this.mPresenter.execBean();
            return;
        }
        finishWithoutAnim();
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        LBSTransPresenter lBSTransPresenter = this.mPresenter;
        if (lBSTransPresenter != null) {
            lBSTransPresenter.SaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }
}
