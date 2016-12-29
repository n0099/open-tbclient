package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0006a {
    private static int ada = 5;
    private static int adf = 0;
    private static int adg = 0;
    private static int adh = 0;
    private static int adl = 0;
    private com.baidu.adp.lib.network.http.f acX;
    private f adb;
    private volatile com.baidu.adp.lib.network.http.d gX = null;
    private HashMap<String, String> acY = null;
    private com.baidu.adp.lib.network.http.h acZ = new com.baidu.adp.lib.network.http.h();
    public boolean adc = false;
    public boolean Al = false;
    public String ol = "";
    public com.baidu.adp.lib.network.http.e ade = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean adi = false;
    public boolean adj = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean adk = false;

    public boolean vK() {
        return this.adi;
    }

    public com.baidu.adp.lib.network.http.h eq() {
        return this.acZ;
    }

    public void vL() {
        this.ade = null;
        this.ol = "";
        this.adi = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Al = false;
        this.adc = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dQ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vL();
                if (this.acX != null) {
                    cancel();
                    this.gX = null;
                }
                this.acX = new com.baidu.adp.lib.network.http.f();
                this.acX.ep().setUrl(str);
                if (this.acY != null) {
                    for (Map.Entry<String, String> entry : this.acY.entrySet()) {
                        this.acX.ep().n(entry.getKey(), entry.getValue());
                    }
                }
                this.gX = new com.baidu.adp.lib.network.http.d(this.acX);
                this.gX.e(ada, 0, 0);
                this.acZ = this.acX.eq();
                byte[] bArr = this.acX.eq().oH;
                this.responseCode = this.acX.eq().responseCode;
                this.errorCode = this.acX.eq().oF;
                this.adi = this.acX.eq().ew();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.acX.eq().contentEncoding != null && this.acX.eq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adc = true;
                    bArr = y(bArr);
                }
                if (!this.adi) {
                    a(str, null);
                }
                this.ade = this.acX.es();
                if (this.ade != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.ade;
                    eVar.ol = String.valueOf(eVar.ol) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.ade;
                    eVar2.ol = String.valueOf(eVar2.ol) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ade = this.acX.es();
                if (this.ade != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.ade;
                    eVar3.ol = String.valueOf(eVar3.ol) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.ade;
                    eVar4.ol = String.valueOf(eVar4.ol) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ade = this.acX.es();
            if (this.ade != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.ade;
                eVar5.ol = String.valueOf(eVar5.ol) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.ade;
                eVar6.ol = String.valueOf(eVar6.ol) + "_responseCode:" + this.responseCode;
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

    public byte[] dR(String str) {
        return dQ(str);
    }

    private boolean vM() {
        if (this.acZ.oE) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = adl + 1;
            adl = i;
            if (i >= 5) {
                adl = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
        byte[] dQ;
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
                    vL();
                    if (this.adb != null) {
                        cancel();
                    }
                    this.acX = new com.baidu.adp.lib.network.http.f();
                    this.adb = new f(this.acX);
                    this.acX.ep().setUrl(str);
                    if (this.acY != null) {
                        for (Map.Entry<String, String> entry : this.acY.entrySet()) {
                            this.acX.ep().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adb.d(null, null, -1);
                    this.acZ = this.acX.eq();
                    dQ = this.acX.eq().oH;
                    this.responseCode = this.acX.eq().responseCode;
                    this.errorCode = this.acX.eq().oF;
                    this.adi = this.acX.eq().ew();
                    if (this.mUseHttpAutoSwitch && vM()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        adg = 0;
                        adf = 0;
                        adh = 0;
                    }
                    if (this.adk) {
                        int i3 = adf + 1;
                        adf = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            adg++;
                            if (adf == 1) {
                                adh = this.errorCode;
                            }
                        }
                        if (adf == 2) {
                            u.a("T2A", adh, this.errorCode, adg);
                            this.adk = false;
                        }
                    }
                    if (dQ != null) {
                        this.dataSize = dQ.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Al = this.adb.cY();
                    this.adj = this.adb.vJ();
                    int size = this.acX.er().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.acX.er().get(i2) != null) {
                                sb.append(this.acX.er().get(i2).oq);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ade = this.acX.es();
                    if (this.ade != null) {
                        this.ade.ol = String.valueOf(eVar7.ol) + sb.toString();
                        this.ade.ol = String.valueOf(eVar8.ol) + "_responseCode:" + this.responseCode;
                        this.ade.ol = String.valueOf(eVar9.ol) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.acX.er().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.acX.er().get(i2) != null) {
                                sb.append(this.acX.er().get(i2).oq);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.ade = this.acX.es();
                    if (this.ade != null) {
                        this.ade.ol = String.valueOf(eVar.ol) + sb.toString();
                        this.ade.ol = String.valueOf(eVar2.ol) + "_responseCode:" + this.responseCode;
                        this.ade.ol = String.valueOf(eVar3.ol) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.acX.er().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.acX.er().get(i2) != null) {
                            sb.append(this.acX.er().get(i2).oq);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ade = this.acX.es();
                if (this.ade != null) {
                    this.ade.ol = String.valueOf(eVar4.ol) + sb.toString();
                    this.ade.ol = String.valueOf(eVar5.ol) + "_responseCode:" + this.responseCode;
                    this.ade.ol = String.valueOf(eVar6.ol) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dQ = dQ(str);
                int i4 = adf + 1;
                adf = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (adf == 1) {
                        adh = this.errorCode;
                    }
                    adg++;
                }
                if (adf == 2) {
                    u.a("A2T", adh, this.errorCode, adg);
                }
                if (vM()) {
                    this.mUseHttpClient = true;
                    this.adk = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    adg = 0;
                    adf = 0;
                    adh = 0;
                }
                if (dQ == null) {
                    return null;
                }
                if (this.acX != null && this.acX.eq().oG != null) {
                    List<String> list = this.acX.eq().oG.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.acX.eq().oG.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Al = true;
                        } else {
                            this.Al = false;
                        }
                    }
                    List<String> list3 = this.acX.eq().oG.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.adj = false;
                            i = i2;
                            if (this.adi && ((z || i != 0) && new String(dQ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dQ, 23, dQ.length);
                            }
                        } else {
                            this.adj = true;
                        }
                    }
                }
                i = i2;
                if (this.adi) {
                    return copyOfRange(dQ, 23, dQ.length);
                }
            } catch (Exception e2) {
                this.ol = String.valueOf(this.ol) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dQ;
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
            for (int i = 0; i < this.acX.er().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.acX.er().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.ol);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.oh);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.of);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.oe);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.og);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.oj);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.om);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.oi);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.oo);
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
            this.ol = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.adi = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.gX != null) {
            this.gX.cancel();
        }
        if (this.adb != null) {
            this.adb.cancel();
            this.adb = null;
        }
    }

    public boolean vN() {
        if (this.adb == null) {
            return false;
        }
        return this.adb.acJ;
    }
}
