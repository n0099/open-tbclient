package b.a.p0.a.y1.c.e;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.d;
import b.a.p0.a.k;
import b.a.p0.a.y1.c.a;
import b.a.p0.a.y1.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes.dex */
public class b implements a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Deque<Message> f9484a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1527717872, "Lb/a/p0/a/y1/c/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1527717872, "Lb/a/p0/a/y1/c/e/b;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9484a = new ArrayDeque();
    }

    @Override // b.a.p0.a.y1.c.a.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a P = a.P();
            while (P.N() && !this.f9484a.isEmpty()) {
                Message peek = this.f9484a.peek();
                if (peek == null || e(peek)) {
                    this.f9484a.poll();
                }
            }
        }
    }

    @Override // b.a.p0.a.y1.c.a.c
    public void b(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            Message h2 = cVar.h();
            h2.arg1 = SwanAppProcessInfo.current().index;
            if (d.J().D()) {
                Object obj = h2.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    if (!bundle.containsKey("ai_apps_id")) {
                        bundle.putString("ai_apps_id", d.J().getAppId());
                    }
                }
            }
            if (e(h2) || !cVar.n()) {
                return;
            }
            this.f9484a.offer(h2);
            a.P().b0();
        }
    }

    @Override // b.a.p0.a.y1.c.a.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.y1.c.a.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final boolean e(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
            a P = a.P();
            if (message == null || !P.N()) {
                return false;
            }
            try {
                P.R().send(message);
                return true;
            } catch (RemoteException e2) {
                P.T();
                b.a.p0.a.e0.d.l("SwanMsgSenderOfClient", " sendMsgToService msg = " + message.toString(), e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
