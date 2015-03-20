package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DZ;
    private b Ea;

    public static c lH() {
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

    public void bt(String str) {
        if (this.Ea != null) {
            this.Ea.bs(str);
        }
    }

    public void a(b bVar) {
        this.Ea = bVar;
    }

    public boolean bq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ea != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ea.lG()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
