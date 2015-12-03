package com.baidu.tbadk.core.util.a;

import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
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
    private static int adq = 5;
    private com.baidu.adp.lib.network.http.e adn;
    private f adr;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> ado = null;
    private com.baidu.adp.lib.network.http.g adp = new com.baidu.adp.lib.network.http.g();
    public List<Integer> ads = new ArrayList();
    public boolean adt = false;
    public boolean Gu = false;
    public String uX = "";
    public com.baidu.adp.lib.network.http.d adu = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean adv = false;
    public boolean adw = false;

    public boolean vP() {
        return this.adv;
    }

    public com.baidu.adp.lib.network.http.g gT() {
        return this.adp;
    }

    public void vQ() {
        this.adu = null;
        this.uX = "";
        this.adv = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gu = false;
        this.adt = false;
        this.ads.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete}, expected: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private final byte[] dF(String str) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        int i = 0;
        try {
            try {
                vQ();
                if (this.adn != null) {
                    cancel();
                    this.ol = null;
                }
                this.adn = new com.baidu.adp.lib.network.http.e();
                this.adn.gS().setUrl(str);
                if (this.ado != null) {
                    for (Map.Entry<String, String> entry : this.ado.entrySet()) {
                        this.adn.gS().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.adn);
                this.ol.e(adq, 0, 0);
                this.adp = this.adn.gT();
                byte[] bArr = this.adn.gT().vl;
                this.responseCode = this.adn.gT().responseCode;
                this.adv = this.adn.gT().gZ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.adn.gT().contentEncoding != null && this.adn.gT().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adt = true;
                    bArr = Q(bArr);
                }
                if (!this.adv) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.adn);
                while (i < this.adn.gU().size()) {
                    this.adu = this.adn.gU().get(i);
                    i++;
                }
                if (this.adu.uX == null) {
                    this.adu.uX = "";
                }
                this.adu.uX = String.valueOf(dVar3.uX) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.adn);
                for (int i2 = 0; i2 < this.adn.gU().size(); i2++) {
                    this.adu = this.adn.gU().get(i2);
                }
                if (this.adu.uX == null) {
                    this.adu.uX = "";
                }
                this.adu.uX = String.valueOf(dVar.uX) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.adn);
            while (i < this.adn.gU().size()) {
                this.adu = this.adn.gU().get(i);
                i++;
            }
            if (this.adu.uX == null) {
                this.adu.uX = "";
            }
            this.adu.uX = String.valueOf(dVar2.uX) + "responseCode:" + this.responseCode;
            throw th;
        }
    }

    private final byte[] Q(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] dG(String str) {
        return dF(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=6] */
    public byte[] m(String str, boolean z) {
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
                    vQ();
                    if (this.adr != null) {
                        cancel();
                    }
                    this.adn = new com.baidu.adp.lib.network.http.e();
                    this.adr = new f(this.adn);
                    this.adn.gS().setUrl(str);
                    if (this.ado != null) {
                        for (Map.Entry<String, String> entry : this.ado.entrySet()) {
                            this.adn.gS().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adr.vN();
                    this.adp = this.adn.gT();
                    bArr = this.adn.gT().vl;
                    this.responseCode = this.adn.gT().responseCode;
                    this.adv = this.adn.gT().gZ();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gu = this.adr.fF();
                    this.adw = this.adr.vO();
                    if (!this.adv) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.adn);
                    StringBuilder sb = new StringBuilder(20);
                    int size2 = this.adn.gU().size();
                    sb.append(";ipsize:");
                    sb.append(size2);
                    sb.append(";ips:");
                    for (int i2 = 0; i2 < this.adn.gU().size(); i2++) {
                        this.adu = this.adn.gU().get(i2);
                        sb.append(this.adu.va);
                        sb.append(",");
                    }
                    if (this.adu.uX == null) {
                        this.adu.uX = "";
                    }
                    this.adu.uX = String.valueOf(dVar4.uX) + sb.toString();
                    this.adu.uX = String.valueOf(dVar5.uX) + "responseCode:" + this.responseCode;
                    this.adu.uX = String.valueOf(dVar6.uX) + " size:" + Integer.toString(this.dataSize);
                    return null;
                }
            } else {
                try {
                    bArr = dF(str);
                    if (bArr == null) {
                        return null;
                    }
                    if (this.adn != null && this.adn.gT().vk != null) {
                        List<String> list = this.adn.gT().vk.get("imgsrc");
                        if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                            i = 1;
                        }
                        List<String> list2 = this.adn.gT().vk.get("Src-Content-Type");
                        if (list2 != null && list2.size() > 0) {
                            if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                                this.Gu = true;
                            } else {
                                this.Gu = false;
                            }
                        }
                        List<String> list3 = this.adn.gT().vk.get("Error-Message");
                        if (list3 != null && list3.size() > 0) {
                            String str3 = list3.get(0);
                            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                                this.adw = false;
                            } else {
                                this.adw = true;
                            }
                        }
                    }
                    if (this.adv && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                        return copyOfRange(bArr, 23, bArr.length);
                    }
                } catch (Exception e2) {
                    this.uX = String.valueOf(this.uX) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                    return null;
                }
            }
            return bArr;
        } finally {
            TiebaStatic.netImg(this.adn);
            StringBuilder sb2 = new StringBuilder(20);
            int size3 = this.adn.gU().size();
            sb2.append(";ipsize:");
            sb2.append(size3);
            sb2.append(";ips:");
            while (i < this.adn.gU().size()) {
                this.adu = this.adn.gU().get(i);
                sb2.append(this.adu.va);
                sb2.append(",");
                i++;
            }
            if (this.adu.uX == null) {
                this.adu.uX = "";
            }
            this.adu.uX = String.valueOf(dVar.uX) + sb2.toString();
            this.adu.uX = String.valueOf(dVar2.uX) + "responseCode:" + this.responseCode;
            this.adu.uX = String.valueOf(dVar3.uX) + " size:" + Integer.toString(this.dataSize);
        }
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
            for (int i = 0; i < this.adn.gU().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.adn.gU().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uZ);
                this.ads.add(Integer.valueOf(dVar.uZ));
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
            this.uX = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.adv = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0004a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.adr != null) {
            this.adr.cancel();
            this.adr = null;
        }
    }

    public boolean vR() {
        if (this.adr == null) {
            return false;
        }
        return this.adr.adf;
    }
}
