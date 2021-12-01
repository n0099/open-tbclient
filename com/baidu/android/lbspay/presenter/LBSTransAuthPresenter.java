package com.baidu.android.lbspay.presenter;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.beans.AuthorizeSignBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.network.AuthorizeSignContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class LBSTransAuthPresenter implements LBSTransPresenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_CHANNEL_ALI = "alipay";
    public static final String SAVED_AUTH_DATA = "mAuthorizeData";
    public transient /* synthetic */ FieldHolder $fh;
    public LBSTransActivity mAct;
    public AuthorizeSignBean mAuthBean;
    public AuthorizeData mAuthorizeData;

    public LBSTransAuthPresenter(LBSTransActivity lBSTransActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lBSTransActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAuthorizeData = null;
        this.mAct = lBSTransActivity;
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void SaveInstanceState(Bundle bundle) {
        AuthorizeData authorizeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (authorizeData = this.mAuthorizeData) == null) {
            return;
        }
        bundle.putSerializable(SAVED_AUTH_DATA, authorizeData);
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void cancelBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AuthorizeSignBean authorizeSignBean = this.mAuthBean;
            if (authorizeSignBean != null) {
                authorizeSignBean.destroyBean();
            }
            LBSPayResult.payResult(this.mAct, 2, null);
        }
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void execBean() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mAuthorizeData == null) {
            return;
        }
        AuthorizeSignBean authorizeSignBean = (AuthorizeSignBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 3, LBSTransActivity.BEAN_TAG);
        this.mAuthBean = authorizeSignBean;
        authorizeSignBean.setAuthorizeData(this.mAuthorizeData);
        this.mAuthBean.setResponseCallback(this.mAct);
        this.mAuthBean.execBean();
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) {
            LBSPayResult.payResult(null, 3, null);
            this.mAct.onBackPressedWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            AuthorizeSignContent authorizeSignContent = obj instanceof AuthorizeSignContent ? (AuthorizeSignContent) obj : null;
            if (authorizeSignContent != null) {
                if (AUTH_CHANNEL_ALI.equals(authorizeSignContent.sign_data.sign_channel)) {
                    if (!LBSPayAli.getInstance().aliAuthorizeSign(this.mAct, authorizeSignContent.sign_data.sign_url)) {
                        LBSPayResult.payResult(this.mAct, 2, null);
                    }
                } else {
                    LBSPayResult.payResult(this.mAct, 2, null);
                }
            }
            this.mAct.onBackPressedWithoutAnim();
        }
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void init(Bundle bundle) {
        LBSTransActivity lBSTransActivity;
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null && (serializable = bundle.getSerializable(SAVED_AUTH_DATA)) != null && (serializable instanceof AuthorizeData)) {
                this.mAuthorizeData = (AuthorizeData) serializable;
            }
            if (this.mAuthorizeData != null || (lBSTransActivity = this.mAct) == null) {
                return;
            }
            this.mAuthorizeData = (AuthorizeData) lBSTransActivity.getIntent().getExtras().get(AuthorizeData.DELIVERY_AUTHORIZE_DATA);
        }
    }
}
