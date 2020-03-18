package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cLQ;
    protected NewErrorData cLR = null;

    public d() {
        this.cLQ = null;
        this.cLQ = new x();
    }

    public void cancel() {
        if (this.cLQ != null) {
            this.cLQ.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cLQ.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cLQ.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cLQ.postNetData();
        this.cLR = new NewErrorData();
        this.cLR.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cLQ != null) {
            return this.cLQ.aGk().aGM().isRequestSuccess();
        }
        return false;
    }

    public String azP() {
        if (this.cLQ != null) {
            return this.cLQ.getErrorString();
        }
        return null;
    }
}
