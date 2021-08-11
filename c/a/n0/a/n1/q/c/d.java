package c.a.n0.a.n1.q.c;

import c.a.n0.a.a2.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements c.a.n0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Function1 f7369a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7370b;

        public a(Function1 function1, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function1, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7369a = function1;
            this.f7370b = str;
        }

        @Override // c.a.n0.a.n1.q.b.a
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONArray c2 = d.c();
                if (c2 != null && c2.length() != 0) {
                    int length = c2.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (Intrinsics.areEqual(this.f7370b, c2.get(i2))) {
                            Function1 function1 = this.f7369a;
                            if (function1 != null) {
                                Unit unit = (Unit) function1.invoke(Boolean.TRUE);
                                return;
                            }
                            return;
                        }
                    }
                    Function1 function12 = this.f7369a;
                    if (function12 != null) {
                        Unit unit2 = (Unit) function12.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                Function1 function13 = this.f7369a;
                if (function13 != null) {
                    Unit unit3 = (Unit) function13.invoke(Boolean.TRUE);
                }
            }
        }
    }

    public static final void b(String str, Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, function1) == null) {
            c.a.n0.a.n1.q.a.g().z(new a(function1, str));
        }
    }

    public static final JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            e Q = e.Q();
            if (Q != null) {
                String q = Q.T().q("note_data_pay_check_list", "");
                if (q == null || StringsKt__StringsJVMKt.isBlank(q)) {
                    return null;
                }
                return new JSONObject(q).optJSONArray("pay_keys");
            }
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }
}
