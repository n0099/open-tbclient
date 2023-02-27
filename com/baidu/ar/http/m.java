package com.baidu.ar.http;

import android.text.TextUtils;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m implements k {
    public Charset qI;
    public int rp = 0;
    public String rm = d.MULTIPART_BOUNDARY;
    public StringBuilder qJ = new StringBuilder();
    public Map<String, byte[]> ro = new HashMap();
    public Map<String, String> rn = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        String format = String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", j.a(str2, this.qI), j.a(str3, this.qI));
        sb.append(str);
        sb.append("--");
        sb.append(this.rm);
        sb.append("\r\n");
        sb.append(format);
        sb.append("\r\n");
        sb.append("Content-Type:");
        sb.append(str4);
        sb.append(ParamableElem.DIVIDE_PARAM);
        if (z) {
            sb.append("charset=");
            sb.append(this.qI.name());
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
            String str2 = "";
            for (Map.Entry<String, String> entry : this.rn.entrySet()) {
                arrayList.add(a(str2, entry.getKey(), new File(entry.getValue()).getName(), j.ar(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str2 = "\r\n";
            }
            str = str2;
        }
        if (!this.ro.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            String str3 = str;
            for (Map.Entry<String, byte[]> entry2 : this.ro.entrySet()) {
                arrayList.add(a(str3, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str3 = "\r\n";
                i++;
            }
            str = str3;
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
        StringBuilder sb = this.qJ;
        sb.append("--");
        sb.append(this.rm);
        sb.append("\r\n");
        StringBuilder sb2 = this.qJ;
        sb2.append("Content-Disposition: form-data; name=\"");
        sb2.append(j.a(str, this.qI));
        sb2.append("\"\r\n");
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
            this.rp = (int) (this.rp + file.length());
        }
        this.rn.put(str, str2);
    }

    public boolean isEmpty() {
        return this.qJ.length() == 0 && this.ro.isEmpty() && this.rn.isEmpty();
    }
}
