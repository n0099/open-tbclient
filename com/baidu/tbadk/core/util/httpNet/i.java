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
    private static int KU = 5;
    private com.baidu.adp.lib.network.http.e KR;
    private ImgHttpClient KW;
    private volatile com.baidu.adp.lib.network.http.c cV = null;
    private HashMap<String, String> KS = null;
    private com.baidu.adp.lib.network.http.g KT = new com.baidu.adp.lib.network.http.g();
    public String KV = p.eJ();
    public List<Integer> KX = new ArrayList();
    public boolean KY = false;
    public boolean vn = false;
    public String kv = "";
    public com.baidu.adp.lib.network.http.d KZ = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean La = false;
    public boolean Lb = false;

    public boolean qg() {
        return this.La;
    }

    public com.baidu.adp.lib.network.http.g dO() {
        return this.KT;
    }

    public void qh() {
        this.KZ = null;
        this.kv = "";
        this.La = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.vn = false;
        this.KY = false;
        this.KX.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    private final byte[] cL(String str) {
        int size;
        int i = 0;
        try {
            try {
                qh();
                if (this.KR != null) {
                    cancel();
                    this.cV = null;
                }
                this.KR = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.KV)) {
                    this.KR.dN().p("sid", this.KV);
                }
                this.KR.dN().setUrl(str);
                if (this.KS != null) {
                    for (Map.Entry<String, String> entry : this.KS.entrySet()) {
                        this.KR.dN().o(entry.getKey(), entry.getValue());
                    }
                }
                this.cV = new com.baidu.adp.lib.network.http.c(this.KR);
                this.cV.i(KU, 0, 0);
                this.KT = this.KR.dO();
                byte[] bArr = this.KR.dO().kK;
                this.responseCode = this.KR.dO().responseCode;
                this.La = this.KR.dO().dT();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.KR.dO().contentEncoding != null && this.KR.dO().contentEncoding.toLowerCase().contains("gzip")) {
                    this.KY = true;
                    bArr = y(bArr);
                }
                if (!this.La) {
                    a(str, null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.KR);
                for (int i2 = 0; i2 < this.KR.dP().size(); i2++) {
                    this.KZ = this.KR.dP().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.KR);
            while (i < this.KR.dP().size()) {
                this.KZ = this.KR.dP().get(i);
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

    public byte[] cM(String str) {
        return cL(str);
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
                    qh();
                    if (this.KW != null) {
                        cancel();
                    }
                    this.KR = new com.baidu.adp.lib.network.http.e();
                    this.KW = new ImgHttpClient(this.KR);
                    this.KR.dN().setUrl(str);
                    if (this.KS != null) {
                        for (Map.Entry<String, String> entry : this.KS.entrySet()) {
                            this.KR.dN().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.KW.qe();
                    this.KT = this.KR.dO();
                    bArr = this.KR.dO().kK;
                    this.responseCode = this.KR.dO().responseCode;
                    this.La = this.KR.dO().dT();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.vn = this.KW.ck();
                    this.Lb = this.KW.qf();
                    if (!this.La) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.KR);
                    for (int i2 = 0; i2 < this.KR.dP().size(); i2++) {
                        this.KZ = this.KR.dP().get(i2);
                    }
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.KR);
                while (i < this.KR.dP().size()) {
                    this.KZ = this.KR.dP().get(i);
                    i++;
                }
            }
        } else {
            try {
                bArr = cL(str);
                if (bArr == null) {
                    return null;
                }
                if (this.KR != null && this.KR.dO().kJ != null) {
                    List<String> list = this.KR.dO().kJ.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.KR.dO().kJ.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.vn = true;
                        } else {
                            this.vn = false;
                        }
                    }
                    List<String> list3 = this.KR.dO().kJ.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.Lb = false;
                        } else {
                            this.Lb = true;
                        }
                    }
                }
                if (this.La && ((z || i != 0) && new String(bArr, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
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
            for (int i = 0; i < this.KR.dP().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.KR.dP().get(i);
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
                this.KX.add(Integer.valueOf(dVar.ky));
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
            this.La = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.cV != null) {
            this.cV.cancel();
        }
        if (this.KW != null) {
            this.KW.cancel();
            this.KW = null;
        }
    }

    public boolean qi() {
        if (this.KW == null) {
            return false;
        }
        return this.KW.KH;
    }
}
