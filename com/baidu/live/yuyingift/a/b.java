package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aMj;
    public int aSZ;
    public String aUg;
    public String aUh;
    public long aUi;
    public int aVi;
    public long aZF;
    public g aZo;
    public String bja;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aZH = new HashMap();
    public String aZG = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8) {
        this.aZF = j;
        this.aMj = gVar.Fs();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aUg = str5;
        this.mGiftName = gVar.Ft();
        this.aVi = gVar.aTf;
        this.aSZ = gVar.Fx();
        this.sceneFrom = gVar.getSceneFrom();
        this.aZo = gVar;
        this.otherParams = str6;
        this.aUh = str7;
        this.aUi = j2;
        this.bja = str8;
    }

    public boolean FC() {
        return this.aSZ == 6;
    }

    public boolean HY() {
        return this.aSZ == 7;
    }
}
