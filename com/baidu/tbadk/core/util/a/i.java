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
    private com.baidu.adp.lib.network.http.e aAv;
    private f aAz;
    private static int aAy = 5;
    private static int aAC = 0;
    private static int aAD = 0;
    private static int aAE = 0;
    private static int aAI = 0;
    private volatile com.baidu.adp.lib.network.http.c we = null;
    private HashMap<String, String> aAw = null;
    private com.baidu.adp.lib.network.http.g aAx = new com.baidu.adp.lib.network.http.g();
    public boolean aAA = false;
    public boolean isGif = false;
    public String CL = "";
    public com.baidu.adp.lib.network.http.d aAB = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aAF = false;
    public boolean aAG = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aAH = false;

    public boolean Dl() {
        return this.aAF;
    }

    public com.baidu.adp.lib.network.http.g jq() {
        return this.aAx;
    }

    public void Dm() {
        this.aAB = null;
        this.CL = "";
        this.aAF = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aAA = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] fD(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Dm();
                if (this.aAv != null) {
                    cancel();
                    this.we = null;
                }
                this.aAv = new com.baidu.adp.lib.network.http.e();
                this.aAv.jp().setUrl(str);
                if (this.aAw != null) {
                    for (Map.Entry<String, String> entry : this.aAw.entrySet()) {
                        this.aAv.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.we = new com.baidu.adp.lib.network.http.c(this.aAv);
                this.we.e(aAy, 0, 0);
                this.aAx = this.aAv.jq();
                byte[] bArr = this.aAv.jq().Dg;
                this.responseCode = this.aAv.jq().responseCode;
                this.errorCode = this.aAv.jq().De;
                this.aAF = this.aAv.jq().jw();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aAv.jq().contentEncoding != null && this.aAv.jq().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aAA = true;
                    bArr = E(bArr);
                }
                if (!this.aAF) {
                    d(str, null);
                }
                this.aAB = this.aAv.js();
                if (this.aAB != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aAB;
                    dVar.CL = sb.append(dVar.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aAB;
                    dVar2.CL = sb2.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.aAB = this.aAv.js();
                if (this.aAB != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aAB;
                    dVar3.CL = sb3.append(dVar3.CL).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aAB;
                    dVar4.CL = sb4.append(dVar4.CL).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aAB = this.aAv.js();
            if (this.aAB != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aAB;
                dVar5.CL = sb5.append(dVar5.CL).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aAB;
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

    public byte[] fE(String str) {
        return fD(str);
    }

    private boolean Dn() {
        if (this.aAx.Dd) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aAI + 1;
            aAI = i;
            if (i >= 5) {
                aAI = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] q(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] fD = fD(str);
                int i3 = aAC + 1;
                aAC = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aAC == 1) {
                        aAE = this.errorCode;
                    }
                    aAD++;
                }
                if (aAC == 2) {
                    s.b("A2T", aAE, this.errorCode, aAD);
                }
                if (true == Dn()) {
                    this.mUseHttpClient = true;
                    this.aAH = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aAD = 0;
                    aAC = 0;
                    aAE = 0;
                }
                if (fD == null) {
                    return null;
                }
                if (this.aAv != null && this.aAv.jq().Df != null) {
                    List<String> list = this.aAv.jq().Df.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aAv.jq().Df.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aAv.jq().Df.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aAG = false;
                            i = i2;
                            return (this.aAF || (!z && i == 0) || !new String(fD, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? fD : copyOfRange(fD, 23, fD.length);
                        }
                        this.aAG = true;
                    }
                }
                i = i2;
                if (this.aAF) {
                }
            } catch (Exception e) {
                this.CL += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Dm();
                if (this.aAz != null) {
                    cancel();
                }
                this.aAv = new com.baidu.adp.lib.network.http.e();
                this.aAz = new f(this.aAv);
                this.aAv.jp().setUrl(str);
                if (this.aAw != null) {
                    for (Map.Entry<String, String> entry : this.aAw.entrySet()) {
                        this.aAv.jp().x(entry.getKey(), entry.getValue());
                    }
                }
                this.aAz.e(null, null, -1);
                this.aAx = this.aAv.jq();
                byte[] bArr = this.aAv.jq().Dg;
                this.responseCode = this.aAv.jq().responseCode;
                this.errorCode = this.aAv.jq().De;
                this.aAF = this.aAv.jq().jw();
                if (this.mUseHttpAutoSwitch && true == Dn()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aAD = 0;
                    aAC = 0;
                    aAE = 0;
                }
                if (this.aAH) {
                    int i4 = aAC + 1;
                    aAC = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aAD++;
                        if (aAC == 1) {
                            aAE = this.errorCode;
                        }
                    }
                    if (aAC == 2) {
                        s.b("T2A", aAE, this.errorCode, aAD);
                        this.aAH = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aAz.isGif();
                this.aAG = this.aAz.Dk();
                int size = this.aAv.jr().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aAv.jr().get(i2) != null) {
                            sb.append(this.aAv.jr().get(i2).CO);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aAB = this.aAv.js();
                if (this.aAB != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aAB;
                    dVar.CL = sb2.append(dVar.CL).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aAB;
                    dVar2.CL = sb3.append(dVar2.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aAB;
                    dVar3.CL = sb4.append(dVar3.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.aAv.jr().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aAv.jr().get(i2) != null) {
                            sb.append(this.aAv.jr().get(i2).CO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.aAB = this.aAv.js();
                if (this.aAB != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aAB;
                    dVar4.CL = sb5.append(dVar4.CL).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aAB;
                    dVar5.CL = sb6.append(dVar5.CL).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aAB;
                    dVar6.CL = sb7.append(dVar6.CL).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aAv.jr().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aAv.jr().get(i2) != null) {
                        sb.append(this.aAv.jr().get(i2).CO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.aAB = this.aAv.js();
            if (this.aAB != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aAB;
                dVar7.CL = sb8.append(dVar7.CL).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aAB;
                dVar8.CL = sb9.append(dVar8.CL).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aAB;
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
            for (int i = 0; i < this.aAv.jr().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aAv.jr().get(i);
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
            this.aAF = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.we != null) {
            this.we.cancel();
        }
        if (this.aAz != null) {
            this.aAz.cancel();
            this.aAz = null;
        }
    }

    public boolean Do() {
        if (this.aAz == null) {
            return false;
        }
        return this.aAz.aAi;
    }
}
