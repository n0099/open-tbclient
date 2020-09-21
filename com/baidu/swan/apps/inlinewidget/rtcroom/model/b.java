package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    public long cvY;
    public String cvZ;
    public String displayName;
    public String roomName;
    public String token;

    public b(String str, long j, String str2, String str3, String str4) {
        this.roomName = str;
        this.cvY = j;
        this.displayName = str2;
        this.cvZ = str3;
        this.token = str4;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.roomName) || TextUtils.isEmpty(this.displayName) || TextUtils.isEmpty(this.cvZ) || TextUtils.isEmpty(this.token) || !com.baidu.swan.apps.inlinewidget.rtcroom.b.a.ba(this.cvY)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.roomName + ";localUserId=" + this.cvY + ";displayName=" + this.displayName + ";rtcAppId=" + this.cvZ + ";token=" + this.token;
    }
}
