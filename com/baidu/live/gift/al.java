package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class al {
    public static final String aVp = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aVq = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ad aVr;

    /* loaded from: classes4.dex */
    private static class a {
        public static al aVs = new al();
    }

    private al() {
        this.aVr = new t();
    }

    public static al GW() {
        return a.aVs;
    }

    public void gG(String str) {
        this.aVr.gG(str);
    }

    public void Gv() {
        this.aVr.Gv();
    }

    public void a(b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aSJ != null) {
            boolean z3 = com.baidu.live.alphavideo.a.BT().BU() && bVar.Fa();
            this.aVr.a(bVar.giftId, bVar.giftName, bVar.aSJ.zipName, z3 ? bVar.aSJ.videoUrl : bVar.aSJ.zipDownloadUrl, z3 ? bVar.aSJ.videoMd5 : bVar.aSJ.zipMD5, z3, z, z2);
        }
    }

    public boolean ar(String str, String str2) {
        return this.aVr.ar(str, str2);
    }

    public void Gw() {
        this.aVr.Gw();
    }
}
