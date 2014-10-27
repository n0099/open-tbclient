package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.l;
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
    private HttpMessageTask.HTTP_METHOD kA;
    private String url = "";
    protected Map<String, String> kB = new HashMap();
    protected LinkedList<BasicNameValuePair> kC = new LinkedList<>();
    protected HashMap<String, byte[]> kD = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.kA;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.kA = http_method;
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

    public boolean dT() {
        return this.kD != null && this.kD.size() > 0;
    }

    public String b(d dVar) {
        if (this.kC.size() == 0) {
            if (dVar != null) {
                dVar.kk = this.url.length();
            }
            return this.url;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.url);
        if (this.url.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.url.endsWith("?") && !this.url.endsWith("&")) {
            sb.append("&");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.kC.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.kC.get(i2).getName());
            sb.append("=");
            sb.append(l.aC(this.kC.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.kk = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.kB != null) {
            for (Map.Entry<String, String> entry : this.kB.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) {
        dV();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.kC != null) {
                    Iterator<BasicNameValuePair> it = this.kC.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            dataOutputStream.writeBytes("--" + str + "\r\n");
                            byte[] bytes = value.getBytes("UTF-8");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(bytes);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    }
                }
                if (this.kD != null) {
                    for (Map.Entry<String, byte[]> entry : this.kD.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + "\r\n");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--\r\n");
                dataOutputStream.flush();
                i = dataOutputStream.size();
            } finally {
                com.baidu.adp.lib.g.a.a((OutputStream) dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.kk = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = dU().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.a((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.a((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.kk = i;
        }
    }

    private StringBuilder dU() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.kC != null) {
            Iterator<BasicNameValuePair> it = this.kC.iterator();
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
                    sb.append(l.aC(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void dV() {
    }

    public void b(HashMap<String, String> hashMap) {
        this.kB = hashMap;
    }

    public String W(String str) {
        if (this.kB != null) {
            return this.kB.get(str);
        }
        return null;
    }

    public void c(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.kC.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.kD.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void k(String str, String str2) {
        this.kC.add(new BasicNameValuePair(str, str2));
    }

    public void l(String str, String str2) {
        if (this.kB != null) {
            this.kB.put(str, str2);
        }
    }
}
