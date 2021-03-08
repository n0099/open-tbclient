package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public String aOA;
    public int aXh;
    public int aXn;
    public String aYp;
    public String aYq;
    public long aYr;
    public int aZw;
    public g bdT;
    public long bel;
    public String bem;
    public Map<Long, Long> ben;
    public String boO;
    public long caB;
    public int caC;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b() {
        this.ben = new HashMap();
    }

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, int i, long j3, int i2) {
        this.ben = new HashMap();
        this.bel = j;
        this.aOA = gVar.DU();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aYp = str5;
        this.mGiftName = gVar.DV();
        this.aZw = gVar.aXn;
        this.aXh = gVar.Eb();
        this.sceneFrom = gVar.getSceneFrom();
        this.bdT = gVar;
        this.bem = TbadkCoreApplication.getCurrentTbs();
        this.otherParams = str6;
        this.aYq = str7;
        this.aYr = j2;
        this.boO = str8;
        this.aXn = i;
        this.caB = j3;
        this.caC = i2;
    }

    public boolean Eh() {
        return this.aXh == 6;
    }

    public boolean GH() {
        return this.aXh == 7;
    }
}
