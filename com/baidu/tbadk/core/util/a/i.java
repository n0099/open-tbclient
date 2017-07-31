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
    private com.baidu.adp.lib.network.http.e aju;
    private f ajy;
    private static int ajx = 5;
    private static int ajB = 0;
    private static int ajC = 0;
    private static int ajD = 0;
    private static int ajH = 0;
    private volatile com.baidu.adp.lib.network.http.c pX = null;
    private HashMap<String, String> ajv = null;
    private com.baidu.adp.lib.network.http.g ajw = new com.baidu.adp.lib.network.http.g();
    public boolean ajz = false;
    public boolean isGif = false;
    public String xc = "";
    public com.baidu.adp.lib.network.http.d ajA = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean ajE = false;
    public boolean ajF = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ajG = false;

    public boolean wq() {
        return this.ajE;
    }

    public com.baidu.adp.lib.network.http.g fK() {
        return this.ajw;
    }

    public void wr() {
        this.ajA = null;
        this.xc = "";
        this.ajE = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ajz = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] en(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wr();
                if (this.aju != null) {
                    cancel();
                    this.pX = null;
                }
                this.aju = new com.baidu.adp.lib.network.http.e();
                this.aju.fJ().setUrl(str);
                if (this.ajv != null) {
                    for (Map.Entry<String, String> entry : this.ajv.entrySet()) {
                        this.aju.fJ().n(entry.getKey(), entry.getValue());
                    }
                }
                this.pX = new com.baidu.adp.lib.network.http.c(this.aju);
                this.pX.d(ajx, 0, 0);
                this.ajw = this.aju.fK();
                byte[] bArr = this.aju.fK().xv;
                this.responseCode = this.aju.fK().responseCode;
                this.errorCode = this.aju.fK().xt;
                this.ajE = this.aju.fK().fQ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aju.fK().contentEncoding != null && this.aju.fK().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ajz = true;
                    bArr = B(bArr);
                }
                if (!this.ajE) {
                    c(str, null);
                }
                this.ajA = this.aju.fM();
                if (this.ajA != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajA;
                    dVar.xc = sb.append(dVar.xc).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajA;
                    dVar2.xc = sb2.append(dVar2.xc).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ajA = this.aju.fM();
                if (this.ajA != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajA;
                    dVar3.xc = sb3.append(dVar3.xc).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajA;
                    dVar4.xc = sb4.append(dVar4.xc).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ajA = this.aju.fM();
            if (this.ajA != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ajA;
                dVar5.xc = sb5.append(dVar5.xc).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ajA;
                dVar6.xc = sb6.append(dVar6.xc).append("_responseCode:").append(this.responseCode).toString();
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
        if (this.ajw.xs) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ajH + 1;
            ajH = i;
            if (i >= 5) {
                ajH = 0;
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
                int i3 = ajB + 1;
                ajB = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ajB == 1) {
                        ajD = this.errorCode;
                    }
                    ajC++;
                }
                if (ajB == 2) {
                    r.a("A2T", ajD, this.errorCode, ajC);
                }
                if (true == ws()) {
                    this.mUseHttpClient = true;
                    this.ajG = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    ajC = 0;
                    ajB = 0;
                    ajD = 0;
                }
                if (en == null) {
                    return null;
                }
                if (this.aju != null && this.aju.fK().xu != null) {
                    List<String> list = this.aju.fK().xu.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aju.fK().xu.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aju.fK().xu.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ajF = false;
                            i = i2;
                            return (this.ajE || (!z && i == 0) || !new String(en, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? en : copyOfRange(en, 23, en.length);
                        }
                        this.ajF = true;
                    }
                }
                i = i2;
                if (this.ajE) {
                }
            } catch (Exception e) {
                this.xc += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                wr();
                if (this.ajy != null) {
                    cancel();
                }
                this.aju = new com.baidu.adp.lib.network.http.e();
                this.ajy = new f(this.aju);
                this.aju.fJ().setUrl(str);
                if (this.ajv != null) {
                    for (Map.Entry<String, String> entry : this.ajv.entrySet()) {
                        this.aju.fJ().n(entry.getKey(), entry.getValue());
                    }
                }
                this.ajy.d(null, null, -1);
                this.ajw = this.aju.fK();
                byte[] bArr = this.aju.fK().xv;
                this.responseCode = this.aju.fK().responseCode;
                this.errorCode = this.aju.fK().xt;
                this.ajE = this.aju.fK().fQ();
                if (this.mUseHttpAutoSwitch && true == ws()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    ajC = 0;
                    ajB = 0;
                    ajD = 0;
                }
                if (this.ajG) {
                    int i4 = ajB + 1;
                    ajB = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        ajC++;
                        if (ajB == 1) {
                            ajD = this.errorCode;
                        }
                    }
                    if (ajB == 2) {
                        r.a("T2A", ajD, this.errorCode, ajC);
                        this.ajG = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.ajy.isGif();
                this.ajF = this.ajy.wp();
                int size = this.aju.fL().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aju.fL().get(i2) != null) {
                            sb.append(this.aju.fL().get(i2).xf);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajA = this.aju.fM();
                if (this.ajA != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ajA;
                    dVar.xc = sb2.append(dVar.xc).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ajA;
                    dVar2.xc = sb3.append(dVar2.xc).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ajA;
                    dVar3.xc = sb4.append(dVar3.xc).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aju.fL().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aju.fL().get(i2) != null) {
                            sb.append(this.aju.fL().get(i2).xf);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ajA = this.aju.fM();
                if (this.ajA != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ajA;
                    dVar4.xc = sb5.append(dVar4.xc).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ajA;
                    dVar5.xc = sb6.append(dVar5.xc).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ajA;
                    dVar6.xc = sb7.append(dVar6.xc).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aju.fL().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aju.fL().get(i2) != null) {
                        sb.append(this.aju.fL().get(i2).xf);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.ajA = this.aju.fM();
            if (this.ajA != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ajA;
                dVar7.xc = sb8.append(dVar7.xc).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ajA;
                dVar8.xc = sb9.append(dVar8.xc).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ajA;
                dVar9.xc = sb10.append(dVar9.xc).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aju.fL().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aju.fL().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.xc);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.wY);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.wZ);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.xb);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.xd);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.xa);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.xe);
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
            this.xc = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.ajE = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        if (this.pX != null) {
            this.pX.cancel();
        }
        if (this.ajy != null) {
            this.ajy.cancel();
            this.ajy = null;
        }
    }

    public boolean wt() {
        if (this.ajy == null) {
            return false;
        }
        return this.ajy.ajg;
    }
}
