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
    private static int afl = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a afg;
    private com.baidu.adp.lib.network.a.a afm = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        vv();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.afg = aVar;
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
    public void fv() {
        if (this.afm != null) {
            this.afm.fv();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fs() {
        this.afm.cancel();
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
            if (this.afg.wp().ws().ahH != null && this.afg.wp().ws().ahH.size() > 0 && !this.afg.wp().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.afg.wp().ws().mUrl);
                if (this.afg.wp().ws().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.afg.wp().ws().mUrl.endsWith("?") && !this.afg.wp().ws().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.afg.wp().ws().ahH.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.afg.wp().ws().ahH.get(i).getName());
                    sb.append("=");
                    sb.append(au.aD(this.afg.wp().ws().ahH.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.afg.wp().ws().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.afg.wp().ws().ahJ || this.afg.wp().ws().mIsBDImage) && !this.afg.wp().mIsFromCDN) {
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
        if (this.afm.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afm.a(str, z, 5, 100, -1, -1, vE());
        com.baidu.adp.lib.network.http.f fJ = this.afm.fJ();
        if (fJ == null) {
            return null;
        }
        hVar = fJ.fC();
        if (fJ != null) {
            try {
                if (fJ.fD() != null && (size = fJ.fD().size()) > 0) {
                    this.afg.wr().ahn = fJ.fD().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.afg.wq().vQ = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn != null ? this.afg.wr().ahn.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afg.wq().vQ = -13;
                TiebaStatic.net(this.afg);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.afg.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn != null ? this.afg.wr().ahn.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afg.wq().vQ = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afg);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn != null ? this.afg.wr().ahn.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afg.wq().vQ = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afg);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn != null ? this.afg.wr().ahn.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afg.wq().vQ = -12;
                TiebaStatic.net(this.afg);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.afg.wq().vQ = hVar.responseCode;
        if (this.afg.wq().vQ != 200) {
            this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
            if (this.afg.wr().ahn != null && !TextUtils.isEmpty(this.afg.wr().ahn.vz)) {
                this.afg.wq().ahm = this.afg.wr().ahn.vz;
            } else {
                this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw);
            }
            TiebaStatic.net(this.afg);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afl) {
                    this.afg.wq().vQ = -11;
                    TiebaStatic.net(this.afg);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.EJ().eT(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.afg.wp().ws().mUrl + "], size:" + i2);
                            this.afg.wq().vQ = -16;
                            TiebaStatic.net(this.afg);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hq());
        aVar.afB = this.afg.wr().ahn.vu;
        aVar.mTime = new Date().getTime() - j;
        aVar.afC = this.afg.wr().ahn.vw;
        aVar.afA = 2;
        ad.a(aVar);
        ad.afz.set(this.afg.wr().ahn.vw);
        TiebaStatic.net(this.afg);
        bArr = hVar == null ? hVar.vS : null;
        return bArr;
    }

    public void ds(String str) {
        this.afg.wq().ahl = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.afg.wq().ahl = errorData.getError_code();
                if (this.afg.wq().ahl == -1) {
                    this.afg.wq().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
                } else if (this.afg.wq().ahl != 0) {
                    this.afg.wq().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.afg.wq().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String va() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uZ = uZ();
        if (uZ == null || this.afg.wq().vQ != 200) {
            return null;
        }
        try {
            this.afg.wp().ws().ahL = TextUtils.isEmpty(this.afg.wp().ws().ahL) ? "UTF-8" : this.afg.wp().ws().ahL;
            str = new String(uZ, 0, uZ.length, this.afg.wp().ws().ahL);
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
            if (this.afg.wp().ws().ahH == null || i2 >= this.afg.wp().ws().ahH.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.afg.wp().ws().ahH.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.afg.wp().ws().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.afm.isCanceled()) {
                return null;
            }
            if (this.afm.a(this.afg.wp().ws().mUrl, this.afg.wp().ws().ahH, this.afg.wp().ws().ahJ, 5, -1, vE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f fJ = this.afm.fJ();
            if (fJ == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fC = fJ.fC();
            if (fJ != null && fJ.fD() != null && (size = fJ.fD().size()) > 0) {
                this.afg.wr().ahn = fJ.fD().get(size - 1);
            }
            this.afg.wq().vQ = fC.responseCode;
            this.afg.wq().mHeader = fC.vR;
            if (this.afg.wq().vQ != 200) {
                if (this.afg.wr().ahn != null && !TextUtils.isEmpty(this.afg.wr().ahn.vz)) {
                    this.afg.wq().ahm = this.afg.wr().ahn.vz;
                } else {
                    this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw);
                }
                TiebaStatic.net(this.afg);
                return null;
            } else if (this.afm.isCanceled()) {
                return null;
            } else {
                str = new String(fC.vS, "utf-8");
                try {
                    if (this.afg.wp().ws().mIsBaiduServer && this.afg.wp().ws().ahK) {
                        ds(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hq());
                    aVar.afB = this.afg.wr().ahn.vu;
                    aVar.mTime = this.afg.wr().ahn.vx;
                    aVar.afC = this.afg.wr().ahn.vw;
                    aVar.afA = 1;
                    ad.a(aVar);
                    ad.afz.set(this.afg.wr().ahn.vw);
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.afg.wq().vQ = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e3 = e6;
                    this.afg.wq().vQ = -15;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (SocketException e7) {
                    e2 = e7;
                    this.afg.wq().vQ = -12;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    this.afg.wq().vQ = -13;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (Exception e9) {
                    e4 = e9;
                    this.afg.wq().vQ = -10;
                    this.afg.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.afg.wq().vQ = -10;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.afg);
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
            if (this.afm.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.afm.a(this.afg.wp().ws().mUrl, this.afg.wp().ws().ahJ, this.afg.wp().ws().ahH, this.afg.wp().ws().ahI, 5, -1, vE());
            this.afg.wq().vQ = a.responseCode;
            this.afg.wq().mHeader = a.vR;
            if (this.afg.wq().vQ != 200) {
                com.baidu.adp.lib.network.http.f fJ = this.afm.fJ();
                int i = 0;
                if (fJ != null && fJ.fD() != null) {
                    i = fJ.fD().size();
                }
                if (i <= 0 || (eVar = fJ.fD().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vz;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.afg.wq().ahm = str3;
                } else {
                    this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw);
                }
                TiebaStatic.net(this.afg);
                return null;
            } else if (this.afm.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vS, "UTF-8");
                try {
                    ds(str);
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.afg.wq().ahm = String.valueOf(String.valueOf(this.afg.wq().vQ)) + "|retryCount:" + (this.afg.wr().ahn == null ? -1 : this.afg.wr().ahn.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.afg.wq().vQ = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.afg.wq().vQ = -13;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.afg.wq().vQ = -10;
                    this.afg.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.afg.wq().vQ = -15;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afg);
                    return str;
                } catch (SocketException e7) {
                    this.afg.wq().vQ = -12;
                    this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.afg);
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
            if (!this.afm.isCanceled()) {
                return this.afm.a(this.afg.wp().ws().mUrl, (z ? new File(str) : l.dc(str)).getAbsolutePath(), false, i2, i3, -1, -1, vE(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.afg);
            return false;
        } catch (Exception e) {
            this.afg.wq().vQ = -10;
            this.afg.wq().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.afg.wq().vQ = -15;
            this.afg.wq().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.afg);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> uX() {
        return this.afg.wp().ws().ahH;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.afg.wp().ws().ahH != null) {
            this.afg.wp().ws().ahH.clear();
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
        if (this.afg.wp().ws().ahI == null) {
            this.afg.wp().ws().ahI = new HashMap<>();
        }
        this.afg.wp().ws().ahI.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.afg.wp().ws().ahH == null) {
                this.afg.wp().ws().ahH = new ArrayList<>();
            }
            int c = c(this.afg.wp().ws().ahH, basicNameValuePair.getName());
            int size = this.afg.wp().ws().ahH.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.afg.wp().ws().ahH.get(c).getName())) {
                    this.afg.wp().ws().ahH.set(c, basicNameValuePair);
                } else {
                    this.afg.wp().ws().ahH.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.afg.wp().ws().ahH.add(c, basicNameValuePair);
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
        if (this.afg != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.afg.wp().ws().ahM)) {
                linkedList.add(new BasicNameValuePair("sid", this.afg.wp().ws().ahM));
            }
            if (!TextUtils.isEmpty(this.afg.wp().ws().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.afg.wp().ws().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
