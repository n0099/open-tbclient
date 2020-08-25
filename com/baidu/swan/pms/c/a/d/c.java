package com.baidu.swan.pms.c.a.d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import okio.BufferedSource;
/* loaded from: classes14.dex */
public class c<T> implements com.baidu.swan.pms.a.c<T> {
    private com.baidu.swan.pms.a.c<T> dFF;
    public int mRetryCount = 0;

    public c(com.baidu.swan.pms.a.c<T> cVar) {
        this.dFF = cVar;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.dFF == null ? new Bundle() : this.dFF.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.c
    public String Q(T t) {
        String str = null;
        if (this.dFF != null) {
            str = this.dFF.Q(t);
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSDownStreamGuard", aTT() + ": getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.utils.d.dH(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": getDownloadPath error: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSDownStreamGuard", aTT() + ": getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.c
    public void P(T t) {
        if (this.dFF != null) {
            try {
                this.dFF.P(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloading e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void O(T t) {
        if (this.dFF != null) {
            try {
                this.dFF.O(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadStart e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void N(T t) {
        if (this.dFF != null) {
            try {
                this.dFF.N(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void ae(T t) {
        if (this.dFF != null) {
            try {
                this.dFF.ae(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadStop e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void M(T t) {
        if (this.dFF != null) {
            try {
                this.dFF.M(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadFinish: cb=" + this.dFF);
                    Log.e("PMSDownStreamGuard", aTT() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        if (this.dFF != null) {
            try {
                this.dFF.a((com.baidu.swan.pms.a.c<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aTT() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aTT() + ": notify onDownloadError e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> aTp() {
        return this.dFF.aTp();
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return this.dFF != null ? this.dFF.a(t, bufferedSource, file, j) : new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    private String aTT() {
        return com.baidu.swan.pms.d.aTn().getProcessName();
    }
}
