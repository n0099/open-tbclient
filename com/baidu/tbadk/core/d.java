package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x bUY;
    protected NewErrorData bUZ = null;

    public d() {
        this.bUY = null;
        this.bUY = new x();
    }

    public void cancel() {
        if (this.bUY != null) {
            this.bUY.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bUY.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bUY.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bUY.postNetData();
        this.bUZ = new NewErrorData();
        this.bUZ.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bUY != null) {
            return this.bUY.amp().amQ().isRequestSuccess();
        }
        return false;
    }

    public String agm() {
        if (this.bUY != null) {
            return this.bUY.getErrorString();
        }
        return null;
    }
}
