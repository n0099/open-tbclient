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
    private static int ZA = 5;
    private static int ZE = 0;
    private static int ZF = 0;
    private static int ZG = 0;
    private static int ZK = 0;
    private f ZB;
    private com.baidu.adp.lib.network.http.f Zx;
    private volatile com.baidu.adp.lib.network.http.d eh = null;
    private HashMap<String, String> Zy = null;
    private com.baidu.adp.lib.network.http.h Zz = new com.baidu.adp.lib.network.http.h();
    public boolean ZC = false;
    public boolean xx = false;
    public String ll = "";
    public com.baidu.adp.lib.network.http.e ZD = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ZH = false;
    public boolean ZI = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ZJ = false;

    public boolean uD() {
        return this.ZH;
    }

    public com.baidu.adp.lib.network.http.h dw() {
        return this.Zz;
    }

    public void uE() {
        this.ZD = null;
        this.ll = "";
        this.ZH = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.xx = false;
        this.ZC = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dM(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                uE();
                if (this.Zx != null) {
                    cancel();
                    this.eh = null;
                }
                this.Zx = new com.baidu.adp.lib.network.http.f();
                this.Zx.dv().setUrl(str);
                if (this.Zy != null) {
                    for (Map.Entry<String, String> entry : this.Zy.entrySet()) {
                        this.Zx.dv().n(entry.getKey(), entry.getValue());
                    }
                }
                this.eh = new com.baidu.adp.lib.network.http.d(this.Zx);
                this.eh.d(ZA, 0, 0);
                this.Zz = this.Zx.dw();
                byte[] bArr = this.Zx.dw().lG;
                this.responseCode = this.Zx.dw().responseCode;
                this.errorCode = this.Zx.dw().lE;
                this.ZH = this.Zx.dw().dC();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Zx.dw().contentEncoding != null && this.Zx.dw().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ZC = true;
                    bArr = v(bArr);
                }
                if (!this.ZH) {
                    a(str, null);
                }
                this.ZD = this.Zx.dy();
                if (this.ZD != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ZD;
                    eVar.ll = String.valueOf(eVar.ll) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ZD;
                    eVar2.ll = String.valueOf(eVar2.ll) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ZD = this.Zx.dy();
                if (this.ZD != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ZD;
                    eVar3.ll = String.valueOf(eVar3.ll) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ZD;
                    eVar4.ll = String.valueOf(eVar4.ll) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ZD = this.Zx.dy();
            if (this.ZD != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ZD;
                eVar5.ll = String.valueOf(eVar5.ll) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ZD;
                eVar6.ll = String.valueOf(eVar6.ll) + "_responseCode:" + this.responseCode;
            }
            throw th;
        }
    }

    private final byte[] v(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dN(String str) {
        return dM(str);
    }

    private boolean uF() {
        if (this.Zz.lD) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ZK + 1;
            ZK = i;
            if (i >= 5) {
                ZK = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] l(String str, boolean z) {
        byte[] dM;
        int i;
        String str2;
        com.baidu.adp.lib.network.http.e eVar;
        com.baidu.adp.lib.network.http.e eVar2;
        com.baidu.adp.lib.network.http.e eVar3;
        com.baidu.adp.lib.network.http.e eVar4;
        com.baidu.adp.lib.network.http.e eVar5;
        com.baidu.adp.lib.network.http.e eVar6;
        com.baidu.adp.lib.network.http.e eVar7;
        com.baidu.adp.lib.network.http.e eVar8;
        com.baidu.adp.lib.network.http.e eVar9;
        int i2 = 0;
        if (this.mUseHttpClient) {
            StringBuilder sb = new StringBuilder(20);
            try {
                try {
                    uE();
                    if (this.ZB != null) {
                        cancel();
                    }
                    this.Zx = new com.baidu.adp.lib.network.http.f();
                    this.ZB = new f(this.Zx);
                    this.Zx.dv().setUrl(str);
                    if (this.Zy != null) {
                        for (Map.Entry<String, String> entry : this.Zy.entrySet()) {
                            this.Zx.dv().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ZB.d(null, null, -1);
                    this.Zz = this.Zx.dw();
                    dM = this.Zx.dw().lG;
                    this.responseCode = this.Zx.dw().responseCode;
                    this.errorCode = this.Zx.dw().lE;
                    this.ZH = this.Zx.dw().dC();
                    if (this.mUseHttpAutoSwitch && uF()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ZF = 0;
                        ZE = 0;
                        ZG = 0;
                    }
                    if (this.ZJ) {
                        int i3 = ZE + 1;
                        ZE = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ZF++;
                            if (ZE == 1) {
                                ZG = this.errorCode;
                            }
                        }
                        if (ZE == 2) {
                            v.a("T2A", ZG, this.errorCode, ZF);
                            this.ZJ = false;
                        }
                    }
                    if (dM != null) {
                        this.dataSize = dM.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.xx = this.ZB.ce();
                    this.ZI = this.ZB.uC();
                    int size = this.Zx.dx().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.Zx.dx().get(i2) != null) {
                                sb.append(this.Zx.dx().get(i2).lo);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ZD = this.Zx.dy();
                    if (this.ZD != null) {
                        this.ZD.ll = String.valueOf(eVar7.ll) + sb.toString();
                        this.ZD.ll = String.valueOf(eVar8.ll) + "_responseCode:" + this.responseCode;
                        this.ZD.ll = String.valueOf(eVar9.ll) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.Zx.dx().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.Zx.dx().get(i2) != null) {
                                sb.append(this.Zx.dx().get(i2).lo);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ZD = this.Zx.dy();
                    if (this.ZD != null) {
                        this.ZD.ll = String.valueOf(eVar.ll) + sb.toString();
                        this.ZD.ll = String.valueOf(eVar2.ll) + "_responseCode:" + this.responseCode;
                        this.ZD.ll = String.valueOf(eVar3.ll) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.Zx.dx().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.Zx.dx().get(i2) != null) {
                            sb.append(this.Zx.dx().get(i2).lo);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ZD = this.Zx.dy();
                if (this.ZD != null) {
                    this.ZD.ll = String.valueOf(eVar4.ll) + sb.toString();
                    this.ZD.ll = String.valueOf(eVar5.ll) + "_responseCode:" + this.responseCode;
                    this.ZD.ll = String.valueOf(eVar6.ll) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dM = dM(str);
                int i4 = ZE + 1;
                ZE = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ZE == 1) {
                        ZG = this.errorCode;
                    }
                    ZF++;
                }
                if (ZE == 2) {
                    v.a("A2T", ZG, this.errorCode, ZF);
                }
                if (uF()) {
                    this.mUseHttpClient = true;
                    this.ZJ = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ZF = 0;
                    ZE = 0;
                    ZG = 0;
                }
                if (dM == null) {
                    return null;
                }
                if (this.Zx != null && this.Zx.dw().lF != null) {
                    List<String> list = this.Zx.dw().lF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.Zx.dw().lF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.xx = true;
                        } else {
                            this.xx = false;
                        }
                    }
                    List<String> list3 = this.Zx.dw().lF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ZI = false;
                            i = i2;
                            if (this.ZH && ((z || i != 0) && new String(dM, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dM, 23, dM.length);
                            }
                        } else {
                            this.ZI = true;
                        }
                    }
                }
                i = i2;
                if (this.ZH) {
                    return copyOfRange(dM, 23, dM.length);
                }
            } catch (Exception e2) {
                this.ll = String.valueOf(this.ll) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dM;
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
            for (int i = 0; i < this.Zx.dx().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.Zx.dx().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.ll);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.li);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.lg);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.lf);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.lh);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.lk);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.lm);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.lj);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.ln);
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
            this.ll = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ZH = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.eh != null) {
            this.eh.cancel();
        }
        if (this.ZB != null) {
            this.ZB.cancel();
            this.ZB = null;
        }
    }

    public boolean uG() {
        if (this.ZB == null) {
            return false;
        }
        return this.ZB.Zj;
    }
}
