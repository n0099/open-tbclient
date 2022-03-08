package c.a.j.j.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class b implements c.a.j.h.b.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.j.a f3766b;

    public b(c.a.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3766b = aVar;
    }

    @Override // c.a.j.h.b.d.a
    public Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (c.a.j.h.d.a.a(activity)) {
                return null;
            }
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // c.a.j.h.b.d.a
    public c.a.j.h.b.d.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.j.h.b.d.b r = this.f3766b.r();
            Intrinsics.checkExpressionValueIsNotNull(r, "bdTaskConfig.taskEnv");
            return r;
        }
        return (c.a.j.h.b.d.b) invokeV.objValue;
    }

    @Override // c.a.j.h.b.d.a
    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || c.a.j.h.d.a.a(activity)) {
            return;
        }
        this.a = new WeakReference<>(activity);
    }

    @Override // c.a.j.h.b.d.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3766b.t() : invokeV.booleanValue;
    }

    @Override // c.a.j.h.b.d.a
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.f3766b.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "bdTaskConfig.context");
            return context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // c.a.j.h.b.d.a
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String k = this.f3766b.k();
            Intrinsics.checkExpressionValueIsNotNull(k, "bdTaskConfig.appVersion");
            return k;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.j.h.b.d.a
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String q = this.f3766b.q();
            Intrinsics.checkExpressionValueIsNotNull(q, "bdTaskConfig.sdkVersion");
            return q;
        }
        return (String) invokeV.objValue;
    }
}
