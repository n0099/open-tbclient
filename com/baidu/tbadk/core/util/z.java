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
    private static int apW = 2097152;
    private final com.baidu.tbadk.core.util.a.a apR;
    private com.baidu.adp.lib.network.a.a apX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public z(com.baidu.tbadk.core.util.a.a aVar) {
        yW();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.apR = aVar;
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

    private void yW() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hP() {
        if (this.apX != null) {
            this.apX.hP();
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hN() {
        this.apX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] yA() {
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
            if (this.apR.zX().Aa().asN != null && this.apR.zX().Aa().asN.size() > 0 && !this.apR.zX().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.apR.zX().Aa().mUrl);
                if (this.apR.zX().Aa().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.apR.zX().Aa().mUrl.endsWith("?") && !this.apR.zX().Aa().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.apR.zX().Aa().asN.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.apR.zX().Aa().asN.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bg(this.apR.zX().Aa().asN.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.apR.zX().Aa().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.apR.zX().Aa().asP || this.apR.zX().Aa().mIsBDImage) && !this.apR.zX().mIsFromCDN) {
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
        if (this.apX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.apX.a(str, z, 5, 100, -1, -1, zg());
        com.baidu.adp.lib.network.http.e id = this.apX.id();
        if (id == null) {
            return null;
        }
        gVar = id.hW();
        if (id != null) {
            try {
                if (id.hX() != null && (size = id.hX().size()) > 0) {
                    this.apR.zZ().ast = id.hX().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.apR.zY().zZ = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast != null ? this.apR.zZ().ast.zF : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apR.zY().zZ = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.apR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast != null ? this.apR.zZ().ast.zF : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apR.zY().zZ = -12;
                TiebaStatic.net(this.apR);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast != null ? this.apR.zZ().ast.zF : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apR.zY().zZ = -13;
                TiebaStatic.net(this.apR);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast != null ? this.apR.zZ().ast.zF : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apR.zY().zZ = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.apR);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.apR.zY().zZ = gVar.responseCode;
        if (this.apR.zY().zZ != 200) {
            this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
            if (this.apR.zZ().ast != null && !TextUtils.isEmpty(this.apR.zZ().ast.zI)) {
                this.apR.zY().ass = this.apR.zZ().ast.zI;
            } else {
                this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF);
            }
            TiebaStatic.net(this.apR);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > apW) {
                    this.apR.zY().zZ = -11;
                    TiebaStatic.net(this.apR);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.IV().fd(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.apR.zX().Aa().mUrl + "], size:" + i2);
                            this.apR.zY().zZ = -16;
                            TiebaStatic.net(this.apR);
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
        aVar.aqm = this.apR.zZ().ast.zD;
        aVar.mTime = new Date().getTime() - j;
        aVar.aqn = this.apR.zZ().ast.zF;
        aVar.aql = 2;
        ab.a(aVar);
        ab.aqk.set(this.apR.zZ().ast.zF);
        TiebaStatic.net(this.apR);
        bArr = gVar == null ? gVar.Ab : null;
        return bArr;
    }

    public void eE(String str) {
        this.apR.zY().asr = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.apR.zY().asr = errorData.getError_code();
                if (this.apR.zY().asr == -1) {
                    this.apR.zY().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
                } else if (this.apR.zY().asr != 0) {
                    this.apR.zY().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.apR.zY().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public String yB() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] yA = yA();
        if (yA == null || this.apR.zY().zZ != 200) {
            return null;
        }
        try {
            this.apR.zX().Aa().asR = TextUtils.isEmpty(this.apR.zX().Aa().asR) ? "UTF-8" : this.apR.zX().Aa().asR;
            str = new String(yA, 0, yA.length, this.apR.zX().Aa().asR);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eE(str);
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
    public String yz() {
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
            if (this.apR.zX().Aa().asN == null || i2 >= this.apR.zX().Aa().asN.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.apR.zX().Aa().asN.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.apR.zX().Aa().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", com.baidu.adp.lib.util.s.bl(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.apX.isCanceled()) {
                return null;
            }
            if (this.apX.a(this.apR.zX().Aa().mUrl, this.apR.zX().Aa().asN, this.apR.zX().Aa().asP, 5, -1, zg()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e id = this.apX.id();
            if (id == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g hW = id.hW();
            if (id != null && id.hX() != null && (size = id.hX().size()) > 0) {
                this.apR.zZ().ast = id.hX().get(size - 1);
            }
            this.apR.zY().zZ = hW.responseCode;
            this.apR.zY().mHeader = hW.Aa;
            if (this.apR.zY().zZ != 200) {
                if (this.apR.zZ().ast != null && !TextUtils.isEmpty(this.apR.zZ().ast.zI)) {
                    this.apR.zY().ass = this.apR.zZ().ast.zI;
                } else {
                    this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF);
                }
                TiebaStatic.net(this.apR);
                return null;
            } else if (this.apX.isCanceled()) {
                return null;
            } else {
                str = new String(hW.Ab, IoUtils.UTF_8);
                try {
                    if (this.apR.zX().Aa().mIsBaiduServer && this.apR.zX().Aa().asQ) {
                        eE(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jJ());
                    aVar.aqm = this.apR.zZ().ast.zD;
                    aVar.mTime = this.apR.zZ().ast.zG;
                    aVar.aqn = this.apR.zZ().ast.zF;
                    aVar.aql = 1;
                    ab.a(aVar);
                    ab.aqk.set(this.apR.zZ().ast.zF);
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.apR.zY().zZ = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.apR.zY().zZ = -15;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.apR.zY().zZ = -12;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.apR.zY().zZ = -13;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.apR.zY().zZ = -10;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.apR.zY().zZ = -10;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.apR);
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
    public String yC() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.apX.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.apX.a(this.apR.zX().Aa().mUrl, this.apR.zX().Aa().asP, this.apR.zX().Aa().asN, this.apR.zX().Aa().asO, 5, -1, zg());
            this.apR.zY().zZ = a.responseCode;
            this.apR.zY().mHeader = a.Aa;
            if (this.apR.zY().zZ != 200) {
                com.baidu.adp.lib.network.http.e id = this.apX.id();
                int i = 0;
                if (id != null && id.hX() != null) {
                    i = id.hX().size();
                }
                if (i <= 0 || (dVar = id.hX().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.zI;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.apR.zY().ass = str2;
                } else {
                    this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF);
                }
                TiebaStatic.net(this.apR);
                return null;
            } else if (this.apX.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Ab, "UTF-8");
                try {
                    eE(str);
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.apR.zY().ass = String.valueOf(this.apR.zY().zZ) + "|retryCount:" + (this.apR.zZ().ast == null ? -1 : this.apR.zZ().ast.zF) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.apR.zY().zZ = -14;
                    return str;
                } catch (SocketException e5) {
                    this.apR.zY().zZ = -12;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.apR.zY().zZ = -13;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.apR.zY().zZ = -10;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.apR);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.apR.zY().zZ = -15;
                    this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.apR);
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
            if (this.apX.isCanceled()) {
                return false;
            }
            return this.apX.a(this.apR.zX().Aa().mUrl, (z ? new File(str) : l.ef(str)).getAbsolutePath(), false, i2, i3, -1, -1, zg(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.z.1
                int apY = 0;
                int apZ = 0;
                int aqa = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.apY = i5 / 50;
                    }
                    this.apZ += i4 - this.aqa;
                    this.aqa = i4;
                    if (handler != null) {
                        if (this.apZ > this.apY || i4 == i5) {
                            this.apZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.apR.zY().zZ = -10;
            this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.apR.zY().zZ = -15;
            this.apR.zY().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.apR);
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> yy() {
        return this.apR.zX().Aa().asN;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.apR.zX().Aa().asN != null) {
            this.apR.zX().Aa().asN.clear();
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
        if (this.apR.zX().Aa().asO == null) {
            this.apR.zX().Aa().asO = new HashMap<>();
        }
        this.apR.zX().Aa().asO.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.apR.zX().Aa().asN == null) {
                this.apR.zX().Aa().asN = new ArrayList<>();
            }
            int c = c(this.apR.zX().Aa().asN, basicNameValuePair.getName());
            int size = this.apR.zX().Aa().asN.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.apR.zX().Aa().asN.get(c).getName())) {
                    this.apR.zX().Aa().asN.set(c, basicNameValuePair);
                } else {
                    this.apR.zX().Aa().asN.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.apR.zX().Aa().asN.add(c, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> zg() {
        if (this.apR != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.apR.zX().Aa().asS)) {
                linkedList.add(new BasicNameValuePair("sid", this.apR.zX().Aa().asS));
            }
            if (!com.baidu.tbadk.o.ag.ip() && !TextUtils.isEmpty(this.apR.zX().Aa().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.apR.zX().Aa().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
