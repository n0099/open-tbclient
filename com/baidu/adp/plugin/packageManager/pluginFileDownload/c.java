package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Jw;
    private b Jx;

    public static c my() {
        if (Jw == null) {
            synchronized (c.class) {
                if (Jw == null) {
                    Jw = new c();
                }
            }
        }
        return Jw;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Jx != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Jx.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Jx != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Jx.b(bdFileDownloadData, 1);
        }
    }

    public void bO(String str) {
        if (this.Jx != null) {
            this.Jx.bN(str);
        }
    }

    public void a(b bVar) {
        this.Jx = bVar;
    }

    public boolean bM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Jx != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Jx.mx()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
