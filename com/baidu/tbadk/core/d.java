package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cLD;
    protected NewErrorData cLE = null;

    public d() {
        this.cLD = null;
        this.cLD = new x();
    }

    public void cancel() {
        if (this.cLD != null) {
            this.cLD.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cLD.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cLD.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cLD.postNetData();
        this.cLE = new NewErrorData();
        this.cLE.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cLD != null) {
            return this.cLD.aGe().aGG().isRequestSuccess();
        }
        return false;
    }

    public String azK() {
        if (this.cLD != null) {
            return this.cLD.getErrorString();
        }
        return null;
    }
}
