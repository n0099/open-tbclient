package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    public String abe;
    public int agi;
    public int ahM;
    public String ahj;
    public long alE;
    public String alF = TbadkCoreApplication.getCurrentTbs();
    public g alq;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.alE = j;
        this.abe = gVar.rC();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.ahj = str5;
        this.mGiftName = gVar.rD();
        this.ahM = gVar.ago;
        this.agi = gVar.rI();
        this.sceneFrom = gVar.getSceneFrom();
        this.alq = gVar;
        this.otherParams = str6;
    }

    public boolean rN() {
        return this.agi == 6;
    }

    public boolean tT() {
        return this.agi == 7;
    }
}
