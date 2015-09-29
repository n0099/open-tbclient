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
public class i implements a.InterfaceC0004a {
    private static int acr = 5;
    private com.baidu.adp.lib.network.http.e aco;
    private f acs;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> acp = null;
    private com.baidu.adp.lib.network.http.g acq = new com.baidu.adp.lib.network.http.g();
    public List<Integer> acu = new ArrayList();
    public boolean acv = false;
    public boolean Gd = false;
    public String uR = "";
    public com.baidu.adp.lib.network.http.d acw = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean acx = false;
    public boolean acy = false;

    public boolean vi() {
        return this.acx;
    }

    public com.baidu.adp.lib.network.http.g gQ() {
        return this.acq;
    }

    public void vj() {
        this.acw = null;
        this.uR = "";
        this.acx = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gd = false;
        this.acv = false;
        this.acu.clear();
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
                vj();
                if (this.aco != null) {
                    cancel();
                    this.ol = null;
                }
                this.aco = new com.baidu.adp.lib.network.http.e();
                this.aco.gP().setUrl(str);
                if (this.acp != null) {
                    for (Map.Entry<String, String> entry : this.acp.entrySet()) {
                        this.aco.gP().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.aco);
                this.ol.e(acr, 0, 0);
                this.acq = this.aco.gQ();
                byte[] bArr = this.aco.gQ().vf;
                this.responseCode = this.aco.gQ().responseCode;
                this.acx = this.aco.gQ().gW();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.aco.gQ().contentEncoding != null && this.aco.gQ().contentEncoding.toLowerCase().contains("gzip")) {
                    this.acv = true;
                    bArr = Q(bArr);
                }
                if (!this.acx) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.aco);
                while (i < this.aco.gR().size()) {
                    this.acw = this.aco.gR().get(i);
                    i++;
                }
                if (this.acw.uR == null) {
                    this.acw.uR = "";
                }
                this.acw.uR = String.valueOf(dVar3.uR) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.aco);
                for (int i2 = 0; i2 < this.aco.gR().size(); i2++) {
                    this.acw = this.aco.gR().get(i2);
                }
                if (this.acw.uR == null) {
                    this.acw.uR = "";
                }
                this.acw.uR = String.valueOf(dVar.uR) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.aco);
            while (i < this.aco.gR().size()) {
                this.acw = this.aco.gR().get(i);
                i++;
            }
            if (this.acw.uR == null) {
                this.acw.uR = "";
            }
            this.acw.uR = String.valueOf(dVar2.uR) + "responseCode:" + this.responseCode;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=6, 299=6] */
    public byte[] l(String str, boolean z) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        com.baidu.adp.lib.network.http.d dVar4;
        com.baidu.adp.lib.network.http.d dVar5;
        com.baidu.adp.lib.network.http.d dVar6;
        com.baidu.adp.lib.network.http.d dVar7;
        com.baidu.adp.lib.network.http.d dVar8;
        byte[] bArr;
        int size;
        String str2;
        int i = 0;
        try {
            if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
                try {
                    vj();
                    if (this.acs != null) {
                        cancel();
                    }
                    this.aco = new com.baidu.adp.lib.network.http.e();
                    this.acs = new f(this.aco);
                    this.aco.gP().setUrl(str);
                    if (this.acp != null) {
                        for (Map.Entry<String, String> entry : this.acp.entrySet()) {
                            this.aco.gP().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.acs.vf();
                    this.acq = this.aco.gQ();
                    bArr = this.aco.gQ().vf;
                    this.responseCode = this.aco.gQ().responseCode;
                    this.acx = this.aco.gQ().gW();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gd = this.acs.fF();
                    this.acy = this.acs.vg();
                    if (!this.acx) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.aco);
                    StringBuilder sb = new StringBuilder(20);
                    int size2 = this.aco.gR().size();
                    sb.append(";ipsize:");
                    sb.append(size2);
                    sb.append(";ips:");
                    for (int i2 = 0; i2 < this.aco.gR().size(); i2++) {
                        this.acw = this.aco.gR().get(i2);
                        sb.append(this.acw.uU);
                        sb.append(",");
                    }
                    if (this.acw.uR == null) {
                        this.acw.uR = "";
                    }
                    this.acw.uR = String.valueOf(dVar5.uR) + sb.toString();
                    this.acw.uR = String.valueOf(dVar6.uR) + "responseCode:" + this.responseCode;
                    if (403 == this.responseCode) {
                        this.acw.uR = String.valueOf(dVar7.uR) + "Host:" + this.acs.vh();
                        this.acs.du(null);
                        this.acw.uR = String.valueOf(dVar8.uR) + "IpList:" + e.getInstance().getAllIPListCanUsed();
                        return null;
                    }
                    return null;
                }
            } else {
                try {
                    bArr = dv(str);
                    if (bArr == null) {
                        return null;
                    }
                    if (this.aco != null && this.aco.gQ().ve != null) {
                        List<String> list = this.aco.gQ().ve.get("imgsrc");
                        if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                            i = 1;
                        }
                        List<String> list2 = this.aco.gQ().ve.get("Src-Content-Type");
                        if (list2 != null && list2.size() > 0) {
                            if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                                this.Gd = true;
                            } else {
                                this.Gd = false;
                            }
                        }
                        List<String> list3 = this.aco.gQ().ve.get("Error-Message");
                        if (list3 != null && list3.size() > 0) {
                            String str3 = list3.get(0);
                            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                                this.acy = false;
                            } else {
                                this.acy = true;
                            }
                        }
                    }
                    if (this.acx && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                        return j(bArr, 23, bArr.length);
                    }
                } catch (Exception e2) {
                    this.uR = String.valueOf(this.uR) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                    return null;
                }
            }
            return bArr;
        } finally {
            TiebaStatic.netImg(this.aco);
            StringBuilder sb2 = new StringBuilder(20);
            int size3 = this.aco.gR().size();
            sb2.append(";ipsize:");
            sb2.append(size3);
            sb2.append(";ips:");
            while (i < this.aco.gR().size()) {
                this.acw = this.aco.gR().get(i);
                sb2.append(this.acw.uU);
                sb2.append(",");
                i++;
            }
            if (this.acw.uR == null) {
                this.acw.uR = "";
            }
            this.acw.uR = String.valueOf(dVar.uR) + sb2.toString();
            this.acw.uR = String.valueOf(dVar2.uR) + "responseCode:" + this.responseCode;
            if (403 == this.responseCode) {
                this.acw.uR = String.valueOf(dVar3.uR) + "Host:" + this.acs.vh();
                this.acs.du(null);
                this.acw.uR = String.valueOf(dVar4.uR) + "IpList:" + e.getInstance().getAllIPListCanUsed();
            }
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
            for (int i = 0; i < this.aco.gR().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.aco.gR().get(i);
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
                this.acu.add(Integer.valueOf(dVar.uT));
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
            this.acx = false;
        }
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.acs != null) {
            this.acs.cancel();
            this.acs = null;
        }
    }

    public boolean vk() {
        if (this.acs == null) {
            return false;
        }
        return this.acs.acg;
    }
}
