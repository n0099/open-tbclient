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
import com.baidu.tbadk.core.util.ab;
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
/* loaded from: classes.dex */
public class z implements r {
    private static int dTS = 2097152;
    private final com.baidu.tbadk.core.util.a.a dTN;
    private com.baidu.adp.lib.network.a.a dTT = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public z(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.dTN = aVar;
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

    @Override // com.baidu.tbadk.core.util.r
    public void setCancel() {
        if (this.dTT != null) {
            this.dTT.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void cancelNetConnect() {
        this.dTT.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c ll;
        if (this.dTN != null && this.dTT != null && (ll = this.dTT.ll()) != null) {
            long kO = ll.kO();
            long kP = ll.kP();
            long kM = ll.kM();
            long kQ = ll.kQ();
            long kR = ll.kR();
            long j3 = kO - j;
            long j4 = kP - kO;
            int kS = ll.kS();
            long j5 = kQ - kP;
            long j6 = kM - kP;
            long j7 = kQ - kM;
            long j8 = kR - kQ;
            if (kR <= 0) {
                j8 = 0;
            }
            HashMap<String, String> aWY = this.dTN.aWY();
            aWY.put("startTime", String.valueOf(j));
            aWY.put("netConTime", String.valueOf(j3));
            aWY.put("netRWTime", String.valueOf(j5));
            aWY.put("firstByteReachTime", String.valueOf(j6));
            aWY.put("allDataReadTime", String.valueOf(j7));
            aWY.put("dataDeCompressTime", String.valueOf(j8));
            aWY.put("httpRetryNum", String.valueOf(kS));
            aWY.put("httpRetryCostTime", String.valueOf(j4));
            aWY.put("dataParseTime", String.valueOf(j2 - kR));
            aWY.put("isHttp", "1");
            aWY.put("httpSize", String.valueOf(i));
            aWY.put("errCode", String.valueOf(this.dTN.aWW().mNetErrorCode));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.r
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
            if (this.dTN.aWV().aWZ().mPostData != null && this.dTN.aWV().aWZ().mPostData.size() > 0 && !this.dTN.aWV().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dTN.aWV().aWZ().mUrl);
                if (this.dTN.aWV().aWZ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dTN.aWV().aWZ().mUrl.endsWith("?") && !this.dTN.aWV().aWZ().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dTN.aWV().aWZ().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dTN.aWV().aWZ().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ar.getUrlEncode(this.dTN.aWV().aWZ().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dTN.aWV().aWZ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dTN.aWV().aWZ().mRequestGzip || this.dTN.aWV().aWZ().mIsBDImage) && !this.dTN.aWV().mIsFromCDN) {
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
        if (this.dTT.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.dTT.a(str, z, 5, 100, -1, -1, aWx());
        com.baidu.adp.lib.network.http.e lm = this.dTT.lm();
        if (lm == null) {
            return null;
        }
        gVar = lm.kU();
        if (lm != null) {
            try {
                if (lm.kV() != null && (size = lm.kV().size()) > 0) {
                    this.dTN.aWX().dVs = lm.kV().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dTN.aWW().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -12;
                TiebaStatic.net(this.dTN);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -13;
                TiebaStatic.net(this.dTN);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.dTN.aWW().mNetErrorCode = gVar.responseCode;
        if (this.dTN.aWW().mNetErrorCode != 200) {
            this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dTN.aWX().dVs != null && !TextUtils.isEmpty(this.dTN.aWX().dVs.exception)) {
                this.dTN.aWW().mException = this.dTN.aWX().dVs.exception;
            } else {
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
            }
            TiebaStatic.net(this.dTN);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dTS) {
                    this.dTN.aWW().mNetErrorCode = -11;
                    TiebaStatic.net(this.dTN);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bgz().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dTN.aWV().aWZ().mUrl + "], size:" + i2);
                            this.dTN.aWW().mNetErrorCode = -16;
                            TiebaStatic.net(this.dTN);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ab.a aVar = new ab.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.dTN.aWX().dVs.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dTN.aWX().dVs.retry;
        aVar.mMethod = 2;
        ab.a(aVar);
        ab.mErrorNums.set(this.dTN.aWX().dVs.retry);
        TiebaStatic.net(this.dTN);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void wE(String str) {
        this.dTN.aWW().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dTN.aWW().mServerErrorCode = errorData.getError_code();
                if (this.dTN.aWW().mServerErrorCode == -1) {
                    this.dTN.aWW().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dTN.aWW().mServerErrorCode != 0) {
                    this.dTN.aWW().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dTN.aWW().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dTN.aWW().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dTN.aWV().aWZ().charSet = TextUtils.isEmpty(this.dTN.aWV().aWZ().charSet) ? "UTF-8" : this.dTN.aWV().aWZ().charSet;
            str = new String(netData, 0, netData.length, this.dTN.aWV().aWZ().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            wE(str);
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

    @Override // com.baidu.tbadk.core.util.r
    public String postNetData() {
        Throwable th;
        int i;
        long j;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1024);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (this.dTN.aWV().aWZ().mPostData == null || i3 >= this.dTN.aWV().aWZ().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dTN.aWV().aWZ().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.dTN.aWV().aWZ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.dTN.aWV().dTQ) {
                addPostData("sig", StringU.zD(sb.toString()));
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
        } catch (SocketException e6) {
            e4 = e6;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketTimeoutException e7) {
            e3 = e7;
            i = 0;
            j = 0;
            str = null;
        } catch (Exception e8) {
            e2 = e8;
            i = 0;
            j = 0;
            str = null;
        } catch (OutOfMemoryError e9) {
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
        if (this.dTT.isCanceled()) {
            return null;
        }
        if (this.dTT.a(this.dTN.aWV().aWZ().mUrl, this.dTN.aWV().aWZ().mPostData, this.dTN.aWV().aWZ().mRequestGzip, 5, -1, aWx()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e lm = this.dTT.lm();
        if (lm == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g kU = lm.kU();
        if (lm != null && lm.kV() != null && (size = lm.kV().size()) > 0) {
            this.dTN.aWX().dVs = lm.kV().get(size - 1);
        }
        this.dTN.aWW().mNetErrorCode = kU.responseCode;
        this.dTN.aWW().mHeader = kU.Lf;
        if (this.dTN.aWW().mNetErrorCode != 200) {
            if (this.dTN.aWX().dVs != null && !TextUtils.isEmpty(this.dTN.aWX().dVs.exception)) {
                this.dTN.aWW().mException = this.dTN.aWX().dVs.exception;
            } else {
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
            }
            TiebaStatic.net(this.dTN);
            return null;
        } else if (this.dTT.isCanceled()) {
            return null;
        } else {
            str = new String(kU.retBytes, "utf-8");
            try {
                if (this.dTN.aWV().aWZ().mIsBaiduServer && this.dTN.aWV().aWZ().mIsJson) {
                    wE(str);
                }
                i = kU.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                } catch (BdHttpCancelException e10) {
                    bdHttpCancelException = e10;
                    j = 0;
                    str2 = str;
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    j = 0;
                } catch (SocketException e12) {
                    e4 = e12;
                    j = 0;
                } catch (SocketTimeoutException e13) {
                    e3 = e13;
                    j = 0;
                } catch (Exception e14) {
                    e2 = e14;
                    j = 0;
                } catch (Throwable th3) {
                    th = th3;
                    j = 0;
                }
            } catch (BdHttpCancelException e15) {
                bdHttpCancelException = e15;
                i = 0;
                j = 0;
                str2 = str;
            } catch (OutOfMemoryError e16) {
                e = e16;
                i = 0;
                j = 0;
            } catch (SocketException e17) {
                e4 = e17;
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e18) {
                e3 = e18;
                i = 0;
                j = 0;
            } catch (Exception e19) {
                e2 = e19;
                i = 0;
                j = 0;
            } catch (Throwable th4) {
                th = th4;
                i = 0;
                j = 0;
            }
            try {
                ab.a aVar = new ab.a();
                aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                aVar.mSize = this.dTN.aWX().dVs.downloadSize;
                aVar.mTime = this.dTN.aWX().dVs.KE;
                aVar.mTimesNum = this.dTN.aWX().dVs.retry;
                aVar.mMethod = 1;
                ab.a(aVar);
                ab.mErrorNums.set(this.dTN.aWX().dVs.retry);
                TiebaStatic.net(this.dTN);
            } catch (BdHttpCancelException e20) {
                bdHttpCancelException = e20;
                str2 = str;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dTN.aWW().mNetErrorCode = -14;
                str = str2;
                a(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e21) {
                e = e21;
                this.dTN.aWW().mNetErrorCode = -15;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e22) {
                e4 = e22;
                this.dTN.aWW().mNetErrorCode = -12;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e4.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e23) {
                e3 = e23;
                this.dTN.aWW().mNetErrorCode = -13;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e3.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (Exception e24) {
                e2 = e24;
                this.dTN.aWW().mNetErrorCode = -10;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (Throwable th5) {
                th = th5;
                this.dTN.aWW().mNetErrorCode = -10;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(th.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            }
            a(currentTimeMillis, j, i);
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.r
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
        if (this.dTT.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.dTT.a(this.dTN.aWV().aWZ().mUrl, this.dTN.aWV().aWZ().mRequestGzip, this.dTN.aWV().aWZ().mPostData, this.dTN.aWV().aWZ().mFileData, 5, -1, aWx());
        this.dTN.aWW().mNetErrorCode = a.responseCode;
        this.dTN.aWW().mHeader = a.Lf;
        if (this.dTN.aWW().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e lm = this.dTT.lm();
            int i2 = 0;
            if (lm != null && lm.kV() != null) {
                i2 = lm.kV().size();
            }
            if (i2 <= 0 || (dVar = lm.kV().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.dTN.aWW().mException = str2;
            } else {
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
            }
            TiebaStatic.net(this.dTN);
            return null;
        } else if (this.dTT.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                wE(str);
                i = a.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                } catch (BdHttpCancelException e9) {
                    e3 = e9;
                    j = 0;
                } catch (OutOfMemoryError e10) {
                    e2 = e10;
                    j = 0;
                } catch (SocketException e11) {
                    j = 0;
                } catch (SocketTimeoutException e12) {
                    j = 0;
                } catch (Exception e13) {
                    e = e13;
                    j = 0;
                }
            } catch (BdHttpCancelException e14) {
                e3 = e14;
                i = 0;
                j = 0;
            } catch (OutOfMemoryError e15) {
                e2 = e15;
                i = 0;
                j = 0;
            } catch (SocketException e16) {
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e17) {
                i = 0;
                j = 0;
            } catch (Exception e18) {
                e = e18;
                i = 0;
                j = 0;
            }
            try {
                TiebaStatic.net(this.dTN);
            } catch (BdHttpCancelException e19) {
                e3 = e19;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                this.dTN.aWW().mNetErrorCode = -14;
                a(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e20) {
                e2 = e20;
                this.dTN.aWW().mNetErrorCode = -15;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e21) {
                this.dTN.aWW().mNetErrorCode = -12;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e22) {
                this.dTN.aWW().mNetErrorCode = -13;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            } catch (Exception e23) {
                e = e23;
                this.dTN.aWW().mNetErrorCode = -10;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                a(currentTimeMillis, j, i);
                return str;
            }
            a(currentTimeMillis, j, i);
            return str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [769=5, 770=5, 771=5, 772=5, 774=5, 776=5, 777=4, 757=5, 758=5, 759=5, 760=5, 761=5, 762=5, 763=5, 764=5, 765=5, 766=5, 767=5] */
    @Override // com.baidu.tbadk.core.util.r
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e lm;
        try {
            try {
                if (this.dTT.isCanceled()) {
                    return false;
                }
                z2 = this.dTT.a(this.dTN.aWV().aWZ().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aWx(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.z.1
                    int dTU = 0;
                    int dTV = 0;
                    int dTW = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.dTU = i5 / 50;
                        }
                        this.dTV += i4 - this.dTW;
                        this.dTW = i4;
                        if (handler != null) {
                            if (this.dTV > this.dTU || i4 == i5) {
                                this.dTV = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.dTN.aWV().Lb);
                try {
                    this.dTN.aWW().mNetErrorCode = this.dTT.lm().kU().responseCode;
                    com.baidu.adp.lib.network.http.e lm2 = this.dTT.lm();
                    if (lm2 != null && lm2.kV() != null && handler != null) {
                        int i4 = lm2.kU().mNetErrorCode;
                        int size = lm2.kV().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = lm2.kV().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.oa(this.dTN.aWW().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.yZ(dVar.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KK);
                            bVar.setUrl(dVar.url);
                            bVar.KQ = dVar.KQ;
                            bVar.KR = dVar.KR;
                            bVar.KS = dVar.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.dTN);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.dTN.aWW().mNetErrorCode = -10;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e lm3 = this.dTT.lm();
                    if (lm3 != null && lm3.kV() != null && handler != null) {
                        int i5 = lm3.kU().mNetErrorCode;
                        int size2 = lm3.kV().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = lm3.kV().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.oa(this.dTN.aWW().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.yZ(dVar2.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KK);
                            bVar2.setUrl(dVar2.url);
                            bVar2.KQ = dVar2.KQ;
                            bVar2.KR = dVar2.KR;
                            bVar2.KS = dVar2.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.dTN);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.dTN.aWW().mNetErrorCode = -15;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e lm4 = this.dTT.lm();
                    if (lm4 != null && lm4.kV() != null && handler != null) {
                        int i6 = lm4.kU().mNetErrorCode;
                        int size3 = lm4.kV().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = lm4.kV().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.oa(this.dTN.aWW().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.yZ(dVar3.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KK);
                            bVar3.setUrl(dVar3.url);
                            bVar3.KQ = dVar3.KQ;
                            bVar3.KR = dVar3.KR;
                            bVar3.KS = dVar3.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.dTN);
                    return z2;
                }
            } finally {
                lm = this.dTT.lm();
                if (lm != null && lm.kV() != null && handler != null) {
                    int i7 = lm.kU().mNetErrorCode;
                    int size4 = lm.kV().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = lm.kV().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.oa(this.dTN.aWW().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.yZ(dVar4.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KK);
                        bVar4.setUrl(dVar4.url);
                        bVar4.KQ = dVar4.KQ;
                        bVar4.KR = dVar4.KR;
                        bVar4.KS = dVar4.KS;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.dTN);
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        } catch (OutOfMemoryError e4) {
            e = e4;
            z2 = false;
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.dTN.aWV().aWZ().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dTN.aWV().aWZ().mPostData != null) {
            this.dTN.aWV().aWZ().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(String str, byte[] bArr) {
        if (this.dTN.aWV().aWZ().mFileData == null) {
            this.dTN.aWV().aWZ().mFileData = new HashMap<>();
        }
        this.dTN.aWV().aWZ().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dTN.aWV().aWZ().mPostData == null) {
                this.dTN.aWV().aWZ().mPostData = new ArrayList<>();
            }
            int c = c(this.dTN.aWV().aWZ().mPostData, basicNameValuePair.getName());
            int size = this.dTN.aWV().aWZ().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dTN.aWV().aWZ().mPostData.get(c).getName())) {
                    this.dTN.aWV().aWZ().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dTN.aWV().aWZ().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dTN.aWV().aWZ().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aWx() {
        if (this.dTN != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dTN.aWV().aWZ().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dTN.aWV().aWZ().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.dTN.aWV().aWZ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dTN.aWV().aWZ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
