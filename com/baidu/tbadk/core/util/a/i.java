package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0017a {
    private static int cXh = 5;
    private static int cXl = 0;
    private static int cXm = 0;
    private static int cXn = 0;
    private static int cXr = 0;
    private com.baidu.adp.lib.network.http.e cXe;
    private f cXi;
    private volatile com.baidu.adp.lib.network.http.c nC = null;
    private HashMap<String, String> cXf = null;
    private com.baidu.adp.lib.network.http.g cXg = new com.baidu.adp.lib.network.http.g();
    public boolean cXj = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d cXk = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean cXo = false;
    public boolean cXp = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean cXq = false;

    public boolean aEB() {
        return this.cXo;
    }

    public com.baidu.adp.lib.network.http.g fY() {
        return this.cXg;
    }

    public void kJ() {
        this.cXk = null;
        this.exception = "";
        this.cXo = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.cXj = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] to(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                kJ();
                if (this.cXe != null) {
                    cancel();
                    this.nC = null;
                }
                this.cXe = new com.baidu.adp.lib.network.http.e();
                this.cXe.fX().setUrl(str);
                if (this.cXf != null) {
                    for (Map.Entry<String, String> entry : this.cXf.entrySet()) {
                        this.cXe.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.nC = new com.baidu.adp.lib.network.http.c(this.cXe);
                this.nC.c(cXh, 0, 0);
                this.cXg = this.cXe.fY();
                byte[] bArr = this.cXe.fY().retBytes;
                this.responseCode = this.cXe.fY().responseCode;
                this.errorCode = this.cXe.fY().mNetErrorCode;
                this.cXo = this.cXe.fY().gg();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.cXe.fY().contentEncoding != null && this.cXe.fY().contentEncoding.toLowerCase().contains("gzip")) {
                    this.cXj = true;
                }
                if (!this.cXo) {
                    f(str, null);
                }
                this.cXk = this.cXe.ga();
                if (this.cXk != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.cXk;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.cXk;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.cXk = this.cXe.ga();
                if (this.cXk != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.cXk;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.cXk;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.cXk = this.cXe.ga();
            if (this.cXk != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.cXk;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.cXk;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] tp(String str) {
        return to(str);
    }

    private boolean aEC() {
        if (this.cXg.ro) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = cXr + 1;
            cXr = i;
            if (i >= 5) {
                cXr = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [332=6] */
    public byte[] T(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                    s.r("httpManager", str, "", "");
                }
                byte[] bArr = to(str);
                int i3 = cXl + 1;
                cXl = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (cXl == 1) {
                        cXn = this.errorCode;
                    }
                    cXm++;
                }
                if (cXl == 2) {
                    s.a("A2T", cXn, this.errorCode, cXm);
                }
                if (true == aEC()) {
                    this.mUseHttpClient = true;
                    this.cXq = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    cXm = 0;
                    cXl = 0;
                    cXn = 0;
                }
                if (bArr == null) {
                    return null;
                }
                if (this.cXe != null && this.cXe.fY().rp != null) {
                    List<String> list = this.cXe.fY().rp.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.cXe.fY().rp.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.cXe.fY().rp.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.cXp = false;
                            i = i2;
                            return (this.cXo || (!z && i == 0) || !new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? bArr : h(bArr, 23, bArr.length);
                        }
                        this.cXp = true;
                    }
                }
                i = i2;
                if (this.cXo) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            s.r("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                kJ();
                if (this.cXi != null) {
                    cancel();
                }
                this.cXe = new com.baidu.adp.lib.network.http.e();
                this.cXi = new f(this.cXe);
                this.cXe.fX().setUrl(str);
                if (this.cXf != null) {
                    for (Map.Entry<String, String> entry : this.cXf.entrySet()) {
                        this.cXe.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.cXi.n(null, null, -1);
                this.cXg = this.cXe.fY();
                byte[] bArr2 = this.cXe.fY().retBytes;
                this.responseCode = this.cXe.fY().responseCode;
                this.errorCode = this.cXe.fY().mNetErrorCode;
                this.cXo = this.cXe.fY().gg();
                if (this.mUseHttpAutoSwitch && true == aEC()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    cXm = 0;
                    cXl = 0;
                    cXn = 0;
                }
                if (this.cXq) {
                    int i4 = cXl + 1;
                    cXl = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        cXm++;
                        if (cXl == 1) {
                            cXn = this.errorCode;
                        }
                    }
                    if (cXl == 2) {
                        s.a("T2A", cXn, this.errorCode, cXm);
                        this.cXq = false;
                    }
                }
                if (bArr2 != null) {
                    this.dataSize = bArr2.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.cXi.isGif();
                this.cXp = this.cXi.aEA();
                int size = this.cXe.fZ().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.cXe.fZ().get(i2) != null) {
                            sb.append(this.cXe.fZ().get(i2).qQ);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.cXk = this.cXe.ga();
                if (this.cXk != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.cXk;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.cXk;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.cXk;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr2;
            } catch (Throwable th) {
                int size2 = this.cXe.fZ().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.cXe.fZ().get(i2) != null) {
                            sb.append(this.cXe.fZ().get(i2).qQ);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.cXk = this.cXe.ga();
                if (this.cXk != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.cXk;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.cXk;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.cXk;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.cXe.fZ().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.cXe.fZ().get(i2) != null) {
                        sb.append(this.cXe.fZ().get(i2).qQ);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.cXk = this.cXe.ga();
            if (this.cXk != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.cXk;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.cXk;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.cXk;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] h(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void f(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.cXe.fZ().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.cXe.fZ().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.exception);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.downloadSize);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.qM);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.qO);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.qN);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.qP);
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
            this.exception = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.cXo = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.nC != null) {
            this.nC.cancel();
        }
        if (this.cXi != null) {
            this.cXi.cancel();
            this.cXi = null;
        }
    }

    public boolean aED() {
        if (this.cXi == null) {
            return false;
        }
        return this.cXi.cWY;
    }
}
