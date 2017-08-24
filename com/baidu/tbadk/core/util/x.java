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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.d;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class x implements p {
    private static int agW = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a agR;
    private com.baidu.adp.lib.network.a.a agX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public x(com.baidu.tbadk.core.util.a.a aVar) {
        vl();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.agR = aVar;
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

    private void vl() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void fD() {
        if (this.agX != null) {
            this.agX.fD();
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public void fA() {
        this.agX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ug() {
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
            if (this.agR.wi().wl().ajp != null && this.agR.wi().wl().ajp.size() > 0 && !this.agR.wi().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.agR.wi().wl().mUrl);
                if (this.agR.wi().wl().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.agR.wi().wl().mUrl.endsWith("?") && !this.agR.wi().wl().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.agR.wi().wl().ajp.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.agR.wi().wl().ajp.get(i).getName());
                    sb.append("=");
                    sb.append(al.aR(this.agR.wi().wl().ajp.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.agR.wi().wl().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.agR.wi().wl().ajr || this.agR.wi().wl().mIsBDImage) && !this.agR.wi().mIsFromCDN) {
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
        if (this.agX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.agX.a(str, z, 5, 100, -1, -1, vv());
        com.baidu.adp.lib.network.http.e fR = this.agX.fR();
        if (fR == null) {
            return null;
        }
        gVar = fR.fK();
        if (fR != null) {
            try {
                if (fR.fL() != null && (size = fR.fL().size()) > 0) {
                    this.agR.wk().aiV = fR.fL().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.agR.wj().xv = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV != null ? this.agR.wk().aiV.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agR.wj().xv = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV != null ? this.agR.wk().aiV.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agR.wj().xv = -12;
                TiebaStatic.net(this.agR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV != null ? this.agR.wk().aiV.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agR.wj().xv = -13;
                TiebaStatic.net(this.agR);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV != null ? this.agR.wk().aiV.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agR.wj().xv = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agR);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.agR.wj().xv = gVar.responseCode;
        if (this.agR.wj().xv != 200) {
            this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
            if (this.agR.wk().aiV != null && !TextUtils.isEmpty(this.agR.wk().aiV.xe)) {
                this.agR.wj().aiU = this.agR.wk().aiV.xe;
            } else {
                this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry);
            }
            TiebaStatic.net(this.agR);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > agW) {
                    this.agR.wj().xv = -11;
                    TiebaStatic.net(this.agR);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Ex().eX(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.agR.wi().wl().mUrl + "], size:" + i2);
                            this.agR.wj().xv = -16;
                            TiebaStatic.net(this.agR);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        z.a aVar = new z.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.hx());
        aVar.ahk = this.agR.wk().aiV.xa;
        aVar.mTime = new Date().getTime() - j;
        aVar.ahl = this.agR.wk().aiV.retry;
        aVar.mMethod = 2;
        z.a(aVar);
        z.ahj.set(this.agR.wk().aiV.retry);
        TiebaStatic.net(this.agR);
        bArr = gVar == null ? gVar.xx : null;
        return bArr;
    }

    public void dU(String str) {
        this.agR.wj().aiT = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.agR.wj().aiT = errorData.getError_code();
                if (this.agR.wj().aiT == -1) {
                    this.agR.wj().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
                } else if (this.agR.wj().aiT != 0) {
                    this.agR.wj().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.agR.wj().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public String uQ() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ug = ug();
        if (ug == null || this.agR.wj().xv != 200) {
            return null;
        }
        try {
            this.agR.wi().wl().ajt = TextUtils.isEmpty(this.agR.wi().wl().ajt) ? "UTF-8" : this.agR.wi().wl().ajt;
            str = new String(ug, 0, ug.length, this.agR.wi().wl().ajt);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dU(str);
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

    @Override // com.baidu.tbadk.core.util.p
    public String uP() {
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
            if (this.agR.wi().wl().ajp == null || i2 >= this.agR.wi().wl().ajp.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.agR.wi().wl().ajp.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.agR.wi().wl().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aW(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.agX.isCanceled()) {
                return null;
            }
            if (this.agX.a(this.agR.wi().wl().mUrl, this.agR.wi().wl().ajp, this.agR.wi().wl().ajr, 5, -1, vv()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fR = this.agX.fR();
            if (fR == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fK = fR.fK();
            if (fR != null && fR.fL() != null && (size = fR.fL().size()) > 0) {
                this.agR.wk().aiV = fR.fL().get(size - 1);
            }
            this.agR.wj().xv = fK.responseCode;
            this.agR.wj().mHeader = fK.xw;
            if (this.agR.wj().xv != 200) {
                if (this.agR.wk().aiV != null && !TextUtils.isEmpty(this.agR.wk().aiV.xe)) {
                    this.agR.wj().aiU = this.agR.wk().aiV.xe;
                } else {
                    this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry);
                }
                TiebaStatic.net(this.agR);
                return null;
            } else if (this.agX.isCanceled()) {
                return null;
            } else {
                str = new String(fK.xx, "utf-8");
                try {
                    if (this.agR.wi().wl().mIsBaiduServer && this.agR.wi().wl().ajs) {
                        dU(str);
                    }
                    z.a aVar = new z.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.hx());
                    aVar.ahk = this.agR.wk().aiV.xa;
                    aVar.mTime = this.agR.wk().aiV.xc;
                    aVar.ahl = this.agR.wk().aiV.retry;
                    aVar.mMethod = 1;
                    z.a(aVar);
                    z.ahj.set(this.agR.wk().aiV.retry);
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.agR.wj().xv = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.agR.wj().xv = -15;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.agR.wj().xv = -12;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.agR.wj().xv = -13;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.agR.wj().xv = -10;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.agR.wj().xv = -10;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.agR);
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

    @Override // com.baidu.tbadk.core.util.p
    public String uR() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.agX.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.agX.a(this.agR.wi().wl().mUrl, this.agR.wi().wl().ajr, this.agR.wi().wl().ajp, this.agR.wi().wl().ajq, 5, -1, vv());
            this.agR.wj().xv = a.responseCode;
            this.agR.wj().mHeader = a.xw;
            if (this.agR.wj().xv != 200) {
                com.baidu.adp.lib.network.http.e fR = this.agX.fR();
                int i = 0;
                if (fR != null && fR.fL() != null) {
                    i = fR.fL().size();
                }
                if (i <= 0 || (dVar = fR.fL().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.xe;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.agR.wj().aiU = str2;
                } else {
                    this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry);
                }
                TiebaStatic.net(this.agR);
                return null;
            } else if (this.agX.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.xx, "UTF-8");
                try {
                    dU(str);
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agR.wj().aiU = String.valueOf(this.agR.wj().xv) + "|retryCount:" + (this.agR.wk().aiV == null ? -1 : this.agR.wk().aiV.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.agR.wj().xv = -14;
                    return str;
                } catch (SocketException e5) {
                    this.agR.wj().xv = -12;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.agR.wj().xv = -13;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.agR.wj().xv = -10;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.agR.wj().xv = -15;
                    this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agR);
                    return str;
                }
            }
        } catch (BdHttpCancelException e9) {
            e3 = e9;
            str = null;
        } catch (OutOfMemoryError e10) {
            e2 = e10;
            str = null;
        } catch (SocketException e11) {
            str = null;
        } catch (SocketTimeoutException e12) {
            str = null;
        } catch (Exception e13) {
            e = e13;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [698=5] */
    @Override // com.baidu.tbadk.core.util.p
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.agX.isCanceled()) {
                return false;
            }
            return this.agX.a(this.agR.wi().wl().mUrl, (z ? new File(str) : k.dD(str)).getAbsolutePath(), false, i2, i3, -1, -1, vv(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.x.1
                int agY = 0;
                int agZ = 0;
                int aha = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void n(int i4, int i5) {
                    if (i5 > 0) {
                        this.agY = i5 / 50;
                    }
                    this.agZ += i4 - this.aha;
                    this.aha = i4;
                    if (handler != null) {
                        if (this.agZ > this.agY || i4 == i5) {
                            this.agZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.agR.wj().xv = -10;
            this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.agR.wj().xv = -15;
            this.agR.wj().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.agR);
        }
    }

    @Override // com.baidu.tbadk.core.util.p
    public ArrayList<BasicNameValuePair> uO() {
        return this.agR.wi().wl().ajp;
    }

    @Override // com.baidu.tbadk.core.util.p
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.agR.wi().wl().ajp != null) {
            this.agR.wi().wl().ajp.clear();
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

    @Override // com.baidu.tbadk.core.util.p
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.p
    public void d(String str, byte[] bArr) {
        if (this.agR.wi().wl().ajq == null) {
            this.agR.wi().wl().ajq = new HashMap<>();
        }
        this.agR.wi().wl().ajq.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.p
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.agR.wi().wl().ajp == null) {
                this.agR.wi().wl().ajp = new ArrayList<>();
            }
            int b = b(this.agR.wi().wl().ajp, basicNameValuePair.getName());
            int size = this.agR.wi().wl().ajp.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.agR.wi().wl().ajp.get(b).getName())) {
                    this.agR.wi().wl().ajp.set(b, basicNameValuePair);
                } else {
                    this.agR.wi().wl().ajp.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.agR.wi().wl().ajp.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vv() {
        if (this.agR != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.agR.wi().wl().aju)) {
                linkedList.add(new BasicNameValuePair("sid", this.agR.wi().wl().aju));
            }
            if (!TextUtils.isEmpty(this.agR.wi().wl().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.agR.wi().wl().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
