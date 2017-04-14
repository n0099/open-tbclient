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
    private HttpMessageTask.HTTP_METHOD vH;
    private String url = "";
    protected Map<String, String> vI = new HashMap();
    protected LinkedList<BasicNameValuePair> vJ = new LinkedList<>();
    protected HashMap<String, byte[]> vK = new HashMap<>();

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.vH;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.vH = http_method;
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

    public boolean fE() {
        return this.vK != null && this.vK.size() > 0;
    }

    public String c(e eVar) {
        if (this.vJ.size() == 0) {
            if (eVar != null) {
                eVar.vo = this.url.length();
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
            if (i2 >= this.vJ.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.vJ.get(i2).getName());
            sb.append("=");
            sb.append(j.aD(this.vJ.get(i2).getValue()));
            i = i2 + 1;
        }
        if (eVar != null) {
            eVar.vo = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.vI != null) {
            for (Map.Entry<String, String> entry : this.vI.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        fG();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.vJ != null) {
                    Iterator<BasicNameValuePair> it = this.vJ.iterator();
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
                if (this.vK != null) {
                    for (Map.Entry<String, byte[]> entry : this.vK.entrySet()) {
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
                com.baidu.adp.lib.g.a.d(dataOutputStream);
            }
        }
        if (eVar != null) {
            eVar.vo = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = fF().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                com.baidu.adp.lib.g.a.d(dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.d(dataOutputStream);
                throw th;
            }
        }
        if (eVar != null) {
            eVar.vo = i;
        }
    }

    private StringBuilder fF() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.vJ != null) {
            Iterator<BasicNameValuePair> it = this.vJ.iterator();
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
                    sb.append(j.aD(value));
                    i++;
                }
            }
        }
        return sb;
    }

    protected void fG() {
    }

    public void d(HashMap<String, String> hashMap) {
        this.vI = hashMap;
    }

    public String aa(String str) {
        if (this.vI != null) {
            return this.vI.get(str);
        }
        return null;
    }

    public void d(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.vJ.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.vK.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void d(String str, byte[] bArr) {
        this.vK.put(str, bArr);
    }

    public void n(String str, String str2) {
        this.vJ.add(new BasicNameValuePair(str, str2));
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.vJ.add(basicNameValuePair);
    }

    public void o(String str, String str2) {
        if (this.vI != null) {
            this.vI.put(str, str2);
        }
    }
}
