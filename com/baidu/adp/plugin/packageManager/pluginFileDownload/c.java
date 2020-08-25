package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Tn;
    private b To;

    public static c qi() {
        if (Tn == null) {
            synchronized (c.class) {
                if (Tn == null) {
                    Tn = new c();
                }
            }
        }
        return Tn;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.To != null) {
            bdFileDownloadData.setCallback(aVar);
            this.To.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.To != null) {
            bdFileDownloadData.setCallback(aVar);
            this.To.b(bdFileDownloadData, 1);
        }
    }

    public void cF(String str) {
        if (this.To != null) {
            this.To.cE(str);
        }
    }

    public void a(b bVar) {
        this.To = bVar;
    }

    public boolean cD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.To != null) {
            for (BdFileDownloadData bdFileDownloadData : this.To.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
