package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c SM;
    private b SO;

    public static c oI() {
        if (SM == null) {
            synchronized (c.class) {
                if (SM == null) {
                    SM = new c();
                }
            }
        }
        return SM;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.SO != null) {
            bdFileDownloadData.setCallback(aVar);
            this.SO.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.SO != null) {
            bdFileDownloadData.setCallback(aVar);
            this.SO.b(bdFileDownloadData, 1);
        }
    }

    public void cC(String str) {
        if (this.SO != null) {
            this.SO.cB(str);
        }
    }

    public void a(b bVar) {
        this.SO = bVar;
    }

    public boolean cA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.SO != null) {
            for (BdFileDownloadData bdFileDownloadData : this.SO.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
