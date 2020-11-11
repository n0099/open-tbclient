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
/* loaded from: classes15.dex */
public class c<T> implements com.baidu.swan.pms.a.c<T> {
    private com.baidu.swan.pms.a.c<T> eic;
    public int mRetryCount = 0;

    public c(com.baidu.swan.pms.a.c<T> cVar) {
        this.eic = cVar;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.eic == null ? new Bundle() : this.eic.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.c
    public String U(T t) {
        String str = null;
        if (this.eic != null) {
            str = this.eic.U(t);
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSDownStreamGuard", bbH() + ": getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.utils.d.dM(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": getDownloadPath error: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSDownStreamGuard", bbH() + ": getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.c
    public void T(T t) {
        if (this.eic != null) {
            try {
                this.eic.T(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloading e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void S(T t) {
        if (this.eic != null) {
            try {
                this.eic.S(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadStart e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void R(T t) {
        if (this.eic != null) {
            try {
                this.eic.R(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void ai(T t) {
        if (this.eic != null) {
            try {
                this.eic.ai(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadStop e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void Q(T t) {
        if (this.eic != null) {
            try {
                this.eic.Q(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadFinish: cb=" + this.eic);
                    Log.e("PMSDownStreamGuard", bbH() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        if (this.eic != null) {
            try {
                this.eic.a((com.baidu.swan.pms.a.c<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", bbH() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", bbH() + ": notify onDownloadError e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> bbd() {
        return this.eic.bbd();
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return this.eic != null ? this.eic.a(t, bufferedSource, file, j) : new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    private String bbH() {
        return com.baidu.swan.pms.d.bbb().getProcessName();
    }
}
