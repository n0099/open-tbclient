package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa cfI;
    protected NewErrorData eCz = null;

    public d() {
        this.cfI = null;
        this.cfI = new aa();
    }

    public void cancel() {
        if (this.cfI != null) {
            this.cfI.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cfI.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cfI.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cfI.postNetData();
        this.eCz = new NewErrorData();
        this.eCz.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cfI != null) {
            return this.cfI.btv().buf().isRequestSuccess();
        }
        return false;
    }

    public String blT() {
        if (this.cfI != null) {
            return this.cfI.getErrorString();
        }
        return null;
    }
}
