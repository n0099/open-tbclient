package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a {
    public String YP;
    public int adB;
    public int aeM;
    public String aej;
    public String aiA = TbadkCoreApplication.getCurrentTbs();
    public g aip;
    public long aiz;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.aiz = j;
        this.YP = gVar.qx();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aej = str5;
        this.mGiftName = gVar.qy();
        this.aeM = gVar.adK;
        this.adB = gVar.qD();
        this.sceneFrom = gVar.getSceneFrom();
        this.aip = gVar;
        this.otherParams = str6;
    }

    public boolean qI() {
        return this.adB == 6;
    }

    public boolean sm() {
        return this.adB == 7;
    }
}
