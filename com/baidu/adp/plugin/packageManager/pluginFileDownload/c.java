package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Jv;
    private b Jw;

    public static c my() {
        if (Jv == null) {
            synchronized (c.class) {
                if (Jv == null) {
                    Jv = new c();
                }
            }
        }
        return Jv;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Jw != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Jw.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Jw != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Jw.b(bdFileDownloadData, 1);
        }
    }

    public void bO(String str) {
        if (this.Jw != null) {
            this.Jw.bN(str);
        }
    }

    public void a(b bVar) {
        this.Jw = bVar;
    }

    public boolean bM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Jw != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Jw.mx()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
