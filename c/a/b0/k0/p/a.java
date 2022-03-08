package c.a.b0.k0.p;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c.a.b0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1746e;

    /* renamed from: f  reason: collision with root package name */
    public int f1747f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f1748g;

    /* renamed from: c.a.b0.k0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Application f1749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1750f;

        public C0065a(a aVar, Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1750f = aVar;
            this.f1749e = application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && (view = (View) this.f1750f.f1748g.get()) != null && activity == view.getContext()) {
                this.f1750f.f1746e = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            View view;
            Application application;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || (view = (View) this.f1750f.f1748g.get()) == null || activity != view.getContext() || (application = this.f1749e) == null) {
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (view = (View) this.f1750f.f1748g.get()) != null && activity == view.getContext()) {
                this.f1750f.f1746e = true;
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

    public a(View view) {
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
        this.f1746e = false;
        this.f1747f = -1;
        this.f1748g = new WeakReference<>(view);
        c();
    }

    public final void c() {
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.b0.k0.i.b.c() instanceof Application) {
                application = (Application) c.a.b0.k0.i.b.c();
            } else {
                application = (Application) c.a.b0.k0.i.b.c().getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new C0065a(this, application));
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f1748g.get()) == null) {
            return;
        }
        if (this.f1747f < ((int) (f.c.f(view.getContext()) * 0.85f)) || this.f1746e) {
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
            if (this.f1747f == measuredHeight || measuredHeight <= 0) {
                return;
            }
            this.f1747f = measuredHeight;
            view.getLayoutParams().height = measuredHeight;
            view.requestLayout();
        }
    }
}
