package com.baidu.searchbox.retrieve.upload;
/* loaded from: classes4.dex */
public class FetchResult {
    public String mJobid;
    public String mValid;

    public FetchResult(String str, String str2) {
        this.mJobid = str;
        this.mValid = str2;
    }

    public String getJobid() {
        return this.mJobid;
    }

    public String getValid() {
        return this.mValid;
    }

    public void setJobid(String str) {
        this.mJobid = str;
    }

    public void setValid(String str) {
        this.mValid = str;
    }
}
