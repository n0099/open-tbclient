package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DX;
    private b DY;

    public static c jQ() {
        if (DX == null) {
            synchronized (c.class) {
                if (DX == null) {
                    DX = new c();
                }
            }
        }
        return DX;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DY != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DY.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DY != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DY.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.DY != null) {
            this.DY.bt(str);
        }
    }

    public void a(b bVar) {
        this.DY = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DY != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DY.jP()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
