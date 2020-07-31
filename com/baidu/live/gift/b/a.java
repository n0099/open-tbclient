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
/* loaded from: classes4.dex */
public class a {
    private static final String aPf = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String aPg = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String fj(String str) {
        return aPf + str;
    }

    private static String fk(String str) {
        return fj(str) + "_zip";
    }

    public static String fl(String str) {
        return aPg + str;
    }

    public static void fm(String str) {
        String fj = fj(str);
        if (!TextUtils.isEmpty(fj)) {
            com.baidu.live.f.a.cleanDir(new File(fj));
        }
        String fk = fk(str);
        if (!TextUtils.isEmpty(fk)) {
            com.baidu.live.f.a.cleanDir(new File(fk));
        }
        String fl = fl(str);
        if (!StringUtils.isNull(fl)) {
            com.baidu.live.f.a.cleanDir(new File(fl));
        }
    }

    public static void Bh() {
        com.baidu.live.f.a.cleanDir(new File(aPf));
        com.baidu.live.f.a.cleanDir(new File(aPg));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aHz != null && !an(bVar.giftId, v.eX(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.aHz != null) {
                        if (com.baidu.live.alphavideo.a.vj().vk() && bVar2.xU()) {
                            a.a(bVar2.giftId, bVar2.aHz, z);
                        } else if (bVar2.xV()) {
                            a.b(bVar2.giftId, bVar2.aHz, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = aPf + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.ez(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, fk(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String fl = fl(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(fl, com.baidu.live.f.b.ez(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, fl, fl, str2, eVar.zipName, eVar.zipMD5, 19, z);
        }
    }

    public static boolean an(String str, String str2) {
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

    public static void Bi() {
        com.baidu.live.f.b.bY(19);
    }
}
