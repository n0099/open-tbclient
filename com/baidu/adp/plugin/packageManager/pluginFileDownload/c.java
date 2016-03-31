package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c EL;
    private b EN;

    public static c lM() {
        if (EL == null) {
            synchronized (c.class) {
                if (EL == null) {
                    EL = new c();
                }
            }
        }
        return EL;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EN != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EN.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.EN != null) {
            bdFileDownloadData.setCallback(aVar);
            this.EN.b(bdFileDownloadData, 1);
        }
    }

    public void bB(String str) {
        if (this.EN != null) {
            this.EN.bA(str);
        }
    }

    public void a(b bVar) {
        this.EN = bVar;
    }

    public boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.EN != null) {
            for (BdFileDownloadData bdFileDownloadData : this.EN.lL()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
