package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public int aAg;
    public g aDF;
    public long aDT;
    public String ats;
    public int ayy;
    public String azA;
    public long azB;
    public String azz;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aDV = new HashMap();
    public String aDU = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aDT = j;
        this.ats = gVar.vV();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.azz = str5;
        this.mGiftName = gVar.vW();
        this.aAg = gVar.ayE;
        this.ayy = gVar.wb();
        this.sceneFrom = gVar.getSceneFrom();
        this.aDF = gVar;
        this.otherParams = str6;
        this.azA = str7;
        this.azB = j2;
    }

    public boolean wg() {
        return this.ayy == 6;
    }

    public boolean yn() {
        return this.ayy == 7;
    }
}
