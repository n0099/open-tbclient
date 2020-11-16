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
/* loaded from: classes12.dex */
class m implements k {
    private Charset qs;
    private int qZ = 0;
    private String qW = d.MULTIPART_BOUNDARY;
    private StringBuilder qt = new StringBuilder();
    private Map<String, byte[]> qY = new HashMap();
    private Map<String, String> qX = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("--").append(this.qW).append("\r\n").append(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.qs), j.a(str3, this.qs))).append("\r\n").append("Content-Type:").append(str4).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (z) {
            sb.append("charset=").append(this.qs.name());
        }
        sb.append("\r\n");
        sb.append("\r\n");
        return new ByteArrayInputStream(sb.toString().getBytes(this.qs));
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null) {
            this.qZ += bArr.length;
        }
        this.qY.put(str, bArr);
    }

    @Override // com.baidu.ar.http.k
    public void a(Charset charset) {
        this.qs = charset;
    }

    public void aq(String str) {
        this.qW = str;
    }

    @Override // com.baidu.ar.http.k
    public InputStream[] eJ() {
        ArrayList arrayList = new ArrayList();
        if (this.qt.length() > 0) {
            arrayList.add(new ByteArrayInputStream(this.qt.toString().getBytes(this.qs)));
        }
        String str = "";
        if (!this.qX.isEmpty()) {
            for (Map.Entry<String, String> entry : this.qX.entrySet()) {
                arrayList.add(a(str, entry.getKey(), new File(entry.getValue()).getName(), j.ao(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str = "\r\n";
            }
        }
        if (!this.qY.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            for (Map.Entry<String, byte[]> entry2 : this.qY.entrySet()) {
                arrayList.add(a(str, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str = "\r\n";
                i++;
            }
        }
        if (!this.qX.isEmpty() || !this.qY.isEmpty()) {
            arrayList.add(new ByteArrayInputStream((str + "--" + this.qW + "--\r\n").getBytes(this.qs)));
        }
        return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.qt.append("--").append(this.qW).append("\r\n");
        this.qt.append("Content-Disposition: form-data; name=\"").append(j.a(str, this.qs)).append("\"\r\n");
        this.qt.append("\r\n");
        this.qt.append(j.a(str2, this.qs));
        this.qt.append("\r\n");
    }

    public String getBoundary() {
        return this.qW;
    }

    @Override // com.baidu.ar.http.k
    public String getContentType() {
        return "multipart/form-data;boundary=" + getBoundary();
    }

    @Override // com.baidu.ar.http.k
    public int getSize() {
        return this.qZ;
    }

    public void h(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            this.qZ = (int) (file.length() + this.qZ);
        }
        this.qX.put(str, str2);
    }

    public boolean isEmpty() {
        return this.qt.length() == 0 && this.qY.isEmpty() && this.qX.isEmpty();
    }
}
