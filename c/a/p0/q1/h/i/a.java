package c.a.p0.q1.h.i;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.o0.m.f;
import c.a.o0.r.r.a2;
import c.a.p0.q1.h.b;
import c.a.p0.q1.h.c;
import c.a.p0.q1.h.d.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.lowFlows.LowFlowsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements c, View.OnClickListener, f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LowFlowsActivity f17357b;

    /* renamed from: c  reason: collision with root package name */
    public b f17358c;

    /* renamed from: d  reason: collision with root package name */
    public d f17359d;

    /* renamed from: e  reason: collision with root package name */
    public String f17360e;

    /* renamed from: f  reason: collision with root package name */
    public String f17361f;

    /* renamed from: g  reason: collision with root package name */
    public String f17362g;

    /* renamed from: h  reason: collision with root package name */
    public int f17363h;
    public View i;
    public ImageView j;
    public ImageView k;
    public NavigationBar l;
    public BdTypeRecyclerView m;
    public View n;
    public ImageView o;
    public TextView p;
    public CollapsingToolbarLayout q;
    public View r;
    public View s;
    public AppBarLayout t;
    public TextView u;
    public RelativeLayout v;
    public AppBarLayout.OnOffsetChangedListener w;

    /* renamed from: c.a.p0.q1.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1304a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1304a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                int totalScrollRange = appBarLayout.getTotalScrollRange() - this.a.i();
                if (totalScrollRange <= 0) {
                    return;
                }
                float abs = Math.abs(i * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (this.a.l == null || abs != 1.0f) {
                    WebPManager.setPureDrawable(this.a.o, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                    if (this.a.p != null) {
                        this.a.p.setAlpha(0.0f);
                    }
                    if (this.a.l.getBarBgView() != null) {
                        this.a.l.getBarBgView().setAlpha(0.0f);
                        return;
                    }
                    return;
                }
                if (this.a.l.getBarBgView() != null) {
                    this.a.l.getBarBgView().setAlpha(1.0f);
                }
                if (this.a.p != null) {
                    this.a.p.setAlpha(1.0f);
                }
                WebPManager.setPureDrawable(this.a.o, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17362g = "";
        this.f17363h = 3;
        this.w = new C1304a(this);
        this.a = tbPageContext;
        this.f17357b = (LowFlowsActivity) tbPageContext.getPageActivity();
        this.f17358c = new c.a.p0.q1.h.g.a(this);
        m();
        k();
    }

    @Override // c.a.o0.m.f
    public void a(View view, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            c.a.p0.q1.h.h.a.a("c14084", StringUtils.isNull(this.f17362g) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.f17360e);
        }
    }

    @Override // c.a.p0.q1.h.c
    public void b(int i) {
        View view;
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            View view2 = this.r;
            if (view2 != null && view2.getParent() != null && (lowFlowsActivity = this.f17357b) != null) {
                lowFlowsActivity.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            if (this.f17357b == null || (view = this.s) == null) {
                return;
            }
            view.setVisibility(0);
            this.f17357b.showNetRefreshView(this.s, "");
        }
    }

    @Override // c.a.o0.m.f
    public void c(View view, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    public final BdUniqueId h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NavigationBar navigationBar = this.l;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.i == null && (tbPageContext = this.a) != null) {
                this.i = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0042, (ViewGroup) null);
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.a.getPageActivity().setContentView(j());
        this.j = (ImageView) j().findViewById(R.id.obfuscated_res_0x7f090d3a);
        this.k = (ImageView) j().findViewById(R.id.obfuscated_res_0x7f090d40);
        this.l = (NavigationBar) j().findViewById(R.id.obfuscated_res_0x7f091246);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) j().findViewById(R.id.obfuscated_res_0x7f09144f);
        this.m = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.m.setFadingEdgeLength(0);
        n(this.f17360e);
        AppBarLayout appBarLayout = (AppBarLayout) j().findViewById(R.id.obfuscated_res_0x7f091243);
        this.t = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.w);
        this.q = (CollapsingToolbarLayout) j().findViewById(R.id.obfuscated_res_0x7f091244);
        this.r = j().findViewById(R.id.obfuscated_res_0x7f091538);
        this.s = j().findViewById(R.id.obfuscated_res_0x7f09153e);
        l();
        d dVar = new d(this.a, this.m);
        this.f17359d = dVar;
        dVar.e(h());
        this.f17359d.d(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        int f2 = n.f(tbPageContext.getPageActivity(), R.dimen.M_H_X008);
        this.v = new RelativeLayout(this.a.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.v.setPadding(0, f2, 0, f2);
        this.v.setLayoutParams(layoutParams);
        this.u = new TextView(this.a.getPageActivity());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.u.setLayoutParams(layoutParams2);
        this.u.setText(R.string.obfuscated_res_0x7f0f09dc);
        this.u.setBackgroundColor(0);
        this.v.addView(this.u);
    }

    @Override // c.a.p0.q1.h.c
    public void loadData() {
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.s;
            if (view != null && view.getParent() != null && (lowFlowsActivity = this.f17357b) != null) {
                lowFlowsActivity.hideNetRefreshView(this.s);
                this.s.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getParent() != null) {
                this.m.setVisibility(8);
            }
            View view2 = this.r;
            if (view2 != null && this.f17357b != null) {
                view2.setVisibility(0);
                this.f17357b.showLoadingView(this.r);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.k.setVisibility(8);
            }
            b bVar = this.f17358c;
            if (bVar != null) {
                bVar.a(h(), this.f17360e, this.f17361f, this.f17362g);
            }
        }
    }

    public final void m() {
        TbPageContext tbPageContext;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null || (intent = this.a.getPageActivity().getIntent()) == null) {
            return;
        }
        this.f17360e = intent.getStringExtra("tab_code");
        this.f17361f = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
        this.f17362g = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Drawable[] a = c.a.p0.q1.h.h.b.a(str);
            if (a != null) {
                this.j.setImageDrawable(a[0]);
                this.k.setImageDrawable(a[1]);
            }
            o(c.a.p0.q1.h.h.b.b(str));
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View addSystemImageButton = this.l.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.n = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09246f);
            this.p = this.l.getCenterText();
            this.l.setCenterTextTitle(str);
        }
    }

    @Override // c.a.p0.q1.h.c
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.f17363h != i) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.p);
                d2.A(R.string.F_X02);
                d2.z(R.dimen.T_X05);
                d2.v(R.color.CAM_X0105);
                this.l.getBarBgView().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                Drawable[] a = c.a.p0.q1.h.h.b.a(this.f17360e);
                if (a != null) {
                    this.j.setImageDrawable(a[0]);
                    this.k.setImageDrawable(a[1]);
                }
                this.v.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.u);
                d3.z(R.dimen.T_X08);
                d3.v(R.color.CAM_X0109);
                d dVar = this.f17359d;
                if (dVar != null) {
                    dVar.b();
                }
            }
            this.f17363h = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.a == null || view.getId() != R.id.obfuscated_res_0x7f091511 || this.a.getPageActivity() == null) {
            return;
        }
        this.a.getPageActivity().finish();
    }

    @Override // c.a.p0.q1.h.c
    public void setData(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            View view = this.r;
            if (view != null && this.f17357b != null && view.getParent() != null) {
                this.f17357b.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(0);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 8) {
                this.k.setVisibility(0);
            }
            for (c.a.d.o.e.n nVar : list) {
                if (nVar instanceof a2) {
                    ((a2) nVar).getThreadData().mTabCode = this.f17360e;
                }
            }
            d dVar = this.f17359d;
            if (dVar != null) {
                dVar.c(list);
            }
            this.m.setFooterView(this.v);
        }
    }
}
