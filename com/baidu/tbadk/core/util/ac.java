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
    private static int abr = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a abm;
    private com.baidu.adp.lib.network.a.a abt = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        uv();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.abm = aVar;
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

    private void uv() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void gO() {
        if (this.abt != null) {
            this.abt.gO();
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public void gL() {
        this.abt.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tW() {
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
            if (this.abm.vp().vs().adL != null && this.abm.vp().vs().adL.size() > 0 && !this.abm.vp().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.abm.vp().vs().mUrl);
                if (this.abm.vp().vs().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.abm.vp().vs().mUrl.endsWith("?") && !this.abm.vp().vs().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.abm.vp().vs().adL.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.abm.vp().vs().adL.get(i).getName());
                    sb.append("=");
                    sb.append(ax.aT(this.abm.vp().vs().adL.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.abm.vp().vs().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.abm.vp().vs().adN || this.abm.vp().vs().mIsBDImage) && !this.abm.vp().mIsFromCDN) {
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
        if (this.abt.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.abt.a(str, z, 5, 100, -1, -1, uE());
        com.baidu.adp.lib.network.http.e ha = this.abt.ha();
        if (ha == null) {
            return null;
        }
        gVar = ha.gT();
        if (ha != null) {
            try {
                if (ha.gU() != null && (size = ha.gU().size()) > 0) {
                    this.abm.vr().adw = ha.gU().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.abm.vq().adt = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.memoryerror);
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw != null ? this.abm.vr().adw.uW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abm.vq().adt = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.abm);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw != null ? this.abm.vr().adw.uW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abm.vq().adt = -12;
                TiebaStatic.net(this.abm);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw != null ? this.abm.vr().adw.uW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abm.vq().adt = -13;
                TiebaStatic.net(this.abm);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.abm.vq().mErrorString = String.valueOf(this.mContext.getResources().getString(n.j.neterror)) + " detailException:" + e.getMessage();
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw != null ? this.abm.vr().adw.uW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.abm.vq().adt = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.abm);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.abm.vq().adt = gVar.responseCode;
        if (this.abm.vq().adt != 200) {
            this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
            if (this.abm.vr().adw != null && !TextUtils.isEmpty(this.abm.vr().adw.uZ)) {
                this.abm.vq().adv = this.abm.vr().adw.uZ;
            } else {
                this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW);
            }
            TiebaStatic.net(this.abm);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > abr) {
                    this.abm.vq().adt = -11;
                    TiebaStatic.net(this.abm);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.CM().et(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.abm.vp().vs().mUrl + "], size:" + i2);
                            this.abm.vq().adt = -16;
                            TiebaStatic.net(this.abm);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iW());
        aVar.abI = this.abm.vr().adw.uT;
        aVar.mTime = new Date().getTime() - j;
        aVar.abJ = this.abm.vr().adw.uW;
        aVar.abH = 2;
        af.a(aVar);
        af.abG.set(this.abm.vr().adw.uW);
        TiebaStatic.net(this.abm);
        bArr = gVar == null ? gVar.vn : null;
        return bArr;
    }

    public void ds(String str) {
        this.abm.vq().adu = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.abm.vq().adu = errorData.getError_code();
                if (this.abm.vq().adu == -1) {
                    this.abm.vq().mErrorString = this.mContext.getString(n.j.error_unkown_try_again);
                } else if (this.abm.vq().adu != 0) {
                    this.abm.vq().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.abm.vq().mErrorString = this.mContext.getString(n.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public String tX() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tW = tW();
        if (tW == null || this.abm.vq().adt != 200) {
            return null;
        }
        try {
            this.abm.vp().vs().adP = TextUtils.isEmpty(this.abm.vp().vs().adP) ? "UTF-8" : this.abm.vp().vs().adP;
            str = new String(tW, 0, tW.length, this.abm.vp().vs().adP);
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

    @Override // com.baidu.tbadk.core.util.u
    public String tV() {
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
            if (this.abm.vp().vs().adL == null || i2 >= this.abm.vp().vs().adL.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.abm.vp().vs().adL.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.abm.vp().vs().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.abt.isCanceled()) {
                return null;
            }
            if (this.abt.a(this.abm.vp().vs().mUrl, this.abm.vp().vs().adL, this.abm.vp().vs().adN, 5, -1, uE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e ha = this.abt.ha();
            if (ha == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gT = ha.gT();
            if (ha != null && ha.gU() != null && (size = ha.gU().size()) > 0) {
                this.abm.vr().adw = ha.gU().get(size - 1);
            }
            this.abm.vq().adt = gT.responseCode;
            this.abm.vq().mHeader = gT.vm;
            if (this.abm.vq().adt != 200) {
                if (this.abm.vr().adw != null && !TextUtils.isEmpty(this.abm.vr().adw.uZ)) {
                    this.abm.vq().adv = this.abm.vr().adw.uZ;
                } else {
                    this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW);
                }
                TiebaStatic.net(this.abm);
                return null;
            } else if (this.abt.isCanceled()) {
                return null;
            } else {
                str = new String(gT.vn, "utf-8");
                try {
                    if (this.abm.vp().vs().mIsBaiduServer && this.abm.vp().vs().adO) {
                        ds(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iW());
                    aVar.abI = this.abm.vr().adw.uT;
                    aVar.mTime = this.abm.vr().adw.uX;
                    aVar.abJ = this.abm.vr().adw.uW;
                    aVar.abH = 1;
                    af.a(aVar);
                    af.abG.set(this.abm.vr().adw.uW);
                    TiebaStatic.net(this.abm);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                    this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.abm.vq().adt = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.abm.vq().adt = -15;
                    this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.abm);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.abm.vq().adt = -12;
                    this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.abm);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.abm.vq().adt = -13;
                    this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.abm);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.abm.vq().adt = -10;
                    this.abm.vq().mErrorString = String.valueOf(this.mContext.getResources().getString(n.j.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.abm);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.abm.vq().adt = -10;
                    this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.abm);
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
    public String tY() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.abt.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.abt.a(this.abm.vp().vs().mUrl, this.abm.vp().vs().adN, this.abm.vp().vs().adL, this.abm.vp().vs().adM, 5, -1, uE());
                this.abm.vq().adt = a2.responseCode;
                this.abm.vq().mHeader = a2.vm;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.abm.vq().adt != 200) {
                    com.baidu.adp.lib.network.http.e ha = this.abt.ha();
                    int i = 0;
                    if (ha != null && ha.gU() != null) {
                        i = ha.gU().size();
                    }
                    String str2 = (i <= 0 || (dVar = ha.gU().get(i + (-1))) == null) ? "" : dVar.uZ;
                    if (TextUtils.isEmpty(str2)) {
                        this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW);
                    } else {
                        this.abm.vq().adv = str2;
                    }
                    TiebaStatic.net(this.abm);
                    return null;
                } else if (this.abt.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vn, "UTF-8");
                    try {
                        ds(str);
                        TiebaStatic.net(this.abm);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                        this.abm.vq().adv = String.valueOf(String.valueOf(this.abm.vq().adt)) + "|retryCount:" + (this.abm.vr().adw == null ? -1 : this.abm.vr().adw.uW) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.abm.vq().adt = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.abm.vq().adt = -15;
                        this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.abm);
                        return str;
                    } catch (SocketException e6) {
                        this.abm.vq().adt = -12;
                        this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                        TiebaStatic.net(this.abm);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.abm.vq().adt = -13;
                        this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.neterror);
                        TiebaStatic.net(this.abm);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.abm.vq().adt = -10;
                        this.abm.vq().mErrorString = String.valueOf(this.mContext.getResources().getString(n.j.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.abm);
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
            if (!this.abt.isCanceled()) {
                return this.abt.a(this.abm.vp().vs().mUrl, (z ? new File(str) : n.cZ(str)).getAbsolutePath(), false, i2, i3, -1, -1, uE(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.abm);
            return false;
        } catch (Exception e) {
            this.abm.vq().adt = -10;
            this.abm.vq().mErrorString = String.valueOf(this.mContext.getResources().getString(n.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.abm.vq().adt = -15;
            this.abm.vq().mErrorString = this.mContext.getResources().getString(n.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.abm);
        }
    }

    @Override // com.baidu.tbadk.core.util.u
    public ArrayList<BasicNameValuePair> tU() {
        return this.abm.vp().vs().adL;
    }

    @Override // com.baidu.tbadk.core.util.u
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.abm.vp().vs().adL != null) {
            this.abm.vp().vs().adL.clear();
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
        if (this.abm.vp().vs().adM == null) {
            this.abm.vp().vs().adM = new HashMap<>();
        }
        this.abm.vp().vs().adM.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.u
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.abm.vp().vs().adL == null) {
                this.abm.vp().vs().adL = new ArrayList<>();
            }
            int b = b(this.abm.vp().vs().adL, basicNameValuePair.getName());
            int size = this.abm.vp().vs().adL.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.abm.vp().vs().adL.get(b).getName())) {
                    this.abm.vp().vs().adL.set(b, basicNameValuePair);
                } else {
                    this.abm.vp().vs().adL.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.abm.vp().vs().adL.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uE() {
        if (this.abm != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.abm.vp().vs().adQ)) {
                linkedList.add(new BasicNameValuePair("sid", this.abm.vp().vs().adQ));
            }
            if (!TextUtils.isEmpty(this.abm.vp().vs().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.abm.vp().vs().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
