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
    private static int bRj = 2097152;
    private final com.baidu.tbadk.core.util.a.a bRd;
    private com.baidu.adp.lib.network.a.a bRk = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        ahB();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bRd = aVar;
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

    private void ahB() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ie() {
        if (this.bRk != null) {
            this.bRk.ie();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ia() {
        this.bRk.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ahf() {
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
            if (this.bRd.aiB().aiE().bUd != null && this.bRd.aiB().aiE().bUd.size() > 0 && !this.bRd.aiB().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bRd.aiB().aiE().mUrl);
                if (this.bRd.aiB().aiE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bRd.aiB().aiE().mUrl.endsWith("?") && !this.bRd.aiB().aiE().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bRd.aiB().aiE().bUd.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bRd.aiB().aiE().bUd.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.bRd.aiB().aiE().bUd.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bRd.aiB().aiE().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bRd.aiB().aiE().bUf || this.bRd.aiB().aiE().mIsBDImage) && !this.bRd.aiB().mIsFromCDN) {
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
        if (this.bRk.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bRk.a(str, z, 5, 100, -1, -1, ahL());
        com.baidu.adp.lib.network.http.e it = this.bRk.it();
        if (it == null) {
            return null;
        }
        gVar = it.il();
        if (it != null) {
            try {
                if (it.im() != null && (size = it.im().size()) > 0) {
                    this.bRd.aiD().bTJ = it.im().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bRd.aiC().AK = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -12;
                TiebaStatic.net(this.bRd);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -13;
                TiebaStatic.net(this.bRd);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRd);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRd);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bRd.aiC().AK = gVar.responseCode;
        if (this.bRd.aiC().AK != 200) {
            this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bRd.aiD().bTJ != null && !TextUtils.isEmpty(this.bRd.aiD().bTJ.At)) {
                this.bRd.aiC().bTI = this.bRd.aiD().bTJ.At;
            } else {
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
            }
            TiebaStatic.net(this.bRd);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bRj) {
                    this.bRd.aiC().AK = -11;
                    TiebaStatic.net(this.bRd);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.asp().kz(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bRd.aiB().aiE().mUrl + "], size:" + i2);
                            this.bRd.aiC().AK = -16;
                            TiebaStatic.net(this.bRd);
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
        aVar.aVH = this.bRd.aiD().bTJ.Ao;
        aVar.mTime = new Date().getTime() - j;
        aVar.bRy = this.bRd.aiD().bTJ.Aq;
        aVar.bRx = 2;
        aa.a(aVar);
        aa.bRw.set(this.bRd.aiD().bTJ.Aq);
        TiebaStatic.net(this.bRd);
        bArr = gVar == null ? gVar.AN : null;
        return bArr;
    }

    public void nG(String str) {
        this.bRd.aiC().bTH = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bRd.aiC().bTH = errorData.getError_code();
                if (this.bRd.aiC().bTH == -1) {
                    this.bRd.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bRd.aiC().bTH != 0) {
                    this.bRd.aiC().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bRd.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ahg() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ahf = ahf();
        if (ahf == null || this.bRd.aiC().AK != 200) {
            return null;
        }
        try {
            this.bRd.aiB().aiE().bUh = TextUtils.isEmpty(this.bRd.aiB().aiE().bUh) ? HTTP.UTF_8 : this.bRd.aiB().aiE().bUh;
            str = new String(ahf, 0, ahf.length, this.bRd.aiB().aiE().bUh);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nG(str);
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
    public String ahe() {
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
            if (this.bRd.aiB().aiE().bUd == null || i2 >= this.bRd.aiB().aiE().bUd.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRd.aiB().aiE().bUd.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRd.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bm(sb.toString()));
            if (this.bRd.aiB().bRg) {
                o("sig", StringU.rs(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bRk.isCanceled()) {
                return null;
            }
            if (this.bRk.a(this.bRd.aiB().aiE().mUrl, this.bRd.aiB().aiE().bUd, this.bRd.aiB().aiE().bUf, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e it = this.bRk.it();
            if (it == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g il = it.il();
            if (it != null && it.im() != null && (size = it.im().size()) > 0) {
                this.bRd.aiD().bTJ = it.im().get(size - 1);
            }
            this.bRd.aiC().AK = il.responseCode;
            this.bRd.aiC().mHeader = il.AM;
            if (this.bRd.aiC().AK != 200) {
                if (this.bRd.aiD().bTJ != null && !TextUtils.isEmpty(this.bRd.aiD().bTJ.At)) {
                    this.bRd.aiC().bTI = this.bRd.aiD().bTJ.At;
                } else {
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
                }
                TiebaStatic.net(this.bRd);
                return null;
            } else if (this.bRk.isCanceled()) {
                return null;
            } else {
                str = new String(il.AN, "utf-8");
                try {
                    if (this.bRd.aiB().aiE().mIsBaiduServer && this.bRd.aiB().aiE().bUg) {
                        nG(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRd.aiD().bTJ.Ao;
                    aVar.mTime = this.bRd.aiD().bTJ.Ar;
                    aVar.bRy = this.bRd.aiD().bTJ.Aq;
                    aVar.bRx = 1;
                    aa.a(aVar);
                    aa.bRw.set(this.bRd.aiD().bTJ.Aq);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRd.aiC().AK = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.bRd.aiC().AK = -15;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.bRd.aiC().AK = -12;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.bRd.aiC().AK = -13;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRd);
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
    public String ahh() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.bRk.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bRk.a(this.bRd.aiB().aiE().mUrl, this.bRd.aiB().aiE().bUf, this.bRd.aiB().aiE().bUd, this.bRd.aiB().aiE().bUe, 5, -1, ahL());
            this.bRd.aiC().AK = a.responseCode;
            this.bRd.aiC().mHeader = a.AM;
            if (this.bRd.aiC().AK != 200) {
                com.baidu.adp.lib.network.http.e it = this.bRk.it();
                int i = 0;
                if (it != null && it.im() != null) {
                    i = it.im().size();
                }
                if (i <= 0 || (dVar = it.im().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.At;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.bRd.aiC().bTI = str2;
                } else {
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
                }
                TiebaStatic.net(this.bRd);
                return null;
            } else if (this.bRk.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.AN, HTTP.UTF_8);
                try {
                    nG(str);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bRd.aiC().AK = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bRd.aiC().AK = -12;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bRd.aiC().AK = -13;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bRd.aiC().AK = -15;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRd);
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
        com.baidu.adp.lib.network.http.e it;
        try {
            try {
                if (this.bRk.isCanceled()) {
                    com.baidu.adp.lib.network.http.e it2 = this.bRk.it();
                    if (it2 != null && it2.im() != null && handler != null) {
                        int i4 = it2.il().AK;
                        StringBuilder sb = new StringBuilder();
                        int size = it2.im().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = it2.im().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.At);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.bRd);
                    return false;
                }
                boolean a = this.bRk.a(this.bRd.aiB().aiE().mUrl, (z ? new File(str) : m.ng(str)).getAbsolutePath(), false, i2, i3, -1, -1, ahL(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bRl = 0;
                    int bRm = 0;
                    int bRn = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void m(int i5, int i6) {
                        if (i6 > 0) {
                            this.bRl = i6 / 50;
                        }
                        this.bRm += i5 - this.bRn;
                        this.bRn = i5;
                        if (handler != null) {
                            if (this.bRm > this.bRl || i5 == i6) {
                                this.bRm = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (it = this.bRk.it()) != null && it.im() != null && handler != null) {
                    int i5 = it.il().AK;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = it.im().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = it.im().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.At);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.bRd);
                return a;
            } catch (Exception e) {
                this.bRd.aiC().AK = -10;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e it3 = this.bRk.it();
                if (it3 != null && it3.im() != null && handler != null) {
                    int i6 = it3.il().AK;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = it3.im().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = it3.im().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.At);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.bRd);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bRd.aiC().AK = -15;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e it4 = this.bRk.it();
                if (it4 != null && it4.im() != null && handler != null) {
                    int i7 = it4.il().AK;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = it4.im().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = it4.im().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.At);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.bRd);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e it5 = this.bRk.it();
            if (it5 != null && it5.im() != null && handler != null) {
                int i8 = it5.il().AK;
                StringBuilder sb5 = new StringBuilder();
                int size5 = it5.im().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = it5.im().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.At);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.bRd);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> ahd() {
        return this.bRd.aiB().aiE().bUd;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bRd.aiB().aiE().bUd != null) {
            this.bRd.aiB().aiE().bUd.clear();
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
        if (this.bRd.aiB().aiE().bUe == null) {
            this.bRd.aiB().aiE().bUe = new HashMap<>();
        }
        this.bRd.aiB().aiE().bUe.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bRd.aiB().aiE().bUd == null) {
                this.bRd.aiB().aiE().bUd = new ArrayList<>();
            }
            int b = b(this.bRd.aiB().aiE().bUd, basicNameValuePair.getName());
            int size = this.bRd.aiB().aiE().bUd.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bRd.aiB().aiE().bUd.get(b).getName())) {
                    this.bRd.aiB().aiE().bUd.set(b, basicNameValuePair);
                } else {
                    this.bRd.aiB().aiE().bUd.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bRd.aiB().aiE().bUd.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> ahL() {
        if (this.bRd != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bRd.aiB().aiE().bUi)) {
                linkedList.add(new BasicNameValuePair("sid", this.bRd.aiB().aiE().bUi));
            }
            if (!com.baidu.tbadk.t.aq.iE() && !TextUtils.isEmpty(this.bRd.aiB().aiE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bRd.aiB().aiE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
