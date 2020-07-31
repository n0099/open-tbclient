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
/* loaded from: classes19.dex */
public class c<T> implements com.baidu.swan.pms.a.c<T> {
    private com.baidu.swan.pms.a.c<T> dwC;
    public int mRetryCount = 0;

    public c(com.baidu.swan.pms.a.c<T> cVar) {
        this.dwC = cVar;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.dwC == null ? new Bundle() : this.dwC.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.c
    public String P(T t) {
        String str = null;
        if (this.dwC != null) {
            str = this.dwC.P(t);
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSDownStreamGuard", aLu() + ": getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.f.d.dB(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": getDownloadPath error: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSDownStreamGuard", aLu() + ": getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.c
    public void O(T t) {
        if (this.dwC != null) {
            try {
                this.dwC.O(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloading e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void N(T t) {
        if (this.dwC != null) {
            try {
                this.dwC.N(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadStart e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void M(T t) {
        if (this.dwC != null) {
            try {
                this.dwC.M(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void ae(T t) {
        if (this.dwC != null) {
            try {
                this.dwC.ae(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadStop e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void L(T t) {
        if (this.dwC != null) {
            try {
                this.dwC.L(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadFinish: cb=" + this.dwC);
                    Log.e("PMSDownStreamGuard", aLu() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        if (this.dwC != null) {
            try {
                this.dwC.a((com.baidu.swan.pms.a.c<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", aLu() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", aLu() + ": notify onDownloadError e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> aKO() {
        return this.dwC.aKO();
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return this.dwC != null ? this.dwC.a(t, bufferedSource, file, j) : new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    private String aLu() {
        return com.baidu.swan.pms.d.aKM().getProcessName();
    }
}
