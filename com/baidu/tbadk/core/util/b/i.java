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
    private static int fdN = 5;
    private static int fdR = 0;
    private static int fdS = 0;
    private static int fdT = 0;
    private static int fdX = 0;
    private com.baidu.adp.lib.network.http.e fdK;
    private f fdO;
    private volatile com.baidu.adp.lib.network.http.c Kj = null;
    private HashMap<String, String> fdL = null;
    private com.baidu.adp.lib.network.http.g fdM = new com.baidu.adp.lib.network.http.g();
    public boolean fdP = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d fdQ = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean fdU = false;
    public boolean fdV = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean fdW = false;

    public boolean btl() {
        return this.fdU;
    }

    public com.baidu.adp.lib.network.http.g lV() {
        return this.fdM;
    }

    public void rf() {
        this.fdQ = null;
        this.exception = "";
        this.fdU = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.fdP = false;
    }

    public boolean btm() {
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Bu(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rf();
                if (this.fdK != null) {
                    cancel();
                    this.Kj = null;
                }
                this.fdK = new com.baidu.adp.lib.network.http.e();
                this.fdK.lU().setUrl(str);
                this.fdK.lU().ai(UseHttpAutoRetrySwitch.isOn());
                if (this.fdL != null) {
                    for (Map.Entry<String, String> entry : this.fdL.entrySet()) {
                        this.fdK.lU().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.Kj = new com.baidu.adp.lib.network.http.c(this.fdK);
                this.Kj.d(fdN, 0, 0);
                this.fdM = this.fdK.lV();
                if (this.fdM != null && this.fdM.Oe != null && (list = this.fdM.Oe.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.fdK.lV().retBytes;
                this.responseCode = this.fdK.lV().responseCode;
                this.errorCode = this.fdK.lV().mNetErrorCode;
                this.fdU = this.fdK.lV().md();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.fdK.lV().contentEncoding != null && this.fdK.lV().contentEncoding.toLowerCase().contains("gzip")) {
                    this.fdP = true;
                }
                if (!this.fdU) {
                    e(str, null);
                }
                this.fdQ = this.fdK.lX();
                if (this.fdQ != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fdQ;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fdQ;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.fdQ = this.fdK.lX();
                if (this.fdQ != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fdQ;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fdQ;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.fdQ = this.fdK.lX();
            if (this.fdQ != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.fdQ;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.fdQ;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Bv(String str) {
        return Bu(str);
    }

    private boolean btn() {
        if (this.fdM.Od) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = fdX + 1;
            fdX = i;
            if (i >= 5) {
                fdX = 0;
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
                byte[] Bu = Bu(str);
                int i3 = fdR + 1;
                fdR = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (fdR == 1) {
                        fdT = this.errorCode;
                    }
                    fdS++;
                }
                if (fdR == 2) {
                    u.b("A2T", fdT, this.errorCode, fdS);
                }
                if (btn()) {
                    this.mUseHttpClient = true;
                    this.fdW = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    fdS = 0;
                    fdR = 0;
                    fdT = 0;
                }
                if (Bu == null) {
                    return null;
                }
                if (this.fdK != null && this.fdK.lV().Oe != null) {
                    List<String> list2 = this.fdK.lV().Oe.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.fdK.lV().Oe.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if (DownloadConstants.MIMETYPE_GIF.equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.fdK.lV().Oe.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.fdV = false;
                            i = i2;
                            return (this.fdU || (!z && i == 0) || !new String(Bu, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Bu : r(Bu, 23, Bu.length);
                        }
                        this.fdV = true;
                    }
                }
                i = i2;
                if (this.fdU) {
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
                if (this.fdO != null) {
                    cancel();
                }
                this.fdK = new com.baidu.adp.lib.network.http.e();
                this.fdO = new f(this.fdK);
                this.fdK.lU().setUrl(str);
                if (this.fdL != null) {
                    for (Map.Entry<String, String> entry : this.fdL.entrySet()) {
                        this.fdK.lU().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.fdO.q(null, null, -1);
                this.fdM = this.fdK.lV();
                if (this.fdM != null && this.fdM.Oe != null && (list = this.fdM.Oe.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.fdK.lV().retBytes;
                this.responseCode = this.fdK.lV().responseCode;
                this.errorCode = this.fdK.lV().mNetErrorCode;
                this.fdU = this.fdK.lV().md();
                if (this.mUseHttpAutoSwitch && true == btn()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    fdS = 0;
                    fdR = 0;
                    fdT = 0;
                }
                if (this.fdW) {
                    int i4 = fdR + 1;
                    fdR = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        fdS++;
                        if (fdR == 1) {
                            fdT = this.errorCode;
                        }
                    }
                    if (fdR == 2) {
                        u.b("T2A", fdT, this.errorCode, fdS);
                        this.fdW = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.fdO.isGif();
                this.fdV = this.fdO.btk();
                int size = this.fdK.lW().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.fdK.lW().get(i2) != null) {
                            sb.append(this.fdK.lW().get(i2).Nz);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fdQ = this.fdK.lX();
                if (this.fdQ != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.fdQ;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.fdQ;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.fdQ;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
                int size2 = this.fdK.lW().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.fdK.lW().get(i2) != null) {
                            sb.append(this.fdK.lW().get(i2).Nz);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.fdQ = this.fdK.lX();
                if (this.fdQ != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.fdQ;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.fdQ;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.fdQ;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.fdK.lW().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.fdK.lW().get(i2) != null) {
                        sb.append(this.fdK.lW().get(i2).Nz);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.fdQ = this.fdK.lX();
            if (this.fdQ != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.fdQ;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.fdQ;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.fdQ;
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
            for (int i = 0; i < this.fdK.lW().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.fdK.lW().get(i);
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
                stringBuffer.append(dVar.Nv);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Nx);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Nw);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Ny);
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
            this.fdU = false;
        }
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.Kj != null) {
            this.Kj.cancel();
        }
        if (this.fdO != null) {
            this.fdO.cancel();
            this.fdO = null;
        }
    }

    public boolean bto() {
        if (this.fdO == null) {
            return false;
        }
        return this.fdO.fdE;
    }
}
