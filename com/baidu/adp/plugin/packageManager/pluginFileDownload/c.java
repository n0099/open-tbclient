package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c yr;
    private b ys;

    public static c jz() {
        if (yr == null) {
            synchronized (c.class) {
                if (yr == null) {
                    yr = new c();
                }
            }
        }
        return yr;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ys != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ys.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ys != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ys.b(bdFileDownloadData, 1);
        }
    }

    public void bj(String str) {
        if (this.ys != null) {
            this.ys.bi(str);
        }
    }

    public void a(b bVar) {
        this.ys = bVar;
    }

    public boolean bh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.ys != null) {
            for (BdFileDownloadData bdFileDownloadData : this.ys.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
