package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa bZh;
    protected NewErrorData evy = null;

    public d() {
        this.bZh = null;
        this.bZh = new aa();
    }

    public void cancel() {
        if (this.bZh != null) {
            this.bZh.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bZh.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bZh.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bZh.postNetData();
        this.evy = new NewErrorData();
        this.evy.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bZh != null) {
            return this.bZh.bqa().bqI().isRequestSuccess();
        }
        return false;
    }

    public String biJ() {
        if (this.bZh != null) {
            return this.bZh.getErrorString();
        }
        return null;
    }
}
