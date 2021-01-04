package com.baidu.live.gift.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    public String aPa;
    public int aXp;
    public BdUniqueId aYC;
    public String aYx;
    public String aYy;
    public long aYz;
    public int aZB;
    public g bdZ;
    public long bes;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> bev = new HashMap();
    public String beu = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
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
        this.otherParams = str6;
        this.aYy = str7;
        this.aYz = j2;
    }

    public boolean GJ() {
        return this.aXp == 6;
    }

    public boolean Jj() {
        return this.aXp == 7;
    }

    public boolean GZ() {
        return this.aXp == 10;
    }
}
