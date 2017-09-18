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
    private static int aiS = 5;
    private static int aiW = 0;
    private static int aiX = 0;
    private static int aiY = 0;
    private static int ajc = 0;
    private com.baidu.adp.lib.network.http.e aiP;
    private f aiT;
    private volatile com.baidu.adp.lib.network.http.c nH = null;
    private HashMap<String, String> aiQ = null;
    private com.baidu.adp.lib.network.http.g aiR = new com.baidu.adp.lib.network.http.g();
    public boolean aiU = false;
    public boolean isGif = false;
    public String uV = "";
    public com.baidu.adp.lib.network.http.d aiV = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aiZ = false;
    public boolean aja = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ajb = false;

    public boolean wo() {
        return this.aiZ;
    }

    public com.baidu.adp.lib.network.http.g fA() {
        return this.aiR;
    }

    public void wp() {
        this.aiV = null;
        this.uV = "";
        this.aiZ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aiU = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ej(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wp();
                if (this.aiP != null) {
                    cancel();
                    this.nH = null;
                }
                this.aiP = new com.baidu.adp.lib.network.http.e();
                this.aiP.fz().setUrl(str);
                if (this.aiQ != null) {
                    for (Map.Entry<String, String> entry : this.aiQ.entrySet()) {
                        this.aiP.fz().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nH = new com.baidu.adp.lib.network.http.c(this.aiP);
                this.nH.d(aiS, 0, 0);
                this.aiR = this.aiP.fA();
                byte[] bArr = this.aiP.fA().vo;
                this.responseCode = this.aiP.fA().responseCode;
                this.errorCode = this.aiP.fA().vm;
                this.aiZ = this.aiP.fA().fG();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aiP.fA().contentEncoding != null && this.aiP.fA().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aiU = true;
                    bArr = w(bArr);
                }
                if (!this.aiZ) {
                    c(str, null);
                }
                this.aiV = this.aiP.fC();
                if (this.aiV != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiV;
                    dVar.uV = sb.append(dVar.uV).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiV;
                    dVar2.uV = sb2.append(dVar2.uV).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aiV = this.aiP.fC();
                if (this.aiV != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiV;
                    dVar3.uV = sb3.append(dVar3.uV).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiV;
                    dVar4.uV = sb4.append(dVar4.uV).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aiV = this.aiP.fC();
            if (this.aiV != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aiV;
                dVar5.uV = sb5.append(dVar5.uV).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aiV;
                dVar6.uV = sb6.append(dVar6.uV).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] w(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] ek(String str) {
        return ej(str);
    }

    private boolean wq() {
        if (this.aiR.vl) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ajc + 1;
            ajc = i;
            if (i >= 5) {
                ajc = 0;
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
                byte[] ej = ej(str);
                int i3 = aiW + 1;
                aiW = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aiW == 1) {
                        aiY = this.errorCode;
                    }
                    aiX++;
                }
                if (aiW == 2) {
                    s.a("A2T", aiY, this.errorCode, aiX);
                }
                if (true == wq()) {
                    this.mUseHttpClient = true;
                    this.ajb = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aiX = 0;
                    aiW = 0;
                    aiY = 0;
                }
                if (ej == null) {
                    return null;
                }
                if (this.aiP != null && this.aiP.fA().vn != null) {
                    List<String> list = this.aiP.fA().vn.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aiP.fA().vn.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aiP.fA().vn.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aja = false;
                            i = i2;
                            return (this.aiZ || (!z && i == 0) || !new String(ej, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ej : copyOfRange(ej, 23, ej.length);
                        }
                        this.aja = true;
                    }
                }
                i = i2;
                if (this.aiZ) {
                }
            } catch (Exception e) {
                this.uV += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                wp();
                if (this.aiT != null) {
                    cancel();
                }
                this.aiP = new com.baidu.adp.lib.network.http.e();
                this.aiT = new f(this.aiP);
                this.aiP.fz().setUrl(str);
                if (this.aiQ != null) {
                    for (Map.Entry<String, String> entry : this.aiQ.entrySet()) {
                        this.aiP.fz().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aiT.d(null, null, -1);
                this.aiR = this.aiP.fA();
                byte[] bArr = this.aiP.fA().vo;
                this.responseCode = this.aiP.fA().responseCode;
                this.errorCode = this.aiP.fA().vm;
                this.aiZ = this.aiP.fA().fG();
                if (this.mUseHttpAutoSwitch && true == wq()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aiX = 0;
                    aiW = 0;
                    aiY = 0;
                }
                if (this.ajb) {
                    int i4 = aiW + 1;
                    aiW = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aiX++;
                        if (aiW == 1) {
                            aiY = this.errorCode;
                        }
                    }
                    if (aiW == 2) {
                        s.a("T2A", aiY, this.errorCode, aiX);
                        this.ajb = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aiT.isGif();
                this.aja = this.aiT.wn();
                int size = this.aiP.fB().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aiP.fB().get(i2) != null) {
                            sb.append(this.aiP.fB().get(i2).uY);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiV = this.aiP.fC();
                if (this.aiV != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiV;
                    dVar.uV = sb2.append(dVar.uV).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiV;
                    dVar2.uV = sb3.append(dVar2.uV).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiV;
                    dVar3.uV = sb4.append(dVar3.uV).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aiP.fB().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aiP.fB().get(i2) != null) {
                            sb.append(this.aiP.fB().get(i2).uY);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiV = this.aiP.fC();
                if (this.aiV != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiV;
                    dVar4.uV = sb5.append(dVar4.uV).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aiV;
                    dVar5.uV = sb6.append(dVar5.uV).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aiV;
                    dVar6.uV = sb7.append(dVar6.uV).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aiP.fB().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aiP.fB().get(i2) != null) {
                        sb.append(this.aiP.fB().get(i2).uY);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aiV = this.aiP.fC();
            if (this.aiV != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aiV;
                dVar7.uV = sb8.append(dVar7.uV).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aiV;
                dVar8.uV = sb9.append(dVar8.uV).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aiV;
                dVar9.uV = sb10.append(dVar9.uV).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aiP.fB().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aiP.fB().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uQ);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uX);
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
            this.uV = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aiZ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nH != null) {
            this.nH.cancel();
        }
        if (this.aiT != null) {
            this.aiT.cancel();
            this.aiT = null;
        }
    }

    public boolean wr() {
        if (this.aiT == null) {
            return false;
        }
        return this.aiT.aiB;
    }
}
