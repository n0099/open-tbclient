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
    private f asA;
    private com.baidu.adp.lib.network.http.e asw;
    private static int asz = 5;
    private static int asD = 0;
    private static int asE = 0;
    private static int asF = 0;
    private static int asJ = 0;
    private volatile com.baidu.adp.lib.network.http.c sN = null;
    private HashMap<String, String> asx = null;
    private com.baidu.adp.lib.network.http.g asy = new com.baidu.adp.lib.network.http.g();
    public boolean asB = false;
    public boolean isGif = false;
    public String zD = "";
    public com.baidu.adp.lib.network.http.d asC = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean asG = false;
    public boolean asH = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean asI = false;

    public boolean zU() {
        return this.asG;
    }

    public com.baidu.adp.lib.network.http.g hX() {
        return this.asy;
    }

    public void zV() {
        this.asC = null;
        this.zD = "";
        this.asG = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.asB = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eX(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                zV();
                if (this.asw != null) {
                    cancel();
                    this.sN = null;
                }
                this.asw = new com.baidu.adp.lib.network.http.e();
                this.asw.hW().setUrl(str);
                if (this.asx != null) {
                    for (Map.Entry<String, String> entry : this.asx.entrySet()) {
                        this.asw.hW().o(entry.getKey(), entry.getValue());
                    }
                }
                this.sN = new com.baidu.adp.lib.network.http.c(this.asw);
                this.sN.d(asz, 0, 0);
                this.asy = this.asw.hX();
                byte[] bArr = this.asw.hX().zW;
                this.responseCode = this.asw.hX().responseCode;
                this.errorCode = this.asw.hX().zU;
                this.asG = this.asw.hX().id();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.asw.hX().contentEncoding != null && this.asw.hX().contentEncoding.toLowerCase().contains("gzip")) {
                    this.asB = true;
                    bArr = x(bArr);
                }
                if (!this.asG) {
                    c(str, null);
                }
                this.asC = this.asw.hZ();
                if (this.asC != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asC;
                    dVar.zD = sb.append(dVar.zD).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asC;
                    dVar2.zD = sb2.append(dVar2.zD).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.asC = this.asw.hZ();
                if (this.asC != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asC;
                    dVar3.zD = sb3.append(dVar3.zD).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asC;
                    dVar4.zD = sb4.append(dVar4.zD).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.asC = this.asw.hZ();
            if (this.asC != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.asC;
                dVar5.zD = sb5.append(dVar5.zD).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.asC;
                dVar6.zD = sb6.append(dVar6.zD).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] x(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] eY(String str) {
        return eX(str);
    }

    private boolean zW() {
        if (this.asy.zT) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = asJ + 1;
            asJ = i;
            if (i >= 5) {
                asJ = 0;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, CONST_STR, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF, CONST_STR, INVOKE, INVOKE, CONST_STR, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=6] */
    public byte[] i(String str, boolean z) {
        int i;
        String str2;
        int i2 = 0;
        if (!this.mUseHttpClient) {
            try {
                byte[] eX = eX(str);
                int i3 = asD + 1;
                asD = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (asD == 1) {
                        asF = this.errorCode;
                    }
                    asE++;
                }
                if (asD == 2) {
                    t.a("A2T", asF, this.errorCode, asE);
                }
                if (true == zW()) {
                    this.mUseHttpClient = true;
                    this.asI = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    asE = 0;
                    asD = 0;
                    asF = 0;
                }
                if (eX == null) {
                    return null;
                }
                if (this.asw != null && this.asw.hX().zV != null) {
                    List<String> list = this.asw.hX().zV.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.asw.hX().zV.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.asw.hX().zV.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.asH = false;
                            i = i2;
                            return (this.asG || (!z && i == 0) || !new String(eX, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eX : copyOfRange(eX, 23, eX.length);
                        }
                        this.asH = true;
                    }
                }
                i = i2;
                if (this.asG) {
                }
            } catch (Exception e) {
                this.zD += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                zV();
                if (this.asA != null) {
                    cancel();
                }
                this.asw = new com.baidu.adp.lib.network.http.e();
                this.asA = new f(this.asw);
                this.asw.hW().setUrl(str);
                if (this.asx != null) {
                    for (Map.Entry<String, String> entry : this.asx.entrySet()) {
                        this.asw.hW().o(entry.getKey(), entry.getValue());
                    }
                }
                this.asA.e(null, null, -1);
                this.asy = this.asw.hX();
                byte[] bArr = this.asw.hX().zW;
                this.responseCode = this.asw.hX().responseCode;
                this.errorCode = this.asw.hX().zU;
                this.asG = this.asw.hX().id();
                if (this.mUseHttpAutoSwitch && true == zW()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    asE = 0;
                    asD = 0;
                    asF = 0;
                }
                if (this.asI) {
                    int i4 = asD + 1;
                    asD = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        asE++;
                        if (asD == 1) {
                            asF = this.errorCode;
                        }
                    }
                    if (asD == 2) {
                        t.a("T2A", asF, this.errorCode, asE);
                        this.asI = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.asA.isGif();
                this.asH = this.asA.zT();
                int size = this.asw.hY().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.asw.hY().get(i2) != null) {
                            sb.append(this.asw.hY().get(i2).zG);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asC = this.asw.hZ();
                if (this.asC != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asC;
                    dVar.zD = sb2.append(dVar.zD).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asC;
                    dVar2.zD = sb3.append(dVar2.zD).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asC;
                    dVar3.zD = sb4.append(dVar3.zD).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.asw.hY().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.asw.hY().get(i2) != null) {
                            sb.append(this.asw.hY().get(i2).zG);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asC = this.asw.hZ();
                if (this.asC != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asC;
                    dVar4.zD = sb5.append(dVar4.zD).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.asC;
                    dVar5.zD = sb6.append(dVar5.zD).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.asC;
                    dVar6.zD = sb7.append(dVar6.zD).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.asw.hY().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.asw.hY().get(i2) != null) {
                        sb.append(this.asw.hY().get(i2).zG);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.asC = this.asw.hZ();
            if (this.asC != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.asC;
                dVar7.zD = sb8.append(dVar7.zD).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.asC;
                dVar8.zD = sb9.append(dVar8.zD).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.asC;
                dVar9.zD = sb10.append(dVar9.zD).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.asw.hY().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.asw.hY().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.zD);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.zA);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.zy);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.zz);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.zC);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.zE);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.zB);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.zF);
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
            this.zD = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.asG = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.sN != null) {
            this.sN.cancel();
        }
        if (this.asA != null) {
            this.asA.cancel();
            this.asA = null;
        }
    }

    public boolean zX() {
        if (this.asA == null) {
            return false;
        }
        return this.asA.asj;
    }
}
