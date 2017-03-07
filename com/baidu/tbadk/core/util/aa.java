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
    private static int aeW = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aeR;
    private com.baidu.adp.lib.network.a.a aeX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public aa(com.baidu.tbadk.core.util.a.a aVar) {
        uY();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.aeR = aVar;
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

    private void uY() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fp() {
        if (this.aeX != null) {
            this.aeX.fp();
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public void fm() {
        this.aeX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uC() {
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
            if (this.aeR.vS().vV().ahs != null && this.aeR.vS().vV().ahs.size() > 0 && !this.aeR.vS().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aeR.vS().vV().mUrl);
                if (this.aeR.vS().vV().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aeR.vS().vV().mUrl.endsWith("?") && !this.aeR.vS().vV().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aeR.vS().vV().ahs.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aeR.vS().vV().ahs.get(i).getName());
                    sb.append("=");
                    sb.append(au.aI(this.aeR.vS().vV().ahs.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aeR.vS().vV().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aeR.vS().vV().ahu || this.aeR.vS().vV().mIsBDImage) && !this.aeR.vS().mIsFromCDN) {
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
        if (this.aeX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aeX.a(str, z, 5, 100, -1, -1, vh());
        com.baidu.adp.lib.network.http.f fD = this.aeX.fD();
        if (fD == null) {
            return null;
        }
        hVar = fD.fw();
        if (fD != null) {
            try {
                if (fD.fx() != null && (size = fD.fx().size()) > 0) {
                    this.aeR.vU().agY = fD.fx().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aeR.vT().wj = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY != null ? this.aeR.vU().agY.vP : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeR.vT().wj = -13;
                TiebaStatic.net(this.aeR);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.aeR.vT().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY != null ? this.aeR.vU().agY.vP : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeR.vT().wj = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aeR);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY != null ? this.aeR.vU().agY.vP : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeR.vT().wj = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aeR);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY != null ? this.aeR.vU().agY.vP : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aeR.vT().wj = -12;
                TiebaStatic.net(this.aeR);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.aeR.vT().wj = hVar.responseCode;
        if (this.aeR.vT().wj != 200) {
            this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
            if (this.aeR.vU().agY != null && !TextUtils.isEmpty(this.aeR.vU().agY.vS)) {
                this.aeR.vT().agX = this.aeR.vU().agY.vS;
            } else {
                this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP);
            }
            TiebaStatic.net(this.aeR);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aeW) {
                    this.aeR.vT().wj = -11;
                    TiebaStatic.net(this.aeR);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.El().eQ(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aeR.vS().vV().mUrl + "], size:" + i2);
                            this.aeR.vT().wj = -16;
                            TiebaStatic.net(this.aeR);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hk());
        aVar.afm = this.aeR.vU().agY.vM;
        aVar.mTime = new Date().getTime() - j;
        aVar.afn = this.aeR.vU().agY.vP;
        aVar.afl = 2;
        ad.a(aVar);
        ad.afk.set(this.aeR.vU().agY.vP);
        TiebaStatic.net(this.aeR);
        bArr = hVar == null ? hVar.wl : null;
        return bArr;
    }

    public void dl(String str) {
        this.aeR.vT().agW = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aeR.vT().agW = errorData.getError_code();
                if (this.aeR.vT().agW == -1) {
                    this.aeR.vT().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
                } else if (this.aeR.vT().agW != 0) {
                    this.aeR.vT().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aeR.vT().mErrorString = this.mContext.getString(w.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String uD() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uC = uC();
        if (uC == null || this.aeR.vT().wj != 200) {
            return null;
        }
        try {
            this.aeR.vS().vV().ahw = TextUtils.isEmpty(this.aeR.vS().vV().ahw) ? "UTF-8" : this.aeR.vS().vV().ahw;
            str = new String(uC, 0, uC.length, this.aeR.vS().vV().ahw);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dl(str);
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
    public String uB() {
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
            if (this.aeR.vS().vV().ahs == null || i2 >= this.aeR.vS().vV().ahs.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aeR.vS().vV().ahs.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aeR.vS().vV().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aN(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aeX.isCanceled()) {
                return null;
            }
            if (this.aeX.a(this.aeR.vS().vV().mUrl, this.aeR.vS().vV().ahs, this.aeR.vS().vV().ahu, 5, -1, vh()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f fD = this.aeX.fD();
            if (fD == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h fw = fD.fw();
            if (fD != null && fD.fx() != null && (size = fD.fx().size()) > 0) {
                this.aeR.vU().agY = fD.fx().get(size - 1);
            }
            this.aeR.vT().wj = fw.responseCode;
            this.aeR.vT().mHeader = fw.wk;
            if (this.aeR.vT().wj != 200) {
                if (this.aeR.vU().agY != null && !TextUtils.isEmpty(this.aeR.vU().agY.vS)) {
                    this.aeR.vT().agX = this.aeR.vU().agY.vS;
                } else {
                    this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP);
                }
                TiebaStatic.net(this.aeR);
                return null;
            } else if (this.aeX.isCanceled()) {
                return null;
            } else {
                str = new String(fw.wl, "utf-8");
                try {
                    if (this.aeR.vS().vV().mIsBaiduServer && this.aeR.vS().vV().ahv) {
                        dl(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hk());
                    aVar.afm = this.aeR.vU().agY.vM;
                    aVar.mTime = this.aeR.vU().agY.vQ;
                    aVar.afn = this.aeR.vU().agY.vP;
                    aVar.afl = 1;
                    ad.a(aVar);
                    ad.afk.set(this.aeR.vU().agY.vP);
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aeR.vT().wj = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e3 = e6;
                    this.aeR.vT().wj = -15;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (SocketException e7) {
                    e2 = e7;
                    this.aeR.vT().wj = -12;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    this.aeR.vT().wj = -13;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (Exception e9) {
                    e4 = e9;
                    this.aeR.vT().wj = -10;
                    this.aeR.vT().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aeR.vT().wj = -10;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aeR);
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
    public String uE() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.aeX.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.aeX.a(this.aeR.vS().vV().mUrl, this.aeR.vS().vV().ahu, this.aeR.vS().vV().ahs, this.aeR.vS().vV().aht, 5, -1, vh());
            this.aeR.vT().wj = a.responseCode;
            this.aeR.vT().mHeader = a.wk;
            if (this.aeR.vT().wj != 200) {
                com.baidu.adp.lib.network.http.f fD = this.aeX.fD();
                int i = 0;
                if (fD != null && fD.fx() != null) {
                    i = fD.fx().size();
                }
                if (i <= 0 || (eVar = fD.fx().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.vS;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.aeR.vT().agX = str3;
                } else {
                    this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP);
                }
                TiebaStatic.net(this.aeR);
                return null;
            } else if (this.aeX.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.wl, "UTF-8");
                try {
                    dl(str);
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    this.aeR.vT().agX = String.valueOf(String.valueOf(this.aeR.vT().wj)) + "|retryCount:" + (this.aeR.vU().agY == null ? -1 : this.aeR.vU().agY.vP) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aeR.vT().wj = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.aeR.vT().wj = -13;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.aeR.vT().wj = -10;
                    this.aeR.vT().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.aeR.vT().wj = -15;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aeR);
                    return str;
                } catch (SocketException e7) {
                    this.aeR.vT().wj = -12;
                    this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.neterror);
                    TiebaStatic.net(this.aeR);
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
            if (!this.aeX.isCanceled()) {
                return this.aeX.a(this.aeR.vS().vV().mUrl, (z ? new File(str) : l.cV(str)).getAbsolutePath(), false, i2, i3, -1, -1, vh(), new ab(this, handler, i), true);
            }
            TiebaStatic.net(this.aeR);
            return false;
        } catch (Exception e) {
            this.aeR.vT().wj = -10;
            this.aeR.vT().mErrorString = String.valueOf(this.mContext.getResources().getString(w.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aeR.vT().wj = -15;
            this.aeR.vT().mErrorString = this.mContext.getResources().getString(w.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aeR);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> uA() {
        return this.aeR.vS().vV().ahs;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aeR.vS().vV().ahs != null) {
            this.aeR.vS().vV().ahs.clear();
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
        if (this.aeR.vS().vV().aht == null) {
            this.aeR.vS().vV().aht = new HashMap<>();
        }
        this.aeR.vS().vV().aht.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aeR.vS().vV().ahs == null) {
                this.aeR.vS().vV().ahs = new ArrayList<>();
            }
            int c = c(this.aeR.vS().vV().ahs, basicNameValuePair.getName());
            int size = this.aeR.vS().vV().ahs.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aeR.vS().vV().ahs.get(c).getName())) {
                    this.aeR.vS().vV().ahs.set(c, basicNameValuePair);
                } else {
                    this.aeR.vS().vV().ahs.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aeR.vS().vV().ahs.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vh() {
        if (this.aeR != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aeR.vS().vV().ahx)) {
                linkedList.add(new BasicNameValuePair("sid", this.aeR.vS().vV().ahx));
            }
            if (!TextUtils.isEmpty(this.aeR.vS().vV().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aeR.vS().vV().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
