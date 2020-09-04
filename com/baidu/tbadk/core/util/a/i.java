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
public class i implements a.InterfaceC0019a {
    private static int elY = 5;
    private static int emc = 0;
    private static int emd = 0;
    private static int eme = 0;
    private static int emi = 0;
    private com.baidu.adp.lib.network.http.e elV;
    private f elZ;
    private volatile com.baidu.adp.lib.network.http.c HY = null;
    private HashMap<String, String> elW = null;
    private com.baidu.adp.lib.network.http.g elX = new com.baidu.adp.lib.network.http.g();
    public boolean ema = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d emb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean emf = false;
    public boolean emg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean emh = false;

    public boolean bjD() {
        return this.emf;
    }

    public com.baidu.adp.lib.network.http.g mt() {
        return this.elX;
    }

    public void rz() {
        this.emb = null;
        this.exception = "";
        this.emf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ema = false;
    }

    public boolean bjE() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Ao(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rz();
                if (this.elV != null) {
                    cancel();
                    this.HY = null;
                }
                this.elV = new com.baidu.adp.lib.network.http.e();
                this.elV.ms().setUrl(str);
                if (this.elW != null) {
                    for (Map.Entry<String, String> entry : this.elW.entrySet()) {
                        this.elV.ms().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.HY = new com.baidu.adp.lib.network.http.c(this.elV);
                this.HY.d(elY, 0, 0);
                this.elX = this.elV.mt();
                if (this.elX != null && this.elX.LK != null && (list = this.elX.LK.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.elV.mt().retBytes;
                this.responseCode = this.elV.mt().responseCode;
                this.errorCode = this.elV.mt().mNetErrorCode;
                this.emf = this.elV.mt().mA();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.elV.mt().contentEncoding != null && this.elV.mt().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ema = true;
                }
                if (!this.emf) {
                    e(str, null);
                }
                this.emb = this.elV.mv();
                if (this.emb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.emb;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.emb;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.emb = this.elV.mv();
                if (this.emb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.emb;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.emb;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.emb = this.elV.mv();
            if (this.emb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.emb;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.emb;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Ap(String str) {
        return Ao(str);
    }

    private boolean bjF() {
        if (this.elX.LJ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = emi + 1;
            emi = i;
            if (i >= 5) {
                emi = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
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
                byte[] Ao = Ao(str);
                int i3 = emc + 1;
                emc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (emc == 1) {
                        eme = this.errorCode;
                    }
                    emd++;
                }
                if (emc == 2) {
                    u.b("A2T", eme, this.errorCode, emd);
                }
                if (true == bjF()) {
                    this.mUseHttpClient = true;
                    this.emh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    emd = 0;
                    emc = 0;
                    eme = 0;
                }
                if (Ao == null) {
                    return null;
                }
                if (this.elV != null && this.elV.mt().LK != null) {
                    List<String> list2 = this.elV.mt().LK.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.elV.mt().LK.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.elV.mt().LK.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.emg = false;
                            i = i2;
                            return (this.emf || (!z && i == 0) || !new String(Ao, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Ao : q(Ao, 23, Ao.length);
                        }
                        this.emg = true;
                    }
                }
                i = i2;
                if (this.emf) {
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
                rz();
                if (this.elZ != null) {
                    cancel();
                }
                this.elV = new com.baidu.adp.lib.network.http.e();
                this.elZ = new f(this.elV);
                this.elV.ms().setUrl(str);
                if (this.elW != null) {
                    for (Map.Entry<String, String> entry : this.elW.entrySet()) {
                        this.elV.ms().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.elZ.m(null, null, -1);
                this.elX = this.elV.mt();
                if (this.elX != null && this.elX.LK != null && (list = this.elX.LK.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.elV.mt().retBytes;
                this.responseCode = this.elV.mt().responseCode;
                this.errorCode = this.elV.mt().mNetErrorCode;
                this.emf = this.elV.mt().mA();
                if (this.mUseHttpAutoSwitch && true == bjF()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    emd = 0;
                    emc = 0;
                    eme = 0;
                }
                if (this.emh) {
                    int i4 = emc + 1;
                    emc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        emd++;
                        if (emc == 1) {
                            eme = this.errorCode;
                        }
                    }
                    if (emc == 2) {
                        u.b("T2A", eme, this.errorCode, emd);
                        this.emh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.elZ.isGif();
                this.emg = this.elZ.bjC();
                int size = this.elV.mu().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.elV.mu().get(i2) != null) {
                            sb.append(this.elV.mu().get(i2).Lk);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.emb = this.elV.mv();
                if (this.emb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.emb;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.emb;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.emb;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.elV.mu().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.elV.mu().get(i2) != null) {
                            sb.append(this.elV.mu().get(i2).Lk);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.emb = this.elV.mv();
                if (this.emb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.emb;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.emb;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.emb;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.elV.mu().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.elV.mu().get(i2) != null) {
                        sb.append(this.elV.mu().get(i2).Lk);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.emb = this.elV.mv();
            if (this.emb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.emb;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.emb;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.emb;
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
            for (int i = 0; i < this.elV.mu().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.elV.mu().get(i);
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
                stringBuffer.append(dVar.Lg);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Li);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Lh);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Lj);
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
            this.emf = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.HY != null) {
            this.HY.cancel();
        }
        if (this.elZ != null) {
            this.elZ.cancel();
            this.elZ = null;
        }
    }

    public boolean bjG() {
        if (this.elZ == null) {
            return false;
        }
        return this.elZ.elP;
    }
}
