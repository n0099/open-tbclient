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
    private static int Wy = 5;
    private ImgHttpClient WA;
    private com.baidu.adp.lib.network.http.e Wv;
    private volatile com.baidu.adp.lib.network.http.c of = null;
    private HashMap<String, String> Ww = null;
    private com.baidu.adp.lib.network.http.g Wx = new com.baidu.adp.lib.network.http.g();
    public String Wz = p.ik();
    public List<Integer> WB = new ArrayList();
    public boolean WC = false;
    public boolean Gm = false;
    public String vL = "";
    public com.baidu.adp.lib.network.http.d WD = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean WE = false;
    public boolean WF = false;

    public boolean tw() {
        return this.WE;
    }

    public com.baidu.adp.lib.network.http.g hn() {
        return this.Wx;
    }

    public void tx() {
        this.WD = null;
        this.vL = "";
        this.WE = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gm = false;
        this.WC = false;
        this.WB.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] cU(String str) {
        int size;
        int i = 0;
        try {
            try {
                tx();
                if (this.Wv != null) {
                    cancel();
                    this.of = null;
                }
                this.Wv = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.Wz)) {
                    this.Wv.hm().p("sid", this.Wz);
                }
                this.Wv.hm().setUrl(str);
                if (this.Ww != null) {
                    for (Map.Entry<String, String> entry : this.Ww.entrySet()) {
                        this.Wv.hm().o(entry.getKey(), entry.getValue());
                    }
                }
                this.of = new com.baidu.adp.lib.network.http.c(this.Wv);
                this.of.i(Wy, 0, 0);
                this.Wx = this.Wv.hn();
                byte[] bArr = this.Wv.hn().vY;
                this.responseCode = this.Wv.hn().responseCode;
                this.WE = this.Wv.hn().hs();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Wv.hn().contentEncoding != null && this.Wv.hn().contentEncoding.toLowerCase().contains("gzip")) {
                    this.WC = true;
                    bArr = z(bArr);
                }
                if (!this.WE) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.Wv);
                for (int i2 = 0; i2 < this.Wv.ho().size(); i2++) {
                    this.WD = this.Wv.ho().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.Wv);
            while (i < this.Wv.ho().size()) {
                this.WD = this.Wv.ho().get(i);
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
                    if (this.WA != null) {
                        cancel();
                    }
                    this.Wv = new com.baidu.adp.lib.network.http.e();
                    this.WA = new ImgHttpClient(this.Wv);
                    this.Wv.hm().setUrl(str);
                    if (this.Ww != null) {
                        for (Map.Entry<String, String> entry : this.Ww.entrySet()) {
                            this.Wv.hm().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.WA.tu();
                    this.Wx = this.Wv.hn();
                    bArr = this.Wv.hn().vY;
                    this.responseCode = this.Wv.hn().responseCode;
                    this.WE = this.Wv.hn().hs();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gm = this.WA.fI();
                    this.WF = this.WA.tv();
                    if (!this.WE) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.Wv);
                    for (int i2 = 0; i2 < this.Wv.ho().size(); i2++) {
                        this.WD = this.Wv.ho().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.Wv);
                while (i < this.Wv.ho().size()) {
                    this.WD = this.Wv.ho().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = cU(str);
                if (bArr == null) {
                    return null;
                }
                if (this.Wv != null && this.Wv.hn().vX != null) {
                    List<String> list = this.Wv.hn().vX.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Wv.hn().vX.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Gm = true;
                        } else {
                            this.Gm = false;
                        }
                    }
                    List<String> list3 = this.Wv.hn().vX.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.WF = false;
                        } else {
                            this.WF = true;
                        }
                    }
                }
                if (this.WE && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
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
            for (int i = 0; i < this.Wv.ho().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.Wv.ho().get(i);
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
                this.WB.add(Integer.valueOf(dVar.vN));
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
            this.WE = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.of != null) {
            this.of.cancel();
        }
        if (this.WA != null) {
            this.WA.cancel();
            this.WA = null;
        }
    }

    public boolean ty() {
        if (this.WA == null) {
            return false;
        }
        return this.WA.Wl;
    }
}
