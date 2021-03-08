package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa cnM;
    protected NewErrorData eKZ = null;

    public d() {
        this.cnM = null;
        this.cnM = new aa();
    }

    public void cancel() {
        if (this.cnM != null) {
            this.cnM.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cnM.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cnM.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cnM.postNetData();
        this.eKZ = new NewErrorData();
        this.eKZ.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cnM != null) {
            return this.cnM.bsu().bte().isRequestSuccess();
        }
        return false;
    }

    public String bkT() {
        if (this.cnM != null) {
            return this.cnM.getErrorString();
        }
        return null;
    }
}
