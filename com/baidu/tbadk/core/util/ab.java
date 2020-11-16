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
public class ab implements s {
    private static int eLH = 2097152;
    private final com.baidu.tbadk.core.util.a.a eLC;
    private com.baidu.adp.lib.network.a.a eLI = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eLC = aVar;
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
        if (this.eLI != null) {
            this.eLI.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.eLI.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mQ;
        if (this.eLC != null && this.eLI != null && (mQ = this.eLI.mQ()) != null) {
            long ms = mQ.ms();
            long mt = mQ.mt();
            long mq = mQ.mq();
            long mu = mQ.mu();
            long mv = mQ.mv();
            long j3 = ms - j;
            long j4 = mt - ms;
            int mw = mQ.mw();
            long j5 = mu - mt;
            long j6 = mq - mt;
            long j7 = mu - mq;
            long j8 = mv - mu;
            if (mv <= 0) {
                j8 = 0;
            }
            HashMap<String, String> bqK = this.eLC.bqK();
            bqK.put("startTime", String.valueOf(System.currentTimeMillis()));
            bqK.put("netConTime", String.valueOf(j3));
            bqK.put("netRWTime", String.valueOf(j5));
            bqK.put("firstByteTime", String.valueOf(j6));
            bqK.put("allDataReadTime", String.valueOf(j7));
            bqK.put("dataDeCompressTime", String.valueOf(j8));
            bqK.put("httpRetryNum", String.valueOf(mw));
            bqK.put("httpRetryCostTime", String.valueOf(j4));
            bqK.put("dataParseTime", String.valueOf(j2 - mv));
            bqK.put("isHttp", "1");
            bqK.put("httpSize", String.valueOf(i));
            bqK.put("errCode", String.valueOf(this.eLC.bqI().mNetErrorCode));
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
            if (this.eLC.bqH().bqL().mPostData != null && this.eLC.bqH().bqL().mPostData.size() > 0 && !this.eLC.bqH().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eLC.bqH().bqL().mUrl);
                if (this.eLC.bqH().bqL().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eLC.bqH().bqL().mUrl.endsWith("?") && !this.eLC.bqH().bqL().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eLC.bqH().bqL().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eLC.bqH().bqL().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(au.getUrlEncode(this.eLC.bqH().bqL().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eLC.bqH().bqL().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eLC.bqH().bqL().mRequestGzip || this.eLC.bqH().bqL().mIsBDImage) && !this.eLC.bqH().mIsFromCDN) {
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
        if (this.eLI.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.eLI.a(str, z, 5, 100, -1, -1, bqd());
        com.baidu.adp.lib.network.http.e mR = this.eLI.mR();
        if (mR == null) {
            return null;
        }
        gVar = mR.my();
        if (mR != null) {
            try {
                if (mR.mz() != null && (size = mR.mz().size()) > 0) {
                    this.eLC.bqJ().eNu = mR.mz().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eLC.bqI().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eLC);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -12;
                TiebaStatic.net(this.eLC);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -13;
                TiebaStatic.net(this.eLC);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eLC);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eLC.bqI().mNetErrorCode = gVar.responseCode;
        if (this.eLC.bqI().mNetErrorCode != 200) {
            this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eLC.bqJ().eNu != null && !TextUtils.isEmpty(this.eLC.bqJ().eNu.exception)) {
                this.eLC.bqI().mException = this.eLC.bqJ().eNu.exception;
            } else {
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
            }
            TiebaStatic.net(this.eLC);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eLH) {
                    this.eLC.bqI().mNetErrorCode = -11;
                    TiebaStatic.net(this.eLC);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bAt().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eLC.bqH().bqL().mUrl + "], size:" + i2);
                            this.eLC.bqI().mNetErrorCode = -16;
                            TiebaStatic.net(this.eLC);
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
        aVar.mSize = this.eLC.bqJ().eNu.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eLC.bqJ().eNu.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eLC.bqJ().eNu.retry);
        TiebaStatic.net(this.eLC);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void Bp(String str) {
        this.eLC.bqI().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eLC.bqI().mServerErrorCode = errorData.getError_code();
                if (this.eLC.bqI().mServerErrorCode == -1) {
                    this.eLC.bqI().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eLC.bqI().mServerErrorCode != 0) {
                    this.eLC.bqI().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eLC.bqI().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eLC.bqI().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eLC.bqH().bqL().charSet = TextUtils.isEmpty(this.eLC.bqH().bqL().charSet) ? "UTF-8" : this.eLC.bqH().bqL().charSet;
            str = new String(netData, 0, netData.length, this.eLC.bqH().bqL().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            Bp(str);
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
            if (this.eLC.bqH().bqL().mPostData == null || i3 >= this.eLC.bqH().bqL().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eLC.bqH().bqL().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eLC.bqH().bqL().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eLC.bqH().eLF) {
                addPostData("sig", StringU.Ew(sb.toString()));
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
        if (this.eLI.isCanceled()) {
            return null;
        }
        if (this.eLI.a(this.eLC.bqH().bqL().mUrl, this.eLC.bqH().bqL().mPostData, this.eLC.bqH().bqL().mRequestGzip, 5, -1, bqd()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mR = this.eLI.mR();
        if (mR == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g my = mR.my();
        if (mR != null && mR.mz() != null && (size = mR.mz().size()) > 0) {
            this.eLC.bqJ().eNu = mR.mz().get(size - 1);
        }
        this.eLC.bqI().mNetErrorCode = my.responseCode;
        this.eLC.bqI().mHeader = my.Mp;
        if (this.eLC.bqI().mNetErrorCode != 200) {
            if (this.eLC.bqJ().eNu != null && !TextUtils.isEmpty(this.eLC.bqJ().eNu.exception)) {
                this.eLC.bqI().mException = this.eLC.bqJ().eNu.exception;
            } else {
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
            }
            TiebaStatic.net(this.eLC);
            return null;
        } else if (this.eLI.isCanceled()) {
            return null;
        } else {
            str = new String(my.retBytes, "utf-8");
            try {
                if (this.eLC.bqH().bqL().mIsBaiduServer && this.eLC.bqH().bqL().mIsJson) {
                    Bp(str);
                }
                i = my.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eLC.bqJ().eNu.downloadSize;
                        aVar.mTime = this.eLC.bqJ().eNu.LK;
                        aVar.mTimesNum = this.eLC.bqJ().eNu.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.eLC.bqJ().eNu.retry);
                        TiebaStatic.net(this.eLC);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.eLC.bqI().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.eLC.bqI().mNetErrorCode = -15;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.eLC.bqI().mNetErrorCode = -12;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.eLC.bqI().mNetErrorCode = -13;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.eLC.bqI().mNetErrorCode = -10;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.eLC.bqI().mNetErrorCode = -10;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eLC);
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
        if (this.eLI.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.eLI.a(this.eLC.bqH().bqL().mUrl, this.eLC.bqH().bqL().mRequestGzip, this.eLC.bqH().bqL().mPostData, this.eLC.bqH().bqL().mFileData, 5, -1, bqd());
        this.eLC.bqI().mNetErrorCode = a2.responseCode;
        this.eLC.bqI().mHeader = a2.Mp;
        if (this.eLC.bqI().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mR = this.eLI.mR();
            int i2 = 0;
            if (mR != null && mR.mz() != null) {
                i2 = mR.mz().size();
            }
            if (i2 <= 0 || (dVar = mR.mz().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.eLC.bqI().mException = str2;
            } else {
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
            }
            TiebaStatic.net(this.eLC);
            return null;
        } else if (this.eLI.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                Bp(str);
                i = a2.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.eLC);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.eLC.bqI().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.eLC.bqI().mNetErrorCode = -15;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.eLC.bqI().mNetErrorCode = -12;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.eLC.bqI().mNetErrorCode = -13;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eLC);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.eLC.bqI().mNetErrorCode = -10;
                        this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eLC);
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
        com.baidu.adp.lib.network.http.e mR;
        try {
            try {
                if (this.eLI.isCanceled()) {
                    return false;
                }
                z2 = this.eLI.a(this.eLC.bqH().bqL().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bqd(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int eLJ = 0;
                    int eLK = 0;
                    int eLL = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.eLJ = i5 / 50;
                        }
                        this.eLK += i4 - this.eLL;
                        this.eLL = i4;
                        if (handler != null) {
                            if (this.eLK > this.eLJ || i4 == i5) {
                                this.eLK = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eLC.bqH().Mk);
                try {
                    this.eLC.bqI().mNetErrorCode = this.eLI.mR().my().responseCode;
                    com.baidu.adp.lib.network.http.e mR2 = this.eLI.mR();
                    if (mR2 != null && mR2.mz() != null && handler != null) {
                        int i4 = mR2.my().mNetErrorCode;
                        int size = mR2.mz().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mR2.mz().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.sl(this.eLC.bqI().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.DL(dVar.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LS);
                            bVar.setUrl(dVar.url);
                            bVar.LZ = dVar.LZ;
                            bVar.Ma = dVar.Ma;
                            bVar.Mb = dVar.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eLC);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eLC.bqI().mNetErrorCode = -10;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR3 = this.eLI.mR();
                    if (mR3 != null && mR3.mz() != null && handler != null) {
                        int i5 = mR3.my().mNetErrorCode;
                        int size2 = mR3.mz().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mR3.mz().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.sl(this.eLC.bqI().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.DL(dVar2.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LS);
                            bVar2.setUrl(dVar2.url);
                            bVar2.LZ = dVar2.LZ;
                            bVar2.Ma = dVar2.Ma;
                            bVar2.Mb = dVar2.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eLC);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eLC.bqI().mNetErrorCode = -15;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR4 = this.eLI.mR();
                    if (mR4 != null && mR4.mz() != null && handler != null) {
                        int i6 = mR4.my().mNetErrorCode;
                        int size3 = mR4.mz().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mR4.mz().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.sl(this.eLC.bqI().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.DL(dVar3.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LS);
                            bVar3.setUrl(dVar3.url);
                            bVar3.LZ = dVar3.LZ;
                            bVar3.Ma = dVar3.Ma;
                            bVar3.Mb = dVar3.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eLC);
                    return z2;
                }
            } finally {
                mR = this.eLI.mR();
                if (mR != null && mR.mz() != null && handler != null) {
                    int i7 = mR.my().mNetErrorCode;
                    int size4 = mR.mz().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mR.mz().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.sl(this.eLC.bqI().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.DL(dVar4.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LS);
                        bVar4.setUrl(dVar4.url);
                        bVar4.LZ = dVar4.LZ;
                        bVar4.Ma = dVar4.Ma;
                        bVar4.Mb = dVar4.Mb;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eLC);
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
        return this.eLC.bqH().bqL().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eLC.bqH().bqL().mPostData != null) {
            this.eLC.bqH().bqL().mPostData.clear();
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
        if (this.eLC.bqH().bqL().mFileData == null) {
            this.eLC.bqH().bqL().mFileData = new HashMap<>();
        }
        this.eLC.bqH().bqL().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eLC.bqH().bqL().mPostData == null) {
                this.eLC.bqH().bqL().mPostData = new ArrayList<>();
            }
            int c = c(this.eLC.bqH().bqL().mPostData, basicNameValuePair.getName());
            int size = this.eLC.bqH().bqL().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eLC.bqH().bqL().mPostData.get(c).getName())) {
                    this.eLC.bqH().bqL().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eLC.bqH().bqL().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eLC.bqH().bqL().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bqd() {
        if (this.eLC != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eLC.bqH().bqL().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eLC.bqH().bqL().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eLC.bqH().bqL().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eLC.bqH().bqL().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
