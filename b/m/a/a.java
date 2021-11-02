package b.m.a;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f33135a;

    /* renamed from: b  reason: collision with root package name */
    public Context f33136b;

    /* renamed from: c  reason: collision with root package name */
    public c f33137c;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f33138d;

    /* renamed from: b.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ServiceConnectionC1508a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f33139e;

        public ServiceConnectionC1508a(a aVar) {
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
            this.f33139e = aVar;
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
                this.f33139e.f33135a.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
                this.f33139e.f33135a.removeMessages(2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f33140a;

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
            this.f33140a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.f33140a.f33137c.a(-1, null);
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    this.f33140a.f33137c.a(-2, null);
                } else {
                    OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                    try {
                        try {
                            this.f33140a.f33137c.b(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                            try {
                                this.f33140a.f33136b.unbindService(this.f33140a.f33138d);
                            } catch (Exception e2) {
                                this.f33140a.f33137c.a(-4, e2);
                            }
                        } catch (RemoteException e3) {
                            this.f33140a.f33137c.a(-3, e3);
                            try {
                                this.f33140a.f33136b.unbindService(this.f33140a.f33138d);
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            this.f33140a.f33136b.unbindService(this.f33140a.f33138d);
                        } catch (Exception e4) {
                            this.f33140a.f33137c.a(-4, e4);
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f33138d = new ServiceConnectionC1508a(this);
        this.f33136b = context;
        this.f33137c = cVar;
        this.f33135a = new b(this, handler == null ? Looper.getMainLooper() : handler.getLooper());
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
            if (this.f33136b.bindService(intent, this.f33138d, 1)) {
                Handler handler = this.f33135a;
                handler.sendMessageDelayed(handler.obtainMessage(2), 10000L);
                return;
            }
            this.f33135a.sendEmptyMessage(0);
        }
    }
}
