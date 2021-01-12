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
/* loaded from: classes10.dex */
public class t implements ae {
    @Override // com.baidu.live.gift.ae
    public void fz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.ha(str)));
            String fA = fA(str);
            if (!TextUtils.isEmpty(fA)) {
                com.baidu.live.i.a.cleanDir(new File(fA));
            }
            String fB = fB(str);
            if (!TextUtils.isEmpty(fB)) {
                com.baidu.live.i.a.cleanDir(new File(fB));
            }
            String fC = fC(str);
            if (!StringUtils.isNull(fC)) {
                com.baidu.live.i.a.cleanDir(new File(fC));
            }
        }
    }

    @Override // com.baidu.live.gift.ae
    public void DI() {
        com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.Pl()));
        com.baidu.live.i.a.cleanDir(new File(am.aUZ));
        com.baidu.live.i.a.cleanDir(new File(am.aVa));
    }

    @Override // com.baidu.live.gift.ae
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !f(str, aj.fV(str), z2)) {
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
    public boolean at(String str, String str2) {
        return FileSerialDownLoader.getInstance().isDownloading(str, str2, 19);
    }

    public boolean f(String str, String str2, boolean z) {
        DownloadData downloadData;
        int i;
        if (at(str, str2)) {
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
    public void DJ() {
        com.baidu.live.i.b.cz(19);
    }

    private String fA(String str) {
        return am.aUZ + str;
    }

    private String fB(String str) {
        return fA(str) + "_zip";
    }

    private String fC(String str) {
        return am.aVa + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(String str, String str2, String str3, String str4, boolean z) {
        String hc = com.baidu.live.ah.b.hc(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.i.b.b(hc, com.baidu.live.i.b.fh(str5))) {
            com.baidu.live.i.a.cleanDir(new File(com.baidu.live.ah.b.hd(str2)));
            return new File(hc).lastModified();
        }
        com.baidu.live.i.b.a(str, str3, com.baidu.live.ah.b.hb(str2), hc, str5, str2, str4, 19, z);
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d(String str, String str2, String str3, String str4, boolean z) {
        String hd = com.baidu.live.ah.b.hd(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.i.b.b(hd, com.baidu.live.i.b.fh(str5))) {
            return new File(hd).lastModified();
        }
        com.baidu.live.i.b.a(str, str3, com.baidu.live.ah.b.hb(str2), hd, str5, str2, str4, 19, z);
        return -1L;
    }
}
