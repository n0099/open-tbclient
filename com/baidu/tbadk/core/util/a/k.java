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
    private static int adk = 5;
    private static int ado = 0;
    private static int adp = 0;
    private static int adq = 0;
    private static int adu = 0;
    private com.baidu.adp.lib.network.http.f adh;
    private f adl;
    private volatile com.baidu.adp.lib.network.http.d gW = null;
    private HashMap<String, String> adi = null;
    private com.baidu.adp.lib.network.http.h adj = new com.baidu.adp.lib.network.http.h();
    public boolean adm = false;
    public boolean Al = false;
    public String oj = "";
    public com.baidu.adp.lib.network.http.e adn = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean adr = false;
    public boolean ads = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean adt = false;

    public boolean vW() {
        return this.adr;
    }

    public com.baidu.adp.lib.network.http.h eq() {
        return this.adj;
    }

    public void vX() {
        this.adn = null;
        this.oj = "";
        this.adr = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Al = false;
        this.adm = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dQ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vX();
                if (this.adh != null) {
                    cancel();
                    this.gW = null;
                }
                this.adh = new com.baidu.adp.lib.network.http.f();
                this.adh.ep().setUrl(str);
                if (this.adi != null) {
                    for (Map.Entry<String, String> entry : this.adi.entrySet()) {
                        this.adh.ep().n(entry.getKey(), entry.getValue());
                    }
                }
                this.gW = new com.baidu.adp.lib.network.http.d(this.adh);
                this.gW.e(adk, 0, 0);
                this.adj = this.adh.eq();
                byte[] bArr = this.adh.eq().oG;
                this.responseCode = this.adh.eq().responseCode;
                this.errorCode = this.adh.eq().oE;
                this.adr = this.adh.eq().ew();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.adh.eq().contentEncoding != null && this.adh.eq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adm = true;
                    bArr = y(bArr);
                }
                if (!this.adr) {
                    a(str, null);
                }
                this.adn = this.adh.es();
                if (this.adn != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.adn;
                    eVar.oj = String.valueOf(eVar.oj) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.adn;
                    eVar2.oj = String.valueOf(eVar2.oj) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.adn = this.adh.es();
                if (this.adn != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.adn;
                    eVar3.oj = String.valueOf(eVar3.oj) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.adn;
                    eVar4.oj = String.valueOf(eVar4.oj) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.adn = this.adh.es();
            if (this.adn != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.adn;
                eVar5.oj = String.valueOf(eVar5.oj) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.adn;
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

    public byte[] dR(String str) {
        return dQ(str);
    }

    private boolean vY() {
        if (this.adj.oD) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = adu + 1;
            adu = i;
            if (i >= 5) {
                adu = 0;
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
                    vX();
                    if (this.adl != null) {
                        cancel();
                    }
                    this.adh = new com.baidu.adp.lib.network.http.f();
                    this.adl = new f(this.adh);
                    this.adh.ep().setUrl(str);
                    if (this.adi != null) {
                        for (Map.Entry<String, String> entry : this.adi.entrySet()) {
                            this.adh.ep().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adl.d(null, null, -1);
                    this.adj = this.adh.eq();
                    dQ = this.adh.eq().oG;
                    this.responseCode = this.adh.eq().responseCode;
                    this.errorCode = this.adh.eq().oE;
                    this.adr = this.adh.eq().ew();
                    if (this.mUseHttpAutoSwitch && vY()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        adp = 0;
                        ado = 0;
                        adq = 0;
                    }
                    if (this.adt) {
                        int i3 = ado + 1;
                        ado = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            adp++;
                            if (ado == 1) {
                                adq = this.errorCode;
                            }
                        }
                        if (ado == 2) {
                            v.a("T2A", adq, this.errorCode, adp);
                            this.adt = false;
                        }
                    }
                    if (dQ != null) {
                        this.dataSize = dQ.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Al = this.adl.cY();
                    this.ads = this.adl.vV();
                    int size = this.adh.er().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.adh.er().get(i2) != null) {
                                sb.append(this.adh.er().get(i2).oo);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adn = this.adh.es();
                    if (this.adn != null) {
                        this.adn.oj = String.valueOf(eVar7.oj) + sb.toString();
                        this.adn.oj = String.valueOf(eVar8.oj) + "_responseCode:" + this.responseCode;
                        this.adn.oj = String.valueOf(eVar9.oj) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.adh.er().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.adh.er().get(i2) != null) {
                                sb.append(this.adh.er().get(i2).oo);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adn = this.adh.es();
                    if (this.adn != null) {
                        this.adn.oj = String.valueOf(eVar.oj) + sb.toString();
                        this.adn.oj = String.valueOf(eVar2.oj) + "_responseCode:" + this.responseCode;
                        this.adn.oj = String.valueOf(eVar3.oj) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.adh.er().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.adh.er().get(i2) != null) {
                            sb.append(this.adh.er().get(i2).oo);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.adn = this.adh.es();
                if (this.adn != null) {
                    this.adn.oj = String.valueOf(eVar4.oj) + sb.toString();
                    this.adn.oj = String.valueOf(eVar5.oj) + "_responseCode:" + this.responseCode;
                    this.adn.oj = String.valueOf(eVar6.oj) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dQ = dQ(str);
                int i4 = ado + 1;
                ado = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (ado == 1) {
                        adq = this.errorCode;
                    }
                    adp++;
                }
                if (ado == 2) {
                    v.a("A2T", adq, this.errorCode, adp);
                }
                if (vY()) {
                    this.mUseHttpClient = true;
                    this.adt = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    adp = 0;
                    ado = 0;
                    adq = 0;
                }
                if (dQ == null) {
                    return null;
                }
                if (this.adh != null && this.adh.eq().oF != null) {
                    List<String> list = this.adh.eq().oF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.adh.eq().oF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Al = true;
                        } else {
                            this.Al = false;
                        }
                    }
                    List<String> list3 = this.adh.eq().oF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ads = false;
                            i = i2;
                            if (this.adr && ((z || i != 0) && new String(dQ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dQ, 23, dQ.length);
                            }
                        } else {
                            this.ads = true;
                        }
                    }
                }
                i = i2;
                if (this.adr) {
                    return copyOfRange(dQ, 23, dQ.length);
                }
            } catch (Exception e2) {
                this.oj = String.valueOf(this.oj) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.adh.er().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.adh.er().get(i);
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
            this.adr = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.gW != null) {
            this.gW.cancel();
        }
        if (this.adl != null) {
            this.adl.cancel();
            this.adl = null;
        }
    }

    public boolean vZ() {
        if (this.adl == null) {
            return false;
        }
        return this.adl.acS;
    }
}
