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
import com.baidu.tieba.n;
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
public class ac implements u {
    private static int aaO = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a aaJ;
    private com.baidu.adp.lib.network.a.a aaP = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        uL();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.aaJ = aVar;
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

    private void uL() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void gO() {
        if (this.aaP != null) {
            this.aaP.gO();
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public void gL() {
        this.aaP.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] um() {
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
            if (this.aaJ.vF().vI().adh != null && this.aaJ.vF().vI().adh.size() > 0 && !this.aaJ.vF().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aaJ.vF().vI().mUrl);
                if (this.aaJ.vF().vI().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aaJ.vF().vI().mUrl.endsWith("?") && !this.aaJ.vF().vI().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aaJ.vF().vI().adh.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aaJ.vF().vI().adh.get(i).getName());
                    sb.append("=");
                    sb.append(ax.aT(this.aaJ.vF().vI().adh.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aaJ.vF().vI().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.aaJ.vF().vI().adj || this.aaJ.vF().vI().mIsBDImage) && !this.aaJ.vF().mIsFromCDN) {
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
        if (this.aaP.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aaP.a(str, z, 5, 100, -1, -1, uU());
        com.baidu.adp.lib.network.http.e ha = this.aaP.ha();
        if (ha == null) {
            return null;
        }
        gVar = ha.gT();
        if (ha != null) {
            try {
                if (ha.gU() != null && (size = ha.gU().size()) > 0) {
                    this.aaJ.vH().acR = ha.gU().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aaJ.vG().acO = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.memoryerror);
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR != null ? this.aaJ.vH().acR.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaJ.vG().acO = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR != null ? this.aaJ.vH().acR.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaJ.vG().acO = -12;
                TiebaStatic.net(this.aaJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR != null ? this.aaJ.vH().acR.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaJ.vG().acO = -13;
                TiebaStatic.net(this.aaJ);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aaJ.vG().mErrorString = String.valueOf(this.mContext.getResources().getString(n.i.neterror)) + " detailException:" + e.getMessage();
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR != null ? this.aaJ.vH().acR.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aaJ.vG().acO = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aaJ);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aaJ.vG().acO = gVar.responseCode;
        if (this.aaJ.vG().acO != 200) {
            this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
            if (this.aaJ.vH().acR != null && !TextUtils.isEmpty(this.aaJ.vH().acR.uX)) {
                this.aaJ.vG().acQ = this.aaJ.vH().acR.uX;
            } else {
                this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU);
            }
            TiebaStatic.net(this.aaJ);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aaO) {
                    this.aaJ.vG().acO = -11;
                    TiebaStatic.net(this.aaJ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.CX().ez(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aaJ.vF().vI().mUrl + "], size:" + i2);
                            this.aaJ.vG().acO = -16;
                            TiebaStatic.net(this.aaJ);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iV());
        aVar.mSize = this.aaJ.vH().acR.uR;
        aVar.mTime = new Date().getTime() - j;
        aVar.abe = this.aaJ.vH().acR.uU;
        aVar.abd = 2;
        af.a(aVar);
        af.abc.set(this.aaJ.vH().acR.uU);
        TiebaStatic.net(this.aaJ);
        bArr = gVar == null ? gVar.vl : null;
        return bArr;
    }

    public void dp(String str) {
        this.aaJ.vG().acP = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aaJ.vG().acP = errorData.getError_code();
                if (this.aaJ.vG().acP == -1) {
                    this.aaJ.vG().mErrorString = this.mContext.getString(n.i.error_unkown_try_again);
                } else if (this.aaJ.vG().acP != 0) {
                    this.aaJ.vG().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aaJ.vG().mErrorString = this.mContext.getString(n.i.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public String un() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] um = um();
        if (um == null || this.aaJ.vG().acO != 200) {
            return null;
        }
        try {
            this.aaJ.vF().vI().adl = TextUtils.isEmpty(this.aaJ.vF().vI().adl) ? "UTF-8" : this.aaJ.vF().vI().adl;
            str = new String(um, 0, um.length, this.aaJ.vF().vI().adl);
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

    @Override // com.baidu.tbadk.core.util.u
    public String ul() {
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
            if (this.aaJ.vF().vI().adh == null || i2 >= this.aaJ.vF().vI().adh.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aaJ.vF().vI().adh.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aaJ.vF().vI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aaP.isCanceled()) {
                return null;
            }
            if (this.aaP.a(this.aaJ.vF().vI().mUrl, this.aaJ.vF().vI().adh, this.aaJ.vF().vI().adj, 5, -1, uU()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e ha = this.aaP.ha();
            if (ha == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gT = ha.gT();
            if (ha != null && ha.gU() != null && (size = ha.gU().size()) > 0) {
                this.aaJ.vH().acR = ha.gU().get(size - 1);
            }
            this.aaJ.vG().acO = gT.responseCode;
            this.aaJ.vG().mHeader = gT.vk;
            if (this.aaJ.vG().acO != 200) {
                if (this.aaJ.vH().acR != null && !TextUtils.isEmpty(this.aaJ.vH().acR.uX)) {
                    this.aaJ.vG().acQ = this.aaJ.vH().acR.uX;
                } else {
                    this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU);
                }
                TiebaStatic.net(this.aaJ);
                return null;
            } else if (this.aaP.isCanceled()) {
                return null;
            } else {
                str = new String(gT.vl, "utf-8");
                try {
                    if (this.aaJ.vF().vI().mIsBaiduServer && this.aaJ.vF().vI().adk) {
                        dp(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iV());
                    aVar.mSize = this.aaJ.vH().acR.uR;
                    aVar.mTime = this.aaJ.vH().acR.uV;
                    aVar.abe = this.aaJ.vH().acR.uU;
                    aVar.abd = 1;
                    af.a(aVar);
                    af.abc.set(this.aaJ.vH().acR.uU);
                    TiebaStatic.net(this.aaJ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                    this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aaJ.vG().acO = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.aaJ.vG().acO = -15;
                    this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aaJ);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.aaJ.vG().acO = -12;
                    this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aaJ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.aaJ.vG().acO = -13;
                    this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aaJ);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.aaJ.vG().acO = -10;
                    this.aaJ.vG().mErrorString = String.valueOf(this.mContext.getResources().getString(n.i.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aaJ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aaJ.vG().acO = -10;
                    this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aaJ);
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

        /* synthetic */ a(ac acVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                ac.this.gL();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [642=8] */
    @Override // com.baidu.tbadk.core.util.u
    public String uo() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.aaP.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.aaP.a(this.aaJ.vF().vI().mUrl, this.aaJ.vF().vI().adj, this.aaJ.vF().vI().adh, this.aaJ.vF().vI().adi, 5, -1, uU());
                this.aaJ.vG().acO = a2.responseCode;
                this.aaJ.vG().mHeader = a2.vk;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.aaJ.vG().acO != 200) {
                    com.baidu.adp.lib.network.http.e ha = this.aaP.ha();
                    int i = 0;
                    if (ha != null && ha.gU() != null) {
                        i = ha.gU().size();
                    }
                    String str2 = (i <= 0 || (dVar = ha.gU().get(i + (-1))) == null) ? "" : dVar.uX;
                    if (TextUtils.isEmpty(str2)) {
                        this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU);
                    } else {
                        this.aaJ.vG().acQ = str2;
                    }
                    TiebaStatic.net(this.aaJ);
                    return null;
                } else if (this.aaP.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vl, "UTF-8");
                    try {
                        dp(str);
                        TiebaStatic.net(this.aaJ);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                        this.aaJ.vG().acQ = String.valueOf(String.valueOf(this.aaJ.vG().acO)) + "|retryCount:" + (this.aaJ.vH().acR == null ? -1 : this.aaJ.vH().acR.uU) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.aaJ.vG().acO = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.aaJ.vG().acO = -15;
                        this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.aaJ);
                        return str;
                    } catch (SocketException e6) {
                        this.aaJ.vG().acO = -12;
                        this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                        TiebaStatic.net(this.aaJ);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.aaJ.vG().acO = -13;
                        this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.neterror);
                        TiebaStatic.net(this.aaJ);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.aaJ.vG().acO = -10;
                        this.aaJ.vG().mErrorString = String.valueOf(this.mContext.getResources().getString(n.i.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.aaJ);
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
    @Override // com.baidu.tbadk.core.util.u
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.aaP.isCanceled()) {
                return this.aaP.a(this.aaJ.vF().vI().mUrl, (z ? new File(str) : n.cW(str)).getAbsolutePath(), false, i2, i3, -1, -1, uU(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.aaJ);
            return false;
        } catch (Exception e) {
            this.aaJ.vG().acO = -10;
            this.aaJ.vG().mErrorString = String.valueOf(this.mContext.getResources().getString(n.i.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aaJ.vG().acO = -15;
            this.aaJ.vG().mErrorString = this.mContext.getResources().getString(n.i.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aaJ);
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public ArrayList<BasicNameValuePair> uk() {
        return this.aaJ.vF().vI().adh;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aaJ.vF().vI().adh != null) {
            this.aaJ.vF().vI().adh.clear();
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
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.u
    public void d(String str, byte[] bArr) {
        if (this.aaJ.vF().vI().adi == null) {
            this.aaJ.vF().vI().adi = new HashMap<>();
        }
        this.aaJ.vF().vI().adi.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.u
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aaJ.vF().vI().adh == null) {
                this.aaJ.vF().vI().adh = new ArrayList<>();
            }
            int b = b(this.aaJ.vF().vI().adh, basicNameValuePair.getName());
            int size = this.aaJ.vF().vI().adh.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.aaJ.vF().vI().adh.get(b).getName())) {
                    this.aaJ.vF().vI().adh.set(b, basicNameValuePair);
                } else {
                    this.aaJ.vF().vI().adh.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.aaJ.vF().vI().adh.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uU() {
        if (this.aaJ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aaJ.vF().vI().adm)) {
                linkedList.add(new BasicNameValuePair("sid", this.aaJ.vF().vI().adm));
            }
            if (!TextUtils.isEmpty(this.aaJ.vF().vI().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aaJ.vF().vI().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
