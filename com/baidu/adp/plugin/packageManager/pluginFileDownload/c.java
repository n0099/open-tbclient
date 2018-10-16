package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Ln;
    private b Lo;

    public static c nx() {
        if (Ln == null) {
            synchronized (c.class) {
                if (Ln == null) {
                    Ln = new c();
                }
            }
        }
        return Ln;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Lo != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Lo.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Lo != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Lo.b(bdFileDownloadData, 1);
        }
    }

    public void ce(String str) {
        if (this.Lo != null) {
            this.Lo.cd(str);
        }
    }

    public void a(b bVar) {
        this.Lo = bVar;
    }

    public boolean cb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Lo != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Lo.nw()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
