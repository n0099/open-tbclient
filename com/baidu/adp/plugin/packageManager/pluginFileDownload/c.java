package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c arO;
    private b arP;

    public static c rl() {
        if (arO == null) {
            synchronized (c.class) {
                if (arO == null) {
                    arO = new c();
                }
            }
        }
        return arO;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arP != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arP.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arP != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arP.b(bdFileDownloadData, 1);
        }
    }

    public void bC(String str) {
        if (this.arP != null) {
            this.arP.bB(str);
        }
    }

    public void a(b bVar) {
        this.arP = bVar;
    }

    public boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.arP != null) {
            for (BdFileDownloadData bdFileDownloadData : this.arP.rk()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
