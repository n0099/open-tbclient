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
    private static int aUz = 2097152;
    private com.baidu.adp.lib.network.a.a aUA = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a aUu;
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Cm();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aUu = aVar;
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

    private void Cm() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mU() {
        if (this.aUA != null) {
            this.aUA.mU();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mR() {
        this.aUA.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] BQ() {
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
            if (this.aUu.Dk().Dn().aWY != null && this.aUu.Dk().Dn().aWY.size() > 0 && !this.aUu.Dk().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aUu.Dk().Dn().mUrl);
                if (this.aUu.Dk().Dn().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aUu.Dk().Dn().mUrl.endsWith("?") && !this.aUu.Dk().Dn().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aUu.Dk().Dn().aWY.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aUu.Dk().Dn().aWY.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aUu.Dk().Dn().aWY.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aUu.Dk().Dn().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aUu.Dk().Dn().aXa || this.aUu.Dk().Dn().mIsBDImage) && !this.aUu.Dk().mIsFromCDN) {
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
        if (this.aUA.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aUA.a(str, z, 5, 100, -1, -1, Cw());
        com.baidu.adp.lib.network.http.e ni = this.aUA.ni();
        if (ni == null) {
            return null;
        }
        gVar = ni.nb();
        if (ni != null) {
            try {
                if (ni.nc() != null && (size = ni.nc().size()) > 0) {
                    this.aUu.Dm().aWE = ni.nc().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aUu.Dl().ajA = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE != null ? this.aUu.Dm().aWE.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUu.Dl().ajA = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUu);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE != null ? this.aUu.Dm().aWE.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUu.Dl().ajA = -12;
                TiebaStatic.net(this.aUu);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE != null ? this.aUu.Dm().aWE.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUu.Dl().ajA = -13;
                TiebaStatic.net(this.aUu);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE != null ? this.aUu.Dm().aWE.ajg : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUu.Dl().ajA = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUu);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aUu.Dl().ajA = gVar.responseCode;
        if (this.aUu.Dl().ajA != 200) {
            this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aUu.Dm().aWE != null && !TextUtils.isEmpty(this.aUu.Dm().aWE.ajj)) {
                this.aUu.Dl().aWD = this.aUu.Dm().aWE.ajj;
            } else {
                this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg);
            }
            TiebaStatic.net(this.aUu);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aUz) {
                    this.aUu.Dl().ajA = -11;
                    TiebaStatic.net(this.aUu);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mb().ie(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aUu.Dk().Dn().mUrl + "], size:" + i2);
                            this.aUu.Dl().ajA = -16;
                            TiebaStatic.net(this.aUu);
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
        aVar.aUO = this.aUu.Dm().aWE.aje;
        aVar.mTime = new Date().getTime() - j;
        aVar.aUP = this.aUu.Dm().aWE.ajg;
        aVar.aUN = 2;
        aa.a(aVar);
        aa.aUM.set(this.aUu.Dm().aWE.ajg);
        TiebaStatic.net(this.aUu);
        bArr = gVar == null ? gVar.ajC : null;
        return bArr;
    }

    public void dS(String str) {
        this.aUu.Dl().aWC = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aUu.Dl().aWC = errorData.getError_code();
                if (this.aUu.Dl().aWC == -1) {
                    this.aUu.Dl().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aUu.Dl().aWC != 0) {
                    this.aUu.Dl().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aUu.Dl().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BR() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BQ = BQ();
        if (BQ == null || this.aUu.Dl().ajA != 200) {
            return null;
        }
        try {
            this.aUu.Dk().Dn().aXc = TextUtils.isEmpty(this.aUu.Dk().Dn().aXc) ? HTTP.UTF_8 : this.aUu.Dk().Dn().aXc;
            str = new String(BQ, 0, BQ.length, this.aUu.Dk().Dn().aXc);
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
    public String BP() {
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
            if (this.aUu.Dk().Dn().aWY == null || i2 >= this.aUu.Dk().Dn().aWY.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aUu.Dk().Dn().aWY.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aUu.Dk().Dn().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aUA.isCanceled()) {
                return null;
            }
            if (this.aUA.a(this.aUu.Dk().Dn().mUrl, this.aUu.Dk().Dn().aWY, this.aUu.Dk().Dn().aXa, 5, -1, Cw()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e ni = this.aUA.ni();
            if (ni == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g nb = ni.nb();
            if (ni != null && ni.nc() != null && (size = ni.nc().size()) > 0) {
                this.aUu.Dm().aWE = ni.nc().get(size - 1);
            }
            this.aUu.Dl().ajA = nb.responseCode;
            this.aUu.Dl().mHeader = nb.ajB;
            if (this.aUu.Dl().ajA != 200) {
                if (this.aUu.Dm().aWE != null && !TextUtils.isEmpty(this.aUu.Dm().aWE.ajj)) {
                    this.aUu.Dl().aWD = this.aUu.Dm().aWE.ajj;
                } else {
                    this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg);
                }
                TiebaStatic.net(this.aUu);
                return null;
            } else if (this.aUA.isCanceled()) {
                return null;
            } else {
                str = new String(nb.ajC, "utf-8");
                try {
                    if (this.aUu.Dk().Dn().mIsBaiduServer && this.aUu.Dk().Dn().aXb) {
                        dS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oO());
                    aVar.aUO = this.aUu.Dm().aWE.aje;
                    aVar.mTime = this.aUu.Dm().aWE.ajh;
                    aVar.aUP = this.aUu.Dm().aWE.ajg;
                    aVar.aUN = 1;
                    aa.a(aVar);
                    aa.aUM.set(this.aUu.Dm().aWE.ajg);
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aUu.Dl().ajA = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aUu.Dl().ajA = -15;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aUu.Dl().ajA = -12;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aUu.Dl().ajA = -13;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aUu.Dl().ajA = -10;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aUu.Dl().ajA = -10;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aUu);
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
    public String BS() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.aUA.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aUA.a(this.aUu.Dk().Dn().mUrl, this.aUu.Dk().Dn().aXa, this.aUu.Dk().Dn().aWY, this.aUu.Dk().Dn().aWZ, 5, -1, Cw());
            this.aUu.Dl().ajA = a.responseCode;
            this.aUu.Dl().mHeader = a.ajB;
            if (this.aUu.Dl().ajA != 200) {
                com.baidu.adp.lib.network.http.e ni = this.aUA.ni();
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
                    this.aUu.Dl().aWD = str2;
                } else {
                    this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg);
                }
                TiebaStatic.net(this.aUu);
                return null;
            } else if (this.aUA.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.ajC, HTTP.UTF_8);
                try {
                    dS(str);
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUu.Dl().aWD = String.valueOf(this.aUu.Dl().ajA) + "|retryCount:" + (this.aUu.Dm().aWE == null ? -1 : this.aUu.Dm().aWE.ajg) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aUu.Dl().ajA = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aUu.Dl().ajA = -12;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aUu.Dl().ajA = -13;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aUu.Dl().ajA = -10;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUu);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aUu.Dl().ajA = -15;
                    this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUu);
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
            if (this.aUA.isCanceled()) {
                return false;
            }
            return this.aUA.a(this.aUu.Dk().Dn().mUrl, (z ? new File(str) : k.dw(str)).getAbsolutePath(), false, i2, i3, -1, -1, Cw(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int aUB = 0;
                int aUC = 0;
                int aUD = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aUB = i5 / 50;
                    }
                    this.aUC += i4 - this.aUD;
                    this.aUD = i4;
                    if (handler != null) {
                        if (this.aUC > this.aUB || i4 == i5) {
                            this.aUC = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aUu.Dl().ajA = -10;
            this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aUu.Dl().ajA = -15;
            this.aUu.Dl().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aUu);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> BO() {
        return this.aUu.Dk().Dn().aWY;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aUu.Dk().Dn().aWY != null) {
            this.aUu.Dk().Dn().aWY.clear();
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
        if (this.aUu.Dk().Dn().aWZ == null) {
            this.aUu.Dk().Dn().aWZ = new HashMap<>();
        }
        this.aUu.Dk().Dn().aWZ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aUu.Dk().Dn().aWY == null) {
                this.aUu.Dk().Dn().aWY = new ArrayList<>();
            }
            int c = c(this.aUu.Dk().Dn().aWY, basicNameValuePair.getName());
            int size = this.aUu.Dk().Dn().aWY.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aUu.Dk().Dn().aWY.get(c).getName())) {
                    this.aUu.Dk().Dn().aWY.set(c, basicNameValuePair);
                } else {
                    this.aUu.Dk().Dn().aWY.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aUu.Dk().Dn().aWY.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> Cw() {
        if (this.aUu != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aUu.Dk().Dn().aXd)) {
                linkedList.add(new BasicNameValuePair("sid", this.aUu.Dk().Dn().aXd));
            }
            if (!TextUtils.isEmpty(this.aUu.Dk().Dn().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aUu.Dk().Dn().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
