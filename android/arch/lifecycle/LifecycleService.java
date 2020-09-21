package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
/* loaded from: classes14.dex */
public class LifecycleService extends Service implements j {
    private final u mDispatcher = new u(this);

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.mDispatcher.hI();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    @Nullable
    public IBinder onBind(Intent intent) {
        this.mDispatcher.hJ();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onStart(Intent intent, int i) {
        this.mDispatcher.hK();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.mDispatcher.hL();
        super.onDestroy();
    }

    @Override // android.arch.lifecycle.j
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }
}
