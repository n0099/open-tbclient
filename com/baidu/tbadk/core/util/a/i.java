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
    private static int aiF = 5;
    private static int aiJ = 0;
    private static int aiK = 0;
    private static int aiL = 0;
    private static int aiP = 0;
    private com.baidu.adp.lib.network.http.e aiC;
    private f aiG;
    private volatile com.baidu.adp.lib.network.http.c nJ = null;
    private HashMap<String, String> aiD = null;
    private com.baidu.adp.lib.network.http.g aiE = new com.baidu.adp.lib.network.http.g();
    public boolean aiH = false;
    public boolean isGif = false;
    public String uY = "";
    public com.baidu.adp.lib.network.http.d aiI = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aiM = false;
    public boolean aiN = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aiO = false;

    public boolean vT() {
        return this.aiM;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.aiE;
    }

    public void vU() {
        this.aiI = null;
        this.uY = "";
        this.aiM = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aiH = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eg(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vU();
                if (this.aiC != null) {
                    cancel();
                    this.nJ = null;
                }
                this.aiC = new com.baidu.adp.lib.network.http.e();
                this.aiC.fy().setUrl(str);
                if (this.aiD != null) {
                    for (Map.Entry<String, String> entry : this.aiD.entrySet()) {
                        this.aiC.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nJ = new com.baidu.adp.lib.network.http.c(this.aiC);
                this.nJ.d(aiF, 0, 0);
                this.aiE = this.aiC.fz();
                byte[] bArr = this.aiC.fz().vr;
                this.responseCode = this.aiC.fz().responseCode;
                this.errorCode = this.aiC.fz().vp;
                this.aiM = this.aiC.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aiC.fz().contentEncoding != null && this.aiC.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aiH = true;
                    bArr = w(bArr);
                }
                if (!this.aiM) {
                    c(str, null);
                }
                this.aiI = this.aiC.fB();
                if (this.aiI != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiI;
                    dVar.uY = sb.append(dVar.uY).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiI;
                    dVar2.uY = sb2.append(dVar2.uY).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aiI = this.aiC.fB();
                if (this.aiI != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiI;
                    dVar3.uY = sb3.append(dVar3.uY).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiI;
                    dVar4.uY = sb4.append(dVar4.uY).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aiI = this.aiC.fB();
            if (this.aiI != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aiI;
                dVar5.uY = sb5.append(dVar5.uY).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aiI;
                dVar6.uY = sb6.append(dVar6.uY).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] eh(String str) {
        return eg(str);
    }

    private boolean vV() {
        if (this.aiE.vo) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aiP + 1;
            aiP = i;
            if (i >= 5) {
                aiP = 0;
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
                byte[] eg = eg(str);
                int i3 = aiJ + 1;
                aiJ = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aiJ == 1) {
                        aiL = this.errorCode;
                    }
                    aiK++;
                }
                if (aiJ == 2) {
                    s.a("A2T", aiL, this.errorCode, aiK);
                }
                if (true == vV()) {
                    this.mUseHttpClient = true;
                    this.aiO = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aiK = 0;
                    aiJ = 0;
                    aiL = 0;
                }
                if (eg == null) {
                    return null;
                }
                if (this.aiC != null && this.aiC.fz().vq != null) {
                    List<String> list = this.aiC.fz().vq.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aiC.fz().vq.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aiC.fz().vq.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aiN = false;
                            i = i2;
                            return (this.aiM || (!z && i == 0) || !new String(eg, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eg : copyOfRange(eg, 23, eg.length);
                        }
                        this.aiN = true;
                    }
                }
                i = i2;
                if (this.aiM) {
                }
            } catch (Exception e) {
                this.uY += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                vU();
                if (this.aiG != null) {
                    cancel();
                }
                this.aiC = new com.baidu.adp.lib.network.http.e();
                this.aiG = new f(this.aiC);
                this.aiC.fy().setUrl(str);
                if (this.aiD != null) {
                    for (Map.Entry<String, String> entry : this.aiD.entrySet()) {
                        this.aiC.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aiG.d(null, null, -1);
                this.aiE = this.aiC.fz();
                byte[] bArr = this.aiC.fz().vr;
                this.responseCode = this.aiC.fz().responseCode;
                this.errorCode = this.aiC.fz().vp;
                this.aiM = this.aiC.fz().fF();
                if (this.mUseHttpAutoSwitch && true == vV()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aiK = 0;
                    aiJ = 0;
                    aiL = 0;
                }
                if (this.aiO) {
                    int i4 = aiJ + 1;
                    aiJ = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aiK++;
                        if (aiJ == 1) {
                            aiL = this.errorCode;
                        }
                    }
                    if (aiJ == 2) {
                        s.a("T2A", aiL, this.errorCode, aiK);
                        this.aiO = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aiG.isGif();
                this.aiN = this.aiG.vS();
                int size = this.aiC.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aiC.fA().get(i2) != null) {
                            sb.append(this.aiC.fA().get(i2).vb);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiI = this.aiC.fB();
                if (this.aiI != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiI;
                    dVar.uY = sb2.append(dVar.uY).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiI;
                    dVar2.uY = sb3.append(dVar2.uY).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiI;
                    dVar3.uY = sb4.append(dVar3.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aiC.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aiC.fA().get(i2) != null) {
                            sb.append(this.aiC.fA().get(i2).vb);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiI = this.aiC.fB();
                if (this.aiI != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiI;
                    dVar4.uY = sb5.append(dVar4.uY).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aiI;
                    dVar5.uY = sb6.append(dVar5.uY).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aiI;
                    dVar6.uY = sb7.append(dVar6.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aiC.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aiC.fA().get(i2) != null) {
                        sb.append(this.aiC.fA().get(i2).vb);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aiI = this.aiC.fB();
            if (this.aiI != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aiI;
                dVar7.uY = sb8.append(dVar7.uY).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aiI;
                dVar8.uY = sb9.append(dVar8.uY).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aiI;
                dVar9.uY = sb10.append(dVar9.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aiC.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aiC.fA().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uZ);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.va);
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
            this.uY = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aiM = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nJ != null) {
            this.nJ.cancel();
        }
        if (this.aiG != null) {
            this.aiG.cancel();
            this.aiG = null;
        }
    }

    public boolean vW() {
        if (this.aiG == null) {
            return false;
        }
        return this.aiG.aio;
    }
}
