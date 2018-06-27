package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Iw;
    private b Ix;

    public static c mf() {
        if (Iw == null) {
            synchronized (c.class) {
                if (Iw == null) {
                    Iw = new c();
                }
            }
        }
        return Iw;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ix != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ix.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ix != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ix.b(bdFileDownloadData, 1);
        }
    }

    public void bN(String str) {
        if (this.Ix != null) {
            this.Ix.bM(str);
        }
    }

    public void a(b bVar) {
        this.Ix = bVar;
    }

    public boolean bK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ix != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ix.me()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
