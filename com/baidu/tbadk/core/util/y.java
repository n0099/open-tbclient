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
public class y implements q {
    private static int ags = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a agn;
    private com.baidu.adp.lib.network.a.a agt = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        uP();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.agn = aVar;
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

    private void uP() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fs() {
        if (this.agt != null) {
            this.agt.fs();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fo() {
        this.agt.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ut() {
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
            if (this.agn.vN().vQ().aiS != null && this.agn.vN().vQ().aiS.size() > 0 && !this.agn.vN().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.agn.vN().vQ().mUrl);
                if (this.agn.vN().vQ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.agn.vN().vQ().mUrl.endsWith("?") && !this.agn.vN().vQ().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.agn.vN().vQ().aiS.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.agn.vN().vQ().aiS.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.agn.vN().vQ().aiS.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.agn.vN().vQ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.agn.vN().vQ().aiU || this.agn.vN().vQ().mIsBDImage) && !this.agn.vN().mIsFromCDN) {
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
        if (this.agt.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.agt.a(str, z, 5, 100, -1, -1, uZ());
        com.baidu.adp.lib.network.http.e fG = this.agt.fG();
        if (fG == null) {
            return null;
        }
        gVar = fG.fz();
        if (fG != null) {
            try {
                if (fG.fA() != null && (size = fG.fA().size()) > 0) {
                    this.agn.vP().aiy = fG.fA().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.agn.vO().vp = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy != null ? this.agn.vP().aiy.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agn.vO().vp = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agn);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy != null ? this.agn.vP().aiy.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agn.vO().vp = -12;
                TiebaStatic.net(this.agn);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy != null ? this.agn.vP().aiy.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agn.vO().vp = -13;
                TiebaStatic.net(this.agn);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy != null ? this.agn.vP().aiy.uV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agn.vO().vp = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agn);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.agn.vO().vp = gVar.responseCode;
        if (this.agn.vO().vp != 200) {
            this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.agn.vP().aiy != null && !TextUtils.isEmpty(this.agn.vP().aiy.uY)) {
                this.agn.vO().aix = this.agn.vP().aiy.uY;
            } else {
                this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV);
            }
            TiebaStatic.net(this.agn);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ags) {
                    this.agn.vO().vp = -11;
                    TiebaStatic.net(this.agn);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Ez().fg(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.agn.vN().vQ().mUrl + "], size:" + i2);
                            this.agn.vO().vp = -16;
                            TiebaStatic.net(this.agn);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
        aVar.agH = this.agn.vP().aiy.uT;
        aVar.mTime = new Date().getTime() - j;
        aVar.agI = this.agn.vP().aiy.uV;
        aVar.agG = 2;
        aa.a(aVar);
        aa.agF.set(this.agn.vP().aiy.uV);
        TiebaStatic.net(this.agn);
        bArr = gVar == null ? gVar.vr : null;
        return bArr;
    }

    public void dL(String str) {
        this.agn.vO().aiw = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.agn.vO().aiw = errorData.getError_code();
                if (this.agn.vO().aiw == -1) {
                    this.agn.vO().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.agn.vO().aiw != 0) {
                    this.agn.vO().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.agn.vO().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String uu() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ut = ut();
        if (ut == null || this.agn.vO().vp != 200) {
            return null;
        }
        try {
            this.agn.vN().vQ().aiW = TextUtils.isEmpty(this.agn.vN().vQ().aiW) ? "UTF-8" : this.agn.vN().vQ().aiW;
            str = new String(ut, 0, ut.length, this.agn.vN().vQ().aiW);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dL(str);
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
    public String us() {
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
            if (this.agn.vN().vQ().aiS == null || i2 >= this.agn.vN().vQ().aiS.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.agn.vN().vQ().aiS.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.agn.vN().vQ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.agt.isCanceled()) {
                return null;
            }
            if (this.agt.a(this.agn.vN().vQ().mUrl, this.agn.vN().vQ().aiS, this.agn.vN().vQ().aiU, 5, -1, uZ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fG = this.agt.fG();
            if (fG == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fz = fG.fz();
            if (fG != null && fG.fA() != null && (size = fG.fA().size()) > 0) {
                this.agn.vP().aiy = fG.fA().get(size - 1);
            }
            this.agn.vO().vp = fz.responseCode;
            this.agn.vO().mHeader = fz.vq;
            if (this.agn.vO().vp != 200) {
                if (this.agn.vP().aiy != null && !TextUtils.isEmpty(this.agn.vP().aiy.uY)) {
                    this.agn.vO().aix = this.agn.vP().aiy.uY;
                } else {
                    this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV);
                }
                TiebaStatic.net(this.agn);
                return null;
            } else if (this.agt.isCanceled()) {
                return null;
            } else {
                str = new String(fz.vr, "utf-8");
                try {
                    if (this.agn.vN().vQ().mIsBaiduServer && this.agn.vN().vQ().aiV) {
                        dL(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
                    aVar.agH = this.agn.vP().aiy.uT;
                    aVar.mTime = this.agn.vP().aiy.uW;
                    aVar.agI = this.agn.vP().aiy.uV;
                    aVar.agG = 1;
                    aa.a(aVar);
                    aa.agF.set(this.agn.vP().aiy.uV);
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.agn.vO().vp = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.agn.vO().vp = -15;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.agn.vO().vp = -12;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.agn.vO().vp = -13;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.agn.vO().vp = -10;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.agn.vO().vp = -10;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.agn);
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

    @Override // com.baidu.tbadk.core.util.q
    public String uv() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.agt.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.agt.a(this.agn.vN().vQ().mUrl, this.agn.vN().vQ().aiU, this.agn.vN().vQ().aiS, this.agn.vN().vQ().aiT, 5, -1, uZ());
            this.agn.vO().vp = a.responseCode;
            this.agn.vO().mHeader = a.vq;
            if (this.agn.vO().vp != 200) {
                com.baidu.adp.lib.network.http.e fG = this.agt.fG();
                int i = 0;
                if (fG != null && fG.fA() != null) {
                    i = fG.fA().size();
                }
                if (i <= 0 || (dVar = fG.fA().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.uY;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.agn.vO().aix = str2;
                } else {
                    this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV);
                }
                TiebaStatic.net(this.agn);
                return null;
            } else if (this.agt.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vr, "UTF-8");
                try {
                    dL(str);
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.agn.vO().aix = String.valueOf(this.agn.vO().vp) + "|retryCount:" + (this.agn.vP().aiy == null ? -1 : this.agn.vP().aiy.uV) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.agn.vO().vp = -14;
                    return str;
                } catch (SocketException e5) {
                    this.agn.vO().vp = -12;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.agn.vO().vp = -13;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.agn.vO().vp = -10;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agn);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.agn.vO().vp = -15;
                    this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agn);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [697=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.agt.isCanceled()) {
                return false;
            }
            return this.agt.a(this.agn.vN().vQ().mUrl, (z ? new File(str) : k.dp(str)).getAbsolutePath(), false, i2, i3, -1, -1, uZ(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int agu = 0;
                int agv = 0;
                int agw = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.agu = i5 / 50;
                    }
                    this.agv += i4 - this.agw;
                    this.agw = i4;
                    if (handler != null) {
                        if (this.agv > this.agu || i4 == i5) {
                            this.agv = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.agn.vO().vp = -10;
            this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.agn.vO().vp = -15;
            this.agn.vO().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.agn);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> ur() {
        return this.agn.vN().vQ().aiS;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.agn.vN().vQ().aiS != null) {
            this.agn.vN().vQ().aiS.clear();
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
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.agn.vN().vQ().aiT == null) {
            this.agn.vN().vQ().aiT = new HashMap<>();
        }
        this.agn.vN().vQ().aiT.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.agn.vN().vQ().aiS == null) {
                this.agn.vN().vQ().aiS = new ArrayList<>();
            }
            int c = c(this.agn.vN().vQ().aiS, basicNameValuePair.getName());
            int size = this.agn.vN().vQ().aiS.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.agn.vN().vQ().aiS.get(c).getName())) {
                    this.agn.vN().vQ().aiS.set(c, basicNameValuePair);
                } else {
                    this.agn.vN().vQ().aiS.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.agn.vN().vQ().aiS.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uZ() {
        if (this.agn != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.agn.vN().vQ().aiX)) {
                linkedList.add(new BasicNameValuePair("sid", this.agn.vN().vQ().aiX));
            }
            if (!TextUtils.isEmpty(this.agn.vN().vQ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.agn.vN().vQ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
