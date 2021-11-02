package b.a.r0.d2;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.g0.g;
import b.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.ThreadFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f15654a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f15655b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f15656c;

    /* renamed from: d  reason: collision with root package name */
    public View f15657d;

    /* renamed from: e  reason: collision with root package name */
    public g f15658e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15659f;

    /* renamed from: g  reason: collision with root package name */
    public e f15660g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f15661h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f15662i;
    public b.a.q0.s.s.a j;
    public a.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    /* loaded from: classes4.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15663e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15663e = fVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f15663e.f15655b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f15663e.f15655b.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (navigationBarShadowView = this.f15663e.f15655b) != null && i2 == 1) {
                navigationBarShadowView.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.d2.g.a f15664e;

        public c(b.a.r0.d2.g.a aVar) {
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
            this.f15664e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.r0.d2.g.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f15664e) == null) {
                return;
            }
            aVar.w(Boolean.TRUE);
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15654a = null;
        this.f15656c = null;
        this.f15657d = null;
        this.f15659f = null;
        this.f15660g = null;
        this.f15661h = null;
        this.f15662i = null;
        this.j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.f15654a = threadFragment.getBaseFragmentActivity();
        this.f15655b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f15662i = (ProgressBar) view.findViewById(R.id.progress);
        this.f15661h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f15659f = NoDataViewFactory.a(this.f15654a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f15654a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f15660g = eVar;
        eVar.notifyDataSetChanged();
        this.f15658e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f15656c = bdListView;
        bdListView.setPullRefresh(this.f15658e);
        this.f15658e.a(threadFragment);
        this.f15657d = new TextView(this.f15654a.getActivity());
        this.f15657d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f15654a.getActivity(), R.dimen.ds88)));
        this.f15656c.addHeaderView(this.f15657d, 0);
        this.f15656c.setAdapter((ListAdapter) this.f15660g);
        this.f15656c.setOnSrollToBottomListener(threadFragment);
        this.f15656c.setOnItemClickListener(threadFragment);
        this.f15656c.setOnScrollListener(this.n);
        this.f15660g.k(threadFragment);
        this.f15660g.r(threadFragment);
        this.f15660g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f15660g.l(z);
            this.f15660g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f15657d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdListView = this.f15656c) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void d(boolean z, String str, b.a.r0.d2.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.f15654a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
                if (aVar != null && aVar.n() != null) {
                    this.f15660g.j(aVar.n());
                    if (aVar.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(aVar);
                        } else {
                            b.a.e.e.m.e.a().removeCallbacks(this.l);
                        }
                        b.a.e.e.m.e.a().postDelayed(this.l, 600L);
                    }
                } else {
                    this.f15662i.setVisibility(8);
                    return;
                }
            } else {
                this.f15654a.showToast(str);
            }
            this.f15660g.m(false);
            this.f15662i.setVisibility(8);
        }
    }

    public void e(String str, b.a.r0.d2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) {
            this.f15660g.p(true);
            if (str != null) {
                this.f15654a.showToast(str);
            }
            if (aVar != null) {
                if (aVar.p() == 0 && !z) {
                    aVar.m();
                }
                if (aVar.p() < 20) {
                    this.f15660g.n(false);
                    this.f15660g.m(true);
                } else {
                    this.f15660g.n(true);
                    this.f15660g.m(true);
                }
                this.f15660g.j(aVar.n());
                p(aVar, z);
            }
            this.f15660g.p(false);
            this.f15660g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.f15654a.closeLoadingDialog();
            if (str != null) {
                this.f15654a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.f15660g.notifyDataSetChanged();
        }
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return R.id.share_lv_markitem_delete;
            }
            return R.id.home_lv_markitem_delete;
        }
        return invokeZ.intValue;
    }

    public int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return R.id.share_mark_item_state;
            }
            return R.id.markitem_state;
        }
        return invokeZ.intValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return R.id.share_lv_markitem_userinfo;
            }
            return R.id.home_lv_markitem_userinfo;
        }
        return invokeZ.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15662i.setVisibility(8);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void l(MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, markData) == null) || markData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15654a.getPageContext().getPageActivity()).createNormalConfig(b.a.e.e.m.b.g(markData.getUesrId(), 0L), false, markData.isGod())));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f15660g.notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15661h, R.color.CAM_X0201);
            g gVar = this.f15658e;
            if (gVar != null) {
                gVar.C(i2);
            }
            m();
            NoDataView noDataView = this.f15659f;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f15654a.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f15659f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.q0.s.s.a aVar = this.j;
            if (aVar != null) {
                aVar.dismiss();
                this.j = null;
            }
            ProgressBar progressBar = this.f15662i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.l);
            }
            e eVar = this.f15660g;
            if (eVar != null) {
                eVar.i();
            }
        }
    }

    public void p(b.a.r0.d2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, aVar, z) == null) {
            if (aVar == null) {
                s();
            } else if (aVar.m() > 0) {
                this.f15659f.setVisibility(8);
                this.f15656c.removeHeaderView(this.f15659f);
                this.f15660g.notifyDataSetChanged();
            } else if (aVar.m() != 0 || z) {
            } else {
                s();
            }
        }
    }

    public void q(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = z;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f15659f.onActivityStart(this.f15654a.getPageContext());
            this.f15656c.removeHeaderView(this.f15659f);
            this.f15656c.addHeaderView(this.f15659f);
            this.f15659f.setVisibility(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f15654a.getPageContext().getPageActivity());
                this.j = aVar;
                aVar.setTitle(this.f15654a.getPageContext().getString(R.string.sync_mark_fail));
                this.j.setMessage(this.f15654a.getPageContext().getString(R.string.neterror));
                if (this.k != null) {
                    this.j.setPositiveButton(this.f15654a.getPageContext().getString(R.string.retry_rightnow), this.k);
                }
                this.j.setNegativeButton(this.f15654a.getPageContext().getString(R.string.confirm), new b(this));
                this.j.create(this.f15654a.getPageContext());
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f15662i.setVisibility(0);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 0) {
                this.f15656c.startPullRefresh();
                return;
            }
            this.f15660g.p(true);
            this.f15660g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.f15660g.j(arrayList);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f15659f.isShown()) {
            this.f15659f.onActivityStart(this.f15654a.getPageContext());
        }
    }
}
