package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c SH;
    private b SJ;

    public static c oJ() {
        if (SH == null) {
            synchronized (c.class) {
                if (SH == null) {
                    SH = new c();
                }
            }
        }
        return SH;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.SJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.SJ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.SJ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.SJ.b(bdFileDownloadData, 1);
        }
    }

    public void cA(String str) {
        if (this.SJ != null) {
            this.SJ.cz(str);
        }
    }

    public void a(b bVar) {
        this.SJ = bVar;
    }

    public boolean cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.SJ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.SJ.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
