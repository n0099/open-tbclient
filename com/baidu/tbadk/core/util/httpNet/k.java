package com.baidu.tbadk.core.util.httpNet;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.f.b {
    private static int Gs = 5;
    private com.baidu.adp.lib.network.http.e Gp;
    private ImgHttpClient Gu;
    private volatile com.baidu.adp.lib.network.http.c aO = null;
    private HashMap<String, String> Gq = null;
    private com.baidu.adp.lib.network.http.g Gr = new com.baidu.adp.lib.network.http.g();
    public String Gt = p.eK();
    public List<Integer> Gv = new ArrayList();
    public boolean Gw = false;
    public boolean sX = false;
    public String kr = "";
    public com.baidu.adp.lib.network.http.d Gx = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean Gy = false;
    public boolean Gz = false;

    public boolean ni() {
        return this.Gy;
    }

    public com.baidu.adp.lib.network.http.g dR() {
        return this.Gr;
    }

    public void nj() {
        this.Gx = null;
        this.kr = "";
        this.Gy = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.sX = false;
        this.Gw = false;
        this.Gv.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] bX(String str) {
        int size;
        int i = 0;
        try {
            try {
                nj();
                if (this.Gp != null) {
                    cancel();
                    this.aO = null;
                }
                this.Gp = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.Gt)) {
                    this.Gp.dQ().l("sid", this.Gt);
                }
                this.Gp.dQ().setUrl(str);
                if (this.Gq != null) {
                    for (Map.Entry<String, String> entry : this.Gq.entrySet()) {
                        this.Gp.dQ().k(entry.getKey(), entry.getValue());
                    }
                }
                this.aO = new com.baidu.adp.lib.network.http.c(this.Gp);
                this.aO.d(Gs, 0, 0);
                this.Gr = this.Gp.dR();
                byte[] bArr = this.Gp.dR().kG;
                this.responseCode = this.Gp.dR().responseCode;
                this.Gy = this.Gp.dR().dW();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Gp.dR().contentEncoding != null && this.Gp.dR().contentEncoding.toLowerCase().contains("gzip")) {
                    this.Gw = true;
                    bArr = y(bArr);
                }
                if (!this.Gy) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.Gp);
                for (int i2 = 0; i2 < this.Gp.dS().size(); i2++) {
                    this.Gx = this.Gp.dS().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.Gp);
            while (i < this.Gp.dS().size()) {
                this.Gx = this.Gp.dS().get(i);
                i++;
            }
        }
    }

    private final byte[] y(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.a(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] bY(String str) {
        return bX(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [278=6] */
    public byte[] j(String str, boolean z) {
        byte[] bArr;
        int size;
        String str2;
        int i = 0;
        if (TbadkApplication.m251getInst().isHttpClientOpen()) {
            try {
                try {
                    nj();
                    if (this.Gu != null) {
                        cancel();
                    }
                    this.Gp = new com.baidu.adp.lib.network.http.e();
                    this.Gu = new ImgHttpClient(this.Gp);
                    this.Gp.dQ().setUrl(str);
                    if (this.Gq != null) {
                        for (Map.Entry<String, String> entry : this.Gq.entrySet()) {
                            this.Gp.dQ().k(entry.getKey(), entry.getValue());
                        }
                    }
                    this.Gu.ng();
                    this.Gr = this.Gp.dR();
                    bArr = this.Gp.dR().kG;
                    this.responseCode = this.Gp.dR().responseCode;
                    this.Gy = this.Gp.dR().dW();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.sX = this.Gu.bM();
                    this.Gz = this.Gu.nh();
                    if (!this.Gy) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.Gp);
                    for (int i2 = 0; i2 < this.Gp.dS().size(); i2++) {
                        this.Gx = this.Gp.dS().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.Gp);
                while (i < this.Gp.dS().size()) {
                    this.Gx = this.Gp.dS().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = bX(str);
                if (bArr == null) {
                    return null;
                }
                if (this.Gp != null && this.Gp.dR().kF != null) {
                    List<String> list = this.Gp.dR().kF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Gp.dR().kF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.sX = true;
                        } else {
                            this.sX = false;
                        }
                    }
                    List<String> list3 = this.Gp.dR().kF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.Gz = false;
                        } else {
                            this.Gz = true;
                        }
                    }
                }
                if (this.Gy && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return f(bArr, 23, bArr.length);
                }
            } catch (Exception e2) {
                this.kr = String.valueOf(this.kr) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return bArr;
    }

    private static byte[] f(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.Gp.dS().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.Gp.dS().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.kr);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.retry);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.km);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.kl);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.ko);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.kq);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.ks);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.kp);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.kt);
                this.Gv.add(Integer.valueOf(dVar.kt));
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
            this.kr = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.Gy = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.aO != null) {
            this.aO.cancel();
        }
        if (this.Gu != null) {
            this.Gu.cancel();
            this.Gu = null;
        }
    }

    public boolean dZ() {
        if (this.Gu == null) {
            return false;
        }
        return this.Gu.mS;
    }
}
