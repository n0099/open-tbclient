package com.baidu.live.u;

import android.content.Context;
/* loaded from: classes4.dex */
public class a {
    public String aVy;
    public long bri;
    public Context context;
    public boolean isHost;
    public int liveType;
    public String otherParams;
    public String portrait;
    public long userId;
    public String userName;

    public a(Context context, int i, long j, boolean z, String str) {
        this.context = context;
        this.liveType = i;
        this.userId = j;
        this.isHost = z;
        this.portrait = str;
        this.otherParams = "";
    }

    public a(Context context, int i, long j, boolean z, String str, String str2, String str3, long j2) {
        this.context = context;
        this.liveType = i;
        this.userId = j;
        this.isHost = z;
        this.portrait = str;
        this.otherParams = str2;
        this.aVy = str3;
        this.bri = j2;
    }
}
