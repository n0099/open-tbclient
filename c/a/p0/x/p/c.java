package c.a.p0.x.p;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.l.d.a f15106a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.l.d.a f15107b;

    /* renamed from: c  reason: collision with root package name */
    public int f15108c;

    /* renamed from: d  reason: collision with root package name */
    public int f15109d;

    public c() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15109d : invokeV.intValue;
    }

    public abstract String b(int i2);

    public abstract int c();

    public c.a.e.l.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15106a : (c.a.e.l.d.a) invokeV.objValue;
    }

    public c.a.e.l.d.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15107b : (c.a.e.l.d.a) invokeV.objValue;
    }

    public abstract String f();

    public abstract String g();

    public abstract EmotionGroupType h();

    public abstract int i();

    public abstract boolean j();

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15108c : invokeV.intValue;
    }

    public abstract int l();

    public abstract boolean m(String str);

    public abstract c.a.e.l.d.a n(String str);

    public abstract c.a.e.l.d.a o(String str);

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f15109d = i2;
        }
    }

    public void q(c.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (aVar != null) {
                aVar.p();
            }
            this.f15106a = aVar;
        }
    }

    public void r(c.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            if (aVar != null) {
                aVar.p();
            }
            this.f15107b = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f15108c = i2;
        }
    }
}
