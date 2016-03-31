package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.t;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ac implements t {
    private static int aba = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aaV;
    private com.baidu.adp.lib.network.a.a abb = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        vT();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.aaV = aVar;
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

    private void vT() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void ha() {
        if (this.abb != null) {
            this.abb.ha();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void gX() {
        this.abb.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] vx() {
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
            if (this.aaV.wO().wR().adB != null && this.aaV.wO().wR().adB.size() > 0 && !this.aaV.wO().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aaV.wO().wR().mUrl);
                if (this.aaV.wO().wR().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aaV.wO().wR().mUrl.endsWith("?") && !this.aaV.wO().wR().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aaV.wO().wR().adB.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aaV.wO().wR().adB.get(i).getName());
                    sb.append("=");
                    sb.append(ay.aU(this.aaV.wO().wR().adB.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aaV.wO().wR().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aaV.wO().wR().adD || this.aaV.wO().wR().mIsBDImage) && !this.aaV.wO().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            hVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            hVar = null;
        } catch (SocketException e3) {
            e = e3;
            hVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            hVar = null;
        } catch (Exception e5) {
            e = e5;
            hVar = null;
        }
        if (this.abb.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.abb.a(str, z, 5, 100, -1, -1, wc());
        com.baidu.adp.lib.network.http.f ho = this.abb.ho();
        if (ho == null) {
            return null;
        }
        hVar = ho.hh();
        if (ho != null) {
            try {
                if (ho.hi() != null && (size = ho.hi().size()) > 0) {
                    this.aaV.wQ().adh = ho.hi().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aaV.wP().vL = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh != null ? this.aaV.wQ().adh.vt : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaV.wP().vL = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaV);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh != null ? this.aaV.wQ().adh.vt : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaV.wP().vL = -12;
                TiebaStatic.net(this.aaV);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh != null ? this.aaV.wQ().adh.vt : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaV.wP().vL = -13;
                TiebaStatic.net(this.aaV);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aaV.wP().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh != null ? this.aaV.wQ().adh.vt : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaV.wP().vL = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaV);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aaV.wP().vL = hVar.responseCode;
        if (this.aaV.wP().vL != 200) {
            this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
            if (this.aaV.wQ().adh != null && !TextUtils.isEmpty(this.aaV.wQ().adh.vw)) {
                this.aaV.wP().adg = this.aaV.wQ().adh.vw;
            } else {
                this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt);
            }
            TiebaStatic.net(this.aaV);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aba) {
                    this.aaV.wP().vL = -11;
                    TiebaStatic.net(this.aaV);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.EO().eT(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aaV.wO().wR().mUrl + "], size:" + i2);
                            this.aaV.wP().vL = -16;
                            TiebaStatic.net(this.aaV);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.jl());
        aVar.abq = this.aaV.wQ().adh.vq;
        aVar.mTime = new Date().getTime() - j;
        aVar.abr = this.aaV.wQ().adh.vt;
        aVar.abp = 2;
        af.a(aVar);
        af.abo.set(this.aaV.wQ().adh.vt);
        TiebaStatic.net(this.aaV);
        bArr = hVar == null ? hVar.vN : null;
        return bArr;
    }

    public void ds(String str) {
        this.aaV.wP().adf = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aaV.wP().adf = errorData.getError_code();
                if (this.aaV.wP().adf == -1) {
                    this.aaV.wP().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
                } else if (this.aaV.wP().adf != 0) {
                    this.aaV.wP().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aaV.wP().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String vy() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] vx = vx();
        if (vx == null || this.aaV.wP().vL != 200) {
            return null;
        }
        try {
            this.aaV.wO().wR().adF = TextUtils.isEmpty(this.aaV.wO().wR().adF) ? "UTF-8" : this.aaV.wO().wR().adF;
            str = new String(vx, 0, vx.length, this.aaV.wO().wR().adF);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            ds(str);
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

    @Override // com.baidu.tbadk.core.util.t
    public String vw() {
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
            if (this.aaV.wO().wR().adB == null || i2 >= this.aaV.wO().wR().adB.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aaV.wO().wR().adB.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aaV.wO().wR().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            p(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aZ(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.abb.isCanceled()) {
                return null;
            }
            if (this.abb.a(this.aaV.wO().wR().mUrl, this.aaV.wO().wR().adB, this.aaV.wO().wR().adD, 5, -1, wc()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ho = this.abb.ho();
            if (ho == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h hh = ho.hh();
            if (ho != null && ho.hi() != null && (size = ho.hi().size()) > 0) {
                this.aaV.wQ().adh = ho.hi().get(size - 1);
            }
            this.aaV.wP().vL = hh.responseCode;
            this.aaV.wP().mHeader = hh.vM;
            if (this.aaV.wP().vL != 200) {
                if (this.aaV.wQ().adh != null && !TextUtils.isEmpty(this.aaV.wQ().adh.vw)) {
                    this.aaV.wP().adg = this.aaV.wQ().adh.vw;
                } else {
                    this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt);
                }
                TiebaStatic.net(this.aaV);
                return null;
            } else if (this.abb.isCanceled()) {
                return null;
            } else {
                str = new String(hh.vN, "utf-8");
                try {
                    if (this.aaV.wO().wR().mIsBaiduServer && this.aaV.wO().wR().adE) {
                        ds(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.jl());
                    aVar.abq = this.aaV.wQ().adh.vq;
                    aVar.mTime = this.aaV.wQ().adh.vu;
                    aVar.abr = this.aaV.wQ().adh.vt;
                    aVar.abp = 1;
                    af.a(aVar);
                    af.abo.set(this.aaV.wQ().adh.vt);
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aaV.wP().vL = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.aaV.wP().vL = -15;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.aaV.wP().vL = -12;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.aaV.wP().vL = -13;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.aaV.wP().vL = -10;
                    this.aaV.wP().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aaV.wP().vL = -10;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aaV);
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

    @Override // com.baidu.tbadk.core.util.t
    public String vz() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.abb.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.abb.a(this.aaV.wO().wR().mUrl, this.aaV.wO().wR().adD, this.aaV.wO().wR().adB, this.aaV.wO().wR().adC, 5, -1, wc());
            this.aaV.wP().vL = a.responseCode;
            this.aaV.wP().mHeader = a.vM;
            if (this.aaV.wP().vL != 200) {
                com.baidu.adp.lib.network.http.f ho = this.abb.ho();
                int i = 0;
                if (ho != null && ho.hi() != null) {
                    i = ho.hi().size();
                }
                if (i <= 0 || (eVar = ho.hi().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vw;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aaV.wP().adg = str3;
                } else {
                    this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt);
                }
                TiebaStatic.net(this.aaV);
                return null;
            } else if (this.abb.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vN, "UTF-8");
                try {
                    ds(str);
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.aaV.wP().adg = String.valueOf(String.valueOf(this.aaV.wP().vL)) + "|retryCount:" + (this.aaV.wQ().adh == null ? -1 : this.aaV.wQ().adh.vt) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aaV.wP().vL = -14;
                    return str2;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    this.aaV.wP().vL = -15;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (SocketException e5) {
                    this.aaV.wP().vL = -12;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aaV.wP().vL = -13;
                    this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.aaV);
                    return str;
                } catch (Exception e7) {
                    e2 = e7;
                    this.aaV.wP().vL = -10;
                    this.aaV.wP().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aaV);
                    return str;
                }
            }
        } catch (BdHttpCancelException e8) {
            bdHttpCancelException = e8;
            str2 = null;
        } catch (SocketException e9) {
            str = null;
        } catch (SocketTimeoutException e10) {
            str = null;
        } catch (Exception e11) {
            e2 = e11;
            str = null;
        } catch (OutOfMemoryError e12) {
            e = e12;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [698=5] */
    @Override // com.baidu.tbadk.core.util.t
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.abb.isCanceled()) {
                return this.abb.a(this.aaV.wO().wR().mUrl, (z ? new File(str) : m.cZ(str)).getAbsolutePath(), false, i2, i3, -1, -1, wc(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.aaV);
            return false;
        } catch (Exception e) {
            this.aaV.wP().vL = -10;
            this.aaV.wP().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aaV.wP().vL = -15;
            this.aaV.wP().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aaV);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> vv() {
        return this.aaV.wO().wR().adB;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aaV.wO().wR().adB != null) {
            this.aaV.wO().wR().adB.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void p(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void c(String str, byte[] bArr) {
        if (this.aaV.wO().wR().adC == null) {
            this.aaV.wO().wR().adC = new HashMap<>();
        }
        this.aaV.wO().wR().adC.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aaV.wO().wR().adB == null) {
                this.aaV.wO().wR().adB = new ArrayList<>();
            }
            int c = c(this.aaV.wO().wR().adB, basicNameValuePair.getName());
            int size = this.aaV.wO().wR().adB.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aaV.wO().wR().adB.get(c).getName())) {
                    this.aaV.wO().wR().adB.set(c, basicNameValuePair);
                } else {
                    this.aaV.wO().wR().adB.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aaV.wO().wR().adB.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> wc() {
        if (this.aaV != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aaV.wO().wR().adG)) {
                linkedList.add(new BasicNameValuePair("sid", this.aaV.wO().wR().adG));
            }
            if (!TextUtils.isEmpty(this.aaV.wO().wR().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aaV.wO().wR().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
