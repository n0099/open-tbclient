package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class b {
    public String Zb;
    public int adQ;
    public String aeS;
    public int afv;
    public g aiX;
    public long ajl;
    public String ajm = TbadkCoreApplication.getCurrentTbs();
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.ajl = j;
        this.Zb = gVar.qE();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aeS = str5;
        this.mGiftName = gVar.qF();
        this.afv = gVar.adZ;
        this.adQ = gVar.qK();
        this.sceneFrom = gVar.getSceneFrom();
        this.aiX = gVar;
        this.otherParams = str6;
    }

    public boolean qP() {
        return this.adQ == 6;
    }

    public boolean sC() {
        return this.adQ == 7;
    }
}
