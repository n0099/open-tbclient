package c.a.b0.b.l.c;

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
public final class a extends c.a.b0.n.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.b.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0018a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f1366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f1367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f1368g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f1369h;

        public RunnableC0018a(long j2, long j3, long j4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1366e = j2;
            this.f1367f = j3;
            this.f1368g = j4;
            this.f1369h = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1366e < c.c()) {
                    c.z();
                } else if (c.f()) {
                    return;
                } else {
                    c.h(this.f1367f, this.f1368g, this.f1369h);
                }
                c.g(this.f1367f, "boot_from_cold", this.f1368g, this.f1369h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f1370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f1371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1372g;

        public b(long j2, long j3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1370e = j2;
            this.f1371f = j3;
            this.f1372g = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.g(this.f1370e, "boot_from_background", this.f1371f, this.f1372g);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.b0.n.b, c.a.b0.n.d
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (TextUtils.equals(activity.getLocalClassName(), "MainActivity")) {
                if (!c.d()) {
                    c.l();
                    return;
                }
                String i2 = c.i();
                long j3 = c.j();
                RunnableC0018a runnableC0018a = new RunnableC0018a(System.currentTimeMillis() - j3, j3, System.currentTimeMillis(), i2);
                Handler handler = new Handler();
                j2 = c.a.b0.b.l.c.b.a;
                handler.postDelayed(runnableC0018a, j2);
            }
        }
    }

    @Override // c.a.b0.n.b, c.a.b0.n.d
    public void onBackgroundToForeground(Activity activity) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!c.d()) {
                c.l();
            } else if (TextUtils.equals(activity.getLocalClassName(), c.k())) {
                String i2 = c.i();
                long j3 = c.j();
                long currentTimeMillis = System.currentTimeMillis();
                if (System.currentTimeMillis() - j3 < c.c()) {
                    c.z();
                    c.y();
                }
                b bVar = new b(j3, currentTimeMillis, i2);
                Handler handler = new Handler();
                j2 = c.a.b0.b.l.c.b.a;
                handler.postDelayed(bVar, j2);
            }
        }
    }

    @Override // c.a.b0.n.b, c.a.b0.n.d
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c.w(activity);
        }
    }
}
