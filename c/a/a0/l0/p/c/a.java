package c.a.a0.l0.p.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a0.l0.p.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.l0.p.d.a f1437b;

    public a(c.a.a0.l0.p.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.f();
        this.f1437b = aVar;
    }

    public a<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f1437b.d(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a<T> b(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, viewGroup)) == null) {
            this.a.s(view, viewGroup);
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public a<T> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.f1437b.m(i);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a<T> d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (i != -1) {
                try {
                    this.a.w(i);
                } catch (Exception e2) {
                    c.a.a0.i.a.h("BubbleBuilder", "", e2);
                    this.a.w(-1);
                    return this;
                }
            }
            if (i2 != -1) {
                try {
                    this.a.x(i2);
                } catch (Exception e3) {
                    c.a.a0.i.a.h("BubbleBuilder", "", e3);
                    this.a.x(-1);
                }
            }
            return this;
        }
        return (a) invokeII.objValue;
    }

    public a<T> e(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bubblePosition)) == null) {
            this.f1437b.e().f1434d = false;
            this.f1437b.e().f1435e = bubblePosition;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a<T> f(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f1437b.n(bVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a<T> g(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            this.f1437b.e().q(f2);
            return this;
        }
        return (a) invokeF.objValue;
    }
}
