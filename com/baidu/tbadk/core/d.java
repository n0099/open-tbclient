package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x blF;
    protected NewErrorData dkY = null;

    public d() {
        this.blF = null;
        this.blF = new x();
    }

    public void cancel() {
        if (this.blF != null) {
            this.blF.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.blF.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.blF.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.blF.postNetData();
        this.dkY = new NewErrorData();
        this.dkY.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.blF != null) {
            return this.blF.aOy().aPa().isRequestSuccess();
        }
        return false;
    }

    public String aIc() {
        if (this.blF != null) {
            return this.blF.getErrorString();
        }
        return null;
    }
}
