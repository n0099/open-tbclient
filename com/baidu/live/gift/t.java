package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t implements ad {
    @Override // com.baidu.live.gift.ad
    public void gG(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.hT(str)));
            String gH = gH(str);
            if (!TextUtils.isEmpty(gH)) {
                com.baidu.live.f.a.cleanDir(new File(gH));
            }
            String gI = gI(str);
            if (!TextUtils.isEmpty(gI)) {
                com.baidu.live.f.a.cleanDir(new File(gI));
            }
            String gJ = gJ(str);
            if (!StringUtils.isNull(gJ)) {
                com.baidu.live.f.a.cleanDir(new File(gJ));
            }
        }
    }

    @Override // com.baidu.live.gift.ad
    public void Gv() {
        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.PR()));
        com.baidu.live.f.a.cleanDir(new File(al.aVp));
        com.baidu.live.f.a.cleanDir(new File(al.aVq));
    }

    @Override // com.baidu.live.gift.ad
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !ar(str, ai.hb(str))) {
            new BdAsyncTask<Void, Void, Long>() { // from class: com.baidu.live.gift.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: d */
                public Long doInBackground(Void... voidArr) {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    return z ? Long.valueOf(t.b(str, str3, str4, str5, z2)) : Long.valueOf(t.c(str, str3, str4, str5, z2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(Long l) {
                    super.onPostExecute(l);
                    if (z3 && l != null && l.longValue() > 0) {
                        v.f(str3, l.longValue());
                    }
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.baidu.live.gift.ad
    public boolean ar(String str, String str2) {
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

    @Override // com.baidu.live.gift.ad
    public void Gw() {
        com.baidu.live.f.b.dT(19);
    }

    private String gH(String str) {
        return al.aVp + str;
    }

    private String gI(String str) {
        return gH(str) + "_zip";
    }

    private String gJ(String str) {
        return al.aVq + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, String str3, String str4, boolean z) {
        String hV = com.baidu.live.ab.b.hV(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.f.b.b(hV, com.baidu.live.f.b.go(str5))) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.hW(str2)));
            return new File(hV).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ab.b.hU(str2), hV, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String hW = com.baidu.live.ab.b.hW(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.f.b.b(hW, com.baidu.live.f.b.go(str5))) {
            return new File(hW).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ab.b.hU(str2), hW, str5, str2, str4, 19, z);
        return -1L;
    }
}
