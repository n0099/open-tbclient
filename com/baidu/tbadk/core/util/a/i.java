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
    private static int aDZ = 5;
    private static int aEd = 0;
    private static int aEe = 0;
    private static int aEf = 0;
    private static int aEj = 0;
    private com.baidu.adp.lib.network.http.e aDW;
    private f aEa;
    private volatile com.baidu.adp.lib.network.http.c we = null;
    private HashMap<String, String> aDX = null;
    private com.baidu.adp.lib.network.http.g aDY = new com.baidu.adp.lib.network.http.g();
    public boolean aEb = false;
    public boolean isGif = false;
    public String CL = "";
    public com.baidu.adp.lib.network.http.d aEc = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aEg = false;
    public boolean aEh = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aEi = false;

    public boolean Ep() {
        return this.aEg;
    }

    public com.baidu.adp.lib.network.http.g jq() {
        return this.aDY;
    }

    public void Eq() {
        this.aEc = null;
        this.CL = "";
        this.aEg = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aEb = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] fW(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Eq();
                if (this.aDW != null) {
                    cancel();
                    this.we = null;
                }
                this.aDW = new com.baidu.adp.lib.network.http.e();
                this.aDW.jp().setUrl(str);
                if (this.aDX != null) {
                    for (Map.Entry<String, String> entry : this.aDX.entrySet()) {
                        this.aDW.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.we = new com.baidu.adp.lib.network.http.c(this.aDW);
                this.we.e(aDZ, 0, 0);
                this.aDY = this.aDW.jq();
                byte[] bArr = this.aDW.jq().Dg;
                this.responseCode = this.aDW.jq().responseCode;
                this.errorCode = this.aDW.jq().De;
                this.aEg = this.aDW.jq().jw();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aDW.jq().contentEncoding != null && this.aDW.jq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aEb = true;
                    bArr = E(bArr);
                }
                if (!this.aEg) {
                    d(str, null);
                }
                this.aEc = this.aDW.js();
                if (this.aEc != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEc;
                    dVar.CL = sb.append(dVar.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEc;
                    dVar2.CL = sb2.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.aEc = this.aDW.js();
                if (this.aEc != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEc;
                    dVar3.CL = sb3.append(dVar3.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEc;
                    dVar4.CL = sb4.append(dVar4.CL).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aEc = this.aDW.js();
            if (this.aEc != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aEc;
                dVar5.CL = sb5.append(dVar5.CL).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aEc;
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

    public byte[] fX(String str) {
        return fW(str);
    }

    private boolean Er() {
        if (this.aDY.Dd) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aEj + 1;
            aEj = i;
            if (i >= 5) {
                aEj = 0;
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
                byte[] fW = fW(str);
                int i3 = aEd + 1;
                aEd = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aEd == 1) {
                        aEf = this.errorCode;
                    }
                    aEe++;
                }
                if (aEd == 2) {
                    s.b("A2T", aEf, this.errorCode, aEe);
                }
                if (true == Er()) {
                    this.mUseHttpClient = true;
                    this.aEi = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aEe = 0;
                    aEd = 0;
                    aEf = 0;
                }
                if (fW == null) {
                    return null;
                }
                if (this.aDW != null && this.aDW.jq().Df != null) {
                    List<String> list = this.aDW.jq().Df.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aDW.jq().Df.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aDW.jq().Df.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aEh = false;
                            i = i2;
                            return (this.aEg || (!z && i == 0) || !new String(fW, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? fW : copyOfRange(fW, 23, fW.length);
                        }
                        this.aEh = true;
                    }
                }
                i = i2;
                if (this.aEg) {
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
                if (this.aEa != null) {
                    cancel();
                }
                this.aDW = new com.baidu.adp.lib.network.http.e();
                this.aEa = new f(this.aDW);
                this.aDW.jp().setUrl(str);
                if (this.aDX != null) {
                    for (Map.Entry<String, String> entry : this.aDX.entrySet()) {
                        this.aDW.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.aEa.e(null, null, -1);
                this.aDY = this.aDW.jq();
                byte[] bArr = this.aDW.jq().Dg;
                this.responseCode = this.aDW.jq().responseCode;
                this.errorCode = this.aDW.jq().De;
                this.aEg = this.aDW.jq().jw();
                if (this.mUseHttpAutoSwitch && true == Er()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aEe = 0;
                    aEd = 0;
                    aEf = 0;
                }
                if (this.aEi) {
                    int i4 = aEd + 1;
                    aEd = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aEe++;
                        if (aEd == 1) {
                            aEf = this.errorCode;
                        }
                    }
                    if (aEd == 2) {
                        s.b("T2A", aEf, this.errorCode, aEe);
                        this.aEi = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aEa.isGif();
                this.aEh = this.aEa.Eo();
                int size = this.aDW.jr().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aDW.jr().get(i2) != null) {
                            sb.append(this.aDW.jr().get(i2).CO);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEc = this.aDW.js();
                if (this.aEc != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEc;
                    dVar.CL = sb2.append(dVar.CL).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEc;
                    dVar2.CL = sb3.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEc;
                    dVar3.CL = sb4.append(dVar3.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.aDW.jr().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aDW.jr().get(i2) != null) {
                            sb.append(this.aDW.jr().get(i2).CO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEc = this.aDW.js();
                if (this.aEc != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEc;
                    dVar4.CL = sb5.append(dVar4.CL).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aEc;
                    dVar5.CL = sb6.append(dVar5.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aEc;
                    dVar6.CL = sb7.append(dVar6.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aDW.jr().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aDW.jr().get(i2) != null) {
                        sb.append(this.aDW.jr().get(i2).CO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.aEc = this.aDW.js();
            if (this.aEc != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aEc;
                dVar7.CL = sb8.append(dVar7.CL).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aEc;
                dVar8.CL = sb9.append(dVar8.CL).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aEc;
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
            for (int i = 0; i < this.aDW.jr().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aDW.jr().get(i);
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
            this.aEg = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.we != null) {
            this.we.cancel();
        }
        if (this.aEa != null) {
            this.aEa.cancel();
            this.aEa = null;
        }
    }

    public boolean Es() {
        if (this.aEa == null) {
            return false;
        }
        return this.aEa.aDJ;
    }
}
