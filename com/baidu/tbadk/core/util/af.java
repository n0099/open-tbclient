package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.willdelete.BdHttpErrorException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class af implements u {
    private static int Ej = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.httpNet.e Ee;
    protected final com.baidu.adp.lib.network.willdelete.a Eq = new com.baidu.adp.lib.network.willdelete.a();
    private Context mContext;

    public af(com.baidu.tbadk.core.util.httpNet.e eVar) {
        mb();
        this.mContext = TbadkApplication.m251getInst().getApp();
        this.Ee = eVar;
        com.baidu.adp.lib.network.willdelete.e.dY().setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private int getMode(int i) {
        switch (i) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    private void mb() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.u
    public boolean lz() {
        return this.Eq.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.u
    public void dM() {
        this.Eq.cancel();
        try {
            int bJ = ak.bJ(this.Ee.na().nd().mUrl);
            if (bJ > 0) {
                ak.mr().l(bJ, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [407=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x040d -> B:87:0x040e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] lB() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.dY().setUid(TbadkApplication.getCurrentAccount());
        try {
            int bJ = ak.bJ(this.Ee.na().nd().mUrl);
            if (bJ > 0) {
                ak.mr().bt(bJ);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Ee.na().nd().Gk == null || this.Ee.na().nd().Gk.size() <= 0 || this.Ee.na().mIsFromCDN) {
                    str = this.Ee.na().nd().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Ee.na().nd().mUrl);
                    if (this.Ee.na().nd().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Ee.na().nd().mUrl.endsWith("?") && !this.Ee.na().nd().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Ee.na().nd().Gk.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Ee.na().nd().Gk.get(i).getName());
                        sb.append("=");
                        sb.append(az.aC(this.Ee.na().nd().Gk.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Ee.na().nd().Gm || this.Ee.na().nd().mIsBDImage) && !this.Ee.na().mIsFromCDN) {
                    z = false;
                }
            } finally {
                ak.bK(this.Ee.na().nd().mUrl);
            }
        } catch (BdHttpCancelException e2) {
            e = e2;
            fVar = null;
        } catch (BdHttpErrorException e3) {
            e = e3;
            fVar = null;
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            fVar = null;
        } catch (SocketException e6) {
            e = e6;
            fVar = null;
        } catch (SocketTimeoutException e7) {
            e = e7;
            fVar = null;
        }
        if (this.Eq.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.dY().a(str, z, 5, 100, -1, new ag(this), this.Eq, mn());
        if (fVar != null) {
            try {
                if (fVar.kW != null) {
                    this.Ee.nc().kW = fVar.kW;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = -14;
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = e.getHttpResponseCode();
                TiebaStatic.net(this.Ee);
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Ee);
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Ee);
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = -12;
                TiebaStatic.net(this.Ee);
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ee.nb().FY = -13;
                TiebaStatic.net(this.Ee);
                ak.bK(this.Ee.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            ak.bK(this.Ee.na().nd().mUrl);
            return null;
        }
        this.Ee.nb().FY = fVar.kU;
        if (this.Ee.nb().FY != 200) {
            this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry);
            TiebaStatic.net(this.Ee);
            ak.bK(this.Ee.na().nd().mUrl);
            return null;
        }
        if (TbadkApplication.m251getInst().isMainProcess(true) && (str2 = fVar.kV) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > Ej) {
                    this.Ee.nb().FY = -11;
                    TiebaStatic.net(this.Ee);
                    ak.bK(this.Ee.na().nd().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.si().cR(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Ee.na().nd().mUrl + "], size:" + i2);
                            this.Ee.nb().FY = -16;
                            TiebaStatic.net(this.Ee);
                            ak.bK(this.Ee.na().nd().mUrl);
                            ak.bK(this.Ee.na().nd().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ao aoVar = new ao();
        aoVar.mMode = getMode(com.baidu.adp.lib.util.j.fm());
        aoVar.mSize = this.Ee.nc().kW.kl;
        aoVar.mTime = new Date().getTime() - j;
        aoVar.EK = this.Ee.nc().kW.retry;
        aoVar.EJ = 2;
        an.a(aoVar);
        an.EI.set(this.Ee.nc().kW.retry);
        TiebaStatic.net(this.Ee);
        ak.bK(this.Ee.na().nd().mUrl);
        if (fVar != null) {
            this.Ee.na().nd().Go = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void bI(String str) {
        this.Ee.nb().FZ = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Ee.nb().FZ = errorData.getError_code();
                if (this.Ee.nb().FZ == -1) {
                    this.Ee.nb().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
                } else if (this.Ee.nb().FZ != 0) {
                    this.Ee.nb().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Ee.nb().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public String lC() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] lB = lB();
        if (lB == null || this.Ee.nb().FY != 200) {
            return null;
        }
        try {
            this.Ee.na().nd().Go = TextUtils.isEmpty(this.Ee.na().nd().Go) ? "UTF-8" : this.Ee.na().nd().Go;
            str = new String(lB, 0, lB.length, this.Ee.na().nd().Go);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            bI(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(e2.getMessage());
            return str;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [634=12] */
    @Override // com.baidu.tbadk.core.util.u
    public String lA() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int bJ = ak.bJ(this.Ee.na().nd().mUrl);
            if (bJ > 0) {
                ak.mr().bt(bJ);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Ee.na().nd().Gk == null || i2 >= this.Ee.na().nd().Gk.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Ee.na().nd().Gk.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(az.aC(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Ee.na().nd().mIsBaiduServer) {
            sb2.append("tiebaclient!!!");
            String aE = com.baidu.adp.lib.util.u.aE(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(aE);
        }
        String sb3 = sb.toString();
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.Eq.isCanceled()) {
                    ak.bK(this.Ee.na().nd().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dY().a(this.Ee.na().nd().mUrl, sb3.getBytes(), this.Ee.na().nd().Gm, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.Eq, mn());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.kW != null) {
                    this.Ee.nc().kW = a.kW;
                }
                this.Ee.nb().FY = a.kU;
                if (this.Ee.nb().FY != 200) {
                    this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry);
                    TiebaStatic.net(this.Ee);
                    ak.bK(this.Ee.na().nd().mUrl);
                    return null;
                } else if (this.Eq.isCanceled()) {
                    ak.bK(this.Ee.na().nd().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Ee.na().nd().mIsBaiduServer && this.Ee.na().nd().Gn) {
                            bI(str);
                        }
                        ao aoVar = new ao();
                        aoVar.mMode = getMode(com.baidu.adp.lib.util.j.fm());
                        aoVar.mSize = this.Ee.nc().kW.kl;
                        aoVar.mTime = this.Ee.nc().kW.kp;
                        aoVar.EK = this.Ee.nc().kW.retry;
                        aoVar.EJ = 1;
                        an.a(aoVar);
                        an.EI.set(this.Ee.nc().kW.retry);
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Ee.nb().FY = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Ee.nb().FY = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Ee.nb().FY = -15;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.Ee.nb().FY = -12;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        e3 = e12;
                        this.Ee.nb().FY = -13;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (Exception e13) {
                        e2 = e13;
                        this.Ee.nb().FY = -10;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Ee.nb().FY = -10;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    }
                }
            } finally {
                ak.bK(this.Ee.na().nd().mUrl);
            }
        } catch (BdHttpCancelException e14) {
            e6 = e14;
            str = null;
        } catch (BdHttpErrorException e15) {
            e5 = e15;
            str = null;
        } catch (SocketException e16) {
            e4 = e16;
            str = null;
        } catch (SocketTimeoutException e17) {
            e3 = e17;
            str = null;
        } catch (Exception e18) {
            e2 = e18;
            str = null;
        } catch (OutOfMemoryError e19) {
            e = e19;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [737=9] */
    @Override // com.baidu.tbadk.core.util.u
    public String lD() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.Eq.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dY().b(this.Ee.na().nd().mUrl, this.Ee.na().nd().Gm, this.Ee.na().nd().Gk, this.Ee.na().nd().Gl, 5, -1, null, this.Eq, null, mn());
                this.Ee.nb().FY = b.kU;
                new Timer().schedule(new ai(this, null), 45000L);
                if (this.Ee.nb().FY != 200) {
                    this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry);
                    TiebaStatic.net(this.Ee);
                    return null;
                } else if (this.Eq.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        bI(str);
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW != null ? this.Ee.nc().kW.retry : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Ee.nb().FY = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ee.nb().Ga = String.valueOf(String.valueOf(this.Ee.nb().FY)) + "|retryCount:" + (this.Ee.nc().kW == null ? -1 : this.Ee.nc().kW.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Ee.nb().FY = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.Ee.nb().FY = -15;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (SocketException e8) {
                        this.Ee.nb().FY = -12;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.Ee.nb().FY = -13;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Ee);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.Ee.nb().FY = -10;
                        this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Ee);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new ai(this, null), 0L);
            }
        } catch (BdHttpCancelException e11) {
            e4 = e11;
            str = null;
        } catch (BdHttpErrorException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (SocketException e15) {
            str = null;
        } catch (SocketTimeoutException e16) {
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [818=5] */
    @Override // com.baidu.tbadk.core.util.u
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.Eq.isCanceled()) {
                return com.baidu.adp.lib.network.willdelete.e.dY().a(this.Ee.na().nd().mUrl, (z ? new File(str) : s.bu(str)).getAbsolutePath(), false, i2, i3, -1, new ah(this, handler, i), this.Eq, mn());
            }
            TiebaStatic.net(this.Ee);
            return false;
        } catch (Exception e) {
            this.Ee.nb().FY = -10;
            this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Ee.nb().FY = -15;
            this.Ee.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Ee);
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public ArrayList<BasicNameValuePair> ly() {
        return this.Ee.na().nd().Gk;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void h(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Ee.na().nd().Gk != null) {
            this.Ee.na().nd().Gk.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public void k(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.u
    public void e(String str, byte[] bArr) {
        if (this.Ee.na().nd().Gl == null) {
            this.Ee.na().nd().Gl = new HashMap<>();
        }
        this.Ee.na().nd().Gl.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.u
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Ee.na().nd().Gk == null) {
                this.Ee.na().nd().Gk = new ArrayList<>();
            }
            int b = b(this.Ee.na().nd().Gk, basicNameValuePair.getName());
            int size = this.Ee.na().nd().Gk.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.Ee.na().nd().Gk.get(b).getName())) {
                    this.Ee.na().nd().Gk.set(b, basicNameValuePair);
                } else {
                    this.Ee.na().nd().Gk.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.Ee.na().nd().Gk.add(b, basicNameValuePair);
            }
        }
    }

    private int b(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    private LinkedList<BasicNameValuePair> mn() {
        if (this.Ee != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Ee.na().nd().FV)) {
                linkedList.add(new BasicNameValuePair("sid", this.Ee.na().nd().FV));
            }
            if (!TextUtils.isEmpty(this.Ee.na().nd().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Ee.na().nd().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
