package com.baidu.tbadk.core.keyboardheight;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.keyboardheight.KeyboardLifecycleHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.m;
import com.baidu.tieba.v85;
import com.baidu.tieba.w85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/tbadk/core/keyboardheight/KeyboardLifecycleHelper;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroid/app/Activity;", "observer", "Lcom/baidu/tbadk/core/keyboardheight/KeyboardHeightObserver;", "(Landroid/app/Activity;Lcom/baidu/tbadk/core/keyboardheight/KeyboardHeightObserver;)V", "isResumed", "", "keyboardHeightProvider", "Lcom/baidu/tbadk/core/keyboardheight/KeyboardHeightProvider;", "keyboardHeightRunnable", "Ljava/lang/Runnable;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyboardLifecycleHelper implements DefaultLifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final v85 b;
    public boolean c;
    public w85 d;
    public final Runnable e;

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStart(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public /* synthetic */ void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        m.$default$onStop(this, lifecycleOwner);
    }

    public KeyboardLifecycleHelper(Activity activity, v85 observer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, observer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.a = activity;
        this.b = observer;
        this.e = new Runnable() { // from class: com.baidu.tieba.u85
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    KeyboardLifecycleHelper.b(KeyboardLifecycleHelper.this);
                }
            }
        };
        SafeHandler.getInst().postDelayed(this.e, 1000L);
    }

    public static final void b(KeyboardLifecycleHelper this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.a.isFinishing()) {
                if (this$0.d == null) {
                    this$0.d = new w85(this$0.a);
                }
                w85 w85Var = this$0.d;
                if (w85Var != null) {
                    w85Var.h();
                }
                if (this$0.c) {
                    w85 w85Var2 = this$0.d;
                    if (w85Var2 != null) {
                        w85Var2.g(this$0.b);
                        return;
                    }
                    return;
                }
                w85 w85Var3 = this$0.d;
                if (w85Var3 != null) {
                    w85Var3.g(null);
                }
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            m.$default$onCreate(this, owner);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            w85 w85Var = this.d;
            if (w85Var != null) {
                w85Var.c();
            }
            SafeHandler.getInst().removeCallbacks(this.e);
            m.$default$onDestroy(this, owner);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            m.$default$onPause(this, owner);
            this.c = false;
            w85 w85Var = this.d;
            if (w85Var != null) {
                w85Var.g(null);
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, owner) == null) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            m.$default$onResume(this, owner);
            this.c = true;
            w85 w85Var = this.d;
            if (w85Var != null) {
                w85Var.g(this.b);
            }
        }
    }
}
