package com.baidu.nadcore.component.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import c.a.b0.g.a.a;
import com.baidu.nadcore.component.ComponentArchManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u0011J\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H&¢\u0006\u0004\b(\u0010\u0011J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010 \u001a\u00020)H&¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/baidu/nadcore/component/api/IComponentPlugin;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/Any;", "Landroid/app/Activity;", "activity", "", "injectActivity", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "context", "injectContext", "(Landroid/content/Context;)V", "Lcom/baidu/nadcore/component/ComponentArchManager;", "manager", "injectManager", "(Lcom/baidu/nadcore/component/ComponentArchManager;)V", "injectService", "()V", "onAttachToManager", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "onDetachFromManager", "onInit", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onRelease", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "nadcore-lib-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IComponentPlugin extends LifecycleObserver {
    void injectActivity(Activity activity);

    void injectContext(Context context);

    void injectManager(ComponentArchManager componentArchManager);

    void injectService();

    void onAttachToManager();

    void onConfigurationChanged(Configuration configuration);

    void onCreateView(ViewGroup viewGroup);

    void onDetachFromManager();

    void onInit();

    boolean onKeyDown(int i2, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onRelease();

    void receiveEvent(a aVar);
}
