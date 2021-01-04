package com.baidu.live.gift.c;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ae;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class a {
    public static final String aZM = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aZN = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aZO;

    /* renamed from: com.baidu.live.gift.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0179a {
        public static a bgF = new a();
    }

    private a() {
        this.aZO = new d();
    }

    public static a JV() {
        return C0179a.bgF;
    }

    public void gL(String str) {
        this.aZO.gL(str);
    }

    public void HD() {
        this.aZO.HD();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aWY != null && bVar.Gc()) {
            boolean z3 = com.baidu.live.alphavideo.a.CC().CD() && bVar.Gb();
            this.aZO.a(bVar.giftId, bVar.giftName, bVar.aWY.zipName, z3 ? bVar.aWY.videoUrl : bVar.aWY.zipDownloadUrl, z3 ? bVar.aWY.videoMd5 : bVar.aWY.zipMD5, z3, z, z2);
        }
    }

    public boolean au(String str, String str2) {
        return this.aZO.au(str, str2);
    }

    public void HE() {
        this.aZO.HE();
    }
}
