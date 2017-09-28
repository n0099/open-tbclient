package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0005a {
    private com.baidu.adp.lib.network.http.e air;
    private f aiv;
    private static int aiu = 5;
    private static int aiy = 0;
    private static int aiz = 0;
    private static int aiA = 0;
    private static int aiE = 0;
    private volatile com.baidu.adp.lib.network.http.c nI = null;
    private HashMap<String, String> ais = null;
    private com.baidu.adp.lib.network.http.g ait = new com.baidu.adp.lib.network.http.g();
    public boolean aiw = false;
    public boolean isGif = false;
    public String uX = "";
    public com.baidu.adp.lib.network.http.d aix = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aiB = false;
    public boolean aiC = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aiD = false;

    public boolean vS() {
        return this.aiB;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.ait;
    }

    public void vT() {
        this.aix = null;
        this.uX = "";
        this.aiB = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aiw = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eb(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vT();
                if (this.air != null) {
                    cancel();
                    this.nI = null;
                }
                this.air = new com.baidu.adp.lib.network.http.e();
                this.air.fy().setUrl(str);
                if (this.ais != null) {
                    for (Map.Entry<String, String> entry : this.ais.entrySet()) {
                        this.air.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nI = new com.baidu.adp.lib.network.http.c(this.air);
                this.nI.d(aiu, 0, 0);
                this.ait = this.air.fz();
                byte[] bArr = this.air.fz().vq;
                this.responseCode = this.air.fz().responseCode;
                this.errorCode = this.air.fz().vo;
                this.aiB = this.air.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.air.fz().contentEncoding != null && this.air.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aiw = true;
                    bArr = w(bArr);
                }
                if (!this.aiB) {
                    c(str, null);
                }
                this.aix = this.air.fB();
                if (this.aix != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aix;
                    dVar.uX = sb.append(dVar.uX).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aix;
                    dVar2.uX = sb2.append(dVar2.uX).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aix = this.air.fB();
                if (this.aix != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aix;
                    dVar3.uX = sb3.append(dVar3.uX).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aix;
                    dVar4.uX = sb4.append(dVar4.uX).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aix = this.air.fB();
            if (this.aix != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aix;
                dVar5.uX = sb5.append(dVar5.uX).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aix;
                dVar6.uX = sb6.append(dVar6.uX).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] w(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] ec(String str) {
        return eb(str);
    }

    private boolean vU() {
        if (this.ait.vn) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aiE + 1;
            aiE = i;
            if (i >= 5) {
                aiE = 0;
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
                byte[] eb = eb(str);
                int i3 = aiy + 1;
                aiy = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aiy == 1) {
                        aiA = this.errorCode;
                    }
                    aiz++;
                }
                if (aiy == 2) {
                    s.a("A2T", aiA, this.errorCode, aiz);
                }
                if (true == vU()) {
                    this.mUseHttpClient = true;
                    this.aiD = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aiz = 0;
                    aiy = 0;
                    aiA = 0;
                }
                if (eb == null) {
                    return null;
                }
                if (this.air != null && this.air.fz().vp != null) {
                    List<String> list = this.air.fz().vp.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.air.fz().vp.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.air.fz().vp.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aiC = false;
                            i = i2;
                            return (this.aiB || (!z && i == 0) || !new String(eb, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eb : copyOfRange(eb, 23, eb.length);
                        }
                        this.aiC = true;
                    }
                }
                i = i2;
                if (this.aiB) {
                }
            } catch (Exception e) {
                this.uX += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                vT();
                if (this.aiv != null) {
                    cancel();
                }
                this.air = new com.baidu.adp.lib.network.http.e();
                this.aiv = new f(this.air);
                this.air.fy().setUrl(str);
                if (this.ais != null) {
                    for (Map.Entry<String, String> entry : this.ais.entrySet()) {
                        this.air.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aiv.d(null, null, -1);
                this.ait = this.air.fz();
                byte[] bArr = this.air.fz().vq;
                this.responseCode = this.air.fz().responseCode;
                this.errorCode = this.air.fz().vo;
                this.aiB = this.air.fz().fF();
                if (this.mUseHttpAutoSwitch && true == vU()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aiz = 0;
                    aiy = 0;
                    aiA = 0;
                }
                if (this.aiD) {
                    int i4 = aiy + 1;
                    aiy = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aiz++;
                        if (aiy == 1) {
                            aiA = this.errorCode;
                        }
                    }
                    if (aiy == 2) {
                        s.a("T2A", aiA, this.errorCode, aiz);
                        this.aiD = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aiv.isGif();
                this.aiC = this.aiv.vR();
                int size = this.air.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.air.fA().get(i2) != null) {
                            sb.append(this.air.fA().get(i2).va);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aix = this.air.fB();
                if (this.aix != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aix;
                    dVar.uX = sb2.append(dVar.uX).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aix;
                    dVar2.uX = sb3.append(dVar2.uX).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aix;
                    dVar3.uX = sb4.append(dVar3.uX).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.air.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.air.fA().get(i2) != null) {
                            sb.append(this.air.fA().get(i2).va);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aix = this.air.fB();
                if (this.aix != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aix;
                    dVar4.uX = sb5.append(dVar4.uX).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aix;
                    dVar5.uX = sb6.append(dVar5.uX).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aix;
                    dVar6.uX = sb7.append(dVar6.uX).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.air.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.air.fA().get(i2) != null) {
                        sb.append(this.air.fA().get(i2).va);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aix = this.air.fB();
            if (this.aix != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aix;
                dVar7.uX = sb8.append(dVar7.uX).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aix;
                dVar8.uX = sb9.append(dVar8.uX).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aix;
                dVar9.uX = sb10.append(dVar9.uX).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.air.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.air.fA().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uZ);
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
            this.uX = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aiB = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nI != null) {
            this.nI.cancel();
        }
        if (this.aiv != null) {
            this.aiv.cancel();
            this.aiv = null;
        }
    }

    public boolean vV() {
        if (this.aiv == null) {
            return false;
        }
        return this.aiv.aid;
    }
}
