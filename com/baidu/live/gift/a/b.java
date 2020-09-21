package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aIB;
    public int aOT;
    public String aPZ;
    public int aQN;
    public String aQa;
    public long aQb;
    public g aUI;
    public long aUZ;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aVb = new HashMap();
    public String aVa = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aUZ = j;
        this.aIB = gVar.Eh();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aPZ = str5;
        this.mGiftName = gVar.Ei();
        this.aQN = gVar.aOZ;
        this.aOT = gVar.Em();
        this.sceneFrom = gVar.getSceneFrom();
        this.aUI = gVar;
        this.otherParams = str6;
        this.aQa = str7;
        this.aQb = j2;
    }

    public boolean Er() {
        return this.aOT == 6;
    }

    public boolean GH() {
        return this.aOT == 7;
    }
}
