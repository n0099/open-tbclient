package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class s implements ac {
    @Override // com.baidu.live.gift.ac
    public void gF(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.hU(str)));
            String gG = gG(str);
            if (!TextUtils.isEmpty(gG)) {
                com.baidu.live.f.a.cleanDir(new File(gG));
            }
            String gH = gH(str);
            if (!TextUtils.isEmpty(gH)) {
                com.baidu.live.f.a.cleanDir(new File(gH));
            }
            String gI = gI(str);
            if (!StringUtils.isNull(gI)) {
                com.baidu.live.f.a.cleanDir(new File(gI));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Gn() {
        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.PI()));
        com.baidu.live.f.a.cleanDir(new File(ak.aUW));
        com.baidu.live.f.a.cleanDir(new File(ak.aUX));
    }

    @Override // com.baidu.live.gift.ac
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !e(str, ah.hb(str), z4)) {
            new BdAsyncTask<Void, Void, Long>() { // from class: com.baidu.live.gift.s.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: d */
                public Long doInBackground(Void... voidArr) {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    return z ? Long.valueOf(s.b(str, str3, str4, str5, z2)) : Long.valueOf(s.c(str, str3, str4, str5, z2));
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: b */
                public void onPostExecute(Long l) {
                    super.onPostExecute(l);
                    if (z3 && l != null && l.longValue() > 0) {
                        u.e(str3, l.longValue());
                    }
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.baidu.live.gift.ac
    public boolean e(String str, String str2, boolean z) {
        int i;
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= downloadList.size()) {
                    i = -1;
                    break;
                }
                DownloadData downloadData = downloadList.get(i2);
                if (19 == downloadData.getType() && downloadData.getId().equals(str) && downloadData.getUrl().equals(str2)) {
                    i = i2;
                    break;
                }
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i > 0) {
            if (z && downloadList != null && downloadList.size() > i && downloadList.size() > 1) {
                Collections.swap(downloadList, i, 1);
                DownloadData downloadData2 = new DownloadData();
                downloadData2.setId(str);
                downloadData2.setUrl(str2);
                downloadData2.setLength(1L);
                downloadData2.setSize(10L);
                com.baidu.live.f.c cVar = new com.baidu.live.f.c();
                cVar.aRp = 7;
                cVar.aRq = downloadData2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.ac
    public void Go() {
        com.baidu.live.f.b.dP(19);
    }

    private String gG(String str) {
        return ak.aUW + str;
    }

    private String gH(String str) {
        return gG(str) + "_zip";
    }

    private String gI(String str) {
        return ak.aUX + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, String str3, String str4, boolean z) {
        String hW = com.baidu.live.ac.b.hW(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.f.b.b(hW, com.baidu.live.f.b.gn(str5))) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.hX(str2)));
            return new File(hW).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ac.b.hV(str2), hW, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String hX = com.baidu.live.ac.b.hX(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.f.b.b(hX, com.baidu.live.f.b.gn(str5))) {
            return new File(hX).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ac.b.hV(str2), hX, str5, str2, str4, 19, z);
        return -1L;
    }
}
