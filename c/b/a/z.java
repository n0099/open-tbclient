package c.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.IDataObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z implements IDataObserver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<WeakReference<IDataObserver>> f31350a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868020620, "Lc/b/a/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868020620, "Lc/b/a/z;");
                return;
            }
        }
        f31350a = new ArrayList<>(4);
    }

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public synchronized void a(IDataObserver iDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iDataObserver) == null) {
            synchronized (this) {
                if (iDataObserver != null) {
                    f31350a.add(new WeakReference<>(iDataObserver));
                }
            }
        }
    }

    public synchronized void b(IDataObserver iDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iDataObserver) == null) {
            synchronized (this) {
                Iterator<WeakReference<IDataObserver>> it = f31350a.iterator();
                while (it.hasNext()) {
                    IDataObserver iDataObserver2 = it.next().get();
                    if (iDataObserver2 == null) {
                        it.remove();
                    } else if (iDataObserver2.equals(iDataObserver)) {
                        it.remove();
                    }
                }
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onIdLoaded(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            synchronized (this) {
                Iterator<WeakReference<IDataObserver>> it = f31350a.iterator();
                while (it.hasNext()) {
                    IDataObserver iDataObserver = it.next().get();
                    if (iDataObserver == null) {
                        it.remove();
                    } else {
                        iDataObserver.onIdLoaded(str, str2, str3);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, jSONObject) == null) {
            synchronized (this) {
                Iterator<WeakReference<IDataObserver>> it = f31350a.iterator();
                while (it.hasNext()) {
                    IDataObserver iDataObserver = it.next().get();
                    if (iDataObserver == null) {
                        it.remove();
                    } else {
                        iDataObserver.onRemoteAbConfigGet(z, jSONObject);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, jSONObject) == null) {
            synchronized (this) {
                Iterator<WeakReference<IDataObserver>> it = f31350a.iterator();
                while (it.hasNext()) {
                    IDataObserver iDataObserver = it.next().get();
                    if (iDataObserver == null) {
                        it.remove();
                    } else {
                        iDataObserver.onRemoteConfigGet(z, jSONObject);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public synchronized void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, str5, str6}) == null) {
            synchronized (this) {
                Iterator<WeakReference<IDataObserver>> it = f31350a.iterator();
                while (it.hasNext()) {
                    IDataObserver iDataObserver = it.next().get();
                    if (iDataObserver == null) {
                        it.remove();
                    } else {
                        iDataObserver.onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
                    }
                }
            }
        }
    }
}
