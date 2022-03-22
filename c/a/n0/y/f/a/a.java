package c.a.n0.y.f.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9539b;

    /* renamed from: c  reason: collision with root package name */
    public int f9540c;

    /* renamed from: d  reason: collision with root package name */
    public b f9541d;

    /* renamed from: c.a.n0.y.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0772a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public C0772a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") && (d2 = this.this$0.d()) != this.this$0.f9540c) {
                if (this.this$0.f9541d != null) {
                    this.this$0.f9541d.a(this.this$0.f9540c, d2);
                }
                this.this$0.f9540c = d2;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);
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

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (SwanAppNetworkUtils.j(this.f9539b)) {
                return 1;
            }
            return SwanAppNetworkUtils.i(this.f9539b) ? 2 : 0;
        }
        return invokeV.intValue;
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f9539b = context;
            this.f9540c = d();
            C0772a c0772a = new C0772a(this);
            this.a = c0772a;
            this.f9539b.registerReceiver(c0772a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f9541d = bVar;
        }
    }

    public void g() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (context = this.f9539b) == null) {
            return;
        }
        context.unregisterReceiver(this.a);
    }
}
