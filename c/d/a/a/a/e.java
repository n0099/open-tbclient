package c.d.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.StrategyProcess;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f31715b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31716a;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (10001 == i2) {
                    f fVar = (f) message.obj;
                    c.d.a.a.a.b.a().c(StatApi.getAppContext(), fVar.f31723f);
                    d.a().c(fVar);
                } else if (10002 != i2) {
                    if (10003 == i2) {
                        d.a().h();
                    }
                } else {
                    String str = (String) message.obj;
                    d.a().b(message.arg1, str);
                    d.a().d(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f31717a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1432477435, "Lc/d/a/a/a/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1432477435, "Lc/d/a/a/a/e$b;");
                    return;
                }
            }
            f31717a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f31717a : (e) invokeV.objValue;
    }

    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            f31715b.obtainMessage(10002, i2, -1, str).sendToTarget();
        }
    }

    public void c(String str, String str2, String str3, String str4, long j2) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
            if (str3 != null) {
                arrayList = new ArrayList(1);
                arrayList.add(str3);
            } else {
                arrayList = null;
            }
            d(str, str2, arrayList, null, str4, j2);
        }
    }

    public void d(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, collection, map, str3, Long.valueOf(j2)}) == null) || StrategyProcess.getInstance().isIgnoreToSend(str)) {
            return;
        }
        if (!e() && StrategyProcess.getInstance().needDownloadStrategy()) {
            LogSender.getInstance().a();
        }
        f31715b.obtainMessage(10001, f.a(str, j2, str2, g.a(), c.d.a.a.a.a.a(), collection, map, str3)).sendToTarget();
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f31716a) {
                return false;
            }
            this.f31716a = true;
            f31715b.sendEmptyMessage(10003);
            LogSender.getInstance().a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31716a = false;
        f31715b = new a(this, c.a().b().getLooper());
    }
}
