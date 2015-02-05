package com.baidu.adp.plugin.packageManager.pluginFileDownload;
/* loaded from: classes.dex */
public class c {
    private static volatile c te;
    private b tf;

    public static c ij() {
        if (te == null) {
            synchronized (c.class) {
                if (te == null) {
                    te = new c();
                }
            }
        }
        return te;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.tf != null) {
            bdFileDownloadData.setCallback(aVar);
            this.tf.h(bdFileDownloadData);
        }
    }

    public void bl(String str) {
        if (this.tf != null) {
            this.tf.bk(str);
        }
    }

    public void a(b bVar) {
        this.tf = bVar;
    }
}
