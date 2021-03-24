package com.baidu.adp.lib.guide;
/* loaded from: classes.dex */
public class BuildException extends RuntimeException {
    public static final long serialVersionUID = 6208777692136933357L;
    public final String mDetailMessage;

    public BuildException() {
        this.mDetailMessage = "General error.";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Build GuideFragment failed: " + this.mDetailMessage;
    }

    public BuildException(String str) {
        this.mDetailMessage = str;
    }
}
