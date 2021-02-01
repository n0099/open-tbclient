package com.baidu.live.follow.pendant;
/* loaded from: classes11.dex */
public class b {
    private String aVj;
    private boolean isFollow = false;
    private String nickName;
    private String userId;

    public b(String str, String str2, String str3) {
        this.nickName = str;
        this.aVj = str2;
        this.userId = str3;
    }

    public void bz(boolean z) {
        this.isFollow = z;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String Du() {
        return this.aVj;
    }

    public String getUserId() {
        return this.userId;
    }
}
