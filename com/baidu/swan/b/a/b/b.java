package com.baidu.swan.b.a.b;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    private DownloadManager ceL;

    public b(DownloadManager downloadManager) {
        this.ceL = downloadManager;
    }

    public Collection<Download> air() {
        return this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.1
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || b.this.a(download)) ? false : true;
            }
        });
    }

    public Download nK(String str) {
        Download download = null;
        Collection<Download> nL = nL(str);
        if (nL != null) {
            for (Download download2 : nL) {
                if (download2 == null) {
                    download2 = download;
                }
                download = download2;
            }
        }
        return download;
    }

    public synchronized Collection<Download> nL(final String str) {
        return TextUtils.isEmpty(str) ? null : this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.2
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || !TextUtils.equals(download.getUrl(), str) || b.this.a(download)) ? false : true;
            }
        });
    }

    public synchronized Collection<Download> nM(final String str) {
        return TextUtils.isEmpty(str) ? null : this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.3
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), str);
            }
        });
    }

    public void ais() {
        Collection<Download> air = air();
        if (air != null && !air.isEmpty()) {
            for (Download download : air) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.ceL.pause(download.getId().longValue());
                }
            }
        }
    }

    public synchronized void ait() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.4
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return (download == null || download.getState() != Download.DownloadState.FINISH || b.this.c(download) || !b.b(download) || com.baidu.swan.b.a.c.a.as(AppRuntime.getAppContext(), download.getKeyByUser())) ? false : true;
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
                        this.ceL.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void ail() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.5
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return download != null && download.getState() == Download.DownloadState.FINISH && com.baidu.swan.b.a.c.a.as(AppRuntime.getAppContext(), download.getKeyByUser());
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
                        this.ceL.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void aiu() {
        f(this.ceL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.6
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return b.this.a(download);
            }
        }));
    }

    public void nN(String str) {
        if (!TextUtils.isEmpty(str)) {
            f(nM(str));
        }
    }

    public void f(Collection<Download> collection) {
        if (collection != null) {
            for (Download download : collection) {
                if (download != null) {
                    this.ceL.cancel(download.getId().longValue());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Download download) {
        if (download == null) {
            return false;
        }
        return (c(download) || (download.getState() == Download.DownloadState.FINISH && !b(download))) && !com.baidu.swan.b.a.c.a.as(AppRuntime.getAppContext(), download.getKeyByUser());
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
