package c.a.b0.l0.o.c;

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
    public c.a.b0.l0.o.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.b0.l0.o.d.a f1833b;

    public a(c.a.b0.l0.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.f();
        this.f1833b = aVar;
    }

    public a<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f1833b.d(z);
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

    public a<T> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f1833b.m(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a<T> d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (i2 != -1) {
                try {
                    this.a.w(i2);
                } catch (Exception e2) {
                    c.a.b0.i.a.h("BubbleBuilder", "", e2);
                    this.a.w(-1);
                    return this;
                }
            }
            if (i3 != -1) {
                try {
                    this.a.x(i3);
                } catch (Exception e3) {
                    c.a.b0.i.a.h("BubbleBuilder", "", e3);
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
            this.f1833b.e().f1830d = false;
            this.f1833b.e().f1831e = bubblePosition;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a<T> f(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f1833b.n(bVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a<T> g(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            this.f1833b.e().q(f2);
            return this;
        }
        return (a) invokeF.objValue;
    }
}
