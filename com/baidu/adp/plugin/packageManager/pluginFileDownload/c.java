package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c yv;
    private b yw;

    public static c jy() {
        if (yv == null) {
            synchronized (c.class) {
                if (yv == null) {
                    yv = new c();
                }
            }
        }
        return yv;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.yw != null) {
            bdFileDownloadData.setCallback(aVar);
            this.yw.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.yw != null) {
            bdFileDownloadData.setCallback(aVar);
            this.yw.b(bdFileDownloadData, 1);
        }
    }

    public void bj(String str) {
        if (this.yw != null) {
            this.yw.bi(str);
        }
    }

    public void a(b bVar) {
        this.yw = bVar;
    }

    public boolean bh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.yw != null) {
            for (BdFileDownloadData bdFileDownloadData : this.yw.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
