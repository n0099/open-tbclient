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
/* loaded from: classes.dex */
public class ab implements t {
    private static int fab = 2097152;
    private final com.baidu.tbadk.core.util.b.a eZW;
    private com.baidu.adp.lib.network.a.a fac = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.b.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eZW = aVar;
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

    @Override // com.baidu.tbadk.core.util.t
    public void setCancel() {
        if (this.fac != null) {
            this.fac.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void cancelNetConnect() {
        this.fac.cancel();
    }

    private void b(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mn;
        if (this.eZW != null && this.fac != null && (mn = this.fac.mn()) != null) {
            long lP = mn.lP();
            long lQ = mn.lQ();
            long lN = mn.lN();
            long lR = mn.lR();
            long lS = mn.lS();
            long j3 = lP - j;
            long j4 = lQ - lP;
            int lT = mn.lT();
            long j5 = lR - lQ;
            long j6 = lN - lQ;
            long j7 = lR - lN;
            long j8 = lS - lR;
            if (lS <= 0) {
                j8 = 0;
            }
            HashMap<String, String> btd = this.eZW.btd();
            btd.put("startTime", String.valueOf(System.currentTimeMillis()));
            btd.put("netConTime", String.valueOf(j3));
            btd.put("netRWTime", String.valueOf(j5));
            btd.put("firstByteTime", String.valueOf(j6));
            btd.put("allDataReadTime", String.valueOf(j7));
            btd.put("dataDeCompressTime", String.valueOf(j8));
            btd.put("httpRetryNum", String.valueOf(lT));
            btd.put("httpRetryCostTime", String.valueOf(j4));
            btd.put("dataParseTime", String.valueOf(j2 - lS));
            btd.put("isHttp", "1");
            btd.put("httpSize", String.valueOf(i));
            btd.put("errCode", String.valueOf(this.eZW.btb().mNetErrorCode));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03a8 -> B:95:0x03a9). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        com.baidu.adp.lib.network.http.g gVar;
        BdHttpCancelException bdHttpCancelException;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.eZW.bta().bte().mPostData != null && this.eZW.bta().bte().mPostData.size() > 0 && !this.eZW.bta().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eZW.bta().bte().mUrl);
                if (this.eZW.bta().bte().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eZW.bta().bte().mUrl.endsWith("?") && !this.eZW.bta().bte().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eZW.bta().bte().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eZW.bta().bte().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(au.getUrlEncode(this.eZW.bta().bte().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eZW.bta().bte().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eZW.bta().bte().mRequestGzip || this.eZW.bta().bte().mIsBDImage) && !this.eZW.bta().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar = null;
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
        if (this.fac.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.fac.a(str, z, 5, 100, -1, -1, bsu());
        com.baidu.adp.lib.network.http.e mo = this.fac.mo();
        if (mo == null) {
            return null;
        }
        gVar = mo.lV();
        if (mo != null) {
            try {
                if (mo.lW() != null && (size = mo.lW().size()) > 0) {
                    this.eZW.btc().fbP = mo.lW().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eZW.btb().mNetErrorCode = -14;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eZW);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -12;
                TiebaStatic.net(this.eZW);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -13;
                TiebaStatic.net(this.eZW);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eZW);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eZW.btb().mNetErrorCode = gVar.responseCode;
        if (this.eZW.btb().mNetErrorCode != 200) {
            this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eZW.btc().fbP != null && !TextUtils.isEmpty(this.eZW.btc().fbP.exception)) {
                this.eZW.btb().mException = this.eZW.btc().fbP.exception;
            } else {
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
            }
            TiebaStatic.net(this.eZW);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fab) {
                    this.eZW.btb().mNetErrorCode = -11;
                    TiebaStatic.net(this.eZW);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCP().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eZW.bta().bte().mUrl + "], size:" + i2);
                            this.eZW.btb().mNetErrorCode = -16;
                            TiebaStatic.net(this.eZW);
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
        aVar.mSize = this.eZW.btc().fbP.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eZW.btc().fbP.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eZW.btc().fbP.retry);
        TiebaStatic.net(this.eZW);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void Ba(String str) {
        this.eZW.btb().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eZW.btb().mServerErrorCode = errorData.getError_code();
                if (this.eZW.btb().mServerErrorCode == -1) {
                    this.eZW.btb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eZW.btb().mServerErrorCode != 0) {
                    this.eZW.btb().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eZW.btb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.eZW.btb().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eZW.bta().bte().charSet = TextUtils.isEmpty(this.eZW.bta().bte().charSet) ? "UTF-8" : this.eZW.bta().bte().charSet;
            str = new String(netData, 0, netData.length, this.eZW.bta().bte().charSet);
            try {
                Ba(str);
                return str;
            } catch (Exception e) {
                e = e;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String postNetData() {
        int i;
        long j;
        String str;
        BdHttpCancelException e;
        String str2;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1024);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (this.eZW.bta().bte().mPostData == null || i3 >= this.eZW.bta().bte().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eZW.bta().bte().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eZW.bta().bte().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eZW.bta().eZZ) {
                addPostData("sig", StringU.Es(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
        } catch (BdHttpCancelException e2) {
            e = e2;
            i = 0;
            j = 0;
            str2 = null;
        } catch (Exception e3) {
            e = e3;
            i = 0;
            j = 0;
            str = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketException e5) {
            e = e5;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketTimeoutException e6) {
            e = e6;
            i = 0;
            j = 0;
            str = null;
        } catch (Throwable th) {
            th = th;
            i = 0;
            j = 0;
            str = null;
        }
        if (this.fac.isCanceled()) {
            return null;
        }
        if (this.fac.a(this.eZW.bta().bte().mUrl, this.eZW.bta().bte().mPostData, this.eZW.bta().bte().mRequestGzip, 5, -1, bsu()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mo = this.fac.mo();
        if (mo == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g lV = mo.lV();
        if (mo != null && mo.lW() != null && (size = mo.lW().size()) > 0) {
            this.eZW.btc().fbP = mo.lW().get(size - 1);
        }
        this.eZW.btb().mNetErrorCode = lV.responseCode;
        this.eZW.btb().mHeader = lV.ME;
        if (this.eZW.btb().mNetErrorCode != 200) {
            if (this.eZW.btc().fbP != null && !TextUtils.isEmpty(this.eZW.btc().fbP.exception)) {
                this.eZW.btb().mException = this.eZW.btc().fbP.exception;
            } else {
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
            }
            TiebaStatic.net(this.eZW);
            return null;
        } else if (this.fac.isCanceled()) {
            return null;
        } else {
            str = new String(lV.retBytes, "utf-8");
            try {
                if (this.eZW.bta().bte().mIsBaiduServer && this.eZW.bta().bte().mIsJson) {
                    Ba(str);
                }
                i = lV.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eZW.btc().fbP.downloadSize;
                        aVar.mTime = this.eZW.btc().fbP.Mb;
                        aVar.mTimesNum = this.eZW.btc().fbP.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.eZW.btc().fbP.retry);
                        TiebaStatic.net(this.eZW);
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str2 = str;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + e.getClass() + "|" + e.getMessage();
                        this.eZW.btb().mNetErrorCode = -14;
                        str = str2;
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e8) {
                        e = e8;
                        this.eZW.btb().mNetErrorCode = -10;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eZW);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        this.eZW.btb().mNetErrorCode = -15;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eZW);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e10) {
                        e = e10;
                        this.eZW.btb().mNetErrorCode = -12;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eZW);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e11) {
                        e = e11;
                        this.eZW.btb().mNetErrorCode = -13;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eZW);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.eZW.btb().mNetErrorCode = -10;
                        this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eZW);
                        b(currentTimeMillis, j, i);
                        return str;
                    }
                } catch (BdHttpCancelException e12) {
                    e = e12;
                    j = 0;
                    str2 = str;
                } catch (Exception e13) {
                    e = e13;
                    j = 0;
                } catch (OutOfMemoryError e14) {
                    e = e14;
                    j = 0;
                } catch (SocketException e15) {
                    e = e15;
                    j = 0;
                } catch (SocketTimeoutException e16) {
                    e = e16;
                    j = 0;
                } catch (Throwable th3) {
                    th = th3;
                    j = 0;
                }
            } catch (BdHttpCancelException e17) {
                e = e17;
                i = 0;
                j = 0;
                str2 = str;
            } catch (OutOfMemoryError e18) {
                e = e18;
                i = 0;
                j = 0;
            } catch (SocketException e19) {
                e = e19;
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e20) {
                e = e20;
                i = 0;
                j = 0;
            } catch (Exception e21) {
                e = e21;
                i = 0;
                j = 0;
            } catch (Throwable th4) {
                th = th4;
                i = 0;
                j = 0;
            }
            b(currentTimeMillis, j, i);
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String postMultiNetData() {
        int i;
        long j;
        String str;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (BdHttpCancelException e) {
            e = e;
            i = 0;
            j = 0;
            str = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            i = 0;
            j = 0;
            str = null;
        } catch (SocketException e3) {
            i = 0;
            j = 0;
            str = null;
        } catch (SocketTimeoutException e4) {
            i = 0;
            j = 0;
            str = null;
        } catch (Exception e5) {
            e = e5;
            i = 0;
            j = 0;
            str = null;
        }
        if (this.fac.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.fac.a(this.eZW.bta().bte().mUrl, this.eZW.bta().bte().mRequestGzip, this.eZW.bta().bte().mPostData, this.eZW.bta().bte().mFileData, 5, -1, bsu());
        this.eZW.btb().mNetErrorCode = a2.responseCode;
        this.eZW.btb().mHeader = a2.ME;
        if (this.eZW.btb().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mo = this.fac.mo();
            int i2 = 0;
            if (mo != null && mo.lW() != null) {
                i2 = mo.lW().size();
            }
            if (i2 <= 0 || (dVar = mo.lW().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.eZW.btb().mException = str2;
            } else {
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
            }
            TiebaStatic.net(this.eZW);
            return null;
        } else if (this.fac.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                Ba(str);
                i = a2.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                } catch (BdHttpCancelException e6) {
                    e = e6;
                    j = 0;
                } catch (Exception e7) {
                    e = e7;
                    j = 0;
                } catch (OutOfMemoryError e8) {
                    e = e8;
                    j = 0;
                } catch (SocketException e9) {
                    j = 0;
                } catch (SocketTimeoutException e10) {
                    j = 0;
                }
                try {
                    TiebaStatic.net(this.eZW);
                } catch (BdHttpCancelException e11) {
                    e = e11;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eZW.btb().mNetErrorCode = -14;
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    this.eZW.btb().mNetErrorCode = -15;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketException e13) {
                    this.eZW.btb().mNetErrorCode = -12;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.eZW);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketTimeoutException e14) {
                    this.eZW.btb().mNetErrorCode = -13;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.eZW);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (Exception e15) {
                    e = e15;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    b(currentTimeMillis, j, i);
                    return str;
                }
            } catch (BdHttpCancelException e16) {
                e = e16;
                i = 0;
                j = 0;
            } catch (SocketException e17) {
                i = 0;
                j = 0;
            } catch (Exception e18) {
                e = e18;
                i = 0;
                j = 0;
            } catch (OutOfMemoryError e19) {
                e = e19;
                i = 0;
                j = 0;
            } catch (SocketTimeoutException e20) {
                i = 0;
                j = 0;
            }
            b(currentTimeMillis, j, i);
            return str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [769=5, 770=5, 771=5, 772=5, 774=5, 776=5, 777=4, 757=5, 758=5, 759=5, 760=5, 761=5, 762=5, 763=5, 764=5, 765=5, 766=5, 767=5] */
    @Override // com.baidu.tbadk.core.util.t
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e mo;
        try {
            try {
                if (this.fac.isCanceled()) {
                    return false;
                }
                z2 = this.fac.a(this.eZW.bta().bte().mUrl, (z ? new File(str) : o.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsu(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int fad = 0;
                    int fae = 0;
                    int faf = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.fad = i5 / 50;
                        }
                        this.fae += i4 - this.faf;
                        this.faf = i4;
                        if (handler != null) {
                            if (this.fae > this.fad || i4 == i5) {
                                this.fae = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eZW.bta().My);
                try {
                    this.eZW.btb().mNetErrorCode = this.fac.mo().lV().responseCode;
                    com.baidu.adp.lib.network.http.e mo2 = this.fac.mo();
                    if (mo2 != null && mo2.lW() != null && handler != null) {
                        int i4 = mo2.lV().mNetErrorCode;
                        int size = mo2.lW().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mo2.lW().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.rw(this.eZW.btb().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Dw(dVar.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mf + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mg + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mh);
                            bVar.setUrl(dVar.url);
                            bVar.Mn = dVar.Mn;
                            bVar.Mo = dVar.Mo;
                            bVar.Mp = dVar.Mp;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eZW);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mo3 = this.fac.mo();
                    if (mo3 != null && mo3.lW() != null && handler != null) {
                        int i5 = mo3.lV().mNetErrorCode;
                        int size2 = mo3.lW().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mo3.lW().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.rw(this.eZW.btb().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Dw(dVar2.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mf + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mg + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mh);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Mn = dVar2.Mn;
                            bVar2.Mo = dVar2.Mo;
                            bVar2.Mp = dVar2.Mp;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eZW);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eZW.btb().mNetErrorCode = -15;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mo4 = this.fac.mo();
                    if (mo4 != null && mo4.lW() != null && handler != null) {
                        int i6 = mo4.lV().mNetErrorCode;
                        int size3 = mo4.lW().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mo4.lW().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.rw(this.eZW.btb().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Dw(dVar3.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mf + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mg + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mh);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Mn = dVar3.Mn;
                            bVar3.Mo = dVar3.Mo;
                            bVar3.Mp = dVar3.Mp;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eZW);
                    return z2;
                }
            } finally {
                mo = this.fac.mo();
                if (mo != null && mo.lW() != null && handler != null) {
                    int i7 = mo.lV().mNetErrorCode;
                    int size4 = mo.lW().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mo.lW().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.rw(this.eZW.btb().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Dw(dVar4.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mf + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mg + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mh);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Mn = dVar4.Mn;
                        bVar4.Mo = dVar4.Mo;
                        bVar4.Mp = dVar4.Mp;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eZW);
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        } catch (OutOfMemoryError e4) {
            e = e4;
            z2 = false;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.eZW.bta().bte().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eZW.bta().bte().mPostData != null) {
            this.eZW.bta().bte().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, byte[] bArr) {
        if (this.eZW.bta().bte().mFileData == null) {
            this.eZW.bta().bte().mFileData = new HashMap<>();
        }
        this.eZW.bta().bte().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eZW.bta().bte().mPostData == null) {
                this.eZW.bta().bte().mPostData = new ArrayList<>();
            }
            int c = c(this.eZW.bta().bte().mPostData, basicNameValuePair.getName());
            int size = this.eZW.bta().bte().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eZW.bta().bte().mPostData.get(c).getName())) {
                    this.eZW.bta().bte().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eZW.bta().bte().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eZW.bta().bte().mPostData.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i = 0;
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

    private LinkedList<BasicNameValuePair> bsu() {
        if (this.eZW != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eZW.bta().bte().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eZW.bta().bte().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eZW.bta().bte().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eZW.bta().bte().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
