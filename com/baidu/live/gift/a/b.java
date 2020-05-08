package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public int aAm;
    public g aDL;
    public long aDZ;
    public String aty;
    public int ayE;
    public String azF;
    public String azG;
    public long azH;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aEb = new HashMap();
    public String aEa = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aDZ = j;
        this.aty = gVar.vU();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.azF = str5;
        this.mGiftName = gVar.vV();
        this.aAm = gVar.ayK;
        this.ayE = gVar.wa();
        this.sceneFrom = gVar.getSceneFrom();
        this.aDL = gVar;
        this.otherParams = str6;
        this.azG = str7;
        this.azH = j2;
    }

    public boolean wf() {
        return this.ayE == 6;
    }

    public boolean ym() {
        return this.ayE == 7;
    }
}
