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
    private static int bJv = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJp;
    private com.baidu.adp.lib.network.a.a bJw = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        acG();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bJp = aVar;
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

    private void acG() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.bJw != null) {
            this.bJw.jl();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.bJw.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ack() {
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
            if (this.bJp.adF().adI().bMo != null && this.bJp.adF().adI().bMo.size() > 0 && !this.bJp.adF().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJp.adF().adI().mUrl);
                if (this.bJp.adF().adI().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJp.adF().adI().mUrl.endsWith("?") && !this.bJp.adF().adI().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJp.adF().adI().bMo.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJp.adF().adI().bMo.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJp.adF().adI().bMo.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJp.adF().adI().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJp.adF().adI().bMq || this.bJp.adF().adI().mIsBDImage) && !this.bJp.adF().mIsFromCDN) {
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
        if (this.bJw.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bJw.a(str, z, 5, 100, -1, -1, acQ());
        com.baidu.adp.lib.network.http.e jz = this.bJw.jz();
        if (jz == null) {
            return null;
        }
        gVar = jz.js();
        if (jz != null) {
            try {
                if (jz.jt() != null && (size = jz.jt().size()) > 0) {
                    this.bJp.adH().bLU = jz.jt().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJp.adG().Dd = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJp);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -12;
                TiebaStatic.net(this.bJp);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -13;
                TiebaStatic.net(this.bJp);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJp);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bJp.adG().Dd = gVar.responseCode;
        if (this.bJp.adG().Dd != 200) {
            this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJp.adH().bLU != null && !TextUtils.isEmpty(this.bJp.adH().bLU.CK)) {
                this.bJp.adG().bLT = this.bJp.adH().bLU.CK;
            } else {
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
            }
            TiebaStatic.net(this.bJp);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJv) {
                    this.bJp.adG().Dd = -11;
                    TiebaStatic.net(this.bJp);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anp().jM(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJp.adF().adI().mUrl + "], size:" + i2);
                            this.bJp.adG().Dd = -16;
                            TiebaStatic.net(this.bJp);
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
        aVar.aSO = this.bJp.adH().bLU.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJK = this.bJp.adH().bLU.CH;
        aVar.bJJ = 2;
        aa.a(aVar);
        aa.bJI.set(this.bJp.adH().bLU.CH);
        TiebaStatic.net(this.bJp);
        bArr = gVar == null ? gVar.Df : null;
        return bArr;
    }

    public void my(String str) {
        this.bJp.adG().bLS = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJp.adG().bLS = errorData.getError_code();
                if (this.bJp.adG().bLS == -1) {
                    this.bJp.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJp.adG().bLS != 0) {
                    this.bJp.adG().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJp.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String acl() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ack = ack();
        if (ack == null || this.bJp.adG().Dd != 200) {
            return null;
        }
        try {
            this.bJp.adF().adI().bMs = TextUtils.isEmpty(this.bJp.adF().adI().bMs) ? HTTP.UTF_8 : this.bJp.adF().adI().bMs;
            str = new String(ack, 0, ack.length, this.bJp.adF().adI().bMs);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            my(str);
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
    public String acj() {
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
            if (this.bJp.adF().adI().bMo == null || i2 >= this.bJp.adF().adI().bMo.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJp.adF().adI().bMo.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJp.adF().adI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", com.baidu.adp.lib.util.s.bC(sb.toString()));
            if (this.bJp.adF().bJs) {
                x("sig", StringU.qj(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bJw.isCanceled()) {
                return null;
            }
            if (this.bJw.a(this.bJp.adF().adI().mUrl, this.bJp.adF().adI().bMo, this.bJp.adF().adI().bMq, 5, -1, acQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jz = this.bJw.jz();
            if (jz == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g js = jz.js();
            if (jz != null && jz.jt() != null && (size = jz.jt().size()) > 0) {
                this.bJp.adH().bLU = jz.jt().get(size - 1);
            }
            this.bJp.adG().Dd = js.responseCode;
            this.bJp.adG().mHeader = js.De;
            if (this.bJp.adG().Dd != 200) {
                if (this.bJp.adH().bLU != null && !TextUtils.isEmpty(this.bJp.adH().bLU.CK)) {
                    this.bJp.adG().bLT = this.bJp.adH().bLU.CK;
                } else {
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
                }
                TiebaStatic.net(this.bJp);
                return null;
            } else if (this.bJw.isCanceled()) {
                return null;
            } else {
                str = new String(js.Df, "utf-8");
                try {
                    if (this.bJp.adF().adI().mIsBaiduServer && this.bJp.adF().adI().bMr) {
                        my(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSO = this.bJp.adH().bLU.CF;
                    aVar.mTime = this.bJp.adH().bLU.CI;
                    aVar.bJK = this.bJp.adH().bLU.CH;
                    aVar.bJJ = 1;
                    aa.a(aVar);
                    aa.bJI.set(this.bJp.adH().bLU.CH);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJp.adG().Dd = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bJp.adG().Dd = -12;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bJp.adG().Dd = -13;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bJp.adG().Dd = -15;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJp);
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
    public String acm() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.bJw.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bJw.a(this.bJp.adF().adI().mUrl, this.bJp.adF().adI().bMq, this.bJp.adF().adI().bMo, this.bJp.adF().adI().bMp, 5, -1, acQ());
            this.bJp.adG().Dd = a.responseCode;
            this.bJp.adG().mHeader = a.De;
            if (this.bJp.adG().Dd != 200) {
                com.baidu.adp.lib.network.http.e jz = this.bJw.jz();
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
                    this.bJp.adG().bLT = str2;
                } else {
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
                }
                TiebaStatic.net(this.bJp);
                return null;
            } else if (this.bJw.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Df, HTTP.UTF_8);
                try {
                    my(str);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bJp.adG().Dd = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bJp.adG().Dd = -12;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bJp.adG().Dd = -13;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bJp.adG().Dd = -15;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJp);
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
                if (this.bJw.isCanceled()) {
                    com.baidu.adp.lib.network.http.e jz2 = this.bJw.jz();
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
                    TiebaStatic.net(this.bJp);
                    return false;
                }
                boolean a = this.bJw.a(this.bJp.adF().adI().mUrl, (z ? new File(str) : m.lY(str)).getAbsolutePath(), false, i2, i3, -1, -1, acQ(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bJx = 0;
                    int bJy = 0;
                    int bJz = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.bJx = i6 / 50;
                        }
                        this.bJy += i5 - this.bJz;
                        this.bJz = i5;
                        if (handler != null) {
                            if (this.bJy > this.bJx || i5 == i6) {
                                this.bJy = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (jz = this.bJw.jz()) != null && jz.jt() != null && handler != null) {
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
                TiebaStatic.net(this.bJp);
                return a;
            } catch (Exception e) {
                this.bJp.adG().Dd = -10;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e jz3 = this.bJw.jz();
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
                TiebaStatic.net(this.bJp);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bJp.adG().Dd = -15;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e jz4 = this.bJw.jz();
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
                TiebaStatic.net(this.bJp);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e jz5 = this.bJw.jz();
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
            TiebaStatic.net(this.bJp);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> aci() {
        return this.bJp.adF().adI().bMo;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJp.adF().adI().bMo != null) {
            this.bJp.adF().adI().bMo.clear();
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
        if (this.bJp.adF().adI().bMp == null) {
            this.bJp.adF().adI().bMp = new HashMap<>();
        }
        this.bJp.adF().adI().bMp.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJp.adF().adI().bMo == null) {
                this.bJp.adF().adI().bMo = new ArrayList<>();
            }
            int b = b(this.bJp.adF().adI().bMo, basicNameValuePair.getName());
            int size = this.bJp.adF().adI().bMo.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJp.adF().adI().bMo.get(b).getName())) {
                    this.bJp.adF().adI().bMo.set(b, basicNameValuePair);
                } else {
                    this.bJp.adF().adI().bMo.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJp.adF().adI().bMo.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> acQ() {
        if (this.bJp != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJp.adF().adI().bMt)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJp.adF().adI().bMt));
            }
            if (!com.baidu.tbadk.s.am.jK() && !TextUtils.isEmpty(this.bJp.adF().adI().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJp.adF().adI().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
