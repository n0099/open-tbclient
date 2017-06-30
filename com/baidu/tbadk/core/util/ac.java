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
public class ac implements u {
    private static int afd = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aeY;
    private com.baidu.adp.lib.network.a.a afe = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        uU();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aeY = aVar;
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

    private void uU() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void fu() {
        if (this.afe != null) {
            this.afe.fu();
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public void fr() {
        this.afe.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tP() {
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
            if (this.aeY.vR().vU().ahy != null && this.aeY.vR().vU().ahy.size() > 0 && !this.aeY.vR().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aeY.vR().vU().mUrl);
                if (this.aeY.vR().vU().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aeY.vR().vU().mUrl.endsWith("?") && !this.aeY.vR().vU().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aeY.vR().vU().ahy.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aeY.vR().vU().ahy.get(i).getName());
                    sb.append("=");
                    sb.append(aw.aI(this.aeY.vR().vU().ahy.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aeY.vR().vU().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aeY.vR().vU().ahA || this.aeY.vR().vU().mIsBDImage) && !this.aeY.vR().mIsFromCDN) {
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
        if (this.afe.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afe.a(str, z, 5, 100, -1, -1, ve());
        com.baidu.adp.lib.network.http.f fI = this.afe.fI();
        if (fI == null) {
            return null;
        }
        hVar = fI.fB();
        if (fI != null) {
            try {
                if (fI.fC() != null && (size = fI.fC().size()) > 0) {
                    this.aeY.vT().ahe = fI.fC().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aeY.vS().vQ = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe != null ? this.aeY.vT().ahe.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeY.vS().vQ = -13;
                TiebaStatic.net(this.aeY);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aeY.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe != null ? this.aeY.vT().ahe.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeY.vS().vQ = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aeY);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe != null ? this.aeY.vT().ahe.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeY.vS().vQ = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aeY);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe != null ? this.aeY.vT().ahe.vw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeY.vS().vQ = -12;
                TiebaStatic.net(this.aeY);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aeY.vS().vQ = hVar.responseCode;
        if (this.aeY.vS().vQ != 200) {
            this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
            if (this.aeY.vT().ahe != null && !TextUtils.isEmpty(this.aeY.vT().ahe.vz)) {
                this.aeY.vS().ahd = this.aeY.vT().ahe.vz;
            } else {
                this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw);
            }
            TiebaStatic.net(this.aeY);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afd) {
                    this.aeY.vS().vQ = -11;
                    TiebaStatic.net(this.aeY);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Eb().eS(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aeY.vR().vU().mUrl + "], size:" + i2);
                            this.aeY.vS().vQ = -16;
                            TiebaStatic.net(this.aeY);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hp());
        aVar.afs = this.aeY.vT().ahe.vu;
        aVar.mTime = new Date().getTime() - j;
        aVar.aft = this.aeY.vT().ahe.vw;
        aVar.afr = 2;
        af.a(aVar);
        af.afq.set(this.aeY.vT().ahe.vw);
        TiebaStatic.net(this.aeY);
        bArr = hVar == null ? hVar.vS : null;
        return bArr;
    }

    public void dH(String str) {
        this.aeY.vS().ahc = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aeY.vS().ahc = errorData.getError_code();
                if (this.aeY.vS().ahc == -1) {
                    this.aeY.vS().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
                } else if (this.aeY.vS().ahc != 0) {
                    this.aeY.vS().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aeY.vS().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public String uz() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tP = tP();
        if (tP == null || this.aeY.vS().vQ != 200) {
            return null;
        }
        try {
            this.aeY.vR().vU().ahC = TextUtils.isEmpty(this.aeY.vR().vU().ahC) ? "UTF-8" : this.aeY.vR().vU().ahC;
            str = new String(tP, 0, tP.length, this.aeY.vR().vU().ahC);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dH(str);
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

    @Override // com.baidu.tbadk.core.util.u
    public String uy() {
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
            if (this.aeY.vR().vU().ahy == null || i2 >= this.aeY.vR().vU().ahy.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aeY.vR().vU().ahy.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aeY.vR().vU().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aN(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.afe.isCanceled()) {
                return null;
            }
            if (this.afe.a(this.aeY.vR().vU().mUrl, this.aeY.vR().vU().ahy, this.aeY.vR().vU().ahA, 5, -1, ve()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f fI = this.afe.fI();
            if (fI == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fB = fI.fB();
            if (fI != null && fI.fC() != null && (size = fI.fC().size()) > 0) {
                this.aeY.vT().ahe = fI.fC().get(size - 1);
            }
            this.aeY.vS().vQ = fB.responseCode;
            this.aeY.vS().mHeader = fB.vR;
            if (this.aeY.vS().vQ != 200) {
                if (this.aeY.vT().ahe != null && !TextUtils.isEmpty(this.aeY.vT().ahe.vz)) {
                    this.aeY.vS().ahd = this.aeY.vT().ahe.vz;
                } else {
                    this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw);
                }
                TiebaStatic.net(this.aeY);
                return null;
            } else if (this.afe.isCanceled()) {
                return null;
            } else {
                str = new String(fB.vS, "utf-8");
                try {
                    if (this.aeY.vR().vU().mIsBaiduServer && this.aeY.vR().vU().ahB) {
                        dH(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hp());
                    aVar.afs = this.aeY.vT().ahe.vu;
                    aVar.mTime = this.aeY.vT().ahe.vx;
                    aVar.aft = this.aeY.vT().ahe.vw;
                    aVar.afr = 1;
                    af.a(aVar);
                    af.afq.set(this.aeY.vT().ahe.vw);
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aeY.vS().vQ = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aeY.vS().vQ = -15;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aeY.vS().vQ = -12;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aeY.vS().vQ = -13;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aeY.vS().vQ = -10;
                    this.aeY.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aeY.vS().vQ = -10;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aeY);
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

    @Override // com.baidu.tbadk.core.util.u
    public String uA() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.afe.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.afe.a(this.aeY.vR().vU().mUrl, this.aeY.vR().vU().ahA, this.aeY.vR().vU().ahy, this.aeY.vR().vU().ahz, 5, -1, ve());
            this.aeY.vS().vQ = a.responseCode;
            this.aeY.vS().mHeader = a.vR;
            if (this.aeY.vS().vQ != 200) {
                com.baidu.adp.lib.network.http.f fI = this.afe.fI();
                int i = 0;
                if (fI != null && fI.fC() != null) {
                    i = fI.fC().size();
                }
                if (i <= 0 || (eVar = fI.fC().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vz;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aeY.vS().ahd = str3;
                } else {
                    this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw);
                }
                TiebaStatic.net(this.aeY);
                return null;
            } else if (this.afe.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vS, "UTF-8");
                try {
                    dH(str);
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aeY.vS().ahd = String.valueOf(String.valueOf(this.aeY.vS().vQ)) + "|retryCount:" + (this.aeY.vT().ahe == null ? -1 : this.aeY.vT().ahe.vw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aeY.vS().vQ = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aeY.vS().vQ = -13;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aeY.vS().vQ = -10;
                    this.aeY.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aeY.vS().vQ = -15;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aeY);
                    return str;
                } catch (SocketException e7) {
                    this.aeY.vS().vQ = -12;
                    this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aeY);
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
    @Override // com.baidu.tbadk.core.util.u
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.afe.isCanceled()) {
                return this.afe.a(this.aeY.vR().vU().mUrl, (z ? new File(str) : n.dr(str)).getAbsolutePath(), false, i2, i3, -1, -1, ve(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.aeY);
            return false;
        } catch (Exception e) {
            this.aeY.vS().vQ = -10;
            this.aeY.vS().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aeY.vS().vQ = -15;
            this.aeY.vS().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aeY);
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public ArrayList<BasicNameValuePair> ux() {
        return this.aeY.vR().vU().ahy;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aeY.vR().vU().ahy != null) {
            this.aeY.vR().vU().ahy.clear();
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

    @Override // com.baidu.tbadk.core.util.u
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.u
    public void d(String str, byte[] bArr) {
        if (this.aeY.vR().vU().ahz == null) {
            this.aeY.vR().vU().ahz = new HashMap<>();
        }
        this.aeY.vR().vU().ahz.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.u
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aeY.vR().vU().ahy == null) {
                this.aeY.vR().vU().ahy = new ArrayList<>();
            }
            int c = c(this.aeY.vR().vU().ahy, basicNameValuePair.getName());
            int size = this.aeY.vR().vU().ahy.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aeY.vR().vU().ahy.get(c).getName())) {
                    this.aeY.vR().vU().ahy.set(c, basicNameValuePair);
                } else {
                    this.aeY.vR().vU().ahy.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aeY.vR().vU().ahy.add(c, basicNameValuePair);
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
        if (this.aeY != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aeY.vR().vU().ahD)) {
                linkedList.add(new BasicNameValuePair("sid", this.aeY.vR().vU().ahD));
            }
            if (!TextUtils.isEmpty(this.aeY.vR().vU().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aeY.vR().vU().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
