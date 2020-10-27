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
    private static int eGT = 2097152;
    private final com.baidu.tbadk.core.util.a.a eGO;
    private com.baidu.adp.lib.network.a.a eGU = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eGO = aVar;
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
        if (this.eGU != null) {
            this.eGU.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.eGU.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mQ;
        if (this.eGO != null && this.eGU != null && (mQ = this.eGU.mQ()) != null) {
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
            HashMap<String, String> boW = this.eGO.boW();
            boW.put("startTime", String.valueOf(System.currentTimeMillis()));
            boW.put("netConTime", String.valueOf(j3));
            boW.put("netRWTime", String.valueOf(j5));
            boW.put("firstByteTime", String.valueOf(j6));
            boW.put("allDataReadTime", String.valueOf(j7));
            boW.put("dataDeCompressTime", String.valueOf(j8));
            boW.put("httpRetryNum", String.valueOf(mw));
            boW.put("httpRetryCostTime", String.valueOf(j4));
            boW.put("dataParseTime", String.valueOf(j2 - mv));
            boW.put("isHttp", "1");
            boW.put("httpSize", String.valueOf(i));
            boW.put("errCode", String.valueOf(this.eGO.boU().mNetErrorCode));
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
            if (this.eGO.boT().boX().mPostData != null && this.eGO.boT().boX().mPostData.size() > 0 && !this.eGO.boT().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eGO.boT().boX().mUrl);
                if (this.eGO.boT().boX().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eGO.boT().boX().mUrl.endsWith("?") && !this.eGO.boT().boX().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eGO.boT().boX().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eGO.boT().boX().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.eGO.boT().boX().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eGO.boT().boX().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eGO.boT().boX().mRequestGzip || this.eGO.boT().boX().mIsBDImage) && !this.eGO.boT().mIsFromCDN) {
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
        if (this.eGU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.eGU.a(str, z, 5, 100, -1, -1, boq());
        com.baidu.adp.lib.network.http.e mR = this.eGU.mR();
        if (mR == null) {
            return null;
        }
        gVar = mR.my();
        if (mR != null) {
            try {
                if (mR.mz() != null && (size = mR.mz().size()) > 0) {
                    this.eGO.boV().eIB = mR.mz().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eGO.boU().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eGO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -12;
                TiebaStatic.net(this.eGO);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -13;
                TiebaStatic.net(this.eGO);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eGO);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eGO.boU().mNetErrorCode = gVar.responseCode;
        if (this.eGO.boU().mNetErrorCode != 200) {
            this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eGO.boV().eIB != null && !TextUtils.isEmpty(this.eGO.boV().eIB.exception)) {
                this.eGO.boU().mException = this.eGO.boV().eIB.exception;
            } else {
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
            }
            TiebaStatic.net(this.eGO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eGT) {
                    this.eGO.boU().mNetErrorCode = -11;
                    TiebaStatic.net(this.eGO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.byE().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eGO.boT().boX().mUrl + "], size:" + i2);
                            this.eGO.boU().mNetErrorCode = -16;
                            TiebaStatic.net(this.eGO);
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
        aVar.mSize = this.eGO.boV().eIB.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eGO.boV().eIB.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eGO.boV().eIB.retry);
        TiebaStatic.net(this.eGO);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void BC(String str) {
        this.eGO.boU().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eGO.boU().mServerErrorCode = errorData.getError_code();
                if (this.eGO.boU().mServerErrorCode == -1) {
                    this.eGO.boU().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eGO.boU().mServerErrorCode != 0) {
                    this.eGO.boU().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eGO.boU().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eGO.boU().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eGO.boT().boX().charSet = TextUtils.isEmpty(this.eGO.boT().boX().charSet) ? "UTF-8" : this.eGO.boT().boX().charSet;
            str = new String(netData, 0, netData.length, this.eGO.boT().boX().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            BC(str);
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
            if (this.eGO.boT().boX().mPostData == null || i3 >= this.eGO.boT().boX().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eGO.boT().boX().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eGO.boT().boX().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eGO.boT().eGR) {
                addPostData("sig", StringU.EH(sb.toString()));
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
        if (this.eGU.isCanceled()) {
            return null;
        }
        if (this.eGU.a(this.eGO.boT().boX().mUrl, this.eGO.boT().boX().mPostData, this.eGO.boT().boX().mRequestGzip, 5, -1, boq()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mR = this.eGU.mR();
        if (mR == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g my = mR.my();
        if (mR != null && mR.mz() != null && (size = mR.mz().size()) > 0) {
            this.eGO.boV().eIB = mR.mz().get(size - 1);
        }
        this.eGO.boU().mNetErrorCode = my.responseCode;
        this.eGO.boU().mHeader = my.Mp;
        if (this.eGO.boU().mNetErrorCode != 200) {
            if (this.eGO.boV().eIB != null && !TextUtils.isEmpty(this.eGO.boV().eIB.exception)) {
                this.eGO.boU().mException = this.eGO.boV().eIB.exception;
            } else {
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
            }
            TiebaStatic.net(this.eGO);
            return null;
        } else if (this.eGU.isCanceled()) {
            return null;
        } else {
            str = new String(my.retBytes, "utf-8");
            try {
                if (this.eGO.boT().boX().mIsBaiduServer && this.eGO.boT().boX().mIsJson) {
                    BC(str);
                }
                i = my.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eGO.boV().eIB.downloadSize;
                        aVar.mTime = this.eGO.boV().eIB.LK;
                        aVar.mTimesNum = this.eGO.boV().eIB.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.eGO.boV().eIB.retry);
                        TiebaStatic.net(this.eGO);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.eGO.boU().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.eGO.boU().mNetErrorCode = -15;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.eGO.boU().mNetErrorCode = -12;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.eGO.boU().mNetErrorCode = -13;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.eGO.boU().mNetErrorCode = -10;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.eGO.boU().mNetErrorCode = -10;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eGO);
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
        if (this.eGU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.eGU.a(this.eGO.boT().boX().mUrl, this.eGO.boT().boX().mRequestGzip, this.eGO.boT().boX().mPostData, this.eGO.boT().boX().mFileData, 5, -1, boq());
        this.eGO.boU().mNetErrorCode = a2.responseCode;
        this.eGO.boU().mHeader = a2.Mp;
        if (this.eGO.boU().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mR = this.eGU.mR();
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
                this.eGO.boU().mException = str2;
            } else {
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
            }
            TiebaStatic.net(this.eGO);
            return null;
        } else if (this.eGU.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                BC(str);
                i = a2.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.eGO);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.eGO.boU().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.eGO.boU().mNetErrorCode = -15;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.eGO.boU().mNetErrorCode = -12;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.eGO.boU().mNetErrorCode = -13;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eGO);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.eGO.boU().mNetErrorCode = -10;
                        this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eGO);
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
                if (this.eGU.isCanceled()) {
                    return false;
                }
                z2 = this.eGU.a(this.eGO.boT().boX().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, boq(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int eGV = 0;
                    int eGW = 0;
                    int eGX = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.eGV = i5 / 50;
                        }
                        this.eGW += i4 - this.eGX;
                        this.eGX = i4;
                        if (handler != null) {
                            if (this.eGW > this.eGV || i4 == i5) {
                                this.eGW = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eGO.boT().Mk);
                try {
                    this.eGO.boU().mNetErrorCode = this.eGU.mR().my().responseCode;
                    com.baidu.adp.lib.network.http.e mR2 = this.eGU.mR();
                    if (mR2 != null && mR2.mz() != null && handler != null) {
                        int i4 = mR2.my().mNetErrorCode;
                        int size = mR2.mz().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mR2.mz().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.rD(this.eGO.boU().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.DY(dVar.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LS);
                            bVar.setUrl(dVar.url);
                            bVar.LZ = dVar.LZ;
                            bVar.Ma = dVar.Ma;
                            bVar.Mb = dVar.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eGO);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eGO.boU().mNetErrorCode = -10;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR3 = this.eGU.mR();
                    if (mR3 != null && mR3.mz() != null && handler != null) {
                        int i5 = mR3.my().mNetErrorCode;
                        int size2 = mR3.mz().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mR3.mz().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.rD(this.eGO.boU().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.DY(dVar2.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LS);
                            bVar2.setUrl(dVar2.url);
                            bVar2.LZ = dVar2.LZ;
                            bVar2.Ma = dVar2.Ma;
                            bVar2.Mb = dVar2.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eGO);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eGO.boU().mNetErrorCode = -15;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mR4 = this.eGU.mR();
                    if (mR4 != null && mR4.mz() != null && handler != null) {
                        int i6 = mR4.my().mNetErrorCode;
                        int size3 = mR4.mz().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mR4.mz().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.rD(this.eGO.boU().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.DY(dVar3.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LS);
                            bVar3.setUrl(dVar3.url);
                            bVar3.LZ = dVar3.LZ;
                            bVar3.Ma = dVar3.Ma;
                            bVar3.Mb = dVar3.Mb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eGO);
                    return z2;
                }
            } finally {
                mR = this.eGU.mR();
                if (mR != null && mR.mz() != null && handler != null) {
                    int i7 = mR.my().mNetErrorCode;
                    int size4 = mR.mz().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mR.mz().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.rD(this.eGO.boU().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.DY(dVar4.LV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lt + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LQ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LS);
                        bVar4.setUrl(dVar4.url);
                        bVar4.LZ = dVar4.LZ;
                        bVar4.Ma = dVar4.Ma;
                        bVar4.Mb = dVar4.Mb;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eGO);
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
        return this.eGO.boT().boX().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eGO.boT().boX().mPostData != null) {
            this.eGO.boT().boX().mPostData.clear();
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
        if (this.eGO.boT().boX().mFileData == null) {
            this.eGO.boT().boX().mFileData = new HashMap<>();
        }
        this.eGO.boT().boX().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eGO.boT().boX().mPostData == null) {
                this.eGO.boT().boX().mPostData = new ArrayList<>();
            }
            int c = c(this.eGO.boT().boX().mPostData, basicNameValuePair.getName());
            int size = this.eGO.boT().boX().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eGO.boT().boX().mPostData.get(c).getName())) {
                    this.eGO.boT().boX().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eGO.boT().boX().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eGO.boT().boX().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> boq() {
        if (this.eGO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eGO.boT().boX().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eGO.boT().boX().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eGO.boT().boX().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eGO.boT().boX().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
