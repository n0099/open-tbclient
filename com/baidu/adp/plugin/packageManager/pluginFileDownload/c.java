package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Cm;
    private b Cn;

    public static c jr() {
        if (Cm == null) {
            synchronized (c.class) {
                if (Cm == null) {
                    Cm = new c();
                }
            }
        }
        return Cm;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Cn != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Cn.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Cn != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Cn.b(bdFileDownloadData, 1);
        }
    }

    public void bz(String str) {
        if (this.Cn != null) {
            this.Cn.by(str);
        }
    }

    public void a(b bVar) {
        this.Cn = bVar;
    }

    public boolean bw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Cn != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Cn.jq()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
