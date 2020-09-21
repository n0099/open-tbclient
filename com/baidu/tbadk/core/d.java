package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa bGb;
    protected NewErrorData dWO = null;

    public d() {
        this.bGb = null;
        this.bGb = new aa();
    }

    public void cancel() {
        if (this.bGb != null) {
            this.bGb.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bGb.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bGb.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bGb.postNetData();
        this.dWO = new NewErrorData();
        this.dWO.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bGb != null) {
            return this.bGb.bjL().bkr().isRequestSuccess();
        }
        return false;
    }

    public String bcE() {
        if (this.bGb != null) {
            return this.bGb.getErrorString();
        }
        return null;
    }
}
