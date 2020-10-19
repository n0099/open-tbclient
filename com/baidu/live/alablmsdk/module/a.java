package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.LinkUserStatus;
/* loaded from: classes4.dex */
public class a {
    public long aBd;
    public long aBf;
    public LinkUserStatus aBg;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public UserPermission aBe = UserPermission.VISITER;
    private boolean aBh = false;

    public void a(LinkUserStatus linkUserStatus) {
        this.aBg = linkUserStatus;
        if (this.aBg == LinkUserStatus.DEFAULT) {
            this.aBh = false;
        } else {
            this.aBh = true;
        }
        com.baidu.live.alablmsdk.a.c.d(" updateCurrent  mCurrentStatus = " + this.aBg);
        com.baidu.live.alablmsdk.a.c.fJ(" updateCurrent mCurrentStatus " + this.aBg);
    }

    public boolean BC() {
        return this.aBh;
    }

    public String BD() {
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.aBd + " otherImUk(对方的)=" + this.aBf;
    }

    public static boolean a(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.aBd == 0) ? false : true;
    }
}
