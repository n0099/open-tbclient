package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa caS;
    protected NewErrorData exh = null;

    public d() {
        this.caS = null;
        this.caS = new aa();
    }

    public void cancel() {
        if (this.caS != null) {
            this.caS.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.caS.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.caS.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.caS.postNetData();
        this.exh = new NewErrorData();
        this.exh.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.caS != null) {
            return this.caS.bqN().bru().isRequestSuccess();
        }
        return false;
    }

    public String bjF() {
        if (this.caS != null) {
            return this.caS.getErrorString();
        }
        return null;
    }
}
