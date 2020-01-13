package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cHA;
    protected NewErrorData cHB = null;

    public d() {
        this.cHA = null;
        this.cHA = new x();
    }

    public void cancel() {
        if (this.cHA != null) {
            this.cHA.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cHA.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cHA.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cHA.postNetData();
        this.cHB = new NewErrorData();
        this.cHB.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cHA != null) {
            return this.cHA.aDU().aEv().isRequestSuccess();
        }
        return false;
    }

    public String axw() {
        if (this.cHA != null) {
            return this.cHA.getErrorString();
        }
        return null;
    }
}
