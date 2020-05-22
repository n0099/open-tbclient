package com.baidu.swan.b.a.b;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b {
    private DownloadManager cSA;

    public b(DownloadManager downloadManager) {
        this.cSA = downloadManager;
    }

    public Collection<Download> awX() {
        return this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.1
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || b.this.a(download)) ? false : true;
            }
        });
    }

    public Download qP(String str) {
        Download download = null;
        Collection<Download> qQ = qQ(str);
        if (qQ != null) {
            for (Download download2 : qQ) {
                if (download2 == null) {
                    download2 = download;
                }
                download = download2;
            }
        }
        return download;
    }

    public synchronized Collection<Download> qQ(final String str) {
        return TextUtils.isEmpty(str) ? null : this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.2
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || !TextUtils.equals(download.getUrl(), str) || b.this.a(download)) ? false : true;
            }
        });
    }

    public synchronized boolean qR(final String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.3
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

    public synchronized Collection<Download> qS(final String str) {
        return TextUtils.isEmpty(str) ? null : this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.4
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), str);
            }
        });
    }

    public void awY() {
        Collection<Download> awX = awX();
        if (awX != null && !awX.isEmpty()) {
            for (Download download : awX) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.cSA.pause(download.getId().longValue());
                }
            }
        }
    }

    public synchronized void awZ() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.5
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return (download == null || download.getState() != Download.DownloadState.FINISH || b.this.c(download) || !b.b(download) || com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), download.getKeyByUser())) ? false : true;
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
                        this.cSA.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void awR() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.6
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return download != null && download.getState() == Download.DownloadState.FINISH && com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), download.getKeyByUser());
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
                        this.cSA.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void axa() {
        h(this.cSA.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.b.a.b.b.7
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return b.this.a(download);
            }
        }));
    }

    public void qT(String str) {
        if (!TextUtils.isEmpty(str)) {
            h(qS(str));
        }
    }

    public void h(Collection<Download> collection) {
        if (collection != null) {
            for (Download download : collection) {
                if (download != null) {
                    this.cSA.cancel(download.getId().longValue());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [268=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Download download) {
        if (download == null) {
            return false;
        }
        return (c(download) || (download.getState() == Download.DownloadState.FINISH && !b(download))) && !com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), download.getKeyByUser());
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
