package com.baidu.android.lbspay.network;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AuthorizeSignContent implements IBeanResponse, Serializable {
    public SignData sign_data;

    /* loaded from: classes2.dex */
    public static class SignData implements Serializable {
        public String sign_channel;
        public String sign_url;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
