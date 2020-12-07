package com.baidu.live.gift.c;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements ae {
    @Override // com.baidu.live.gift.ae
    public void ha(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.ag.b.iy(str)));
            String hb = hb(str);
            if (!TextUtils.isEmpty(hb)) {
                com.baidu.live.h.a.cleanDir(new File(hb));
            }
            String hc = hc(str);
            if (!TextUtils.isEmpty(hc)) {
                com.baidu.live.h.a.cleanDir(new File(hc));
            }
            String hd = hd(str);
            if (!StringUtils.isNull(hd)) {
                com.baidu.live.h.a.cleanDir(new File(hd));
            }
        }
    }

    @Override // com.baidu.live.gift.ae
    public void Ic() {
        com.baidu.live.h.a.cleanDir(new File(com.baidu.live.ag.b.Sc()));
        com.baidu.live.h.a.cleanDir(new File(a.aYh));
        com.baidu.live.h.a.cleanDir(new File(a.aYi));
    }

    @Override // com.baidu.live.gift.ae
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !e(str, ac.hw(str), z4)) {
            new BdAsyncTask<Void, Void, Long>() { // from class: com.baidu.live.gift.c.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: d */
                public Long doInBackground(Void... voidArr) {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    return z ? Long.valueOf(d.b(str, str3, str4, str5, z2)) : Long.valueOf(d.c(str, str3, str4, str5, z2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(Long l) {
                    super.onPostExecute(l);
                    if (z3 && l != null && l.longValue() > 0) {
                        v.e(str3, l.longValue());
                    }
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.baidu.live.gift.ae
    public boolean e(String str, String str2, boolean z) {
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

    @Override // com.baidu.live.gift.ae
    public void Id() {
        com.baidu.live.h.b.ei(19);
    }

    private String hb(String str) {
        return a.aYh + str;
    }

    private String hc(String str) {
        return hb(str) + "_zip";
    }

    private String hd(String str) {
        return a.aYi + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, String str3, String str4, boolean z) {
        String iA = com.baidu.live.ag.b.iA(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.h.b.b(iA, com.baidu.live.h.b.gJ(str5))) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.ag.b.iB(str2)));
            return new File(iA).lastModified();
        }
        com.baidu.live.h.b.a(str, str3, com.baidu.live.ag.b.iz(str2), iA, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String iB = com.baidu.live.ag.b.iB(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.h.b.b(iB, com.baidu.live.h.b.gJ(str5))) {
            return new File(iB).lastModified();
        }
        com.baidu.live.h.b.a(str, str3, com.baidu.live.ag.b.iz(str2), iB, str5, str2, str4, 19, z);
        return -1L;
    }
}
