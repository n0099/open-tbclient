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
    private static int fcv = 2097152;
    private final com.baidu.tbadk.core.util.b.a fcq;
    private com.baidu.adp.lib.network.a.a fcw = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.b.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.fcq = aVar;
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
        if (this.fcw != null) {
            this.fcw.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.fcw.cancel();
    }

    private void b(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mo;
        if (this.fcq != null && this.fcw != null && (mo = this.fcw.mo()) != null) {
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
            HashMap<String, String> bwC = this.fcq.bwC();
            bwC.put("startTime", String.valueOf(System.currentTimeMillis()));
            bwC.put("netConTime", String.valueOf(j3));
            bwC.put("netRWTime", String.valueOf(j5));
            bwC.put("firstByteTime", String.valueOf(j6));
            bwC.put("allDataReadTime", String.valueOf(j7));
            bwC.put("dataDeCompressTime", String.valueOf(j8));
            bwC.put("httpRetryNum", String.valueOf(lU));
            bwC.put("httpRetryCostTime", String.valueOf(j4));
            bwC.put("dataParseTime", String.valueOf(j2 - lT));
            bwC.put("isHttp", "1");
            bwC.put("httpSize", String.valueOf(i));
            bwC.put("errCode", String.valueOf(this.fcq.bwA().mNetErrorCode));
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
            if (this.fcq.bwz().bwD().mPostData != null && this.fcq.bwz().bwD().mPostData.size() > 0 && !this.fcq.bwz().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.fcq.bwz().bwD().mUrl);
                if (this.fcq.bwz().bwD().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.fcq.bwz().bwD().mUrl.endsWith("?") && !this.fcq.bwz().bwD().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.fcq.bwz().bwD().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.fcq.bwz().bwD().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(at.getUrlEncode(this.fcq.bwz().bwD().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.fcq.bwz().bwD().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.fcq.bwz().bwD().mRequestGzip || this.fcq.bwz().bwD().mIsBDImage) && !this.fcq.bwz().mIsFromCDN) {
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
        if (this.fcw.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.fcw.a(str, z, 5, 100, -1, -1, bvT());
        com.baidu.adp.lib.network.http.e mp = this.fcw.mp();
        if (mp == null) {
            return null;
        }
        gVar = mp.lW();
        if (mp != null) {
            try {
                if (mp.lX() != null && (size = mp.lX().size()) > 0) {
                    this.fcq.bwB().fej = mp.lX().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.fcq.bwA().mNetErrorCode = -14;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej != null ? this.fcq.bwB().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwA().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fcq);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej != null ? this.fcq.bwB().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwA().mNetErrorCode = -12;
                TiebaStatic.net(this.fcq);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej != null ? this.fcq.bwB().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwA().mNetErrorCode = -13;
                TiebaStatic.net(this.fcq);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej != null ? this.fcq.bwB().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwA().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fcq);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.fcq.bwA().mNetErrorCode = gVar.responseCode;
        if (this.fcq.bwA().mNetErrorCode != 200) {
            this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.fcq.bwB().fej != null && !TextUtils.isEmpty(this.fcq.bwB().fej.exception)) {
                this.fcq.bwA().mException = this.fcq.bwB().fej.exception;
            } else {
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry);
            }
            TiebaStatic.net(this.fcq);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fcv) {
                    this.fcq.bwA().mNetErrorCode = -11;
                    TiebaStatic.net(this.fcq);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bGp().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.fcq.bwz().bwD().mUrl + "], size:" + i2);
                            this.fcq.bwA().mNetErrorCode = -16;
                            TiebaStatic.net(this.fcq);
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
        aVar.mSize = this.fcq.bwB().fej.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.fcq.bwB().fej.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.fcq.bwB().fej.retry);
        TiebaStatic.net(this.fcq);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void BV(String str) {
        this.fcq.bwA().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.fcq.bwA().mServerErrorCode = errorData.getError_code();
                if (this.fcq.bwA().mServerErrorCode == -1) {
                    this.fcq.bwA().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.fcq.bwA().mServerErrorCode != 0) {
                    this.fcq.bwA().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.fcq.bwA().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.fcq.bwA().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.fcq.bwz().bwD().charSet = TextUtils.isEmpty(this.fcq.bwz().bwD().charSet) ? "UTF-8" : this.fcq.bwz().bwD().charSet;
            str = new String(netData, 0, netData.length, this.fcq.bwz().bwD().charSet);
            try {
                BV(str);
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
            if (this.fcq.bwz().bwD().mPostData == null || i3 >= this.fcq.bwz().bwD().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fcq.bwz().bwD().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.fcq.bwz().bwD().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.fcq.bwz().fct) {
                addPostData("sig", StringU.Fi(sb.toString()));
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
        if (this.fcw.isCanceled()) {
            return null;
        }
        if (this.fcw.a(this.fcq.bwz().bwD().mUrl, this.fcq.bwz().bwD().mPostData, this.fcq.bwz().bwD().mRequestGzip, 5, -1, bvT()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mp = this.fcw.mp();
        if (mp == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g lW = mp.lW();
        if (mp != null && mp.lX() != null && (size = mp.lX().size()) > 0) {
            this.fcq.bwB().fej = mp.lX().get(size - 1);
        }
        this.fcq.bwA().mNetErrorCode = lW.responseCode;
        this.fcq.bwA().mHeader = lW.MI;
        if (this.fcq.bwA().mNetErrorCode != 200) {
            if (this.fcq.bwB().fej != null && !TextUtils.isEmpty(this.fcq.bwB().fej.exception)) {
                this.fcq.bwA().mException = this.fcq.bwB().fej.exception;
            } else {
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry);
            }
            TiebaStatic.net(this.fcq);
            return null;
        } else if (this.fcw.isCanceled()) {
            return null;
        } else {
            str = new String(lW.retBytes, "utf-8");
            try {
                if (this.fcq.bwz().bwD().mIsBaiduServer && this.fcq.bwz().bwD().mIsJson) {
                    BV(str);
                }
                i = lW.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ac.a aVar = new ac.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.fcq.bwB().fej.downloadSize;
                        aVar.mTime = this.fcq.bwB().fej.Mf;
                        aVar.mTimesNum = this.fcq.bwB().fej.retry;
                        aVar.mMethod = 1;
                        ac.a(aVar);
                        ac.mErrorNums.set(this.fcq.bwB().fej.retry);
                        TiebaStatic.net(this.fcq);
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str2 = str;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry) + "|" + e.getClass() + "|" + e.getMessage();
                        this.fcq.bwA().mNetErrorCode = -14;
                        str = str2;
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e8) {
                        e = e8;
                        this.fcq.bwA().mNetErrorCode = -10;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fcq);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        this.fcq.bwA().mNetErrorCode = -15;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fcq);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e10) {
                        e = e10;
                        this.fcq.bwA().mNetErrorCode = -12;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fcq);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e11) {
                        e = e11;
                        this.fcq.bwA().mNetErrorCode = -13;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fcq);
                        b(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.fcq.bwA().mNetErrorCode = -10;
                        this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.fcq);
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
        if (this.fcw.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.fcw.a(this.fcq.bwz().bwD().mUrl, this.fcq.bwz().bwD().mRequestGzip, this.fcq.bwz().bwD().mPostData, this.fcq.bwz().bwD().mFileData, 5, -1, bvT());
        this.fcq.bwA().mNetErrorCode = a2.responseCode;
        this.fcq.bwA().mHeader = a2.MI;
        if (this.fcq.bwA().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mp = this.fcw.mp();
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
                this.fcq.bwA().mException = str2;
            } else {
                this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry);
            }
            TiebaStatic.net(this.fcq);
            return null;
        } else if (this.fcw.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                BV(str);
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
                    TiebaStatic.net(this.fcq);
                } catch (BdHttpCancelException e11) {
                    e = e11;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fcq.bwA().mException = String.valueOf(this.fcq.bwA().mNetErrorCode) + "|retryCount:" + (this.fcq.bwB().fej == null ? -1 : this.fcq.bwB().fej.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fcq.bwA().mNetErrorCode = -14;
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    this.fcq.bwA().mNetErrorCode = -15;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketException e13) {
                    this.fcq.bwA().mNetErrorCode = -12;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.fcq);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (SocketTimeoutException e14) {
                    this.fcq.bwA().mNetErrorCode = -13;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.fcq);
                    b(currentTimeMillis, j, i);
                    return str;
                } catch (Exception e15) {
                    e = e15;
                    this.fcq.bwA().mNetErrorCode = -10;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
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
                if (this.fcw.isCanceled()) {
                    return false;
                }
                z2 = this.fcw.a(this.fcq.bwz().bwD().mUrl, (z ? new File(str) : n.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bvT(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.aa.1
                    int fcx = 0;
                    int fcy = 0;
                    int fcz = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.fcx = i5 / 50;
                        }
                        this.fcy += i4 - this.fcz;
                        this.fcz = i4;
                        if (handler != null) {
                            if (this.fcy > this.fcx || i4 == i5) {
                                this.fcy = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.fcq.bwz().MD);
                try {
                    this.fcq.bwA().mNetErrorCode = this.fcw.mp().lW().responseCode;
                    com.baidu.adp.lib.network.http.e mp2 = this.fcw.mp();
                    if (mp2 != null && mp2.lX() != null && handler != null) {
                        int i4 = mp2.lW().mNetErrorCode;
                        int size = mp2.lX().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mp2.lX().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.sX(this.fcq.bwA().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.Et(dVar.Mn + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Mk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Ml);
                            bVar.setUrl(dVar.url);
                            bVar.Mr = dVar.Mr;
                            bVar.Ms = dVar.Ms;
                            bVar.Mt = dVar.Mt;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.fcq);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.fcq.bwA().mNetErrorCode = -10;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mp3 = this.fcw.mp();
                    if (mp3 != null && mp3.lX() != null && handler != null) {
                        int i5 = mp3.lW().mNetErrorCode;
                        int size2 = mp3.lX().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mp3.lX().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.sX(this.fcq.bwA().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.Et(dVar2.Mn + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Mk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Ml);
                            bVar2.setUrl(dVar2.url);
                            bVar2.Mr = dVar2.Mr;
                            bVar2.Ms = dVar2.Ms;
                            bVar2.Mt = dVar2.Mt;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.fcq);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.fcq.bwA().mNetErrorCode = -15;
                    this.fcq.bwA().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mp4 = this.fcw.mp();
                    if (mp4 != null && mp4.lX() != null && handler != null) {
                        int i6 = mp4.lW().mNetErrorCode;
                        int size3 = mp4.lX().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mp4.lX().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.sX(this.fcq.bwA().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.Et(dVar3.Mn + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Mk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Ml);
                            bVar3.setUrl(dVar3.url);
                            bVar3.Mr = dVar3.Mr;
                            bVar3.Ms = dVar3.Ms;
                            bVar3.Mt = dVar3.Mt;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.fcq);
                    return z2;
                }
            } finally {
                mp = this.fcw.mp();
                if (mp != null && mp.lX() != null && handler != null) {
                    int i7 = mp.lW().mNetErrorCode;
                    int size4 = mp.lX().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mp.lX().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.sX(this.fcq.bwA().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.Et(dVar4.Mn + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.LR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Mk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Ml);
                        bVar4.setUrl(dVar4.url);
                        bVar4.Mr = dVar4.Mr;
                        bVar4.Ms = dVar4.Ms;
                        bVar4.Mt = dVar4.Mt;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.fcq);
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
        return this.fcq.bwz().bwD().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.fcq.bwz().bwD().mPostData != null) {
            this.fcq.bwz().bwD().mPostData.clear();
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
        if (this.fcq.bwz().bwD().mFileData == null) {
            this.fcq.bwz().bwD().mFileData = new HashMap<>();
        }
        this.fcq.bwz().bwD().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.fcq.bwz().bwD().mPostData == null) {
                this.fcq.bwz().bwD().mPostData = new ArrayList<>();
            }
            int c = c(this.fcq.bwz().bwD().mPostData, basicNameValuePair.getName());
            int size = this.fcq.bwz().bwD().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.fcq.bwz().bwD().mPostData.get(c).getName())) {
                    this.fcq.bwz().bwD().mPostData.set(c, basicNameValuePair);
                } else {
                    this.fcq.bwz().bwD().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.fcq.bwz().bwD().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bvT() {
        if (this.fcq != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.fcq.bwz().bwD().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.fcq.bwz().bwD().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.fcq.bwz().bwD().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.fcq.bwz().bwD().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
