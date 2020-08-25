package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    public String aHi;
    public int aMZ;
    public String aNZ;
    public int aOJ;
    public String aOa;
    public long aOb;
    public long aSM;
    public g aSz;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aSO = new HashMap();
    public String aSN = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aSM = j;
        this.aHi = gVar.DR();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aNZ = str5;
        this.mGiftName = gVar.DS();
        this.aOJ = gVar.aNf;
        this.aMZ = gVar.DW();
        this.sceneFrom = gVar.getSceneFrom();
        this.aSz = gVar;
        this.otherParams = str6;
        this.aOa = str7;
        this.aOb = j2;
    }

    public boolean Eb() {
        return this.aMZ == 6;
    }

    public boolean Gh() {
        return this.aMZ == 7;
    }
}
