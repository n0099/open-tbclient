package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c DN;
    private b DO;

    public static c mf() {
        if (DN == null) {
            synchronized (c.class) {
                if (DN == null) {
                    DN = new c();
                }
            }
        }
        return DN;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.DO != null) {
            bdFileDownloadData.setCallback(aVar);
            this.DO.h(bdFileDownloadData);
        }
    }

    public void by(String str) {
        if (this.DO != null) {
            this.DO.bx(str);
        }
    }

    public void a(b bVar) {
        this.DO = bVar;
    }

    public boolean bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.DO != null) {
            for (BdFileDownloadData bdFileDownloadData : this.DO.me()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
