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
/* loaded from: classes2.dex */
public class i implements a.InterfaceC0019a {
    private static int elU = 5;
    private static int elY = 0;
    private static int elZ = 0;
    private static int ema = 0;
    private static int eme = 0;
    private com.baidu.adp.lib.network.http.e elR;
    private f elV;
    private volatile com.baidu.adp.lib.network.http.c HY = null;
    private HashMap<String, String> elS = null;
    private com.baidu.adp.lib.network.http.g elT = new com.baidu.adp.lib.network.http.g();
    public boolean elW = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d elX = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean emb = false;
    public boolean emc = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean emd = false;

    public boolean bjD() {
        return this.emb;
    }

    public com.baidu.adp.lib.network.http.g mt() {
        return this.elT;
    }

    public void rz() {
        this.elX = null;
        this.exception = "";
        this.emb = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.elW = false;
    }

    public boolean bjE() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] An(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rz();
                if (this.elR != null) {
                    cancel();
                    this.HY = null;
                }
                this.elR = new com.baidu.adp.lib.network.http.e();
                this.elR.ms().setUrl(str);
                if (this.elS != null) {
                    for (Map.Entry<String, String> entry : this.elS.entrySet()) {
                        this.elR.ms().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.HY = new com.baidu.adp.lib.network.http.c(this.elR);
                this.HY.d(elU, 0, 0);
                this.elT = this.elR.mt();
                if (this.elT != null && this.elT.LK != null && (list = this.elT.LK.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.elR.mt().retBytes;
                this.responseCode = this.elR.mt().responseCode;
                this.errorCode = this.elR.mt().mNetErrorCode;
                this.emb = this.elR.mt().mA();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.elR.mt().contentEncoding != null && this.elR.mt().contentEncoding.toLowerCase().contains("gzip")) {
                    this.elW = true;
                }
                if (!this.emb) {
                    e(str, null);
                }
                this.elX = this.elR.mv();
                if (this.elX != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.elX;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.elX;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.elX = this.elR.mv();
                if (this.elX != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.elX;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.elX;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.elX = this.elR.mv();
            if (this.elX != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.elX;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.elX;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Ao(String str) {
        return An(str);
    }

    private boolean bjF() {
        if (this.elT.LJ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = eme + 1;
            eme = i;
            if (i >= 5) {
                eme = 0;
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
                byte[] An = An(str);
                int i3 = elY + 1;
                elY = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (elY == 1) {
                        ema = this.errorCode;
                    }
                    elZ++;
                }
                if (elY == 2) {
                    u.b("A2T", ema, this.errorCode, elZ);
                }
                if (true == bjF()) {
                    this.mUseHttpClient = true;
                    this.emd = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    elZ = 0;
                    elY = 0;
                    ema = 0;
                }
                if (An == null) {
                    return null;
                }
                if (this.elR != null && this.elR.mt().LK != null) {
                    List<String> list2 = this.elR.mt().LK.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.elR.mt().LK.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.elR.mt().LK.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.emc = false;
                            i = i2;
                            return (this.emb || (!z && i == 0) || !new String(An, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? An : q(An, 23, An.length);
                        }
                        this.emc = true;
                    }
                }
                i = i2;
                if (this.emb) {
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
                if (this.elV != null) {
                    cancel();
                }
                this.elR = new com.baidu.adp.lib.network.http.e();
                this.elV = new f(this.elR);
                this.elR.ms().setUrl(str);
                if (this.elS != null) {
                    for (Map.Entry<String, String> entry : this.elS.entrySet()) {
                        this.elR.ms().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.elV.m(null, null, -1);
                this.elT = this.elR.mt();
                if (this.elT != null && this.elT.LK != null && (list = this.elT.LK.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.elR.mt().retBytes;
                this.responseCode = this.elR.mt().responseCode;
                this.errorCode = this.elR.mt().mNetErrorCode;
                this.emb = this.elR.mt().mA();
                if (this.mUseHttpAutoSwitch && true == bjF()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    elZ = 0;
                    elY = 0;
                    ema = 0;
                }
                if (this.emd) {
                    int i4 = elY + 1;
                    elY = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        elZ++;
                        if (elY == 1) {
                            ema = this.errorCode;
                        }
                    }
                    if (elY == 2) {
                        u.b("T2A", ema, this.errorCode, elZ);
                        this.emd = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.elV.isGif();
                this.emc = this.elV.bjC();
                int size = this.elR.mu().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.elR.mu().get(i2) != null) {
                            sb.append(this.elR.mu().get(i2).Lk);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.elX = this.elR.mv();
                if (this.elX != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.elX;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.elX;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.elX;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.elR.mu().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.elR.mu().get(i2) != null) {
                            sb.append(this.elR.mu().get(i2).Lk);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.elX = this.elR.mv();
                if (this.elX != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.elX;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.elX;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.elX;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.elR.mu().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.elR.mu().get(i2) != null) {
                        sb.append(this.elR.mu().get(i2).Lk);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.elX = this.elR.mv();
            if (this.elX != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.elX;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.elX;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.elX;
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
            for (int i = 0; i < this.elR.mu().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.elR.mu().get(i);
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
            this.emb = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.HY != null) {
            this.HY.cancel();
        }
        if (this.elV != null) {
            this.elV.cancel();
            this.elV = null;
        }
    }

    public boolean bjG() {
        if (this.elV == null) {
            return false;
        }
        return this.elV.elL;
    }
}
