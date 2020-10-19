package com.baidu.live.gift.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.w;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.utils.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements f {
    @Override // com.baidu.live.gift.b.f
    public void he(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(s.hX(str)));
            String hg = hg(str);
            if (!TextUtils.isEmpty(hg)) {
                com.baidu.live.f.a.cleanDir(new File(hg));
            }
            String hh = hh(str);
            if (!TextUtils.isEmpty(hh)) {
                com.baidu.live.f.a.cleanDir(new File(hh));
            }
            String hi = hi(str);
            if (!StringUtils.isNull(hi)) {
                com.baidu.live.f.a.cleanDir(new File(hi));
            }
        }
    }

    @Override // com.baidu.live.gift.b.f
    public void Ii() {
        com.baidu.live.f.a.cleanDir(new File(s.QY()));
        com.baidu.live.f.a.cleanDir(new File(a.aZV));
        com.baidu.live.f.a.cleanDir(new File(a.aZW));
    }

    @Override // com.baidu.live.gift.b.f
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z) {
        if (!at(str, w.gR(str))) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.live.gift.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        d.this.b(str, str3, str4, str5, z);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public boolean au(String str, String str2) {
        File[] listFiles;
        if (com.baidu.live.f.a.existFile(str)) {
            if (!com.baidu.live.f.a.isDirectory(str)) {
                FileHelper.deleteFileOrDir(new File(str));
                return true;
            }
            ArrayList<String> gn = com.baidu.live.f.b.gn(str2);
            if (gn == null || gn.size() <= 0 || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
                return true;
            }
            for (File file : listFiles) {
                if (!file.isDirectory() && !gn.contains(com.baidu.live.f.a.getFileMd5(file))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.gift.b.f
    public boolean at(String str, String str2) {
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

    @Override // com.baidu.live.gift.b.f
    public void Ij() {
        com.baidu.live.f.b.dT(19);
    }

    private String hg(String str) {
        return a.aZV + str;
    }

    private String hh(String str) {
        return hg(str) + "_zip";
    }

    private String hi(String str) {
        return a.aZW + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, boolean z) {
        String hZ = s.hZ(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!au(hZ, str5)) {
            com.baidu.live.f.a.cleanDir(new File(s.ia(str2)));
        } else {
            com.baidu.live.f.b.a(str, str3, s.hY(str2), hZ, str5, str2, str4, 19, z);
        }
    }
}
