package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0006a {
    private static int adL = 5;
    private static int adP = 0;
    private static int adQ = 0;
    private static int adR = 0;
    private static int adV = 0;
    private com.baidu.adp.lib.network.http.f adI;
    private f adM;
    private volatile com.baidu.adp.lib.network.http.d oq = null;
    private HashMap<String, String> adJ = null;
    private com.baidu.adp.lib.network.http.h adK = new com.baidu.adp.lib.network.http.h();
    public boolean adN = false;
    public boolean Hd = false;
    public String vw = "";
    public com.baidu.adp.lib.network.http.e adO = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean adS = false;
    public boolean adT = false;
    private boolean mUseHttpClient = TbadkCoreApplication.m411getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.m411getInst().isHttpAutoSwitch();
    private boolean adU = false;

    public boolean wX() {
        return this.adS;
    }

    public com.baidu.adp.lib.network.http.h hh() {
        return this.adK;
    }

    public void wY() {
        this.adO = null;
        this.vw = "";
        this.adS = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Hd = false;
        this.adN = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dM(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wY();
                if (this.adI != null) {
                    cancel();
                    this.oq = null;
                }
                this.adI = new com.baidu.adp.lib.network.http.f();
                this.adI.hg().setUrl(str);
                if (this.adJ != null) {
                    for (Map.Entry<String, String> entry : this.adJ.entrySet()) {
                        this.adI.hg().p(entry.getKey(), entry.getValue());
                    }
                }
                this.oq = new com.baidu.adp.lib.network.http.d(this.adI);
                this.oq.e(adL, 0, 0);
                this.adK = this.adI.hh();
                byte[] bArr = this.adI.hh().vN;
                this.responseCode = this.adI.hh().responseCode;
                this.errorCode = this.adI.hh().vL;
                this.adS = this.adI.hh().hn();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.adI.hh().contentEncoding != null && this.adI.hh().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adN = true;
                    bArr = w(bArr);
                }
                if (!this.adS) {
                    a(str, null);
                }
                this.adO = this.adI.hj();
                if (this.adO != null) {
                    com.baidu.adp.lib.network.http.e eVar = this.adO;
                    eVar.vw = String.valueOf(eVar.vw) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar2 = this.adO;
                    eVar2.vw = String.valueOf(eVar2.vw) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.adO = this.adI.hj();
                if (this.adO != null) {
                    com.baidu.adp.lib.network.http.e eVar3 = this.adO;
                    eVar3.vw = String.valueOf(eVar3.vw) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.e eVar4 = this.adO;
                    eVar4.vw = String.valueOf(eVar4.vw) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.adO = this.adI.hj();
            if (this.adO != null) {
                com.baidu.adp.lib.network.http.e eVar5 = this.adO;
                eVar5.vw = String.valueOf(eVar5.vw) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.e eVar6 = this.adO;
                eVar6.vw = String.valueOf(eVar6.vw) + "_responseCode:" + this.responseCode;
            }
            throw th;
        }
    }

    private final byte[] w(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dN(String str) {
        return dM(str);
    }

    private boolean wZ() {
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = adV + 1;
            adV = i;
            if (i >= 5) {
                adV = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] l(String str, boolean z) {
        byte[] dM;
        String str2;
        com.baidu.adp.lib.network.http.e eVar;
        com.baidu.adp.lib.network.http.e eVar2;
        com.baidu.adp.lib.network.http.e eVar3;
        com.baidu.adp.lib.network.http.e eVar4;
        com.baidu.adp.lib.network.http.e eVar5;
        com.baidu.adp.lib.network.http.e eVar6;
        int size;
        int i = 0;
        if (this.mUseHttpClient) {
            StringBuilder sb = new StringBuilder(20);
            try {
                try {
                    wY();
                    if (this.adM != null) {
                        cancel();
                    }
                    this.adI = new com.baidu.adp.lib.network.http.f();
                    this.adM = new f(this.adI);
                    this.adI.hg().setUrl(str);
                    if (this.adJ != null) {
                        for (Map.Entry<String, String> entry : this.adJ.entrySet()) {
                            this.adI.hg().p(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adM.d(null, null, -1);
                    this.adK = this.adI.hh();
                    dM = this.adI.hh().vN;
                    this.responseCode = this.adI.hh().responseCode;
                    this.errorCode = this.adI.hh().vL;
                    this.adS = this.adI.hh().hn();
                    if (this.mUseHttpAutoSwitch && wZ()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.m411getInst().setHttpClientOpen(false);
                        adQ = 0;
                        adP = 0;
                        adR = 0;
                    }
                    if (this.adU) {
                        int i2 = adP + 1;
                        adP = i2;
                        if (i2 <= 2 && this.responseCode != 200) {
                            adQ++;
                            if (adP == 1) {
                                adR = this.errorCode;
                            }
                        }
                        if (adP == 2) {
                            v.a("T2A", adR, this.errorCode, adQ);
                            this.adU = false;
                        }
                    }
                    if (dM != null) {
                        this.dataSize = dM.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Hd = this.adM.fO();
                    this.adT = this.adM.wW();
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.adI.hi().size();
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    for (int i3 = 0; i3 < this.adI.hi().size(); i3++) {
                        if (this.adI.hi().get(i3) != null) {
                            sb.append(this.adI.hi().get(i3).vz);
                        }
                        if (i3 != this.adI.hi().size() - 1) {
                            sb.append("_");
                        }
                    }
                    this.adO = this.adI.hj();
                    if (this.adO != null) {
                        this.adO.vw = String.valueOf(eVar4.vw) + sb.toString();
                        this.adO.vw = String.valueOf(eVar5.vw) + "_responseCode:" + this.responseCode;
                        this.adO.vw = String.valueOf(eVar6.vw) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } finally {
                int size3 = this.adI.hi().size();
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i < this.adI.hi().size()) {
                    if (this.adI.hi().get(i) != null) {
                        sb.append(this.adI.hi().get(i).vz);
                    }
                    if (i != this.adI.hi().size() - 1) {
                        sb.append("_");
                    }
                    i++;
                }
                this.adO = this.adI.hj();
                if (this.adO != null) {
                    this.adO.vw = String.valueOf(eVar.vw) + sb.toString();
                    this.adO.vw = String.valueOf(eVar2.vw) + "_responseCode:" + this.responseCode;
                    this.adO.vw = String.valueOf(eVar3.vw) + "_size:" + Integer.toString(this.dataSize);
                }
            }
        } else {
            try {
                dM = dM(str);
                int i4 = adP + 1;
                adP = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (adP == 1) {
                        adR = this.errorCode;
                    }
                    adQ++;
                }
                if (adP == 2) {
                    v.a("A2T", adR, this.errorCode, adQ);
                }
                if (wZ()) {
                    this.mUseHttpClient = true;
                    this.adU = true;
                    TbadkCoreApplication.m411getInst().setHttpClientOpen(true);
                    adQ = 0;
                    adP = 0;
                    adR = 0;
                }
                if (dM == null) {
                    return null;
                }
                if (this.adI != null && this.adI.hh().vM != null) {
                    List<String> list = this.adI.hh().vM.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.adI.hh().vM.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Hd = true;
                        } else {
                            this.Hd = false;
                        }
                    }
                    List<String> list3 = this.adI.hh().vM.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.adT = false;
                        } else {
                            this.adT = true;
                        }
                    }
                }
                if (this.adS && ((z || i != 0) && new String(dM, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return copyOfRange(dM, 23, dM.length);
                }
            } catch (Exception e2) {
                this.vw = String.valueOf(this.vw) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dM;
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(String.valueOf(i) + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void a(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.adI.hi().size(); i++) {
                com.baidu.adp.lib.network.http.e eVar = this.adI.hi().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(eVar.vw);
                stringBuffer.append("retry:");
                stringBuffer.append(eVar.vt);
                stringBuffer.append("connectTime:");
                stringBuffer.append(eVar.vr);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(eVar.vq);
                stringBuffer.append("rspTime:");
                stringBuffer.append(eVar.vs);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(eVar.vv);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(eVar.vx);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(eVar.vu);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(eVar.vy);
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
            this.vw = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.adS = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.oq != null) {
            this.oq.cancel();
        }
        if (this.adM != null) {
            this.adM.cancel();
            this.adM = null;
        }
    }

    public boolean xa() {
        if (this.adM == null) {
            return false;
        }
        return this.adM.adu;
    }
}
