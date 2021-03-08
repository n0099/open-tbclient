package com.baidu.live.videochat.f;
/* loaded from: classes10.dex */
public class c {
    private String avatar;
    private boolean isHost;
    private String nickName;
    private String userId;

    public c(String str, String str2, String str3, boolean z) {
        this.avatar = str;
        this.nickName = str2;
        this.isHost = z;
        this.userId = str3;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }

    public boolean Xj() {
        return this.isHost;
    }

    public String getUserId() {
        return this.userId;
    }
}
