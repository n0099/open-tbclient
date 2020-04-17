package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c RV;
    private b RW;

    public static c or() {
        if (RV == null) {
            synchronized (c.class) {
                if (RV == null) {
                    RV = new c();
                }
            }
        }
        return RV;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.RW != null) {
            bdFileDownloadData.setCallback(aVar);
            this.RW.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.RW != null) {
            bdFileDownloadData.setCallback(aVar);
            this.RW.b(bdFileDownloadData, 1);
        }
    }

    public void cA(String str) {
        if (this.RW != null) {
            this.RW.cz(str);
        }
    }

    public void a(b bVar) {
        this.RW = bVar;
    }

    public boolean cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.RW != null) {
            for (BdFileDownloadData bdFileDownloadData : this.RW.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
