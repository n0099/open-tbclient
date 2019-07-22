package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
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
    private static int bSj = 2097152;
    private final com.baidu.tbadk.core.util.a.a bSd;
    private com.baidu.adp.lib.network.a.a bSk = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        aiD();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bSd = aVar;
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

    private void aiD() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void in() {
        if (this.bSk != null) {
            this.bSk.in();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ik() {
        this.bSk.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] aih() {
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
            if (this.bSd.ajE().ajH().bVe != null && this.bSd.ajE().ajH().bVe.size() > 0 && !this.bSd.ajE().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bSd.ajE().ajH().mUrl);
                if (this.bSd.ajE().ajH().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bSd.ajE().ajH().mUrl.endsWith("?") && !this.bSd.ajE().ajH().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bSd.ajE().ajH().bVe.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bSd.ajE().ajH().bVe.get(i).getName());
                    sb.append("=");
                    sb.append(aq.bi(this.bSd.ajE().ajH().bVe.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bSd.ajE().ajH().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bSd.ajE().ajH().bVg || this.bSd.ajE().ajH().mIsBDImage) && !this.bSd.ajE().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (Exception e2) {
            e = e2;
            gVar = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            gVar = null;
        } catch (SocketException e4) {
            e = e4;
            gVar = null;
        } catch (SocketTimeoutException e5) {
            e = e5;
            gVar = null;
        }
        if (this.bSk.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bSk.a(str, z, 5, 100, -1, -1, aiN());
        com.baidu.adp.lib.network.http.e iC = this.bSk.iC();
        if (iC == null) {
            return null;
        }
        gVar = iC.iv();
        if (iC != null) {
            try {
                if (iC.iw() != null && (size = iC.iw().size()) > 0) {
                    this.bSd.ajG().bUK = iC.iw().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bSd.ajF().AR = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -12;
                TiebaStatic.net(this.bSd);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -13;
                TiebaStatic.net(this.bSd);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSd);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSd);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bSd.ajF().AR = gVar.responseCode;
        if (this.bSd.ajF().AR != 200) {
            this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bSd.ajG().bUK != null && !TextUtils.isEmpty(this.bSd.ajG().bUK.Az)) {
                this.bSd.ajF().bUJ = this.bSd.ajG().bUK.Az;
            } else {
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
            }
            TiebaStatic.net(this.bSd);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bSj) {
                    this.bSd.ajF().AR = -11;
                    TiebaStatic.net(this.bSd);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.atw().kF(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bSd.ajE().ajH().mUrl + "], size:" + i2);
                            this.bSd.ajF().AR = -16;
                            TiebaStatic.net(this.bSd);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.aWr = this.bSd.ajG().bUK.Au;
        aVar.mTime = new Date().getTime() - j;
        aVar.bSy = this.bSd.ajG().bUK.Aw;
        aVar.bSx = 2;
        aa.a(aVar);
        aa.bSw.set(this.bSd.ajG().bUK.Aw);
        TiebaStatic.net(this.bSd);
        bArr = gVar == null ? gVar.AU : null;
        return bArr;
    }

    public void nS(String str) {
        this.bSd.ajF().bUI = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bSd.ajF().bUI = errorData.getError_code();
                if (this.bSd.ajF().bUI == -1) {
                    this.bSd.ajF().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bSd.ajF().bUI != 0) {
                    this.bSd.ajF().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bSd.ajF().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aii() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] aih = aih();
        if (aih == null || this.bSd.ajF().AR != 200) {
            return null;
        }
        try {
            this.bSd.ajE().ajH().bVi = TextUtils.isEmpty(this.bSd.ajE().ajH().bVi) ? HTTP.UTF_8 : this.bSd.ajE().ajH().bVi;
            str = new String(aih, 0, aih.length, this.bSd.ajE().ajH().bVi);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nS(str);
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
    public String aig() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.bSd.ajE().ajH().bVe == null || i2 >= this.bSd.ajE().ajH().bVe.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSd.ajE().ajH().bVe.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSd.ajE().ajH().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bn(sb.toString()));
            if (this.bSd.ajE().bSg) {
                o("sig", StringU.rK(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bSk.isCanceled()) {
                return null;
            }
            if (this.bSk.a(this.bSd.ajE().ajH().mUrl, this.bSd.ajE().ajH().bVe, this.bSd.ajE().ajH().bVg, 5, -1, aiN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e iC = this.bSk.iC();
            if (iC == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g iv = iC.iv();
            if (iC != null && iC.iw() != null && (size = iC.iw().size()) > 0) {
                this.bSd.ajG().bUK = iC.iw().get(size - 1);
            }
            this.bSd.ajF().AR = iv.responseCode;
            this.bSd.ajF().mHeader = iv.AT;
            if (this.bSd.ajF().AR != 200) {
                if (this.bSd.ajG().bUK != null && !TextUtils.isEmpty(this.bSd.ajG().bUK.Az)) {
                    this.bSd.ajF().bUJ = this.bSd.ajG().bUK.Az;
                } else {
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
                }
                TiebaStatic.net(this.bSd);
                return null;
            } else if (this.bSk.isCanceled()) {
                return null;
            } else {
                str = new String(iv.AU, "utf-8");
                try {
                    if (this.bSd.ajE().ajH().mIsBaiduServer && this.bSd.ajE().ajH().bVh) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSd.ajG().bUK.Au;
                    aVar.mTime = this.bSd.ajG().bUK.Ax;
                    aVar.bSy = this.bSd.ajG().bUK.Aw;
                    aVar.bSx = 1;
                    aa.a(aVar);
                    aa.bSw.set(this.bSd.ajG().bUK.Aw);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSd.ajF().AR = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.bSd.ajF().AR = -15;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.bSd.ajF().AR = -12;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.bSd.ajF().AR = -13;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (SocketException e11) {
            e4 = e11;
            str = null;
        } catch (SocketTimeoutException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aij() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.bSk.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bSk.a(this.bSd.ajE().ajH().mUrl, this.bSd.ajE().ajH().bVg, this.bSd.ajE().ajH().bVe, this.bSd.ajE().ajH().bVf, 5, -1, aiN());
            this.bSd.ajF().AR = a.responseCode;
            this.bSd.ajF().mHeader = a.AT;
            if (this.bSd.ajF().AR != 200) {
                com.baidu.adp.lib.network.http.e iC = this.bSk.iC();
                int i = 0;
                if (iC != null && iC.iw() != null) {
                    i = iC.iw().size();
                }
                if (i <= 0 || (dVar = iC.iw().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.Az;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.bSd.ajF().bUJ = str2;
                } else {
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
                }
                TiebaStatic.net(this.bSd);
                return null;
            } else if (this.bSk.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.AU, HTTP.UTF_8);
                try {
                    nS(str);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bSd.ajF().AR = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bSd.ajF().AR = -12;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bSd.ajF().AR = -13;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bSd.ajF().AR = -15;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSd);
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, IF, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [704=5, 705=5, 706=5, 707=5, 708=5, 709=5, 710=5, 711=5, 712=5, 713=5, 714=5, 715=5, 716=5, 718=5, 721=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        com.baidu.adp.lib.network.http.e iC;
        try {
            try {
                if (this.bSk.isCanceled()) {
                    com.baidu.adp.lib.network.http.e iC2 = this.bSk.iC();
                    if (iC2 != null && iC2.iw() != null && handler != null) {
                        int i4 = iC2.iv().AR;
                        StringBuilder sb = new StringBuilder();
                        int size = iC2.iw().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = iC2.iw().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.Az);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.bSd);
                    return false;
                }
                boolean a = this.bSk.a(this.bSd.ajE().ajH().mUrl, (z ? new File(str) : m.ns(str)).getAbsolutePath(), false, i2, i3, -1, -1, aiN(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bSl = 0;
                    int bSm = 0;
                    int bSn = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.bSl = i6 / 50;
                        }
                        this.bSm += i5 - this.bSn;
                        this.bSn = i5;
                        if (handler != null) {
                            if (this.bSm > this.bSl || i5 == i6) {
                                this.bSm = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (iC = this.bSk.iC()) != null && iC.iw() != null && handler != null) {
                    int i5 = iC.iv().AR;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = iC.iw().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = iC.iw().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.Az);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.bSd);
                return a;
            } catch (Exception e) {
                this.bSd.ajF().AR = -10;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e iC3 = this.bSk.iC();
                if (iC3 != null && iC3.iw() != null && handler != null) {
                    int i6 = iC3.iv().AR;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = iC3.iw().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = iC3.iw().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.Az);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.bSd);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bSd.ajF().AR = -15;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e iC4 = this.bSk.iC();
                if (iC4 != null && iC4.iw() != null && handler != null) {
                    int i7 = iC4.iv().AR;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = iC4.iw().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = iC4.iw().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.Az);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.bSd);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e iC5 = this.bSk.iC();
            if (iC5 != null && iC5.iw() != null && handler != null) {
                int i8 = iC5.iv().AR;
                StringBuilder sb5 = new StringBuilder();
                int size5 = iC5.iw().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = iC5.iw().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.Az);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.bSd);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> aif() {
        return this.bSd.ajE().ajH().bVe;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bSd.ajE().ajH().bVe != null) {
            this.bSd.ajE().ajH().bVe.clear();
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
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.bSd.ajE().ajH().bVf == null) {
            this.bSd.ajE().ajH().bVf = new HashMap<>();
        }
        this.bSd.ajE().ajH().bVf.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bSd.ajE().ajH().bVe == null) {
                this.bSd.ajE().ajH().bVe = new ArrayList<>();
            }
            int b = b(this.bSd.ajE().ajH().bVe, basicNameValuePair.getName());
            int size = this.bSd.ajE().ajH().bVe.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bSd.ajE().ajH().bVe.get(b).getName())) {
                    this.bSd.ajE().ajH().bVe.set(b, basicNameValuePair);
                } else {
                    this.bSd.ajE().ajH().bVe.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bSd.ajE().ajH().bVe.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aiN() {
        if (this.bSd != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bSd.ajE().ajH().bVj)) {
                linkedList.add(new BasicNameValuePair("sid", this.bSd.ajE().ajH().bVj));
            }
            if (!com.baidu.tbadk.t.aq.iN() && !TextUtils.isEmpty(this.bSd.ajE().ajH().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bSd.ajE().ajH().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
