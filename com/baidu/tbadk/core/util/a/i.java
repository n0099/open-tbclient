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
    private static int aiY = 5;
    private static int ajc = 0;
    private static int ajd = 0;
    private static int aje = 0;
    private static int aji = 0;
    private com.baidu.adp.lib.network.http.e aiV;
    private f aiZ;
    private volatile com.baidu.adp.lib.network.http.c nJ = null;
    private HashMap<String, String> aiW = null;
    private com.baidu.adp.lib.network.http.g aiX = new com.baidu.adp.lib.network.http.g();
    public boolean aja = false;
    public boolean isGif = false;
    public String uW = "";
    public com.baidu.adp.lib.network.http.d ajb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ajf = false;
    public boolean ajg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ajh = false;

    public boolean vT() {
        return this.ajf;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.aiX;
    }

    public void vU() {
        this.ajb = null;
        this.uW = "";
        this.ajf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aja = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ei(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vU();
                if (this.aiV != null) {
                    cancel();
                    this.nJ = null;
                }
                this.aiV = new com.baidu.adp.lib.network.http.e();
                this.aiV.fy().setUrl(str);
                if (this.aiW != null) {
                    for (Map.Entry<String, String> entry : this.aiW.entrySet()) {
                        this.aiV.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nJ = new com.baidu.adp.lib.network.http.c(this.aiV);
                this.nJ.d(aiY, 0, 0);
                this.aiX = this.aiV.fz();
                byte[] bArr = this.aiV.fz().vp;
                this.responseCode = this.aiV.fz().responseCode;
                this.errorCode = this.aiV.fz().vn;
                this.ajf = this.aiV.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aiV.fz().contentEncoding != null && this.aiV.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aja = true;
                    bArr = w(bArr);
                }
                if (!this.ajf) {
                    c(str, null);
                }
                this.ajb = this.aiV.fB();
                if (this.ajb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajb;
                    dVar.uW = sb.append(dVar.uW).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajb;
                    dVar2.uW = sb2.append(dVar2.uW).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ajb = this.aiV.fB();
                if (this.ajb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajb;
                    dVar3.uW = sb3.append(dVar3.uW).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajb;
                    dVar4.uW = sb4.append(dVar4.uW).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ajb = this.aiV.fB();
            if (this.ajb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ajb;
                dVar5.uW = sb5.append(dVar5.uW).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ajb;
                dVar6.uW = sb6.append(dVar6.uW).append("_responseCode:").append(this.responseCode).toString();
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
        if (this.aiX.vm) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aji + 1;
            aji = i;
            if (i >= 5) {
                aji = 0;
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
                int i3 = ajc + 1;
                ajc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ajc == 1) {
                        aje = this.errorCode;
                    }
                    ajd++;
                }
                if (ajc == 2) {
                    s.a("A2T", aje, this.errorCode, ajd);
                }
                if (true == vV()) {
                    this.mUseHttpClient = true;
                    this.ajh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    ajd = 0;
                    ajc = 0;
                    aje = 0;
                }
                if (ei == null) {
                    return null;
                }
                if (this.aiV != null && this.aiV.fz().vo != null) {
                    List<String> list = this.aiV.fz().vo.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aiV.fz().vo.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aiV.fz().vo.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ajg = false;
                            i = i2;
                            return (this.ajf || (!z && i == 0) || !new String(ei, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ei : copyOfRange(ei, 23, ei.length);
                        }
                        this.ajg = true;
                    }
                }
                i = i2;
                if (this.ajf) {
                }
            } catch (Exception e) {
                this.uW += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                vU();
                if (this.aiZ != null) {
                    cancel();
                }
                this.aiV = new com.baidu.adp.lib.network.http.e();
                this.aiZ = new f(this.aiV);
                this.aiV.fy().setUrl(str);
                if (this.aiW != null) {
                    for (Map.Entry<String, String> entry : this.aiW.entrySet()) {
                        this.aiV.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aiZ.d(null, null, -1);
                this.aiX = this.aiV.fz();
                byte[] bArr = this.aiV.fz().vp;
                this.responseCode = this.aiV.fz().responseCode;
                this.errorCode = this.aiV.fz().vn;
                this.ajf = this.aiV.fz().fF();
                if (this.mUseHttpAutoSwitch && true == vV()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    ajd = 0;
                    ajc = 0;
                    aje = 0;
                }
                if (this.ajh) {
                    int i4 = ajc + 1;
                    ajc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        ajd++;
                        if (ajc == 1) {
                            aje = this.errorCode;
                        }
                    }
                    if (ajc == 2) {
                        s.a("T2A", aje, this.errorCode, ajd);
                        this.ajh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aiZ.isGif();
                this.ajg = this.aiZ.vS();
                int size = this.aiV.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aiV.fA().get(i2) != null) {
                            sb.append(this.aiV.fA().get(i2).uZ);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajb = this.aiV.fB();
                if (this.ajb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajb;
                    dVar.uW = sb2.append(dVar.uW).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajb;
                    dVar2.uW = sb3.append(dVar2.uW).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajb;
                    dVar3.uW = sb4.append(dVar3.uW).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aiV.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aiV.fA().get(i2) != null) {
                            sb.append(this.aiV.fA().get(i2).uZ);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajb = this.aiV.fB();
                if (this.ajb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajb;
                    dVar4.uW = sb5.append(dVar4.uW).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ajb;
                    dVar5.uW = sb6.append(dVar5.uW).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ajb;
                    dVar6.uW = sb7.append(dVar6.uW).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aiV.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aiV.fA().get(i2) != null) {
                        sb.append(this.aiV.fA().get(i2).uZ);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.ajb = this.aiV.fB();
            if (this.ajb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ajb;
                dVar7.uW = sb8.append(dVar7.uW).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ajb;
                dVar8.uW = sb9.append(dVar8.uW).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ajb;
                dVar9.uW = sb10.append(dVar9.uW).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aiV.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aiV.fA().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uY);
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
            this.uW = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ajf = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nJ != null) {
            this.nJ.cancel();
        }
        if (this.aiZ != null) {
            this.aiZ.cancel();
            this.aiZ = null;
        }
    }

    public boolean vW() {
        if (this.aiZ == null) {
            return false;
        }
        return this.aiZ.aiI;
    }
}
