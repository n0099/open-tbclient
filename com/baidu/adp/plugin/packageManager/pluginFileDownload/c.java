package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c It;
    private b Iu;

    public static c mh() {
        if (It == null) {
            synchronized (c.class) {
                if (It == null) {
                    It = new c();
                }
            }
        }
        return It;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Iu != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Iu.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Iu != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Iu.b(bdFileDownloadData, 1);
        }
    }

    public void bO(String str) {
        if (this.Iu != null) {
            this.Iu.bN(str);
        }
    }

    public void a(b bVar) {
        this.Iu = bVar;
    }

    public boolean bL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Iu != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Iu.mg()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
