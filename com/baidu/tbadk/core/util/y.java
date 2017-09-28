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
    private static int afL = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a afG;
    private com.baidu.adp.lib.network.a.a afM = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        uM();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.afG = aVar;
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

    private void uM() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fs() {
        if (this.afM != null) {
            this.afM.fs();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fo() {
        this.afM.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uq() {
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
            if (this.afG.vJ().vM().aik != null && this.afG.vJ().vM().aik.size() > 0 && !this.afG.vJ().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.afG.vJ().vM().mUrl);
                if (this.afG.vJ().vM().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.afG.vJ().vM().mUrl.endsWith("?") && !this.afG.vJ().vM().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.afG.vJ().vM().aik.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.afG.vJ().vM().aik.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.afG.vJ().vM().aik.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.afG.vJ().vM().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.afG.vJ().vM().aim || this.afG.vJ().vM().mIsBDImage) && !this.afG.vJ().mIsFromCDN) {
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
        if (this.afM.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.afM.a(str, z, 5, 100, -1, -1, uW());
        com.baidu.adp.lib.network.http.e fG = this.afM.fG();
        if (fG == null) {
            return null;
        }
        gVar = fG.fz();
        if (fG != null) {
            try {
                if (fG.fA() != null && (size = fG.fA().size()) > 0) {
                    this.afG.vL().ahQ = fG.fA().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.afG.vK().vo = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ != null ? this.afG.vL().ahQ.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afG.vK().vo = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afG);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ != null ? this.afG.vL().ahQ.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afG.vK().vo = -12;
                TiebaStatic.net(this.afG);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ != null ? this.afG.vL().ahQ.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afG.vK().vo = -13;
                TiebaStatic.net(this.afG);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ != null ? this.afG.vL().ahQ.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.afG.vK().vo = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.afG);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.afG.vK().vo = gVar.responseCode;
        if (this.afG.vK().vo != 200) {
            this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
            if (this.afG.vL().ahQ != null && !TextUtils.isEmpty(this.afG.vL().ahQ.uX)) {
                this.afG.vK().ahP = this.afG.vL().ahQ.uX;
            } else {
                this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU);
            }
            TiebaStatic.net(this.afG);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > afL) {
                    this.afG.vK().vo = -11;
                    TiebaStatic.net(this.afG);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.DZ().fi(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.afG.vJ().vM().mUrl + "], size:" + i2);
                            this.afG.vK().vo = -16;
                            TiebaStatic.net(this.afG);
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
        aVar.aga = this.afG.vL().ahQ.uS;
        aVar.mTime = new Date().getTime() - j;
        aVar.agb = this.afG.vL().ahQ.uU;
        aVar.afZ = 2;
        aa.a(aVar);
        aa.afY.set(this.afG.vL().ahQ.uU);
        TiebaStatic.net(this.afG);
        bArr = gVar == null ? gVar.vq : null;
        return bArr;
    }

    public void dE(String str) {
        this.afG.vK().ahO = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.afG.vK().ahO = errorData.getError_code();
                if (this.afG.vK().ahO == -1) {
                    this.afG.vK().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
                } else if (this.afG.vK().ahO != 0) {
                    this.afG.vK().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.afG.vK().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ur() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uq = uq();
        if (uq == null || this.afG.vK().vo != 200) {
            return null;
        }
        try {
            this.afG.vJ().vM().aio = TextUtils.isEmpty(this.afG.vJ().vM().aio) ? "UTF-8" : this.afG.vJ().vM().aio;
            str = new String(uq, 0, uq.length, this.afG.vJ().vM().aio);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            dE(str);
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
    public String up() {
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
            if (this.afG.vJ().vM().aik == null || i2 >= this.afG.vJ().vM().aik.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.afG.vJ().vM().aik.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.afG.vJ().vM().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.afM.isCanceled()) {
                return null;
            }
            if (this.afM.a(this.afG.vJ().vM().mUrl, this.afG.vJ().vM().aik, this.afG.vJ().vM().aim, 5, -1, uW()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fG = this.afM.fG();
            if (fG == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fz = fG.fz();
            if (fG != null && fG.fA() != null && (size = fG.fA().size()) > 0) {
                this.afG.vL().ahQ = fG.fA().get(size - 1);
            }
            this.afG.vK().vo = fz.responseCode;
            this.afG.vK().mHeader = fz.vp;
            if (this.afG.vK().vo != 200) {
                if (this.afG.vL().ahQ != null && !TextUtils.isEmpty(this.afG.vL().ahQ.uX)) {
                    this.afG.vK().ahP = this.afG.vL().ahQ.uX;
                } else {
                    this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU);
                }
                TiebaStatic.net(this.afG);
                return null;
            } else if (this.afM.isCanceled()) {
                return null;
            } else {
                str = new String(fz.vq, "utf-8");
                try {
                    if (this.afG.vJ().vM().mIsBaiduServer && this.afG.vJ().vM().ain) {
                        dE(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
                    aVar.aga = this.afG.vL().ahQ.uS;
                    aVar.mTime = this.afG.vL().ahQ.uV;
                    aVar.agb = this.afG.vL().ahQ.uU;
                    aVar.afZ = 1;
                    aa.a(aVar);
                    aa.afY.set(this.afG.vL().ahQ.uU);
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.afG.vK().vo = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.afG.vK().vo = -15;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.afG.vK().vo = -12;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.afG.vK().vo = -13;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.afG.vK().vo = -10;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.afG.vK().vo = -10;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.afG);
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
    public String us() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.afM.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.afM.a(this.afG.vJ().vM().mUrl, this.afG.vJ().vM().aim, this.afG.vJ().vM().aik, this.afG.vJ().vM().ail, 5, -1, uW());
            this.afG.vK().vo = a.responseCode;
            this.afG.vK().mHeader = a.vp;
            if (this.afG.vK().vo != 200) {
                com.baidu.adp.lib.network.http.e fG = this.afM.fG();
                int i = 0;
                if (fG != null && fG.fA() != null) {
                    i = fG.fA().size();
                }
                if (i <= 0 || (dVar = fG.fA().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.uX;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.afG.vK().ahP = str2;
                } else {
                    this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU);
                }
                TiebaStatic.net(this.afG);
                return null;
            } else if (this.afM.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vq, "UTF-8");
                try {
                    dE(str);
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.afG.vK().ahP = String.valueOf(this.afG.vK().vo) + "|retryCount:" + (this.afG.vL().ahQ == null ? -1 : this.afG.vL().ahQ.uU) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.afG.vK().vo = -14;
                    return str;
                } catch (SocketException e5) {
                    this.afG.vK().vo = -12;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.afG.vK().vo = -13;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.afG.vK().vo = -10;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.afG);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.afG.vK().vo = -15;
                    this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.afG);
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
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.afM.isCanceled()) {
                return false;
            }
            return this.afM.a(this.afG.vJ().vM().mUrl, (z ? new File(str) : k.dj(str)).getAbsolutePath(), false, i2, i3, -1, -1, uW(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int afN = 0;
                int afO = 0;
                int afP = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.afN = i5 / 50;
                    }
                    this.afO += i4 - this.afP;
                    this.afP = i4;
                    if (handler != null) {
                        if (this.afO > this.afN || i4 == i5) {
                            this.afO = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.afG.vK().vo = -10;
            this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.afG.vK().vo = -15;
            this.afG.vK().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.afG);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> uo() {
        return this.afG.vJ().vM().aik;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.afG.vJ().vM().aik != null) {
            this.afG.vJ().vM().aik.clear();
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
        if (this.afG.vJ().vM().ail == null) {
            this.afG.vJ().vM().ail = new HashMap<>();
        }
        this.afG.vJ().vM().ail.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.afG.vJ().vM().aik == null) {
                this.afG.vJ().vM().aik = new ArrayList<>();
            }
            int b = b(this.afG.vJ().vM().aik, basicNameValuePair.getName());
            int size = this.afG.vJ().vM().aik.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.afG.vJ().vM().aik.get(b).getName())) {
                    this.afG.vJ().vM().aik.set(b, basicNameValuePair);
                } else {
                    this.afG.vJ().vM().aik.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.afG.vJ().vM().aik.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uW() {
        if (this.afG != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.afG.vJ().vM().aip)) {
                linkedList.add(new BasicNameValuePair("sid", this.afG.vJ().vM().aip));
            }
            if (!TextUtils.isEmpty(this.afG.vJ().vM().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.afG.vJ().vM().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
