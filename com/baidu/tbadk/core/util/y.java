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
    private static int ago = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a agj;
    private com.baidu.adp.lib.network.a.a agp = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        vi();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.agj = aVar;
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

    private void vi() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ft() {
        if (this.agp != null) {
            this.agp.ft();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void fp() {
        this.agp.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] uc() {
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
            if (this.agj.wf().wi().aiI != null && this.agj.wf().wi().aiI.size() > 0 && !this.agj.wf().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.agj.wf().wi().mUrl);
                if (this.agj.wf().wi().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.agj.wf().wi().mUrl.endsWith("?") && !this.agj.wf().wi().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.agj.wf().wi().aiI.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.agj.wf().wi().aiI.get(i).getName());
                    sb.append("=");
                    sb.append(am.aN(this.agj.wf().wi().aiI.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.agj.wf().wi().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.agj.wf().wi().aiK || this.agj.wf().wi().mIsBDImage) && !this.agj.wf().mIsFromCDN) {
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
        if (this.agp.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.agp.a(str, z, 5, 100, -1, -1, vs());
        com.baidu.adp.lib.network.http.e fH = this.agp.fH();
        if (fH == null) {
            return null;
        }
        gVar = fH.fA();
        if (fH != null) {
            try {
                if (fH.fB() != null && (size = fH.fB().size()) > 0) {
                    this.agj.wh().aio = fH.fB().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.agj.wg().vm = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio != null ? this.agj.wh().aio.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agj.wg().vm = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agj);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio != null ? this.agj.wh().aio.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agj.wg().vm = -12;
                TiebaStatic.net(this.agj);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio != null ? this.agj.wh().aio.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agj.wg().vm = -13;
                TiebaStatic.net(this.agj);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio != null ? this.agj.wh().aio.uS : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.agj.wg().vm = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.agj);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.agj.wg().vm = gVar.responseCode;
        if (this.agj.wg().vm != 200) {
            this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
            if (this.agj.wh().aio != null && !TextUtils.isEmpty(this.agj.wh().aio.uV)) {
                this.agj.wg().ain = this.agj.wh().aio.uV;
            } else {
                this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS);
            }
            TiebaStatic.net(this.agj);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ago) {
                    this.agj.wg().vm = -11;
                    TiebaStatic.net(this.agj);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Ev().eX(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.agj.wf().wi().mUrl + "], size:" + i2);
                            this.agj.wg().vm = -16;
                            TiebaStatic.net(this.agj);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.ho());
        aVar.agD = this.agj.wh().aio.uQ;
        aVar.mTime = new Date().getTime() - j;
        aVar.agE = this.agj.wh().aio.uS;
        aVar.agC = 2;
        aa.a(aVar);
        aa.agB.set(this.agj.wh().aio.uS);
        TiebaStatic.net(this.agj);
        bArr = gVar == null ? gVar.vo : null;
        return bArr;
    }

    public void dL(String str) {
        this.agj.wg().aim = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.agj.wg().aim = errorData.getError_code();
                if (this.agj.wg().aim == -1) {
                    this.agj.wg().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
                } else if (this.agj.wg().aim != 0) {
                    this.agj.wg().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.agj.wg().mErrorString = this.mContext.getString(d.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String uN() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uc = uc();
        if (uc == null || this.agj.wg().vm != 200) {
            return null;
        }
        try {
            this.agj.wf().wi().aiM = TextUtils.isEmpty(this.agj.wf().wi().aiM) ? "UTF-8" : this.agj.wf().wi().aiM;
            str = new String(uc, 0, uc.length, this.agj.wf().wi().aiM);
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
    public String uM() {
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
            if (this.agj.wf().wi().aiI == null || i2 >= this.agj.wf().wi().aiI.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.agj.wf().wi().aiI.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.agj.wf().wi().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.r.aS(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.agp.isCanceled()) {
                return null;
            }
            if (this.agp.a(this.agj.wf().wi().mUrl, this.agj.wf().wi().aiI, this.agj.wf().wi().aiK, 5, -1, vs()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e fH = this.agp.fH();
            if (fH == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g fA = fH.fA();
            if (fH != null && fH.fB() != null && (size = fH.fB().size()) > 0) {
                this.agj.wh().aio = fH.fB().get(size - 1);
            }
            this.agj.wg().vm = fA.responseCode;
            this.agj.wg().mHeader = fA.vn;
            if (this.agj.wg().vm != 200) {
                if (this.agj.wh().aio != null && !TextUtils.isEmpty(this.agj.wh().aio.uV)) {
                    this.agj.wg().ain = this.agj.wh().aio.uV;
                } else {
                    this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS);
                }
                TiebaStatic.net(this.agj);
                return null;
            } else if (this.agp.isCanceled()) {
                return null;
            } else {
                str = new String(fA.vo, "utf-8");
                try {
                    if (this.agj.wf().wi().mIsBaiduServer && this.agj.wf().wi().aiL) {
                        dL(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.ho());
                    aVar.agD = this.agj.wh().aio.uQ;
                    aVar.mTime = this.agj.wh().aio.uT;
                    aVar.agE = this.agj.wh().aio.uS;
                    aVar.agC = 1;
                    aa.a(aVar);
                    aa.agB.set(this.agj.wh().aio.uS);
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.agj.wg().vm = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.agj.wg().vm = -15;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.agj.wg().vm = -12;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.agj.wg().vm = -13;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.agj.wg().vm = -10;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.agj.wg().vm = -10;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.agj);
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
    public String uO() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.agp.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.agp.a(this.agj.wf().wi().mUrl, this.agj.wf().wi().aiK, this.agj.wf().wi().aiI, this.agj.wf().wi().aiJ, 5, -1, vs());
            this.agj.wg().vm = a.responseCode;
            this.agj.wg().mHeader = a.vn;
            if (this.agj.wg().vm != 200) {
                com.baidu.adp.lib.network.http.e fH = this.agp.fH();
                int i = 0;
                if (fH != null && fH.fB() != null) {
                    i = fH.fB().size();
                }
                if (i <= 0 || (dVar = fH.fB().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.uV;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.agj.wg().ain = str2;
                } else {
                    this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS);
                }
                TiebaStatic.net(this.agj);
                return null;
            } else if (this.agp.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.vo, "UTF-8");
                try {
                    dL(str);
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    this.agj.wg().ain = String.valueOf(this.agj.wg().vm) + "|retryCount:" + (this.agj.wh().aio == null ? -1 : this.agj.wh().aio.uS) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.agj.wg().vm = -14;
                    return str;
                } catch (SocketException e5) {
                    this.agj.wg().vm = -12;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.agj.wg().vm = -13;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror);
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.agj.wg().vm = -10;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.agj);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.agj.wg().vm = -15;
                    this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.agj);
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
            if (this.agp.isCanceled()) {
                return false;
            }
            return this.agp.a(this.agj.wf().wi().mUrl, (z ? new File(str) : k.dt(str)).getAbsolutePath(), false, i2, i3, -1, -1, vs(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int agq = 0;
                int agr = 0;
                int ags = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.agq = i5 / 50;
                    }
                    this.agr += i4 - this.ags;
                    this.ags = i4;
                    if (handler != null) {
                        if (this.agr > this.agq || i4 == i5) {
                            this.agr = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.agj.wg().vm = -10;
            this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.agj.wg().vm = -15;
            this.agj.wg().mErrorString = this.mContext.getResources().getString(d.l.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.agj);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> uL() {
        return this.agj.wf().wi().aiI;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void k(ArrayList<BasicNameValuePair> arrayList) {
        if (this.agj.wf().wi().aiI != null) {
            this.agj.wf().wi().aiI.clear();
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
        if (this.agj.wf().wi().aiJ == null) {
            this.agj.wf().wi().aiJ = new HashMap<>();
        }
        this.agj.wf().wi().aiJ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.agj.wf().wi().aiI == null) {
                this.agj.wf().wi().aiI = new ArrayList<>();
            }
            int b = b(this.agj.wf().wi().aiI, basicNameValuePair.getName());
            int size = this.agj.wf().wi().aiI.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.agj.wf().wi().aiI.get(b).getName())) {
                    this.agj.wf().wi().aiI.set(b, basicNameValuePair);
                } else {
                    this.agj.wf().wi().aiI.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.agj.wf().wi().aiI.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> vs() {
        if (this.agj != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.agj.wf().wi().aiN)) {
                linkedList.add(new BasicNameValuePair("sid", this.agj.wf().wi().aiN));
            }
            if (!TextUtils.isEmpty(this.agj.wf().wi().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.agj.wf().wi().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
