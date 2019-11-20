package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c vP;
    private b vQ;

    public static c jh() {
        if (vP == null) {
            synchronized (c.class) {
                if (vP == null) {
                    vP = new c();
                }
            }
        }
        return vP;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vQ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vQ.b(bdFileDownloadData, 1);
        }
    }

    public void aX(String str) {
        if (this.vQ != null) {
            this.vQ.aW(str);
        }
    }

    public void a(b bVar) {
        this.vQ = bVar;
    }

    public boolean aV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.vQ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.vQ.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
