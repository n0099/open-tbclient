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
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ab implements s {
    private static int US = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private final com.baidu.tbadk.core.util.httpNet.a UM;
    private com.baidu.adp.lib.network.a.a UT = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public ab(com.baidu.tbadk.core.util.httpNet.a aVar) {
        sW();
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
        this.UM = aVar;
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

    private void sW() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void gS() {
        this.UT.cancel();
        try {
            int cU = af.cU(this.UM.tS().tV().mUrl);
            if (cU > 0) {
                af.th().m(cU, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [335=12] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0454 -> B:100:0x0455). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] sx() {
        com.baidu.adp.lib.network.http.g gVar;
        byte[] bArr;
        String str;
        int size;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.a.a.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            int cU = af.cU(this.UM.tS().tV().mUrl);
            if (cU > 0) {
                af.th().bZ(cU);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.UM.tS().tV().Xb == null || this.UM.tS().tV().Xb.size() <= 0 || this.UM.tS().mIsFromCDN) {
                    str = this.UM.tS().tV().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.UM.tS().tV().mUrl);
                    if (this.UM.tS().tV().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.UM.tS().tV().mUrl.endsWith("?") && !this.UM.tS().tV().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.UM.tS().tV().Xb.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.UM.tS().tV().Xb.get(i).getName());
                        sb.append("=");
                        sb.append(bb.aV(this.UM.tS().tV().Xb.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.UM.tS().tV().Xd || this.UM.tS().tV().mIsBDImage) && !this.UM.tS().mIsFromCDN) {
                    z = false;
                }
            } finally {
                af.cV(this.UM.tS().tV().mUrl);
            }
        } catch (BdHttpCancelException e2) {
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
        } catch (OutOfMemoryError e6) {
            e = e6;
            gVar = null;
        }
        if (this.UT.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.UT.a(str, z, 5, 100, -1, -1, te());
        com.baidu.adp.lib.network.http.e hf = this.UT.hf();
        if (hf == null) {
            return null;
        }
        gVar = hf.gZ();
        if (hf != null) {
            try {
                if (hf.ha() != null && (size = hf.ha().size()) > 0) {
                    this.UM.tU().WK = hf.ha().get(size - 1);
                }
            } catch (BdHttpCancelException e7) {
                e = e7;
                this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK != null ? this.UM.tU().WK.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.UM.tT().WH = -14;
                af.cV(this.UM.tS().tV().mUrl);
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.memoryerror);
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU) + "|" + e.getClass() + "|" + e.getMessage();
                this.UM.tT().WH = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.UM);
                af.cV(this.UM.tS().tV().mUrl);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK != null ? this.UM.tU().WK.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.UM.tT().WH = -12;
                TiebaStatic.net(this.UM);
                af.cV(this.UM.tS().tV().mUrl);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK != null ? this.UM.tU().WK.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.UM.tT().WH = -13;
                TiebaStatic.net(this.UM);
                af.cV(this.UM.tS().tV().mUrl);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e11) {
                e = e11;
                this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK != null ? this.UM.tU().WK.uU : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.UM.tT().WH = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.UM);
                af.cV(this.UM.tS().tV().mUrl);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            af.cV(this.UM.tS().tV().mUrl);
            return null;
        }
        this.UM.tT().WH = gVar.responseCode;
        if (this.UM.tT().WH != 200) {
            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
            if (this.UM.tU().WK == null || TextUtils.isEmpty(this.UM.tU().WK.uX)) {
                this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU);
            } else {
                this.UM.tT().WJ = this.UM.tU().WK.uX;
            }
            TiebaStatic.net(this.UM);
            af.cV(this.UM.tS().tV().mUrl);
            return null;
        }
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > US) {
                    this.UM.tT().WH = -11;
                    TiebaStatic.net(this.UM);
                    af.cV(this.UM.tS().tV().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.Am().dN(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.UM.tS().tV().mUrl + "], size:" + i2);
                            this.UM.tT().WH = -16;
                            TiebaStatic.net(this.UM);
                            af.cV(this.UM.tS().tV().mUrl);
                            af.cV(this.UM.tS().tV().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aj ajVar = new aj();
        ajVar.mMode = getMode(com.baidu.adp.lib.util.k.jc());
        ajVar.mSize = this.UM.tU().WK.uR;
        ajVar.mTime = new Date().getTime() - j;
        ajVar.Vm = this.UM.tU().WK.uU;
        ajVar.Vl = 2;
        ai.a(ajVar);
        ai.Vk.set(this.UM.tU().WK.uU);
        TiebaStatic.net(this.UM);
        af.cV(this.UM.tS().tV().mUrl);
        bArr = gVar == null ? gVar.vk : null;
        return bArr;
    }

    public void cT(String str) {
        this.UM.tT().WI = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.UM.tT().WI = errorData.getError_code();
                if (this.UM.tT().WI == -1) {
                    this.UM.tT().mErrorString = this.mContext.getString(com.baidu.tieba.t.error_unkown_try_again);
                } else if (this.UM.tT().WI != 0) {
                    this.UM.tT().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.UM.tT().mErrorString = this.mContext.getString(com.baidu.tieba.t.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String sy() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] sx = sx();
        if (sx == null || this.UM.tT().WH != 200) {
            return null;
        }
        try {
            this.UM.tS().tV().Xf = TextUtils.isEmpty(this.UM.tS().tV().Xf) ? "UTF-8" : this.UM.tS().tV().Xf;
            str = new String(sx, 0, sx.length, this.UM.tS().tV().Xf);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cT(str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [565=12] */
    @Override // com.baidu.tbadk.core.util.s
    public String sw() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException e5;
        int size;
        StringBuilder sb = new StringBuilder(1024);
        try {
            int cU = af.cU(this.UM.tS().tV().mUrl);
            if (cU > 0) {
                af.th().bZ(cU);
            }
        } catch (Exception e6) {
            BdLog.e(e6.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.UM.tS().tV().Xb == null || i2 >= this.UM.tS().tV().Xb.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.UM.tS().tV().Xb.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.UM.tS().tV().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o(SapiUtils.KEY_QR_LOGIN_SIGN, com.baidu.adp.lib.util.ac.toMd5(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.UT.isCanceled()) {
                    af.cV(this.UM.tS().tV().mUrl);
                    return null;
                } else if (this.UT.a(this.UM.tS().tV().mUrl, this.UM.tS().tV().Xb, this.UM.tS().tV().Xd, 5, -1, te()) == null) {
                    throw new BdHttpCancelException();
                } else {
                    com.baidu.adp.lib.network.http.e hf = this.UT.hf();
                    if (hf == null) {
                        return null;
                    }
                    com.baidu.adp.lib.network.http.g gZ = hf.gZ();
                    if (hf != null && hf.ha() != null && (size = hf.ha().size()) > 0) {
                        this.UM.tU().WK = hf.ha().get(size - 1);
                    }
                    this.UM.tT().WH = gZ.responseCode;
                    this.UM.tT().mHeader = gZ.vj;
                    if (this.UM.tT().WH != 200) {
                        if (this.UM.tU().WK == null || TextUtils.isEmpty(this.UM.tU().WK.uX)) {
                            this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU);
                        } else {
                            this.UM.tT().WJ = this.UM.tU().WK.uX;
                        }
                        TiebaStatic.net(this.UM);
                        af.cV(this.UM.tS().tV().mUrl);
                        return null;
                    } else if (this.UT.isCanceled()) {
                        af.cV(this.UM.tS().tV().mUrl);
                        return null;
                    } else {
                        str = new String(gZ.vk, "utf-8");
                        try {
                            if (this.UM.tS().tV().mIsBaiduServer && this.UM.tS().tV().Xe) {
                                cT(str);
                            }
                            aj ajVar = new aj();
                            ajVar.mMode = getMode(com.baidu.adp.lib.util.k.jc());
                            ajVar.mSize = this.UM.tU().WK.uR;
                            ajVar.mTime = this.UM.tU().WK.uV;
                            ajVar.Vm = this.UM.tU().WK.uU;
                            ajVar.Vl = 1;
                            ai.a(ajVar);
                            ai.Vk.set(this.UM.tU().WK.uU);
                            TiebaStatic.net(this.UM);
                            return str;
                        } catch (BdHttpCancelException e7) {
                            e5 = e7;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                            this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU) + "|" + e5.getClass() + "|" + e5.getMessage();
                            this.UM.tT().WH = -14;
                            return str;
                        } catch (Exception e8) {
                            e = e8;
                            this.UM.tT().WH = -10;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                            BdLog.e(e.getMessage());
                            TiebaStatic.net(this.UM);
                            return str;
                        } catch (OutOfMemoryError e9) {
                            e4 = e9;
                            this.UM.tT().WH = -15;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.memoryerror);
                            BdLog.e(e4.getMessage());
                            TiebaStatic.net(this.UM);
                            return str;
                        } catch (SocketException e10) {
                            e3 = e10;
                            this.UM.tT().WH = -12;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                            BdLog.e(e3.getMessage());
                            TiebaStatic.net(this.UM);
                            return str;
                        } catch (SocketTimeoutException e11) {
                            e2 = e11;
                            this.UM.tT().WH = -13;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                            BdLog.e(e2.getMessage());
                            TiebaStatic.net(this.UM);
                            return str;
                        } catch (Throwable th2) {
                            th = th2;
                            this.UM.tT().WH = -10;
                            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                            BdLog.e(th.getMessage());
                            TiebaStatic.net(this.UM);
                            return str;
                        }
                    }
                }
            } finally {
                af.cV(this.UM.tS().tV().mUrl);
            }
        } catch (BdHttpCancelException e12) {
            e5 = e12;
            str = null;
        } catch (OutOfMemoryError e13) {
            e4 = e13;
            str = null;
        } catch (SocketException e14) {
            e3 = e14;
            str = null;
        } catch (SocketTimeoutException e15) {
            e2 = e15;
            str = null;
        } catch (Exception e16) {
            e = e16;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [671=8] */
    @Override // com.baidu.tbadk.core.util.s
    public String sz() {
        OutOfMemoryError e;
        String str;
        Exception e2;
        BdHttpCancelException e3;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            try {
                if (this.UT.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.http.g a = this.UT.a(this.UM.tS().tV().mUrl, this.UM.tS().tV().Xd, this.UM.tS().tV().Xb, this.UM.tS().tV().Xc, 5, -1, te());
                this.UM.tT().WH = a.responseCode;
                this.UM.tT().mHeader = a.vj;
                new Timer().schedule(new ad(this, null), 45000L);
                if (this.UM.tT().WH != 200) {
                    com.baidu.adp.lib.network.http.e hf = this.UT.hf();
                    int i = 0;
                    if (hf != null && hf.ha() != null) {
                        i = hf.ha().size();
                    }
                    String str2 = (i <= 0 || (dVar = hf.ha().get(i + (-1))) == null) ? "" : dVar.uX;
                    if (TextUtils.isEmpty(str2)) {
                        this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU);
                    } else {
                        this.UM.tT().WJ = str2;
                    }
                    TiebaStatic.net(this.UM);
                    return null;
                } else if (this.UT.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a.vk, "UTF-8");
                    try {
                        cT(str);
                        TiebaStatic.net(this.UM);
                        return str;
                    } catch (BdHttpCancelException e4) {
                        e3 = e4;
                        this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                        this.UM.tT().WJ = String.valueOf(String.valueOf(this.UM.tT().WH)) + "|retryCount:" + (this.UM.tU().WK == null ? -1 : this.UM.tU().WK.uU) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.UM.tT().WH = -14;
                        return str;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        this.UM.tT().WH = -15;
                        this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.UM);
                        return str;
                    } catch (SocketException e6) {
                        this.UM.tT().WH = -12;
                        this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                        TiebaStatic.net(this.UM);
                        return str;
                    } catch (SocketTimeoutException e7) {
                        this.UM.tT().WH = -13;
                        this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                        TiebaStatic.net(this.UM);
                        return str;
                    } catch (Exception e8) {
                        e2 = e8;
                        this.UM.tT().WH = -10;
                        this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.UM);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new ad(this, null), 0L);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [731=5] */
    @Override // com.baidu.tbadk.core.util.s
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.UT.isCanceled()) {
                return this.UT.a(this.UM.tS().tV().mUrl, (z ? new File(str) : o.cE(str)).getAbsolutePath(), false, i2, i3, -1, -1, te(), new ac(this, handler, i), true);
            }
            TiebaStatic.net(this.UM);
            return false;
        } catch (Exception e) {
            this.UM.tT().WH = -10;
            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.UM.tT().WH = -15;
            this.UM.tT().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.t.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.UM);
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> sv() {
        return this.UM.tS().tV().Xb;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void n(ArrayList<BasicNameValuePair> arrayList) {
        if (this.UM.tS().tV().Xb != null) {
            this.UM.tS().tV().Xb.clear();
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

    @Override // com.baidu.tbadk.core.util.s
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void d(String str, byte[] bArr) {
        if (this.UM.tS().tV().Xc == null) {
            this.UM.tS().tV().Xc = new HashMap<>();
        }
        this.UM.tS().tV().Xc.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.UM.tS().tV().Xb == null) {
                this.UM.tS().tV().Xb = new ArrayList<>();
            }
            int b = b(this.UM.tS().tV().Xb, basicNameValuePair.getName());
            int size = this.UM.tS().tV().Xb.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.UM.tS().tV().Xb.get(b).getName())) {
                    this.UM.tS().tV().Xb.set(b, basicNameValuePair);
                } else {
                    this.UM.tS().tV().Xb.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.UM.tS().tV().Xb.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> te() {
        if (this.UM != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.UM.tS().tV().WE)) {
                linkedList.add(new BasicNameValuePair("sid", this.UM.tS().tV().WE));
            }
            if (!TextUtils.isEmpty(this.UM.tS().tV().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.UM.tS().tV().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
