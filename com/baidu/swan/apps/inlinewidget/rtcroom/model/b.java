package com.baidu.swan.apps.inlinewidget.rtcroom.model;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class b {
    public long ddZ;
    public String displayName;
    public String roomName;
    public String rtcAppId;
    public String token;

    public b(String str, long j, String str2, String str3, String str4) {
        this.roomName = str;
        this.ddZ = j;
        this.displayName = str2;
        this.rtcAppId = str3;
        this.token = str4;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.roomName) || TextUtils.isEmpty(this.displayName) || TextUtils.isEmpty(this.rtcAppId) || TextUtils.isEmpty(this.token) || !com.baidu.swan.apps.inlinewidget.rtcroom.b.a.cm(this.ddZ)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.roomName + ";localUserId=" + this.ddZ + ";displayName=" + this.displayName + ";rtcAppId=" + this.rtcAppId + ";token=" + this.token;
    }
}
