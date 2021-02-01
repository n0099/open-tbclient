package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c US;
    private b UT;

    public static c pP() {
        if (US == null) {
            synchronized (c.class) {
                if (US == null) {
                    US = new c();
                }
            }
        }
        return US;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UT != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UT.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UT != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UT.b(bdFileDownloadData, 1);
        }
    }

    public void cG(String str) {
        if (this.UT != null) {
            this.UT.cF(str);
        }
    }

    public void a(b bVar) {
        this.UT = bVar;
    }

    public boolean cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.UT != null) {
            for (BdFileDownloadData bdFileDownloadData : this.UT.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
