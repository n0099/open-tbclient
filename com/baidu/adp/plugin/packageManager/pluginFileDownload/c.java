package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c Ez;
    private b EA;

    public static c jS() {
        if (Ez == null) {
            synchronized (c.class) {
                if (Ez == null) {
                    Ez = new c();
                }
            }
        }
        return Ez;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EA != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EA.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EA != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EA.b(bdFileDownloadData, 1);
        }
    }

    public void bk(String str) {
        if (this.EA != null) {
            this.EA.bj(str);
        }
    }

    public void a(b bVar) {
        this.EA = bVar;
    }

    public boolean bh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.EA != null) {
            for (BdFileDownloadData bdFileDownloadData : this.EA.jR()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
