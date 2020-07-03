package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class d {
    protected y byb;
    protected NewErrorData dFv = null;

    public d() {
        this.byb = null;
        this.byb = new y();
    }

    public void cancel() {
        if (this.byb != null) {
            this.byb.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.byb.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.byb.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.byb.postNetData();
        this.dFv = new NewErrorData();
        this.dFv.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.byb != null) {
            return this.byb.aWu().aWW().isRequestSuccess();
        }
        return false;
    }

    public String aPy() {
        if (this.byb != null) {
            return this.byb.getErrorString();
        }
        return null;
    }
}
