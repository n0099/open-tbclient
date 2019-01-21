package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.StringU;
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class y implements q {
    private static int aBz = 2097152;
    private com.baidu.adp.lib.network.a.a aBA = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a aBt;
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Dv();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aBt = aVar;
        com.baidu.adp.lib.network.a.a.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
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

    private void Dv() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jj() {
        if (this.aBA != null) {
            this.aBA.jj();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jg() {
        this.aBA.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] CZ() {
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
            if (this.aBt.Eu().Ex().aEt != null && this.aBt.Eu().Ex().aEt.size() > 0 && !this.aBt.Eu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aBt.Eu().Ex().mUrl);
                if (this.aBt.Eu().Ex().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aBt.Eu().Ex().mUrl.endsWith("?") && !this.aBt.Eu().Ex().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.aBt.Eu().Ex().aEt.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.aBt.Eu().Ex().aEt.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.aBt.Eu().Ex().aEt.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aBt.Eu().Ex().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aBt.Eu().Ex().aEv || this.aBt.Eu().Ex().mIsBDImage) && !this.aBt.Eu().mIsFromCDN) {
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
        if (this.aBA.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aBA.a(str, z, 5, 100, -1, -1, DF());
        com.baidu.adp.lib.network.http.e jx = this.aBA.jx();
        if (jx == null) {
            return null;
        }
        gVar = jx.jq();
        if (jx != null) {
            try {
                if (jx.jr() != null && (size = jx.jr().size()) > 0) {
                    this.aBt.Ew().aDZ = jx.jr().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aBt.Ev().De = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aBt);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -12;
                TiebaStatic.net(this.aBt);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -13;
                TiebaStatic.net(this.aBt);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aBt);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aBt.Ev().De = gVar.responseCode;
        if (this.aBt.Ev().De != 200) {
            this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.aBt.Ew().aDZ != null && !TextUtils.isEmpty(this.aBt.Ew().aDZ.CL)) {
                this.aBt.Ev().aDY = this.aBt.Ew().aDZ.CL;
            } else {
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
            }
            TiebaStatic.net(this.aBt);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aBz) {
                    this.aBt.Ev().De = -11;
                    TiebaStatic.net(this.aBt);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.NM().gb(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aBt.Eu().Ex().mUrl + "], size:" + i2);
                            this.aBt.Ev().De = -16;
                            TiebaStatic.net(this.aBt);
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
        aVar.mSize = this.aBt.Ew().aDZ.CG;
        aVar.mTime = new Date().getTime() - j;
        aVar.aBO = this.aBt.Ew().aDZ.CI;
        aVar.aBN = 2;
        aa.a(aVar);
        aa.aBM.set(this.aBt.Ew().aDZ.CI);
        TiebaStatic.net(this.aBt);
        bArr = gVar == null ? gVar.Dg : null;
        return bArr;
    }

    public void fN(String str) {
        this.aBt.Ev().aDX = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aBt.Ev().aDX = errorData.getError_code();
                if (this.aBt.Ev().aDX == -1) {
                    this.aBt.Ev().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.aBt.Ev().aDX != 0) {
                    this.aBt.Ev().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aBt.Ev().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Da() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] CZ = CZ();
        if (CZ == null || this.aBt.Ev().De != 200) {
            return null;
        }
        try {
            this.aBt.Eu().Ex().aEx = TextUtils.isEmpty(this.aBt.Eu().Ex().aEx) ? "UTF-8" : this.aBt.Eu().Ex().aEx;
            str = new String(CZ, 0, CZ.length, this.aBt.Eu().Ex().aEx);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            fN(str);
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
    public String CY() {
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
            if (this.aBt.Eu().Ex().aEt == null || i2 >= this.aBt.Eu().Ex().aEt.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aBt.Eu().Ex().aEt.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aBt.Eu().Ex().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", com.baidu.adp.lib.util.s.bC(sb.toString()));
            if (this.aBt.Eu().aBw) {
                x("sig", StringU.jz(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aBA.isCanceled()) {
                return null;
            }
            if (this.aBA.a(this.aBt.Eu().Ex().mUrl, this.aBt.Eu().Ex().aEt, this.aBt.Eu().Ex().aEv, 5, -1, DF()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jx = this.aBA.jx();
            if (jx == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g jq = jx.jq();
            if (jx != null && jx.jr() != null && (size = jx.jr().size()) > 0) {
                this.aBt.Ew().aDZ = jx.jr().get(size - 1);
            }
            this.aBt.Ev().De = jq.responseCode;
            this.aBt.Ev().mHeader = jq.Df;
            if (this.aBt.Ev().De != 200) {
                if (this.aBt.Ew().aDZ != null && !TextUtils.isEmpty(this.aBt.Ew().aDZ.CL)) {
                    this.aBt.Ev().aDY = this.aBt.Ew().aDZ.CL;
                } else {
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
                }
                TiebaStatic.net(this.aBt);
                return null;
            } else if (this.aBA.isCanceled()) {
                return null;
            } else {
                str = new String(jq.Dg, IoUtils.UTF_8);
                try {
                    if (this.aBt.Eu().Ex().mIsBaiduServer && this.aBt.Eu().Ex().aEw) {
                        fN(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.aBt.Ew().aDZ.CG;
                    aVar.mTime = this.aBt.Ew().aDZ.CJ;
                    aVar.aBO = this.aBt.Ew().aDZ.CI;
                    aVar.aBN = 1;
                    aa.a(aVar);
                    aa.aBM.set(this.aBt.Ew().aDZ.CI);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aBt.Ev().De = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.aBt.Ev().De = -12;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.aBt.Ev().De = -13;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.aBt.Ev().De = -15;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aBt);
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
    public String Db() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.aBA.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aBA.a(this.aBt.Eu().Ex().mUrl, this.aBt.Eu().Ex().aEv, this.aBt.Eu().Ex().aEt, this.aBt.Eu().Ex().aEu, 5, -1, DF());
            this.aBt.Ev().De = a.responseCode;
            this.aBt.Ev().mHeader = a.Df;
            if (this.aBt.Ev().De != 200) {
                com.baidu.adp.lib.network.http.e jx = this.aBA.jx();
                int i = 0;
                if (jx != null && jx.jr() != null) {
                    i = jx.jr().size();
                }
                if (i <= 0 || (dVar = jx.jr().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.CL;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aBt.Ev().aDY = str2;
                } else {
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
                }
                TiebaStatic.net(this.aBt);
                return null;
            } else if (this.aBA.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Dg, "UTF-8");
                try {
                    fN(str);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aBt.Ev().De = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aBt.Ev().De = -12;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aBt.Ev().De = -13;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aBt.Ev().De = -15;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aBt);
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
        com.baidu.adp.lib.network.http.e jx;
        try {
            try {
                if (this.aBA.isCanceled()) {
                    com.baidu.adp.lib.network.http.e jx2 = this.aBA.jx();
                    if (jx2 != null && jx2.jr() != null && handler != null) {
                        int i4 = jx2.jq().De;
                        StringBuilder sb = new StringBuilder();
                        int size = jx2.jr().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = jx2.jr().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.CL);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.aBt);
                    return false;
                }
                boolean a = this.aBA.a(this.aBt.Eu().Ex().mUrl, (z ? new File(str) : l.fl(str)).getAbsolutePath(), false, i2, i3, -1, -1, DF(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int aBB = 0;
                    int aBC = 0;
                    int aBD = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void o(int i5, int i6) {
                        if (i6 > 0) {
                            this.aBB = i6 / 50;
                        }
                        this.aBC += i5 - this.aBD;
                        this.aBD = i5;
                        if (handler != null) {
                            if (this.aBC > this.aBB || i5 == i6) {
                                this.aBC = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (jx = this.aBA.jx()) != null && jx.jr() != null && handler != null) {
                    int i5 = jx.jq().De;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = jx.jr().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = jx.jr().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.CL);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.aBt);
                return a;
            } catch (Exception e) {
                this.aBt.Ev().De = -10;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e jx3 = this.aBA.jx();
                if (jx3 != null && jx3.jr() != null && handler != null) {
                    int i6 = jx3.jq().De;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = jx3.jr().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = jx3.jr().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.CL);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.aBt);
                return false;
            } catch (OutOfMemoryError e2) {
                this.aBt.Ev().De = -15;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e jx4 = this.aBA.jx();
                if (jx4 != null && jx4.jr() != null && handler != null) {
                    int i7 = jx4.jq().De;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = jx4.jr().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = jx4.jr().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.CL);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.aBt);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e jx5 = this.aBA.jx();
            if (jx5 != null && jx5.jr() != null && handler != null) {
                int i8 = jx5.jq().De;
                StringBuilder sb5 = new StringBuilder();
                int size5 = jx5.jr().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = jx5.jr().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.CL);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.aBt);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> CX() {
        return this.aBt.Eu().Ex().aEt;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aBt.Eu().Ex().aEt != null) {
            this.aBt.Eu().Ex().aEt.clear();
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
        if (this.aBt.Eu().Ex().aEu == null) {
            this.aBt.Eu().Ex().aEu = new HashMap<>();
        }
        this.aBt.Eu().Ex().aEu.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aBt.Eu().Ex().aEt == null) {
                this.aBt.Eu().Ex().aEt = new ArrayList<>();
            }
            int b = b(this.aBt.Eu().Ex().aEt, basicNameValuePair.getName());
            int size = this.aBt.Eu().Ex().aEt.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.aBt.Eu().Ex().aEt.get(b).getName())) {
                    this.aBt.Eu().Ex().aEt.set(b, basicNameValuePair);
                } else {
                    this.aBt.Eu().Ex().aEt.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.aBt.Eu().Ex().aEt.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> DF() {
        if (this.aBt != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aBt.Eu().Ex().aEy)) {
                linkedList.add(new BasicNameValuePair("sid", this.aBt.Eu().Ex().aEy));
            }
            if (!com.baidu.tbadk.p.al.jJ() && !TextUtils.isEmpty(this.aBt.Eu().Ex().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aBt.Eu().Ex().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
