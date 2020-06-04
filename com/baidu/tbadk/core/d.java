package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x bth;
    protected NewErrorData dzc = null;

    public d() {
        this.bth = null;
        this.bth = new x();
    }

    public void cancel() {
        if (this.bth != null) {
            this.bth.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bth.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bth.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bth.postNetData();
        this.dzc = new NewErrorData();
        this.dzc.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bth != null) {
            return this.bth.aUA().aVc().isRequestSuccess();
        }
        return false;
    }

    public String aNO() {
        if (this.bth != null) {
            return this.bth.getErrorString();
        }
        return null;
    }
}
