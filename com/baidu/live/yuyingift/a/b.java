package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    public String aPa;
    public int aXp;
    public int aXv;
    public String aYx;
    public String aYy;
    public long aYz;
    public int aZB;
    public long bZL;
    public int bZM;
    public g bdZ;
    public long bes;
    public String beu;
    public Map<Long, Long> bev;
    public String boI;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b() {
        this.bev = new HashMap();
    }

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, int i, long j3, int i2) {
        this.bev = new HashMap();
        this.bes = j;
        this.aPa = gVar.Gx();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aYx = str5;
        this.mGiftName = gVar.Gy();
        this.aZB = gVar.aXv;
        this.aXp = gVar.GD();
        this.sceneFrom = gVar.getSceneFrom();
        this.bdZ = gVar;
        this.beu = TbadkCoreApplication.getCurrentTbs();
        this.otherParams = str6;
        this.aYy = str7;
        this.aYz = j2;
        this.boI = str8;
        this.aXv = i;
        this.bZL = j3;
        this.bZM = i2;
    }

    public boolean GJ() {
        return this.aXp == 6;
    }

    public boolean Jj() {
        return this.aXp == 7;
    }
}
