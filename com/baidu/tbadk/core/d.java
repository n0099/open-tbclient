package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class d {
    protected z byq;
    protected NewErrorData dLs = null;

    public d() {
        this.byq = null;
        this.byq = new z();
    }

    public void cancel() {
        if (this.byq != null) {
            this.byq.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.byq.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.byq.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.byq.postNetData();
        this.dLs = new NewErrorData();
        this.dLs.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.byq != null) {
            return this.byq.bav().baX().isRequestSuccess();
        }
        return false;
    }

    public String aTt() {
        if (this.byq != null) {
            return this.byq.getErrorString();
        }
        return null;
    }
}
