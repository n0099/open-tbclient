package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.resourceLoader.b {
    private static int m = 5;
    private com.baidu.adp.lib.network.http.e i;
    private volatile com.baidu.adp.lib.network.http.c j = null;
    private HashMap<String, String> k = null;
    private com.baidu.adp.lib.network.http.g l = new com.baidu.adp.lib.network.http.g();
    public String a = r.a();
    public List<Integer> b = new ArrayList();
    public boolean c = false;
    public boolean d = false;
    public String e = "";
    public com.baidu.adp.lib.network.http.d f = null;
    public int g = -1;
    public int h = -1;
    private boolean n = false;

    public boolean b() {
        return this.n;
    }

    public com.baidu.adp.lib.network.http.g c() {
        return this.l;
    }

    public void d() {
        this.f = null;
        this.e = "";
        this.n = false;
        this.h = -1;
        this.g = -1;
        this.d = false;
        this.c = false;
        this.b.clear();
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null) {
            if (this.k == null) {
                this.k = new HashMap<>();
            }
            this.k.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6] */
    private final byte[] b(String str) {
        int size;
        int i = 0;
        try {
            try {
                d();
                if (this.i != null) {
                    a();
                    this.j = null;
                }
                this.i = new com.baidu.adp.lib.network.http.e();
                if (!TextUtils.isEmpty(this.a)) {
                    this.i.a().b("sid", this.a);
                }
                this.i.a().a(str);
                if (this.k != null) {
                    for (Map.Entry<String, String> entry : this.k.entrySet()) {
                        this.i.a().a(entry.getKey(), entry.getValue());
                    }
                }
                this.j = new com.baidu.adp.lib.network.http.c(this.i);
                this.j.a(m, 0, 0);
                this.l = this.i.b();
                byte[] bArr = this.i.b().g;
                this.h = this.i.b().b;
                this.n = this.i.b().a();
                if (bArr != null) {
                    this.g = bArr.length;
                } else {
                    this.g = 0;
                }
                if (this.i.b().c != null && this.i.b().c.toLowerCase().contains("gzip")) {
                    this.c = true;
                    bArr = a(bArr);
                }
                if (!this.n) {
                    a(str, (Exception) null);
                }
                while (true) {
                    if (i >= size) {
                        return bArr;
                    }
                }
            } catch (Exception e) {
                a(str, e);
                TiebaStatic.netImg(this.i);
                for (int i2 = 0; i2 < this.i.c().size(); i2++) {
                    this.f = this.i.c().get(i2);
                }
                return null;
            }
        } finally {
            TiebaStatic.netImg(this.i);
            while (i < this.i.c().size()) {
                this.f = this.i.c().get(i);
                i++;
            }
        }
    }

    private final byte[] a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.a(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public byte[] a(String str) {
        return a(str, false);
    }

    public byte[] a(String str, boolean z) {
        boolean z2;
        String str2;
        boolean z3 = false;
        try {
            byte[] b = b(str);
            if (b == null) {
                return null;
            }
            if (this.i != null && this.i.b().f != null) {
                List<String> list = this.i.b().f.get("imgsrc");
                if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                    z3 = true;
                }
                List<String> list2 = this.i.b().f.get("Src-Content-Type");
                if (list2 != null && list2.size() > 0) {
                    if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                        this.d = true;
                        z2 = z3;
                        return (this.n || !((z || z2) && new String(b, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;"))) ? b : a(b, 23, b.length);
                    }
                    this.d = false;
                }
            }
            z2 = z3;
            if (this.n) {
            }
        } catch (Exception e) {
            this.e = String.valueOf(this.e) + "BDIMAGE DECODE ERROR" + e.getMessage();
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
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
            for (int i = 0; i < this.i.c().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.i.c().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.h);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.e);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.c);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.b);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.d);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.g);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.i);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.f);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.j);
                this.b.add(Integer.valueOf(dVar.j));
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
            this.e = stringBuffer.toString();
        } catch (Exception e) {
        } finally {
            this.n = false;
        }
    }

    @Override // com.baidu.adp.lib.resourceLoader.b
    public void a() {
        if (this.j != null) {
            this.j.a();
        }
    }
}
