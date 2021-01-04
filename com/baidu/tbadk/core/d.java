package com.baidu.tbadk.core;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class d {
    protected z cmJ;
    protected NewErrorData eMd = null;

    public d() {
        this.cmJ = null;
        this.cmJ = new z();
    }

    public void cancel() {
        if (this.cmJ != null) {
            this.cmJ.cancelNetConnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUrl(String str) {
        this.cmJ.setUrl(str);
    }

    public void addPostData(String str, String str2) {
        this.cmJ.addPostData(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getResult() {
        String postNetData = this.cmJ.postNetData();
        this.eMd = new NewErrorData();
        this.eMd.parserJson(postNetData);
        return postNetData;
    }

    public boolean isRequestSuccess() {
        if (this.cmJ != null) {
            return this.cmJ.bvQ().bwA().isRequestSuccess();
        }
        return false;
    }

    public String bos() {
        if (this.cmJ != null) {
            return this.cmJ.getErrorString();
        }
        return null;
    }
}
