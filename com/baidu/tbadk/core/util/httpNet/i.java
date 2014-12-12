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
    private static int KD = 5;
    private com.baidu.adp.lib.network.http.e KA;
    private ImgHttpClient KF;
    private volatile com.baidu.adp.lib.network.http.c cU = null;
    private HashMap<String, String> KB = null;
    private com.baidu.adp.lib.network.http.g KC = new com.baidu.adp.lib.network.http.g();
    public String KE = p.eL();
    public List<Integer> KG = new ArrayList();
    public boolean KH = false;
    public boolean vk = false;
    public String ks = "";
    public com.baidu.adp.lib.network.http.d KI = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean KJ = false;
    public boolean KK = false;

    public boolean qc() {
        return this.KJ;
    }

    public com.baidu.adp.lib.network.http.g dQ() {
        return this.KC;
    }

    public void qd() {
        this.KI = null;
        this.ks = "";
        this.KJ = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.vk = false;
        this.KH = false;
        this.KG.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] cP(String str) {
        int size;
        int i = 0;
        try {
            try {
                qd();
                if (this.KA != null) {
                    cancel();
                    this.cU = null;
                }
                this.KA = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.KE)) {
                    this.KA.dP().p("sid", this.KE);
                }
                this.KA.dP().setUrl(str);
                if (this.KB != null) {
                    for (Map.Entry<String, String> entry : this.KB.entrySet()) {
                        this.KA.dP().o(entry.getKey(), entry.getValue());
                    }
                }
                this.cU = new com.baidu.adp.lib.network.http.c(this.KA);
                this.cU.i(KD, 0, 0);
                this.KC = this.KA.dQ();
                byte[] bArr = this.KA.dQ().kH;
                this.responseCode = this.KA.dQ().responseCode;
                this.KJ = this.KA.dQ().dV();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.KA.dQ().contentEncoding != null && this.KA.dQ().contentEncoding.toLowerCase().contains("gzip")) {
                    this.KH = true;
                    bArr = y(bArr);
                }
                if (!this.KJ) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.KA);
                for (int i2 = 0; i2 < this.KA.dR().size(); i2++) {
                    this.KI = this.KA.dR().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.KA);
            while (i < this.KA.dR().size()) {
                this.KI = this.KA.dR().get(i);
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

    public byte[] cQ(String str) {
        return cP(str);
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
                    qd();
                    if (this.KF != null) {
                        cancel();
                    }
                    this.KA = new com.baidu.adp.lib.network.http.e();
                    this.KF = new ImgHttpClient(this.KA);
                    this.KA.dP().setUrl(str);
                    if (this.KB != null) {
                        for (Map.Entry<String, String> entry : this.KB.entrySet()) {
                            this.KA.dP().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.KF.qa();
                    this.KC = this.KA.dQ();
                    bArr = this.KA.dQ().kH;
                    this.responseCode = this.KA.dQ().responseCode;
                    this.KJ = this.KA.dQ().dV();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.vk = this.KF.cm();
                    this.KK = this.KF.qb();
                    if (!this.KJ) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.KA);
                    for (int i2 = 0; i2 < this.KA.dR().size(); i2++) {
                        this.KI = this.KA.dR().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.KA);
                while (i < this.KA.dR().size()) {
                    this.KI = this.KA.dR().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = cP(str);
                if (bArr == null) {
                    return null;
                }
                if (this.KA != null && this.KA.dQ().kG != null) {
                    List<String> list = this.KA.dQ().kG.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.KA.dQ().kG.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.vk = true;
                        } else {
                            this.vk = false;
                        }
                    }
                    List<String> list3 = this.KA.dQ().kG.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.KK = false;
                        } else {
                            this.KK = true;
                        }
                    }
                }
                if (this.KJ && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return h(bArr, 23, bArr.length);
                }
            } catch (Exception e2) {
                this.ks = String.valueOf(this.ks) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.KA.dR().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.KA.dR().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.ks);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.ko);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.km);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.kp);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.kr);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.kt);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.kq);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.ku);
                this.KG.add(Integer.valueOf(dVar.ku));
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
            this.ks = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.KJ = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.cU != null) {
            this.cU.cancel();
        }
        if (this.KF != null) {
            this.KF.cancel();
            this.KF = null;
        }
    }

    public boolean qe() {
        if (this.KF == null) {
            return false;
        }
        return this.KF.Kr;
    }
}
