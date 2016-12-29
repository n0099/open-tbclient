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
    private static int aas = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aan;
    private com.baidu.adp.lib.network.a.a aat = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        uH();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aan = aVar;
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

    private void uH() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void ej() {
        if (this.aat != null) {
            this.aat.ej();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void eg() {
        this.aat.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ul() {
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
            if (this.aan.vB().vE().acQ != null && this.aan.vB().vE().acQ.size() > 0 && !this.aan.vB().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aan.vB().vE().mUrl);
                if (this.aan.vB().vE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aan.vB().vE().mUrl.endsWith("?") && !this.aan.vB().vE().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aan.vB().vE().acQ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aan.vB().vE().acQ.get(i).getName());
                    sb.append("=");
                    sb.append(av.aP(this.aan.vB().vE().acQ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aan.vB().vE().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aan.vB().vE().acS || this.aan.vB().vE().mIsBDImage) && !this.aan.vB().mIsFromCDN) {
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
        if (this.aat.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aat.a(str, z, 5, 100, -1, -1, uQ());
        com.baidu.adp.lib.network.http.f ex = this.aat.ex();
        if (ex == null) {
            return null;
        }
        hVar = ex.eq();
        if (ex != null) {
            try {
                if (ex.er() != null && (size = ex.er().size()) > 0) {
                    this.aan.vD().acw = ex.er().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aan.vC().oF = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw != null ? this.aan.vD().acw.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aan.vC().oF = -13;
                TiebaStatic.net(this.aan);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aan.vC().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw != null ? this.aan.vD().acw.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aan.vC().oF = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aan);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw != null ? this.aan.vD().acw.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aan.vC().oF = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aan);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw != null ? this.aan.vD().acw.oh : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aan.vC().oF = -12;
                TiebaStatic.net(this.aan);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aan.vC().oF = hVar.responseCode;
        if (this.aan.vC().oF != 200) {
            this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
            if (this.aan.vD().acw != null && !TextUtils.isEmpty(this.aan.vD().acw.ol)) {
                this.aan.vC().acv = this.aan.vD().acw.ol;
            } else {
                this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh);
            }
            TiebaStatic.net(this.aan);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aas) {
                    this.aan.vC().oF = -11;
                    TiebaStatic.net(this.aan);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.DX().eU(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aan.vB().vE().mUrl + "], size:" + i2);
                            this.aan.vC().oF = -16;
                            TiebaStatic.net(this.aan);
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
        aVar.aaI = this.aan.vD().acw.oe;
        aVar.mTime = new Date().getTime() - j;
        aVar.aaJ = this.aan.vD().acw.oh;
        aVar.aaH = 2;
        ad.a(aVar);
        ad.aaG.set(this.aan.vD().acw.oh);
        TiebaStatic.net(this.aan);
        bArr = hVar == null ? hVar.oH : null;
        return bArr;
    }

    public void du(String str) {
        this.aan.vC().acu = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aan.vC().acu = errorData.getError_code();
                if (this.aan.vC().acu == -1) {
                    this.aan.vC().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
                } else if (this.aan.vC().acu != 0) {
                    this.aan.vC().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aan.vC().mErrorString = this.mContext.getString(r.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String um() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ul = ul();
        if (ul == null || this.aan.vC().oF != 200) {
            return null;
        }
        try {
            this.aan.vB().vE().acU = TextUtils.isEmpty(this.aan.vB().vE().acU) ? "UTF-8" : this.aan.vB().vE().acU;
            str = new String(ul, 0, ul.length, this.aan.vB().vE().acU);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            du(str);
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
    public String uk() {
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
            if (this.aan.vB().vE().acQ == null || i2 >= this.aan.vB().vE().acQ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aan.vB().vE().acQ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aan.vB().vE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aU(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aat.isCanceled()) {
                return null;
            }
            if (this.aat.a(this.aan.vB().vE().mUrl, this.aan.vB().vE().acQ, this.aan.vB().vE().acS, 5, -1, uQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ex = this.aat.ex();
            if (ex == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h eq = ex.eq();
            if (ex != null && ex.er() != null && (size = ex.er().size()) > 0) {
                this.aan.vD().acw = ex.er().get(size - 1);
            }
            this.aan.vC().oF = eq.responseCode;
            this.aan.vC().mHeader = eq.oG;
            if (this.aan.vC().oF != 200) {
                if (this.aan.vD().acw != null && !TextUtils.isEmpty(this.aan.vD().acw.ol)) {
                    this.aan.vC().acv = this.aan.vD().acw.ol;
                } else {
                    this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh);
                }
                TiebaStatic.net(this.aan);
                return null;
            } else if (this.aat.isCanceled()) {
                return null;
            } else {
                str = new String(eq.oH, "utf-8");
                try {
                    if (this.aan.vB().vE().mIsBaiduServer && this.aan.vB().vE().acT) {
                        du(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.gs());
                    aVar.aaI = this.aan.vD().acw.oe;
                    aVar.mTime = this.aan.vD().acw.oi;
                    aVar.aaJ = this.aan.vD().acw.oh;
                    aVar.aaH = 1;
                    ad.a(aVar);
                    ad.aaG.set(this.aan.vD().acw.oh);
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aan.vC().oF = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.aan.vC().oF = -12;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.aan.vC().oF = -13;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.aan.vC().oF = -10;
                    this.aan.vC().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.aan.vC().oF = -15;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aan.vC().oF = -10;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aan);
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

    @Override // com.baidu.tbadk.core.util.s
    public String un() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aat.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aat.a(this.aan.vB().vE().mUrl, this.aan.vB().vE().acS, this.aan.vB().vE().acQ, this.aan.vB().vE().acR, 5, -1, uQ());
            this.aan.vC().oF = a.responseCode;
            this.aan.vC().mHeader = a.oG;
            if (this.aan.vC().oF != 200) {
                com.baidu.adp.lib.network.http.f ex = this.aat.ex();
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
                    this.aan.vC().acv = str3;
                } else {
                    this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh);
                }
                TiebaStatic.net(this.aan);
                return null;
            } else if (this.aat.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.oH, "UTF-8");
                try {
                    du(str);
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    this.aan.vC().acv = String.valueOf(String.valueOf(this.aan.vC().oF)) + "|retryCount:" + (this.aan.vD().acw == null ? -1 : this.aan.vD().acw.oh) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aan.vC().oF = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aan.vC().oF = -13;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aan.vC().oF = -10;
                    this.aan.vC().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aan.vC().oF = -15;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aan);
                    return str;
                } catch (SocketException e7) {
                    this.aan.vC().oF = -12;
                    this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.neterror);
                    TiebaStatic.net(this.aan);
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
            if (!this.aat.isCanceled()) {
                return this.aat.a(this.aan.vB().vE().mUrl, (z ? new File(str) : m.de(str)).getAbsolutePath(), false, i2, i3, -1, -1, uQ(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.aan);
            return false;
        } catch (Exception e) {
            this.aan.vC().oF = -10;
            this.aan.vC().mErrorString = String.valueOf(this.mContext.getResources().getString(r.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aan.vC().oF = -15;
            this.aan.vC().mErrorString = this.mContext.getResources().getString(r.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aan);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> uj() {
        return this.aan.vB().vE().acQ;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aan.vB().vE().acQ != null) {
            this.aan.vB().vE().acQ.clear();
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
        if (this.aan.vB().vE().acR == null) {
            this.aan.vB().vE().acR = new HashMap<>();
        }
        this.aan.vB().vE().acR.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aan.vB().vE().acQ == null) {
                this.aan.vB().vE().acQ = new ArrayList<>();
            }
            int c = c(this.aan.vB().vE().acQ, basicNameValuePair.getName());
            int size = this.aan.vB().vE().acQ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aan.vB().vE().acQ.get(c).getName())) {
                    this.aan.vB().vE().acQ.set(c, basicNameValuePair);
                } else {
                    this.aan.vB().vE().acQ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aan.vB().vE().acQ.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uQ() {
        if (this.aan != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aan.vB().vE().acV)) {
                linkedList.add(new BasicNameValuePair("sid", this.aan.vB().vE().acV));
            }
            if (!TextUtils.isEmpty(this.aan.vB().vE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aan.vB().vE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
