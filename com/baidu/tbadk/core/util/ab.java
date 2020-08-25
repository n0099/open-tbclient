package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ab implements s {
    private static int ejT = 2097152;
    private final com.baidu.tbadk.core.util.a.a ejO;
    private com.baidu.adp.lib.network.a.a ejU = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.ejO = aVar;
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

    private void initNetWork() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.ejU != null) {
            this.ejU.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.ejU.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mK;
        if (this.ejO != null && this.ejU != null && (mK = this.ejU.mK()) != null) {
            long mn = mK.mn();
            long mo = mK.mo();
            long ml = mK.ml();
            long mp = mK.mp();
            long mq = mK.mq();
            long j3 = mn - j;
            long j4 = mo - mn;
            int mr = mK.mr();
            long j5 = mp - mo;
            long j6 = ml - mo;
            long j7 = mp - ml;
            long j8 = mq - mp;
            if (mq <= 0) {
                j8 = 0;
            }
            HashMap<String, String> bjy = this.ejO.bjy();
            bjy.put("startTime", String.valueOf(j));
            bjy.put("netConTime", String.valueOf(j3));
            bjy.put("netRWTime", String.valueOf(j5));
            bjy.put("firstByteReachTime", String.valueOf(j6));
            bjy.put("allDataReadTime", String.valueOf(j7));
            bjy.put("dataDeCompressTime", String.valueOf(j8));
            bjy.put("httpRetryNum", String.valueOf(mr));
            bjy.put("httpRetryCostTime", String.valueOf(j4));
            bjy.put("dataParseTime", String.valueOf(j2 - mq));
            bjy.put("isHttp", "1");
            bjy.put("httpSize", String.valueOf(i));
            bjy.put("errCode", String.valueOf(this.ejO.bjw().mNetErrorCode));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
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
            if (this.ejO.bjv().bjz().mPostData != null && this.ejO.bjv().bjz().mPostData.size() > 0 && !this.ejO.bjv().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ejO.bjv().bjz().mUrl);
                if (this.ejO.bjv().bjz().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ejO.bjv().bjz().mUrl.endsWith("?") && !this.ejO.bjv().bjz().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.ejO.bjv().bjz().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.ejO.bjv().bjz().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.ejO.bjv().bjz().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ejO.bjv().bjz().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.ejO.bjv().bjz().mRequestGzip || this.ejO.bjv().bjz().mIsBDImage) && !this.ejO.bjv().mIsFromCDN) {
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
        if (this.ejU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ejU.a(str, z, 5, 100, -1, -1, biT());
        com.baidu.adp.lib.network.http.e mL = this.ejU.mL();
        if (mL == null) {
            return null;
        }
        gVar = mL.mt();
        if (mL != null) {
            try {
                if (mL.mu() != null && (size = mL.mu().size()) > 0) {
                    this.ejO.bjx().elw = mL.mu().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ejO.bjw().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw != null ? this.ejO.bjx().elw.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ejO.bjw().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ejO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw != null ? this.ejO.bjx().elw.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ejO.bjw().mNetErrorCode = -12;
                TiebaStatic.net(this.ejO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw != null ? this.ejO.bjx().elw.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ejO.bjw().mNetErrorCode = -13;
                TiebaStatic.net(this.ejO);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw != null ? this.ejO.bjx().elw.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ejO.bjw().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ejO);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ejO.bjw().mNetErrorCode = gVar.responseCode;
        if (this.ejO.bjw().mNetErrorCode != 200) {
            this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.ejO.bjx().elw != null && !TextUtils.isEmpty(this.ejO.bjx().elw.exception)) {
                this.ejO.bjw().mException = this.ejO.bjx().elw.exception;
            } else {
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry);
            }
            TiebaStatic.net(this.ejO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ejT) {
                    this.ejO.bjw().mNetErrorCode = -11;
                    TiebaStatic.net(this.ejO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bsW().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ejO.bjv().bjz().mUrl + "], size:" + i2);
                            this.ejO.bjw().mNetErrorCode = -16;
                            TiebaStatic.net(this.ejO);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.ejO.bjx().elw.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.ejO.bjx().elw.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.ejO.bjx().elw.retry);
        TiebaStatic.net(this.ejO);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void Aa(String str) {
        this.ejO.bjw().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ejO.bjw().mServerErrorCode = errorData.getError_code();
                if (this.ejO.bjw().mServerErrorCode == -1) {
                    this.ejO.bjw().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.ejO.bjw().mServerErrorCode != 0) {
                    this.ejO.bjw().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ejO.bjw().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.ejO.bjw().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.ejO.bjv().bjz().charSet = TextUtils.isEmpty(this.ejO.bjv().bjz().charSet) ? "UTF-8" : this.ejO.bjv().bjz().charSet;
            str = new String(netData, 0, netData.length, this.ejO.bjv().bjz().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            Aa(str);
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

    @Override // com.baidu.tbadk.core.util.s
    public String postNetData() {
        Throwable th;
        int i;
        long j;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1024);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (this.ejO.bjv().bjz().mPostData == null || i3 >= this.ejO.bjv().bjz().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ejO.bjv().bjz().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.ejO.bjv().bjz().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.ejO.bjv().ejR) {
                addPostData("sig", StringU.Df(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
        } catch (BdHttpCancelException e5) {
            bdHttpCancelException = e5;
            i = 0;
            j = 0;
            str2 = null;
        } catch (OutOfMemoryError e6) {
            e4 = e6;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketException e7) {
            e3 = e7;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketTimeoutException e8) {
            e2 = e8;
            i = 0;
            j = 0;
            str = null;
        } catch (Exception e9) {
            e = e9;
            i = 0;
            j = 0;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
            j = 0;
            str = null;
        }
        if (this.ejU.isCanceled()) {
            return null;
        }
        if (this.ejU.a(this.ejO.bjv().bjz().mUrl, this.ejO.bjv().bjz().mPostData, this.ejO.bjv().bjz().mRequestGzip, 5, -1, biT()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mL = this.ejU.mL();
        if (mL == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g mt = mL.mt();
        if (mL != null && mL.mu() != null && (size = mL.mu().size()) > 0) {
            this.ejO.bjx().elw = mL.mu().get(size - 1);
        }
        this.ejO.bjw().mNetErrorCode = mt.responseCode;
        this.ejO.bjw().mHeader = mt.LK;
        if (this.ejO.bjw().mNetErrorCode != 200) {
            if (this.ejO.bjx().elw != null && !TextUtils.isEmpty(this.ejO.bjx().elw.exception)) {
                this.ejO.bjw().mException = this.ejO.bjx().elw.exception;
            } else {
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry);
            }
            TiebaStatic.net(this.ejO);
            return null;
        } else if (this.ejU.isCanceled()) {
            return null;
        } else {
            str = new String(mt.retBytes, "utf-8");
            try {
                if (this.ejO.bjv().bjz().mIsBaiduServer && this.ejO.bjv().bjz().mIsJson) {
                    Aa(str);
                }
                i = mt.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.ejO.bjx().elw.downloadSize;
                        aVar.mTime = this.ejO.bjx().elw.Lh;
                        aVar.mTimesNum = this.ejO.bjx().elw.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.ejO.bjx().elw.retry);
                        TiebaStatic.net(this.ejO);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.ejO.bjw().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.ejO.bjw().mNetErrorCode = -15;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.ejO.bjw().mNetErrorCode = -12;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.ejO.bjw().mNetErrorCode = -13;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.ejO.bjw().mNetErrorCode = -10;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.ejO.bjw().mNetErrorCode = -10;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    }
                } catch (BdHttpCancelException e15) {
                    bdHttpCancelException = e15;
                    j = 0;
                    str2 = str;
                } catch (OutOfMemoryError e16) {
                    e4 = e16;
                    j = 0;
                } catch (SocketException e17) {
                    e3 = e17;
                    j = 0;
                } catch (SocketTimeoutException e18) {
                    e2 = e18;
                    j = 0;
                } catch (Exception e19) {
                    e = e19;
                    j = 0;
                } catch (Throwable th4) {
                    th = th4;
                    j = 0;
                }
            } catch (BdHttpCancelException e20) {
                bdHttpCancelException = e20;
                i = 0;
                j = 0;
                str2 = str;
            } catch (OutOfMemoryError e21) {
                e4 = e21;
                i = 0;
                j = 0;
            } catch (SocketException e22) {
                e3 = e22;
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e23) {
                e2 = e23;
                i = 0;
                j = 0;
            } catch (Exception e24) {
                e = e24;
                i = 0;
                j = 0;
            } catch (Throwable th5) {
                th = th5;
                i = 0;
                j = 0;
            }
            a(currentTimeMillis, j, i);
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String postMultiNetData() {
        Exception e;
        int i;
        long j;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (BdHttpCancelException e4) {
            e3 = e4;
            i = 0;
            j = 0;
            str = null;
        } catch (OutOfMemoryError e5) {
            e2 = e5;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketException e6) {
            i = 0;
            j = 0;
            str = null;
        } catch (SocketTimeoutException e7) {
            i = 0;
            j = 0;
            str = null;
        } catch (Exception e8) {
            e = e8;
            i = 0;
            j = 0;
            str = null;
        }
        if (this.ejU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.ejU.a(this.ejO.bjv().bjz().mUrl, this.ejO.bjv().bjz().mRequestGzip, this.ejO.bjv().bjz().mPostData, this.ejO.bjv().bjz().mFileData, 5, -1, biT());
        this.ejO.bjw().mNetErrorCode = a.responseCode;
        this.ejO.bjw().mHeader = a.LK;
        if (this.ejO.bjw().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mL = this.ejU.mL();
            int i2 = 0;
            if (mL != null && mL.mu() != null) {
                i2 = mL.mu().size();
            }
            if (i2 <= 0 || (dVar = mL.mu().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.ejO.bjw().mException = str2;
            } else {
                this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry);
            }
            TiebaStatic.net(this.ejO);
            return null;
        } else if (this.ejU.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                Aa(str);
                i = a.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.ejO);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.ejO.bjw().mException = String.valueOf(this.ejO.bjw().mNetErrorCode) + "|retryCount:" + (this.ejO.bjx().elw == null ? -1 : this.ejO.bjx().elw.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ejO.bjw().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.ejO.bjw().mNetErrorCode = -15;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.ejO.bjw().mNetErrorCode = -12;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.ejO.bjw().mNetErrorCode = -13;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.ejO.bjw().mNetErrorCode = -10;
                        this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ejO);
                        a(currentTimeMillis, j, i);
                        return str;
                    }
                } catch (BdHttpCancelException e14) {
                    e3 = e14;
                    j = 0;
                } catch (OutOfMemoryError e15) {
                    e2 = e15;
                    j = 0;
                } catch (SocketException e16) {
                    j = 0;
                } catch (SocketTimeoutException e17) {
                    j = 0;
                } catch (Exception e18) {
                    e = e18;
                    j = 0;
                }
            } catch (BdHttpCancelException e19) {
                e3 = e19;
                i = 0;
                j = 0;
            } catch (OutOfMemoryError e20) {
                e2 = e20;
                i = 0;
                j = 0;
            } catch (SocketException e21) {
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e22) {
                i = 0;
                j = 0;
            } catch (Exception e23) {
                e = e23;
                i = 0;
                j = 0;
            }
            a(currentTimeMillis, j, i);
            return str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [769=5, 770=5, 771=5, 772=5, 774=5, 776=5, 777=4, 757=5, 758=5, 759=5, 760=5, 761=5, 762=5, 763=5, 764=5, 765=5, 766=5, 767=5] */
    @Override // com.baidu.tbadk.core.util.s
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e mL;
        try {
            try {
                if (this.ejU.isCanceled()) {
                    return false;
                }
                z2 = this.ejU.a(this.ejO.bjv().bjz().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, biT(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int ejV = 0;
                    int ejW = 0;
                    int ejX = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.ejV = i5 / 50;
                        }
                        this.ejW += i4 - this.ejX;
                        this.ejX = i4;
                        if (handler != null) {
                            if (this.ejW > this.ejV || i4 == i5) {
                                this.ejW = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.ejO.bjv().LG);
                try {
                    this.ejO.bjw().mNetErrorCode = this.ejU.mL().mt().responseCode;
                    com.baidu.adp.lib.network.http.e mL2 = this.ejU.mL();
                    if (mL2 != null && mL2.mu() != null && handler != null) {
                        int i4 = mL2.mt().mNetErrorCode;
                        int size = mL2.mu().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mL2.mu().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.qD(this.ejO.bjw().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Cw(dVar.Lp + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Ll + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lm + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Ln);
                            bVar.setUrl(dVar.url);
                            bVar.Lt = dVar.Lt;
                            bVar.Lu = dVar.Lu;
                            bVar.Lv = dVar.Lv;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.ejO);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.ejO.bjw().mNetErrorCode = -10;
                    this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mL3 = this.ejU.mL();
                    if (mL3 != null && mL3.mu() != null && handler != null) {
                        int i5 = mL3.mt().mNetErrorCode;
                        int size2 = mL3.mu().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mL3.mu().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.qD(this.ejO.bjw().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Cw(dVar2.Lp + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Ll + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lm + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Ln);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Lt = dVar2.Lt;
                            bVar2.Lu = dVar2.Lu;
                            bVar2.Lv = dVar2.Lv;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.ejO);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.ejO.bjw().mNetErrorCode = -15;
                    this.ejO.bjw().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mL4 = this.ejU.mL();
                    if (mL4 != null && mL4.mu() != null && handler != null) {
                        int i6 = mL4.mt().mNetErrorCode;
                        int size3 = mL4.mu().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mL4.mu().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.qD(this.ejO.bjw().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Cw(dVar3.Lp + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Ll + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lm + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Ln);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Lt = dVar3.Lt;
                            bVar3.Lu = dVar3.Lu;
                            bVar3.Lv = dVar3.Lv;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.ejO);
                    return z2;
                }
            } finally {
                mL = this.ejU.mL();
                if (mL != null && mL.mu() != null && handler != null) {
                    int i7 = mL.mt().mNetErrorCode;
                    int size4 = mL.mu().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mL.mu().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.qD(this.ejO.bjw().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Cw(dVar4.Lp + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Ll + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lm + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Ln);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Lt = dVar4.Lt;
                        bVar4.Lu = dVar4.Lu;
                        bVar4.Lv = dVar4.Lv;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.ejO);
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        } catch (OutOfMemoryError e4) {
            e = e4;
            z2 = false;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.ejO.bjv().bjz().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ejO.bjv().bjz().mPostData != null) {
            this.ejO.bjv().bjz().mPostData.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                addPostData(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, byte[] bArr) {
        if (this.ejO.bjv().bjz().mFileData == null) {
            this.ejO.bjv().bjz().mFileData = new HashMap<>();
        }
        this.ejO.bjv().bjz().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ejO.bjv().bjz().mPostData == null) {
                this.ejO.bjv().bjz().mPostData = new ArrayList<>();
            }
            int c = c(this.ejO.bjv().bjz().mPostData, basicNameValuePair.getName());
            int size = this.ejO.bjv().bjz().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.ejO.bjv().bjz().mPostData.get(c).getName())) {
                    this.ejO.bjv().bjz().mPostData.set(c, basicNameValuePair);
                } else {
                    this.ejO.bjv().bjz().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.ejO.bjv().bjz().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> biT() {
        if (this.ejO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ejO.bjv().bjz().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.ejO.bjv().bjz().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.ejO.bjv().bjz().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ejO.bjv().bjz().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
