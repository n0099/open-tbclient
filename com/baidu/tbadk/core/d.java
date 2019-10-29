package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x bVP;
    protected NewErrorData bVQ = null;

    public d() {
        this.bVP = null;
        this.bVP = new x();
    }

    public void cancel() {
        if (this.bVP != null) {
            this.bVP.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bVP.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bVP.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bVP.postNetData();
        this.bVQ = new NewErrorData();
        this.bVQ.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bVP != null) {
            return this.bVP.amr().amS().isRequestSuccess();
        }
        return false;
    }

    public String ago() {
        if (this.bVP != null) {
            return this.bVP.getErrorString();
        }
        return null;
    }
}
