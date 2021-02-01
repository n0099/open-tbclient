package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    public String aNa;
    public int aVH;
    public int aVN;
    public String aWP;
    public String aWQ;
    public long aWR;
    public int aXW;
    public long bZb;
    public int bZc;
    public long bcK;
    public String bcL;
    public Map<Long, Long> bcM;
    public g bct;
    public String bno;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b() {
        this.bcM = new HashMap();
    }

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, int i, long j3, int i2) {
        this.bcM = new HashMap();
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
        this.bcL = TbadkCoreApplication.getCurrentTbs();
        this.otherParams = str6;
        this.aWQ = str7;
        this.aWR = j2;
        this.bno = str8;
        this.aVN = i;
        this.bZb = j3;
        this.bZc = i2;
    }

    public boolean Ee() {
        return this.aVH == 6;
    }

    public boolean GE() {
        return this.aVH == 7;
    }
}
