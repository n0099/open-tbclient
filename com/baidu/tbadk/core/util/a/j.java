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
public class j implements a.InterfaceC0005a {
    private static int adU = 5;
    private com.baidu.adp.lib.network.http.e adR;
    private f adV;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> adS = null;
    private com.baidu.adp.lib.network.http.g adT = new com.baidu.adp.lib.network.http.g();
    public List<Integer> adW = new ArrayList();
    public boolean adX = false;
    public boolean GK = false;
    public String uZ = "";
    public com.baidu.adp.lib.network.http.d adY = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean adZ = false;
    public boolean aea = false;

    public boolean vz() {
        return this.adZ;
    }

    public com.baidu.adp.lib.network.http.g gT() {
        return this.adT;
    }

    public void vA() {
        this.adY = null;
        this.uZ = "";
        this.adZ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.GK = false;
        this.adX = false;
        this.adW.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete}, expected: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private final byte[] dI(String str) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        int i = 0;
        try {
            try {
                vA();
                if (this.adR != null) {
                    cancel();
                    this.ol = null;
                }
                this.adR = new com.baidu.adp.lib.network.http.e();
                this.adR.gS().setUrl(str);
                if (this.adS != null) {
                    for (Map.Entry<String, String> entry : this.adS.entrySet()) {
                        this.adR.gS().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.adR);
                this.ol.e(adU, 0, 0);
                this.adT = this.adR.gT();
                byte[] bArr = this.adR.gT().vn;
                this.responseCode = this.adR.gT().responseCode;
                this.adZ = this.adR.gT().gZ();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.adR.gT().contentEncoding != null && this.adR.gT().contentEncoding.toLowerCase().contains("gzip")) {
                    this.adX = true;
                    bArr = Q(bArr);
                }
                if (!this.adZ) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.adR);
                while (i < this.adR.gU().size()) {
                    this.adY = this.adR.gU().get(i);
                    i++;
                }
                if (this.adY.uZ == null) {
                    this.adY.uZ = "";
                }
                this.adY.uZ = String.valueOf(dVar3.uZ) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.adR);
                for (int i2 = 0; i2 < this.adR.gU().size(); i2++) {
                    this.adY = this.adR.gU().get(i2);
                }
                if (this.adY.uZ == null) {
                    this.adY.uZ = "";
                }
                this.adY.uZ = String.valueOf(dVar.uZ) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.adR);
            while (i < this.adR.gU().size()) {
                this.adY = this.adR.gU().get(i);
                i++;
            }
            if (this.adY.uZ == null) {
                this.adY.uZ = "";
            }
            this.adY.uZ = String.valueOf(dVar2.uZ) + "responseCode:" + this.responseCode;
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

    public byte[] dJ(String str) {
        return dI(str);
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
                    vA();
                    if (this.adV != null) {
                        cancel();
                    }
                    this.adR = new com.baidu.adp.lib.network.http.e();
                    this.adV = new f(this.adR);
                    this.adR.gS().setUrl(str);
                    if (this.adS != null) {
                        for (Map.Entry<String, String> entry : this.adS.entrySet()) {
                            this.adR.gS().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.adV.vx();
                    this.adT = this.adR.gT();
                    bArr = this.adR.gT().vn;
                    this.responseCode = this.adR.gT().responseCode;
                    this.adZ = this.adR.gT().gZ();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.GK = this.adV.fF();
                    this.aea = this.adV.vy();
                    if (!this.adZ) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.adR);
                    StringBuilder sb = new StringBuilder(20);
                    int size2 = this.adR.gU().size();
                    sb.append(";ipsize:");
                    sb.append(size2);
                    sb.append(";ips:");
                    for (int i2 = 0; i2 < this.adR.gU().size(); i2++) {
                        this.adY = this.adR.gU().get(i2);
                        sb.append(this.adY.vc);
                        sb.append(",");
                    }
                    if (this.adY.uZ == null) {
                        this.adY.uZ = "";
                    }
                    this.adY.uZ = String.valueOf(dVar4.uZ) + sb.toString();
                    this.adY.uZ = String.valueOf(dVar5.uZ) + "responseCode:" + this.responseCode;
                    this.adY.uZ = String.valueOf(dVar6.uZ) + " size:" + Integer.toString(this.dataSize);
                    return null;
                }
            } else {
                try {
                    bArr = dI(str);
                    if (bArr == null) {
                        return null;
                    }
                    if (this.adR != null && this.adR.gT().vm != null) {
                        List<String> list = this.adR.gT().vm.get("imgsrc");
                        if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                            i = 1;
                        }
                        List<String> list2 = this.adR.gT().vm.get("Src-Content-Type");
                        if (list2 != null && list2.size() > 0) {
                            if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                                this.GK = true;
                            } else {
                                this.GK = false;
                            }
                        }
                        List<String> list3 = this.adR.gT().vm.get("Error-Message");
                        if (list3 != null && list3.size() > 0) {
                            String str3 = list3.get(0);
                            if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                                this.aea = false;
                            } else {
                                this.aea = true;
                            }
                        }
                    }
                    if (this.adZ && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                        return copyOfRange(bArr, 23, bArr.length);
                    }
                } catch (Exception e2) {
                    this.uZ = String.valueOf(this.uZ) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                    return null;
                }
            }
            return bArr;
        } finally {
            TiebaStatic.netImg(this.adR);
            StringBuilder sb2 = new StringBuilder(20);
            int size3 = this.adR.gU().size();
            sb2.append(";ipsize:");
            sb2.append(size3);
            sb2.append(";ips:");
            while (i < this.adR.gU().size()) {
                this.adY = this.adR.gU().get(i);
                sb2.append(this.adY.vc);
                sb2.append(",");
                i++;
            }
            if (this.adY.uZ == null) {
                this.adY.uZ = "";
            }
            this.adY.uZ = String.valueOf(dVar.uZ) + sb2.toString();
            this.adY.uZ = String.valueOf(dVar2.uZ) + "responseCode:" + this.responseCode;
            this.adY.uZ = String.valueOf(dVar3.uZ) + " size:" + Integer.toString(this.dataSize);
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
            for (int i = 0; i < this.adR.gU().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.adR.gU().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uZ);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.va);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.vb);
                this.adW.add(Integer.valueOf(dVar.vb));
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
            this.uZ = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.adZ = false;
        }
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.adV != null) {
            this.adV.cancel();
            this.adV = null;
        }
    }

    public boolean vB() {
        if (this.adV == null) {
            return false;
        }
        return this.adV.adJ;
    }
}
