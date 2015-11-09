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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.i;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x implements q {
    private static int aac = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a ZX;
    private com.baidu.adp.lib.network.a.a aad = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public x(com.baidu.tbadk.core.util.a.a aVar) {
        ug();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.ZX = aVar;
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

    private void ug() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void gM() {
        if (this.aad != null) {
            this.aad.gM();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void gJ() {
        this.aad.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tH() {
        com.baidu.adp.lib.network.http.g gVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.adp.lib.network.http.g gVar2;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.ZX.uZ().vc().aco != null && this.ZX.uZ().vc().aco.size() > 0 && !this.ZX.uZ().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZX.uZ().vc().mUrl);
                if (this.ZX.uZ().vc().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZX.uZ().vc().mUrl.endsWith("?") && !this.ZX.uZ().vc().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZX.uZ().vc().aco.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZX.uZ().vc().aco.get(i).getName());
                    sb.append("=");
                    sb.append(as.aP(this.ZX.uZ().vc().aco.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZX.uZ().vc().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZX.uZ().vc().acq || this.ZX.uZ().vc().mIsBDImage) && !this.ZX.uZ().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            gVar = null;
        } catch (SocketException e3) {
            e = e3;
            gVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            gVar = null;
        } catch (Exception e5) {
            e = e5;
            gVar = null;
        }
        if (this.aad.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aad.a(str, z, 5, 100, -1, -1, uo());
        com.baidu.adp.lib.network.http.e gY = this.aad.gY();
        if (gY == null) {
            return null;
        }
        gVar = gY.gR();
        if (gY != null) {
            try {
                if (gY.gS() != null && (size = gY.gS().size()) > 0) {
                    this.ZX.vb().abZ = gY.gS().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZX.va().abW = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ != null ? this.ZX.vb().abZ.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abW = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ != null ? this.ZX.vb().abZ.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abW = -12;
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ != null ? this.ZX.vb().abZ.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abW = -13;
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.ZX.va().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ != null ? this.ZX.vb().abZ.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abW = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ZX.va().abW = gVar.responseCode;
        if (this.ZX.va().abW != 200) {
            this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
            if (this.ZX.vb().abZ != null && !TextUtils.isEmpty(this.ZX.vb().abZ.uR)) {
                this.ZX.va().abY = this.ZX.vb().abZ.uR;
            } else {
                this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO);
            }
            TiebaStatic.net(this.ZX);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aac) {
                    this.ZX.va().abW = -11;
                    TiebaStatic.net(this.ZX);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.BV().el(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZX.uZ().vc().mUrl + "], size:" + i2);
                            this.ZX.va().abW = -16;
                            TiebaStatic.net(this.ZX);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iT());
        aVar.mSize = this.ZX.vb().abZ.uL;
        aVar.mTime = new Date().getTime() - j;
        aVar.aas = this.ZX.vb().abZ.uO;
        aVar.aar = 2;
        aa.a(aVar);
        aa.aaq.set(this.ZX.vb().abZ.uO);
        TiebaStatic.net(this.ZX);
        bArr = gVar == null ? gVar.vf : null;
        return bArr;
    }

    public void df(String str) {
        this.ZX.va().abX = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZX.va().abX = errorData.getError_code();
                if (this.ZX.va().abX == -1) {
                    this.ZX.va().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
                } else if (this.ZX.va().abX != 0) {
                    this.ZX.va().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZX.va().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tI() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tH = tH();
        if (tH == null || this.ZX.va().abW != 200) {
            return null;
        }
        try {
            this.ZX.uZ().vc().acs = TextUtils.isEmpty(this.ZX.uZ().vc().acs) ? "UTF-8" : this.ZX.uZ().vc().acs;
            str = new String(tH, 0, tH.length, this.ZX.uZ().vc().acs);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            df(str);
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

    @Override // com.baidu.tbadk.core.util.q
    public String tG() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.ZX.uZ().vc().aco == null || i2 >= this.ZX.uZ().vc().aco.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZX.uZ().vc().aco.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZX.uZ().vc().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aad.isCanceled()) {
                return null;
            }
            if (this.aad.a(this.ZX.uZ().vc().mUrl, this.ZX.uZ().vc().aco, this.ZX.uZ().vc().acq, 5, -1, uo()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gY = this.aad.gY();
            if (gY == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gR = gY.gR();
            if (gY != null && gY.gS() != null && (size = gY.gS().size()) > 0) {
                this.ZX.vb().abZ = gY.gS().get(size - 1);
            }
            this.ZX.va().abW = gR.responseCode;
            this.ZX.va().mHeader = gR.ve;
            if (this.ZX.va().abW != 200) {
                if (this.ZX.vb().abZ != null && !TextUtils.isEmpty(this.ZX.vb().abZ.uR)) {
                    this.ZX.va().abY = this.ZX.vb().abZ.uR;
                } else {
                    this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO);
                }
                TiebaStatic.net(this.ZX);
                return null;
            } else if (this.aad.isCanceled()) {
                return null;
            } else {
                str = new String(gR.vf, "utf-8");
                try {
                    if (this.ZX.uZ().vc().mIsBaiduServer && this.ZX.uZ().vc().acr) {
                        df(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iT());
                    aVar.mSize = this.ZX.vb().abZ.uL;
                    aVar.mTime = this.ZX.vb().abZ.uP;
                    aVar.aas = this.ZX.vb().abZ.uO;
                    aVar.aar = 1;
                    aa.a(aVar);
                    aa.aaq.set(this.ZX.vb().abZ.uO);
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZX.va().abW = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.ZX.va().abW = -15;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.ZX.va().abW = -12;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.ZX.va().abW = -13;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.ZX.va().abW = -10;
                    this.ZX.va().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZX.va().abW = -10;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (SocketException e11) {
            e4 = e11;
            str = null;
        } catch (SocketTimeoutException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                x.this.gJ();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [642=8] */
    @Override // com.baidu.tbadk.core.util.q
    public String tJ() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.aad.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.aad.a(this.ZX.uZ().vc().mUrl, this.ZX.uZ().vc().acq, this.ZX.uZ().vc().aco, this.ZX.uZ().vc().acp, 5, -1, uo());
                this.ZX.va().abW = a2.responseCode;
                this.ZX.va().mHeader = a2.ve;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.ZX.va().abW != 200) {
                    com.baidu.adp.lib.network.http.e gY = this.aad.gY();
                    int i = 0;
                    if (gY != null && gY.gS() != null) {
                        i = gY.gS().size();
                    }
                    String str2 = (i <= 0 || (dVar = gY.gS().get(i + (-1))) == null) ? "" : dVar.uR;
                    if (TextUtils.isEmpty(str2)) {
                        this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO);
                    } else {
                        this.ZX.va().abY = str2;
                    }
                    TiebaStatic.net(this.ZX);
                    return null;
                } else if (this.aad.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vf, "UTF-8");
                    try {
                        df(str);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        this.ZX.va().abY = String.valueOf(String.valueOf(this.ZX.va().abW)) + "|retryCount:" + (this.ZX.vb().abZ == null ? -1 : this.ZX.vb().abZ.uO) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ZX.va().abW = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.ZX.va().abW = -15;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (SocketException e6) {
                        this.ZX.va().abW = -12;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.ZX.va().abW = -13;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.ZX.va().abW = -10;
                        this.ZX.va().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ZX);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new a(this, null), 0L);
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (SocketException e10) {
            str = null;
        } catch (SocketTimeoutException e11) {
            str = null;
        } catch (Exception e12) {
            e2 = e12;
            str = null;
        } catch (OutOfMemoryError e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [702=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.aad.isCanceled()) {
                return this.aad.a(this.ZX.uZ().vc().mUrl, (z ? new File(str) : n.cO(str)).getAbsolutePath(), false, i2, i3, -1, -1, uo(), new y(this, handler, i), true);
            }
            TiebaStatic.net(this.ZX);
            return false;
        } catch (Exception e) {
            this.ZX.va().abW = -10;
            this.ZX.va().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZX.va().abW = -15;
            this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZX);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> tF() {
        return this.ZX.uZ().vc().aco;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZX.uZ().vc().aco != null) {
            this.ZX.uZ().vc().aco.clear();
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

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.ZX.uZ().vc().acp == null) {
            this.ZX.uZ().vc().acp = new HashMap<>();
        }
        this.ZX.uZ().vc().acp.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZX.uZ().vc().aco == null) {
                this.ZX.uZ().vc().aco = new ArrayList<>();
            }
            int b = b(this.ZX.uZ().vc().aco, basicNameValuePair.getName());
            int size = this.ZX.uZ().vc().aco.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.ZX.uZ().vc().aco.get(b).getName())) {
                    this.ZX.uZ().vc().aco.set(b, basicNameValuePair);
                } else {
                    this.ZX.uZ().vc().aco.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.ZX.uZ().vc().aco.add(b, basicNameValuePair);
            }
        }
    }

    private int b(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    private LinkedList<BasicNameValuePair> uo() {
        if (this.ZX != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZX.uZ().vc().acu)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZX.uZ().vc().acu));
            }
            if (!TextUtils.isEmpty(this.ZX.uZ().vc().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZX.uZ().vc().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
