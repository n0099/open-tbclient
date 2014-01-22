package com.baidu.sapi2.a;

import com.baidu.sapi2.utils.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {
    private static String d = "UTF-8";
    protected ConcurrentHashMap<String, String> a;
    protected ConcurrentHashMap<String, a> b;
    protected ConcurrentHashMap<String, ArrayList<String>> c;

    public b() {
        d();
    }

    public b(Map<String, String> map) {
        d();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public void a(String str, File file) {
        a(str, new FileInputStream(file), file.getName());
    }

    public void a(String str, ArrayList<String> arrayList) {
        if (str != null && arrayList != null) {
            this.c.put(str, arrayList);
        }
    }

    public void a(String str, InputStream inputStream) {
        a(str, inputStream, null);
    }

    public void a(String str, InputStream inputStream, String str2) {
        a(str, inputStream, str2, null);
    }

    public void a(String str, InputStream inputStream, String str2, String str3) {
        if (str != null && inputStream != null) {
            this.b.put(str, new a(inputStream, str2, str3));
        }
    }

    public void a(String str) {
        this.a.remove(str);
        this.b.remove(str);
        this.c.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, a> entry2 : this.b.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, ArrayList<String>> entry3 : this.c.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            ArrayList<String> value = entry3.getValue();
            Iterator<String> it = value.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (value.indexOf(next) != 0) {
                    sb.append("&");
                }
                sb.append(entry3.getKey());
                sb.append("=");
                sb.append(next);
            }
        }
        return sb.toString();
    }

    public HttpEntity a() {
        if (!this.b.isEmpty()) {
            d dVar = new d();
            for (Map.Entry<String, String> entry : this.a.entrySet()) {
                dVar.a(entry.getKey(), entry.getValue());
            }
            int size = this.b.entrySet().size() - 1;
            int i = 0;
            for (Map.Entry<String, a> entry2 : this.b.entrySet()) {
                a value = entry2.getValue();
                if (value.a != null) {
                    boolean z = i == size;
                    if (value.c != null) {
                        dVar.a(entry2.getKey(), value.a(), value.a, value.c, z);
                    } else {
                        dVar.a(entry2.getKey(), value.a(), value.a, z);
                    }
                }
                i++;
            }
            for (Map.Entry<String, ArrayList<String>> entry3 : this.c.entrySet()) {
                Iterator<String> it = entry3.getValue().iterator();
                while (it.hasNext()) {
                    dVar.a(entry3.getKey(), it.next());
                }
            }
            return dVar;
        }
        try {
            return new UrlEncodedFormEntity(b(), d);
        } catch (UnsupportedEncodingException e) {
            L.e(e);
            return null;
        }
    }

    private void d() {
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
    }

    protected List<BasicNameValuePair> b() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.c.entrySet()) {
            Iterator<String> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                linkedList.add(new BasicNameValuePair(entry2.getKey(), it.next()));
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return URLEncodedUtils.format(b(), d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public InputStream a;
        public String b;
        public String c;

        public a(InputStream inputStream, String str, String str2) {
            this.a = inputStream;
            this.b = str;
            this.c = str2;
        }

        public String a() {
            return this.b != null ? this.b : "nofilename";
        }
    }
}
