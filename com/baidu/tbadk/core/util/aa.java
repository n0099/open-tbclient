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
import com.baidu.tbadk.core.util.ad;
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
public class aa implements s {
    private static int aaY = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aaT;
    private com.baidu.adp.lib.network.a.a aaZ = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        uV();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aaT = aVar;
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

    private void uV() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void ej() {
        if (this.aaZ != null) {
            this.aaZ.ej();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void eg() {
        this.aaZ.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uz() {
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
            if (this.aaT.vR().vU().ady != null && this.aaT.vR().vU().ady.size() > 0 && !this.aaT.vR().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aaT.vR().vU().mUrl);
                if (this.aaT.vR().vU().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aaT.vR().vU().mUrl.endsWith("?") && !this.aaT.vR().vU().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aaT.vR().vU().ady.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aaT.vR().vU().ady.get(i).getName());
                    sb.append("=");
                    sb.append(ax.aP(this.aaT.vR().vU().ady.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aaT.vR().vU().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aaT.vR().vU().adA || this.aaT.vR().vU().mIsBDImage) && !this.aaT.vR().mIsFromCDN) {
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
        if (this.aaZ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aaZ.a(str, z, 5, 100, -1, -1, ve());
        com.baidu.adp.lib.network.http.f ex = this.aaZ.ex();
        if (ex == null) {
            return null;
        }
        hVar = ex.eq();
        if (ex != null) {
            try {
                if (ex.er() != null && (size = ex.er().size()) > 0) {
                    this.aaT.vT().ade = ex.er().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aaT.vS().oF = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade != null ? this.aaT.vT().ade.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaT.vS().oF = -13;
                TiebaStatic.net(this.aaT);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aaT.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade != null ? this.aaT.vT().ade.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaT.vS().oF = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaT);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade != null ? this.aaT.vT().ade.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaT.vS().oF = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaT);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade != null ? this.aaT.vT().ade.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaT.vS().oF = -12;
                TiebaStatic.net(this.aaT);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aaT.vS().oF = hVar.responseCode;
        if (this.aaT.vS().oF != 200) {
            this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
            if (this.aaT.vT().ade != null && !TextUtils.isEmpty(this.aaT.vT().ade.ol)) {
                this.aaT.vS().adc = this.aaT.vT().ade.ol;
            } else {
                this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh);
            }
            TiebaStatic.net(this.aaT);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aaY) {
                    this.aaT.vS().oF = -11;
                    TiebaStatic.net(this.aaT);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Ep().eT(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aaT.vR().vU().mUrl + "], size:" + i2);
                            this.aaT.vS().oF = -16;
                            TiebaStatic.net(this.aaT);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
        aVar.abo = this.aaT.vT().ade.oe;
        aVar.mTime = new Date().getTime() - j;
        aVar.abp = this.aaT.vT().ade.oh;
        aVar.abn = 2;
        ad.a(aVar);
        ad.abm.set(this.aaT.vT().ade.oh);
        TiebaStatic.net(this.aaT);
        bArr = hVar == null ? hVar.oH : null;
        return bArr;
    }

    public void dt(String str) {
        this.aaT.vS().adb = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aaT.vS().adb = errorData.getError_code();
                if (this.aaT.vS().adb == -1) {
                    this.aaT.vS().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
                } else if (this.aaT.vS().adb != 0) {
                    this.aaT.vS().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aaT.vS().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String uA() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uz = uz();
        if (uz == null || this.aaT.vS().oF != 200) {
            return null;
        }
        try {
            this.aaT.vR().vU().adC = TextUtils.isEmpty(this.aaT.vR().vU().adC) ? "UTF-8" : this.aaT.vR().vU().adC;
            str = new String(uz, 0, uz.length, this.aaT.vR().vU().adC);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dt(str);
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

    @Override // com.baidu.tbadk.core.util.s
    public String uy() {
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
            if (this.aaT.vR().vU().ady == null || i2 >= this.aaT.vR().vU().ady.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aaT.vR().vU().ady.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aaT.vR().vU().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aaZ.isCanceled()) {
                return null;
            }
            if (this.aaZ.a(this.aaT.vR().vU().mUrl, this.aaT.vR().vU().ady, this.aaT.vR().vU().adA, 5, -1, ve()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ex = this.aaZ.ex();
            if (ex == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h eq = ex.eq();
            if (ex != null && ex.er() != null && (size = ex.er().size()) > 0) {
                this.aaT.vT().ade = ex.er().get(size - 1);
            }
            this.aaT.vS().oF = eq.responseCode;
            this.aaT.vS().mHeader = eq.oG;
            if (this.aaT.vS().oF != 200) {
                if (this.aaT.vT().ade != null && !TextUtils.isEmpty(this.aaT.vT().ade.ol)) {
                    this.aaT.vS().adc = this.aaT.vT().ade.ol;
                } else {
                    this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh);
                }
                TiebaStatic.net(this.aaT);
                return null;
            } else if (this.aaZ.isCanceled()) {
                return null;
            } else {
                str = new String(eq.oH, "utf-8");
                try {
                    if (this.aaT.vR().vU().mIsBaiduServer && this.aaT.vR().vU().adB) {
                        dt(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
                    aVar.abo = this.aaT.vT().ade.oe;
                    aVar.mTime = this.aaT.vT().ade.oi;
                    aVar.abp = this.aaT.vT().ade.oh;
                    aVar.abn = 1;
                    ad.a(aVar);
                    ad.abm.set(this.aaT.vT().ade.oh);
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aaT.vS().oF = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.aaT.vS().oF = -12;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.aaT.vS().oF = -13;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.aaT.vS().oF = -10;
                    this.aaT.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.aaT.vS().oF = -15;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aaT.vS().oF = -10;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aaT);
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

    @Override // com.baidu.tbadk.core.util.s
    public String uB() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aaZ.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aaZ.a(this.aaT.vR().vU().mUrl, this.aaT.vR().vU().adA, this.aaT.vR().vU().ady, this.aaT.vR().vU().adz, 5, -1, ve());
            this.aaT.vS().oF = a.responseCode;
            this.aaT.vS().mHeader = a.oG;
            if (this.aaT.vS().oF != 200) {
                com.baidu.adp.lib.network.http.f ex = this.aaZ.ex();
                int i = 0;
                if (ex != null && ex.er() != null) {
                    i = ex.er().size();
                }
                if (i <= 0 || (eVar = ex.er().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.ol;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aaT.vS().adc = str3;
                } else {
                    this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh);
                }
                TiebaStatic.net(this.aaT);
                return null;
            } else if (this.aaZ.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.oH, "UTF-8");
                try {
                    dt(str);
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aaT.vS().adc = String.valueOf(String.valueOf(this.aaT.vS().oF)) + "|retryCount:" + (this.aaT.vT().ade == null ? -1 : this.aaT.vT().ade.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aaT.vS().oF = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aaT.vS().oF = -13;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aaT.vS().oF = -10;
                    this.aaT.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aaT.vS().oF = -15;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aaT);
                    return str;
                } catch (SocketException e7) {
                    this.aaT.vS().oF = -12;
                    this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aaT);
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
    @Override // com.baidu.tbadk.core.util.s
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.aaZ.isCanceled()) {
                return this.aaZ.a(this.aaT.vR().vU().mUrl, (z ? new File(str) : m.dd(str)).getAbsolutePath(), false, i2, i3, -1, -1, ve(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.aaT);
            return false;
        } catch (Exception e) {
            this.aaT.vS().oF = -10;
            this.aaT.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aaT.vS().oF = -15;
            this.aaT.vS().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aaT);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> ux() {
        return this.aaT.vR().vU().ady;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aaT.vR().vU().ady != null) {
            this.aaT.vR().vU().ady.clear();
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

    @Override // com.baidu.tbadk.core.util.s
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void d(String str, byte[] bArr) {
        if (this.aaT.vR().vU().adz == null) {
            this.aaT.vR().vU().adz = new HashMap<>();
        }
        this.aaT.vR().vU().adz.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aaT.vR().vU().ady == null) {
                this.aaT.vR().vU().ady = new ArrayList<>();
            }
            int c = c(this.aaT.vR().vU().ady, basicNameValuePair.getName());
            int size = this.aaT.vR().vU().ady.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aaT.vR().vU().ady.get(c).getName())) {
                    this.aaT.vR().vU().ady.set(c, basicNameValuePair);
                } else {
                    this.aaT.vR().vU().ady.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aaT.vR().vU().ady.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> ve() {
        if (this.aaT != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aaT.vR().vU().adD)) {
                linkedList.add(new BasicNameValuePair("sid", this.aaT.vR().vU().adD));
            }
            if (!TextUtils.isEmpty(this.aaT.vR().vU().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aaT.vR().vU().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
