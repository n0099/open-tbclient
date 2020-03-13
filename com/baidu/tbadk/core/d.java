package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cLF;
    protected NewErrorData cLG = null;

    public d() {
        this.cLF = null;
        this.cLF = new x();
    }

    public void cancel() {
        if (this.cLF != null) {
            this.cLF.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cLF.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cLF.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cLF.postNetData();
        this.cLG = new NewErrorData();
        this.cLG.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cLF != null) {
            return this.cLF.aGg().aGI().isRequestSuccess();
        }
        return false;
    }

    public String azM() {
        if (this.cLF != null) {
            return this.cLF.getErrorString();
        }
        return null;
    }
}
