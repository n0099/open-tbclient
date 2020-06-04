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
public class i implements a.InterfaceC0021a {
    private static int dOY = 5;
    private static int dPc = 0;
    private static int dPd = 0;
    private static int dPe = 0;
    private static int dPi = 0;
    private com.baidu.adp.lib.network.http.e dOV;
    private f dOZ;
    private volatile com.baidu.adp.lib.network.http.c GR = null;
    private HashMap<String, String> dOW = null;
    private com.baidu.adp.lib.network.http.g dOX = new com.baidu.adp.lib.network.http.g();
    public boolean dPa = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dPb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dPf = false;
    public boolean dPg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dPh = false;

    public boolean aVj() {
        return this.dPf;
    }

    public com.baidu.adp.lib.network.http.g kE() {
        return this.dOX;
    }

    public void pI() {
        this.dPb = null;
        this.exception = "";
        this.dPf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dPa = false;
    }

    public boolean aVk() {
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] wA(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pI();
                if (this.dOV != null) {
                    cancel();
                    this.GR = null;
                }
                this.dOV = new com.baidu.adp.lib.network.http.e();
                this.dOV.kD().setUrl(str);
                if (this.dOW != null) {
                    for (Map.Entry<String, String> entry : this.dOW.entrySet()) {
                        this.dOV.kD().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.GR = new com.baidu.adp.lib.network.http.c(this.dOV);
                this.GR.d(dOY, 0, 0);
                this.dOX = this.dOV.kE();
                if (this.dOX != null && this.dOX.KF != null && (list = this.dOX.KF.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dOV.kE().retBytes;
                this.responseCode = this.dOV.kE().responseCode;
                this.errorCode = this.dOV.kE().mNetErrorCode;
                this.dPf = this.dOV.kE().kL();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dOV.kE().contentEncoding != null && this.dOV.kE().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dPa = true;
                }
                if (!this.dPf) {
                    e(str, null);
                }
                this.dPb = this.dOV.kG();
                if (this.dPb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dPb;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dPb;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dPb = this.dOV.kG();
                if (this.dPb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dPb;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dPb;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dPb = this.dOV.kG();
            if (this.dPb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dPb;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dPb;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] wB(String str) {
        return wA(str);
    }

    private boolean aVl() {
        if (this.dOX.KE) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dPi + 1;
            dPi = i;
            if (i >= 5) {
                dPi = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
    public byte[] al(String str, boolean z) {
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
                byte[] wA = wA(str);
                int i3 = dPc + 1;
                dPc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dPc == 1) {
                        dPe = this.errorCode;
                    }
                    dPd++;
                }
                if (dPc == 2) {
                    s.a("A2T", dPe, this.errorCode, dPd);
                }
                if (true == aVl()) {
                    this.mUseHttpClient = true;
                    this.dPh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dPd = 0;
                    dPc = 0;
                    dPe = 0;
                }
                if (wA == null) {
                    return null;
                }
                if (this.dOV != null && this.dOV.kE().KF != null) {
                    List<String> list2 = this.dOV.kE().KF.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dOV.kE().KF.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dOV.kE().KF.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dPg = false;
                            i = i2;
                            return (this.dPf || (!z && i == 0) || !new String(wA, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? wA : o(wA, 23, wA.length);
                        }
                        this.dPg = true;
                    }
                }
                i = i2;
                if (this.dPf) {
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
                pI();
                if (this.dOZ != null) {
                    cancel();
                }
                this.dOV = new com.baidu.adp.lib.network.http.e();
                this.dOZ = new f(this.dOV);
                this.dOV.kD().setUrl(str);
                if (this.dOW != null) {
                    for (Map.Entry<String, String> entry : this.dOW.entrySet()) {
                        this.dOV.kD().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dOZ.l(null, null, -1);
                this.dOX = this.dOV.kE();
                if (this.dOX != null && this.dOX.KF != null && (list = this.dOX.KF.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dOV.kE().retBytes;
                this.responseCode = this.dOV.kE().responseCode;
                this.errorCode = this.dOV.kE().mNetErrorCode;
                this.dPf = this.dOV.kE().kL();
                if (this.mUseHttpAutoSwitch && true == aVl()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dPd = 0;
                    dPc = 0;
                    dPe = 0;
                }
                if (this.dPh) {
                    int i4 = dPc + 1;
                    dPc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dPd++;
                        if (dPc == 1) {
                            dPe = this.errorCode;
                        }
                    }
                    if (dPc == 2) {
                        s.a("T2A", dPe, this.errorCode, dPd);
                        this.dPh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dOZ.isGif();
                this.dPg = this.dOZ.aVi();
                int size = this.dOV.kF().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dOV.kF().get(i2) != null) {
                            sb.append(this.dOV.kF().get(i2).Kg);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dPb = this.dOV.kG();
                if (this.dPb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dPb;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dPb;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dPb;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dOV.kF().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dOV.kF().get(i2) != null) {
                            sb.append(this.dOV.kF().get(i2).Kg);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dPb = this.dOV.kG();
                if (this.dPb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dPb;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dPb;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dPb;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dOV.kF().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dOV.kF().get(i2) != null) {
                        sb.append(this.dOV.kF().get(i2).Kg);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dPb = this.dOV.kG();
            if (this.dPb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dPb;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dPb;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dPb;
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
            for (int i = 0; i < this.dOV.kF().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dOV.kF().get(i);
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
                stringBuffer.append(dVar.Kc);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Ke);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Kd);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Kf);
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
            this.dPf = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.GR != null) {
            this.GR.cancel();
        }
        if (this.dOZ != null) {
            this.dOZ.cancel();
            this.dOZ = null;
        }
    }

    public boolean aVm() {
        if (this.dOZ == null) {
            return false;
        }
        return this.dOZ.dOP;
    }
}
