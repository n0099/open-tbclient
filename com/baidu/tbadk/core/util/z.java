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
import com.baidu.tbadk.core.util.ac;
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
public class z implements r {
    private static int ZG = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a ZB;
    private com.baidu.adp.lib.network.a.a ZH = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public z(com.baidu.tbadk.core.util.a.a aVar) {
        uB();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.ZB = aVar;
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

    private void uB() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void eh() {
        if (this.ZH != null) {
            this.ZH.eh();
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void ee() {
        this.ZH.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ue() {
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
            if (this.ZB.vv().vy().acc != null && this.ZB.vv().vy().acc.size() > 0 && !this.ZB.vv().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZB.vv().vy().mUrl);
                if (this.ZB.vv().vy().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZB.vv().vy().mUrl.endsWith("?") && !this.ZB.vv().vy().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZB.vv().vy().acc.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZB.vv().vy().acc.get(i).getName());
                    sb.append("=");
                    sb.append(at.aO(this.ZB.vv().vy().acc.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZB.vv().vy().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZB.vv().vy().ace || this.ZB.vv().vy().mIsBDImage) && !this.ZB.vv().mIsFromCDN) {
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
        if (this.ZH.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ZH.a(str, z, 5, 100, -1, -1, uK());
        com.baidu.adp.lib.network.http.f ev = this.ZH.ev();
        if (ev == null) {
            return null;
        }
        hVar = ev.eo();
        if (ev != null) {
            try {
                if (ev.ep() != null && (size = ev.ep().size()) > 0) {
                    this.ZB.vx().abI = ev.ep().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZB.vw().oy = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI != null ? this.ZB.vx().abI.oa : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZB.vw().oy = -13;
                TiebaStatic.net(this.ZB);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.ZB.vw().mErrorString = String.valueOf(this.mContext.getResources().getString(r.l.neterror)) + " detailException:" + e.getMessage();
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI != null ? this.ZB.vx().abI.oa : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZB.vw().oy = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZB);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.memoryerror);
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI != null ? this.ZB.vx().abI.oa : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZB.vw().oy = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZB);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI != null ? this.ZB.vx().abI.oa : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZB.vw().oy = -12;
                TiebaStatic.net(this.ZB);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.ZB.vw().oy = hVar.responseCode;
        if (this.ZB.vw().oy != 200) {
            this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
            if (this.ZB.vx().abI != null && !TextUtils.isEmpty(this.ZB.vx().abI.od)) {
                this.ZB.vw().abH = this.ZB.vx().abI.od;
            } else {
                this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa);
            }
            TiebaStatic.net(this.ZB);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ZG) {
                    this.ZB.vw().oy = -11;
                    TiebaStatic.net(this.ZB);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.DS().eV(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZB.vv().vy().mUrl + "], size:" + i2);
                            this.ZB.vw().oy = -16;
                            TiebaStatic.net(this.ZB);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ac.a aVar = new ac.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.gq());
        aVar.ZW = this.ZB.vx().abI.nX;
        aVar.mTime = new Date().getTime() - j;
        aVar.ZX = this.ZB.vx().abI.oa;
        aVar.ZV = 2;
        ac.a(aVar);
        ac.ZU.set(this.ZB.vx().abI.oa);
        TiebaStatic.net(this.ZB);
        bArr = hVar == null ? hVar.oA : null;
        return bArr;
    }

    public void ds(String str) {
        this.ZB.vw().abG = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZB.vw().abG = errorData.getError_code();
                if (this.ZB.vw().abG == -1) {
                    this.ZB.vw().mErrorString = this.mContext.getString(r.l.error_unkown_try_again);
                } else if (this.ZB.vw().abG != 0) {
                    this.ZB.vw().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZB.vw().mErrorString = this.mContext.getString(r.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public String uf() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ue = ue();
        if (ue == null || this.ZB.vw().oy != 200) {
            return null;
        }
        try {
            this.ZB.vv().vy().acg = TextUtils.isEmpty(this.ZB.vv().vy().acg) ? "UTF-8" : this.ZB.vv().vy().acg;
            str = new String(ue, 0, ue.length, this.ZB.vv().vy().acg);
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

    @Override // com.baidu.tbadk.core.util.r
    public String ud() {
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
            if (this.ZB.vv().vy().acc == null || i2 >= this.ZB.vv().vy().acc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZB.vv().vy().acc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZB.vv().vy().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aT(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.ZH.isCanceled()) {
                return null;
            }
            if (this.ZH.a(this.ZB.vv().vy().mUrl, this.ZB.vv().vy().acc, this.ZB.vv().vy().ace, 5, -1, uK()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f ev = this.ZH.ev();
            if (ev == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h eo = ev.eo();
            if (ev != null && ev.ep() != null && (size = ev.ep().size()) > 0) {
                this.ZB.vx().abI = ev.ep().get(size - 1);
            }
            this.ZB.vw().oy = eo.responseCode;
            this.ZB.vw().mHeader = eo.oz;
            if (this.ZB.vw().oy != 200) {
                if (this.ZB.vx().abI != null && !TextUtils.isEmpty(this.ZB.vx().abI.od)) {
                    this.ZB.vw().abH = this.ZB.vx().abI.od;
                } else {
                    this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa);
                }
                TiebaStatic.net(this.ZB);
                return null;
            } else if (this.ZH.isCanceled()) {
                return null;
            } else {
                str = new String(eo.oA, "utf-8");
                try {
                    if (this.ZB.vv().vy().mIsBaiduServer && this.ZB.vv().vy().acf) {
                        ds(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.gq());
                    aVar.ZW = this.ZB.vx().abI.nX;
                    aVar.mTime = this.ZB.vx().abI.ob;
                    aVar.ZX = this.ZB.vx().abI.oa;
                    aVar.ZV = 1;
                    ac.a(aVar);
                    ac.ZU.set(this.ZB.vx().abI.oa);
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZB.vw().oy = -14;
                    return str2;
                } catch (SocketException e6) {
                    e2 = e6;
                    this.ZB.vw().oy = -12;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    this.ZB.vw().oy = -13;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (Exception e8) {
                    e4 = e8;
                    this.ZB.vw().oy = -10;
                    this.ZB.vw().mErrorString = String.valueOf(this.mContext.getResources().getString(r.l.neterror)) + " detailException:" + e4.getMessage();
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e3 = e9;
                    this.ZB.vw().oy = -15;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.memoryerror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZB.vw().oy = -10;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZB);
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

    @Override // com.baidu.tbadk.core.util.r
    public String ug() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.ZH.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.ZH.a(this.ZB.vv().vy().mUrl, this.ZB.vv().vy().ace, this.ZB.vv().vy().acc, this.ZB.vv().vy().acd, 5, -1, uK());
            this.ZB.vw().oy = a.responseCode;
            this.ZB.vw().mHeader = a.oz;
            if (this.ZB.vw().oy != 200) {
                com.baidu.adp.lib.network.http.f ev = this.ZH.ev();
                int i = 0;
                if (ev != null && ev.ep() != null) {
                    i = ev.ep().size();
                }
                if (i <= 0 || (eVar = ev.ep().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.od;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.ZB.vw().abH = str3;
                } else {
                    this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa);
                }
                TiebaStatic.net(this.ZB);
                return null;
            } else if (this.ZH.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.oA, "UTF-8");
                try {
                    ds(str);
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    this.ZB.vw().abH = String.valueOf(String.valueOf(this.ZB.vw().oy)) + "|retryCount:" + (this.ZB.vx().abI == null ? -1 : this.ZB.vx().abI.oa) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZB.vw().oy = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.ZB.vw().oy = -13;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.ZB.vw().oy = -10;
                    this.ZB.vw().mErrorString = String.valueOf(this.mContext.getResources().getString(r.l.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.ZB.vw().oy = -15;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZB);
                    return str;
                } catch (SocketException e7) {
                    this.ZB.vw().oy = -12;
                    this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.neterror);
                    TiebaStatic.net(this.ZB);
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
    @Override // com.baidu.tbadk.core.util.r
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.ZH.isCanceled()) {
                return this.ZH.a(this.ZB.vv().vy().mUrl, (z ? new File(str) : l.dc(str)).getAbsolutePath(), false, i2, i3, -1, -1, uK(), new aa(this, handler, i), true);
            }
            TiebaStatic.net(this.ZB);
            return false;
        } catch (Exception e) {
            this.ZB.vw().oy = -10;
            this.ZB.vw().mErrorString = String.valueOf(this.mContext.getResources().getString(r.l.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZB.vw().oy = -15;
            this.ZB.vw().mErrorString = this.mContext.getResources().getString(r.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZB);
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> uc() {
        return this.ZB.vv().vy().acc;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZB.vv().vy().acc != null) {
            this.ZB.vv().vy().acc.clear();
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

    @Override // com.baidu.tbadk.core.util.r
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void d(String str, byte[] bArr) {
        if (this.ZB.vv().vy().acd == null) {
            this.ZB.vv().vy().acd = new HashMap<>();
        }
        this.ZB.vv().vy().acd.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZB.vv().vy().acc == null) {
                this.ZB.vv().vy().acc = new ArrayList<>();
            }
            int c = c(this.ZB.vv().vy().acc, basicNameValuePair.getName());
            int size = this.ZB.vv().vy().acc.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.ZB.vv().vy().acc.get(c).getName())) {
                    this.ZB.vv().vy().acc.set(c, basicNameValuePair);
                } else {
                    this.ZB.vv().vy().acc.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.ZB.vv().vy().acc.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uK() {
        if (this.ZB != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZB.vv().vy().ach)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZB.vv().vy().ach));
            }
            if (!TextUtils.isEmpty(this.ZB.vv().vy().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZB.vv().vy().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
