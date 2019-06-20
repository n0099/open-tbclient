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
    private static int bUm = 5;
    private static int bUq = 0;
    private static int bUr = 0;
    private static int bUs = 0;
    private static int bUw = 0;
    private com.baidu.adp.lib.network.http.e bUj;
    private f bUn;
    private volatile com.baidu.adp.lib.network.http.c tG = null;
    private HashMap<String, String> bUk = null;
    private com.baidu.adp.lib.network.http.g bUl = new com.baidu.adp.lib.network.http.g();
    public boolean bUo = false;
    public boolean isGif = false;
    public String At = "";
    public com.baidu.adp.lib.network.http.d bUp = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bUt = false;
    public boolean bUu = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bUv = false;

    public boolean aiJ() {
        return this.bUt;
    }

    public com.baidu.adp.lib.network.http.g il() {
        return this.bUl;
    }

    public void pa() {
        this.bUp = null;
        this.At = "";
        this.bUt = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bUo = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] od(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pa();
                if (this.bUj != null) {
                    cancel();
                    this.tG = null;
                }
                this.bUj = new com.baidu.adp.lib.network.http.e();
                this.bUj.ik().setUrl(str);
                if (this.bUk != null) {
                    for (Map.Entry<String, String> entry : this.bUk.entrySet()) {
                        this.bUj.ik().o(entry.getKey(), entry.getValue());
                    }
                }
                this.tG = new com.baidu.adp.lib.network.http.c(this.bUj);
                this.tG.d(bUm, 0, 0);
                this.bUl = this.bUj.il();
                byte[] bArr = this.bUj.il().AN;
                this.responseCode = this.bUj.il().responseCode;
                this.errorCode = this.bUj.il().AK;
                this.bUt = this.bUj.il().is();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bUj.il().contentEncoding != null && this.bUj.il().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bUo = true;
                    bArr = G(bArr);
                }
                if (!this.bUt) {
                    e(str, null);
                }
                this.bUp = this.bUj.in();
                if (this.bUp != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bUp;
                    dVar.At = sb.append(dVar.At).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bUp;
                    dVar2.At = sb2.append(dVar2.At).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bUp = this.bUj.in();
                if (this.bUp != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bUp;
                    dVar3.At = sb3.append(dVar3.At).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bUp;
                    dVar4.At = sb4.append(dVar4.At).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bUp = this.bUj.in();
            if (this.bUp != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bUp;
                dVar5.At = sb5.append(dVar5.At).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bUp;
                dVar6.At = sb6.append(dVar6.At).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] oe(String str) {
        return od(str);
    }

    private boolean aiK() {
        if (this.bUl.AJ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bUw + 1;
            bUw = i;
            if (i >= 5) {
                bUw = 0;
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
                byte[] od = od(str);
                int i3 = bUq + 1;
                bUq = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bUq == 1) {
                        bUs = this.errorCode;
                    }
                    bUr++;
                }
                if (bUq == 2) {
                    s.a("A2T", bUs, this.errorCode, bUr);
                }
                if (true == aiK()) {
                    this.mUseHttpClient = true;
                    this.bUv = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bUr = 0;
                    bUq = 0;
                    bUs = 0;
                }
                if (od == null) {
                    return null;
                }
                if (this.bUj != null && this.bUj.il().AM != null) {
                    List<String> list = this.bUj.il().AM.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bUj.il().AM.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bUj.il().AM.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bUu = false;
                            i = i2;
                            return (this.bUt || (!z && i == 0) || !new String(od, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? od : copyOfRange(od, 23, od.length);
                        }
                        this.bUu = true;
                    }
                }
                i = i2;
                if (this.bUt) {
                }
            } catch (Exception e) {
                this.At += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pa();
                if (this.bUn != null) {
                    cancel();
                }
                this.bUj = new com.baidu.adp.lib.network.http.e();
                this.bUn = new f(this.bUj);
                this.bUj.ik().setUrl(str);
                if (this.bUk != null) {
                    for (Map.Entry<String, String> entry : this.bUk.entrySet()) {
                        this.bUj.ik().o(entry.getKey(), entry.getValue());
                    }
                }
                this.bUn.l(null, null, -1);
                this.bUl = this.bUj.il();
                byte[] bArr = this.bUj.il().AN;
                this.responseCode = this.bUj.il().responseCode;
                this.errorCode = this.bUj.il().AK;
                this.bUt = this.bUj.il().is();
                if (this.mUseHttpAutoSwitch && true == aiK()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bUr = 0;
                    bUq = 0;
                    bUs = 0;
                }
                if (this.bUv) {
                    int i4 = bUq + 1;
                    bUq = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bUr++;
                        if (bUq == 1) {
                            bUs = this.errorCode;
                        }
                    }
                    if (bUq == 2) {
                        s.a("T2A", bUs, this.errorCode, bUr);
                        this.bUv = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bUn.isGif();
                this.bUu = this.bUn.aiI();
                int size = this.bUj.im().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bUj.im().get(i2) != null) {
                            sb.append(this.bUj.im().get(i2).Aw);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bUp = this.bUj.in();
                if (this.bUp != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bUp;
                    dVar.At = sb2.append(dVar.At).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bUp;
                    dVar2.At = sb3.append(dVar2.At).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bUp;
                    dVar3.At = sb4.append(dVar3.At).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bUj.im().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bUj.im().get(i2) != null) {
                            sb.append(this.bUj.im().get(i2).Aw);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bUp = this.bUj.in();
                if (this.bUp != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bUp;
                    dVar4.At = sb5.append(dVar4.At).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bUp;
                    dVar5.At = sb6.append(dVar5.At).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bUp;
                    dVar6.At = sb7.append(dVar6.At).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bUj.im().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bUj.im().get(i2) != null) {
                        sb.append(this.bUj.im().get(i2).Aw);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bUp = this.bUj.in();
            if (this.bUp != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bUp;
                dVar7.At = sb8.append(dVar7.At).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bUp;
                dVar8.At = sb9.append(dVar8.At).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bUp;
                dVar9.At = sb10.append(dVar9.At).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.bUj.im().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bUj.im().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.At);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.Aq);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.Ao);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.Ap);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.As);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Au);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Ar);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Av);
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
            this.At = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.bUt = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.tG != null) {
            this.tG.cancel();
        }
        if (this.bUn != null) {
            this.bUn.cancel();
            this.bUn = null;
        }
    }

    public boolean aiL() {
        if (this.bUn == null) {
            return false;
        }
        return this.bUn.bTW;
    }
}
