package c.a.q0.b2;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.f0.g;
import c.a.p0.s.s.a;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f15958a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f15959b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f15960c;

    /* renamed from: d  reason: collision with root package name */
    public View f15961d;

    /* renamed from: e  reason: collision with root package name */
    public g f15962e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15963f;

    /* renamed from: g  reason: collision with root package name */
    public e f15964g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f15965h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f15966i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.s.a f15967j;
    public a.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f15968e;

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
            this.f15968e = fVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f15968e.f15959b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f15968e.f15959b.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (navigationBarShadowView = this.f15968e.f15959b) != null && i2 == 1) {
                navigationBarShadowView.show();
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.q0.b2.g.a f15969e;

        public c(c.a.q0.b2.g.a aVar) {
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
            this.f15969e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.q0.b2.g.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f15969e) == null) {
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
        this.f15958a = null;
        this.f15960c = null;
        this.f15961d = null;
        this.f15963f = null;
        this.f15964g = null;
        this.f15965h = null;
        this.f15966i = null;
        this.f15967j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.f15958a = threadFragment.getBaseFragmentActivity();
        this.f15959b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f15966i = (ProgressBar) view.findViewById(R.id.progress);
        this.f15965h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f15963f = NoDataViewFactory.a(this.f15958a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f15958a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f15964g = eVar;
        eVar.notifyDataSetChanged();
        this.f15962e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f15960c = bdListView;
        bdListView.setPullRefresh(this.f15962e);
        this.f15962e.a(threadFragment);
        this.f15961d = new TextView(this.f15958a.getActivity());
        this.f15961d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f15958a.getActivity(), R.dimen.ds88)));
        this.f15960c.addHeaderView(this.f15961d, 0);
        this.f15960c.setAdapter((ListAdapter) this.f15964g);
        this.f15960c.setOnSrollToBottomListener(threadFragment);
        this.f15960c.setOnItemClickListener(threadFragment);
        this.f15960c.setOnScrollListener(this.n);
        this.f15964g.k(threadFragment);
        this.f15964g.r(threadFragment);
        this.f15964g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f15964g.l(z);
            this.f15964g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f15961d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdListView = this.f15960c) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void d(boolean z, String str, c.a.q0.b2.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.f15958a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
                if (aVar != null && aVar.n() != null) {
                    this.f15964g.j(aVar.n());
                    if (aVar.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(aVar);
                        } else {
                            c.a.e.e.m.e.a().removeCallbacks(this.l);
                        }
                        c.a.e.e.m.e.a().postDelayed(this.l, 600L);
                    }
                } else {
                    this.f15966i.setVisibility(8);
                    return;
                }
            } else {
                this.f15958a.showToast(str);
            }
            this.f15964g.m(false);
            this.f15966i.setVisibility(8);
        }
    }

    public void e(String str, c.a.q0.b2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) {
            this.f15964g.p(true);
            if (str != null) {
                this.f15958a.showToast(str);
            }
            if (aVar != null) {
                if (aVar.p() == 0 && !z) {
                    aVar.m();
                }
                if (aVar.p() < 20) {
                    this.f15964g.n(false);
                    this.f15964g.m(true);
                } else {
                    this.f15964g.n(true);
                    this.f15964g.m(true);
                }
                this.f15964g.j(aVar.n());
                p(aVar, z);
            }
            this.f15964g.p(false);
            this.f15964g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.f15958a.closeLoadingDialog();
            if (str != null) {
                this.f15958a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.f15964g.notifyDataSetChanged();
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
            this.f15966i.setVisibility(8);
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15958a.getPageContext().getPageActivity()).createNormalConfig(c.a.e.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f15964g.notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15965h, R.color.CAM_X0201);
            g gVar = this.f15962e;
            if (gVar != null) {
                gVar.D(i2);
            }
            m();
            NoDataView noDataView = this.f15963f;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f15958a.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f15963f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.p0.s.s.a aVar = this.f15967j;
            if (aVar != null) {
                aVar.dismiss();
                this.f15967j = null;
            }
            ProgressBar progressBar = this.f15966i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.l);
            }
            e eVar = this.f15964g;
            if (eVar != null) {
                eVar.i();
            }
        }
    }

    public void p(c.a.q0.b2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, aVar, z) == null) {
            if (aVar == null) {
                s();
            } else if (aVar.m() > 0) {
                this.f15963f.setVisibility(8);
                this.f15960c.removeHeaderView(this.f15963f);
                this.f15964g.notifyDataSetChanged();
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
            this.f15963f.onActivityStart(this.f15958a.getPageContext());
            this.f15960c.removeHeaderView(this.f15963f);
            this.f15960c.addHeaderView(this.f15963f);
            this.f15963f.setVisibility(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f15967j == null) {
                c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f15958a.getPageContext().getPageActivity());
                this.f15967j = aVar;
                aVar.setTitle(this.f15958a.getPageContext().getString(R.string.sync_mark_fail));
                this.f15967j.setMessage(this.f15958a.getPageContext().getString(R.string.neterror));
                if (this.k != null) {
                    this.f15967j.setPositiveButton(this.f15958a.getPageContext().getString(R.string.retry_rightnow), this.k);
                }
                this.f15967j.setNegativeButton(this.f15958a.getPageContext().getString(R.string.confirm), new b(this));
                this.f15967j.create(this.f15958a.getPageContext());
                this.f15967j.setCanceledOnTouchOutside(true);
            }
            this.f15967j.show();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f15966i.setVisibility(0);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 0) {
                this.f15960c.startPullRefresh();
                return;
            }
            this.f15964g.p(true);
            this.f15964g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.f15964g.j(arrayList);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f15963f.isShown()) {
            this.f15963f.onActivityStart(this.f15958a.getPageContext());
        }
    }
}
