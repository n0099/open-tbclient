package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* loaded from: classes15.dex */
class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.mFullLifecycleObserver = fullLifecycleObserver;
        this.mLifecycleEventObserver = lifecycleEventObserver;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.mFullLifecycleObserver.onCreate(lifecycleOwner);
                break;
            case ON_START:
                this.mFullLifecycleObserver.onStart(lifecycleOwner);
                break;
            case ON_RESUME:
                this.mFullLifecycleObserver.onResume(lifecycleOwner);
                break;
            case ON_PAUSE:
                this.mFullLifecycleObserver.onPause(lifecycleOwner);
                break;
            case ON_STOP:
                this.mFullLifecycleObserver.onStop(lifecycleOwner);
                break;
            case ON_DESTROY:
                this.mFullLifecycleObserver.onDestroy(lifecycleOwner);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        if (this.mLifecycleEventObserver != null) {
            this.mLifecycleEventObserver.onStateChanged(lifecycleOwner, event);
        }
    }
}
