package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class t implements ae {
    @Override // com.baidu.live.gift.ae
    public void gL(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.il(str)));
            String gM = gM(str);
            if (!TextUtils.isEmpty(gM)) {
                com.baidu.live.i.a.cleanDir(new File(gM));
            }
            String gN = gN(str);
            if (!TextUtils.isEmpty(gN)) {
                com.baidu.live.i.a.cleanDir(new File(gN));
            }
            String gO = gO(str);
            if (!StringUtils.isNull(gO)) {
                com.baidu.live.i.a.cleanDir(new File(gO));
            }
        }
    }

    @Override // com.baidu.live.gift.ae
    public void HD() {
        com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.Tg()));
        com.baidu.live.i.a.cleanDir(new File(am.aZM));
        com.baidu.live.i.a.cleanDir(new File(am.aZN));
    }

    @Override // com.baidu.live.gift.ae
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !f(str, aj.hh(str), z2)) {
            new BdAsyncTask<Void, Void, Long>() { // from class: com.baidu.live.gift.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                /* renamed from: d */
                public Long doInBackground(Void... voidArr) {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    return z ? Long.valueOf(t.c(str, str3, str4, str5, z2)) : Long.valueOf(t.d(str, str3, str4, str5, z2));
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
    public boolean au(String str, String str2) {
        return FileSerialDownLoader.getInstance().isDownloading(str, str2, 19);
    }

    public boolean f(String str, String str2, boolean z) {
        DownloadData downloadData;
        int i;
        if (au(str, str2)) {
            if (z) {
                List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
                try {
                    Iterator<DownloadData> it = downloadList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            downloadData = null;
                            break;
                        }
                        DownloadData next = it.next();
                        if (next != null && 19 == next.getType() && next.getId().equals(str) && next.getUrl().equals(str2)) {
                            next.setPriority(415);
                            it.remove();
                            downloadData = next;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadData == null) {
                    return true;
                }
                if (!downloadList.isEmpty()) {
                    for (int i2 = 0; i2 < downloadList.size(); i2++) {
                        if (downloadData.getPriority() >= downloadList.get(i2).getPriority()) {
                            i = i2;
                            break;
                        }
                    }
                }
                i = -1;
                if (i >= 0) {
                    downloadList.add(i, downloadData);
                } else {
                    downloadList.add(downloadData);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.gift.ae
    public void HE() {
        com.baidu.live.i.b.ef(19);
    }

    private String gM(String str) {
        return am.aZM + str;
    }

    private String gN(String str) {
        return gM(str) + "_zip";
    }

    private String gO(String str) {
        return am.aZN + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String in = com.baidu.live.ah.b.in(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.i.b.b(in, com.baidu.live.i.b.gt(str5))) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.io(str2)));
            return new File(in).lastModified();
        }
        com.baidu.live.i.b.a(str, str3, com.baidu.live.ah.b.im(str2), in, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d(String str, String str2, String str3, String str4, boolean z) {
        String io2 = com.baidu.live.ah.b.io(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.i.b.b(io2, com.baidu.live.i.b.gt(str5))) {
            return new File(io2).lastModified();
        }
        com.baidu.live.i.b.a(str, str3, com.baidu.live.ah.b.im(str2), io2, str5, str2, str4, 19, z);
        return -1L;
    }
}
