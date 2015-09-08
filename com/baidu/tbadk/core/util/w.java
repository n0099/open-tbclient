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
public class w implements q {
    private static int aac = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.a.a ZX;
    private com.baidu.adp.lib.network.a.a aad = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public w(com.baidu.tbadk.core.util.a.a aVar) {
        ui();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.ZX = aVar;
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

    private void ui() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void gJ() {
        this.aad.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0391 -> B:91:0x0392). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] tJ() {
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
            if (this.ZX.uZ().vc().acj != null && this.ZX.uZ().vc().acj.size() > 0 && !this.ZX.uZ().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ZX.uZ().vc().mUrl);
                if (this.ZX.uZ().vc().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ZX.uZ().vc().mUrl.endsWith("?") && !this.ZX.uZ().vc().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ZX.uZ().vc().acj.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ZX.uZ().vc().acj.get(i).getName());
                    sb.append("=");
                    sb.append(aq.aR(this.ZX.uZ().vc().acj.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ZX.uZ().vc().mUrl;
            }
            TbConfig.getDebugSwitch();
            if ((!this.ZX.uZ().vc().acl || this.ZX.uZ().vc().mIsBDImage) && !this.ZX.uZ().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            gVar2 = null;
        } catch (Exception e2) {
            e = e2;
            gVar = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            gVar = null;
        } catch (SocketException e4) {
            e = e4;
            gVar = null;
        } catch (SocketTimeoutException e5) {
            e = e5;
            gVar = null;
        }
        if (this.aad.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.aad.a(str, z, 5, 100, -1, -1, uq());
        com.baidu.adp.lib.network.http.e gW = this.aad.gW();
        if (gW == null) {
            return null;
        }
        gVar = gW.gQ();
        if (gW != null) {
            try {
                if (gW.gR() != null && (size = gW.gR().size()) > 0) {
                    this.ZX.vb().abS = gW.gR().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ZX.va().abP = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS != null ? this.ZX.vb().abS.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abP = -12;
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS != null ? this.ZX.vb().abS.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abP = -13;
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS != null ? this.ZX.vb().abS.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abP = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS != null ? this.ZX.vb().abS.uO : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ZX.va().abP = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ZX);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.ZX.va().abP = gVar.responseCode;
        if (this.ZX.va().abP != 200) {
            this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
            if (this.ZX.vb().abS != null && !TextUtils.isEmpty(this.ZX.vb().abS.uR)) {
                this.ZX.va().abR = this.ZX.vb().abS.uR;
            } else {
                this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO);
            }
            TiebaStatic.net(this.ZX);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aac) {
                    this.ZX.va().abP = -11;
                    TiebaStatic.net(this.ZX);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.c.Cs().em(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ZX.uZ().vc().mUrl + "], size:" + i2);
                            this.ZX.va().abP = -16;
                            TiebaStatic.net(this.ZX);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        z.a aVar = new z.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.i.iR());
        aVar.mSize = this.ZX.vb().abS.uL;
        aVar.mTime = new Date().getTime() - j;
        aVar.aas = this.ZX.vb().abS.uO;
        aVar.aar = 2;
        z.a(aVar);
        z.aaq.set(this.ZX.vb().abS.uO);
        TiebaStatic.net(this.ZX);
        bArr = gVar == null ? gVar.ve : null;
        return bArr;
    }

    public void db(String str) {
        this.ZX.va().abQ = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ZX.va().abQ = errorData.getError_code();
                if (this.ZX.va().abQ == -1) {
                    this.ZX.va().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
                } else if (this.ZX.va().abQ != 0) {
                    this.ZX.va().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ZX.va().mErrorString = this.mContext.getString(i.h.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String tK() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] tJ = tJ();
        if (tJ == null || this.ZX.va().abP != 200) {
            return null;
        }
        try {
            this.ZX.uZ().vc().acn = TextUtils.isEmpty(this.ZX.uZ().vc().acn) ? "UTF-8" : this.ZX.uZ().vc().acn;
            str = new String(tJ, 0, tJ.length, this.ZX.uZ().vc().acn);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            db(str);
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
    public String tI() {
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
            if (this.ZX.uZ().vc().acj == null || i2 >= this.ZX.uZ().vc().acj.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ZX.uZ().vc().acj.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ZX.uZ().vc().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.t.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            if (this.aad.isCanceled()) {
                return null;
            }
            if (this.aad.a(this.ZX.uZ().vc().mUrl, this.ZX.uZ().vc().acj, this.ZX.uZ().vc().acl, 5, -1, uq()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e gW = this.aad.gW();
            if (gW == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g gQ = gW.gQ();
            if (gW != null && gW.gR() != null && (size = gW.gR().size()) > 0) {
                this.ZX.vb().abS = gW.gR().get(size - 1);
            }
            this.ZX.va().abP = gQ.responseCode;
            this.ZX.va().mHeader = gQ.vd;
            if (this.ZX.va().abP != 200) {
                if (this.ZX.vb().abS != null && !TextUtils.isEmpty(this.ZX.vb().abS.uR)) {
                    this.ZX.va().abR = this.ZX.vb().abS.uR;
                } else {
                    this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO);
                }
                TiebaStatic.net(this.ZX);
                return null;
            } else if (this.aad.isCanceled()) {
                return null;
            } else {
                str = new String(gQ.ve, "utf-8");
                try {
                    if (this.ZX.uZ().vc().mIsBaiduServer && this.ZX.uZ().vc().acm) {
                        db(str);
                    }
                    z.a aVar = new z.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.i.iR());
                    aVar.mSize = this.ZX.vb().abS.uL;
                    aVar.mTime = this.ZX.vb().abS.uP;
                    aVar.aas = this.ZX.vb().abS.uO;
                    aVar.aar = 1;
                    z.a(aVar);
                    z.aaq.set(this.ZX.vb().abS.uO);
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ZX.va().abP = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ZX.va().abP = -15;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ZX.va().abP = -12;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ZX.va().abP = -13;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ZX.va().abP = -10;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ZX);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ZX.va().abP = -10;
                    this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ZX);
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

    /* loaded from: classes.dex */
    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                w.this.gJ();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [635=8] */
    @Override // com.baidu.tbadk.core.util.q
    public String tL() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.aad.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a2 = this.aad.a(this.ZX.uZ().vc().mUrl, this.ZX.uZ().vc().acl, this.ZX.uZ().vc().acj, this.ZX.uZ().vc().ack, 5, -1, uq());
                this.ZX.va().abP = a2.responseCode;
                this.ZX.va().mHeader = a2.vd;
                new Timer().schedule(new a(this, null), 45000L);
                if (this.ZX.va().abP != 200) {
                    com.baidu.adp.lib.network.http.e gW = this.aad.gW();
                    int i = 0;
                    if (gW != null && gW.gR() != null) {
                        i = gW.gR().size();
                    }
                    String str2 = (i <= 0 || (dVar = gW.gR().get(i + (-1))) == null) ? "" : dVar.uR;
                    if (TextUtils.isEmpty(str2)) {
                        this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO);
                    } else {
                        this.ZX.va().abR = str2;
                    }
                    TiebaStatic.net(this.ZX);
                    return null;
                } else if (this.aad.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a2.ve, "UTF-8");
                    try {
                        db(str);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        this.ZX.va().abR = String.valueOf(String.valueOf(this.ZX.va().abP)) + "|retryCount:" + (this.ZX.vb().abS == null ? -1 : this.ZX.vb().abS.uO) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.ZX.va().abP = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.ZX.va().abP = -15;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (SocketException e6) {
                        this.ZX.va().abP = -12;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.ZX.va().abP = -13;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        TiebaStatic.net(this.ZX);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.ZX.va().abP = -10;
                        this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.ZX);
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
            if (!this.aad.isCanceled()) {
                return this.aad.a(this.ZX.uZ().vc().mUrl, (z ? new File(str) : n.cL(str)).getAbsolutePath(), false, i2, i3, -1, -1, uq(), new x(this, handler, i), true);
            }
            TiebaStatic.net(this.ZX);
            return false;
        } catch (Exception e) {
            this.ZX.va().abP = -10;
            this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ZX.va().abP = -15;
            this.ZX.va().mErrorString = this.mContext.getResources().getString(i.h.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ZX);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> tH() {
        return this.ZX.uZ().vc().acj;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ZX.uZ().vc().acj != null) {
            this.ZX.uZ().vc().acj.clear();
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
        if (this.ZX.uZ().vc().ack == null) {
            this.ZX.uZ().vc().ack = new HashMap<>();
        }
        this.ZX.uZ().vc().ack.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ZX.uZ().vc().acj == null) {
                this.ZX.uZ().vc().acj = new ArrayList<>();
            }
            int b = b(this.ZX.uZ().vc().acj, basicNameValuePair.getName());
            int size = this.ZX.uZ().vc().acj.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.ZX.uZ().vc().acj.get(b).getName())) {
                    this.ZX.uZ().vc().acj.set(b, basicNameValuePair);
                } else {
                    this.ZX.uZ().vc().acj.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.ZX.uZ().vc().acj.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> uq() {
        if (this.ZX != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ZX.uZ().vc().aco)) {
                linkedList.add(new BasicNameValuePair("sid", this.ZX.uZ().vc().aco));
            }
            if (!TextUtils.isEmpty(this.ZX.uZ().vc().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ZX.uZ().vc().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
