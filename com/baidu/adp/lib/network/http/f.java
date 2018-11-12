package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.k;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.webkit.internal.ETAG;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f {
    private HttpMessageTask.HTTP_METHOD CZ;
    private String url = "";
    protected Map<String, String> Da = new HashMap();
    protected LinkedList<BasicNameValuePair> Db = new LinkedList<>();
    protected HashMap<String, byte[]> Dc = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.CZ;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.CZ = http_method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        if (str == null) {
            this.url = "";
        } else {
            this.url = str;
        }
    }

    public boolean jt() {
        return this.Dc != null && this.Dc.size() > 0;
    }

    public String c(d dVar) {
        if (this.Db.size() == 0) {
            if (dVar != null) {
                dVar.CF = this.url.length();
            }
            return this.url;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.url);
        if (this.url.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.url.endsWith("?") && !this.url.endsWith(ETAG.ITEM_SEPARATOR)) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Db.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.Db.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.bx(this.Db.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.CF = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.Da != null) {
            for (Map.Entry<String, String> entry : this.Da.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        jv();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.Db != null) {
                    Iterator<BasicNameValuePair> it = this.Db.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + SystemInfoUtil.LINE_END);
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + SystemInfoUtil.LINE_END);
                                dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                            }
                        }
                    }
                }
                if (this.Dc != null) {
                    for (Map.Entry<String, byte[]> entry : this.Dc.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + SystemInfoUtil.LINE_END);
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + SystemInfoUtil.LINE_END);
                            dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes(SystemInfoUtil.LINE_END);
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--" + SystemInfoUtil.LINE_END);
                dataOutputStream.flush();
                i = dataOutputStream.size();
            } finally {
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.CF = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = ju().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.b((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.CF = i;
        }
    }

    private StringBuilder ju() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.Db != null) {
            Iterator<BasicNameValuePair> it = this.Db.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(name + ETAG.EQUAL);
                    sb.append(k.bx(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void jv() {
    }

    public void l(HashMap<String, String> hashMap) {
        this.Da = hashMap;
    }

    public String aQ(String str) {
        if (this.Da != null) {
            return this.Da.get(str);
        }
        return null;
    }

    public void j(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.Db.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.Dc.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void d(String str, byte[] bArr) {
        this.Dc.put(str, bArr);
    }

    public void x(String str, String str2) {
        this.Db.add(new BasicNameValuePair(str, str2));
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.Db.add(basicNameValuePair);
    }

    public void y(String str, String str2) {
        if (this.Da != null) {
            this.Da.put(str, str2);
        }
    }
}
