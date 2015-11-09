package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DO;
    private b DP;

    public static c mg() {
        if (DO == null) {
            synchronized (c.class) {
                if (DO == null) {
                    DO = new c();
                }
            }
        }
        return DO;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DP != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DP.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DP != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DP.b(bdFileDownloadData, 1);
        }
    }

    public void bw(String str) {
        if (this.DP != null) {
            this.DP.bv(str);
        }
    }

    public void a(b bVar) {
        this.DP = bVar;
    }

    public boolean bt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DP != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DP.mf()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
