package com.baidu.android.nebula.c;

import android.content.Context;
import android.os.Process;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a a;
    private final CharSequence b;
    private String c;

    public m(a aVar, CharSequence charSequence, String str) {
        this.a = aVar;
        this.c = null;
        this.b = charSequence;
        this.c = str;
    }

    private UrlEncodedFormEntity a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("needsdata", this.c));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
            try {
                urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
                return urlEncodedFormEntity;
            } catch (UnsupportedEncodingException e) {
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        InputStream inputStream;
        Throwable th;
        Process.setThreadPriority(10);
        context = this.a.a;
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a(context);
        HttpPost httpPost = new HttpPost(this.b.toString());
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    httpPost.addHeader("Accept-Encoding", "gzip");
                    httpPost.setEntity(a());
                    HttpResponse execute = aVar.execute(httpPost);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        HttpEntity entity = execute.getEntity();
                        inputStream2 = this.a.a(entity);
                        if (inputStream2 == null) {
                            try {
                                inputStream2 = entity.getContent();
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                aVar.a();
                                try {
                                    inputStream.close();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                throw th;
                            }
                        }
                        try {
                            this.a.a(inputStream2);
                            this.a.b();
                        } catch (IOException e2) {
                        } catch (JSONException e3) {
                        }
                    }
                    aVar.a();
                    try {
                        inputStream2.close();
                    } catch (Exception e4) {
                        System.out.println(e4.getMessage());
                    }
                } catch (ClientProtocolException e5) {
                    aVar.a();
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                        System.out.println(e6.getMessage());
                    }
                }
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } catch (IOException e7) {
            aVar.a();
            try {
                inputStream2.close();
            } catch (Exception e8) {
                System.out.println(e8.getMessage());
            }
        }
    }
}
