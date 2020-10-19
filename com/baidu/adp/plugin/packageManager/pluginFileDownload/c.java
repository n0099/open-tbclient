package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c TX;
    private b TY;

    public static c qn() {
        if (TX == null) {
            synchronized (c.class) {
                if (TX == null) {
                    TX = new c();
                }
            }
        }
        return TX;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TY != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TY.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TY != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TY.b(bdFileDownloadData, 1);
        }
    }

    public void cI(String str) {
        if (this.TY != null) {
            this.TY.cH(str);
        }
    }

    public void a(b bVar) {
        this.TY = bVar;
    }

    public boolean cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.TY != null) {
            for (BdFileDownloadData bdFileDownloadData : this.TY.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
