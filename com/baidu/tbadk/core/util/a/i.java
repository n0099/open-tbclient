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
    private static int aiV = 5;
    private static int aiZ = 0;
    private static int aja = 0;
    private static int ajb = 0;
    private static int ajf = 0;
    private com.baidu.adp.lib.network.http.e aiS;
    private f aiW;
    private volatile com.baidu.adp.lib.network.http.c nI = null;
    private HashMap<String, String> aiT = null;
    private com.baidu.adp.lib.network.http.g aiU = new com.baidu.adp.lib.network.http.g();
    public boolean aiX = false;
    public boolean isGif = false;
    public String uV = "";
    public com.baidu.adp.lib.network.http.d aiY = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ajc = false;
    public boolean ajd = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aje = false;

    public boolean vT() {
        return this.ajc;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.aiU;
    }

    public void vU() {
        this.aiY = null;
        this.uV = "";
        this.ajc = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aiX = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ei(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vU();
                if (this.aiS != null) {
                    cancel();
                    this.nI = null;
                }
                this.aiS = new com.baidu.adp.lib.network.http.e();
                this.aiS.fy().setUrl(str);
                if (this.aiT != null) {
                    for (Map.Entry<String, String> entry : this.aiT.entrySet()) {
                        this.aiS.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nI = new com.baidu.adp.lib.network.http.c(this.aiS);
                this.nI.d(aiV, 0, 0);
                this.aiU = this.aiS.fz();
                byte[] bArr = this.aiS.fz().vo;
                this.responseCode = this.aiS.fz().responseCode;
                this.errorCode = this.aiS.fz().vm;
                this.ajc = this.aiS.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aiS.fz().contentEncoding != null && this.aiS.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aiX = true;
                    bArr = w(bArr);
                }
                if (!this.ajc) {
                    c(str, null);
                }
                this.aiY = this.aiS.fB();
                if (this.aiY != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiY;
                    dVar.uV = sb.append(dVar.uV).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiY;
                    dVar2.uV = sb2.append(dVar2.uV).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aiY = this.aiS.fB();
                if (this.aiY != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiY;
                    dVar3.uV = sb3.append(dVar3.uV).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiY;
                    dVar4.uV = sb4.append(dVar4.uV).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aiY = this.aiS.fB();
            if (this.aiY != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aiY;
                dVar5.uV = sb5.append(dVar5.uV).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aiY;
                dVar6.uV = sb6.append(dVar6.uV).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] ej(String str) {
        return ei(str);
    }

    private boolean vV() {
        if (this.aiU.vl) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ajf + 1;
            ajf = i;
            if (i >= 5) {
                ajf = 0;
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
                byte[] ei = ei(str);
                int i3 = aiZ + 1;
                aiZ = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aiZ == 1) {
                        ajb = this.errorCode;
                    }
                    aja++;
                }
                if (aiZ == 2) {
                    s.a("A2T", ajb, this.errorCode, aja);
                }
                if (true == vV()) {
                    this.mUseHttpClient = true;
                    this.aje = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aja = 0;
                    aiZ = 0;
                    ajb = 0;
                }
                if (ei == null) {
                    return null;
                }
                if (this.aiS != null && this.aiS.fz().vn != null) {
                    List<String> list = this.aiS.fz().vn.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aiS.fz().vn.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aiS.fz().vn.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ajd = false;
                            i = i2;
                            return (this.ajc || (!z && i == 0) || !new String(ei, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ei : copyOfRange(ei, 23, ei.length);
                        }
                        this.ajd = true;
                    }
                }
                i = i2;
                if (this.ajc) {
                }
            } catch (Exception e) {
                this.uV += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                vU();
                if (this.aiW != null) {
                    cancel();
                }
                this.aiS = new com.baidu.adp.lib.network.http.e();
                this.aiW = new f(this.aiS);
                this.aiS.fy().setUrl(str);
                if (this.aiT != null) {
                    for (Map.Entry<String, String> entry : this.aiT.entrySet()) {
                        this.aiS.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aiW.d(null, null, -1);
                this.aiU = this.aiS.fz();
                byte[] bArr = this.aiS.fz().vo;
                this.responseCode = this.aiS.fz().responseCode;
                this.errorCode = this.aiS.fz().vm;
                this.ajc = this.aiS.fz().fF();
                if (this.mUseHttpAutoSwitch && true == vV()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aja = 0;
                    aiZ = 0;
                    ajb = 0;
                }
                if (this.aje) {
                    int i4 = aiZ + 1;
                    aiZ = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aja++;
                        if (aiZ == 1) {
                            ajb = this.errorCode;
                        }
                    }
                    if (aiZ == 2) {
                        s.a("T2A", ajb, this.errorCode, aja);
                        this.aje = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aiW.isGif();
                this.ajd = this.aiW.vS();
                int size = this.aiS.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aiS.fA().get(i2) != null) {
                            sb.append(this.aiS.fA().get(i2).uY);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiY = this.aiS.fB();
                if (this.aiY != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aiY;
                    dVar.uV = sb2.append(dVar.uV).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aiY;
                    dVar2.uV = sb3.append(dVar2.uV).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aiY;
                    dVar3.uV = sb4.append(dVar3.uV).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aiS.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aiS.fA().get(i2) != null) {
                            sb.append(this.aiS.fA().get(i2).uY);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aiY = this.aiS.fB();
                if (this.aiY != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aiY;
                    dVar4.uV = sb5.append(dVar4.uV).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aiY;
                    dVar5.uV = sb6.append(dVar5.uV).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aiY;
                    dVar6.uV = sb7.append(dVar6.uV).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aiS.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aiS.fA().get(i2) != null) {
                        sb.append(this.aiS.fA().get(i2).uY);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aiY = this.aiS.fB();
            if (this.aiY != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aiY;
                dVar7.uV = sb8.append(dVar7.uV).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aiY;
                dVar8.uV = sb9.append(dVar8.uV).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aiY;
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
            for (int i = 0; i < this.aiS.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aiS.fA().get(i);
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
            this.ajc = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nI != null) {
            this.nI.cancel();
        }
        if (this.aiW != null) {
            this.aiW.cancel();
            this.aiW = null;
        }
    }

    public boolean vW() {
        if (this.aiW == null) {
            return false;
        }
        return this.aiW.aiF;
    }
}
