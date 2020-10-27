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
    private static int eIZ = 5;
    private static int eJd = 0;
    private static int eJe = 0;
    private static int eJf = 0;
    private static int eJj = 0;
    private com.baidu.adp.lib.network.http.e eIW;
    private f eJa;
    private volatile com.baidu.adp.lib.network.http.c Iw = null;
    private HashMap<String, String> eIX = null;
    private com.baidu.adp.lib.network.http.g eIY = new com.baidu.adp.lib.network.http.g();
    public boolean eJb = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d eJc = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean eJg = false;
    public boolean eJh = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean eJi = false;

    public boolean bpb() {
        return this.eJg;
    }

    public com.baidu.adp.lib.network.http.g my() {
        return this.eIY;
    }

    public void rE() {
        this.eJc = null;
        this.exception = "";
        this.eJg = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.eJb = false;
    }

    public boolean bpc() {
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] BP(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rE();
                if (this.eIW != null) {
                    cancel();
                    this.Iw = null;
                }
                this.eIW = new com.baidu.adp.lib.network.http.e();
                this.eIW.mx().setUrl(str);
                this.eIW.mx().al(UseHttpAutoRetrySwitch.isOn());
                if (this.eIX != null) {
                    for (Map.Entry<String, String> entry : this.eIX.entrySet()) {
                        this.eIW.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Iw = new com.baidu.adp.lib.network.http.c(this.eIW);
                this.Iw.d(eIZ, 0, 0);
                this.eIY = this.eIW.my();
                if (this.eIY != null && this.eIY.Mp != null && (list = this.eIY.Mp.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eIW.my().retBytes;
                this.responseCode = this.eIW.my().responseCode;
                this.errorCode = this.eIW.my().mNetErrorCode;
                this.eJg = this.eIW.my().mG();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eIW.my().contentEncoding != null && this.eIW.my().contentEncoding.toLowerCase().contains("gzip")) {
                    this.eJb = true;
                }
                if (!this.eJg) {
                    e(str, null);
                }
                this.eJc = this.eIW.mA();
                if (this.eJc != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eJc;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eJc;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.eJc = this.eIW.mA();
                if (this.eJc != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eJc;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eJc;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.eJc = this.eIW.mA();
            if (this.eJc != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.eJc;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.eJc;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] BQ(String str) {
        return BP(str);
    }

    private boolean bpd() {
        if (this.eIY.Mo) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eJj + 1;
            eJj = i;
            if (i >= 5) {
                eJj = 0;
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
                byte[] BP = BP(str);
                int i3 = eJd + 1;
                eJd = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (eJd == 1) {
                        eJf = this.errorCode;
                    }
                    eJe++;
                }
                if (eJd == 2) {
                    u.b("A2T", eJf, this.errorCode, eJe);
                }
                if (true == bpd()) {
                    this.mUseHttpClient = true;
                    this.eJi = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    eJe = 0;
                    eJd = 0;
                    eJf = 0;
                }
                if (BP == null) {
                    return null;
                }
                if (this.eIW != null && this.eIW.my().Mp != null) {
                    List<String> list2 = this.eIW.my().Mp.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eIW.my().Mp.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eIW.my().Mp.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.eJh = false;
                            i = i2;
                            return (this.eJg || (!z && i == 0) || !new String(BP, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? BP : s(BP, 23, BP.length);
                        }
                        this.eJh = true;
                    }
                }
                i = i2;
                if (this.eJg) {
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
                if (this.eJa != null) {
                    cancel();
                }
                this.eIW = new com.baidu.adp.lib.network.http.e();
                this.eJa = new f(this.eIW);
                this.eIW.mx().setUrl(str);
                if (this.eIX != null) {
                    for (Map.Entry<String, String> entry : this.eIX.entrySet()) {
                        this.eIW.mx().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eJa.m(null, null, -1);
                this.eIY = this.eIW.my();
                if (this.eIY != null && this.eIY.Mp != null && (list = this.eIY.Mp.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eIW.my().retBytes;
                this.responseCode = this.eIW.my().responseCode;
                this.errorCode = this.eIW.my().mNetErrorCode;
                this.eJg = this.eIW.my().mG();
                if (this.mUseHttpAutoSwitch && true == bpd()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    eJe = 0;
                    eJd = 0;
                    eJf = 0;
                }
                if (this.eJi) {
                    int i4 = eJd + 1;
                    eJd = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        eJe++;
                        if (eJd == 1) {
                            eJf = this.errorCode;
                        }
                    }
                    if (eJd == 2) {
                        u.b("T2A", eJf, this.errorCode, eJe);
                        this.eJi = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eJa.isGif();
                this.eJh = this.eJa.bpa();
                int size = this.eIW.mz().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eIW.mz().get(i2) != null) {
                            sb.append(this.eIW.mz().get(i2).LO);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eJc = this.eIW.mA();
                if (this.eJc != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.eJc;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.eJc;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.eJc;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.eIW.mz().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eIW.mz().get(i2) != null) {
                            sb.append(this.eIW.mz().get(i2).LO);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.eJc = this.eIW.mA();
                if (this.eJc != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.eJc;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.eJc;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.eJc;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.eIW.mz().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eIW.mz().get(i2) != null) {
                        sb.append(this.eIW.mz().get(i2).LO);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.eJc = this.eIW.mA();
            if (this.eJc != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.eJc;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.eJc;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.eJc;
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
            for (int i = 0; i < this.eIW.mz().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eIW.mz().get(i);
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
            this.eJg = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.Iw != null) {
            this.Iw.cancel();
        }
        if (this.eJa != null) {
            this.eJa.cancel();
            this.eJa = null;
        }
    }

    public boolean bpe() {
        if (this.eJa == null) {
            return false;
        }
        return this.eJa.eIQ;
    }
}
