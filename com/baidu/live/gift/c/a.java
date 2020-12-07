package com.baidu.live.gift.c;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.gift.ae;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static final String aYh = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aYi = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private ae aYj;

    /* renamed from: com.baidu.live.gift.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0185a {
        public static a beX = new a();
    }

    private a() {
        this.aYj = new d();
    }

    public static a Ku() {
        return C0185a.beX;
    }

    public void ha(String str) {
        this.aYj.ha(str);
    }

    public void Ic() {
        this.aYj.Ic();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        a(bVar, z, false);
    }

    public void a(com.baidu.live.gift.b bVar, boolean z, boolean z2) {
        if (bVar != null && bVar.aVt != null) {
            boolean z3 = com.baidu.live.alphavideo.a.Dl().Dm() && bVar.GD();
            this.aYj.a(bVar.giftId, bVar.giftName, bVar.aVt.zipName, z3 ? bVar.aVt.videoUrl : bVar.aVt.zipDownloadUrl, z3 ? bVar.aVt.videoMd5 : bVar.aVt.zipMD5, z3, z, z2, false);
        }
    }

    public boolean aw(String str, String str2) {
        return this.aYj.e(str, str2, false);
    }

    public void Id() {
        this.aYj.Id();
    }
}
