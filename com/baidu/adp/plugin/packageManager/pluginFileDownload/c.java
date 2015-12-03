package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Ed;
    private b Ee;

    public static c mj() {
        if (Ed == null) {
            synchronized (c.class) {
                if (Ed == null) {
                    Ed = new c();
                }
            }
        }
        return Ed;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ee != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ee.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ee != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ee.b(bdFileDownloadData, 1);
        }
    }

    public void bA(String str) {
        if (this.Ee != null) {
            this.Ee.bz(str);
        }
    }

    public void a(b bVar) {
        this.Ee = bVar;
    }

    public boolean bx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ee != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ee.mi()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
