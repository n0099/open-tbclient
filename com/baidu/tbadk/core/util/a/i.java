package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0016a {
    private static int bVn = 5;
    private static int bVr = 0;
    private static int bVs = 0;
    private static int bVt = 0;
    private static int bVx = 0;
    private com.baidu.adp.lib.network.http.e bVk;
    private f bVo;
    private volatile com.baidu.adp.lib.network.http.c tJ = null;
    private HashMap<String, String> bVl = null;
    private com.baidu.adp.lib.network.http.g bVm = new com.baidu.adp.lib.network.http.g();
    public boolean bVp = false;
    public boolean isGif = false;
    public String Az = "";
    public com.baidu.adp.lib.network.http.d bVq = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bVu = false;
    public boolean bVv = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bVw = false;

    public boolean ajN() {
        return this.bVu;
    }

    public com.baidu.adp.lib.network.http.g iv() {
        return this.bVm;
    }

    public void pv() {
        this.bVq = null;
        this.Az = "";
        this.bVu = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bVp = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] ow(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pv();
                if (this.bVk != null) {
                    cancel();
                    this.tJ = null;
                }
                this.bVk = new com.baidu.adp.lib.network.http.e();
                this.bVk.iu().setUrl(str);
                if (this.bVl != null) {
                    for (Map.Entry<String, String> entry : this.bVl.entrySet()) {
                        this.bVk.iu().o(entry.getKey(), entry.getValue());
                    }
                }
                this.tJ = new com.baidu.adp.lib.network.http.c(this.bVk);
                this.tJ.d(bVn, 0, 0);
                this.bVm = this.bVk.iv();
                byte[] bArr = this.bVk.iv().AU;
                this.responseCode = this.bVk.iv().responseCode;
                this.errorCode = this.bVk.iv().AR;
                this.bVu = this.bVk.iv().iB();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bVk.iv().contentEncoding != null && this.bVk.iv().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bVp = true;
                    bArr = H(bArr);
                }
                if (!this.bVu) {
                    e(str, null);
                }
                this.bVq = this.bVk.ix();
                if (this.bVq != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bVq;
                    dVar.Az = sb.append(dVar.Az).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bVq;
                    dVar2.Az = sb2.append(dVar2.Az).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bVq = this.bVk.ix();
                if (this.bVq != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bVq;
                    dVar3.Az = sb3.append(dVar3.Az).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bVq;
                    dVar4.Az = sb4.append(dVar4.Az).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bVq = this.bVk.ix();
            if (this.bVq != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bVq;
                dVar5.Az = sb5.append(dVar5.Az).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bVq;
                dVar6.Az = sb6.append(dVar6.Az).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] H(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] ox(String str) {
        return ow(str);
    }

    private boolean ajO() {
        if (this.bVm.AQ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bVx + 1;
            bVx = i;
            if (i >= 5) {
                bVx = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] O(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] ow = ow(str);
                int i3 = bVr + 1;
                bVr = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bVr == 1) {
                        bVt = this.errorCode;
                    }
                    bVs++;
                }
                if (bVr == 2) {
                    s.a("A2T", bVt, this.errorCode, bVs);
                }
                if (true == ajO()) {
                    this.mUseHttpClient = true;
                    this.bVw = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bVs = 0;
                    bVr = 0;
                    bVt = 0;
                }
                if (ow == null) {
                    return null;
                }
                if (this.bVk != null && this.bVk.iv().AT != null) {
                    List<String> list = this.bVk.iv().AT.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bVk.iv().AT.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bVk.iv().AT.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bVv = false;
                            i = i2;
                            return (this.bVu || (!z && i == 0) || !new String(ow, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? ow : k(ow, 23, ow.length);
                        }
                        this.bVv = true;
                    }
                }
                i = i2;
                if (this.bVu) {
                }
            } catch (Exception e) {
                this.Az += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pv();
                if (this.bVo != null) {
                    cancel();
                }
                this.bVk = new com.baidu.adp.lib.network.http.e();
                this.bVo = new f(this.bVk);
                this.bVk.iu().setUrl(str);
                if (this.bVl != null) {
                    for (Map.Entry<String, String> entry : this.bVl.entrySet()) {
                        this.bVk.iu().o(entry.getKey(), entry.getValue());
                    }
                }
                this.bVo.l(null, null, -1);
                this.bVm = this.bVk.iv();
                byte[] bArr = this.bVk.iv().AU;
                this.responseCode = this.bVk.iv().responseCode;
                this.errorCode = this.bVk.iv().AR;
                this.bVu = this.bVk.iv().iB();
                if (this.mUseHttpAutoSwitch && true == ajO()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bVs = 0;
                    bVr = 0;
                    bVt = 0;
                }
                if (this.bVw) {
                    int i4 = bVr + 1;
                    bVr = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bVs++;
                        if (bVr == 1) {
                            bVt = this.errorCode;
                        }
                    }
                    if (bVr == 2) {
                        s.a("T2A", bVt, this.errorCode, bVs);
                        this.bVw = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bVo.isGif();
                this.bVv = this.bVo.ajM();
                int size = this.bVk.iw().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bVk.iw().get(i2) != null) {
                            sb.append(this.bVk.iw().get(i2).AC);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bVq = this.bVk.ix();
                if (this.bVq != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bVq;
                    dVar.Az = sb2.append(dVar.Az).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bVq;
                    dVar2.Az = sb3.append(dVar2.Az).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bVq;
                    dVar3.Az = sb4.append(dVar3.Az).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bVk.iw().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bVk.iw().get(i2) != null) {
                            sb.append(this.bVk.iw().get(i2).AC);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bVq = this.bVk.ix();
                if (this.bVq != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bVq;
                    dVar4.Az = sb5.append(dVar4.Az).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bVq;
                    dVar5.Az = sb6.append(dVar5.Az).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bVq;
                    dVar6.Az = sb7.append(dVar6.Az).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bVk.iw().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bVk.iw().get(i2) != null) {
                        sb.append(this.bVk.iw().get(i2).AC);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bVq = this.bVk.ix();
            if (this.bVq != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bVq;
                dVar7.Az = sb8.append(dVar7.Az).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bVq;
                dVar8.Az = sb9.append(dVar8.Az).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bVq;
                dVar9.Az = sb10.append(dVar9.Az).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            throw th;
        }
    }

    private static byte[] k(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.bVk.iw().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bVk.iw().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.Az);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.Aw);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.Au);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.Av);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.Ay);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.AA);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.Ax);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.AB);
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
            this.Az = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.bVu = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.tJ != null) {
            this.tJ.cancel();
        }
        if (this.bVo != null) {
            this.bVo.cancel();
            this.bVo = null;
        }
    }

    public boolean ajP() {
        if (this.bVo == null) {
            return false;
        }
        return this.bVo.bUX;
    }
}
