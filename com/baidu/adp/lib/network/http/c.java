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
    private e lh;
    private b or;
    private int ot = 0;
    private long of = 0;

    public c(e eVar) {
        this.lh = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [199=15, 200=8, 201=8, 202=8, 203=8, 205=6] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.or = new b(this.lh);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.ow = i5 + 1;
                this.ot = i5;
                L(i5);
                z3 = this.or.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.lh.fK().oT) {
                            this.lh.fK().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.lh.fK().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx = a.fx();
                        if (fx != null) {
                            fx.a(this.lh);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.lh.fK().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx2 = a.fx();
                        if (fx2 != null) {
                            fx2.a(this.lh);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.lh.fK().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx3 = a.fx();
                        if (fx3 != null) {
                            fx3.a(this.lh);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.lh.fK().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx4 = a.fx();
                        if (fx4 != null) {
                            fx4.a(this.lh);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e5) {
                        e = e5;
                        dVar.exception = "errorCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.lh.fK().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx5 = a.fx();
                        if (fx5 != null) {
                            fx5.a(this.lh);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e6) {
                        e = e6;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.lh.fK().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                            this.lh.a(dVar);
                            a fx6 = a.fx();
                            if (fx6 != null) {
                                fx6.a(this.lh);
                            }
                            i5++;
                            z4 = z3;
                        } finally {
                            com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                            this.lh.a(dVar);
                            a fx7 = a.fx();
                            if (fx7 != null) {
                                fx7.a(this.lh);
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
    public void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.lh.fK().oT && z && i4 < i; i4++) {
            d dVar = new d();
            this.lh.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.ot = i4;
                            dVar.ow = i4 + 1;
                            dVar.oG = 1;
                            L(i4);
                            this.or = new b(this.lh);
                            this.or.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.lh.fK().mNetErrorCode = -19;
                            dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.of <= 0 && this.or != null) {
                                this.of = this.or.fA();
                            }
                            dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                            this.lh.b(dVar);
                            a fx = a.fx();
                            if (fx != null) {
                                fx.a(this.lh);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.lh.fK().mNetErrorCode = -12;
                        if (this.of <= 0 && this.or != null) {
                            this.of = this.or.fA();
                        }
                        dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.b(dVar);
                        a fx2 = a.fx();
                        if (fx2 != null) {
                            fx2.a(this.lh);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.lh.fK().mNetErrorCode = -13;
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.b(dVar);
                    a fx3 = a.fx();
                    if (fx3 != null) {
                        fx3.a(this.lh);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.lh.fK().mNetErrorCode = -10;
                    BdLog.e(e4.getMessage());
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.b(dVar);
                    a fx4 = a.fx();
                    if (fx4 != null) {
                        fx4.a(this.lh);
                        return;
                    }
                    return;
                }
                if (this.lh.fK().responseCode == 200) {
                    this.lh.b(dVar);
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.b(dVar);
                    a fx5 = a.fx();
                    if (fx5 != null) {
                        fx5.a(this.lh);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4;
                boolean K = K(this.lh.fK().responseCode);
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.b(dVar);
                a fx6 = a.fx();
                if (fx6 != null) {
                    fx6.a(this.lh);
                }
                z = K;
            } catch (Throwable th) {
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.b(dVar);
                a fx7 = a.fx();
                if (fx7 != null) {
                    fx7.a(this.lh);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=7, 385=7, 387=5, 377=7, 378=7, 380=7, 381=14, 382=7, 383=7] */
    private void d(int i, int i2, int i3) {
        boolean z;
        a fx;
        b bVar;
        boolean fD;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lh.fK().oT && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.ow = i4 + 1;
            this.ot = i4;
            L(i4);
            try {
                try {
                    try {
                        try {
                            this.or = new b(this.lh);
                            this.or.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.lh.fK().mNetErrorCode = -14;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.lh.a(dVar);
                            if (this.of <= 0 && this.or != null) {
                                this.of = this.or.fA();
                            }
                            dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                            this.lh.a(dVar);
                            a fx2 = a.fx();
                            if (fx2 != null && this.or != null && this.or.fD()) {
                                fx2.a(this.lh);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lh.fK().mNetErrorCode = -13;
                        z = true;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lh.a(dVar);
                        if (this.of <= 0 && this.or != null) {
                            this.of = this.or.fA();
                        }
                        dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx3 = a.fx();
                        if (fx3 != null && this.or != null && this.or.fD()) {
                            fx3.a(this.lh);
                        }
                    }
                } catch (SocketException e3) {
                    this.lh.fK().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lh.a(dVar);
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.a(dVar);
                    a fx4 = a.fx();
                    if (fx4 != null && this.or != null && this.or.fD()) {
                        fx4.a(this.lh);
                    }
                }
                if (this.lh.fK().responseCode == 200) {
                    if (fx != null) {
                        if (bVar != null) {
                            if (fD) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4;
                z = K(this.lh.fK().responseCode);
                this.lh.a(dVar);
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.a(dVar);
                a fx5 = a.fx();
                if (fx5 != null && this.or != null && this.or.fD()) {
                    fx5.a(this.lh);
                }
                z2 = z;
            } finally {
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.a(dVar);
                fx = a.fx();
                if (fx != null && this.or != null && this.or.fD()) {
                    fx.a(this.lh);
                }
            }
        }
    }

    private boolean K(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.lh.fJ().fN()) {
            d(i, i2, i3);
        } else {
            f(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [499=7, 500=7, 502=7, 503=14, 504=7, 505=7, 506=7, 507=7, 509=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.lh.fK().oT && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.ot = i4;
            dVar.ow = i4 + 1;
            L(i4);
            try {
                try {
                    try {
                        try {
                            this.or = new b(this.lh);
                            this.or.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.lh.fK().mNetErrorCode = -14;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.lh.a(dVar);
                            if (this.of <= 0 && this.or != null) {
                                this.of = this.or.fA();
                            }
                            dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                            this.lh.a(dVar);
                            a fx = a.fx();
                            if (fx != null) {
                                fx.a(this.lh);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.lh.fK().mNetErrorCode = -13;
                        z = true;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.lh.a(dVar);
                        if (this.of <= 0 && this.or != null) {
                            this.of = this.or.fA();
                        }
                        dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                        this.lh.a(dVar);
                        a fx2 = a.fx();
                        if (fx2 != null) {
                            fx2.a(this.lh);
                        }
                    }
                } catch (SocketException e3) {
                    this.lh.fK().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.lh.a(dVar);
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.a(dVar);
                    a fx3 = a.fx();
                    if (fx3 != null) {
                        fx3.a(this.lh);
                    }
                } catch (Throwable th) {
                    this.lh.fK().mNetErrorCode = -10;
                    z = false;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.lh.a(dVar);
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.a(dVar);
                    a fx4 = a.fx();
                    if (fx4 != null) {
                        fx4.a(this.lh);
                    }
                }
                if (this.lh.fK().responseCode == 200) {
                    if (this.of <= 0 && this.or != null) {
                        this.of = this.or.fA();
                    }
                    dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                    this.lh.a(dVar);
                    a fx5 = a.fx();
                    if (fx5 != null) {
                        fx5.a(this.lh);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.lh.fK().responseCode) + "|retryCount:" + i4;
                z = K(this.lh.fK().responseCode);
                this.lh.a(dVar);
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.a(dVar);
                a fx6 = a.fx();
                if (fx6 != null) {
                    fx6.a(this.lh);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.of <= 0 && this.or != null) {
                    this.of = this.or.fA();
                }
                dVar.ox = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fh().a(this.lh.fJ().getUrl(), this.lh.fJ().ah(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.exception), dVar.oC != null);
                this.lh.a(dVar);
                a fx7 = a.fx();
                if (fx7 != null) {
                    fx7.a(this.lh);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.or != null) {
            this.or.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.lh == null) {
            return false;
        }
        return this.lh.fK().oT;
    }

    public void setCancel() {
        if (this.lh != null) {
            this.lh.fK().oT = true;
        }
    }

    public long fE() {
        if (this.of > 0) {
            return this.of;
        }
        if (this.or == null) {
            return -1L;
        }
        return this.or.fA();
    }

    public long fF() {
        if (this.or == null) {
            return -1L;
        }
        return this.or.fB();
    }

    public long fC() {
        if (this.or == null) {
            return -1L;
        }
        return this.or.fC();
    }

    public long fG() {
        if (this.or == null) {
            return -1L;
        }
        return this.or.fz();
    }

    public long fH() {
        if (this.or == null) {
            return -1L;
        }
        return this.or.fy();
    }

    public int fI() {
        return this.ot;
    }

    private void L(int i) {
        try {
            if (this.lh != null && i > 0) {
                this.lh.fJ().l("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
