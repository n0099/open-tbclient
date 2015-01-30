package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.willdelete.BdHttpErrorException;
import com.baidu.adp.lib.util.BdLog;
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
public class ag implements v {
    private static int IF = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    protected final com.baidu.adp.lib.network.willdelete.a IL = new com.baidu.adp.lib.network.willdelete.a();
    private final com.baidu.tbadk.core.util.httpNet.c Iz;
    private Context mContext;

    public ag(com.baidu.tbadk.core.util.httpNet.c cVar) {
        oY();
        this.mContext = TbadkCoreApplication.m255getInst().getApp();
        this.Iz = cVar;
        com.baidu.adp.lib.network.willdelete.e.dV().setUserAgent("bdtb for Android " + TbConfig.getVersion());
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

    private void oY() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.v
    public boolean ox() {
        return this.IL.isCanceled();
    }

    @Override // com.baidu.tbadk.core.util.v
    public void dJ() {
        this.IL.cancel();
        try {
            int cA = al.cA(this.Iz.qg().qj().mUrl);
            if (cA > 0) {
                al.po().o(cA, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [404=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x040d -> B:87:0x040e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] oz() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.dV().setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            int cA = al.cA(this.Iz.qg().qj().mUrl);
            if (cA > 0) {
                al.po().bV(cA);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            try {
                if (this.Iz.qg().qj().KO == null || this.Iz.qg().qj().KO.size() <= 0 || this.Iz.qg().mIsFromCDN) {
                    str = this.Iz.qg().qj().mUrl;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.Iz.qg().qj().mUrl);
                    if (this.Iz.qg().qj().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.Iz.qg().qj().mUrl.endsWith("?") && !this.Iz.qg().qj().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.Iz.qg().qj().KO.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.Iz.qg().qj().KO.get(i).getName());
                        sb.append("=");
                        sb.append(bf.aE(this.Iz.qg().qj().KO.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.Iz.qg().qj().KQ || this.Iz.qg().qj().mIsBDImage) && !this.Iz.qg().mIsFromCDN) {
                    z = false;
                }
            } finally {
                al.cB(this.Iz.qg().qj().mUrl);
            }
        } catch (BdHttpCancelException e2) {
            e = e2;
            fVar = null;
        } catch (BdHttpErrorException e3) {
            e = e3;
            fVar = null;
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            fVar = null;
        } catch (SocketException e6) {
            e = e6;
            fVar = null;
        } catch (SocketTimeoutException e7) {
            e = e7;
            fVar = null;
        }
        if (this.IL.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.dV().a(str, z, 5, 100, -1, new ah(this), this.IL, pk());
        if (fVar != null) {
            try {
                if (fVar.la != null) {
                    this.Iz.qi().la = fVar.la;
                }
            } catch (BdHttpCancelException e8) {
                e = e8;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = -14;
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e9) {
                e = e9;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = e.getHttpResponseCode();
                TiebaStatic.net(this.Iz);
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iz);
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.Iz);
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = -12;
                TiebaStatic.net(this.Iz);
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.Iz.qh().KB = -13;
                TiebaStatic.net(this.Iz);
                al.cB(this.Iz.qg().qj().mUrl);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            al.cB(this.Iz.qg().qj().mUrl);
            return null;
        }
        this.Iz.qh().KB = fVar.kY;
        if (this.Iz.qh().KB != 200) {
            this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry);
            TiebaStatic.net(this.Iz);
            al.cB(this.Iz.qg().qj().mUrl);
            return null;
        }
        if (TbadkCoreApplication.m255getInst().isMainProcess(true) && (str2 = fVar.kZ) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > IF) {
                    this.Iz.qh().KB = -11;
                    TiebaStatic.net(this.Iz);
                    al.cB(this.Iz.qg().qj().mUrl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.we().dx(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.Iz.qg().qj().mUrl + "], size:" + i2);
                            this.Iz.qh().KB = -16;
                            TiebaStatic.net(this.Iz);
                            al.cB(this.Iz.qg().qj().mUrl);
                            al.cB(this.Iz.qg().qj().mUrl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ap apVar = new ap();
        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fk());
        apVar.mSize = this.Iz.qi().la.kq;
        apVar.mTime = new Date().getTime() - j;
        apVar.Jf = this.Iz.qi().la.retry;
        apVar.Je = 2;
        ao.a(apVar);
        ao.Jd.set(this.Iz.qi().la.retry);
        TiebaStatic.net(this.Iz);
        al.cB(this.Iz.qg().qj().mUrl);
        if (fVar != null) {
            this.Iz.qg().qj().KS = fVar.charset;
            bArr = fVar.data;
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void cz(String str) {
        this.Iz.qh().KC = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.Iz.qh().KC = errorData.getError_code();
                if (this.Iz.qh().KC == -1) {
                    this.Iz.qh().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
                } else if (this.Iz.qh().KC != 0) {
                    this.Iz.qh().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.Iz.qh().mErrorString = this.mContext.getString(com.baidu.tieba.z.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public String oA() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] oz = oz();
        if (oz == null || this.Iz.qh().KB != 200) {
            return null;
        }
        try {
            this.Iz.qg().qj().KS = TextUtils.isEmpty(this.Iz.qg().qj().KS) ? "UTF-8" : this.Iz.qg().qj().KS;
            str = new String(oz, 0, oz.length, this.Iz.qg().qj().KS);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            cz(str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=12] */
    @Override // com.baidu.tbadk.core.util.v
    public String oy() {
        Throwable th;
        String str;
        OutOfMemoryError e;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        BdHttpErrorException e5;
        BdHttpCancelException e6;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int cA = al.cA(this.Iz.qg().qj().mUrl);
            if (cA > 0) {
                al.po().bV(cA);
            }
        } catch (Exception e7) {
            BdLog.e(e7.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.Iz.qg().qj().KO == null || i2 >= this.Iz.qg().qj().KO.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.Iz.qg().qj().KO.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(bf.aE(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.Iz.qg().qj().mIsBaiduServer) {
            sb2.append("tiebaclient!!!");
            String md5 = com.baidu.adp.lib.util.z.toMd5(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(md5);
        }
        String sb3 = sb.toString();
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.IL.isCanceled()) {
                    al.cB(this.Iz.qg().qj().mUrl);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.dV().a(this.Iz.qg().qj().mUrl, sb3.getBytes(), this.Iz.qg().qj().KQ, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.IL, pk());
                if (a == null) {
                    throw new BdHttpCancelException();
                }
                if (a.la != null) {
                    this.Iz.qi().la = a.la;
                }
                this.Iz.qh().KB = a.kY;
                if (this.Iz.qh().KB != 200) {
                    this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry);
                    TiebaStatic.net(this.Iz);
                    al.cB(this.Iz.qg().qj().mUrl);
                    return null;
                } else if (this.IL.isCanceled()) {
                    al.cB(this.Iz.qg().qj().mUrl);
                    return null;
                } else {
                    str = new String(a.data, "utf-8");
                    try {
                        if (this.Iz.qg().qj().mIsBaiduServer && this.Iz.qg().qj().KR) {
                            cz(str);
                        }
                        ap apVar = new ap();
                        apVar.mMode = getMode(com.baidu.adp.lib.util.i.fk());
                        apVar.mSize = this.Iz.qi().la.kq;
                        apVar.mTime = this.Iz.qi().la.kt;
                        apVar.Jf = this.Iz.qi().la.retry;
                        apVar.Je = 1;
                        ao.a(apVar);
                        ao.Jd.set(this.Iz.qi().la.retry);
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (BdHttpCancelException e8) {
                        e6 = e8;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.Iz.qh().KB = -14;
                        return str;
                    } catch (BdHttpErrorException e9) {
                        e5 = e9;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.Iz.qh().KB = e5.getHttpResponseCode();
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        this.Iz.qh().KB = -15;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.Iz.qh().KB = -12;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (SocketTimeoutException e12) {
                        e3 = e12;
                        this.Iz.qh().KB = -13;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (Exception e13) {
                        e2 = e13;
                        this.Iz.qh().KB = -10;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.Iz.qh().KB = -10;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    }
                }
            } finally {
                al.cB(this.Iz.qg().qj().mUrl);
            }
        } catch (BdHttpCancelException e14) {
            e6 = e14;
            str = null;
        } catch (BdHttpErrorException e15) {
            e5 = e15;
            str = null;
        } catch (SocketException e16) {
            e4 = e16;
            str = null;
        } catch (SocketTimeoutException e17) {
            e3 = e17;
            str = null;
        } catch (Exception e18) {
            e2 = e18;
            str = null;
        } catch (OutOfMemoryError e19) {
            e = e19;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [734=9] */
    @Override // com.baidu.tbadk.core.util.v
    public String oB() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        BdHttpErrorException e3;
        BdHttpCancelException e4;
        try {
            try {
                if (this.IL.isCanceled()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.f b = com.baidu.adp.lib.network.willdelete.e.dV().b(this.Iz.qg().qj().mUrl, this.Iz.qg().qj().KQ, this.Iz.qg().qj().KO, this.Iz.qg().qj().KP, 5, -1, null, this.IL, null, pk());
                this.Iz.qh().KB = b.kY;
                new Timer().schedule(new aj(this, null), 45000L);
                if (this.Iz.qh().KB != 200) {
                    this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry);
                    TiebaStatic.net(this.Iz);
                    return null;
                } else if (this.IL.isCanceled()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(b.data, b.charset);
                    try {
                        cz(str);
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (BdHttpCancelException e5) {
                        e4 = e5;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la != null ? this.Iz.qi().la.retry : -1) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.Iz.qh().KB = -14;
                        return str;
                    } catch (BdHttpErrorException e6) {
                        e3 = e6;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        this.Iz.qh().KD = String.valueOf(String.valueOf(this.Iz.qh().KB)) + "|retryCount:" + (this.Iz.qi().la == null ? -1 : this.Iz.qi().la.retry) + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Iz.qh().KB = e3.getHttpResponseCode();
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                        this.Iz.qh().KB = -15;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (SocketException e8) {
                        this.Iz.qh().KB = -12;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (SocketTimeoutException e9) {
                        this.Iz.qh().KB = -13;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        TiebaStatic.net(this.Iz);
                        return str;
                    } catch (Exception e10) {
                        e2 = e10;
                        this.Iz.qh().KB = -10;
                        this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.Iz);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new aj(this, null), 0L);
            }
        } catch (BdHttpCancelException e11) {
            e4 = e11;
            str = null;
        } catch (BdHttpErrorException e12) {
            e3 = e12;
            str = null;
        } catch (Exception e13) {
            e2 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            str = null;
        } catch (SocketException e15) {
            str = null;
        } catch (SocketTimeoutException e16) {
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [815=5] */
    @Override // com.baidu.tbadk.core.util.v
    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        try {
            if (!this.IL.isCanceled()) {
                return com.baidu.adp.lib.network.willdelete.e.dV().a(this.Iz.qg().qj().mUrl, (z ? new File(str) : s.ck(str)).getAbsolutePath(), false, i2, i3, -1, new ai(this, handler, i), this.IL, pk());
            }
            TiebaStatic.net(this.Iz);
            return false;
        } catch (Exception e) {
            this.Iz.qh().KB = -10;
            this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.neterror);
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.Iz.qh().KB = -15;
            this.Iz.qh().mErrorString = this.mContext.getResources().getString(com.baidu.tieba.z.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.Iz);
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public ArrayList<BasicNameValuePair> ow() {
        return this.Iz.qg().qj().KO;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.Iz.qg().qj().KO != null) {
            this.Iz.qg().qj().KO.clear();
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

    @Override // com.baidu.tbadk.core.util.v
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.v
    public void g(String str, byte[] bArr) {
        if (this.Iz.qg().qj().KP == null) {
            this.Iz.qg().qj().KP = new HashMap<>();
        }
        this.Iz.qg().qj().KP.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.Iz.qg().qj().KO == null) {
                this.Iz.qg().qj().KO = new ArrayList<>();
            }
            int b = b(this.Iz.qg().qj().KO, basicNameValuePair.getName());
            int size = this.Iz.qg().qj().KO.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.Iz.qg().qj().KO.get(b).getName())) {
                    this.Iz.qg().qj().KO.set(b, basicNameValuePair);
                } else {
                    this.Iz.qg().qj().KO.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.Iz.qg().qj().KO.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> pk() {
        if (this.Iz != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.Iz.qg().qj().Ky)) {
                linkedList.add(new BasicNameValuePair("sid", this.Iz.qg().qj().Ky));
            }
            if (!TextUtils.isEmpty(this.Iz.qg().qj().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.Iz.qg().qj().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
