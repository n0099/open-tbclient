package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0015a {
    private static int auY = 5;
    private static int avc = 0;
    private static int avd = 0;
    private static int ave = 0;
    private static int avi = 0;
    private com.baidu.adp.lib.network.http.e auV;
    private f auZ;
    private volatile com.baidu.adp.lib.network.http.c vo = null;
    private HashMap<String, String> auW = null;
    private com.baidu.adp.lib.network.http.g auX = new com.baidu.adp.lib.network.http.g();
    public boolean ava = false;
    public boolean isGif = false;
    public String BZ = "";
    public com.baidu.adp.lib.network.http.d avb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean avf = false;
    public boolean avg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean avh = false;

    public boolean AX() {
        return this.avf;
    }

    public com.baidu.adp.lib.network.http.g jd() {
        return this.auX;
    }

    public void AY() {
        this.avb = null;
        this.BZ = "";
        this.avf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ava = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] fp(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                AY();
                if (this.auV != null) {
                    cancel();
                    this.vo = null;
                }
                this.auV = new com.baidu.adp.lib.network.http.e();
                this.auV.jc().setUrl(str);
                if (this.auW != null) {
                    for (Map.Entry<String, String> entry : this.auW.entrySet()) {
                        this.auV.jc().u(entry.getKey(), entry.getValue());
                    }
                }
                this.vo = new com.baidu.adp.lib.network.http.c(this.auV);
                this.vo.e(auY, 0, 0);
                this.auX = this.auV.jd();
                byte[] bArr = this.auV.jd().Cs;
                this.responseCode = this.auV.jd().responseCode;
                this.errorCode = this.auV.jd().Cq;
                this.avf = this.auV.jd().jj();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.auV.jd().contentEncoding != null && this.auV.jd().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ava = true;
                    bArr = F(bArr);
                }
                if (!this.avf) {
                    c(str, null);
                }
                this.avb = this.auV.jf();
                if (this.avb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.avb;
                    dVar.BZ = sb.append(dVar.BZ).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.avb;
                    dVar2.BZ = sb2.append(dVar2.BZ).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.avb = this.auV.jf();
                if (this.avb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.avb;
                    dVar3.BZ = sb3.append(dVar3.BZ).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.avb;
                    dVar4.BZ = sb4.append(dVar4.BZ).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.avb = this.auV.jf();
            if (this.avb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.avb;
                dVar5.BZ = sb5.append(dVar5.BZ).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.avb;
                dVar6.BZ = sb6.append(dVar6.BZ).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] F(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] fq(String str) {
        return fp(str);
    }

    private boolean AZ() {
        if (this.auX.Cp) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = avi + 1;
            avi = i;
            if (i >= 5) {
                avi = 0;
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
                byte[] fp = fp(str);
                int i3 = avc + 1;
                avc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (avc == 1) {
                        ave = this.errorCode;
                    }
                    avd++;
                }
                if (avc == 2) {
                    s.b("A2T", ave, this.errorCode, avd);
                }
                if (true == AZ()) {
                    this.mUseHttpClient = true;
                    this.avh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    avd = 0;
                    avc = 0;
                    ave = 0;
                }
                if (fp == null) {
                    return null;
                }
                if (this.auV != null && this.auV.jd().Cr != null) {
                    List<String> list = this.auV.jd().Cr.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.auV.jd().Cr.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.auV.jd().Cr.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.avg = false;
                            i = i2;
                            return (this.avf || (!z && i == 0) || !new String(fp, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? fp : copyOfRange(fp, 23, fp.length);
                        }
                        this.avg = true;
                    }
                }
                i = i2;
                if (this.avf) {
                }
            } catch (Exception e) {
                this.BZ += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                AY();
                if (this.auZ != null) {
                    cancel();
                }
                this.auV = new com.baidu.adp.lib.network.http.e();
                this.auZ = new f(this.auV);
                this.auV.jc().setUrl(str);
                if (this.auW != null) {
                    for (Map.Entry<String, String> entry : this.auW.entrySet()) {
                        this.auV.jc().u(entry.getKey(), entry.getValue());
                    }
                }
                this.auZ.e(null, null, -1);
                this.auX = this.auV.jd();
                byte[] bArr = this.auV.jd().Cs;
                this.responseCode = this.auV.jd().responseCode;
                this.errorCode = this.auV.jd().Cq;
                this.avf = this.auV.jd().jj();
                if (this.mUseHttpAutoSwitch && true == AZ()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    avd = 0;
                    avc = 0;
                    ave = 0;
                }
                if (this.avh) {
                    int i4 = avc + 1;
                    avc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        avd++;
                        if (avc == 1) {
                            ave = this.errorCode;
                        }
                    }
                    if (avc == 2) {
                        s.b("T2A", ave, this.errorCode, avd);
                        this.avh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.auZ.isGif();
                this.avg = this.auZ.AW();
                int size = this.auV.je().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.auV.je().get(i2) != null) {
                            sb.append(this.auV.je().get(i2).Cc);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.avb = this.auV.jf();
                if (this.avb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.avb;
                    dVar.BZ = sb2.append(dVar.BZ).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.avb;
                    dVar2.BZ = sb3.append(dVar2.BZ).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.avb;
                    dVar3.BZ = sb4.append(dVar3.BZ).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.auV.je().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.auV.je().get(i2) != null) {
                            sb.append(this.auV.je().get(i2).Cc);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.avb = this.auV.jf();
                if (this.avb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.avb;
                    dVar4.BZ = sb5.append(dVar4.BZ).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.avb;
                    dVar5.BZ = sb6.append(dVar5.BZ).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.avb;
                    dVar6.BZ = sb7.append(dVar6.BZ).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.auV.je().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.auV.je().get(i2) != null) {
                        sb.append(this.auV.je().get(i2).Cc);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.avb = this.auV.jf();
            if (this.avb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.avb;
                dVar7.BZ = sb8.append(dVar7.BZ).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.avb;
                dVar8.BZ = sb9.append(dVar8.BZ).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.avb;
                dVar9.BZ = sb10.append(dVar9.BZ).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.auV.je().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.auV.je().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.BZ);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.BW);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.BU);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.BV);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.BY);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Ca);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.BX);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Cb);
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
            this.BZ = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.avf = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.vo != null) {
            this.vo.cancel();
        }
        if (this.auZ != null) {
            this.auZ.cancel();
            this.auZ = null;
        }
    }

    public boolean Ba() {
        if (this.auZ == null) {
            return false;
        }
        return this.auZ.auI;
    }
}
