package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c LJ;
    private b LK;

    public static c nD() {
        if (LJ == null) {
            synchronized (c.class) {
                if (LJ == null) {
                    LJ = new c();
                }
            }
        }
        return LJ;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LK != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LK.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LK != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LK.b(bdFileDownloadData, 1);
        }
    }

    public void ce(String str) {
        if (this.LK != null) {
            this.LK.cd(str);
        }
    }

    public void a(b bVar) {
        this.LK = bVar;
    }

    public boolean cc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.LK != null) {
            for (BdFileDownloadData bdFileDownloadData : this.LK.nC()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
