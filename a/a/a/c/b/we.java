package a.a.a.c.b;

import android.os.Handler;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class we implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1437a;

    public we(trw trwVar, Handler handler) {
        this.f1437a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1437a.post(runnable);
    }
}
