package com.baidu.live.yuyingift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aOt;
    public int aVJ;
    public String aWR;
    public String aWS;
    public long aWT;
    public int aXW;
    public long bcJ;
    public g bcr;
    public String bnb;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> bcL = new HashMap();
    public String bcK = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8) {
        this.bcJ = j;
        this.aOt = gVar.GX();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aWR = str5;
        this.mGiftName = gVar.GY();
        this.aXW = gVar.aVP;
        this.aVJ = gVar.Hc();
        this.sceneFrom = gVar.getSceneFrom();
        this.bcr = gVar;
        this.otherParams = str6;
        this.aWS = str7;
        this.aWT = j2;
        this.bnb = str8;
    }

    public boolean Hi() {
        return this.aVJ == 6;
    }

    public boolean JH() {
        return this.aVJ == 7;
    }
}
