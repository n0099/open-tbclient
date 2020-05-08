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
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0019a {
    private static int dAS = 5;
    private static int dAW = 0;
    private static int dAX = 0;
    private static int dAY = 0;
    private static int dBc = 0;
    private com.baidu.adp.lib.network.http.e dAP;
    private f dAT;
    private volatile com.baidu.adp.lib.network.http.c GQ = null;
    private HashMap<String, String> dAQ = null;
    private com.baidu.adp.lib.network.http.g dAR = new com.baidu.adp.lib.network.http.g();
    public boolean dAU = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dAV = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dAZ = false;
    public boolean dBa = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dBb = false;

    public boolean aPe() {
        return this.dAZ;
    }

    public com.baidu.adp.lib.network.http.g kC() {
        return this.dAR;
    }

    public void pC() {
        this.dAV = null;
        this.exception = "";
        this.dAZ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dAU = false;
    }

    public boolean aPf() {
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] uU(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pC();
                if (this.dAP != null) {
                    cancel();
                    this.GQ = null;
                }
                this.dAP = new com.baidu.adp.lib.network.http.e();
                this.dAP.kB().setUrl(str);
                if (this.dAQ != null) {
                    for (Map.Entry<String, String> entry : this.dAQ.entrySet()) {
                        this.dAP.kB().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.GQ = new com.baidu.adp.lib.network.http.c(this.dAP);
                this.GQ.d(dAS, 0, 0);
                this.dAR = this.dAP.kC();
                if (this.dAR != null && this.dAR.Kt != null && (list = this.dAR.Kt.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dAP.kC().retBytes;
                this.responseCode = this.dAP.kC().responseCode;
                this.errorCode = this.dAP.kC().mNetErrorCode;
                this.dAZ = this.dAP.kC().kJ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dAP.kC().contentEncoding != null && this.dAP.kC().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dAU = true;
                }
                if (!this.dAZ) {
                    e(str, null);
                }
                this.dAV = this.dAP.kE();
                if (this.dAV != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dAV;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dAV;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dAV = this.dAP.kE();
                if (this.dAV != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dAV;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dAV;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dAV = this.dAP.kE();
            if (this.dAV != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dAV;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dAV;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] uV(String str) {
        return uU(str);
    }

    private boolean aPg() {
        if (this.dAR.Ks) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dBc + 1;
            dBc = i;
            if (i >= 5) {
                dBc = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
    public byte[] Y(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                    s.u("httpManager", str, "", "");
                }
                byte[] uU = uU(str);
                int i3 = dAW + 1;
                dAW = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dAW == 1) {
                        dAY = this.errorCode;
                    }
                    dAX++;
                }
                if (dAW == 2) {
                    s.a("A2T", dAY, this.errorCode, dAX);
                }
                if (true == aPg()) {
                    this.mUseHttpClient = true;
                    this.dBb = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dAX = 0;
                    dAW = 0;
                    dAY = 0;
                }
                if (uU == null) {
                    return null;
                }
                if (this.dAP != null && this.dAP.kC().Kt != null) {
                    List<String> list2 = this.dAP.kC().Kt.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dAP.kC().Kt.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dAP.kC().Kt.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dBa = false;
                            i = i2;
                            return (this.dAZ || (!z && i == 0) || !new String(uU, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? uU : n(uU, 23, uU.length);
                        }
                        this.dBa = true;
                    }
                }
                i = i2;
                if (this.dAZ) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            s.u("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pC();
                if (this.dAT != null) {
                    cancel();
                }
                this.dAP = new com.baidu.adp.lib.network.http.e();
                this.dAT = new f(this.dAP);
                this.dAP.kB().setUrl(str);
                if (this.dAQ != null) {
                    for (Map.Entry<String, String> entry : this.dAQ.entrySet()) {
                        this.dAP.kB().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dAT.l(null, null, -1);
                this.dAR = this.dAP.kC();
                if (this.dAR != null && this.dAR.Kt != null && (list = this.dAR.Kt.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dAP.kC().retBytes;
                this.responseCode = this.dAP.kC().responseCode;
                this.errorCode = this.dAP.kC().mNetErrorCode;
                this.dAZ = this.dAP.kC().kJ();
                if (this.mUseHttpAutoSwitch && true == aPg()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dAX = 0;
                    dAW = 0;
                    dAY = 0;
                }
                if (this.dBb) {
                    int i4 = dAW + 1;
                    dAW = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dAX++;
                        if (dAW == 1) {
                            dAY = this.errorCode;
                        }
                    }
                    if (dAW == 2) {
                        s.a("T2A", dAY, this.errorCode, dAX);
                        this.dBb = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dAT.isGif();
                this.dBa = this.dAT.aPd();
                int size = this.dAP.kD().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dAP.kD().get(i2) != null) {
                            sb.append(this.dAP.kD().get(i2).JU);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dAV = this.dAP.kE();
                if (this.dAV != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dAV;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dAV;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dAV;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dAP.kD().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dAP.kD().get(i2) != null) {
                            sb.append(this.dAP.kD().get(i2).JU);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dAV = this.dAP.kE();
                if (this.dAV != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dAV;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dAV;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dAV;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dAP.kD().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dAP.kD().get(i2) != null) {
                        sb.append(this.dAP.kD().get(i2).JU);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dAV = this.dAP.kE();
            if (this.dAV != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dAV;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dAV;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dAV;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] n(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.dAP.kD().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dAP.kD().get(i);
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
                stringBuffer.append(dVar.JQ);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.JS);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.JR);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.JT);
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
            this.dAZ = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.GQ != null) {
            this.GQ.cancel();
        }
        if (this.dAT != null) {
            this.dAT.cancel();
            this.dAT = null;
        }
    }

    public boolean aPh() {
        if (this.dAT == null) {
            return false;
        }
        return this.dAT.dAJ;
    }
}
