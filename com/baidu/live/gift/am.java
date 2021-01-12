package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class am {
    public static final String aUZ = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aVa = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aVb;

    /* loaded from: classes10.dex */
    private static class a {
        public static am aVc = new am();
    }

    private am() {
        this.aVb = new t();
    }

    public static am Em() {
        return a.aVc;
    }

    public void fz(String str) {
        this.aVb.fz(str);
    }

    public void DI() {
        this.aVb.DI();
    }

    public void a(b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aSl != null && bVar.Ci()) {
            boolean z3 = com.baidu.live.alphavideo.a.yH().yI() && bVar.Cg();
            this.aVb.a(bVar.giftId, bVar.giftName, bVar.aSl.zipName, z3 ? bVar.aSl.videoUrl : bVar.aSl.zipDownloadUrl, z3 ? bVar.aSl.videoMd5 : bVar.aSl.zipMD5, z3, z, z2);
        }
    }

    public boolean at(String str, String str2) {
        return this.aVb.at(str, str2);
    }

    public void DJ() {
        this.aVb.DJ();
    }
}
