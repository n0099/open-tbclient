package com.baidu.mapapi.http;

import android.os.Build;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class AsyncHttpClient {
    public int a = 10000;
    public int b = 10000;
    public ExecutorService c = Executors.newCachedThreadPool();

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        public abstract void a();

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public /* synthetic */ a(com.baidu.mapapi.http.a aVar) {
            this();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", CommandUBCHelper.COMMAND_UBC_VALUE_FALSE);
        }
    }

    public boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        if (permissionCheck != 0 && permissionCheck != 602 && permissionCheck != 601) {
            return false;
        }
        return true;
    }

    public void get(String str, HttpClient.ProtoResultCallback protoResultCallback) {
        if (str != null) {
            this.c.submit(new com.baidu.mapapi.http.a(this, protoResultCallback, str));
            return;
        }
        throw new IllegalArgumentException("URI cannot be null");
    }
}
