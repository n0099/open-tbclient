package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
/* loaded from: classes15.dex */
public class LifecycleService extends Service implements j {
    private final u mDispatcher = new u(this);

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.mDispatcher.hJ();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    @Nullable
    public IBinder onBind(Intent intent) {
        this.mDispatcher.hK();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onStart(Intent intent, int i) {
        this.mDispatcher.hL();
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
        this.mDispatcher.hM();
        super.onDestroy();
    }

    @Override // android.arch.lifecycle.j
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }
}
