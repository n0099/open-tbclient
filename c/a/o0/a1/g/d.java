package c.a.o0.a1.g;

import android.view.View;
import android.view.ViewGroup;
import c.a.o0.a1.g.h;
import c.a.o0.a1.g.h.e;
import c.a.o0.f0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class d<T extends c.a.o0.f0.a, D extends h.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public ViewType f9804b;

    /* renamed from: c  reason: collision with root package name */
    public T f9805c;

    /* renamed from: d  reason: collision with root package name */
    public D f9806d;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
    }

    public final void a(View view) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (t = this.f9805c) == null) {
            return;
        }
        t.attachView(view);
    }

    public final void b(View view) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (t = this.f9805c) == null) {
            return;
        }
        t.dettachView(view);
    }

    public final View c(ViewType viewType, ViewGroup viewGroup, D d2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, viewGroup, d2)) == null) {
            this.f9804b = viewType;
            this.f9806d = d2;
            if (this.f9805c == null) {
                this.f9805c = f(viewType, viewGroup);
            }
            View view = this.f9805c.getView();
            if (viewGroup.indexOfChild(view) < 0) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                a(viewGroup);
            } else if (viewGroup.indexOfChild(view) != viewGroup.getChildCount() - 1) {
                view.bringToFront();
            }
            d(viewType, this.f9805c, d2);
            return view;
        }
        return (View) invokeLLL.objValue;
    }

    public abstract void d(ViewType viewType, T t, D d2);

    public void e(int i) {
        ViewType viewType;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.a != i && (viewType = this.f9804b) != null && (t = this.f9805c) != null) {
                d(viewType, t, this.f9806d);
            }
            this.a = i;
        }
    }

    public abstract T f(ViewType viewType, ViewGroup viewGroup);
}
