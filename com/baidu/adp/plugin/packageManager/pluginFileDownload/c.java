package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c TZ;
    private b Ua;

    public static c qn() {
        if (TZ == null) {
            synchronized (c.class) {
                if (TZ == null) {
                    TZ = new c();
                }
            }
        }
        return TZ;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ua != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ua.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.Ua != null) {
            bdFileDownloadData.setCallback(aVar);
            this.Ua.b(bdFileDownloadData, 1);
        }
    }

    public void cK(String str) {
        if (this.Ua != null) {
            this.Ua.cJ(str);
        }
    }

    public void a(b bVar) {
        this.Ua = bVar;
    }

    public boolean cI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.Ua != null) {
            for (BdFileDownloadData bdFileDownloadData : this.Ua.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
