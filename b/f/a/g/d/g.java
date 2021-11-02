package b.f.a.g.d;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.LogUtil;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f30709c = "g";

    /* renamed from: d  reason: collision with root package name */
    public static final HashSet<Class<?>> f30710d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashSet<Class<?>> f30711e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f30712a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30713b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1775635959, "Lb/f/a/g/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1775635959, "Lb/f/a/g/d/g;");
                return;
            }
        }
        f30710d = new HashSet<>();
        f30711e = new HashSet<>();
        f30710d.add(UnknownHostException.class);
        f30710d.add(SocketException.class);
        f30710d.add(ProtocolException.class);
        f30711e.add(SSLException.class);
        f30711e.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30712a = i2;
        this.f30713b = i3;
    }

    public boolean a(Exception exc, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, exc, i2)) == null) {
            boolean z = false;
            if (i2 <= this.f30712a && (b(f30710d, exc) || !b(f30711e, exc))) {
                z = true;
            }
            String str = f30709c;
            LogUtil.d(str, f30709c + " retryRequest is called ,retry flag is " + z);
            if (z) {
                SystemClock.sleep(this.f30713b);
            } else {
                exc.printStackTrace();
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public boolean b(HashSet<Class<?>> hashSet, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashSet, th)) == null) {
            Iterator<Class<?>> it = hashSet.iterator();
            while (it.hasNext()) {
                if (it.next().isInstance(th)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
