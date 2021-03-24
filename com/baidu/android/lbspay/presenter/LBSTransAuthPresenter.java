package com.baidu.android.lbspay.presenter;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.beans.AuthorizeSignBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.network.AuthorizeSignContent;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LBSTransAuthPresenter implements LBSTransPresenter {
    public static final String AUTH_CHANNEL_ALI = "alipay";
    public static final String SAVED_AUTH_DATA = "mAuthorizeData";
    public LBSTransActivity mAct;
    public AuthorizeSignBean mAuthBean;
    public AuthorizeData mAuthorizeData = null;

    public LBSTransAuthPresenter(LBSTransActivity lBSTransActivity) {
        this.mAct = lBSTransActivity;
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void SaveInstanceState(Bundle bundle) {
        AuthorizeData authorizeData = this.mAuthorizeData;
        if (authorizeData != null) {
            bundle.putSerializable(SAVED_AUTH_DATA, authorizeData);
        }
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void cancelBean() {
        AuthorizeSignBean authorizeSignBean = this.mAuthBean;
        if (authorizeSignBean != null) {
            authorizeSignBean.destroyBean();
        }
        LBSPayResult.payResult(this.mAct, 2, null);
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void execBean() {
        if (this.mAuthorizeData != null) {
            AuthorizeSignBean authorizeSignBean = (AuthorizeSignBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 3, LBSTransActivity.BEAN_TAG);
            this.mAuthBean = authorizeSignBean;
            authorizeSignBean.setAuthorizeData(this.mAuthorizeData);
            this.mAuthBean.setResponseCallback(this.mAct);
            this.mAuthBean.execBean();
        }
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void handleFailure(int i, int i2, String str) {
        LBSPayResult.payResult(null, 3, null);
        this.mAct.onBackPressedWithoutAnim();
    }

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void handleResponse(int i, Object obj, String str) {
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

    @Override // com.baidu.android.lbspay.presenter.LBSTransPresenter
    public void init(Bundle bundle) {
        LBSTransActivity lBSTransActivity;
        Serializable serializable;
        if (bundle != null && (serializable = bundle.getSerializable(SAVED_AUTH_DATA)) != null && (serializable instanceof AuthorizeData)) {
            this.mAuthorizeData = (AuthorizeData) serializable;
        }
        if (this.mAuthorizeData != null || (lBSTransActivity = this.mAct) == null) {
            return;
        }
        this.mAuthorizeData = (AuthorizeData) lBSTransActivity.getIntent().getExtras().get(AuthorizeData.DELIVERY_AUTHORIZE_DATA);
    }
}
