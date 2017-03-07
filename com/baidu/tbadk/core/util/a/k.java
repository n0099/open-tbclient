package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0005a {
    private static int ahC = 5;
    private static int ahG = 0;
    private static int ahH = 0;
    private static int ahI = 0;
    private static int ahM = 0;
    private f ahD;
    private com.baidu.adp.lib.network.http.f ahz;
    private volatile com.baidu.adp.lib.network.http.d oP = null;
    private HashMap<String, String> ahA = null;
    private com.baidu.adp.lib.network.http.h ahB = new com.baidu.adp.lib.network.http.h();
    public boolean ahE = false;
    public boolean Ho = false;
    public String vS = "";
    public com.baidu.adp.lib.network.http.e ahF = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahJ = false;
    public boolean ahK = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ahL = false;

    public boolean wb() {
        return this.ahJ;
    }

    public com.baidu.adp.lib.network.http.h fw() {
        return this.ahB;
    }

    public void wc() {
        this.ahF = null;
        this.vS = "";
        this.ahJ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Ho = false;
        this.ahE = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dI(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wc();
                if (this.ahz != null) {
                    cancel();
                    this.oP = null;
                }
                this.ahz = new com.baidu.adp.lib.network.http.f();
                this.ahz.fv().setUrl(str);
                if (this.ahA != null) {
                    for (Map.Entry<String, String> entry : this.ahA.entrySet()) {
                        this.ahz.fv().n(entry.getKey(), entry.getValue());
                    }
                }
                this.oP = new com.baidu.adp.lib.network.http.d(this.ahz);
                this.oP.d(ahC, 0, 0);
                this.ahB = this.ahz.fw();
                byte[] bArr = this.ahz.fw().wl;
                this.responseCode = this.ahz.fw().responseCode;
                this.errorCode = this.ahz.fw().wj;
                this.ahJ = this.ahz.fw().fC();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ahz.fw().contentEncoding != null && this.ahz.fw().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahE = true;
                    bArr = y(bArr);
                }
                if (!this.ahJ) {
                    a(str, null);
                }
                this.ahF = this.ahz.fy();
                if (this.ahF != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahF;
                    eVar.vS = String.valueOf(eVar.vS) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahF;
                    eVar2.vS = String.valueOf(eVar2.vS) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahF = this.ahz.fy();
                if (this.ahF != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahF;
                    eVar3.vS = String.valueOf(eVar3.vS) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahF;
                    eVar4.vS = String.valueOf(eVar4.vS) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahF = this.ahz.fy();
            if (this.ahF != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahF;
                eVar5.vS = String.valueOf(eVar5.vS) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahF;
                eVar6.vS = String.valueOf(eVar6.vS) + "_responseCode:" + this.responseCode;
            }
            throw th;
        }
    }

    private final byte[] y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dJ(String str) {
        return dI(str);
    }

    private boolean wd() {
        if (this.ahB.wi) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ahM + 1;
            ahM = i;
            if (i >= 5) {
                ahM = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
        byte[] dI;
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
                    wc();
                    if (this.ahD != null) {
                        cancel();
                    }
                    this.ahz = new com.baidu.adp.lib.network.http.f();
                    this.ahD = new f(this.ahz);
                    this.ahz.fv().setUrl(str);
                    if (this.ahA != null) {
                        for (Map.Entry<String, String> entry : this.ahA.entrySet()) {
                            this.ahz.fv().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahD.d(null, null, -1);
                    this.ahB = this.ahz.fw();
                    dI = this.ahz.fw().wl;
                    this.responseCode = this.ahz.fw().responseCode;
                    this.errorCode = this.ahz.fw().wj;
                    this.ahJ = this.ahz.fw().fC();
                    if (this.mUseHttpAutoSwitch && wd()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ahH = 0;
                        ahG = 0;
                        ahI = 0;
                    }
                    if (this.ahL) {
                        int i3 = ahG + 1;
                        ahG = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ahH++;
                            if (ahG == 1) {
                                ahI = this.errorCode;
                            }
                        }
                        if (ahG == 2) {
                            u.a("T2A", ahI, this.errorCode, ahH);
                            this.ahL = false;
                        }
                    }
                    if (dI != null) {
                        this.dataSize = dI.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Ho = this.ahD.ef();
                    this.ahK = this.ahD.wa();
                    int size = this.ahz.fx().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.ahz.fx().get(i2) != null) {
                                sb.append(this.ahz.fx().get(i2).vV);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahF = this.ahz.fy();
                    if (this.ahF != null) {
                        this.ahF.vS = String.valueOf(eVar7.vS) + sb.toString();
                        this.ahF.vS = String.valueOf(eVar8.vS) + "_responseCode:" + this.responseCode;
                        this.ahF.vS = String.valueOf(eVar9.vS) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.ahz.fx().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.ahz.fx().get(i2) != null) {
                                sb.append(this.ahz.fx().get(i2).vV);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahF = this.ahz.fy();
                    if (this.ahF != null) {
                        this.ahF.vS = String.valueOf(eVar.vS) + sb.toString();
                        this.ahF.vS = String.valueOf(eVar2.vS) + "_responseCode:" + this.responseCode;
                        this.ahF.vS = String.valueOf(eVar3.vS) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.ahz.fx().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.ahz.fx().get(i2) != null) {
                            sb.append(this.ahz.fx().get(i2).vV);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahF = this.ahz.fy();
                if (this.ahF != null) {
                    this.ahF.vS = String.valueOf(eVar4.vS) + sb.toString();
                    this.ahF.vS = String.valueOf(eVar5.vS) + "_responseCode:" + this.responseCode;
                    this.ahF.vS = String.valueOf(eVar6.vS) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dI = dI(str);
                int i4 = ahG + 1;
                ahG = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahG == 1) {
                        ahI = this.errorCode;
                    }
                    ahH++;
                }
                if (ahG == 2) {
                    u.a("A2T", ahI, this.errorCode, ahH);
                }
                if (wd()) {
                    this.mUseHttpClient = true;
                    this.ahL = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ahH = 0;
                    ahG = 0;
                    ahI = 0;
                }
                if (dI == null) {
                    return null;
                }
                if (this.ahz != null && this.ahz.fw().wk != null) {
                    List<String> list = this.ahz.fw().wk.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ahz.fw().wk.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Ho = true;
                        } else {
                            this.Ho = false;
                        }
                    }
                    List<String> list3 = this.ahz.fw().wk.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahK = false;
                            i = i2;
                            if (this.ahJ && ((z || i != 0) && new String(dI, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dI, 23, dI.length);
                            }
                        } else {
                            this.ahK = true;
                        }
                    }
                }
                i = i2;
                if (this.ahJ) {
                    return copyOfRange(dI, 23, dI.length);
                }
            } catch (Exception e2) {
                this.vS = String.valueOf(this.vS) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dI;
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
            for (int i = 0; i < this.ahz.fx().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.ahz.fx().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.vS);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.vP);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.vN);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.vM);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.vO);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.vR);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.vT);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.vQ);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.vU);
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
            this.vS = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ahJ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.oP != null) {
            this.oP.cancel();
        }
        if (this.ahD != null) {
            this.ahD.cancel();
            this.ahD = null;
        }
    }

    public boolean we() {
        if (this.ahD == null) {
            return false;
        }
        return this.ahD.ahl;
    }
}
