package com.baidu.tbadk.core.util.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.e.b;
import com.baidu.down.manage.DownloadConstants;
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
public class i implements b.a {
    private static int fcn = 5;
    private static int fcs = 0;
    private static int fct = 0;
    private static int fcu = 0;
    private static int fcy = 0;
    private com.baidu.adp.lib.network.http.e fck;
    private f fco;
    private volatile com.baidu.adp.lib.network.http.c IQ = null;
    private HashMap<String, String> fcl = null;
    private com.baidu.adp.lib.network.http.g fcm = new com.baidu.adp.lib.network.http.g();
    public boolean fcq = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d fcr = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean fcv = false;
    public boolean fcw = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean fcx = false;

    public boolean bti() {
        return this.fcv;
    }

    public com.baidu.adp.lib.network.http.g lV() {
        return this.fcm;
    }

    public void rf() {
        this.fcr = null;
        this.exception = "";
        this.fcv = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.fcq = false;
    }

    public boolean btj() {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Bn(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rf();
                if (this.fck != null) {
                    cancel();
                    this.IQ = null;
                }
                this.fck = new com.baidu.adp.lib.network.http.e();
                this.fck.lU().setUrl(str);
                this.fck.lU().ai(UseHttpAutoRetrySwitch.isOn());
                if (this.fcl != null) {
                    for (Map.Entry<String, String> entry : this.fcl.entrySet()) {
                        this.fck.lU().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.IQ = new com.baidu.adp.lib.network.http.c(this.fck);
                this.IQ.d(fcn, 0, 0);
                this.fcm = this.fck.lV();
                if (this.fcm != null && this.fcm.ME != null && (list = this.fcm.ME.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.fck.lV().retBytes;
                this.responseCode = this.fck.lV().responseCode;
                this.errorCode = this.fck.lV().mNetErrorCode;
                this.fcv = this.fck.lV().md();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.fck.lV().contentEncoding != null && this.fck.lV().contentEncoding.toLowerCase().contains("gzip")) {
                    this.fcq = true;
                }
                if (!this.fcv) {
                    e(str, null);
                }
                this.fcr = this.fck.lX();
                if (this.fcr != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fcr;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fcr;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.fcr = this.fck.lX();
                if (this.fcr != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fcr;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fcr;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.fcr = this.fck.lX();
            if (this.fcr != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.fcr;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.fcr;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Bo(String str) {
        return Bn(str);
    }

    private boolean btk() {
        if (this.fcm.MD) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = fcy + 1;
            fcy = i;
            if (i >= 5) {
                fcy = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [353=6] */
    public byte[] aw(String str, boolean z) {
        int i;
        String str2;
        List<String> list;
        int i2 = 0;
        this.needCache = true;
        if (!this.mUseHttpClient || UseHttpdnsSdkSwitch.isOn()) {
            try {
                byte[] Bn = Bn(str);
                int i3 = fcs + 1;
                fcs = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (fcs == 1) {
                        fcu = this.errorCode;
                    }
                    fct++;
                }
                if (fcs == 2) {
                    u.b("A2T", fcu, this.errorCode, fct);
                }
                if (btk()) {
                    this.mUseHttpClient = true;
                    this.fcx = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    fct = 0;
                    fcs = 0;
                    fcu = 0;
                }
                if (Bn == null) {
                    return null;
                }
                if (this.fck != null && this.fck.lV().ME != null) {
                    List<String> list2 = this.fck.lV().ME.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.fck.lV().ME.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if (DownloadConstants.MIMETYPE_GIF.equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.fck.lV().ME.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.fcw = false;
                            i = i2;
                            return (this.fcv || (!z && i == 0) || !new String(Bn, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Bn : r(Bn, 23, Bn.length);
                        }
                        this.fcw = true;
                    }
                }
                i = i2;
                if (this.fcv) {
                }
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                rf();
                if (this.fco != null) {
                    cancel();
                }
                this.fck = new com.baidu.adp.lib.network.http.e();
                this.fco = new f(this.fck);
                this.fck.lU().setUrl(str);
                if (this.fcl != null) {
                    for (Map.Entry<String, String> entry : this.fcl.entrySet()) {
                        this.fck.lU().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.fco.q(null, null, -1);
                this.fcm = this.fck.lV();
                if (this.fcm != null && this.fcm.ME != null && (list = this.fcm.ME.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.fck.lV().retBytes;
                this.responseCode = this.fck.lV().responseCode;
                this.errorCode = this.fck.lV().mNetErrorCode;
                this.fcv = this.fck.lV().md();
                if (this.mUseHttpAutoSwitch && true == btk()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    fct = 0;
                    fcs = 0;
                    fcu = 0;
                }
                if (this.fcx) {
                    int i4 = fcs + 1;
                    fcs = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        fct++;
                        if (fcs == 1) {
                            fcu = this.errorCode;
                        }
                    }
                    if (fcs == 2) {
                        u.b("T2A", fcu, this.errorCode, fct);
                        this.fcx = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.fco.isGif();
                this.fcw = this.fco.bth();
                int size = this.fck.lW().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.fck.lW().get(i2) != null) {
                            sb.append(this.fck.lW().get(i2).Me);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fcr = this.fck.lX();
                if (this.fcr != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fcr;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fcr;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fcr;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
                int size2 = this.fck.lW().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.fck.lW().get(i2) != null) {
                            sb.append(this.fck.lW().get(i2).Me);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fcr = this.fck.lX();
                if (this.fcr != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fcr;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.fcr;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.fcr;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.fck.lW().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.fck.lW().get(i2) != null) {
                        sb.append(this.fck.lW().get(i2).Me);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.fcr = this.fck.lX();
            if (this.fcr != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.fcr;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.fcr;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.fcr;
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
            for (int i = 0; i < this.fck.lW().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.fck.lW().get(i);
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
                stringBuffer.append(dVar.Ma);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Mc);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Mb);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Md);
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
            this.fcv = false;
        }
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.IQ != null) {
            this.IQ.cancel();
        }
        if (this.fco != null) {
            this.fco.cancel();
            this.fco = null;
        }
    }

    public boolean btl() {
        if (this.fco == null) {
            return false;
        }
        return this.fco.fce;
    }
}
