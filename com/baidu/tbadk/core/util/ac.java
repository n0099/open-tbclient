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
    private static int WA = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private com.baidu.adp.lib.network.a.a WB = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a Wv;
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        tz();
        this.mContext = TbadkCoreApplication.m11getInst().getApp();
        this.Wv = aVar;
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

    private void tz() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    /* renamed from: do  reason: not valid java name */
    public void mo15do() {
        if (this.WB != null) {
            this.WB.m4do();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void dl() {
        this.WB.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] td() {
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
            if (this.Wv.uu().ux().YZ != null && this.Wv.uu().ux().YZ.size() > 0 && !this.Wv.uu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.Wv.uu().ux().mUrl);
                if (this.Wv.uu().ux().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.Wv.uu().ux().mUrl.endsWith("?") && !this.Wv.uu().ux().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.Wv.uu().ux().YZ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.Wv.uu().ux().YZ.get(i).getName());
                    sb.append("=");
                    sb.append(ay.aN(this.Wv.uu().ux().YZ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.Wv.uu().ux().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.Wv.uu().ux().Zb || this.Wv.uu().ux().mIsBDImage) && !this.Wv.uu().mIsFromCDN) {
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
        if (this.WB.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.WB.a(str, z, 5, 100, -1, -1, tI());
        com.baidu.adp.lib.network.http.f dC = this.WB.dC();
        if (dC == null) {
            return null;
        }
        hVar = dC.dv();
        if (dC != null) {
            try {
                if (dC.dw() != null && (size = dC.dw().size()) > 0) {
                    this.Wv.uw().YF = dC.dw().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.Wv.uv().lE = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF != null ? this.Wv.uw().YF.lk : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Wv.uv().lE = -13;
                TiebaStatic.net(this.Wv);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.Wv.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF != null ? this.Wv.uw().YF.lk : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Wv.uv().lE = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Wv);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF != null ? this.Wv.uw().YF.lk : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Wv.uv().lE = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Wv);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF != null ? this.Wv.uw().YF.lk : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Wv.uv().lE = -12;
                TiebaStatic.net(this.Wv);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.Wv.uv().lE = hVar.responseCode;
        if (this.Wv.uv().lE != 200) {
            this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
            if (this.Wv.uw().YF != null && !TextUtils.isEmpty(this.Wv.uw().YF.ln)) {
                this.Wv.uv().YE = this.Wv.uw().YF.ln;
            } else {
                this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk);
            }
            TiebaStatic.net(this.Wv);
            return null;
        }
        if (TbadkCoreApplication.m11getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > WA) {
                    this.Wv.uv().lE = -11;
                    TiebaStatic.net(this.Wv);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.CH().ez(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Wv.uu().ux().mUrl + "], size:" + i2);
                            this.Wv.uv().lE = -16;
                            TiebaStatic.net(this.Wv);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.fw());
        aVar.WQ = this.Wv.uw().YF.lh;
        aVar.mTime = new Date().getTime() - j;
        aVar.WR = this.Wv.uw().YF.lk;
        aVar.WP = 2;
        af.a(aVar);
        af.WO.set(this.Wv.uw().YF.lk);
        TiebaStatic.net(this.Wv);
        bArr = hVar == null ? hVar.lG : null;
        return bArr;
    }

    public void dp(String str) {
        this.Wv.uv().YD = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Wv.uv().YD = errorData.getError_code();
                if (this.Wv.uv().YD == -1) {
                    this.Wv.uv().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
                } else if (this.Wv.uv().YD != 0) {
                    this.Wv.uv().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Wv.uv().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String te() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] td = td();
        if (td == null || this.Wv.uv().lE != 200) {
            return null;
        }
        try {
            this.Wv.uu().ux().Zd = TextUtils.isEmpty(this.Wv.uu().ux().Zd) ? "UTF-8" : this.Wv.uu().ux().Zd;
            str = new String(td, 0, td.length, this.Wv.uu().ux().Zd);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dp(str);
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
    public String tc() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Wv.uu().ux().YZ == null || i2 >= this.Wv.uu().ux().YZ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Wv.uu().ux().YZ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.Wv.uu().ux().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aS(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.WB.isCanceled()) {
                return null;
            }
            if (this.WB.a(this.Wv.uu().ux().mUrl, this.Wv.uu().ux().YZ, this.Wv.uu().ux().Zb, 5, -1, tI()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f dC = this.WB.dC();
            if (dC == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h dv = dC.dv();
            if (dC != null && dC.dw() != null && (size = dC.dw().size()) > 0) {
                this.Wv.uw().YF = dC.dw().get(size - 1);
            }
            this.Wv.uv().lE = dv.responseCode;
            this.Wv.uv().mHeader = dv.lF;
            if (this.Wv.uv().lE != 200) {
                if (this.Wv.uw().YF != null && !TextUtils.isEmpty(this.Wv.uw().YF.ln)) {
                    this.Wv.uv().YE = this.Wv.uw().YF.ln;
                } else {
                    this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk);
                }
                TiebaStatic.net(this.Wv);
                return null;
            } else if (this.WB.isCanceled()) {
                return null;
            } else {
                str = new String(dv.lG, "utf-8");
                try {
                    if (this.Wv.uu().ux().mIsBaiduServer && this.Wv.uu().ux().Zc) {
                        dp(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.fw());
                    aVar.WQ = this.Wv.uw().YF.lh;
                    aVar.mTime = this.Wv.uw().YF.ll;
                    aVar.WR = this.Wv.uw().YF.lk;
                    aVar.WP = 1;
                    af.a(aVar);
                    af.WO.set(this.Wv.uw().YF.lk);
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.Wv.uv().lE = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.Wv.uv().lE = -12;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.Wv.uv().lE = -13;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.Wv.uv().lE = -10;
                    this.Wv.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.Wv.uv().lE = -15;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.Wv.uv().lE = -10;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String tf() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.WB.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.WB.a(this.Wv.uu().ux().mUrl, this.Wv.uu().ux().Zb, this.Wv.uu().ux().YZ, this.Wv.uu().ux().Za, 5, -1, tI());
            this.Wv.uv().lE = a.responseCode;
            this.Wv.uv().mHeader = a.lF;
            if (this.Wv.uv().lE != 200) {
                com.baidu.adp.lib.network.http.f dC = this.WB.dC();
                int i = 0;
                if (dC != null && dC.dw() != null) {
                    i = dC.dw().size();
                }
                if (i <= 0 || (eVar = dC.dw().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.ln;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.Wv.uv().YE = str3;
                } else {
                    this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk);
                }
                TiebaStatic.net(this.Wv);
                return null;
            } else if (this.WB.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.lG, "UTF-8");
                try {
                    dp(str);
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.Wv.uv().YE = String.valueOf(String.valueOf(this.Wv.uv().lE)) + "|retryCount:" + (this.Wv.uw().YF == null ? -1 : this.Wv.uw().YF.lk) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.Wv.uv().lE = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.Wv.uv().lE = -13;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.Wv.uv().lE = -10;
                    this.Wv.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.Wv.uv().lE = -15;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.Wv);
                    return str;
                } catch (SocketException e7) {
                    this.Wv.uv().lE = -12;
                    this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.Wv);
                    return str;
                }
            }
        } catch (BdHttpCancelException e8) {
            bdHttpCancelException = e8;
            str2 = null;
        } catch (OutOfMemoryError e9) {
            e2 = e9;
            str = null;
        } catch (SocketException e10) {
            str = null;
        } catch (SocketTimeoutException e11) {
            str = null;
        } catch (Exception e12) {
            e = e12;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [698=5] */
    @Override // com.baidu.tbadk.core.util.t
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.WB.isCanceled()) {
                return this.WB.a(this.Wv.uu().ux().mUrl, (z ? new File(str) : m.cX(str)).getAbsolutePath(), false, i2, i3, -1, -1, tI(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.Wv);
            return false;
        } catch (Exception e) {
            this.Wv.uv().lE = -10;
            this.Wv.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Wv.uv().lE = -15;
            this.Wv.uv().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Wv);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> tb() {
        return this.Wv.uu().ux().YZ;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Wv.uu().ux().YZ != null) {
            this.Wv.uu().ux().YZ.clear();
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
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void c(String str, byte[] bArr) {
        if (this.Wv.uu().ux().Za == null) {
            this.Wv.uu().ux().Za = new HashMap<>();
        }
        this.Wv.uu().ux().Za.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Wv.uu().ux().YZ == null) {
                this.Wv.uu().ux().YZ = new ArrayList<>();
            }
            int c = c(this.Wv.uu().ux().YZ, basicNameValuePair.getName());
            int size = this.Wv.uu().ux().YZ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.Wv.uu().ux().YZ.get(c).getName())) {
                    this.Wv.uu().ux().YZ.set(c, basicNameValuePair);
                } else {
                    this.Wv.uu().ux().YZ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.Wv.uu().ux().YZ.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> tI() {
        if (this.Wv != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Wv.uu().ux().Ze)) {
                linkedList.add(new BasicNameValuePair("sid", this.Wv.uu().ux().Ze));
            }
            if (!TextUtils.isEmpty(this.Wv.uu().ux().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Wv.uu().ux().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
