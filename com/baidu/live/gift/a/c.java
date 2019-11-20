package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c {
    public int VZ;
    public String WE;
    public int Wi;
    public g aak;
    public String aav;
    public long aaw;
    public String aax = TbadkCoreApplication.getCurrentTbs();
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public c(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.aaw = j;
        this.aav = gVar.pc();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.WE = str5;
        this.mGiftName = gVar.pd();
        this.Wi = gVar.Wi;
        this.VZ = gVar.pi();
        this.sceneFrom = gVar.getSceneFrom();
        this.aak = gVar;
        this.otherParams = str6;
    }

    public boolean pm() {
        return this.VZ == 6;
    }

    public boolean qD() {
        return this.VZ == 7;
    }
}
