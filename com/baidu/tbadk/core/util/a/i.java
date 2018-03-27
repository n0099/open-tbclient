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
    private static int aYI = 5;
    private static int aYM = 0;
    private static int aYN = 0;
    private static int aYO = 0;
    private static int aYS = 0;
    private com.baidu.adp.lib.network.http.e aYF;
    private f aYJ;
    private volatile com.baidu.adp.lib.network.http.c acm = null;
    private HashMap<String, String> aYG = null;
    private com.baidu.adp.lib.network.http.g aYH = new com.baidu.adp.lib.network.http.g();
    public boolean aYK = false;
    public boolean isGif = false;
    public String ajf = "";
    public com.baidu.adp.lib.network.http.d aYL = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aYP = false;
    public boolean aYQ = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aYR = false;

    public boolean DE() {
        return this.aYP;
    }

    public com.baidu.adp.lib.network.http.g nc() {
        return this.aYH;
    }

    public void DF() {
        this.aYL = null;
        this.ajf = "";
        this.aYP = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aYK = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eF(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                DF();
                if (this.aYF != null) {
                    cancel();
                    this.acm = null;
                }
                this.aYF = new com.baidu.adp.lib.network.http.e();
                this.aYF.nb().setUrl(str);
                if (this.aYG != null) {
                    for (Map.Entry<String, String> entry : this.aYG.entrySet()) {
                        this.aYF.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.acm = new com.baidu.adp.lib.network.http.c(this.aYF);
                this.acm.m(aYI, 0, 0);
                this.aYH = this.aYF.nc();
                byte[] bArr = this.aYF.nc().ajy;
                this.responseCode = this.aYF.nc().responseCode;
                this.errorCode = this.aYF.nc().ajw;
                this.aYP = this.aYF.nc().ni();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aYF.nc().contentEncoding != null && this.aYF.nc().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aYK = true;
                    bArr = w(bArr);
                }
                if (!this.aYP) {
                    c(str, null);
                }
                this.aYL = this.aYF.ne();
                if (this.aYL != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYL;
                    dVar.ajf = sb.append(dVar.ajf).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYL;
                    dVar2.ajf = sb2.append(dVar2.ajf).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aYL = this.aYF.ne();
                if (this.aYL != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYL;
                    dVar3.ajf = sb3.append(dVar3.ajf).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYL;
                    dVar4.ajf = sb4.append(dVar4.ajf).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aYL = this.aYF.ne();
            if (this.aYL != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aYL;
                dVar5.ajf = sb5.append(dVar5.ajf).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aYL;
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

    private boolean DG() {
        if (this.aYH.ajv) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aYS + 1;
            aYS = i;
            if (i >= 5) {
                aYS = 0;
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
                int i3 = aYM + 1;
                aYM = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aYM == 1) {
                        aYO = this.errorCode;
                    }
                    aYN++;
                }
                if (aYM == 2) {
                    s.a("A2T", aYO, this.errorCode, aYN);
                }
                if (true == DG()) {
                    this.mUseHttpClient = true;
                    this.aYR = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aYN = 0;
                    aYM = 0;
                    aYO = 0;
                }
                if (eF == null) {
                    return null;
                }
                if (this.aYF != null && this.aYF.nc().ajx != null) {
                    List<String> list = this.aYF.nc().ajx.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aYF.nc().ajx.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aYF.nc().ajx.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aYQ = false;
                            i = i2;
                            return (this.aYP || (!z && i == 0) || !new String(eF, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eF : copyOfRange(eF, 23, eF.length);
                        }
                        this.aYQ = true;
                    }
                }
                i = i2;
                if (this.aYP) {
                }
            } catch (Exception e) {
                this.ajf += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                DF();
                if (this.aYJ != null) {
                    cancel();
                }
                this.aYF = new com.baidu.adp.lib.network.http.e();
                this.aYJ = new f(this.aYF);
                this.aYF.nb().setUrl(str);
                if (this.aYG != null) {
                    for (Map.Entry<String, String> entry : this.aYG.entrySet()) {
                        this.aYF.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aYJ.d(null, null, -1);
                this.aYH = this.aYF.nc();
                byte[] bArr = this.aYF.nc().ajy;
                this.responseCode = this.aYF.nc().responseCode;
                this.errorCode = this.aYF.nc().ajw;
                this.aYP = this.aYF.nc().ni();
                if (this.mUseHttpAutoSwitch && true == DG()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aYN = 0;
                    aYM = 0;
                    aYO = 0;
                }
                if (this.aYR) {
                    int i4 = aYM + 1;
                    aYM = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aYN++;
                        if (aYM == 1) {
                            aYO = this.errorCode;
                        }
                    }
                    if (aYM == 2) {
                        s.a("T2A", aYO, this.errorCode, aYN);
                        this.aYR = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aYJ.isGif();
                this.aYQ = this.aYJ.DD();
                int size = this.aYF.nd().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aYF.nd().get(i2) != null) {
                            sb.append(this.aYF.nd().get(i2).aji);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYL = this.aYF.ne();
                if (this.aYL != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYL;
                    dVar.ajf = sb2.append(dVar.ajf).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYL;
                    dVar2.ajf = sb3.append(dVar2.ajf).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYL;
                    dVar3.ajf = sb4.append(dVar3.ajf).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aYF.nd().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aYF.nd().get(i2) != null) {
                            sb.append(this.aYF.nd().get(i2).aji);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYL = this.aYF.ne();
                if (this.aYL != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYL;
                    dVar4.ajf = sb5.append(dVar4.ajf).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aYL;
                    dVar5.ajf = sb6.append(dVar5.ajf).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aYL;
                    dVar6.ajf = sb7.append(dVar6.ajf).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aYF.nd().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aYF.nd().get(i2) != null) {
                        sb.append(this.aYF.nd().get(i2).aji);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aYL = this.aYF.ne();
            if (this.aYL != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aYL;
                dVar7.ajf = sb8.append(dVar7.ajf).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aYL;
                dVar8.ajf = sb9.append(dVar8.ajf).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aYL;
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
            for (int i = 0; i < this.aYF.nd().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aYF.nd().get(i);
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
            this.aYP = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.acm != null) {
            this.acm.cancel();
        }
        if (this.aYJ != null) {
            this.aYJ.cancel();
            this.aYJ = null;
        }
    }

    public boolean DH() {
        if (this.aYJ == null) {
            return false;
        }
        return this.aYJ.aYs;
    }
}
