package com.baidu.live.gift.c;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ae;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class a {
    public static final String aUZ = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aVa = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aVb;

    /* renamed from: com.baidu.live.gift.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0170a {
        public static a bbO = new a();
    }

    private a() {
        this.aVb = new d();
    }

    public static a Ga() {
        return C0170a.bbO;
    }

    public void fz(String str) {
        this.aVb.fz(str);
    }

    public void DI() {
        this.aVb.DI();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aSl != null && bVar.Ch()) {
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
