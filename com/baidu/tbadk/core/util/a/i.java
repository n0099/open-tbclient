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
    private static int aEC = 5;
    private static int aEG = 0;
    private static int aEH = 0;
    private static int aEI = 0;
    private static int aEM = 0;
    private f aED;
    private com.baidu.adp.lib.network.http.e aEz;
    private volatile com.baidu.adp.lib.network.http.c we = null;
    private HashMap<String, String> aEA = null;
    private com.baidu.adp.lib.network.http.g aEB = new com.baidu.adp.lib.network.http.g();
    public boolean aEE = false;
    public boolean isGif = false;
    public String CL = "";
    public com.baidu.adp.lib.network.http.d aEF = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aEJ = false;
    public boolean aEK = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aEL = false;

    public boolean EC() {
        return this.aEJ;
    }

    public com.baidu.adp.lib.network.http.g jq() {
        return this.aEB;
    }

    public void ED() {
        this.aEF = null;
        this.CL = "";
        this.aEJ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aEE = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] gj(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                ED();
                if (this.aEz != null) {
                    cancel();
                    this.we = null;
                }
                this.aEz = new com.baidu.adp.lib.network.http.e();
                this.aEz.jp().setUrl(str);
                if (this.aEA != null) {
                    for (Map.Entry<String, String> entry : this.aEA.entrySet()) {
                        this.aEz.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.we = new com.baidu.adp.lib.network.http.c(this.aEz);
                this.we.e(aEC, 0, 0);
                this.aEB = this.aEz.jq();
                byte[] bArr = this.aEz.jq().Dg;
                this.responseCode = this.aEz.jq().responseCode;
                this.errorCode = this.aEz.jq().De;
                this.aEJ = this.aEz.jq().jw();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aEz.jq().contentEncoding != null && this.aEz.jq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aEE = true;
                    bArr = E(bArr);
                }
                if (!this.aEJ) {
                    d(str, null);
                }
                this.aEF = this.aEz.js();
                if (this.aEF != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEF;
                    dVar.CL = sb.append(dVar.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEF;
                    dVar2.CL = sb2.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.aEF = this.aEz.js();
                if (this.aEF != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEF;
                    dVar3.CL = sb3.append(dVar3.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEF;
                    dVar4.CL = sb4.append(dVar4.CL).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aEF = this.aEz.js();
            if (this.aEF != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aEF;
                dVar5.CL = sb5.append(dVar5.CL).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aEF;
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
        if (this.aEB.Dd) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aEM + 1;
            aEM = i;
            if (i >= 5) {
                aEM = 0;
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
                int i3 = aEG + 1;
                aEG = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aEG == 1) {
                        aEI = this.errorCode;
                    }
                    aEH++;
                }
                if (aEG == 2) {
                    s.b("A2T", aEI, this.errorCode, aEH);
                }
                if (true == EE()) {
                    this.mUseHttpClient = true;
                    this.aEL = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aEH = 0;
                    aEG = 0;
                    aEI = 0;
                }
                if (gj == null) {
                    return null;
                }
                if (this.aEz != null && this.aEz.jq().Df != null) {
                    List<String> list = this.aEz.jq().Df.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aEz.jq().Df.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aEz.jq().Df.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aEK = false;
                            i = i2;
                            return (this.aEJ || (!z && i == 0) || !new String(gj, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? gj : copyOfRange(gj, 23, gj.length);
                        }
                        this.aEK = true;
                    }
                }
                i = i2;
                if (this.aEJ) {
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
                if (this.aED != null) {
                    cancel();
                }
                this.aEz = new com.baidu.adp.lib.network.http.e();
                this.aED = new f(this.aEz);
                this.aEz.jp().setUrl(str);
                if (this.aEA != null) {
                    for (Map.Entry<String, String> entry : this.aEA.entrySet()) {
                        this.aEz.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.aED.e(null, null, -1);
                this.aEB = this.aEz.jq();
                byte[] bArr = this.aEz.jq().Dg;
                this.responseCode = this.aEz.jq().responseCode;
                this.errorCode = this.aEz.jq().De;
                this.aEJ = this.aEz.jq().jw();
                if (this.mUseHttpAutoSwitch && true == EE()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aEH = 0;
                    aEG = 0;
                    aEI = 0;
                }
                if (this.aEL) {
                    int i4 = aEG + 1;
                    aEG = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aEH++;
                        if (aEG == 1) {
                            aEI = this.errorCode;
                        }
                    }
                    if (aEG == 2) {
                        s.b("T2A", aEI, this.errorCode, aEH);
                        this.aEL = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aED.isGif();
                this.aEK = this.aED.EB();
                int size = this.aEz.jr().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aEz.jr().get(i2) != null) {
                            sb.append(this.aEz.jr().get(i2).CO);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEF = this.aEz.js();
                if (this.aEF != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aEF;
                    dVar.CL = sb2.append(dVar.CL).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aEF;
                    dVar2.CL = sb3.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aEF;
                    dVar3.CL = sb4.append(dVar3.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.aEz.jr().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aEz.jr().get(i2) != null) {
                            sb.append(this.aEz.jr().get(i2).CO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aEF = this.aEz.js();
                if (this.aEF != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aEF;
                    dVar4.CL = sb5.append(dVar4.CL).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aEF;
                    dVar5.CL = sb6.append(dVar5.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aEF;
                    dVar6.CL = sb7.append(dVar6.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aEz.jr().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aEz.jr().get(i2) != null) {
                        sb.append(this.aEz.jr().get(i2).CO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.aEF = this.aEz.js();
            if (this.aEF != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aEF;
                dVar7.CL = sb8.append(dVar7.CL).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aEF;
                dVar8.CL = sb9.append(dVar8.CL).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aEF;
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
            for (int i = 0; i < this.aEz.jr().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aEz.jr().get(i);
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
            this.aEJ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.we != null) {
            this.we.cancel();
        }
        if (this.aED != null) {
            this.aED.cancel();
            this.aED = null;
        }
    }

    public boolean EF() {
        if (this.aED == null) {
            return false;
        }
        return this.aED.aEm;
    }
}
