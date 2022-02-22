package c.a.t0.b1.i;

import android.app.Activity;
import c.a.t0.b1.g.h;
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
/* loaded from: classes6.dex */
public class h extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h.c f12658e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f12659f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView f12660g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f12661h;

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
        this.f12659f = tbPageContext;
        this.f12660g = bdRecyclerView;
        this.f12658e = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.f12661h = pbListView;
        pbListView.b();
        this.f12661h.p(R.color.transparent);
        this.f12661h.t(this.f12658e.a);
        this.f12661h.M(this.f12658e.f12632b);
        this.f12661h.y();
        this.f12661h.H(R.dimen.tbfontsize33);
        this.f12661h.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f12661h.B(R.color.CAM_X0110);
        this.f12661h.s();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f12659f.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // c.a.t0.b1.i.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12658e.f12637g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // c.a.t0.b1.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12660g.setNextPage(this.f12661h);
            this.f12661h.R();
            this.f12661h.D(this.f12658e.f12633c);
            this.f12661h.C(null);
        }
    }

    @Override // c.a.t0.b1.i.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12660g.setNextPage(this.f12661h);
            this.f12661h.f();
            this.f12661h.D(this.f12658e.f12635e);
            this.f12661h.C(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12660g.setNextPage(this.f12661h);
            this.f12661h.f();
            this.f12661h.D(this.f12658e.f12634d);
            this.f12661h.C(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12660g.setNextPage(this.f12661h);
            this.f12661h.f();
            this.f12661h.D(this.f12658e.f12636f);
            this.f12661h.C(this.f12658e.f12638h);
        }
    }

    @Override // c.a.t0.b1.i.f
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12661h.d(i2);
        }
    }
}
