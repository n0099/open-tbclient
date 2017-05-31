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
    private static int aha = 5;
    private static int ahe = 0;
    private static int ahf = 0;
    private static int ahg = 0;
    private static int ahk = 0;
    private com.baidu.adp.lib.network.http.f agX;
    private f ahb;
    private volatile com.baidu.adp.lib.network.http.d om = null;
    private HashMap<String, String> agY = null;
    private com.baidu.adp.lib.network.http.h agZ = new com.baidu.adp.lib.network.http.h();
    public boolean ahc = false;
    public boolean GS = false;
    public String vA = "";
    public com.baidu.adp.lib.network.http.e ahd = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ahh = false;
    public boolean ahi = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean ahj = false;

    public boolean vJ() {
        return this.ahh;
    }

    public com.baidu.adp.lib.network.http.h fC() {
        return this.agZ;
    }

    public void vK() {
        this.ahd = null;
        this.vA = "";
        this.ahh = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GS = false;
        this.ahc = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dJ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vK();
                if (this.agX != null) {
                    cancel();
                    this.om = null;
                }
                this.agX = new com.baidu.adp.lib.network.http.f();
                this.agX.fB().setUrl(str);
                if (this.agY != null) {
                    for (Map.Entry<String, String> entry : this.agY.entrySet()) {
                        this.agX.fB().n(entry.getKey(), entry.getValue());
                    }
                }
                this.om = new com.baidu.adp.lib.network.http.d(this.agX);
                this.om.d(aha, 0, 0);
                this.agZ = this.agX.fC();
                byte[] bArr = this.agX.fC().vT;
                this.responseCode = this.agX.fC().responseCode;
                this.errorCode = this.agX.fC().vR;
                this.ahh = this.agX.fC().fI();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.agX.fC().contentEncoding != null && this.agX.fC().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ahc = true;
                    bArr = y(bArr);
                }
                if (!this.ahh) {
                    a(str, null);
                }
                this.ahd = this.agX.fE();
                if (this.ahd != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ahd;
                    eVar.vA = String.valueOf(eVar.vA) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ahd;
                    eVar2.vA = String.valueOf(eVar2.vA) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ahd = this.agX.fE();
                if (this.ahd != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ahd;
                    eVar3.vA = String.valueOf(eVar3.vA) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ahd;
                    eVar4.vA = String.valueOf(eVar4.vA) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ahd = this.agX.fE();
            if (this.ahd != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ahd;
                eVar5.vA = String.valueOf(eVar5.vA) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ahd;
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

    public byte[] dK(String str) {
        return dJ(str);
    }

    private boolean vL() {
        if (this.agZ.vQ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ahk + 1;
            ahk = i;
            if (i >= 5) {
                ahk = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] j(String str, boolean z) {
        byte[] dJ;
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
                    vK();
                    if (this.ahb != null) {
                        cancel();
                    }
                    this.agX = new com.baidu.adp.lib.network.http.f();
                    this.ahb = new f(this.agX);
                    this.agX.fB().setUrl(str);
                    if (this.agY != null) {
                        for (Map.Entry<String, String> entry : this.agY.entrySet()) {
                            this.agX.fB().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.ahb.d(null, null, -1);
                    this.agZ = this.agX.fC();
                    dJ = this.agX.fC().vT;
                    this.responseCode = this.agX.fC().responseCode;
                    this.errorCode = this.agX.fC().vR;
                    this.ahh = this.agX.fC().fI();
                    if (this.mUseHttpAutoSwitch && vL()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ahf = 0;
                        ahe = 0;
                        ahg = 0;
                    }
                    if (this.ahj) {
                        int i3 = ahe + 1;
                        ahe = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ahf++;
                            if (ahe == 1) {
                                ahg = this.errorCode;
                            }
                        }
                        if (ahe == 2) {
                            u.a("T2A", ahg, this.errorCode, ahf);
                            this.ahj = false;
                        }
                    }
                    if (dJ != null) {
                        this.dataSize = dJ.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GS = this.ahb.ef();
                    this.ahi = this.ahb.vI();
                    int size = this.agX.fD().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.agX.fD().get(i2) != null) {
                                sb.append(this.agX.fD().get(i2).vD);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahd = this.agX.fE();
                    if (this.ahd != null) {
                        this.ahd.vA = String.valueOf(eVar7.vA) + sb.toString();
                        this.ahd.vA = String.valueOf(eVar8.vA) + "_responseCode:" + this.responseCode;
                        this.ahd.vA = String.valueOf(eVar9.vA) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.agX.fD().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.agX.fD().get(i2) != null) {
                                sb.append(this.agX.fD().get(i2).vD);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ahd = this.agX.fE();
                    if (this.ahd != null) {
                        this.ahd.vA = String.valueOf(eVar.vA) + sb.toString();
                        this.ahd.vA = String.valueOf(eVar2.vA) + "_responseCode:" + this.responseCode;
                        this.ahd.vA = String.valueOf(eVar3.vA) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.agX.fD().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.agX.fD().get(i2) != null) {
                            sb.append(this.agX.fD().get(i2).vD);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ahd = this.agX.fE();
                if (this.ahd != null) {
                    this.ahd.vA = String.valueOf(eVar4.vA) + sb.toString();
                    this.ahd.vA = String.valueOf(eVar5.vA) + "_responseCode:" + this.responseCode;
                    this.ahd.vA = String.valueOf(eVar6.vA) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dJ = dJ(str);
                int i4 = ahe + 1;
                ahe = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ahe == 1) {
                        ahg = this.errorCode;
                    }
                    ahf++;
                }
                if (ahe == 2) {
                    u.a("A2T", ahg, this.errorCode, ahf);
                }
                if (vL()) {
                    this.mUseHttpClient = true;
                    this.ahj = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ahf = 0;
                    ahe = 0;
                    ahg = 0;
                }
                if (dJ == null) {
                    return null;
                }
                if (this.agX != null && this.agX.fC().vS != null) {
                    List<String> list = this.agX.fC().vS.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.agX.fC().vS.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.GS = true;
                        } else {
                            this.GS = false;
                        }
                    }
                    List<String> list3 = this.agX.fC().vS.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ahi = false;
                            i = i2;
                            if (this.ahh && ((z || i != 0) && new String(dJ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dJ, 23, dJ.length);
                            }
                        } else {
                            this.ahi = true;
                        }
                    }
                }
                i = i2;
                if (this.ahh) {
                    return copyOfRange(dJ, 23, dJ.length);
                }
            } catch (Exception e2) {
                this.vA = String.valueOf(this.vA) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.agX.fD().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.agX.fD().get(i);
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
            this.ahh = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.om != null) {
            this.om.cancel();
        }
        if (this.ahb != null) {
            this.ahb.cancel();
            this.ahb = null;
        }
    }

    public boolean vM() {
        if (this.ahb == null) {
            return false;
        }
        return this.ahb.agJ;
    }
}
