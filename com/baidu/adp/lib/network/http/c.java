package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class c {
    private b Ar;
    private e tI;
    private int As = 0;
    private long Ah = 0;

    public c(e eVar) {
        this.tI = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [199=15, 200=8, 201=8, 202=8, 203=8, 205=6] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int gr = i3 <= 0 ? com.baidu.adp.framework.c.b.gn().gq().gr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        int gr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.gn().go().gr() : i4;
        boolean z4 = false;
        this.Ar = new b(this.tI);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.Aw = i5 + 1;
                this.As = i5;
                ac(i5);
                z3 = this.Ar.a(str, hVar, gr, gr2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.tI.iv().AQ) {
                            this.tI.iv().AR = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.Az = "responseCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tI.iv().AR = -100;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id = a.id();
                        if (id != null) {
                            id.a(this.tI);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.Az = "responseCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.tI.iv().AR = -19;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id2 = a.id();
                        if (id2 != null) {
                            id2.a(this.tI);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e3) {
                        e = e3;
                        dVar.Az = "responseCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tI.iv().AR = -12;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id3 = a.id();
                        if (id3 != null) {
                            id3.a(this.tI);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        dVar.Az = "responseCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tI.iv().AR = -13;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id4 = a.id();
                        if (id4 != null) {
                            id4.a(this.tI);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e5) {
                        e = e5;
                        dVar.Az = "errorCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tI.iv().AR = -19;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id5 = a.id();
                        if (id5 != null) {
                            id5.a(this.tI);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e6) {
                        e = e6;
                        try {
                            dVar.Az = "errorCode:" + String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.tI.iv().AR = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                            this.tI.a(dVar);
                            a id6 = a.id();
                            if (id6 != null) {
                                id6.a(this.tI);
                            }
                            i5++;
                            z4 = z3;
                        } finally {
                            com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                            this.tI.a(dVar);
                            a id7 = a.id();
                            if (id7 != null) {
                                id7.a(this.tI);
                            }
                        }
                    }
                }
                return z3;
            } catch (FileNotFoundException e7) {
                e = e7;
                z3 = z4;
            } catch (IllegalStateException e8) {
                e = e8;
                z3 = z4;
            } catch (SocketException e9) {
                e = e9;
                z3 = z4;
            } catch (SocketTimeoutException e10) {
                e = e10;
                z3 = z4;
            } catch (IOException e11) {
                e = e11;
                z3 = z4;
            } catch (Exception e12) {
                e = e12;
                z3 = z4;
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=7, 298=7, 300=7, 301=14, 302=7, 303=7, 304=7, 305=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.tI.iv().AQ && z && i4 < i; i4++) {
            d dVar = new d();
            this.tI.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.As = i4;
                            dVar.Aw = i4 + 1;
                            dVar.AG = 1;
                            ac(i4);
                            this.Ar = new b(this.tI);
                            this.Ar.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.tI.iv().AR = -19;
                            dVar.Az = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Ah <= 0 && this.Ar != null) {
                                this.Ah = this.Ar.ig();
                            }
                            dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                            this.tI.b(dVar);
                            a id = a.id();
                            if (id != null) {
                                id.a(this.tI);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.tI.iv().AR = -12;
                        if (this.Ah <= 0 && this.Ar != null) {
                            this.Ah = this.Ar.ig();
                        }
                        dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.b(dVar);
                        a id2 = a.id();
                        if (id2 != null) {
                            id2.a(this.tI);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.tI.iv().AR = -13;
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.b(dVar);
                    a id3 = a.id();
                    if (id3 != null) {
                        id3.a(this.tI);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.tI.iv().AR = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.b(dVar);
                    a id4 = a.id();
                    if (id4 != null) {
                        id4.a(this.tI);
                        return;
                    }
                    return;
                }
                if (this.tI.iv().responseCode == 200) {
                    this.tI.b(dVar);
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.b(dVar);
                    a id5 = a.id();
                    if (id5 != null) {
                        id5.a(this.tI);
                        return;
                    }
                    return;
                }
                dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.tI.iv().responseCode);
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.b(dVar);
                a id6 = a.id();
                if (id6 != null) {
                    id6.a(this.tI);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.b(dVar);
                a id7 = a.id();
                if (id7 != null) {
                    id7.a(this.tI);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=7, 385=7, 387=5, 377=7, 378=7, 380=7, 381=14, 382=7, 383=7] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a id;
        b bVar;
        boolean ij;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.tI.iv().AQ && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.Aw = i4 + 1;
            this.As = i4;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Ar = new b(this.tI);
                            this.Ar.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tI.iv().AR = -14;
                            dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tI.a(dVar);
                            if (this.Ah <= 0 && this.Ar != null) {
                                this.Ah = this.Ar.ig();
                            }
                            dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                            this.tI.a(dVar);
                            a id2 = a.id();
                            if (id2 != null && this.Ar != null && this.Ar.ij()) {
                                id2.a(this.tI);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tI.iv().AR = -13;
                        z = true;
                        dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tI.a(dVar);
                        if (this.Ah <= 0 && this.Ar != null) {
                            this.Ah = this.Ar.ig();
                        }
                        dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id3 = a.id();
                        if (id3 != null && this.Ar != null && this.Ar.ij()) {
                            id3.a(this.tI);
                        }
                    }
                } catch (SocketException e3) {
                    this.tI.iv().AR = -12;
                    z = true;
                    dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tI.a(dVar);
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.a(dVar);
                    a id4 = a.id();
                    if (id4 != null && this.Ar != null && this.Ar.ij()) {
                        id4.a(this.tI);
                    }
                }
                if (this.tI.iv().responseCode == 200) {
                    if (id != null) {
                        if (bVar != null) {
                            if (ij) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4;
                z = ab(this.tI.iv().responseCode);
                this.tI.a(dVar);
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.a(dVar);
                a id5 = a.id();
                if (id5 != null && this.Ar != null && this.Ar.ij()) {
                    id5.a(this.tI);
                }
                z2 = z;
            } finally {
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.a(dVar);
                id = a.id();
                if (id != null && this.Ar != null && this.Ar.ij()) {
                    id.a(this.tI);
                }
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.tI.iu().iy()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [499=7, 500=7, 502=7, 503=14, 504=7, 505=7, 506=7, 507=7, 509=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gn().gq().gr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gn().go().gr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.tI.iv().AQ && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.As = i4;
            dVar.Aw = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Ar = new b(this.tI);
                            this.Ar.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tI.iv().AR = -14;
                            dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tI.a(dVar);
                            if (this.Ah <= 0 && this.Ar != null) {
                                this.Ah = this.Ar.ig();
                            }
                            dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                            this.tI.a(dVar);
                            a id = a.id();
                            if (id != null) {
                                id.a(this.tI);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tI.iv().AR = -13;
                        z = true;
                        dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tI.a(dVar);
                        if (this.Ah <= 0 && this.Ar != null) {
                            this.Ah = this.Ar.ig();
                        }
                        dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                        this.tI.a(dVar);
                        a id2 = a.id();
                        if (id2 != null) {
                            id2.a(this.tI);
                        }
                    }
                } catch (SocketException e3) {
                    this.tI.iv().AR = -12;
                    z = true;
                    dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tI.a(dVar);
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.a(dVar);
                    a id3 = a.id();
                    if (id3 != null) {
                        id3.a(this.tI);
                    }
                } catch (Throwable th) {
                    this.tI.iv().AR = -10;
                    z = false;
                    dVar.Az = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.tI.a(dVar);
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.a(dVar);
                    a id4 = a.id();
                    if (id4 != null) {
                        id4.a(this.tI);
                    }
                }
                if (this.tI.iv().responseCode == 200) {
                    if (this.Ah <= 0 && this.Ar != null) {
                        this.Ah = this.Ar.ig();
                    }
                    dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                    this.tI.a(dVar);
                    a id5 = a.id();
                    if (id5 != null) {
                        id5.a(this.tI);
                        return;
                    }
                    return;
                }
                dVar.Az = String.valueOf(this.tI.iv().responseCode) + "|retryCount:" + i4;
                z = ab(this.tI.iv().responseCode);
                this.tI.a(dVar);
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.a(dVar);
                a id6 = a.id();
                if (id6 != null) {
                    id6.a(this.tI);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ah <= 0 && this.Ar != null) {
                    this.Ah = this.Ar.ig();
                }
                dVar.Ax = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hH().a(this.tI.iu().getUrl(), this.tI.iu().aB(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Az), dVar.AD != null);
                this.tI.a(dVar);
                a id7 = a.id();
                if (id7 != null) {
                    id7.a(this.tI);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Ar != null) {
            this.Ar.ik();
        }
    }

    public boolean im() {
        if (this.tI == null) {
            return false;
        }
        return this.tI.iv().AQ;
    }

    public void in() {
        if (this.tI != null) {
            this.tI.iv().AQ = true;
        }
    }

    public long ip() {
        if (this.Ah > 0) {
            return this.Ah;
        }
        if (this.Ar == null) {
            return -1L;
        }
        return this.Ar.ig();
    }

    public long iq() {
        if (this.Ar == null) {
            return -1L;
        }
        return this.Ar.ih();
    }

    public long ii() {
        if (this.Ar == null) {
            return -1L;
        }
        return this.Ar.ii();
    }

    public long ir() {
        if (this.Ar == null) {
            return -1L;
        }
        return this.Ar.m9if();
    }

    public long is() {
        if (this.Ar == null) {
            return -1L;
        }
        return this.Ar.ie();
    }

    public int it() {
        return this.As;
    }

    private void ac(int i) {
        try {
            if (this.tI != null && i > 0) {
                this.tI.iu().q("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
