package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes2.dex */
public class d {
    protected aa bDY;
    protected NewErrorData dUA = null;

    public d() {
        this.bDY = null;
        this.bDY = new aa();
    }

    public void cancel() {
        if (this.bDY != null) {
            this.bDY.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bDY.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bDY.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bDY.postNetData();
        this.dUA = new NewErrorData();
        this.dUA.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bDY != null) {
            return this.bDY.biQ().bjw().isRequestSuccess();
        }
        return false;
    }

    public String bbK() {
        if (this.bDY != null) {
            return this.bDY.getErrorString();
        }
        return null;
    }
}
