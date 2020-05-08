package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.e;
import com.baidu.live.gift.u;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final String aFw = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String aFx = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String eu(String str) {
        return aFw + str;
    }

    private static String ev(String str) {
        return eu(str) + "_zip";
    }

    public static String ew(String str) {
        return aFx + str;
    }

    public static void ex(String str) {
        String eu = eu(str);
        if (!TextUtils.isEmpty(eu)) {
            com.baidu.live.f.a.cleanDir(new File(eu));
        }
        String ev = ev(str);
        if (!TextUtils.isEmpty(ev)) {
            com.baidu.live.f.a.cleanDir(new File(ev));
        }
        String ew = ew(str);
        if (!StringUtils.isNull(ew)) {
            com.baidu.live.f.a.cleanDir(new File(ew));
        }
    }

    public static void yQ() {
        com.baidu.live.f.a.cleanDir(new File(aFw));
        com.baidu.live.f.a.cleanDir(new File(aFx));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.ayq != null && !ab(bVar.giftId, u.ej(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.ayq != null) {
                        if (com.baidu.live.alphavideo.a.tK().tL() && bVar2.vB()) {
                            a.a(bVar2.giftId, bVar2.ayq, z);
                        } else if (bVar2.vC()) {
                            a.b(bVar2.giftId, bVar2.ayq, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = aFw + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.dQ(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, ev(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String ew = ew(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(ew, com.baidu.live.f.b.dQ(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, ew, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean ab(String str, String str2) {
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

    public static void yR() {
        com.baidu.live.f.b.bD(19);
    }
}
