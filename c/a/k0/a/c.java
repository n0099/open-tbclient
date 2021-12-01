package c.a.k0.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f3599b;

        /* renamed from: c  reason: collision with root package name */
        public int f3600c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3601d;

        /* renamed from: e  reason: collision with root package name */
        public int f3602e;

        /* renamed from: f  reason: collision with root package name */
        public int f3603f;

        /* renamed from: g  reason: collision with root package name */
        public int f3604g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f3605h;

        public b() {
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
            this.f3599b = new HashMap();
            this.f3600c = 3;
            this.f3601d = false;
            this.f3602e = 640;
            this.f3603f = 480;
            this.f3604g = 1;
            this.f3605h = false;
        }

        public final c i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public final b j(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f3603f = i2;
                this.f3605h = true;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f3602e = i2;
                this.f3605h = true;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
        }
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String unused = bVar.a;
        int unused2 = bVar.f3600c;
        int unused3 = bVar.f3602e;
        int unused4 = bVar.f3603f;
        boolean unused5 = bVar.f3605h;
        boolean unused6 = bVar.f3601d;
        int unused7 = bVar.f3604g;
        a(bVar.f3599b);
    }
}
