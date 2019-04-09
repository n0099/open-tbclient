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
    private static int bJy = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJs;
    private com.baidu.adp.lib.network.a.a bJz = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        acD();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bJs = aVar;
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
        if (this.bJz != null) {
            this.bJz.jl();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.bJz.cancel();
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
            if (this.bJs.adC().adF().bMr != null && this.bJs.adC().adF().bMr.size() > 0 && !this.bJs.adC().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJs.adC().adF().mUrl);
                if (this.bJs.adC().adF().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJs.adC().adF().mUrl.endsWith("?") && !this.bJs.adC().adF().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJs.adC().adF().bMr.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJs.adC().adF().bMr.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJs.adC().adF().bMr.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJs.adC().adF().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJs.adC().adF().bMt || this.bJs.adC().adF().mIsBDImage) && !this.bJs.adC().mIsFromCDN) {
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
        if (this.bJz.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bJz.a(str, z, 5, 100, -1, -1, acN());
        com.baidu.adp.lib.network.http.e jz = this.bJz.jz();
        if (jz == null) {
            return null;
        }
        gVar = jz.js();
        if (jz != null) {
            try {
                if (jz.jt() != null && (size = jz.jt().size()) > 0) {
                    this.bJs.adE().bLX = jz.jt().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJs.adD().Dd = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJs);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -12;
                TiebaStatic.net(this.bJs);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -13;
                TiebaStatic.net(this.bJs);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJs);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bJs.adD().Dd = gVar.responseCode;
        if (this.bJs.adD().Dd != 200) {
            this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJs.adE().bLX != null && !TextUtils.isEmpty(this.bJs.adE().bLX.CK)) {
                this.bJs.adD().bLW = this.bJs.adE().bLX.CK;
            } else {
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
            }
            TiebaStatic.net(this.bJs);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJy) {
                    this.bJs.adD().Dd = -11;
                    TiebaStatic.net(this.bJs);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anm().jL(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJs.adC().adF().mUrl + "], size:" + i2);
                            this.bJs.adD().Dd = -16;
                            TiebaStatic.net(this.bJs);
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
        aVar.aSS = this.bJs.adE().bLX.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJN = this.bJs.adE().bLX.CH;
        aVar.bJM = 2;
        aa.a(aVar);
        aa.bJL.set(this.bJs.adE().bLX.CH);
        TiebaStatic.net(this.bJs);
        bArr = gVar == null ? gVar.Df : null;
        return bArr;
    }

    public void mz(String str) {
        this.bJs.adD().bLV = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJs.adD().bLV = errorData.getError_code();
                if (this.bJs.adD().bLV == -1) {
                    this.bJs.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJs.adD().bLV != 0) {
                    this.bJs.adD().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJs.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aci() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ach = ach();
        if (ach == null || this.bJs.adD().Dd != 200) {
            return null;
        }
        try {
            this.bJs.adC().adF().bMv = TextUtils.isEmpty(this.bJs.adC().adF().bMv) ? HTTP.UTF_8 : this.bJs.adC().adF().bMv;
            str = new String(ach, 0, ach.length, this.bJs.adC().adF().bMv);
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
            if (this.bJs.adC().adF().bMr == null || i2 >= this.bJs.adC().adF().bMr.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJs.adC().adF().bMr.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJs.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", com.baidu.adp.lib.util.s.bC(sb.toString()));
            if (this.bJs.adC().bJv) {
                x("sig", StringU.qk(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bJz.isCanceled()) {
                return null;
            }
            if (this.bJz.a(this.bJs.adC().adF().mUrl, this.bJs.adC().adF().bMr, this.bJs.adC().adF().bMt, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jz = this.bJz.jz();
            if (jz == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g js = jz.js();
            if (jz != null && jz.jt() != null && (size = jz.jt().size()) > 0) {
                this.bJs.adE().bLX = jz.jt().get(size - 1);
            }
            this.bJs.adD().Dd = js.responseCode;
            this.bJs.adD().mHeader = js.De;
            if (this.bJs.adD().Dd != 200) {
                if (this.bJs.adE().bLX != null && !TextUtils.isEmpty(this.bJs.adE().bLX.CK)) {
                    this.bJs.adD().bLW = this.bJs.adE().bLX.CK;
                } else {
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
                }
                TiebaStatic.net(this.bJs);
                return null;
            } else if (this.bJz.isCanceled()) {
                return null;
            } else {
                str = new String(js.Df, "utf-8");
                try {
                    if (this.bJs.adC().adF().mIsBaiduServer && this.bJs.adC().adF().bMu) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSS = this.bJs.adE().bLX.CF;
                    aVar.mTime = this.bJs.adE().bLX.CI;
                    aVar.bJN = this.bJs.adE().bLX.CH;
                    aVar.bJM = 1;
                    aa.a(aVar);
                    aa.bJL.set(this.bJs.adE().bLX.CH);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJs.adD().Dd = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bJs.adD().Dd = -12;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bJs.adD().Dd = -13;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bJs.adD().Dd = -15;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJs);
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
            if (this.bJz.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bJz.a(this.bJs.adC().adF().mUrl, this.bJs.adC().adF().bMt, this.bJs.adC().adF().bMr, this.bJs.adC().adF().bMs, 5, -1, acN());
            this.bJs.adD().Dd = a.responseCode;
            this.bJs.adD().mHeader = a.De;
            if (this.bJs.adD().Dd != 200) {
                com.baidu.adp.lib.network.http.e jz = this.bJz.jz();
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
                    this.bJs.adD().bLW = str2;
                } else {
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
                }
                TiebaStatic.net(this.bJs);
                return null;
            } else if (this.bJz.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Df, HTTP.UTF_8);
                try {
                    mz(str);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bJs.adD().Dd = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bJs.adD().Dd = -12;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bJs.adD().Dd = -13;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bJs.adD().Dd = -15;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJs);
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
                if (this.bJz.isCanceled()) {
                    com.baidu.adp.lib.network.http.e jz2 = this.bJz.jz();
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
                    TiebaStatic.net(this.bJs);
                    return false;
                }
                boolean a = this.bJz.a(this.bJs.adC().adF().mUrl, (z ? new File(str) : m.lZ(str)).getAbsolutePath(), false, i2, i3, -1, -1, acN(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bJA = 0;
                    int bJB = 0;
                    int bJC = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.bJA = i6 / 50;
                        }
                        this.bJB += i5 - this.bJC;
                        this.bJC = i5;
                        if (handler != null) {
                            if (this.bJB > this.bJA || i5 == i6) {
                                this.bJB = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (jz = this.bJz.jz()) != null && jz.jt() != null && handler != null) {
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
                TiebaStatic.net(this.bJs);
                return a;
            } catch (Exception e) {
                this.bJs.adD().Dd = -10;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e jz3 = this.bJz.jz();
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
                TiebaStatic.net(this.bJs);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bJs.adD().Dd = -15;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e jz4 = this.bJz.jz();
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
                TiebaStatic.net(this.bJs);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e jz5 = this.bJz.jz();
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
            TiebaStatic.net(this.bJs);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> acf() {
        return this.bJs.adC().adF().bMr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJs.adC().adF().bMr != null) {
            this.bJs.adC().adF().bMr.clear();
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
        if (this.bJs.adC().adF().bMs == null) {
            this.bJs.adC().adF().bMs = new HashMap<>();
        }
        this.bJs.adC().adF().bMs.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJs.adC().adF().bMr == null) {
                this.bJs.adC().adF().bMr = new ArrayList<>();
            }
            int b = b(this.bJs.adC().adF().bMr, basicNameValuePair.getName());
            int size = this.bJs.adC().adF().bMr.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJs.adC().adF().bMr.get(b).getName())) {
                    this.bJs.adC().adF().bMr.set(b, basicNameValuePair);
                } else {
                    this.bJs.adC().adF().bMr.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJs.adC().adF().bMr.add(b, basicNameValuePair);
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
        if (this.bJs != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJs.adC().adF().bMw)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJs.adC().adF().bMw));
            }
            if (!com.baidu.tbadk.s.am.jK() && !TextUtils.isEmpty(this.bJs.adC().adF().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJs.adC().adF().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
