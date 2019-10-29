package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import java.util.List;
/* loaded from: classes.dex */
public abstract class b {
    public abstract void a(BdFileDownloadData bdFileDownloadData, int i);

    public abstract void aW(String str);

    public abstract void b(BdFileDownloadData bdFileDownloadData, int i);

    public abstract List<BdFileDownloadData> getDownloadList();

    public void h(BdFileDownloadData bdFileDownloadData) {
        a(bdFileDownloadData, 1);
    }
}
