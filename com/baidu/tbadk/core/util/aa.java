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
    private static int eal = 2097152;
    private final com.baidu.tbadk.core.util.a.a eag;
    private com.baidu.adp.lib.network.a.a eam = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.eag = aVar;
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
        if (this.eam != null) {
            this.eam.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.eam.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c ll;
        if (this.eag != null && this.eam != null && (ll = this.eam.ll()) != null) {
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
            HashMap<String, String> baZ = this.eag.baZ();
            baZ.put("startTime", String.valueOf(j));
            baZ.put("netConTime", String.valueOf(j3));
            baZ.put("netRWTime", String.valueOf(j5));
            baZ.put("firstByteReachTime", String.valueOf(j6));
            baZ.put("allDataReadTime", String.valueOf(j7));
            baZ.put("dataDeCompressTime", String.valueOf(j8));
            baZ.put("httpRetryNum", String.valueOf(kS));
            baZ.put("httpRetryCostTime", String.valueOf(j4));
            baZ.put("dataParseTime", String.valueOf(j2 - kR));
            baZ.put("isHttp", "1");
            baZ.put("httpSize", String.valueOf(i));
            baZ.put("errCode", String.valueOf(this.eag.baX().mNetErrorCode));
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
            if (this.eag.baW().bba().mPostData != null && this.eag.baW().bba().mPostData.size() > 0 && !this.eag.baW().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eag.baW().bba().mUrl);
                if (this.eag.baW().bba().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eag.baW().bba().mUrl.endsWith("?") && !this.eag.baW().bba().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eag.baW().bba().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eag.baW().bba().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(as.getUrlEncode(this.eag.baW().bba().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eag.baW().bba().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eag.baW().bba().mRequestGzip || this.eag.baW().bba().mIsBDImage) && !this.eag.baW().mIsFromCDN) {
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
        if (this.eam.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.eam.a(str, z, 5, 100, -1, -1, bay());
        com.baidu.adp.lib.network.http.e lm = this.eam.lm();
        if (lm == null) {
            return null;
        }
        gVar = lm.kU();
        if (lm != null) {
            try {
                if (lm.kV() != null && (size = lm.kV().size()) > 0) {
                    this.eag.baY().ebN = lm.kV().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eag.baX().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eag);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -12;
                TiebaStatic.net(this.eag);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -13;
                TiebaStatic.net(this.eag);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eag);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.eag.baX().mNetErrorCode = gVar.responseCode;
        if (this.eag.baX().mNetErrorCode != 200) {
            this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eag.baY().ebN != null && !TextUtils.isEmpty(this.eag.baY().ebN.exception)) {
                this.eag.baX().mException = this.eag.baY().ebN.exception;
            } else {
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
            }
            TiebaStatic.net(this.eag);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eal) {
                    this.eag.baX().mNetErrorCode = -11;
                    TiebaStatic.net(this.eag);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bkk().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eag.baW().bba().mUrl + "], size:" + i2);
                            this.eag.baX().mNetErrorCode = -16;
                            TiebaStatic.net(this.eag);
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
        aVar.mSize = this.eag.baY().ebN.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eag.baY().ebN.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.eag.baY().ebN.retry);
        TiebaStatic.net(this.eag);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void xM(String str) {
        this.eag.baX().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eag.baX().mServerErrorCode = errorData.getError_code();
                if (this.eag.baX().mServerErrorCode == -1) {
                    this.eag.baX().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eag.baX().mServerErrorCode != 0) {
                    this.eag.baX().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eag.baX().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eag.baX().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eag.baW().bba().charSet = TextUtils.isEmpty(this.eag.baW().bba().charSet) ? "UTF-8" : this.eag.baW().bba().charSet;
            str = new String(netData, 0, netData.length, this.eag.baW().bba().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            xM(str);
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
            if (this.eag.baW().bba().mPostData == null || i3 >= this.eag.baW().bba().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eag.baW().bba().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.eag.baW().bba().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.eag.baW().eaj) {
                addPostData("sig", StringU.AL(sb.toString()));
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
        if (this.eam.isCanceled()) {
            return null;
        }
        if (this.eam.a(this.eag.baW().bba().mUrl, this.eag.baW().bba().mPostData, this.eag.baW().bba().mRequestGzip, 5, -1, bay()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e lm = this.eam.lm();
        if (lm == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g kU = lm.kU();
        if (lm != null && lm.kV() != null && (size = lm.kV().size()) > 0) {
            this.eag.baY().ebN = lm.kV().get(size - 1);
        }
        this.eag.baX().mNetErrorCode = kU.responseCode;
        this.eag.baX().mHeader = kU.Lf;
        if (this.eag.baX().mNetErrorCode != 200) {
            if (this.eag.baY().ebN != null && !TextUtils.isEmpty(this.eag.baY().ebN.exception)) {
                this.eag.baX().mException = this.eag.baY().ebN.exception;
            } else {
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
            }
            TiebaStatic.net(this.eag);
            return null;
        } else if (this.eam.isCanceled()) {
            return null;
        } else {
            str = new String(kU.retBytes, "utf-8");
            try {
                if (this.eag.baW().bba().mIsBaiduServer && this.eag.baW().bba().mIsJson) {
                    xM(str);
                }
                i = kU.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ac.a aVar = new ac.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.eag.baY().ebN.downloadSize;
                        aVar.mTime = this.eag.baY().ebN.KE;
                        aVar.mTimesNum = this.eag.baY().ebN.retry;
                        aVar.mMethod = 1;
                        ac.a(aVar);
                        ac.mErrorNums.set(this.eag.baY().ebN.retry);
                        TiebaStatic.net(this.eag);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.eag.baX().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.eag.baX().mNetErrorCode = -15;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.eag.baX().mNetErrorCode = -12;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.eag.baX().mNetErrorCode = -13;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.eag.baX().mNetErrorCode = -10;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.eag.baX().mNetErrorCode = -10;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.eag);
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
        if (this.eam.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.eam.a(this.eag.baW().bba().mUrl, this.eag.baW().bba().mRequestGzip, this.eag.baW().bba().mPostData, this.eag.baW().bba().mFileData, 5, -1, bay());
        this.eag.baX().mNetErrorCode = a.responseCode;
        this.eag.baX().mHeader = a.Lf;
        if (this.eag.baX().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e lm = this.eam.lm();
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
                this.eag.baX().mException = str2;
            } else {
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
            }
            TiebaStatic.net(this.eag);
            return null;
        } else if (this.eam.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                xM(str);
                i = a.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.eag);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.eag.baX().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.eag.baX().mNetErrorCode = -15;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.eag.baX().mNetErrorCode = -12;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.eag.baX().mNetErrorCode = -13;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.eag);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.eag.baX().mNetErrorCode = -10;
                        this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.eag);
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
        com.baidu.adp.lib.network.http.e lm;
        try {
            try {
                if (this.eam.isCanceled()) {
                    return false;
                }
                z2 = this.eam.a(this.eag.baW().bba().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bay(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.aa.1
                    int ean = 0;
                    int eao = 0;
                    int eap = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.ean = i5 / 50;
                        }
                        this.eao += i4 - this.eap;
                        this.eap = i4;
                        if (handler != null) {
                            if (this.eao > this.ean || i4 == i5) {
                                this.eao = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.eag.baW().Lb);
                try {
                    this.eag.baX().mNetErrorCode = this.eam.lm().kU().responseCode;
                    com.baidu.adp.lib.network.http.e lm2 = this.eam.lm();
                    if (lm2 != null && lm2.kV() != null && handler != null) {
                        int i4 = lm2.kU().mNetErrorCode;
                        int size = lm2.kV().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = lm2.kV().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.os(this.eag.baX().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Ag(dVar.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.KK);
                            bVar.setUrl(dVar.url);
                            bVar.KQ = dVar.KQ;
                            bVar.KR = dVar.KR;
                            bVar.KS = dVar.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.eag);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.eag.baX().mNetErrorCode = -10;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e lm3 = this.eam.lm();
                    if (lm3 != null && lm3.kV() != null && handler != null) {
                        int i5 = lm3.kU().mNetErrorCode;
                        int size2 = lm3.kV().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = lm3.kV().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.os(this.eag.baX().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Ag(dVar2.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.KK);
                            bVar2.setUrl(dVar2.url);
                            bVar2.KQ = dVar2.KQ;
                            bVar2.KR = dVar2.KR;
                            bVar2.KS = dVar2.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.eag);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.eag.baX().mNetErrorCode = -15;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e lm4 = this.eam.lm();
                    if (lm4 != null && lm4.kV() != null && handler != null) {
                        int i6 = lm4.kU().mNetErrorCode;
                        int size3 = lm4.kV().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = lm4.kV().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.os(this.eag.baX().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Ag(dVar3.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.KK);
                            bVar3.setUrl(dVar3.url);
                            bVar3.KQ = dVar3.KQ;
                            bVar3.KR = dVar3.KR;
                            bVar3.KS = dVar3.KS;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.eag);
                    return z2;
                }
            } finally {
                lm = this.eam.lm();
                if (lm != null && lm.kV() != null && handler != null) {
                    int i7 = lm.kU().mNetErrorCode;
                    int size4 = lm.kV().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = lm.kV().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.os(this.eag.baX().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Ag(dVar4.KM + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Kq + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KI + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KJ + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.KK);
                        bVar4.setUrl(dVar4.url);
                        bVar4.KQ = dVar4.KQ;
                        bVar4.KR = dVar4.KR;
                        bVar4.KS = dVar4.KS;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.eag);
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
        return this.eag.baW().bba().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eag.baW().bba().mPostData != null) {
            this.eag.baW().bba().mPostData.clear();
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
        if (this.eag.baW().bba().mFileData == null) {
            this.eag.baW().bba().mFileData = new HashMap<>();
        }
        this.eag.baW().bba().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eag.baW().bba().mPostData == null) {
                this.eag.baW().bba().mPostData = new ArrayList<>();
            }
            int c = c(this.eag.baW().bba().mPostData, basicNameValuePair.getName());
            int size = this.eag.baW().bba().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eag.baW().bba().mPostData.get(c).getName())) {
                    this.eag.baW().bba().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eag.baW().bba().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eag.baW().bba().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bay() {
        if (this.eag != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eag.baW().bba().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eag.baW().bba().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.eag.baW().bba().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eag.baW().bba().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
