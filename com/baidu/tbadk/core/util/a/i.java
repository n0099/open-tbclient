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
    private static int eVh = 5;
    private static int eVl = 0;
    private static int eVm = 0;
    private static int eVn = 0;
    private static int eVr = 0;
    private com.baidu.adp.lib.network.http.e eVe;
    private f eVi;
    private volatile com.baidu.adp.lib.network.http.c Ju = null;
    private HashMap<String, String> eVf = null;
    private com.baidu.adp.lib.network.http.g eVg = new com.baidu.adp.lib.network.http.g();
    public boolean eVj = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eVk = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean eVo = false;
    public boolean eVp = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean eVq = false;

    public boolean bum() {
        return this.eVo;
    }

    public com.baidu.adp.lib.network.http.g my() {
        return this.eVg;
    }

    public void rG() {
        this.eVk = null;
        this.exception = "";
        this.eVo = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.eVj = false;
    }

    public boolean bun() {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Ck(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rG();
                if (this.eVe != null) {
                    cancel();
                    this.Ju = null;
                }
                this.eVe = new com.baidu.adp.lib.network.http.e();
                this.eVe.mx().setUrl(str);
                this.eVe.mx().aj(UseHttpAutoRetrySwitch.isOn());
                if (this.eVf != null) {
                    for (Map.Entry<String, String> entry : this.eVf.entrySet()) {
                        this.eVe.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Ju = new com.baidu.adp.lib.network.http.c(this.eVe);
                this.Ju.d(eVh, 0, 0);
                this.eVg = this.eVe.my();
                if (this.eVg != null && this.eVg.Nk != null && (list = this.eVg.Nk.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eVe.my().retBytes;
                this.responseCode = this.eVe.my().responseCode;
                this.errorCode = this.eVe.my().mNetErrorCode;
                this.eVo = this.eVe.my().mG();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eVe.my().contentEncoding != null && this.eVe.my().contentEncoding.toLowerCase().contains("gzip")) {
                    this.eVj = true;
                }
                if (!this.eVo) {
                    e(str, null);
                }
                this.eVk = this.eVe.mA();
                if (this.eVk != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eVk;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eVk;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eVk = this.eVe.mA();
                if (this.eVk != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eVk;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eVk;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eVk = this.eVe.mA();
            if (this.eVk != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eVk;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eVk;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Cl(String str) {
        return Ck(str);
    }

    private boolean buo() {
        if (this.eVg.Nj) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eVr + 1;
            eVr = i;
            if (i >= 5) {
                eVr = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=6] */
    public byte[] ax(String str, boolean z) {
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
                byte[] Ck = Ck(str);
                int i3 = eVl + 1;
                eVl = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (eVl == 1) {
                        eVn = this.errorCode;
                    }
                    eVm++;
                }
                if (eVl == 2) {
                    u.b("A2T", eVn, this.errorCode, eVm);
                }
                if (true == buo()) {
                    this.mUseHttpClient = true;
                    this.eVq = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    eVm = 0;
                    eVl = 0;
                    eVn = 0;
                }
                if (Ck == null) {
                    return null;
                }
                if (this.eVe != null && this.eVe.my().Nk != null) {
                    List<String> list2 = this.eVe.my().Nk.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eVe.my().Nk.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eVe.my().Nk.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.eVp = false;
                            i = i2;
                            return (this.eVo || (!z && i == 0) || !new String(Ck, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Ck : s(Ck, 23, Ck.length);
                        }
                        this.eVp = true;
                    }
                }
                i = i2;
                if (this.eVo) {
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
                rG();
                if (this.eVi != null) {
                    cancel();
                }
                this.eVe = new com.baidu.adp.lib.network.http.e();
                this.eVi = new f(this.eVe);
                this.eVe.mx().setUrl(str);
                if (this.eVf != null) {
                    for (Map.Entry<String, String> entry : this.eVf.entrySet()) {
                        this.eVe.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eVi.n(null, null, -1);
                this.eVg = this.eVe.my();
                if (this.eVg != null && this.eVg.Nk != null && (list = this.eVg.Nk.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eVe.my().retBytes;
                this.responseCode = this.eVe.my().responseCode;
                this.errorCode = this.eVe.my().mNetErrorCode;
                this.eVo = this.eVe.my().mG();
                if (this.mUseHttpAutoSwitch && true == buo()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    eVm = 0;
                    eVl = 0;
                    eVn = 0;
                }
                if (this.eVq) {
                    int i4 = eVl + 1;
                    eVl = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        eVm++;
                        if (eVl == 1) {
                            eVn = this.errorCode;
                        }
                    }
                    if (eVl == 2) {
                        u.b("T2A", eVn, this.errorCode, eVm);
                        this.eVq = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eVi.isGif();
                this.eVp = this.eVi.bul();
                int size = this.eVe.mz().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eVe.mz().get(i2) != null) {
                            sb.append(this.eVe.mz().get(i2).MJ);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eVk = this.eVe.mA();
                if (this.eVk != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eVk;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eVk;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eVk;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eVe.mz().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eVe.mz().get(i2) != null) {
                            sb.append(this.eVe.mz().get(i2).MJ);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eVk = this.eVe.mA();
                if (this.eVk != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eVk;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eVk;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eVk;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eVe.mz().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eVe.mz().get(i2) != null) {
                        sb.append(this.eVe.mz().get(i2).MJ);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eVk = this.eVe.mA();
            if (this.eVk != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eVk;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eVk;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eVk;
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
            for (int i = 0; i < this.eVe.mz().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eVe.mz().get(i);
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
                stringBuffer.append(dVar.MF);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.MH);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.MG);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.MI);
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
            this.eVo = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.Ju != null) {
            this.Ju.cancel();
        }
        if (this.eVi != null) {
            this.eVi.cancel();
            this.eVi = null;
        }
    }

    public boolean bup() {
        if (this.eVi == null) {
            return false;
        }
        return this.eVi.eUY;
    }
}
