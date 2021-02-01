package com.baidu.live.gift.c;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ae;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class a {
    public static final String aYh = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aYi = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aYj;

    /* renamed from: com.baidu.live.gift.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0171a {
        public static a beV = new a();
    }

    private a() {
        this.aYj = new d();
    }

    public static a Hq() {
        return C0171a.beV;
    }

    public void fU(String str) {
        this.aYj.fU(str);
    }

    public void EY() {
        this.aYj.EY();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aVp != null) {
            if (z2 || bVar.Dw()) {
                boolean z3 = com.baidu.live.alphavideo.a.zo().zp() && bVar.Dv();
                this.aYj.a(bVar.giftId, bVar.giftName, bVar.aVp.zipName, z3 ? bVar.aVp.videoUrl : bVar.aVp.zipDownloadUrl, z3 ? bVar.aVp.videoMd5 : bVar.aVp.zipMD5, z3, bVar.Dw(), z, z2, bVar.aVr);
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
