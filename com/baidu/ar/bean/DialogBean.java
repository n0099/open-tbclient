package com.baidu.ar.bean;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class DialogBean implements Serializable {
    private static final long serialVersionUID = 793013907308438500L;
    private String mCancelText;
    private String mConfirmText;
    private int mId;
    private String mKey;
    private String mMessage;
    private String mTitle;

    public String a() {
        return this.mMessage;
    }

    public void a(String str) {
        this.mMessage = str;
    }

    public String b() {
        return this.mTitle;
    }

    public void b(String str) {
        this.mTitle = str;
    }

    public String c() {
        return this.mConfirmText;
    }

    public void c(String str) {
        this.mConfirmText = str;
    }

    public String d() {
        return this.mCancelText;
    }

    public void d(String str) {
        this.mCancelText = str;
    }

    public String e() {
        return this.mKey;
    }

    public void e(String str) {
        this.mKey = str;
    }
}
