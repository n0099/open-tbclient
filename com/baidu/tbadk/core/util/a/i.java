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
    private com.baidu.adp.lib.network.http.e bMu;
    private f bMy;
    private static int bMx = 5;
    private static int bMB = 0;
    private static int bMC = 0;
    private static int bMD = 0;
    private static int bMH = 0;
    private volatile com.baidu.adp.lib.network.http.c vZ = null;
    private HashMap<String, String> bMv = null;
    private com.baidu.adp.lib.network.http.g bMw = new com.baidu.adp.lib.network.http.g();
    public boolean bMz = false;
    public boolean isGif = false;
    public String CK = "";
    public com.baidu.adp.lib.network.http.d bMA = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bME = false;
    public boolean bMF = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bMG = false;

    public boolean adN() {
        return this.bME;
    }

    public com.baidu.adp.lib.network.http.g js() {
        return this.bMw;
    }

    public void qf() {
        this.bMA = null;
        this.CK = "";
        this.bME = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bMz = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] mV(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                qf();
                if (this.bMu != null) {
                    cancel();
                    this.vZ = null;
                }
                this.bMu = new com.baidu.adp.lib.network.http.e();
                this.bMu.jr().setUrl(str);
                if (this.bMv != null) {
                    for (Map.Entry<String, String> entry : this.bMv.entrySet()) {
                        this.bMu.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.vZ = new com.baidu.adp.lib.network.http.c(this.bMu);
                this.vZ.e(bMx, 0, 0);
                this.bMw = this.bMu.js();
                byte[] bArr = this.bMu.js().Df;
                this.responseCode = this.bMu.js().responseCode;
                this.errorCode = this.bMu.js().Dd;
                this.bME = this.bMu.js().jy();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bMu.js().contentEncoding != null && this.bMu.js().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bMz = true;
                    bArr = M(bArr);
                }
                if (!this.bME) {
                    e(str, null);
                }
                this.bMA = this.bMu.ju();
                if (this.bMA != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMA;
                    dVar.CK = sb.append(dVar.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMA;
                    dVar2.CK = sb2.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bMA = this.bMu.ju();
                if (this.bMA != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMA;
                    dVar3.CK = sb3.append(dVar3.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMA;
                    dVar4.CK = sb4.append(dVar4.CK).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bMA = this.bMu.ju();
            if (this.bMA != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bMA;
                dVar5.CK = sb5.append(dVar5.CK).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bMA;
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
        if (this.bMw.Dc) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bMH + 1;
            bMH = i;
            if (i >= 5) {
                bMH = 0;
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
                int i3 = bMB + 1;
                bMB = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bMB == 1) {
                        bMD = this.errorCode;
                    }
                    bMC++;
                }
                if (bMB == 2) {
                    s.b("A2T", bMD, this.errorCode, bMC);
                }
                if (true == adO()) {
                    this.mUseHttpClient = true;
                    this.bMG = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bMC = 0;
                    bMB = 0;
                    bMD = 0;
                }
                if (mV == null) {
                    return null;
                }
                if (this.bMu != null && this.bMu.js().De != null) {
                    List<String> list = this.bMu.js().De.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bMu.js().De.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bMu.js().De.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bMF = false;
                            i = i2;
                            return (this.bME || (!z && i == 0) || !new String(mV, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? mV : copyOfRange(mV, 23, mV.length);
                        }
                        this.bMF = true;
                    }
                }
                i = i2;
                if (this.bME) {
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
                if (this.bMy != null) {
                    cancel();
                }
                this.bMu = new com.baidu.adp.lib.network.http.e();
                this.bMy = new f(this.bMu);
                this.bMu.jr().setUrl(str);
                if (this.bMv != null) {
                    for (Map.Entry<String, String> entry : this.bMv.entrySet()) {
                        this.bMu.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.bMy.n(null, null, -1);
                this.bMw = this.bMu.js();
                byte[] bArr = this.bMu.js().Df;
                this.responseCode = this.bMu.js().responseCode;
                this.errorCode = this.bMu.js().Dd;
                this.bME = this.bMu.js().jy();
                if (this.mUseHttpAutoSwitch && true == adO()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bMC = 0;
                    bMB = 0;
                    bMD = 0;
                }
                if (this.bMG) {
                    int i4 = bMB + 1;
                    bMB = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bMC++;
                        if (bMB == 1) {
                            bMD = this.errorCode;
                        }
                    }
                    if (bMB == 2) {
                        s.b("T2A", bMD, this.errorCode, bMC);
                        this.bMG = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bMy.isGif();
                this.bMF = this.bMy.adM();
                int size = this.bMu.jt().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bMu.jt().get(i2) != null) {
                            sb.append(this.bMu.jt().get(i2).CN);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMA = this.bMu.ju();
                if (this.bMA != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMA;
                    dVar.CK = sb2.append(dVar.CK).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMA;
                    dVar2.CK = sb3.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMA;
                    dVar3.CK = sb4.append(dVar3.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bMu.jt().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bMu.jt().get(i2) != null) {
                            sb.append(this.bMu.jt().get(i2).CN);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMA = this.bMu.ju();
                if (this.bMA != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMA;
                    dVar4.CK = sb5.append(dVar4.CK).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bMA;
                    dVar5.CK = sb6.append(dVar5.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bMA;
                    dVar6.CK = sb7.append(dVar6.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bMu.jt().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bMu.jt().get(i2) != null) {
                        sb.append(this.bMu.jt().get(i2).CN);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bMA = this.bMu.ju();
            if (this.bMA != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bMA;
                dVar7.CK = sb8.append(dVar7.CK).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bMA;
                dVar8.CK = sb9.append(dVar8.CK).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bMA;
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
            for (int i = 0; i < this.bMu.jt().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bMu.jt().get(i);
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
            this.bME = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.vZ != null) {
            this.vZ.cancel();
        }
        if (this.bMy != null) {
            this.bMy.cancel();
            this.bMy = null;
        }
    }

    public boolean adP() {
        if (this.bMy == null) {
            return false;
        }
        return this.bMy.bMh;
    }
}
