package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
class m implements k {
    private Charset pN;
    private int qu = 0;
    private String qr = d.MULTIPART_BOUNDARY;
    private StringBuilder pO = new StringBuilder();
    private Map<String, byte[]> qt = new HashMap();
    private Map<String, String> qs = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("--").append(this.qr).append("\r\n").append(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.pN), j.a(str3, this.pN))).append("\r\n").append("Content-Type:").append(str4).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (z) {
            sb.append("charset=").append(this.pN.name());
        }
        sb.append("\r\n");
        sb.append("\r\n");
        return new ByteArrayInputStream(sb.toString().getBytes(this.pN));
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null) {
            this.qu += bArr.length;
        }
        this.qt.put(str, bArr);
    }

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.pN = charset;
    }

    public void am(String str) {
        this.qr = str;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dz() {
        ArrayList arrayList = new ArrayList();
        if (this.pO.length() > 0) {
            arrayList.add(new ByteArrayInputStream(this.pO.toString().getBytes(this.pN)));
        }
        String str = "";
        if (!this.qs.isEmpty()) {
            for (Map.Entry<String, String> entry : this.qs.entrySet()) {
                arrayList.add(a(str, entry.getKey(), new File(entry.getValue()).getName(), j.ak(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str = "\r\n";
            }
        }
        if (!this.qt.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            for (Map.Entry<String, byte[]> entry2 : this.qt.entrySet()) {
                arrayList.add(a(str, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str = "\r\n";
                i++;
            }
        }
        if (!this.qs.isEmpty() || !this.qt.isEmpty()) {
            arrayList.add(new ByteArrayInputStream((str + "--" + this.qr + "--\r\n").getBytes(this.pN)));
        }
        return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.pO.append("--").append(this.qr).append("\r\n");
        this.pO.append("Content-Disposition: form-data; name=\"").append(j.a(str, this.pN)).append("\"\r\n");
        this.pO.append("\r\n");
        this.pO.append(j.a(str2, this.pN));
        this.pO.append("\r\n");
    }

    public void f(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            this.qu = (int) (file.length() + this.qu);
        }
        this.qs.put(str, str2);
    }

    public String getBoundary() {
        return this.qr;
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return "multipart/form-data;boundary=" + getBoundary();
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        return this.qu;
    }

    public boolean isEmpty() {
        return this.pO.length() == 0 && this.qt.isEmpty() && this.qs.isEmpty();
    }
}
