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
    private static int aEB = 5;
    private static int aEF = 0;
    private static int aEG = 0;
    private static int aEH = 0;
    private static int aEL = 0;
    private f aEC;
    private com.baidu.adp.lib.network.http.e aEy;
    private volatile com.baidu.adp.lib.network.http.c we = null;
    private HashMap<String, String> aEz = null;
    private com.baidu.adp.lib.network.http.g aEA = new com.baidu.adp.lib.network.http.g();
    public boolean aED = false;
    public boolean isGif = false;
    public String CL = "";
    public com.baidu.adp.lib.network.http.d aEE = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aEI = false;
    public boolean aEJ = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aEK = false;

    public boolean EC() {
        return this.aEI;
    }

    public com.baidu.adp.lib.network.http.g jq() {
        return this.aEA;
    }

    public void ED() {
        this.aEE = null;
        this.CL = "";
        this.aEI = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aED = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] gj(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                ED();
                if (this.aEy != null) {
                    cancel();
                    this.we = null;
                }
                this.aEy = new com.baidu.adp.lib.network.http.e();
                this.aEy.jp().setUrl(str);
                if (this.aEz != null) {
                    for (Map.Entry<String, String> entry : this.aEz.entrySet()) {
                        this.aEy.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.we = new com.baidu.adp.lib.network.http.c(this.aEy);
                this.we.e(aEB, 0, 0);
                this.aEA = this.aEy.jq();
                byte[] bArr = this.aEy.jq().Dg;
                this.responseCode = this.aEy.jq().responseCode;
                this.errorCode = this.aEy.jq().De;
                this.aEI = this.aEy.jq().jw();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aEy.jq().contentEncoding != null && this.aEy.jq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aED = true;
                    bArr = E(bArr);
                }
                if (!this.aEI) {
                    d(str, null);
                }
                this.aEE = this.aEy.js();
                if (this.aEE != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEE;
                    dVar.CL = sb.append(dVar.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEE;
                    dVar2.CL = sb2.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.aEE = this.aEy.js();
                if (this.aEE != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEE;
                    dVar3.CL = sb3.append(dVar3.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEE;
                    dVar4.CL = sb4.append(dVar4.CL).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aEE = this.aEy.js();
            if (this.aEE != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aEE;
                dVar5.CL = sb5.append(dVar5.CL).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aEE;
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

    public byte[] gk(String str) {
        return gj(str);
    }

    private boolean EE() {
        if (this.aEA.Dd) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aEL + 1;
            aEL = i;
            if (i >= 5) {
                aEL = 0;
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
                byte[] gj = gj(str);
                int i3 = aEF + 1;
                aEF = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aEF == 1) {
                        aEH = this.errorCode;
                    }
                    aEG++;
                }
                if (aEF == 2) {
                    s.b("A2T", aEH, this.errorCode, aEG);
                }
                if (true == EE()) {
                    this.mUseHttpClient = true;
                    this.aEK = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aEG = 0;
                    aEF = 0;
                    aEH = 0;
                }
                if (gj == null) {
                    return null;
                }
                if (this.aEy != null && this.aEy.jq().Df != null) {
                    List<String> list = this.aEy.jq().Df.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aEy.jq().Df.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aEy.jq().Df.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aEJ = false;
                            i = i2;
                            return (this.aEI || (!z && i == 0) || !new String(gj, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? gj : copyOfRange(gj, 23, gj.length);
                        }
                        this.aEJ = true;
                    }
                }
                i = i2;
                if (this.aEI) {
                }
            } catch (Exception e) {
                this.CL += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                ED();
                if (this.aEC != null) {
                    cancel();
                }
                this.aEy = new com.baidu.adp.lib.network.http.e();
                this.aEC = new f(this.aEy);
                this.aEy.jp().setUrl(str);
                if (this.aEz != null) {
                    for (Map.Entry<String, String> entry : this.aEz.entrySet()) {
                        this.aEy.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.aEC.e(null, null, -1);
                this.aEA = this.aEy.jq();
                byte[] bArr = this.aEy.jq().Dg;
                this.responseCode = this.aEy.jq().responseCode;
                this.errorCode = this.aEy.jq().De;
                this.aEI = this.aEy.jq().jw();
                if (this.mUseHttpAutoSwitch && true == EE()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aEG = 0;
                    aEF = 0;
                    aEH = 0;
                }
                if (this.aEK) {
                    int i4 = aEF + 1;
                    aEF = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aEG++;
                        if (aEF == 1) {
                            aEH = this.errorCode;
                        }
                    }
                    if (aEF == 2) {
                        s.b("T2A", aEH, this.errorCode, aEG);
                        this.aEK = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aEC.isGif();
                this.aEJ = this.aEC.EB();
                int size = this.aEy.jr().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aEy.jr().get(i2) != null) {
                            sb.append(this.aEy.jr().get(i2).CO);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEE = this.aEy.js();
                if (this.aEE != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEE;
                    dVar.CL = sb2.append(dVar.CL).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEE;
                    dVar2.CL = sb3.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEE;
                    dVar3.CL = sb4.append(dVar3.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.aEy.jr().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aEy.jr().get(i2) != null) {
                            sb.append(this.aEy.jr().get(i2).CO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEE = this.aEy.js();
                if (this.aEE != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEE;
                    dVar4.CL = sb5.append(dVar4.CL).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aEE;
                    dVar5.CL = sb6.append(dVar5.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aEE;
                    dVar6.CL = sb7.append(dVar6.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aEy.jr().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aEy.jr().get(i2) != null) {
                        sb.append(this.aEy.jr().get(i2).CO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.aEE = this.aEy.js();
            if (this.aEE != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aEE;
                dVar7.CL = sb8.append(dVar7.CL).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aEE;
                dVar8.CL = sb9.append(dVar8.CL).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aEE;
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
            for (int i = 0; i < this.aEy.jr().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aEy.jr().get(i);
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
            this.aEI = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.we != null) {
            this.we.cancel();
        }
        if (this.aEC != null) {
            this.aEC.cancel();
            this.aEC = null;
        }
    }

    public boolean EF() {
        if (this.aEC == null) {
            return false;
        }
        return this.aEC.aEl;
    }
}
