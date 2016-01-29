package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements a.InterfaceC0005a {
    private static int aev = 5;
    private com.baidu.adp.lib.network.http.e aes;
    private f aew;
    private volatile com.baidu.adp.lib.network.http.c oq = null;
    private HashMap<String, String> aet = null;
    private com.baidu.adp.lib.network.http.g aeu = new com.baidu.adp.lib.network.http.g();
    public boolean aex = false;
    public boolean GY = false;
    public String vi = "";
    public com.baidu.adp.lib.network.http.d aey = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    private boolean aez = false;
    public boolean aeA = false;

    public boolean wF() {
        return this.aez;
    }

    public com.baidu.adp.lib.network.http.g hb() {
        return this.aeu;
    }

    public void wG() {
        this.aey = null;
        this.vi = "";
        this.aez = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GY = false;
        this.aex = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT, IGET]}, finally: {[IGET, INVOKE, IPUT, IGET, IGET, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] dH(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                wG();
                if (this.aes != null) {
                    cancel();
                    this.oq = null;
                }
                this.aes = new com.baidu.adp.lib.network.http.e();
                this.aes.ha().setUrl(str);
                if (this.aet != null) {
                    for (Map.Entry<String, String> entry : this.aet.entrySet()) {
                        this.aes.ha().p(entry.getKey(), entry.getValue());
                    }
                }
                this.oq = new com.baidu.adp.lib.network.http.c(this.aes);
                this.oq.e(aev, 0, 0);
                this.aeu = this.aes.hb();
                byte[] bArr = this.aes.hb().vx;
                this.responseCode = this.aes.hb().responseCode;
                this.errorCode = this.aes.hb().vv;
                this.aez = this.aes.hb().hh();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aes.hb().contentEncoding != null && this.aes.hb().contentEncoding.toLowerCase().contains("gzip")) {
                    this.aex = true;
                    bArr = P(bArr);
                }
                if (!this.aez) {
                    a(str, null);
                }
                this.aey = this.aes.hd();
                if (this.aey != null) {
                    com.baidu.adp.lib.network.http.d dVar = this.aey;
                    dVar.vi = String.valueOf(dVar.vi) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.d dVar2 = this.aey;
                    dVar2.vi = String.valueOf(dVar2.vi) + "_responseCode:" + this.responseCode;
                    return bArr;
                }
                return bArr;
            } catch (Exception e) {
                stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                this.aey = this.aes.hd();
                if (this.aey != null) {
                    com.baidu.adp.lib.network.http.d dVar3 = this.aey;
                    dVar3.vi = String.valueOf(dVar3.vi) + stringBuffer.toString();
                    com.baidu.adp.lib.network.http.d dVar4 = this.aey;
                    dVar4.vi = String.valueOf(dVar4.vi) + "_responseCode:" + this.responseCode;
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            this.aey = this.aes.hd();
            if (this.aey != null) {
                com.baidu.adp.lib.network.http.d dVar5 = this.aey;
                dVar5.vi = String.valueOf(dVar5.vi) + stringBuffer.toString();
                com.baidu.adp.lib.network.http.d dVar6 = this.aey;
                dVar6.vi = String.valueOf(dVar6.vi) + "_responseCode:" + this.responseCode;
            }
            throw th;
        }
    }

    private final byte[] P(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dI(String str) {
        return dH(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [281=6] */
    public byte[] m(String str, boolean z) {
        byte[] dH;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        com.baidu.adp.lib.network.http.d dVar4;
        com.baidu.adp.lib.network.http.d dVar5;
        com.baidu.adp.lib.network.http.d dVar6;
        int size;
        int i = 0;
        if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
            StringBuilder sb = new StringBuilder(20);
            try {
                try {
                    wG();
                    if (this.aew != null) {
                        cancel();
                    }
                    this.aes = new com.baidu.adp.lib.network.http.e();
                    this.aew = new f(this.aes);
                    this.aes.ha().setUrl(str);
                    if (this.aet != null) {
                        for (Map.Entry<String, String> entry : this.aet.entrySet()) {
                            this.aes.ha().p(entry.getKey(), entry.getValue());
                        }
                    }
                    this.aew.wD();
                    this.aeu = this.aes.hb();
                    dH = this.aes.hb().vx;
                    this.responseCode = this.aes.hb().responseCode;
                    this.errorCode = this.aes.hb().vv;
                    this.aez = this.aes.hb().hh();
                    if (dH != null) {
                        this.dataSize = dH.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GY = this.aew.fN();
                    this.aeA = this.aew.wE();
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    sb.append("_httpclienterr_" + e.getClass() + "_" + e.getMessage());
                    int size2 = this.aes.hc().size();
                    sb.append("_ipsize:");
                    sb.append(size2);
                    sb.append("_ips:");
                    for (int i2 = 0; i2 < this.aes.hc().size(); i2++) {
                        if (this.aes.hc().get(i2) != null) {
                            sb.append(this.aes.hc().get(i2).vl);
                        }
                        if (i2 != this.aes.hc().size() - 1) {
                            sb.append("_");
                        }
                    }
                    this.aey = this.aes.hd();
                    if (this.aey != null) {
                        this.aey.vi = String.valueOf(dVar4.vi) + sb.toString();
                        this.aey.vi = String.valueOf(dVar5.vi) + "_responseCode:" + this.responseCode;
                        this.aey.vi = String.valueOf(dVar6.vi) + "_size:" + Integer.toString(this.dataSize);
                        return null;
                    }
                    return null;
                }
            } finally {
                int size3 = this.aes.hc().size();
                sb.append("_ipsize:");
                sb.append(size3);
                sb.append("_ips:");
                while (i < this.aes.hc().size()) {
                    if (this.aes.hc().get(i) != null) {
                        sb.append(this.aes.hc().get(i).vl);
                    }
                    if (i != this.aes.hc().size() - 1) {
                        sb.append("_");
                    }
                    i++;
                }
                this.aey = this.aes.hd();
                if (this.aey != null) {
                    this.aey.vi = String.valueOf(dVar.vi) + sb.toString();
                    this.aey.vi = String.valueOf(dVar2.vi) + "_responseCode:" + this.responseCode;
                    this.aey.vi = String.valueOf(dVar3.vi) + "_size:" + Integer.toString(this.dataSize);
                }
            }
        } else {
            try {
                dH = dH(str);
                if (dH == null) {
                    return null;
                }
                if (this.aes != null && this.aes.hb().vw != null) {
                    List<String> list = this.aes.hb().vw.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.aes.hb().vw.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.GY = true;
                        } else {
                            this.GY = false;
                        }
                    }
                    List<String> list3 = this.aes.hb().vw.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.aeA = false;
                        } else {
                            this.aeA = true;
                        }
                    }
                }
                if (this.aez && ((z || i != 0) && new String(dH, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return copyOfRange(dH, 23, dH.length);
                }
            } catch (Exception e2) {
                this.vi = String.valueOf(this.vi) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return dH;
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(String.valueOf(i) + " > " + i2);
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
        return bArr2;
    }

    private void a(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.aes.hc().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aes.hc().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.vi);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.vf);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.vd);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.vc);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ve);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.vh);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.vj);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.vg);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.vk);
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
            this.vi = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.aez = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        if (this.oq != null) {
            this.oq.cancel();
        }
        if (this.aew != null) {
            this.aew.cancel();
            this.aew = null;
        }
    }

    public boolean wH() {
        if (this.aew == null) {
            return false;
        }
        return this.aew.aee;
    }
}
