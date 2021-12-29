package c.a.s0.k0;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c f13147b;

    /* renamed from: c  reason: collision with root package name */
    public Application f13148c;

    /* renamed from: d  reason: collision with root package name */
    public String f13149d;

    /* renamed from: e  reason: collision with root package name */
    public final j f13150e;

    /* renamed from: f  reason: collision with root package name */
    public final k f13151f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
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
            c.a.s0.k0.a a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            if (!f.i()) {
                String c2 = f.c();
                f.m(c2 + " Process Not In WhiteList，No Receive");
            } else if ("intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (a = this.this$0.f13150e.a(intent)) != null) {
                int myPid = Process.myPid();
                int pid = a.getPid();
                if (a == null || a.getType() != 1) {
                    if (a.getType() == 2) {
                        if (myPid != pid) {
                            return;
                        }
                    } else if (a.getType() == 3 && !f.l()) {
                        return;
                    }
                } else if (myPid == pid) {
                    return;
                }
                if (this.this$0.f13147b != null) {
                    this.this$0.f13147b.a(a);
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
        this.f13149d = null;
        this.f13150e = new j();
        this.f13151f = new k();
        this.f13148c = application;
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                unregisterReceiver();
                this.a = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.setPriority(1000);
                intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.f13148c.registerReceiver(this.a, intentFilter);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.a == null || this.f13148c == null) {
                    return;
                }
                this.f13148c.unregisterReceiver(this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.s0.k0.d
    public void a(c.a.s0.k0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            f(aVar);
        }
    }

    @Override // c.a.s0.k0.d
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f13147b = cVar;
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f13149d == null && (application = this.f13148c) != null) {
                this.f13149d = application.getPackageName();
            }
            return this.f13149d;
        }
        return (String) invokeV.objValue;
    }

    public final void f(c.a.s0.k0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(e());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f13151f.a(intent, aVar);
                    this.f13148c.sendBroadcast(intent);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            throw new NullPointerException("send multi-process message is null");
        }
    }

    @Override // c.a.s0.k0.d
    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerReceiver();
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            unregisterReceiver();
        }
    }
}
