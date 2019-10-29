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
    private static int cle = 5;
    private static int cli = 0;
    private static int clj = 0;
    private static int clk = 0;
    private static int clo = 0;
    private com.baidu.adp.lib.network.http.e clb;
    private f clf;
    private volatile com.baidu.adp.lib.network.http.c lK = null;
    private HashMap<String, String> clc = null;
    private com.baidu.adp.lib.network.http.g cld = new com.baidu.adp.lib.network.http.g();
    public boolean clg = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d clh = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean cll = false;
    public boolean clm = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean cln = false;

    public boolean amZ() {
        return this.cll;
    }

    public com.baidu.adp.lib.network.http.g fK() {
        return this.cld;
    }

    public void kr() {
        this.clh = null;
        this.exception = "";
        this.cll = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.clg = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] nZ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                kr();
                if (this.clb != null) {
                    cancel();
                    this.lK = null;
                }
                this.clb = new com.baidu.adp.lib.network.http.e();
                this.clb.fJ().setUrl(str);
                this.clb.fJ().D(bo.isOn());
                if (this.clc != null) {
                    for (Map.Entry<String, String> entry : this.clc.entrySet()) {
                        this.clb.fJ().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.lK = new com.baidu.adp.lib.network.http.c(this.clb);
                this.lK.c(cle, 0, 0);
                this.cld = this.clb.fK();
                byte[] bArr = this.clb.fK().retBytes;
                this.responseCode = this.clb.fK().responseCode;
                this.errorCode = this.clb.fK().mNetErrorCode;
                this.cll = this.clb.fK().fR();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.clb.fK().contentEncoding != null && this.clb.fK().contentEncoding.toLowerCase().contains("gzip")) {
                    this.clg = true;
                }
                if (!this.cll) {
                    e(str, null);
                }
                this.clh = this.clb.fM();
                if (this.clh != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.clh;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.clh;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.clh = this.clb.fM();
                if (this.clh != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.clh;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.clh;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.clh = this.clb.fM();
            if (this.clh != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.clh;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.clh;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] oa(String str) {
        return nZ(str);
    }

    private boolean ana() {
        if (this.cld.pz) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = clo + 1;
            clo = i;
            if (i >= 5) {
                clo = 0;
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
                int i3 = cli + 1;
                cli = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (cli == 1) {
                        clk = this.errorCode;
                    }
                    clj++;
                }
                if (cli == 2) {
                    s.a("A2T", clk, this.errorCode, clj);
                }
                if (true == ana()) {
                    this.mUseHttpClient = true;
                    this.cln = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    clj = 0;
                    cli = 0;
                    clk = 0;
                }
                if (nZ == null) {
                    return null;
                }
                if (this.clb != null && this.clb.fK().pA != null) {
                    List<String> list = this.clb.fK().pA.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.clb.fK().pA.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.clb.fK().pA.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.clm = false;
                            i = i2;
                            return (this.cll || (!z && i == 0) || !new String(nZ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? nZ : i(nZ, 23, nZ.length);
                        }
                        this.clm = true;
                    }
                }
                i = i2;
                if (this.cll) {
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
                if (this.clf != null) {
                    cancel();
                }
                this.clb = new com.baidu.adp.lib.network.http.e();
                this.clf = new f(this.clb);
                this.clb.fJ().setUrl(str);
                if (this.clc != null) {
                    for (Map.Entry<String, String> entry : this.clc.entrySet()) {
                        this.clb.fJ().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.clf.i(null, null, -1);
                this.cld = this.clb.fK();
                byte[] bArr = this.clb.fK().retBytes;
                this.responseCode = this.clb.fK().responseCode;
                this.errorCode = this.clb.fK().mNetErrorCode;
                this.cll = this.clb.fK().fR();
                if (this.mUseHttpAutoSwitch && true == ana()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    clj = 0;
                    cli = 0;
                    clk = 0;
                }
                if (this.cln) {
                    int i4 = cli + 1;
                    cli = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        clj++;
                        if (cli == 1) {
                            clk = this.errorCode;
                        }
                    }
                    if (cli == 2) {
                        s.a("T2A", clk, this.errorCode, clj);
                        this.cln = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.clf.isGif();
                this.clm = this.clf.amY();
                int size = this.clb.fL().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.clb.fL().get(i2) != null) {
                            sb.append(this.clb.fL().get(i2).pa);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.clh = this.clb.fM();
                if (this.clh != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.clh;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.clh;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.clh;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Throwable th) {
                int size2 = this.clb.fL().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.clb.fL().get(i2) != null) {
                            sb.append(this.clb.fL().get(i2).pa);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.clh = this.clb.fM();
                if (this.clh != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.clh;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.clh;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.clh;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                throw th;
            }
        } catch (Exception e2) {
            sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
            int size3 = this.clb.fL().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.clb.fL().get(i2) != null) {
                        sb.append(this.clb.fL().get(i2).pa);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.clh = this.clb.fM();
            if (this.clh != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.clh;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.clh;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.clh;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            return null;
        }
    }

    private static byte[] i(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.clb.fL().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.clb.fL().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.exception);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.oV);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.downloadSize);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.oU);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.oX);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.oY);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.oW);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.oZ);
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
            this.cll = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.lK != null) {
            this.lK.cancel();
        }
        if (this.clf != null) {
            this.clf.cancel();
            this.clf = null;
        }
    }

    public boolean anb() {
        if (this.clf == null) {
            return false;
        }
        return this.clf.ckV;
    }
}
