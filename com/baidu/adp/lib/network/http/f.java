package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.k;
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
    private HttpMessageTask.HTTP_METHOD rh;
    private String url = "";
    protected Map<String, String> ri = new HashMap();
    protected LinkedList<BasicNameValuePair> rj = new LinkedList<>();
    protected HashMap<String, byte[]> rk = new HashMap<>();
    private boolean rl = false;
    private boolean rm = false;
    private boolean ro = false;

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.rh;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.rh = http_method;
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

    public boolean gb() {
        return this.rk != null && this.rk.size() > 0;
    }

    public String c(d dVar) {
        if (this.rj.size() == 0) {
            if (dVar != null) {
                dVar.qM = this.url.length();
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
            if (i2 >= this.rj.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.rj.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.getUrlEncode(this.rj.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.qM = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.ri != null) {
            for (Map.Entry<String, String> entry : this.ri.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        ge();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.rj != null) {
                    Iterator<BasicNameValuePair> it = this.rj.iterator();
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
                if (this.rk != null) {
                    for (Map.Entry<String, byte[]> entry : this.rk.entrySet()) {
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
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
            }
        }
        if (dVar != null) {
            dVar.qM = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = gd().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.f.a.close((OutputStream) dataOutputStream);
                throw th;
            }
        }
        if (dVar != null) {
            dVar.qM = i;
        }
    }

    private StringBuilder gd() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.rj != null) {
            Iterator<BasicNameValuePair> it = this.rj.iterator();
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
                    sb.append(k.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void ge() {
    }

    public void i(HashMap<String, String> hashMap) {
        this.ri = hashMap;
    }

    public String al(String str) {
        if (this.ri != null) {
            return this.ri.get(str);
        }
        return null;
    }

    public void h(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.rj.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.rk.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void addPostData(String str, byte[] bArr) {
        this.rk.put(str, bArr);
    }

    public void addPostData(String str, String str2) {
        this.rj.add(new BasicNameValuePair(str, str2));
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.rj.add(basicNameValuePair);
    }

    public void n(String str, String str2) {
        if (this.ri != null) {
            this.ri.put(str, str2);
        }
    }

    public void I(boolean z) {
        this.rl = z;
    }

    public boolean gf() {
        return this.rl;
    }
}
