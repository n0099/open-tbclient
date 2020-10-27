package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class d {
    protected aa bVi;
    protected NewErrorData ero = null;

    public d() {
        this.bVi = null;
        this.bVi = new aa();
    }

    public void cancel() {
        if (this.bVi != null) {
            this.bVi.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.bVi.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.bVi.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.bVi.postNetData();
        this.ero = new NewErrorData();
        this.ero.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.bVi != null) {
            return this.bVi.bon().boU().isRequestSuccess();
        }
        return false;
    }

    public String bhf() {
        if (this.bVi != null) {
            return this.bVi.getErrorString();
        }
        return null;
    }
}
