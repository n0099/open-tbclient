package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c EG;
    private b EH;

    public static c lU() {
        if (EG == null) {
            synchronized (c.class) {
                if (EG == null) {
                    EG = new c();
                }
            }
        }
        return EG;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EH.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EH != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EH.b(bdFileDownloadData, 1);
        }
    }

    public void bD(String str) {
        if (this.EH != null) {
            this.EH.bC(str);
        }
    }

    public void a(b bVar) {
        this.EH = bVar;
    }

    public boolean bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.EH != null) {
            for (BdFileDownloadData bdFileDownloadData : this.EH.lT()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
