package com.baidu.tbadk.core.util.httpNet;

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
public class i implements a.InterfaceC0004a {
    private static int aci = 5;
    private com.baidu.adp.lib.network.http.e acf;
    private f acj;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> acg = null;
    private com.baidu.adp.lib.network.http.g ach = new com.baidu.adp.lib.network.http.g();
    public List<Integer> ack = new ArrayList();
    public boolean acl = false;
    public boolean Gd = false;
    public String uT = "";
    public com.baidu.adp.lib.network.http.d acm = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean acn = false;
    public boolean aco = false;

    public boolean vf() {
        return this.acn;
    }

    public com.baidu.adp.lib.network.http.g gT() {
        return this.ach;
    }

    public void vg() {
        this.acm = null;
        this.uT = "";
        this.acn = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gd = false;
        this.acl = false;
        this.ack.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete}, expected: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private final byte[] dj(String str) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        int i = 0;
        try {
            try {
                vg();
                if (this.acf != null) {
                    cancel();
                    this.ol = null;
                }
                this.acf = new com.baidu.adp.lib.network.http.e();
                this.acf.gS().setUrl(str);
                if (this.acg != null) {
                    for (Map.Entry<String, String> entry : this.acg.entrySet()) {
                        this.acf.gS().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.acf);
                this.ol.f(aci, 0, 0);
                this.ach = this.acf.gT();
                byte[] bArr = this.acf.gT().vg;
                this.responseCode = this.acf.gT().responseCode;
                this.acn = this.acf.gT().gY();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.acf.gT().contentEncoding != null && this.acf.gT().contentEncoding.toLowerCase().contains("gzip")) {
                    this.acl = true;
                    bArr = Q(bArr);
                }
                if (!this.acn) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.acf);
                while (i < this.acf.gU().size()) {
                    this.acm = this.acf.gU().get(i);
                    i++;
                }
                if (this.acm.uT == null) {
                    this.acm.uT = "";
                }
                this.acm.uT = String.valueOf(dVar3.uT) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.acf);
                for (int i2 = 0; i2 < this.acf.gU().size(); i2++) {
                    this.acm = this.acf.gU().get(i2);
                }
                if (this.acm.uT == null) {
                    this.acm.uT = "";
                }
                this.acm.uT = String.valueOf(dVar.uT) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.acf);
            while (i < this.acf.gU().size()) {
                this.acm = this.acf.gU().get(i);
                i++;
            }
            if (this.acm.uT == null) {
                this.acm.uT = "";
            }
            this.acm.uT = String.valueOf(dVar2.uT) + "responseCode:" + this.responseCode;
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

    public byte[] dk(String str) {
        return dj(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=6] */
    public byte[] l(String str, boolean z) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        byte[] dj;
        String str2;
        com.baidu.adp.lib.network.http.d dVar3;
        com.baidu.adp.lib.network.http.d dVar4;
        int size;
        int i = 0;
        try {
            if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
                try {
                    vg();
                    if (this.acj != null) {
                        cancel();
                    }
                    this.acf = new com.baidu.adp.lib.network.http.e();
                    this.acj = new f(this.acf);
                    this.acf.gS().setUrl(str);
                    if (this.acg != null) {
                        for (Map.Entry<String, String> entry : this.acg.entrySet()) {
                            this.acf.gS().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.acj.vd();
                    this.ach = this.acf.gT();
                    dj = this.acf.gT().vg;
                    this.responseCode = this.acf.gT().responseCode;
                    this.acn = this.acf.gT().gY();
                    if (dj != null) {
                        this.dataSize = dj.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gd = this.acj.fI();
                    this.aco = this.acj.ve();
                    if (!this.acn) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.acf);
                    StringBuilder sb = new StringBuilder(20);
                    int size2 = this.acf.gU().size();
                    sb.append(";ipsize:");
                    sb.append(size2);
                    sb.append(";ips:");
                    for (int i2 = 0; i2 < this.acf.gU().size(); i2++) {
                        this.acm = this.acf.gU().get(i2);
                        sb.append(this.acm.uW);
                        sb.append(",");
                    }
                    if (this.acm.uT == null) {
                        this.acm.uT = "";
                    }
                    this.acm.uT = String.valueOf(dVar3.uT) + sb.toString();
                    this.acm.uT = String.valueOf(dVar4.uT) + "responseCode:" + this.responseCode;
                    return null;
                }
            } else {
                try {
                    dj = dj(str);
                    if (dj == null) {
                        return null;
                    }
                    if (this.acf != null && this.acf.gT().vf != null) {
                        List<String> list = this.acf.gT().vf.get("imgsrc");
                        if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                            i = 1;
                        }
                        List<String> list2 = this.acf.gT().vf.get("Src-Content-Type");
                        if (list2 != null && list2.size() > 0) {
                            if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                                this.Gd = true;
                            } else {
                                this.Gd = false;
                            }
                        }
                        List<String> list3 = this.acf.gT().vf.get("Error-Message");
                        if (list3 != null && list3.size() > 0) {
                            String str3 = list3.get(0);
                            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                                this.aco = false;
                            } else {
                                this.aco = true;
                            }
                        }
                    }
                    if (this.acn && ((z || i != 0) && new String(dj, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                        return j(dj, 23, dj.length);
                    }
                } catch (Exception e2) {
                    this.uT = String.valueOf(this.uT) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                    return null;
                }
            }
            return dj;
        } finally {
            TiebaStatic.netImg(this.acf);
            StringBuilder sb2 = new StringBuilder(20);
            int size3 = this.acf.gU().size();
            sb2.append(";ipsize:");
            sb2.append(size3);
            sb2.append(";ips:");
            while (i < this.acf.gU().size()) {
                this.acm = this.acf.gU().get(i);
                sb2.append(this.acm.uW);
                sb2.append(",");
                i++;
            }
            if (this.acm.uT == null) {
                this.acm.uT = "";
            }
            this.acm.uT = String.valueOf(dVar.uT) + sb2.toString();
            this.acm.uT = String.valueOf(dVar2.uT) + "responseCode:" + this.responseCode;
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
            for (int i = 0; i < this.acf.gU().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.acf.gU().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uQ);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.uO);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uN);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uP);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uV);
                this.ack.add(Integer.valueOf(dVar.uV));
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
            this.uT = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.acn = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.acj != null) {
            this.acj.cancel();
            this.acj = null;
        }
    }

    public boolean vh() {
        if (this.acj == null) {
            return false;
        }
        return this.acj.abX;
    }
}
