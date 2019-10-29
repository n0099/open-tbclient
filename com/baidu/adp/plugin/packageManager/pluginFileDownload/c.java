package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c wr;
    private b ws;

    public static c jh() {
        if (wr == null) {
            synchronized (c.class) {
                if (wr == null) {
                    wr = new c();
                }
            }
        }
        return wr;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ws != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ws.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ws != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ws.b(bdFileDownloadData, 1);
        }
    }

    public void aX(String str) {
        if (this.ws != null) {
            this.ws.aW(str);
        }
    }

    public void a(b bVar) {
        this.ws = bVar;
    }

    public boolean aV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.ws != null) {
            for (BdFileDownloadData bdFileDownloadData : this.ws.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
