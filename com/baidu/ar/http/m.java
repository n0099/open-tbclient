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
/* loaded from: classes3.dex */
class m implements k {
    private Charset qI;
    private int rp = 0;
    private String rm = d.MULTIPART_BOUNDARY;
    private StringBuilder qJ = new StringBuilder();
    private Map<String, byte[]> ro = new HashMap();
    private Map<String, String> rn = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("--").append(this.rm).append("\r\n").append(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.qI), j.a(str3, this.qI))).append("\r\n").append("Content-Type:").append(str4).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (z) {
            sb.append("charset=").append(this.qI.name());
        }
        sb.append("\r\n");
        sb.append("\r\n");
        return new ByteArrayInputStream(sb.toString().getBytes(this.qI));
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null) {
            this.rp += bArr.length;
        }
        this.ro.put(str, bArr);
    }

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.qI = charset;
    }

    public void at(String str) {
        this.rm = str;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eI() {
        ArrayList arrayList = new ArrayList();
        if (this.qJ.length() > 0) {
            arrayList.add(new ByteArrayInputStream(this.qJ.toString().getBytes(this.qI)));
        }
        String str = "";
        if (!this.rn.isEmpty()) {
            for (Map.Entry<String, String> entry : this.rn.entrySet()) {
                arrayList.add(a(str, entry.getKey(), new File(entry.getValue()).getName(), j.ar(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str = "\r\n";
            }
        }
        if (!this.ro.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            for (Map.Entry<String, byte[]> entry2 : this.ro.entrySet()) {
                arrayList.add(a(str, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str = "\r\n";
                i++;
            }
        }
        if (!this.rn.isEmpty() || !this.ro.isEmpty()) {
            arrayList.add(new ByteArrayInputStream((str + "--" + this.rm + "--\r\n").getBytes(this.qI)));
        }
        return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.qJ.append("--").append(this.rm).append("\r\n");
        this.qJ.append("Content-Disposition: form-data; name=\"").append(j.a(str, this.qI)).append("\"\r\n");
        this.qJ.append("\r\n");
        this.qJ.append(j.a(str2, this.qI));
        this.qJ.append("\r\n");
    }

    public String getBoundary() {
        return this.rm;
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return "multipart/form-data;boundary=" + getBoundary();
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        return this.rp;
    }

    public void h(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            this.rp = (int) (file.length() + this.rp);
        }
        this.rn.put(str, str2);
    }

    public boolean isEmpty() {
        return this.qJ.length() == 0 && this.ro.isEmpty() && this.rn.isEmpty();
    }
}
