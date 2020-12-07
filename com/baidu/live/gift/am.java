package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class am {
    public static final String aYh = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aYi = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aYj;

    /* loaded from: classes4.dex */
    private static class a {
        public static am aYk = new am();
    }

    private am() {
        this.aYj = new t();
    }

    public static am IF() {
        return a.aYk;
    }

    public void ha(String str) {
        this.aYj.ha(str);
    }

    public void Ic() {
        this.aYj.Ic();
    }

    public void a(b bVar, boolean z, boolean z2) {
        a(bVar, z, false, z2);
    }

    public void a(b bVar, boolean z, boolean z2, boolean z3) {
        if (bVar != null && bVar.aVt != null) {
            boolean z4 = com.baidu.live.alphavideo.a.Dl().Dm() && bVar.GD();
            this.aYj.a(bVar.giftId, bVar.giftName, bVar.aVt.zipName, z4 ? bVar.aVt.videoUrl : bVar.aVt.zipDownloadUrl, z4 ? bVar.aVt.videoMd5 : bVar.aVt.zipMD5, z4, z, z2, z3);
        }
    }

    public boolean aw(String str, String str2) {
        return this.aYj.e(str, str2, false);
    }

    public void Id() {
        this.aYj.Id();
    }
}
