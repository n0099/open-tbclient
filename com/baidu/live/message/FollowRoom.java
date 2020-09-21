package com.baidu.live.message;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class FollowRoom implements Serializable {
    public boolean isFollowed;
    public String liveId;

    public FollowRoom(boolean z, String str) {
        this.isFollowed = z;
        this.liveId = str;
    }
}
