package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.e;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static final String aUv = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String aUw = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String gF(String str) {
        return aUv + str;
    }

    private static String gG(String str) {
        return gF(str) + "_zip";
    }

    public static String gH(String str) {
        return aUw + str;
    }

    public static void gI(String str) {
        String gF = gF(str);
        if (!TextUtils.isEmpty(gF)) {
            com.baidu.live.f.a.cleanDir(new File(gF));
        }
        String gG = gG(str);
        if (!TextUtils.isEmpty(gG)) {
            com.baidu.live.f.a.cleanDir(new File(gG));
        }
        String gH = gH(str);
        if (!StringUtils.isNull(gH)) {
            com.baidu.live.f.a.cleanDir(new File(gH));
        }
    }

    public static void GK() {
        com.baidu.live.f.a.cleanDir(new File(aUv));
        com.baidu.live.f.a.cleanDir(new File(aUw));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aML != null && !ar(bVar.giftId, v.gt(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.aML != null) {
                        if (com.baidu.live.alphavideo.a.AH().AI() && bVar2.Dx()) {
                            a.a(bVar2.giftId, bVar2.aML, z);
                        } else if (bVar2.Dy()) {
                            a.b(bVar2.giftId, bVar2.aML, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = aUv + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.fU(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, gG(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String gH = gH(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(gH, com.baidu.live.f.b.fU(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, gH, gH, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean ar(String str, String str2) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            for (DownloadData downloadData : downloadList) {
                if (19 == downloadData.getType() && downloadData.getId().equals(str) && downloadData.getUrl().equals(str2)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void GL() {
        com.baidu.live.f.b.dK(19);
    }
}
