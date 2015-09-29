package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DM;
    private b DN;

    public static c mf() {
        if (DM == null) {
            synchronized (c.class) {
                if (DM == null) {
                    DM = new c();
                }
            }
        }
        return DM;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DN != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DN.h(bdFileDownloadData);
        }
    }

    public void by(String str) {
        if (this.DN != null) {
            this.DN.bx(str);
        }
    }

    public void a(b bVar) {
        this.DN = bVar;
    }

    public boolean bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DN != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DN.me()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
