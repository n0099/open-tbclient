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
    private static int aYS = 5;
    private static int aYW = 0;
    private static int aYX = 0;
    private static int aYY = 0;
    private static int aZc = 0;
    private com.baidu.adp.lib.network.http.e aYP;
    private f aYT;
    private volatile com.baidu.adp.lib.network.http.c acs = null;
    private HashMap<String, String> aYQ = null;
    private com.baidu.adp.lib.network.http.g aYR = new com.baidu.adp.lib.network.http.g();
    public boolean aYU = false;
    public boolean isGif = false;
    public String ajl = "";
    public com.baidu.adp.lib.network.http.d aYV = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aYZ = false;
    public boolean aZa = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aZb = false;

    public boolean DE() {
        return this.aYZ;
    }

    public com.baidu.adp.lib.network.http.g nc() {
        return this.aYR;
    }

    public void DF() {
        this.aYV = null;
        this.ajl = "";
        this.aYZ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aYU = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eF(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                DF();
                if (this.aYP != null) {
                    cancel();
                    this.acs = null;
                }
                this.aYP = new com.baidu.adp.lib.network.http.e();
                this.aYP.nb().setUrl(str);
                if (this.aYQ != null) {
                    for (Map.Entry<String, String> entry : this.aYQ.entrySet()) {
                        this.aYP.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.acs = new com.baidu.adp.lib.network.http.c(this.aYP);
                this.acs.m(aYS, 0, 0);
                this.aYR = this.aYP.nc();
                byte[] bArr = this.aYP.nc().ajE;
                this.responseCode = this.aYP.nc().responseCode;
                this.errorCode = this.aYP.nc().ajC;
                this.aYZ = this.aYP.nc().ni();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aYP.nc().contentEncoding != null && this.aYP.nc().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aYU = true;
                    bArr = w(bArr);
                }
                if (!this.aYZ) {
                    c(str, null);
                }
                this.aYV = this.aYP.ne();
                if (this.aYV != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYV;
                    dVar.ajl = sb.append(dVar.ajl).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYV;
                    dVar2.ajl = sb2.append(dVar2.ajl).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aYV = this.aYP.ne();
                if (this.aYV != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYV;
                    dVar3.ajl = sb3.append(dVar3.ajl).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYV;
                    dVar4.ajl = sb4.append(dVar4.ajl).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aYV = this.aYP.ne();
            if (this.aYV != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aYV;
                dVar5.ajl = sb5.append(dVar5.ajl).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aYV;
                dVar6.ajl = sb6.append(dVar6.ajl).append("_responseCode:").append(this.responseCode).toString();
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
        if (this.aYR.ajB) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aZc + 1;
            aZc = i;
            if (i >= 5) {
                aZc = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] j(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] eF = eF(str);
                int i3 = aYW + 1;
                aYW = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aYW == 1) {
                        aYY = this.errorCode;
                    }
                    aYX++;
                }
                if (aYW == 2) {
                    s.a("A2T", aYY, this.errorCode, aYX);
                }
                if (true == DG()) {
                    this.mUseHttpClient = true;
                    this.aZb = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aYX = 0;
                    aYW = 0;
                    aYY = 0;
                }
                if (eF == null) {
                    return null;
                }
                if (this.aYP != null && this.aYP.nc().ajD != null) {
                    List<String> list = this.aYP.nc().ajD.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aYP.nc().ajD.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aYP.nc().ajD.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aZa = false;
                            i = i2;
                            return (this.aYZ || (!z && i == 0) || !new String(eF, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eF : copyOfRange(eF, 23, eF.length);
                        }
                        this.aZa = true;
                    }
                }
                i = i2;
                if (this.aYZ) {
                }
            } catch (Exception e) {
                this.ajl += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                DF();
                if (this.aYT != null) {
                    cancel();
                }
                this.aYP = new com.baidu.adp.lib.network.http.e();
                this.aYT = new f(this.aYP);
                this.aYP.nb().setUrl(str);
                if (this.aYQ != null) {
                    for (Map.Entry<String, String> entry : this.aYQ.entrySet()) {
                        this.aYP.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aYT.d(null, null, -1);
                this.aYR = this.aYP.nc();
                byte[] bArr = this.aYP.nc().ajE;
                this.responseCode = this.aYP.nc().responseCode;
                this.errorCode = this.aYP.nc().ajC;
                this.aYZ = this.aYP.nc().ni();
                if (this.mUseHttpAutoSwitch && true == DG()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aYX = 0;
                    aYW = 0;
                    aYY = 0;
                }
                if (this.aZb) {
                    int i4 = aYW + 1;
                    aYW = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aYX++;
                        if (aYW == 1) {
                            aYY = this.errorCode;
                        }
                    }
                    if (aYW == 2) {
                        s.a("T2A", aYY, this.errorCode, aYX);
                        this.aZb = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aYT.isGif();
                this.aZa = this.aYT.DD();
                int size = this.aYP.nd().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aYP.nd().get(i2) != null) {
                            sb.append(this.aYP.nd().get(i2).ajo);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYV = this.aYP.ne();
                if (this.aYV != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aYV;
                    dVar.ajl = sb2.append(dVar.ajl).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aYV;
                    dVar2.ajl = sb3.append(dVar2.ajl).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aYV;
                    dVar3.ajl = sb4.append(dVar3.ajl).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aYP.nd().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aYP.nd().get(i2) != null) {
                            sb.append(this.aYP.nd().get(i2).ajo);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aYV = this.aYP.ne();
                if (this.aYV != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aYV;
                    dVar4.ajl = sb5.append(dVar4.ajl).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aYV;
                    dVar5.ajl = sb6.append(dVar5.ajl).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aYV;
                    dVar6.ajl = sb7.append(dVar6.ajl).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aYP.nd().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aYP.nd().get(i2) != null) {
                        sb.append(this.aYP.nd().get(i2).ajo);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aYV = this.aYP.ne();
            if (this.aYV != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aYV;
                dVar7.ajl = sb8.append(dVar7.ajl).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aYV;
                dVar8.ajl = sb9.append(dVar8.ajl).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aYV;
                dVar9.ajl = sb10.append(dVar9.ajl).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aYP.nd().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aYP.nd().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.ajl);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.aji);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.ajg);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ajh);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.ajk);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.ajm);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.ajj);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ajn);
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
            this.ajl = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aYZ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.acs != null) {
            this.acs.cancel();
        }
        if (this.aYT != null) {
            this.aYT.cancel();
            this.aYT = null;
        }
    }

    public boolean DH() {
        if (this.aYT == null) {
            return false;
        }
        return this.aYT.aYC;
    }
}
