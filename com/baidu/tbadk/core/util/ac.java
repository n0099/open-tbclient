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
import com.baidu.tieba.u;
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
    private static int Xz = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private com.baidu.adp.lib.network.a.a XA = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a Xu;
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        tw();
        this.mContext = TbadkCoreApplication.m10getInst().getApp();
        this.Xu = aVar;
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

    private void tw() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    /* renamed from: do  reason: not valid java name */
    public void mo13do() {
        if (this.XA != null) {
            this.XA.m4do();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void dl() {
        this.XA.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ta() {
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
            if (this.Xu.uu().ux().ZZ != null && this.Xu.uu().ux().ZZ.size() > 0 && !this.Xu.uu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.Xu.uu().ux().mUrl);
                if (this.Xu.uu().ux().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.Xu.uu().ux().mUrl.endsWith("?") && !this.Xu.uu().ux().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.Xu.uu().ux().ZZ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.Xu.uu().ux().ZZ.get(i).getName());
                    sb.append("=");
                    sb.append(ba.aO(this.Xu.uu().ux().ZZ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.Xu.uu().ux().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.Xu.uu().ux().aab || this.Xu.uu().ux().mIsBDImage) && !this.Xu.uu().mIsFromCDN) {
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
        if (this.XA.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.XA.a(str, z, 5, 100, -1, -1, tF());
        com.baidu.adp.lib.network.http.f dC = this.XA.dC();
        if (dC == null) {
            return null;
        }
        hVar = dC.dv();
        if (dC != null) {
            try {
                if (dC.dw() != null && (size = dC.dw().size()) > 0) {
                    this.Xu.uw().ZF = dC.dw().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.Xu.uv().mi = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF != null ? this.Xu.uw().ZF.lN : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Xu.uv().mi = -13;
                TiebaStatic.net(this.Xu);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.Xu.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF != null ? this.Xu.uw().ZF.lN : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Xu.uv().mi = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Xu);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF != null ? this.Xu.uw().ZF.lN : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Xu.uv().mi = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Xu);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF != null ? this.Xu.uw().ZF.lN : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Xu.uv().mi = -12;
                TiebaStatic.net(this.Xu);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.Xu.uv().mi = hVar.responseCode;
        if (this.Xu.uv().mi != 200) {
            this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
            if (this.Xu.uw().ZF != null && !TextUtils.isEmpty(this.Xu.uw().ZF.lQ)) {
                this.Xu.uv().ZE = this.Xu.uw().ZF.lQ;
            } else {
                this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN);
            }
            TiebaStatic.net(this.Xu);
            return null;
        }
        if (TbadkCoreApplication.m10getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > Xz) {
                    this.Xu.uv().mi = -11;
                    TiebaStatic.net(this.Xu);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.CP().eD(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Xu.uu().ux().mUrl + "], size:" + i2);
                            this.Xu.uv().mi = -16;
                            TiebaStatic.net(this.Xu);
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
        aVar.XP = this.Xu.uw().ZF.lK;
        aVar.mTime = new Date().getTime() - j;
        aVar.XQ = this.Xu.uw().ZF.lN;
        aVar.XO = 2;
        af.a(aVar);
        af.XN.set(this.Xu.uw().ZF.lN);
        TiebaStatic.net(this.Xu);
        bArr = hVar == null ? hVar.mk : null;
        return bArr;
    }

    public void dm(String str) {
        this.Xu.uv().ZD = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Xu.uv().ZD = errorData.getError_code();
                if (this.Xu.uv().ZD == -1) {
                    this.Xu.uv().mErrorString = this.mContext.getString(u.j.error_unkown_try_again);
                } else if (this.Xu.uv().ZD != 0) {
                    this.Xu.uv().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Xu.uv().mErrorString = this.mContext.getString(u.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String tb() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ta = ta();
        if (ta == null || this.Xu.uv().mi != 200) {
            return null;
        }
        try {
            this.Xu.uu().ux().aad = TextUtils.isEmpty(this.Xu.uu().ux().aad) ? "UTF-8" : this.Xu.uu().ux().aad;
            str = new String(ta, 0, ta.length, this.Xu.uu().ux().aad);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dm(str);
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
    public String sZ() {
        Throwable th;
        String str;
        SocketTimeoutException e;
        SocketException e2;
        OutOfMemoryError e3;
        Exception e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Xu.uu().ux().ZZ == null || i2 >= this.Xu.uu().ux().ZZ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Xu.uu().ux().ZZ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.Xu.uu().ux().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aT(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.XA.isCanceled()) {
                return null;
            }
            if (this.XA.a(this.Xu.uu().ux().mUrl, this.Xu.uu().ux().ZZ, this.Xu.uu().ux().aab, 5, -1, tF()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f dC = this.XA.dC();
            if (dC == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h dv = dC.dv();
            if (dC != null && dC.dw() != null && (size = dC.dw().size()) > 0) {
                this.Xu.uw().ZF = dC.dw().get(size - 1);
            }
            this.Xu.uv().mi = dv.responseCode;
            this.Xu.uv().mHeader = dv.mj;
            if (this.Xu.uv().mi != 200) {
                if (this.Xu.uw().ZF != null && !TextUtils.isEmpty(this.Xu.uw().ZF.lQ)) {
                    this.Xu.uv().ZE = this.Xu.uw().ZF.lQ;
                } else {
                    this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN);
                }
                TiebaStatic.net(this.Xu);
                return null;
            } else if (this.XA.isCanceled()) {
                return null;
            } else {
                str = new String(dv.mk, "utf-8");
                try {
                    if (this.Xu.uu().ux().mIsBaiduServer && this.Xu.uu().ux().aac) {
                        dm(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.fw());
                    aVar.XP = this.Xu.uw().ZF.lK;
                    aVar.mTime = this.Xu.uw().ZF.lO;
                    aVar.XQ = this.Xu.uw().ZF.lN;
                    aVar.XO = 1;
                    af.a(aVar);
                    af.XN.set(this.Xu.uw().ZF.lN);
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.Xu.uv().mi = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.Xu.uv().mi = -12;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.Xu.uv().mi = -13;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.Xu.uv().mi = -10;
                    this.Xu.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.Xu.uv().mi = -15;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.Xu.uv().mi = -10;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (Exception e11) {
            e4 = e11;
            str = null;
        } catch (OutOfMemoryError e12) {
            e3 = e12;
            str = null;
        } catch (SocketException e13) {
            e2 = e13;
            str = null;
        } catch (SocketTimeoutException e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String tc() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.XA.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.XA.a(this.Xu.uu().ux().mUrl, this.Xu.uu().ux().aab, this.Xu.uu().ux().ZZ, this.Xu.uu().ux().aaa, 5, -1, tF());
            this.Xu.uv().mi = a.responseCode;
            this.Xu.uv().mHeader = a.mj;
            if (this.Xu.uv().mi != 200) {
                com.baidu.adp.lib.network.http.f dC = this.XA.dC();
                int i = 0;
                if (dC != null && dC.dw() != null) {
                    i = dC.dw().size();
                }
                if (i <= 0 || (eVar = dC.dw().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.lQ;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.Xu.uv().ZE = str3;
                } else {
                    this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN);
                }
                TiebaStatic.net(this.Xu);
                return null;
            } else if (this.XA.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.mk, "UTF-8");
                try {
                    dm(str);
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    this.Xu.uv().ZE = String.valueOf(String.valueOf(this.Xu.uv().mi)) + "|retryCount:" + (this.Xu.uw().ZF == null ? -1 : this.Xu.uw().ZF.lN) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.Xu.uv().mi = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.Xu.uv().mi = -13;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.Xu.uv().mi = -10;
                    this.Xu.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.Xu.uv().mi = -15;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.Xu);
                    return str;
                } catch (SocketException e7) {
                    this.Xu.uv().mi = -12;
                    this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    TiebaStatic.net(this.Xu);
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
            if (!this.XA.isCanceled()) {
                return this.XA.a(this.Xu.uu().ux().mUrl, (z ? new File(str) : m.cW(str)).getAbsolutePath(), false, i2, i3, -1, -1, tF(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.Xu);
            return false;
        } catch (Exception e) {
            this.Xu.uv().mi = -10;
            this.Xu.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Xu.uv().mi = -15;
            this.Xu.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Xu);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> sY() {
        return this.Xu.uu().ux().ZZ;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Xu.uu().ux().ZZ != null) {
            this.Xu.uu().ux().ZZ.clear();
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
    public void d(String str, byte[] bArr) {
        if (this.Xu.uu().ux().aaa == null) {
            this.Xu.uu().ux().aaa = new HashMap<>();
        }
        this.Xu.uu().ux().aaa.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Xu.uu().ux().ZZ == null) {
                this.Xu.uu().ux().ZZ = new ArrayList<>();
            }
            int c = c(this.Xu.uu().ux().ZZ, basicNameValuePair.getName());
            int size = this.Xu.uu().ux().ZZ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.Xu.uu().ux().ZZ.get(c).getName())) {
                    this.Xu.uu().ux().ZZ.set(c, basicNameValuePair);
                } else {
                    this.Xu.uu().ux().ZZ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.Xu.uu().ux().ZZ.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> tF() {
        if (this.Xu != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Xu.uu().ux().aae)) {
                linkedList.add(new BasicNameValuePair("sid", this.Xu.uu().ux().aae));
            }
            if (!TextUtils.isEmpty(this.Xu.uu().ux().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Xu.uu().ux().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
