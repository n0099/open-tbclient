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
    private HttpMessageTask.HTTP_METHOD LA;
    private String url = "";
    protected Map<String, String> LB = new HashMap();
    protected LinkedList<BasicNameValuePair> LC = new LinkedList<>();
    protected HashMap<String, byte[]> LD = new HashMap<>();
    private boolean LG = false;
    private boolean LH = false;
    private boolean LI = false;

    public HttpMessageTask.HTTP_METHOD getMethod() {
        return this.LA;
    }

    public void setMethod(HttpMessageTask.HTTP_METHOD http_method) {
        this.LA = http_method;
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

    public boolean mw() {
        return this.LD != null && this.LD.size() > 0;
    }

    public String c(d dVar) {
        if (this.LC.size() == 0) {
            if (dVar != null) {
                dVar.Lf = this.url.length();
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
            if (i2 >= this.LC.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(this.LC.get(i2).getName());
            sb.append(ETAG.EQUAL);
            sb.append(k.getUrlEncode(this.LC.get(i2).getValue()));
            i = i2 + 1;
        }
        if (dVar != null) {
            dVar.Lf = sb.length();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && this.LB != null) {
            for (Map.Entry<String, String> entry : this.LB.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        my();
        int i = 0;
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.LC != null) {
                    Iterator<BasicNameValuePair> it = this.LC.iterator();
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
                if (this.LD != null) {
                    for (Map.Entry<String, byte[]> entry : this.LD.entrySet()) {
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
            dVar.Lf = i;
        }
    }

    public void a(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i = 0;
        if (httpURLConnection != null) {
            String sb = mx().toString();
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
            dVar.Lf = i;
        }
    }

    private StringBuilder mx() {
        StringBuilder sb = new StringBuilder(1024);
        if (this.LC != null) {
            Iterator<BasicNameValuePair> it = this.LC.iterator();
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

    protected void my() {
    }

    public void t(HashMap<String, String> hashMap) {
        this.LB = hashMap;
    }

    public String bH(String str) {
        if (this.LB != null) {
            return this.LB.get(str);
        }
        return null;
    }

    public void n(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.LC.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.LD.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void addPostData(String str, byte[] bArr) {
        this.LD.put(str, bArr);
    }

    public void addPostData(String str, String str2) {
        this.LC.add(new BasicNameValuePair(str, str2));
    }

    public void addPostData(BasicNameValuePair basicNameValuePair) {
        this.LC.add(basicNameValuePair);
    }

    public void u(String str, String str2) {
        if (this.LB != null) {
            this.LB.put(str, str2);
        }
    }

    public void al(boolean z) {
        this.LG = z;
    }

    public boolean mz() {
        return this.LG;
    }
}
