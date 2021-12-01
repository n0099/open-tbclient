package c.a.r0.a0.f.g.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f14160b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f14161c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a0.f.g.c.a f14162d;

    /* renamed from: e  reason: collision with root package name */
    public View f14163e;

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
        this.f14161c = tbPageContext;
        int k2 = l.k(tbPageContext.getPageActivity());
        this.a = k2;
        this.f14160b = (int) ((k2 * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(c.a.r0.a0.f.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f14162d = aVar;
        }
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f14163e = new View(this.f14161c.getPageActivity());
            this.f14163e.setLayoutParams(new FrameLayout.LayoutParams(this.a, this.f14160b));
            this.f14163e.setBackgroundDrawable(new ColorDrawable(this.f14161c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
            return this.f14163e;
        }
        return (View) invokeV.objValue;
    }

    public abstract boolean f(c.a.r0.a0.f.g.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int k2 = l.k(this.f14161c.getPageActivity());
            this.a = k2;
            this.f14160b = (int) ((k2 * 9.0d) / 16.0d);
            View view = this.f14163e;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = this.a;
                layoutParams.height = this.f14160b;
                this.f14163e.setLayoutParams(layoutParams);
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
