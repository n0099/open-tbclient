package com.baidu.live.gift.b;

import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static final String DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + TbConfig.getTempDirName() + "/" + AlaDynamicGiftLocalInfoConfig.DIR_NAME + "/";

    public static String cz(String str) {
        return DIR_PATH + str;
    }

    public static void cA(String str) {
        String cz = cz(str);
        if (!StringUtils.isNull(cz)) {
            com.baidu.live.d.a.cleanDir(new File(cz));
        }
    }

    public static void rb() {
        com.baidu.live.d.a.cleanDir(new File(DIR_PATH));
    }

    public static void b(final String str, final String str2, final String str3, final String str4, final boolean z) {
        new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.live.gift.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                a.c(str, str2, str3, str4, z);
                return null;
            }
        }.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str, String str2, String str3, String str4, boolean z) {
        if (StringUtils.isNull(str3) || StringUtils.isNull(str2) || StringUtils.isNull(str4)) {
            return false;
        }
        String str5 = DIR_PATH + str3;
        String str6 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str3;
        if (!com.baidu.live.d.b.d(str5, com.baidu.live.d.b.bX(str6)) || cB(str)) {
            return false;
        }
        if (BdNetTypeUtil.isWifiNet() || z) {
            com.baidu.live.d.b.a(str, str2, str5, str6, str3, str4, 19, z);
        }
        return true;
    }

    public static boolean cB(String str) {
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || StringUtils.isNull(str)) {
            return false;
        }
        try {
            for (DownloadData downloadData : downloadList) {
                if (19 == downloadData.getType() && downloadData.getId().equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void rc() {
        com.baidu.live.d.b.aY(19);
    }
}
