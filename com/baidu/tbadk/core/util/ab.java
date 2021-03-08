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
    private static int fbA = 2097152;
    private com.baidu.adp.lib.network.a.a fbB = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.b.a fbv;
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.b.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.fbv = aVar;
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
        if (this.fbB != null) {
            this.fbB.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void cancelNetConnect() {
        this.fbB.cancel();
    }

    private void a(long j, long j2, int i) {
        com.baidu.adp.lib.network.http.c mn;
        if (this.fbv != null && this.fbB != null && (mn = this.fbB.mn()) != null) {
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
            HashMap<String, String> btg = this.fbv.btg();
            btg.put("startTime", String.valueOf(System.currentTimeMillis()));
            btg.put("netConTime", String.valueOf(j3));
            btg.put("netRWTime", String.valueOf(j5));
            btg.put("firstByteTime", String.valueOf(j6));
            btg.put("allDataReadTime", String.valueOf(j7));
            btg.put("dataDeCompressTime", String.valueOf(j8));
            btg.put("httpRetryNum", String.valueOf(lT));
            btg.put("httpRetryCostTime", String.valueOf(j4));
            btg.put("dataParseTime", String.valueOf(j2 - lS));
            btg.put("isHttp", "1");
            btg.put("httpSize", String.valueOf(i));
            btg.put("errCode", String.valueOf(this.fbv.bte().mNetErrorCode));
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
            if (this.fbv.btd().bth().mPostData != null && this.fbv.btd().bth().mPostData.size() > 0 && !this.fbv.btd().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.fbv.btd().bth().mUrl);
                if (this.fbv.btd().bth().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.fbv.btd().bth().mUrl.endsWith("?") && !this.fbv.btd().bth().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.fbv.btd().bth().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.fbv.btd().bth().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(au.getUrlEncode(this.fbv.btd().bth().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.fbv.btd().bth().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.fbv.btd().bth().mRequestGzip || this.fbv.btd().bth().mIsBDImage) && !this.fbv.btd().mIsFromCDN) {
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
        if (this.fbB.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.fbB.a(str, z, 5, 100, -1, -1, bsx());
        com.baidu.adp.lib.network.http.e mo = this.fbB.mo();
        if (mo == null) {
            return null;
        }
        gVar = mo.lV();
        if (mo != null) {
            try {
                if (mo.lW() != null && (size = mo.lW().size()) > 0) {
                    this.fbv.btf().fdp = mo.lW().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.fbv.bte().mNetErrorCode = -14;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fbv);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -12;
                TiebaStatic.net(this.fbv);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -13;
                TiebaStatic.net(this.fbv);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fbv);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.fbv.bte().mNetErrorCode = gVar.responseCode;
        if (this.fbv.bte().mNetErrorCode != 200) {
            this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.fbv.btf().fdp != null && !TextUtils.isEmpty(this.fbv.btf().fdp.exception)) {
                this.fbv.bte().mException = this.fbv.btf().fdp.exception;
            } else {
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
            }
            TiebaStatic.net(this.fbv);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fbA) {
                    this.fbv.bte().mNetErrorCode = -11;
                    TiebaStatic.net(this.fbv);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCS().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.fbv.btd().bth().mUrl + "], size:" + i2);
                            this.fbv.bte().mNetErrorCode = -16;
                            TiebaStatic.net(this.fbv);
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
        aVar.mSize = this.fbv.btf().fdp.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.fbv.btf().fdp.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.fbv.btf().fdp.retry);
        TiebaStatic.net(this.fbv);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void Bh(String str) {
        this.fbv.bte().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.fbv.bte().mServerErrorCode = errorData.getError_code();
                if (this.fbv.bte().mServerErrorCode == -1) {
                    this.fbv.bte().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.fbv.bte().mServerErrorCode != 0) {
                    this.fbv.bte().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.fbv.bte().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.fbv.bte().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.fbv.btd().bth().charSet = TextUtils.isEmpty(this.fbv.btd().bth().charSet) ? "UTF-8" : this.fbv.btd().bth().charSet;
            str = new String(netData, 0, netData.length, this.fbv.btd().bth().charSet);
            try {
                Bh(str);
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
            if (this.fbv.btd().bth().mPostData == null || i3 >= this.fbv.btd().bth().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fbv.btd().bth().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i2 = i3 + 1;
        }
        if (this.fbv.btd().bth().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.fbv.btd().fby) {
                addPostData("sig", StringU.Ez(sb.toString()));
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
        if (this.fbB.isCanceled()) {
            return null;
        }
        if (this.fbB.a(this.fbv.btd().bth().mUrl, this.fbv.btd().bth().mPostData, this.fbv.btd().bth().mRequestGzip, 5, -1, bsx()) == null) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.e mo = this.fbB.mo();
        if (mo == null) {
            return null;
        }
        com.baidu.adp.lib.network.http.g lV = mo.lV();
        if (mo != null && mo.lW() != null && (size = mo.lW().size()) > 0) {
            this.fbv.btf().fdp = mo.lW().get(size - 1);
        }
        this.fbv.bte().mNetErrorCode = lV.responseCode;
        this.fbv.bte().mHeader = lV.Oe;
        if (this.fbv.bte().mNetErrorCode != 200) {
            if (this.fbv.btf().fdp != null && !TextUtils.isEmpty(this.fbv.btf().fdp.exception)) {
                this.fbv.bte().mException = this.fbv.btf().fdp.exception;
            } else {
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
            }
            TiebaStatic.net(this.fbv);
            return null;
        } else if (this.fbB.isCanceled()) {
            return null;
        } else {
            str = new String(lV.retBytes, "utf-8");
            try {
                if (this.fbv.btd().bth().mIsBaiduServer && this.fbv.btd().bth().mIsJson) {
                    Bh(str);
                }
                i = lV.retBytes.length;
                try {
                    j = System.currentTimeMillis();
                    try {
                        ad.a aVar = new ad.a();
                        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                        aVar.mSize = this.fbv.btf().fdp.downloadSize;
                        aVar.mTime = this.fbv.btf().fdp.Nw;
                        aVar.mTimesNum = this.fbv.btf().fdp.retry;
                        aVar.mMethod = 1;
                        ad.a(aVar);
                        ad.mErrorNums.set(this.fbv.btf().fdp.retry);
                        TiebaStatic.net(this.fbv);
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str2 = str;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + e.getClass() + "|" + e.getMessage();
                        this.fbv.bte().mNetErrorCode = -14;
                        str = str2;
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e8) {
                        e = e8;
                        this.fbv.bte().mNetErrorCode = -10;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fbv);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        this.fbv.bte().mNetErrorCode = -15;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fbv);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e10) {
                        e = e10;
                        this.fbv.bte().mNetErrorCode = -12;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fbv);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e11) {
                        e = e11;
                        this.fbv.bte().mNetErrorCode = -13;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.fbv);
                        a(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.fbv.bte().mNetErrorCode = -10;
                        this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.fbv);
                        a(currentTimeMillis, j, i);
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
            a(currentTimeMillis, j, i);
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
        if (this.fbB.isCanceled()) {
            throw new BdHttpCancelException();
        }
        com.baidu.adp.lib.network.http.g a2 = this.fbB.a(this.fbv.btd().bth().mUrl, this.fbv.btd().bth().mRequestGzip, this.fbv.btd().bth().mPostData, this.fbv.btd().bth().mFileData, 5, -1, bsx());
        this.fbv.bte().mNetErrorCode = a2.responseCode;
        this.fbv.bte().mHeader = a2.Oe;
        if (this.fbv.bte().mNetErrorCode != 200) {
            com.baidu.adp.lib.network.http.e mo = this.fbB.mo();
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
                this.fbv.bte().mException = str2;
            } else {
                this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
            }
            TiebaStatic.net(this.fbv);
            return null;
        } else if (this.fbB.isCanceled()) {
            throw new BdHttpCancelException();
        } else {
            str = new String(a2.retBytes, "UTF-8");
            try {
                Bh(str);
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
                    TiebaStatic.net(this.fbv);
                } catch (BdHttpCancelException e11) {
                    e = e11;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fbv.bte().mException = String.valueOf(this.fbv.bte().mNetErrorCode) + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fbv.bte().mNetErrorCode = -14;
                    a(currentTimeMillis, j, i);
                    return str;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    this.fbv.bte().mNetErrorCode = -15;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    a(currentTimeMillis, j, i);
                    return str;
                } catch (SocketException e13) {
                    this.fbv.bte().mNetErrorCode = -12;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.fbv);
                    a(currentTimeMillis, j, i);
                    return str;
                } catch (SocketTimeoutException e14) {
                    this.fbv.bte().mNetErrorCode = -13;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.fbv);
                    a(currentTimeMillis, j, i);
                    return str;
                } catch (Exception e15) {
                    e = e15;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    a(currentTimeMillis, j, i);
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
            a(currentTimeMillis, j, i);
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
                if (this.fbB.isCanceled()) {
                    return false;
                }
                z2 = this.fbB.a(this.fbv.btd().bth().mUrl, (z ? new File(str) : o.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsx(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.ab.1
                    int fbC = 0;
                    int fbD = 0;
                    int fbE = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void onProgress(int i4, int i5) {
                        if (i5 > 0) {
                            this.fbC = i5 / 50;
                        }
                        this.fbD += i4 - this.fbE;
                        this.fbE = i4;
                        if (handler != null) {
                            if (this.fbD > this.fbC || i4 == i5) {
                                this.fbD = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.fbv.btd().NZ);
                try {
                    this.fbv.bte().mNetErrorCode = this.fbB.mo().lV().responseCode;
                    com.baidu.adp.lib.network.http.e mo2 = this.fbB.mo();
                    if (mo2 != null && mo2.lW() != null && handler != null) {
                        int i4 = mo2.lV().mNetErrorCode;
                        int size = mo2.lW().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = mo2.lW().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.ry(this.fbv.bte().mNetErrorCode);
                            bVar.setException(dVar.exception);
                            bVar.DD(dVar.NH + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.Nj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.NC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.ND + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.NF);
                            bVar.setUrl(dVar.url);
                            bVar.NM = dVar.NM;
                            bVar.NN = dVar.NN;
                            bVar.NP = dVar.NP;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.fbv);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mo3 = this.fbB.mo();
                    if (mo3 != null && mo3.lW() != null && handler != null) {
                        int i5 = mo3.lV().mNetErrorCode;
                        int size2 = mo3.lW().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = mo3.lW().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.ry(this.fbv.bte().mNetErrorCode);
                            bVar2.setException(dVar2.exception);
                            bVar2.DD(dVar2.NH + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.Nj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.NC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.ND + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.NF);
                            bVar2.setUrl(dVar2.url);
                            bVar2.NM = dVar2.NM;
                            bVar2.NN = dVar2.NN;
                            bVar2.NP = dVar2.NP;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.fbv);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.fbv.bte().mNetErrorCode = -15;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e mo4 = this.fbB.mo();
                    if (mo4 != null && mo4.lW() != null && handler != null) {
                        int i6 = mo4.lV().mNetErrorCode;
                        int size3 = mo4.lW().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = mo4.lW().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.ry(this.fbv.bte().mNetErrorCode);
                            bVar3.setException(dVar3.exception);
                            bVar3.DD(dVar3.NH + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.Nj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.NC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.ND + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.NF);
                            bVar3.setUrl(dVar3.url);
                            bVar3.NM = dVar3.NM;
                            bVar3.NN = dVar3.NN;
                            bVar3.NP = dVar3.NP;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.fbv);
                    return z2;
                }
            } finally {
                mo = this.fbB.mo();
                if (mo != null && mo.lW() != null && handler != null) {
                    int i7 = mo.lV().mNetErrorCode;
                    int size4 = mo.lW().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = mo.lW().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.ry(this.fbv.bte().mNetErrorCode);
                        bVar4.setException(dVar4.exception);
                        bVar4.DD(dVar4.NH + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.Nj + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.NC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.ND + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.NF);
                        bVar4.setUrl(dVar4.url);
                        bVar4.NM = dVar4.NM;
                        bVar4.NN = dVar4.NN;
                        bVar4.NP = dVar4.NP;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.fbv);
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
        return this.fbv.btd().bth().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.fbv.btd().bth().mPostData != null) {
            this.fbv.btd().bth().mPostData.clear();
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
        if (this.fbv.btd().bth().mFileData == null) {
            this.fbv.btd().bth().mFileData = new HashMap<>();
        }
        this.fbv.btd().bth().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.fbv.btd().bth().mPostData == null) {
                this.fbv.btd().bth().mPostData = new ArrayList<>();
            }
            int c = c(this.fbv.btd().bth().mPostData, basicNameValuePair.getName());
            int size = this.fbv.btd().bth().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.fbv.btd().bth().mPostData.get(c).getName())) {
                    this.fbv.btd().bth().mPostData.set(c, basicNameValuePair);
                } else {
                    this.fbv.btd().bth().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.fbv.btd().bth().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> bsx() {
        if (this.fbv != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.fbv.btd().bth().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.fbv.btd().bth().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.fbv.btd().bth().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.fbv.btd().bth().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
