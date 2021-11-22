package b.a.p0.a.d1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> mActivityRef;
    public CallbackHandler mCallbackHandler;
    public Context mContext;
    public b.a.p0.a.h0.f.a mJsContainer;
    public UnitedSchemeMainDispatcher mMainDispatcher;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1320901318, "Lb/a/p0/a/d1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1320901318, "Lb/a/p0/a/d1/a;");
                return;
            }
        }
        DEBUG = k.f6863a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public a(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
        this.mJsContainer = aVar;
        if (DEBUG) {
            if (context == null || unitedSchemeMainDispatcher == null) {
                throw new IllegalArgumentException("any of context, dispatcher objects can't be null.");
            }
        }
    }

    public Context getDispatchContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Activity> weakReference = this.mActivityRef;
            Activity activity = weakReference != null ? weakReference.get() : null;
            return activity == null ? this.mContext : activity;
        }
        return (Context) invokeV.objValue;
    }

    public void setActivityRef(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        this.mActivityRef = new WeakReference<>(activity);
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler) == null) {
            this.mCallbackHandler = callbackHandler;
        }
    }
}
