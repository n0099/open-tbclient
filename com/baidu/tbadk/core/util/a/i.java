package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0016a {
    private static int bUl = 5;
    private static int bUp = 0;
    private static int bUq = 0;
    private static int bUr = 0;
    private static int bUv = 0;
    private com.baidu.adp.lib.network.http.e bUi;
    private f bUm;
    private volatile com.baidu.adp.lib.network.http.c tH = null;
    private HashMap<String, String> bUj = null;
    private com.baidu.adp.lib.network.http.g bUk = new com.baidu.adp.lib.network.http.g();
    public boolean bUn = false;
    public boolean isGif = false;
    public String Au = "";
    public com.baidu.adp.lib.network.http.d bUo = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bUs = false;
    public boolean bUt = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bUu = false;

    public boolean aiJ() {
        return this.bUs;
    }

    public com.baidu.adp.lib.network.http.g il() {
        return this.bUk;
    }

    public void pa() {
        this.bUo = null;
        this.Au = "";
        this.bUs = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bUn = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] oe(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pa();
                if (this.bUi != null) {
                    cancel();
                    this.tH = null;
                }
                this.bUi = new com.baidu.adp.lib.network.http.e();
                this.bUi.ik().setUrl(str);
                if (this.bUj != null) {
                    for (Map.Entry<String, String> entry : this.bUj.entrySet()) {
                        this.bUi.ik().o(entry.getKey(), entry.getValue());
                    }
                }
                this.tH = new com.baidu.adp.lib.network.http.c(this.bUi);
                this.tH.d(bUl, 0, 0);
                this.bUk = this.bUi.il();
                byte[] bArr = this.bUi.il().AO;
                this.responseCode = this.bUi.il().responseCode;
                this.errorCode = this.bUi.il().AM;
                this.bUs = this.bUi.il().is();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bUi.il().contentEncoding != null && this.bUi.il().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bUn = true;
                    bArr = G(bArr);
                }
                if (!this.bUs) {
                    e(str, null);
                }
                this.bUo = this.bUi.in();
                if (this.bUo != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bUo;
                    dVar.Au = sb.append(dVar.Au).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bUo;
                    dVar2.Au = sb2.append(dVar2.Au).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bUo = this.bUi.in();
                if (this.bUo != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bUo;
                    dVar3.Au = sb3.append(dVar3.Au).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bUo;
                    dVar4.Au = sb4.append(dVar4.Au).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bUo = this.bUi.in();
            if (this.bUo != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bUo;
                dVar5.Au = sb5.append(dVar5.Au).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bUo;
                dVar6.Au = sb6.append(dVar6.Au).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] G(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] og(String str) {
        return oe(str);
    }

    private boolean aiK() {
        if (this.bUk.AK) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bUv + 1;
            bUv = i;
            if (i >= 5) {
                bUv = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] N(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] oe = oe(str);
                int i3 = bUp + 1;
                bUp = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bUp == 1) {
                        bUr = this.errorCode;
                    }
                    bUq++;
                }
                if (bUp == 2) {
                    s.a("A2T", bUr, this.errorCode, bUq);
                }
                if (true == aiK()) {
                    this.mUseHttpClient = true;
                    this.bUu = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bUq = 0;
                    bUp = 0;
                    bUr = 0;
                }
                if (oe == null) {
                    return null;
                }
                if (this.bUi != null && this.bUi.il().AN != null) {
                    List<String> list = this.bUi.il().AN.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bUi.il().AN.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bUi.il().AN.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bUt = false;
                            i = i2;
                            return (this.bUs || (!z && i == 0) || !new String(oe, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? oe : copyOfRange(oe, 23, oe.length);
                        }
                        this.bUt = true;
                    }
                }
                i = i2;
                if (this.bUs) {
                }
            } catch (Exception e) {
                this.Au += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pa();
                if (this.bUm != null) {
                    cancel();
                }
                this.bUi = new com.baidu.adp.lib.network.http.e();
                this.bUm = new f(this.bUi);
                this.bUi.ik().setUrl(str);
                if (this.bUj != null) {
                    for (Map.Entry<String, String> entry : this.bUj.entrySet()) {
                        this.bUi.ik().o(entry.getKey(), entry.getValue());
                    }
                }
                this.bUm.l(null, null, -1);
                this.bUk = this.bUi.il();
                byte[] bArr = this.bUi.il().AO;
                this.responseCode = this.bUi.il().responseCode;
                this.errorCode = this.bUi.il().AM;
                this.bUs = this.bUi.il().is();
                if (this.mUseHttpAutoSwitch && true == aiK()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bUq = 0;
                    bUp = 0;
                    bUr = 0;
                }
                if (this.bUu) {
                    int i4 = bUp + 1;
                    bUp = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bUq++;
                        if (bUp == 1) {
                            bUr = this.errorCode;
                        }
                    }
                    if (bUp == 2) {
                        s.a("T2A", bUr, this.errorCode, bUq);
                        this.bUu = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bUm.isGif();
                this.bUt = this.bUm.aiI();
                int size = this.bUi.im().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bUi.im().get(i2) != null) {
                            sb.append(this.bUi.im().get(i2).Ax);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bUo = this.bUi.in();
                if (this.bUo != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bUo;
                    dVar.Au = sb2.append(dVar.Au).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bUo;
                    dVar2.Au = sb3.append(dVar2.Au).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bUo;
                    dVar3.Au = sb4.append(dVar3.Au).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bUi.im().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bUi.im().get(i2) != null) {
                            sb.append(this.bUi.im().get(i2).Ax);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bUo = this.bUi.in();
                if (this.bUo != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bUo;
                    dVar4.Au = sb5.append(dVar4.Au).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bUo;
                    dVar5.Au = sb6.append(dVar5.Au).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bUo;
                    dVar6.Au = sb7.append(dVar6.Au).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bUi.im().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bUi.im().get(i2) != null) {
                        sb.append(this.bUi.im().get(i2).Ax);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bUo = this.bUi.in();
            if (this.bUo != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bUo;
                dVar7.Au = sb8.append(dVar7.Au).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bUo;
                dVar8.Au = sb9.append(dVar8.Au).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bUo;
                dVar9.Au = sb10.append(dVar9.Au).append("_size:").append(Integer.toString(this.dataSize)).toString();
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

    private void e(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.bUi.im().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bUi.im().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.Au);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.Ar);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.Ap);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.Aq);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.At);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Av);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.As);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Aw);
            }
            if (exc != null) {
                stringBuffer.append("webclient exception");
                stringBuffer.append(DealIntentService.KEY_CLASS);
                stringBuffer.append(exc.getClass());
                stringBuffer.append("message");
                stringBuffer.append(exc.getMessage());
            } else {
                stringBuffer.append("networkcore exception");
            }
            this.Au = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.bUs = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.tH != null) {
            this.tH.cancel();
        }
        if (this.bUm != null) {
            this.bUm.cancel();
            this.bUm = null;
        }
    }

    public boolean aiL() {
        if (this.bUm == null) {
            return false;
        }
        return this.bUm.bTV;
    }
}
