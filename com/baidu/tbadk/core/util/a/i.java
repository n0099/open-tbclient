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
public class i implements a.InterfaceC0007a {
    private static int akl = 5;
    private static int akp = 0;
    private static int akq = 0;
    private static int akr = 0;
    private static int akv = 0;
    private com.baidu.adp.lib.network.http.e aki;
    private f akm;
    private volatile com.baidu.adp.lib.network.http.c mB = null;
    private HashMap<String, String> akj = null;
    private com.baidu.adp.lib.network.http.g akk = new com.baidu.adp.lib.network.http.g();
    public boolean akn = false;
    public boolean isGif = false;
    public String tG = "";
    public com.baidu.adp.lib.network.http.d ako = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aks = false;
    public boolean akt = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aku = false;

    public boolean wq() {
        return this.aks;
    }

    public com.baidu.adp.lib.network.http.g ff() {
        return this.akk;
    }

    public void wr() {
        this.ako = null;
        this.tG = "";
        this.aks = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.akn = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ex(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wr();
                if (this.aki != null) {
                    cancel();
                    this.mB = null;
                }
                this.aki = new com.baidu.adp.lib.network.http.e();
                this.aki.fe().setUrl(str);
                if (this.akj != null) {
                    for (Map.Entry<String, String> entry : this.akj.entrySet()) {
                        this.aki.fe().n(entry.getKey(), entry.getValue());
                    }
                }
                this.mB = new com.baidu.adp.lib.network.http.c(this.aki);
                this.mB.d(akl, 0, 0);
                this.akk = this.aki.ff();
                byte[] bArr = this.aki.ff().tZ;
                this.responseCode = this.aki.ff().responseCode;
                this.errorCode = this.aki.ff().tX;
                this.aks = this.aki.ff().fl();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aki.ff().contentEncoding != null && this.aki.ff().contentEncoding.toLowerCase().contains("gzip")) {
                    this.akn = true;
                    bArr = x(bArr);
                }
                if (!this.aks) {
                    c(str, null);
                }
                this.ako = this.aki.fh();
                if (this.ako != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ako;
                    dVar.tG = sb.append(dVar.tG).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ako;
                    dVar2.tG = sb2.append(dVar2.tG).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ako = this.aki.fh();
                if (this.ako != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ako;
                    dVar3.tG = sb3.append(dVar3.tG).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ako;
                    dVar4.tG = sb4.append(dVar4.tG).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ako = this.aki.fh();
            if (this.ako != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ako;
                dVar5.tG = sb5.append(dVar5.tG).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ako;
                dVar6.tG = sb6.append(dVar6.tG).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] x(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] ey(String str) {
        return ex(str);
    }

    private boolean ws() {
        if (this.akk.tW) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = akv + 1;
            akv = i;
            if (i >= 5) {
                akv = 0;
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
                byte[] ex = ex(str);
                int i3 = akp + 1;
                akp = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (akp == 1) {
                        akr = this.errorCode;
                    }
                    akq++;
                }
                if (akp == 2) {
                    s.a("A2T", akr, this.errorCode, akq);
                }
                if (true == ws()) {
                    this.mUseHttpClient = true;
                    this.aku = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    akq = 0;
                    akp = 0;
                    akr = 0;
                }
                if (ex == null) {
                    return null;
                }
                if (this.aki != null && this.aki.ff().tY != null) {
                    List<String> list = this.aki.ff().tY.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aki.ff().tY.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aki.ff().tY.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.akt = false;
                            i = i2;
                            return (this.aks || (!z && i == 0) || !new String(ex, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ex : copyOfRange(ex, 23, ex.length);
                        }
                        this.akt = true;
                    }
                }
                i = i2;
                if (this.aks) {
                }
            } catch (Exception e) {
                this.tG += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                wr();
                if (this.akm != null) {
                    cancel();
                }
                this.aki = new com.baidu.adp.lib.network.http.e();
                this.akm = new f(this.aki);
                this.aki.fe().setUrl(str);
                if (this.akj != null) {
                    for (Map.Entry<String, String> entry : this.akj.entrySet()) {
                        this.aki.fe().n(entry.getKey(), entry.getValue());
                    }
                }
                this.akm.e(null, null, -1);
                this.akk = this.aki.ff();
                byte[] bArr = this.aki.ff().tZ;
                this.responseCode = this.aki.ff().responseCode;
                this.errorCode = this.aki.ff().tX;
                this.aks = this.aki.ff().fl();
                if (this.mUseHttpAutoSwitch && true == ws()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    akq = 0;
                    akp = 0;
                    akr = 0;
                }
                if (this.aku) {
                    int i4 = akp + 1;
                    akp = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        akq++;
                        if (akp == 1) {
                            akr = this.errorCode;
                        }
                    }
                    if (akp == 2) {
                        s.a("T2A", akr, this.errorCode, akq);
                        this.aku = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.akm.isGif();
                this.akt = this.akm.wp();
                int size = this.aki.fg().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aki.fg().get(i2) != null) {
                            sb.append(this.aki.fg().get(i2).tJ);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ako = this.aki.fh();
                if (this.ako != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ako;
                    dVar.tG = sb2.append(dVar.tG).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ako;
                    dVar2.tG = sb3.append(dVar2.tG).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ako;
                    dVar3.tG = sb4.append(dVar3.tG).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aki.fg().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aki.fg().get(i2) != null) {
                            sb.append(this.aki.fg().get(i2).tJ);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ako = this.aki.fh();
                if (this.ako != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ako;
                    dVar4.tG = sb5.append(dVar4.tG).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ako;
                    dVar5.tG = sb6.append(dVar5.tG).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ako;
                    dVar6.tG = sb7.append(dVar6.tG).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aki.fg().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aki.fg().get(i2) != null) {
                        sb.append(this.aki.fg().get(i2).tJ);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.ako = this.aki.fh();
            if (this.ako != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ako;
                dVar7.tG = sb8.append(dVar7.tG).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ako;
                dVar8.tG = sb9.append(dVar8.tG).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ako;
                dVar9.tG = sb10.append(dVar9.tG).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aki.fg().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aki.fg().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.tG);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.tD);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.tB);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.tC);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.tF);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.tH);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.tE);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.tI);
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
            this.tG = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aks = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0007a
    public void cancel() {
        if (this.mB != null) {
            this.mB.cancel();
        }
        if (this.akm != null) {
            this.akm.cancel();
            this.akm = null;
        }
    }

    public boolean wt() {
        if (this.akm == null) {
            return false;
        }
        return this.akm.ajV;
    }
}
