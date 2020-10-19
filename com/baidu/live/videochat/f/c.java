package com.baidu.live.videochat.f;
/* loaded from: classes4.dex */
public class c {
    private String avatar;
    private boolean isHost;
    private String nickName;

    public c(String str, String str2, boolean z) {
        this.avatar = str;
        this.nickName = str2;
        this.isHost = z;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }

    public boolean SR() {
        return this.isHost;
    }
}
