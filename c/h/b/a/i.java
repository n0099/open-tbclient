package c.h.b.a;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f32438f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f32439d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f32440e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2023317484, "Lc/h/b/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2023317484, "Lc/h/b/a/i;");
                return;
            }
        }
        f32438f = new LinkedHashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Thread thread, long j2) {
        this(thread, 100, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thread, Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Thread) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // c.h.b.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : this.f32440e.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append(Part.CRLF);
            }
            synchronized (f32438f) {
                if (f32438f.size() == this.f32439d && this.f32439d > 0) {
                    f32438f.remove(f32438f.keySet().iterator().next());
                }
                f32438f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
            }
        }
    }

    public ArrayList<String> e(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            synchronized (f32438f) {
                for (Long l : f32438f.keySet()) {
                    if (j2 < l.longValue() && l.longValue() < j3) {
                        arrayList.add(c.h.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f32438f.get(l));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Thread thread, int i2, long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thread, Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32439d = 100;
        this.f32440e = thread;
        this.f32439d = i2;
    }
}
