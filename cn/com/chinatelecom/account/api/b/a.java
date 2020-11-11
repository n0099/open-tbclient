package cn.com.chinatelecom.account.api.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class a {
    private static Executor b = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public Handler f973a = new Handler(Looper.getMainLooper());
}
