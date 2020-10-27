package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.LinkUserStatus;
/* loaded from: classes4.dex */
public class a {
    public long aBi;
    public long aBk;
    public LinkUserStatus aBl;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public UserPermission aBj = UserPermission.VISITER;
    private boolean aBm = false;

    public void a(LinkUserStatus linkUserStatus) {
        this.aBl = linkUserStatus;
        if (this.aBl == LinkUserStatus.DEFAULT) {
            this.aBm = false;
        } else {
            this.aBm = true;
        }
        com.baidu.live.alablmsdk.a.c.d(" updateCurrent  mCurrentStatus = " + this.aBl);
        com.baidu.live.alablmsdk.a.c.fJ(" updateCurrent mCurrentStatus " + this.aBl);
    }

    public boolean BC() {
        return this.aBm;
    }

    public String BD() {
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.aBi + " otherImUk(对方的)=" + this.aBk;
    }

    public static boolean a(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.aBi == 0) ? false : true;
    }
}
