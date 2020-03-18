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
    private com.baidu.swan.pms.a.c<T> cBJ;
    public int mRetryCount = 0;

    public c(com.baidu.swan.pms.a.c<T> cVar) {
        this.cBJ = cVar;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.cBJ == null ? new Bundle() : this.cBJ.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.c
    public String K(T t) {
        String str = null;
        if (this.cBJ != null) {
            str = this.cBJ.K(t);
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("PMSDownStreamGuard", atX() + ": getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.f.c.dE(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": getDownloadPath error: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d("PMSDownStreamGuard", atX() + ": getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.c
    public void J(T t) {
        if (this.cBJ != null) {
            try {
                this.cBJ.J(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloading t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloading e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void I(T t) {
        if (this.cBJ != null) {
            try {
                this.cBJ.I(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadStart t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadStart e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void H(T t) {
        if (this.cBJ != null) {
            try {
                this.cBJ.H(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadProgress t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void Y(T t) {
        if (this.cBJ != null) {
            try {
                this.cBJ.Y(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadStop t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadStop e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void G(T t) {
        if (this.cBJ != null) {
            try {
                this.cBJ.G(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadFinish: t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadFinish: cb=" + this.cBJ);
                    Log.e("PMSDownStreamGuard", atX() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        if (this.cBJ != null) {
            try {
                this.cBJ.a((com.baidu.swan.pms.a.c<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.e("PMSDownStreamGuard", atX() + ": notify onDownloadError t=" + t.toString());
                    Log.e("PMSDownStreamGuard", atX() + ": notify onDownloadError e=" + Log.getStackTraceString(e));
                    throw e;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.c
    public Map<String, Object> atu() {
        return this.cBJ.atu();
    }

    @Override // com.baidu.swan.pms.a.c
    public com.baidu.swan.pms.model.a a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        return this.cBJ != null ? this.cBJ.a(t, bufferedSource, file, j) : new com.baidu.swan.pms.model.a(2302, "业务层默认不处理下载流");
    }

    private String atX() {
        return com.baidu.swan.pms.d.ats().getProcessName();
    }
}
