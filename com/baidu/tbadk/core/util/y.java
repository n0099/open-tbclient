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
    private static int aUB = 2097152;
    private com.baidu.adp.lib.network.a.a aUC = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a aUw;
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Cf();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aUw = aVar;
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

    private void Cf() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mV() {
        if (this.aUC != null) {
            this.aUC.mV();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mS() {
        this.aUC.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] BJ() {
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
            if (this.aUw.Dc().Df().aXa != null && this.aUw.Dc().Df().aXa.size() > 0 && !this.aUw.Dc().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aUw.Dc().Df().mUrl);
                if (this.aUw.Dc().Df().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aUw.Dc().Df().mUrl.endsWith("?") && !this.aUw.Dc().Df().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aUw.Dc().Df().aXa.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aUw.Dc().Df().aXa.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aUw.Dc().Df().aXa.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aUw.Dc().Df().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aUw.Dc().Df().aXc || this.aUw.Dc().Df().mIsBDImage) && !this.aUw.Dc().mIsFromCDN) {
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
        if (this.aUC.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aUC.a(str, z, 5, 100, -1, -1, Cp());
        com.baidu.adp.lib.network.http.e nj = this.aUC.nj();
        if (nj == null) {
            return null;
        }
        gVar = nj.nc();
        if (nj != null) {
            try {
                if (nj.nd() != null && (size = nj.nd().size()) > 0) {
                    this.aUw.De().aWG = nj.nd().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aUw.Dd().ajD = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG != null ? this.aUw.De().aWG.ajj : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUw.Dd().ajD = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUw);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG != null ? this.aUw.De().aWG.ajj : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUw.Dd().ajD = -12;
                TiebaStatic.net(this.aUw);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG != null ? this.aUw.De().aWG.ajj : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUw.Dd().ajD = -13;
                TiebaStatic.net(this.aUw);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG != null ? this.aUw.De().aWG.ajj : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aUw.Dd().ajD = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aUw);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aUw.Dd().ajD = gVar.responseCode;
        if (this.aUw.Dd().ajD != 200) {
            this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aUw.De().aWG != null && !TextUtils.isEmpty(this.aUw.De().aWG.ajm)) {
                this.aUw.Dd().aWF = this.aUw.De().aWG.ajm;
            } else {
                this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj);
            }
            TiebaStatic.net(this.aUw);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aUB) {
                    this.aUw.Dd().ajD = -11;
                    TiebaStatic.net(this.aUw);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.LR().ia(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aUw.Dc().Df().mUrl + "], size:" + i2);
                            this.aUw.Dd().ajD = -16;
                            TiebaStatic.net(this.aUw);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
        aVar.aUQ = this.aUw.De().aWG.ajh;
        aVar.mTime = new Date().getTime() - j;
        aVar.aUR = this.aUw.De().aWG.ajj;
        aVar.aUP = 2;
        aa.a(aVar);
        aa.aUO.set(this.aUw.De().aWG.ajj);
        TiebaStatic.net(this.aUw);
        bArr = gVar == null ? gVar.ajF : null;
        return bArr;
    }

    public void dX(String str) {
        this.aUw.Dd().aWE = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aUw.Dd().aWE = errorData.getError_code();
                if (this.aUw.Dd().aWE == -1) {
                    this.aUw.Dd().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aUw.Dd().aWE != 0) {
                    this.aUw.Dd().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aUw.Dd().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BK() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BJ = BJ();
        if (BJ == null || this.aUw.Dd().ajD != 200) {
            return null;
        }
        try {
            this.aUw.Dc().Df().aXe = TextUtils.isEmpty(this.aUw.Dc().Df().aXe) ? HTTP.UTF_8 : this.aUw.Dc().Df().aXe;
            str = new String(BJ, 0, BJ.length, this.aUw.Dc().Df().aXe);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dX(str);
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
    public String BI() {
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
            if (this.aUw.Dc().Df().aXa == null || i2 >= this.aUw.Dc().Df().aXa.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aUw.Dc().Df().aXa.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aUw.Dc().Df().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aUC.isCanceled()) {
                return null;
            }
            if (this.aUC.a(this.aUw.Dc().Df().mUrl, this.aUw.Dc().Df().aXa, this.aUw.Dc().Df().aXc, 5, -1, Cp()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e nj = this.aUC.nj();
            if (nj == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g nc = nj.nc();
            if (nj != null && nj.nd() != null && (size = nj.nd().size()) > 0) {
                this.aUw.De().aWG = nj.nd().get(size - 1);
            }
            this.aUw.Dd().ajD = nc.responseCode;
            this.aUw.Dd().mHeader = nc.ajE;
            if (this.aUw.Dd().ajD != 200) {
                if (this.aUw.De().aWG != null && !TextUtils.isEmpty(this.aUw.De().aWG.ajm)) {
                    this.aUw.Dd().aWF = this.aUw.De().aWG.ajm;
                } else {
                    this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj);
                }
                TiebaStatic.net(this.aUw);
                return null;
            } else if (this.aUC.isCanceled()) {
                return null;
            } else {
                str = new String(nc.ajF, "utf-8");
                try {
                    if (this.aUw.Dc().Df().mIsBaiduServer && this.aUw.Dc().Df().aXd) {
                        dX(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aUQ = this.aUw.De().aWG.ajh;
                    aVar.mTime = this.aUw.De().aWG.ajk;
                    aVar.aUR = this.aUw.De().aWG.ajj;
                    aVar.aUP = 1;
                    aa.a(aVar);
                    aa.aUO.set(this.aUw.De().aWG.ajj);
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aUw.Dd().ajD = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aUw.Dd().ajD = -15;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aUw.Dd().ajD = -12;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aUw.Dd().ajD = -13;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aUw.Dd().ajD = -10;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aUw.Dd().ajD = -10;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aUw);
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
    public String BL() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.aUC.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aUC.a(this.aUw.Dc().Df().mUrl, this.aUw.Dc().Df().aXc, this.aUw.Dc().Df().aXa, this.aUw.Dc().Df().aXb, 5, -1, Cp());
            this.aUw.Dd().ajD = a.responseCode;
            this.aUw.Dd().mHeader = a.ajE;
            if (this.aUw.Dd().ajD != 200) {
                com.baidu.adp.lib.network.http.e nj = this.aUC.nj();
                int i = 0;
                if (nj != null && nj.nd() != null) {
                    i = nj.nd().size();
                }
                if (i <= 0 || (dVar = nj.nd().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.ajm;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aUw.Dd().aWF = str2;
                } else {
                    this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj);
                }
                TiebaStatic.net(this.aUw);
                return null;
            } else if (this.aUC.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.ajF, HTTP.UTF_8);
                try {
                    dX(str);
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aUw.Dd().aWF = String.valueOf(this.aUw.Dd().ajD) + "|retryCount:" + (this.aUw.De().aWG == null ? -1 : this.aUw.De().aWG.ajj) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aUw.Dd().ajD = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aUw.Dd().ajD = -12;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aUw.Dd().ajD = -13;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aUw.Dd().ajD = -10;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aUw);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aUw.Dd().ajD = -15;
                    this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aUw);
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
            if (this.aUC.isCanceled()) {
                return false;
            }
            return this.aUC.a(this.aUw.Dc().Df().mUrl, (z ? new File(str) : k.dy(str)).getAbsolutePath(), false, i2, i3, -1, -1, Cp(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int aUD = 0;
                int aUE = 0;
                int aUF = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aUD = i5 / 50;
                    }
                    this.aUE += i4 - this.aUF;
                    this.aUF = i4;
                    if (handler != null) {
                        if (this.aUE > this.aUD || i4 == i5) {
                            this.aUE = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aUw.Dd().ajD = -10;
            this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aUw.Dd().ajD = -15;
            this.aUw.Dd().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aUw);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> BH() {
        return this.aUw.Dc().Df().aXa;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aUw.Dc().Df().aXa != null) {
            this.aUw.Dc().Df().aXa.clear();
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
        if (this.aUw.Dc().Df().aXb == null) {
            this.aUw.Dc().Df().aXb = new HashMap<>();
        }
        this.aUw.Dc().Df().aXb.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aUw.Dc().Df().aXa == null) {
                this.aUw.Dc().Df().aXa = new ArrayList<>();
            }
            int c = c(this.aUw.Dc().Df().aXa, basicNameValuePair.getName());
            int size = this.aUw.Dc().Df().aXa.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aUw.Dc().Df().aXa.get(c).getName())) {
                    this.aUw.Dc().Df().aXa.set(c, basicNameValuePair);
                } else {
                    this.aUw.Dc().Df().aXa.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aUw.Dc().Df().aXa.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> Cp() {
        if (this.aUw != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aUw.Dc().Df().aXf)) {
                linkedList.add(new BasicNameValuePair("sid", this.aUw.Dc().Df().aXf));
            }
            if (!TextUtils.isEmpty(this.aUw.Dc().Df().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aUw.Dc().Df().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
