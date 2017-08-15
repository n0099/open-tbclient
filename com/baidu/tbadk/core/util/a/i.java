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
public class i implements a.InterfaceC0005a {
    private f ajA;
    private com.baidu.adp.lib.network.http.e ajw;
    private static int ajz = 5;
    private static int ajD = 0;
    private static int ajE = 0;
    private static int ajF = 0;
    private static int ajJ = 0;
    private volatile com.baidu.adp.lib.network.http.c pZ = null;
    private HashMap<String, String> ajx = null;
    private com.baidu.adp.lib.network.http.g ajy = new com.baidu.adp.lib.network.http.g();
    public boolean ajB = false;
    public boolean isGif = false;
    public String xe = "";
    public com.baidu.adp.lib.network.http.d ajC = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ajG = false;
    public boolean ajH = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ajI = false;

    public boolean wq() {
        return this.ajG;
    }

    public com.baidu.adp.lib.network.http.g fK() {
        return this.ajy;
    }

    public void wr() {
        this.ajC = null;
        this.xe = "";
        this.ajG = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ajB = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] en(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wr();
                if (this.ajw != null) {
                    cancel();
                    this.pZ = null;
                }
                this.ajw = new com.baidu.adp.lib.network.http.e();
                this.ajw.fJ().setUrl(str);
                if (this.ajx != null) {
                    for (Map.Entry<String, String> entry : this.ajx.entrySet()) {
                        this.ajw.fJ().n(entry.getKey(), entry.getValue());
                    }
                }
                this.pZ = new com.baidu.adp.lib.network.http.c(this.ajw);
                this.pZ.d(ajz, 0, 0);
                this.ajy = this.ajw.fK();
                byte[] bArr = this.ajw.fK().xx;
                this.responseCode = this.ajw.fK().responseCode;
                this.errorCode = this.ajw.fK().xv;
                this.ajG = this.ajw.fK().fQ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ajw.fK().contentEncoding != null && this.ajw.fK().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ajB = true;
                    bArr = B(bArr);
                }
                if (!this.ajG) {
                    c(str, null);
                }
                this.ajC = this.ajw.fM();
                if (this.ajC != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajC;
                    dVar.xe = sb.append(dVar.xe).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajC;
                    dVar2.xe = sb2.append(dVar2.xe).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ajC = this.ajw.fM();
                if (this.ajC != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajC;
                    dVar3.xe = sb3.append(dVar3.xe).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajC;
                    dVar4.xe = sb4.append(dVar4.xe).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ajC = this.ajw.fM();
            if (this.ajC != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ajC;
                dVar5.xe = sb5.append(dVar5.xe).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ajC;
                dVar6.xe = sb6.append(dVar6.xe).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] B(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] eo(String str) {
        return en(str);
    }

    private boolean ws() {
        if (this.ajy.xu) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ajJ + 1;
            ajJ = i;
            if (i >= 5) {
                ajJ = 0;
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
                byte[] en = en(str);
                int i3 = ajD + 1;
                ajD = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ajD == 1) {
                        ajF = this.errorCode;
                    }
                    ajE++;
                }
                if (ajD == 2) {
                    r.a("A2T", ajF, this.errorCode, ajE);
                }
                if (true == ws()) {
                    this.mUseHttpClient = true;
                    this.ajI = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    ajE = 0;
                    ajD = 0;
                    ajF = 0;
                }
                if (en == null) {
                    return null;
                }
                if (this.ajw != null && this.ajw.fK().xw != null) {
                    List<String> list = this.ajw.fK().xw.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ajw.fK().xw.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.ajw.fK().xw.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ajH = false;
                            i = i2;
                            return (this.ajG || (!z && i == 0) || !new String(en, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? en : copyOfRange(en, 23, en.length);
                        }
                        this.ajH = true;
                    }
                }
                i = i2;
                if (this.ajG) {
                }
            } catch (Exception e) {
                this.xe += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                wr();
                if (this.ajA != null) {
                    cancel();
                }
                this.ajw = new com.baidu.adp.lib.network.http.e();
                this.ajA = new f(this.ajw);
                this.ajw.fJ().setUrl(str);
                if (this.ajx != null) {
                    for (Map.Entry<String, String> entry : this.ajx.entrySet()) {
                        this.ajw.fJ().n(entry.getKey(), entry.getValue());
                    }
                }
                this.ajA.d(null, null, -1);
                this.ajy = this.ajw.fK();
                byte[] bArr = this.ajw.fK().xx;
                this.responseCode = this.ajw.fK().responseCode;
                this.errorCode = this.ajw.fK().xv;
                this.ajG = this.ajw.fK().fQ();
                if (this.mUseHttpAutoSwitch && true == ws()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    ajE = 0;
                    ajD = 0;
                    ajF = 0;
                }
                if (this.ajI) {
                    int i4 = ajD + 1;
                    ajD = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        ajE++;
                        if (ajD == 1) {
                            ajF = this.errorCode;
                        }
                    }
                    if (ajD == 2) {
                        r.a("T2A", ajF, this.errorCode, ajE);
                        this.ajI = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.ajA.isGif();
                this.ajH = this.ajA.wp();
                int size = this.ajw.fL().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.ajw.fL().get(i2) != null) {
                            sb.append(this.ajw.fL().get(i2).xh);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajC = this.ajw.fM();
                if (this.ajC != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajC;
                    dVar.xe = sb2.append(dVar.xe).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajC;
                    dVar2.xe = sb3.append(dVar2.xe).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajC;
                    dVar3.xe = sb4.append(dVar3.xe).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.ajw.fL().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.ajw.fL().get(i2) != null) {
                            sb.append(this.ajw.fL().get(i2).xh);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajC = this.ajw.fM();
                if (this.ajC != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajC;
                    dVar4.xe = sb5.append(dVar4.xe).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ajC;
                    dVar5.xe = sb6.append(dVar5.xe).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ajC;
                    dVar6.xe = sb7.append(dVar6.xe).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.ajw.fL().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.ajw.fL().get(i2) != null) {
                        sb.append(this.ajw.fL().get(i2).xh);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.ajC = this.ajw.fM();
            if (this.ajC != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ajC;
                dVar7.xe = sb8.append(dVar7.xe).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ajC;
                dVar8.xe = sb9.append(dVar8.xe).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ajC;
                dVar9.xe = sb10.append(dVar9.xe).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.ajw.fL().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.ajw.fL().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.xe);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.xa);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.xb);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.xd);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.xf);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.xc);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.xg);
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
            this.xe = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ajG = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.pZ != null) {
            this.pZ.cancel();
        }
        if (this.ajA != null) {
            this.ajA.cancel();
            this.ajA = null;
        }
    }

    public boolean wt() {
        if (this.ajA == null) {
            return false;
        }
        return this.ajA.aji;
    }
}
