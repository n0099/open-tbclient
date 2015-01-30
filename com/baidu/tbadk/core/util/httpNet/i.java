package com.baidu.tbadk.core.util.httpNet;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.lib.f.b {
    private static int KX = 5;
    private com.baidu.adp.lib.network.http.e KU;
    private ImgHttpClient KZ;
    private volatile com.baidu.adp.lib.network.http.c cV = null;
    private HashMap<String, String> KV = null;
    private com.baidu.adp.lib.network.http.g KW = new com.baidu.adp.lib.network.http.g();
    public String KY = p.eJ();
    public List<Integer> La = new ArrayList();
    public boolean Lb = false;
    public boolean vq = false;
    public String kv = "";
    public com.baidu.adp.lib.network.http.d Lc = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean Ld = false;
    public boolean Le = false;

    public boolean qn() {
        return this.Ld;
    }

    public com.baidu.adp.lib.network.http.g dO() {
        return this.KW;
    }

    public void qo() {
        this.Lc = null;
        this.kv = "";
        this.Ld = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.vq = false;
        this.Lb = false;
        this.La.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] cO(String str) {
        int size;
        int i = 0;
        try {
            try {
                qo();
                if (this.KU != null) {
                    cancel();
                    this.cV = null;
                }
                this.KU = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.KY)) {
                    this.KU.dN().p("sid", this.KY);
                }
                this.KU.dN().setUrl(str);
                if (this.KV != null) {
                    for (Map.Entry<String, String> entry : this.KV.entrySet()) {
                        this.KU.dN().o(entry.getKey(), entry.getValue());
                    }
                }
                this.cV = new com.baidu.adp.lib.network.http.c(this.KU);
                this.cV.i(KX, 0, 0);
                this.KW = this.KU.dO();
                byte[] bArr = this.KU.dO().kK;
                this.responseCode = this.KU.dO().responseCode;
                this.Ld = this.KU.dO().dT();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.KU.dO().contentEncoding != null && this.KU.dO().contentEncoding.toLowerCase().contains("gzip")) {
                    this.Lb = true;
                    bArr = y(bArr);
                }
                if (!this.Ld) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.KU);
                for (int i2 = 0; i2 < this.KU.dP().size(); i2++) {
                    this.Lc = this.KU.dP().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.KU);
            while (i < this.KU.dP().size()) {
                this.Lc = this.KU.dP().get(i);
                i++;
            }
        }
    }

    private final byte[] y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] cP(String str) {
        return cO(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [278=6] */
    public byte[] l(String str, boolean z) {
        byte[] bArr;
        int size;
        String str2;
        int i = 0;
        if (TbadkCoreApplication.m255getInst().isHttpClientOpen()) {
            try {
                try {
                    qo();
                    if (this.KZ != null) {
                        cancel();
                    }
                    this.KU = new com.baidu.adp.lib.network.http.e();
                    this.KZ = new ImgHttpClient(this.KU);
                    this.KU.dN().setUrl(str);
                    if (this.KV != null) {
                        for (Map.Entry<String, String> entry : this.KV.entrySet()) {
                            this.KU.dN().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.KZ.ql();
                    this.KW = this.KU.dO();
                    bArr = this.KU.dO().kK;
                    this.responseCode = this.KU.dO().responseCode;
                    this.Ld = this.KU.dO().dT();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.vq = this.KZ.ck();
                    this.Le = this.KZ.qm();
                    if (!this.Ld) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.KU);
                    for (int i2 = 0; i2 < this.KU.dP().size(); i2++) {
                        this.Lc = this.KU.dP().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.KU);
                while (i < this.KU.dP().size()) {
                    this.Lc = this.KU.dP().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = cO(str);
                if (bArr == null) {
                    return null;
                }
                if (this.KU != null && this.KU.dO().kJ != null) {
                    List<String> list = this.KU.dO().kJ.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.KU.dO().kJ.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.vq = true;
                        } else {
                            this.vq = false;
                        }
                    }
                    List<String> list3 = this.KU.dO().kJ.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.Le = false;
                        } else {
                            this.Le = true;
                        }
                    }
                }
                if (this.Ld && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return h(bArr, 23, bArr.length);
                }
            } catch (Exception e2) {
                this.kv = String.valueOf(this.kv) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return bArr;
    }

    private static byte[] h(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.KU.dP().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.KU.dP().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.kv);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.kr);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.kq);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ks);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.ku);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.kx);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.kt);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ky);
                this.La.add(Integer.valueOf(dVar.ky));
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
            this.kv = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.Ld = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.cV != null) {
            this.cV.cancel();
        }
        if (this.KZ != null) {
            this.KZ.cancel();
            this.KZ = null;
        }
    }

    public boolean qp() {
        if (this.KZ == null) {
            return false;
        }
        return this.KZ.KK;
    }
}
