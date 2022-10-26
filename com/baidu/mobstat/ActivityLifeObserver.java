package com.baidu.mobstat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ActivityLifeObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final ActivityLifeObserver c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Application.ActivityLifecycleCallbacks b;
    public Set d;

    /* loaded from: classes2.dex */
    public interface IActivityLifeCallback {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1823214289, "Lcom/baidu/mobstat/ActivityLifeObserver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1823214289, "Lcom/baidu/mobstat/ActivityLifeObserver;");
                return;
            }
        }
        c = new ActivityLifeObserver();
    }

    public ActivityLifeObserver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedHashSet();
    }

    public static ActivityLifeObserver instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c;
        }
        return (ActivityLifeObserver) invokeV.objValue;
    }

    public void clearObservers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.d) {
                this.d.clear();
            }
        }
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iActivityLifeCallback) == null) {
            synchronized (this.d) {
                this.d.add(iActivityLifeCallback);
            }
        }
    }

    public void doRegister(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.b = new Application.ActivityLifecycleCallbacks(this) { // from class: com.baidu.mobstat.ActivityLifeObserver.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ActivityLifeObserver a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityCreated(activity, bundle);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivitySaveInstanceState(activity, bundle);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityDestroyed(activity);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityPaused(activity);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityResumed(activity);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityStarted(activity);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                        synchronized (this.a.d) {
                            for (IActivityLifeCallback iActivityLifeCallback : this.a.d) {
                                iActivityLifeCallback.onActivityStopped(activity);
                            }
                        }
                    }
                }
            };
            try {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.b);
            } catch (Exception unused) {
                bb.c().a("registerActivityLifecycleCallbacks encounter exception");
            }
        }
    }

    public void registerActivityLifeCallback(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, context) != null) || this.a || Build.VERSION.SDK_INT < 14) {
            return;
        }
        doRegister(context);
        this.a = true;
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iActivityLifeCallback) == null) {
            synchronized (this.d) {
                this.d.remove(iActivityLifeCallback);
            }
        }
    }

    public void unRegister(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            try {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
