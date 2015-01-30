package com.baidu.adp.plugin.packageManager.pluginFileDownload;
/* loaded from: classes.dex */
public class c {
    private static volatile c th;
    private b ti;

    public static c iq() {
        if (th == null) {
            synchronized (c.class) {
                if (th == null) {
                    th = new c();
                }
            }
        }
        return th;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ti != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ti.h(bdFileDownloadData);
        }
    }

    public void bo(String str) {
        if (this.ti != null) {
            this.ti.bn(str);
        }
    }

    public void a(b bVar) {
        this.ti = bVar;
    }
}
