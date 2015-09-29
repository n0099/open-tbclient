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
import com.baidu.tieba.i;
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
public class x implements q {
    private static int ZW = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a ZR;
    private com.baidu.adp.lib.network.a.a ZX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public x(com.baidu.tbadk.core.util.a.a aVar) {
        ug();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.ZR = aVar;
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

    private void ug() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void gJ() {
        this.ZX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tH() {
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
            if (this.ZR.uX().va().aci != null && this.ZR.uX().va().aci.size() > 0 && !this.ZR.uX().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZR.uX().va().mUrl);
                if (this.ZR.uX().va().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZR.uX().va().mUrl.endsWith("?") && !this.ZR.uX().va().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZR.uX().va().aci.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZR.uX().va().aci.get(i).getName());
                    sb.append("=");
                    sb.append(ar.aR(this.ZR.uX().va().aci.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZR.uX().va().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZR.uX().va().ack || this.ZR.uX().va().mIsBDImage) && !this.ZR.uX().mIsFromCDN) {
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
        if (this.ZX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ZX.a(str, z, 5, 100, -1, -1, uo());
        com.baidu.adp.lib.network.http.e gX = this.ZX.gX();
        if (gX == null) {
            return null;
        }
        gVar = gX.gQ();
        if (gX != null) {
            try {
                if (gX.gR() != null && (size = gX.gR().size()) > 0) {
                    this.ZR.uZ().abR = gX.gR().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZR.uY().abO = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR != null ? this.ZR.uZ().abR.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZR.uY().abO = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR != null ? this.ZR.uZ().abR.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZR.uY().abO = -12;
                TiebaStatic.net(this.ZR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR != null ? this.ZR.uZ().abR.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZR.uY().abO = -13;
                TiebaStatic.net(this.ZR);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.ZR.uY().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR != null ? this.ZR.uZ().abR.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZR.uY().abO = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZR);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ZR.uY().abO = gVar.responseCode;
        if (this.ZR.uY().abO != 200) {
            this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
            if (this.ZR.uZ().abR != null && !TextUtils.isEmpty(this.ZR.uZ().abR.uR)) {
                this.ZR.uY().abQ = this.ZR.uZ().abR.uR;
            } else {
                this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO);
            }
            TiebaStatic.net(this.ZR);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ZW) {
                    this.ZR.uY().abO = -11;
                    TiebaStatic.net(this.ZR);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Cf().en(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZR.uX().va().mUrl + "], size:" + i2);
                            this.ZR.uY().abO = -16;
                            TiebaStatic.net(this.ZR);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iS());
        aVar.mSize = this.ZR.uZ().abR.uL;
        aVar.mTime = new Date().getTime() - j;
        aVar.aam = this.ZR.uZ().abR.uO;
        aVar.aal = 2;
        aa.a(aVar);
        aa.aak.set(this.ZR.uZ().abR.uO);
        TiebaStatic.net(this.ZR);
        bArr = gVar == null ? gVar.vf : null;
        return bArr;
    }

    public void de(String str) {
        this.ZR.uY().abP = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZR.uY().abP = errorData.getError_code();
                if (this.ZR.uY().abP == -1) {
                    this.ZR.uY().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
                } else if (this.ZR.uY().abP != 0) {
                    this.ZR.uY().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZR.uY().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tI() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tH = tH();
        if (tH == null || this.ZR.uY().abO != 200) {
            return null;
        }
        try {
            this.ZR.uX().va().acm = TextUtils.isEmpty(this.ZR.uX().va().acm) ? "UTF-8" : this.ZR.uX().va().acm;
            str = new String(tH, 0, tH.length, this.ZR.uX().va().acm);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            de(str);
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
    public String tG() {
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
            if (this.ZR.uX().va().aci == null || i2 >= this.ZR.uX().va().aci.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZR.uX().va().aci.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZR.uX().va().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.ZX.isCanceled()) {
                return null;
            }
            if (this.ZX.a(this.ZR.uX().va().mUrl, this.ZR.uX().va().aci, this.ZR.uX().va().ack, 5, -1, uo()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gX = this.ZX.gX();
            if (gX == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gQ = gX.gQ();
            if (gX != null && gX.gR() != null && (size = gX.gR().size()) > 0) {
                this.ZR.uZ().abR = gX.gR().get(size - 1);
            }
            this.ZR.uY().abO = gQ.responseCode;
            this.ZR.uY().mHeader = gQ.ve;
            if (this.ZR.uY().abO != 200) {
                if (this.ZR.uZ().abR != null && !TextUtils.isEmpty(this.ZR.uZ().abR.uR)) {
                    this.ZR.uY().abQ = this.ZR.uZ().abR.uR;
                } else {
                    this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO);
                }
                TiebaStatic.net(this.ZR);
                return null;
            } else if (this.ZX.isCanceled()) {
                return null;
            } else {
                str = new String(gQ.vf, "utf-8");
                try {
                    if (this.ZR.uX().va().mIsBaiduServer && this.ZR.uX().va().acl) {
                        de(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iS());
                    aVar.mSize = this.ZR.uZ().abR.uL;
                    aVar.mTime = this.ZR.uZ().abR.uP;
                    aVar.aam = this.ZR.uZ().abR.uO;
                    aVar.aal = 1;
                    aa.a(aVar);
                    aa.aak.set(this.ZR.uZ().abR.uO);
                    TiebaStatic.net(this.ZR);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZR.uY().abO = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.ZR.uY().abO = -15;
                    this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZR);
                    return str;
                } catch (SocketException e7) {
                    e4 = e7;
                    this.ZR.uY().abO = -12;
                    this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZR);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e3 = e8;
                    this.ZR.uY().abO = -13;
                    this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZR);
                    return str;
                } catch (Exception e9) {
                    e2 = e9;
                    this.ZR.uY().abO = -10;
                    this.ZR.uY().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZR);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZR.uY().abO = -10;
                    this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZR);
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

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                x.this.gJ();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [635=8] */
    @Override // com.baidu.tbadk.core.util.q
    public String tJ() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.ZX.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.ZX.a(this.ZR.uX().va().mUrl, this.ZR.uX().va().ack, this.ZR.uX().va().aci, this.ZR.uX().va().acj, 5, -1, uo());
                this.ZR.uY().abO = a2.responseCode;
                this.ZR.uY().mHeader = a2.ve;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.ZR.uY().abO != 200) {
                    com.baidu.adp.lib.network.http.e gX = this.ZX.gX();
                    int i = 0;
                    if (gX != null && gX.gR() != null) {
                        i = gX.gR().size();
                    }
                    String str2 = (i <= 0 || (dVar = gX.gR().get(i + (-1))) == null) ? "" : dVar.uR;
                    if (TextUtils.isEmpty(str2)) {
                        this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO);
                    } else {
                        this.ZR.uY().abQ = str2;
                    }
                    TiebaStatic.net(this.ZR);
                    return null;
                } else if (this.ZX.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.vf, "UTF-8");
                    try {
                        de(str);
                        TiebaStatic.net(this.ZR);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        this.ZR.uY().abQ = String.valueOf(String.valueOf(this.ZR.uY().abO)) + "|retryCount:" + (this.ZR.uZ().abR == null ? -1 : this.ZR.uZ().abR.uO) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ZR.uY().abO = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.ZR.uY().abO = -15;
                        this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ZR);
                        return str;
                    } catch (SocketException e6) {
                        this.ZR.uY().abO = -12;
                        this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZR);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.ZR.uY().abO = -13;
                        this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZR);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.ZR.uY().abO = -10;
                        this.ZR.uY().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e2.getMessage();
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ZR);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [695=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.ZX.isCanceled()) {
                return this.ZX.a(this.ZR.uX().va().mUrl, (z ? new File(str) : n.cN(str)).getAbsolutePath(), false, i2, i3, -1, -1, uo(), new y(this, handler, i), true);
            }
            TiebaStatic.net(this.ZR);
            return false;
        } catch (Exception e) {
            this.ZR.uY().abO = -10;
            this.ZR.uY().mErrorString = String.valueOf(this.mContext.getResources().getString(i.h.neterror)) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZR.uY().abO = -15;
            this.ZR.uY().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZR);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> tF() {
        return this.ZR.uX().va().aci;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZR.uX().va().aci != null) {
            this.ZR.uX().va().aci.clear();
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
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.ZR.uX().va().acj == null) {
            this.ZR.uX().va().acj = new HashMap<>();
        }
        this.ZR.uX().va().acj.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZR.uX().va().aci == null) {
                this.ZR.uX().va().aci = new ArrayList<>();
            }
            int b = b(this.ZR.uX().va().aci, basicNameValuePair.getName());
            int size = this.ZR.uX().va().aci.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.ZR.uX().va().aci.get(b).getName())) {
                    this.ZR.uX().va().aci.set(b, basicNameValuePair);
                } else {
                    this.ZR.uX().va().aci.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.ZR.uX().va().aci.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uo() {
        if (this.ZR != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZR.uX().va().acn)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZR.uX().va().acn));
            }
            if (!TextUtils.isEmpty(this.ZR.uX().va().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZR.uX().va().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
