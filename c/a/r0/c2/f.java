package c.a.r0.c2;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.g;
import c.a.q0.s.s.a;
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
    public BaseFragmentActivity f16480a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f16481b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f16482c;

    /* renamed from: d  reason: collision with root package name */
    public View f16483d;

    /* renamed from: e  reason: collision with root package name */
    public g f16484e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f16485f;

    /* renamed from: g  reason: collision with root package name */
    public e f16486g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f16487h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f16488i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.a f16489j;
    public a.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f16490e;

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
            this.f16490e = fVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f16490e.f16481b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f16490e.f16481b.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (navigationBarShadowView = this.f16490e.f16481b) != null && i2 == 1) {
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
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
        public c.a.r0.c2.g.a f16491e;

        public c(c.a.r0.c2.g.a aVar) {
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
            this.f16491e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.r0.c2.g.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f16491e) == null) {
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
        this.f16480a = null;
        this.f16482c = null;
        this.f16483d = null;
        this.f16485f = null;
        this.f16486g = null;
        this.f16487h = null;
        this.f16488i = null;
        this.f16489j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.f16480a = threadFragment.getBaseFragmentActivity();
        this.f16481b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f16488i = (ProgressBar) view.findViewById(R.id.progress);
        this.f16487h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f16485f = NoDataViewFactory.a(this.f16480a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f16480a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f16486g = eVar;
        eVar.notifyDataSetChanged();
        this.f16484e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f16482c = bdListView;
        bdListView.setPullRefresh(this.f16484e);
        this.f16484e.a(threadFragment);
        this.f16483d = new TextView(this.f16480a.getActivity());
        this.f16483d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f16480a.getActivity(), R.dimen.ds88)));
        this.f16482c.addHeaderView(this.f16483d, 0);
        this.f16482c.setAdapter((ListAdapter) this.f16486g);
        this.f16482c.setOnSrollToBottomListener(threadFragment);
        this.f16482c.setOnItemClickListener(threadFragment);
        this.f16482c.setOnScrollListener(this.n);
        this.f16486g.k(threadFragment);
        this.f16486g.r(threadFragment);
        this.f16486g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f16486g.l(z);
            this.f16486g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f16483d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdListView = this.f16482c) == null) {
            return;
        }
        bdListView.completePullRefreshPostDelayed(0L);
    }

    public void d(boolean z, String str, c.a.r0.c2.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.f16480a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
                if (aVar != null && aVar.n() != null) {
                    this.f16486g.j(aVar.n());
                    if (aVar.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(aVar);
                        } else {
                            c.a.e.e.m.e.a().removeCallbacks(this.l);
                        }
                        c.a.e.e.m.e.a().postDelayed(this.l, 600L);
                    }
                } else {
                    this.f16488i.setVisibility(8);
                    return;
                }
            } else {
                this.f16480a.showToast(str);
            }
            this.f16486g.m(false);
            this.f16488i.setVisibility(8);
        }
    }

    public void e(String str, c.a.r0.c2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) {
            this.f16486g.p(true);
            if (str != null) {
                this.f16480a.showToast(str);
            }
            if (aVar != null) {
                if (aVar.p() == 0 && !z) {
                    aVar.m();
                }
                if (aVar.p() < 20) {
                    this.f16486g.n(false);
                    this.f16486g.m(true);
                } else {
                    this.f16486g.n(true);
                    this.f16486g.m(true);
                }
                this.f16486g.j(aVar.n());
                p(aVar, z);
            }
            this.f16486g.p(false);
            this.f16486g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.f16480a.closeLoadingDialog();
            if (str != null) {
                this.f16480a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.f16486g.notifyDataSetChanged();
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
            this.f16488i.setVisibility(8);
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f16480a.getPageContext().getPageActivity()).createNormalConfig(c.a.e.e.m.b.g(markData.getUesrId(), 0L), false, markData.isGod())));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f16486g.notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f16487h, R.color.CAM_X0201);
            g gVar = this.f16484e;
            if (gVar != null) {
                gVar.D(i2);
            }
            m();
            NoDataView noDataView = this.f16485f;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f16480a.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f16485f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.q0.s.s.a aVar = this.f16489j;
            if (aVar != null) {
                aVar.dismiss();
                this.f16489j = null;
            }
            ProgressBar progressBar = this.f16488i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.l);
            }
            e eVar = this.f16486g;
            if (eVar != null) {
                eVar.i();
            }
        }
    }

    public void p(c.a.r0.c2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, aVar, z) == null) {
            if (aVar == null) {
                s();
            } else if (aVar.m() > 0) {
                this.f16485f.setVisibility(8);
                this.f16482c.removeHeaderView(this.f16485f);
                this.f16486g.notifyDataSetChanged();
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
            this.f16485f.onActivityStart(this.f16480a.getPageContext());
            this.f16482c.removeHeaderView(this.f16485f);
            this.f16482c.addHeaderView(this.f16485f);
            this.f16485f.setVisibility(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f16489j == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f16480a.getPageContext().getPageActivity());
                this.f16489j = aVar;
                aVar.setTitle(this.f16480a.getPageContext().getString(R.string.sync_mark_fail));
                this.f16489j.setMessage(this.f16480a.getPageContext().getString(R.string.neterror));
                if (this.k != null) {
                    this.f16489j.setPositiveButton(this.f16480a.getPageContext().getString(R.string.retry_rightnow), this.k);
                }
                this.f16489j.setNegativeButton(this.f16480a.getPageContext().getString(R.string.confirm), new b(this));
                this.f16489j.create(this.f16480a.getPageContext());
                this.f16489j.setCanceledOnTouchOutside(true);
            }
            this.f16489j.show();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f16488i.setVisibility(0);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 0) {
                this.f16482c.startPullRefresh();
                return;
            }
            this.f16486g.p(true);
            this.f16486g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.f16486g.j(arrayList);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f16485f.isShown()) {
            this.f16485f.onActivityStart(this.f16480a.getPageContext());
        }
    }
}
