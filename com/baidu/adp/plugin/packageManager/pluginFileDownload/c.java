package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Iu;
    private b Iv;

    public static c mf() {
        if (Iu == null) {
            synchronized (c.class) {
                if (Iu == null) {
                    Iu = new c();
                }
            }
        }
        return Iu;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Iv != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Iv.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Iv != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Iv.b(bdFileDownloadData, 1);
        }
    }

    public void bL(String str) {
        if (this.Iv != null) {
            this.Iv.bK(str);
        }
    }

    public void a(b bVar) {
        this.Iv = bVar;
    }

    public boolean bI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Iv != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Iv.me()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
