package com.baidu.b.a.f.d;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements com.baidu.b.a.b.c.b {
    private com.baidu.b.a.b.c.b ZV;
    private com.baidu.b.a.c.a.a ZX;
    public int mRetryCount = 0;
    private List<com.baidu.b.a.b.c.b> ZW = new ArrayList();

    public b(com.baidu.b.a.b.c.b bVar, com.baidu.b.a.c.a.a aVar) {
        this.ZW.add(bVar);
        this.ZV = bVar;
        this.ZX = aVar;
    }

    public void a(com.baidu.b.a.b.c.b bVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "attachCallback:" + bVar);
        }
        if (bVar != null && bVar != this.ZV) {
            this.ZW.add(bVar);
        }
    }

    @Override // com.baidu.b.a.b.c.b
    public int getDownloadOptions() {
        if (this.ZV != null) {
            return this.ZV.getDownloadOptions();
        }
        return 0;
    }

    @Override // com.baidu.b.a.b.c.b
    public Map<String, Integer> getOptions() {
        if (this.ZV != null) {
            return this.ZV.getOptions();
        }
        return null;
    }

    @Override // com.baidu.b.a.b.c.b
    public String getDownloadPath() {
        String str = null;
        if (this.ZV != null) {
            str = this.ZV.getDownloadPath();
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
        return this.ZV != null ? this.ZV.getDownloadItems() : new ArrayList(0);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onDownloading:" + aVar);
        }
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        com.baidu.b.a.h.g.sk().a(this.ZX.KC, this.ZX.errMsg, this.ZX.channelId, this.ZX.packageName, this.ZX.Zn, this.ZX.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFileCancel(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onFileCancel:" + aVar);
        }
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        com.baidu.b.a.h.g.sk().a(this.ZX.KC, this.ZX.errMsg, this.ZX.channelId, this.ZX.packageName, this.ZX.Zn, this.ZX.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onDownloadError:" + aVar);
        }
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        com.baidu.b.a.h.g.sk().a(this.ZX.KC, this.ZX.errMsg, this.ZX.channelId, this.ZX.packageName, this.ZX.Zn, this.ZX.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, com.baidu.b.a.c.a.a aVar2) {
        if (com.baidu.b.a.h.b.isDebug()) {
            Log.d("DownloadCallbackGuard", "onFileDownloaded:" + aVar);
        }
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
        com.baidu.b.a.h.g.sk().a(aVar2.KC, aVar2.errMsg, aVar2.channelId, aVar2.packageName, aVar2.Zn, aVar2.downloadUrl, "", 0, this.mRetryCount);
    }

    @Override // com.baidu.b.a.b.c.b
    public void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list, List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3) {
        if (this.ZW.size() > 0) {
            for (com.baidu.b.a.b.c.b bVar : this.ZW) {
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
            ((b) bVar).ZX.KC = this.ZX.KC;
            ((b) bVar).ZX.errMsg = this.ZX.errMsg;
            ((b) bVar).ZX.Zm = this.ZX.Zm;
        }
    }

    public String toString() {
        return "DownloadGuard{DynamicFile:" + this.ZX + ",callback:" + this.ZV;
    }
}
