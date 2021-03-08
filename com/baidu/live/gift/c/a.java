package com.baidu.live.gift.c;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ae;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class a {
    public static final String aZH = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aZI = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aZJ;

    /* renamed from: com.baidu.live.gift.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0177a {
        public static a bgy = new a();
    }

    private a() {
        this.aZJ = new d();
    }

    public static a Ht() {
        return C0177a.bgy;
    }

    public void ga(String str) {
        this.aZJ.ga(str);
    }

    public void Fb() {
        this.aZJ.Fb();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aWP != null) {
            if (z2 || bVar.Dz()) {
                boolean z3 = com.baidu.live.alphavideo.a.zr().zs() && bVar.Dy();
                this.aZJ.a(bVar.giftId, bVar.giftName, bVar.aWP.zipName, z3 ? bVar.aWP.videoUrl : bVar.aWP.zipDownloadUrl, z3 ? bVar.aWP.videoMd5 : bVar.aWP.zipMD5, z3, bVar.Dz(), z, z2, bVar.aWR);
            }
        }
    }

    public boolean at(String str, String str2) {
        return this.aZJ.at(str, str2);
    }

    public void Fc() {
        this.aZJ.Fc();
    }
}
