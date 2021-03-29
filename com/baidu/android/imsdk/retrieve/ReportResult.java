package com.baidu.android.imsdk.retrieve;
/* loaded from: classes.dex */
public class ReportResult {
    public String mJobId;
    public String mValid;

    public ReportResult(String str, String str2) {
        this.mJobId = str;
        this.mValid = str2;
    }

    public String getJobId() {
        return this.mJobId;
    }

    public String getValid() {
        return this.mValid;
    }

    public void setJobId(String str) {
        this.mJobId = str;
    }

    public void setValid(String str) {
        this.mValid = str;
    }
}
