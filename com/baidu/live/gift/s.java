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
    public void gL(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.ia(str)));
            String gM = gM(str);
            if (!TextUtils.isEmpty(gM)) {
                com.baidu.live.f.a.cleanDir(new File(gM));
            }
            String gN = gN(str);
            if (!TextUtils.isEmpty(gN)) {
                com.baidu.live.f.a.cleanDir(new File(gN));
            }
            String gO = gO(str);
            if (!StringUtils.isNull(gO)) {
                com.baidu.live.f.a.cleanDir(new File(gO));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void GW() {
        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.Qr()));
        com.baidu.live.f.a.cleanDir(new File(ak.aWH));
        com.baidu.live.f.a.cleanDir(new File(ak.aWI));
    }

    @Override // com.baidu.live.gift.ac
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3, boolean z4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !e(str, ah.hh(str), z4)) {
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
                cVar.aTa = 7;
                cVar.aTb = downloadData2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913078, cVar));
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.ac
    public void GX() {
        com.baidu.live.f.b.dT(19);
    }

    private String gM(String str) {
        return ak.aWH + str;
    }

    private String gN(String str) {
        return gM(str) + "_zip";
    }

    private String gO(String str) {
        return ak.aWI + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, String str3, String str4, boolean z) {
        String ic = com.baidu.live.ac.b.ic(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.f.b.b(ic, com.baidu.live.f.b.gu(str5))) {
            com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.id(str2)));
            return new File(ic).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ac.b.ib(str2), ic, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String id = com.baidu.live.ac.b.id(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.f.b.b(id, com.baidu.live.f.b.gu(str5))) {
            return new File(id).lastModified();
        }
        com.baidu.live.f.b.a(str, str3, com.baidu.live.ac.b.ib(str2), id, str5, str2, str4, 19, z);
        return -1L;
    }
}
