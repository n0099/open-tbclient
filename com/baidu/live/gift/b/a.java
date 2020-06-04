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
    private static final String aLe = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    private static final String aLf = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String fe(String str) {
        return aLe + str;
    }

    private static String ff(String str) {
        return fe(str) + "_zip";
    }

    public static String fg(String str) {
        return aLf + str;
    }

    public static void fh(String str) {
        String fe = fe(str);
        if (!TextUtils.isEmpty(fe)) {
            com.baidu.live.f.a.cleanDir(new File(fe));
        }
        String ff = ff(str);
        if (!TextUtils.isEmpty(ff)) {
            com.baidu.live.f.a.cleanDir(new File(ff));
        }
        String fg = fg(str);
        if (!StringUtils.isNull(fg)) {
            com.baidu.live.f.a.cleanDir(new File(fg));
        }
    }

    public static void Af() {
        com.baidu.live.f.a.cleanDir(new File(aLe));
        com.baidu.live.f.a.cleanDir(new File(aLf));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aDI != null && !an(bVar.giftId, v.eS(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.aDI != null) {
                        if (com.baidu.live.alphavideo.a.uR().uS() && bVar2.wR()) {
                            a.a(bVar2.giftId, bVar2.aDI, z);
                        } else if (bVar2.wS()) {
                            a.b(bVar2.giftId, bVar2.aDI, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String str2 = aLe + eVar.zipName;
        String str3 = "dynamic_video_md5_" + eVar.zipName;
        if (com.baidu.live.f.b.b(str2, com.baidu.live.f.b.ev(str3))) {
            com.baidu.live.f.b.a(str, eVar.videoUrl, ff(eVar.zipName), str2, str3, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String fg = fg(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(fg, com.baidu.live.f.b.ev(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, fg, fg, str2, eVar.zipName, eVar.zipMD5, 19, z);
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

    public static void Ag() {
        com.baidu.live.f.b.bM(19);
    }
}
