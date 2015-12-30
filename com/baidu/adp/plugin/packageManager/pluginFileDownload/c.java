package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Ev;
    private b Ew;

    public static c lH() {
        if (Ev == null) {
            synchronized (c.class) {
                if (Ev == null) {
                    Ev = new c();
                }
            }
        }
        return Ev;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ew != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ew.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ew != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ew.b(bdFileDownloadData, 1);
        }
    }

    public void bD(String str) {
        if (this.Ew != null) {
            this.Ew.bC(str);
        }
    }

    public void a(b bVar) {
        this.Ew = bVar;
    }

    public boolean bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ew != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ew.lG()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
