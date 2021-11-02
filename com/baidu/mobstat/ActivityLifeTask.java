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
/* loaded from: classes7.dex */
public class ActivityLifeTask {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40691a;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f40692b;

    /* renamed from: c  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f40693c;

    /* renamed from: d  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f40694d;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityLifeObserver.IActivityLifeCallback f40695e;
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
                f40692b = new AutoTrack.MyActivityLifeCallback(1);
                f40694d = new af.a();
                f40693c = new av.a();
                f40695e = new AutoTrack.MyActivityLifeCallback(2);
            }
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (ActivityLifeTask.class) {
                if (f40691a) {
                    return;
                }
                a(context);
                ActivityLifeObserver.instance().clearObservers();
                ActivityLifeObserver.instance().addObserver(f40692b);
                ActivityLifeObserver.instance().addObserver(f40694d);
                ActivityLifeObserver.instance().addObserver(f40693c);
                ActivityLifeObserver.instance().addObserver(f40695e);
                ActivityLifeObserver.instance().registerActivityLifeCallback(context);
                f40691a = true;
            }
        }
    }
}
