package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.k;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class f {
    private HttpMessageTask.HTTP_METHOD oL;
    private String url = "";
    protected Map<String, String> oM = new HashMap();
    protected LinkedList<BasicNameValuePair> oN = new LinkedList<>();
    protected HashMap<String, byte[]> oO = new HashMap<>();
    private boolean oP = false;
    private boolean oQ = false;
    private boolean oR = false;
    private boolean oS = true;

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.oL;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.oL = http_method;
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

    public boolean fN() {
        return this.oO != null && this.oO.size() > 0;
    }

    public String c(d dVar) {
        if (this.oN.size() == 0) {
            if (dVar != null) {
                dVar.ou = this.url.length();
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
            if (i2 >= this.oN.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.oN.get(i2).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.oN.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.ou = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.oM != null) {
            for (Map.Entry<String, String> entry : this.oM.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        fP();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.oN != null) {
                    Iterator<BasicNameValuePair> it = this.oN.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + "\r\n");
                                byte[] bytes = value.getBytes(HTTP.UTF_8);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                }
                if (this.oO != null) {
                    for (Map.Entry<String, byte[]> entry : this.oO.entrySet()) {
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
                com.baidu.adp.lib.g.a.close((OutputStream) dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.ou = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = fO().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.close((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.close((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.ou = i;
        }
    }

    private StringBuilder fO() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.oN != null) {
            Iterator<BasicNameValuePair> it = this.oN.iterator();
            int i = 0;
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(k.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void fP() {
    }

    public void j(HashMap<String, String> hashMap) {
        this.oM = hashMap;
    }

    public String ah(String str) {
        if (this.oM != null) {
            return this.oM.get(str);
        }
        return null;
    }

    public void i(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.oN.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.oO.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void addPostData(String str, byte[] bArr) {
        this.oO.put(str, bArr);
    }

    public void addPostData(String str, String str2) {
        this.oN.add(new BasicNameValuePair(str, str2));
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.oN.add(basicNameValuePair);
    }

    public void l(String str, String str2) {
        if (this.oM != null) {
            this.oM.put(str, str2);
        }
    }

    public void D(boolean z) {
        this.oS = z;
    }

    public boolean fQ() {
        return this.oS;
    }
}
