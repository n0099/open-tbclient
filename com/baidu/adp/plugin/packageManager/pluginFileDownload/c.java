package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c UW;
    private b UX;

    public static c pR() {
        if (UW == null) {
            synchronized (c.class) {
                if (UW == null) {
                    UW = new c();
                }
            }
        }
        return UW;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UX != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UX.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UX != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UX.b(bdFileDownloadData, 1);
        }
    }

    public void cG(String str) {
        if (this.UX != null) {
            this.UX.cF(str);
        }
    }

    public void a(b bVar) {
        this.UX = bVar;
    }

    public boolean cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.UX != null) {
            for (BdFileDownloadData bdFileDownloadData : this.UX.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
