package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class y implements q {
    private static int ciu = 2097152;
    private final com.baidu.tbadk.core.util.a.a cip;
    private com.baidu.adp.lib.network.a.a civ = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.cip = aVar;
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
        if (this.civ != null) {
            this.civ.setCancel();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.civ.cancel();
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
            if (this.cip.amP().amS().mPostData != null && this.cip.amP().amS().mPostData.size() > 0 && !this.cip.amP().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cip.amP().amS().mUrl);
                if (this.cip.amP().amS().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cip.amP().amS().mUrl.endsWith("?") && !this.cip.amP().amS().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.cip.amP().amS().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.cip.amP().amS().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(aq.getUrlEncode(this.cip.amP().amS().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cip.amP().amS().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cip.amP().amS().mRequestGzip || this.cip.amP().amS().mIsBDImage) && !this.cip.amP().mIsFromCDN) {
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
        if (this.civ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.civ.a(str, z, 5, 100, -1, -1, ams());
        com.baidu.adp.lib.network.http.e fS = this.civ.fS();
        if (fS == null) {
            return null;
        }
        gVar = fS.fK();
        if (fS != null) {
            try {
                if (fS.fL() != null && (size = fS.fL().size()) > 0) {
                    this.cip.amR().cjO = fS.fL().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cip.amQ().mNetErrorCode = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -12;
                TiebaStatic.net(this.cip);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -13;
                TiebaStatic.net(this.cip);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cip);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cip);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.cip.amQ().mNetErrorCode = gVar.responseCode;
        if (this.cip.amQ().mNetErrorCode != 200) {
            this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cip.amR().cjO != null && !TextUtils.isEmpty(this.cip.amR().cjO.exception)) {
                this.cip.amQ().mException = this.cip.amR().cjO.exception;
            } else {
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
            }
            TiebaStatic.net(this.cip);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ciu) {
                    this.cip.amQ().mNetErrorCode = -11;
                    TiebaStatic.net(this.cip);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.avs().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cip.amP().amS().mUrl + "], size:" + i2);
                            this.cip.amQ().mNetErrorCode = -16;
                            TiebaStatic.net(this.cip);
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
        aVar.mSize = this.cip.amR().cjO.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cip.amR().cjO.ow;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cip.amR().cjO.ow);
        TiebaStatic.net(this.cip);
        bArr = gVar == null ? gVar.retBytes : null;
        return bArr;
    }

    public void nO(String str) {
        this.cip.amQ().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cip.amQ().mServerErrorCode = errorData.getError_code();
                if (this.cip.amQ().mServerErrorCode == -1) {
                    this.cip.amQ().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cip.amQ().mServerErrorCode != 0) {
                    this.cip.amQ().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cip.amQ().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cip.amQ().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cip.amP().amS().charSet = TextUtils.isEmpty(this.cip.amP().amS().charSet) ? HTTP.UTF_8 : this.cip.amP().amS().charSet;
            str = new String(netData, 0, netData.length, this.cip.amP().amS().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nO(str);
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
            if (this.cip.amP().amS().mPostData == null || i2 >= this.cip.amP().amS().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cip.amP().amS().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cip.amP().amS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
            if (this.cip.amP().cis) {
                addPostData("sig", StringU.qF(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.civ.isCanceled()) {
                return null;
            }
            if (this.civ.a(this.cip.amP().amS().mUrl, this.cip.amP().amS().mPostData, this.cip.amP().amS().mRequestGzip, 5, -1, ams()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fS = this.civ.fS();
            if (fS == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fK = fS.fK();
            if (fS != null && fS.fL() != null && (size = fS.fL().size()) > 0) {
                this.cip.amR().cjO = fS.fL().get(size - 1);
            }
            this.cip.amQ().mNetErrorCode = fK.responseCode;
            this.cip.amQ().mHeader = fK.oU;
            if (this.cip.amQ().mNetErrorCode != 200) {
                if (this.cip.amR().cjO != null && !TextUtils.isEmpty(this.cip.amR().cjO.exception)) {
                    this.cip.amQ().mException = this.cip.amR().cjO.exception;
                } else {
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
                }
                TiebaStatic.net(this.cip);
                return null;
            } else if (this.civ.isCanceled()) {
                return null;
            } else {
                str = new String(fK.retBytes, "utf-8");
                try {
                    if (this.cip.amP().amS().mIsBaiduServer && this.cip.amP().amS().mIsJson) {
                        nO(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cip.amR().cjO.downloadSize;
                    aVar.mTime = this.cip.amR().cjO.ox;
                    aVar.mTimesNum = this.cip.amR().cjO.ow;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cip.amR().cjO.ow);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cip.amQ().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.cip.amQ().mNetErrorCode = -15;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.cip.amQ().mNetErrorCode = -12;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.cip.amQ().mNetErrorCode = -13;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cip);
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
            if (this.civ.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.civ.a(this.cip.amP().amS().mUrl, this.cip.amP().amS().mRequestGzip, this.cip.amP().amS().mPostData, this.cip.amP().amS().mFileData, 5, -1, ams());
            this.cip.amQ().mNetErrorCode = a.responseCode;
            this.cip.amQ().mHeader = a.oU;
            if (this.cip.amQ().mNetErrorCode != 200) {
                com.baidu.adp.lib.network.http.e fS = this.civ.fS();
                int i = 0;
                if (fS != null && fS.fL() != null) {
                    i = fS.fL().size();
                }
                if (i <= 0 || (dVar = fS.fL().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.exception;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.cip.amQ().mException = str2;
                } else {
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
                }
                TiebaStatic.net(this.cip);
                return null;
            } else if (this.civ.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.retBytes, HTTP.UTF_8);
                try {
                    nO(str);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cip.amQ().mNetErrorCode = -14;
                    return str;
                } catch (SocketException e5) {
                    this.cip.amQ().mNetErrorCode = -12;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.cip.amQ().mNetErrorCode = -13;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.cip.amQ().mNetErrorCode = -15;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cip);
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, INVOKE, CONST, CONST, INVOKE, INVOKE, INVOKE, IF, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [704=5, 705=5, 706=5, 707=5, 708=5, 709=5, 710=5, 711=5, 712=5, 713=5, 714=5, 715=5, 716=5, 718=5, 721=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        com.baidu.adp.lib.network.http.e fS;
        try {
            try {
                if (this.civ.isCanceled()) {
                    com.baidu.adp.lib.network.http.e fS2 = this.civ.fS();
                    if (fS2 != null && fS2.fL() != null && handler != null) {
                        int i4 = fS2.fK().mNetErrorCode;
                        StringBuilder sb = new StringBuilder();
                        int size = fS2.fL().size();
                        if (size > 0) {
                            com.baidu.adp.lib.network.http.d dVar = fS2.fL().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(dVar.exception);
                            sb.append("-url-");
                            sb.append(dVar.url);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                    }
                    TiebaStatic.net(this.cip);
                    return false;
                }
                boolean a = this.civ.a(this.cip.amP().amS().mUrl, (z ? new File(str) : m.CreateFileIfNotFoundInCache(str)).getAbsolutePath(), false, i2, i3, -1, -1, ams(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                    int ciw = 0;
                    int cix = 0;
                    int ciy = 0;

                    @Override // com.baidu.adp.lib.network.http.h
                    public void h(int i5, int i6) {
                        if (i6 > 0) {
                            this.ciw = i6 / 50;
                        }
                        this.cix += i5 - this.ciy;
                        this.ciy = i5;
                        if (handler != null) {
                            if (this.cix > this.ciw || i5 == i6) {
                                this.cix = 0;
                                handler.sendMessage(handler.obtainMessage(i, i5, i6));
                            }
                        }
                    }
                }, true);
                if (!a && (fS = this.civ.fS()) != null && fS.fL() != null && handler != null) {
                    int i5 = fS.fK().mNetErrorCode;
                    StringBuilder sb2 = new StringBuilder();
                    int size2 = fS.fL().size();
                    if (size2 > 0) {
                        com.baidu.adp.lib.network.http.d dVar2 = fS.fL().get(size2 - 1);
                        sb2.append("-netErrorCode-");
                        sb2.append(i5);
                        sb2.append("-exception-");
                        sb2.append(dVar2.exception);
                        sb2.append("-url-");
                        sb2.append(dVar2.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                }
                TiebaStatic.net(this.cip);
                return a;
            } catch (Exception e) {
                this.cip.amQ().mNetErrorCode = -10;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                BdLog.e(e.getMessage());
                com.baidu.adp.lib.network.http.e fS3 = this.civ.fS();
                if (fS3 != null && fS3.fL() != null && handler != null) {
                    int i6 = fS3.fK().mNetErrorCode;
                    StringBuilder sb3 = new StringBuilder();
                    int size3 = fS3.fL().size();
                    if (size3 > 0) {
                        com.baidu.adp.lib.network.http.d dVar3 = fS3.fL().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(dVar3.exception);
                        sb3.append("-url-");
                        sb3.append(dVar3.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.cip);
                return false;
            } catch (OutOfMemoryError e2) {
                this.cip.amQ().mNetErrorCode = -15;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e2.getMessage());
                com.baidu.adp.lib.network.http.e fS4 = this.civ.fS();
                if (fS4 != null && fS4.fL() != null && handler != null) {
                    int i7 = fS4.fK().mNetErrorCode;
                    StringBuilder sb4 = new StringBuilder();
                    int size4 = fS4.fL().size();
                    if (size4 > 0) {
                        com.baidu.adp.lib.network.http.d dVar4 = fS4.fL().get(size4 - 1);
                        sb4.append("-netErrorCode-");
                        sb4.append(i7);
                        sb4.append("-exception-");
                        sb4.append(dVar4.exception);
                        sb4.append("-url-");
                        sb4.append(dVar4.url);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i7, -1, sb4.toString()));
                }
                TiebaStatic.net(this.cip);
                return false;
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.network.http.e fS5 = this.civ.fS();
            if (fS5 != null && fS5.fL() != null && handler != null) {
                int i8 = fS5.fK().mNetErrorCode;
                StringBuilder sb5 = new StringBuilder();
                int size5 = fS5.fL().size();
                if (size5 > 0) {
                    com.baidu.adp.lib.network.http.d dVar5 = fS5.fL().get(size5 - 1);
                    sb5.append("-netErrorCode-");
                    sb5.append(i8);
                    sb5.append("-exception-");
                    sb5.append(dVar5.exception);
                    sb5.append("-url-");
                    sb5.append(dVar5.url);
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i8, -1, sb5.toString()));
            }
            TiebaStatic.net(this.cip);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.cip.amP().amS().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cip.amP().amS().mPostData != null) {
            this.cip.amP().amS().mPostData.clear();
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
        if (this.cip.amP().amS().mFileData == null) {
            this.cip.amP().amS().mFileData = new HashMap<>();
        }
        this.cip.amP().amS().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cip.amP().amS().mPostData == null) {
                this.cip.amP().amS().mPostData = new ArrayList<>();
            }
            int c = c(this.cip.amP().amS().mPostData, basicNameValuePair.getName());
            int size = this.cip.amP().amS().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.cip.amP().amS().mPostData.get(c).getName())) {
                    this.cip.amP().amS().mPostData.set(c, basicNameValuePair);
                } else {
                    this.cip.amP().amS().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.cip.amP().amS().mPostData.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> ams() {
        if (this.cip != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cip.amP().amS().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cip.amP().amS().mSeqId));
            }
            if (!com.baidu.tbadk.t.aq.isOn() && !TextUtils.isEmpty(this.cip.amP().amS().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cip.amP().amS().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
