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
    private static int acY = 5;
    private static int adc = 0;
    private static int ade = 0;
    private static int adf = 0;
    private static int adj = 0;
    private com.baidu.adp.lib.network.http.f acV;
    private f acZ;
    private volatile com.baidu.adp.lib.network.http.d gW = null;
    private HashMap<String, String> acW = null;
    private com.baidu.adp.lib.network.http.h acX = new com.baidu.adp.lib.network.http.h();
    public boolean ada = false;
    public boolean Al = false;
    public String oj = "";
    public com.baidu.adp.lib.network.http.e adb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean adg = false;
    public boolean adh = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean adi = false;

    public boolean vI() {
        return this.adg;
    }

    public com.baidu.adp.lib.network.http.h eq() {
        return this.acX;
    }

    public void vJ() {
        this.adb = null;
        this.oj = "";
        this.adg = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Al = false;
        this.ada = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vJ();
                if (this.acV != null) {
                    cancel();
                    this.gW = null;
                }
                this.acV = new com.baidu.adp.lib.network.http.f();
                this.acV.ep().setUrl(str);
                if (this.acW != null) {
                    for (Map.Entry<String, String> entry : this.acW.entrySet()) {
                        this.acV.ep().n(entry.getKey(), entry.getValue());
                    }
                }
                this.gW = new com.baidu.adp.lib.network.http.d(this.acV);
                this.gW.e(acY, 0, 0);
                this.acX = this.acV.eq();
                byte[] bArr = this.acV.eq().oG;
                this.responseCode = this.acV.eq().responseCode;
                this.errorCode = this.acV.eq().oE;
                this.adg = this.acV.eq().ew();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.acV.eq().contentEncoding != null && this.acV.eq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ada = true;
                    bArr = y(bArr);
                }
                if (!this.adg) {
                    a(str, null);
                }
                this.adb = this.acV.es();
                if (this.adb != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.adb;
                    eVar.oj = String.valueOf(eVar.oj) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.adb;
                    eVar2.oj = String.valueOf(eVar2.oj) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.adb = this.acV.es();
                if (this.adb != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.adb;
                    eVar3.oj = String.valueOf(eVar3.oj) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.adb;
                    eVar4.oj = String.valueOf(eVar4.oj) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.adb = this.acV.es();
            if (this.adb != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.adb;
                eVar5.oj = String.valueOf(eVar5.oj) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.adb;
                eVar6.oj = String.valueOf(eVar6.oj) + "_responseCode:" + this.responseCode;
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

    public byte[] dO(String str) {
        return dN(str);
    }

    private boolean vK() {
        if (this.acX.oD) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = adj + 1;
            adj = i;
            if (i >= 5) {
                adj = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
        byte[] dN;
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
                    vJ();
                    if (this.acZ != null) {
                        cancel();
                    }
                    this.acV = new com.baidu.adp.lib.network.http.f();
                    this.acZ = new f(this.acV);
                    this.acV.ep().setUrl(str);
                    if (this.acW != null) {
                        for (Map.Entry<String, String> entry : this.acW.entrySet()) {
                            this.acV.ep().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.acZ.d(null, null, -1);
                    this.acX = this.acV.eq();
                    dN = this.acV.eq().oG;
                    this.responseCode = this.acV.eq().responseCode;
                    this.errorCode = this.acV.eq().oE;
                    this.adg = this.acV.eq().ew();
                    if (this.mUseHttpAutoSwitch && vK()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        ade = 0;
                        adc = 0;
                        adf = 0;
                    }
                    if (this.adi) {
                        int i3 = adc + 1;
                        adc = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            ade++;
                            if (adc == 1) {
                                adf = this.errorCode;
                            }
                        }
                        if (adc == 2) {
                            v.a("T2A", adf, this.errorCode, ade);
                            this.adi = false;
                        }
                    }
                    if (dN != null) {
                        this.dataSize = dN.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Al = this.acZ.cY();
                    this.adh = this.acZ.vH();
                    int size = this.acV.er().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.acV.er().get(i2) != null) {
                                sb.append(this.acV.er().get(i2).oo);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adb = this.acV.es();
                    if (this.adb != null) {
                        this.adb.oj = String.valueOf(eVar7.oj) + sb.toString();
                        this.adb.oj = String.valueOf(eVar8.oj) + "_responseCode:" + this.responseCode;
                        this.adb.oj = String.valueOf(eVar9.oj) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.acV.er().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.acV.er().get(i2) != null) {
                                sb.append(this.acV.er().get(i2).oo);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adb = this.acV.es();
                    if (this.adb != null) {
                        this.adb.oj = String.valueOf(eVar.oj) + sb.toString();
                        this.adb.oj = String.valueOf(eVar2.oj) + "_responseCode:" + this.responseCode;
                        this.adb.oj = String.valueOf(eVar3.oj) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.acV.er().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.acV.er().get(i2) != null) {
                            sb.append(this.acV.er().get(i2).oo);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.adb = this.acV.es();
                if (this.adb != null) {
                    this.adb.oj = String.valueOf(eVar4.oj) + sb.toString();
                    this.adb.oj = String.valueOf(eVar5.oj) + "_responseCode:" + this.responseCode;
                    this.adb.oj = String.valueOf(eVar6.oj) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dN = dN(str);
                int i4 = adc + 1;
                adc = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (adc == 1) {
                        adf = this.errorCode;
                    }
                    ade++;
                }
                if (adc == 2) {
                    v.a("A2T", adf, this.errorCode, ade);
                }
                if (vK()) {
                    this.mUseHttpClient = true;
                    this.adi = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    ade = 0;
                    adc = 0;
                    adf = 0;
                }
                if (dN == null) {
                    return null;
                }
                if (this.acV != null && this.acV.eq().oF != null) {
                    List<String> list = this.acV.eq().oF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.acV.eq().oF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Al = true;
                        } else {
                            this.Al = false;
                        }
                    }
                    List<String> list3 = this.acV.eq().oF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.adh = false;
                            i = i2;
                            if (this.adg && ((z || i != 0) && new String(dN, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dN, 23, dN.length);
                            }
                        } else {
                            this.adh = true;
                        }
                    }
                }
                i = i2;
                if (this.adg) {
                    return copyOfRange(dN, 23, dN.length);
                }
            } catch (Exception e2) {
                this.oj = String.valueOf(this.oj) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dN;
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
            for (int i = 0; i < this.acV.er().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.acV.er().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.oj);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.og);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.oe);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.od);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.of);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.oi);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.ol);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.oh);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.om);
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
            this.oj = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.adg = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.gW != null) {
            this.gW.cancel();
        }
        if (this.acZ != null) {
            this.acZ.cancel();
            this.acZ = null;
        }
    }

    public boolean vL() {
        if (this.acZ == null) {
            return false;
        }
        return this.acZ.acH;
    }
}
