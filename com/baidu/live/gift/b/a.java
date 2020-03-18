package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.e;
import com.baidu.live.gift.t;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final String amY = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String amZ = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String dC(String str) {
        return amY + str;
    }

    private static String dD(String str) {
        return dC(str) + "_zip";
    }

    public static String dE(String str) {
        return amZ + str;
    }

    public static void dF(String str) {
        String dC = dC(str);
        if (!TextUtils.isEmpty(dC)) {
            com.baidu.live.f.a.cleanDir(new File(dC));
        }
        String dD = dD(str);
        if (!TextUtils.isEmpty(dD)) {
            com.baidu.live.f.a.cleanDir(new File(dD));
        }
        String dE = dE(str);
        if (!StringUtils.isNull(dE)) {
            com.baidu.live.f.a.cleanDir(new File(dE));
        }
    }

    public static void ux() {
        com.baidu.live.f.a.cleanDir(new File(amY));
        com.baidu.live.f.a.cleanDir(new File(amZ));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.afT != null && !X(bVar.giftId, t.ds(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.afT != null) {
                        if (com.baidu.live.alphavideo.a.pA().pB() && bVar2.rk()) {
                            a.a(bVar2.giftId, bVar2.afT, z);
                        } else if (bVar2.rl()) {
                            a.b(bVar2.giftId, bVar2.afT, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = amY + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.cY(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, dD(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String dE = dE(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(dE, com.baidu.live.f.b.cY(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, dE, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean X(String str, String str2) {
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

    public static void uy() {
        com.baidu.live.f.b.bq(19);
    }
}
