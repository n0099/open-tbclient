package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static final String aZV = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aZW = TbadkCoreApplication.getInst().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";
    private f aZX;

    /* renamed from: com.baidu.live.gift.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0179a {
        public static a aZY = new a();
    }

    private a() {
        this.aZX = new d();
    }

    public static a Ih() {
        return C0179a.aZY;
    }

    public void he(String str) {
        this.aZX.he(str);
    }

    public void Ii() {
        this.aZX.Ii();
    }

    public void a(com.baidu.live.gift.b bVar, boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aRO != null) {
            this.aZX.a(bVar.giftId, bVar.giftName, bVar.aRO.zipName, bVar.aRO.videoUrl, bVar.aRO.videoMd5, z);
        }
    }

    public boolean at(String str, String str2) {
        return this.aZX.at(str, str2);
    }

    public void Ij() {
        this.aZX.Ij();
    }
}
