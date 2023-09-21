package com.baidu.nadcore.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.nadcore.component.api.IComponentPlugin;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.qj0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b>\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0010J\u001f\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0017¢\u0006\u0004\b)\u0010\u0010J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\u0004H\u0017¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010,\u001a\u00020\u0004H\u0017¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010-\u001a\u00020\u0004H\u0017¢\u0006\u0004\b-\u0010\u0010J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100R\"\u0010\b\u001a\u00020\u00078\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\nR\"\u00105\u001a\u00020\u00028\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0006R\"\u0010\f\u001a\u00020\u000b8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\f\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\u000e¨\u0006?"}, d2 = {"Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/component/api/IComponentPlugin;", "Landroid/app/Activity;", "activity", "", "injectActivity", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "context", "injectContext", "(Landroid/content/Context;)V", "Lcom/baidu/nadcore/component/ComponentArchManager;", "manager", "injectManager", "(Lcom/baidu/nadcore/component/ComponentArchManager;)V", "injectService", "()V", "onAttachToManager", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", MissionEvent.MESSAGE_DESTROY, "onDetachFromManager", "onInit", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "hostActivity", "Landroid/app/Activity;", "getHostActivity", "()Landroid/app/Activity;", "setHostActivity", "Lcom/baidu/nadcore/component/ComponentArchManager;", "getManager", "()Lcom/baidu/nadcore/component/ComponentArchManager;", "setManager", "<init>", "nadcore-lib-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class AbsComponentPlugin implements IComponentPlugin {
    public Context a;
    public ComponentArchManager b;
    public Activity c;

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void J(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void m() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void onInit() {
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void s(qj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void x() {
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void z() {
    }

    public final Activity b() {
        Activity activity = this.c;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostActivity");
        }
        return activity;
    }

    public final ComponentArchManager c() {
        ComponentArchManager componentArchManager = this.b;
        if (componentArchManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
        }
        return componentArchManager;
    }

    public final Context getContext() {
        Context context = this.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void injectContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void u(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c = activity;
    }

    @Override // com.baidu.nadcore.component.api.IComponentPlugin
    public void y(ComponentArchManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.b = manager;
    }
}
