package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0006a {
    private static int Zj = 5;
    private static int Zn = 0;
    private static int Zo = 0;
    private static int Zp = 0;
    private static int Zt = 0;
    private com.baidu.adp.lib.network.http.f Zg;
    private f Zk;
    private volatile com.baidu.adp.lib.network.http.d ei = null;
    private HashMap<String, String> Zh = null;
    private com.baidu.adp.lib.network.http.h Zi = new com.baidu.adp.lib.network.http.h();
    public boolean Zl = false;
    public boolean xv = false;
    public String ln = "";
    public com.baidu.adp.lib.network.http.e Zm = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean Zq = false;
    public boolean Zr = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m11getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m11getInst().isHttpAutoSwitch();
    private boolean Zs = false;

    public boolean uE() {
        return this.Zq;
    }

    public com.baidu.adp.lib.network.http.h dv() {
        return this.Zi;
    }

    public void uF() {
        this.Zm = null;
        this.ln = "";
        this.Zq = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.xv = false;
        this.Zl = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dJ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                uF();
                if (this.Zg != null) {
                    cancel();
                    this.ei = null;
                }
                this.Zg = new com.baidu.adp.lib.network.http.f();
                this.Zg.du().setUrl(str);
                if (this.Zh != null) {
                    for (Map.Entry<String, String> entry : this.Zh.entrySet()) {
                        this.Zg.du().n(entry.getKey(), entry.getValue());
                    }
                }
                this.ei = new com.baidu.adp.lib.network.http.d(this.Zg);
                this.ei.d(Zj, 0, 0);
                this.Zi = this.Zg.dv();
                byte[] bArr = this.Zg.dv().lG;
                this.responseCode = this.Zg.dv().responseCode;
                this.errorCode = this.Zg.dv().lE;
                this.Zq = this.Zg.dv().dB();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Zg.dv().contentEncoding != null && this.Zg.dv().contentEncoding.toLowerCase().contains("gzip")) {
                    this.Zl = true;
                    bArr = v(bArr);
                }
                if (!this.Zq) {
                    a(str, null);
                }
                this.Zm = this.Zg.dx();
                if (this.Zm != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.Zm;
                    eVar.ln = String.valueOf(eVar.ln) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.Zm;
                    eVar2.ln = String.valueOf(eVar2.ln) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.Zm = this.Zg.dx();
                if (this.Zm != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.Zm;
                    eVar3.ln = String.valueOf(eVar3.ln) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.Zm;
                    eVar4.ln = String.valueOf(eVar4.ln) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.Zm = this.Zg.dx();
            if (this.Zm != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.Zm;
                eVar5.ln = String.valueOf(eVar5.ln) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.Zm;
                eVar6.ln = String.valueOf(eVar6.ln) + "_responseCode:" + this.responseCode;
            }
            throw th;
        }
    }

    private final byte[] v(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dK(String str) {
        return dJ(str);
    }

    private boolean uG() {
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = Zt + 1;
            Zt = i;
            if (i >= 5) {
                Zt = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] l(String str, boolean z) {
        byte[] dJ;
        String str2;
        com.baidu.adp.lib.network.http.e eVar;
        com.baidu.adp.lib.network.http.e eVar2;
        com.baidu.adp.lib.network.http.e eVar3;
        com.baidu.adp.lib.network.http.e eVar4;
        com.baidu.adp.lib.network.http.e eVar5;
        com.baidu.adp.lib.network.http.e eVar6;
        int size;
        int i = 0;
        if (this.mUseHttpClient) {
            StringBuilder sb = new StringBuilder(20);
            try {
                try {
                    uF();
                    if (this.Zk != null) {
                        cancel();
                    }
                    this.Zg = new com.baidu.adp.lib.network.http.f();
                    this.Zk = new f(this.Zg);
                    this.Zg.du().setUrl(str);
                    if (this.Zh != null) {
                        for (Map.Entry<String, String> entry : this.Zh.entrySet()) {
                            this.Zg.du().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.Zk.d(null, null, -1);
                    this.Zi = this.Zg.dv();
                    dJ = this.Zg.dv().lG;
                    this.responseCode = this.Zg.dv().responseCode;
                    this.errorCode = this.Zg.dv().lE;
                    this.Zq = this.Zg.dv().dB();
                    if (this.mUseHttpAutoSwitch && uG()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m11getInst().setHttpClientOpen(false);
                        Zo = 0;
                        Zn = 0;
                        Zp = 0;
                    }
                    if (this.Zs) {
                        int i2 = Zn + 1;
                        Zn = i2;
                        if (i2 <= 2 && this.responseCode != 200) {
                            Zo++;
                            if (Zn == 1) {
                                Zp = this.errorCode;
                            }
                        }
                        if (Zn == 2) {
                            v.a("T2A", Zp, this.errorCode, Zo);
                            this.Zs = false;
                        }
                    }
                    if (dJ != null) {
                        this.dataSize = dJ.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.xv = this.Zk.cd();
                    this.Zr = this.Zk.uD();
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.Zg.dw().size();
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    for (int i3 = 0; i3 < this.Zg.dw().size(); i3++) {
                        if (this.Zg.dw().get(i3) != null) {
                            sb.append(this.Zg.dw().get(i3).lq);
                        }
                        if (i3 != this.Zg.dw().size() - 1) {
                            sb.append("_");
                        }
                    }
                    this.Zm = this.Zg.dx();
                    if (this.Zm != null) {
                        this.Zm.ln = String.valueOf(eVar4.ln) + sb.toString();
                        this.Zm.ln = String.valueOf(eVar5.ln) + "_responseCode:" + this.responseCode;
                        this.Zm.ln = String.valueOf(eVar6.ln) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } finally {
                int size3 = this.Zg.dw().size();
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i < this.Zg.dw().size()) {
                    if (this.Zg.dw().get(i) != null) {
                        sb.append(this.Zg.dw().get(i).lq);
                    }
                    if (i != this.Zg.dw().size() - 1) {
                        sb.append("_");
                    }
                    i++;
                }
                this.Zm = this.Zg.dx();
                if (this.Zm != null) {
                    this.Zm.ln = String.valueOf(eVar.ln) + sb.toString();
                    this.Zm.ln = String.valueOf(eVar2.ln) + "_responseCode:" + this.responseCode;
                    this.Zm.ln = String.valueOf(eVar3.ln) + "_size:" + Integer.toString(this.dataSize);
                }
            }
        } else {
            try {
                dJ = dJ(str);
                int i4 = Zn + 1;
                Zn = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (Zn == 1) {
                        Zp = this.errorCode;
                    }
                    Zo++;
                }
                if (Zn == 2) {
                    v.a("A2T", Zp, this.errorCode, Zo);
                }
                if (uG()) {
                    this.mUseHttpClient = true;
                    this.Zs = true;
                    TbadkCoreApplication.m11getInst().setHttpClientOpen(true);
                    Zo = 0;
                    Zn = 0;
                    Zp = 0;
                }
                if (dJ == null) {
                    return null;
                }
                if (this.Zg != null && this.Zg.dv().lF != null) {
                    List<String> list = this.Zg.dv().lF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Zg.dv().lF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.xv = true;
                        } else {
                            this.xv = false;
                        }
                    }
                    List<String> list3 = this.Zg.dv().lF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.Zr = false;
                        } else {
                            this.Zr = true;
                        }
                    }
                }
                if (this.Zq && ((z || i != 0) && new String(dJ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return copyOfRange(dJ, 23, dJ.length);
                }
            } catch (Exception e2) {
                this.ln = String.valueOf(this.ln) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dJ;
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(String.valueOf(i) + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void a(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.Zg.dw().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.Zg.dw().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.ln);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.lk);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.li);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.lh);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.lj);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.lm);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.lo);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.ll);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.lp);
            }
            if (exc != null) {
                stringBuffer.append("webclient exception");
                stringBuffer.append("class");
                stringBuffer.append(exc.getClass());
                stringBuffer.append("message");
                stringBuffer.append(exc.getMessage());
            } else {
                stringBuffer.append("networkcore exception");
            }
            this.ln = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.Zq = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.ei != null) {
            this.ei.cancel();
        }
        if (this.Zk != null) {
            this.Zk.cancel();
            this.Zk = null;
        }
    }

    public boolean uH() {
        if (this.Zk == null) {
            return false;
        }
        return this.Zk.YS;
    }
}
