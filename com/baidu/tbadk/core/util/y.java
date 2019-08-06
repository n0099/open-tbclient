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
    private static int bSp = 2097152;
    private final com.baidu.tbadk.core.util.a.a bSj;
    private com.baidu.adp.lib.network.a.a bSq = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        aiF();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bSj = aVar;
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

    private void aiF() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void in() {
        if (this.bSq != null) {
            this.bSq.in();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ik() {
        this.bSq.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] aij() {
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
            if (this.bSj.ajG().ajJ().bVk != null && this.bSj.ajG().ajJ().bVk.size() > 0 && !this.bSj.ajG().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bSj.ajG().ajJ().mUrl);
                if (this.bSj.ajG().ajJ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bSj.ajG().ajJ().mUrl.endsWith("?") && !this.bSj.ajG().ajJ().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bSj.ajG().ajJ().bVk.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bSj.ajG().ajJ().bVk.get(i).getName());
                    sb.append("=");
                    sb.append(aq.bi(this.bSj.ajG().ajJ().bVk.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bSj.ajG().ajJ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bSj.ajG().ajJ().bVm || this.bSj.ajG().ajJ().mIsBDImage) && !this.bSj.ajG().mIsFromCDN) {
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
        if (this.bSq.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bSq.a(str, z, 5, 100, -1, -1, aiP());
        com.baidu.adp.lib.network.http.e iC = this.bSq.iC();
        if (iC == null) {
            return null;
        }
        gVar = iC.iv();
        if (iC != null) {
            try {
                if (iC.iw() != null && (size = iC.iw().size()) > 0) {
                    this.bSj.ajI().bUQ = iC.iw().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bSj.ajH().AR = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -12;
                TiebaStatic.net(this.bSj);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -13;
                TiebaStatic.net(this.bSj);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSj);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSj);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bSj.ajH().AR = gVar.responseCode;
        if (this.bSj.ajH().AR != 200) {
            this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bSj.ajI().bUQ != null && !TextUtils.isEmpty(this.bSj.ajI().bUQ.Az)) {
                this.bSj.ajH().bUP = this.bSj.ajI().bUQ.Az;
            } else {
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
            }
            TiebaStatic.net(this.bSj);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bSp) {
                    this.bSj.ajH().AR = -11;
                    TiebaStatic.net(this.bSj);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aty().kG(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bSj.ajG().ajJ().mUrl + "], size:" + i2);
                            this.bSj.ajH().AR = -16;
                            TiebaStatic.net(this.bSj);
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
        aVar.aWr = this.bSj.ajI().bUQ.Au;
        aVar.mTime = new Date().getTime() - j;
        aVar.bSE = this.bSj.ajI().bUQ.Aw;
        aVar.bSD = 2;
        aa.a(aVar);
        aa.bSC.set(this.bSj.ajI().bUQ.Aw);
        TiebaStatic.net(this.bSj);
        bArr = gVar == null ? gVar.AU : null;
        return bArr;
    }

    public void nS(String str) {
        this.bSj.ajH().bUO = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bSj.ajH().bUO = errorData.getError_code();
                if (this.bSj.ajH().bUO == -1) {
                    this.bSj.ajH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bSj.ajH().bUO != 0) {
                    this.bSj.ajH().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bSj.ajH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aik() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] aij = aij();
        if (aij == null || this.bSj.ajH().AR != 200) {
            return null;
        }
        try {
            this.bSj.ajG().ajJ().bVo = TextUtils.isEmpty(this.bSj.ajG().ajJ().bVo) ? HTTP.UTF_8 : this.bSj.ajG().ajJ().bVo;
            str = new String(aij, 0, aij.length, this.bSj.ajG().ajJ().bVo);
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
    public String aii() {
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
            if (this.bSj.ajG().ajJ().bVk == null || i2 >= this.bSj.ajG().ajJ().bVk.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSj.ajG().ajJ().bVk.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSj.ajG().ajJ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bn(sb.toString()));
            if (this.bSj.ajG().bSm) {
                o("sig", StringU.rK(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bSq.isCanceled()) {
                return null;
            }
            if (this.bSq.a(this.bSj.ajG().ajJ().mUrl, this.bSj.ajG().ajJ().bVk, this.bSj.ajG().ajJ().bVm, 5, -1, aiP()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e iC = this.bSq.iC();
            if (iC == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g iv = iC.iv();
            if (iC != null && iC.iw() != null && (size = iC.iw().size()) > 0) {
                this.bSj.ajI().bUQ = iC.iw().get(size - 1);
            }
            this.bSj.ajH().AR = iv.responseCode;
            this.bSj.ajH().mHeader = iv.AT;
            if (this.bSj.ajH().AR != 200) {
                if (this.bSj.ajI().bUQ != null && !TextUtils.isEmpty(this.bSj.ajI().bUQ.Az)) {
                    this.bSj.ajH().bUP = this.bSj.ajI().bUQ.Az;
                } else {
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
                }
                TiebaStatic.net(this.bSj);
                return null;
            } else if (this.bSq.isCanceled()) {
                return null;
            } else {
                str = new String(iv.AU, "utf-8");
                try {
                    if (this.bSj.ajG().ajJ().mIsBaiduServer && this.bSj.ajG().ajJ().bVn) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSj.ajI().bUQ.Au;
                    aVar.mTime = this.bSj.ajI().bUQ.Ax;
                    aVar.bSE = this.bSj.ajI().bUQ.Aw;
                    aVar.bSD = 1;
                    aa.a(aVar);
                    aa.bSC.set(this.bSj.ajI().bUQ.Aw);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSj.ajH().AR = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.bSj.ajH().AR = -15;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.bSj.ajH().AR = -12;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.bSj.ajH().AR = -13;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSj);
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
    public String ail() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.bSq.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bSq.a(this.bSj.ajG().ajJ().mUrl, this.bSj.ajG().ajJ().bVm, this.bSj.ajG().ajJ().bVk, this.bSj.ajG().ajJ().bVl, 5, -1, aiP());
            this.bSj.ajH().AR = a.responseCode;
            this.bSj.ajH().mHeader = a.AT;
            if (this.bSj.ajH().AR != 200) {
                com.baidu.adp.lib.network.http.e iC = this.bSq.iC();
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
                    this.bSj.ajH().bUP = str2;
                } else {
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
                }
                TiebaStatic.net(this.bSj);
                return null;
            } else if (this.bSq.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.AU, HTTP.UTF_8);
                try {
                    nS(str);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bSj.ajH().AR = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bSj.ajH().AR = -12;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bSj.ajH().AR = -13;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bSj.ajH().AR = -15;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSj);
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
                if (this.bSq.isCanceled()) {
                    com.baidu.adp.lib.network.http.e iC2 = this.bSq.iC();
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
                    TiebaStatic.net(this.bSj);
                    return false;
                }
                boolean a = this.bSq.a(this.bSj.ajG().ajJ().mUrl, (z ? new File(str) : m.ns(str)).getAbsolutePath(), false, i2, i3, -1, -1, aiP(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bSr = 0;
                    int bSs = 0;
                    int bSt = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.bSr = i6 / 50;
                        }
                        this.bSs += i5 - this.bSt;
                        this.bSt = i5;
                        if (handler != null) {
                            if (this.bSs > this.bSr || i5 == i6) {
                                this.bSs = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (iC = this.bSq.iC()) != null && iC.iw() != null && handler != null) {
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
                TiebaStatic.net(this.bSj);
                return a;
            } catch (Exception e) {
                this.bSj.ajH().AR = -10;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e iC3 = this.bSq.iC();
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
                TiebaStatic.net(this.bSj);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bSj.ajH().AR = -15;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e iC4 = this.bSq.iC();
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
                TiebaStatic.net(this.bSj);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e iC5 = this.bSq.iC();
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
            TiebaStatic.net(this.bSj);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> aih() {
        return this.bSj.ajG().ajJ().bVk;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bSj.ajG().ajJ().bVk != null) {
            this.bSj.ajG().ajJ().bVk.clear();
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
        if (this.bSj.ajG().ajJ().bVl == null) {
            this.bSj.ajG().ajJ().bVl = new HashMap<>();
        }
        this.bSj.ajG().ajJ().bVl.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bSj.ajG().ajJ().bVk == null) {
                this.bSj.ajG().ajJ().bVk = new ArrayList<>();
            }
            int b = b(this.bSj.ajG().ajJ().bVk, basicNameValuePair.getName());
            int size = this.bSj.ajG().ajJ().bVk.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bSj.ajG().ajJ().bVk.get(b).getName())) {
                    this.bSj.ajG().ajJ().bVk.set(b, basicNameValuePair);
                } else {
                    this.bSj.ajG().ajJ().bVk.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bSj.ajG().ajJ().bVk.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aiP() {
        if (this.bSj != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bSj.ajG().ajJ().bVp)) {
                linkedList.add(new BasicNameValuePair("sid", this.bSj.ajG().ajJ().bVp));
            }
            if (!com.baidu.tbadk.t.aq.iN() && !TextUtils.isEmpty(this.bSj.ajG().ajJ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bSj.ajG().ajJ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
