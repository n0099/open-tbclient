package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c EY;
    private b EZ;

    public static c jO() {
        if (EY == null) {
            synchronized (c.class) {
                if (EY == null) {
                    EY = new c();
                }
            }
        }
        return EY;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EZ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EZ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EZ.b(bdFileDownloadData, 1);
        }
    }

    public void bp(String str) {
        if (this.EZ != null) {
            this.EZ.bo(str);
        }
    }

    public void a(b bVar) {
        this.EZ = bVar;
    }

    public boolean bm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.EZ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.EZ.jN()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
