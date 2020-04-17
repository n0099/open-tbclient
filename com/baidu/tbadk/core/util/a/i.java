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
    private static int dAO = 5;
    private static int dAS = 0;
    private static int dAT = 0;
    private static int dAU = 0;
    private static int dAY = 0;
    private com.baidu.adp.lib.network.http.e dAL;
    private f dAP;
    private volatile com.baidu.adp.lib.network.http.c GN = null;
    private HashMap<String, String> dAM = null;
    private com.baidu.adp.lib.network.http.g dAN = new com.baidu.adp.lib.network.http.g();
    public boolean dAQ = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dAR = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dAV = false;
    public boolean dAW = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dAX = false;

    public boolean aPh() {
        return this.dAV;
    }

    public com.baidu.adp.lib.network.http.g kC() {
        return this.dAN;
    }

    public void pC() {
        this.dAR = null;
        this.exception = "";
        this.dAV = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dAQ = false;
    }

    public boolean aPi() {
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] uR(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pC();
                if (this.dAL != null) {
                    cancel();
                    this.GN = null;
                }
                this.dAL = new com.baidu.adp.lib.network.http.e();
                this.dAL.kB().setUrl(str);
                if (this.dAM != null) {
                    for (Map.Entry<String, String> entry : this.dAM.entrySet()) {
                        this.dAL.kB().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.GN = new com.baidu.adp.lib.network.http.c(this.dAL);
                this.GN.d(dAO, 0, 0);
                this.dAN = this.dAL.kC();
                if (this.dAN != null && this.dAN.Kq != null && (list = this.dAN.Kq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dAL.kC().retBytes;
                this.responseCode = this.dAL.kC().responseCode;
                this.errorCode = this.dAL.kC().mNetErrorCode;
                this.dAV = this.dAL.kC().kJ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dAL.kC().contentEncoding != null && this.dAL.kC().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dAQ = true;
                }
                if (!this.dAV) {
                    e(str, null);
                }
                this.dAR = this.dAL.kE();
                if (this.dAR != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dAR;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dAR;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dAR = this.dAL.kE();
                if (this.dAR != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dAR;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dAR;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dAR = this.dAL.kE();
            if (this.dAR != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dAR;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dAR;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] uS(String str) {
        return uR(str);
    }

    private boolean aPj() {
        if (this.dAN.Kp) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dAY + 1;
            dAY = i;
            if (i >= 5) {
                dAY = 0;
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
                byte[] uR = uR(str);
                int i3 = dAS + 1;
                dAS = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dAS == 1) {
                        dAU = this.errorCode;
                    }
                    dAT++;
                }
                if (dAS == 2) {
                    s.a("A2T", dAU, this.errorCode, dAT);
                }
                if (true == aPj()) {
                    this.mUseHttpClient = true;
                    this.dAX = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dAT = 0;
                    dAS = 0;
                    dAU = 0;
                }
                if (uR == null) {
                    return null;
                }
                if (this.dAL != null && this.dAL.kC().Kq != null) {
                    List<String> list2 = this.dAL.kC().Kq.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dAL.kC().Kq.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dAL.kC().Kq.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dAW = false;
                            i = i2;
                            return (this.dAV || (!z && i == 0) || !new String(uR, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? uR : n(uR, 23, uR.length);
                        }
                        this.dAW = true;
                    }
                }
                i = i2;
                if (this.dAV) {
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
                if (this.dAP != null) {
                    cancel();
                }
                this.dAL = new com.baidu.adp.lib.network.http.e();
                this.dAP = new f(this.dAL);
                this.dAL.kB().setUrl(str);
                if (this.dAM != null) {
                    for (Map.Entry<String, String> entry : this.dAM.entrySet()) {
                        this.dAL.kB().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dAP.l(null, null, -1);
                this.dAN = this.dAL.kC();
                if (this.dAN != null && this.dAN.Kq != null && (list = this.dAN.Kq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dAL.kC().retBytes;
                this.responseCode = this.dAL.kC().responseCode;
                this.errorCode = this.dAL.kC().mNetErrorCode;
                this.dAV = this.dAL.kC().kJ();
                if (this.mUseHttpAutoSwitch && true == aPj()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dAT = 0;
                    dAS = 0;
                    dAU = 0;
                }
                if (this.dAX) {
                    int i4 = dAS + 1;
                    dAS = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dAT++;
                        if (dAS == 1) {
                            dAU = this.errorCode;
                        }
                    }
                    if (dAS == 2) {
                        s.a("T2A", dAU, this.errorCode, dAT);
                        this.dAX = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dAP.isGif();
                this.dAW = this.dAP.aPg();
                int size = this.dAL.kD().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dAL.kD().get(i2) != null) {
                            sb.append(this.dAL.kD().get(i2).JR);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dAR = this.dAL.kE();
                if (this.dAR != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dAR;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dAR;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dAR;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dAL.kD().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dAL.kD().get(i2) != null) {
                            sb.append(this.dAL.kD().get(i2).JR);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dAR = this.dAL.kE();
                if (this.dAR != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dAR;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dAR;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dAR;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dAL.kD().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dAL.kD().get(i2) != null) {
                        sb.append(this.dAL.kD().get(i2).JR);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dAR = this.dAL.kE();
            if (this.dAR != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dAR;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dAR;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dAR;
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
            for (int i = 0; i < this.dAL.kD().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dAL.kD().get(i);
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
                stringBuffer.append(dVar.JN);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.JP);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.JO);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.JQ);
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
            this.dAV = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.GN != null) {
            this.GN.cancel();
        }
        if (this.dAP != null) {
            this.dAP.cancel();
            this.dAP = null;
        }
    }

    public boolean aPk() {
        if (this.dAP == null) {
            return false;
        }
        return this.dAP.dAF;
    }
}
