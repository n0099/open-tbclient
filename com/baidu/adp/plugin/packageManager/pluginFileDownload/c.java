package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Cl;
    private b Cm;

    public static c jr() {
        if (Cl == null) {
            synchronized (c.class) {
                if (Cl == null) {
                    Cl = new c();
                }
            }
        }
        return Cl;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Cm != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Cm.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Cm != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Cm.b(bdFileDownloadData, 1);
        }
    }

    public void bz(String str) {
        if (this.Cm != null) {
            this.Cm.by(str);
        }
    }

    public void a(b bVar) {
        this.Cm = bVar;
    }

    public boolean bw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Cm != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Cm.jq()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
