package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c JG;
    private b JH;

    public static c mO() {
        if (JG == null) {
            synchronized (c.class) {
                if (JG == null) {
                    JG = new c();
                }
            }
        }
        return JG;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.JH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.JH.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.JH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.JH.b(bdFileDownloadData, 1);
        }
    }

    public void bQ(String str) {
        if (this.JH != null) {
            this.JH.bP(str);
        }
    }

    public void a(b bVar) {
        this.JH = bVar;
    }

    public boolean bO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.JH != null) {
            for (BdFileDownloadData bdFileDownloadData : this.JH.mN()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
