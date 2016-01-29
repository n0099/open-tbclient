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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.t;
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
public class ab implements t {
    private static int abO = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a abJ;
    private com.baidu.adp.lib.network.a.a abP = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.a.a aVar) {
        vA();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.abJ = aVar;
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

    private void vA() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void gW() {
        if (this.abP != null) {
            this.abP.gW();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void gT() {
        this.abP.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] va() {
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
            if (this.abJ.wv().wy().ael != null && this.abJ.wv().wy().ael.size() > 0 && !this.abJ.wv().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.abJ.wv().wy().mUrl);
                if (this.abJ.wv().wy().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.abJ.wv().wy().mUrl.endsWith("?") && !this.abJ.wv().wy().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.abJ.wv().wy().ael.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.abJ.wv().wy().ael.get(i).getName());
                    sb.append("=");
                    sb.append(aw.aS(this.abJ.wv().wy().ael.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.abJ.wv().wy().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.abJ.wv().wy().aen || this.abJ.wv().wy().mIsBDImage) && !this.abJ.wv().mIsFromCDN) {
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
        if (this.abP.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.abP.a(str, z, 5, 100, -1, -1, vJ());
        com.baidu.adp.lib.network.http.e hi = this.abP.hi();
        if (hi == null) {
            return null;
        }
        gVar = hi.hb();
        if (hi != null) {
            try {
                if (hi.hc() != null && (size = hi.hc().size()) > 0) {
                    this.abJ.wx().adR = hi.hc().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.abJ.ww().vv = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR != null ? this.abJ.wx().adR.vf : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abJ.ww().vv = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.abJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR != null ? this.abJ.wx().adR.vf : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abJ.ww().vv = -12;
                TiebaStatic.net(this.abJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR != null ? this.abJ.wx().adR.vf : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abJ.ww().vv = -13;
                TiebaStatic.net(this.abJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.abJ.ww().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR != null ? this.abJ.wx().adR.vf : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abJ.ww().vv = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.abJ);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.abJ.ww().vv = gVar.responseCode;
        if (this.abJ.ww().vv != 200) {
            this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
            if (this.abJ.wx().adR != null && !TextUtils.isEmpty(this.abJ.wx().adR.vi)) {
                this.abJ.ww().adQ = this.abJ.wx().adR.vi;
            } else {
                this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf);
            }
            TiebaStatic.net(this.abJ);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > abO) {
                    this.abJ.ww().vv = -11;
                    TiebaStatic.net(this.abJ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Ed().eN(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.abJ.wv().wy().mUrl + "], size:" + i2);
                            this.abJ.ww().vv = -16;
                            TiebaStatic.net(this.abJ);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ae.a aVar = new ae.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.jf());
        aVar.ace = this.abJ.wx().adR.vc;
        aVar.mTime = new Date().getTime() - j;
        aVar.acf = this.abJ.wx().adR.vf;
        aVar.acd = 2;
        ae.a(aVar);
        ae.acc.set(this.abJ.wx().adR.vf);
        TiebaStatic.net(this.abJ);
        bArr = gVar == null ? gVar.vx : null;
        return bArr;
    }

    public void dp(String str) {
        this.abJ.ww().adP = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.abJ.ww().adP = errorData.getError_code();
                if (this.abJ.ww().adP == -1) {
                    this.abJ.ww().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
                } else if (this.abJ.ww().adP != 0) {
                    this.abJ.ww().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.abJ.ww().mErrorString = this.mContext.getString(t.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String vb() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] va = va();
        if (va == null || this.abJ.ww().vv != 200) {
            return null;
        }
        try {
            this.abJ.wv().wy().aep = TextUtils.isEmpty(this.abJ.wv().wy().aep) ? "UTF-8" : this.abJ.wv().wy().aep;
            str = new String(va, 0, va.length, this.abJ.wv().wy().aep);
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
    public String uZ() {
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
            if (this.abJ.wv().wy().ael == null || i2 >= this.abJ.wv().wy().ael.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.abJ.wv().wy().ael.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.abJ.wv().wy().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            p(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.abP.isCanceled()) {
                return null;
            }
            if (this.abP.a(this.abJ.wv().wy().mUrl, this.abJ.wv().wy().ael, this.abJ.wv().wy().aen, 5, -1, vJ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e hi = this.abP.hi();
            if (hi == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g hb = hi.hb();
            if (hi != null && hi.hc() != null && (size = hi.hc().size()) > 0) {
                this.abJ.wx().adR = hi.hc().get(size - 1);
            }
            this.abJ.ww().vv = hb.responseCode;
            this.abJ.ww().mHeader = hb.vw;
            if (this.abJ.ww().vv != 200) {
                if (this.abJ.wx().adR != null && !TextUtils.isEmpty(this.abJ.wx().adR.vi)) {
                    this.abJ.ww().adQ = this.abJ.wx().adR.vi;
                } else {
                    this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf);
                }
                TiebaStatic.net(this.abJ);
                return null;
            } else if (this.abP.isCanceled()) {
                return null;
            } else {
                str = new String(hb.vx, "utf-8");
                try {
                    if (this.abJ.wv().wy().mIsBaiduServer && this.abJ.wv().wy().aeo) {
                        dp(str);
                    }
                    ae.a aVar = new ae.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.jf());
                    aVar.ace = this.abJ.wx().adR.vc;
                    aVar.mTime = this.abJ.wx().adR.vg;
                    aVar.acf = this.abJ.wx().adR.vf;
                    aVar.acd = 1;
                    ae.a(aVar);
                    ae.acc.set(this.abJ.wx().adR.vf);
                    TiebaStatic.net(this.abJ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.abJ.ww().vv = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.abJ.ww().vv = -15;
                    this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.abJ);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.abJ.ww().vv = -12;
                    this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.abJ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.abJ.ww().vv = -13;
                    this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.abJ);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.abJ.ww().vv = -10;
                    this.abJ.ww().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.abJ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.abJ.ww().vv = -10;
                    this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.abJ);
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

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                ab.this.gT();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [642=8] */
    @Override // com.baidu.tbadk.core.util.t
    public String vc() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.abP.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.abP.a(this.abJ.wv().wy().mUrl, this.abJ.wv().wy().aen, this.abJ.wv().wy().ael, this.abJ.wv().wy().aem, 5, -1, vJ());
                this.abJ.ww().vv = a2.responseCode;
                this.abJ.ww().mHeader = a2.vw;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.abJ.ww().vv != 200) {
                    com.baidu.adp.lib.network.http.e hi = this.abP.hi();
                    int i = 0;
                    if (hi != null && hi.hc() != null) {
                        i = hi.hc().size();
                    }
                    String str2 = (i <= 0 || (dVar = hi.hc().get(i + (-1))) == null) ? "" : dVar.vi;
                    if (TextUtils.isEmpty(str2)) {
                        this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf);
                    } else {
                        this.abJ.ww().adQ = str2;
                    }
                    TiebaStatic.net(this.abJ);
                    return null;
                } else if (this.abP.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vx, "UTF-8");
                    try {
                        dp(str);
                        TiebaStatic.net(this.abJ);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                        this.abJ.ww().adQ = String.valueOf(String.valueOf(this.abJ.ww().vv)) + "|retryCount:" + (this.abJ.wx().adR == null ? -1 : this.abJ.wx().adR.vf) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.abJ.ww().vv = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.abJ.ww().vv = -15;
                        this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.abJ);
                        return str;
                    } catch (SocketException e6) {
                        this.abJ.ww().vv = -12;
                        this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                        TiebaStatic.net(this.abJ);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.abJ.ww().vv = -13;
                        this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.neterror);
                        TiebaStatic.net(this.abJ);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.abJ.ww().vv = -10;
                        this.abJ.ww().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.abJ);
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
    @Override // com.baidu.tbadk.core.util.t
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.abP.isCanceled()) {
                return this.abP.a(this.abJ.wv().wy().mUrl, (z ? new File(str) : m.cW(str)).getAbsolutePath(), false, i2, i3, -1, -1, vJ(), new ac(this, handler, i), true);
            }
            TiebaStatic.net(this.abJ);
            return false;
        } catch (Exception e) {
            this.abJ.ww().vv = -10;
            this.abJ.ww().mErrorString = String.valueOf(this.mContext.getResources().getString(t.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.abJ.ww().vv = -15;
            this.abJ.ww().mErrorString = this.mContext.getResources().getString(t.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.abJ);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> uY() {
        return this.abJ.wv().wy().ael;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void n(ArrayList<BasicNameValuePair> arrayList) {
        if (this.abJ.wv().wy().ael != null) {
            this.abJ.wv().wy().ael.clear();
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
    public void p(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void d(String str, byte[] bArr) {
        if (this.abJ.wv().wy().aem == null) {
            this.abJ.wv().wy().aem = new HashMap<>();
        }
        this.abJ.wv().wy().aem.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.abJ.wv().wy().ael == null) {
                this.abJ.wv().wy().ael = new ArrayList<>();
            }
            int c = c(this.abJ.wv().wy().ael, basicNameValuePair.getName());
            int size = this.abJ.wv().wy().ael.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.abJ.wv().wy().ael.get(c).getName())) {
                    this.abJ.wv().wy().ael.set(c, basicNameValuePair);
                } else {
                    this.abJ.wv().wy().ael.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.abJ.wv().wy().ael.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vJ() {
        if (this.abJ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.abJ.wv().wy().aeq)) {
                linkedList.add(new BasicNameValuePair("sid", this.abJ.wv().wy().aeq));
            }
            if (!TextUtils.isEmpty(this.abJ.wv().wy().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.abJ.wv().wy().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
