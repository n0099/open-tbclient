package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ab;
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
public class z implements r {
    private static int apx = 2097152;
    private final com.baidu.tbadk.core.util.a.a aps;
    private com.baidu.adp.lib.network.a.a apy = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public z(com.baidu.tbadk.core.util.a.a aVar) {
        yI();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.aps = aVar;
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

    private void yI() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hP() {
        if (this.apy != null) {
            this.apy.hP();
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hN() {
        this.apy.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ym() {
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
            if (this.aps.zI().zL().ask != null && this.aps.zI().zL().ask.size() > 0 && !this.aps.zI().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aps.zI().zL().mUrl);
                if (this.aps.zI().zL().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aps.zI().zL().mUrl.endsWith("?") && !this.aps.zI().zL().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aps.zI().zL().ask.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aps.zI().zL().ask.get(i).getName());
                    sb.append("=");
                    sb.append(ao.be(this.aps.zI().zL().ask.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aps.zI().zL().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aps.zI().zL().asm || this.aps.zI().zL().mIsBDImage) && !this.aps.zI().mIsFromCDN) {
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
        if (this.apy.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.apy.a(str, z, 5, 100, -1, -1, yS());
        com.baidu.adp.lib.network.http.e id = this.apy.id();
        if (id == null) {
            return null;
        }
        gVar = id.hW();
        if (id != null) {
            try {
                if (id.hX() != null && (size = id.hX().size()) > 0) {
                    this.aps.zK().arQ = id.hX().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aps.zJ().Ab = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ != null ? this.aps.zK().arQ.zH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zJ().Ab = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aps);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ != null ? this.aps.zK().arQ.zH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zJ().Ab = -12;
                TiebaStatic.net(this.aps);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ != null ? this.aps.zK().arQ.zH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zJ().Ab = -13;
                TiebaStatic.net(this.aps);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ != null ? this.aps.zK().arQ.zH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zJ().Ab = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aps);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.aps.zJ().Ab = gVar.responseCode;
        if (this.aps.zJ().Ab != 200) {
            this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
            if (this.aps.zK().arQ != null && !TextUtils.isEmpty(this.aps.zK().arQ.zK)) {
                this.aps.zJ().arP = this.aps.zK().arQ.zK;
            } else {
                this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH);
            }
            TiebaStatic.net(this.aps);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > apx) {
                    this.aps.zJ().Ab = -11;
                    TiebaStatic.net(this.aps);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.ID().fc(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aps.zI().zL().mUrl + "], size:" + i2);
                            this.aps.zJ().Ab = -16;
                            TiebaStatic.net(this.aps);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ab.a aVar = new ab.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.jJ());
        aVar.apN = this.aps.zK().arQ.zF;
        aVar.mTime = new Date().getTime() - j;
        aVar.apO = this.aps.zK().arQ.zH;
        aVar.apM = 2;
        ab.a(aVar);
        ab.apL.set(this.aps.zK().arQ.zH);
        TiebaStatic.net(this.aps);
        bArr = gVar == null ? gVar.Ae : null;
        return bArr;
    }

    public void eB(String str) {
        this.aps.zJ().arO = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aps.zJ().arO = errorData.getError_code();
                if (this.aps.zJ().arO == -1) {
                    this.aps.zJ().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
                } else if (this.aps.zJ().arO != 0) {
                    this.aps.zJ().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aps.zJ().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public String yn() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ym = ym();
        if (ym == null || this.aps.zJ().Ab != 200) {
            return null;
        }
        try {
            this.aps.zI().zL().aso = TextUtils.isEmpty(this.aps.zI().zL().aso) ? "UTF-8" : this.aps.zI().zL().aso;
            str = new String(ym, 0, ym.length, this.aps.zI().zL().aso);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eB(str);
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

    @Override // com.baidu.tbadk.core.util.r
    public String yl() {
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
            if (this.aps.zI().zL().ask == null || i2 >= this.aps.zI().zL().ask.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aps.zI().zL().ask.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aps.zI().zL().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bj(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.apy.isCanceled()) {
                return null;
            }
            if (this.apy.a(this.aps.zI().zL().mUrl, this.aps.zI().zL().ask, this.aps.zI().zL().asm, 5, -1, yS()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e id = this.apy.id();
            if (id == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g hW = id.hW();
            if (id != null && id.hX() != null && (size = id.hX().size()) > 0) {
                this.aps.zK().arQ = id.hX().get(size - 1);
            }
            this.aps.zJ().Ab = hW.responseCode;
            this.aps.zJ().mHeader = hW.Ac;
            if (this.aps.zJ().Ab != 200) {
                if (this.aps.zK().arQ != null && !TextUtils.isEmpty(this.aps.zK().arQ.zK)) {
                    this.aps.zJ().arP = this.aps.zK().arQ.zK;
                } else {
                    this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH);
                }
                TiebaStatic.net(this.aps);
                return null;
            } else if (this.apy.isCanceled()) {
                return null;
            } else {
                str = new String(hW.Ae, IoUtils.UTF_8);
                try {
                    if (this.aps.zI().zL().mIsBaiduServer && this.aps.zI().zL().asn) {
                        eB(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jJ());
                    aVar.apN = this.aps.zK().arQ.zF;
                    aVar.mTime = this.aps.zK().arQ.zI;
                    aVar.apO = this.aps.zK().arQ.zH;
                    aVar.apM = 1;
                    ab.a(aVar);
                    ab.apL.set(this.aps.zK().arQ.zH);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aps.zJ().Ab = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aps.zJ().Ab = -15;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aps.zJ().Ab = -12;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aps.zJ().Ab = -13;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aps.zJ().Ab = -10;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aps.zJ().Ab = -10;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aps);
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

    @Override // com.baidu.tbadk.core.util.r
    public String yo() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.apy.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.apy.a(this.aps.zI().zL().mUrl, this.aps.zI().zL().asm, this.aps.zI().zL().ask, this.aps.zI().zL().asl, 5, -1, yS());
            this.aps.zJ().Ab = a.responseCode;
            this.aps.zJ().mHeader = a.Ac;
            if (this.aps.zJ().Ab != 200) {
                com.baidu.adp.lib.network.http.e id = this.apy.id();
                int i = 0;
                if (id != null && id.hX() != null) {
                    i = id.hX().size();
                }
                if (i <= 0 || (dVar = id.hX().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.zK;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.aps.zJ().arP = str2;
                } else {
                    this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH);
                }
                TiebaStatic.net(this.aps);
                return null;
            } else if (this.apy.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Ae, "UTF-8");
                try {
                    eB(str);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.aps.zJ().arP = String.valueOf(this.aps.zJ().Ab) + "|retryCount:" + (this.aps.zK().arQ == null ? -1 : this.aps.zK().arQ.zH) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aps.zJ().Ab = -14;
                    return str;
                } catch (SocketException e5) {
                    this.aps.zJ().Ab = -12;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.aps.zJ().Ab = -13;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.aps.zJ().Ab = -10;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.aps.zJ().Ab = -15;
                    this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aps);
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
    @Override // com.baidu.tbadk.core.util.r
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.apy.isCanceled()) {
                return false;
            }
            return this.apy.a(this.aps.zI().zL().mUrl, (z ? new File(str) : l.ec(str)).getAbsolutePath(), false, i2, i3, -1, -1, yS(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.z.1
                int apz = 0;
                int apA = 0;
                int apB = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.apz = i5 / 50;
                    }
                    this.apA += i4 - this.apB;
                    this.apB = i4;
                    if (handler != null) {
                        if (this.apA > this.apz || i4 == i5) {
                            this.apA = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aps.zJ().Ab = -10;
            this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aps.zJ().Ab = -15;
            this.aps.zJ().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aps);
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> yk() {
        return this.aps.zI().zL().ask;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aps.zI().zL().ask != null) {
            this.aps.zI().zL().ask.clear();
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

    @Override // com.baidu.tbadk.core.util.r
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void d(String str, byte[] bArr) {
        if (this.aps.zI().zL().asl == null) {
            this.aps.zI().zL().asl = new HashMap<>();
        }
        this.aps.zI().zL().asl.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aps.zI().zL().ask == null) {
                this.aps.zI().zL().ask = new ArrayList<>();
            }
            int c = c(this.aps.zI().zL().ask, basicNameValuePair.getName());
            int size = this.aps.zI().zL().ask.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aps.zI().zL().ask.get(c).getName())) {
                    this.aps.zI().zL().ask.set(c, basicNameValuePair);
                } else {
                    this.aps.zI().zL().ask.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aps.zI().zL().ask.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> yS() {
        if (this.aps != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aps.zI().zL().asp)) {
                linkedList.add(new BasicNameValuePair("sid", this.aps.zI().zL().asp));
            }
            if (!com.baidu.tbadk.o.af.ip() && !TextUtils.isEmpty(this.aps.zI().zL().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aps.zI().zL().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
