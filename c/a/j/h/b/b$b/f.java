package c.a.j.h.b.b$b;

import android.text.TextUtils;
import c.a.j.h.b.b$b.d;
import c.a.j.h.b.b$b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final a f4054f;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4055b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4056c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f4057d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f4058e;

    /* loaded from: classes.dex */
    public static final class a {
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

        @JvmStatic
        public final f a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str == null || TextUtils.isEmpty(str)) {
                    return null;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("get raw data:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    e.b bVar = e.f4051c;
                    String optString = jSONObject.optString("Random");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "dataObj.optString(\"Random\")");
                    e b2 = bVar.b(optString);
                    String optString2 = jSONObject.optString("CipherSuite");
                    int optInt = jSONObject.optInt("LifeTime");
                    String optString3 = jSONObject.optString("SKR");
                    LinkedList linkedList = new LinkedList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("Extensions");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            String item = optJSONArray.optString(i2);
                            d.b bVar2 = d.f4048c;
                            Intrinsics.checkExpressionValueIsNotNull(item, "item");
                            d b3 = bVar2.b(item);
                            if (b3 != null) {
                                linkedList.add(b3);
                            }
                        }
                    }
                    return new f(b2, c.a.j.h.d.i.b(optString2), optInt, c.a.j.h.d.i.b(optString3), linkedList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("can not parse server hello:" + e2.getMessage());
                    return null;
                }
            }
            return (f) invokeL.objValue;
        }

        @JvmStatic
        public final f b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? a(c.a.j.h.d.i.a(bArr)) : (f) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(738460067, "Lc/a/j/h/b/b$b/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(738460067, "Lc/a/j/h/b/b$b/f;");
                return;
            }
        }
        f4054f = new a(null);
    }

    public f(e eVar, byte[] bArr, int i2, byte[] bArr2, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, bArr, Integer.valueOf(i2), bArr2, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = eVar;
        this.f4055b = bArr;
        this.f4056c = i2;
        this.f4057d = bArr2;
        this.f4058e = list;
    }

    @JvmStatic
    public static final f a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? f4054f.b(bArr) : (f) invokeL.objValue;
    }

    public final List<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4058e : (List) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4056c : invokeV.intValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.j.h.d.i.d(this.f4055b) : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.j.h.d.i.d(this.f4057d) : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    if (Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(this.f4055b, fVar.f4055b)) {
                        if (!(this.f4056c == fVar.f4056c) || !Intrinsics.areEqual(this.f4057d, fVar.f4057d) || !Intrinsics.areEqual(this.f4058e, fVar.f4058e)) {
                        }
                    }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.a;
            int hashCode = (eVar != null ? eVar.hashCode() : 0) * 31;
            byte[] bArr = this.f4055b;
            int hashCode2 = (((hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + this.f4056c) * 31;
            byte[] bArr2 = this.f4057d;
            int hashCode3 = (hashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
            List<d> list = this.f4058e;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ServerHello(random=" + this.a + ", cipherSuiteBytes=" + Arrays.toString(this.f4055b) + ", lifeTime=" + this.f4056c + ", SKRBytes=" + Arrays.toString(this.f4057d) + ", extensions=" + this.f4058e + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
