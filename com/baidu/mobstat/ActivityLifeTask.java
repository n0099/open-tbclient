package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver;
import com.baidu.mobstat.AutoTrack;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ActivityLifeTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8395a;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8396b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8397c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8398d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f8399e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-822234110, "Lcom/baidu/mobstat/ActivityLifeTask;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-822234110, "Lcom/baidu/mobstat/ActivityLifeTask;");
        }
    }

    public ActivityLifeTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (ActivityLifeTask.class) {
                f8396b = new AutoTrack.MyActivityLifeCallback(1);
                f8398d = new af.a();
                f8397c = new av.a();
                f8399e = new AutoTrack.MyActivityLifeCallback(2);
            }
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (ActivityLifeTask.class) {
                if (f8395a) {
                    return;
                }
                a(context);
                ActivityLifeObserver.instance().clearObservers();
                ActivityLifeObserver.instance().addObserver(f8396b);
                ActivityLifeObserver.instance().addObserver(f8398d);
                ActivityLifeObserver.instance().addObserver(f8397c);
                ActivityLifeObserver.instance().addObserver(f8399e);
                ActivityLifeObserver.instance().registerActivityLifeCallback(context);
                f8395a = true;
            }
        }
    }
}
