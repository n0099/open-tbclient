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
    private static int dbk = 5;
    private static int dbo = 0;
    private static int dbp = 0;
    private static int dbq = 0;
    private static int dbu = 0;
    private com.baidu.adp.lib.network.http.e dbh;
    private f dbl;
    private volatile com.baidu.adp.lib.network.http.c nG = null;
    private HashMap<String, String> dbi = null;
    private com.baidu.adp.lib.network.http.g dbj = new com.baidu.adp.lib.network.http.g();
    public boolean dbm = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d dbn = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean dbr = false;
    public boolean dbs = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean dbt = false;

    public boolean aGM() {
        return this.dbr;
    }

    public com.baidu.adp.lib.network.http.g fY() {
        return this.dbj;
    }

    public void kY() {
        this.dbn = null;
        this.exception = "";
        this.dbr = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.dbm = false;
    }

    public boolean aGN() {
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("image_no_cache_switch", 0) == 1) {
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
                if (this.dbh != null) {
                    cancel();
                    this.nG = null;
                }
                this.dbh = new com.baidu.adp.lib.network.http.e();
                this.dbh.fX().setUrl(str);
                if (this.dbi != null) {
                    for (Map.Entry<String, String> entry : this.dbi.entrySet()) {
                        this.dbh.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.nG = new com.baidu.adp.lib.network.http.c(this.dbh);
                this.nG.c(dbk, 0, 0);
                this.dbj = this.dbh.fY();
                if (this.dbj != null && this.dbj.rq != null && (list = this.dbj.rq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dbh.fY().retBytes;
                this.responseCode = this.dbh.fY().responseCode;
                this.errorCode = this.dbh.fY().mNetErrorCode;
                this.dbr = this.dbh.fY().gg();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.dbh.fY().contentEncoding != null && this.dbh.fY().contentEncoding.toLowerCase().contains("gzip")) {
                    this.dbm = true;
                }
                if (!this.dbr) {
                    f(str, null);
                }
                this.dbn = this.dbh.ga();
                if (this.dbn != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dbn;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dbn;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.dbn = this.dbh.ga();
                if (this.dbn != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dbn;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dbn;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.dbn = this.dbh.ga();
            if (this.dbn != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.dbn;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.dbn;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] tF(String str) {
        return tE(str);
    }

    private boolean aGO() {
        if (this.dbj.rp) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = dbu + 1;
            dbu = i;
            if (i >= 5) {
                dbu = 0;
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
                int i3 = dbo + 1;
                dbo = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (dbo == 1) {
                        dbq = this.errorCode;
                    }
                    dbp++;
                }
                if (dbo == 2) {
                    s.a("A2T", dbq, this.errorCode, dbp);
                }
                if (true == aGO()) {
                    this.mUseHttpClient = true;
                    this.dbt = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    dbp = 0;
                    dbo = 0;
                    dbq = 0;
                }
                if (tE == null) {
                    return null;
                }
                if (this.dbh != null && this.dbh.fY().rq != null) {
                    List<String> list2 = this.dbh.fY().rq.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.dbh.fY().rq.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.dbh.fY().rq.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.dbs = false;
                            i = i2;
                            return (this.dbr || (!z && i == 0) || !new String(tE, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? tE : l(tE, 23, tE.length);
                        }
                        this.dbs = true;
                    }
                }
                i = i2;
                if (this.dbr) {
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
                if (this.dbl != null) {
                    cancel();
                }
                this.dbh = new com.baidu.adp.lib.network.http.e();
                this.dbl = new f(this.dbh);
                this.dbh.fX().setUrl(str);
                if (this.dbi != null) {
                    for (Map.Entry<String, String> entry : this.dbi.entrySet()) {
                        this.dbh.fX().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.dbl.m(null, null, -1);
                this.dbj = this.dbh.fY();
                if (this.dbj != null && this.dbj.rq != null && (list = this.dbj.rq.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.dbh.fY().retBytes;
                this.responseCode = this.dbh.fY().responseCode;
                this.errorCode = this.dbh.fY().mNetErrorCode;
                this.dbr = this.dbh.fY().gg();
                if (this.mUseHttpAutoSwitch && true == aGO()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    dbp = 0;
                    dbo = 0;
                    dbq = 0;
                }
                if (this.dbt) {
                    int i4 = dbo + 1;
                    dbo = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        dbp++;
                        if (dbo == 1) {
                            dbq = this.errorCode;
                        }
                    }
                    if (dbo == 2) {
                        s.a("T2A", dbq, this.errorCode, dbp);
                        this.dbt = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.dbl.isGif();
                this.dbs = this.dbl.aGL();
                int size = this.dbh.fZ().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.dbh.fZ().get(i2) != null) {
                            sb.append(this.dbh.fZ().get(i2).qR);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dbn = this.dbh.ga();
                if (this.dbn != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.dbn;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.dbn;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.dbn;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.dbh.fZ().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.dbh.fZ().get(i2) != null) {
                            sb.append(this.dbh.fZ().get(i2).qR);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.dbn = this.dbh.ga();
                if (this.dbn != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.dbn;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.dbn;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.dbn;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.dbh.fZ().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.dbh.fZ().get(i2) != null) {
                        sb.append(this.dbh.fZ().get(i2).qR);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.dbn = this.dbh.ga();
            if (this.dbn != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.dbn;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.dbn;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.dbn;
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
            for (int i = 0; i < this.dbh.fZ().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.dbh.fZ().get(i);
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
            this.dbr = false;
        }
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.nG != null) {
            this.nG.cancel();
        }
        if (this.dbl != null) {
            this.dbl.cancel();
            this.dbl = null;
        }
    }

    public boolean aGP() {
        if (this.dbl == null) {
            return false;
        }
        return this.dbl.dbb;
    }
}
