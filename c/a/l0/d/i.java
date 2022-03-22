package c.a.l0.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile i f3582g;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: b  reason: collision with root package name */
    public int f3583b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3584c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3585d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3586e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f3587f;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String stringExtra = intent.getStringExtra("ss");
                if (this.a.f3583b == 1) {
                    return;
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    this.a.f3583b = 1;
                } else if ("LOADED".equals(stringExtra)) {
                    if (this.a.f3587f.isEmpty()) {
                        return;
                    }
                    this.a.f3583b = 1;
                } else {
                    this.a.f3583b = 1;
                    this.a.f3587f.add(stringExtra);
                }
            }
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3583b = 0;
        this.f3584c = false;
        this.f3585d = false;
        this.f3586e = false;
        this.f3587f = new HashSet<>();
    }

    public static i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f3582g == null) {
                synchronized (i.class) {
                    if (f3582g == null) {
                        f3582g = new i();
                    }
                }
            }
            return f3582g;
        }
        return (i) invokeV.objValue;
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                if (this.a != null) {
                    return;
                }
                this.a = new a(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
                context.registerReceiver(this.a, intentFilter);
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
        }
    }

    public void e(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject) == null) {
            this.f3585d = jSONObject.optInt("1", 0) == 1;
            this.f3584c = jSONObject.optInt("2", 0) == 1;
            this.f3586e = jSONObject.optInt("3", 0) == 1;
            if (this.f3584c) {
                d(context);
            } else {
                h(context);
            }
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f3584c) {
                return this.f3583b;
            }
            return -1000;
        }
        return invokeV.intValue;
    }

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            try {
                if (this.a == null) {
                    return;
                }
                context.unregisterReceiver(this.a);
                this.a = null;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f3585d) {
                if (this.f3586e) {
                    return this.f3584c && this.f3583b != 1;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f3583b = 0;
            this.f3587f.clear();
        }
    }
}
