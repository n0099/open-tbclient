package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements a.InterfaceC0004a {
    private static int acy = 5;
    private com.baidu.adp.lib.network.http.e acv;
    private f acz;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> acw = null;
    private com.baidu.adp.lib.network.http.g acx = new com.baidu.adp.lib.network.http.g();
    public List<Integer> acA = new ArrayList();
    public boolean acB = false;
    public boolean Gf = false;
    public String uR = "";
    public com.baidu.adp.lib.network.http.d acC = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean acD = false;
    public boolean acE = false;

    public boolean vj() {
        return this.acD;
    }

    public com.baidu.adp.lib.network.http.g gR() {
        return this.acx;
    }

    public void vk() {
        this.acC = null;
        this.uR = "";
        this.acD = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gf = false;
        this.acB = false;
        this.acA.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete}, expected: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private final byte[] dv(String str) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        int i = 0;
        try {
            try {
                vk();
                if (this.acv != null) {
                    cancel();
                    this.ol = null;
                }
                this.acv = new com.baidu.adp.lib.network.http.e();
                this.acv.gQ().setUrl(str);
                if (this.acw != null) {
                    for (Map.Entry<String, String> entry : this.acw.entrySet()) {
                        this.acv.gQ().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.acv);
                this.ol.e(acy, 0, 0);
                this.acx = this.acv.gR();
                byte[] bArr = this.acv.gR().vf;
                this.responseCode = this.acv.gR().responseCode;
                this.acD = this.acv.gR().gX();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.acv.gR().contentEncoding != null && this.acv.gR().contentEncoding.toLowerCase().contains("gzip")) {
                    this.acB = true;
                    bArr = Q(bArr);
                }
                if (!this.acD) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.acv);
                while (i < this.acv.gS().size()) {
                    this.acC = this.acv.gS().get(i);
                    i++;
                }
                if (this.acC.uR == null) {
                    this.acC.uR = "";
                }
                this.acC.uR = String.valueOf(dVar3.uR) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.acv);
                for (int i2 = 0; i2 < this.acv.gS().size(); i2++) {
                    this.acC = this.acv.gS().get(i2);
                }
                if (this.acC.uR == null) {
                    this.acC.uR = "";
                }
                this.acC.uR = String.valueOf(dVar.uR) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.acv);
            while (i < this.acv.gS().size()) {
                this.acC = this.acv.gS().get(i);
                i++;
            }
            if (this.acC.uR == null) {
                this.acC.uR = "";
            }
            this.acC.uR = String.valueOf(dVar2.uR) + "responseCode:" + this.responseCode;
            throw th;
        }
    }

    private final byte[] Q(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dw(String str) {
        return dv(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=6] */
    public byte[] l(String str, boolean z) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        com.baidu.adp.lib.network.http.d dVar4;
        com.baidu.adp.lib.network.http.d dVar5;
        com.baidu.adp.lib.network.http.d dVar6;
        byte[] bArr;
        int size;
        String str2;
        int i = 0;
        try {
            if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
                try {
                    vk();
                    if (this.acz != null) {
                        cancel();
                    }
                    this.acv = new com.baidu.adp.lib.network.http.e();
                    this.acz = new f(this.acv);
                    this.acv.gQ().setUrl(str);
                    if (this.acw != null) {
                        for (Map.Entry<String, String> entry : this.acw.entrySet()) {
                            this.acv.gQ().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.acz.vh();
                    this.acx = this.acv.gR();
                    bArr = this.acv.gR().vf;
                    this.responseCode = this.acv.gR().responseCode;
                    this.acD = this.acv.gR().gX();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gf = this.acz.fF();
                    this.acE = this.acz.vi();
                    if (!this.acD) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.acv);
                    StringBuilder sb = new StringBuilder(20);
                    int size2 = this.acv.gS().size();
                    sb.append(";ipsize:");
                    sb.append(size2);
                    sb.append(";ips:");
                    for (int i2 = 0; i2 < this.acv.gS().size(); i2++) {
                        this.acC = this.acv.gS().get(i2);
                        sb.append(this.acC.uU);
                        sb.append(",");
                    }
                    if (this.acC.uR == null) {
                        this.acC.uR = "";
                    }
                    this.acC.uR = String.valueOf(dVar4.uR) + sb.toString();
                    this.acC.uR = String.valueOf(dVar5.uR) + "responseCode:" + this.responseCode;
                    this.acC.uR = String.valueOf(dVar6.uR) + " size:" + Integer.toString(this.dataSize);
                    return null;
                }
            } else {
                try {
                    bArr = dv(str);
                    if (bArr == null) {
                        return null;
                    }
                    if (this.acv != null && this.acv.gR().ve != null) {
                        List<String> list = this.acv.gR().ve.get("imgsrc");
                        if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                            i = 1;
                        }
                        List<String> list2 = this.acv.gR().ve.get("Src-Content-Type");
                        if (list2 != null && list2.size() > 0) {
                            if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                                this.Gf = true;
                            } else {
                                this.Gf = false;
                            }
                        }
                        List<String> list3 = this.acv.gR().ve.get("Error-Message");
                        if (list3 != null && list3.size() > 0) {
                            String str3 = list3.get(0);
                            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                                this.acE = false;
                            } else {
                                this.acE = true;
                            }
                        }
                    }
                    if (this.acD && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                        return j(bArr, 23, bArr.length);
                    }
                } catch (Exception e2) {
                    this.uR = String.valueOf(this.uR) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                    return null;
                }
            }
            return bArr;
        } finally {
            TiebaStatic.netImg(this.acv);
            StringBuilder sb2 = new StringBuilder(20);
            int size3 = this.acv.gS().size();
            sb2.append(";ipsize:");
            sb2.append(size3);
            sb2.append(";ips:");
            while (i < this.acv.gS().size()) {
                this.acC = this.acv.gS().get(i);
                sb2.append(this.acC.uU);
                sb2.append(",");
                i++;
            }
            if (this.acC.uR == null) {
                this.acC.uR = "";
            }
            this.acC.uR = String.valueOf(dVar.uR) + sb2.toString();
            this.acC.uR = String.valueOf(dVar2.uR) + "responseCode:" + this.responseCode;
            this.acC.uR = String.valueOf(dVar3.uR) + " size:" + Integer.toString(this.dataSize);
        }
    }

    private static byte[] j(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.acv.gS().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.acv.gS().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uO);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.uM);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uL);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uN);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uQ);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uP);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uT);
                this.acA.add(Integer.valueOf(dVar.uT));
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
            this.uR = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.acD = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.acz != null) {
            this.acz.cancel();
            this.acz = null;
        }
    }

    public boolean vl() {
        if (this.acz == null) {
            return false;
        }
        return this.acz.acm;
    }
}
