package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Ea;
    private b Eb;

    public static c jP() {
        if (Ea == null) {
            synchronized (c.class) {
                if (Ea == null) {
                    Ea = new c();
                }
            }
        }
        return Ea;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Eb != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Eb.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Eb != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Eb.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.Eb != null) {
            this.Eb.bt(str);
        }
    }

    public void a(b bVar) {
        this.Eb = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Eb != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Eb.jO()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
