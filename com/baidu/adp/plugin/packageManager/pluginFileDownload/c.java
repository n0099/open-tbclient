package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DL;
    private b DM;

    public static c mh() {
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

    public void bx(String str) {
        if (this.DM != null) {
            this.DM.bw(str);
        }
    }

    public void a(b bVar) {
        this.DM = bVar;
    }

    public boolean bu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DM != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DM.mg()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
