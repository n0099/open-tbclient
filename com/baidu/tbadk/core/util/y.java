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
    private static int axw = 2097152;
    private final com.baidu.tbadk.core.util.a.a axq;
    private com.baidu.adp.lib.network.a.a axx = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Ce();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.axq = aVar;
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

    private void Ce() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jj() {
        if (this.axx != null) {
            this.axx.jj();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jg() {
        this.axx.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] BI() {
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
            if (this.axq.Dd().Dg().aAp != null && this.axq.Dd().Dg().aAp.size() > 0 && !this.axq.Dd().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.axq.Dd().Dg().mUrl);
                if (this.axq.Dd().Dg().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.axq.Dd().Dg().mUrl.endsWith("?") && !this.axq.Dd().Dg().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.axq.Dd().Dg().aAp.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.axq.Dd().Dg().aAp.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.axq.Dd().Dg().aAp.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.axq.Dd().Dg().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.axq.Dd().Dg().aAr || this.axq.Dd().Dg().mIsBDImage) && !this.axq.Dd().mIsFromCDN) {
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
        if (this.axx.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.axx.a(str, z, 5, 100, -1, -1, Co());
        com.baidu.adp.lib.network.http.e jx = this.axx.jx();
        if (jx == null) {
            return null;
        }
        gVar = jx.jq();
        if (jx != null) {
            try {
                if (jx.jr() != null && (size = jx.jr().size()) > 0) {
                    this.axq.Df().azV = jx.jr().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.axq.De().De = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.axq);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -12;
                TiebaStatic.net(this.axq);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -13;
                TiebaStatic.net(this.axq);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.axq);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.axq.De().De = gVar.responseCode;
        if (this.axq.De().De != 200) {
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.axq.Df().azV != null && !TextUtils.isEmpty(this.axq.Df().azV.CL)) {
                this.axq.De().azU = this.axq.Df().azV.CL;
            } else {
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
            }
            TiebaStatic.net(this.axq);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > axw) {
                    this.axq.De().De = -11;
                    TiebaStatic.net(this.axq);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mq().fM(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.axq.Dd().Dg().mUrl + "], size:" + i2);
                            this.axq.De().De = -16;
                            TiebaStatic.net(this.axq);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.lb());
        aVar.mSize = this.axq.Df().azV.CG;
        aVar.mTime = new Date().getTime() - j;
        aVar.axL = this.axq.Df().azV.CI;
        aVar.axK = 2;
        aa.a(aVar);
        aa.axJ.set(this.axq.Df().azV.CI);
        TiebaStatic.net(this.axq);
        bArr = gVar == null ? gVar.Dg : null;
        return bArr;
    }

    public void fi(String str) {
        this.axq.De().azT = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.axq.De().azT = errorData.getError_code();
                if (this.axq.De().azT == -1) {
                    this.axq.De().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.axq.De().azT != 0) {
                    this.axq.De().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.axq.De().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BJ() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BI = BI();
        if (BI == null || this.axq.De().De != 200) {
            return null;
        }
        try {
            this.axq.Dd().Dg().aAt = TextUtils.isEmpty(this.axq.Dd().Dg().aAt) ? "UTF-8" : this.axq.Dd().Dg().aAt;
            str = new String(BI, 0, BI.length, this.axq.Dd().Dg().aAt);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            fi(str);
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
    public String BH() {
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
            if (this.axq.Dd().Dg().aAp == null || i2 >= this.axq.Dd().Dg().aAp.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.axq.Dd().Dg().aAp.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.axq.Dd().Dg().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", com.baidu.adp.lib.util.s.bC(sb.toString()));
            if (this.axq.Dd().axt) {
                x("sig", StringU.iQ(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.axx.isCanceled()) {
                return null;
            }
            if (this.axx.a(this.axq.Dd().Dg().mUrl, this.axq.Dd().Dg().aAp, this.axq.Dd().Dg().aAr, 5, -1, Co()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jx = this.axx.jx();
            if (jx == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g jq = jx.jq();
            if (jx != null && jx.jr() != null && (size = jx.jr().size()) > 0) {
                this.axq.Df().azV = jx.jr().get(size - 1);
            }
            this.axq.De().De = jq.responseCode;
            this.axq.De().mHeader = jq.Df;
            if (this.axq.De().De != 200) {
                if (this.axq.Df().azV != null && !TextUtils.isEmpty(this.axq.Df().azV.CL)) {
                    this.axq.De().azU = this.axq.Df().azV.CL;
                } else {
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
                }
                TiebaStatic.net(this.axq);
                return null;
            } else if (this.axx.isCanceled()) {
                return null;
            } else {
                str = new String(jq.Dg, IoUtils.UTF_8);
                try {
                    if (this.axq.Dd().Dg().mIsBaiduServer && this.axq.Dd().Dg().aAs) {
                        fi(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.lb());
                    aVar.mSize = this.axq.Df().azV.CG;
                    aVar.mTime = this.axq.Df().azV.CJ;
                    aVar.axL = this.axq.Df().azV.CI;
                    aVar.axK = 1;
                    aa.a(aVar);
                    aa.axJ.set(this.axq.Df().azV.CI);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.axq.De().De = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.axq.De().De = -12;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.axq.De().De = -13;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.axq.De().De = -15;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.axq);
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
    public String BK() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.axx.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.axx.a(this.axq.Dd().Dg().mUrl, this.axq.Dd().Dg().aAr, this.axq.Dd().Dg().aAp, this.axq.Dd().Dg().aAq, 5, -1, Co());
            this.axq.De().De = a.responseCode;
            this.axq.De().mHeader = a.Df;
            if (this.axq.De().De != 200) {
                com.baidu.adp.lib.network.http.e jx = this.axx.jx();
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
                    this.axq.De().azU = str2;
                } else {
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
                }
                TiebaStatic.net(this.axq);
                return null;
            } else if (this.axx.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Dg, "UTF-8");
                try {
                    fi(str);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.axq.De().De = -14;
                    return str;
                } catch (SocketException e5) {
                    this.axq.De().De = -12;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.axq.De().De = -13;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.axq.De().De = -15;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.axq);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [703=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.axx.isCanceled()) {
                return false;
            }
            return this.axx.a(this.axq.Dd().Dg().mUrl, (z ? new File(str) : l.eK(str)).getAbsolutePath(), false, i2, i3, -1, -1, Co(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int axy = 0;
                int axz = 0;
                int axA = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.axy = i5 / 50;
                    }
                    this.axz += i4 - this.axA;
                    this.axA = i4;
                    if (handler != null) {
                        if (this.axz > this.axy || i4 == i5) {
                            this.axz = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.axq.De().De = -10;
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.axq.De().De = -15;
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.axq);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> BG() {
        return this.axq.Dd().Dg().aAp;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.axq.Dd().Dg().aAp != null) {
            this.axq.Dd().Dg().aAp.clear();
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
        if (this.axq.Dd().Dg().aAq == null) {
            this.axq.Dd().Dg().aAq = new HashMap<>();
        }
        this.axq.Dd().Dg().aAq.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.axq.Dd().Dg().aAp == null) {
                this.axq.Dd().Dg().aAp = new ArrayList<>();
            }
            int b = b(this.axq.Dd().Dg().aAp, basicNameValuePair.getName());
            int size = this.axq.Dd().Dg().aAp.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.axq.Dd().Dg().aAp.get(b).getName())) {
                    this.axq.Dd().Dg().aAp.set(b, basicNameValuePair);
                } else {
                    this.axq.Dd().Dg().aAp.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.axq.Dd().Dg().aAp.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> Co() {
        if (this.axq != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.axq.Dd().Dg().aAu)) {
                linkedList.add(new BasicNameValuePair("sid", this.axq.Dd().Dg().aAu));
            }
            if (!com.baidu.tbadk.p.al.jJ() && !TextUtils.isEmpty(this.axq.Dd().Dg().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.axq.Dd().Dg().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
