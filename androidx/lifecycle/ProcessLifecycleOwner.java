package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ProcessLifecycleOwner implements LifecycleOwner {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final long TIMEOUT_MS = 700;
    public static final ProcessLifecycleOwner sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable mDelayedPauseRunnable;
    public Handler mHandler;
    public ReportFragment.ActivityInitializationListener mInitializationListener;
    public boolean mPauseSent;
    public final LifecycleRegistry mRegistry;
    public int mResumedCounter;
    public int mStartedCounter;
    public boolean mStopSent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19541886, "Landroidx/lifecycle/ProcessLifecycleOwner;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-19541886, "Landroidx/lifecycle/ProcessLifecycleOwner;");
                return;
            }
        }
        sInstance = new ProcessLifecycleOwner();
    }

    public ProcessLifecycleOwner() {
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
        this.mStartedCounter = 0;
        this.mResumedCounter = 0;
        this.mPauseSent = true;
        this.mStopSent = true;
        this.mRegistry = new LifecycleRegistry(this);
        this.mDelayedPauseRunnable = new Runnable(this) { // from class: androidx.lifecycle.ProcessLifecycleOwner.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ProcessLifecycleOwner this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.dispatchPauseIfNeeded();
                    this.this$0.dispatchStopIfNeeded();
                }
            }
        };
        this.mInitializationListener = new ReportFragment.ActivityInitializationListener(this) { // from class: androidx.lifecycle.ProcessLifecycleOwner.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ProcessLifecycleOwner this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
            public void onCreate() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
            public void onResume() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.activityResumed();
                }
            }

            @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
            public void onStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.activityStarted();
                }
            }
        };
    }

    @NonNull
    public static LifecycleOwner get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sInstance : (LifecycleOwner) invokeV.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            sInstance.attach(context);
        }
    }

    public void activityPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.mResumedCounter - 1;
            this.mResumedCounter = i;
            if (i == 0) {
                this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700L);
            }
        }
    }

    public void activityResumed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.mResumedCounter + 1;
            this.mResumedCounter = i;
            if (i == 1) {
                if (this.mPauseSent) {
                    this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                    this.mPauseSent = false;
                    return;
                }
                this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
            }
        }
    }

    public void activityStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.mStartedCounter + 1;
            this.mStartedCounter = i;
            if (i == 1 && this.mStopSent) {
                this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                this.mStopSent = false;
            }
        }
    }

    public void activityStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mStartedCounter--;
            dispatchStopIfNeeded();
        }
    }

    public void attach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.mHandler = new Handler();
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks(this) { // from class: androidx.lifecycle.ProcessLifecycleOwner.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ProcessLifecycleOwner this$0;

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
                    this.this$0 = this;
                }

                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) || Build.VERSION.SDK_INT >= 29) {
                        return;
                    }
                    ReportFragment.get(activity).setProcessListener(this.this$0.mInitializationListener);
                }

                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                        this.this$0.activityPaused();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
                        activity.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks(this) { // from class: androidx.lifecycle.ProcessLifecycleOwner.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPostResumed(@NonNull Activity activity2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, activity2) == null) {
                                    this.this$1.this$0.activityResumed();
                                }
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPostStarted(@NonNull Activity activity2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity2) == null) {
                                    this.this$1.this$0.activityStarted();
                                }
                            }
                        });
                    }
                }

                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                        this.this$0.activityStopped();
                    }
                }
            });
        }
    }

    public void dispatchPauseIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public void dispatchStopIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRegistry : (Lifecycle) invokeV.objValue;
    }
}
