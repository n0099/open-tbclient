package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f {
    private HttpMessageTask.HTTP_METHOD e;
    private String d = "";
    protected Map<String, String> a = new HashMap();
    protected LinkedList<BasicNameValuePair> b = new LinkedList<>();
    protected HashMap<String, byte[]> c = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD a() {
        return this.e;
    }

    public void a(HttpMessageTask.HTTP_METHOD http_method) {
        this.e = http_method;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        if (str == null) {
            this.d = "";
        } else {
            this.d = str;
        }
    }

    public boolean c() {
        return this.c != null && this.c.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(d dVar) {
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.d);
        if (this.d.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.d.endsWith("?") && !this.d.endsWith("&")) {
            sb.append("&");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.b.get(i2).getName());
            sb.append("=");
            sb.append(j.c(this.b.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.a = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.a != null) {
            for (Map.Entry<String, String> entry : this.a.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) {
        d();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.b != null) {
                    Iterator<BasicNameValuePair> it = this.b.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            dataOutputStream.writeBytes("--" + str + IOUtils.LINE_SEPARATOR_WINDOWS);
                            byte[] bytes = value.getBytes("UTF-8");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.write(bytes);
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                    }
                }
                if (this.c != null) {
                    for (Map.Entry<String, byte[]> entry : this.c.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--" + IOUtils.LINE_SEPARATOR_WINDOWS);
                dataOutputStream.flush();
                i = dataOutputStream.size();
            } finally {
                com.baidu.adp.lib.f.a.a((OutputStream) dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.a = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = e().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            BdLog.i("POST:" + this.d + "?" + sb);
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.f.a.a((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.f.a.a((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.a = i;
        }
    }

    private StringBuilder e() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.b != null) {
            Iterator<BasicNameValuePair> it = this.b.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(String.valueOf(name) + "=");
                    sb.append(j.c(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void d() {
    }

    public void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    public String b(String str) {
        if (this.a != null) {
            return this.a.get(str);
        }
        return null;
    }

    public void a(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.b.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.c.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void a(String str, String str2) {
        this.b.add(new BasicNameValuePair(str, str2));
    }

    public void b(String str, String str2) {
        if (this.a != null) {
            this.a.put(str, str2);
        }
    }
}
