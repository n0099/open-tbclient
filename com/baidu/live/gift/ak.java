package com.baidu.live.gift;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class ak {
    public static final String aUW = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aUX = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ac aUY;

    /* loaded from: classes4.dex */
    private static class a {
        public static ak aUZ = new ak();
    }

    private ak() {
        this.aUY = new s();
    }

    public static ak GO() {
        return a.aUZ;
    }

    public void gF(String str) {
        this.aUY.gF(str);
    }

    public void Gn() {
        this.aUY.Gn();
    }

    public void a(b bVar, boolean z, boolean z2) {
        a(bVar, z, false, z2);
    }

    public void a(b bVar, boolean z, boolean z2, boolean z3) {
        if (bVar != null && bVar.aSr != null) {
            boolean z4 = com.baidu.live.alphavideo.a.BC().BD() && bVar.ES();
            this.aUY.a(bVar.giftId, bVar.giftName, bVar.aSr.zipName, z4 ? bVar.aSr.videoUrl : bVar.aSr.zipDownloadUrl, z4 ? bVar.aSr.videoMd5 : bVar.aSr.zipMD5, z4, z, z2, z3);
        }
    }

    public boolean ar(String str, String str2) {
        return this.aUY.e(str, str2, false);
    }

    public void Go() {
        this.aUY.Go();
    }
}
