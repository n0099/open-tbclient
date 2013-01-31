package com.baidu.browser.explorer.share;
/* loaded from: classes.dex */
public class BdSharerOM {
    public static final int TYPE_STREAM = 2;
    public static final int TYPE_TEXT = 1;
    private String mContent;
    private int mContentType;
    private String mExtra1;
    private String mExtra2;
    private String mPath;

    public int getContentType() {
        return this.mContentType;
    }

    public void setContentType(int i) {
        this.mContentType = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public String getExtra1() {
        return this.mExtra1;
    }

    public void setExtra1(String str) {
        this.mExtra1 = str;
    }

    public String getExtra2() {
        return this.mExtra2;
    }

    public void setExtra2(String str) {
        this.mExtra2 = str;
    }
}
