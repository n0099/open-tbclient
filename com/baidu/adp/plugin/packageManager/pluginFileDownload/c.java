package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c RY;
    private b RZ;

    public static c or() {
        if (RY == null) {
            synchronized (c.class) {
                if (RY == null) {
                    RY = new c();
                }
            }
        }
        return RY;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.RZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.RZ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.RZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.RZ.b(bdFileDownloadData, 1);
        }
    }

    public void cA(String str) {
        if (this.RZ != null) {
            this.RZ.cz(str);
        }
    }

    public void a(b bVar) {
        this.RZ = bVar;
    }

    public boolean cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.RZ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.RZ.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
