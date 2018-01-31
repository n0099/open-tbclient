package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c arR;
    private b arS;

    public static c rm() {
        if (arR == null) {
            synchronized (c.class) {
                if (arR == null) {
                    arR = new c();
                }
            }
        }
        return arR;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arS != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arS.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.arS != null) {
            bdFileDownloadData.setCallback(aVar);
            this.arS.b(bdFileDownloadData, 1);
        }
    }

    public void bC(String str) {
        if (this.arS != null) {
            this.arS.bB(str);
        }
    }

    public void a(b bVar) {
        this.arS = bVar;
    }

    public boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.arS != null) {
            for (BdFileDownloadData bdFileDownloadData : this.arS.rl()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
