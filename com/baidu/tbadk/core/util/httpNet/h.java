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
public class h implements com.baidu.adp.lib.f.b {
    private static int Ww = 5;
    private com.baidu.adp.lib.network.http.e Wt;
    private ImgHttpClient Wy;
    private volatile com.baidu.adp.lib.network.http.c of = null;
    private HashMap<String, String> Wu = null;
    private com.baidu.adp.lib.network.http.g Wv = new com.baidu.adp.lib.network.http.g();
    public String Wx = p.ik();
    public List<Integer> Wz = new ArrayList();
    public boolean WA = false;
    public boolean Gk = false;
    public String vL = "";
    public com.baidu.adp.lib.network.http.d WB = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean WC = false;
    public boolean WD = false;

    public boolean tw() {
        return this.WC;
    }

    public com.baidu.adp.lib.network.http.g hn() {
        return this.Wv;
    }

    public void tx() {
        this.WB = null;
        this.vL = "";
        this.WC = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gk = false;
        this.WA = false;
        this.Wz.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] cU(String str) {
        int size;
        int i = 0;
        try {
            try {
                tx();
                if (this.Wt != null) {
                    cancel();
                    this.of = null;
                }
                this.Wt = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.Wx)) {
                    this.Wt.hm().p("sid", this.Wx);
                }
                this.Wt.hm().setUrl(str);
                if (this.Wu != null) {
                    for (Map.Entry<String, String> entry : this.Wu.entrySet()) {
                        this.Wt.hm().o(entry.getKey(), entry.getValue());
                    }
                }
                this.of = new com.baidu.adp.lib.network.http.c(this.Wt);
                this.of.i(Ww, 0, 0);
                this.Wv = this.Wt.hn();
                byte[] bArr = this.Wt.hn().vY;
                this.responseCode = this.Wt.hn().responseCode;
                this.WC = this.Wt.hn().hs();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Wt.hn().contentEncoding != null && this.Wt.hn().contentEncoding.toLowerCase().contains("gzip")) {
                    this.WA = true;
                    bArr = z(bArr);
                }
                if (!this.WC) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.Wt);
                for (int i2 = 0; i2 < this.Wt.ho().size(); i2++) {
                    this.WB = this.Wt.ho().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.Wt);
            while (i < this.Wt.ho().size()) {
                this.WB = this.Wt.ho().get(i);
                i++;
            }
        }
    }

    private final byte[] z(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] cV(String str) {
        return cU(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [278=6] */
    public byte[] l(String str, boolean z) {
        byte[] bArr;
        int size;
        String str2;
        int i = 0;
        if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
            try {
                try {
                    tx();
                    if (this.Wy != null) {
                        cancel();
                    }
                    this.Wt = new com.baidu.adp.lib.network.http.e();
                    this.Wy = new ImgHttpClient(this.Wt);
                    this.Wt.hm().setUrl(str);
                    if (this.Wu != null) {
                        for (Map.Entry<String, String> entry : this.Wu.entrySet()) {
                            this.Wt.hm().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.Wy.tu();
                    this.Wv = this.Wt.hn();
                    bArr = this.Wt.hn().vY;
                    this.responseCode = this.Wt.hn().responseCode;
                    this.WC = this.Wt.hn().hs();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gk = this.Wy.fI();
                    this.WD = this.Wy.tv();
                    if (!this.WC) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.Wt);
                    for (int i2 = 0; i2 < this.Wt.ho().size(); i2++) {
                        this.WB = this.Wt.ho().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.Wt);
                while (i < this.Wt.ho().size()) {
                    this.WB = this.Wt.ho().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = cU(str);
                if (bArr == null) {
                    return null;
                }
                if (this.Wt != null && this.Wt.hn().vX != null) {
                    List<String> list = this.Wt.hn().vX.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Wt.hn().vX.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Gk = true;
                        } else {
                            this.Gk = false;
                        }
                    }
                    List<String> list3 = this.Wt.hn().vX.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.WD = false;
                        } else {
                            this.WD = true;
                        }
                    }
                }
                if (this.WC && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return h(bArr, 23, bArr.length);
                }
            } catch (Exception e2) {
                this.vL = String.valueOf(this.vL) + "BDIMAGE DECODE ERROR" + e2.getMessage();
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
            for (int i = 0; i < this.Wt.ho().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.Wt.ho().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.vL);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.vI);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.vG);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.vF);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.vH);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.vK);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.vM);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.vJ);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.vN);
                this.Wz.add(Integer.valueOf(dVar.vN));
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
            this.vL = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.WC = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.of != null) {
            this.of.cancel();
        }
        if (this.Wy != null) {
            this.Wy.cancel();
            this.Wy = null;
        }
    }

    public boolean ty() {
        if (this.Wy == null) {
            return false;
        }
        return this.Wy.Wj;
    }
}
