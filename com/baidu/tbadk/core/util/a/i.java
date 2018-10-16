package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0018a {
    private static int azJ = 5;
    private static int azN = 0;
    private static int azO = 0;
    private static int azP = 0;
    private static int azT = 0;
    private com.baidu.adp.lib.network.http.e azG;
    private f azK;
    private volatile com.baidu.adp.lib.network.http.c wb = null;
    private HashMap<String, String> azH = null;
    private com.baidu.adp.lib.network.http.g azI = new com.baidu.adp.lib.network.http.g();
    public boolean azL = false;
    public boolean isGif = false;
    public String CH = "";
    public com.baidu.adp.lib.network.http.d azM = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean azQ = false;
    public boolean azR = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean azS = false;

    public boolean De() {
        return this.azQ;
    }

    public com.baidu.adp.lib.network.http.g js() {
        return this.azI;
    }

    public void Df() {
        this.azM = null;
        this.CH = "";
        this.azQ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.azL = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] fD(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Df();
                if (this.azG != null) {
                    cancel();
                    this.wb = null;
                }
                this.azG = new com.baidu.adp.lib.network.http.e();
                this.azG.jr().setUrl(str);
                if (this.azH != null) {
                    for (Map.Entry<String, String> entry : this.azH.entrySet()) {
                        this.azG.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.wb = new com.baidu.adp.lib.network.http.c(this.azG);
                this.wb.e(azJ, 0, 0);
                this.azI = this.azG.js();
                byte[] bArr = this.azG.js().Dc;
                this.responseCode = this.azG.js().responseCode;
                this.errorCode = this.azG.js().Da;
                this.azQ = this.azG.js().jy();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.azG.js().contentEncoding != null && this.azG.js().contentEncoding.toLowerCase().contains("gzip")) {
                    this.azL = true;
                    bArr = F(bArr);
                }
                if (!this.azQ) {
                    d(str, null);
                }
                this.azM = this.azG.ju();
                if (this.azM != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.azM;
                    dVar.CH = sb.append(dVar.CH).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.azM;
                    dVar2.CH = sb2.append(dVar2.CH).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + BaseRequestAction.SPLITE + e.getMessage());
                this.azM = this.azG.ju();
                if (this.azM != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.azM;
                    dVar3.CH = sb3.append(dVar3.CH).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.azM;
                    dVar4.CH = sb4.append(dVar4.CH).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.azM = this.azG.ju();
            if (this.azM != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.azM;
                dVar5.CH = sb5.append(dVar5.CH).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.azM;
                dVar6.CH = sb6.append(dVar6.CH).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] F(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] fE(String str) {
        return fD(str);
    }

    private boolean Dg() {
        if (this.azI.CZ) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = azT + 1;
            azT = i;
            if (i >= 5) {
                azT = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] q(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] fD = fD(str);
                int i3 = azN + 1;
                azN = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (azN == 1) {
                        azP = this.errorCode;
                    }
                    azO++;
                }
                if (azN == 2) {
                    s.b("A2T", azP, this.errorCode, azO);
                }
                if (true == Dg()) {
                    this.mUseHttpClient = true;
                    this.azS = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    azO = 0;
                    azN = 0;
                    azP = 0;
                }
                if (fD == null) {
                    return null;
                }
                if (this.azG != null && this.azG.js().Db != null) {
                    List<String> list = this.azG.js().Db.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.azG.js().Db.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.azG.js().Db.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.azR = false;
                            i = i2;
                            return (this.azQ || (!z && i == 0) || !new String(fD, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? fD : copyOfRange(fD, 23, fD.length);
                        }
                        this.azR = true;
                    }
                }
                i = i2;
                if (this.azQ) {
                }
            } catch (Exception e) {
                this.CH += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Df();
                if (this.azK != null) {
                    cancel();
                }
                this.azG = new com.baidu.adp.lib.network.http.e();
                this.azK = new f(this.azG);
                this.azG.jr().setUrl(str);
                if (this.azH != null) {
                    for (Map.Entry<String, String> entry : this.azH.entrySet()) {
                        this.azG.jr().x(entry.getKey(), entry.getValue());
                    }
                }
                this.azK.e(null, null, -1);
                this.azI = this.azG.js();
                byte[] bArr = this.azG.js().Dc;
                this.responseCode = this.azG.js().responseCode;
                this.errorCode = this.azG.js().Da;
                this.azQ = this.azG.js().jy();
                if (this.mUseHttpAutoSwitch && true == Dg()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    azO = 0;
                    azN = 0;
                    azP = 0;
                }
                if (this.azS) {
                    int i4 = azN + 1;
                    azN = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        azO++;
                        if (azN == 1) {
                            azP = this.errorCode;
                        }
                    }
                    if (azN == 2) {
                        s.b("T2A", azP, this.errorCode, azO);
                        this.azS = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.azK.isGif();
                this.azR = this.azK.Dd();
                int size = this.azG.jt().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.azG.jt().get(i2) != null) {
                            sb.append(this.azG.jt().get(i2).CK);
                        }
                        if (i2 != size - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.azM = this.azG.ju();
                if (this.azM != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.azM;
                    dVar.CH = sb2.append(dVar.CH).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.azM;
                    dVar2.CH = sb3.append(dVar2.CH).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.azM;
                    dVar3.CH = sb4.append(dVar3.CH).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + BaseRequestAction.SPLITE + e2.getMessage());
                int size2 = this.azG.jt().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.azG.jt().get(i2) != null) {
                            sb.append(this.azG.jt().get(i2).CK);
                        }
                        if (i2 != size2 - 1) {
                            sb.append(BaseRequestAction.SPLITE);
                        }
                        i2++;
                    }
                }
                this.azM = this.azG.ju();
                if (this.azM != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.azM;
                    dVar4.CH = sb5.append(dVar4.CH).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.azM;
                    dVar5.CH = sb6.append(dVar5.CH).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.azM;
                    dVar6.CH = sb7.append(dVar6.CH).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.azG.jt().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.azG.jt().get(i2) != null) {
                        sb.append(this.azG.jt().get(i2).CK);
                    }
                    if (i2 != size3 - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                    i2++;
                }
            }
            this.azM = this.azG.ju();
            if (this.azM != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.azM;
                dVar7.CH = sb8.append(dVar7.CH).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.azM;
                dVar8.CH = sb9.append(dVar8.CH).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.azM;
                dVar9.CH = sb10.append(dVar9.CH).append("_size:").append(Integer.toString(this.dataSize)).toString();
            }
            throw th;
        }
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void d(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.azG.jt().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.azG.jt().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.CH);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.CE);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.CC);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.CD);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.CG);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.CI);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.CF);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.CJ);
            }
            if (exc != null) {
                stringBuffer.append("webclient exception");
                stringBuffer.append("class");
                stringBuffer.append(exc.getClass());
                stringBuffer.append("message");
                stringBuffer.append(exc.getMessage());
            } else {
                stringBuffer.append("networkcore exception");
            }
            this.CH = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.azQ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.wb != null) {
            this.wb.cancel();
        }
        if (this.azK != null) {
            this.azK.cancel();
            this.azK = null;
        }
    }

    public boolean Dh() {
        if (this.azK == null) {
            return false;
        }
        return this.azK.azt;
    }
}
