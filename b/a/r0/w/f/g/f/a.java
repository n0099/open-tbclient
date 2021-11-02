package b.a.r0.w.f.g.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.e.e.p.l;
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

    /* renamed from: a  reason: collision with root package name */
    public int f24861a;

    /* renamed from: b  reason: collision with root package name */
    public int f24862b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f24863c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.w.f.g.c.a f24864d;

    /* renamed from: e  reason: collision with root package name */
    public View f24865e;

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
        this.f24863c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f24861a = k;
        this.f24862b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(b.a.r0.w.f.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f24864d = aVar;
        }
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f24865e = new View(this.f24863c.getPageActivity());
            this.f24865e.setLayoutParams(new FrameLayout.LayoutParams(this.f24861a, this.f24862b));
            this.f24865e.setBackgroundDrawable(new ColorDrawable(this.f24863c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
            return this.f24865e;
        }
        return (View) invokeV.objValue;
    }

    public abstract boolean f(b.a.r0.w.f.g.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int k = l.k(this.f24863c.getPageActivity());
            this.f24861a = k;
            this.f24862b = (int) ((k * 9.0d) / 16.0d);
            View view = this.f24865e;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = this.f24861a;
                layoutParams.height = this.f24862b;
                this.f24865e.setLayoutParams(layoutParams);
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
