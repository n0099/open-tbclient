package com.baidu.live.gift.b;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ac;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static final String aUW = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aUX = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ac aUY;

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0180a {
        public static a baZ = new a();
    }

    private a() {
        this.aUY = new d();
    }

    public static a Iu() {
        return C0180a.baZ;
    }

    public void gF(String str) {
        this.aUY.gF(str);
    }

    public void Gn() {
        this.aUY.Gn();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aSr != null) {
            boolean z3 = com.baidu.live.alphavideo.a.BC().BD() && bVar.ES();
            this.aUY.a(bVar.giftId, bVar.giftName, bVar.aSr.zipName, z3 ? bVar.aSr.videoUrl : bVar.aSr.zipDownloadUrl, z3 ? bVar.aSr.videoMd5 : bVar.aSr.zipMD5, z3, z, z2, false);
        }
    }

    public boolean ar(String str, String str2) {
        return this.aUY.e(str, str2, false);
    }

    public void Go() {
        this.aUY.Go();
    }
}
