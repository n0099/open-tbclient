package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x blK;
    protected NewErrorData dlc = null;

    public d() {
        this.blK = null;
        this.blK = new x();
    }

    public void cancel() {
        if (this.blK != null) {
            this.blK.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.blK.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.blK.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.blK.postNetData();
        this.dlc = new NewErrorData();
        this.dlc.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.blK != null) {
            return this.blK.aOw().aOX().isRequestSuccess();
        }
        return false;
    }

    public String aIa() {
        if (this.blK != null) {
            return this.blK.getErrorString();
        }
        return null;
    }
}
