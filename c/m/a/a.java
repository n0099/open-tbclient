package c.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34217a;

    /* renamed from: b  reason: collision with root package name */
    public Context f34218b;

    /* renamed from: c  reason: collision with root package name */
    public c f34219c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f34220d;

    /* renamed from: c.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ServiceConnectionC1513a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f34221e;

        public ServiceConnectionC1513a(a aVar) {
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
            this.f34221e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, componentName) == null) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, componentName, iBinder) == null) {
                this.f34221e.f34217a.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
                this.f34221e.f34217a.removeMessages(2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f34222a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34222a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.f34222a.f34219c.a(-1, null);
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    this.f34222a.f34219c.a(-2, null);
                } else {
                    OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                    try {
                        try {
                            this.f34222a.f34219c.b(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                            try {
                                this.f34222a.f34218b.unbindService(this.f34222a.f34220d);
                            } catch (Exception e2) {
                                this.f34222a.f34219c.a(-4, e2);
                            }
                        } catch (RemoteException e3) {
                            this.f34222a.f34219c.a(-3, e3);
                            try {
                                this.f34222a.f34218b.unbindService(this.f34222a.f34220d);
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            this.f34222a.f34218b.unbindService(this.f34222a.f34220d);
                        } catch (Exception e4) {
                            this.f34222a.f34219c.a(-4, e4);
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, Exception exc);

        void b(String str, boolean z);
    }

    public a(Context context, c cVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34220d = new ServiceConnectionC1513a(this);
        this.f34218b = context;
        this.f34219c = cVar;
        this.f34217a = new b(this, handler == null ? Looper.getMainLooper() : handler.getLooper());
    }

    public static void d(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, cVar) == null) {
            e(context, cVar, null);
        }
    }

    public static void e(Context context, c cVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, cVar, handler) == null) {
            new a(context.getApplicationContext(), cVar, handler).f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.f34218b.bindService(intent, this.f34220d, 1)) {
                Handler handler = this.f34217a;
                handler.sendMessageDelayed(handler.obtainMessage(2), 10000L);
                return;
            }
            this.f34217a.sendEmptyMessage(0);
        }
    }
}
