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
    private static int agm = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a agh;
    private com.baidu.adp.lib.network.a.a agn = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        uM();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.agh = aVar;
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
        if (this.agn != null) {
            this.agn.fs();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fo() {
        this.agn.cancel();
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
            if (this.agh.vK().vN().aiM != null && this.agh.vK().vN().aiM.size() > 0 && !this.agh.vK().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.agh.vK().vN().mUrl);
                if (this.agh.vK().vN().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.agh.vK().vN().mUrl.endsWith("?") && !this.agh.vK().vN().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.agh.vK().vN().aiM.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.agh.vK().vN().aiM.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.agh.vK().vN().aiM.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.agh.vK().vN().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.agh.vK().vN().aiO || this.agh.vK().vN().mIsBDImage) && !this.agh.vK().mIsFromCDN) {
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
        if (this.agn.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.agn.a(str, z, 5, 100, -1, -1, uW());
        com.baidu.adp.lib.network.http.e fG = this.agn.fG();
        if (fG == null) {
            return null;
        }
        gVar = fG.fz();
        if (fG != null) {
            try {
                if (fG.fA() != null && (size = fG.fA().size()) > 0) {
                    this.agh.vM().ais = fG.fA().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.agh.vL().vm = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais != null ? this.agh.vM().ais.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agh.vL().vm = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agh);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais != null ? this.agh.vM().ais.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agh.vL().vm = -12;
                TiebaStatic.net(this.agh);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais != null ? this.agh.vM().ais.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agh.vL().vm = -13;
                TiebaStatic.net(this.agh);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais != null ? this.agh.vM().ais.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agh.vL().vm = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agh);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.agh.vL().vm = gVar.responseCode;
        if (this.agh.vL().vm != 200) {
            this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.agh.vM().ais != null && !TextUtils.isEmpty(this.agh.vM().ais.uV)) {
                this.agh.vL().air = this.agh.vM().ais.uV;
            } else {
                this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS);
            }
            TiebaStatic.net(this.agh);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > agm) {
                    this.agh.vL().vm = -11;
                    TiebaStatic.net(this.agh);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.EA().fg(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.agh.vK().vN().mUrl + "], size:" + i2);
                            this.agh.vL().vm = -16;
                            TiebaStatic.net(this.agh);
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
        aVar.agB = this.agh.vM().ais.uQ;
        aVar.mTime = new Date().getTime() - j;
        aVar.agC = this.agh.vM().ais.uS;
        aVar.agA = 2;
        aa.a(aVar);
        aa.agz.set(this.agh.vM().ais.uS);
        TiebaStatic.net(this.agh);
        bArr = gVar == null ? gVar.vo : null;
        return bArr;
    }

    public void dL(String str) {
        this.agh.vL().aiq = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.agh.vL().aiq = errorData.getError_code();
                if (this.agh.vL().aiq == -1) {
                    this.agh.vL().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.agh.vL().aiq != 0) {
                    this.agh.vL().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.agh.vL().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ur() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uq = uq();
        if (uq == null || this.agh.vL().vm != 200) {
            return null;
        }
        try {
            this.agh.vK().vN().aiQ = TextUtils.isEmpty(this.agh.vK().vN().aiQ) ? "UTF-8" : this.agh.vK().vN().aiQ;
            str = new String(uq, 0, uq.length, this.agh.vK().vN().aiQ);
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
            if (this.agh.vK().vN().aiM == null || i2 >= this.agh.vK().vN().aiM.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.agh.vK().vN().aiM.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.agh.vK().vN().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.s.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.agn.isCanceled()) {
                return null;
            }
            if (this.agn.a(this.agh.vK().vN().mUrl, this.agh.vK().vN().aiM, this.agh.vK().vN().aiO, 5, -1, uW()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fG = this.agn.fG();
            if (fG == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fz = fG.fz();
            if (fG != null && fG.fA() != null && (size = fG.fA().size()) > 0) {
                this.agh.vM().ais = fG.fA().get(size - 1);
            }
            this.agh.vL().vm = fz.responseCode;
            this.agh.vL().mHeader = fz.vn;
            if (this.agh.vL().vm != 200) {
                if (this.agh.vM().ais != null && !TextUtils.isEmpty(this.agh.vM().ais.uV)) {
                    this.agh.vL().air = this.agh.vM().ais.uV;
                } else {
                    this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS);
                }
                TiebaStatic.net(this.agh);
                return null;
            } else if (this.agn.isCanceled()) {
                return null;
            } else {
                str = new String(fz.vo, "utf-8");
                try {
                    if (this.agh.vK().vN().mIsBaiduServer && this.agh.vK().vN().aiP) {
                        dL(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.hn());
                    aVar.agB = this.agh.vM().ais.uQ;
                    aVar.mTime = this.agh.vM().ais.uT;
                    aVar.agC = this.agh.vM().ais.uS;
                    aVar.agA = 1;
                    aa.a(aVar);
                    aa.agz.set(this.agh.vM().ais.uS);
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.agh.vL().vm = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.agh.vL().vm = -15;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.agh.vL().vm = -12;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.agh.vL().vm = -13;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.agh.vL().vm = -10;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.agh.vL().vm = -10;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.agh);
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
            if (this.agn.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.agn.a(this.agh.vK().vN().mUrl, this.agh.vK().vN().aiO, this.agh.vK().vN().aiM, this.agh.vK().vN().aiN, 5, -1, uW());
            this.agh.vL().vm = a.responseCode;
            this.agh.vL().mHeader = a.vn;
            if (this.agh.vL().vm != 200) {
                com.baidu.adp.lib.network.http.e fG = this.agn.fG();
                int i = 0;
                if (fG != null && fG.fA() != null) {
                    i = fG.fA().size();
                }
                if (i <= 0 || (dVar = fG.fA().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.uV;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.agh.vL().air = str2;
                } else {
                    this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS);
                }
                TiebaStatic.net(this.agh);
                return null;
            } else if (this.agn.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vo, "UTF-8");
                try {
                    dL(str);
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.agh.vL().air = String.valueOf(this.agh.vL().vm) + "|retryCount:" + (this.agh.vM().ais == null ? -1 : this.agh.vM().ais.uS) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.agh.vL().vm = -14;
                    return str;
                } catch (SocketException e5) {
                    this.agh.vL().vm = -12;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.agh.vL().vm = -13;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.agh.vL().vm = -10;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agh);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.agh.vL().vm = -15;
                    this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agh);
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
            if (this.agn.isCanceled()) {
                return false;
            }
            return this.agn.a(this.agh.vK().vN().mUrl, (z ? new File(str) : k.dp(str)).getAbsolutePath(), false, i2, i3, -1, -1, uW(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int ago = 0;
                int agp = 0;
                int agq = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.ago = i5 / 50;
                    }
                    this.agp += i4 - this.agq;
                    this.agq = i4;
                    if (handler != null) {
                        if (this.agp > this.ago || i4 == i5) {
                            this.agp = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.agh.vL().vm = -10;
            this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.agh.vL().vm = -15;
            this.agh.vL().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.agh);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> uo() {
        return this.agh.vK().vN().aiM;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.agh.vK().vN().aiM != null) {
            this.agh.vK().vN().aiM.clear();
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
        if (this.agh.vK().vN().aiN == null) {
            this.agh.vK().vN().aiN = new HashMap<>();
        }
        this.agh.vK().vN().aiN.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.agh.vK().vN().aiM == null) {
                this.agh.vK().vN().aiM = new ArrayList<>();
            }
            int c = c(this.agh.vK().vN().aiM, basicNameValuePair.getName());
            int size = this.agh.vK().vN().aiM.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.agh.vK().vN().aiM.get(c).getName())) {
                    this.agh.vK().vN().aiM.set(c, basicNameValuePair);
                } else {
                    this.agh.vK().vN().aiM.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.agh.vK().vN().aiM.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uW() {
        if (this.agh != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.agh.vK().vN().aiR)) {
                linkedList.add(new BasicNameValuePair("sid", this.agh.vK().vN().aiR));
            }
            if (!TextUtils.isEmpty(this.agh.vK().vN().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.agh.vK().vN().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
