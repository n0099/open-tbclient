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
    private static int Xj = 5;
    private com.baidu.adp.lib.network.http.e Xg;
    private ImgHttpClient Xl;
    private volatile com.baidu.adp.lib.network.http.c ol = null;
    private HashMap<String, String> Xh = null;
    private com.baidu.adp.lib.network.http.g Xi = new com.baidu.adp.lib.network.http.g();
    public String Xk = p.hT();
    public List<Integer> Xm = new ArrayList();
    public boolean Xn = false;
    public boolean Gc = false;
    public String uX = "";
    public com.baidu.adp.lib.network.http.d Xo = null;
    public int dataSize = -1;
    public int responseCode = -1;
    private boolean Xp = false;
    public boolean Xq = false;

    public boolean ub() {
        return this.Xp;
    }

    public com.baidu.adp.lib.network.http.g gZ() {
        return this.Xi;
    }

    public void uc() {
        this.Xo = null;
        this.uX = "";
        this.Xp = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.Gc = false;
        this.Xn = false;
        this.Xm.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=6] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, MOVE, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete}, expected: {[IGET, INVOKE, IGET, INVOKE, INVOKE, CHECK_CAST, IPUT, ARITH, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, CONST_STR, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IGET, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF, IGET, IGET, IF, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private final byte[] di(String str) {
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        com.baidu.adp.lib.network.http.d dVar3;
        int i = 0;
        try {
            try {
                uc();
                if (this.Xg != null) {
                    cancel();
                    this.ol = null;
                }
                this.Xg = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.Xk)) {
                    this.Xg.gY().p("sid", this.Xk);
                }
                this.Xg.gY().setUrl(str);
                if (this.Xh != null) {
                    for (Map.Entry<String, String> entry : this.Xh.entrySet()) {
                        this.Xg.gY().o(entry.getKey(), entry.getValue());
                    }
                }
                this.ol = new com.baidu.adp.lib.network.http.c(this.Xg);
                this.ol.i(Xj, 0, 0);
                this.Xi = this.Xg.gZ();
                byte[] bArr = this.Xg.gZ().vk;
                this.responseCode = this.Xg.gZ().responseCode;
                this.Xp = this.Xg.gZ().he();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.Xg.gZ().contentEncoding != null && this.Xg.gZ().contentEncoding.toLowerCase().contains("gzip")) {
                    this.Xn = true;
                    bArr = z(bArr);
                }
                if (!this.Xp) {
                    a(str, null);
                }
                TiebaStatic.netImg(this.Xg);
                while (i < this.Xg.ha().size()) {
                    this.Xo = this.Xg.ha().get(i);
                    i++;
                }
                if (this.Xo.uX == null) {
                    this.Xo.uX = "";
                }
                this.Xo.uX = String.valueOf(dVar3.uX) + "responseCode:" + this.responseCode;
                return bArr;
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.Xg);
                for (int i2 = 0; i2 < this.Xg.ha().size(); i2++) {
                    this.Xo = this.Xg.ha().get(i2);
                }
                if (this.Xo.uX == null) {
                    this.Xo.uX = "";
                }
                this.Xo.uX = String.valueOf(dVar2.uX) + "responseCode:" + this.responseCode;
                return null;
            }
        } catch (Throwable th) {
            TiebaStatic.netImg(this.Xg);
            while (i < this.Xg.ha().size()) {
                this.Xo = this.Xg.ha().get(i);
                i++;
            }
            if (this.Xo.uX == null) {
                this.Xo.uX = "";
            }
            this.Xo.uX = String.valueOf(dVar.uX) + "responseCode:" + this.responseCode;
            throw th;
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

    public byte[] dj(String str) {
        return di(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [283=6] */
    public byte[] l(String str, boolean z) {
        byte[] di;
        String str2;
        com.baidu.adp.lib.network.http.d dVar;
        com.baidu.adp.lib.network.http.d dVar2;
        int size;
        int i = 0;
        if (TbadkCoreApplication.m411getInst().isHttpClientOpen()) {
            try {
                try {
                    uc();
                    if (this.Xl != null) {
                        cancel();
                    }
                    this.Xg = new com.baidu.adp.lib.network.http.e();
                    this.Xl = new ImgHttpClient(this.Xg);
                    this.Xg.gY().setUrl(str);
                    if (this.Xh != null) {
                        for (Map.Entry<String, String> entry : this.Xh.entrySet()) {
                            this.Xg.gY().o(entry.getKey(), entry.getValue());
                        }
                    }
                    this.Xl.tZ();
                    this.Xi = this.Xg.gZ();
                    di = this.Xg.gZ().vk;
                    this.responseCode = this.Xg.gZ().responseCode;
                    this.Xp = this.Xg.gZ().he();
                    if (di != null) {
                        this.dataSize = di.length;
                    } else {
                        this.dataSize = 0;
                    }
                    this.Gc = this.Xl.fN();
                    this.Xq = this.Xl.ua();
                    if (!this.Xp) {
                        a(str, null);
                    }
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    a(str, e);
                    TiebaStatic.netImg(this.Xg);
                    for (int i2 = 0; i2 < this.Xg.ha().size(); i2++) {
                        this.Xo = this.Xg.ha().get(i2);
                    }
                    if (this.Xo.uX == null) {
                        this.Xo.uX = "";
                    }
                    this.Xo.uX = String.valueOf(dVar2.uX) + "responseCode:" + this.responseCode;
                    return null;
                }
            } finally {
                TiebaStatic.netImg(this.Xg);
                while (i < this.Xg.ha().size()) {
                    this.Xo = this.Xg.ha().get(i);
                    i++;
                }
                if (this.Xo.uX == null) {
                    this.Xo.uX = "";
                }
                this.Xo.uX = String.valueOf(dVar.uX) + "responseCode:" + this.responseCode;
            }
        } else {
            try {
                di = di(str);
                if (di == null) {
                    return null;
                }
                if (this.Xg != null && this.Xg.gZ().vj != null) {
                    List<String> list = this.Xg.gZ().vj.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        i = 1;
                    }
                    List<String> list2 = this.Xg.gZ().vj.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.Gc = true;
                        } else {
                            this.Gc = false;
                        }
                    }
                    List<String> list3 = this.Xg.gZ().vj.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (TextUtils.isEmpty(str3) || str3.equalsIgnoreCase("OK")) {
                            this.Xq = false;
                        } else {
                            this.Xq = true;
                        }
                    }
                }
                if (this.Xp && ((z || i != 0) && new String(di, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) {
                    return g(di, 23, di.length);
                }
            } catch (Exception e2) {
                this.uX = String.valueOf(this.uX) + "BDIMAGE DECODE ERROR" + e2.getMessage();
                return null;
            }
        }
        return di;
    }

    private static byte[] g(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.Xg.ha().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.Xg.ha().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.uX);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.uU);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.uS);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.uR);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.uT);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.uW);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.uY);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.uV);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.uZ);
                this.Xm.add(Integer.valueOf(dVar.uZ));
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
            this.uX = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.Xp = false;
        }
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.ol != null) {
            this.ol.cancel();
        }
        if (this.Xl != null) {
            this.Xl.cancel();
            this.Xl = null;
        }
    }

    public boolean ud() {
        if (this.Xl == null) {
            return false;
        }
        return this.Xl.WX;
    }
}
