package com.baidu.mobstat;

import android.annotation.TargetApi;
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
/* loaded from: classes5.dex */
public class ActivityLifeObserver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final ActivityLifeObserver f42790b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42791a;

    /* renamed from: c  reason: collision with root package name */
    public Set<IActivityLifeCallback> f42792c;

    /* loaded from: classes5.dex */
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
        f42790b = new ActivityLifeObserver();
    }

    public ActivityLifeObserver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42792c = new LinkedHashSet();
    }

    public static ActivityLifeObserver instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f42790b : (ActivityLifeObserver) invokeV.objValue;
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iActivityLifeCallback) == null) {
            synchronized (this.f42792c) {
                this.f42792c.add(iActivityLifeCallback);
            }
        }
    }

    public void clearObservers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f42792c) {
                this.f42792c.clear();
            }
        }
    }

    @TargetApi(14)
    public void doRegister(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            try {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) { // from class: com.baidu.mobstat.ActivityLifeObserver.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ActivityLifeObserver f42793a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f42793a = this;
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityCreated(activity, bundle);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityDestroyed(activity);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityPaused(activity);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityResumed(activity);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivitySaveInstanceState(activity, bundle);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityStarted(activity);
                                }
                            }
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                            synchronized (this.f42793a.f42792c) {
                                for (IActivityLifeCallback iActivityLifeCallback : this.f42793a.f42792c) {
                                    iActivityLifeCallback.onActivityStopped(activity);
                                }
                            }
                        }
                    }
                });
            } catch (Exception unused) {
                bc.c().a("registerActivityLifecycleCallbacks encounter exception");
            }
        }
    }

    public void registerActivityLifeCallback(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || this.f42791a || Build.VERSION.SDK_INT < 14) {
            return;
        }
        doRegister(context);
        this.f42791a = true;
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iActivityLifeCallback) == null) {
            synchronized (this.f42792c) {
                this.f42792c.remove(iActivityLifeCallback);
            }
        }
    }
}
