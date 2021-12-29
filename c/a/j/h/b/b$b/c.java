package c.a.j.h.b.b$b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c implements j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final b f3962e;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f3963b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d> f3964c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f3965d;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;

        /* renamed from: b  reason: collision with root package name */
        public List<byte[]> f3966b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f3967c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f3968d;

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
                    return;
                }
            }
            this.f3966b = new LinkedList();
            this.f3967c = new LinkedList();
        }

        public final a a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                this.f3967c.add(dVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                this.a = eVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                List<byte[]> list = this.f3966b;
                byte[] c2 = c.a.j.h.d.i.c(bArr);
                Intrinsics.checkExpressionValueIsNotNull(c2, "StringUtils.base64Encode(cipherSuite)");
                list.add(c2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this.a, this.f3966b, this.f3967c, c.a.j.h.d.i.c(this.f3968d)) : (c) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @JvmStatic
        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (a) invokeV.objValue;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(738459974, "Lc/a/j/h/b/b$b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(738459974, "Lc/a/j/h/b/b$b/c;");
                return;
            }
        }
        f3962e = new b(null);
    }

    public c(e eVar, List<byte[]> list, List<d> list2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, list, list2, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.f3963b = list;
        this.f3964c = list2;
        this.f3965d = bArr;
    }

    @JvmStatic
    public static final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3962e.a() : (a) invokeV.objValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] b2 = c.a.j.h.d.i.b(b());
            Intrinsics.checkExpressionValueIsNotNull(b2, "StringUtils.str2Byte(toJsonStr())");
            return b2;
        }
        return (byte[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String jSONObject = c().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.j.h.b.b$b.j
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            e eVar = this.a;
            jSONObject.putOpt("Random", eVar != null ? eVar.c() : null);
            jSONObject.putOpt("CipherSuites", g.a.b(this.f3963b));
            jSONObject.putOpt("Extensions", g.a.a(this.f3964c));
            jSONObject.putOpt("SKR", c.a.j.h.d.i.a(this.f3965d));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.f3963b, cVar.f3963b) && Intrinsics.areEqual(this.f3964c, cVar.f3964c) && Intrinsics.areEqual(this.f3965d, cVar.f3965d);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.a;
            int hashCode = (eVar != null ? eVar.hashCode() : 0) * 31;
            List<byte[]> list = this.f3963b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<d> list2 = this.f3964c;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            byte[] bArr = this.f3965d;
            return hashCode3 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ClientHello(random=" + this.a + ", cipherSuites=" + this.f3963b + ", extensions=" + this.f3964c + ", SKRBytes=" + Arrays.toString(this.f3965d) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
