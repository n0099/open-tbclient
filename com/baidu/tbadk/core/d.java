package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa cml;
    protected NewErrorData eJy = null;

    public d() {
        this.cml = null;
        this.cml = new aa();
    }

    public void cancel() {
        if (this.cml != null) {
            this.cml.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cml.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cml.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cml.postNetData();
        this.eJy = new NewErrorData();
        this.eJy.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cml != null) {
            return this.cml.bsr().btb().isRequestSuccess();
        }
        return false;
    }

    public String bkR() {
        if (this.cml != null) {
            return this.cml.getErrorString();
        }
        return null;
    }
}
