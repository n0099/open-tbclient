package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DZ;
    private b Ea;

    public static c jP() {
        if (DZ == null) {
            synchronized (c.class) {
                if (DZ == null) {
                    DZ = new c();
                }
            }
        }
        return DZ;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ea != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ea.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ea != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ea.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.Ea != null) {
            this.Ea.bt(str);
        }
    }

    public void a(b bVar) {
        this.Ea = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ea != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ea.jO()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
