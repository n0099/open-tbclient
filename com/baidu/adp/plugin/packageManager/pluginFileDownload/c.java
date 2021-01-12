package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c UU;
    private b UV;

    public static c pR() {
        if (UU == null) {
            synchronized (c.class) {
                if (UU == null) {
                    UU = new c();
                }
            }
        }
        return UU;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UV != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UV.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.UV != null) {
            bdFileDownloadData.setCallback(aVar);
            this.UV.b(bdFileDownloadData, 1);
        }
    }

    public void cG(String str) {
        if (this.UV != null) {
            this.UV.cF(str);
        }
    }

    public void a(b bVar) {
        this.UV = bVar;
    }

    public boolean cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.UV != null) {
            for (BdFileDownloadData bdFileDownloadData : this.UV.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
