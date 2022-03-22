package c.a.a0.d.b.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a extends c.a.a0.q.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.d.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0013a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f1083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f1084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1085d;

        public RunnableC0013a(long j, long j2, long j3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.f1083b = j2;
            this.f1084c = j3;
            this.f1085d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a < c.c()) {
                    c.z();
                } else if (c.f()) {
                    return;
                } else {
                    c.h(this.f1083b, this.f1084c, this.f1085d);
                }
                c.g(this.f1083b, "boot_from_cold", this.f1084c, this.f1085d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f1086b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1087c;

        public b(long j, long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.f1086b = j2;
            this.f1087c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.g(this.a, "boot_from_background", this.f1086b, this.f1087c);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.a0.q.b, c.a.a0.q.e
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (TextUtils.equals(activity.getLocalClassName(), "MainActivity")) {
                if (!c.d()) {
                    c.l();
                    return;
                }
                String i = c.i();
                long j2 = c.j();
                RunnableC0013a runnableC0013a = new RunnableC0013a(System.currentTimeMillis() - j2, j2, System.currentTimeMillis(), i);
                Handler handler = new Handler();
                j = c.a.a0.d.b.c.b.a;
                handler.postDelayed(runnableC0013a, j);
            }
        }
    }

    @Override // c.a.a0.q.b, c.a.a0.q.e
    public void onBackgroundToForeground(Activity activity) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!c.d()) {
                c.l();
            } else if (TextUtils.equals(activity.getLocalClassName(), c.k())) {
                String i = c.i();
                long j2 = c.j();
                long currentTimeMillis = System.currentTimeMillis();
                if (System.currentTimeMillis() - j2 < c.c()) {
                    c.z();
                    c.y();
                }
                b bVar = new b(j2, currentTimeMillis, i);
                Handler handler = new Handler();
                j = c.a.a0.d.b.c.b.a;
                handler.postDelayed(bVar, j);
            }
        }
    }

    @Override // c.a.a0.q.b, c.a.a0.q.e
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c.w(activity);
        }
    }
}
