package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public String aKn;
    public int aSC;
    public int aSI;
    public String aTK;
    public String aTL;
    public long aTM;
    public int aUO;
    public long aZD;
    public String aZE;
    public Map<Long, Long> aZF;
    public g aZl;
    public long bUZ;
    public int bVa;
    public String bjV;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b() {
        this.aZF = new HashMap();
    }

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, int i, long j3, int i2) {
        this.aZF = new HashMap();
        this.aZD = j;
        this.aKn = gVar.CC();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aTK = str5;
        this.mGiftName = gVar.CD();
        this.aUO = gVar.aSI;
        this.aSC = gVar.CI();
        this.sceneFrom = gVar.getSceneFrom();
        this.aZl = gVar;
        this.aZE = TbadkCoreApplication.getCurrentTbs();
        this.otherParams = str6;
        this.aTL = str7;
        this.aTM = j2;
        this.bjV = str8;
        this.aSI = i;
        this.bUZ = j3;
        this.bVa = i2;
    }

    public boolean CO() {
        return this.aSC == 6;
    }

    public boolean Fo() {
        return this.aSC == 7;
    }
}
