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
    private static int bRi = 2097152;
    private final com.baidu.tbadk.core.util.a.a bRc;
    private com.baidu.adp.lib.network.a.a bRj = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        ahB();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.bRc = aVar;
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
        if (this.bRj != null) {
            this.bRj.ie();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ia() {
        this.bRj.cancel();
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
            if (this.bRc.aiB().aiE().bUc != null && this.bRc.aiB().aiE().bUc.size() > 0 && !this.bRc.aiB().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bRc.aiB().aiE().mUrl);
                if (this.bRc.aiB().aiE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bRc.aiB().aiE().mUrl.endsWith("?") && !this.bRc.aiB().aiE().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bRc.aiB().aiE().bUc.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bRc.aiB().aiE().bUc.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.bRc.aiB().aiE().bUc.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bRc.aiB().aiE().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bRc.aiB().aiE().bUe || this.bRc.aiB().aiE().mIsBDImage) && !this.bRc.aiB().mIsFromCDN) {
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
        if (this.bRj.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.bRj.a(str, z, 5, 100, -1, -1, ahL());
        com.baidu.adp.lib.network.http.e it = this.bRj.it();
        if (it == null) {
            return null;
        }
        gVar = it.il();
        if (it != null) {
            try {
                if (it.im() != null && (size = it.im().size()) > 0) {
                    this.bRc.aiD().bTI = it.im().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bRc.aiC().AM = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -12;
                TiebaStatic.net(this.bRc);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -13;
                TiebaStatic.net(this.bRc);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRc);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRc);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.bRc.aiC().AM = gVar.responseCode;
        if (this.bRc.aiC().AM != 200) {
            this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bRc.aiD().bTI != null && !TextUtils.isEmpty(this.bRc.aiD().bTI.Au)) {
                this.bRc.aiC().bTH = this.bRc.aiD().bTI.Au;
            } else {
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
            }
            TiebaStatic.net(this.bRc);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bRi) {
                    this.bRc.aiC().AM = -11;
                    TiebaStatic.net(this.bRc);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.asp().kz(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bRc.aiB().aiE().mUrl + "], size:" + i2);
                            this.bRc.aiC().AM = -16;
                            TiebaStatic.net(this.bRc);
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
        aVar.aVH = this.bRc.aiD().bTI.Ap;
        aVar.mTime = new Date().getTime() - j;
        aVar.bRx = this.bRc.aiD().bTI.Ar;
        aVar.bRw = 2;
        aa.a(aVar);
        aa.bRv.set(this.bRc.aiD().bTI.Ar);
        TiebaStatic.net(this.bRc);
        bArr = gVar == null ? gVar.AO : null;
        return bArr;
    }

    public void nH(String str) {
        this.bRc.aiC().bTG = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bRc.aiC().bTG = errorData.getError_code();
                if (this.bRc.aiC().bTG == -1) {
                    this.bRc.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bRc.aiC().bTG != 0) {
                    this.bRc.aiC().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bRc.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ahg() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ahf = ahf();
        if (ahf == null || this.bRc.aiC().AM != 200) {
            return null;
        }
        try {
            this.bRc.aiB().aiE().bUg = TextUtils.isEmpty(this.bRc.aiB().aiE().bUg) ? HTTP.UTF_8 : this.bRc.aiB().aiE().bUg;
            str = new String(ahf, 0, ahf.length, this.bRc.aiB().aiE().bUg);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nH(str);
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
            if (this.bRc.aiB().aiE().bUc == null || i2 >= this.bRc.aiB().aiE().bUc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRc.aiB().aiE().bUc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRc.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bm(sb.toString()));
            if (this.bRc.aiB().bRf) {
                o("sig", StringU.rt(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.bRj.isCanceled()) {
                return null;
            }
            if (this.bRj.a(this.bRc.aiB().aiE().mUrl, this.bRc.aiB().aiE().bUc, this.bRc.aiB().aiE().bUe, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e it = this.bRj.it();
            if (it == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g il = it.il();
            if (it != null && it.im() != null && (size = it.im().size()) > 0) {
                this.bRc.aiD().bTI = it.im().get(size - 1);
            }
            this.bRc.aiC().AM = il.responseCode;
            this.bRc.aiC().mHeader = il.AN;
            if (this.bRc.aiC().AM != 200) {
                if (this.bRc.aiD().bTI != null && !TextUtils.isEmpty(this.bRc.aiD().bTI.Au)) {
                    this.bRc.aiC().bTH = this.bRc.aiD().bTI.Au;
                } else {
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
                }
                TiebaStatic.net(this.bRc);
                return null;
            } else if (this.bRj.isCanceled()) {
                return null;
            } else {
                str = new String(il.AO, "utf-8");
                try {
                    if (this.bRc.aiB().aiE().mIsBaiduServer && this.bRc.aiB().aiE().bUf) {
                        nH(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRc.aiD().bTI.Ap;
                    aVar.mTime = this.bRc.aiD().bTI.As;
                    aVar.bRx = this.bRc.aiD().bTI.Ar;
                    aVar.bRw = 1;
                    aa.a(aVar);
                    aa.bRv.set(this.bRc.aiD().bTI.Ar);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRc.aiC().AM = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.bRc.aiC().AM = -15;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.bRc.aiC().AM = -12;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.bRc.aiC().AM = -13;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRc);
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
            if (this.bRj.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.bRj.a(this.bRc.aiB().aiE().mUrl, this.bRc.aiB().aiE().bUe, this.bRc.aiB().aiE().bUc, this.bRc.aiB().aiE().bUd, 5, -1, ahL());
            this.bRc.aiC().AM = a.responseCode;
            this.bRc.aiC().mHeader = a.AN;
            if (this.bRc.aiC().AM != 200) {
                com.baidu.adp.lib.network.http.e it = this.bRj.it();
                int i = 0;
                if (it != null && it.im() != null) {
                    i = it.im().size();
                }
                if (i <= 0 || (dVar = it.im().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.Au;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.bRc.aiC().bTH = str2;
                } else {
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
                }
                TiebaStatic.net(this.bRc);
                return null;
            } else if (this.bRj.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.AO, HTTP.UTF_8);
                try {
                    nH(str);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.bRc.aiC().AM = -14;
                    return str;
                } catch (SocketException e5) {
                    this.bRc.aiC().AM = -12;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.bRc.aiC().AM = -13;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.bRc.aiC().AM = -15;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRc);
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
                if (this.bRj.isCanceled()) {
                    com.baidu.adp.lib.network.http.e it2 = this.bRj.it();
                    if (it2 != null && it2.im() != null && handler != null) {
                        int i4 = it2.il().AM;
                        StringBuilder sb = new StringBuilder();
                        int size = it2.im().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = it2.im().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.Au);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.bRc);
                    return false;
                }
                boolean a = this.bRj.a(this.bRc.aiB().aiE().mUrl, (z ? new File(str) : m.nh(str)).getAbsolutePath(), false, i2, i3, -1, -1, ahL(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int bRk = 0;
                    int bRl = 0;
                    int bRm = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void m(int i5, int i6) {
                        if (i6 > 0) {
                            this.bRk = i6 / 50;
                        }
                        this.bRl += i5 - this.bRm;
                        this.bRm = i5;
                        if (handler != null) {
                            if (this.bRl > this.bRk || i5 == i6) {
                                this.bRl = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (it = this.bRj.it()) != null && it.im() != null && handler != null) {
                    int i5 = it.il().AM;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = it.im().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = it.im().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.Au);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.bRc);
                return a;
            } catch (Exception e) {
                this.bRc.aiC().AM = -10;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e it3 = this.bRj.it();
                if (it3 != null && it3.im() != null && handler != null) {
                    int i6 = it3.il().AM;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = it3.im().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = it3.im().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.Au);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.bRc);
                return false;
            } catch (OutOfMemoryError e2) {
                this.bRc.aiC().AM = -15;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e it4 = this.bRj.it();
                if (it4 != null && it4.im() != null && handler != null) {
                    int i7 = it4.il().AM;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = it4.im().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = it4.im().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.Au);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.bRc);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e it5 = this.bRj.it();
            if (it5 != null && it5.im() != null && handler != null) {
                int i8 = it5.il().AM;
                StringBuilder sb5 = new StringBuilder();
                int size5 = it5.im().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = it5.im().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.Au);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.bRc);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> ahd() {
        return this.bRc.aiB().aiE().bUc;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bRc.aiB().aiE().bUc != null) {
            this.bRc.aiB().aiE().bUc.clear();
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
        if (this.bRc.aiB().aiE().bUd == null) {
            this.bRc.aiB().aiE().bUd = new HashMap<>();
        }
        this.bRc.aiB().aiE().bUd.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bRc.aiB().aiE().bUc == null) {
                this.bRc.aiB().aiE().bUc = new ArrayList<>();
            }
            int b = b(this.bRc.aiB().aiE().bUc, basicNameValuePair.getName());
            int size = this.bRc.aiB().aiE().bUc.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bRc.aiB().aiE().bUc.get(b).getName())) {
                    this.bRc.aiB().aiE().bUc.set(b, basicNameValuePair);
                } else {
                    this.bRc.aiB().aiE().bUc.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bRc.aiB().aiE().bUc.add(b, basicNameValuePair);
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
        if (this.bRc != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bRc.aiB().aiE().bUh)) {
                linkedList.add(new BasicNameValuePair("sid", this.bRc.aiB().aiE().bUh));
            }
            if (!com.baidu.tbadk.t.aq.iE() && !TextUtils.isEmpty(this.bRc.aiB().aiE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bRc.aiB().aiE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
