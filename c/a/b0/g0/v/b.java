package c.a.b0.g0.v;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c.a.b0.d0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1616e;

    /* renamed from: f  reason: collision with root package name */
    public int f1617f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f1618g;

    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Application f1619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1620f;

        public a(b bVar, Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1620f = bVar;
            this.f1619e = application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && (view = (View) this.f1620f.f1618g.get()) != null && activity == view.getContext()) {
                this.f1620f.f1616e = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            View view;
            Application application;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || (view = (View) this.f1620f.f1618g.get()) == null || activity != view.getContext() || (application = this.f1619e) == null) {
                return;
            }
            application.unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (view = (View) this.f1620f.f1618g.get()) != null && activity == view.getContext()) {
                this.f1620f.f1616e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1616e = false;
        this.f1617f = -1;
        this.f1618g = new WeakReference<>(view);
        c();
    }

    public final void c() {
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.b0.g0.p.b.c() instanceof Application) {
                application = (Application) c.a.b0.g0.p.b.c();
            } else {
                application = (Application) c.a.b0.g0.p.b.c().getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new a(this, application));
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f1618g.get()) == null) {
            return;
        }
        if (this.f1617f < ((int) (f.c.f(view.getContext()) * 0.85f)) || this.f1616e) {
            if (ViewCompat.isAttachedToWindow(view)) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.top;
                if (i2 == 0) {
                    i2 = f.c.g();
                }
                measuredHeight = rect.bottom - i2;
            } else {
                measuredHeight = view.getMeasuredHeight();
            }
            if (this.f1617f == measuredHeight || measuredHeight <= 0) {
                return;
            }
            this.f1617f = measuredHeight;
            view.getLayoutParams().height = measuredHeight;
            view.requestLayout();
        }
    }
}
