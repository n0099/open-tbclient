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
public class i implements a.InterfaceC0020a {
    private com.baidu.adp.lib.network.http.e eoo;
    private f eos;
    private static int eor = 5;
    private static int eov = 0;
    private static int eow = 0;
    private static int eox = 0;
    private static int eoB = 0;
    private volatile com.baidu.adp.lib.network.http.c Ig = null;
    private HashMap<String, String> eop = null;
    private com.baidu.adp.lib.network.http.g eoq = new com.baidu.adp.lib.network.http.g();
    public boolean eot = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eou = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean eoy = false;
    public boolean eoz = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean eoA = false;

    public boolean bky() {
        return this.eoy;
    }

    public com.baidu.adp.lib.network.http.g mx() {
        return this.eoq;
    }

    public void rE() {
        this.eou = null;
        this.exception = "";
        this.eoy = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.eot = false;
    }

    public boolean bkz() {
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] AK(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rE();
                if (this.eoo != null) {
                    cancel();
                    this.Ig = null;
                }
                this.eoo = new com.baidu.adp.lib.network.http.e();
                this.eoo.mw().setUrl(str);
                this.eoo.mw().al(UseHttpAutoRetrySwitch.isOn());
                if (this.eop != null) {
                    for (Map.Entry<String, String> entry : this.eop.entrySet()) {
                        this.eoo.mw().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Ig = new com.baidu.adp.lib.network.http.c(this.eoo);
                this.Ig.d(eor, 0, 0);
                this.eoq = this.eoo.mx();
                if (this.eoq != null && this.eoq.LY != null && (list = this.eoq.LY.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eoo.mx().retBytes;
                this.responseCode = this.eoo.mx().responseCode;
                this.errorCode = this.eoo.mx().mNetErrorCode;
                this.eoy = this.eoo.mx().mF();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eoo.mx().contentEncoding != null && this.eoo.mx().contentEncoding.toLowerCase().contains("gzip")) {
                    this.eot = true;
                }
                if (!this.eoy) {
                    e(str, null);
                }
                this.eou = this.eoo.mz();
                if (this.eou != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eou;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eou;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eou = this.eoo.mz();
                if (this.eou != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eou;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eou;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eou = this.eoo.mz();
            if (this.eou != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eou;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eou;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] AL(String str) {
        return AK(str);
    }

    private boolean bkA() {
        if (this.eoq.LX) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eoB + 1;
            eoB = i;
            if (i >= 5) {
                eoB = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=6] */
    public byte[] aq(String str, boolean z) {
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
                byte[] AK = AK(str);
                int i3 = eov + 1;
                eov = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (eov == 1) {
                        eox = this.errorCode;
                    }
                    eow++;
                }
                if (eov == 2) {
                    u.b("A2T", eox, this.errorCode, eow);
                }
                if (true == bkA()) {
                    this.mUseHttpClient = true;
                    this.eoA = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    eow = 0;
                    eov = 0;
                    eox = 0;
                }
                if (AK == null) {
                    return null;
                }
                if (this.eoo != null && this.eoo.mx().LY != null) {
                    List<String> list2 = this.eoo.mx().LY.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eoo.mx().LY.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eoo.mx().LY.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.eoz = false;
                            i = i2;
                            return (this.eoy || (!z && i == 0) || !new String(AK, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? AK : q(AK, 23, AK.length);
                        }
                        this.eoz = true;
                    }
                }
                i = i2;
                if (this.eoy) {
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
                if (this.eos != null) {
                    cancel();
                }
                this.eoo = new com.baidu.adp.lib.network.http.e();
                this.eos = new f(this.eoo);
                this.eoo.mw().setUrl(str);
                if (this.eop != null) {
                    for (Map.Entry<String, String> entry : this.eop.entrySet()) {
                        this.eoo.mw().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eos.m(null, null, -1);
                this.eoq = this.eoo.mx();
                if (this.eoq != null && this.eoq.LY != null && (list = this.eoq.LY.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eoo.mx().retBytes;
                this.responseCode = this.eoo.mx().responseCode;
                this.errorCode = this.eoo.mx().mNetErrorCode;
                this.eoy = this.eoo.mx().mF();
                if (this.mUseHttpAutoSwitch && true == bkA()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    eow = 0;
                    eov = 0;
                    eox = 0;
                }
                if (this.eoA) {
                    int i4 = eov + 1;
                    eov = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        eow++;
                        if (eov == 1) {
                            eox = this.errorCode;
                        }
                    }
                    if (eov == 2) {
                        u.b("T2A", eox, this.errorCode, eow);
                        this.eoA = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eos.isGif();
                this.eoz = this.eos.bkx();
                int size = this.eoo.my().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eoo.my().get(i2) != null) {
                            sb.append(this.eoo.my().get(i2).Lu);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eou = this.eoo.mz();
                if (this.eou != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eou;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eou;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eou;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eoo.my().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eoo.my().get(i2) != null) {
                            sb.append(this.eoo.my().get(i2).Lu);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eou = this.eoo.mz();
                if (this.eou != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eou;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eou;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eou;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eoo.my().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eoo.my().get(i2) != null) {
                        sb.append(this.eoo.my().get(i2).Lu);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eou = this.eoo.mz();
            if (this.eou != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eou;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eou;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eou;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] q(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.eoo.my().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eoo.my().get(i);
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
                stringBuffer.append(dVar.Lq);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Ls);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Lr);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Lt);
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
            this.eoy = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0020a
    public void cancel() {
        if (this.Ig != null) {
            this.Ig.cancel();
        }
        if (this.eos != null) {
            this.eos.cancel();
            this.eos = null;
        }
    }

    public boolean bkB() {
        if (this.eos == null) {
            return false;
        }
        return this.eos.eoi;
    }
}
