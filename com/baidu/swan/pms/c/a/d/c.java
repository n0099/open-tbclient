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
/* loaded from: classes11.dex */
public class c<T> implements com.baidu.swan.pms.a.c<T> {
    private com.baidu.swan.pms.a.c<T> dlZ;
    public int mRetryCount = 0;

    public c(com.baidu.swan.pms.a.c<T> cVar) {
        this.dlZ = cVar;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.dlZ == null ? new Bundle() : this.dlZ.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.c
    public String P(T t) {
        String str = null;
        if (this.dlZ != null) {
            str = this.dlZ.P(t);
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSDownStreamGuard", aGx() + ": getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.f.c.dw(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": getDownloadPath error: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSDownStreamGuard", aGx() + ": getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.c
    public void O(T t) {
        if (this.dlZ != null) {
            try {
                this.dlZ.O(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloading e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void N(T t) {
        if (this.dlZ != null) {
            try {
                this.dlZ.N(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadStart e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void M(T t) {
        if (this.dlZ != null) {
            try {
                this.dlZ.M(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void ae(T t) {
        if (this.dlZ != null) {
            try {
                this.dlZ.ae(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadStop e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void L(T t) {
        if (this.dlZ != null) {
            try {
                this.dlZ.L(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadFinish: cb=" + this.dlZ);
                    Log.e("PMSDownStreamGuard", aGx() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        if (this.dlZ != null) {
            try {
                this.dlZ.a((com.baidu.swan.pms.a.c<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aGx() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aGx() + ": notify onDownloadError e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> aFR() {
        return this.dlZ.aFR();
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return this.dlZ != null ? this.dlZ.a(t, bufferedSource, file, j) : new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    private String aGx() {
        return com.baidu.swan.pms.d.aFP().getProcessName();
    }
}
