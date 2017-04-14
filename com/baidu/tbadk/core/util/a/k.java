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
    private static int ahQ = 5;
    private static int ahU = 0;
    private static int ahV = 0;
    private static int ahW = 0;
    private static int aia = 0;
    private com.baidu.adp.lib.network.http.f ahN;
    private f ahR;
    private volatile com.baidu.adp.lib.network.http.d ol = null;
    private HashMap<String, String> ahO = null;
    private com.baidu.adp.lib.network.http.h ahP = new com.baidu.adp.lib.network.http.h();
    public boolean ahS = false;
    public boolean GP = false;
    public String vv = "";
    public com.baidu.adp.lib.network.http.e ahT = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahX = false;
    public boolean ahY = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ahZ = false;

    public boolean wy() {
        return this.ahX;
    }

    public com.baidu.adp.lib.network.http.h fB() {
        return this.ahP;
    }

    public void wz() {
        this.ahT = null;
        this.vv = "";
        this.ahX = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GP = false;
        this.ahS = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dO(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wz();
                if (this.ahN != null) {
                    cancel();
                    this.ol = null;
                }
                this.ahN = new com.baidu.adp.lib.network.http.f();
                this.ahN.fA().setUrl(str);
                if (this.ahO != null) {
                    for (Map.Entry<String, String> entry : this.ahO.entrySet()) {
                        this.ahN.fA().n(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.d(this.ahN);
                this.ol.d(ahQ, 0, 0);
                this.ahP = this.ahN.fB();
                byte[] bArr = this.ahN.fB().vO;
                this.responseCode = this.ahN.fB().responseCode;
                this.errorCode = this.ahN.fB().vM;
                this.ahX = this.ahN.fB().fH();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ahN.fB().contentEncoding != null && this.ahN.fB().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahS = true;
                    bArr = y(bArr);
                }
                if (!this.ahX) {
                    a(str, null);
                }
                this.ahT = this.ahN.fD();
                if (this.ahT != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahT;
                    eVar.vv = String.valueOf(eVar.vv) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahT;
                    eVar2.vv = String.valueOf(eVar2.vv) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahT = this.ahN.fD();
                if (this.ahT != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahT;
                    eVar3.vv = String.valueOf(eVar3.vv) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahT;
                    eVar4.vv = String.valueOf(eVar4.vv) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahT = this.ahN.fD();
            if (this.ahT != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahT;
                eVar5.vv = String.valueOf(eVar5.vv) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahT;
                eVar6.vv = String.valueOf(eVar6.vv) + "_responseCode:" + this.responseCode;
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

    public byte[] dP(String str) {
        return dO(str);
    }

    private boolean wA() {
        if (this.ahP.vL) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aia + 1;
            aia = i;
            if (i >= 5) {
                aia = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
        byte[] dO;
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
                    wz();
                    if (this.ahR != null) {
                        cancel();
                    }
                    this.ahN = new com.baidu.adp.lib.network.http.f();
                    this.ahR = new f(this.ahN);
                    this.ahN.fA().setUrl(str);
                    if (this.ahO != null) {
                        for (Map.Entry<String, String> entry : this.ahO.entrySet()) {
                            this.ahN.fA().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahR.d(null, null, -1);
                    this.ahP = this.ahN.fB();
                    dO = this.ahN.fB().vO;
                    this.responseCode = this.ahN.fB().responseCode;
                    this.errorCode = this.ahN.fB().vM;
                    this.ahX = this.ahN.fB().fH();
                    if (this.mUseHttpAutoSwitch && wA()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ahV = 0;
                        ahU = 0;
                        ahW = 0;
                    }
                    if (this.ahZ) {
                        int i3 = ahU + 1;
                        ahU = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ahV++;
                            if (ahU == 1) {
                                ahW = this.errorCode;
                            }
                        }
                        if (ahU == 2) {
                            u.a("T2A", ahW, this.errorCode, ahV);
                            this.ahZ = false;
                        }
                    }
                    if (dO != null) {
                        this.dataSize = dO.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GP = this.ahR.ee();
                    this.ahY = this.ahR.wx();
                    int size = this.ahN.fC().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.ahN.fC().get(i2) != null) {
                                sb.append(this.ahN.fC().get(i2).vy);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahT = this.ahN.fD();
                    if (this.ahT != null) {
                        this.ahT.vv = String.valueOf(eVar7.vv) + sb.toString();
                        this.ahT.vv = String.valueOf(eVar8.vv) + "_responseCode:" + this.responseCode;
                        this.ahT.vv = String.valueOf(eVar9.vv) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.ahN.fC().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.ahN.fC().get(i2) != null) {
                                sb.append(this.ahN.fC().get(i2).vy);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahT = this.ahN.fD();
                    if (this.ahT != null) {
                        this.ahT.vv = String.valueOf(eVar.vv) + sb.toString();
                        this.ahT.vv = String.valueOf(eVar2.vv) + "_responseCode:" + this.responseCode;
                        this.ahT.vv = String.valueOf(eVar3.vv) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.ahN.fC().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.ahN.fC().get(i2) != null) {
                            sb.append(this.ahN.fC().get(i2).vy);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahT = this.ahN.fD();
                if (this.ahT != null) {
                    this.ahT.vv = String.valueOf(eVar4.vv) + sb.toString();
                    this.ahT.vv = String.valueOf(eVar5.vv) + "_responseCode:" + this.responseCode;
                    this.ahT.vv = String.valueOf(eVar6.vv) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dO = dO(str);
                int i4 = ahU + 1;
                ahU = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahU == 1) {
                        ahW = this.errorCode;
                    }
                    ahV++;
                }
                if (ahU == 2) {
                    u.a("A2T", ahW, this.errorCode, ahV);
                }
                if (wA()) {
                    this.mUseHttpClient = true;
                    this.ahZ = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ahV = 0;
                    ahU = 0;
                    ahW = 0;
                }
                if (dO == null) {
                    return null;
                }
                if (this.ahN != null && this.ahN.fB().vN != null) {
                    List<String> list = this.ahN.fB().vN.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ahN.fB().vN.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.GP = true;
                        } else {
                            this.GP = false;
                        }
                    }
                    List<String> list3 = this.ahN.fB().vN.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahY = false;
                            i = i2;
                            if (this.ahX && ((z || i != 0) && new String(dO, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dO, 23, dO.length);
                            }
                        } else {
                            this.ahY = true;
                        }
                    }
                }
                i = i2;
                if (this.ahX) {
                    return copyOfRange(dO, 23, dO.length);
                }
            } catch (Exception e2) {
                this.vv = String.valueOf(this.vv) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dO;
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
            for (int i = 0; i < this.ahN.fC().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.ahN.fC().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.vv);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.vs);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.vq);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.vp);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.vr);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.vu);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.vw);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.vt);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.vx);
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
            this.vv = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ahX = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.ahR != null) {
            this.ahR.cancel();
            this.ahR = null;
        }
    }

    public boolean wB() {
        if (this.ahR == null) {
            return false;
        }
        return this.ahR.ahz;
    }
}
