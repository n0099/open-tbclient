package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class d {
    protected z chV;
    protected NewErrorData eHs = null;

    public d() {
        this.chV = null;
        this.chV = new z();
    }

    public void cancel() {
        if (this.chV != null) {
            this.chV.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.chV.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.chV.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.chV.postNetData();
        this.eHs = new NewErrorData();
        this.eHs.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.chV != null) {
            return this.chV.brX().bsH().isRequestSuccess();
        }
        return false;
    }

    public String bkz() {
        if (this.chV != null) {
            return this.chV.getErrorString();
        }
        return null;
    }
}
