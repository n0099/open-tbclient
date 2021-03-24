package com.baidu.android.lbspay.beans;

import android.content.Context;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.network.AuthorizeSignContent;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AuthorizeSignBean extends PayBaseBean<AuthorizeSignContent> {
    public AuthorizeData mAuthSignData;

    public AuthorizeSignBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        execBean(AuthorizeSignContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        AuthorizeData authorizeData = this.mAuthSignData;
        if (authorizeData != null) {
            authorizeData.addParams(arrayList);
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 3;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getZhiFuHost() + "/proxy/authorize/sign";
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean isLbsPayBean() {
        return true;
    }

    public void setAuthorizeData(AuthorizeData authorizeData) {
        this.mAuthSignData = authorizeData;
    }
}
