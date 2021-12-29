package c.q.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes9.dex */
public class t0 implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31437e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31438f;

    /* renamed from: g  reason: collision with root package name */
    public final BlockingQueue f31439g;

    public t0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31438f = false;
        this.f31439g = new LinkedBlockingQueue();
        this.f31437e = context;
    }

    public IBinder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f31438f) {
                throw new IllegalStateException("Binder already consumed");
            }
            IBinder iBinder = (IBinder) this.f31439g.take();
            if (iBinder != null) {
                this.f31438f = true;
            }
            return iBinder;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
            try {
                this.f31439g.put(iBinder);
                String a = ((com.win.opensdk.a) com.win.opensdk.b.a(iBinder)).a();
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                m2.x(this.f31437e, a);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
        }
    }
}
