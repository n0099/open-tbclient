package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cLE;
    protected NewErrorData cLF = null;

    public d() {
        this.cLE = null;
        this.cLE = new x();
    }

    public void cancel() {
        if (this.cLE != null) {
            this.cLE.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cLE.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cLE.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cLE.postNetData();
        this.cLF = new NewErrorData();
        this.cLF.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cLE != null) {
            return this.cLE.aGg().aGI().isRequestSuccess();
        }
        return false;
    }

    public String azM() {
        if (this.cLE != null) {
            return this.cLE.getErrorString();
        }
        return null;
    }
}
