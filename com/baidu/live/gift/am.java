package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class am {
    public static final String aYh = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aYi = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aYj;

    /* loaded from: classes11.dex */
    private static class a {
        public static am aYk = new am();
    }

    private am() {
        this.aYj = new t();
    }

    public static am FC() {
        return a.aYk;
    }

    public void fU(String str) {
        this.aYj.fU(str);
    }

    public void EY() {
        this.aYj.EY();
    }

    public void a(b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aVp != null) {
            if (z2 || bVar.Dx()) {
                boolean z3 = com.baidu.live.alphavideo.a.zo().zp() && bVar.Dv();
                this.aYj.a(bVar.giftId, bVar.giftName, bVar.aVp.zipName, z3 ? bVar.aVp.videoUrl : bVar.aVp.zipDownloadUrl, z3 ? bVar.aVp.videoMd5 : bVar.aVp.zipMD5, z3, bVar.Dx(), z, z2, bVar.aVr);
            }
        }
    }

    public boolean at(String str, String str2) {
        return this.aYj.at(str, str2);
    }

    public void EZ() {
        this.aYj.EZ();
    }
}
