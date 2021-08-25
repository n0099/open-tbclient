package c.a.p0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d0 extends a {
    public static /* synthetic */ Interceptable $ic;
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f12722c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f12723a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.b.e f12724b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1704683248, "Lc/a/p0/b/f/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1704683248, "Lc/a/p0/b/f/d0;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkExpressionValueIsNotNull(gen, "BdUniqueId.gen()");
        f12722c = gen;
    }

    public d0() {
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
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f12723a = arrayList;
        arrayList.add("12_7_video_draw");
        this.f12723a.add("12_7_video_draw_a");
        this.f12723a.add("12_7_video_draw_b");
        this.f12723a.add("12_7_video_draw_c");
    }

    @Override // c.a.p0.b.f.a
    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12723a : (ArrayList) invokeV.objValue;
    }

    @Override // c.a.p0.b.f.a
    public c.a.p0.b.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12724b : (c.a.p0.b.e) invokeV.objValue;
    }

    @Override // c.a.p0.b.f.a
    public BdUniqueId c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f12722c : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.p0.b.f.a
    public void f(c.a.p0.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f12724b = eVar;
        }
    }
}
