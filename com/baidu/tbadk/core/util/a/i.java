package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
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
    private static int aDY = 5;
    private static int aEc = 0;
    private static int aEd = 0;
    private static int aEe = 0;
    private static int aEi = 0;
    private com.baidu.adp.lib.network.http.e aDV;
    private f aDZ;
    private volatile com.baidu.adp.lib.network.http.c we = null;
    private HashMap<String, String> aDW = null;
    private com.baidu.adp.lib.network.http.g aDX = new com.baidu.adp.lib.network.http.g();
    public boolean aEa = false;
    public boolean isGif = false;
    public String CL = "";
    public com.baidu.adp.lib.network.http.d aEb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aEf = false;
    public boolean aEg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aEh = false;

    public boolean Ep() {
        return this.aEf;
    }

    public com.baidu.adp.lib.network.http.g jq() {
        return this.aDX;
    }

    public void Eq() {
        this.aEb = null;
        this.CL = "";
        this.aEf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aEa = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] fV(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Eq();
                if (this.aDV != null) {
                    cancel();
                    this.we = null;
                }
                this.aDV = new com.baidu.adp.lib.network.http.e();
                this.aDV.jp().setUrl(str);
                if (this.aDW != null) {
                    for (Map.Entry<String, String> entry : this.aDW.entrySet()) {
                        this.aDV.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.we = new com.baidu.adp.lib.network.http.c(this.aDV);
                this.we.e(aDY, 0, 0);
                this.aDX = this.aDV.jq();
                byte[] bArr = this.aDV.jq().Dg;
                this.responseCode = this.aDV.jq().responseCode;
                this.errorCode = this.aDV.jq().De;
                this.aEf = this.aDV.jq().jw();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aDV.jq().contentEncoding != null && this.aDV.jq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aEa = true;
                    bArr = E(bArr);
                }
                if (!this.aEf) {
                    d(str, null);
                }
                this.aEb = this.aDV.js();
                if (this.aEb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEb;
                    dVar.CL = sb.append(dVar.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEb;
                    dVar2.CL = sb2.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.aEb = this.aDV.js();
                if (this.aEb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEb;
                    dVar3.CL = sb3.append(dVar3.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEb;
                    dVar4.CL = sb4.append(dVar4.CL).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aEb = this.aDV.js();
            if (this.aEb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aEb;
                dVar5.CL = sb5.append(dVar5.CL).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aEb;
                dVar6.CL = sb6.append(dVar6.CL).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] E(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] fW(String str) {
        return fV(str);
    }

    private boolean Er() {
        if (this.aDX.Dd) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aEi + 1;
            aEi = i;
            if (i >= 5) {
                aEi = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] r(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] fV = fV(str);
                int i3 = aEc + 1;
                aEc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aEc == 1) {
                        aEe = this.errorCode;
                    }
                    aEd++;
                }
                if (aEc == 2) {
                    s.b("A2T", aEe, this.errorCode, aEd);
                }
                if (true == Er()) {
                    this.mUseHttpClient = true;
                    this.aEh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aEd = 0;
                    aEc = 0;
                    aEe = 0;
                }
                if (fV == null) {
                    return null;
                }
                if (this.aDV != null && this.aDV.jq().Df != null) {
                    List<String> list = this.aDV.jq().Df.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aDV.jq().Df.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aDV.jq().Df.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aEg = false;
                            i = i2;
                            return (this.aEf || (!z && i == 0) || !new String(fV, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? fV : copyOfRange(fV, 23, fV.length);
                        }
                        this.aEg = true;
                    }
                }
                i = i2;
                if (this.aEf) {
                }
            } catch (Exception e) {
                this.CL += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Eq();
                if (this.aDZ != null) {
                    cancel();
                }
                this.aDV = new com.baidu.adp.lib.network.http.e();
                this.aDZ = new f(this.aDV);
                this.aDV.jp().setUrl(str);
                if (this.aDW != null) {
                    for (Map.Entry<String, String> entry : this.aDW.entrySet()) {
                        this.aDV.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.aDZ.e(null, null, -1);
                this.aDX = this.aDV.jq();
                byte[] bArr = this.aDV.jq().Dg;
                this.responseCode = this.aDV.jq().responseCode;
                this.errorCode = this.aDV.jq().De;
                this.aEf = this.aDV.jq().jw();
                if (this.mUseHttpAutoSwitch && true == Er()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aEd = 0;
                    aEc = 0;
                    aEe = 0;
                }
                if (this.aEh) {
                    int i4 = aEc + 1;
                    aEc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aEd++;
                        if (aEc == 1) {
                            aEe = this.errorCode;
                        }
                    }
                    if (aEc == 2) {
                        s.b("T2A", aEe, this.errorCode, aEd);
                        this.aEh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aDZ.isGif();
                this.aEg = this.aDZ.Eo();
                int size = this.aDV.jr().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aDV.jr().get(i2) != null) {
                            sb.append(this.aDV.jr().get(i2).CO);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEb = this.aDV.js();
                if (this.aEb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEb;
                    dVar.CL = sb2.append(dVar.CL).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEb;
                    dVar2.CL = sb3.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEb;
                    dVar3.CL = sb4.append(dVar3.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.aDV.jr().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aDV.jr().get(i2) != null) {
                            sb.append(this.aDV.jr().get(i2).CO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEb = this.aDV.js();
                if (this.aEb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEb;
                    dVar4.CL = sb5.append(dVar4.CL).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aEb;
                    dVar5.CL = sb6.append(dVar5.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aEb;
                    dVar6.CL = sb7.append(dVar6.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aDV.jr().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aDV.jr().get(i2) != null) {
                        sb.append(this.aDV.jr().get(i2).CO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.aEb = this.aDV.js();
            if (this.aEb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aEb;
                dVar7.CL = sb8.append(dVar7.CL).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aEb;
                dVar8.CL = sb9.append(dVar8.CL).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aEb;
                dVar9.CL = sb10.append(dVar9.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
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

    private void d(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.aDV.jr().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aDV.jr().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.CL);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.CI);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.CG);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.CH);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.CK);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.CM);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.CJ);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.CN);
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
            this.CL = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aEf = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.we != null) {
            this.we.cancel();
        }
        if (this.aDZ != null) {
            this.aDZ.cancel();
            this.aDZ = null;
        }
    }

    public boolean Es() {
        if (this.aDZ == null) {
            return false;
        }
        return this.aDZ.aDI;
    }
}
