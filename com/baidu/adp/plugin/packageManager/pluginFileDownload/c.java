package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Wm;
    private b Wn;

    public static c pP() {
        if (Wm == null) {
            synchronized (c.class) {
                if (Wm == null) {
                    Wm = new c();
                }
            }
        }
        return Wm;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Wn != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Wn.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Wn != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Wn.b(bdFileDownloadData, 1);
        }
    }

    public void cK(String str) {
        if (this.Wn != null) {
            this.Wn.cJ(str);
        }
    }

    public void a(b bVar) {
        this.Wn = bVar;
    }

    public boolean cI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Wn != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Wn.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
