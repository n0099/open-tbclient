package c.a.q0.a1.i;

import android.app.Activity;
import c.a.q0.a1.g.h;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h.c f12075e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f12076f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView f12077g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f12078h;

    public h(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdRecyclerView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12076f = tbPageContext;
        this.f12077g = bdRecyclerView;
        this.f12075e = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.f12078h = pbListView;
        pbListView.b();
        this.f12078h.p(R.color.transparent);
        this.f12078h.t(this.f12075e.a);
        this.f12078h.M(this.f12075e.f12049b);
        this.f12078h.y();
        this.f12078h.H(R.dimen.tbfontsize33);
        this.f12078h.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f12078h.B(R.color.CAM_X0110);
        this.f12078h.s();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f12076f.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // c.a.q0.a1.i.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12075e.f12054g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // c.a.q0.a1.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12077g.setNextPage(this.f12078h);
            this.f12078h.R();
            this.f12078h.D(this.f12075e.f12050c);
            this.f12078h.C(null);
        }
    }

    @Override // c.a.q0.a1.i.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12077g.setNextPage(this.f12078h);
            this.f12078h.f();
            this.f12078h.D(this.f12075e.f12052e);
            this.f12078h.C(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12077g.setNextPage(this.f12078h);
            this.f12078h.f();
            this.f12078h.D(this.f12075e.f12051d);
            this.f12078h.C(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12077g.setNextPage(this.f12078h);
            this.f12078h.f();
            this.f12078h.D(this.f12075e.f12053f);
            this.f12078h.C(this.f12075e.f12055h);
        }
    }

    @Override // c.a.q0.a1.i.f
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12078h.d(i2);
        }
    }
}
