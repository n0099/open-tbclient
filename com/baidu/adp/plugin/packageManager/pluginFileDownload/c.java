package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c TY;
    private b TZ;

    public static c qn() {
        if (TY == null) {
            synchronized (c.class) {
                if (TY == null) {
                    TY = new c();
                }
            }
        }
        return TY;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TZ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TZ.b(bdFileDownloadData, 1);
        }
    }

    public void cI(String str) {
        if (this.TZ != null) {
            this.TZ.cH(str);
        }
    }

    public void a(b bVar) {
        this.TZ = bVar;
    }

    public boolean cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.TZ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.TZ.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
