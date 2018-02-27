package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c arI;
    private b arJ;

    public static c rm() {
        if (arI == null) {
            synchronized (c.class) {
                if (arI == null) {
                    arI = new c();
                }
            }
        }
        return arI;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arJ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arJ.b(bdFileDownloadData, 1);
        }
    }

    public void bC(String str) {
        if (this.arJ != null) {
            this.arJ.bB(str);
        }
    }

    public void a(b bVar) {
        this.arJ = bVar;
    }

    public boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.arJ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.arJ.rl()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
