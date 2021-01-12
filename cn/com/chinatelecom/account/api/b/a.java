package cn.com.chinatelecom.account.api.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static Executor f1105b = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    public Handler f1106a = new Handler(Looper.getMainLooper());
}
