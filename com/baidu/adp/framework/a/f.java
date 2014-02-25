package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<HttpMessage, com.baidu.adp.framework.message.c, com.baidu.adp.framework.message.c> {
    final /* synthetic */ d a;
    private HttpMessage b;
    private com.baidu.adp.lib.network.a c;
    private HttpMessageTask d;

    public f(d dVar, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.a = dVar;
        this.b = null;
        this.c = null;
        this.d = null;
        setPriority(httpMessageTask.l());
        setImmediatelyExecut(httpMessageTask.e());
        setTag(httpMessage.e());
        setParallelTag(httpMessageTask.i());
        setKey(String.valueOf(httpMessageTask.i()));
        setType(httpMessageTask.h());
        this.b = httpMessage;
        this.d = httpMessageTask;
        this.c = new com.baidu.adp.lib.network.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.adp.framework.message.c a(HttpMessage... httpMessageArr) {
        com.baidu.adp.lib.network.f fVar;
        String a;
        if (this.c.c()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(256);
        List<Map.Entry<String, Object>> c = this.b.c();
        HashMap<String, String> a2 = this.b.a();
        LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
        for (Map.Entry<String, String> entry : a2.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        HashMap<String, byte[]> hashMap = new HashMap<>();
        if (this.b.b()) {
            for (Map.Entry<String, Object> entry2 : c) {
                if (entry2 != null && entry2.getValue() != null) {
                    if (entry2.getValue() instanceof String) {
                        arrayList.add(new BasicNameValuePair(entry2.getKey(), (String) entry2.getValue()));
                    } else if (entry2.getValue() instanceof byte[]) {
                        hashMap.put(entry2.getKey(), (byte[]) entry2.getValue());
                    } else {
                        com.baidu.adp.lib.util.f.b("Ignore request param:" + entry2.getKey());
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c.size()) {
                break;
            }
            Map.Entry<String, Object> entry3 = c.get(i2);
            if (entry3 != null && (entry3.getValue() instanceof String)) {
                String key = entry3.getKey();
                String str = (String) entry3.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(key) + "=");
                sb.append(com.baidu.adp.lib.util.h.c(str));
            }
            i = i2 + 1;
        }
        String sb2 = sb.toString();
        int a3 = this.d.j().a();
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.toString());
        }
        if (this.d.c() == HttpMessageTask.HTTP_METHOD.GET) {
            fVar = com.baidu.adp.lib.network.e.a().a(this.d.a().endsWith("?") ? String.valueOf(a) + sb2 : String.valueOf(a) + "?" + sb2, this.d.d(), this.d.k(), 100, a3, (com.baidu.adp.lib.network.d) null, this.c, linkedList);
        } else {
            if (this.d.c() == HttpMessageTask.HTTP_METHOD.POST) {
                if (hashMap.size() > 0) {
                    fVar = com.baidu.adp.lib.network.e.a().a(this.d.a(), this.d.d(), arrayList, hashMap, this.d.k(), a3, null, this.c, null, linkedList);
                } else {
                    fVar = com.baidu.adp.lib.network.e.a().a(this.d.a(), sb2.getBytes(), this.d.d(), this.d.k(), a3, (com.baidu.adp.lib.network.d) null, this.c, linkedList);
                }
            }
            fVar = null;
        }
        if (fVar == null) {
            return null;
        }
        try {
            com.baidu.adp.framework.message.c newInstance = this.d.f().newInstance();
            newInstance.a(this.b);
            newInstance.a(fVar.a, fVar.b);
            if (newInstance.a()) {
                try {
                    newInstance.a(this.b.d(), (int) fVar.d);
                    newInstance.b(this.b.d(), fVar.d);
                    return newInstance;
                } catch (Exception e2) {
                    newInstance.a(-1003);
                    com.baidu.adp.lib.util.f.b(e2.toString());
                    return newInstance;
                }
            }
            return newInstance;
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b("responsedMessage create error reason = " + e3.toString());
            return new e(this.b.d(), this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.adp.framework.message.c cVar) {
        this.a.a.a(cVar);
    }
}
