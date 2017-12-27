package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c arP;
    private b arQ;

    public static c rl() {
        if (arP == null) {
            synchronized (c.class) {
                if (arP == null) {
                    arP = new c();
                }
            }
        }
        return arP;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arQ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arQ.b(bdFileDownloadData, 1);
        }
    }

    public void bC(String str) {
        if (this.arQ != null) {
            this.arQ.bB(str);
        }
    }

    public void a(b bVar) {
        this.arQ = bVar;
    }

    public boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.arQ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.arQ.rk()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
