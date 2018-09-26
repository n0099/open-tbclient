package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c KP;
    private b KQ;

    public static c nn() {
        if (KP == null) {
            synchronized (c.class) {
                if (KP == null) {
                    KP = new c();
                }
            }
        }
        return KP;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.KQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.KQ.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.KQ != null) {
            bdFileDownloadData.setCallback(aVar);
            this.KQ.b(bdFileDownloadData, 1);
        }
    }

    public void cf(String str) {
        if (this.KQ != null) {
            this.KQ.ce(str);
        }
    }

    public void a(b bVar) {
        this.KQ = bVar;
    }

    public boolean cc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.KQ != null) {
            for (BdFileDownloadData bdFileDownloadData : this.KQ.nm()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
