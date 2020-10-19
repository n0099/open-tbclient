package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa bML;
    protected NewErrorData eiQ = null;

    public d() {
        this.bML = null;
        this.bML = new aa();
    }

    public void cancel() {
        if (this.bML != null) {
            this.bML.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bML.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bML.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bML.postNetData();
        this.eiQ = new NewErrorData();
        this.eiQ.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bML != null) {
            return this.bML.bmu().bnb().isRequestSuccess();
        }
        return false;
    }

    public String bfm() {
        if (this.bML != null) {
            return this.bML.getErrorString();
        }
        return null;
    }
}
