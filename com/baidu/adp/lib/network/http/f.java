package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.h;
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
public final class f {
    private HttpMessageTask.HTTP_METHOD e;
    private String d = "";
    protected Map<String, String> a = new HashMap();
    protected LinkedList<BasicNameValuePair> b = new LinkedList<>();
    protected HashMap<String, byte[]> c = new HashMap<>();

    public final HttpMessageTask.HTTP_METHOD a() {
        return this.e;
    }

    public final void a(HttpMessageTask.HTTP_METHOD http_method) {
        this.e = http_method;
    }

    public final String b() {
        return this.d;
    }

    public final void a(String str) {
        if (str == null) {
            this.d = "";
        } else {
            this.d = str;
        }
    }

    public final boolean c() {
        return this.c != null && this.c.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(d dVar) {
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
            sb.append(h.c(this.b.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.a = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.a != null) {
            for (Map.Entry<String, String> entry : this.a.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(HttpURLConnection httpURLConnection, String str, d dVar) {
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
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
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
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--\r\n");
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

    public final void a(HttpURLConnection httpURLConnection, d dVar) {
        int i = 0;
        if (httpURLConnection != null) {
            StringBuilder sb = new StringBuilder(1024);
            if (this.b != null) {
                Iterator<BasicNameValuePair> it = this.b.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (next != null) {
                        String name = next.getName();
                        String value = next.getValue();
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(String.valueOf(name) + "=");
                        sb.append(h.c(value));
                        i2++;
                    }
                }
            }
            String sb2 = sb.toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            com.baidu.adp.lib.util.f.d("POST:" + this.d + "?" + sb2);
            try {
                dataOutputStream.writeBytes(sb2);
                dataOutputStream.flush();
                com.baidu.adp.lib.f.a.a((OutputStream) dataOutputStream);
                i = sb2.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.f.a.a((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.a = i;
        }
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    public final String b(String str) {
        if (this.a != null) {
            return this.a.get(str);
        }
        return null;
    }

    public final void a(List<Map.Entry<String, Object>> list) {
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

    public final void a(String str, String str2) {
        this.b.add(new BasicNameValuePair(str, str2));
    }

    public final void b(String str, String str2) {
        if (this.a != null) {
            this.a.put(str, str2);
        }
    }
}
