package com.baidu.adp.lib.guide;
/* loaded from: classes.dex */
class BuildException extends RuntimeException {
    private final String mDetailMessage;

    public BuildException() {
        this.mDetailMessage = "General error.";
    }

    public BuildException(String str) {
        this.mDetailMessage = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Build GuideFragment failed: " + this.mDetailMessage;
    }
}
