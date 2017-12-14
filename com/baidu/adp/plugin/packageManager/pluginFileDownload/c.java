package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DK;
    private b DL;

    public static c jM() {
        if (DK == null) {
            synchronized (c.class) {
                if (DK == null) {
                    DK = new c();
                }
            }
        }
        return DK;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DL != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DL.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DL != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DL.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.DL != null) {
            this.DL.bt(str);
        }
    }

    public void a(b bVar) {
        this.DL = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DL != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DL.jL()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
