package c.a.c0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2200b;

    /* renamed from: c  reason: collision with root package name */
    public int f2201c;

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f2202d;

    /* renamed from: e  reason: collision with root package name */
    public c f2203e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: c.a.c0.i.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0078a extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a this$1;

            public C0078a(a aVar) {
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
                this.this$1 = aVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && NetUtil.a(c.a.c0.e.a.b())) {
                    e.c().b();
                    try {
                        c.a.c0.e.a.b().unregisterReceiver(this);
                    } catch (Exception unused) {
                    }
                    this.this$1.a.f2202d = null;
                }
            }
        }

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.c0.i.j
        public void a(ADConfigError aDConfigError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDConfigError) == null) || this.a.f2203e == null || this.a.f2203e.i() || aDConfigError == null || TextUtils.isEmpty(aDConfigError.reason)) {
                return;
            }
            if (!NetUtil.a(c.a.c0.e.a.b())) {
                if (this.a.f2202d == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    this.a.f2202d = new C0078a(this);
                    c.a.c0.e.a.b().registerReceiver(this.a.f2202d, intentFilter);
                    return;
                }
                return;
            }
            e.c().b();
        }
    }

    public f(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f2201c = i3;
        this.f2200b = z;
    }

    public void d() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f2203e) == null) {
            return;
        }
        cVar.l(null);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = new c(this.a, this.f2200b, this.f2201c);
            this.f2203e = cVar;
            cVar.l(new a(this));
            c.a.c0.a0.b.c(this.f2203e, "adc_async_request", 0);
        }
    }
}
