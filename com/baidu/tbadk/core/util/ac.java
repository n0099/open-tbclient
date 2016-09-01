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
    private static int aan = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aai;
    private com.baidu.adp.lib.network.a.a aao = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        uC();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aai = aVar;
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

    private void uC() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void ej() {
        if (this.aao != null) {
            this.aao.ej();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void eg() {
        this.aao.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uf() {
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
            if (this.aai.vz().vC().acO != null && this.aai.vz().vC().acO.size() > 0 && !this.aai.vz().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aai.vz().vC().mUrl);
                if (this.aai.vz().vC().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aai.vz().vC().mUrl.endsWith("?") && !this.aai.vz().vC().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aai.vz().vC().acO.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aai.vz().vC().acO.get(i).getName());
                    sb.append("=");
                    sb.append(ba.aP(this.aai.vz().vC().acO.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aai.vz().vC().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aai.vz().vC().acQ || this.aai.vz().vC().mIsBDImage) && !this.aai.vz().mIsFromCDN) {
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
        if (this.aao.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aao.a(str, z, 5, 100, -1, -1, uL());
        com.baidu.adp.lib.network.http.f ex = this.aao.ex();
        if (ex == null) {
            return null;
        }
        hVar = ex.eq();
        if (ex != null) {
            try {
                if (ex.er() != null && (size = ex.er().size()) > 0) {
                    this.aai.vB().acu = ex.er().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aai.vA().oE = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu != null ? this.aai.vB().acu.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aai.vA().oE = -13;
                TiebaStatic.net(this.aai);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aai.vA().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu != null ? this.aai.vB().acu.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aai.vA().oE = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aai);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu != null ? this.aai.vB().acu.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aai.vA().oE = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aai);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu != null ? this.aai.vB().acu.og : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aai.vA().oE = -12;
                TiebaStatic.net(this.aai);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aai.vA().oE = hVar.responseCode;
        if (this.aai.vA().oE != 200) {
            this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
            if (this.aai.vB().acu != null && !TextUtils.isEmpty(this.aai.vB().acu.oj)) {
                this.aai.vA().act = this.aai.vB().acu.oj;
            } else {
                this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og);
            }
            TiebaStatic.net(this.aai);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aan) {
                    this.aai.vA().oE = -11;
                    TiebaStatic.net(this.aai);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Ek().eR(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aai.vz().vC().mUrl + "], size:" + i2);
                            this.aai.vA().oE = -16;
                            TiebaStatic.net(this.aai);
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
        aVar.aaD = this.aai.vB().acu.od;
        aVar.mTime = new Date().getTime() - j;
        aVar.aaE = this.aai.vB().acu.og;
        aVar.aaC = 2;
        af.a(aVar);
        af.aaB.set(this.aai.vB().acu.og);
        TiebaStatic.net(this.aai);
        bArr = hVar == null ? hVar.oG : null;
        return bArr;
    }

    public void dp(String str) {
        this.aai.vA().acs = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aai.vA().acs = errorData.getError_code();
                if (this.aai.vA().acs == -1) {
                    this.aai.vA().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
                } else if (this.aai.vA().acs != 0) {
                    this.aai.vA().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aai.vA().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String ug() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uf = uf();
        if (uf == null || this.aai.vA().oE != 200) {
            return null;
        }
        try {
            this.aai.vz().vC().acS = TextUtils.isEmpty(this.aai.vz().vC().acS) ? "UTF-8" : this.aai.vz().vC().acS;
            str = new String(uf, 0, uf.length, this.aai.vz().vC().acS);
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
    public String ue() {
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
            if (this.aai.vz().vC().acO == null || i2 >= this.aai.vz().vC().acO.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aai.vz().vC().acO.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aai.vz().vC().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aao.isCanceled()) {
                return null;
            }
            if (this.aao.a(this.aai.vz().vC().mUrl, this.aai.vz().vC().acO, this.aai.vz().vC().acQ, 5, -1, uL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ex = this.aao.ex();
            if (ex == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h eq = ex.eq();
            if (ex != null && ex.er() != null && (size = ex.er().size()) > 0) {
                this.aai.vB().acu = ex.er().get(size - 1);
            }
            this.aai.vA().oE = eq.responseCode;
            this.aai.vA().mHeader = eq.oF;
            if (this.aai.vA().oE != 200) {
                if (this.aai.vB().acu != null && !TextUtils.isEmpty(this.aai.vB().acu.oj)) {
                    this.aai.vA().act = this.aai.vB().acu.oj;
                } else {
                    this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og);
                }
                TiebaStatic.net(this.aai);
                return null;
            } else if (this.aao.isCanceled()) {
                return null;
            } else {
                str = new String(eq.oG, "utf-8");
                try {
                    if (this.aai.vz().vC().mIsBaiduServer && this.aai.vz().vC().acR) {
                        dp(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
                    aVar.aaD = this.aai.vB().acu.od;
                    aVar.mTime = this.aai.vB().acu.oh;
                    aVar.aaE = this.aai.vB().acu.og;
                    aVar.aaC = 1;
                    af.a(aVar);
                    af.aaB.set(this.aai.vB().acu.og);
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aai.vA().oE = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.aai.vA().oE = -12;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.aai.vA().oE = -13;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.aai.vA().oE = -10;
                    this.aai.vA().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.aai.vA().oE = -15;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aai.vA().oE = -10;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aai);
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
    public String uh() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aao.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aao.a(this.aai.vz().vC().mUrl, this.aai.vz().vC().acQ, this.aai.vz().vC().acO, this.aai.vz().vC().acP, 5, -1, uL());
            this.aai.vA().oE = a.responseCode;
            this.aai.vA().mHeader = a.oF;
            if (this.aai.vA().oE != 200) {
                com.baidu.adp.lib.network.http.f ex = this.aao.ex();
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
                    this.aai.vA().act = str3;
                } else {
                    this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og);
                }
                TiebaStatic.net(this.aai);
                return null;
            } else if (this.aao.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.oG, "UTF-8");
                try {
                    dp(str);
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.aai.vA().act = String.valueOf(String.valueOf(this.aai.vA().oE)) + "|retryCount:" + (this.aai.vB().acu == null ? -1 : this.aai.vB().acu.og) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aai.vA().oE = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aai.vA().oE = -13;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aai.vA().oE = -10;
                    this.aai.vA().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aai.vA().oE = -15;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aai);
                    return str;
                } catch (SocketException e7) {
                    this.aai.vA().oE = -12;
                    this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    TiebaStatic.net(this.aai);
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
            if (!this.aao.isCanceled()) {
                return this.aao.a(this.aai.vz().vC().mUrl, (z ? new File(str) : m.cZ(str)).getAbsolutePath(), false, i2, i3, -1, -1, uL(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.aai);
            return false;
        } catch (Exception e) {
            this.aai.vA().oE = -10;
            this.aai.vA().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aai.vA().oE = -15;
            this.aai.vA().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aai);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> ud() {
        return this.aai.vz().vC().acO;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aai.vz().vC().acO != null) {
            this.aai.vz().vC().acO.clear();
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
        if (this.aai.vz().vC().acP == null) {
            this.aai.vz().vC().acP = new HashMap<>();
        }
        this.aai.vz().vC().acP.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aai.vz().vC().acO == null) {
                this.aai.vz().vC().acO = new ArrayList<>();
            }
            int c = c(this.aai.vz().vC().acO, basicNameValuePair.getName());
            int size = this.aai.vz().vC().acO.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aai.vz().vC().acO.get(c).getName())) {
                    this.aai.vz().vC().acO.set(c, basicNameValuePair);
                } else {
                    this.aai.vz().vC().acO.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aai.vz().vC().acO.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uL() {
        if (this.aai != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aai.vz().vC().acT)) {
                linkedList.add(new BasicNameValuePair("sid", this.aai.vz().vC().acT));
            }
            if (!TextUtils.isEmpty(this.aai.vz().vC().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aai.vz().vC().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
