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
public class i implements a.InterfaceC0017a {
    private static int dbm = 5;
    private static int dbq = 0;
    private static int dbr = 0;
    private static int dbs = 0;
    private static int dbw = 0;
    private com.baidu.adp.lib.network.http.e dbj;
    private f dbn;
    private volatile com.baidu.adp.lib.network.http.c nG = null;
    private HashMap<String, String> dbk = null;
    private com.baidu.adp.lib.network.http.g dbl = new com.baidu.adp.lib.network.http.g();
    public boolean dbo = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dbp = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dbt = false;
    public boolean dbu = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dbv = false;

    public boolean aGO() {
        return this.dbt;
    }

    public com.baidu.adp.lib.network.http.g fY() {
        return this.dbl;
    }

    public void kY() {
        this.dbp = null;
        this.exception = "";
        this.dbt = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dbo = false;
    }

    public boolean aGP() {
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] tE(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                kY();
                if (this.dbj != null) {
                    cancel();
                    this.nG = null;
                }
                this.dbj = new com.baidu.adp.lib.network.http.e();
                this.dbj.fX().setUrl(str);
                if (this.dbk != null) {
                    for (Map.Entry<String, String> entry : this.dbk.entrySet()) {
                        this.dbj.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.nG = new com.baidu.adp.lib.network.http.c(this.dbj);
                this.nG.c(dbm, 0, 0);
                this.dbl = this.dbj.fY();
                if (this.dbl != null && this.dbl.rq != null && (list = this.dbl.rq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dbj.fY().retBytes;
                this.responseCode = this.dbj.fY().responseCode;
                this.errorCode = this.dbj.fY().mNetErrorCode;
                this.dbt = this.dbj.fY().gg();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dbj.fY().contentEncoding != null && this.dbj.fY().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dbo = true;
                }
                if (!this.dbt) {
                    f(str, null);
                }
                this.dbp = this.dbj.ga();
                if (this.dbp != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dbp;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dbp;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dbp = this.dbj.ga();
                if (this.dbp != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dbp;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dbp;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dbp = this.dbj.ga();
            if (this.dbp != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dbp;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dbp;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] tF(String str) {
        return tE(str);
    }

    private boolean aGQ() {
        if (this.dbl.rp) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dbw + 1;
            dbw = i;
            if (i >= 5) {
                dbw = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=6] */
    public byte[] T(String str, boolean z) {
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
                byte[] tE = tE(str);
                int i3 = dbq + 1;
                dbq = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dbq == 1) {
                        dbs = this.errorCode;
                    }
                    dbr++;
                }
                if (dbq == 2) {
                    s.a("A2T", dbs, this.errorCode, dbr);
                }
                if (true == aGQ()) {
                    this.mUseHttpClient = true;
                    this.dbv = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dbr = 0;
                    dbq = 0;
                    dbs = 0;
                }
                if (tE == null) {
                    return null;
                }
                if (this.dbj != null && this.dbj.fY().rq != null) {
                    List<String> list2 = this.dbj.fY().rq.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dbj.fY().rq.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dbj.fY().rq.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dbu = false;
                            i = i2;
                            return (this.dbt || (!z && i == 0) || !new String(tE, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? tE : l(tE, 23, tE.length);
                        }
                        this.dbu = true;
                    }
                }
                i = i2;
                if (this.dbt) {
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
                kY();
                if (this.dbn != null) {
                    cancel();
                }
                this.dbj = new com.baidu.adp.lib.network.http.e();
                this.dbn = new f(this.dbj);
                this.dbj.fX().setUrl(str);
                if (this.dbk != null) {
                    for (Map.Entry<String, String> entry : this.dbk.entrySet()) {
                        this.dbj.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dbn.m(null, null, -1);
                this.dbl = this.dbj.fY();
                if (this.dbl != null && this.dbl.rq != null && (list = this.dbl.rq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dbj.fY().retBytes;
                this.responseCode = this.dbj.fY().responseCode;
                this.errorCode = this.dbj.fY().mNetErrorCode;
                this.dbt = this.dbj.fY().gg();
                if (this.mUseHttpAutoSwitch && true == aGQ()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dbr = 0;
                    dbq = 0;
                    dbs = 0;
                }
                if (this.dbv) {
                    int i4 = dbq + 1;
                    dbq = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dbr++;
                        if (dbq == 1) {
                            dbs = this.errorCode;
                        }
                    }
                    if (dbq == 2) {
                        s.a("T2A", dbs, this.errorCode, dbr);
                        this.dbv = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dbn.isGif();
                this.dbu = this.dbn.aGN();
                int size = this.dbj.fZ().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dbj.fZ().get(i2) != null) {
                            sb.append(this.dbj.fZ().get(i2).qR);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dbp = this.dbj.ga();
                if (this.dbp != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dbp;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dbp;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dbp;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dbj.fZ().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dbj.fZ().get(i2) != null) {
                            sb.append(this.dbj.fZ().get(i2).qR);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dbp = this.dbj.ga();
                if (this.dbp != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dbp;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dbp;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dbp;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dbj.fZ().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dbj.fZ().get(i2) != null) {
                        sb.append(this.dbj.fZ().get(i2).qR);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dbp = this.dbj.ga();
            if (this.dbp != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dbp;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dbp;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dbp;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] l(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void f(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.dbj.fZ().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dbj.fZ().get(i);
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
                stringBuffer.append(dVar.qN);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.qP);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.qO);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.qQ);
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
            this.dbt = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.nG != null) {
            this.nG.cancel();
        }
        if (this.dbn != null) {
            this.dbn.cancel();
            this.dbn = null;
        }
    }

    public boolean aGR() {
        if (this.dbn == null) {
            return false;
        }
        return this.dbn.dbd;
    }
}
