package com.baidu.live.gift.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    public String aNa;
    public int aVH;
    public String aWP;
    public String aWQ;
    public long aWR;
    public BdUniqueId aWU;
    public int aXW;
    public long bcK;
    public g bct;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> bcM = new HashMap();
    public String bcL = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.bcK = j;
        this.aNa = gVar.DR();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aWP = str5;
        this.mGiftName = gVar.DS();
        this.aXW = gVar.aVN;
        this.aVH = gVar.DY();
        this.sceneFrom = gVar.getSceneFrom();
        this.bct = gVar;
        this.otherParams = str6;
        this.aWQ = str7;
        this.aWR = j2;
    }

    public boolean Ee() {
        return this.aVH == 6;
    }

    public boolean GE() {
        return this.aVH == 7;
    }

    public boolean Eu() {
        return this.aVH == 10;
    }
}
