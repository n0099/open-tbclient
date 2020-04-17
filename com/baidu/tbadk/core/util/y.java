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
    private static int dyT = 2097152;
    private final com.baidu.tbadk.core.util.a.a dyO;
    private com.baidu.adp.lib.network.a.a dyU = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.dyO = aVar;
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
        if (this.dyU != null) {
            this.dyU.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.dyU.cancel();
    }

    private void d(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c kT;
        if (this.dyO != null && this.dyU != null && (kT = this.dyU.kT()) != null) {
            long kw = kT.kw();
            long kx = kT.kx();
            long ku = kT.ku();
            long ky = kT.ky();
            long kz = kT.kz();
            long j3 = kw - j;
            long j4 = kx - kw;
            int kA = kT.kA();
            long j5 = ky - kx;
            long j6 = ku - kx;
            long j7 = ky - ku;
            long j8 = kz - ky;
            if (kz <= 0) {
                j8 = 0;
            }
            HashMap<String, String> aPc = this.dyO.aPc();
            aPc.put("netConTime", String.valueOf(j3));
            aPc.put("netRWTime", String.valueOf(j5));
            aPc.put("firstByteReachTime", String.valueOf(j6));
            aPc.put("allDataReadTime", String.valueOf(j7));
            aPc.put("dataDeCompressTime", String.valueOf(j8));
            aPc.put("httpRetryNum", String.valueOf(kA));
            aPc.put("httpRetryCostTime", String.valueOf(j4));
            aPc.put("dataParseTime", String.valueOf(j2 - kz));
            aPc.put("isHttp", "1");
            aPc.put("httpSize", String.valueOf(i));
            aPc.put("errCode", String.valueOf(this.dyO.aPa().mNetErrorCode));
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
            if (this.dyO.aOZ().aPd().mPostData != null && this.dyO.aOZ().aPd().mPostData.size() > 0 && !this.dyO.aOZ().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dyO.aOZ().aPd().mUrl);
                if (this.dyO.aOZ().aPd().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dyO.aOZ().aPd().mUrl.endsWith("?") && !this.dyO.aOZ().aPd().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dyO.aOZ().aPd().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dyO.aOZ().aPd().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.dyO.aOZ().aPd().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dyO.aOZ().aPd().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dyO.aOZ().aPd().mRequestGzip || this.dyO.aOZ().aPd().mIsBDImage) && !this.dyO.aOZ().mIsFromCDN) {
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
        if (this.dyU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.dyU.a(str, z, 5, 100, -1, -1, aOB());
        com.baidu.adp.lib.network.http.e kU = this.dyU.kU();
        if (kU == null) {
            return null;
        }
        gVar = kU.kC();
        if (kU != null) {
            try {
                if (kU.kD() != null && (size = kU.kD().size()) > 0) {
                    this.dyO.aPb().dAq = kU.kD().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dyO.aPa().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -12;
                TiebaStatic.net(this.dyO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -13;
                TiebaStatic.net(this.dyO);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.dyO.aPa().mNetErrorCode = gVar.responseCode;
        if (this.dyO.aPa().mNetErrorCode != 200) {
            this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dyO.aPb().dAq != null && !TextUtils.isEmpty(this.dyO.aPb().dAq.exception)) {
                this.dyO.aPa().mException = this.dyO.aPb().dAq.exception;
            } else {
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
            }
            TiebaStatic.net(this.dyO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dyT) {
                    this.dyO.aPa().mNetErrorCode = -11;
                    TiebaStatic.net(this.dyO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aYm().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dyO.aOZ().aPd().mUrl + "], size:" + i2);
                            this.dyO.aPa().mNetErrorCode = -16;
                            TiebaStatic.net(this.dyO);
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
        aVar.mSize = this.dyO.aPb().dAq.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dyO.aPb().dAq.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.dyO.aPb().dAq.retry);
        TiebaStatic.net(this.dyO);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void uF(String str) {
        this.dyO.aPa().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dyO.aPa().mServerErrorCode = errorData.getError_code();
                if (this.dyO.aPa().mServerErrorCode == -1) {
                    this.dyO.aPa().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dyO.aPa().mServerErrorCode != 0) {
                    this.dyO.aPa().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dyO.aPa().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dyO.aPa().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dyO.aOZ().aPd().charSet = TextUtils.isEmpty(this.dyO.aOZ().aPd().charSet) ? "UTF-8" : this.dyO.aOZ().aPd().charSet;
            str = new String(netData, 0, netData.length, this.dyO.aOZ().aPd().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            uF(str);
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
            if (this.dyO.aOZ().aPd().mPostData == null || i3 >= this.dyO.aOZ().aPd().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dyO.aOZ().aPd().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.dyO.aOZ().aPd().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.dyO.aOZ().dyR) {
                addPostData("sig", StringU.xB(sb.toString()));
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
        if (this.dyU.isCanceled()) {
            return null;
        }
        if (this.dyU.a(this.dyO.aOZ().aPd().mUrl, this.dyO.aOZ().aPd().mPostData, this.dyO.aOZ().aPd().mRequestGzip, 5, -1, aOB()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e kU = this.dyU.kU();
        if (kU == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g kC = kU.kC();
        if (kU != null && kU.kD() != null && (size = kU.kD().size()) > 0) {
            this.dyO.aPb().dAq = kU.kD().get(size - 1);
        }
        this.dyO.aPa().mNetErrorCode = kC.responseCode;
        this.dyO.aPa().mHeader = kC.Kq;
        if (this.dyO.aPa().mNetErrorCode != 200) {
            if (this.dyO.aPb().dAq != null && !TextUtils.isEmpty(this.dyO.aPb().dAq.exception)) {
                this.dyO.aPa().mException = this.dyO.aPb().dAq.exception;
            } else {
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
            }
            TiebaStatic.net(this.dyO);
            return null;
        } else if (this.dyU.isCanceled()) {
            return null;
        } else {
            str = new String(kC.retBytes, "utf-8");
            try {
                if (this.dyO.aOZ().aPd().mIsBaiduServer && this.dyO.aOZ().aPd().mIsJson) {
                    uF(str);
                }
                i = kC.retBytes.length;
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
                aVar.mSize = this.dyO.aPb().dAq.downloadSize;
                aVar.mTime = this.dyO.aPb().dAq.JO;
                aVar.mTimesNum = this.dyO.aPb().dAq.retry;
                aVar.mMethod = 1;
                aa.a(aVar);
                aa.mErrorNums.set(this.dyO.aPb().dAq.retry);
                TiebaStatic.net(this.dyO);
            } catch (BdHttpCancelException e20) {
                bdHttpCancelException = e20;
                str2 = str;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dyO.aPa().mNetErrorCode = -14;
                str = str2;
                d(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e21) {
                e = e21;
                this.dyO.aPa().mNetErrorCode = -15;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e22) {
                e4 = e22;
                this.dyO.aPa().mNetErrorCode = -12;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e4.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e23) {
                e3 = e23;
                this.dyO.aPa().mNetErrorCode = -13;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(e3.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (Exception e24) {
                e2 = e24;
                this.dyO.aPa().mNetErrorCode = -10;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (Throwable th5) {
                th = th5;
                this.dyO.aPa().mNetErrorCode = -10;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                BdLog.e(th.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            }
            d(currentTimeMillis, j, i);
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
        if (this.dyU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.dyU.a(this.dyO.aOZ().aPd().mUrl, this.dyO.aOZ().aPd().mRequestGzip, this.dyO.aOZ().aPd().mPostData, this.dyO.aOZ().aPd().mFileData, 5, -1, aOB());
        this.dyO.aPa().mNetErrorCode = a.responseCode;
        this.dyO.aPa().mHeader = a.Kq;
        if (this.dyO.aPa().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e kU = this.dyU.kU();
            int i2 = 0;
            if (kU != null && kU.kD() != null) {
                i2 = kU.kD().size();
            }
            if (i2 <= 0 || (dVar = kU.kD().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.dyO.aPa().mException = str2;
            } else {
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
            }
            TiebaStatic.net(this.dyO);
            return null;
        } else if (this.dyU.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                uF(str);
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
                TiebaStatic.net(this.dyO);
            } catch (BdHttpCancelException e19) {
                e3 = e19;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                this.dyO.aPa().mNetErrorCode = -14;
                d(currentTimeMillis, j, i);
                return str;
            } catch (OutOfMemoryError e20) {
                e2 = e20;
                this.dyO.aPa().mNetErrorCode = -15;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (SocketException e21) {
                this.dyO.aPa().mNetErrorCode = -12;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (SocketTimeoutException e22) {
                this.dyO.aPa().mNetErrorCode = -13;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            } catch (Exception e23) {
                e = e23;
                this.dyO.aPa().mNetErrorCode = -10;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                d(currentTimeMillis, j, i);
                return str;
            }
            d(currentTimeMillis, j, i);
            return str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [768=5, 769=5, 770=5, 771=5, 773=5, 775=5, 776=4, 756=5, 757=5, 758=5, 759=5, 760=5, 761=5, 762=5, 763=5, 764=5, 765=5, 766=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e kU;
        try {
            try {
                if (this.dyU.isCanceled()) {
                    return false;
                }
                z2 = this.dyU.a(this.dyO.aOZ().aPd().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aOB(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int dyV = 0;
                    int dyW = 0;
                    int dyX = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.dyV = i5 / 50;
                        }
                        this.dyW += i4 - this.dyX;
                        this.dyX = i4;
                        if (handler != null) {
                            if (this.dyW > this.dyV || i4 == i5) {
                                this.dyW = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.dyO.aOZ().Km);
                try {
                    this.dyO.aPa().mNetErrorCode = this.dyU.kU().kC().responseCode;
                    com.baidu.adp.lib.network.http.e kU2 = this.dyU.kU();
                    if (kU2 != null && kU2.kD() != null && handler != null) {
                        int i4 = kU2.kC().mNetErrorCode;
                        int size = kU2.kD().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = kU2.kD().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.nb(this.dyO.aPa().mNetErrorCode);
                            bVar.bF(dVar.exception);
                            bVar.wX(dVar.JW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.JD + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.JS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.JT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.JU);
                            bVar.setUrl(dVar.url);
                            bVar.Ka = dVar.Ka;
                            bVar.Kb = dVar.Kb;
                            bVar.Kc = dVar.Kc;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.dyO);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.dyO.aPa().mNetErrorCode = -10;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e kU3 = this.dyU.kU();
                    if (kU3 != null && kU3.kD() != null && handler != null) {
                        int i5 = kU3.kC().mNetErrorCode;
                        int size2 = kU3.kD().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = kU3.kD().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.nb(this.dyO.aPa().mNetErrorCode);
                            bVar2.bF(dVar2.exception);
                            bVar2.wX(dVar2.JW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.JD + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.JS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.JT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.JU);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Ka = dVar2.Ka;
                            bVar2.Kb = dVar2.Kb;
                            bVar2.Kc = dVar2.Kc;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.dyO);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.dyO.aPa().mNetErrorCode = -15;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e kU4 = this.dyU.kU();
                    if (kU4 != null && kU4.kD() != null && handler != null) {
                        int i6 = kU4.kC().mNetErrorCode;
                        int size3 = kU4.kD().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = kU4.kD().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.nb(this.dyO.aPa().mNetErrorCode);
                            bVar3.bF(dVar3.exception);
                            bVar3.wX(dVar3.JW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.JD + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.JS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.JT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.JU);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Ka = dVar3.Ka;
                            bVar3.Kb = dVar3.Kb;
                            bVar3.Kc = dVar3.Kc;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.dyO);
                    return z2;
                }
            } finally {
                kU = this.dyU.kU();
                if (kU != null && kU.kD() != null && handler != null) {
                    int i7 = kU.kC().mNetErrorCode;
                    int size4 = kU.kD().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = kU.kD().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.nb(this.dyO.aPa().mNetErrorCode);
                        bVar4.bF(dVar4.exception);
                        bVar4.wX(dVar4.JW + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.JD + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.JS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.JT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.JU);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Ka = dVar4.Ka;
                        bVar4.Kb = dVar4.Kb;
                        bVar4.Kc = dVar4.Kc;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.dyO);
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
        return this.dyO.aOZ().aPd().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dyO.aOZ().aPd().mPostData != null) {
            this.dyO.aOZ().aPd().mPostData.clear();
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
        if (this.dyO.aOZ().aPd().mFileData == null) {
            this.dyO.aOZ().aPd().mFileData = new HashMap<>();
        }
        this.dyO.aOZ().aPd().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dyO.aOZ().aPd().mPostData == null) {
                this.dyO.aOZ().aPd().mPostData = new ArrayList<>();
            }
            int c = c(this.dyO.aOZ().aPd().mPostData, basicNameValuePair.getName());
            int size = this.dyO.aOZ().aPd().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dyO.aOZ().aPd().mPostData.get(c).getName())) {
                    this.dyO.aOZ().aPd().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dyO.aOZ().aPd().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dyO.aOZ().aPd().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aOB() {
        if (this.dyO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dyO.aOZ().aPd().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dyO.aOZ().aPd().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.dyO.aOZ().aPd().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dyO.aOZ().aPd().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
