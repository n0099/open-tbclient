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
    private static int adI = 5;
    private static int adM = 0;
    private static int adN = 0;
    private static int adO = 0;
    private static int adS = 0;
    private com.baidu.adp.lib.network.http.f adF;
    private f adJ;
    private volatile com.baidu.adp.lib.network.http.d gX = null;
    private HashMap<String, String> adG = null;
    private com.baidu.adp.lib.network.http.h adH = new com.baidu.adp.lib.network.http.h();
    public boolean adK = false;
    public boolean Al = false;
    public String ol = "";
    public com.baidu.adp.lib.network.http.e adL = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean adP = false;
    public boolean adQ = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m9getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m9getInst().isHttpAutoSwitch();
    private boolean adR = false;

    public boolean wa() {
        return this.adP;
    }

    public com.baidu.adp.lib.network.http.h eq() {
        return this.adH;
    }

    public void wb() {
        this.adL = null;
        this.ol = "";
        this.adP = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Al = false;
        this.adK = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dS(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wb();
                if (this.adF != null) {
                    cancel();
                    this.gX = null;
                }
                this.adF = new com.baidu.adp.lib.network.http.f();
                this.adF.ep().setUrl(str);
                if (this.adG != null) {
                    for (Map.Entry<String, String> entry : this.adG.entrySet()) {
                        this.adF.ep().n(entry.getKey(), entry.getValue());
                    }
                }
                this.gX = new com.baidu.adp.lib.network.http.d(this.adF);
                this.gX.e(adI, 0, 0);
                this.adH = this.adF.eq();
                byte[] bArr = this.adF.eq().oH;
                this.responseCode = this.adF.eq().responseCode;
                this.errorCode = this.adF.eq().oF;
                this.adP = this.adF.eq().ew();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.adF.eq().contentEncoding != null && this.adF.eq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adK = true;
                    bArr = y(bArr);
                }
                if (!this.adP) {
                    a(str, null);
                }
                this.adL = this.adF.es();
                if (this.adL != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.adL;
                    eVar.ol = String.valueOf(eVar.ol) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.adL;
                    eVar2.ol = String.valueOf(eVar2.ol) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.adL = this.adF.es();
                if (this.adL != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.adL;
                    eVar3.ol = String.valueOf(eVar3.ol) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.adL;
                    eVar4.ol = String.valueOf(eVar4.ol) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.adL = this.adF.es();
            if (this.adL != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.adL;
                eVar5.ol = String.valueOf(eVar5.ol) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.adL;
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

    public byte[] dT(String str) {
        return dS(str);
    }

    private boolean wc() {
        if (this.adH.oE) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = adS + 1;
            adS = i;
            if (i >= 5) {
                adS = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] m(String str, boolean z) {
        byte[] dS;
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
                    if (this.adJ != null) {
                        cancel();
                    }
                    this.adF = new com.baidu.adp.lib.network.http.f();
                    this.adJ = new f(this.adF);
                    this.adF.ep().setUrl(str);
                    if (this.adG != null) {
                        for (Map.Entry<String, String> entry : this.adG.entrySet()) {
                            this.adF.ep().n(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adJ.d(null, null, -1);
                    this.adH = this.adF.eq();
                    dS = this.adF.eq().oH;
                    this.responseCode = this.adF.eq().responseCode;
                    this.errorCode = this.adF.eq().oF;
                    this.adP = this.adF.eq().ew();
                    if (this.mUseHttpAutoSwitch && wc()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m9getInst().setHttpClientOpen(false);
                        adN = 0;
                        adM = 0;
                        adO = 0;
                    }
                    if (this.adR) {
                        int i3 = adM + 1;
                        adM = i3;
                        if (i3 <= 2 && this.responseCode != 200) {
                            adN++;
                            if (adM == 1) {
                                adO = this.errorCode;
                            }
                        }
                        if (adM == 2) {
                            u.a("T2A", adO, this.errorCode, adN);
                            this.adR = false;
                        }
                    }
                    if (dS != null) {
                        this.dataSize = dS.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Al = this.adJ.cY();
                    this.adQ = this.adJ.vZ();
                    int size = this.adF.er().size();
                    if (size > 0) {
                        sb.append("_ipsize:");
                        sb.append(size);
                        sb.append("_ips:");
                        while (i2 < size) {
                            if (this.adF.er().get(i2) != null) {
                                sb.append(this.adF.er().get(i2).oq);
                            }
                            if (i2 != size - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adL = this.adF.es();
                    if (this.adL != null) {
                        this.adL.ol = String.valueOf(eVar7.ol) + sb.toString();
                        this.adL.ol = String.valueOf(eVar8.ol) + "_responseCode:" + this.responseCode;
                        this.adL.ol = String.valueOf(eVar9.ol) + "_size:" + Integer.toString(this.dataSize);
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.adF.er().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i2 < size2) {
                            if (this.adF.er().get(i2) != null) {
                                sb.append(this.adF.er().get(i2).oq);
                            }
                            if (i2 != size2 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    this.adL = this.adF.es();
                    if (this.adL != null) {
                        this.adL.ol = String.valueOf(eVar.ol) + sb.toString();
                        this.adL.ol = String.valueOf(eVar2.ol) + "_responseCode:" + this.responseCode;
                        this.adL.ol = String.valueOf(eVar3.ol) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                int size3 = this.adF.er().size();
                if (size3 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size3);
                    sb.append("_ips:");
                    while (i2 < size3) {
                        if (this.adF.er().get(i2) != null) {
                            sb.append(this.adF.er().get(i2).oq);
                        }
                        if (i2 != size3 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.adL = this.adF.es();
                if (this.adL != null) {
                    this.adL.ol = String.valueOf(eVar4.ol) + sb.toString();
                    this.adL.ol = String.valueOf(eVar5.ol) + "_responseCode:" + this.responseCode;
                    this.adL.ol = String.valueOf(eVar6.ol) + "_size:" + Integer.toString(this.dataSize);
                }
                throw th;
            }
        } else {
            try {
                dS = dS(str);
                int i4 = adM + 1;
                adM = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (adM == 1) {
                        adO = this.errorCode;
                    }
                    adN++;
                }
                if (adM == 2) {
                    u.a("A2T", adO, this.errorCode, adN);
                }
                if (wc()) {
                    this.mUseHttpClient = true;
                    this.adR = true;
                    TbadkCoreApplication.m9getInst().setHttpClientOpen(true);
                    adN = 0;
                    adM = 0;
                    adO = 0;
                }
                if (dS == null) {
                    return null;
                }
                if (this.adF != null && this.adF.eq().oG != null) {
                    List<String> list = this.adF.eq().oG.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.adF.eq().oG.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Al = true;
                        } else {
                            this.Al = false;
                        }
                    }
                    List<String> list3 = this.adF.eq().oG.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.adQ = false;
                            i = i2;
                            if (this.adP && ((z || i != 0) && new String(dS, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                                return copyOfRange(dS, 23, dS.length);
                            }
                        } else {
                            this.adQ = true;
                        }
                    }
                }
                i = i2;
                if (this.adP) {
                    return copyOfRange(dS, 23, dS.length);
                }
            } catch (Exception e2) {
                this.ol = String.valueOf(this.ol) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dS;
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
            for (int i = 0; i < this.adF.er().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.adF.er().get(i);
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
            this.adP = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.gX != null) {
            this.gX.cancel();
        }
        if (this.adJ != null) {
            this.adJ.cancel();
            this.adJ = null;
        }
    }

    public boolean wd() {
        if (this.adJ == null) {
            return false;
        }
        return this.adJ.adr;
    }
}
