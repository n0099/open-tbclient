package c.a.r0.a.h0.o.j.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecordType a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6960b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6961c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f6962d;

    /* renamed from: c.a.r0.a.h0.o.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0392a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RecordType a;

        /* renamed from: b  reason: collision with root package name */
        public String f6963b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6964c;

        /* renamed from: d  reason: collision with root package name */
        public Object f6965d;

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
                }
            }
        }

        public a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (a) invokeV.objValue;
        }

        public b f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f6963b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f6964c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b h(RecordType recordType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, recordType)) == null) {
                this.a = recordType;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public /* synthetic */ a(b bVar, C0392a c0392a) {
        this(bVar);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    public a(b bVar) {
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
        this.a = bVar.a;
        this.f6960b = bVar.f6963b;
        this.f6961c = bVar.f6964c;
        this.f6962d = bVar.f6965d;
    }
}
