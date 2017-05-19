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
    private static int aeD = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private com.baidu.adp.lib.network.a.a aeE = new com.baidu.adp.lib.network.a.a();
    private final com.baidu.tbadk.core.util.a.a aey;
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        uI();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aey = aVar;
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

    private void uI() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fv() {
        if (this.aeE != null) {
            this.aeE.fv();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fs() {
        this.aeE.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] um() {
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
            if (this.aey.vD().vG().agZ != null && this.aey.vD().vG().agZ.size() > 0 && !this.aey.vD().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aey.vD().vG().mUrl);
                if (this.aey.vD().vG().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aey.vD().vG().mUrl.endsWith("?") && !this.aey.vD().vG().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aey.vD().vG().agZ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aey.vD().vG().agZ.get(i).getName());
                    sb.append("=");
                    sb.append(au.aD(this.aey.vD().vG().agZ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aey.vD().vG().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aey.vD().vG().ahb || this.aey.vD().vG().mIsBDImage) && !this.aey.vD().mIsFromCDN) {
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
        if (this.aeE.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aeE.a(str, z, 5, 100, -1, -1, uR());
        com.baidu.adp.lib.network.http.f fJ = this.aeE.fJ();
        if (fJ == null) {
            return null;
        }
        hVar = fJ.fC();
        if (fJ != null) {
            try {
                if (fJ.fD() != null && (size = fJ.fD().size()) > 0) {
                    this.aey.vF().agF = fJ.fD().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aey.vE().vR = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF != null ? this.aey.vF().agF.vx : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aey.vE().vR = -13;
                TiebaStatic.net(this.aey);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aey.vE().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF != null ? this.aey.vF().agF.vx : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aey.vE().vR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aey);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF != null ? this.aey.vF().agF.vx : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aey.vE().vR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aey);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF != null ? this.aey.vF().agF.vx : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aey.vE().vR = -12;
                TiebaStatic.net(this.aey);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aey.vE().vR = hVar.responseCode;
        if (this.aey.vE().vR != 200) {
            this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
            if (this.aey.vF().agF != null && !TextUtils.isEmpty(this.aey.vF().agF.vA)) {
                this.aey.vE().agE = this.aey.vF().agF.vA;
            } else {
                this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx);
            }
            TiebaStatic.net(this.aey);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aeD) {
                    this.aey.vE().vR = -11;
                    TiebaStatic.net(this.aey);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.DN().eP(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aey.vD().vG().mUrl + "], size:" + i2);
                            this.aey.vE().vR = -16;
                            TiebaStatic.net(this.aey);
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
        aVar.aeT = this.aey.vF().agF.vv;
        aVar.mTime = new Date().getTime() - j;
        aVar.aeU = this.aey.vF().agF.vx;
        aVar.aeS = 2;
        ad.a(aVar);
        ad.aeR.set(this.aey.vF().agF.vx);
        TiebaStatic.net(this.aey);
        bArr = hVar == null ? hVar.vT : null;
        return bArr;
    }

    public void dq(String str) {
        this.aey.vE().agD = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aey.vE().agD = errorData.getError_code();
                if (this.aey.vE().agD == -1) {
                    this.aey.vE().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
                } else if (this.aey.vE().agD != 0) {
                    this.aey.vE().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aey.vE().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String un() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] um = um();
        if (um == null || this.aey.vE().vR != 200) {
            return null;
        }
        try {
            this.aey.vD().vG().ahd = TextUtils.isEmpty(this.aey.vD().vG().ahd) ? "UTF-8" : this.aey.vD().vG().ahd;
            str = new String(um, 0, um.length, this.aey.vD().vG().ahd);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dq(str);
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
    public String ul() {
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
            if (this.aey.vD().vG().agZ == null || i2 >= this.aey.vD().vG().agZ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aey.vD().vG().agZ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aey.vD().vG().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aI(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aeE.isCanceled()) {
                return null;
            }
            if (this.aeE.a(this.aey.vD().vG().mUrl, this.aey.vD().vG().agZ, this.aey.vD().vG().ahb, 5, -1, uR()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f fJ = this.aeE.fJ();
            if (fJ == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fC = fJ.fC();
            if (fJ != null && fJ.fD() != null && (size = fJ.fD().size()) > 0) {
                this.aey.vF().agF = fJ.fD().get(size - 1);
            }
            this.aey.vE().vR = fC.responseCode;
            this.aey.vE().mHeader = fC.vS;
            if (this.aey.vE().vR != 200) {
                if (this.aey.vF().agF != null && !TextUtils.isEmpty(this.aey.vF().agF.vA)) {
                    this.aey.vE().agE = this.aey.vF().agF.vA;
                } else {
                    this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx);
                }
                TiebaStatic.net(this.aey);
                return null;
            } else if (this.aeE.isCanceled()) {
                return null;
            } else {
                str = new String(fC.vT, "utf-8");
                try {
                    if (this.aey.vD().vG().mIsBaiduServer && this.aey.vD().vG().ahc) {
                        dq(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hq());
                    aVar.aeT = this.aey.vF().agF.vv;
                    aVar.mTime = this.aey.vF().agF.vy;
                    aVar.aeU = this.aey.vF().agF.vx;
                    aVar.aeS = 1;
                    ad.a(aVar);
                    ad.aeR.set(this.aey.vF().agF.vx);
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aey.vE().vR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.aey.vE().vR = -12;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.aey.vE().vR = -13;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.aey.vE().vR = -10;
                    this.aey.vE().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.aey.vE().vR = -15;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aey.vE().vR = -10;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aey);
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
    public String uo() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aeE.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aeE.a(this.aey.vD().vG().mUrl, this.aey.vD().vG().ahb, this.aey.vD().vG().agZ, this.aey.vD().vG().aha, 5, -1, uR());
            this.aey.vE().vR = a.responseCode;
            this.aey.vE().mHeader = a.vS;
            if (this.aey.vE().vR != 200) {
                com.baidu.adp.lib.network.http.f fJ = this.aeE.fJ();
                int i = 0;
                if (fJ != null && fJ.fD() != null) {
                    i = fJ.fD().size();
                }
                if (i <= 0 || (eVar = fJ.fD().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vA;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aey.vE().agE = str3;
                } else {
                    this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx);
                }
                TiebaStatic.net(this.aey);
                return null;
            } else if (this.aeE.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vT, "UTF-8");
                try {
                    dq(str);
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aey.vE().agE = String.valueOf(String.valueOf(this.aey.vE().vR)) + "|retryCount:" + (this.aey.vF().agF == null ? -1 : this.aey.vF().agF.vx) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aey.vE().vR = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aey.vE().vR = -13;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aey.vE().vR = -10;
                    this.aey.vE().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aey.vE().vR = -15;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aey);
                    return str;
                } catch (SocketException e7) {
                    this.aey.vE().vR = -12;
                    this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aey);
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
            if (!this.aeE.isCanceled()) {
                return this.aeE.a(this.aey.vD().vG().mUrl, (z ? new File(str) : l.da(str)).getAbsolutePath(), false, i2, i3, -1, -1, uR(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.aey);
            return false;
        } catch (Exception e) {
            this.aey.vE().vR = -10;
            this.aey.vE().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aey.vE().vR = -15;
            this.aey.vE().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aey);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> uk() {
        return this.aey.vD().vG().agZ;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aey.vD().vG().agZ != null) {
            this.aey.vD().vG().agZ.clear();
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
        if (this.aey.vD().vG().aha == null) {
            this.aey.vD().vG().aha = new HashMap<>();
        }
        this.aey.vD().vG().aha.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aey.vD().vG().agZ == null) {
                this.aey.vD().vG().agZ = new ArrayList<>();
            }
            int c = c(this.aey.vD().vG().agZ, basicNameValuePair.getName());
            int size = this.aey.vD().vG().agZ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aey.vD().vG().agZ.get(c).getName())) {
                    this.aey.vD().vG().agZ.set(c, basicNameValuePair);
                } else {
                    this.aey.vD().vG().agZ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aey.vD().vG().agZ.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uR() {
        if (this.aey != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aey.vD().vG().ahe)) {
                linkedList.add(new BasicNameValuePair("sid", this.aey.vD().vG().ahe));
            }
            if (!TextUtils.isEmpty(this.aey.vD().vG().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aey.vD().vG().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
