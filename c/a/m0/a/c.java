package c.a.m0.a;

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
        public Map<String, String> f4366b;

        /* renamed from: c  reason: collision with root package name */
        public int f4367c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4368d;

        /* renamed from: e  reason: collision with root package name */
        public int f4369e;

        /* renamed from: f  reason: collision with root package name */
        public int f4370f;

        /* renamed from: g  reason: collision with root package name */
        public int f4371g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4372h;

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
            this.f4366b = new HashMap();
            this.f4367c = 3;
            this.f4368d = false;
            this.f4369e = 640;
            this.f4370f = 480;
            this.f4371g = 1;
            this.f4372h = false;
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
                this.f4370f = i2;
                this.f4372h = true;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public final b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f4369e = i2;
                this.f4372h = true;
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
        int unused2 = bVar.f4367c;
        int unused3 = bVar.f4369e;
        int unused4 = bVar.f4370f;
        boolean unused5 = bVar.f4372h;
        boolean unused6 = bVar.f4368d;
        int unused7 = bVar.f4371g;
        a(bVar.f4366b);
    }
}
