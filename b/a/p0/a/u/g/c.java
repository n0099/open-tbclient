package b.a.p0.a.u.g;

import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8954b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f8955c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f8956a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1515262032, "Lb/a/p0/a/u/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1515262032, "Lb/a/p0/a/u/g/c;");
                return;
            }
        }
        f8954b = k.f6863a;
    }

    public c() {
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
        ArrayList arrayList = new ArrayList();
        this.f8956a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f8955c == null) {
                synchronized (c.class) {
                    if (f8955c == null) {
                        f8955c = new c();
                    }
                }
            }
            return f8955c;
        }
        return (c) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.g.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (f8954b) {
                String str2 = "markStart: " + str;
            }
            for (int i2 = 0; i2 < this.f8956a.size(); i2++) {
                this.f8956a.get(i2).a(str);
            }
        }
    }

    @Override // b.a.p0.a.u.g.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (f8954b) {
                String str2 = "markEnd: " + str;
            }
            for (int i2 = 0; i2 < this.f8956a.size(); i2++) {
                this.f8956a.get(i2).b(str);
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                boolean z = f8954b;
                if (f8955c == null) {
                    return;
                }
                f8955c = null;
            }
        }
    }
}
