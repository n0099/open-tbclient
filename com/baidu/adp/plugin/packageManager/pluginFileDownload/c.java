package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Gb;
    private b Gc;

    public static c jZ() {
        if (Gb == null) {
            synchronized (c.class) {
                if (Gb == null) {
                    Gb = new c();
                }
            }
        }
        return Gb;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Gc != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Gc.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Gc != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Gc.b(bdFileDownloadData, 1);
        }
    }

    public void bx(String str) {
        if (this.Gc != null) {
            this.Gc.bw(str);
        }
    }

    public void a(b bVar) {
        this.Gc = bVar;
    }

    public boolean bu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Gc != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Gc.jY()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
