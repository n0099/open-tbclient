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
    private static int Ei = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.httpNet.e Ed;
    protected final com.baidu.adp.lib.network.willdelete.a Ep = new com.baidu.adp.lib.network.willdelete.a();
    private Context mContext;

    public af(com.baidu.tbadk.core.util.httpNet.e eVar) {
        mb();
        this.mContext = TbadkApplication.m251getInst().getApp();
        this.Ed = eVar;
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
        return this.Ep.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.u
    public void dM() {
        this.Ep.cancel();
        try {
            int bJ = ak.bJ(this.Ed.na().nd().mUrl);
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
            int bJ = ak.bJ(this.Ed.na().nd().mUrl);
            if (bJ > 0) {
                ak.mr().bt(bJ);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Ed.na().nd().Gj == null || this.Ed.na().nd().Gj.size() <= 0 || this.Ed.na().mIsFromCDN) {
                    str = this.Ed.na().nd().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Ed.na().nd().mUrl);
                    if (this.Ed.na().nd().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Ed.na().nd().mUrl.endsWith("?") && !this.Ed.na().nd().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Ed.na().nd().Gj.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Ed.na().nd().Gj.get(i).getName());
                        sb.append("=");
                        sb.append(ay.aC(this.Ed.na().nd().Gj.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Ed.na().nd().Gl || this.Ed.na().nd().mIsBDImage) && !this.Ed.na().mIsFromCDN) {
                    z = false;
                }
            } finally {
                ak.bK(this.Ed.na().nd().mUrl);
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
        if (this.Ep.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.dY().a(str, z, 5, 100, -1, new ag(this), this.Ep, mn());
        if (fVar != null) {
            try {
                if (fVar.kW != null) {
                    this.Ed.nc().kW = fVar.kW;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = -14;
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = e.getHttpResponseCode();
                TiebaStatic.net(this.Ed);
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Ed);
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Ed);
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = -12;
                TiebaStatic.net(this.Ed);
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Ed.nb().FX = -13;
                TiebaStatic.net(this.Ed);
                ak.bK(this.Ed.na().nd().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            ak.bK(this.Ed.na().nd().mUrl);
            return null;
        }
        this.Ed.nb().FX = fVar.kU;
        if (this.Ed.nb().FX != 200) {
            this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry);
            TiebaStatic.net(this.Ed);
            ak.bK(this.Ed.na().nd().mUrl);
            return null;
        }
        if (TbadkApplication.m251getInst().isMainProcess(true) && (str2 = fVar.kV) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > Ei) {
                    this.Ed.nb().FX = -11;
                    TiebaStatic.net(this.Ed);
                    ak.bK(this.Ed.na().nd().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.sg().cR(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Ed.na().nd().mUrl + "], size:" + i2);
                            this.Ed.nb().FX = -16;
                            TiebaStatic.net(this.Ed);
                            ak.bK(this.Ed.na().nd().mUrl);
                            ak.bK(this.Ed.na().nd().mUrl);
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
        aoVar.mSize = this.Ed.nc().kW.kl;
        aoVar.mTime = new Date().getTime() - j;
        aoVar.EJ = this.Ed.nc().kW.retry;
        aoVar.EI = 2;
        an.a(aoVar);
        an.EH.set(this.Ed.nc().kW.retry);
        TiebaStatic.net(this.Ed);
        ak.bK(this.Ed.na().nd().mUrl);
        if (fVar != null) {
            this.Ed.na().nd().Gn = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void bI(String str) {
        this.Ed.nb().FY = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Ed.nb().FY = errorData.getError_code();
                if (this.Ed.nb().FY == -1) {
                    this.Ed.nb().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
                } else if (this.Ed.nb().FY != 0) {
                    this.Ed.nb().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Ed.nb().mErrorString = this.mContext.getString(com.baidu.tieba.y.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public String lC() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] lB = lB();
        if (lB == null || this.Ed.nb().FX != 200) {
            return null;
        }
        try {
            this.Ed.na().nd().Gn = TextUtils.isEmpty(this.Ed.na().nd().Gn) ? "UTF-8" : this.Ed.na().nd().Gn;
            str = new String(lB, 0, lB.length, this.Ed.na().nd().Gn);
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
            int bJ = ak.bJ(this.Ed.na().nd().mUrl);
            if (bJ > 0) {
                ak.mr().bt(bJ);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Ed.na().nd().Gj == null || i2 >= this.Ed.na().nd().Gj.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Ed.na().nd().Gj.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(ay.aC(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Ed.na().nd().mIsBaiduServer) {
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
                if (this.Ep.isCanceled()) {
                    ak.bK(this.Ed.na().nd().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dY().a(this.Ed.na().nd().mUrl, sb3.getBytes(), this.Ed.na().nd().Gl, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.Ep, mn());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.kW != null) {
                    this.Ed.nc().kW = a.kW;
                }
                this.Ed.nb().FX = a.kU;
                if (this.Ed.nb().FX != 200) {
                    this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry);
                    TiebaStatic.net(this.Ed);
                    ak.bK(this.Ed.na().nd().mUrl);
                    return null;
                } else if (this.Ep.isCanceled()) {
                    ak.bK(this.Ed.na().nd().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Ed.na().nd().mIsBaiduServer && this.Ed.na().nd().Gm) {
                            bI(str);
                        }
                        ao aoVar = new ao();
                        aoVar.mMode = getMode(com.baidu.adp.lib.util.j.fm());
                        aoVar.mSize = this.Ed.nc().kW.kl;
                        aoVar.mTime = this.Ed.nc().kW.kp;
                        aoVar.EJ = this.Ed.nc().kW.retry;
                        aoVar.EI = 1;
                        an.a(aoVar);
                        an.EH.set(this.Ed.nc().kW.retry);
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Ed.nb().FX = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Ed.nb().FX = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Ed.nb().FX = -15;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.Ed.nb().FX = -12;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        e3 = e12;
                        this.Ed.nb().FX = -13;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (Exception e13) {
                        e2 = e13;
                        this.Ed.nb().FX = -10;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Ed.nb().FX = -10;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    }
                }
            } finally {
                ak.bK(this.Ed.na().nd().mUrl);
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
                if (this.Ep.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dY().b(this.Ed.na().nd().mUrl, this.Ed.na().nd().Gl, this.Ed.na().nd().Gj, this.Ed.na().nd().Gk, 5, -1, null, this.Ep, null, mn());
                this.Ed.nb().FX = b.kU;
                new Timer().schedule(new ai(this, null), 45000L);
                if (this.Ed.nb().FX != 200) {
                    this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry);
                    TiebaStatic.net(this.Ed);
                    return null;
                } else if (this.Ep.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        bI(str);
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW != null ? this.Ed.nc().kW.retry : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Ed.nb().FX = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        this.Ed.nb().FZ = String.valueOf(String.valueOf(this.Ed.nb().FX)) + "|retryCount:" + (this.Ed.nc().kW == null ? -1 : this.Ed.nc().kW.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Ed.nb().FX = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.Ed.nb().FX = -15;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (SocketException e8) {
                        this.Ed.nb().FX = -12;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.Ed.nb().FX = -13;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        TiebaStatic.net(this.Ed);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.Ed.nb().FX = -10;
                        this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Ed);
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
            if (!this.Ep.isCanceled()) {
                return com.baidu.adp.lib.network.willdelete.e.dY().a(this.Ed.na().nd().mUrl, (z ? new File(str) : s.bu(str)).getAbsolutePath(), false, i2, i3, -1, new ah(this, handler, i), this.Ep, mn());
            }
            TiebaStatic.net(this.Ed);
            return false;
        } catch (Exception e) {
            this.Ed.nb().FX = -10;
            this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Ed.nb().FX = -15;
            this.Ed.nb().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.y.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Ed);
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public ArrayList<BasicNameValuePair> ly() {
        return this.Ed.na().nd().Gj;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void h(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Ed.na().nd().Gj != null) {
            this.Ed.na().nd().Gj.clear();
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
        if (this.Ed.na().nd().Gk == null) {
            this.Ed.na().nd().Gk = new HashMap<>();
        }
        this.Ed.na().nd().Gk.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.u
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Ed.na().nd().Gj == null) {
                this.Ed.na().nd().Gj = new ArrayList<>();
            }
            int b = b(this.Ed.na().nd().Gj, basicNameValuePair.getName());
            int size = this.Ed.na().nd().Gj.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.Ed.na().nd().Gj.get(b).getName())) {
                    this.Ed.na().nd().Gj.set(b, basicNameValuePair);
                } else {
                    this.Ed.na().nd().Gj.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.Ed.na().nd().Gj.add(b, basicNameValuePair);
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
        if (this.Ed != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Ed.na().nd().FU)) {
                linkedList.add(new BasicNameValuePair("sid", this.Ed.na().nd().FU));
            }
            if (!TextUtils.isEmpty(this.Ed.na().nd().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Ed.na().nd().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
