package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Lq;
    private b Lr;

    public static c nu() {
        if (Lq == null) {
            synchronized (c.class) {
                if (Lq == null) {
                    Lq = new c();
                }
            }
        }
        return Lq;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Lr != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Lr.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Lr != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Lr.b(bdFileDownloadData, 1);
        }
    }

    public void ce(String str) {
        if (this.Lr != null) {
            this.Lr.cd(str);
        }
    }

    public void a(b bVar) {
        this.Lr = bVar;
    }

    public boolean cb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Lr != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Lr.nt()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
