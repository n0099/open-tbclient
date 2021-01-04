package com.baidu.android.imsdk.retrieve;
/* loaded from: classes4.dex */
public class ReportResult {
    private String mJobId;
    private String mValid;

    public ReportResult(String str, String str2) {
        this.mJobId = str;
        this.mValid = str2;
    }

    public String getJobId() {
        return this.mJobId;
    }

    public void setJobId(String str) {
        this.mJobId = str;
    }

    public String getValid() {
        return this.mValid;
    }

    public void setValid(String str) {
        this.mValid = str;
    }
}
