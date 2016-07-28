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
    private static int aaj = 5;
    private static int aan = 0;
    private static int aao = 0;
    private static int aap = 0;
    private static int aat = 0;
    private com.baidu.adp.lib.network.http.f aag;
    private f aak;
    private volatile com.baidu.adp.lib.network.http.d eK = null;
    private HashMap<String, String> aah = null;
    private com.baidu.adp.lib.network.http.h aai = new com.baidu.adp.lib.network.http.h();
    public boolean aal = false;
    public boolean xY = false;
    public String lQ = "";
    public com.baidu.adp.lib.network.http.e aam = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aaq = false;
    public boolean aar = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m10getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m10getInst().isHttpAutoSwitch();
    private boolean aas = false;

    public boolean uD() {
        return this.aaq;
    }

    public com.baidu.adp.lib.network.http.h dv() {
        return this.aai;
    }

    public void uE() {
        this.aam = null;
        this.lQ = "";
        this.aaq = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.xY = false;
        this.aal = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dL(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                uE();
                if (this.aag != null) {
                    cancel();
                    this.eK = null;
                }
                this.aag = new com.baidu.adp.lib.network.http.f();
                this.aag.du().setUrl(str);
                if (this.aah != null) {
                    for (Map.Entry<String, String> entry : this.aah.entrySet()) {
                        this.aag.du().n(entry.getKey(), entry.getValue());
                    }
                }
                this.eK = new com.baidu.adp.lib.network.http.d(this.aag);
                this.eK.e(aaj, 0, 0);
                this.aai = this.aag.dv();
                byte[] bArr = this.aag.dv().mk;
                this.responseCode = this.aag.dv().responseCode;
                this.errorCode = this.aag.dv().mi;
                this.aaq = this.aag.dv().dB();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aag.dv().contentEncoding != null && this.aag.dv().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aal = true;
                    bArr = y(bArr);
                }
                if (!this.aaq) {
                    a(str, null);
                }
                this.aam = this.aag.dx();
                if (this.aam != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.aam;
                    eVar.lQ = String.valueOf(eVar.lQ) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.aam;
                    eVar2.lQ = String.valueOf(eVar2.lQ) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aam = this.aag.dx();
                if (this.aam != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.aam;
                    eVar3.lQ = String.valueOf(eVar3.lQ) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.aam;
                    eVar4.lQ = String.valueOf(eVar4.lQ) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aam = this.aag.dx();
            if (this.aam != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.aam;
                eVar5.lQ = String.valueOf(eVar5.lQ) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.aam;
                eVar6.lQ = String.valueOf(eVar6.lQ) + "_responseCode:" + this.responseCode;
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

    public byte[] dM(String str) {
        return dL(str);
    }

    private boolean uF() {
        if (this.aai.mh) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aat + 1;
            aat = i;
            if (i >= 5) {
                aat = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] l(String str, boolean z) {
        byte[] dL;
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
                    uE();
                    if (this.aak != null) {
                        cancel();
                    }
                    this.aag = new com.baidu.adp.lib.network.http.f();
                    this.aak = new f(this.aag);
                    this.aag.du().setUrl(str);
                    if (this.aah != null) {
                        for (Map.Entry<String, String> entry : this.aah.entrySet()) {
                            this.aag.du().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.aak.d(null, null, -1);
                    this.aai = this.aag.dv();
                    dL = this.aag.dv().mk;
                    this.responseCode = this.aag.dv().responseCode;
                    this.errorCode = this.aag.dv().mi;
                    this.aaq = this.aag.dv().dB();
                    if (this.mUseHttpAutoSwitch && uF()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m10getInst().setHttpClientOpen(false);
                        aao = 0;
                        aan = 0;
                        aap = 0;
                    }
                    if (this.aas) {
                        int i3 = aan + 1;
                        aan = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            aao++;
                            if (aan == 1) {
                                aap = this.errorCode;
                            }
                        }
                        if (aan == 2) {
                            v.a("T2A", aap, this.errorCode, aao);
                            this.aas = false;
                        }
                    }
                    if (dL != null) {
                        this.dataSize = dL.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.xY = this.aak.cd();
                    this.aar = this.aak.uC();
                    int size = this.aag.dw().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.aag.dw().get(i2) != null) {
                                sb.append(this.aag.dw().get(i2).lT);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.aam = this.aag.dx();
                    if (this.aam != null) {
                        this.aam.lQ = String.valueOf(eVar7.lQ) + sb.toString();
                        this.aam.lQ = String.valueOf(eVar8.lQ) + "_responseCode:" + this.responseCode;
                        this.aam.lQ = String.valueOf(eVar9.lQ) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.aag.dw().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.aag.dw().get(i2) != null) {
                                sb.append(this.aag.dw().get(i2).lT);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.aam = this.aag.dx();
                    if (this.aam != null) {
                        this.aam.lQ = String.valueOf(eVar.lQ) + sb.toString();
                        this.aam.lQ = String.valueOf(eVar2.lQ) + "_responseCode:" + this.responseCode;
                        this.aam.lQ = String.valueOf(eVar3.lQ) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.aag.dw().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.aag.dw().get(i2) != null) {
                            sb.append(this.aag.dw().get(i2).lT);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aam = this.aag.dx();
                if (this.aam != null) {
                    this.aam.lQ = String.valueOf(eVar4.lQ) + sb.toString();
                    this.aam.lQ = String.valueOf(eVar5.lQ) + "_responseCode:" + this.responseCode;
                    this.aam.lQ = String.valueOf(eVar6.lQ) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dL = dL(str);
                int i4 = aan + 1;
                aan = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (aan == 1) {
                        aap = this.errorCode;
                    }
                    aao++;
                }
                if (aan == 2) {
                    v.a("A2T", aap, this.errorCode, aao);
                }
                if (uF()) {
                    this.mUseHttpClient = true;
                    this.aas = true;
                    TbadkCoreApplication.m10getInst().setHttpClientOpen(true);
                    aao = 0;
                    aan = 0;
                    aap = 0;
                }
                if (dL == null) {
                    return null;
                }
                if (this.aag != null && this.aag.dv().mj != null) {
                    List<String> list = this.aag.dv().mj.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aag.dv().mj.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.xY = true;
                        } else {
                            this.xY = false;
                        }
                    }
                    List<String> list3 = this.aag.dv().mj.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aar = false;
                            i = i2;
                            if (this.aaq && ((z || i != 0) && new String(dL, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dL, 23, dL.length);
                            }
                        } else {
                            this.aar = true;
                        }
                    }
                }
                i = i2;
                if (this.aaq) {
                    return copyOfRange(dL, 23, dL.length);
                }
            } catch (Exception e2) {
                this.lQ = String.valueOf(this.lQ) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dL;
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
            for (int i = 0; i < this.aag.dw().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.aag.dw().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.lQ);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.lN);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.lL);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.lK);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.lM);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.lP);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.lR);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.lO);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.lS);
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
            this.lQ = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aaq = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.eK != null) {
            this.eK.cancel();
        }
        if (this.aak != null) {
            this.aak.cancel();
            this.aak = null;
        }
    }

    public boolean uG() {
        if (this.aak == null) {
            return false;
        }
        return this.aak.ZS;
    }
}
