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
import com.baidu.tieba.StringU;
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
    private static int bJx = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJr;
    private com.baidu.adp.lib.network.a.a bJy = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        acD();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bJr = aVar;
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

    private void acD() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.bJy != null) {
            this.bJy.jl();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.bJy.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ach() {
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
            if (this.bJr.adC().adF().bMq != null && this.bJr.adC().adF().bMq.size() > 0 && !this.bJr.adC().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJr.adC().adF().mUrl);
                if (this.bJr.adC().adF().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJr.adC().adF().mUrl.endsWith("?") && !this.bJr.adC().adF().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJr.adC().adF().bMq.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJr.adC().adF().bMq.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJr.adC().adF().bMq.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJr.adC().adF().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJr.adC().adF().bMs || this.bJr.adC().adF().mIsBDImage) && !this.bJr.adC().mIsFromCDN) {
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
        if (this.bJy.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bJy.a(str, z, 5, 100, -1, -1, acN());
        com.baidu.adp.lib.network.http.e jz = this.bJy.jz();
        if (jz == null) {
            return null;
        }
        gVar = jz.js();
        if (jz != null) {
            try {
                if (jz.jt() != null && (size = jz.jt().size()) > 0) {
                    this.bJr.adE().bLW = jz.jt().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJr.adD().Dd = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJr);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -12;
                TiebaStatic.net(this.bJr);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -13;
                TiebaStatic.net(this.bJr);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJr);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bJr.adD().Dd = gVar.responseCode;
        if (this.bJr.adD().Dd != 200) {
            this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJr.adE().bLW != null && !TextUtils.isEmpty(this.bJr.adE().bLW.CK)) {
                this.bJr.adD().bLV = this.bJr.adE().bLW.CK;
            } else {
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
            }
            TiebaStatic.net(this.bJr);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJx) {
                    this.bJr.adD().Dd = -11;
                    TiebaStatic.net(this.bJr);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anm().jL(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJr.adC().adF().mUrl + "], size:" + i2);
                            this.bJr.adD().Dd = -16;
                            TiebaStatic.net(this.bJr);
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
        aVar.aSR = this.bJr.adE().bLW.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJM = this.bJr.adE().bLW.CH;
        aVar.bJL = 2;
        aa.a(aVar);
        aa.bJK.set(this.bJr.adE().bLW.CH);
        TiebaStatic.net(this.bJr);
        bArr = gVar == null ? gVar.Df : null;
        return bArr;
    }

    public void mz(String str) {
        this.bJr.adD().bLU = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJr.adD().bLU = errorData.getError_code();
                if (this.bJr.adD().bLU == -1) {
                    this.bJr.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJr.adD().bLU != 0) {
                    this.bJr.adD().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJr.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aci() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ach = ach();
        if (ach == null || this.bJr.adD().Dd != 200) {
            return null;
        }
        try {
            this.bJr.adC().adF().bMu = TextUtils.isEmpty(this.bJr.adC().adF().bMu) ? HTTP.UTF_8 : this.bJr.adC().adF().bMu;
            str = new String(ach, 0, ach.length, this.bJr.adC().adF().bMu);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            mz(str);
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
    public String acg() {
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
            if (this.bJr.adC().adF().bMq == null || i2 >= this.bJr.adC().adF().bMq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJr.adC().adF().bMq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJr.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", com.baidu.adp.lib.util.s.bC(sb.toString()));
            if (this.bJr.adC().bJu) {
                x("sig", StringU.qk(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bJy.isCanceled()) {
                return null;
            }
            if (this.bJy.a(this.bJr.adC().adF().mUrl, this.bJr.adC().adF().bMq, this.bJr.adC().adF().bMs, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jz = this.bJy.jz();
            if (jz == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g js = jz.js();
            if (jz != null && jz.jt() != null && (size = jz.jt().size()) > 0) {
                this.bJr.adE().bLW = jz.jt().get(size - 1);
            }
            this.bJr.adD().Dd = js.responseCode;
            this.bJr.adD().mHeader = js.De;
            if (this.bJr.adD().Dd != 200) {
                if (this.bJr.adE().bLW != null && !TextUtils.isEmpty(this.bJr.adE().bLW.CK)) {
                    this.bJr.adD().bLV = this.bJr.adE().bLW.CK;
                } else {
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
                }
                TiebaStatic.net(this.bJr);
                return null;
            } else if (this.bJy.isCanceled()) {
                return null;
            } else {
                str = new String(js.Df, "utf-8");
                try {
                    if (this.bJr.adC().adF().mIsBaiduServer && this.bJr.adC().adF().bMt) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSR = this.bJr.adE().bLW.CF;
                    aVar.mTime = this.bJr.adE().bLW.CI;
                    aVar.bJM = this.bJr.adE().bLW.CH;
                    aVar.bJL = 1;
                    aa.a(aVar);
                    aa.bJK.set(this.bJr.adE().bLW.CH);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJr.adD().Dd = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bJr.adD().Dd = -12;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bJr.adD().Dd = -13;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bJr.adD().Dd = -15;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJr);
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
    public String acj() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.bJy.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bJy.a(this.bJr.adC().adF().mUrl, this.bJr.adC().adF().bMs, this.bJr.adC().adF().bMq, this.bJr.adC().adF().bMr, 5, -1, acN());
            this.bJr.adD().Dd = a.responseCode;
            this.bJr.adD().mHeader = a.De;
            if (this.bJr.adD().Dd != 200) {
                com.baidu.adp.lib.network.http.e jz = this.bJy.jz();
                int i = 0;
                if (jz != null && jz.jt() != null) {
                    i = jz.jt().size();
                }
                if (i <= 0 || (dVar = jz.jt().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.CK;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.bJr.adD().bLV = str2;
                } else {
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
                }
                TiebaStatic.net(this.bJr);
                return null;
            } else if (this.bJy.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Df, HTTP.UTF_8);
                try {
                    mz(str);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bJr.adD().Dd = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bJr.adD().Dd = -12;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bJr.adD().Dd = -13;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bJr.adD().Dd = -15;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJr);
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
        com.baidu.adp.lib.network.http.e jz;
        try {
            try {
                if (this.bJy.isCanceled()) {
                    com.baidu.adp.lib.network.http.e jz2 = this.bJy.jz();
                    if (jz2 != null && jz2.jt() != null && handler != null) {
                        int i4 = jz2.js().Dd;
                        StringBuilder sb = new StringBuilder();
                        int size = jz2.jt().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = jz2.jt().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.CK);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.bJr);
                    return false;
                }
                boolean a = this.bJy.a(this.bJr.adC().adF().mUrl, (z ? new File(str) : m.lZ(str)).getAbsolutePath(), false, i2, i3, -1, -1, acN(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bJz = 0;
                    int bJA = 0;
                    int bJB = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.bJz = i6 / 50;
                        }
                        this.bJA += i5 - this.bJB;
                        this.bJB = i5;
                        if (handler != null) {
                            if (this.bJA > this.bJz || i5 == i6) {
                                this.bJA = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (jz = this.bJy.jz()) != null && jz.jt() != null && handler != null) {
                    int i5 = jz.js().Dd;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = jz.jt().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = jz.jt().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.CK);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.bJr);
                return a;
            } catch (Exception e) {
                this.bJr.adD().Dd = -10;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e jz3 = this.bJy.jz();
                if (jz3 != null && jz3.jt() != null && handler != null) {
                    int i6 = jz3.js().Dd;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = jz3.jt().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = jz3.jt().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.CK);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.bJr);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bJr.adD().Dd = -15;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e jz4 = this.bJy.jz();
                if (jz4 != null && jz4.jt() != null && handler != null) {
                    int i7 = jz4.js().Dd;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = jz4.jt().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = jz4.jt().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.CK);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.bJr);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e jz5 = this.bJy.jz();
            if (jz5 != null && jz5.jt() != null && handler != null) {
                int i8 = jz5.js().Dd;
                StringBuilder sb5 = new StringBuilder();
                int size5 = jz5.jt().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = jz5.jt().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.CK);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.bJr);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> acf() {
        return this.bJr.adC().adF().bMq;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJr.adC().adF().bMq != null) {
            this.bJr.adC().adF().bMq.clear();
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
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.bJr.adC().adF().bMr == null) {
            this.bJr.adC().adF().bMr = new HashMap<>();
        }
        this.bJr.adC().adF().bMr.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJr.adC().adF().bMq == null) {
                this.bJr.adC().adF().bMq = new ArrayList<>();
            }
            int b = b(this.bJr.adC().adF().bMq, basicNameValuePair.getName());
            int size = this.bJr.adC().adF().bMq.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJr.adC().adF().bMq.get(b).getName())) {
                    this.bJr.adC().adF().bMq.set(b, basicNameValuePair);
                } else {
                    this.bJr.adC().adF().bMq.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJr.adC().adF().bMq.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> acN() {
        if (this.bJr != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJr.adC().adF().bMv)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJr.adC().adF().bMv));
            }
            if (!com.baidu.tbadk.s.am.jK() && !TextUtils.isEmpty(this.bJr.adC().adF().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJr.adC().adF().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
