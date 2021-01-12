package com.baidu.live.follow.pendant;
/* loaded from: classes10.dex */
public class b {
    private String aSf;
    private boolean isFollow = false;
    private String nickName;
    private String userId;

    public b(String str, String str2, String str3) {
        this.nickName = str;
        this.aSf = str2;
        this.userId = str3;
    }

    public void bu(boolean z) {
        this.isFollow = z;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String Cf() {
        return this.aSf;
    }

    public String getUserId() {
        return this.userId;
    }
}
