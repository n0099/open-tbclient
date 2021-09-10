package c.a.q0.j0;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f13501a;

    /* renamed from: b  reason: collision with root package name */
    public c f13502b;

    /* renamed from: c  reason: collision with root package name */
    public Application f13503c;

    /* renamed from: d  reason: collision with root package name */
    public String f13504d;

    /* renamed from: e  reason: collision with root package name */
    public final j f13505e;

    /* renamed from: f  reason: collision with root package name */
    public final k f13506f;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            c.a.q0.j0.a a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            if (!f.i()) {
                String c2 = f.c();
                f.m(c2 + " Process Not In WhiteList，No Receive");
            } else if ("intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (a2 = this.this$0.f13505e.a(intent)) != null) {
                int myPid = Process.myPid();
                int pid = a2.getPid();
                if (a2 == null || a2.getType() != 1) {
                    if (a2.getType() == 2) {
                        if (myPid != pid) {
                            return;
                        }
                    } else if (a2.getType() == 3 && !f.l()) {
                        return;
                    }
                } else if (myPid == pid) {
                    return;
                }
                if (this.this$0.f13502b != null) {
                    this.this$0.f13502b.a(a2);
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13504d = null;
        this.f13505e = new j();
        this.f13506f = new k();
        this.f13503c = application;
    }

    @Override // c.a.q0.j0.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    @Override // c.a.q0.j0.d
    public void b(c.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            h(aVar);
        }
    }

    @Override // c.a.q0.j0.d
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f13502b = cVar;
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f13504d == null && (application = this.f13503c) != null) {
                this.f13504d = application.getPackageName();
            }
            return this.f13504d;
        }
        return (String) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                i();
                this.f13501a = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.setPriority(1000);
                intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.f13503c.registerReceiver(this.f13501a, intentFilter);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(c.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (aVar != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(f());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f13506f.a(intent, aVar);
                    this.f13503c.sendBroadcast(intent);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            throw new NullPointerException("send multi-process message is null");
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                if (this.f13501a == null || this.f13503c == null) {
                    return;
                }
                this.f13503c.unregisterReceiver(this.f13501a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
