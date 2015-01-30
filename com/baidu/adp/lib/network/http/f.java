package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.k;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f {
    private HttpMessageTask.HTTP_METHOD kE;
    private String url = "";
    protected Map<String, String> kF = new HashMap();
    protected LinkedList<BasicNameValuePair> kG = new LinkedList<>();
    protected HashMap<String, byte[]> kH = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.kE;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.kE = http_method;
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

    public boolean dQ() {
        return this.kH != null && this.kH.size() > 0;
    }

    public String b(d dVar) {
        if (this.kG.size() == 0) {
            if (dVar != null) {
                dVar.kp = this.url.length();
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
            if (i2 >= this.kG.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.kG.get(i2).getName());
            sb.append("=");
            sb.append(k.aE(this.kG.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.kp = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.kF != null) {
            for (Map.Entry<String, String> entry : this.kF.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) {
        dS();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.kG != null) {
                    Iterator<BasicNameValuePair> it = this.kG.iterator();
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
                if (this.kH != null) {
                    for (Map.Entry<String, byte[]> entry : this.kH.entrySet()) {
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
                com.baidu.adp.lib.g.a.b(dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.kp = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = dR().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.b(dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.b(dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.kp = i;
        }
    }

    private StringBuilder dR() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.kG != null) {
            Iterator<BasicNameValuePair> it = this.kG.iterator();
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
                    sb.append(k.aE(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void dS() {
    }

    public void c(HashMap<String, String> hashMap) {
        this.kF = hashMap;
    }

    public String ab(String str) {
        if (this.kF != null) {
            return this.kF.get(str);
        }
        return null;
    }

    public void c(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.kG.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.kH.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void o(String str, String str2) {
        this.kG.add(new BasicNameValuePair(str, str2));
    }

    public void p(String str, String str2) {
        if (this.kF != null) {
            this.kF.put(str, str2);
        }
    }
}
