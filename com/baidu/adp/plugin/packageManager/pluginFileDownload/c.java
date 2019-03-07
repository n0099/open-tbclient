package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c LI;
    private b LJ;

    public static c nD() {
        if (LI == null) {
            synchronized (c.class) {
                if (LI == null) {
                    LI = new c();
                }
            }
        }
        return LI;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LJ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.LJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.LJ.b(bdFileDownloadData, 1);
        }
    }

    public void ce(String str) {
        if (this.LJ != null) {
            this.LJ.cd(str);
        }
    }

    public void a(b bVar) {
        this.LJ = bVar;
    }

    public boolean cc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.LJ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.LJ.nC()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
