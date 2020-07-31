package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aBY;
    public int aHO;
    public String aIO;
    public String aIP;
    public long aIQ;
    public int aJy;
    public g aNm;
    public long aNz;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aNB = new HashMap();
    public String aNA = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aNz = j;
        this.aBY = gVar.yo();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aIO = str5;
        this.mGiftName = gVar.yp();
        this.aJy = gVar.aHU;
        this.aHO = gVar.yt();
        this.sceneFrom = gVar.getSceneFrom();
        this.aNm = gVar;
        this.otherParams = str6;
        this.aIP = str7;
        this.aIQ = j2;
    }

    public boolean yy() {
        return this.aHO == 6;
    }

    public boolean AE() {
        return this.aHO == 7;
    }
}
