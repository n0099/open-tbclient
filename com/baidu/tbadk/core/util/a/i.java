package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0021a {
    private static int eAD = 5;
    private static int eAH = 0;
    private static int eAI = 0;
    private static int eAJ = 0;
    private static int eAN = 0;
    private com.baidu.adp.lib.network.http.e eAA;
    private f eAE;
    private volatile com.baidu.adp.lib.network.http.c Iw = null;
    private HashMap<String, String> eAB = null;
    private com.baidu.adp.lib.network.http.g eAC = new com.baidu.adp.lib.network.http.g();
    public boolean eAF = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eAG = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean eAK = false;
    public boolean eAL = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean eAM = false;

    public boolean bni() {
        return this.eAK;
    }

    public com.baidu.adp.lib.network.http.g my() {
        return this.eAC;
    }

    public void rE() {
        this.eAG = null;
        this.exception = "";
        this.eAK = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.eAF = false;
    }

    public boolean bnj() {
        if (com.baidu.tbadk.core.sharedPref.b.blO().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Bw(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rE();
                if (this.eAA != null) {
                    cancel();
                    this.Iw = null;
                }
                this.eAA = new com.baidu.adp.lib.network.http.e();
                this.eAA.mx().setUrl(str);
                this.eAA.mx().al(UseHttpAutoRetrySwitch.isOn());
                if (this.eAB != null) {
                    for (Map.Entry<String, String> entry : this.eAB.entrySet()) {
                        this.eAA.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Iw = new com.baidu.adp.lib.network.http.c(this.eAA);
                this.Iw.d(eAD, 0, 0);
                this.eAC = this.eAA.my();
                if (this.eAC != null && this.eAC.Mo != null && (list = this.eAC.Mo.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eAA.my().retBytes;
                this.responseCode = this.eAA.my().responseCode;
                this.errorCode = this.eAA.my().mNetErrorCode;
                this.eAK = this.eAA.my().mG();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eAA.my().contentEncoding != null && this.eAA.my().contentEncoding.toLowerCase().contains("gzip")) {
                    this.eAF = true;
                }
                if (!this.eAK) {
                    e(str, null);
                }
                this.eAG = this.eAA.mA();
                if (this.eAG != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eAG;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eAG;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eAG = this.eAA.mA();
                if (this.eAG != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eAG;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eAG;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eAG = this.eAA.mA();
            if (this.eAG != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eAG;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eAG;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Bx(String str) {
        return Bw(str);
    }

    private boolean bnk() {
        if (this.eAC.Mn) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eAN + 1;
            eAN = i;
            if (i >= 5) {
                eAN = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=6] */
    public byte[] au(String str, boolean z) {
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
                byte[] Bw = Bw(str);
                int i3 = eAH + 1;
                eAH = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (eAH == 1) {
                        eAJ = this.errorCode;
                    }
                    eAI++;
                }
                if (eAH == 2) {
                    u.b("A2T", eAJ, this.errorCode, eAI);
                }
                if (true == bnk()) {
                    this.mUseHttpClient = true;
                    this.eAM = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    eAI = 0;
                    eAH = 0;
                    eAJ = 0;
                }
                if (Bw == null) {
                    return null;
                }
                if (this.eAA != null && this.eAA.my().Mo != null) {
                    List<String> list2 = this.eAA.my().Mo.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eAA.my().Mo.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eAA.my().Mo.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.eAL = false;
                            i = i2;
                            return (this.eAK || (!z && i == 0) || !new String(Bw, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Bw : s(Bw, 23, Bw.length);
                        }
                        this.eAL = true;
                    }
                }
                i = i2;
                if (this.eAK) {
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
                rE();
                if (this.eAE != null) {
                    cancel();
                }
                this.eAA = new com.baidu.adp.lib.network.http.e();
                this.eAE = new f(this.eAA);
                this.eAA.mx().setUrl(str);
                if (this.eAB != null) {
                    for (Map.Entry<String, String> entry : this.eAB.entrySet()) {
                        this.eAA.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eAE.m(null, null, -1);
                this.eAC = this.eAA.my();
                if (this.eAC != null && this.eAC.Mo != null && (list = this.eAC.Mo.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eAA.my().retBytes;
                this.responseCode = this.eAA.my().responseCode;
                this.errorCode = this.eAA.my().mNetErrorCode;
                this.eAK = this.eAA.my().mG();
                if (this.mUseHttpAutoSwitch && true == bnk()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    eAI = 0;
                    eAH = 0;
                    eAJ = 0;
                }
                if (this.eAM) {
                    int i4 = eAH + 1;
                    eAH = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        eAI++;
                        if (eAH == 1) {
                            eAJ = this.errorCode;
                        }
                    }
                    if (eAH == 2) {
                        u.b("T2A", eAJ, this.errorCode, eAI);
                        this.eAM = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eAE.isGif();
                this.eAL = this.eAE.bnh();
                int size = this.eAA.mz().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eAA.mz().get(i2) != null) {
                            sb.append(this.eAA.mz().get(i2).LN);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eAG = this.eAA.mA();
                if (this.eAG != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eAG;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eAG;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eAG;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eAA.mz().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eAA.mz().get(i2) != null) {
                            sb.append(this.eAA.mz().get(i2).LN);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eAG = this.eAA.mA();
                if (this.eAG != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eAG;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eAG;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eAG;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eAA.mz().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eAA.mz().get(i2) != null) {
                        sb.append(this.eAA.mz().get(i2).LN);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eAG = this.eAA.mA();
            if (this.eAG != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eAG;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eAG;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eAG;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] s(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.eAA.mz().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eAA.mz().get(i);
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
                stringBuffer.append(dVar.LI);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.LK);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.LJ);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.LM);
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
            this.eAK = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.Iw != null) {
            this.Iw.cancel();
        }
        if (this.eAE != null) {
            this.eAE.cancel();
            this.eAE = null;
        }
    }

    public boolean bnl() {
        if (this.eAE == null) {
            return false;
        }
        return this.eAE.eAu;
    }
}
