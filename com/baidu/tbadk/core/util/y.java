package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
    private static int cVo = 2097152;
    private final com.baidu.tbadk.core.util.a.a cVj;
    private com.baidu.adp.lib.network.a.a cVp = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.cVj = aVar;
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
        if (this.cVp != null) {
            this.cVp.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.cVp.cancel();
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
            if (this.cVj.aEu().aEx().mPostData != null && this.cVj.aEu().aEx().mPostData.size() > 0 && !this.cVj.aEu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cVj.aEu().aEx().mUrl);
                if (this.cVj.aEu().aEx().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cVj.aEu().aEx().mUrl.endsWith("?") && !this.cVj.aEu().aEx().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.cVj.aEu().aEx().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.cVj.aEu().aEx().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.cVj.aEu().aEx().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cVj.aEu().aEx().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cVj.aEu().aEx().mRequestGzip || this.cVj.aEu().aEx().mIsBDImage) && !this.cVj.aEu().mIsFromCDN) {
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
        if (this.cVp.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.cVp.a(str, z, 5, 100, -1, -1, aDX());
        com.baidu.adp.lib.network.http.e gq = this.cVp.gq();
        if (gq == null) {
            return null;
        }
        gVar = gq.fY();
        if (gq != null) {
            try {
                if (gq.fZ() != null && (size = gq.fZ().size()) > 0) {
                    this.cVj.aEw().cWJ = gq.fZ().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cVj.aEv().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ != null ? this.cVj.aEw().cWJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cVj.aEv().mNetErrorCode = -12;
                TiebaStatic.net(this.cVj);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ != null ? this.cVj.aEw().cWJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cVj.aEv().mNetErrorCode = -13;
                TiebaStatic.net(this.cVj);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ != null ? this.cVj.aEw().cWJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cVj.aEv().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cVj);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ != null ? this.cVj.aEw().cWJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cVj.aEv().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cVj);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.cVj.aEv().mNetErrorCode = gVar.responseCode;
        if (this.cVj.aEv().mNetErrorCode != 200) {
            this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cVj.aEw().cWJ != null && !TextUtils.isEmpty(this.cVj.aEw().cWJ.exception)) {
                this.cVj.aEv().mException = this.cVj.aEw().cWJ.exception;
            } else {
                this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry);
            }
            TiebaStatic.net(this.cVj);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cVo) {
                    this.cVj.aEv().mNetErrorCode = -11;
                    TiebaStatic.net(this.cVj);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aNs().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cVj.aEu().aEx().mUrl + "], size:" + i2);
                            this.cVj.aEv().mNetErrorCode = -16;
                            TiebaStatic.net(this.cVj);
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
        aVar.mSize = this.cVj.aEw().cWJ.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cVj.aEw().cWJ.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cVj.aEw().cWJ.retry);
        TiebaStatic.net(this.cVj);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void tc(String str) {
        this.cVj.aEv().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cVj.aEv().mServerErrorCode = errorData.getError_code();
                if (this.cVj.aEv().mServerErrorCode == -1) {
                    this.cVj.aEv().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cVj.aEv().mServerErrorCode != 0) {
                    this.cVj.aEv().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cVj.aEv().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cVj.aEv().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cVj.aEu().aEx().charSet = TextUtils.isEmpty(this.cVj.aEu().aEx().charSet) ? "UTF-8" : this.cVj.aEu().aEx().charSet;
            str = new String(netData, 0, netData.length, this.cVj.aEu().aEx().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            tc(str);
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
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.cVj.aEu().aEx().mPostData == null || i2 >= this.cVj.aEu().aEx().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cVj.aEu().aEx().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cVj.aEu().aEx().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.cVj.aEu().cVm) {
                addPostData("sig", StringU.vT(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.cVp.isCanceled()) {
                return null;
            }
            if (this.cVp.a(this.cVj.aEu().aEx().mUrl, this.cVj.aEu().aEx().mPostData, this.cVj.aEu().aEx().mRequestGzip, 5, -1, aDX()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gq = this.cVp.gq();
            if (gq == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fY = gq.fY();
            if (gq != null && gq.fZ() != null && (size = gq.fZ().size()) > 0) {
                this.cVj.aEw().cWJ = gq.fZ().get(size - 1);
            }
            this.cVj.aEv().mNetErrorCode = fY.responseCode;
            this.cVj.aEv().mHeader = fY.rp;
            if (this.cVj.aEv().mNetErrorCode != 200) {
                if (this.cVj.aEw().cWJ != null && !TextUtils.isEmpty(this.cVj.aEw().cWJ.exception)) {
                    this.cVj.aEv().mException = this.cVj.aEw().cWJ.exception;
                } else {
                    this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry);
                }
                TiebaStatic.net(this.cVj);
                return null;
            } else if (this.cVp.isCanceled()) {
                return null;
            } else {
                str = new String(fY.retBytes, "utf-8");
                try {
                    if (this.cVj.aEu().aEx().mIsBaiduServer && this.cVj.aEu().aEx().mIsJson) {
                        tc(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cVj.aEw().cWJ.downloadSize;
                    aVar.mTime = this.cVj.aEw().cWJ.qN;
                    aVar.mTimesNum = this.cVj.aEw().cWJ.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cVj.aEw().cWJ.retry);
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cVj.aEv().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.cVj.aEv().mNetErrorCode = -15;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.cVj.aEv().mNetErrorCode = -12;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.cVj.aEv().mNetErrorCode = -13;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.cVj.aEv().mNetErrorCode = -10;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cVj.aEv().mNetErrorCode = -10;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (SocketException e11) {
            e4 = e11;
            str = null;
        } catch (SocketTimeoutException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String postMultiNetData() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.cVp.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.cVp.a(this.cVj.aEu().aEx().mUrl, this.cVj.aEu().aEx().mRequestGzip, this.cVj.aEu().aEx().mPostData, this.cVj.aEu().aEx().mFileData, 5, -1, aDX());
            this.cVj.aEv().mNetErrorCode = a.responseCode;
            this.cVj.aEv().mHeader = a.rp;
            if (this.cVj.aEv().mNetErrorCode != 200) {
                com.baidu.adp.lib.network.http.e gq = this.cVp.gq();
                int i = 0;
                if (gq != null && gq.fZ() != null) {
                    i = gq.fZ().size();
                }
                if (i <= 0 || (dVar = gq.fZ().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.exception;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.cVj.aEv().mException = str2;
                } else {
                    this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry);
                }
                TiebaStatic.net(this.cVj);
                return null;
            } else if (this.cVp.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.retBytes, "UTF-8");
                try {
                    tc(str);
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cVj.aEv().mException = String.valueOf(this.cVj.aEv().mNetErrorCode) + "|retryCount:" + (this.cVj.aEw().cWJ == null ? -1 : this.cVj.aEw().cWJ.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cVj.aEv().mNetErrorCode = -14;
                    return str;
                } catch (SocketException e5) {
                    this.cVj.aEv().mNetErrorCode = -12;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.cVj.aEv().mNetErrorCode = -13;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.cVj.aEv().mNetErrorCode = -10;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.cVj.aEv().mNetErrorCode = -15;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cVj);
                    return str;
                }
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e2 = e10;
            str = null;
        } catch (SocketException e11) {
            str = null;
        } catch (SocketTimeoutException e12) {
            str = null;
        } catch (Exception e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [705=5, 706=5, 707=5, 708=5, 709=5, 710=5, 711=5, 712=5, 713=5, 714=5, 715=5, 717=5, 718=5, 719=5, 720=5, 722=5, 724=5, 725=4] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.e gq;
        try {
            try {
                if (this.cVp.isCanceled()) {
                    return false;
                }
                z2 = this.cVp.a(this.cVj.aEu().aEx().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aDX(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int cVq = 0;
                    int cVr = 0;
                    int cVs = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void j(int i4, int i5) {
                        if (i5 > 0) {
                            this.cVq = i5 / 50;
                        }
                        this.cVr += i4 - this.cVs;
                        this.cVs = i4;
                        if (handler != null) {
                            if (this.cVr > this.cVq || i4 == i5) {
                                this.cVr = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.cVj.aEu().rk);
                try {
                    this.cVj.aEv().mNetErrorCode = this.cVp.gq().fY().responseCode;
                    com.baidu.adp.lib.network.http.e gq2 = this.cVp.gq();
                    if (gq2 != null && gq2.fZ() != null && handler != null) {
                        int i4 = gq2.fY().mNetErrorCode;
                        int size = gq2.fZ().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = gq2.fZ().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.mx(this.cVj.aEv().mNetErrorCode);
                            bVar.aq(dVar.exception);
                            bVar.vm(dVar.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qT);
                            bVar.setUrl(dVar.url);
                            bVar.qY = dVar.qY;
                            bVar.qZ = dVar.qZ;
                            bVar.ra = dVar.ra;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.cVj);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.cVj.aEv().mNetErrorCode = -10;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e gq3 = this.cVp.gq();
                    if (gq3 != null && gq3.fZ() != null && handler != null) {
                        int i5 = gq3.fY().mNetErrorCode;
                        int size2 = gq3.fZ().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = gq3.fZ().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.mx(this.cVj.aEv().mNetErrorCode);
                            bVar2.aq(dVar2.exception);
                            bVar2.vm(dVar2.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qT);
                            bVar2.setUrl(dVar2.url);
                            bVar2.qY = dVar2.qY;
                            bVar2.qZ = dVar2.qZ;
                            bVar2.ra = dVar2.ra;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.cVj);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.cVj.aEv().mNetErrorCode = -15;
                    this.cVj.aEv().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e gq4 = this.cVp.gq();
                    if (gq4 != null && gq4.fZ() != null && handler != null) {
                        int i6 = gq4.fY().mNetErrorCode;
                        int size3 = gq4.fZ().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = gq4.fZ().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.mx(this.cVj.aEv().mNetErrorCode);
                            bVar3.aq(dVar3.exception);
                            bVar3.vm(dVar3.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qT);
                            bVar3.setUrl(dVar3.url);
                            bVar3.qY = dVar3.qY;
                            bVar3.qZ = dVar3.qZ;
                            bVar3.ra = dVar3.ra;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.cVj);
                    return z2;
                }
            } finally {
                gq = this.cVp.gq();
                if (gq != null && gq.fZ() != null && handler != null) {
                    int i7 = gq.fY().mNetErrorCode;
                    int size4 = gq.fZ().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = gq.fZ().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.mx(this.cVj.aEv().mNetErrorCode);
                        bVar4.aq(dVar4.exception);
                        bVar4.vm(dVar4.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qT);
                        bVar4.setUrl(dVar4.url);
                        bVar4.qY = dVar4.qY;
                        bVar4.qZ = dVar4.qZ;
                        bVar4.ra = dVar4.ra;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.cVj);
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
        return this.cVj.aEu().aEx().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cVj.aEu().aEx().mPostData != null) {
            this.cVj.aEu().aEx().mPostData.clear();
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
        if (this.cVj.aEu().aEx().mFileData == null) {
            this.cVj.aEu().aEx().mFileData = new HashMap<>();
        }
        this.cVj.aEu().aEx().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cVj.aEu().aEx().mPostData == null) {
                this.cVj.aEu().aEx().mPostData = new ArrayList<>();
            }
            int c = c(this.cVj.aEu().aEx().mPostData, basicNameValuePair.getName());
            int size = this.cVj.aEu().aEx().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.cVj.aEu().aEx().mPostData.get(c).getName())) {
                    this.cVj.aEu().aEx().mPostData.set(c, basicNameValuePair);
                } else {
                    this.cVj.aEu().aEx().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.cVj.aEu().aEx().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aDX() {
        if (this.cVj != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cVj.aEu().aEx().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cVj.aEu().aEx().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.cVj.aEu().aEx().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cVj.aEu().aEx().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
