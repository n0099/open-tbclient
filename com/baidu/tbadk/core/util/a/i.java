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
    private static int bMA = 5;
    private static int bME = 0;
    private static int bMF = 0;
    private static int bMG = 0;
    private static int bMK = 0;
    private f bMB;
    private com.baidu.adp.lib.network.http.e bMx;
    private volatile com.baidu.adp.lib.network.http.c vZ = null;
    private HashMap<String, String> bMy = null;
    private com.baidu.adp.lib.network.http.g bMz = new com.baidu.adp.lib.network.http.g();
    public boolean bMC = false;
    public boolean isGif = false;
    public String CK = "";
    public com.baidu.adp.lib.network.http.d bMD = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bMH = false;
    public boolean bMI = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bMJ = false;

    public boolean adK() {
        return this.bMH;
    }

    public com.baidu.adp.lib.network.http.g js() {
        return this.bMz;
    }

    public void qf() {
        this.bMD = null;
        this.CK = "";
        this.bMH = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bMC = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] mW(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                qf();
                if (this.bMx != null) {
                    cancel();
                    this.vZ = null;
                }
                this.bMx = new com.baidu.adp.lib.network.http.e();
                this.bMx.jr().setUrl(str);
                if (this.bMy != null) {
                    for (Map.Entry<String, String> entry : this.bMy.entrySet()) {
                        this.bMx.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.vZ = new com.baidu.adp.lib.network.http.c(this.bMx);
                this.vZ.e(bMA, 0, 0);
                this.bMz = this.bMx.js();
                byte[] bArr = this.bMx.js().Df;
                this.responseCode = this.bMx.js().responseCode;
                this.errorCode = this.bMx.js().Dd;
                this.bMH = this.bMx.js().jy();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bMx.js().contentEncoding != null && this.bMx.js().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bMC = true;
                    bArr = M(bArr);
                }
                if (!this.bMH) {
                    e(str, null);
                }
                this.bMD = this.bMx.ju();
                if (this.bMD != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMD;
                    dVar.CK = sb.append(dVar.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMD;
                    dVar2.CK = sb2.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bMD = this.bMx.ju();
                if (this.bMD != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMD;
                    dVar3.CK = sb3.append(dVar3.CK).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMD;
                    dVar4.CK = sb4.append(dVar4.CK).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bMD = this.bMx.ju();
            if (this.bMD != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bMD;
                dVar5.CK = sb5.append(dVar5.CK).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bMD;
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

    public byte[] mX(String str) {
        return mW(str);
    }

    private boolean adL() {
        if (this.bMz.Dc) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bMK + 1;
            bMK = i;
            if (i >= 5) {
                bMK = 0;
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
                byte[] mW = mW(str);
                int i3 = bME + 1;
                bME = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bME == 1) {
                        bMG = this.errorCode;
                    }
                    bMF++;
                }
                if (bME == 2) {
                    s.b("A2T", bMG, this.errorCode, bMF);
                }
                if (true == adL()) {
                    this.mUseHttpClient = true;
                    this.bMJ = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bMF = 0;
                    bME = 0;
                    bMG = 0;
                }
                if (mW == null) {
                    return null;
                }
                if (this.bMx != null && this.bMx.js().De != null) {
                    List<String> list = this.bMx.js().De.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bMx.js().De.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bMx.js().De.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bMI = false;
                            i = i2;
                            return (this.bMH || (!z && i == 0) || !new String(mW, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? mW : copyOfRange(mW, 23, mW.length);
                        }
                        this.bMI = true;
                    }
                }
                i = i2;
                if (this.bMH) {
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
                if (this.bMB != null) {
                    cancel();
                }
                this.bMx = new com.baidu.adp.lib.network.http.e();
                this.bMB = new f(this.bMx);
                this.bMx.jr().setUrl(str);
                if (this.bMy != null) {
                    for (Map.Entry<String, String> entry : this.bMy.entrySet()) {
                        this.bMx.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.bMB.n(null, null, -1);
                this.bMz = this.bMx.js();
                byte[] bArr = this.bMx.js().Df;
                this.responseCode = this.bMx.js().responseCode;
                this.errorCode = this.bMx.js().Dd;
                this.bMH = this.bMx.js().jy();
                if (this.mUseHttpAutoSwitch && true == adL()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bMF = 0;
                    bME = 0;
                    bMG = 0;
                }
                if (this.bMJ) {
                    int i4 = bME + 1;
                    bME = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bMF++;
                        if (bME == 1) {
                            bMG = this.errorCode;
                        }
                    }
                    if (bME == 2) {
                        s.b("T2A", bMG, this.errorCode, bMF);
                        this.bMJ = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bMB.isGif();
                this.bMI = this.bMB.adJ();
                int size = this.bMx.jt().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bMx.jt().get(i2) != null) {
                            sb.append(this.bMx.jt().get(i2).CN);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMD = this.bMx.ju();
                if (this.bMD != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bMD;
                    dVar.CK = sb2.append(dVar.CK).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bMD;
                    dVar2.CK = sb3.append(dVar2.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bMD;
                    dVar3.CK = sb4.append(dVar3.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bMx.jt().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bMx.jt().get(i2) != null) {
                            sb.append(this.bMx.jt().get(i2).CN);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bMD = this.bMx.ju();
                if (this.bMD != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bMD;
                    dVar4.CK = sb5.append(dVar4.CK).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bMD;
                    dVar5.CK = sb6.append(dVar5.CK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bMD;
                    dVar6.CK = sb7.append(dVar6.CK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bMx.jt().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bMx.jt().get(i2) != null) {
                        sb.append(this.bMx.jt().get(i2).CN);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bMD = this.bMx.ju();
            if (this.bMD != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bMD;
                dVar7.CK = sb8.append(dVar7.CK).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bMD;
                dVar8.CK = sb9.append(dVar8.CK).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bMD;
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
            for (int i = 0; i < this.bMx.jt().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bMx.jt().get(i);
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
            this.bMH = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.vZ != null) {
            this.vZ.cancel();
        }
        if (this.bMB != null) {
            this.bMB.cancel();
            this.bMB = null;
        }
    }

    public boolean adM() {
        if (this.bMB == null) {
            return false;
        }
        return this.bMB.bMk;
    }
}
