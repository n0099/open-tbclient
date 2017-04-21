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
    private static int ahR = 5;
    private static int ahV = 0;
    private static int ahW = 0;
    private static int ahX = 0;
    private static int aib = 0;
    private com.baidu.adp.lib.network.http.f ahO;
    private f ahS;
    private volatile com.baidu.adp.lib.network.http.d ol = null;
    private HashMap<String, String> ahP = null;
    private com.baidu.adp.lib.network.http.h ahQ = new com.baidu.adp.lib.network.http.h();
    public boolean ahT = false;
    public boolean GS = false;
    public String vz = "";
    public com.baidu.adp.lib.network.http.e ahU = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahY = false;
    public boolean ahZ = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean aia = false;

    public boolean wy() {
        return this.ahY;
    }

    public com.baidu.adp.lib.network.http.h fC() {
        return this.ahQ;
    }

    public void wz() {
        this.ahU = null;
        this.vz = "";
        this.ahY = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GS = false;
        this.ahT = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dO(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wz();
                if (this.ahO != null) {
                    cancel();
                    this.ol = null;
                }
                this.ahO = new com.baidu.adp.lib.network.http.f();
                this.ahO.fB().setUrl(str);
                if (this.ahP != null) {
                    for (Map.Entry<String, String> entry : this.ahP.entrySet()) {
                        this.ahO.fB().n(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.d(this.ahO);
                this.ol.d(ahR, 0, 0);
                this.ahQ = this.ahO.fC();
                byte[] bArr = this.ahO.fC().vS;
                this.responseCode = this.ahO.fC().responseCode;
                this.errorCode = this.ahO.fC().vQ;
                this.ahY = this.ahO.fC().fI();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ahO.fC().contentEncoding != null && this.ahO.fC().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahT = true;
                    bArr = y(bArr);
                }
                if (!this.ahY) {
                    a(str, null);
                }
                this.ahU = this.ahO.fE();
                if (this.ahU != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahU;
                    eVar.vz = String.valueOf(eVar.vz) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahU;
                    eVar2.vz = String.valueOf(eVar2.vz) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahU = this.ahO.fE();
                if (this.ahU != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahU;
                    eVar3.vz = String.valueOf(eVar3.vz) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahU;
                    eVar4.vz = String.valueOf(eVar4.vz) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahU = this.ahO.fE();
            if (this.ahU != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahU;
                eVar5.vz = String.valueOf(eVar5.vz) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahU;
                eVar6.vz = String.valueOf(eVar6.vz) + "_responseCode:" + this.responseCode;
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
        if (this.ahQ.vP) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aib + 1;
            aib = i;
            if (i >= 5) {
                aib = 0;
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
                    if (this.ahS != null) {
                        cancel();
                    }
                    this.ahO = new com.baidu.adp.lib.network.http.f();
                    this.ahS = new f(this.ahO);
                    this.ahO.fB().setUrl(str);
                    if (this.ahP != null) {
                        for (Map.Entry<String, String> entry : this.ahP.entrySet()) {
                            this.ahO.fB().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahS.d(null, null, -1);
                    this.ahQ = this.ahO.fC();
                    dO = this.ahO.fC().vS;
                    this.responseCode = this.ahO.fC().responseCode;
                    this.errorCode = this.ahO.fC().vQ;
                    this.ahY = this.ahO.fC().fI();
                    if (this.mUseHttpAutoSwitch && wA()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ahW = 0;
                        ahV = 0;
                        ahX = 0;
                    }
                    if (this.aia) {
                        int i3 = ahV + 1;
                        ahV = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ahW++;
                            if (ahV == 1) {
                                ahX = this.errorCode;
                            }
                        }
                        if (ahV == 2) {
                            u.a("T2A", ahX, this.errorCode, ahW);
                            this.aia = false;
                        }
                    }
                    if (dO != null) {
                        this.dataSize = dO.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GS = this.ahS.ef();
                    this.ahZ = this.ahS.wx();
                    int size = this.ahO.fD().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.ahO.fD().get(i2) != null) {
                                sb.append(this.ahO.fD().get(i2).vC);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahU = this.ahO.fE();
                    if (this.ahU != null) {
                        this.ahU.vz = String.valueOf(eVar7.vz) + sb.toString();
                        this.ahU.vz = String.valueOf(eVar8.vz) + "_responseCode:" + this.responseCode;
                        this.ahU.vz = String.valueOf(eVar9.vz) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.ahO.fD().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.ahO.fD().get(i2) != null) {
                                sb.append(this.ahO.fD().get(i2).vC);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahU = this.ahO.fE();
                    if (this.ahU != null) {
                        this.ahU.vz = String.valueOf(eVar.vz) + sb.toString();
                        this.ahU.vz = String.valueOf(eVar2.vz) + "_responseCode:" + this.responseCode;
                        this.ahU.vz = String.valueOf(eVar3.vz) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.ahO.fD().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.ahO.fD().get(i2) != null) {
                            sb.append(this.ahO.fD().get(i2).vC);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahU = this.ahO.fE();
                if (this.ahU != null) {
                    this.ahU.vz = String.valueOf(eVar4.vz) + sb.toString();
                    this.ahU.vz = String.valueOf(eVar5.vz) + "_responseCode:" + this.responseCode;
                    this.ahU.vz = String.valueOf(eVar6.vz) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dO = dO(str);
                int i4 = ahV + 1;
                ahV = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahV == 1) {
                        ahX = this.errorCode;
                    }
                    ahW++;
                }
                if (ahV == 2) {
                    u.a("A2T", ahX, this.errorCode, ahW);
                }
                if (wA()) {
                    this.mUseHttpClient = true;
                    this.aia = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ahW = 0;
                    ahV = 0;
                    ahX = 0;
                }
                if (dO == null) {
                    return null;
                }
                if (this.ahO != null && this.ahO.fC().vR != null) {
                    List<String> list = this.ahO.fC().vR.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ahO.fC().vR.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.GS = true;
                        } else {
                            this.GS = false;
                        }
                    }
                    List<String> list3 = this.ahO.fC().vR.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahZ = false;
                            i = i2;
                            if (this.ahY && ((z || i != 0) && new String(dO, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dO, 23, dO.length);
                            }
                        } else {
                            this.ahZ = true;
                        }
                    }
                }
                i = i2;
                if (this.ahY) {
                    return copyOfRange(dO, 23, dO.length);
                }
            } catch (Exception e2) {
                this.vz = String.valueOf(this.vz) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.ahO.fD().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.ahO.fD().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.vz);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.vw);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.vu);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.vv);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.vy);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.vA);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.vx);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.vB);
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
            this.vz = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ahY = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.ahS != null) {
            this.ahS.cancel();
            this.ahS = null;
        }
    }

    public boolean wB() {
        if (this.ahS == null) {
            return false;
        }
        return this.ahS.ahA;
    }
}
