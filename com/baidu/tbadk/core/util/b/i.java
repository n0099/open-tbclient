package com.baidu.tbadk.core.util.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.b;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements b.a {
    private static int eZY = 5;
    private static int fac = 0;
    private static int fad = 0;
    private static int fae = 0;
    private static int fai = 0;
    private com.baidu.adp.lib.network.http.e eZV;
    private f eZZ;
    private volatile com.baidu.adp.lib.network.http.c IR = null;
    private HashMap<String, String> eZW = null;
    private com.baidu.adp.lib.network.http.g eZX = new com.baidu.adp.lib.network.http.g();
    public boolean faa = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d fab = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean faf = false;
    public boolean fag = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean fah = false;

    public boolean bsO() {
        return this.faf;
    }

    public com.baidu.adp.lib.network.http.g lW() {
        return this.eZX;
    }

    public void rh() {
        this.fab = null;
        this.exception = "";
        this.faf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.faa = false;
    }

    public boolean bsP() {
        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] AW(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rh();
                if (this.eZV != null) {
                    cancel();
                    this.IR = null;
                }
                this.eZV = new com.baidu.adp.lib.network.http.e();
                this.eZV.lV().setUrl(str);
                this.eZV.lV().ai(UseHttpAutoRetrySwitch.isOn());
                if (this.eZW != null) {
                    for (Map.Entry<String, String> entry : this.eZW.entrySet()) {
                        this.eZV.lV().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.IR = new com.baidu.adp.lib.network.http.c(this.eZV);
                this.IR.d(eZY, 0, 0);
                this.eZX = this.eZV.lW();
                if (this.eZX != null && this.eZX.MG != null && (list = this.eZX.MG.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eZV.lW().retBytes;
                this.responseCode = this.eZV.lW().responseCode;
                this.errorCode = this.eZV.lW().mNetErrorCode;
                this.faf = this.eZV.lW().me();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.eZV.lW().contentEncoding != null && this.eZV.lW().contentEncoding.toLowerCase().contains("gzip")) {
                    this.faa = true;
                }
                if (!this.faf) {
                    e(str, null);
                }
                this.fab = this.eZV.lY();
                if (this.fab != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fab;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fab;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.fab = this.eZV.lY();
                if (this.fab != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fab;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fab;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.fab = this.eZV.lY();
            if (this.fab != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.fab;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.fab;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] AX(String str) {
        return AW(str);
    }

    private boolean bsQ() {
        if (this.eZX.MF) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = fai + 1;
            fai = i;
            if (i >= 5) {
                fai = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [353=6] */
    public byte[] ax(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                byte[] AW = AW(str);
                int i3 = fac + 1;
                fac = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (fac == 1) {
                        fae = this.errorCode;
                    }
                    fad++;
                }
                if (fac == 2) {
                    t.b("A2T", fae, this.errorCode, fad);
                }
                if (bsQ()) {
                    this.mUseHttpClient = true;
                    this.fah = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    fad = 0;
                    fac = 0;
                    fae = 0;
                }
                if (AW == null) {
                    return null;
                }
                if (this.eZV != null && this.eZV.lW().MG != null) {
                    List<String> list2 = this.eZV.lW().MG.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.eZV.lW().MG.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if (DownloadConstants.MIMETYPE_GIF.equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.eZV.lW().MG.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.fag = false;
                            i = i2;
                            return (this.faf || (!z && i == 0) || !new String(AW, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? AW : r(AW, 23, AW.length);
                        }
                        this.fag = true;
                    }
                }
                i = i2;
                if (this.faf) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                rh();
                if (this.eZZ != null) {
                    cancel();
                }
                this.eZV = new com.baidu.adp.lib.network.http.e();
                this.eZZ = new f(this.eZV);
                this.eZV.lV().setUrl(str);
                if (this.eZW != null) {
                    for (Map.Entry<String, String> entry : this.eZW.entrySet()) {
                        this.eZV.lV().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.eZZ.q(null, null, -1);
                this.eZX = this.eZV.lW();
                if (this.eZX != null && this.eZX.MG != null && (list = this.eZX.MG.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.eZV.lW().retBytes;
                this.responseCode = this.eZV.lW().responseCode;
                this.errorCode = this.eZV.lW().mNetErrorCode;
                this.faf = this.eZV.lW().me();
                if (this.mUseHttpAutoSwitch && true == bsQ()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    fad = 0;
                    fac = 0;
                    fae = 0;
                }
                if (this.fah) {
                    int i4 = fac + 1;
                    fac = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        fad++;
                        if (fac == 1) {
                            fae = this.errorCode;
                        }
                    }
                    if (fac == 2) {
                        t.b("T2A", fae, this.errorCode, fad);
                        this.fah = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.eZZ.isGif();
                this.fag = this.eZZ.bsN();
                int size = this.eZV.lX().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.eZV.lX().get(i2) != null) {
                            sb.append(this.eZV.lX().get(i2).Mg);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fab = this.eZV.lY();
                if (this.fab != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fab;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fab;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fab;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
                int size2 = this.eZV.lX().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.eZV.lX().get(i2) != null) {
                            sb.append(this.eZV.lX().get(i2).Mg);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fab = this.eZV.lY();
                if (this.fab != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fab;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.fab;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.fab;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.eZV.lX().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.eZV.lX().get(i2) != null) {
                        sb.append(this.eZV.lX().get(i2).Mg);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.fab = this.eZV.lY();
            if (this.fab != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.fab;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.fab;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.fab;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            throw th;
        }
    }

    private static byte[] r(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.eZV.lX().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.eZV.lX().get(i);
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
                stringBuffer.append(dVar.Mc);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Me);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Md);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Mf);
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
            this.faf = false;
        }
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.IR != null) {
            this.IR.cancel();
        }
        if (this.eZZ != null) {
            this.eZZ.cancel();
            this.eZZ = null;
        }
    }

    public boolean bsR() {
        if (this.eZZ == null) {
            return false;
        }
        return this.eZZ.eZP;
    }
}
