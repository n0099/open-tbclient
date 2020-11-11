package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aNj;
    public int aUs;
    public long aVA;
    public String aVy;
    public String aVz;
    public int aWA;
    public g baH;
    public long baY;
    public String bku;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> bba = new HashMap();
    public String baZ = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8) {
        this.baY = j;
        this.aNj = gVar.FT();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aVy = str5;
        this.mGiftName = gVar.FU();
        this.aWA = gVar.aUy;
        this.aUs = gVar.FY();
        this.sceneFrom = gVar.getSceneFrom();
        this.baH = gVar;
        this.otherParams = str6;
        this.aVz = str7;
        this.aVA = j2;
        this.bku = str8;
    }

    public boolean Gd() {
        return this.aUs == 6;
    }

    public boolean Iz() {
        return this.aUs == 7;
    }
}
