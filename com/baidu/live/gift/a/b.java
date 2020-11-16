package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aLy;
    public int aSH;
    public String aTN;
    public String aTO;
    public long aTP;
    public int aUP;
    public g aYV;
    public long aZm;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aZo = new HashMap();
    public String aZn = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aZm = j;
        this.aLy = gVar.Fk();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aTN = str5;
        this.mGiftName = gVar.Fl();
        this.aUP = gVar.aSN;
        this.aSH = gVar.Fp();
        this.sceneFrom = gVar.getSceneFrom();
        this.aYV = gVar;
        this.otherParams = str6;
        this.aTO = str7;
        this.aTP = j2;
    }

    public boolean Fu() {
        return this.aSH == 6;
    }

    public boolean HQ() {
        return this.aSH == 7;
    }
}
