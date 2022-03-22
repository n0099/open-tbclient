package c.a.o0.a1.i;

import android.app.Activity;
import c.a.o0.a1.g.h;
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
    public h.c a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f9849b;

    /* renamed from: c  reason: collision with root package name */
    public BdRecyclerView f9850c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f9851d;

    public h(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdRecyclerView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9849b = tbPageContext;
        this.f9850c = bdRecyclerView;
        this.a = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.f9851d = pbListView;
        pbListView.b();
        this.f9851d.p(R.color.transparent);
        this.f9851d.t(this.a.a);
        this.f9851d.M(this.a.f9826b);
        this.f9851d.y();
        this.f9851d.H(R.dimen.tbfontsize33);
        this.f9851d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f9851d.B(R.color.CAM_X0110);
        this.f9851d.s();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f9849b.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // c.a.o0.a1.i.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.f9831g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // c.a.o0.a1.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f9850c.setNextPage(this.f9851d);
            this.f9851d.R();
            this.f9851d.D(this.a.f9827c);
            this.f9851d.C(null);
        }
    }

    @Override // c.a.o0.a1.i.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f9850c.setNextPage(this.f9851d);
            this.f9851d.f();
            this.f9851d.D(this.a.f9829e);
            this.f9851d.C(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f9850c.setNextPage(this.f9851d);
            this.f9851d.f();
            this.f9851d.D(this.a.f9828d);
            this.f9851d.C(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f9850c.setNextPage(this.f9851d);
            this.f9851d.f();
            this.f9851d.D(this.a.f9830f);
            this.f9851d.C(this.a.f9832h);
        }
    }

    @Override // c.a.o0.a1.i.f
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f9851d.d(i);
        }
    }
}
