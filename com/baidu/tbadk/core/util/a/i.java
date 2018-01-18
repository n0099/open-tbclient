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
public class i implements a.InterfaceC0018a {
    private static int aXg = 5;
    private static int aXk = 0;
    private static int aXl = 0;
    private static int aXm = 0;
    private static int aXq = 0;
    private com.baidu.adp.lib.network.http.e aXd;
    private f aXh;
    private volatile com.baidu.adp.lib.network.http.c acu = null;
    private HashMap<String, String> aXe = null;
    private com.baidu.adp.lib.network.http.g aXf = new com.baidu.adp.lib.network.http.g();
    public boolean aXi = false;
    public boolean isGif = false;
    public String ajj = "";
    public com.baidu.adp.lib.network.http.d aXj = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aXn = false;
    public boolean aXo = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aXp = false;

    public boolean Dj() {
        return this.aXn;
    }

    public com.baidu.adp.lib.network.http.g nb() {
        return this.aXf;
    }

    public void Dk() {
        this.aXj = null;
        this.ajj = "";
        this.aXn = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aXi = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ep(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Dk();
                if (this.aXd != null) {
                    cancel();
                    this.acu = null;
                }
                this.aXd = new com.baidu.adp.lib.network.http.e();
                this.aXd.na().setUrl(str);
                if (this.aXe != null) {
                    for (Map.Entry<String, String> entry : this.aXe.entrySet()) {
                        this.aXd.na().n(entry.getKey(), entry.getValue());
                    }
                }
                this.acu = new com.baidu.adp.lib.network.http.c(this.aXd);
                this.acu.m(aXg, 0, 0);
                this.aXf = this.aXd.nb();
                byte[] bArr = this.aXd.nb().ajC;
                this.responseCode = this.aXd.nb().responseCode;
                this.errorCode = this.aXd.nb().ajA;
                this.aXn = this.aXd.nb().nh();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aXd.nb().contentEncoding != null && this.aXd.nb().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aXi = true;
                    bArr = w(bArr);
                }
                if (!this.aXn) {
                    c(str, null);
                }
                this.aXj = this.aXd.nd();
                if (this.aXj != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aXj;
                    dVar.ajj = sb.append(dVar.ajj).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aXj;
                    dVar2.ajj = sb2.append(dVar2.ajj).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aXj = this.aXd.nd();
                if (this.aXj != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aXj;
                    dVar3.ajj = sb3.append(dVar3.ajj).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aXj;
                    dVar4.ajj = sb4.append(dVar4.ajj).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aXj = this.aXd.nd();
            if (this.aXj != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aXj;
                dVar5.ajj = sb5.append(dVar5.ajj).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aXj;
                dVar6.ajj = sb6.append(dVar6.ajj).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] eq(String str) {
        return ep(str);
    }

    private boolean Dl() {
        if (this.aXf.ajz) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aXq + 1;
            aXq = i;
            if (i >= 5) {
                aXq = 0;
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
                byte[] ep = ep(str);
                int i3 = aXk + 1;
                aXk = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aXk == 1) {
                        aXm = this.errorCode;
                    }
                    aXl++;
                }
                if (aXk == 2) {
                    s.a("A2T", aXm, this.errorCode, aXl);
                }
                if (true == Dl()) {
                    this.mUseHttpClient = true;
                    this.aXp = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aXl = 0;
                    aXk = 0;
                    aXm = 0;
                }
                if (ep == null) {
                    return null;
                }
                if (this.aXd != null && this.aXd.nb().ajB != null) {
                    List<String> list = this.aXd.nb().ajB.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aXd.nb().ajB.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aXd.nb().ajB.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aXo = false;
                            i = i2;
                            return (this.aXn || (!z && i == 0) || !new String(ep, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ep : copyOfRange(ep, 23, ep.length);
                        }
                        this.aXo = true;
                    }
                }
                i = i2;
                if (this.aXn) {
                }
            } catch (Exception e) {
                this.ajj += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Dk();
                if (this.aXh != null) {
                    cancel();
                }
                this.aXd = new com.baidu.adp.lib.network.http.e();
                this.aXh = new f(this.aXd);
                this.aXd.na().setUrl(str);
                if (this.aXe != null) {
                    for (Map.Entry<String, String> entry : this.aXe.entrySet()) {
                        this.aXd.na().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aXh.d(null, null, -1);
                this.aXf = this.aXd.nb();
                byte[] bArr = this.aXd.nb().ajC;
                this.responseCode = this.aXd.nb().responseCode;
                this.errorCode = this.aXd.nb().ajA;
                this.aXn = this.aXd.nb().nh();
                if (this.mUseHttpAutoSwitch && true == Dl()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aXl = 0;
                    aXk = 0;
                    aXm = 0;
                }
                if (this.aXp) {
                    int i4 = aXk + 1;
                    aXk = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aXl++;
                        if (aXk == 1) {
                            aXm = this.errorCode;
                        }
                    }
                    if (aXk == 2) {
                        s.a("T2A", aXm, this.errorCode, aXl);
                        this.aXp = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aXh.isGif();
                this.aXo = this.aXh.Di();
                int size = this.aXd.nc().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aXd.nc().get(i2) != null) {
                            sb.append(this.aXd.nc().get(i2).ajm);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aXj = this.aXd.nd();
                if (this.aXj != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aXj;
                    dVar.ajj = sb2.append(dVar.ajj).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aXj;
                    dVar2.ajj = sb3.append(dVar2.ajj).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aXj;
                    dVar3.ajj = sb4.append(dVar3.ajj).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aXd.nc().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aXd.nc().get(i2) != null) {
                            sb.append(this.aXd.nc().get(i2).ajm);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aXj = this.aXd.nd();
                if (this.aXj != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aXj;
                    dVar4.ajj = sb5.append(dVar4.ajj).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aXj;
                    dVar5.ajj = sb6.append(dVar5.ajj).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aXj;
                    dVar6.ajj = sb7.append(dVar6.ajj).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aXd.nc().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aXd.nc().get(i2) != null) {
                        sb.append(this.aXd.nc().get(i2).ajm);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aXj = this.aXd.nd();
            if (this.aXj != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aXj;
                dVar7.ajj = sb8.append(dVar7.ajj).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aXj;
                dVar8.ajj = sb9.append(dVar8.ajj).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aXj;
                dVar9.ajj = sb10.append(dVar9.ajj).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aXd.nc().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aXd.nc().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.ajj);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.ajg);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.aje);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ajf);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.aji);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.ajk);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.ajh);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ajl);
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
            this.ajj = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aXn = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.acu != null) {
            this.acu.cancel();
        }
        if (this.aXh != null) {
            this.aXh.cancel();
            this.aXh = null;
        }
    }

    public boolean Dm() {
        if (this.aXh == null) {
            return false;
        }
        return this.aXh.aWQ;
    }
}
