package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c EC;
    private b ED;

    public static c jQ() {
        if (EC == null) {
            synchronized (c.class) {
                if (EC == null) {
                    EC = new c();
                }
            }
        }
        return EC;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ED != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ED.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.ED != null) {
            bdFileDownloadData.setCallback(aVar);
            this.ED.b(bdFileDownloadData, 1);
        }
    }

    public void bp(String str) {
        if (this.ED != null) {
            this.ED.bo(str);
        }
    }

    public void a(b bVar) {
        this.ED = bVar;
    }

    public boolean bm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.ED != null) {
            for (BdFileDownloadData bdFileDownloadData : this.ED.jP()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
