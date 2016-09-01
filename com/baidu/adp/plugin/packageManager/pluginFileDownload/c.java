package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c xT;
    private b xU;

    public static c iW() {
        if (xT == null) {
            synchronized (c.class) {
                if (xT == null) {
                    xT = new c();
                }
            }
        }
        return xT;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.xU != null) {
            bdFileDownloadData.setCallback(aVar);
            this.xU.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.xU != null) {
            bdFileDownloadData.setCallback(aVar);
            this.xU.b(bdFileDownloadData, 1);
        }
    }

    public void bw(String str) {
        if (this.xU != null) {
            this.xU.bv(str);
        }
    }

    public void a(b bVar) {
        this.xU = bVar;
    }

    public boolean bt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.xU != null) {
            for (BdFileDownloadData bdFileDownloadData : this.xU.iV()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
