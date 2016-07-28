package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c vH;
    private b vI;

    public static c ib() {
        if (vH == null) {
            synchronized (c.class) {
                if (vH == null) {
                    vH = new c();
                }
            }
        }
        return vH;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vI != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vI.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vI != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vI.b(bdFileDownloadData, 1);
        }
    }

    public void bv(String str) {
        if (this.vI != null) {
            this.vI.bu(str);
        }
    }

    public void a(b bVar) {
        this.vI = bVar;
    }

    public boolean bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.vI != null) {
            for (BdFileDownloadData bdFileDownloadData : this.vI.ia()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
