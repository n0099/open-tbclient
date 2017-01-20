package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c xK;
    private b xL;

    public static c iU() {
        if (xK == null) {
            synchronized (c.class) {
                if (xK == null) {
                    xK = new c();
                }
            }
        }
        return xK;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.xL != null) {
            bdFileDownloadData.setCallback(aVar);
            this.xL.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.xL != null) {
            bdFileDownloadData.setCallback(aVar);
            this.xL.b(bdFileDownloadData, 1);
        }
    }

    public void bv(String str) {
        if (this.xL != null) {
            this.xL.bu(str);
        }
    }

    public void a(b bVar) {
        this.xL = bVar;
    }

    public boolean bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.xL != null) {
            for (BdFileDownloadData bdFileDownloadData : this.xL.iT()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
