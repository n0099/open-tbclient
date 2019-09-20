package com.baidu.swan.pms.b.a.c;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
/* loaded from: classes2.dex */
public class c<T> implements com.baidu.swan.pms.a.a<T> {
    private com.baidu.swan.pms.a.a<T> btK;
    private T btM;
    public int mRetryCount = 0;
    private List<com.baidu.swan.pms.a.a<T>> btL = new ArrayList();

    public c(T t, com.baidu.swan.pms.a.a<T> aVar) {
        this.btM = t;
        this.btK = aVar;
    }

    public void a(com.baidu.swan.pms.a.a<T> aVar) {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSDownStreamGuard", "attachCallback:" + aVar);
        }
    }

    @Override // com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        return this.btK == null ? new Bundle() : this.btK.a(bundle, set);
    }

    @Override // com.baidu.swan.pms.a.a
    public String gs() {
        String str = null;
        if (this.btK != null) {
            str = this.btK.gs();
        }
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSDownStreamGuard", "getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.e.c.cg(AppRuntime.getAppContext()).getAbsolutePath();
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.d("PMSDownStreamGuard", "getDownloadPath error:" + e.getMessage());
                }
            }
            if (com.baidu.swan.pms.e.DEBUG) {
                Log.d("PMSDownStreamGuard", "getDownloadPath failed, using default path:" + str);
            }
        }
        return str;
    }

    @Override // com.baidu.swan.pms.a.a
    public void G(T t) {
        if (this.btK != null) {
            try {
                this.btK.G(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloading error:" + t.toString());
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void F(T t) {
        if (this.btK != null) {
            try {
                this.btK.F(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadStart error:" + t.toString());
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void R(T t) {
        if (this.btK != null) {
            try {
                this.btK.R(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadProgress error:" + t.toString());
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void T(T t) {
        Throwable th;
        int i;
        T t2;
        if (this.btK != null) {
            try {
                this.btK.T(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadStop error:" + t.toString());
                }
            }
        }
        if (this.btL.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.btL.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.btM;
                        if (next instanceof c) {
                            T t4 = ((c) next).btM;
                            a(this.btM, t4, i3);
                            i = i3 + 1;
                            t2 = t4;
                        } else {
                            i = i3;
                            t2 = t3;
                        }
                        try {
                            next.T(t2);
                            i2 = i;
                        } catch (Throwable th2) {
                            i2 = i;
                            th = th2;
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.e("PMSDownStreamGuard", "notify onDownloadStop error:" + th.toString());
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void E(T t) {
        Throwable th;
        int i;
        T t2;
        if (this.btK != null) {
            try {
                this.btK.E(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadFinish error:" + t.toString());
                }
            }
        }
        if (this.btL.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.btL.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.btM;
                        if (next instanceof c) {
                            T t4 = ((c) next).btM;
                            a(this.btM, t4, i3);
                            i = i3 + 1;
                            t2 = t4;
                        } else {
                            i = i3;
                            t2 = t3;
                        }
                        try {
                            next.E(t2);
                            i2 = i;
                        } catch (Throwable th2) {
                            i2 = i;
                            th = th2;
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.e("PMSDownStreamGuard", "notify onDownloadFinish error:" + th.toString());
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
        Throwable th;
        int i;
        T t2;
        if (this.btK != null) {
            try {
                this.btK.a((com.baidu.swan.pms.a.a<T>) t, aVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadError error:" + t.toString());
                }
            }
        }
        if (this.btL.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.btL.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.btM;
                        if (next instanceof c) {
                            T t4 = ((c) next).btM;
                            a(this.btM, t4, i3);
                            i = i3 + 1;
                            t2 = t4;
                        } else {
                            i = i3;
                            t2 = t3;
                        }
                        try {
                            next.a((com.baidu.swan.pms.a.a<T>) t2, aVar);
                            i2 = i;
                        } catch (Throwable th2) {
                            i2 = i;
                            th = th2;
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.e("PMSDownStreamGuard", "notify onDownloadError error:" + th.toString());
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public boolean a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        if (this.btK != null) {
            return this.btK.a(t, bufferedSource, file, j);
        }
        return a(bufferedSource, new FileOutputStream(file), j);
    }

    private boolean a(BufferedSource bufferedSource, OutputStream outputStream, long j) throws IOException {
        InputStream newInputStream = Channels.newInputStream(bufferedSource);
        byte[] bArr = new byte[com.baidu.swan.pms.a.g.a(this, "swan_pms_buffer").getInt("swan_pms_buffer", 64)];
        int i = 0;
        int length = bArr.length;
        long j2 = 0;
        while (i != -1) {
            if (j > 0) {
                if (j2 >= j) {
                    break;
                } else if (length + j2 > j) {
                    length = (int) (j - j2);
                }
            }
            i = newInputStream.read(bArr, 0, length);
            if (i > 0) {
                outputStream.write(bArr, 0, i);
                j2 += i;
            }
        }
        return j2 == j;
    }

    private void a(T t, T t2, int i) {
        if ((t instanceof com.baidu.swan.pms.model.c) && (t2 instanceof com.baidu.swan.pms.model.c)) {
            com.baidu.swan.pms.model.c cVar = (com.baidu.swan.pms.model.c) t;
            com.baidu.swan.pms.model.c cVar2 = (com.baidu.swan.pms.model.c) t2;
            cVar2.state = cVar.state;
            cVar2.filePath = cVar.filePath;
            cVar2.currentSize = cVar.currentSize;
            cVar2.createTime = cVar.createTime;
            cVar2.updateTime = cVar.updateTime;
            cVar2.aaX = i;
        }
    }
}
