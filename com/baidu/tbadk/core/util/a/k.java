package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0005a {
    private static int ahI = 5;
    private static int ahM = 0;
    private static int ahN = 0;
    private static int ahO = 0;
    private static int ahS = 0;
    private com.baidu.adp.lib.network.http.f ahF;
    private f ahJ;
    private volatile com.baidu.adp.lib.network.http.d om = null;
    private HashMap<String, String> ahG = null;
    private com.baidu.adp.lib.network.http.h ahH = new com.baidu.adp.lib.network.http.h();
    public boolean ahK = false;
    public boolean isGif = false;
    public String vz = "";
    public com.baidu.adp.lib.network.http.e ahL = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahP = false;
    public boolean ahQ = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ahR = false;

    public boolean wa() {
        return this.ahP;
    }

    public com.baidu.adp.lib.network.http.h fB() {
        return this.ahH;
    }

    public void wb() {
        this.ahL = null;
        this.vz = "";
        this.ahP = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ahK = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ee(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wb();
                if (this.ahF != null) {
                    cancel();
                    this.om = null;
                }
                this.ahF = new com.baidu.adp.lib.network.http.f();
                this.ahF.fA().setUrl(str);
                if (this.ahG != null) {
                    for (Map.Entry<String, String> entry : this.ahG.entrySet()) {
                        this.ahF.fA().n(entry.getKey(), entry.getValue());
                    }
                }
                this.om = new com.baidu.adp.lib.network.http.d(this.ahF);
                this.om.d(ahI, 0, 0);
                this.ahH = this.ahF.fB();
                byte[] bArr = this.ahF.fB().vS;
                this.responseCode = this.ahF.fB().responseCode;
                this.errorCode = this.ahF.fB().vQ;
                this.ahP = this.ahF.fB().fH();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ahF.fB().contentEncoding != null && this.ahF.fB().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahK = true;
                    bArr = y(bArr);
                }
                if (!this.ahP) {
                    c(str, null);
                }
                this.ahL = this.ahF.fD();
                if (this.ahL != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahL;
                    eVar.vz = String.valueOf(eVar.vz) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahL;
                    eVar2.vz = String.valueOf(eVar2.vz) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahL = this.ahF.fD();
                if (this.ahL != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahL;
                    eVar3.vz = String.valueOf(eVar3.vz) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahL;
                    eVar4.vz = String.valueOf(eVar4.vz) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahL = this.ahF.fD();
            if (this.ahL != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahL;
                eVar5.vz = String.valueOf(eVar5.vz) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahL;
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

    public byte[] ef(String str) {
        return ee(str);
    }

    private boolean wc() {
        if (this.ahH.vP) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ahS + 1;
            ahS = i;
            if (i >= 5) {
                ahS = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] k(String str, boolean z) {
        byte[] ee;
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
                    wb();
                    if (this.ahJ != null) {
                        cancel();
                    }
                    this.ahF = new com.baidu.adp.lib.network.http.f();
                    this.ahJ = new f(this.ahF);
                    this.ahF.fA().setUrl(str);
                    if (this.ahG != null) {
                        for (Map.Entry<String, String> entry : this.ahG.entrySet()) {
                            this.ahF.fA().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahJ.d(null, null, -1);
                    this.ahH = this.ahF.fB();
                    ee = this.ahF.fB().vS;
                    this.responseCode = this.ahF.fB().responseCode;
                    this.errorCode = this.ahF.fB().vQ;
                    this.ahP = this.ahF.fB().fH();
                    if (this.mUseHttpAutoSwitch && wc()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ahN = 0;
                        ahM = 0;
                        ahO = 0;
                    }
                    if (this.ahR) {
                        int i3 = ahM + 1;
                        ahM = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ahN++;
                            if (ahM == 1) {
                                ahO = this.errorCode;
                            }
                        }
                        if (ahM == 2) {
                            w.a("T2A", ahO, this.errorCode, ahN);
                            this.ahR = false;
                        }
                    }
                    if (ee != null) {
                        this.dataSize = ee.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.isGif = this.ahJ.isGif();
                    this.ahQ = this.ahJ.vZ();
                    int size = this.ahF.fC().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.ahF.fC().get(i2) != null) {
                                sb.append(this.ahF.fC().get(i2).vC);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahL = this.ahF.fD();
                    if (this.ahL != null) {
                        this.ahL.vz = String.valueOf(eVar7.vz) + sb.toString();
                        this.ahL.vz = String.valueOf(eVar8.vz) + "_responseCode:" + this.responseCode;
                        this.ahL.vz = String.valueOf(eVar9.vz) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.ahF.fC().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.ahF.fC().get(i2) != null) {
                                sb.append(this.ahF.fC().get(i2).vC);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahL = this.ahF.fD();
                    if (this.ahL != null) {
                        this.ahL.vz = String.valueOf(eVar.vz) + sb.toString();
                        this.ahL.vz = String.valueOf(eVar2.vz) + "_responseCode:" + this.responseCode;
                        this.ahL.vz = String.valueOf(eVar3.vz) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.ahF.fC().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.ahF.fC().get(i2) != null) {
                            sb.append(this.ahF.fC().get(i2).vC);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahL = this.ahF.fD();
                if (this.ahL != null) {
                    this.ahL.vz = String.valueOf(eVar4.vz) + sb.toString();
                    this.ahL.vz = String.valueOf(eVar5.vz) + "_responseCode:" + this.responseCode;
                    this.ahL.vz = String.valueOf(eVar6.vz) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                ee = ee(str);
                int i4 = ahM + 1;
                ahM = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahM == 1) {
                        ahO = this.errorCode;
                    }
                    ahN++;
                }
                if (ahM == 2) {
                    w.a("A2T", ahO, this.errorCode, ahN);
                }
                if (wc()) {
                    this.mUseHttpClient = true;
                    this.ahR = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ahN = 0;
                    ahM = 0;
                    ahO = 0;
                }
                if (ee == null) {
                    return null;
                }
                if (this.ahF != null && this.ahF.fB().vR != null) {
                    List<String> list = this.ahF.fB().vR.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ahF.fB().vR.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.ahF.fB().vR.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahQ = false;
                            i = i2;
                            if (this.ahP && ((z || i != 0) && new String(ee, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(ee, 23, ee.length);
                            }
                        } else {
                            this.ahQ = true;
                        }
                    }
                }
                i = i2;
                if (this.ahP) {
                    return copyOfRange(ee, 23, ee.length);
                }
            } catch (Exception e2) {
                this.vz = String.valueOf(this.vz) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return ee;
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

    private void c(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.ahF.fC().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.ahF.fC().get(i);
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
                stringBuffer.append(PushConstants.EXTRA_PUSH_MESSAGE);
                stringBuffer.append(exc.getMessage());
            } else {
                stringBuffer.append("networkcore exception");
            }
            this.vz = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ahP = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.om != null) {
            this.om.cancel();
        }
        if (this.ahJ != null) {
            this.ahJ.cancel();
            this.ahJ = null;
        }
    }

    public boolean wd() {
        if (this.ahJ == null) {
            return false;
        }
        return this.ahJ.ahr;
    }
}
