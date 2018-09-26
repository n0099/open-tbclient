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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.StringU;
import com.baidu.tieba.e;
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
    private static int arW = 2097152;
    private final com.baidu.tbadk.core.util.a.a arQ;
    private com.baidu.adp.lib.network.a.a arX = new com.baidu.adp.lib.network.a.a();
    private Context mContext;

    public y(com.baidu.tbadk.core.util.a.a aVar) {
        zQ();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.arQ = aVar;
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

    private void zQ() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void iW() {
        if (this.arX != null) {
            this.arX.iW();
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void iT() {
        this.arX.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x03aa -> B:95:0x03ab). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] zu() {
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
            if (this.arQ.AP().AS().auP != null && this.arQ.AP().AS().auP.size() > 0 && !this.arQ.AP().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.arQ.AP().AS().mUrl);
                if (this.arQ.AP().AS().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.arQ.AP().AS().mUrl.endsWith("?") && !this.arQ.AP().AS().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.arQ.AP().AS().auP.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.arQ.AP().AS().auP.get(i).getName());
                    sb.append("=");
                    sb.append(ao.by(this.arQ.AP().AS().auP.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.arQ.AP().AS().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.arQ.AP().AS().auR || this.arQ.AP().AS().mIsBDImage) && !this.arQ.AP().mIsFromCDN) {
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
        if (this.arX.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.arX.a(str, z, 5, 100, -1, -1, Aa());
        com.baidu.adp.lib.network.http.e jk = this.arX.jk();
        if (jk == null) {
            return null;
        }
        gVar = jk.jd();
        if (jk != null) {
            try {
                if (jk.je() != null && (size = jk.je().size()) > 0) {
                    this.arQ.AR().auv = jk.je().get(size - 1);
                }
            } catch (BdHttpCancelException e6) {
                gVar2 = gVar;
                bdHttpCancelException = e6;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.arQ.AQ().Cq = -14;
                gVar = gVar2;
                if (gVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.arQ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -12;
                TiebaStatic.net(this.arQ);
                if (gVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -13;
                TiebaStatic.net(this.arQ);
                if (gVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.arQ);
                if (gVar == null) {
                }
                return bArr;
            }
        }
        if (gVar == null) {
            return null;
        }
        this.arQ.AQ().Cq = gVar.responseCode;
        if (this.arQ.AQ().Cq != 200) {
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.arQ.AR().auv != null && !TextUtils.isEmpty(this.arQ.AR().auv.BZ)) {
                this.arQ.AQ().auu = this.arQ.AR().auv.BZ;
            } else {
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
            }
            TiebaStatic.net(this.arQ);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = gVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > arW) {
                    this.arQ.AQ().Cq = -11;
                    TiebaStatic.net(this.arQ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Kg().fp(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.arQ.AP().AS().mUrl + "], size:" + i2);
                            this.arQ.AQ().Cq = -16;
                            TiebaStatic.net(this.arQ);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.kQ());
        aVar.asm = this.arQ.AR().auv.BU;
        aVar.mTime = new Date().getTime() - j;
        aVar.asn = this.arQ.AR().auv.BW;
        aVar.asl = 2;
        aa.a(aVar);
        aa.ask.set(this.arQ.AR().auv.BW);
        TiebaStatic.net(this.arQ);
        bArr = gVar == null ? gVar.Cs : null;
        return bArr;
    }

    public void eU(String str) {
        this.arQ.AQ().aut = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.arQ.AQ().aut = errorData.getError_code();
                if (this.arQ.AQ().aut == -1) {
                    this.arQ.AQ().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.arQ.AQ().aut != 0) {
                    this.arQ.AQ().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.arQ.AQ().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String zv() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] zu = zu();
        if (zu == null || this.arQ.AQ().Cq != 200) {
            return null;
        }
        try {
            this.arQ.AP().AS().auT = TextUtils.isEmpty(this.arQ.AP().AS().auT) ? "UTF-8" : this.arQ.AP().AS().auT;
            str = new String(zu, 0, zu.length, this.arQ.AP().AS().auT);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eU(str);
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
    public String zt() {
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
            if (this.arQ.AP().AS().auP == null || i2 >= this.arQ.AP().AS().auP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.arQ.AP().AS().auP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.arQ.AP().AS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            u("sign", com.baidu.adp.lib.util.s.bD(sb.toString()));
            if (this.arQ.AP().arT) {
                u("sig", StringU.iB(sb.toString()));
            }
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.arX.isCanceled()) {
                return null;
            }
            if (this.arX.a(this.arQ.AP().AS().mUrl, this.arQ.AP().AS().auP, this.arQ.AP().AS().auR, 5, -1, Aa()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.e jk = this.arX.jk();
            if (jk == null) {
                return null;
            }
            com.baidu.adp.lib.network.http.g jd = jk.jd();
            if (jk != null && jk.je() != null && (size = jk.je().size()) > 0) {
                this.arQ.AR().auv = jk.je().get(size - 1);
            }
            this.arQ.AQ().Cq = jd.responseCode;
            this.arQ.AQ().mHeader = jd.Cr;
            if (this.arQ.AQ().Cq != 200) {
                if (this.arQ.AR().auv != null && !TextUtils.isEmpty(this.arQ.AR().auv.BZ)) {
                    this.arQ.AQ().auu = this.arQ.AR().auv.BZ;
                } else {
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
                }
                TiebaStatic.net(this.arQ);
                return null;
            } else if (this.arX.isCanceled()) {
                return null;
            } else {
                str = new String(jd.Cs, IoUtils.UTF_8);
                try {
                    if (this.arQ.AP().AS().mIsBaiduServer && this.arQ.AP().AS().auS) {
                        eU(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.kQ());
                    aVar.asm = this.arQ.AR().auv.BU;
                    aVar.mTime = this.arQ.AR().auv.BX;
                    aVar.asn = this.arQ.AR().auv.BW;
                    aVar.asl = 1;
                    aa.a(aVar);
                    aa.ask.set(this.arQ.AR().auv.BW);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.arQ.AQ().Cq = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.arQ.AQ().Cq = -12;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.arQ.AQ().Cq = -13;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.arQ.AQ().Cq = -15;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.arQ);
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
    public String zw() {
        Exception e;
        String str;
        OutOfMemoryError e2;
        BdHttpCancelException e3;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        try {
            if (this.arX.isCanceled()) {
                throw new BdHttpCancelException();
            }
            com.baidu.adp.lib.network.http.g a = this.arX.a(this.arQ.AP().AS().mUrl, this.arQ.AP().AS().auR, this.arQ.AP().AS().auP, this.arQ.AP().AS().auQ, 5, -1, Aa());
            this.arQ.AQ().Cq = a.responseCode;
            this.arQ.AQ().mHeader = a.Cr;
            if (this.arQ.AQ().Cq != 200) {
                com.baidu.adp.lib.network.http.e jk = this.arX.jk();
                int i = 0;
                if (jk != null && jk.je() != null) {
                    i = jk.je().size();
                }
                if (i <= 0 || (dVar = jk.je().get(i - 1)) == null) {
                    str2 = "";
                } else {
                    str2 = dVar.BZ;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.arQ.AQ().auu = str2;
                } else {
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
                }
                TiebaStatic.net(this.arQ);
                return null;
            } else if (this.arX.isCanceled()) {
                throw new BdHttpCancelException();
            } else {
                str = new String(a.Cs, "UTF-8");
                try {
                    eU(str);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (BdHttpCancelException e4) {
                    e3 = e4;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.arQ.AQ().Cq = -14;
                    return str;
                } catch (SocketException e5) {
                    this.arQ.AQ().Cq = -12;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketTimeoutException e6) {
                    this.arQ.AQ().Cq = -13;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Exception e7) {
                    e = e7;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (OutOfMemoryError e8) {
                    e2 = e8;
                    this.arQ.AQ().Cq = -15;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.arQ);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [703=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.arX.isCanceled()) {
                return false;
            }
            return this.arX.a(this.arQ.AP().AS().mUrl, (z ? new File(str) : l.eu(str)).getAbsolutePath(), false, i2, i3, -1, -1, Aa(), new com.baidu.adp.lib.network.http.h() { // from class: com.baidu.tbadk.core.util.y.1
                int arY = 0;
                int arZ = 0;
                int asa = 0;

                @Override // com.baidu.adp.lib.network.http.h
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.arY = i5 / 50;
                    }
                    this.arZ += i4 - this.asa;
                    this.asa = i4;
                    if (handler != null) {
                        if (this.arZ > this.arY || i4 == i5) {
                            this.arZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.arQ.AQ().Cq = -10;
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.arQ.AQ().Cq = -15;
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.arQ);
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> zs() {
        return this.arQ.AP().AS().auP;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.arQ.AP().AS().auP != null) {
            this.arQ.AP().AS().auP.clear();
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
    public void u(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.arQ.AP().AS().auQ == null) {
            this.arQ.AP().AS().auQ = new HashMap<>();
        }
        this.arQ.AP().AS().auQ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.arQ.AP().AS().auP == null) {
                this.arQ.AP().AS().auP = new ArrayList<>();
            }
            int b = b(this.arQ.AP().AS().auP, basicNameValuePair.getName());
            int size = this.arQ.AP().AS().auP.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.arQ.AP().AS().auP.get(b).getName())) {
                    this.arQ.AP().AS().auP.set(b, basicNameValuePair);
                } else {
                    this.arQ.AP().AS().auP.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.arQ.AP().AS().auP.add(b, basicNameValuePair);
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

    private LinkedList<BasicNameValuePair> Aa() {
        if (this.arQ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.arQ.AP().AS().auU)) {
                linkedList.add(new BasicNameValuePair("sid", this.arQ.AP().AS().auU));
            }
            if (!com.baidu.tbadk.p.ak.jw() && !TextUtils.isEmpty(this.arQ.AP().AS().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.arQ.AP().AS().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
