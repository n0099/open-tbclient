package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0005a {
    private static int acm = 5;
    private static int acq = 0;
    private static int acr = 0;
    private static int acs = 0;
    private static int acw = 0;
    private com.baidu.adp.lib.network.http.f acj;
    private f acn;
    private volatile com.baidu.adp.lib.network.http.d gU = null;
    private HashMap<String, String> ack = null;
    private com.baidu.adp.lib.network.http.h acl = new com.baidu.adp.lib.network.http.h();
    public boolean aco = false;
    public boolean Aa = false;
    public String od = "";
    public com.baidu.adp.lib.network.http.e acp = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean act = false;
    public boolean acu = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean acv = false;

    public boolean vE() {
        return this.act;
    }

    public com.baidu.adp.lib.network.http.h eo() {
        return this.acl;
    }

    public void vF() {
        this.acp = null;
        this.od = "";
        this.act = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Aa = false;
        this.aco = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dO(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vF();
                if (this.acj != null) {
                    cancel();
                    this.gU = null;
                }
                this.acj = new com.baidu.adp.lib.network.http.f();
                this.acj.en().setUrl(str);
                if (this.ack != null) {
                    for (Map.Entry<String, String> entry : this.ack.entrySet()) {
                        this.acj.en().n(entry.getKey(), entry.getValue());
                    }
                }
                this.gU = new com.baidu.adp.lib.network.http.d(this.acj);
                this.gU.d(acm, 0, 0);
                this.acl = this.acj.eo();
                byte[] bArr = this.acj.eo().oA;
                this.responseCode = this.acj.eo().responseCode;
                this.errorCode = this.acj.eo().oy;
                this.act = this.acj.eo().eu();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.acj.eo().contentEncoding != null && this.acj.eo().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aco = true;
                    bArr = y(bArr);
                }
                if (!this.act) {
                    a(str, null);
                }
                this.acp = this.acj.eq();
                if (this.acp != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.acp;
                    eVar.od = String.valueOf(eVar.od) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.acp;
                    eVar2.od = String.valueOf(eVar2.od) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.acp = this.acj.eq();
                if (this.acp != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.acp;
                    eVar3.od = String.valueOf(eVar3.od) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.acp;
                    eVar4.od = String.valueOf(eVar4.od) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.acp = this.acj.eq();
            if (this.acp != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.acp;
                eVar5.od = String.valueOf(eVar5.od) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.acp;
                eVar6.od = String.valueOf(eVar6.od) + "_responseCode:" + this.responseCode;
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

    private boolean vG() {
        if (this.acl.ox) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = acw + 1;
            acw = i;
            if (i >= 5) {
                acw = 0;
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
                    vF();
                    if (this.acn != null) {
                        cancel();
                    }
                    this.acj = new com.baidu.adp.lib.network.http.f();
                    this.acn = new f(this.acj);
                    this.acj.en().setUrl(str);
                    if (this.ack != null) {
                        for (Map.Entry<String, String> entry : this.ack.entrySet()) {
                            this.acj.en().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.acn.d(null, null, -1);
                    this.acl = this.acj.eo();
                    dO = this.acj.eo().oA;
                    this.responseCode = this.acj.eo().responseCode;
                    this.errorCode = this.acj.eo().oy;
                    this.act = this.acj.eo().eu();
                    if (this.mUseHttpAutoSwitch && vG()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        acr = 0;
                        acq = 0;
                        acs = 0;
                    }
                    if (this.acv) {
                        int i3 = acq + 1;
                        acq = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            acr++;
                            if (acq == 1) {
                                acs = this.errorCode;
                            }
                        }
                        if (acq == 2) {
                            t.a("T2A", acs, this.errorCode, acr);
                            this.acv = false;
                        }
                    }
                    if (dO != null) {
                        this.dataSize = dO.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Aa = this.acn.cW();
                    this.acu = this.acn.vD();
                    int size = this.acj.ep().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.acj.ep().get(i2) != null) {
                                sb.append(this.acj.ep().get(i2).og);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.acp = this.acj.eq();
                    if (this.acp != null) {
                        this.acp.od = String.valueOf(eVar7.od) + sb.toString();
                        this.acp.od = String.valueOf(eVar8.od) + "_responseCode:" + this.responseCode;
                        this.acp.od = String.valueOf(eVar9.od) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.acj.ep().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.acj.ep().get(i2) != null) {
                                sb.append(this.acj.ep().get(i2).og);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.acp = this.acj.eq();
                    if (this.acp != null) {
                        this.acp.od = String.valueOf(eVar.od) + sb.toString();
                        this.acp.od = String.valueOf(eVar2.od) + "_responseCode:" + this.responseCode;
                        this.acp.od = String.valueOf(eVar3.od) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.acj.ep().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.acj.ep().get(i2) != null) {
                            sb.append(this.acj.ep().get(i2).og);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.acp = this.acj.eq();
                if (this.acp != null) {
                    this.acp.od = String.valueOf(eVar4.od) + sb.toString();
                    this.acp.od = String.valueOf(eVar5.od) + "_responseCode:" + this.responseCode;
                    this.acp.od = String.valueOf(eVar6.od) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dO = dO(str);
                int i4 = acq + 1;
                acq = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (acq == 1) {
                        acs = this.errorCode;
                    }
                    acr++;
                }
                if (acq == 2) {
                    t.a("A2T", acs, this.errorCode, acr);
                }
                if (vG()) {
                    this.mUseHttpClient = true;
                    this.acv = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    acr = 0;
                    acq = 0;
                    acs = 0;
                }
                if (dO == null) {
                    return null;
                }
                if (this.acj != null && this.acj.eo().oz != null) {
                    List<String> list = this.acj.eo().oz.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.acj.eo().oz.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Aa = true;
                        } else {
                            this.Aa = false;
                        }
                    }
                    List<String> list3 = this.acj.eo().oz.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.acu = false;
                            i = i2;
                            if (this.act && ((z || i != 0) && new String(dO, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dO, 23, dO.length);
                            }
                        } else {
                            this.acu = true;
                        }
                    }
                }
                i = i2;
                if (this.act) {
                    return copyOfRange(dO, 23, dO.length);
                }
            } catch (Exception e2) {
                this.od = String.valueOf(this.od) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.acj.ep().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.acj.ep().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.od);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.oa);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.nY);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.nX);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.nZ);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.oc);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.oe);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.ob);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.of);
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
            this.od = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.act = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.gU != null) {
            this.gU.cancel();
        }
        if (this.acn != null) {
            this.acn.cancel();
            this.acn = null;
        }
    }

    public boolean vH() {
        if (this.acn == null) {
            return false;
        }
        return this.acn.abV;
    }
}
