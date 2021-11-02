package b.a.r0.i3.j;

import android.view.View;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.g0.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h extends b.a.e.a.d<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f18162a;

    /* renamed from: b  reason: collision with root package name */
    public View f18163b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f18164c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f18165d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.g0.g f18166e;

    /* renamed from: f  reason: collision with root package name */
    public e f18167f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f18168g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view, onKeyListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], (View.OnKeyListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18166e.U(bdUniqueId);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f18165d.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18164c.completePullRefreshPostDelayed(0L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18165d.setVisibility(0);
        }
    }

    public void f(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            d();
            if (z || str == null) {
                return;
            }
            this.f18162a.showToast(str, true);
        }
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18163b : (View) invokeV.objValue;
    }

    public void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f18168g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f18164c.removeHeaderView(this.f18168g);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18165d.setVisibility(8);
        }
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        try {
            if (fVar.g()) {
                return;
            }
            this.f18167f.i(fVar);
            this.f18167f.notifyDataSetChanged();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void k(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f18165d.removeNetworkChangeListener(bVar);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f18166e.a(gVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f18168g == null) {
                this.f18168g = NoDataViewFactory.a(this.f18162a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
            }
            this.f18168g.setTextOption(NoDataViewFactory.e.a(i2));
            this.f18168g.onChangeSkinType(this.f18162a, TbadkCoreApplication.getInst().getSkinType());
            this.f18168g.setVisibility(0);
            this.f18164c.removeHeaderView(this.f18168g);
            this.f18164c.addHeaderView(this.f18168g);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f18162a.getLayoutMode().k(i2 == 1);
            this.f18162a.getLayoutMode().j(this.f18163b);
            this.f18167f.h(i2);
            this.f18166e.C(i2);
            this.f18165d.onChangeSkinType(this.mContext, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, onKeyListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18162a = null;
        this.f18164c = null;
        this.f18166e = null;
        this.f18167f = null;
        this.f18162a = tbPageContext;
        this.f18163b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f18164c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f18162a.getOrignalPage() instanceof SquareActivity) {
            this.f18164c.setOnItemClickListener((SquareActivity) this.f18162a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f18167f = eVar;
        this.f18164c.setAdapter((ListAdapter) eVar);
        b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(tbPageContext);
        this.f18166e = gVar;
        this.f18164c.setPullRefresh(gVar);
        this.f18165d = (NoNetworkView) this.f18163b.findViewById(R.id.view_no_network);
    }
}
