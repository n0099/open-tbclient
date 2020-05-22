package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Sj;
    private b Sk;

    public static c os() {
        if (Sj == null) {
            synchronized (c.class) {
                if (Sj == null) {
                    Sj = new c();
                }
            }
        }
        return Sj;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Sk != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Sk.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Sk != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Sk.b(bdFileDownloadData, 1);
        }
    }

    public void cB(String str) {
        if (this.Sk != null) {
            this.Sk.cA(str);
        }
    }

    public void a(b bVar) {
        this.Sk = bVar;
    }

    public boolean cz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Sk != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Sk.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
