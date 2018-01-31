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
    private static int aXj = 5;
    private static int aXn = 0;
    private static int aXo = 0;
    private static int aXp = 0;
    private static int aXt = 0;
    private com.baidu.adp.lib.network.http.e aXg;
    private f aXk;
    private volatile com.baidu.adp.lib.network.http.c acu = null;
    private HashMap<String, String> aXh = null;
    private com.baidu.adp.lib.network.http.g aXi = new com.baidu.adp.lib.network.http.g();
    public boolean aXl = false;
    public boolean isGif = false;
    public String ajm = "";
    public com.baidu.adp.lib.network.http.d aXm = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aXq = false;
    public boolean aXr = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean aXs = false;

    public boolean Dk() {
        return this.aXq;
    }

    public com.baidu.adp.lib.network.http.g nc() {
        return this.aXi;
    }

    public void Dl() {
        this.aXm = null;
        this.ajm = "";
        this.aXq = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aXl = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] et(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Dl();
                if (this.aXg != null) {
                    cancel();
                    this.acu = null;
                }
                this.aXg = new com.baidu.adp.lib.network.http.e();
                this.aXg.nb().setUrl(str);
                if (this.aXh != null) {
                    for (Map.Entry<String, String> entry : this.aXh.entrySet()) {
                        this.aXg.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.acu = new com.baidu.adp.lib.network.http.c(this.aXg);
                this.acu.m(aXj, 0, 0);
                this.aXi = this.aXg.nc();
                byte[] bArr = this.aXg.nc().ajF;
                this.responseCode = this.aXg.nc().responseCode;
                this.errorCode = this.aXg.nc().ajD;
                this.aXq = this.aXg.nc().ni();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aXg.nc().contentEncoding != null && this.aXg.nc().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aXl = true;
                    bArr = w(bArr);
                }
                if (!this.aXq) {
                    c(str, null);
                }
                this.aXm = this.aXg.ne();
                if (this.aXm != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aXm;
                    dVar.ajm = sb.append(dVar.ajm).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aXm;
                    dVar2.ajm = sb2.append(dVar2.ajm).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aXm = this.aXg.ne();
                if (this.aXm != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aXm;
                    dVar3.ajm = sb3.append(dVar3.ajm).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aXm;
                    dVar4.ajm = sb4.append(dVar4.ajm).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aXm = this.aXg.ne();
            if (this.aXm != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.aXm;
                dVar5.ajm = sb5.append(dVar5.ajm).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.aXm;
                dVar6.ajm = sb6.append(dVar6.ajm).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] eu(String str) {
        return et(str);
    }

    private boolean Dm() {
        if (this.aXi.ajC) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = aXt + 1;
            aXt = i;
            if (i >= 5) {
                aXt = 0;
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
                byte[] et = et(str);
                int i3 = aXn + 1;
                aXn = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aXn == 1) {
                        aXp = this.errorCode;
                    }
                    aXo++;
                }
                if (aXn == 2) {
                    s.a("A2T", aXp, this.errorCode, aXo);
                }
                if (true == Dm()) {
                    this.mUseHttpClient = true;
                    this.aXs = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    aXo = 0;
                    aXn = 0;
                    aXp = 0;
                }
                if (et == null) {
                    return null;
                }
                if (this.aXg != null && this.aXg.nc().ajE != null) {
                    List<String> list = this.aXg.nc().ajE.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aXg.nc().ajE.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aXg.nc().ajE.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aXr = false;
                            i = i2;
                            return (this.aXq || (!z && i == 0) || !new String(et, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? et : copyOfRange(et, 23, et.length);
                        }
                        this.aXr = true;
                    }
                }
                i = i2;
                if (this.aXq) {
                }
            } catch (Exception e) {
                this.ajm += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Dl();
                if (this.aXk != null) {
                    cancel();
                }
                this.aXg = new com.baidu.adp.lib.network.http.e();
                this.aXk = new f(this.aXg);
                this.aXg.nb().setUrl(str);
                if (this.aXh != null) {
                    for (Map.Entry<String, String> entry : this.aXh.entrySet()) {
                        this.aXg.nb().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aXk.d(null, null, -1);
                this.aXi = this.aXg.nc();
                byte[] bArr = this.aXg.nc().ajF;
                this.responseCode = this.aXg.nc().responseCode;
                this.errorCode = this.aXg.nc().ajD;
                this.aXq = this.aXg.nc().ni();
                if (this.mUseHttpAutoSwitch && true == Dm()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    aXo = 0;
                    aXn = 0;
                    aXp = 0;
                }
                if (this.aXs) {
                    int i4 = aXn + 1;
                    aXn = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        aXo++;
                        if (aXn == 1) {
                            aXp = this.errorCode;
                        }
                    }
                    if (aXn == 2) {
                        s.a("T2A", aXp, this.errorCode, aXo);
                        this.aXs = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aXk.isGif();
                this.aXr = this.aXk.Dj();
                int size = this.aXg.nd().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aXg.nd().get(i2) != null) {
                            sb.append(this.aXg.nd().get(i2).ajp);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aXm = this.aXg.ne();
                if (this.aXm != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.aXm;
                    dVar.ajm = sb2.append(dVar.ajm).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aXm;
                    dVar2.ajm = sb3.append(dVar2.ajm).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.aXm;
                    dVar3.ajm = sb4.append(dVar3.ajm).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aXg.nd().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aXg.nd().get(i2) != null) {
                            sb.append(this.aXg.nd().get(i2).ajp);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.aXm = this.aXg.ne();
                if (this.aXm != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aXm;
                    dVar4.ajm = sb5.append(dVar4.ajm).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.aXm;
                    dVar5.ajm = sb6.append(dVar5.ajm).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.aXm;
                    dVar6.ajm = sb7.append(dVar6.ajm).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aXg.nd().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aXg.nd().get(i2) != null) {
                        sb.append(this.aXg.nd().get(i2).ajp);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.aXm = this.aXg.ne();
            if (this.aXm != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.aXm;
                dVar7.ajm = sb8.append(dVar7.ajm).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.aXm;
                dVar8.ajm = sb9.append(dVar8.ajm).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.aXm;
                dVar9.ajm = sb10.append(dVar9.ajm).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aXg.nd().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aXg.nd().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.ajm);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.ajj);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.ajh);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.aji);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.ajl);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.ajn);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.ajk);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ajo);
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
            this.ajm = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aXq = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.acu != null) {
            this.acu.cancel();
        }
        if (this.aXk != null) {
            this.aXk.cancel();
            this.aXk = null;
        }
    }

    public boolean Dn() {
        if (this.aXk == null) {
            return false;
        }
        return this.aXk.aWT;
    }
}
