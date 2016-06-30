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
import com.baidu.tieba.u;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ac implements t {
    private static int WQ = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a WL;
    private com.baidu.adp.lib.network.a.a WR = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ac(com.baidu.tbadk.core.util.a.a aVar) {
        tx();
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
        this.WL = aVar;
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

    private void tx() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void dp() {
        if (this.WR != null) {
            this.WR.dp();
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public void dm() {
        this.WR.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0398 -> B:91:0x0399). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tb() {
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
            if (this.WL.uu().ux().Zq != null && this.WL.uu().ux().Zq.size() > 0 && !this.WL.uu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.WL.uu().ux().mUrl);
                if (this.WL.uu().ux().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.WL.uu().ux().mUrl.endsWith("?") && !this.WL.uu().ux().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.WL.uu().ux().Zq.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.WL.uu().ux().Zq.get(i).getName());
                    sb.append("=");
                    sb.append(ba.aN(this.WL.uu().ux().Zq.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.WL.uu().ux().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.WL.uu().ux().Zs || this.WL.uu().ux().mIsBDImage) && !this.WL.uu().mIsFromCDN) {
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
        if (this.WR.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.WR.a(str, z, 5, 100, -1, -1, tG());
        com.baidu.adp.lib.network.http.f dD = this.WR.dD();
        if (dD == null) {
            return null;
        }
        hVar = dD.dw();
        if (dD != null) {
            try {
                if (dD.dx() != null && (size = dD.dx().size()) > 0) {
                    this.WL.uw().YW = dD.dx().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                hVar2 = hVar;
                bdHttpCancelException = e6;
                this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.WL.uv().lE = -14;
                hVar = hVar2;
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e7) {
                e = e7;
                this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW != null ? this.WL.uw().YW.li : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.WL.uv().lE = -13;
                TiebaStatic.net(this.WL);
                if (hVar == null) {
                }
                return bArr;
            } catch (Exception e8) {
                e = e8;
                this.WL.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW != null ? this.WL.uw().YW.li : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.WL.uv().lE = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.WL);
                if (hVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e9) {
                e = e9;
                this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW != null ? this.WL.uw().YW.li : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.WL.uv().lE = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.WL);
                if (hVar == null) {
                }
                return bArr;
            } catch (SocketException e10) {
                e = e10;
                this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW != null ? this.WL.uw().YW.li : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.WL.uv().lE = -12;
                TiebaStatic.net(this.WL);
                if (hVar == null) {
                }
                return bArr;
            }
        }
        if (hVar == null) {
            return null;
        }
        this.WL.uv().lE = hVar.responseCode;
        if (this.WL.uv().lE != 200) {
            this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
            if (this.WL.uw().YW != null && !TextUtils.isEmpty(this.WL.uw().YW.ll)) {
                this.WL.uv().YV = this.WL.uw().YW.ll;
            } else {
                this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li);
            }
            TiebaStatic.net(this.WL);
            return null;
        }
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (str2 = hVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > WQ) {
                    this.WL.uv().lE = -11;
                    TiebaStatic.net(this.WL);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.CQ().eD(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.WL.uu().ux().mUrl + "], size:" + i2);
                            this.WL.uv().lE = -16;
                            TiebaStatic.net(this.WL);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        af.a aVar = new af.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.fx());
        aVar.Xg = this.WL.uw().YW.lf;
        aVar.mTime = new Date().getTime() - j;
        aVar.Xh = this.WL.uw().YW.li;
        aVar.Xf = 2;
        af.a(aVar);
        af.Xe.set(this.WL.uw().YW.li);
        TiebaStatic.net(this.WL);
        bArr = hVar == null ? hVar.lG : null;
        return bArr;
    }

    public void dn(String str) {
        this.WL.uv().YU = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.WL.uv().YU = errorData.getError_code();
                if (this.WL.uv().YU == -1) {
                    this.WL.uv().mErrorString = this.mContext.getString(u.j.error_unkown_try_again);
                } else if (this.WL.uv().YU != 0) {
                    this.WL.uv().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.WL.uv().mErrorString = this.mContext.getString(u.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String tc() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tb = tb();
        if (tb == null || this.WL.uv().lE != 200) {
            return null;
        }
        try {
            this.WL.uu().ux().Zu = TextUtils.isEmpty(this.WL.uu().ux().Zu) ? "UTF-8" : this.WL.uu().ux().Zu;
            str = new String(tb, 0, tb.length, this.WL.uu().ux().Zu);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dn(str);
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
    public String ta() {
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
            if (this.WL.uu().ux().Zq == null || i2 >= this.WL.uu().ux().Zq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.WL.uu().ux().Zq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.WL.uu().ux().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.aS(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.WR.isCanceled()) {
                return null;
            }
            if (this.WR.a(this.WL.uu().ux().mUrl, this.WL.uu().ux().Zq, this.WL.uu().ux().Zs, 5, -1, tG()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.f dD = this.WR.dD();
            if (dD == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.h dw = dD.dw();
            if (dD != null && dD.dx() != null && (size = dD.dx().size()) > 0) {
                this.WL.uw().YW = dD.dx().get(size - 1);
            }
            this.WL.uv().lE = dw.responseCode;
            this.WL.uv().mHeader = dw.lF;
            if (this.WL.uv().lE != 200) {
                if (this.WL.uw().YW != null && !TextUtils.isEmpty(this.WL.uw().YW.ll)) {
                    this.WL.uv().YV = this.WL.uw().YW.ll;
                } else {
                    this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li);
                }
                TiebaStatic.net(this.WL);
                return null;
            } else if (this.WR.isCanceled()) {
                return null;
            } else {
                str = new String(dw.lG, "utf-8");
                try {
                    if (this.WL.uu().ux().mIsBaiduServer && this.WL.uu().ux().Zt) {
                        dn(str);
                    }
                    af.a aVar = new af.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.fx());
                    aVar.Xg = this.WL.uw().YW.lf;
                    aVar.mTime = this.WL.uw().YW.lj;
                    aVar.Xh = this.WL.uw().YW.li;
                    aVar.Xf = 1;
                    af.a(aVar);
                    af.Xe.set(this.WL.uw().YW.li);
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.WL.uv().lE = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.WL.uv().lE = -12;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.WL.uv().lE = -13;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.WL.uv().lE = -10;
                    this.WL.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.WL.uv().lE = -15;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.WL.uv().lE = -10;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.WL);
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

    @Override // com.baidu.tbadk.core.util.t
    public String td() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        try {
            if (this.WR.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.h a = this.WR.a(this.WL.uu().ux().mUrl, this.WL.uu().ux().Zs, this.WL.uu().ux().Zq, this.WL.uu().ux().Zr, 5, -1, tG());
            this.WL.uv().lE = a.responseCode;
            this.WL.uv().mHeader = a.lF;
            if (this.WL.uv().lE != 200) {
                com.baidu.adp.lib.network.http.f dD = this.WR.dD();
                int i = 0;
                if (dD != null && dD.dx() != null) {
                    i = dD.dx().size();
                }
                if (i <= 0 || (eVar = dD.dx().get(i - 1)) == null) {
                    str3 = "";
                } else {
                    str3 = eVar.ll;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.WL.uv().YV = str3;
                } else {
                    this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li);
                }
                TiebaStatic.net(this.WL);
                return null;
            } else if (this.WR.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.lG, "UTF-8");
                try {
                    dn(str);
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (BdHttpCancelException e3) {
                    bdHttpCancelException = e3;
                    str2 = str;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    this.WL.uv().YV = String.valueOf(String.valueOf(this.WL.uv().lE)) + "|retryCount:" + (this.WL.uw().YW == null ? -1 : this.WL.uw().YW.li) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.WL.uv().lE = -14;
                    return str2;
                } catch (SocketTimeoutException e4) {
                    this.WL.uv().lE = -13;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.WL.uv().lE = -10;
                    this.WL.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e2 = e6;
                    this.WL.uv().lE = -15;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.WL);
                    return str;
                } catch (SocketException e7) {
                    this.WL.uv().lE = -12;
                    this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.neterror);
                    TiebaStatic.net(this.WL);
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
    @Override // com.baidu.tbadk.core.util.t
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.WR.isCanceled()) {
                return this.WR.a(this.WL.uu().ux().mUrl, (z ? new File(str) : m.cW(str)).getAbsolutePath(), false, i2, i3, -1, -1, tG(), new ad(this, handler, i), true);
            }
            TiebaStatic.net(this.WL);
            return false;
        } catch (Exception e) {
            this.WL.uv().lE = -10;
            this.WL.uv().mErrorString = String.valueOf(this.mContext.getResources().getString(u.j.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.WL.uv().lE = -15;
            this.WL.uv().mErrorString = this.mContext.getResources().getString(u.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.WL);
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> sZ() {
        return this.WL.uu().ux().Zq;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.WL.uu().ux().Zq != null) {
            this.WL.uu().ux().Zq.clear();
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
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void d(String str, byte[] bArr) {
        if (this.WL.uu().ux().Zr == null) {
            this.WL.uu().ux().Zr = new HashMap<>();
        }
        this.WL.uu().ux().Zr.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.WL.uu().ux().Zq == null) {
                this.WL.uu().ux().Zq = new ArrayList<>();
            }
            int c = c(this.WL.uu().ux().Zq, basicNameValuePair.getName());
            int size = this.WL.uu().ux().Zq.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.WL.uu().ux().Zq.get(c).getName())) {
                    this.WL.uu().ux().Zq.set(c, basicNameValuePair);
                } else {
                    this.WL.uu().ux().Zq.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.WL.uu().ux().Zq.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> tG() {
        if (this.WL != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.WL.uu().ux().Zv)) {
                linkedList.add(new BasicNameValuePair("sid", this.WL.uu().ux().Zv));
            }
            if (!TextUtils.isEmpty(this.WL.uu().ux().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.WL.uu().ux().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
