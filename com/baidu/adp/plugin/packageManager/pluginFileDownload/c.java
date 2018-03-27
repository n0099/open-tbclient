package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c arJ;
    private b arK;

    public static c rm() {
        if (arJ == null) {
            synchronized (c.class) {
                if (arJ == null) {
                    arJ = new c();
                }
            }
        }
        return arJ;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arK != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arK.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arK != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arK.b(bdFileDownloadData, 1);
        }
    }

    public void bC(String str) {
        if (this.arK != null) {
            this.arK.bB(str);
        }
    }

    public void a(b bVar) {
        this.arK = bVar;
    }

    public boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.arK != null) {
            for (BdFileDownloadData bdFileDownloadData : this.arK.rl()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
