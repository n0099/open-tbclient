package com.baidu.swan.gamecenter.appmanager.download;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class c {
    private DownloadManager dcP;

    public c(DownloadManager downloadManager) {
        this.dcP = downloadManager;
    }

    public Collection<Download> aBx() {
        return this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.1
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || c.this.a(download)) ? false : true;
            }
        });
    }

    public Download rT(String str) {
        Download download = null;
        Collection<Download> rU = rU(str);
        if (rU != null) {
            for (Download download2 : rU) {
                if (download2 == null) {
                    download2 = download;
                }
                download = download2;
            }
        }
        return download;
    }

    public synchronized Collection<Download> rU(final String str) {
        return TextUtils.isEmpty(str) ? null : this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.2
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || !TextUtils.equals(download.getUrl(), str) || c.this.a(download)) ? false : true;
            }
        });
    }

    public synchronized boolean rV(final String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.3
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getKeyByUser(), str);
            }
        });
        if (downloadListByFilter != null) {
            z = downloadListByFilter.size() > 0;
        }
        return z;
    }

    public synchronized Collection<Download> rW(final String str) {
        return TextUtils.isEmpty(str) ? null : this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.4
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), str);
            }
        });
    }

    public void aBy() {
        Collection<Download> aBx = aBx();
        if (aBx != null && !aBx.isEmpty()) {
            for (Download download : aBx) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.dcP.pause(download.getId().longValue());
                }
            }
        }
    }

    public Collection<Download> aBz() {
        Collection<Download> aBx = aBx();
        if (aBx == null || aBx.isEmpty()) {
            return null;
        }
        for (Download download : aBx) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                this.dcP.resume(download.getId().longValue());
            }
        }
        return aBx;
    }

    public synchronized void aBA() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.5
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return (download == null || download.getState() != Download.DownloadState.FINISH || c.this.c(download) || !c.b(download) || com.baidu.swan.gamecenter.appmanager.install.a.ac(AppRuntime.getAppContext(), download.getKeyByUser())) ? false : true;
                }
            });
            if (downloadListByFilter != null && downloadListByFilter.size() - 20 > 0) {
                Iterator<Download> it = downloadListByFilter.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    Download next = it.next();
                    if (i2 == size) {
                        break;
                    }
                    if (next != null) {
                        this.dcP.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void aBp() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.6
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return download != null && download.getState() == Download.DownloadState.FINISH && com.baidu.swan.gamecenter.appmanager.install.a.ac(AppRuntime.getAppContext(), download.getKeyByUser());
                }
            });
            if (downloadListByFilter != null && downloadListByFilter.size() - 30 > 0) {
                Iterator<Download> it = downloadListByFilter.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    Download next = it.next();
                    if (i2 == size) {
                        break;
                    }
                    if (next != null) {
                        this.dcP.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void aBB() {
        h(this.dcP.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.7
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return c.this.a(download);
            }
        }));
    }

    public void rX(String str) {
        if (!TextUtils.isEmpty(str)) {
            h(rW(str));
        }
    }

    public void h(Collection<Download> collection) {
        if (collection != null) {
            for (Download download : collection) {
                if (download != null) {
                    this.dcP.cancel(download.getId().longValue());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [289=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Download download) {
        if (download == null) {
            return false;
        }
        return (c(download) || (download.getState() == Download.DownloadState.FINISH && !b(download))) && !com.baidu.swan.gamecenter.appmanager.install.a.ac(AppRuntime.getAppContext(), download.getKeyByUser());
    }

    public static boolean b(Download download) {
        if (download == null) {
            return false;
        }
        String realDownloadDir = download.getRealDownloadDir();
        String fileName = download.getFileName();
        if (TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
            return false;
        }
        File file = new File(realDownloadDir + File.separator + fileName);
        return file.isFile() && file.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Download download) {
        return download != null && (System.currentTimeMillis() - new a(download).getDownloadTime()) / 86400000 >= 30;
    }
}
