package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public String aAL;
    public int aGt;
    public String aHt;
    public String aHu;
    public long aHv;
    public int aIb;
    public g aLR;
    public long aMe;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aMg = new HashMap();
    public String aMf = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aMe = j;
        this.aAL = gVar.xM();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aHt = str5;
        this.mGiftName = gVar.xN();
        this.aIb = gVar.aGz;
        this.aGt = gVar.xR();
        this.sceneFrom = gVar.getSceneFrom();
        this.aLR = gVar;
        this.otherParams = str6;
        this.aHu = str7;
        this.aHv = j2;
    }

    public boolean xW() {
        return this.aGt == 6;
    }

    public boolean Ac() {
        return this.aGt == 7;
    }
}
