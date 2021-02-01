package com.baidu.live.gift.c;

import android.text.TextUtils;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class d implements ae {
    @Override // com.baidu.live.gift.ae
    public void fU(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hw(str)));
            String fV = fV(str);
            if (!TextUtils.isEmpty(fV)) {
                com.baidu.live.h.a.cleanDir(new File(fV));
            }
            String fW = fW(str);
            if (!TextUtils.isEmpty(fW)) {
                com.baidu.live.h.a.cleanDir(new File(fW));
            }
            String fX = fX(str);
            if (!StringUtils.isNull(fX)) {
                com.baidu.live.h.a.cleanDir(new File(fX));
            }
        }
    }

    @Override // com.baidu.live.gift.ae
    public void EY() {
        com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.QM()));
        com.baidu.live.h.a.cleanDir(new File(a.aYh));
        com.baidu.live.h.a.cleanDir(new File(a.aYi));
    }

    @Override // com.baidu.live.gift.ae
    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final boolean z, final boolean z2, final boolean z3, final boolean z4, final int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (!z2 || !f(str, ac.gr(str), z3)) {
                new BdAsyncTask<Void, Void, Long>() { // from class: com.baidu.live.gift.c.d.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                    /* renamed from: d */
                    public Long doInBackground(Void... voidArr) {
                        if (TextUtils.isEmpty(str2)) {
                            return null;
                        }
                        return z ? Long.valueOf(d.a(str, str3, str4, str5, z2, z3)) : Long.valueOf(d.b(str, str3, str4, str5, z2, z3));
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                    /* renamed from: b */
                    public void onPostExecute(Long l) {
                        super.onPostExecute(l);
                        if (z4 && l != null && l.longValue() > 0) {
                            v.b(str3, l.longValue(), i);
                        }
                    }
                }.execute(new Void[0]);
            }
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
    public void EZ() {
        com.baidu.live.h.b.cE(19);
    }

    private String fV(String str) {
        return a.aYh + str;
    }

    private String fW(String str) {
        return fV(str) + "_zip";
    }

    private String fX(String str) {
        return a.aYi + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        String hy = com.baidu.live.storage.b.hy(str2);
        String str5 = "dynamic_video_md5_" + str2;
        if (!com.baidu.live.h.b.b(hy, com.baidu.live.h.b.fC(str5))) {
            com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hz(str2)));
            return new File(hy).lastModified();
        }
        if (z) {
            com.baidu.live.h.b.a(str, str3, com.baidu.live.storage.b.hx(str2), hy, str5, str2, str4, 19, z2);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        String hz = com.baidu.live.storage.b.hz(str2);
        String str5 = AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + str2;
        if (!com.baidu.live.h.b.b(hz, com.baidu.live.h.b.fC(str5))) {
            return new File(hz).lastModified();
        }
        if (z) {
            com.baidu.live.h.b.a(str, str3, com.baidu.live.storage.b.hx(str2), hz, str5, str2, str4, 19, z2);
        }
        return -1L;
    }
}
