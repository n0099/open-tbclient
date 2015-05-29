package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DP;
    private b DQ;

    public static c ma() {
        if (DP == null) {
            synchronized (c.class) {
                if (DP == null) {
                    DP = new c();
                }
            }
        }
        return DP;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DQ.h(bdFileDownloadData);
        }
    }

    public void bD(String str) {
        if (this.DQ != null) {
            this.DQ.bC(str);
        }
    }

    public void a(b bVar) {
        this.DQ = bVar;
    }

    public boolean bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DQ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DQ.lZ()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
