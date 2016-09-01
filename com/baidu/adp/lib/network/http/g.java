package com.baidu.adp.lib.network.http;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.j;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g {
    private HttpMessageTask.HTTP_METHOD oz;
    private String url = "";
    protected Map<String, String> oA = new HashMap();
    protected LinkedList<BasicNameValuePair> oB = new LinkedList<>();
    protected HashMap<String, byte[]> oC = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.oz;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.oz = http_method;
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

    public boolean et() {
        return this.oC != null && this.oC.size() > 0;
    }

    public String c(e eVar) {
        if (this.oB.size() == 0) {
            if (eVar != null) {
                eVar.oc = this.url.length();
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
            if (i2 >= this.oB.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.oB.get(i2).getName());
            sb.append("=");
            sb.append(j.aP(this.oB.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.oc = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.oA != null) {
            for (Map.Entry<String, String> entry : this.oA.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        ev();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.oB != null) {
                    Iterator<BasicNameValuePair> it = this.oB.iterator();
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
                if (this.oC != null) {
                    for (Map.Entry<String, byte[]> entry : this.oC.entrySet()) {
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
                com.baidu.adp.lib.h.a.d(dataOutputStream);
            }
        }
        if (eVar != null) {
            eVar.oc = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = eu().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.h.a.d(dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.h.a.d(dataOutputStream);
                throw th;
            }
        }
        if (eVar != null) {
            eVar.oc = i;
        }
    }

    private StringBuilder eu() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.oB != null) {
            Iterator<BasicNameValuePair> it = this.oB.iterator();
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
                    sb.append(j.aP(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void ev() {
    }

    public void d(HashMap<String, String> hashMap) {
        this.oA = hashMap;
    }

    public String ae(String str) {
        if (this.oA != null) {
            return this.oA.get(str);
        }
        return null;
    }

    public void d(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.oB.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.oC.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void d(String str, byte[] bArr) {
        this.oC.put(str, bArr);
    }

    public void n(String str, String str2) {
        this.oB.add(new BasicNameValuePair(str, str2));
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.oB.add(basicNameValuePair);
    }

    public void o(String str, String str2) {
        if (this.oA != null) {
            this.oA.put(str, str2);
        }
    }
}
