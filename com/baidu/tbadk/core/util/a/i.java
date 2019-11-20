package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.t.bo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0016a {
    private static int ckn = 5;
    private static int ckr = 0;
    private static int cks = 0;
    private static int ckt = 0;
    private static int ckx = 0;
    private com.baidu.adp.lib.network.http.e ckk;
    private f cko;
    private volatile com.baidu.adp.lib.network.http.c li = null;
    private HashMap<String, String> ckl = null;
    private com.baidu.adp.lib.network.http.g ckm = new com.baidu.adp.lib.network.http.g();
    public boolean ckp = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d ckq = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean cku = false;
    public boolean ckv = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean ckw = false;

    public boolean amX() {
        return this.cku;
    }

    public com.baidu.adp.lib.network.http.g fK() {
        return this.ckm;
    }

    public void kr() {
        this.ckq = null;
        this.exception = "";
        this.cku = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.ckp = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] nZ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                kr();
                if (this.ckk != null) {
                    cancel();
                    this.li = null;
                }
                this.ckk = new com.baidu.adp.lib.network.http.e();
                this.ckk.fJ().setUrl(str);
                this.ckk.fJ().D(bo.isOn());
                if (this.ckl != null) {
                    for (Map.Entry<String, String> entry : this.ckl.entrySet()) {
                        this.ckk.fJ().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.li = new com.baidu.adp.lib.network.http.c(this.ckk);
                this.li.c(ckn, 0, 0);
                this.ckm = this.ckk.fK();
                byte[] bArr = this.ckk.fK().retBytes;
                this.responseCode = this.ckk.fK().responseCode;
                this.errorCode = this.ckk.fK().mNetErrorCode;
                this.cku = this.ckk.fK().fR();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.ckk.fK().contentEncoding != null && this.ckk.fK().contentEncoding.toLowerCase().contains("gzip")) {
                    this.ckp = true;
                }
                if (!this.cku) {
                    e(str, null);
                }
                this.ckq = this.ckk.fM();
                if (this.ckq != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ckq;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ckq;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.ckq = this.ckk.fM();
                if (this.ckq != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ckq;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ckq;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.ckq = this.ckk.fM();
            if (this.ckq != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.ckq;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.ckq;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] oa(String str) {
        return nZ(str);
    }

    private boolean amY() {
        if (this.ckm.oT) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = ckx + 1;
            ckx = i;
            if (i >= 5) {
                ckx = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [333=6] */
    public byte[] P(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient || bo.isOn()) {
            try {
                if (com.baidu.adp.lib.b.d.ft().af("need_more_logs") == 1) {
                    s.p("httpManager", str, "", "");
                }
                byte[] nZ = nZ(str);
                int i3 = ckr + 1;
                ckr = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ckr == 1) {
                        ckt = this.errorCode;
                    }
                    cks++;
                }
                if (ckr == 2) {
                    s.a("A2T", ckt, this.errorCode, cks);
                }
                if (true == amY()) {
                    this.mUseHttpClient = true;
                    this.ckw = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    cks = 0;
                    ckr = 0;
                    ckt = 0;
                }
                if (nZ == null) {
                    return null;
                }
                if (this.ckk != null && this.ckk.fK().oU != null) {
                    List<String> list = this.ckk.fK().oU.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.ckk.fK().oU.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.ckk.fK().oU.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ckv = false;
                            i = i2;
                            return (this.cku || (!z && i == 0) || !new String(nZ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? nZ : g(nZ, 23, nZ.length);
                        }
                        this.ckv = true;
                    }
                }
                i = i2;
                if (this.cku) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (com.baidu.adp.lib.b.d.ft().af("need_more_logs") == 1) {
            s.p("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                kr();
                if (this.cko != null) {
                    cancel();
                }
                this.ckk = new com.baidu.adp.lib.network.http.e();
                this.cko = new f(this.ckk);
                this.ckk.fJ().setUrl(str);
                if (this.ckl != null) {
                    for (Map.Entry<String, String> entry : this.ckl.entrySet()) {
                        this.ckk.fJ().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.cko.i(null, null, -1);
                this.ckm = this.ckk.fK();
                byte[] bArr = this.ckk.fK().retBytes;
                this.responseCode = this.ckk.fK().responseCode;
                this.errorCode = this.ckk.fK().mNetErrorCode;
                this.cku = this.ckk.fK().fR();
                if (this.mUseHttpAutoSwitch && true == amY()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    cks = 0;
                    ckr = 0;
                    ckt = 0;
                }
                if (this.ckw) {
                    int i4 = ckr + 1;
                    ckr = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        cks++;
                        if (ckr == 1) {
                            ckt = this.errorCode;
                        }
                    }
                    if (ckr == 2) {
                        s.a("T2A", ckt, this.errorCode, cks);
                        this.ckw = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.cko.isGif();
                this.ckv = this.cko.amW();
                int size = this.ckk.fL().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.ckk.fL().get(i2) != null) {
                            sb.append(this.ckk.fL().get(i2).oB);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.ckq = this.ckk.fM();
                if (this.ckq != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.ckq;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.ckq;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.ckq;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.ckk.fL().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.ckk.fL().get(i2) != null) {
                            sb.append(this.ckk.fL().get(i2).oB);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.ckq = this.ckk.fM();
                if (this.ckq != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.ckq;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.ckq;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.ckq;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.ckk.fL().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.ckk.fL().get(i2) != null) {
                        sb.append(this.ckk.fL().get(i2).oB);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.ckq = this.ckk.fM();
            if (this.ckq != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.ckq;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.ckq;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.ckq;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] g(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.ckk.fL().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.ckk.fL().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.exception);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.ow);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.downloadSize);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ov);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.oy);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.oz);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.ox);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.oA);
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
            this.cku = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.li != null) {
            this.li.cancel();
        }
        if (this.cko != null) {
            this.cko.cancel();
            this.cko = null;
        }
    }

    public boolean amZ() {
        if (this.cko == null) {
            return false;
        }
        return this.cko.cke;
    }
}
