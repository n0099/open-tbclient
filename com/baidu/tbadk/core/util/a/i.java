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
    private static int bVY = 5;
    private static int bWc = 0;
    private static int bWd = 0;
    private static int bWe = 0;
    private static int bWi = 0;
    private com.baidu.adp.lib.network.http.e bVV;
    private f bVZ;
    private volatile com.baidu.adp.lib.network.http.c tJ = null;
    private HashMap<String, String> bVW = null;
    private com.baidu.adp.lib.network.http.g bVX = new com.baidu.adp.lib.network.http.g();
    public boolean bWa = false;
    public boolean isGif = false;
    public String Az = "";
    public com.baidu.adp.lib.network.http.d bWb = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean bWf = false;
    public boolean bWg = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean bWh = false;

    public boolean ajV() {
        return this.bWf;
    }

    public com.baidu.adp.lib.network.http.g iv() {
        return this.bVX;
    }

    public void pw() {
        this.bWb = null;
        this.Az = "";
        this.bWf = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.bWa = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] oy(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                pw();
                if (this.bVV != null) {
                    cancel();
                    this.tJ = null;
                }
                this.bVV = new com.baidu.adp.lib.network.http.e();
                this.bVV.iu().setUrl(str);
                if (this.bVW != null) {
                    for (Map.Entry<String, String> entry : this.bVW.entrySet()) {
                        this.bVV.iu().o(entry.getKey(), entry.getValue());
                    }
                }
                this.tJ = new com.baidu.adp.lib.network.http.c(this.bVV);
                this.tJ.d(bVY, 0, 0);
                this.bVX = this.bVV.iv();
                byte[] bArr = this.bVV.iv().AU;
                this.responseCode = this.bVV.iv().responseCode;
                this.errorCode = this.bVV.iv().AR;
                this.bWf = this.bVV.iv().iB();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.bVV.iv().contentEncoding != null && this.bVV.iv().contentEncoding.toLowerCase().contains("gzip")) {
                    this.bWa = true;
                    bArr = H(bArr);
                }
                if (!this.bWf) {
                    e(str, null);
                }
                this.bWb = this.bVV.ix();
                if (this.bWb != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bWb;
                    dVar.Az = sb.append(dVar.Az).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bWb;
                    dVar2.Az = sb2.append(dVar2.Az).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.bWb = this.bVV.ix();
                if (this.bWb != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bWb;
                    dVar3.Az = sb3.append(dVar3.Az).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bWb;
                    dVar4.Az = sb4.append(dVar4.Az).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.bWb = this.bVV.ix();
            if (this.bWb != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.bWb;
                dVar5.Az = sb5.append(dVar5.Az).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.bWb;
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

    public byte[] oz(String str) {
        return oy(str);
    }

    private boolean ajW() {
        if (this.bVX.AQ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = bWi + 1;
            bWi = i;
            if (i >= 5) {
                bWi = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [350=6] */
    public byte[] O(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                if (com.baidu.adp.lib.b.d.hS().az("need_more_logs") == 1) {
                    s.n("httpManager", str, "", "");
                }
                byte[] oy = oy(str);
                int i3 = bWc + 1;
                bWc = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (bWc == 1) {
                        bWe = this.errorCode;
                    }
                    bWd++;
                }
                if (bWc == 2) {
                    s.a("A2T", bWe, this.errorCode, bWd);
                }
                if (true == ajW()) {
                    this.mUseHttpClient = true;
                    this.bWh = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    bWd = 0;
                    bWc = 0;
                    bWe = 0;
                }
                if (oy == null) {
                    return null;
                }
                if (this.bVV != null && this.bVV.iv().AT != null) {
                    List<String> list = this.bVV.iv().AT.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.bVV.iv().AT.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.bVV.iv().AT.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.bWg = false;
                            i = i2;
                            return (this.bWf || (!z && i == 0) || !new String(oy, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? oy : k(oy, 23, oy.length);
                        }
                        this.bWg = true;
                    }
                }
                i = i2;
                if (this.bWf) {
                }
            } catch (Exception e) {
                this.Az += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        if (com.baidu.adp.lib.b.d.hS().az("need_more_logs") == 1) {
            s.n("httpClient", str, "", "");
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                pw();
                if (this.bVZ != null) {
                    cancel();
                }
                this.bVV = new com.baidu.adp.lib.network.http.e();
                this.bVZ = new f(this.bVV);
                this.bVV.iu().setUrl(str);
                if (this.bVW != null) {
                    for (Map.Entry<String, String> entry : this.bVW.entrySet()) {
                        this.bVV.iu().o(entry.getKey(), entry.getValue());
                    }
                }
                this.bVZ.l(null, null, -1);
                this.bVX = this.bVV.iv();
                byte[] bArr = this.bVV.iv().AU;
                this.responseCode = this.bVV.iv().responseCode;
                this.errorCode = this.bVV.iv().AR;
                this.bWf = this.bVV.iv().iB();
                if (this.mUseHttpAutoSwitch && true == ajW()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    bWd = 0;
                    bWc = 0;
                    bWe = 0;
                }
                if (this.bWh) {
                    int i4 = bWc + 1;
                    bWc = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        bWd++;
                        if (bWc == 1) {
                            bWe = this.errorCode;
                        }
                    }
                    if (bWc == 2) {
                        s.a("T2A", bWe, this.errorCode, bWd);
                        this.bWh = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.bVZ.isGif();
                this.bWg = this.bVZ.ajU();
                int size = this.bVV.iw().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.bVV.iw().get(i2) != null) {
                            sb.append(this.bVV.iw().get(i2).AC);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bWb = this.bVV.ix();
                if (this.bWb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.bWb;
                    dVar.Az = sb2.append(dVar.Az).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.bWb;
                    dVar2.Az = sb3.append(dVar2.Az).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.bWb;
                    dVar3.Az = sb4.append(dVar3.Az).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.bVV.iw().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.bVV.iw().get(i2) != null) {
                            sb.append(this.bVV.iw().get(i2).AC);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.bWb = this.bVV.ix();
                if (this.bWb != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.bWb;
                    dVar4.Az = sb5.append(dVar4.Az).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.bWb;
                    dVar5.Az = sb6.append(dVar5.Az).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.bWb;
                    dVar6.Az = sb7.append(dVar6.Az).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.bVV.iw().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.bVV.iw().get(i2) != null) {
                        sb.append(this.bVV.iw().get(i2).AC);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.bWb = this.bVV.ix();
            if (this.bWb != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.bWb;
                dVar7.Az = sb8.append(dVar7.Az).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.bWb;
                dVar8.Az = sb9.append(dVar8.Az).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.bWb;
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
            for (int i = 0; i < this.bVV.iw().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.bVV.iw().get(i);
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
            this.bWf = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.tJ != null) {
            this.tJ.cancel();
        }
        if (this.bVZ != null) {
            this.bVZ.cancel();
            this.bVZ = null;
        }
    }

    public boolean ajX() {
        if (this.bVZ == null) {
            return false;
        }
        return this.bVZ.bVJ;
    }
}
