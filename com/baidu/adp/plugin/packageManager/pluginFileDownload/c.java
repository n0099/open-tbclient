package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Gd;
    private b Ge;

    public static c jZ() {
        if (Gd == null) {
            synchronized (c.class) {
                if (Gd == null) {
                    Gd = new c();
                }
            }
        }
        return Gd;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ge != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ge.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ge != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ge.b(bdFileDownloadData, 1);
        }
    }

    public void bx(String str) {
        if (this.Ge != null) {
            this.Ge.bw(str);
        }
    }

    public void a(b bVar) {
        this.Ge = bVar;
    }

    public boolean bu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ge != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ge.jY()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
