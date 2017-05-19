package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0005a {
    private static int ahj = 5;
    private static int ahn = 0;
    private static int aho = 0;
    private static int ahp = 0;
    private static int aht = 0;
    private com.baidu.adp.lib.network.http.f ahg;
    private f ahk;
    private volatile com.baidu.adp.lib.network.http.d om = null;
    private HashMap<String, String> ahh = null;
    private com.baidu.adp.lib.network.http.h ahi = new com.baidu.adp.lib.network.http.h();
    public boolean ahl = false;
    public boolean GS = false;
    public String vA = "";
    public com.baidu.adp.lib.network.http.e ahm = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahq = false;
    public boolean ahr = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ahs = false;

    public boolean vM() {
        return this.ahq;
    }

    public com.baidu.adp.lib.network.http.h fC() {
        return this.ahi;
    }

    public void vN() {
        this.ahm = null;
        this.vA = "";
        this.ahq = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GS = false;
        this.ahl = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dM(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vN();
                if (this.ahg != null) {
                    cancel();
                    this.om = null;
                }
                this.ahg = new com.baidu.adp.lib.network.http.f();
                this.ahg.fB().setUrl(str);
                if (this.ahh != null) {
                    for (Map.Entry<String, String> entry : this.ahh.entrySet()) {
                        this.ahg.fB().n(entry.getKey(), entry.getValue());
                    }
                }
                this.om = new com.baidu.adp.lib.network.http.d(this.ahg);
                this.om.d(ahj, 0, 0);
                this.ahi = this.ahg.fC();
                byte[] bArr = this.ahg.fC().vT;
                this.responseCode = this.ahg.fC().responseCode;
                this.errorCode = this.ahg.fC().vR;
                this.ahq = this.ahg.fC().fI();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ahg.fC().contentEncoding != null && this.ahg.fC().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahl = true;
                    bArr = y(bArr);
                }
                if (!this.ahq) {
                    a(str, null);
                }
                this.ahm = this.ahg.fE();
                if (this.ahm != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahm;
                    eVar.vA = String.valueOf(eVar.vA) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahm;
                    eVar2.vA = String.valueOf(eVar2.vA) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahm = this.ahg.fE();
                if (this.ahm != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahm;
                    eVar3.vA = String.valueOf(eVar3.vA) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahm;
                    eVar4.vA = String.valueOf(eVar4.vA) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahm = this.ahg.fE();
            if (this.ahm != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahm;
                eVar5.vA = String.valueOf(eVar5.vA) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahm;
                eVar6.vA = String.valueOf(eVar6.vA) + "_responseCode:" + this.responseCode;
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

    public byte[] dN(String str) {
        return dM(str);
    }

    private boolean vO() {
        if (this.ahi.vQ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aht + 1;
            aht = i;
            if (i >= 5) {
                aht = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
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
                    vN();
                    if (this.ahk != null) {
                        cancel();
                    }
                    this.ahg = new com.baidu.adp.lib.network.http.f();
                    this.ahk = new f(this.ahg);
                    this.ahg.fB().setUrl(str);
                    if (this.ahh != null) {
                        for (Map.Entry<String, String> entry : this.ahh.entrySet()) {
                            this.ahg.fB().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahk.d(null, null, -1);
                    this.ahi = this.ahg.fC();
                    dM = this.ahg.fC().vT;
                    this.responseCode = this.ahg.fC().responseCode;
                    this.errorCode = this.ahg.fC().vR;
                    this.ahq = this.ahg.fC().fI();
                    if (this.mUseHttpAutoSwitch && vO()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        aho = 0;
                        ahn = 0;
                        ahp = 0;
                    }
                    if (this.ahs) {
                        int i3 = ahn + 1;
                        ahn = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            aho++;
                            if (ahn == 1) {
                                ahp = this.errorCode;
                            }
                        }
                        if (ahn == 2) {
                            u.a("T2A", ahp, this.errorCode, aho);
                            this.ahs = false;
                        }
                    }
                    if (dM != null) {
                        this.dataSize = dM.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GS = this.ahk.ef();
                    this.ahr = this.ahk.vL();
                    int size = this.ahg.fD().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.ahg.fD().get(i2) != null) {
                                sb.append(this.ahg.fD().get(i2).vD);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahm = this.ahg.fE();
                    if (this.ahm != null) {
                        this.ahm.vA = String.valueOf(eVar7.vA) + sb.toString();
                        this.ahm.vA = String.valueOf(eVar8.vA) + "_responseCode:" + this.responseCode;
                        this.ahm.vA = String.valueOf(eVar9.vA) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.ahg.fD().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.ahg.fD().get(i2) != null) {
                                sb.append(this.ahg.fD().get(i2).vD);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahm = this.ahg.fE();
                    if (this.ahm != null) {
                        this.ahm.vA = String.valueOf(eVar.vA) + sb.toString();
                        this.ahm.vA = String.valueOf(eVar2.vA) + "_responseCode:" + this.responseCode;
                        this.ahm.vA = String.valueOf(eVar3.vA) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.ahg.fD().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.ahg.fD().get(i2) != null) {
                            sb.append(this.ahg.fD().get(i2).vD);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahm = this.ahg.fE();
                if (this.ahm != null) {
                    this.ahm.vA = String.valueOf(eVar4.vA) + sb.toString();
                    this.ahm.vA = String.valueOf(eVar5.vA) + "_responseCode:" + this.responseCode;
                    this.ahm.vA = String.valueOf(eVar6.vA) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dM = dM(str);
                int i4 = ahn + 1;
                ahn = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahn == 1) {
                        ahp = this.errorCode;
                    }
                    aho++;
                }
                if (ahn == 2) {
                    u.a("A2T", ahp, this.errorCode, aho);
                }
                if (vO()) {
                    this.mUseHttpClient = true;
                    this.ahs = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    aho = 0;
                    ahn = 0;
                    ahp = 0;
                }
                if (dM == null) {
                    return null;
                }
                if (this.ahg != null && this.ahg.fC().vS != null) {
                    List<String> list = this.ahg.fC().vS.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ahg.fC().vS.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.GS = true;
                        } else {
                            this.GS = false;
                        }
                    }
                    List<String> list3 = this.ahg.fC().vS.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahr = false;
                            i = i2;
                            if (this.ahq && ((z || i != 0) && new String(dM, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dM, 23, dM.length);
                            }
                        } else {
                            this.ahr = true;
                        }
                    }
                }
                i = i2;
                if (this.ahq) {
                    return copyOfRange(dM, 23, dM.length);
                }
            } catch (Exception e2) {
                this.vA = String.valueOf(this.vA) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.ahg.fD().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.ahg.fD().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.vA);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.vx);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.vv);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.vw);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.vz);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.vB);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.vy);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.vC);
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
            this.vA = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ahq = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.om != null) {
            this.om.cancel();
        }
        if (this.ahk != null) {
            this.ahk.cancel();
            this.ahk = null;
        }
    }

    public boolean vP() {
        if (this.ahk == null) {
            return false;
        }
        return this.ahk.agS;
    }
}
