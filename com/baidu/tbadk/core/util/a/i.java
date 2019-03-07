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
public class i implements a.InterfaceC0016a {
    private com.baidu.adp.lib.network.http.e bMt;
    private f bMx;
    private static int bMw = 5;
    private static int bMA = 0;
    private static int bMB = 0;
    private static int bMC = 0;
    private static int bMG = 0;
    private volatile com.baidu.adp.lib.network.http.c vZ = null;
    private HashMap<String, String> bMu = null;
    private com.baidu.adp.lib.network.http.g bMv = new com.baidu.adp.lib.network.http.g();
    public boolean bMy = false;
    public boolean isGif = false;
    public String CK = "";
    public com.baidu.adp.lib.network.http.d bMz = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bMD = false;
    public boolean bME = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bMF = false;

    public boolean adN() {
        return this.bMD;
    }

    public com.baidu.adp.lib.network.http.g js() {
        return this.bMv;
    }

    public void qf() {
        this.bMz = null;
        this.CK = "";
        this.bMD = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bMy = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] mV(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                qf();
                if (this.bMt != null) {
                    cancel();
                    this.vZ = null;
                }
                this.bMt = new com.baidu.adp.lib.network.http.e();
                this.bMt.jr().setUrl(str);
                if (this.bMu != null) {
                    for (Map.Entry<String, String> entry : this.bMu.entrySet()) {
                        this.bMt.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.vZ = new com.baidu.adp.lib.network.http.c(this.bMt);
                this.vZ.e(bMw, 0, 0);
                this.bMv = this.bMt.js();
                byte[] bArr = this.bMt.js().Df;
                this.responseCode = this.bMt.js().responseCode;
                this.errorCode = this.bMt.js().Dd;
                this.bMD = this.bMt.js().jy();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bMt.js().contentEncoding != null && this.bMt.js().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bMy = true;
                    bArr = M(bArr);
                }
                if (!this.bMD) {
                    e(str, null);
                }
                this.bMz = this.bMt.ju();
                if (this.bMz != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMz;
                    dVar.CK = sb.append(dVar.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMz;
                    dVar2.CK = sb2.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bMz = this.bMt.ju();
                if (this.bMz != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMz;
                    dVar3.CK = sb3.append(dVar3.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMz;
                    dVar4.CK = sb4.append(dVar4.CK).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bMz = this.bMt.ju();
            if (this.bMz != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bMz;
                dVar5.CK = sb5.append(dVar5.CK).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bMz;
                dVar6.CK = sb6.append(dVar6.CK).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] M(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] mW(String str) {
        return mV(str);
    }

    private boolean adO() {
        if (this.bMv.Dc) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bMG + 1;
            bMG = i;
            if (i >= 5) {
                bMG = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] K(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] mV = mV(str);
                int i3 = bMA + 1;
                bMA = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bMA == 1) {
                        bMC = this.errorCode;
                    }
                    bMB++;
                }
                if (bMA == 2) {
                    s.b("A2T", bMC, this.errorCode, bMB);
                }
                if (true == adO()) {
                    this.mUseHttpClient = true;
                    this.bMF = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bMB = 0;
                    bMA = 0;
                    bMC = 0;
                }
                if (mV == null) {
                    return null;
                }
                if (this.bMt != null && this.bMt.js().De != null) {
                    List<String> list = this.bMt.js().De.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bMt.js().De.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bMt.js().De.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bME = false;
                            i = i2;
                            return (this.bMD || (!z && i == 0) || !new String(mV, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? mV : copyOfRange(mV, 23, mV.length);
                        }
                        this.bME = true;
                    }
                }
                i = i2;
                if (this.bMD) {
                }
            } catch (Exception e) {
                this.CK += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                qf();
                if (this.bMx != null) {
                    cancel();
                }
                this.bMt = new com.baidu.adp.lib.network.http.e();
                this.bMx = new f(this.bMt);
                this.bMt.jr().setUrl(str);
                if (this.bMu != null) {
                    for (Map.Entry<String, String> entry : this.bMu.entrySet()) {
                        this.bMt.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.bMx.n(null, null, -1);
                this.bMv = this.bMt.js();
                byte[] bArr = this.bMt.js().Df;
                this.responseCode = this.bMt.js().responseCode;
                this.errorCode = this.bMt.js().Dd;
                this.bMD = this.bMt.js().jy();
                if (this.mUseHttpAutoSwitch && true == adO()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bMB = 0;
                    bMA = 0;
                    bMC = 0;
                }
                if (this.bMF) {
                    int i4 = bMA + 1;
                    bMA = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bMB++;
                        if (bMA == 1) {
                            bMC = this.errorCode;
                        }
                    }
                    if (bMA == 2) {
                        s.b("T2A", bMC, this.errorCode, bMB);
                        this.bMF = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bMx.isGif();
                this.bME = this.bMx.adM();
                int size = this.bMt.jt().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bMt.jt().get(i2) != null) {
                            sb.append(this.bMt.jt().get(i2).CN);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMz = this.bMt.ju();
                if (this.bMz != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMz;
                    dVar.CK = sb2.append(dVar.CK).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMz;
                    dVar2.CK = sb3.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMz;
                    dVar3.CK = sb4.append(dVar3.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bMt.jt().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bMt.jt().get(i2) != null) {
                            sb.append(this.bMt.jt().get(i2).CN);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMz = this.bMt.ju();
                if (this.bMz != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMz;
                    dVar4.CK = sb5.append(dVar4.CK).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bMz;
                    dVar5.CK = sb6.append(dVar5.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bMz;
                    dVar6.CK = sb7.append(dVar6.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bMt.jt().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bMt.jt().get(i2) != null) {
                        sb.append(this.bMt.jt().get(i2).CN);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bMz = this.bMt.ju();
            if (this.bMz != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bMz;
                dVar7.CK = sb8.append(dVar7.CK).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bMz;
                dVar8.CK = sb9.append(dVar8.CK).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bMz;
                dVar9.CK = sb10.append(dVar9.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
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

    private void e(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.bMt.jt().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bMt.jt().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.CK);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.CH);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.CF);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.CG);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.CJ);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.CL);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.CI);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.CM);
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
            this.CK = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.bMD = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.vZ != null) {
            this.vZ.cancel();
        }
        if (this.bMx != null) {
            this.bMx.cancel();
            this.bMx = null;
        }
    }

    public boolean adP() {
        if (this.bMx == null) {
            return false;
        }
        return this.bMx.bMg;
    }
}
