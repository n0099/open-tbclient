package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c ve;
    private b vf;

    public static c ia() {
        if (ve == null) {
            synchronized (c.class) {
                if (ve == null) {
                    ve = new c();
                }
            }
        }
        return ve;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vf != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vf.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vf != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vf.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.vf != null) {
            this.vf.bt(str);
        }
    }

    public void a(b bVar) {
        this.vf = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.vf != null) {
            for (BdFileDownloadData bdFileDownloadData : this.vf.hZ()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
