package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    public String aHk;
    public int aNb;
    public int aOL;
    public String aOb;
    public String aOc;
    public long aOd;
    public g aSB;
    public long aSO;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aSQ = new HashMap();
    public String aSP = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aSO = j;
        this.aHk = gVar.DR();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aOb = str5;
        this.mGiftName = gVar.DS();
        this.aOL = gVar.aNh;
        this.aNb = gVar.DW();
        this.sceneFrom = gVar.getSceneFrom();
        this.aSB = gVar;
        this.otherParams = str6;
        this.aOc = str7;
        this.aOd = j2;
    }

    public boolean Eb() {
        return this.aNb == 6;
    }

    public boolean Gh() {
        return this.aNb == 7;
    }
}
