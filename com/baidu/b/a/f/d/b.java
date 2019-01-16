package com.baidu.b.a.f.d;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements com.baidu.b.a.b.c.b {
    private com.baidu.b.a.b.c.b aae;
    private com.baidu.b.a.c.a.a aag;
    public int mRetryCount = 0;
    private List<com.baidu.b.a.b.c.b> aaf = new ArrayList();

    public b(com.baidu.b.a.b.c.b bVar, com.baidu.b.a.c.a.a aVar) {
        this.aaf.add(bVar);
        this.aae = bVar;
        this.aag = aVar;
    }

    public void a(com.baidu.b.a.b.c.b bVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "attachCallback:" + bVar);
        }
        if (bVar != null && bVar != this.aae) {
            this.aaf.add(bVar);
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public int getDownloadOptions() {
        if (this.aae != null) {
            return this.aae.getDownloadOptions();
        }
        return 0;
    }

    @Override // com.baidu.b.a.b.c.b
    public Map<String, Integer> getOptions() {
        if (this.aae != null) {
            return this.aae.getOptions();
        }
        return null;
    }

    @Override // com.baidu.b.a.b.c.b
    public String getDownloadPath() {
        String str = null;
        if (this.aae != null) {
            str = this.aae.getDownloadPath();
        }
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.b.a.h.f.bk(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.d("DownloadCallbackGuard", "getDownloadPath error:" + e.getMessage());
                }
            }
            if (com.baidu.b.a.h.b.isDebug()) {
                Log.d("DownloadCallbackGuard", "getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.b.a.b.c.b
    public List<com.baidu.b.a.c.a.a> getDownloadItems() {
        return this.aae != null ? this.aae.getDownloadItems() : new ArrayList(0);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onDownloading:" + aVar);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    bVar.onDownloading(aVar);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onDownloading error:" + th.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public void onDownloadStart(String str) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onDownloadStart:" + str);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    bVar.onDownloadStart(str);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onDownloadStart error:" + th.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFileProgress(String str, long j, long j2) {
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    bVar.onFileProgress(str, j, j2);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onFileProgress error:" + th.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFilePause(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onFilePause:" + aVar);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    b(bVar);
                    bVar.onFilePause(aVar);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onFilePause error:" + th.toString());
                    }
                }
            }
        }
        com.baidu.b.a.h.g.sn().a(this.aag.KI, this.aag.errMsg, this.aag.channelId, this.aag.packageName, this.aag.Zw, this.aag.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFileCancel(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onFileCancel:" + aVar);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    b(bVar);
                    bVar.onFileCancel(aVar);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onFileCancel error:" + th.toString());
                    }
                }
            }
        }
        com.baidu.b.a.h.g.sn().a(this.aag.KI, this.aag.errMsg, this.aag.channelId, this.aag.packageName, this.aag.Zw, this.aag.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onDownloadError:" + aVar);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    b(bVar);
                    bVar.onDownloadError(aVar);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onDownloadError error:" + th.toString());
                    }
                }
            }
        }
        com.baidu.b.a.h.g.sn().a(this.aag.KI, this.aag.errMsg, this.aag.channelId, this.aag.packageName, this.aag.Zw, this.aag.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, com.baidu.b.a.c.a.a aVar2) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onFileDownloaded:" + aVar);
        }
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    b(bVar);
                    bVar.onFileDownloaded(aVar, aVar2);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onFileDownloaded error:" + th.toString());
                    }
                }
            }
        }
        com.baidu.b.a.h.g.sn().a(aVar2.KI, aVar2.errMsg, aVar2.channelId, aVar2.packageName, aVar2.Zw, aVar2.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list, List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3) {
        if (this.aaf.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.aaf) {
                try {
                    bVar.onBulkDownloaded(list, list2, list3);
                } catch (Throwable th) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        Log.e("DownloadCallbackGuard", "notify onBulkDownloaded error:" + th.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public String getChannelId() {
        return null;
    }

    @Override // com.baidu.b.a.b.c.b
    public String getPackageName() {
        return null;
    }

    private void b(com.baidu.b.a.b.c.b bVar) {
        if (bVar instanceof b) {
            ((b) bVar).aag.KI = this.aag.KI;
            ((b) bVar).aag.errMsg = this.aag.errMsg;
            ((b) bVar).aag.Zv = this.aag.Zv;
        }
    }

    public String toString() {
        return "DownloadGuard{DynamicFile:" + this.aag + ",callback:" + this.aae;
    }
}
