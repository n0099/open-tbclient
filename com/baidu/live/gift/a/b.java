package com.baidu.live.gift.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public String aKn;
    public int aSC;
    public String aTK;
    public String aTL;
    public long aTM;
    public BdUniqueId aTP;
    public int aUO;
    public long aZD;
    public g aZl;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aZF = new HashMap();
    public String aZE = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
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
        this.otherParams = str6;
        this.aTL = str7;
        this.aTM = j2;
    }

    public boolean CO() {
        return this.aSC == 6;
    }

    public boolean Fo() {
        return this.aSC == 7;
    }

    public boolean De() {
        return this.aSC == 10;
    }
}
