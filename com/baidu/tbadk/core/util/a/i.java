package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0006a {
    private static int aie = 5;
    private static int aii = 0;
    private static int aij = 0;
    private static int aik = 0;
    private static int aio = 0;
    private com.baidu.adp.lib.network.http.e aib;
    private f aif;
    private volatile com.baidu.adp.lib.network.http.c om = null;
    private HashMap<String, String> aic = null;
    private com.baidu.adp.lib.network.http.g aid = new com.baidu.adp.lib.network.http.g();
    public boolean aig = false;
    public boolean isGif = false;
    public String vA = "";
    public com.baidu.adp.lib.network.http.d aih = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ail = false;
    public boolean aim = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ain = false;

    public boolean wg() {
        return this.ail;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.aid;
    }

    public void wh() {
        this.aih = null;
        this.vA = "";
        this.ail = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aig = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eh(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wh();
                if (this.aib != null) {
                    cancel();
                    this.om = null;
                }
                this.aib = new com.baidu.adp.lib.network.http.e();
                this.aib.fy().setUrl(str);
                if (this.aic != null) {
                    for (Map.Entry<String, String> entry : this.aic.entrySet()) {
                        this.aib.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.om = new com.baidu.adp.lib.network.http.c(this.aib);
                this.om.d(aie, 0, 0);
                this.aid = this.aib.fz();
                byte[] bArr = this.aib.fz().vT;
                this.responseCode = this.aib.fz().responseCode;
                this.errorCode = this.aib.fz().vR;
                this.ail = this.aib.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aib.fz().contentEncoding != null && this.aib.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aig = true;
                    bArr = y(bArr);
                }
                if (!this.ail) {
                    c(str, null);
                }
                this.aih = this.aib.fB();
                if (this.aih != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aih;
                    dVar.vA = sb.append(dVar.vA).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aih;
                    dVar2.vA = sb2.append(dVar2.vA).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aih = this.aib.fB();
                if (this.aih != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aih;
                    dVar3.vA = sb3.append(dVar3.vA).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aih;
                    dVar4.vA = sb4.append(dVar4.vA).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aih = this.aib.fB();
            if (this.aih != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aih;
                dVar5.vA = sb5.append(dVar5.vA).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aih;
                dVar6.vA = sb6.append(dVar6.vA).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] ei(String str) {
        return eh(str);
    }

    private boolean wi() {
        if (this.aid.vQ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aio + 1;
            aio = i;
            if (i >= 5) {
                aio = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] k(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] eh = eh(str);
                int i3 = aii + 1;
                aii = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aii == 1) {
                        aik = this.errorCode;
                    }
                    aij++;
                }
                if (aii == 2) {
                    r.a("A2T", aik, this.errorCode, aij);
                }
                if (true == wi()) {
                    this.mUseHttpClient = true;
                    this.ain = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aij = 0;
                    aii = 0;
                    aik = 0;
                }
                if (eh == null) {
                    return null;
                }
                if (this.aib != null && this.aib.fz().vS != null) {
                    List<String> list = this.aib.fz().vS.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aib.fz().vS.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aib.fz().vS.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aim = false;
                            i = i2;
                            return (this.ail || (!z && i == 0) || !new String(eh, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eh : copyOfRange(eh, 23, eh.length);
                        }
                        this.aim = true;
                    }
                }
                i = i2;
                if (this.ail) {
                }
            } catch (Exception e) {
                this.vA += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                wh();
                if (this.aif != null) {
                    cancel();
                }
                this.aib = new com.baidu.adp.lib.network.http.e();
                this.aif = new f(this.aib);
                this.aib.fy().setUrl(str);
                if (this.aic != null) {
                    for (Map.Entry<String, String> entry : this.aic.entrySet()) {
                        this.aib.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aif.d(null, null, -1);
                this.aid = this.aib.fz();
                byte[] bArr = this.aib.fz().vT;
                this.responseCode = this.aib.fz().responseCode;
                this.errorCode = this.aib.fz().vR;
                this.ail = this.aib.fz().fF();
                if (this.mUseHttpAutoSwitch && true == wi()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aij = 0;
                    aii = 0;
                    aik = 0;
                }
                if (this.ain) {
                    int i4 = aii + 1;
                    aii = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aij++;
                        if (aii == 1) {
                            aik = this.errorCode;
                        }
                    }
                    if (aii == 2) {
                        r.a("T2A", aik, this.errorCode, aij);
                        this.ain = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aif.isGif();
                this.aim = this.aif.wf();
                int size = this.aib.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aib.fA().get(i2) != null) {
                            sb.append(this.aib.fA().get(i2).vD);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aih = this.aib.fB();
                if (this.aih != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aih;
                    dVar.vA = sb2.append(dVar.vA).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aih;
                    dVar2.vA = sb3.append(dVar2.vA).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aih;
                    dVar3.vA = sb4.append(dVar3.vA).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aib.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aib.fA().get(i2) != null) {
                            sb.append(this.aib.fA().get(i2).vD);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aih = this.aib.fB();
                if (this.aih != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aih;
                    dVar4.vA = sb5.append(dVar4.vA).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aih;
                    dVar5.vA = sb6.append(dVar5.vA).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aih;
                    dVar6.vA = sb7.append(dVar6.vA).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aib.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aib.fA().get(i2) != null) {
                        sb.append(this.aib.fA().get(i2).vD);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aih = this.aib.fB();
            if (this.aih != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aih;
                dVar7.vA = sb8.append(dVar7.vA).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aih;
                dVar8.vA = sb9.append(dVar8.vA).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aih;
                dVar9.vA = sb10.append(dVar9.vA).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aib.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aib.fA().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.vA);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.vx);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.vv);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.vw);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.vz);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.vB);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.vy);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.vC);
            }
            if (exc != null) {
                stringBuffer.append("webclient exception");
                stringBuffer.append("class");
                stringBuffer.append(exc.getClass());
                stringBuffer.append(PushConstants.EXTRA_PUSH_MESSAGE);
                stringBuffer.append(exc.getMessage());
            } else {
                stringBuffer.append("networkcore exception");
            }
            this.vA = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ail = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        if (this.om != null) {
            this.om.cancel();
        }
        if (this.aif != null) {
            this.aif.cancel();
            this.aif = null;
        }
    }

    public boolean wj() {
        if (this.aif == null) {
            return false;
        }
        return this.aif.ahN;
    }
}
