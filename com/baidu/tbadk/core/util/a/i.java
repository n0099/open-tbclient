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
    private static int aii = 5;
    private static int aim = 0;
    private static int ain = 0;
    private static int aio = 0;
    private static int ais = 0;
    private com.baidu.adp.lib.network.http.e aif;
    private f aij;
    private volatile com.baidu.adp.lib.network.http.c nJ = null;
    private HashMap<String, String> aig = null;
    private com.baidu.adp.lib.network.http.g aih = new com.baidu.adp.lib.network.http.g();
    public boolean aik = false;
    public boolean isGif = false;
    public String uY = "";
    public com.baidu.adp.lib.network.http.d ail = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aip = false;
    public boolean aiq = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean air = false;

    public boolean vL() {
        return this.aip;
    }

    public com.baidu.adp.lib.network.http.g fz() {
        return this.aih;
    }

    public void vM() {
        this.ail = null;
        this.uY = "";
        this.aip = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.aik = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ea(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                vM();
                if (this.aif != null) {
                    cancel();
                    this.nJ = null;
                }
                this.aif = new com.baidu.adp.lib.network.http.e();
                this.aif.fy().setUrl(str);
                if (this.aig != null) {
                    for (Map.Entry<String, String> entry : this.aig.entrySet()) {
                        this.aif.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.nJ = new com.baidu.adp.lib.network.http.c(this.aif);
                this.nJ.d(aii, 0, 0);
                this.aih = this.aif.fz();
                byte[] bArr = this.aif.fz().vr;
                this.responseCode = this.aif.fz().responseCode;
                this.errorCode = this.aif.fz().vp;
                this.aip = this.aif.fz().fF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aif.fz().contentEncoding != null && this.aif.fz().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aik = true;
                    bArr = w(bArr);
                }
                if (!this.aip) {
                    c(str, null);
                }
                this.ail = this.aif.fB();
                if (this.ail != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ail;
                    dVar.uY = sb.append(dVar.uY).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ail;
                    dVar2.uY = sb2.append(dVar2.uY).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.ail = this.aif.fB();
                if (this.ail != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ail;
                    dVar3.uY = sb3.append(dVar3.uY).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ail;
                    dVar4.uY = sb4.append(dVar4.uY).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ail = this.aif.fB();
            if (this.ail != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ail;
                dVar5.uY = sb5.append(dVar5.uY).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ail;
                dVar6.uY = sb6.append(dVar6.uY).append("_responseCode:").append(this.responseCode).toString();
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

    public byte[] eb(String str) {
        return ea(str);
    }

    private boolean vN() {
        if (this.aih.vo) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ais + 1;
            ais = i;
            if (i >= 5) {
                ais = 0;
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
                byte[] ea = ea(str);
                int i3 = aim + 1;
                aim = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (aim == 1) {
                        aio = this.errorCode;
                    }
                    ain++;
                }
                if (aim == 2) {
                    s.a("A2T", aio, this.errorCode, ain);
                }
                if (true == vN()) {
                    this.mUseHttpClient = true;
                    this.air = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    ain = 0;
                    aim = 0;
                    aio = 0;
                }
                if (ea == null) {
                    return null;
                }
                if (this.aif != null && this.aif.fz().vq != null) {
                    List<String> list = this.aif.fz().vq.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.aif.fz().vq.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.aif.fz().vq.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aiq = false;
                            i = i2;
                            return (this.aip || (!z && i == 0) || !new String(ea, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ea : copyOfRange(ea, 23, ea.length);
                        }
                        this.aiq = true;
                    }
                }
                i = i2;
                if (this.aip) {
                }
            } catch (Exception e) {
                this.uY += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                vM();
                if (this.aij != null) {
                    cancel();
                }
                this.aif = new com.baidu.adp.lib.network.http.e();
                this.aij = new f(this.aif);
                this.aif.fy().setUrl(str);
                if (this.aig != null) {
                    for (Map.Entry<String, String> entry : this.aig.entrySet()) {
                        this.aif.fy().n(entry.getKey(), entry.getValue());
                    }
                }
                this.aij.d(null, null, -1);
                this.aih = this.aif.fz();
                byte[] bArr = this.aif.fz().vr;
                this.responseCode = this.aif.fz().responseCode;
                this.errorCode = this.aif.fz().vp;
                this.aip = this.aif.fz().fF();
                if (this.mUseHttpAutoSwitch && true == vN()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    ain = 0;
                    aim = 0;
                    aio = 0;
                }
                if (this.air) {
                    int i4 = aim + 1;
                    aim = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        ain++;
                        if (aim == 1) {
                            aio = this.errorCode;
                        }
                    }
                    if (aim == 2) {
                        s.a("T2A", aio, this.errorCode, ain);
                        this.air = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.aij.isGif();
                this.aiq = this.aij.vK();
                int size = this.aif.fA().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.aif.fA().get(i2) != null) {
                            sb.append(this.aif.fA().get(i2).vb);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ail = this.aif.fB();
                if (this.ail != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ail;
                    dVar.uY = sb2.append(dVar.uY).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ail;
                    dVar2.uY = sb3.append(dVar2.uY).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ail;
                    dVar3.uY = sb4.append(dVar3.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.aif.fA().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.aif.fA().get(i2) != null) {
                            sb.append(this.aif.fA().get(i2).vb);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.ail = this.aif.fB();
                if (this.ail != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ail;
                    dVar4.uY = sb5.append(dVar4.uY).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ail;
                    dVar5.uY = sb6.append(dVar5.uY).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ail;
                    dVar6.uY = sb7.append(dVar6.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.aif.fA().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.aif.fA().get(i2) != null) {
                        sb.append(this.aif.fA().get(i2).vb);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.ail = this.aif.fB();
            if (this.ail != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ail;
                dVar7.uY = sb8.append(dVar7.uY).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ail;
                dVar8.uY = sb9.append(dVar8.uY).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ail;
                dVar9.uY = sb10.append(dVar9.uY).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.aif.fA().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aif.fA().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uZ);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.va);
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
            this.uY = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aip = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.nJ != null) {
            this.nJ.cancel();
        }
        if (this.aij != null) {
            this.aij.cancel();
            this.aij = null;
        }
    }

    public boolean vO() {
        if (this.aij == null) {
            return false;
        }
        return this.aij.ahR;
    }
}
