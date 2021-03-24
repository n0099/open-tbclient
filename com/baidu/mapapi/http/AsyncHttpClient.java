package com.baidu.mapapi.http;

import android.os.Build;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class AsyncHttpClient {

    /* renamed from: a  reason: collision with root package name */
    public int f6778a = 4000;

    /* renamed from: b  reason: collision with root package name */
    public int f6779b = 4000;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f6780c = Executors.newCachedThreadPool();

    /* loaded from: classes2.dex */
    public static abstract class a implements Runnable {
        public a() {
        }

        public /* synthetic */ a(com.baidu.mapapi.http.a aVar) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public void get(String str, HttpClient.ProtoResultCallback protoResultCallback) {
        if (str == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }
        this.f6780c.submit(new com.baidu.mapapi.http.a(this, protoResultCallback, str));
    }

    public boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        return permissionCheck == 0 || permissionCheck == 602 || permissionCheck == 601;
    }
}
