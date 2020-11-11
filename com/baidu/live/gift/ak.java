package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class ak {
    public static final String aWH = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aWI = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ac aWJ;

    /* loaded from: classes4.dex */
    private static class a {
        public static ak aWK = new ak();
    }

    private ak() {
        this.aWJ = new s();
    }

    public static ak Hx() {
        return a.aWK;
    }

    public void gL(String str) {
        this.aWJ.gL(str);
    }

    public void GW() {
        this.aWJ.GW();
    }

    public void a(b bVar, boolean z, boolean z2) {
        a(bVar, z, false, z2);
    }

    public void a(b bVar, boolean z, boolean z2, boolean z3) {
        if (bVar != null && bVar.aUc != null) {
            boolean z4 = com.baidu.live.alphavideo.a.Cl().Cm() && bVar.FB();
            this.aWJ.a(bVar.giftId, bVar.giftName, bVar.aUc.zipName, z4 ? bVar.aUc.videoUrl : bVar.aUc.zipDownloadUrl, z4 ? bVar.aUc.videoMd5 : bVar.aUc.zipMD5, z4, z, z2, z3);
        }
    }

    public boolean as(String str, String str2) {
        return this.aWJ.e(str, str2, false);
    }

    public void GX() {
        this.aWJ.GX();
    }
}
