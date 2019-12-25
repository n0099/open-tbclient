package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class d {
    protected x cHo;
    protected NewErrorData cHp = null;

    public d() {
        this.cHo = null;
        this.cHo = new x();
    }

    public void cancel() {
        if (this.cHo != null) {
            this.cHo.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cHo.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cHo.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cHo.postNetData();
        this.cHp = new NewErrorData();
        this.cHp.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cHo != null) {
            return this.cHo.aDB().aEc().isRequestSuccess();
        }
        return false;
    }

    public String axd() {
        if (this.cHo != null) {
            return this.cHo.getErrorString();
        }
        return null;
    }
}
