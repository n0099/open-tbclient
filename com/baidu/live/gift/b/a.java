package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.e;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.utils.s;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static final String aWK = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/.dynamicvideo/";
    public static final String aWL = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String gQ(String str) {
        return aWK + str;
    }

    private static String gR(String str) {
        return gQ(str) + "_zip";
    }

    public static String gS(String str) {
        return aWL + str;
    }

    public static void gT(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(s.hG(str)));
            String gQ = gQ(str);
            if (!TextUtils.isEmpty(gQ)) {
                com.baidu.live.f.a.cleanDir(new File(gQ));
            }
            String gR = gR(str);
            if (!TextUtils.isEmpty(gR)) {
                com.baidu.live.f.a.cleanDir(new File(gR));
            }
            String gS = gS(str);
            if (!StringUtils.isNull(gS)) {
                com.baidu.live.f.a.cleanDir(new File(gS));
            }
        }
    }

    public static void Hl() {
        com.baidu.live.f.a.cleanDir(new File(s.PT()));
        com.baidu.live.f.a.cleanDir(new File(aWK));
        com.baidu.live.f.a.cleanDir(new File(aWL));
    }

    public static void a(com.baidu.live.gift.b bVar, final boolean z) {
        if (bVar != null && !TextUtils.isEmpty(bVar.giftId) && bVar.aOD != null && !ar(bVar.giftId, w.gD(bVar.giftId))) {
            new BdAsyncTask<com.baidu.live.gift.b, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: a */
                public Void doInBackground(com.baidu.live.gift.b... bVarArr) {
                    com.baidu.live.gift.b bVar2 = bVarArr[0];
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.giftName) && bVar2.aOD != null) {
                        if (com.baidu.live.alphavideo.a.AW().AX() && bVar2.DO()) {
                            a.a(bVar2.giftId, bVar2.aOD, z);
                        } else if (bVar2.DP()) {
                            a.b(bVar2.giftId, bVar2.aOD, z);
                        }
                    }
                    return null;
                }
            }.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, e eVar, boolean z) {
        String hI = s.hI(eVar.zipName);
        String str2 = "dynamic_video_md5_" + eVar.zipName;
        if (!com.baidu.live.f.b.b(hI, com.baidu.live.f.b.fZ(str2))) {
            com.baidu.live.f.a.cleanDir(new File(s.hJ(eVar.zipName)));
        } else {
            com.baidu.live.f.b.a(str, eVar.videoUrl, s.hH(eVar.zipName), hI, str2, eVar.zipName, eVar.videoMd5, 19, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, e eVar, boolean z) {
        String hJ = s.hJ(eVar.zipName);
        String str2 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + eVar.zipName;
        if (com.baidu.live.f.b.b(hJ, com.baidu.live.f.b.fZ(str2))) {
            com.baidu.live.f.b.a(str, eVar.zipDownloadUrl, s.hH(eVar.zipName), hJ, str2, eVar.zipName, eVar.zipMD5, 19, z);
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

    public static void Hm() {
        com.baidu.live.f.b.dO(19);
    }
}
