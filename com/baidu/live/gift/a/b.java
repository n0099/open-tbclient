package com.baidu.live.gift.a;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public String aLF;
    public int aSe;
    public int aTY;
    public String aTk;
    public String aTl;
    public long aTm;
    public g aXT;
    public long aYk;
    public String liveId;
    public String mGiftName;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;
    public Map<Long, Long> aYm = new HashMap();
    public String aYl = TbadkCoreApplication.getCurrentTbs();

    public b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        this.aYk = j;
        this.aLF = gVar.Fd();
        this.userId = str;
        this.userName = str2;
        this.liveId = str3;
        this.roomId = str4;
        this.aTk = str5;
        this.mGiftName = gVar.Fe();
        this.aTY = gVar.aSk;
        this.aSe = gVar.Fi();
        this.sceneFrom = gVar.getSceneFrom();
        this.aXT = gVar;
        this.otherParams = str6;
        this.aTl = str7;
        this.aTm = j2;
    }

    public boolean Fn() {
        return this.aSe == 6;
    }

    public boolean HD() {
        return this.aSe == 7;
    }
}
