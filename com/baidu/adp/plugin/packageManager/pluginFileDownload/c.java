package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c TG;
    private b TH;

    public static c qn() {
        if (TG == null) {
            synchronized (c.class) {
                if (TG == null) {
                    TG = new c();
                }
            }
        }
        return TG;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TH.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.TH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.TH.b(bdFileDownloadData, 1);
        }
    }

    public void cI(String str) {
        if (this.TH != null) {
            this.TH.cH(str);
        }
    }

    public void a(b bVar) {
        this.TH = bVar;
    }

    public boolean cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.TH != null) {
            for (BdFileDownloadData bdFileDownloadData : this.TH.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
