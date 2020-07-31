package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0022a {
    private static int ecl = 5;
    private static int ecp = 0;
    private static int ecq = 0;
    private static int ecr = 0;
    private static int ecv = 0;
    private com.baidu.adp.lib.network.http.e eci;
    private f ecm;
    private volatile com.baidu.adp.lib.network.http.c Ht = null;
    private HashMap<String, String> ecj = null;
    private com.baidu.adp.lib.network.http.g eck = new com.baidu.adp.lib.network.http.g();
    public boolean ecn = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eco = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean ecs = false;
    public boolean ect = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ecu = false;

    public boolean bbe() {
        return this.ecs;
    }

    public com.baidu.adp.lib.network.http.g kU() {
        return this.eck;
    }

    public void qa() {
        this.eco = null;
        this.exception = "";
        this.ecs = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ecn = false;
    }

    public boolean bbf() {
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] xZ(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                qa();
                if (this.eci != null) {
                    cancel();
                    this.Ht = null;
                }
                this.eci = new com.baidu.adp.lib.network.http.e();
                this.eci.kT().setUrl(str);
                if (this.ecj != null) {
                    for (Map.Entry<String, String> entry : this.ecj.entrySet()) {
                        this.eci.kT().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Ht = new com.baidu.adp.lib.network.http.c(this.eci);
                this.Ht.d(ecl, 0, 0);
                this.eck = this.eci.kU();
                if (this.eck != null && this.eck.Lf != null && (list = this.eck.Lf.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eci.kU().retBytes;
                this.responseCode = this.eci.kU().responseCode;
                this.errorCode = this.eci.kU().mNetErrorCode;
                this.ecs = this.eci.kU().lb();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eci.kU().contentEncoding != null && this.eci.kU().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ecn = true;
                }
                if (!this.ecs) {
                    e(str, null);
                }
                this.eco = this.eci.kW();
                if (this.eco != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eco;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eco;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eco = this.eci.kW();
                if (this.eco != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eco;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eco;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eco = this.eci.kW();
            if (this.eco != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eco;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eco;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] ya(String str) {
        return xZ(str);
    }

    private boolean bbg() {
        if (this.eck.Le) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ecv + 1;
            ecv = i;
            if (i >= 5) {
                ecv = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
    public byte[] am(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                    u.u("httpManager", str, "", "");
                }
                byte[] xZ = xZ(str);
                int i3 = ecp + 1;
                ecp = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ecp == 1) {
                        ecr = this.errorCode;
                    }
                    ecq++;
                }
                if (ecp == 2) {
                    u.a("A2T", ecr, this.errorCode, ecq);
                }
                if (true == bbg()) {
                    this.mUseHttpClient = true;
                    this.ecu = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    ecq = 0;
                    ecp = 0;
                    ecr = 0;
                }
                if (xZ == null) {
                    return null;
                }
                if (this.eci != null && this.eci.kU().Lf != null) {
                    List<String> list2 = this.eci.kU().Lf.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eci.kU().Lf.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eci.kU().Lf.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ect = false;
                            i = i2;
                            return (this.ecs || (!z && i == 0) || !new String(xZ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? xZ : p(xZ, 23, xZ.length);
                        }
                        this.ect = true;
                    }
                }
                i = i2;
                if (this.ecs) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            u.u("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                qa();
                if (this.ecm != null) {
                    cancel();
                }
                this.eci = new com.baidu.adp.lib.network.http.e();
                this.ecm = new f(this.eci);
                this.eci.kT().setUrl(str);
                if (this.ecj != null) {
                    for (Map.Entry<String, String> entry : this.ecj.entrySet()) {
                        this.eci.kT().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.ecm.l(null, null, -1);
                this.eck = this.eci.kU();
                if (this.eck != null && this.eck.Lf != null && (list = this.eck.Lf.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eci.kU().retBytes;
                this.responseCode = this.eci.kU().responseCode;
                this.errorCode = this.eci.kU().mNetErrorCode;
                this.ecs = this.eci.kU().lb();
                if (this.mUseHttpAutoSwitch && true == bbg()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    ecq = 0;
                    ecp = 0;
                    ecr = 0;
                }
                if (this.ecu) {
                    int i4 = ecp + 1;
                    ecp = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        ecq++;
                        if (ecp == 1) {
                            ecr = this.errorCode;
                        }
                    }
                    if (ecp == 2) {
                        u.a("T2A", ecr, this.errorCode, ecq);
                        this.ecu = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.ecm.isGif();
                this.ect = this.ecm.bbd();
                int size = this.eci.kV().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eci.kV().get(i2) != null) {
                            sb.append(this.eci.kV().get(i2).KH);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eco = this.eci.kW();
                if (this.eco != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eco;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eco;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eco;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eci.kV().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eci.kV().get(i2) != null) {
                            sb.append(this.eci.kV().get(i2).KH);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eco = this.eci.kW();
                if (this.eco != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eco;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eco;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eco;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eci.kV().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eci.kV().get(i2) != null) {
                        sb.append(this.eci.kV().get(i2).KH);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eco = this.eci.kW();
            if (this.eco != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eco;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eco;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eco;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] p(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.eci.kV().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eci.kV().get(i);
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
                stringBuffer.append(dVar.KD);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.KF);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.KE);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.KG);
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
            this.ecs = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0022a
    public void cancel() {
        if (this.Ht != null) {
            this.Ht.cancel();
        }
        if (this.ecm != null) {
            this.ecm.cancel();
            this.ecm = null;
        }
    }

    public boolean bbh() {
        if (this.ecm == null) {
            return false;
        }
        return this.ecm.ecc;
    }
}
