package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c {
    public int WB;
    public String WX;
    public int Ws;
    public g aaC;
    public String aaN;
    public long aaO;
    public String aaP = TbadkCoreApplication.getCurrentTbs();
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public c(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.aaO = j;
        this.aaN = gVar.pc();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.WX = str5;
        this.mGiftName = gVar.pd();
        this.WB = gVar.WB;
        this.Ws = gVar.pi();
        this.sceneFrom = gVar.getSceneFrom();
        this.aaC = gVar;
        this.otherParams = str6;
    }

    public boolean pm() {
        return this.Ws == 6;
    }

    public boolean qC() {
        return this.Ws == 7;
    }
}
