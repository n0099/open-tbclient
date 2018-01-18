package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.d;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class y implements q {
    private static int aUy = 2097152;
    private final com.baidu.tbadk.core.util.a.a aUt;
    private com.baidu.adp.lib.network.a.a aUz = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Ce();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aUt = aVar;
        com.baidu.adp.lib.network.a.a.setUserAgent("bdtb for Android " + TbConfig.getVersion());
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

    private void Ce() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mU() {
        if (this.aUz != null) {
            this.aUz.mU();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mR() {
        this.aUz.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] BI() {
        com.baidu.adp.lib.network.http.g gVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.adp.lib.network.http.g gVar2;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aUt.Db().De().aWX != null && this.aUt.Db().De().aWX.size() > 0 && !this.aUt.Db().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aUt.Db().De().mUrl);
                if (this.aUt.Db().De().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aUt.Db().De().mUrl.endsWith("?") && !this.aUt.Db().De().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aUt.Db().De().aWX.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aUt.Db().De().aWX.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aUt.Db().De().aWX.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aUt.Db().De().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aUt.Db().De().aWZ || this.aUt.Db().De().mIsBDImage) && !this.aUt.Db().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            gVar = null;
        } catch (SocketException e3) {
            e = e3;
            gVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            gVar = null;
        } catch (Exception e5) {
            e = e5;
            gVar = null;
        }
        if (this.aUz.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aUz.a(str, z, 5, 100, -1, -1, Co());
        com.baidu.adp.lib.network.http.e ni = this.aUz.ni();
        if (ni == null) {
            return null;
        }
        gVar = ni.nb();
        if (ni != null) {
            try {
                if (ni.nc() != null && (size = ni.nc().size()) > 0) {
                    this.aUt.Dd().aWD = ni.nc().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aUt.Dc().ajA = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD != null ? this.aUt.Dd().aWD.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUt.Dc().ajA = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUt);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD != null ? this.aUt.Dd().aWD.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUt.Dc().ajA = -12;
                TiebaStatic.net(this.aUt);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD != null ? this.aUt.Dd().aWD.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUt.Dc().ajA = -13;
                TiebaStatic.net(this.aUt);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD != null ? this.aUt.Dd().aWD.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUt.Dc().ajA = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUt);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aUt.Dc().ajA = gVar.responseCode;
        if (this.aUt.Dc().ajA != 200) {
            this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aUt.Dd().aWD != null && !TextUtils.isEmpty(this.aUt.Dd().aWD.ajj)) {
                this.aUt.Dc().aWC = this.aUt.Dd().aWD.ajj;
            } else {
                this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg);
            }
            TiebaStatic.net(this.aUt);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aUy) {
                    this.aUt.Dc().ajA = -11;
                    TiebaStatic.net(this.aUt);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.LP().ia(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aUt.Db().De().mUrl + "], size:" + i2);
                            this.aUt.Dc().ajA = -16;
                            TiebaStatic.net(this.aUt);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.oO());
        aVar.aUN = this.aUt.Dd().aWD.aje;
        aVar.mTime = new Date().getTime() - j;
        aVar.aUO = this.aUt.Dd().aWD.ajg;
        aVar.aUM = 2;
        aa.a(aVar);
        aa.aUL.set(this.aUt.Dd().aWD.ajg);
        TiebaStatic.net(this.aUt);
        bArr = gVar == null ? gVar.ajC : null;
        return bArr;
    }

    public void dS(String str) {
        this.aUt.Dc().aWB = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aUt.Dc().aWB = errorData.getError_code();
                if (this.aUt.Dc().aWB == -1) {
                    this.aUt.Dc().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aUt.Dc().aWB != 0) {
                    this.aUt.Dc().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aUt.Dc().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BJ() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BI = BI();
        if (BI == null || this.aUt.Dc().ajA != 200) {
            return null;
        }
        try {
            this.aUt.Db().De().aXb = TextUtils.isEmpty(this.aUt.Db().De().aXb) ? HTTP.UTF_8 : this.aUt.Db().De().aXb;
            str = new String(BI, 0, BI.length, this.aUt.Db().De().aXb);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dS(str);
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

    @Override // com.baidu.tbadk.core.util.q
    public String BH() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.aUt.Db().De().aWX == null || i2 >= this.aUt.Db().De().aWX.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aUt.Db().De().aWX.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aUt.Db().De().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aUz.isCanceled()) {
                return null;
            }
            if (this.aUz.a(this.aUt.Db().De().mUrl, this.aUt.Db().De().aWX, this.aUt.Db().De().aWZ, 5, -1, Co()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e ni = this.aUz.ni();
            if (ni == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g nb = ni.nb();
            if (ni != null && ni.nc() != null && (size = ni.nc().size()) > 0) {
                this.aUt.Dd().aWD = ni.nc().get(size - 1);
            }
            this.aUt.Dc().ajA = nb.responseCode;
            this.aUt.Dc().mHeader = nb.ajB;
            if (this.aUt.Dc().ajA != 200) {
                if (this.aUt.Dd().aWD != null && !TextUtils.isEmpty(this.aUt.Dd().aWD.ajj)) {
                    this.aUt.Dc().aWC = this.aUt.Dd().aWD.ajj;
                } else {
                    this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg);
                }
                TiebaStatic.net(this.aUt);
                return null;
            } else if (this.aUz.isCanceled()) {
                return null;
            } else {
                str = new String(nb.ajC, "utf-8");
                try {
                    if (this.aUt.Db().De().mIsBaiduServer && this.aUt.Db().De().aXa) {
                        dS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oO());
                    aVar.aUN = this.aUt.Dd().aWD.aje;
                    aVar.mTime = this.aUt.Dd().aWD.ajh;
                    aVar.aUO = this.aUt.Dd().aWD.ajg;
                    aVar.aUM = 1;
                    aa.a(aVar);
                    aa.aUL.set(this.aUt.Dd().aWD.ajg);
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aUt.Dc().ajA = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aUt.Dc().ajA = -15;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aUt.Dc().ajA = -12;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aUt.Dc().ajA = -13;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aUt.Dc().ajA = -10;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aUt.Dc().ajA = -10;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BK() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.aUz.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aUz.a(this.aUt.Db().De().mUrl, this.aUt.Db().De().aWZ, this.aUt.Db().De().aWX, this.aUt.Db().De().aWY, 5, -1, Co());
            this.aUt.Dc().ajA = a.responseCode;
            this.aUt.Dc().mHeader = a.ajB;
            if (this.aUt.Dc().ajA != 200) {
                com.baidu.adp.lib.network.http.e ni = this.aUz.ni();
                int i = 0;
                if (ni != null && ni.nc() != null) {
                    i = ni.nc().size();
                }
                if (i <= 0 || (dVar = ni.nc().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.ajj;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aUt.Dc().aWC = str2;
                } else {
                    this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg);
                }
                TiebaStatic.net(this.aUt);
                return null;
            } else if (this.aUz.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.ajC, HTTP.UTF_8);
                try {
                    dS(str);
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUt.Dc().aWC = String.valueOf(this.aUt.Dc().ajA) + "|retryCount:" + (this.aUt.Dd().aWD == null ? -1 : this.aUt.Dd().aWD.ajg) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aUt.Dc().ajA = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aUt.Dc().ajA = -12;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aUt.Dc().ajA = -13;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aUt.Dc().ajA = -10;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aUt.Dc().ajA = -15;
                    this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUt);
                    return str;
                }
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e2 = e10;
            str = null;
        } catch (SocketException e11) {
            str = null;
        } catch (SocketTimeoutException e12) {
            str = null;
        } catch (Exception e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [697=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.aUz.isCanceled()) {
                return false;
            }
            return this.aUz.a(this.aUt.Db().De().mUrl, (z ? new File(str) : k.dw(str)).getAbsolutePath(), false, i2, i3, -1, -1, Co(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int aUA = 0;
                int aUB = 0;
                int aUC = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aUA = i5 / 50;
                    }
                    this.aUB += i4 - this.aUC;
                    this.aUC = i4;
                    if (handler != null) {
                        if (this.aUB > this.aUA || i4 == i5) {
                            this.aUB = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aUt.Dc().ajA = -10;
            this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aUt.Dc().ajA = -15;
            this.aUt.Dc().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aUt);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> BG() {
        return this.aUt.Db().De().aWX;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aUt.Db().De().aWX != null) {
            this.aUt.Db().De().aWX.clear();
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

    @Override // com.baidu.tbadk.core.util.q
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.aUt.Db().De().aWY == null) {
            this.aUt.Db().De().aWY = new HashMap<>();
        }
        this.aUt.Db().De().aWY.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aUt.Db().De().aWX == null) {
                this.aUt.Db().De().aWX = new ArrayList<>();
            }
            int c = c(this.aUt.Db().De().aWX, basicNameValuePair.getName());
            int size = this.aUt.Db().De().aWX.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aUt.Db().De().aWX.get(c).getName())) {
                    this.aUt.Db().De().aWX.set(c, basicNameValuePair);
                } else {
                    this.aUt.Db().De().aWX.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aUt.Db().De().aWX.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    private LinkedList<BasicNameValuePair> Co() {
        if (this.aUt != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aUt.Db().De().aXc)) {
                linkedList.add(new BasicNameValuePair("sid", this.aUt.Db().De().aXc));
            }
            if (!TextUtils.isEmpty(this.aUt.Db().De().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aUt.Db().De().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
