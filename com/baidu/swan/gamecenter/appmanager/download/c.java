package com.baidu.swan.gamecenter.appmanager.download;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private DownloadManager edL;

    public c(DownloadManager downloadManager) {
        this.edL = downloadManager;
    }

    public Collection<Download> aWS() {
        return this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.1
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || c.this.a(download)) ? false : true;
            }
        });
    }

    public Download wz(String str) {
        Download download = null;
        Collection<Download> wA = wA(str);
        if (wA != null) {
            for (Download download2 : wA) {
                if (download2 == null) {
                    download2 = download;
                }
                download = download2;
            }
        }
        return download;
    }

    public synchronized Collection<Download> wA(final String str) {
        return TextUtils.isEmpty(str) ? null : this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.2
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return (download == null || !TextUtils.equals(download.getUrl(), str) || c.this.a(download)) ? false : true;
            }
        });
    }

    public synchronized boolean wB(final String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.3
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

    public synchronized Collection<Download> wC(final String str) {
        return TextUtils.isEmpty(str) ? null : this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.4
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return download != null && TextUtils.equals(download.getUrl(), str);
            }
        });
    }

    public void aVk() {
        Collection<Download> aWS = aWS();
        if (aWS != null && !aWS.isEmpty()) {
            for (Download download : aWS) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.edL.pause(download.getId().longValue());
                }
            }
        }
    }

    public Collection<Download> aWT() {
        Collection<Download> aWS = aWS();
        if (aWS == null || aWS.isEmpty()) {
            return null;
        }
        for (Download download : aWS) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                this.edL.resume(download.getId().longValue());
            }
        }
        return aWS;
    }

    public synchronized void aWU() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.5
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return (download == null || download.getState() != Download.DownloadState.FINISH || c.this.c(download) || !c.b(download) || com.baidu.swan.gamecenter.appmanager.install.a.au(AppRuntime.getAppContext(), download.getKeyByUser())) ? false : true;
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
                        this.edL.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void aWK() {
        int size;
        int i = 0;
        synchronized (this) {
            Collection<Download> downloadListByFilter = this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.6
                @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
                public boolean filter(Download download) {
                    return download != null && download.getState() == Download.DownloadState.FINISH && com.baidu.swan.gamecenter.appmanager.install.a.au(AppRuntime.getAppContext(), download.getKeyByUser());
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
                        this.edL.cancel(next.getId().longValue());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public synchronized void aWV() {
        j(this.edL.getDownloadListByFilter(new DownloadManager.DownloadItemFilter() { // from class: com.baidu.swan.gamecenter.appmanager.download.c.7
            @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
            public boolean filter(Download download) {
                return c.this.a(download);
            }
        }));
    }

    public void wD(String str) {
        if (!TextUtils.isEmpty(str)) {
            j(wC(str));
        }
    }

    public void j(Collection<Download> collection) {
        if (collection != null) {
            for (Download download : collection) {
                if (download != null) {
                    this.edL.cancel(download.getId().longValue());
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
        return (c(download) || (download.getState() == Download.DownloadState.FINISH && !b(download))) && !com.baidu.swan.gamecenter.appmanager.install.a.au(AppRuntime.getAppContext(), download.getKeyByUser());
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
