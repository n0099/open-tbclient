package com.baidu.mapapi.http;

import android.os.Build;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class AsyncHttpClient {
    private int a = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
    private int b = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
    private ExecutorService c = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class a implements Runnable {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
        this.c.submit(new com.baidu.mapapi.http.a(this, protoResultCallback, str));
    }

    protected boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        return permissionCheck == 0 || permissionCheck == 602 || permissionCheck == 601;
    }
}
