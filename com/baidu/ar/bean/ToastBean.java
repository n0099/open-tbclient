package com.baidu.ar.bean;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class ToastBean implements Serializable {
    private static final long serialVersionUID = 8124965987658747179L;
    private int mId;
    private String mKey;
    private String mMsg;

    public String a() {
        return this.mMsg;
    }

    public void a(String str) {
        this.mMsg = str;
    }

    public void b(String str) {
        this.mKey = str;
    }
}
