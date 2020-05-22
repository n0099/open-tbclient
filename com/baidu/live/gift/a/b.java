package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public int aDX;
    public String aEX;
    public String aEY;
    public long aEZ;
    public int aFF;
    public g aJk;
    public long aJy;
    public String ayw;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aJA = new HashMap();
    public String aJz = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aJy = j;
        this.ayw = gVar.xl();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aEX = str5;
        this.mGiftName = gVar.xm();
        this.aFF = gVar.aEd;
        this.aDX = gVar.xr();
        this.sceneFrom = gVar.getSceneFrom();
        this.aJk = gVar;
        this.otherParams = str6;
        this.aEY = str7;
        this.aEZ = j2;
    }

    public boolean xw() {
        return this.aDX == 6;
    }

    public boolean zC() {
        return this.aDX == 7;
    }
}
