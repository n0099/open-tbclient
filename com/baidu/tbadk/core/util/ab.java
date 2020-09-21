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
    private static int emm = 2097152;
    private final com.baidu.tbadk.core.util.a.a emh;
    private com.baidu.adp.lib.network.a.a emn = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.emh = aVar;
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
        if (this.emn != null) {
            this.emn.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.emn.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mP;
        if (this.emh != null && this.emn != null && (mP = this.emn.mP()) != null) {
            long mr = mP.mr();
            long ms = mP.ms();
            long mp = mP.mp();
            long mt = mP.mt();
            long mu = mP.mu();
            long j3 = mr - j;
            long j4 = ms - mr;
            int mv = mP.mv();
            long j5 = mt - ms;
            long j6 = mp - ms;
            long j7 = mt - mp;
            long j8 = mu - mt;
            if (mu <= 0) {
                j8 = 0;
            }
            HashMap<String, String> bkt = this.emh.bkt();
            bkt.put("startTime", String.valueOf(System.currentTimeMillis()));
            bkt.put("netConTime", String.valueOf(j3));
            bkt.put("netRWTime", String.valueOf(j5));
            bkt.put("firstByteReachTime", String.valueOf(j6));
            bkt.put("allDataReadTime", String.valueOf(j7));
            bkt.put("dataDeCompressTime", String.valueOf(j8));
            bkt.put("httpRetryNum", String.valueOf(mv));
            bkt.put("httpRetryCostTime", String.valueOf(j4));
            bkt.put("dataParseTime", String.valueOf(j2 - mu));
            bkt.put("isHttp", "1");
            bkt.put("httpSize", String.valueOf(i));
            bkt.put("errCode", String.valueOf(this.emh.bkr().mNetErrorCode));
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
            if (this.emh.bkq().bku().mPostData != null && this.emh.bkq().bku().mPostData.size() > 0 && !this.emh.bkq().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.emh.bkq().bku().mUrl);
                if (this.emh.bkq().bku().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.emh.bkq().bku().mUrl.endsWith("?") && !this.emh.bkq().bku().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.emh.bkq().bku().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.emh.bkq().bku().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.emh.bkq().bku().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.emh.bkq().bku().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.emh.bkq().bku().mRequestGzip || this.emh.bkq().bku().mIsBDImage) && !this.emh.bkq().mIsFromCDN) {
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
        if (this.emn.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.emn.a(str, z, 5, 100, -1, -1, bjO());
        com.baidu.adp.lib.network.http.e mQ = this.emn.mQ();
        if (mQ == null) {
            return null;
        }
        gVar = mQ.mx();
        if (mQ != null) {
            try {
                if (mQ.my() != null && (size = mQ.my().size()) > 0) {
                    this.emh.bks().enS = mQ.my().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.emh.bkr().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.emh);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -12;
                TiebaStatic.net(this.emh);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -13;
                TiebaStatic.net(this.emh);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.emh);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.emh.bkr().mNetErrorCode = gVar.responseCode;
        if (this.emh.bkr().mNetErrorCode != 200) {
            this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.emh.bks().enS != null && !TextUtils.isEmpty(this.emh.bks().enS.exception)) {
                this.emh.bkr().mException = this.emh.bks().enS.exception;
            } else {
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
            }
            TiebaStatic.net(this.emh);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > emm) {
                    this.emh.bkr().mNetErrorCode = -11;
                    TiebaStatic.net(this.emh);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bub().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.emh.bkq().bku().mUrl + "], size:" + i2);
                            this.emh.bkr().mNetErrorCode = -16;
                            TiebaStatic.net(this.emh);
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
        aVar.mSize = this.emh.bks().enS.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.emh.bks().enS.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.emh.bks().enS.retry);
        TiebaStatic.net(this.emh);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void Ax(String str) {
        this.emh.bkr().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.emh.bkr().mServerErrorCode = errorData.getError_code();
                if (this.emh.bkr().mServerErrorCode == -1) {
                    this.emh.bkr().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.emh.bkr().mServerErrorCode != 0) {
                    this.emh.bkr().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.emh.bkr().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.emh.bkr().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.emh.bkq().bku().charSet = TextUtils.isEmpty(this.emh.bkq().bku().charSet) ? "UTF-8" : this.emh.bkq().bku().charSet;
            str = new String(netData, 0, netData.length, this.emh.bkq().bku().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            Ax(str);
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
            if (this.emh.bkq().bku().mPostData == null || i3 >= this.emh.bkq().bku().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.emh.bkq().bku().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.emh.bkq().bku().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.emh.bkq().emk) {
                addPostData("sig", StringU.DD(sb.toString()));
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
        if (this.emn.isCanceled()) {
            return null;
        }
        if (this.emn.a(this.emh.bkq().bku().mUrl, this.emh.bkq().bku().mPostData, this.emh.bkq().bku().mRequestGzip, 5, -1, bjO()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mQ = this.emn.mQ();
        if (mQ == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g mx = mQ.mx();
        if (mQ != null && mQ.my() != null && (size = mQ.my().size()) > 0) {
            this.emh.bks().enS = mQ.my().get(size - 1);
        }
        this.emh.bkr().mNetErrorCode = mx.responseCode;
        this.emh.bkr().mHeader = mx.LY;
        if (this.emh.bkr().mNetErrorCode != 200) {
            if (this.emh.bks().enS != null && !TextUtils.isEmpty(this.emh.bks().enS.exception)) {
                this.emh.bkr().mException = this.emh.bks().enS.exception;
            } else {
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
            }
            TiebaStatic.net(this.emh);
            return null;
        } else if (this.emn.isCanceled()) {
            return null;
        } else {
            str = new String(mx.retBytes, "utf-8");
            try {
                if (this.emh.bkq().bku().mIsBaiduServer && this.emh.bkq().bku().mIsJson) {
                    Ax(str);
                }
                i = mx.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.emh.bks().enS.downloadSize;
                        aVar.mTime = this.emh.bks().enS.Lr;
                        aVar.mTimesNum = this.emh.bks().enS.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.emh.bks().enS.retry);
                        TiebaStatic.net(this.emh);
                    } catch (BdHttpCancelException e10) {
                        bdHttpCancelException = e10;
                        str2 = str;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                        this.emh.bkr().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e4 = e11;
                        this.emh.bkr().mNetErrorCode = -15;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e12) {
                        e3 = e12;
                        this.emh.bkr().mNetErrorCode = -12;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e2 = e13;
                        this.emh.bkr().mNetErrorCode = -13;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e14) {
                        e = e14;
                        this.emh.bkr().mNetErrorCode = -10;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        this.emh.bkr().mNetErrorCode = -10;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.emh);
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
        if (this.emn.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a = this.emn.a(this.emh.bkq().bku().mUrl, this.emh.bkq().bku().mRequestGzip, this.emh.bkq().bku().mPostData, this.emh.bkq().bku().mFileData, 5, -1, bjO());
        this.emh.bkr().mNetErrorCode = a.responseCode;
        this.emh.bkr().mHeader = a.LY;
        if (this.emh.bkr().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mQ = this.emn.mQ();
            int i2 = 0;
            if (mQ != null && mQ.my() != null) {
                i2 = mQ.my().size();
            }
            if (i2 <= 0 || (dVar = mQ.my().get(i2 - 1)) == null) {
                str2 = "";
            } else {
                str2 = dVar.exception;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.emh.bkr().mException = str2;
            } else {
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
            }
            TiebaStatic.net(this.emh);
            return null;
        } else if (this.emn.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a.retBytes, "UTF-8");
            try {
                Ax(str);
                i = a.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        TiebaStatic.net(this.emh);
                    } catch (BdHttpCancelException e9) {
                        e3 = e9;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.emh.bkr().mNetErrorCode = -14;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e2 = e10;
                        this.emh.bkr().mNetErrorCode = -15;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e11) {
                        this.emh.bkr().mNetErrorCode = -12;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        this.emh.bkr().mNetErrorCode = -13;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        TiebaStatic.net(this.emh);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e13) {
                        e = e13;
                        this.emh.bkr().mNetErrorCode = -10;
                        this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.emh);
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
        com.baidu.adp.lib.network.http.e mQ;
        try {
            try {
                if (this.emn.isCanceled()) {
                    return false;
                }
                z2 = this.emn.a(this.emh.bkq().bku().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bjO(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int emo = 0;
                    int emp = 0;
                    int emq = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.emo = i5 / 50;
                        }
                        this.emp += i4 - this.emq;
                        this.emq = i4;
                        if (handler != null) {
                            if (this.emp > this.emo || i4 == i5) {
                                this.emp = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.emh.bkq().LS);
                try {
                    this.emh.bkr().mNetErrorCode = this.emn.mQ().mx().responseCode;
                    com.baidu.adp.lib.network.http.e mQ2 = this.emn.mQ();
                    if (mQ2 != null && mQ2.my() != null && handler != null) {
                        int i4 = mQ2.mx().mNetErrorCode;
                        int size = mQ2.my().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mQ2.my().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.qU(this.emh.bkr().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.CT(dVar.Lz + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Ld + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lv + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lw + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Lx);
                            bVar.setUrl(dVar.url);
                            bVar.LD = dVar.LD;
                            bVar.LG = dVar.LG;
                            bVar.LH = dVar.LH;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.emh);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.emh.bkr().mNetErrorCode = -10;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mQ3 = this.emn.mQ();
                    if (mQ3 != null && mQ3.my() != null && handler != null) {
                        int i5 = mQ3.mx().mNetErrorCode;
                        int size2 = mQ3.my().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mQ3.my().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.qU(this.emh.bkr().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.CT(dVar2.Lz + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Ld + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lv + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lw + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Lx);
                            bVar2.setUrl(dVar2.url);
                            bVar2.LD = dVar2.LD;
                            bVar2.LG = dVar2.LG;
                            bVar2.LH = dVar2.LH;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.emh);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.emh.bkr().mNetErrorCode = -15;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mQ4 = this.emn.mQ();
                    if (mQ4 != null && mQ4.my() != null && handler != null) {
                        int i6 = mQ4.mx().mNetErrorCode;
                        int size3 = mQ4.my().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mQ4.my().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.qU(this.emh.bkr().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.CT(dVar3.Lz + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Ld + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lv + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lw + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Lx);
                            bVar3.setUrl(dVar3.url);
                            bVar3.LD = dVar3.LD;
                            bVar3.LG = dVar3.LG;
                            bVar3.LH = dVar3.LH;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.emh);
                    return z2;
                }
            } finally {
                mQ = this.emn.mQ();
                if (mQ != null && mQ.my() != null && handler != null) {
                    int i7 = mQ.mx().mNetErrorCode;
                    int size4 = mQ.my().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mQ.my().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.qU(this.emh.bkr().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.CT(dVar4.Lz + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Ld + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lv + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lw + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Lx);
                        bVar4.setUrl(dVar4.url);
                        bVar4.LD = dVar4.LD;
                        bVar4.LG = dVar4.LG;
                        bVar4.LH = dVar4.LH;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.emh);
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
        return this.emh.bkq().bku().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.emh.bkq().bku().mPostData != null) {
            this.emh.bkq().bku().mPostData.clear();
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
        if (this.emh.bkq().bku().mFileData == null) {
            this.emh.bkq().bku().mFileData = new HashMap<>();
        }
        this.emh.bkq().bku().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.emh.bkq().bku().mPostData == null) {
                this.emh.bkq().bku().mPostData = new ArrayList<>();
            }
            int c = c(this.emh.bkq().bku().mPostData, basicNameValuePair.getName());
            int size = this.emh.bkq().bku().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.emh.bkq().bku().mPostData.get(c).getName())) {
                    this.emh.bkq().bku().mPostData.set(c, basicNameValuePair);
                } else {
                    this.emh.bkq().bku().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.emh.bkq().bku().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bjO() {
        if (this.emh != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.emh.bkq().bku().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.emh.bkq().bku().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.emh.bkq().bku().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.emh.bkq().bku().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
