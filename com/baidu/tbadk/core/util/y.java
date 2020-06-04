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
import com.baidu.tbadk.core.util.aa;
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
public class y implements q {
    private static int dNc = 2097152;
    private final com.baidu.tbadk.core.util.a.a dMX;
    private com.baidu.adp.lib.network.a.a dNd = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.dMX = aVar;
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

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.dNd != null) {
            this.dNd.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.dNd.cancel();
    }

    private void b(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c kV;
        if (this.dMX != null && this.dNd != null && (kV = this.dNd.kV()) != null) {
            long ky = kV.ky();
            long kz = kV.kz();
            long kw = kV.kw();
            long kA = kV.kA();
            long kB = kV.kB();
            long j3 = ky - j;
            long j4 = kz - ky;
            int kC = kV.kC();
            long j5 = kA - kz;
            long j6 = kw - kz;
            long j7 = kA - kw;
            long j8 = kB - kA;
            if (kB <= 0) {
                j8 = 0;
            }
            HashMap<String, String> aVe = this.dMX.aVe();
            aVe.put("startTime", String.valueOf(j));
            aVe.put("netConTime", String.valueOf(j3));
            aVe.put("netRWTime", String.valueOf(j5));
            aVe.put("firstByteReachTime", String.valueOf(j6));
            aVe.put("allDataReadTime", String.valueOf(j7));
            aVe.put("dataDeCompressTime", String.valueOf(j8));
            aVe.put("httpRetryNum", String.valueOf(kC));
            aVe.put("httpRetryCostTime", String.valueOf(j4));
            aVe.put("dataParseTime", String.valueOf(j2 - kB));
            aVe.put("isHttp", "1");
            aVe.put("httpSize", String.valueOf(i));
            aVe.put("errCode", String.valueOf(this.dMX.aVc().mNetErrorCode));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
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
            if (this.dMX.aVb().aVf().mPostData != null && this.dMX.aVb().aVf().mPostData.size() > 0 && !this.dMX.aVb().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dMX.aVb().aVf().mUrl);
                if (this.dMX.aVb().aVf().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dMX.aVb().aVf().mUrl.endsWith("?") && !this.dMX.aVb().aVf().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dMX.aVb().aVf().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dMX.aVb().aVf().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.dMX.aVb().aVf().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dMX.aVb().aVf().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dMX.aVb().aVf().mRequestGzip || this.dMX.aVb().aVf().mIsBDImage) && !this.dMX.aVb().mIsFromCDN) {
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
        if (this.dNd.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.dNd.a(str, z, 5, 100, -1, -1, aUD());
        com.baidu.adp.lib.network.http.e kW = this.dNd.kW();
        if (kW == null) {
            return null;
        }
        gVar = kW.kE();
        if (kW != null) {
            try {
                if (kW.kF() != null && (size = kW.kF().size()) > 0) {
                    this.dMX.aVd().dOA = kW.kF().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dMX.aVc().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA != null ? this.dMX.aVd().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVc().mNetErrorCode = -12;
                TiebaStatic.net(this.dMX);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA != null ? this.dMX.aVd().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVc().mNetErrorCode = -13;
                TiebaStatic.net(this.dMX);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA != null ? this.dMX.aVd().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVc().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA != null ? this.dMX.aVd().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVc().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.dMX.aVc().mNetErrorCode = gVar.responseCode;
        if (this.dMX.aVc().mNetErrorCode != 200) {
            this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dMX.aVd().dOA != null && !TextUtils.isEmpty(this.dMX.aVd().dOA.exception)) {
                this.dMX.aVc().mException = this.dMX.aVd().dOA.exception;
            } else {
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry);
            }
            TiebaStatic.net(this.dMX);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dNc) {
                    this.dMX.aVc().mNetErrorCode = -11;
                    TiebaStatic.net(this.dMX);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.beu().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dMX.aVb().aVf().mUrl + "], size:" + i2);
                            this.dMX.aVc().mNetErrorCode = -16;
                            TiebaStatic.net(this.dMX);
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
        aVar.mSize = this.dMX.aVd().dOA.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dMX.aVd().dOA.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.dMX.aVd().dOA.retry);
        TiebaStatic.net(this.dMX);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void wo(String str) {
        this.dMX.aVc().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dMX.aVc().mServerErrorCode = errorData.getError_code();
                if (this.dMX.aVc().mServerErrorCode == -1) {
                    this.dMX.aVc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dMX.aVc().mServerErrorCode != 0) {
                    this.dMX.aVc().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dMX.aVc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dMX.aVc().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dMX.aVb().aVf().charSet = TextUtils.isEmpty(this.dMX.aVb().aVf().charSet) ? "UTF-8" : this.dMX.aVb().aVf().charSet;
            str = new String(netData, 0, netData.length, this.dMX.aVb().aVf().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            wo(str);
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
            if (this.dMX.aVb().aVf().mPostData == null || i3 >= this.dMX.aVb().aVf().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dMX.aVb().aVf().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.dMX.aVb().aVf().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.dMX.aVb().dNa) {
                addPostData("sig", StringU.zk(sb.toString()));
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
        if (this.dNd.isCanceled()) {
            return null;
        }
        if (this.dNd.a(this.dMX.aVb().aVf().mUrl, this.dMX.aVb().aVf().mPostData, this.dMX.aVb().aVf().mRequestGzip, 5, -1, aUD()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e kW = this.dNd.kW();
        if (kW == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g kE = kW.kE();
        if (kW != null && kW.kF() != null && (size = kW.kF().size()) > 0) {
            this.dMX.aVd().dOA = kW.kF().get(size - 1);
        }
        this.dMX.aVc().mNetErrorCode = kE.responseCode;
        this.dMX.aVc().mHeader = kE.KF;
        if (this.dMX.aVc().mNetErrorCode != 200) {
            if (this.dMX.aVd().dOA != null && !TextUtils.isEmpty(this.dMX.aVd().dOA.exception)) {
                this.dMX.aVc().mException = this.dMX.aVd().dOA.exception;
            } else {
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry);
            }
            TiebaStatic.net(this.dMX);
            return null;
        } else if (this.dNd.isCanceled()) {
            return null;
        } else {
            str = new String(kE.retBytes, "utf-8");
            try {
                if (this.dMX.aVb().aVf().mIsBaiduServer && this.dMX.aVb().aVf().mIsJson) {
                    wo(str);
                }
                i = kE.retBytes.length;
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
                aa.a aVar = new aa.a();
                aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                aVar.mSize = this.dMX.aVd().dOA.downloadSize;
                aVar.mTime = this.dMX.aVd().dOA.Kd;
                aVar.mTimesNum = this.dMX.aVd().dOA.retry;
                aVar.mMethod = 1;
                aa.a(aVar);
                aa.mErrorNums.set(this.dMX.aVd().dOA.retry);
                TiebaStatic.net(this.dMX);
            } catch (BdHttpCancelException e20) {
                bdHttpCancelException = e20;
                str2 = str;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dMX.aVc().mNetErrorCode = -14;
                str = str2;
                b(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e21) {
                e = e21;
                this.dMX.aVc().mNetErrorCode = -15;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e22) {
                e4 = e22;
                this.dMX.aVc().mNetErrorCode = -12;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e4.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e23) {
                e3 = e23;
                this.dMX.aVc().mNetErrorCode = -13;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e3.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (Exception e24) {
                e2 = e24;
                this.dMX.aVc().mNetErrorCode = -10;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (Throwable th5) {
                th = th5;
                this.dMX.aVc().mNetErrorCode = -10;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(th.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            }
            b(currentTimeMillis, j, i);
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
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
        if (this.dNd.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.dNd.a(this.dMX.aVb().aVf().mUrl, this.dMX.aVb().aVf().mRequestGzip, this.dMX.aVb().aVf().mPostData, this.dMX.aVb().aVf().mFileData, 5, -1, aUD());
        this.dMX.aVc().mNetErrorCode = a.responseCode;
        this.dMX.aVc().mHeader = a.KF;
        if (this.dMX.aVc().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e kW = this.dNd.kW();
            int i2 = 0;
            if (kW != null && kW.kF() != null) {
                i2 = kW.kF().size();
            }
            if (i2 <= 0 || (dVar = kW.kF().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.dMX.aVc().mException = str2;
            } else {
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry);
            }
            TiebaStatic.net(this.dMX);
            return null;
        } else if (this.dNd.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                wo(str);
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
                TiebaStatic.net(this.dMX);
            } catch (BdHttpCancelException e19) {
                e3 = e19;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVc().mException = String.valueOf(this.dMX.aVc().mNetErrorCode) + "|retryCount:" + (this.dMX.aVd().dOA == null ? -1 : this.dMX.aVd().dOA.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                this.dMX.aVc().mNetErrorCode = -14;
                b(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e20) {
                e2 = e20;
                this.dMX.aVc().mNetErrorCode = -15;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e21) {
                this.dMX.aVc().mNetErrorCode = -12;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e22) {
                this.dMX.aVc().mNetErrorCode = -13;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            } catch (Exception e23) {
                e = e23;
                this.dMX.aVc().mNetErrorCode = -10;
                this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                b(currentTimeMillis, j, i);
                return str;
            }
            b(currentTimeMillis, j, i);
            return str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [769=5, 770=5, 771=5, 772=5, 774=5, 776=5, 777=4, 757=5, 758=5, 759=5, 760=5, 761=5, 762=5, 763=5, 764=5, 765=5, 766=5, 767=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e kW;
        try {
            try {
                if (this.dNd.isCanceled()) {
                    return false;
                }
                z2 = this.dNd.a(this.dMX.aVb().aVf().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aUD(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int dNe = 0;
                    int dNf = 0;
                    int dNg = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.dNe = i5 / 50;
                        }
                        this.dNf += i4 - this.dNg;
                        this.dNg = i4;
                        if (handler != null) {
                            if (this.dNf > this.dNe || i4 == i5) {
                                this.dNf = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.dMX.aVb().KA);
                try {
                    this.dMX.aVc().mNetErrorCode = this.dNd.kW().kE().responseCode;
                    com.baidu.adp.lib.network.http.e kW2 = this.dNd.kW();
                    if (kW2 != null && kW2.kF() != null && handler != null) {
                        int i4 = kW2.kE().mNetErrorCode;
                        int size = kW2.kF().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = kW2.kF().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.nF(this.dMX.aVc().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.yG(dVar.Kl + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.JQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Kh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Ki + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Kj);
                            bVar.setUrl(dVar.url);
                            bVar.Kp = dVar.Kp;
                            bVar.Kq = dVar.Kq;
                            bVar.Kr = dVar.Kr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.dMX);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.dMX.aVc().mNetErrorCode = -10;
                    this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e kW3 = this.dNd.kW();
                    if (kW3 != null && kW3.kF() != null && handler != null) {
                        int i5 = kW3.kE().mNetErrorCode;
                        int size2 = kW3.kF().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = kW3.kF().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.nF(this.dMX.aVc().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.yG(dVar2.Kl + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.JQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Kh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Ki + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Kj);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Kp = dVar2.Kp;
                            bVar2.Kq = dVar2.Kq;
                            bVar2.Kr = dVar2.Kr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.dMX);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.dMX.aVc().mNetErrorCode = -15;
                    this.dMX.aVc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e kW4 = this.dNd.kW();
                    if (kW4 != null && kW4.kF() != null && handler != null) {
                        int i6 = kW4.kE().mNetErrorCode;
                        int size3 = kW4.kF().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = kW4.kF().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.nF(this.dMX.aVc().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.yG(dVar3.Kl + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.JQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Kh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Ki + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Kj);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Kp = dVar3.Kp;
                            bVar3.Kq = dVar3.Kq;
                            bVar3.Kr = dVar3.Kr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.dMX);
                    return z2;
                }
            } finally {
                kW = this.dNd.kW();
                if (kW != null && kW.kF() != null && handler != null) {
                    int i7 = kW.kE().mNetErrorCode;
                    int size4 = kW.kF().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = kW.kF().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.nF(this.dMX.aVc().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.yG(dVar4.Kl + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.JQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Kh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Ki + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Kj);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Kp = dVar4.Kp;
                        bVar4.Kq = dVar4.Kq;
                        bVar4.Kr = dVar4.Kr;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.dMX);
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        } catch (OutOfMemoryError e4) {
            e = e4;
            z2 = false;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.dMX.aVb().aVf().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dMX.aVb().aVf().mPostData != null) {
            this.dMX.aVb().aVf().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, byte[] bArr) {
        if (this.dMX.aVb().aVf().mFileData == null) {
            this.dMX.aVb().aVf().mFileData = new HashMap<>();
        }
        this.dMX.aVb().aVf().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dMX.aVb().aVf().mPostData == null) {
                this.dMX.aVb().aVf().mPostData = new ArrayList<>();
            }
            int c = c(this.dMX.aVb().aVf().mPostData, basicNameValuePair.getName());
            int size = this.dMX.aVb().aVf().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dMX.aVb().aVf().mPostData.get(c).getName())) {
                    this.dMX.aVb().aVf().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dMX.aVb().aVf().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dMX.aVb().aVf().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aUD() {
        if (this.dMX != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dMX.aVb().aVf().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dMX.aVb().aVf().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.dMX.aVb().aVf().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dMX.aVb().aVf().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
