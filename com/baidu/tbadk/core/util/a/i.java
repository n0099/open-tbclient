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
    private static int asA = 5;
    private static int asE = 0;
    private static int asF = 0;
    private static int asG = 0;
    private static int asK = 0;
    private f asB;
    private com.baidu.adp.lib.network.http.e asx;
    private volatile com.baidu.adp.lib.network.http.c sO = null;
    private HashMap<String, String> asy = null;
    private com.baidu.adp.lib.network.http.g asz = new com.baidu.adp.lib.network.http.g();
    public boolean asC = false;
    public boolean isGif = false;
    public String zE = "";
    public com.baidu.adp.lib.network.http.d asD = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean asH = false;
    public boolean asI = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean asJ = false;

    public boolean zS() {
        return this.asH;
    }

    public com.baidu.adp.lib.network.http.g hX() {
        return this.asz;
    }

    public void zT() {
        this.asD = null;
        this.zE = "";
        this.asH = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.asC = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eX(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                zT();
                if (this.asx != null) {
                    cancel();
                    this.sO = null;
                }
                this.asx = new com.baidu.adp.lib.network.http.e();
                this.asx.hW().setUrl(str);
                if (this.asy != null) {
                    for (Map.Entry<String, String> entry : this.asy.entrySet()) {
                        this.asx.hW().o(entry.getKey(), entry.getValue());
                    }
                }
                this.sO = new com.baidu.adp.lib.network.http.c(this.asx);
                this.sO.d(asA, 0, 0);
                this.asz = this.asx.hX();
                byte[] bArr = this.asx.hX().zX;
                this.responseCode = this.asx.hX().responseCode;
                this.errorCode = this.asx.hX().zV;
                this.asH = this.asx.hX().id();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.asx.hX().contentEncoding != null && this.asx.hX().contentEncoding.toLowerCase().contains("gzip")) {
                    this.asC = true;
                    bArr = x(bArr);
                }
                if (!this.asH) {
                    c(str, null);
                }
                this.asD = this.asx.hZ();
                if (this.asD != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asD;
                    dVar.zE = sb.append(dVar.zE).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asD;
                    dVar2.zE = sb2.append(dVar2.zE).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.asD = this.asx.hZ();
                if (this.asD != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asD;
                    dVar3.zE = sb3.append(dVar3.zE).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asD;
                    dVar4.zE = sb4.append(dVar4.zE).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.asD = this.asx.hZ();
            if (this.asD != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.asD;
                dVar5.zE = sb5.append(dVar5.zE).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.asD;
                dVar6.zE = sb6.append(dVar6.zE).append("_responseCode:").append(this.responseCode).toString();
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

    private boolean zU() {
        if (this.asz.zU) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = asK + 1;
            asK = i;
            if (i >= 5) {
                asK = 0;
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
                int i3 = asE + 1;
                asE = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (asE == 1) {
                        asG = this.errorCode;
                    }
                    asF++;
                }
                if (asE == 2) {
                    t.a("A2T", asG, this.errorCode, asF);
                }
                if (true == zU()) {
                    this.mUseHttpClient = true;
                    this.asJ = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    asF = 0;
                    asE = 0;
                    asG = 0;
                }
                if (eX == null) {
                    return null;
                }
                if (this.asx != null && this.asx.hX().zW != null) {
                    List<String> list = this.asx.hX().zW.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.asx.hX().zW.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.asx.hX().zW.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.asI = false;
                            i = i2;
                            return (this.asH || (!z && i == 0) || !new String(eX, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eX : copyOfRange(eX, 23, eX.length);
                        }
                        this.asI = true;
                    }
                }
                i = i2;
                if (this.asH) {
                }
            } catch (Exception e) {
                this.zE += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                zT();
                if (this.asB != null) {
                    cancel();
                }
                this.asx = new com.baidu.adp.lib.network.http.e();
                this.asB = new f(this.asx);
                this.asx.hW().setUrl(str);
                if (this.asy != null) {
                    for (Map.Entry<String, String> entry : this.asy.entrySet()) {
                        this.asx.hW().o(entry.getKey(), entry.getValue());
                    }
                }
                this.asB.e(null, null, -1);
                this.asz = this.asx.hX();
                byte[] bArr = this.asx.hX().zX;
                this.responseCode = this.asx.hX().responseCode;
                this.errorCode = this.asx.hX().zV;
                this.asH = this.asx.hX().id();
                if (this.mUseHttpAutoSwitch && true == zU()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    asF = 0;
                    asE = 0;
                    asG = 0;
                }
                if (this.asJ) {
                    int i4 = asE + 1;
                    asE = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        asF++;
                        if (asE == 1) {
                            asG = this.errorCode;
                        }
                    }
                    if (asE == 2) {
                        t.a("T2A", asG, this.errorCode, asF);
                        this.asJ = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.asB.isGif();
                this.asI = this.asB.zR();
                int size = this.asx.hY().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.asx.hY().get(i2) != null) {
                            sb.append(this.asx.hY().get(i2).zH);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asD = this.asx.hZ();
                if (this.asD != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asD;
                    dVar.zE = sb2.append(dVar.zE).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asD;
                    dVar2.zE = sb3.append(dVar2.zE).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asD;
                    dVar3.zE = sb4.append(dVar3.zE).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.asx.hY().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.asx.hY().get(i2) != null) {
                            sb.append(this.asx.hY().get(i2).zH);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asD = this.asx.hZ();
                if (this.asD != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asD;
                    dVar4.zE = sb5.append(dVar4.zE).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.asD;
                    dVar5.zE = sb6.append(dVar5.zE).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.asD;
                    dVar6.zE = sb7.append(dVar6.zE).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.asx.hY().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.asx.hY().get(i2) != null) {
                        sb.append(this.asx.hY().get(i2).zH);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.asD = this.asx.hZ();
            if (this.asD != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.asD;
                dVar7.zE = sb8.append(dVar7.zE).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.asD;
                dVar8.zE = sb9.append(dVar8.zE).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.asD;
                dVar9.zE = sb10.append(dVar9.zE).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.asx.hY().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.asx.hY().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.zE);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.zB);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.zz);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.zA);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.zD);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.zF);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.zC);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.zG);
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
            this.zE = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.asH = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.sO != null) {
            this.sO.cancel();
        }
        if (this.asB != null) {
            this.asB.cancel();
            this.asB = null;
        }
    }

    public boolean zV() {
        if (this.asB == null) {
            return false;
        }
        return this.asB.ask;
    }
}
