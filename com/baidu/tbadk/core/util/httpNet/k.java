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
    private static int Gt = 5;
    private com.baidu.adp.lib.network.http.e Gq;
    private ImgHttpClient Gv;
    private volatile com.baidu.adp.lib.network.http.c aO = null;
    private HashMap<String, String> Gr = null;
    private com.baidu.adp.lib.network.http.g Gs = new com.baidu.adp.lib.network.http.g();
    public String Gu = p.eK();
    public List<Integer> Gw = new ArrayList();
    public boolean Gx = false;
    public boolean sX = false;
    public String kr = "";
    public com.baidu.adp.lib.network.http.d Gy = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean Gz = false;
    public boolean GA = false;

    public boolean ni() {
        return this.Gz;
    }

    public com.baidu.adp.lib.network.http.g dR() {
        return this.Gs;
    }

    public void nj() {
        this.Gy = null;
        this.kr = "";
        this.Gz = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.sX = false;
        this.Gx = false;
        this.Gw.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] bX(String str) {
        int size;
        int i = 0;
        try {
            try {
                nj();
                if (this.Gq != null) {
                    cancel();
                    this.aO = null;
                }
                this.Gq = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.Gu)) {
                    this.Gq.dQ().l("sid", this.Gu);
                }
                this.Gq.dQ().setUrl(str);
                if (this.Gr != null) {
                    for (Map.Entry<String, String> entry : this.Gr.entrySet()) {
                        this.Gq.dQ().k(entry.getKey(), entry.getValue());
                    }
                }
                this.aO = new com.baidu.adp.lib.network.http.c(this.Gq);
                this.aO.d(Gt, 0, 0);
                this.Gs = this.Gq.dR();
                byte[] bArr = this.Gq.dR().kG;
                this.responseCode = this.Gq.dR().responseCode;
                this.Gz = this.Gq.dR().dW();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Gq.dR().contentEncoding != null && this.Gq.dR().contentEncoding.toLowerCase().contains("gzip")) {
                    this.Gx = true;
                    bArr = y(bArr);
                }
                if (!this.Gz) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.Gq);
                for (int i2 = 0; i2 < this.Gq.dS().size(); i2++) {
                    this.Gy = this.Gq.dS().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.Gq);
            while (i < this.Gq.dS().size()) {
                this.Gy = this.Gq.dS().get(i);
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
                    if (this.Gv != null) {
                        cancel();
                    }
                    this.Gq = new com.baidu.adp.lib.network.http.e();
                    this.Gv = new ImgHttpClient(this.Gq);
                    this.Gq.dQ().setUrl(str);
                    if (this.Gr != null) {
                        for (Map.Entry<String, String> entry : this.Gr.entrySet()) {
                            this.Gq.dQ().k(entry.getKey(), entry.getValue());
                        }
                    }
                    this.Gv.ng();
                    this.Gs = this.Gq.dR();
                    bArr = this.Gq.dR().kG;
                    this.responseCode = this.Gq.dR().responseCode;
                    this.Gz = this.Gq.dR().dW();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.sX = this.Gv.bM();
                    this.GA = this.Gv.nh();
                    if (!this.Gz) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.Gq);
                    for (int i2 = 0; i2 < this.Gq.dS().size(); i2++) {
                        this.Gy = this.Gq.dS().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.Gq);
                while (i < this.Gq.dS().size()) {
                    this.Gy = this.Gq.dS().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = bX(str);
                if (bArr == null) {
                    return null;
                }
                if (this.Gq != null && this.Gq.dR().kF != null) {
                    List<String> list = this.Gq.dR().kF.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Gq.dR().kF.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.sX = true;
                        } else {
                            this.sX = false;
                        }
                    }
                    List<String> list3 = this.Gq.dR().kF.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.GA = false;
                        } else {
                            this.GA = true;
                        }
                    }
                }
                if (this.Gz && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
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
            for (int i = 0; i < this.Gq.dS().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.Gq.dS().get(i);
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
                this.Gw.add(Integer.valueOf(dVar.kt));
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
            this.Gz = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.aO != null) {
            this.aO.cancel();
        }
        if (this.Gv != null) {
            this.Gv.cancel();
            this.Gv = null;
        }
    }

    public boolean dZ() {
        if (this.Gv == null) {
            return false;
        }
        return this.Gv.mS;
    }
}
