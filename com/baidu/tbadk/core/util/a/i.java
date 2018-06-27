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
    private static int asW = 5;
    private static int ata = 0;
    private static int atb = 0;
    private static int atc = 0;
    private static int atg = 0;
    private com.baidu.adp.lib.network.http.e asT;
    private f asX;
    private volatile com.baidu.adp.lib.network.http.c sV = null;
    private HashMap<String, String> asU = null;
    private com.baidu.adp.lib.network.http.g asV = new com.baidu.adp.lib.network.http.g();
    public boolean asY = false;
    public boolean isGif = false;
    public String zI = "";
    public com.baidu.adp.lib.network.http.d asZ = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean atd = false;
    public boolean ate = false;
    private boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    private boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    private boolean atf = false;

    public boolean Af() {
        return this.atd;
    }

    public com.baidu.adp.lib.network.http.g hW() {
        return this.asV;
    }

    public void Ag() {
        this.asZ = null;
        this.zI = "";
        this.atd = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.asY = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] eZ(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                Ag();
                if (this.asT != null) {
                    cancel();
                    this.sV = null;
                }
                this.asT = new com.baidu.adp.lib.network.http.e();
                this.asT.hV().setUrl(str);
                if (this.asU != null) {
                    for (Map.Entry<String, String> entry : this.asU.entrySet()) {
                        this.asT.hV().o(entry.getKey(), entry.getValue());
                    }
                }
                this.sV = new com.baidu.adp.lib.network.http.c(this.asT);
                this.sV.d(asW, 0, 0);
                this.asV = this.asT.hW();
                byte[] bArr = this.asT.hW().Ab;
                this.responseCode = this.asT.hW().responseCode;
                this.errorCode = this.asT.hW().zZ;
                this.atd = this.asT.hW().ic();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.asT.hW().contentEncoding != null && this.asT.hW().contentEncoding.toLowerCase().contains("gzip")) {
                    this.asY = true;
                    bArr = z(bArr);
                }
                if (!this.atd) {
                    c(str, null);
                }
                this.asZ = this.asT.hY();
                if (this.asZ != null) {
                    StringBuilder sb = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asZ;
                    dVar.zI = sb.append(dVar.zI).append(stringBuffer.toString()).toString();
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asZ;
                    dVar2.zI = sb2.append(dVar2.zI).append("_responseCode:").append(this.responseCode).toString();
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.asZ = this.asT.hY();
                if (this.asZ != null) {
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asZ;
                    dVar3.zI = sb3.append(dVar3.zI).append(stringBuffer.toString()).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asZ;
                    dVar4.zI = sb4.append(dVar4.zI).append("_responseCode:").append(this.responseCode).toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.asZ = this.asT.hY();
            if (this.asZ != null) {
                StringBuilder sb5 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar5 = this.asZ;
                dVar5.zI = sb5.append(dVar5.zI).append(stringBuffer.toString()).toString();
                StringBuilder sb6 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar6 = this.asZ;
                dVar6.zI = sb6.append(dVar6.zI).append("_responseCode:").append(this.responseCode).toString();
            }
            throw th;
        }
    }

    private final byte[] z(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] fa(String str) {
        return eZ(str);
    }

    private boolean Ah() {
        if (this.asV.zY) {
            return false;
        }
        if (this.errorCode == -12 || this.errorCode == -18 || this.errorCode == -19) {
            int i = atg + 1;
            atg = i;
            if (i >= 5) {
                atg = 0;
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
                byte[] eZ = eZ(str);
                int i3 = ata + 1;
                ata = i3;
                if (i3 <= 2 && this.responseCode != 200) {
                    if (ata == 1) {
                        atc = this.errorCode;
                    }
                    atb++;
                }
                if (ata == 2) {
                    t.a("A2T", atc, this.errorCode, atb);
                }
                if (true == Ah()) {
                    this.mUseHttpClient = true;
                    this.atf = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    atb = 0;
                    ata = 0;
                    atc = 0;
                }
                if (eZ == null) {
                    return null;
                }
                if (this.asT != null && this.asT.hW().Aa != null) {
                    List<String> list = this.asT.hW().Aa.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i2 = 1;
                    }
                    List<String> list2 = this.asT.hW().Aa.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.asT.hW().Aa.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.ate = false;
                            i = i2;
                            return (this.atd || (!z && i == 0) || !new String(eZ, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) ? eZ : copyOfRange(eZ, 23, eZ.length);
                        }
                        this.ate = true;
                    }
                }
                i = i2;
                if (this.atd) {
                }
            } catch (Exception e) {
                this.zI += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        try {
            try {
                Ag();
                if (this.asX != null) {
                    cancel();
                }
                this.asT = new com.baidu.adp.lib.network.http.e();
                this.asX = new f(this.asT);
                this.asT.hV().setUrl(str);
                if (this.asU != null) {
                    for (Map.Entry<String, String> entry : this.asU.entrySet()) {
                        this.asT.hV().o(entry.getKey(), entry.getValue());
                    }
                }
                this.asX.e(null, null, -1);
                this.asV = this.asT.hW();
                byte[] bArr = this.asT.hW().Ab;
                this.responseCode = this.asT.hW().responseCode;
                this.errorCode = this.asT.hW().zZ;
                this.atd = this.asT.hW().ic();
                if (this.mUseHttpAutoSwitch && true == Ah()) {
                    this.mUseHttpClient = false;
                    TbadkCoreApplication.getInst().setHttpClientOpen(false);
                    atb = 0;
                    ata = 0;
                    atc = 0;
                }
                if (this.atf) {
                    int i4 = ata + 1;
                    ata = i4;
                    if (i4 <= 2 && this.responseCode != 200) {
                        atb++;
                        if (ata == 1) {
                            atc = this.errorCode;
                        }
                    }
                    if (ata == 2) {
                        t.a("T2A", atc, this.errorCode, atb);
                        this.atf = false;
                    }
                }
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                this.isGif = this.asX.isGif();
                this.ate = this.asX.Ae();
                int size = this.asT.hX().size();
                if (size > 0) {
                    sb.append("_ipsize:");
                    sb.append(size);
                    sb.append("_ips:");
                    while (i2 < size) {
                        if (this.asT.hX().get(i2) != null) {
                            sb.append(this.asT.hX().get(i2).zL);
                        }
                        if (i2 != size - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asZ = this.asT.hY();
                if (this.asZ != null) {
                    StringBuilder sb2 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar = this.asZ;
                    dVar.zI = sb2.append(dVar.zI).append(sb.toString()).toString();
                    StringBuilder sb3 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar2 = this.asZ;
                    dVar2.zI = sb3.append(dVar2.zI).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb4 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar3 = this.asZ;
                    dVar3.zI = sb4.append(dVar3.zI).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return bArr;
            } catch (Exception e2) {
                sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                int size2 = this.asT.hX().size();
                if (size2 > 0) {
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    while (i2 < size2) {
                        if (this.asT.hX().get(i2) != null) {
                            sb.append(this.asT.hX().get(i2).zL);
                        }
                        if (i2 != size2 - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                this.asZ = this.asT.hY();
                if (this.asZ != null) {
                    StringBuilder sb5 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar4 = this.asZ;
                    dVar4.zI = sb5.append(dVar4.zI).append(sb.toString()).toString();
                    StringBuilder sb6 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar5 = this.asZ;
                    dVar5.zI = sb6.append(dVar5.zI).append("_responseCode:").append(this.responseCode).toString();
                    StringBuilder sb7 = new StringBuilder();
                    com.baidu.adp.lib.network.http.d dVar6 = this.asZ;
                    dVar6.zI = sb7.append(dVar6.zI).append("_size:").append(Integer.toString(this.dataSize)).toString();
                }
                return null;
            }
        } catch (Throwable th) {
            int size3 = this.asT.hX().size();
            if (size3 > 0) {
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i2 < size3) {
                    if (this.asT.hX().get(i2) != null) {
                        sb.append(this.asT.hX().get(i2).zL);
                    }
                    if (i2 != size3 - 1) {
                        sb.append("_");
                    }
                    i2++;
                }
            }
            this.asZ = this.asT.hY();
            if (this.asZ != null) {
                StringBuilder sb8 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar7 = this.asZ;
                dVar7.zI = sb8.append(dVar7.zI).append(sb.toString()).toString();
                StringBuilder sb9 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar8 = this.asZ;
                dVar8.zI = sb9.append(dVar8.zI).append("_responseCode:").append(this.responseCode).toString();
                StringBuilder sb10 = new StringBuilder();
                com.baidu.adp.lib.network.http.d dVar9 = this.asZ;
                dVar9.zI = sb10.append(dVar9.zI).append("_size:").append(Integer.toString(this.dataSize)).toString();
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
            for (int i = 0; i < this.asT.hX().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.asT.hX().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.zI);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.zF);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.connectTime);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.zD);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.zE);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.zH);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.zJ);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.zG);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.zK);
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
            this.zI = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.atd = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.sV != null) {
            this.sV.cancel();
        }
        if (this.asX != null) {
            this.asX.cancel();
            this.asX = null;
        }
    }

    public boolean Ai() {
        if (this.asX == null) {
            return false;
        }
        return this.asX.asG;
    }
}
