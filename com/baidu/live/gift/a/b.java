package com.baidu.live.gift.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public String aOA;
    public int aXh;
    public String aYp;
    public String aYq;
    public long aYr;
    public BdUniqueId aYu;
    public int aZw;
    public g bdT;
    public long bel;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> ben = new HashMap();
    public String bem = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
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
        this.otherParams = str6;
        this.aYq = str7;
        this.aYr = j2;
    }

    public boolean Eh() {
        return this.aXh == 6;
    }

    public boolean GH() {
        return this.aXh == 7;
    }

    public boolean Ex() {
        return this.aXh == 10;
    }
}
