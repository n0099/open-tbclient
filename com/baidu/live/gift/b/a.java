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
    private static final String amO = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String amP = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String dD(String str) {
        return amO + str;
    }

    private static String dE(String str) {
        return dD(str) + "_zip";
    }

    public static String dF(String str) {
        return amP + str;
    }

    public static void dG(String str) {
        String dD = dD(str);
        if (!TextUtils.isEmpty(dD)) {
            com.baidu.live.f.a.cleanDir(new File(dD));
        }
        String dE = dE(str);
        if (!TextUtils.isEmpty(dE)) {
            com.baidu.live.f.a.cleanDir(new File(dE));
        }
        String dF = dF(str);
        if (!StringUtils.isNull(dF)) {
            com.baidu.live.f.a.cleanDir(new File(dF));
        }
    }

    public static void us() {
        com.baidu.live.f.a.cleanDir(new File(amO));
        com.baidu.live.f.a.cleanDir(new File(amP));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.afJ != null && !Y(bVar.giftId, t.dt(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.afJ != null) {
                        if (com.baidu.live.alphavideo.a.pv().pw() && bVar2.rf()) {
                            a.a(bVar2.giftId, bVar2.afJ, z);
                        } else if (bVar2.rg()) {
                            a.b(bVar2.giftId, bVar2.afJ, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = amO + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.cZ(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, dE(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String dF = dF(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(dF, com.baidu.live.f.b.cZ(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, dF, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean Y(String str, String str2) {
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

    public static void ut() {
        com.baidu.live.f.b.bq(19);
    }
}
