package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class i implements a.InterfaceC0015a {
    private com.baidu.adp.lib.network.http.e asq;
    private f asu;
    private static int ast = 5;
    private static int asx = 0;
    private static int asy = 0;
    private static int asz = 0;
    private static int asD = 0;
    private volatile com.baidu.adp.lib.network.http.c sX = null;
    private HashMap<String, String> asr = null;
    private com.baidu.adp.lib.network.http.g ass = new com.baidu.adp.lib.network.http.g();
    public boolean asv = false;
    public boolean isGif = false;
    public String zK = "";
    public com.baidu.adp.lib.network.http.d asw = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean asA = false;
    public boolean asB = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean asC = false;

    public boolean zQ() {
        return this.asA;
    }

    public com.baidu.adp.lib.network.http.g hW() {
        return this.ass;
    }

    public void zR() {
        this.asw = null;
        this.zK = "";
        this.asA = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.asv = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eW(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                zR();
                if (this.asq != null) {
                    cancel();
                    this.sX = null;
                }
                this.asq = new com.baidu.adp.lib.network.http.e();
                this.asq.hV().setUrl(str);
                if (this.asr != null) {
                    for (Map.Entry<String, String> entry : this.asr.entrySet()) {
                        this.asq.hV().o(entry.getKey(), entry.getValue());
                    }
                }
                this.sX = new com.baidu.adp.lib.network.http.c(this.asq);
                this.sX.d(ast, 0, 0);
                this.ass = this.asq.hW();
                byte[] bArr = this.asq.hW().Ae;
                this.responseCode = this.asq.hW().responseCode;
                this.errorCode = this.asq.hW().Ab;
                this.asA = this.asq.hW().ic();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.asq.hW().contentEncoding != null && this.asq.hW().contentEncoding.toLowerCase().contains("gzip")) {
                    this.asv = true;
                    bArr = y(bArr);
                }
                if (!this.asA) {
                    c(str, null);
                }
                this.asw = this.asq.hY();
                if (this.asw != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asw;
                    dVar.zK = sb.append(dVar.zK).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asw;
                    dVar2.zK = sb2.append(dVar2.zK).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.asw = this.asq.hY();
                if (this.asw != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asw;
                    dVar3.zK = sb3.append(dVar3.zK).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asw;
                    dVar4.zK = sb4.append(dVar4.zK).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.asw = this.asq.hY();
            if (this.asw != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.asw;
                dVar5.zK = sb5.append(dVar5.zK).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.asw;
                dVar6.zK = sb6.append(dVar6.zK).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] eX(String str) {
        return eW(str);
    }

    private boolean zS() {
        if (this.ass.Aa) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = asD + 1;
            asD = i;
            if (i >= 5) {
                asD = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] j(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] eW = eW(str);
                int i3 = asx + 1;
                asx = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (asx == 1) {
                        asz = this.errorCode;
                    }
                    asy++;
                }
                if (asx == 2) {
                    t.a("A2T", asz, this.errorCode, asy);
                }
                if (true == zS()) {
                    this.mUseHttpClient = true;
                    this.asC = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    asy = 0;
                    asx = 0;
                    asz = 0;
                }
                if (eW == null) {
                    return null;
                }
                if (this.asq != null && this.asq.hW().Ac != null) {
                    List<String> list = this.asq.hW().Ac.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.asq.hW().Ac.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.asq.hW().Ac.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.asB = false;
                            i = i2;
                            return (this.asA || (!z && i == 0) || !new String(eW, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eW : copyOfRange(eW, 23, eW.length);
                        }
                        this.asB = true;
                    }
                }
                i = i2;
                if (this.asA) {
                }
            } catch (Exception e) {
                this.zK += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                zR();
                if (this.asu != null) {
                    cancel();
                }
                this.asq = new com.baidu.adp.lib.network.http.e();
                this.asu = new f(this.asq);
                this.asq.hV().setUrl(str);
                if (this.asr != null) {
                    for (Map.Entry<String, String> entry : this.asr.entrySet()) {
                        this.asq.hV().o(entry.getKey(), entry.getValue());
                    }
                }
                this.asu.e(null, null, -1);
                this.ass = this.asq.hW();
                byte[] bArr = this.asq.hW().Ae;
                this.responseCode = this.asq.hW().responseCode;
                this.errorCode = this.asq.hW().Ab;
                this.asA = this.asq.hW().ic();
                if (this.mUseHttpAutoSwitch && true == zS()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    asy = 0;
                    asx = 0;
                    asz = 0;
                }
                if (this.asC) {
                    int i4 = asx + 1;
                    asx = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        asy++;
                        if (asx == 1) {
                            asz = this.errorCode;
                        }
                    }
                    if (asx == 2) {
                        t.a("T2A", asz, this.errorCode, asy);
                        this.asC = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.asu.isGif();
                this.asB = this.asu.zP();
                int size = this.asq.hX().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.asq.hX().get(i2) != null) {
                            sb.append(this.asq.hX().get(i2).zN);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asw = this.asq.hY();
                if (this.asw != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asw;
                    dVar.zK = sb2.append(dVar.zK).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asw;
                    dVar2.zK = sb3.append(dVar2.zK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asw;
                    dVar3.zK = sb4.append(dVar3.zK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.asq.hX().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.asq.hX().get(i2) != null) {
                            sb.append(this.asq.hX().get(i2).zN);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asw = this.asq.hY();
                if (this.asw != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asw;
                    dVar4.zK = sb5.append(dVar4.zK).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.asw;
                    dVar5.zK = sb6.append(dVar5.zK).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.asw;
                    dVar6.zK = sb7.append(dVar6.zK).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.asq.hX().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.asq.hX().get(i2) != null) {
                        sb.append(this.asq.hX().get(i2).zN);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.asw = this.asq.hY();
            if (this.asw != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.asw;
                dVar7.zK = sb8.append(dVar7.zK).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.asw;
                dVar8.zK = sb9.append(dVar8.zK).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.asw;
                dVar9.zK = sb10.append(dVar9.zK).append("_size:").append(Integer.toString(this.dataSize)).toString();
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

    private void c(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.asq.hX().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.asq.hX().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.zK);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.zH);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.zF);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.zG);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.zJ);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.zL);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.zI);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.zM);
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
            this.zK = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.asA = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.sX != null) {
            this.sX.cancel();
        }
        if (this.asu != null) {
            this.asu.cancel();
            this.asu = null;
        }
    }

    public boolean zT() {
        if (this.asu == null) {
            return false;
        }
        return this.asu.asd;
    }
}
