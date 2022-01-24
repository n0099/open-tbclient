package c.a.t0.t3.e;

import android.view.View;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
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
/* loaded from: classes8.dex */
public class h extends c.a.d.a.d<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public View f23823b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f23824c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f23825d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.k0.g f23826e;

    /* renamed from: f  reason: collision with root package name */
    public e f23827f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f23828g;

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
        this.f23826e.V(bdUniqueId);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23825d.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23824c.completePullRefreshPostDelayed(0L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23825d.setVisibility(0);
        }
    }

    public void f(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            d();
            if (z || str == null) {
                return;
            }
            this.a.showToast(str, true);
        }
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23823b : (View) invokeV.objValue;
    }

    public void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f23828g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f23824c.removeHeaderView(this.f23828g);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23825d.setVisibility(8);
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
            this.f23827f.i(fVar);
            this.f23827f.notifyDataSetChanged();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void k(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f23825d.removeNetworkChangeListener(bVar);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f23826e.a(gVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f23828g == null) {
                this.f23828g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
            }
            this.f23828g.setTextOption(NoDataViewFactory.e.a(i2));
            this.f23828g.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.f23828g.setVisibility(0);
            this.f23824c.removeHeaderView(this.f23828g);
            this.f23824c.addHeaderView(this.f23828g);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f23823b);
            this.f23827f.h(i2);
            this.f23826e.C(i2);
            this.f23825d.onChangeSkinType(this.mContext, i2);
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f23824c = null;
        this.f23826e = null;
        this.f23827f = null;
        this.a = tbPageContext;
        this.f23823b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f23824c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.f23824c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f23827f = eVar;
        this.f23824c.setAdapter((ListAdapter) eVar);
        c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(tbPageContext);
        this.f23826e = gVar;
        this.f23824c.setPullRefresh(gVar);
        this.f23825d = (NoNetworkView) this.f23823b.findViewById(R.id.view_no_network);
    }
}
