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
    private static int eMI = 2097152;
    private final com.baidu.tbadk.core.util.a.a eMD;
    private com.baidu.adp.lib.network.a.a eMJ = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eMD = aVar;
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
        if (this.eMJ != null) {
            this.eMJ.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.eMJ.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mQ;
        if (this.eMD != null && this.eMJ != null && (mQ = this.eMJ.mQ()) != null) {
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
            HashMap<String, String> brw = this.eMD.brw();
            brw.put("startTime", String.valueOf(System.currentTimeMillis()));
            brw.put("netConTime", String.valueOf(j3));
            brw.put("netRWTime", String.valueOf(j5));
            brw.put("firstByteTime", String.valueOf(j6));
            brw.put("allDataReadTime", String.valueOf(j7));
            brw.put("dataDeCompressTime", String.valueOf(j8));
            brw.put("httpRetryNum", String.valueOf(mw));
            brw.put("httpRetryCostTime", String.valueOf(j4));
            brw.put("dataParseTime", String.valueOf(j2 - mv));
            brw.put("isHttp", "1");
            brw.put("httpSize", String.valueOf(i));
            brw.put("errCode", String.valueOf(this.eMD.bru().mNetErrorCode));
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
            if (this.eMD.brt().brx().mPostData != null && this.eMD.brt().brx().mPostData.size() > 0 && !this.eMD.brt().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eMD.brt().brx().mUrl);
                if (this.eMD.brt().brx().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eMD.brt().brx().mUrl.endsWith("?") && !this.eMD.brt().brx().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eMD.brt().brx().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eMD.brt().brx().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.eMD.brt().brx().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eMD.brt().brx().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eMD.brt().brx().mRequestGzip || this.eMD.brt().brx().mIsBDImage) && !this.eMD.brt().mIsFromCDN) {
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
        if (this.eMJ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.eMJ.a(str, z, 5, 100, -1, -1, bqQ());
        com.baidu.adp.lib.network.http.e mR = this.eMJ.mR();
        if (mR == null) {
            return null;
        }
        gVar = mR.my();
        if (mR != null) {
            try {
                if (mR.mz() != null && (size = mR.mz().size()) > 0) {
                    this.eMD.brv().eOq = mR.mz().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eMD.bru().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq != null ? this.eMD.brv().eOq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eMD.bru().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eMD);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq != null ? this.eMD.brv().eOq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eMD.bru().mNetErrorCode = -12;
                TiebaStatic.net(this.eMD);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq != null ? this.eMD.brv().eOq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eMD.bru().mNetErrorCode = -13;
                TiebaStatic.net(this.eMD);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq != null ? this.eMD.brv().eOq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eMD.bru().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eMD);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eMD.bru().mNetErrorCode = gVar.responseCode;
        if (this.eMD.bru().mNetErrorCode != 200) {
            this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eMD.brv().eOq != null && !TextUtils.isEmpty(this.eMD.brv().eOq.exception)) {
                this.eMD.bru().mException = this.eMD.brv().eOq.exception;
            } else {
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry);
            }
            TiebaStatic.net(this.eMD);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eMI) {
                    this.eMD.bru().mNetErrorCode = -11;
                    TiebaStatic.net(this.eMD);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bBd().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eMD.brt().brx().mUrl + "], size:" + i2);
                            this.eMD.bru().mNetErrorCode = -16;
                            TiebaStatic.net(this.eMD);
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
        aVar.mSize = this.eMD.brv().eOq.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eMD.brv().eOq.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eMD.brv().eOq.retry);
        TiebaStatic.net(this.eMD);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void BQ(String str) {
        this.eMD.bru().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eMD.bru().mServerErrorCode = errorData.getError_code();
                if (this.eMD.bru().mServerErrorCode == -1) {
                    this.eMD.bru().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eMD.bru().mServerErrorCode != 0) {
                    this.eMD.bru().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eMD.bru().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eMD.bru().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eMD.brt().brx().charSet = TextUtils.isEmpty(this.eMD.brt().brx().charSet) ? "UTF-8" : this.eMD.brt().brx().charSet;
            str = new String(netData, 0, netData.length, this.eMD.brt().brx().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            BQ(str);
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
            if (this.eMD.brt().brx().mPostData == null || i3 >= this.eMD.brt().brx().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eMD.brt().brx().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eMD.brt().brx().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eMD.brt().eMG) {
                addPostData("sig", StringU.EV(sb.toString()));
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
        if (this.eMJ.isCanceled()) {
            return null;
        }
        if (this.eMJ.a(this.eMD.brt().brx().mUrl, this.eMD.brt().brx().mPostData, this.eMD.brt().brx().mRequestGzip, 5, -1, bqQ()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mR = this.eMJ.mR();
        if (mR == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g my = mR.my();
        if (mR != null && mR.mz() != null && (size = mR.mz().size()) > 0) {
            this.eMD.brv().eOq = mR.mz().get(size - 1);
        }
        this.eMD.bru().mNetErrorCode = my.responseCode;
        this.eMD.bru().mHeader = my.Mp;
        if (this.eMD.bru().mNetErrorCode != 200) {
            if (this.eMD.brv().eOq != null && !TextUtils.isEmpty(this.eMD.brv().eOq.exception)) {
                this.eMD.bru().mException = this.eMD.brv().eOq.exception;
            } else {
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry);
            }
            TiebaStatic.net(this.eMD);
            return null;
        } else if (this.eMJ.isCanceled()) {
            return null;
        } else {
            str = new String(my.retBytes, "utf-8");
            try {
                if (this.eMD.brt().brx().mIsBaiduServer && this.eMD.brt().brx().mIsJson) {
                    BQ(str);
                }
                i = my.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eMD.brv().eOq.downloadSize;
                        aVar.mTime = this.eMD.brv().eOq.LK;
                        aVar.mTimesNum = this.eMD.brv().eOq.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.eMD.brv().eOq.retry);
                        TiebaStatic.net(this.eMD);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.eMD.bru().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.eMD.bru().mNetErrorCode = -15;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.eMD.bru().mNetErrorCode = -12;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.eMD.bru().mNetErrorCode = -13;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.eMD.bru().mNetErrorCode = -10;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.eMD.bru().mNetErrorCode = -10;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eMD);
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
        if (this.eMJ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.eMJ.a(this.eMD.brt().brx().mUrl, this.eMD.brt().brx().mRequestGzip, this.eMD.brt().brx().mPostData, this.eMD.brt().brx().mFileData, 5, -1, bqQ());
        this.eMD.bru().mNetErrorCode = a2.responseCode;
        this.eMD.bru().mHeader = a2.Mp;
        if (this.eMD.bru().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mR = this.eMJ.mR();
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
                this.eMD.bru().mException = str2;
            } else {
                this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry);
            }
            TiebaStatic.net(this.eMD);
            return null;
        } else if (this.eMJ.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                BQ(str);
                i = a2.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.eMD);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eMD.bru().mException = String.valueOf(this.eMD.bru().mNetErrorCode) + "|retryCount:" + (this.eMD.brv().eOq == null ? -1 : this.eMD.brv().eOq.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.eMD.bru().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.eMD.bru().mNetErrorCode = -15;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.eMD.bru().mNetErrorCode = -12;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.eMD.bru().mNetErrorCode = -13;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eMD);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.eMD.bru().mNetErrorCode = -10;
                        this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eMD);
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
                if (this.eMJ.isCanceled()) {
                    return false;
                }
                z2 = this.eMJ.a(this.eMD.brt().brx().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bqQ(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int eMK = 0;
                    int eML = 0;
                    int eMM = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.eMK = i5 / 50;
                        }
                        this.eML += i4 - this.eMM;
                        this.eMM = i4;
                        if (handler != null) {
                            if (this.eML > this.eMK || i4 == i5) {
                                this.eML = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eMD.brt().Mk);
                try {
                    this.eMD.bru().mNetErrorCode = this.eMJ.mR().my().responseCode;
                    com.baidu.adp.lib.network.http.e mR2 = this.eMJ.mR();
                    if (mR2 != null && mR2.mz() != null && handler != null) {
                        int i4 = mR2.my().mNetErrorCode;
                        int size = mR2.mz().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mR2.mz().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.rN(this.eMD.bru().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Em(dVar.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LS);
                            bVar.setUrl(dVar.url);
                            bVar.LZ = dVar.LZ;
                            bVar.Ma = dVar.Ma;
                            bVar.Mb = dVar.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eMD);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eMD.bru().mNetErrorCode = -10;
                    this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR3 = this.eMJ.mR();
                    if (mR3 != null && mR3.mz() != null && handler != null) {
                        int i5 = mR3.my().mNetErrorCode;
                        int size2 = mR3.mz().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mR3.mz().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.rN(this.eMD.bru().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Em(dVar2.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LS);
                            bVar2.setUrl(dVar2.url);
                            bVar2.LZ = dVar2.LZ;
                            bVar2.Ma = dVar2.Ma;
                            bVar2.Mb = dVar2.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eMD);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eMD.bru().mNetErrorCode = -15;
                    this.eMD.bru().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR4 = this.eMJ.mR();
                    if (mR4 != null && mR4.mz() != null && handler != null) {
                        int i6 = mR4.my().mNetErrorCode;
                        int size3 = mR4.mz().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mR4.mz().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.rN(this.eMD.bru().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Em(dVar3.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LS);
                            bVar3.setUrl(dVar3.url);
                            bVar3.LZ = dVar3.LZ;
                            bVar3.Ma = dVar3.Ma;
                            bVar3.Mb = dVar3.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eMD);
                    return z2;
                }
            } finally {
                mR = this.eMJ.mR();
                if (mR != null && mR.mz() != null && handler != null) {
                    int i7 = mR.my().mNetErrorCode;
                    int size4 = mR.mz().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mR.mz().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.rN(this.eMD.bru().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Em(dVar4.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LS);
                        bVar4.setUrl(dVar4.url);
                        bVar4.LZ = dVar4.LZ;
                        bVar4.Ma = dVar4.Ma;
                        bVar4.Mb = dVar4.Mb;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eMD);
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
        return this.eMD.brt().brx().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eMD.brt().brx().mPostData != null) {
            this.eMD.brt().brx().mPostData.clear();
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
        if (this.eMD.brt().brx().mFileData == null) {
            this.eMD.brt().brx().mFileData = new HashMap<>();
        }
        this.eMD.brt().brx().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eMD.brt().brx().mPostData == null) {
                this.eMD.brt().brx().mPostData = new ArrayList<>();
            }
            int c = c(this.eMD.brt().brx().mPostData, basicNameValuePair.getName());
            int size = this.eMD.brt().brx().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eMD.brt().brx().mPostData.get(c).getName())) {
                    this.eMD.brt().brx().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eMD.brt().brx().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eMD.brt().brx().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bqQ() {
        if (this.eMD != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eMD.brt().brx().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eMD.brt().brx().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eMD.brt().brx().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eMD.brt().brx().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
