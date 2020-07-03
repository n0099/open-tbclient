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
/* loaded from: classes3.dex */
public class a {
    private static final String aNK = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String aNL = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String fk(String str) {
        return aNK + str;
    }

    private static String fl(String str) {
        return fk(str) + "_zip";
    }

    public static String fm(String str) {
        return aNL + str;
    }

    public static void fn(String str) {
        String fk = fk(str);
        if (!TextUtils.isEmpty(fk)) {
            com.baidu.live.f.a.cleanDir(new File(fk));
        }
        String fl = fl(str);
        if (!TextUtils.isEmpty(fl)) {
            com.baidu.live.f.a.cleanDir(new File(fl));
        }
        String fm = fm(str);
        if (!StringUtils.isNull(fm)) {
            com.baidu.live.f.a.cleanDir(new File(fm));
        }
    }

    public static void AF() {
        com.baidu.live.f.a.cleanDir(new File(aNK));
        com.baidu.live.f.a.cleanDir(new File(aNL));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aGe != null && !ao(bVar.giftId, v.eY(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.aGe != null) {
                        if (com.baidu.live.alphavideo.a.vj().vk() && bVar2.xs()) {
                            a.a(bVar2.giftId, bVar2.aGe, z);
                        } else if (bVar2.xt()) {
                            a.b(bVar2.giftId, bVar2.aGe, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = aNK + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.eA(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, fl(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String fm = fm(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(fm, com.baidu.live.f.b.eA(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, fm, fm, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean ao(String str, String str2) {
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

    public static void AG() {
        com.baidu.live.f.b.bS(19);
    }
}
