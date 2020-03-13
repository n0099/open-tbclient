package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    public String aaT;
    public int afX;
    public String agZ;
    public int ahC;
    public g alf;
    public long alu;
    public String alv = TbadkCoreApplication.getCurrentTbs();
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.alu = j;
        this.aaT = gVar.rx();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.agZ = str5;
        this.mGiftName = gVar.ry();
        this.ahC = gVar.agd;
        this.afX = gVar.rD();
        this.sceneFrom = gVar.getSceneFrom();
        this.alf = gVar;
        this.otherParams = str6;
    }

    public boolean rI() {
        return this.afX == 6;
    }

    public boolean tO() {
        return this.afX == 7;
    }
}
