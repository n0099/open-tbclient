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
import com.baidu.tbadk.core.util.ac;
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
public class aa implements s {
    private static int eXM = 2097152;
    private final com.baidu.tbadk.core.util.b.a eXH;
    private com.baidu.adp.lib.network.a.a eXN = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.b.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eXH = aVar;
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
        if (this.eXN != null) {
            this.eXN.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.eXN.cancel();
    }

    private void b(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mo;
        if (this.eXH != null && this.eXN != null && (mo = this.eXN.mo()) != null) {
            long lQ = mo.lQ();
            long lR = mo.lR();
            long lO = mo.lO();
            long lS = mo.lS();
            long lT = mo.lT();
            long j3 = lQ - j;
            long j4 = lR - lQ;
            int lU = mo.lU();
            long j5 = lS - lR;
            long j6 = lO - lR;
            long j7 = lS - lO;
            long j8 = lT - lS;
            if (lT <= 0) {
                j8 = 0;
            }
            HashMap<String, String> bsJ = this.eXH.bsJ();
            bsJ.put("startTime", String.valueOf(System.currentTimeMillis()));
            bsJ.put("netConTime", String.valueOf(j3));
            bsJ.put("netRWTime", String.valueOf(j5));
            bsJ.put("firstByteTime", String.valueOf(j6));
            bsJ.put("allDataReadTime", String.valueOf(j7));
            bsJ.put("dataDeCompressTime", String.valueOf(j8));
            bsJ.put("httpRetryNum", String.valueOf(lU));
            bsJ.put("httpRetryCostTime", String.valueOf(j4));
            bsJ.put("dataParseTime", String.valueOf(j2 - lT));
            bsJ.put("isHttp", "1");
            bsJ.put("httpSize", String.valueOf(i));
            bsJ.put("errCode", String.valueOf(this.eXH.bsH().mNetErrorCode));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03a8 -> B:95:0x03a9). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
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
            if (this.eXH.bsG().bsK().mPostData != null && this.eXH.bsG().bsK().mPostData.size() > 0 && !this.eXH.bsG().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eXH.bsG().bsK().mUrl);
                if (this.eXH.bsG().bsK().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eXH.bsG().bsK().mUrl.endsWith("?") && !this.eXH.bsG().bsK().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eXH.bsG().bsK().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eXH.bsG().bsK().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(at.getUrlEncode(this.eXH.bsG().bsK().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eXH.bsG().bsK().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eXH.bsG().bsK().mRequestGzip || this.eXH.bsG().bsK().mIsBDImage) && !this.eXH.bsG().mIsFromCDN) {
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
        if (this.eXN.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.eXN.a(str, z, 5, 100, -1, -1, bsa());
        com.baidu.adp.lib.network.http.e mp = this.eXN.mp();
        if (mp == null) {
            return null;
        }
        gVar = mp.lW();
        if (mp != null) {
            try {
                if (mp.lX() != null && (size = mp.lX().size()) > 0) {
                    this.eXH.bsI().eZA = mp.lX().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eXH.bsH().mNetErrorCode = -14;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eXH);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -12;
                TiebaStatic.net(this.eXH);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -13;
                TiebaStatic.net(this.eXH);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eXH);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eXH.bsH().mNetErrorCode = gVar.responseCode;
        if (this.eXH.bsH().mNetErrorCode != 200) {
            this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eXH.bsI().eZA != null && !TextUtils.isEmpty(this.eXH.bsI().eZA.exception)) {
                this.eXH.bsH().mException = this.eXH.bsI().eZA.exception;
            } else {
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
            }
            TiebaStatic.net(this.eXH);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eXM) {
                    this.eXH.bsH().mNetErrorCode = -11;
                    TiebaStatic.net(this.eXH);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCx().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eXH.bsG().bsK().mUrl + "], size:" + i2);
                            this.eXH.bsH().mNetErrorCode = -16;
                            TiebaStatic.net(this.eXH);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ac.a aVar = new ac.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.eXH.bsI().eZA.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eXH.bsI().eZA.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.eXH.bsI().eZA.retry);
        TiebaStatic.net(this.eXH);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void AJ(String str) {
        this.eXH.bsH().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eXH.bsH().mServerErrorCode = errorData.getError_code();
                if (this.eXH.bsH().mServerErrorCode == -1) {
                    this.eXH.bsH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eXH.bsH().mServerErrorCode != 0) {
                    this.eXH.bsH().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eXH.bsH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.eXH.bsH().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eXH.bsG().bsK().charSet = TextUtils.isEmpty(this.eXH.bsG().bsK().charSet) ? "UTF-8" : this.eXH.bsG().bsK().charSet;
            str = new String(netData, 0, netData.length, this.eXH.bsG().bsK().charSet);
            try {
                AJ(str);
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

    @Override // com.baidu.tbadk.core.util.s
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
            if (this.eXH.bsG().bsK().mPostData == null || i3 >= this.eXH.bsG().bsK().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eXH.bsG().bsK().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eXH.bsG().bsK().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eXH.bsG().eXK) {
                addPostData("sig", StringU.DW(sb.toString()));
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
        if (this.eXN.isCanceled()) {
            return null;
        }
        if (this.eXN.a(this.eXH.bsG().bsK().mUrl, this.eXH.bsG().bsK().mPostData, this.eXH.bsG().bsK().mRequestGzip, 5, -1, bsa()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mp = this.eXN.mp();
        if (mp == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g lW = mp.lW();
        if (mp != null && mp.lX() != null && (size = mp.lX().size()) > 0) {
            this.eXH.bsI().eZA = mp.lX().get(size - 1);
        }
        this.eXH.bsH().mNetErrorCode = lW.responseCode;
        this.eXH.bsH().mHeader = lW.MG;
        if (this.eXH.bsH().mNetErrorCode != 200) {
            if (this.eXH.bsI().eZA != null && !TextUtils.isEmpty(this.eXH.bsI().eZA.exception)) {
                this.eXH.bsH().mException = this.eXH.bsI().eZA.exception;
            } else {
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
            }
            TiebaStatic.net(this.eXH);
            return null;
        } else if (this.eXN.isCanceled()) {
            return null;
        } else {
            str = new String(lW.retBytes, "utf-8");
            try {
                if (this.eXH.bsG().bsK().mIsBaiduServer && this.eXH.bsG().bsK().mIsJson) {
                    AJ(str);
                }
                i = lW.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ac.a aVar = new ac.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eXH.bsI().eZA.downloadSize;
                        aVar.mTime = this.eXH.bsI().eZA.Md;
                        aVar.mTimesNum = this.eXH.bsI().eZA.retry;
                        aVar.mMethod = 1;
                        ac.a(aVar);
                        ac.mErrorNums.set(this.eXH.bsI().eZA.retry);
                        TiebaStatic.net(this.eXH);
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str2 = str;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + e.getClass() + "|" + e.getMessage();
                        this.eXH.bsH().mNetErrorCode = -14;
                        str = str2;
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e8) {
                        e = e8;
                        this.eXH.bsH().mNetErrorCode = -10;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eXH);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        this.eXH.bsH().mNetErrorCode = -15;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eXH);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e10) {
                        e = e10;
                        this.eXH.bsH().mNetErrorCode = -12;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eXH);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e11) {
                        e = e11;
                        this.eXH.bsH().mNetErrorCode = -13;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eXH);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.eXH.bsH().mNetErrorCode = -10;
                        this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eXH);
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

    @Override // com.baidu.tbadk.core.util.s
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
        if (this.eXN.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.eXN.a(this.eXH.bsG().bsK().mUrl, this.eXH.bsG().bsK().mRequestGzip, this.eXH.bsG().bsK().mPostData, this.eXH.bsG().bsK().mFileData, 5, -1, bsa());
        this.eXH.bsH().mNetErrorCode = a2.responseCode;
        this.eXH.bsH().mHeader = a2.MG;
        if (this.eXH.bsH().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mp = this.eXN.mp();
            int i2 = 0;
            if (mp != null && mp.lX() != null) {
                i2 = mp.lX().size();
            }
            if (i2 <= 0 || (dVar = mp.lX().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.eXH.bsH().mException = str2;
            } else {
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
            }
            TiebaStatic.net(this.eXH);
            return null;
        } else if (this.eXN.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                AJ(str);
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
                    TiebaStatic.net(this.eXH);
                } catch (BdHttpCancelException e11) {
                    e = e11;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eXH.bsH().mNetErrorCode = -14;
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    this.eXH.bsH().mNetErrorCode = -15;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketException e13) {
                    this.eXH.bsH().mNetErrorCode = -12;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.eXH);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketTimeoutException e14) {
                    this.eXH.bsH().mNetErrorCode = -13;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.eXH);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (Exception e15) {
                    e = e15;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
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
    @Override // com.baidu.tbadk.core.util.s
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e mp;
        try {
            try {
                if (this.eXN.isCanceled()) {
                    return false;
                }
                z2 = this.eXN.a(this.eXH.bsG().bsK().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsa(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.aa.1
                    int eXO = 0;
                    int eXP = 0;
                    int eXQ = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.eXO = i5 / 50;
                        }
                        this.eXP += i4 - this.eXQ;
                        this.eXQ = i4;
                        if (handler != null) {
                            if (this.eXP > this.eXO || i4 == i5) {
                                this.eXP = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eXH.bsG().MA);
                try {
                    this.eXH.bsH().mNetErrorCode = this.eXN.mp().lW().responseCode;
                    com.baidu.adp.lib.network.http.e mp2 = this.eXN.mp();
                    if (mp2 != null && mp2.lX() != null && handler != null) {
                        int i4 = mp2.lW().mNetErrorCode;
                        int size = mp2.lX().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mp2.lX().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.rr(this.eXH.bsH().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Dh(dVar.Ml + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mi + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mj);
                            bVar.setUrl(dVar.url);
                            bVar.Mp = dVar.Mp;
                            bVar.Mq = dVar.Mq;
                            bVar.Mr = dVar.Mr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eXH);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mp3 = this.eXN.mp();
                    if (mp3 != null && mp3.lX() != null && handler != null) {
                        int i5 = mp3.lW().mNetErrorCode;
                        int size2 = mp3.lX().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mp3.lX().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.rr(this.eXH.bsH().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Dh(dVar2.Ml + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mi + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mj);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Mp = dVar2.Mp;
                            bVar2.Mq = dVar2.Mq;
                            bVar2.Mr = dVar2.Mr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eXH);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eXH.bsH().mNetErrorCode = -15;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mp4 = this.eXN.mp();
                    if (mp4 != null && mp4.lX() != null && handler != null) {
                        int i6 = mp4.lW().mNetErrorCode;
                        int size3 = mp4.lX().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mp4.lX().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.rr(this.eXH.bsH().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Dh(dVar3.Ml + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mi + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mj);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Mp = dVar3.Mp;
                            bVar3.Mq = dVar3.Mq;
                            bVar3.Mr = dVar3.Mr;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eXH);
                    return z2;
                }
            } finally {
                mp = this.eXN.mp();
                if (mp != null && mp.lX() != null && handler != null) {
                    int i7 = mp.lW().mNetErrorCode;
                    int size4 = mp.lX().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mp.lX().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.rr(this.eXH.bsH().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Dh(dVar4.Ml + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mh + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mi + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mj);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Mp = dVar4.Mp;
                        bVar4.Mq = dVar4.Mq;
                        bVar4.Mr = dVar4.Mr;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eXH);
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
        return this.eXH.bsG().bsK().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eXH.bsG().bsK().mPostData != null) {
            this.eXH.bsG().bsK().mPostData.clear();
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
        if (this.eXH.bsG().bsK().mFileData == null) {
            this.eXH.bsG().bsK().mFileData = new HashMap<>();
        }
        this.eXH.bsG().bsK().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eXH.bsG().bsK().mPostData == null) {
                this.eXH.bsG().bsK().mPostData = new ArrayList<>();
            }
            int c = c(this.eXH.bsG().bsK().mPostData, basicNameValuePair.getName());
            int size = this.eXH.bsG().bsK().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eXH.bsG().bsK().mPostData.get(c).getName())) {
                    this.eXH.bsG().bsK().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eXH.bsG().bsK().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eXH.bsG().bsK().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bsa() {
        if (this.eXH != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eXH.bsG().bsK().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eXH.bsG().bsK().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eXH.bsG().bsK().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eXH.bsG().bsK().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
