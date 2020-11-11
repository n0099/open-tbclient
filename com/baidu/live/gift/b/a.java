package com.baidu.live.gift.b;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ac;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static final String aWH = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aWI = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ac aWJ;

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0182a {
        public static a bcK = new a();
    }

    private a() {
        this.aWJ = new d();
    }

    public static a Jd() {
        return C0182a.bcK;
    }

    public void gL(String str) {
        this.aWJ.gL(str);
    }

    public void GW() {
        this.aWJ.GW();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aUc != null) {
            boolean z3 = com.baidu.live.alphavideo.a.Cl().Cm() && bVar.FB();
            this.aWJ.a(bVar.giftId, bVar.giftName, bVar.aUc.zipName, z3 ? bVar.aUc.videoUrl : bVar.aUc.zipDownloadUrl, z3 ? bVar.aUc.videoMd5 : bVar.aUc.zipMD5, z3, z, z2, false);
        }
    }

    public boolean as(String str, String str2) {
        return this.aWJ.e(str, str2, false);
    }

    public void GX() {
        this.aWJ.GX();
    }
}
