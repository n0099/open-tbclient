package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Build;
import com.baidu.mapapi.UIMsg;
import com.baidu.webkit.internal.ABTestConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class a {
    private int a = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
    private int b = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
    private ExecutorService c = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractRunnableC0094a implements Runnable {
        private AbstractRunnableC0094a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractRunnableC0094a(b bVar) {
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
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
    }

    public void a(String str, e eVar) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Request URL cannot be null");
        }
        this.c.submit(new b(this, eVar, str));
    }
}
