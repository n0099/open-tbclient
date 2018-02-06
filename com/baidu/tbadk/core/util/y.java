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
    private static int aWg = 2097152;
    private final com.baidu.tbadk.core.util.a.a aWb;
    private com.baidu.adp.lib.network.a.a aWh = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        Cy();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aWb = aVar;
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
        if (this.aWh != null) {
            this.aWh.mV();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mS() {
        this.aWh.cancel();
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
            if (this.aWb.Dw().Dz().aYJ != null && this.aWb.Dw().Dz().aYJ.size() > 0 && !this.aWb.Dw().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aWb.Dw().Dz().mUrl);
                if (this.aWb.Dw().Dz().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aWb.Dw().Dz().mUrl.endsWith("?") && !this.aWb.Dw().Dz().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aWb.Dw().Dz().aYJ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aWb.Dw().Dz().aYJ.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aWb.Dw().Dz().aYJ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aWb.Dw().Dz().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aWb.Dw().Dz().aYL || this.aWb.Dw().Dz().mIsBDImage) && !this.aWb.Dw().mIsFromCDN) {
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
        if (this.aWh.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aWh.a(str, z, 5, 100, -1, -1, CI());
        com.baidu.adp.lib.network.http.e nj = this.aWh.nj();
        if (nj == null) {
            return null;
        }
        gVar = nj.nc();
        if (nj != null) {
            try {
                if (nj.nd() != null && (size = nj.nd().size()) > 0) {
                    this.aWb.Dy().aYp = nj.nd().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aWb.Dx().ajC = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aWb);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -12;
                TiebaStatic.net(this.aWb);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -13;
                TiebaStatic.net(this.aWb);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aWb);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aWb.Dx().ajC = gVar.responseCode;
        if (this.aWb.Dx().ajC != 200) {
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aWb.Dy().aYp != null && !TextUtils.isEmpty(this.aWb.Dy().aYp.ajl)) {
                this.aWb.Dx().aYo = this.aWb.Dy().aYp.ajl;
            } else {
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
            }
            TiebaStatic.net(this.aWb);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aWg) {
                    this.aWb.Dx().ajC = -11;
                    TiebaStatic.net(this.aWb);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mx().hY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aWb.Dw().Dz().mUrl + "], size:" + i2);
                            this.aWb.Dx().ajC = -16;
                            TiebaStatic.net(this.aWb);
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
        aVar.aWw = this.aWb.Dy().aYp.ajg;
        aVar.mTime = new Date().getTime() - j;
        aVar.aWx = this.aWb.Dy().aYp.aji;
        aVar.aWv = 2;
        aa.a(aVar);
        aa.aWu.set(this.aWb.Dy().aYp.aji);
        TiebaStatic.net(this.aWb);
        bArr = gVar == null ? gVar.ajE : null;
        return bArr;
    }

    public void ej(String str) {
        this.aWb.Dx().aYn = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aWb.Dx().aYn = errorData.getError_code();
                if (this.aWb.Dx().aYn == -1) {
                    this.aWb.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aWb.Dx().aYn != 0) {
                    this.aWb.Dx().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aWb.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Cd() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] Cc = Cc();
        if (Cc == null || this.aWb.Dx().ajC != 200) {
            return null;
        }
        try {
            this.aWb.Dw().Dz().aYN = TextUtils.isEmpty(this.aWb.Dw().Dz().aYN) ? "UTF-8" : this.aWb.Dw().Dz().aYN;
            str = new String(Cc, 0, Cc.length, this.aWb.Dw().Dz().aYN);
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
            if (this.aWb.Dw().Dz().aYJ == null || i2 >= this.aWb.Dw().Dz().aYJ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aWb.Dw().Dz().aYJ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aWb.Dw().Dz().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", com.baidu.adp.lib.util.s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.aWh.isCanceled()) {
                return null;
            }
            if (this.aWh.a(this.aWb.Dw().Dz().mUrl, this.aWb.Dw().Dz().aYJ, this.aWb.Dw().Dz().aYL, 5, -1, CI()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e nj = this.aWh.nj();
            if (nj == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g nc = nj.nc();
            if (nj != null && nj.nd() != null && (size = nj.nd().size()) > 0) {
                this.aWb.Dy().aYp = nj.nd().get(size - 1);
            }
            this.aWb.Dx().ajC = nc.responseCode;
            this.aWb.Dx().mHeader = nc.ajD;
            if (this.aWb.Dx().ajC != 200) {
                if (this.aWb.Dy().aYp != null && !TextUtils.isEmpty(this.aWb.Dy().aYp.ajl)) {
                    this.aWb.Dx().aYo = this.aWb.Dy().aYp.ajl;
                } else {
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
                }
                TiebaStatic.net(this.aWb);
                return null;
            } else if (this.aWh.isCanceled()) {
                return null;
            } else {
                str = new String(nc.ajE, "utf-8");
                try {
                    if (this.aWb.Dw().Dz().mIsBaiduServer && this.aWb.Dw().Dz().aYM) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWw = this.aWb.Dy().aYp.ajg;
                    aVar.mTime = this.aWb.Dy().aYp.ajj;
                    aVar.aWx = this.aWb.Dy().aYp.aji;
                    aVar.aWv = 1;
                    aa.a(aVar);
                    aa.aWu.set(this.aWb.Dy().aYp.aji);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aWb.Dx().ajC = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aWb.Dx().ajC = -15;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aWb.Dx().ajC = -12;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aWb.Dx().ajC = -13;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aWb);
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
            if (this.aWh.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.aWh.a(this.aWb.Dw().Dz().mUrl, this.aWb.Dw().Dz().aYL, this.aWb.Dw().Dz().aYJ, this.aWb.Dw().Dz().aYK, 5, -1, CI());
            this.aWb.Dx().ajC = a.responseCode;
            this.aWb.Dx().mHeader = a.ajD;
            if (this.aWb.Dx().ajC != 200) {
                com.baidu.adp.lib.network.http.e nj = this.aWh.nj();
                int i = 0;
                if (nj != null && nj.nd() != null) {
                    i = nj.nd().size();
                }
                if (i <= 0 || (dVar = nj.nd().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.ajl;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aWb.Dx().aYo = str2;
                } else {
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
                }
                TiebaStatic.net(this.aWb);
                return null;
            } else if (this.aWh.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.ajE, "UTF-8");
                try {
                    ej(str);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aWb.Dx().ajC = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aWb.Dx().ajC = -12;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aWb.Dx().ajC = -13;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aWb.Dx().ajC = -15;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aWb);
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
            if (this.aWh.isCanceled()) {
                return false;
            }
            return this.aWh.a(this.aWb.Dw().Dz().mUrl, (z ? new File(str) : k.dK(str)).getAbsolutePath(), false, i2, i3, -1, -1, CI(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int aWi = 0;
                int aWj = 0;
                int aWk = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aWi = i5 / 50;
                    }
                    this.aWj += i4 - this.aWk;
                    this.aWk = i4;
                    if (handler != null) {
                        if (this.aWj > this.aWi || i4 == i5) {
                            this.aWj = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aWb.Dx().ajC = -10;
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aWb.Dx().ajC = -15;
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aWb);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> Ca() {
        return this.aWb.Dw().Dz().aYJ;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aWb.Dw().Dz().aYJ != null) {
            this.aWb.Dw().Dz().aYJ.clear();
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
        if (this.aWb.Dw().Dz().aYK == null) {
            this.aWb.Dw().Dz().aYK = new HashMap<>();
        }
        this.aWb.Dw().Dz().aYK.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aWb.Dw().Dz().aYJ == null) {
                this.aWb.Dw().Dz().aYJ = new ArrayList<>();
            }
            int c = c(this.aWb.Dw().Dz().aYJ, basicNameValuePair.getName());
            int size = this.aWb.Dw().Dz().aYJ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aWb.Dw().Dz().aYJ.get(c).getName())) {
                    this.aWb.Dw().Dz().aYJ.set(c, basicNameValuePair);
                } else {
                    this.aWb.Dw().Dz().aYJ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aWb.Dw().Dz().aYJ.add(c, basicNameValuePair);
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
        if (this.aWb != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aWb.Dw().Dz().aYO)) {
                linkedList.add(new BasicNameValuePair("sid", this.aWb.Dw().Dz().aYO));
            }
            if (!com.baidu.tbadk.o.ad.nv() && !TextUtils.isEmpty(this.aWb.Dw().Dz().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aWb.Dw().Dz().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
