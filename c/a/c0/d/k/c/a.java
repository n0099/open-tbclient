package c.a.c0.d.k.c;

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
public final class a extends c.a.c0.q.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.c0.d.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0044a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f1779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f1780f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f1781g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f1782h;

        public RunnableC0044a(long j2, long j3, long j4, String str) {
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
            this.f1779e = j2;
            this.f1780f = j3;
            this.f1781g = j4;
            this.f1782h = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1779e < c.c()) {
                    c.z();
                } else if (c.f()) {
                    return;
                } else {
                    c.h(this.f1780f, this.f1781g, this.f1782h);
                }
                c.g(this.f1780f, "boot_from_cold", this.f1781g, this.f1782h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f1783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f1784f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1785g;

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
            this.f1783e = j2;
            this.f1784f = j3;
            this.f1785g = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.g(this.f1783e, "boot_from_background", this.f1784f, this.f1785g);
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

    @Override // c.a.c0.q.b, c.a.c0.q.d
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
                RunnableC0044a runnableC0044a = new RunnableC0044a(System.currentTimeMillis() - j3, j3, System.currentTimeMillis(), i2);
                Handler handler = new Handler();
                j2 = c.a.c0.d.k.c.b.a;
                handler.postDelayed(runnableC0044a, j2);
            }
        }
    }

    @Override // c.a.c0.q.b, c.a.c0.q.d
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
                j2 = c.a.c0.d.k.c.b.a;
                handler.postDelayed(bVar, j2);
            }
        }
    }

    @Override // c.a.c0.q.b, c.a.c0.q.d
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            c.w(activity);
        }
    }
}
