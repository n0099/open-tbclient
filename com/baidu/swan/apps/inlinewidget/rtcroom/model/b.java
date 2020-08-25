package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class b {
    public String ctQ;
    public long ctR;
    public String ctS;
    public String displayName;
    public String token;

    public b(String str, long j, String str2, String str3, String str4) {
        this.ctQ = str;
        this.ctR = j;
        this.displayName = str2;
        this.ctS = str3;
        this.token = str4;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.ctQ) || TextUtils.isEmpty(this.displayName) || TextUtils.isEmpty(this.ctS) || TextUtils.isEmpty(this.token) || !com.baidu.swan.apps.inlinewidget.rtcroom.b.a.aZ(this.ctR)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.ctQ + ";localUserId=" + this.ctR + ";displayName=" + this.displayName + ";rtcAppId=" + this.ctS + ";token=" + this.token;
    }
}
