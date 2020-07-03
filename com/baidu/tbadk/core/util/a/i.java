package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0021a {
    private static int dVQ = 5;
    private static int dVU = 0;
    private static int dVV = 0;
    private static int dVW = 0;
    private static int dWa = 0;
    private com.baidu.adp.lib.network.http.e dVN;
    private f dVR;
    private volatile com.baidu.adp.lib.network.http.c Ht = null;
    private HashMap<String, String> dVO = null;
    private com.baidu.adp.lib.network.http.g dVP = new com.baidu.adp.lib.network.http.g();
    public boolean dVS = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dVT = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dVX = false;
    public boolean dVY = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dVZ = false;

    public boolean aXd() {
        return this.dVX;
    }

    public com.baidu.adp.lib.network.http.g kU() {
        return this.dVP;
    }

    public void pZ() {
        this.dVT = null;
        this.exception = "";
        this.dVX = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dVS = false;
    }

    public boolean aXe() {
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] wR(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pZ();
                if (this.dVN != null) {
                    cancel();
                    this.Ht = null;
                }
                this.dVN = new com.baidu.adp.lib.network.http.e();
                this.dVN.kT().setUrl(str);
                if (this.dVO != null) {
                    for (Map.Entry<String, String> entry : this.dVO.entrySet()) {
                        this.dVN.kT().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Ht = new com.baidu.adp.lib.network.http.c(this.dVN);
                this.Ht.d(dVQ, 0, 0);
                this.dVP = this.dVN.kU();
                if (this.dVP != null && this.dVP.Lf != null && (list = this.dVP.Lf.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dVN.kU().retBytes;
                this.responseCode = this.dVN.kU().responseCode;
                this.errorCode = this.dVN.kU().mNetErrorCode;
                this.dVX = this.dVN.kU().lb();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dVN.kU().contentEncoding != null && this.dVN.kU().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dVS = true;
                }
                if (!this.dVX) {
                    e(str, null);
                }
                this.dVT = this.dVN.kW();
                if (this.dVT != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dVT;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dVT;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dVT = this.dVN.kW();
                if (this.dVT != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dVT;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dVT;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dVT = this.dVN.kW();
            if (this.dVT != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dVT;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dVT;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] wS(String str) {
        return wR(str);
    }

    private boolean aXf() {
        if (this.dVP.Le) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dWa + 1;
            dWa = i;
            if (i >= 5) {
                dWa = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
    public byte[] an(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                    t.u("httpManager", str, "", "");
                }
                byte[] wR = wR(str);
                int i3 = dVU + 1;
                dVU = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dVU == 1) {
                        dVW = this.errorCode;
                    }
                    dVV++;
                }
                if (dVU == 2) {
                    t.a("A2T", dVW, this.errorCode, dVV);
                }
                if (true == aXf()) {
                    this.mUseHttpClient = true;
                    this.dVZ = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dVV = 0;
                    dVU = 0;
                    dVW = 0;
                }
                if (wR == null) {
                    return null;
                }
                if (this.dVN != null && this.dVN.kU().Lf != null) {
                    List<String> list2 = this.dVN.kU().Lf.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dVN.kU().Lf.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dVN.kU().Lf.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dVY = false;
                            i = i2;
                            return (this.dVX || (!z && i == 0) || !new String(wR, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? wR : o(wR, 23, wR.length);
                        }
                        this.dVY = true;
                    }
                }
                i = i2;
                if (this.dVX) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            t.u("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pZ();
                if (this.dVR != null) {
                    cancel();
                }
                this.dVN = new com.baidu.adp.lib.network.http.e();
                this.dVR = new f(this.dVN);
                this.dVN.kT().setUrl(str);
                if (this.dVO != null) {
                    for (Map.Entry<String, String> entry : this.dVO.entrySet()) {
                        this.dVN.kT().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dVR.l(null, null, -1);
                this.dVP = this.dVN.kU();
                if (this.dVP != null && this.dVP.Lf != null && (list = this.dVP.Lf.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dVN.kU().retBytes;
                this.responseCode = this.dVN.kU().responseCode;
                this.errorCode = this.dVN.kU().mNetErrorCode;
                this.dVX = this.dVN.kU().lb();
                if (this.mUseHttpAutoSwitch && true == aXf()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dVV = 0;
                    dVU = 0;
                    dVW = 0;
                }
                if (this.dVZ) {
                    int i4 = dVU + 1;
                    dVU = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dVV++;
                        if (dVU == 1) {
                            dVW = this.errorCode;
                        }
                    }
                    if (dVU == 2) {
                        t.a("T2A", dVW, this.errorCode, dVV);
                        this.dVZ = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dVR.isGif();
                this.dVY = this.dVR.aXc();
                int size = this.dVN.kV().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dVN.kV().get(i2) != null) {
                            sb.append(this.dVN.kV().get(i2).KH);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dVT = this.dVN.kW();
                if (this.dVT != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dVT;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dVT;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dVT;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dVN.kV().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dVN.kV().get(i2) != null) {
                            sb.append(this.dVN.kV().get(i2).KH);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dVT = this.dVN.kW();
                if (this.dVT != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dVT;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dVT;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dVT;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dVN.kV().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dVN.kV().get(i2) != null) {
                        sb.append(this.dVN.kV().get(i2).KH);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dVT = this.dVN.kW();
            if (this.dVT != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dVT;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dVT;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dVT;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] o(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.dVN.kV().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dVN.kV().get(i);
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
            this.dVX = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.Ht != null) {
            this.Ht.cancel();
        }
        if (this.dVR != null) {
            this.dVR.cancel();
            this.dVR = null;
        }
    }

    public boolean aXg() {
        if (this.dVR == null) {
            return false;
        }
        return this.dVR.dVH;
    }
}
