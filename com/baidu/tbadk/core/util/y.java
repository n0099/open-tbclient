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
    private static int cZF = 2097152;
    private final com.baidu.tbadk.core.util.a.a cZA;
    private com.baidu.adp.lib.network.a.a cZG = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.cZA = aVar;
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
        if (this.cZG != null) {
            this.cZG.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.cZG.cancel();
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
            if (this.cZA.aGL().aGO().mPostData != null && this.cZA.aGL().aGO().mPostData.size() > 0 && !this.cZA.aGL().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cZA.aGL().aGO().mUrl);
                if (this.cZA.aGL().aGO().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cZA.aGL().aGO().mUrl.endsWith("?") && !this.cZA.aGL().aGO().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.cZA.aGL().aGO().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.cZA.aGL().aGO().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.cZA.aGL().aGO().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cZA.aGL().aGO().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cZA.aGL().aGO().mRequestGzip || this.cZA.aGL().aGO().mIsBDImage) && !this.cZA.aGL().mIsFromCDN) {
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
        if (this.cZG.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.cZG.a(str, z, 5, 100, -1, -1, aGn());
        com.baidu.adp.lib.network.http.e gq = this.cZG.gq();
        if (gq == null) {
            return null;
        }
        gVar = gq.fY();
        if (gq != null) {
            try {
                if (gq.fZ() != null && (size = gq.fZ().size()) > 0) {
                    this.cZA.aGN().dbb = gq.fZ().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cZA.aGM().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -12;
                TiebaStatic.net(this.cZA);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -13;
                TiebaStatic.net(this.cZA);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cZA);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cZA);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.cZA.aGM().mNetErrorCode = gVar.responseCode;
        if (this.cZA.aGM().mNetErrorCode != 200) {
            this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cZA.aGN().dbb != null && !TextUtils.isEmpty(this.cZA.aGN().dbb.exception)) {
                this.cZA.aGM().mException = this.cZA.aGN().dbb.exception;
            } else {
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
            }
            TiebaStatic.net(this.cZA);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cZF) {
                    this.cZA.aGM().mNetErrorCode = -11;
                    TiebaStatic.net(this.cZA);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aPV().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cZA.aGL().aGO().mUrl + "], size:" + i2);
                            this.cZA.aGM().mNetErrorCode = -16;
                            TiebaStatic.net(this.cZA);
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
        aVar.mSize = this.cZA.aGN().dbb.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cZA.aGN().dbb.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cZA.aGN().dbb.retry);
        TiebaStatic.net(this.cZA);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void ts(String str) {
        this.cZA.aGM().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cZA.aGM().mServerErrorCode = errorData.getError_code();
                if (this.cZA.aGM().mServerErrorCode == -1) {
                    this.cZA.aGM().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cZA.aGM().mServerErrorCode != 0) {
                    this.cZA.aGM().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cZA.aGM().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cZA.aGM().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cZA.aGL().aGO().charSet = TextUtils.isEmpty(this.cZA.aGL().aGO().charSet) ? "UTF-8" : this.cZA.aGL().aGO().charSet;
            str = new String(netData, 0, netData.length, this.cZA.aGL().aGO().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            ts(str);
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
            if (this.cZA.aGL().aGO().mPostData == null || i2 >= this.cZA.aGL().aGO().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cZA.aGL().aGO().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cZA.aGL().aGO().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.cZA.aGL().cZD) {
                addPostData("sig", StringU.wp(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.cZG.isCanceled()) {
                return null;
            }
            if (this.cZG.a(this.cZA.aGL().aGO().mUrl, this.cZA.aGL().aGO().mPostData, this.cZA.aGL().aGO().mRequestGzip, 5, -1, aGn()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gq = this.cZG.gq();
            if (gq == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fY = gq.fY();
            if (gq != null && gq.fZ() != null && (size = gq.fZ().size()) > 0) {
                this.cZA.aGN().dbb = gq.fZ().get(size - 1);
            }
            this.cZA.aGM().mNetErrorCode = fY.responseCode;
            this.cZA.aGM().mHeader = fY.rq;
            if (this.cZA.aGM().mNetErrorCode != 200) {
                if (this.cZA.aGN().dbb != null && !TextUtils.isEmpty(this.cZA.aGN().dbb.exception)) {
                    this.cZA.aGM().mException = this.cZA.aGN().dbb.exception;
                } else {
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
                }
                TiebaStatic.net(this.cZA);
                return null;
            } else if (this.cZG.isCanceled()) {
                return null;
            } else {
                str = new String(fY.retBytes, "utf-8");
                try {
                    if (this.cZA.aGL().aGO().mIsBaiduServer && this.cZA.aGL().aGO().mIsJson) {
                        ts(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cZA.aGN().dbb.downloadSize;
                    aVar.mTime = this.cZA.aGN().dbb.qN;
                    aVar.mTimesNum = this.cZA.aGN().dbb.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cZA.aGN().dbb.retry);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cZA.aGM().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.cZA.aGM().mNetErrorCode = -15;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.cZA.aGM().mNetErrorCode = -12;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.cZA.aGM().mNetErrorCode = -13;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cZA);
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
            if (this.cZG.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.cZG.a(this.cZA.aGL().aGO().mUrl, this.cZA.aGL().aGO().mRequestGzip, this.cZA.aGL().aGO().mPostData, this.cZA.aGL().aGO().mFileData, 5, -1, aGn());
            this.cZA.aGM().mNetErrorCode = a.responseCode;
            this.cZA.aGM().mHeader = a.rq;
            if (this.cZA.aGM().mNetErrorCode != 200) {
                com.baidu.adp.lib.network.http.e gq = this.cZG.gq();
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
                    this.cZA.aGM().mException = str2;
                } else {
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
                }
                TiebaStatic.net(this.cZA);
                return null;
            } else if (this.cZG.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.retBytes, "UTF-8");
                try {
                    ts(str);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cZA.aGM().mNetErrorCode = -14;
                    return str;
                } catch (SocketException e5) {
                    this.cZA.aGM().mNetErrorCode = -12;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.cZA.aGM().mNetErrorCode = -13;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.cZA.aGM().mNetErrorCode = -15;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cZA);
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
                if (this.cZG.isCanceled()) {
                    return false;
                }
                z2 = this.cZG.a(this.cZA.aGL().aGO().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aGn(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int cZH = 0;
                    int cZI = 0;
                    int cZJ = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void k(int i4, int i5) {
                        if (i5 > 0) {
                            this.cZH = i5 / 50;
                        }
                        this.cZI += i4 - this.cZJ;
                        this.cZJ = i4;
                        if (handler != null) {
                            if (this.cZI > this.cZH || i4 == i5) {
                                this.cZI = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.cZA.aGL().rl);
                try {
                    this.cZA.aGM().mNetErrorCode = this.cZG.gq().fY().responseCode;
                    com.baidu.adp.lib.network.http.e gq2 = this.cZG.gq();
                    if (gq2 != null && gq2.fZ() != null && handler != null) {
                        int i4 = gq2.fY().mNetErrorCode;
                        int size = gq2.fZ().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = gq2.fZ().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.mQ(this.cZA.aGM().mNetErrorCode);
                            bVar.aq(dVar.exception);
                            bVar.vI(dVar.qV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qT);
                            bVar.setUrl(dVar.url);
                            bVar.qZ = dVar.qZ;
                            bVar.ra = dVar.ra;
                            bVar.rb = dVar.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.cZA);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e gq3 = this.cZG.gq();
                    if (gq3 != null && gq3.fZ() != null && handler != null) {
                        int i5 = gq3.fY().mNetErrorCode;
                        int size2 = gq3.fZ().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = gq3.fZ().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.mQ(this.cZA.aGM().mNetErrorCode);
                            bVar2.aq(dVar2.exception);
                            bVar2.vI(dVar2.qV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qT);
                            bVar2.setUrl(dVar2.url);
                            bVar2.qZ = dVar2.qZ;
                            bVar2.ra = dVar2.ra;
                            bVar2.rb = dVar2.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.cZA);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.cZA.aGM().mNetErrorCode = -15;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.e gq4 = this.cZG.gq();
                    if (gq4 != null && gq4.fZ() != null && handler != null) {
                        int i6 = gq4.fY().mNetErrorCode;
                        int size3 = gq4.fZ().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = gq4.fZ().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.mQ(this.cZA.aGM().mNetErrorCode);
                            bVar3.aq(dVar3.exception);
                            bVar3.vI(dVar3.qV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qT);
                            bVar3.setUrl(dVar3.url);
                            bVar3.qZ = dVar3.qZ;
                            bVar3.ra = dVar3.ra;
                            bVar3.rb = dVar3.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.cZA);
                    return z2;
                }
            } finally {
                gq = this.cZG.gq();
                if (gq != null && gq.fZ() != null && handler != null) {
                    int i7 = gq.fY().mNetErrorCode;
                    int size4 = gq.fZ().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = gq.fZ().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.mQ(this.cZA.aGM().mNetErrorCode);
                        bVar4.aq(dVar4.exception);
                        bVar4.vI(dVar4.qV + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qR + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qS + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qT);
                        bVar4.setUrl(dVar4.url);
                        bVar4.qZ = dVar4.qZ;
                        bVar4.ra = dVar4.ra;
                        bVar4.rb = dVar4.rb;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.cZA);
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
        return this.cZA.aGL().aGO().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cZA.aGL().aGO().mPostData != null) {
            this.cZA.aGL().aGO().mPostData.clear();
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
        if (this.cZA.aGL().aGO().mFileData == null) {
            this.cZA.aGL().aGO().mFileData = new HashMap<>();
        }
        this.cZA.aGL().aGO().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cZA.aGL().aGO().mPostData == null) {
                this.cZA.aGL().aGO().mPostData = new ArrayList<>();
            }
            int c = c(this.cZA.aGL().aGO().mPostData, basicNameValuePair.getName());
            int size = this.cZA.aGL().aGO().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.cZA.aGL().aGO().mPostData.get(c).getName())) {
                    this.cZA.aGL().aGO().mPostData.set(c, basicNameValuePair);
                } else {
                    this.cZA.aGL().aGO().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.cZA.aGL().aGO().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> aGn() {
        if (this.cZA != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cZA.aGL().aGO().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cZA.aGL().aGO().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.cZA.aGL().aGO().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cZA.aGL().aGO().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
