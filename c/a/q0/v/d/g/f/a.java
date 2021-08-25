package c.a.q0.v.d.g.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25350a;

    /* renamed from: b  reason: collision with root package name */
    public int f25351b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f25352c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.v.d.g.c.a f25353d;

    /* renamed from: e  reason: collision with root package name */
    public View f25354e;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25352c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f25350a = k;
        this.f25351b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(c.a.q0.v.d.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f25353d = aVar;
        }
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f25354e = new View(this.f25352c.getPageActivity());
            this.f25354e.setLayoutParams(new FrameLayout.LayoutParams(this.f25350a, this.f25351b));
            this.f25354e.setBackgroundDrawable(new ColorDrawable(this.f25352c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
            return this.f25354e;
        }
        return (View) invokeV.objValue;
    }

    public abstract boolean f(c.a.q0.v.d.g.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int k = l.k(this.f25352c.getPageActivity());
            this.f25350a = k;
            this.f25351b = (int) ((k * 9.0d) / 16.0d);
            View view = this.f25354e;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = this.f25350a;
                layoutParams.height = this.f25351b;
                this.f25354e.setLayoutParams(layoutParams);
            }
        }
    }

    public abstract void i(int i2);

    public abstract void j();

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public abstract void m();

    public abstract void n();
}
