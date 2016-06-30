package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class c {
    private static volatile c vg;
    private b vh;

    public static c ic() {
        if (vg == null) {
            synchronized (c.class) {
                if (vg == null) {
                    vg = new c();
                }
            }
        }
        return vg;
    }

    private c() {
    }

    public void a(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vh != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vh.h(bdFileDownloadData);
        }
    }

    public void b(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData != null && this.vh != null) {
            bdFileDownloadData.setCallback(aVar);
            this.vh.b(bdFileDownloadData, 1);
        }
    }

    public void bu(String str) {
        if (this.vh != null) {
            this.vh.bt(str);
        }
    }

    public void a(b bVar) {
        this.vh = bVar;
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.vh != null) {
            for (BdFileDownloadData bdFileDownloadData : this.vh.ib()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
