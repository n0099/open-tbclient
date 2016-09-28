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
import com.baidu.tieba.r;
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
    private static int aaA = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private com.baidu.adp.lib.network.a.a aaB = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a aav;
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        uR();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aav = aVar;
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

    private void uR() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void ej() {
        if (this.aaB != null) {
            this.aaB.ej();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void eg() {
        this.aaB.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uv() {
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
            if (this.aav.vN().vQ().acZ != null && this.aav.vN().vQ().acZ.size() > 0 && !this.aav.vN().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aav.vN().vQ().mUrl);
                if (this.aav.vN().vQ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aav.vN().vQ().mUrl.endsWith("?") && !this.aav.vN().vQ().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aav.vN().vQ().acZ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aav.vN().vQ().acZ.get(i).getName());
                    sb.append("=");
                    sb.append(az.aP(this.aav.vN().vQ().acZ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aav.vN().vQ().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aav.vN().vQ().adb || this.aav.vN().vQ().mIsBDImage) && !this.aav.vN().mIsFromCDN) {
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
        if (this.aaB.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aaB.a(str, z, 5, 100, -1, -1, va());
        com.baidu.adp.lib.network.http.f ex = this.aaB.ex();
        if (ex == null) {
            return null;
        }
        hVar = ex.eq();
        if (ex != null) {
            try {
                if (ex.er() != null && (size = ex.er().size()) > 0) {
                    this.aav.vP().acF = ex.er().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aav.vO().oE = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF != null ? this.aav.vP().acF.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aav.vO().oE = -13;
                TiebaStatic.net(this.aav);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aav.vO().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF != null ? this.aav.vP().acF.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aav.vO().oE = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aav);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF != null ? this.aav.vP().acF.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aav.vO().oE = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aav);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF != null ? this.aav.vP().acF.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aav.vO().oE = -12;
                TiebaStatic.net(this.aav);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aav.vO().oE = hVar.responseCode;
        if (this.aav.vO().oE != 200) {
            this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
            if (this.aav.vP().acF != null && !TextUtils.isEmpty(this.aav.vP().acF.oj)) {
                this.aav.vO().acE = this.aav.vP().acF.oj;
            } else {
                this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og);
            }
            TiebaStatic.net(this.aav);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aaA) {
                    this.aav.vO().oE = -11;
                    TiebaStatic.net(this.aav);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Ek().eQ(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aav.vN().vQ().mUrl + "], size:" + i2);
                            this.aav.vO().oE = -16;
                            TiebaStatic.net(this.aav);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
        aVar.aaQ = this.aav.vP().acF.od;
        aVar.mTime = new Date().getTime() - j;
        aVar.aaR = this.aav.vP().acF.og;
        aVar.aaP = 2;
        af.a(aVar);
        af.aaO.set(this.aav.vP().acF.og);
        TiebaStatic.net(this.aav);
        bArr = hVar == null ? hVar.oG : null;
        return bArr;
    }

    public void dr(String str) {
        this.aav.vO().acD = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aav.vO().acD = errorData.getError_code();
                if (this.aav.vO().acD == -1) {
                    this.aav.vO().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
                } else if (this.aav.vO().acD != 0) {
                    this.aav.vO().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aav.vO().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String uw() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uv = uv();
        if (uv == null || this.aav.vO().oE != 200) {
            return null;
        }
        try {
            this.aav.vN().vQ().ade = TextUtils.isEmpty(this.aav.vN().vQ().ade) ? "UTF-8" : this.aav.vN().vQ().ade;
            str = new String(uv, 0, uv.length, this.aav.vN().vQ().ade);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dr(str);
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
    public String uu() {
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
            if (this.aav.vN().vQ().acZ == null || i2 >= this.aav.vN().vQ().acZ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aav.vN().vQ().acZ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aav.vN().vQ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aaB.isCanceled()) {
                return null;
            }
            if (this.aaB.a(this.aav.vN().vQ().mUrl, this.aav.vN().vQ().acZ, this.aav.vN().vQ().adb, 5, -1, va()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ex = this.aaB.ex();
            if (ex == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h eq = ex.eq();
            if (ex != null && ex.er() != null && (size = ex.er().size()) > 0) {
                this.aav.vP().acF = ex.er().get(size - 1);
            }
            this.aav.vO().oE = eq.responseCode;
            this.aav.vO().mHeader = eq.oF;
            if (this.aav.vO().oE != 200) {
                if (this.aav.vP().acF != null && !TextUtils.isEmpty(this.aav.vP().acF.oj)) {
                    this.aav.vO().acE = this.aav.vP().acF.oj;
                } else {
                    this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og);
                }
                TiebaStatic.net(this.aav);
                return null;
            } else if (this.aaB.isCanceled()) {
                return null;
            } else {
                str = new String(eq.oG, "utf-8");
                try {
                    if (this.aav.vN().vQ().mIsBaiduServer && this.aav.vN().vQ().adc) {
                        dr(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
                    aVar.aaQ = this.aav.vP().acF.od;
                    aVar.mTime = this.aav.vP().acF.oh;
                    aVar.aaR = this.aav.vP().acF.og;
                    aVar.aaP = 1;
                    af.a(aVar);
                    af.aaO.set(this.aav.vP().acF.og);
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aav.vO().oE = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e3 = e6;
                    this.aav.vO().oE = -15;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (SocketException e7) {
                    e2 = e7;
                    this.aav.vO().oE = -12;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    this.aav.vO().oE = -13;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (Exception e9) {
                    e4 = e9;
                    this.aav.vO().oE = -10;
                    this.aav.vO().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aav.vO().oE = -10;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aav);
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
    public String ux() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aaB.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aaB.a(this.aav.vN().vQ().mUrl, this.aav.vN().vQ().adb, this.aav.vN().vQ().acZ, this.aav.vN().vQ().ada, 5, -1, va());
            this.aav.vO().oE = a.responseCode;
            this.aav.vO().mHeader = a.oF;
            if (this.aav.vO().oE != 200) {
                com.baidu.adp.lib.network.http.f ex = this.aaB.ex();
                int i = 0;
                if (ex != null && ex.er() != null) {
                    i = ex.er().size();
                }
                if (i <= 0 || (eVar = ex.er().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.oj;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aav.vO().acE = str3;
                } else {
                    this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og);
                }
                TiebaStatic.net(this.aav);
                return null;
            } else if (this.aaB.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.oG, "UTF-8");
                try {
                    dr(str);
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aav.vO().acE = String.valueOf(String.valueOf(this.aav.vO().oE)) + "|retryCount:" + (this.aav.vP().acF == null ? -1 : this.aav.vP().acF.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aav.vO().oE = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aav.vO().oE = -13;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aav.vO().oE = -10;
                    this.aav.vO().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aav.vO().oE = -15;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aav);
                    return str;
                } catch (SocketException e7) {
                    this.aav.vO().oE = -12;
                    this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aav);
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
            if (!this.aaB.isCanceled()) {
                return this.aaB.a(this.aav.vN().vQ().mUrl, (z ? new File(str) : m.db(str)).getAbsolutePath(), false, i2, i3, -1, -1, va(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.aav);
            return false;
        } catch (Exception e) {
            this.aav.vO().oE = -10;
            this.aav.vO().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aav.vO().oE = -15;
            this.aav.vO().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aav);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> ut() {
        return this.aav.vN().vQ().acZ;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aav.vN().vQ().acZ != null) {
            this.aav.vN().vQ().acZ.clear();
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
        if (this.aav.vN().vQ().ada == null) {
            this.aav.vN().vQ().ada = new HashMap<>();
        }
        this.aav.vN().vQ().ada.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aav.vN().vQ().acZ == null) {
                this.aav.vN().vQ().acZ = new ArrayList<>();
            }
            int c = c(this.aav.vN().vQ().acZ, basicNameValuePair.getName());
            int size = this.aav.vN().vQ().acZ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aav.vN().vQ().acZ.get(c).getName())) {
                    this.aav.vN().vQ().acZ.set(c, basicNameValuePair);
                } else {
                    this.aav.vN().vQ().acZ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aav.vN().vQ().acZ.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> va() {
        if (this.aav != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aav.vN().vQ().adf)) {
                linkedList.add(new BasicNameValuePair("sid", this.aav.vN().vQ().adf));
            }
            if (!TextUtils.isEmpty(this.aav.vN().vQ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aav.vN().vQ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
