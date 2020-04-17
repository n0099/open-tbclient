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
    private Charset po;
    private int pV = 0;
    private String pS = d.MULTIPART_BOUNDARY;
    private StringBuilder pp = new StringBuilder();
    private Map<String, byte[]> pU = new HashMap();
    private Map<String, String> pT = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("--").append(this.pS).append("\r\n").append(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.po), j.a(str3, this.po))).append("\r\n").append("Content-Type:").append(str4).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (z) {
            sb.append("charset=").append(this.po.name());
        }
        sb.append("\r\n");
        sb.append("\r\n");
        return new ByteArrayInputStream(sb.toString().getBytes(this.po));
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null) {
            this.pV += bArr.length;
        }
        this.pU.put(str, bArr);
    }

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.po = charset;
    }

    public void al(String str) {
        this.pS = str;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] dj() {
        ArrayList arrayList = new ArrayList();
        if (this.pp.length() > 0) {
            arrayList.add(new ByteArrayInputStream(this.pp.toString().getBytes(this.po)));
        }
        String str = "";
        if (!this.pT.isEmpty()) {
            for (Map.Entry<String, String> entry : this.pT.entrySet()) {
                arrayList.add(a(str, entry.getKey(), new File(entry.getValue()).getName(), j.aj(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str = "\r\n";
            }
        }
        if (!this.pU.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            for (Map.Entry<String, byte[]> entry2 : this.pU.entrySet()) {
                arrayList.add(a(str, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str = "\r\n";
                i++;
            }
        }
        if (!this.pT.isEmpty() || !this.pU.isEmpty()) {
            arrayList.add(new ByteArrayInputStream((str + "--" + this.pS + "--\r\n").getBytes(this.po)));
        }
        return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.pp.append("--").append(this.pS).append("\r\n");
        this.pp.append("Content-Disposition: form-data; name=\"").append(j.a(str, this.po)).append("\"\r\n");
        this.pp.append("\r\n");
        this.pp.append(j.a(str2, this.po));
        this.pp.append("\r\n");
    }

    public void f(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            this.pV = (int) (file.length() + this.pV);
        }
        this.pT.put(str, str2);
    }

    public String getBoundary() {
        return this.pS;
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return "multipart/form-data;boundary=" + getBoundary();
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        return this.pV;
    }

    public boolean isEmpty() {
        return this.pp.length() == 0 && this.pU.isEmpty() && this.pT.isEmpty();
    }
}
