package c.a.p0.a.r0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends DataOutputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final c.a.p0.a.r0.b<byte[], String> f7248e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.p0.a.r0.b<byte[], String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.r0.b
        @Nullable
        public byte[] call(@Nullable String str) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str == null) {
                    return null;
                }
                return str.getBytes();
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.r0.b<byte[], Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.r0.b
        @Nullable
        public byte[] call(@Nullable Boolean bool) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                if (bool == null || !bool.booleanValue()) {
                    return null;
                }
                return new byte[0];
            }
            return (byte[]) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(828242289, "Lc/a/p0/a/r0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(828242289, "Lc/a/p0/a/r0/d;");
                return;
            }
        }
        f7248e = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(OutputStream outputStream) throws IOException {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(Map<String, Boolean> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            e(map, new b(this));
        }
    }

    public void b(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            if (bArr == null) {
                writeInt(-1);
                return;
            }
            writeInt(bArr.length);
            if (bArr.length > 0) {
                write(bArr);
            }
        }
    }

    public <T> void c(@Nullable T t, @NonNull c.a.p0.a.r0.b<byte[], T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, bVar) == null) {
            try {
                b(bVar.call(t));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public <T> void d(@Nullable Collection<T> collection, c.a.p0.a.r0.b<byte[], T> bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, collection, bVar) == null) {
            if (collection == null) {
                writeInt(-1);
                return;
            }
            writeInt(collection.size());
            for (T t : collection) {
                try {
                    b(bVar.call(t));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public <T> void e(Map<String, T> map, c.a.p0.a.r0.b<byte[], T> bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, bVar) == null) {
            if (map == null) {
                writeInt(-1);
                return;
            }
            writeInt(map.size());
            g(map.keySet());
            d(map.values(), bVar);
        }
    }

    public void f(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                b(f7248e.call(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g(Collection<String> collection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            d(collection, f7248e);
        }
    }

    public void h(Map<String, String> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            e(map, f7248e);
        }
    }
}
