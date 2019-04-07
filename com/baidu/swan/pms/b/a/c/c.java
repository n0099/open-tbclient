package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c<T> implements com.baidu.swan.pms.a.a<T> {
    private com.baidu.swan.pms.a.a<T> bmu;
    private T bmw;
    public int mRetryCount = 0;
    private List<com.baidu.swan.pms.a.a<T>> bmv = new ArrayList();

    public c(T t, com.baidu.swan.pms.a.a<T> aVar) {
        this.bmw = t;
        this.bmu = aVar;
    }

    public void a(com.baidu.swan.pms.a.a<T> aVar) {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSDownStreamGuard", "attachCallback:" + aVar);
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public String hp() {
        String str = null;
        if (this.bmu != null) {
            str = this.bmu.hp();
        }
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("PMSDownStreamGuard", "getDownloadPath:" + str);
        }
        if (str == null) {
            try {
                str = com.baidu.swan.pms.d.c.cC(AppRuntime.getAppContext()).getAbsolutePath();
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
        if (this.bmu != null) {
            try {
                this.bmu.G(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloading error:" + t.toString());
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void F(T t) {
        if (this.bmu != null) {
            try {
                this.bmu.F(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadStart error:" + t.toString());
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.a.a
    public void S(T t) {
        if (this.bmu != null) {
            try {
                this.bmu.S(t);
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
        if (this.bmu != null) {
            try {
                this.bmu.T(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadStop error:" + t.toString());
                }
            }
        }
        if (this.bmv.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.bmv.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.bmw;
                        if (next instanceof c) {
                            T t4 = ((c) next).bmw;
                            a(this.bmw, t4, i3);
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
        if (this.bmu != null) {
            try {
                this.bmu.E(t);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadFinish error:" + t.toString());
                }
            }
        }
        if (this.bmv.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.bmv.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.bmw;
                        if (next instanceof c) {
                            T t4 = ((c) next).bmw;
                            a(this.bmw, t4, i3);
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
    public void a(T t, com.baidu.swan.pms.model.b bVar) {
        Throwable th;
        int i;
        T t2;
        if (this.bmu != null) {
            try {
                this.bmu.a(t, bVar);
            } catch (Exception e) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.e("PMSDownStreamGuard", "notify onDownloadError error:" + t.toString());
                }
            }
        }
        if (this.bmv.size() > 0) {
            int i2 = 1;
            Iterator<com.baidu.swan.pms.a.a<T>> it = this.bmv.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    com.baidu.swan.pms.a.a<T> next = it.next();
                    try {
                        T t3 = this.bmw;
                        if (next instanceof c) {
                            T t4 = ((c) next).bmw;
                            a(this.bmw, t4, i3);
                            i = i3 + 1;
                            t2 = t4;
                        } else {
                            i = i3;
                            t2 = t3;
                        }
                        try {
                            next.a(t2, bVar);
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

    private void a(T t, T t2, int i) {
        if ((t instanceof com.baidu.swan.pms.model.d) && (t2 instanceof com.baidu.swan.pms.model.d)) {
            com.baidu.swan.pms.model.d dVar = (com.baidu.swan.pms.model.d) t;
            com.baidu.swan.pms.model.d dVar2 = (com.baidu.swan.pms.model.d) t2;
            dVar2.state = dVar.state;
            dVar2.filePath = dVar.filePath;
            dVar2.currentSize = dVar.currentSize;
            dVar2.createTime = dVar.createTime;
            dVar2.updateTime = dVar.updateTime;
            dVar2.acN = i;
        }
    }
}
