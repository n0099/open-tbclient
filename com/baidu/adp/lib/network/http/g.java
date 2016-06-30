package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.j;
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
public class g {
    private HttpMessageTask.HTTP_METHOD ly;
    private String url = "";
    protected Map<String, String> lA = new HashMap();
    protected LinkedList<BasicNameValuePair> lB = new LinkedList<>();
    protected HashMap<String, byte[]> lC = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.ly;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.ly = http_method;
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

    public boolean dz() {
        return this.lC != null && this.lC.size() > 0;
    }

    public String c(e eVar) {
        if (this.lB.size() == 0) {
            if (eVar != null) {
                eVar.le = this.url.length();
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
            if (i2 >= this.lB.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.lB.get(i2).getName());
            sb.append("=");
            sb.append(j.aN(this.lB.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.le = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.lA != null) {
            for (Map.Entry<String, String> entry : this.lA.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) {
        dB();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.lB != null) {
                    Iterator<BasicNameValuePair> it = this.lB.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + "\r\n");
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                }
                if (this.lC != null) {
                    for (Map.Entry<String, byte[]> entry : this.lC.entrySet()) {
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
                com.baidu.adp.lib.h.a.b((OutputStream) dataOutputStream);
            }
        }
        if (eVar != null) {
            eVar.le = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = dA().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.h.a.b((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.h.a.b((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (eVar != null) {
            eVar.le = i;
        }
    }

    private StringBuilder dA() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.lB != null) {
            Iterator<BasicNameValuePair> it = this.lB.iterator();
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
                    sb.append(j.aN(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void dB() {
    }

    public void d(HashMap<String, String> hashMap) {
        this.lA = hashMap;
    }

    public String ab(String str) {
        if (this.lA != null) {
            return this.lA.get(str);
        }
        return null;
    }

    public void d(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.lB.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.lC.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void d(String str, byte[] bArr) {
        this.lC.put(str, bArr);
    }

    public void n(String str, String str2) {
        this.lB.add(new BasicNameValuePair(str, str2));
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.lB.add(basicNameValuePair);
    }

    public void o(String str, String str2) {
        if (this.lA != null) {
            this.lA.put(str, str2);
        }
    }
}
