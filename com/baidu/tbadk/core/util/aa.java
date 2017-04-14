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
import com.baidu.tieba.w;
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
    private static int afk = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aff;
    private com.baidu.adp.lib.network.a.a afl = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        vv();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aff = aVar;
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

    private void vv() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fu() {
        if (this.afl != null) {
            this.afl.fu();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fr() {
        this.afl.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uZ() {
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
            if (this.aff.wp().ws().ahG != null && this.aff.wp().ws().ahG.size() > 0 && !this.aff.wp().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aff.wp().ws().mUrl);
                if (this.aff.wp().ws().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aff.wp().ws().mUrl.endsWith("?") && !this.aff.wp().ws().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aff.wp().ws().ahG.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aff.wp().ws().ahG.get(i).getName());
                    sb.append("=");
                    sb.append(au.aD(this.aff.wp().ws().ahG.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aff.wp().ws().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aff.wp().ws().ahI || this.aff.wp().ws().mIsBDImage) && !this.aff.wp().mIsFromCDN) {
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
        if (this.afl.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afl.a(str, z, 5, 100, -1, -1, vE());
        com.baidu.adp.lib.network.http.f fI = this.afl.fI();
        if (fI == null) {
            return null;
        }
        hVar = fI.fB();
        if (fI != null) {
            try {
                if (fI.fC() != null && (size = fI.fC().size()) > 0) {
                    this.aff.wr().ahm = fI.fC().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aff.wq().vM = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm != null ? this.aff.wr().ahm.vs : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aff.wq().vM = -13;
                TiebaStatic.net(this.aff);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aff.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm != null ? this.aff.wr().ahm.vs : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aff.wq().vM = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aff);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm != null ? this.aff.wr().ahm.vs : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aff.wq().vM = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aff);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm != null ? this.aff.wr().ahm.vs : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aff.wq().vM = -12;
                TiebaStatic.net(this.aff);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aff.wq().vM = hVar.responseCode;
        if (this.aff.wq().vM != 200) {
            this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
            if (this.aff.wr().ahm != null && !TextUtils.isEmpty(this.aff.wr().ahm.vv)) {
                this.aff.wq().ahl = this.aff.wr().ahm.vv;
            } else {
                this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs);
            }
            TiebaStatic.net(this.aff);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afk) {
                    this.aff.wq().vM = -11;
                    TiebaStatic.net(this.aff);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.EJ().eT(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aff.wp().ws().mUrl + "], size:" + i2);
                            this.aff.wq().vM = -16;
                            TiebaStatic.net(this.aff);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hp());
        aVar.afA = this.aff.wr().ahm.vp;
        aVar.mTime = new Date().getTime() - j;
        aVar.afB = this.aff.wr().ahm.vs;
        aVar.afz = 2;
        ad.a(aVar);
        ad.afy.set(this.aff.wr().ahm.vs);
        TiebaStatic.net(this.aff);
        bArr = hVar == null ? hVar.vO : null;
        return bArr;
    }

    public void ds(String str) {
        this.aff.wq().ahk = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aff.wq().ahk = errorData.getError_code();
                if (this.aff.wq().ahk == -1) {
                    this.aff.wq().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
                } else if (this.aff.wq().ahk != 0) {
                    this.aff.wq().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aff.wq().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String va() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uZ = uZ();
        if (uZ == null || this.aff.wq().vM != 200) {
            return null;
        }
        try {
            this.aff.wp().ws().ahK = TextUtils.isEmpty(this.aff.wp().ws().ahK) ? "UTF-8" : this.aff.wp().ws().ahK;
            str = new String(uZ, 0, uZ.length, this.aff.wp().ws().ahK);
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

    @Override // com.baidu.tbadk.core.util.s
    public String uY() {
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
            if (this.aff.wp().ws().ahG == null || i2 >= this.aff.wp().ws().ahG.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aff.wp().ws().ahG.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aff.wp().ws().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.afl.isCanceled()) {
                return null;
            }
            if (this.afl.a(this.aff.wp().ws().mUrl, this.aff.wp().ws().ahG, this.aff.wp().ws().ahI, 5, -1, vE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f fI = this.afl.fI();
            if (fI == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fB = fI.fB();
            if (fI != null && fI.fC() != null && (size = fI.fC().size()) > 0) {
                this.aff.wr().ahm = fI.fC().get(size - 1);
            }
            this.aff.wq().vM = fB.responseCode;
            this.aff.wq().mHeader = fB.vN;
            if (this.aff.wq().vM != 200) {
                if (this.aff.wr().ahm != null && !TextUtils.isEmpty(this.aff.wr().ahm.vv)) {
                    this.aff.wq().ahl = this.aff.wr().ahm.vv;
                } else {
                    this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs);
                }
                TiebaStatic.net(this.aff);
                return null;
            } else if (this.afl.isCanceled()) {
                return null;
            } else {
                str = new String(fB.vO, "utf-8");
                try {
                    if (this.aff.wp().ws().mIsBaiduServer && this.aff.wp().ws().ahJ) {
                        ds(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hp());
                    aVar.afA = this.aff.wr().ahm.vp;
                    aVar.mTime = this.aff.wr().ahm.vt;
                    aVar.afB = this.aff.wr().ahm.vs;
                    aVar.afz = 1;
                    ad.a(aVar);
                    ad.afy.set(this.aff.wr().ahm.vs);
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aff.wq().vM = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.aff.wq().vM = -12;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.aff.wq().vM = -13;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.aff.wq().vM = -10;
                    this.aff.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.aff.wq().vM = -15;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aff.wq().vM = -10;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aff);
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
    public String vb() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.afl.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.afl.a(this.aff.wp().ws().mUrl, this.aff.wp().ws().ahI, this.aff.wp().ws().ahG, this.aff.wp().ws().ahH, 5, -1, vE());
            this.aff.wq().vM = a.responseCode;
            this.aff.wq().mHeader = a.vN;
            if (this.aff.wq().vM != 200) {
                com.baidu.adp.lib.network.http.f fI = this.afl.fI();
                int i = 0;
                if (fI != null && fI.fC() != null) {
                    i = fI.fC().size();
                }
                if (i <= 0 || (eVar = fI.fC().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vv;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aff.wq().ahl = str3;
                } else {
                    this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs);
                }
                TiebaStatic.net(this.aff);
                return null;
            } else if (this.afl.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vO, "UTF-8");
                try {
                    ds(str);
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aff.wq().ahl = String.valueOf(String.valueOf(this.aff.wq().vM)) + "|retryCount:" + (this.aff.wr().ahm == null ? -1 : this.aff.wr().ahm.vs) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aff.wq().vM = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aff.wq().vM = -13;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aff.wq().vM = -10;
                    this.aff.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aff.wq().vM = -15;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aff);
                    return str;
                } catch (SocketException e7) {
                    this.aff.wq().vM = -12;
                    this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aff);
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
            if (!this.afl.isCanceled()) {
                return this.afl.a(this.aff.wp().ws().mUrl, (z ? new File(str) : l.dc(str)).getAbsolutePath(), false, i2, i3, -1, -1, vE(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.aff);
            return false;
        } catch (Exception e) {
            this.aff.wq().vM = -10;
            this.aff.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aff.wq().vM = -15;
            this.aff.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aff);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> uX() {
        return this.aff.wp().ws().ahG;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aff.wp().ws().ahG != null) {
            this.aff.wp().ws().ahG.clear();
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
        if (this.aff.wp().ws().ahH == null) {
            this.aff.wp().ws().ahH = new HashMap<>();
        }
        this.aff.wp().ws().ahH.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aff.wp().ws().ahG == null) {
                this.aff.wp().ws().ahG = new ArrayList<>();
            }
            int c = c(this.aff.wp().ws().ahG, basicNameValuePair.getName());
            int size = this.aff.wp().ws().ahG.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aff.wp().ws().ahG.get(c).getName())) {
                    this.aff.wp().ws().ahG.set(c, basicNameValuePair);
                } else {
                    this.aff.wp().ws().ahG.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aff.wp().ws().ahG.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vE() {
        if (this.aff != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aff.wp().ws().ahL)) {
                linkedList.add(new BasicNameValuePair("sid", this.aff.wp().ws().ahL));
            }
            if (!TextUtils.isEmpty(this.aff.wp().ws().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aff.wp().ws().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
