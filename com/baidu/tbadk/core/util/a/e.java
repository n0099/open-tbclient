package com.baidu.tbadk.core.util.a;

import android.annotation.SuppressLint;
import com.baidu.adp.lib.stats.o;
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
public final class e {
    private static int l = 5;
    private com.baidu.adp.lib.network.http.e h;
    private volatile com.baidu.adp.lib.network.http.c i = null;
    private HashMap<String, String> j = null;
    private com.baidu.adp.lib.network.http.g k = new com.baidu.adp.lib.network.http.g();
    public String a = o.a();
    public List<Integer> b = new ArrayList();
    public boolean c = false;
    public boolean d = false;
    public String e = "";
    public int f = -1;
    public int g = -1;
    private boolean m = false;

    public final boolean a() {
        return this.m;
    }

    public final void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null) {
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
    }

    private final byte[] b(String str) {
        try {
            this.e = "";
            this.m = false;
            this.g = -1;
            this.f = -1;
            this.d = false;
            this.c = false;
            this.b.clear();
            if (this.h != null) {
                b();
                this.i = null;
            }
            this.h = new com.baidu.adp.lib.network.http.e();
            this.h.a().a(str);
            if (this.j != null) {
                for (Map.Entry<String, String> entry : this.j.entrySet()) {
                    this.h.a().a(entry.getKey(), entry.getValue());
                }
            }
            this.i = new com.baidu.adp.lib.network.http.c(this.h);
            this.i.a(l, 0, 0);
            this.k = this.h.b();
            byte[] bArr = this.h.b().g;
            this.g = this.h.b().b;
            com.baidu.adp.lib.network.http.g b = this.h.b();
            this.m = b.b == 200 || b.b / 100 == 3;
            if (bArr != null) {
                this.f = bArr.length;
            } else {
                this.f = 0;
            }
            if (this.h.b().c != null && this.h.b().c.toLowerCase().contains("gzip")) {
                this.c = true;
                bArr = a(bArr);
            }
            if (!this.m) {
                a(str, (Exception) null);
            }
            return bArr;
        } catch (Exception e) {
            a(str, e);
            return null;
        } finally {
            TiebaStatic.a(this.h);
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.a(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }

    public final byte[] a(String str) {
        return a(str, false);
    }

    public final byte[] a(String str, boolean z) {
        String obj;
        boolean z2 = false;
        try {
            byte[] b = b(str);
            if (b == null) {
                return null;
            }
            if (this.h != null && this.h.b().f != null) {
                List<String> list = this.h.b().f.get("imgsrc");
                if (list != null && (obj = list.toString()) != null && obj.length() > 0) {
                    z2 = true;
                }
                List<String> list2 = this.h.b().f.get("Src-Content-Type");
                if (list2 != null) {
                    if ("image/gif".equalsIgnoreCase(list2.toString())) {
                        this.d = true;
                    } else {
                        this.d = false;
                    }
                }
            }
            if (this.m) {
                if ((z || z2) && new String(b, 0, 23).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                    int length = b.length;
                    int i = length - 23;
                    if (i < 0) {
                        throw new IllegalArgumentException(String.valueOf(23) + " > " + length);
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(b, 23, bArr, 0, Math.min(b.length - 23, i));
                    return bArr;
                }
                return b;
            }
            return b;
        } catch (Exception e) {
            this.e = String.valueOf(this.e) + "BDIMAGE DECODE ERROR" + e.getMessage();
            return null;
        }
    }

    private void a(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.h.c().size(); i++) {
                com.baidu.adp.lib.network.http.d dVar = this.h.c().get(i);
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
            this.m = false;
        }
    }

    public final void b() {
        if (this.h != null) {
            this.h.b().a = true;
        }
    }
}
