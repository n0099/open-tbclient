package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0018a {
    private static int aYG = 5;
    private static int aYK = 0;
    private static int aYL = 0;
    private static int aYM = 0;
    private static int aYQ = 0;
    private com.baidu.adp.lib.network.http.e aYD;
    private f aYH;
    private volatile com.baidu.adp.lib.network.http.c acm = null;
    private HashMap<String, String> aYE = null;
    private com.baidu.adp.lib.network.http.g aYF = new com.baidu.adp.lib.network.http.g();
    public boolean aYI = false;
    public boolean isGif = false;
    public String ajf = "";
    public com.baidu.adp.lib.network.http.d aYJ = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aYN = false;
    public boolean aYO = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aYP = false;

    public boolean DD() {
        return this.aYN;
    }

    public com.baidu.adp.lib.network.http.g nc() {
        return this.aYF;
    }

    public void DE() {
        this.aYJ = null;
        this.ajf = "";
        this.aYN = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aYI = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eF(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                DE();
                if (this.aYD != null) {
                    cancel();
                    this.acm = null;
                }
                this.aYD = new com.baidu.adp.lib.network.http.e();
                this.aYD.nb().setUrl(str);
                if (this.aYE != null) {
                    for (Map.Entry<String, String> entry : this.aYE.entrySet()) {
                        this.aYD.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.acm = new com.baidu.adp.lib.network.http.c(this.aYD);
                this.acm.m(aYG, 0, 0);
                this.aYF = this.aYD.nc();
                byte[] bArr = this.aYD.nc().ajy;
                this.responseCode = this.aYD.nc().responseCode;
                this.errorCode = this.aYD.nc().ajw;
                this.aYN = this.aYD.nc().ni();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aYD.nc().contentEncoding != null && this.aYD.nc().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aYI = true;
                    bArr = w(bArr);
                }
                if (!this.aYN) {
                    c(str, null);
                }
                this.aYJ = this.aYD.ne();
                if (this.aYJ != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYJ;
                    dVar.ajf = sb.append(dVar.ajf).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYJ;
                    dVar2.ajf = sb2.append(dVar2.ajf).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aYJ = this.aYD.ne();
                if (this.aYJ != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYJ;
                    dVar3.ajf = sb3.append(dVar3.ajf).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYJ;
                    dVar4.ajf = sb4.append(dVar4.ajf).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aYJ = this.aYD.ne();
            if (this.aYJ != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aYJ;
                dVar5.ajf = sb5.append(dVar5.ajf).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aYJ;
                dVar6.ajf = sb6.append(dVar6.ajf).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] w(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] eG(String str) {
        return eF(str);
    }

    private boolean DF() {
        if (this.aYF.ajv) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aYQ + 1;
            aYQ = i;
            if (i >= 5) {
                aYQ = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] i(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] eF = eF(str);
                int i3 = aYK + 1;
                aYK = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aYK == 1) {
                        aYM = this.errorCode;
                    }
                    aYL++;
                }
                if (aYK == 2) {
                    s.a("A2T", aYM, this.errorCode, aYL);
                }
                if (true == DF()) {
                    this.mUseHttpClient = true;
                    this.aYP = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aYL = 0;
                    aYK = 0;
                    aYM = 0;
                }
                if (eF == null) {
                    return null;
                }
                if (this.aYD != null && this.aYD.nc().ajx != null) {
                    List<String> list = this.aYD.nc().ajx.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aYD.nc().ajx.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aYD.nc().ajx.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aYO = false;
                            i = i2;
                            return (this.aYN || (!z && i == 0) || !new String(eF, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eF : copyOfRange(eF, 23, eF.length);
                        }
                        this.aYO = true;
                    }
                }
                i = i2;
                if (this.aYN) {
                }
            } catch (Exception e) {
                this.ajf += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                DE();
                if (this.aYH != null) {
                    cancel();
                }
                this.aYD = new com.baidu.adp.lib.network.http.e();
                this.aYH = new f(this.aYD);
                this.aYD.nb().setUrl(str);
                if (this.aYE != null) {
                    for (Map.Entry<String, String> entry : this.aYE.entrySet()) {
                        this.aYD.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aYH.d(null, null, -1);
                this.aYF = this.aYD.nc();
                byte[] bArr = this.aYD.nc().ajy;
                this.responseCode = this.aYD.nc().responseCode;
                this.errorCode = this.aYD.nc().ajw;
                this.aYN = this.aYD.nc().ni();
                if (this.mUseHttpAutoSwitch && true == DF()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aYL = 0;
                    aYK = 0;
                    aYM = 0;
                }
                if (this.aYP) {
                    int i4 = aYK + 1;
                    aYK = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aYL++;
                        if (aYK == 1) {
                            aYM = this.errorCode;
                        }
                    }
                    if (aYK == 2) {
                        s.a("T2A", aYM, this.errorCode, aYL);
                        this.aYP = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aYH.isGif();
                this.aYO = this.aYH.DC();
                int size = this.aYD.nd().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aYD.nd().get(i2) != null) {
                            sb.append(this.aYD.nd().get(i2).aji);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYJ = this.aYD.ne();
                if (this.aYJ != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYJ;
                    dVar.ajf = sb2.append(dVar.ajf).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYJ;
                    dVar2.ajf = sb3.append(dVar2.ajf).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYJ;
                    dVar3.ajf = sb4.append(dVar3.ajf).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aYD.nd().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aYD.nd().get(i2) != null) {
                            sb.append(this.aYD.nd().get(i2).aji);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYJ = this.aYD.ne();
                if (this.aYJ != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYJ;
                    dVar4.ajf = sb5.append(dVar4.ajf).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aYJ;
                    dVar5.ajf = sb6.append(dVar5.ajf).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aYJ;
                    dVar6.ajf = sb7.append(dVar6.ajf).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aYD.nd().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aYD.nd().get(i2) != null) {
                        sb.append(this.aYD.nd().get(i2).aji);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aYJ = this.aYD.ne();
            if (this.aYJ != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aYJ;
                dVar7.ajf = sb8.append(dVar7.ajf).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aYJ;
                dVar8.ajf = sb9.append(dVar8.ajf).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aYJ;
                dVar9.ajf = sb10.append(dVar9.ajf).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            throw th;
        }
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
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
            for (int i = 0; i < this.aYD.nd().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aYD.nd().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.ajf);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.ajc);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.aja);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ajb);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.aje);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.ajg);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.ajd);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ajh);
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
            this.ajf = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aYN = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.acm != null) {
            this.acm.cancel();
        }
        if (this.aYH != null) {
            this.aYH.cancel();
            this.aYH = null;
        }
    }

    public boolean DG() {
        if (this.aYH == null) {
            return false;
        }
        return this.aYH.aYq;
    }
}
