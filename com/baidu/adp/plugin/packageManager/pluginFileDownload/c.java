package com.baidu.adp.plugin.packageManager.pluginFileDownload;
/* loaded from: classes.dex */
public class c {
    private static volatile c sX;
    private b sY;

    public static c iq() {
        if (sX == null) {
            synchronized (c.class) {
                if (sX == null) {
                    sX = new c();
                }
            }
        }
        return sX;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.sY != null) {
            bdFileDownloadData.setCallback(aVar);
            this.sY.h(bdFileDownloadData);
        }
    }

    public void bo(String str) {
        if (this.sY != null) {
            this.sY.bn(str);
        }
    }

    public void a(b bVar) {
        this.sY = bVar;
    }
}
