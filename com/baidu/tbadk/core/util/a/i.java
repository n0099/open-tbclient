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
    private static int eOO = 5;
    private static int eOS = 0;
    private static int eOT = 0;
    private static int eOU = 0;
    private static int eOY = 0;
    private com.baidu.adp.lib.network.http.e eOL;
    private f eOP;
    private volatile com.baidu.adp.lib.network.http.c Iw = null;
    private HashMap<String, String> eOM = null;
    private com.baidu.adp.lib.network.http.g eON = new com.baidu.adp.lib.network.http.g();
    public boolean eOQ = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eOR = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean eOV = false;
    public boolean eOW = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean eOX = false;

    public boolean brB() {
        return this.eOV;
    }

    public com.baidu.adp.lib.network.http.g my() {
        return this.eON;
    }

    public void rE() {
        this.eOR = null;
        this.exception = "";
        this.eOV = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.eOQ = false;
    }

    public boolean brC() {
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Cd(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rE();
                if (this.eOL != null) {
                    cancel();
                    this.Iw = null;
                }
                this.eOL = new com.baidu.adp.lib.network.http.e();
                this.eOL.mx().setUrl(str);
                this.eOL.mx().al(UseHttpAutoRetrySwitch.isOn());
                if (this.eOM != null) {
                    for (Map.Entry<String, String> entry : this.eOM.entrySet()) {
                        this.eOL.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Iw = new com.baidu.adp.lib.network.http.c(this.eOL);
                this.Iw.d(eOO, 0, 0);
                this.eON = this.eOL.my();
                if (this.eON != null && this.eON.Mp != null && (list = this.eON.Mp.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eOL.my().retBytes;
                this.responseCode = this.eOL.my().responseCode;
                this.errorCode = this.eOL.my().mNetErrorCode;
                this.eOV = this.eOL.my().mG();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eOL.my().contentEncoding != null && this.eOL.my().contentEncoding.toLowerCase().contains("gzip")) {
                    this.eOQ = true;
                }
                if (!this.eOV) {
                    e(str, null);
                }
                this.eOR = this.eOL.mA();
                if (this.eOR != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eOR;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eOR;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eOR = this.eOL.mA();
                if (this.eOR != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eOR;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eOR;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eOR = this.eOL.mA();
            if (this.eOR != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eOR;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eOR;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Ce(String str) {
        return Cd(str);
    }

    private boolean brD() {
        if (this.eON.Mo) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eOY + 1;
            eOY = i;
            if (i >= 5) {
                eOY = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=6] */
    public byte[] aw(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                    u.v("httpManager", str, "", "");
                }
                byte[] Cd = Cd(str);
                int i3 = eOS + 1;
                eOS = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (eOS == 1) {
                        eOU = this.errorCode;
                    }
                    eOT++;
                }
                if (eOS == 2) {
                    u.b("A2T", eOU, this.errorCode, eOT);
                }
                if (true == brD()) {
                    this.mUseHttpClient = true;
                    this.eOX = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    eOT = 0;
                    eOS = 0;
                    eOU = 0;
                }
                if (Cd == null) {
                    return null;
                }
                if (this.eOL != null && this.eOL.my().Mp != null) {
                    List<String> list2 = this.eOL.my().Mp.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eOL.my().Mp.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eOL.my().Mp.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.eOW = false;
                            i = i2;
                            return (this.eOV || (!z && i == 0) || !new String(Cd, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Cd : s(Cd, 23, Cd.length);
                        }
                        this.eOW = true;
                    }
                }
                i = i2;
                if (this.eOV) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            u.v("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                rE();
                if (this.eOP != null) {
                    cancel();
                }
                this.eOL = new com.baidu.adp.lib.network.http.e();
                this.eOP = new f(this.eOL);
                this.eOL.mx().setUrl(str);
                if (this.eOM != null) {
                    for (Map.Entry<String, String> entry : this.eOM.entrySet()) {
                        this.eOL.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eOP.n(null, null, -1);
                this.eON = this.eOL.my();
                if (this.eON != null && this.eON.Mp != null && (list = this.eON.Mp.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eOL.my().retBytes;
                this.responseCode = this.eOL.my().responseCode;
                this.errorCode = this.eOL.my().mNetErrorCode;
                this.eOV = this.eOL.my().mG();
                if (this.mUseHttpAutoSwitch && true == brD()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    eOT = 0;
                    eOS = 0;
                    eOU = 0;
                }
                if (this.eOX) {
                    int i4 = eOS + 1;
                    eOS = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        eOT++;
                        if (eOS == 1) {
                            eOU = this.errorCode;
                        }
                    }
                    if (eOS == 2) {
                        u.b("T2A", eOU, this.errorCode, eOT);
                        this.eOX = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eOP.isGif();
                this.eOW = this.eOP.brA();
                int size = this.eOL.mz().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eOL.mz().get(i2) != null) {
                            sb.append(this.eOL.mz().get(i2).LO);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eOR = this.eOL.mA();
                if (this.eOR != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eOR;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eOR;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eOR;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eOL.mz().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eOL.mz().get(i2) != null) {
                            sb.append(this.eOL.mz().get(i2).LO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eOR = this.eOL.mA();
                if (this.eOR != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eOR;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eOR;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eOR;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eOL.mz().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eOL.mz().get(i2) != null) {
                        sb.append(this.eOL.mz().get(i2).LO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eOR = this.eOL.mA();
            if (this.eOR != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eOR;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eOR;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eOR;
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
            for (int i = 0; i < this.eOL.mz().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eOL.mz().get(i);
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
                stringBuffer.append(dVar.LJ);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.LM);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.LK);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.LN);
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
            this.eOV = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.Iw != null) {
            this.Iw.cancel();
        }
        if (this.eOP != null) {
            this.eOP.cancel();
            this.eOP = null;
        }
    }

    public boolean brE() {
        if (this.eOP == null) {
            return false;
        }
        return this.eOP.eOF;
    }
}
