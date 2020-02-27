package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c yN;
    private b yO;

    public static c jN() {
        if (yN == null) {
            synchronized (c.class) {
                if (yN == null) {
                    yN = new c();
                }
            }
        }
        return yN;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.yO != null) {
            bdFileDownloadData.setCallback(aVar);
            this.yO.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.yO != null) {
            bdFileDownloadData.setCallback(aVar);
            this.yO.b(bdFileDownloadData, 1);
        }
    }

    public void bl(String str) {
        if (this.yO != null) {
            this.yO.bk(str);
        }
    }

    public void a(b bVar) {
        this.yO = bVar;
    }

    public boolean bj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.yO != null) {
            for (BdFileDownloadData bdFileDownloadData : this.yO.getDownloadList()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
