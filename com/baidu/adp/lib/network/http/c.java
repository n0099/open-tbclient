package com.baidu.adp.lib.network.http;

import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public final class c {
    private e a;

    public c(e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=6, 127=6] */
    public final void a(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.e.b.a().k().b();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.e.b.a().j();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.e.b.a().b().b();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.a.b().a && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    dVar.e = i4 + 1;
                    new a(this.a).a(i2, i3, dVar);
                } catch (SocketException e) {
                    dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                    this.a.b().b = -12;
                    this.a.a(dVar);
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e2) {
                    dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.a.b().b = -13;
                    this.a.a(dVar);
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    z = true;
                } catch (Exception e3) {
                    dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.a.b().b = -10;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetData", "error = " + e3.getMessage());
                    this.a.a(dVar);
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    return;
                }
                if (this.a.b().b == 200) {
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    return;
                }
                dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4;
                z = a(this.a.b().b);
                this.a.a(dVar);
                dVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.a(dVar);
            } catch (Throwable th) {
                dVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.a(dVar);
                throw th;
            }
        }
    }

    private static boolean a(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504) ? false : true;
    }

    public final void b(int i, int i2, int i3) {
        if (this.a.a().c()) {
            if (i2 <= 0) {
                i2 = com.baidu.adp.framework.e.b.a().k().b();
            }
            if (i <= 0) {
                i = com.baidu.adp.framework.e.b.a().j();
            }
            if (i3 <= 0) {
                i3 = com.baidu.adp.framework.e.b.a().b().b();
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            for (int i4 = 0; !this.a.b().a && z && i4 < i; i4++) {
                d dVar = new d();
                dVar.e = i4 + 1;
                try {
                    try {
                        try {
                            try {
                                new a(this.a).b(i2, i3, dVar);
                            } catch (SocketTimeoutException e) {
                                this.a.b().b = -13;
                                dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e.getMessage());
                                this.a.a(dVar);
                                dVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.a(dVar);
                                z = true;
                            }
                        } catch (UnsupportedOperationException e2) {
                            this.a.b().b = -14;
                            dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                            this.a.a(dVar);
                            dVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.a(dVar);
                            z = false;
                        }
                    } catch (SocketException e3) {
                        this.a.b().b = -12;
                        dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketException " + e3.getMessage());
                        this.a.a(dVar);
                        dVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.a(dVar);
                        z = true;
                    } catch (Throwable th) {
                        this.a.b().b = -10;
                        dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", th.getMessage());
                        this.a.a(dVar);
                        dVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.a(dVar);
                        z = false;
                    }
                    if (this.a.b().b == 200) {
                        return;
                    }
                    dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4;
                    z = a(this.a.b().b);
                    this.a.a(dVar);
                } finally {
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                }
            }
            return;
        }
        c(i, i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [301=7, 302=7] */
    private void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.e.b.a().k().b();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.e.b.a().j();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.e.b.a().b().b();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.a.b().a && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.e = i4 + 1;
            try {
                try {
                    try {
                        new a(this.a).c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.a.b().b = -14;
                        dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                        this.a.a(dVar);
                        dVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.a(dVar);
                        z = false;
                    } catch (Throwable th) {
                        this.a.b().b = -10;
                        dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", th.getMessage());
                        this.a.a(dVar);
                        dVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.a.b().b = -12;
                    dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketException " + e2.getMessage());
                    this.a.a(dVar);
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.a.b().b = -13;
                    dVar.h = com.baidu.adp.a.b.a().b().getApplicationContext().getResources().getString(com.baidu.adp.f.neterror);
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e3.getMessage());
                    this.a.a(dVar);
                    dVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.a(dVar);
                    z = true;
                }
                if (this.a.b().b == 200) {
                    return;
                }
                dVar.h = String.valueOf(String.valueOf(this.a.b().b)) + "|retryCount:" + i4;
                z = a(this.a.b().b);
                this.a.a(dVar);
            } finally {
                dVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.a(dVar);
            }
        }
    }
}
