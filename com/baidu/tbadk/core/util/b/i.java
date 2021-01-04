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
    private static int feH = 5;
    private static int feL = 0;
    private static int feM = 0;
    private static int feN = 0;
    private static int feR = 0;
    private com.baidu.adp.lib.network.http.e feE;
    private f feI;
    private volatile com.baidu.adp.lib.network.http.c IT = null;
    private HashMap<String, String> feF = null;
    private com.baidu.adp.lib.network.http.g feG = new com.baidu.adp.lib.network.http.g();
    public boolean feJ = false;
    public boolean isGif = false;
    public String exception = "";
    public com.baidu.adp.lib.network.http.d feK = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean needCache = true;
    private boolean feO = false;
    public boolean feP = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean feQ = false;

    public boolean bwH() {
        return this.feO;
    }

    public com.baidu.adp.lib.network.http.g lW() {
        return this.feG;
    }

    public void rh() {
        this.feK = null;
        this.exception = "";
        this.feO = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.feJ = false;
    }

    public boolean bwI() {
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] Ci(String str) {
        List<String> list;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                rh();
                if (this.feE != null) {
                    cancel();
                    this.IT = null;
                }
                this.feE = new com.baidu.adp.lib.network.http.e();
                this.feE.lV().setUrl(str);
                this.feE.lV().ai(UseHttpAutoRetrySwitch.isOn());
                if (this.feF != null) {
                    for (Map.Entry<String, String> entry : this.feF.entrySet()) {
                        this.feE.lV().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.IT = new com.baidu.adp.lib.network.http.c(this.feE);
                this.IT.d(feH, 0, 0);
                this.feG = this.feE.lW();
                if (this.feG != null && this.feG.MI != null && (list = this.feG.MI.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.feE.lW().retBytes;
                this.responseCode = this.feE.lW().responseCode;
                this.errorCode = this.feE.lW().mNetErrorCode;
                this.feO = this.feE.lW().me();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.feE.lW().contentEncoding != null && this.feE.lW().contentEncoding.toLowerCase().contains("gzip")) {
                    this.feJ = true;
                }
                if (!this.feO) {
                    e(str, null);
                }
                this.feK = this.feE.lY();
                if (this.feK != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.feK;
                    dVar.exception = sb.append(dVar.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.feK;
                    dVar2.exception = sb2.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e.getMessage());
                this.feK = this.feE.lY();
                if (this.feK != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.feK;
                    dVar3.exception = sb3.append(dVar3.exception).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.feK;
                    dVar4.exception = sb4.append(dVar4.exception).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.feK = this.feE.lY();
            if (this.feK != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.feK;
                dVar5.exception = sb5.append(dVar5.exception).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.feK;
                dVar6.exception = sb6.append(dVar6.exception).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    public byte[] Cj(String str) {
        return Ci(str);
    }

    private boolean bwJ() {
        if (this.feG.MH) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = feR + 1;
            feR = i;
            if (i >= 5) {
                feR = 0;
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
                byte[] Ci = Ci(str);
                int i3 = feL + 1;
                feL = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (feL == 1) {
                        feN = this.errorCode;
                    }
                    feM++;
                }
                if (feL == 2) {
                    t.b("A2T", feN, this.errorCode, feM);
                }
                if (bwJ()) {
                    this.mUseHttpClient = true;
                    this.feQ = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    feM = 0;
                    feL = 0;
                    feN = 0;
                }
                if (Ci == null) {
                    return null;
                }
                if (this.feE != null && this.feE.lW().MI != null) {
                    List<String> list2 = this.feE.lW().MI.get("imgsrc");
                    if (list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list3 = this.feE.lW().MI.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if (DownloadConstants.MIMETYPE_GIF.equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.feE.lW().MI.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.feP = false;
                            i = i2;
                            return (this.feO || (!z && i == 0) || !new String(Ci, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? Ci : s(Ci, 23, Ci.length);
                        }
                        this.feP = true;
                    }
                }
                i = i2;
                if (this.feO) {
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
                if (this.feI != null) {
                    cancel();
                }
                this.feE = new com.baidu.adp.lib.network.http.e();
                this.feI = new f(this.feE);
                this.feE.lV().setUrl(str);
                if (this.feF != null) {
                    for (Map.Entry<String, String> entry : this.feF.entrySet()) {
                        this.feE.lV().addPostData(entry.getKey(), entry.getValue());
                    }
                }
                this.feI.q(null, null, -1);
                this.feG = this.feE.lW();
                if (this.feG != null && this.feG.MI != null && (list = this.feG.MI.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.feE.lW().retBytes;
                this.responseCode = this.feE.lW().responseCode;
                this.errorCode = this.feE.lW().mNetErrorCode;
                this.feO = this.feE.lW().me();
                if (this.mUseHttpAutoSwitch && true == bwJ()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    feM = 0;
                    feL = 0;
                    feN = 0;
                }
                if (this.feQ) {
                    int i4 = feL + 1;
                    feL = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        feM++;
                        if (feL == 1) {
                            feN = this.errorCode;
                        }
                    }
                    if (feL == 2) {
                        t.b("T2A", feN, this.errorCode, feM);
                        this.feQ = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.feI.isGif();
                this.feP = this.feI.bwG();
                int size = this.feE.lX().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.feE.lX().get(i2) != null) {
                            sb.append(this.feE.lX().get(i2).Mi);
                        }
                        if (i2 != size - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.feK = this.feE.lY();
                if (this.feK != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.feK;
                    dVar.exception = sb2.append(dVar.exception).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.feK;
                    dVar2.exception = sb3.append(dVar2.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.feK;
                    dVar3.exception = sb4.append(dVar3.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e2.getMessage());
                int size2 = this.feE.lX().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.feE.lX().get(i2) != null) {
                            sb.append(this.feE.lX().get(i2).Mi);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        }
                        i2++;
                    }
                }
                this.feK = this.feE.lY();
                if (this.feK != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.feK;
                    dVar4.exception = sb5.append(dVar4.exception).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.feK;
                    dVar5.exception = sb6.append(dVar5.exception).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.feK;
                    dVar6.exception = sb7.append(dVar6.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.feE.lX().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.feE.lX().get(i2) != null) {
                        sb.append(this.feE.lX().get(i2).Mi);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    i2++;
                }
            }
            this.feK = this.feE.lY();
            if (this.feK != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.feK;
                dVar7.exception = sb8.append(dVar7.exception).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.feK;
                dVar8.exception = sb9.append(dVar8.exception).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.feK;
                dVar9.exception = sb10.append(dVar9.exception).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            throw th;
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
            for (int i = 0; i < this.feE.lX().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.feE.lX().get(i);
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
                stringBuffer.append(dVar.Me);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.dnsTime);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.Mg);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Mf);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.Mh);
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
            this.feO = false;
        }
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.IT != null) {
            this.IT.cancel();
        }
        if (this.feI != null) {
            this.feI.cancel();
            this.feI = null;
        }
    }

    public boolean bwK() {
        if (this.feI == null) {
            return false;
        }
        return this.feI.fey;
    }
}
