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
    private static int cWX = 5;
    private static int cXb = 0;
    private static int cXc = 0;
    private static int cXd = 0;
    private static int cXh = 0;
    private com.baidu.adp.lib.network.http.f cWU;
    private f cWY;
    private volatile com.baidu.adp.lib.network.http.c nF = null;
    private HashMap<String, String> cWV = null;
    private com.baidu.adp.lib.network.http.h cWW = new com.baidu.adp.lib.network.http.h();
    public boolean cWZ = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d cXa = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean cXe = false;
    public boolean cXf = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean cXg = false;

    public boolean aEi() {
        return this.cXe;
    }

    public com.baidu.adp.lib.network.http.h fZ() {
        return this.cWW;
    }

    public void kI() {
        this.cXa = null;
        this.exception = "";
        this.cXe = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.cWZ = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] tk(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                kI();
                if (this.cWU != null) {
                    cancel();
                    this.nF = null;
                }
                this.cWU = new com.baidu.adp.lib.network.http.f();
                this.cWU.fY().setUrl(str);
                if (this.cWV != null) {
                    for (Map.Entry<String, String> entry : this.cWV.entrySet()) {
                        this.cWU.fY().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.nF = new com.baidu.adp.lib.network.http.c(this.cWU);
                this.nF.c(cWX, 0, 0);
                this.cWW = this.cWU.fZ();
                byte[] bArr = this.cWU.fZ().retBytes;
                this.responseCode = this.cWU.fZ().responseCode;
                this.errorCode = this.cWU.fZ().mNetErrorCode;
                this.cXe = this.cWU.fZ().gh();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.cWU.fZ().contentEncoding != null && this.cWU.fZ().contentEncoding.toLowerCase().contains("gzip")) {
                    this.cWZ = true;
                }
                if (!this.cXe) {
                    f(str, null);
                }
                this.cXa = this.cWU.gb();
                if (this.cXa != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.cXa;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.cXa;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.cXa = this.cWU.gb();
                if (this.cXa != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.cXa;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.cXa;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.cXa = this.cWU.gb();
            if (this.cXa != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.cXa;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.cXa;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] tl(String str) {
        return tk(str);
    }

    private boolean aEj() {
        if (this.cWW.ro) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = cXh + 1;
            cXh = i;
            if (i >= 5) {
                cXh = 0;
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
                byte[] tk = tk(str);
                int i3 = cXb + 1;
                cXb = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (cXb == 1) {
                        cXd = this.errorCode;
                    }
                    cXc++;
                }
                if (cXb == 2) {
                    s.a("A2T", cXd, this.errorCode, cXc);
                }
                if (true == aEj()) {
                    this.mUseHttpClient = true;
                    this.cXg = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    cXc = 0;
                    cXb = 0;
                    cXd = 0;
                }
                if (tk == null) {
                    return null;
                }
                if (this.cWU != null && this.cWU.fZ().rp != null) {
                    List<String> list = this.cWU.fZ().rp.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.cWU.fZ().rp.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.cWU.fZ().rp.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.cXf = false;
                            i = i2;
                            return (this.cXe || (!z && i == 0) || !new String(tk, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? tk : i(tk, 23, tk.length);
                        }
                        this.cXf = true;
                    }
                }
                i = i2;
                if (this.cXe) {
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
                kI();
                if (this.cWY != null) {
                    cancel();
                }
                this.cWU = new com.baidu.adp.lib.network.http.f();
                this.cWY = new f(this.cWU);
                this.cWU.fY().setUrl(str);
                if (this.cWV != null) {
                    for (Map.Entry<String, String> entry : this.cWV.entrySet()) {
                        this.cWU.fY().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.cWY.n(null, null, -1);
                this.cWW = this.cWU.fZ();
                byte[] bArr = this.cWU.fZ().retBytes;
                this.responseCode = this.cWU.fZ().responseCode;
                this.errorCode = this.cWU.fZ().mNetErrorCode;
                this.cXe = this.cWU.fZ().gh();
                if (this.mUseHttpAutoSwitch && true == aEj()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    cXc = 0;
                    cXb = 0;
                    cXd = 0;
                }
                if (this.cXg) {
                    int i4 = cXb + 1;
                    cXb = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        cXc++;
                        if (cXb == 1) {
                            cXd = this.errorCode;
                        }
                    }
                    if (cXb == 2) {
                        s.a("T2A", cXd, this.errorCode, cXc);
                        this.cXg = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.cWY.isGif();
                this.cXf = this.cWY.aEh();
                int size = this.cWU.ga().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.cWU.ga().get(i2) != null) {
                            sb.append(this.cWU.ga().get(i2).qS);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.cXa = this.cWU.gb();
                if (this.cXa != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.cXa;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.cXa;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.cXa;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.cWU.ga().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.cWU.ga().get(i2) != null) {
                            sb.append(this.cWU.ga().get(i2).qS);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.cXa = this.cWU.gb();
                if (this.cXa != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.cXa;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.cXa;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.cXa;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.cWU.ga().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.cWU.ga().get(i2) != null) {
                        sb.append(this.cWU.ga().get(i2).qS);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.cXa = this.cWU.gb();
            if (this.cXa != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.cXa;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.cXa;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.cXa;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] i(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.cWU.ga().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.cWU.ga().get(i);
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
                stringBuffer.append(dVar.qO);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.qQ);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.qP);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.qR);
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
            this.cXe = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.nF != null) {
            this.nF.cancel();
        }
        if (this.cWY != null) {
            this.cWY.cancel();
            this.cWY = null;
        }
    }

    public boolean aEk() {
        if (this.cWY == null) {
            return false;
        }
        return this.cWY.cWO;
    }
}
