package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class b {
    public String ctU;
    public long ctV;
    public String ctW;
    public String displayName;
    public String token;

    public b(String str, long j, String str2, String str3, String str4) {
        this.ctU = str;
        this.ctV = j;
        this.displayName = str2;
        this.ctW = str3;
        this.token = str4;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.ctU) || TextUtils.isEmpty(this.displayName) || TextUtils.isEmpty(this.ctW) || TextUtils.isEmpty(this.token) || !com.baidu.swan.apps.inlinewidget.rtcroom.b.a.aZ(this.ctV)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.ctU + ";localUserId=" + this.ctV + ";displayName=" + this.displayName + ";rtcAppId=" + this.ctW + ";token=" + this.token;
    }
}
