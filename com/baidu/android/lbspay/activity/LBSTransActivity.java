package com.baidu.android.lbspay.activity;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.presenter.LBSTransPresenter;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
/* loaded from: classes4.dex */
public class LBSTransActivity extends LBSBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "LBSTransActivity";
    public static final String PRESENTER_TYPE = "presentertype";
    public transient /* synthetic */ FieldHolder $fh;
    public LBSTransPresenter mPresenter;

    public LBSTransActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(ResUtils.layout(getActivity(), "wallet_juhe_trans_layout"));
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i2, int i3, String str) {
        LBSTransPresenter lBSTransPresenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) || (lBSTransPresenter = this.mPresenter) == null) {
            return;
        }
        lBSTransPresenter.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i2, Object obj, String str) {
        LBSTransPresenter lBSTransPresenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) || (lBSTransPresenter = this.mPresenter) == null) {
            return;
        }
        lBSTransPresenter.handleResponse(i2, obj, str);
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LBSTransPresenter lBSTransPresenter = this.mPresenter;
            if (lBSTransPresenter != null) {
                lBSTransPresenter.cancelBean();
            }
            onBackPressedWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            LBSTransPresenter lBSTransPresenter = this.mPresenter;
            if (lBSTransPresenter != null) {
                lBSTransPresenter.SaveInstanceState(bundle);
            }
            super.onSaveInstanceState(bundle);
        }
    }
}
