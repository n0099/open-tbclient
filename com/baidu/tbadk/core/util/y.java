package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
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
    private static int aVW = 2097152;
    private final com.baidu.tbadk.core.util.a.a aVR;
    private com.baidu.adp.lib.network.a.a aVX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Cy();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aVR = aVar;
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

    private void Cy() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mV() {
        if (this.aVX != null) {
            this.aVX.mV();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mS() {
        this.aVX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] Cc() {
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
            if (this.aVR.Dw().Dz().aYz != null && this.aVR.Dw().Dz().aYz.size() > 0 && !this.aVR.Dw().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aVR.Dw().Dz().mUrl);
                if (this.aVR.Dw().Dz().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aVR.Dw().Dz().mUrl.endsWith("?") && !this.aVR.Dw().Dz().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aVR.Dw().Dz().aYz.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aVR.Dw().Dz().aYz.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aVR.Dw().Dz().aYz.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aVR.Dw().Dz().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aVR.Dw().Dz().aYB || this.aVR.Dw().Dz().mIsBDImage) && !this.aVR.Dw().mIsFromCDN) {
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
        if (this.aVX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aVX.a(str, z, 5, 100, -1, -1, CI());
        com.baidu.adp.lib.network.http.e nj = this.aVX.nj();
        if (nj == null) {
            return null;
        }
        gVar = nj.nc();
        if (nj != null) {
            try {
                if (nj.nd() != null && (size = nj.nd().size()) > 0) {
                    this.aVR.Dy().aYf = nj.nd().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aVR.Dx().ajw = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf != null ? this.aVR.Dy().aYf.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVR.Dx().ajw = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aVR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf != null ? this.aVR.Dy().aYf.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVR.Dx().ajw = -12;
                TiebaStatic.net(this.aVR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf != null ? this.aVR.Dy().aYf.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVR.Dx().ajw = -13;
                TiebaStatic.net(this.aVR);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf != null ? this.aVR.Dy().aYf.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVR.Dx().ajw = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aVR);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aVR.Dx().ajw = gVar.responseCode;
        if (this.aVR.Dx().ajw != 200) {
            this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aVR.Dy().aYf != null && !TextUtils.isEmpty(this.aVR.Dy().aYf.ajf)) {
                this.aVR.Dx().aYe = this.aVR.Dy().aYf.ajf;
            } else {
                this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc);
            }
            TiebaStatic.net(this.aVR);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aVW) {
                    this.aVR.Dx().ajw = -11;
                    TiebaStatic.net(this.aVR);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mx().hY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aVR.Dw().Dz().mUrl + "], size:" + i2);
                            this.aVR.Dx().ajw = -16;
                            TiebaStatic.net(this.aVR);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
        aVar.aWm = this.aVR.Dy().aYf.aja;
        aVar.mTime = new Date().getTime() - j;
        aVar.aWn = this.aVR.Dy().aYf.ajc;
        aVar.aWl = 2;
        aa.a(aVar);
        aa.aWk.set(this.aVR.Dy().aYf.ajc);
        TiebaStatic.net(this.aVR);
        bArr = gVar == null ? gVar.ajy : null;
        return bArr;
    }

    public void ej(String str) {
        this.aVR.Dx().aYd = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aVR.Dx().aYd = errorData.getError_code();
                if (this.aVR.Dx().aYd == -1) {
                    this.aVR.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aVR.Dx().aYd != 0) {
                    this.aVR.Dx().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aVR.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Cd() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] Cc = Cc();
        if (Cc == null || this.aVR.Dx().ajw != 200) {
            return null;
        }
        try {
            this.aVR.Dw().Dz().aYD = TextUtils.isEmpty(this.aVR.Dw().Dz().aYD) ? "UTF-8" : this.aVR.Dw().Dz().aYD;
            str = new String(Cc, 0, Cc.length, this.aVR.Dw().Dz().aYD);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            ej(str);
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
    public String Cb() {
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
            if (this.aVR.Dw().Dz().aYz == null || i2 >= this.aVR.Dw().Dz().aYz.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aVR.Dw().Dz().aYz.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aVR.Dw().Dz().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", com.baidu.adp.lib.util.s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aVX.isCanceled()) {
                return null;
            }
            if (this.aVX.a(this.aVR.Dw().Dz().mUrl, this.aVR.Dw().Dz().aYz, this.aVR.Dw().Dz().aYB, 5, -1, CI()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e nj = this.aVX.nj();
            if (nj == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g nc = nj.nc();
            if (nj != null && nj.nd() != null && (size = nj.nd().size()) > 0) {
                this.aVR.Dy().aYf = nj.nd().get(size - 1);
            }
            this.aVR.Dx().ajw = nc.responseCode;
            this.aVR.Dx().mHeader = nc.ajx;
            if (this.aVR.Dx().ajw != 200) {
                if (this.aVR.Dy().aYf != null && !TextUtils.isEmpty(this.aVR.Dy().aYf.ajf)) {
                    this.aVR.Dx().aYe = this.aVR.Dy().aYf.ajf;
                } else {
                    this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc);
                }
                TiebaStatic.net(this.aVR);
                return null;
            } else if (this.aVX.isCanceled()) {
                return null;
            } else {
                str = new String(nc.ajy, "utf-8");
                try {
                    if (this.aVR.Dw().Dz().mIsBaiduServer && this.aVR.Dw().Dz().aYC) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWm = this.aVR.Dy().aYf.aja;
                    aVar.mTime = this.aVR.Dy().aYf.ajd;
                    aVar.aWn = this.aVR.Dy().aYf.ajc;
                    aVar.aWl = 1;
                    aa.a(aVar);
                    aa.aWk.set(this.aVR.Dy().aYf.ajc);
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aVR.Dx().ajw = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aVR.Dx().ajw = -15;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aVR.Dx().ajw = -12;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aVR.Dx().ajw = -13;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aVR.Dx().ajw = -10;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aVR.Dx().ajw = -10;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aVR);
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
    public String Ce() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.aVX.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aVX.a(this.aVR.Dw().Dz().mUrl, this.aVR.Dw().Dz().aYB, this.aVR.Dw().Dz().aYz, this.aVR.Dw().Dz().aYA, 5, -1, CI());
            this.aVR.Dx().ajw = a.responseCode;
            this.aVR.Dx().mHeader = a.ajx;
            if (this.aVR.Dx().ajw != 200) {
                com.baidu.adp.lib.network.http.e nj = this.aVX.nj();
                int i = 0;
                if (nj != null && nj.nd() != null) {
                    i = nj.nd().size();
                }
                if (i <= 0 || (dVar = nj.nd().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.ajf;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aVR.Dx().aYe = str2;
                } else {
                    this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc);
                }
                TiebaStatic.net(this.aVR);
                return null;
            } else if (this.aVX.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.ajy, "UTF-8");
                try {
                    ej(str);
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aVR.Dx().aYe = String.valueOf(this.aVR.Dx().ajw) + "|retryCount:" + (this.aVR.Dy().aYf == null ? -1 : this.aVR.Dy().aYf.ajc) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aVR.Dx().ajw = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aVR.Dx().ajw = -12;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aVR.Dx().ajw = -13;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aVR.Dx().ajw = -10;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aVR);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aVR.Dx().ajw = -15;
                    this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aVR);
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
            if (this.aVX.isCanceled()) {
                return false;
            }
            return this.aVX.a(this.aVR.Dw().Dz().mUrl, (z ? new File(str) : k.dK(str)).getAbsolutePath(), false, i2, i3, -1, -1, CI(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int aVY = 0;
                int aVZ = 0;
                int aWa = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aVY = i5 / 50;
                    }
                    this.aVZ += i4 - this.aWa;
                    this.aWa = i4;
                    if (handler != null) {
                        if (this.aVZ > this.aVY || i4 == i5) {
                            this.aVZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aVR.Dx().ajw = -10;
            this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aVR.Dx().ajw = -15;
            this.aVR.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aVR);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> Ca() {
        return this.aVR.Dw().Dz().aYz;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aVR.Dw().Dz().aYz != null) {
            this.aVR.Dw().Dz().aYz.clear();
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
        if (this.aVR.Dw().Dz().aYA == null) {
            this.aVR.Dw().Dz().aYA = new HashMap<>();
        }
        this.aVR.Dw().Dz().aYA.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aVR.Dw().Dz().aYz == null) {
                this.aVR.Dw().Dz().aYz = new ArrayList<>();
            }
            int c = c(this.aVR.Dw().Dz().aYz, basicNameValuePair.getName());
            int size = this.aVR.Dw().Dz().aYz.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aVR.Dw().Dz().aYz.get(c).getName())) {
                    this.aVR.Dw().Dz().aYz.set(c, basicNameValuePair);
                } else {
                    this.aVR.Dw().Dz().aYz.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aVR.Dw().Dz().aYz.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> CI() {
        if (this.aVR != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aVR.Dw().Dz().aYE)) {
                linkedList.add(new BasicNameValuePair("sid", this.aVR.Dw().Dz().aYE));
            }
            if (!com.baidu.tbadk.o.ad.nv() && !TextUtils.isEmpty(this.aVR.Dw().Dz().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aVR.Dw().Dz().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
