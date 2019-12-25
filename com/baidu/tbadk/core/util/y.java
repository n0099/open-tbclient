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
    private static int cVe = 2097152;
    private final com.baidu.tbadk.core.util.a.a cUZ;
    private com.baidu.adp.lib.network.a.a cVf = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.cUZ = aVar;
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
        if (this.cVf != null) {
            this.cVf.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.cVf.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        com.baidu.adp.lib.network.http.h hVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.adp.lib.network.http.h hVar2;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.cUZ.aEb().aEe().mPostData != null && this.cUZ.aEb().aEe().mPostData.size() > 0 && !this.cUZ.aEb().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cUZ.aEb().aEe().mUrl);
                if (this.cUZ.aEb().aEe().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cUZ.aEb().aEe().mUrl.endsWith("?") && !this.cUZ.aEb().aEe().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.cUZ.aEb().aEe().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.cUZ.aEb().aEe().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.cUZ.aEb().aEe().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cUZ.aEb().aEe().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cUZ.aEb().aEe().mRequestGzip || this.cUZ.aEb().aEe().mIsBDImage) && !this.cUZ.aEb().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            hVar2 = null;
        } catch (Exception e2) {
            e = e2;
            hVar = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            hVar = null;
        } catch (SocketException e4) {
            e = e4;
            hVar = null;
        } catch (SocketTimeoutException e5) {
            e = e5;
            hVar = null;
        }
        if (this.cVf.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.cVf.a(str, z, 5, 100, -1, -1, aDE());
        com.baidu.adp.lib.network.http.f gr = this.cVf.gr();
        if (gr == null) {
            return null;
        }
        hVar = gr.fZ();
        if (gr != null) {
            try {
                if (gr.ga() != null && (size = gr.ga().size()) > 0) {
                    this.cUZ.aEd().cWz = gr.ga().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cUZ.aEc().mNetErrorCode = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -12;
                TiebaStatic.net(this.cUZ);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -13;
                TiebaStatic.net(this.cUZ);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cUZ);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cUZ);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.cUZ.aEc().mNetErrorCode = hVar.responseCode;
        if (this.cUZ.aEc().mNetErrorCode != 200) {
            this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cUZ.aEd().cWz != null && !TextUtils.isEmpty(this.cUZ.aEd().cWz.exception)) {
                this.cUZ.aEc().mException = this.cUZ.aEd().cWz.exception;
            } else {
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
            }
            TiebaStatic.net(this.cUZ);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cVe) {
                    this.cUZ.aEc().mNetErrorCode = -11;
                    TiebaStatic.net(this.cUZ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aMZ().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cUZ.aEb().aEe().mUrl + "], size:" + i2);
                            this.cUZ.aEc().mNetErrorCode = -16;
                            TiebaStatic.net(this.cUZ);
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
        aVar.mSize = this.cUZ.aEd().cWz.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cUZ.aEd().cWz.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cUZ.aEd().cWz.retry);
        TiebaStatic.net(this.cUZ);
        bArr = hVar == null ? hVar.retBytes : null;
        return bArr;
    }

    public void sZ(String str) {
        this.cUZ.aEc().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cUZ.aEc().mServerErrorCode = errorData.getError_code();
                if (this.cUZ.aEc().mServerErrorCode == -1) {
                    this.cUZ.aEc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cUZ.aEc().mServerErrorCode != 0) {
                    this.cUZ.aEc().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cUZ.aEc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cUZ.aEc().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cUZ.aEb().aEe().charSet = TextUtils.isEmpty(this.cUZ.aEb().aEe().charSet) ? "UTF-8" : this.cUZ.aEb().aEe().charSet;
            str = new String(netData, 0, netData.length, this.cUZ.aEb().aEe().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            sZ(str);
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
            if (this.cUZ.aEb().aEe().mPostData == null || i2 >= this.cUZ.aEb().aEe().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cUZ.aEb().aEe().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cUZ.aEb().aEe().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.cUZ.aEb().cVc) {
                addPostData("sig", StringU.vP(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.cVf.isCanceled()) {
                return null;
            }
            if (this.cVf.a(this.cUZ.aEb().aEe().mUrl, this.cUZ.aEb().aEe().mPostData, this.cUZ.aEb().aEe().mRequestGzip, 5, -1, aDE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f gr = this.cVf.gr();
            if (gr == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fZ = gr.fZ();
            if (gr != null && gr.ga() != null && (size = gr.ga().size()) > 0) {
                this.cUZ.aEd().cWz = gr.ga().get(size - 1);
            }
            this.cUZ.aEc().mNetErrorCode = fZ.responseCode;
            this.cUZ.aEc().mHeader = fZ.rp;
            if (this.cUZ.aEc().mNetErrorCode != 200) {
                if (this.cUZ.aEd().cWz != null && !TextUtils.isEmpty(this.cUZ.aEd().cWz.exception)) {
                    this.cUZ.aEc().mException = this.cUZ.aEd().cWz.exception;
                } else {
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
                }
                TiebaStatic.net(this.cUZ);
                return null;
            } else if (this.cVf.isCanceled()) {
                return null;
            } else {
                str = new String(fZ.retBytes, "utf-8");
                try {
                    if (this.cUZ.aEb().aEe().mIsBaiduServer && this.cUZ.aEb().aEe().mIsJson) {
                        sZ(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cUZ.aEd().cWz.downloadSize;
                    aVar.mTime = this.cUZ.aEd().cWz.qP;
                    aVar.mTimesNum = this.cUZ.aEd().cWz.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cUZ.aEd().cWz.retry);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cUZ.aEc().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.cUZ.aEc().mNetErrorCode = -15;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.cUZ.aEc().mNetErrorCode = -12;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.cUZ.aEc().mNetErrorCode = -13;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cUZ);
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
            if (this.cVf.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.cVf.a(this.cUZ.aEb().aEe().mUrl, this.cUZ.aEb().aEe().mRequestGzip, this.cUZ.aEb().aEe().mPostData, this.cUZ.aEb().aEe().mFileData, 5, -1, aDE());
            this.cUZ.aEc().mNetErrorCode = a.responseCode;
            this.cUZ.aEc().mHeader = a.rp;
            if (this.cUZ.aEc().mNetErrorCode != 200) {
                com.baidu.adp.lib.network.http.f gr = this.cVf.gr();
                int i = 0;
                if (gr != null && gr.ga() != null) {
                    i = gr.ga().size();
                }
                if (i <= 0 || (dVar = gr.ga().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.exception;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.cUZ.aEc().mException = str2;
                } else {
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
                }
                TiebaStatic.net(this.cUZ);
                return null;
            } else if (this.cVf.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.retBytes, "UTF-8");
                try {
                    sZ(str);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cUZ.aEc().mNetErrorCode = -14;
                    return str;
                } catch (SocketException e5) {
                    this.cUZ.aEc().mNetErrorCode = -12;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.cUZ.aEc().mNetErrorCode = -13;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.cUZ.aEc().mNetErrorCode = -15;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cUZ);
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [705=5, 706=5, 707=5, 708=5, 709=5, 710=5, 711=5, 712=5, 713=5, 714=5, 715=5, 717=5, 718=5, 719=5, 720=5, 722=5, 724=5, 725=4] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        boolean z2;
        com.baidu.adp.lib.network.http.f gr;
        try {
            try {
                if (this.cVf.isCanceled()) {
                    return false;
                }
                z2 = this.cVf.a(this.cUZ.aEb().aEe().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, aDE(), new com.baidu.adp.lib.network.http.i() { // from class: com.baidu.tbadk.core.util.y.1
                    int cVg = 0;
                    int cVh = 0;
                    int cVi = 0;

                    @Override // com.baidu.adp.lib.network.http.i
                    public void j(int i4, int i5) {
                        if (i5 > 0) {
                            this.cVg = i5 / 50;
                        }
                        this.cVh += i4 - this.cVi;
                        this.cVi = i4;
                        if (handler != null) {
                            if (this.cVh > this.cVg || i4 == i5) {
                                this.cVh = 0;
                                handler.sendMessage(handler.obtainMessage(i, i4, i5));
                            }
                        }
                    }
                }, true, false, this.cUZ.aEb().rm);
                try {
                    this.cUZ.aEc().mNetErrorCode = this.cVf.gr().fZ().responseCode;
                    com.baidu.adp.lib.network.http.f gr2 = this.cVf.gr();
                    if (gr2 != null && gr2.ga() != null && handler != null) {
                        int i4 = gr2.fZ().mNetErrorCode;
                        int size = gr2.ga().size();
                        com.baidu.tbadk.o.b bVar = new com.baidu.tbadk.o.b();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = gr2.ga().get(size - 1);
                            bVar.setErrorCode(i4);
                            bVar.mx(this.cUZ.aEc().mNetErrorCode);
                            bVar.aq(dVar.exception);
                            bVar.vh(dVar.qF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar.qV);
                            bVar.setUrl(dVar.url);
                            bVar.qZ = dVar.qZ;
                            bVar.ra = dVar.ra;
                            bVar.rb = dVar.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
                    }
                    TiebaStatic.net(this.cUZ);
                    return z2;
                } catch (Exception e) {
                    e = e;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.f gr3 = this.cVf.gr();
                    if (gr3 != null && gr3.ga() != null && handler != null) {
                        int i5 = gr3.fZ().mNetErrorCode;
                        int size2 = gr3.ga().size();
                        com.baidu.tbadk.o.b bVar2 = new com.baidu.tbadk.o.b();
                        if (size2 > 0) {
                            com.baidu.adp.lib.network.http.d dVar2 = gr3.ga().get(size2 - 1);
                            bVar2.setErrorCode(i5);
                            bVar2.mx(this.cUZ.aEc().mNetErrorCode);
                            bVar2.aq(dVar2.exception);
                            bVar2.vh(dVar2.qF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar2.qV);
                            bVar2.setUrl(dVar2.url);
                            bVar2.qZ = dVar2.qZ;
                            bVar2.ra = dVar2.ra;
                            bVar2.rb = dVar2.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
                    }
                    TiebaStatic.net(this.cUZ);
                    return z2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    this.cUZ.aEc().mNetErrorCode = -15;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.network.http.f gr4 = this.cVf.gr();
                    if (gr4 != null && gr4.ga() != null && handler != null) {
                        int i6 = gr4.fZ().mNetErrorCode;
                        int size3 = gr4.ga().size();
                        com.baidu.tbadk.o.b bVar3 = new com.baidu.tbadk.o.b();
                        if (size3 > 0) {
                            com.baidu.adp.lib.network.http.d dVar3 = gr4.ga().get(size3 - 1);
                            bVar3.setErrorCode(i6);
                            bVar3.mx(this.cUZ.aEc().mNetErrorCode);
                            bVar3.aq(dVar3.exception);
                            bVar3.vh(dVar3.qF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar3.qV);
                            bVar3.setUrl(dVar3.url);
                            bVar3.qZ = dVar3.qZ;
                            bVar3.ra = dVar3.ra;
                            bVar3.rb = dVar3.rb;
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, bVar3));
                    }
                    TiebaStatic.net(this.cUZ);
                    return z2;
                }
            } finally {
                gr = this.cVf.gr();
                if (gr != null && gr.ga() != null && handler != null) {
                    int i7 = gr.fZ().mNetErrorCode;
                    int size4 = gr.ga().size();
                    com.baidu.tbadk.o.b bVar4 = new com.baidu.tbadk.o.b();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = gr.ga().get(size4 - 1);
                        bVar4.setErrorCode(i7);
                        bVar4.mx(this.cUZ.aEc().mNetErrorCode);
                        bVar4.aq(dVar4.exception);
                        bVar4.vh(dVar4.qF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qU + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + dVar4.qV);
                        bVar4.setUrl(dVar4.url);
                        bVar4.qZ = dVar4.qZ;
                        bVar4.ra = dVar4.ra;
                        bVar4.rb = dVar4.rb;
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, bVar4));
                }
                TiebaStatic.net(this.cUZ);
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
        return this.cUZ.aEb().aEe().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cUZ.aEb().aEe().mPostData != null) {
            this.cUZ.aEb().aEe().mPostData.clear();
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
        if (this.cUZ.aEb().aEe().mFileData == null) {
            this.cUZ.aEb().aEe().mFileData = new HashMap<>();
        }
        this.cUZ.aEb().aEe().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cUZ.aEb().aEe().mPostData == null) {
                this.cUZ.aEb().aEe().mPostData = new ArrayList<>();
            }
            int d = d(this.cUZ.aEb().aEe().mPostData, basicNameValuePair.getName());
            int size = this.cUZ.aEb().aEe().mPostData.size();
            if (d >= 0 && d < size) {
                if (basicNameValuePair.getName().equals(this.cUZ.aEb().aEe().mPostData.get(d).getName())) {
                    this.cUZ.aEb().aEe().mPostData.set(d, basicNameValuePair);
                } else {
                    this.cUZ.aEb().aEe().mPostData.add(d, basicNameValuePair);
                }
            } else if (d == size) {
                this.cUZ.aEb().aEe().mPostData.add(d, basicNameValuePair);
            }
        }
    }

    private int d(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    private LinkedList<BasicNameValuePair> aDE() {
        if (this.cUZ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cUZ.aEb().aEe().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cUZ.aEb().aEe().mSeqId));
            }
            if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.cUZ.aEb().aEe().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cUZ.aEb().aEe().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
