package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Lz;
    private b LA;

    public static c ny() {
        if (Lz == null) {
            synchronized (c.class) {
                if (Lz == null) {
                    Lz = new c();
                }
            }
        }
        return Lz;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LA != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LA.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LA != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LA.b(bdFileDownloadData, 1);
        }
    }

    public void cf(String str) {
        if (this.LA != null) {
            this.LA.ce(str);
        }
    }

    public void a(b bVar) {
        this.LA = bVar;
    }

    public boolean cc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.LA != null) {
            for (BdFileDownloadData bdFileDownloadData : this.LA.nx()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
