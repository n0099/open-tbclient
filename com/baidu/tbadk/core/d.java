package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa bEb;
    protected NewErrorData dUE = null;

    public d() {
        this.bEb = null;
        this.bEb = new aa();
    }

    public void cancel() {
        if (this.bEb != null) {
            this.bEb.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bEb.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bEb.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bEb.postNetData();
        this.dUE = new NewErrorData();
        this.dUE.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bEb != null) {
            return this.bEb.biQ().bjw().isRequestSuccess();
        }
        return false;
    }

    public String bbK() {
        if (this.bEb != null) {
            return this.bEb.getErrorString();
        }
        return null;
    }
}
