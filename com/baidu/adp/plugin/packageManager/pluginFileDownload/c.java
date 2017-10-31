package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DL;
    private b DM;

    public static c jM() {
        if (DL == null) {
            synchronized (c.class) {
                if (DL == null) {
                    DL = new c();
                }
            }
        }
        return DL;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DM != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DM.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DM != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DM.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.DM != null) {
            this.DM.bt(str);
        }
    }

    public void a(b bVar) {
        this.DM = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DM != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DM.jL()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
