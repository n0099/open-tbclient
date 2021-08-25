package c.a.q0.o3.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f23454a;

    /* renamed from: b  reason: collision with root package name */
    public View f23455b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f23456c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23457d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f23458e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<c.a.q0.o3.h.a> f23459f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f23460g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23461h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.o3.h.b f23462i;

    /* renamed from: j  reason: collision with root package name */
    public int f23463j;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23464e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23464e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.q0.o3.h.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f23464e.f23462i.getItem(i2)) == null) {
                return;
            }
            c.a.p0.s.d0.b j3 = c.a.p0.s.d0.b.j();
            j3.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), item.d());
            this.f23464e.f23462i.notifyDataSetChanged();
            if (StringUtils.isNull(item.c())) {
                return;
            }
            String c2 = item.c();
            int d2 = c.a.e.e.m.b.d(c2, 0);
            CustomMessage customMessage = null;
            if (d2 == 1) {
                TiebaStatic.log("c10263");
                this.f23464e.k();
            } else if (d2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f23464e.f23454a.getActivity()));
            } else if (d2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.f23464e.f23454a.getActivity()));
            } else if (d2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.f23464e.f23454a.getPageContext().getPageActivity()));
            } else if (d2 != 5) {
                UrlManager.getInstance().dealOneLink(this.f23464e.f23454a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f23464e.f23454a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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

    /* renamed from: c.a.q0.o3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1082c implements c.a.p0.s.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1082c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.w.a
        public c.a.p0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.w.b.c cVar = new c.a.p0.s.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (c.a.p0.s.w.b.c) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.a
        public c.a.p0.s.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.a.p0.s.w.b.e eVar = new c.a.p0.s.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (c.a.p0.s.w.b.e) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.s.w.b.d<c.a.q0.o3.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23465a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23465a = cVar;
        }

        @Override // c.a.p0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.f23465a.f23454a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, c.a.q0.o3.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            }
        }
    }

    public c(DressupCenterActivity dressupCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dressupCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23463j = 0;
        this.f23454a = dressupCenterActivity;
        this.f23463j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f23454a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f23455b = inflate;
        this.f23454a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f23455b.findViewById(R.id.view_navigation_bar);
        this.f23457d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23457d.setCenterTextTitle(this.f23454a.getPageContext().getString(R.string.dressup_center_title));
        this.f23458e = (NoNetworkView) this.f23455b.findViewById(R.id.view_no_network);
        this.f23456c = (BdListView) this.f23455b.findViewById(R.id.dress_listview);
        this.f23459f = (CoverFlowView) this.f23455b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23455b.findViewById(R.id.dressup_center_recommend);
        this.f23460g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.f23462i = new c.a.q0.o3.h.b(this.f23454a.getPageContext());
        TextView textView = new TextView(this.f23454a.getActivity());
        this.f23461h = textView;
        textView.setHeight(l.g(this.f23454a.getActivity(), R.dimen.ds30));
        this.f23456c.setAdapter((ListAdapter) this.f23462i);
        this.f23456c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23454a.hideNetRefreshView(this.f23455b);
            this.f23456c.setVisibility(0);
            this.f23460g.setVisibility(0);
            this.f23459f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23455b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        c.a.q0.o3.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23454a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f23454a.getLayoutMode().j(this.f23455b);
            NavigationBar navigationBar = this.f23457d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23454a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f23458e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f23454a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<c.a.q0.o3.h.a> coverFlowView = this.f23459f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f23459f.onChangeSkinType();
            }
            BdListView bdListView = this.f23456c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f23462i) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f23460g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f23460g.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.f23461h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<c.a.q0.o3.h.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f23459f.setVisibility(0);
                this.f23459f.setData(list);
                return true;
            }
            this.f23459f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<c.a.q0.o3.h.d> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.f23456c.removeHeaderView(this.f23461h);
                    this.f23456c.addHeaderView(this.f23461h);
                } else {
                    this.f23456c.removeHeaderView(this.f23461h);
                }
                this.f23456c.setVisibility(0);
                this.f23462i.b(list);
                this.f23462i.notifyDataSetChanged();
                return;
            }
            this.f23456c.setVisibility(8);
        }
    }

    public final boolean i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23460g.setVisibility(0);
                this.f23460g.fillView(eVar);
                return true;
            }
            this.f23460g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<c.a.q0.o3.h.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f23459f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1082c(this));
        this.f23459f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f23454a.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.function_unavailable_tip);
            aVar.setPositiveButton(R.string.confirm, new b(this));
            aVar.create(this.f23454a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f23456c.setVisibility(8);
            this.f23459f.setVisibility(8);
            this.f23460g.setVisibility(8);
            String string = this.f23454a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23454a.setNetRefreshViewTopMargin(this.f23463j);
            this.f23454a.showNetRefreshView(this.f23455b, string, false);
        }
    }

    public void m(List<c.a.q0.o3.h.a> list, e eVar, List<c.a.q0.o3.h.d> list2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, eVar, list2, Boolean.valueOf(z)}) == null) {
            if ((list != null && list.size() > 0) || ((eVar != null && !StringUtils.isNull(eVar.c())) || (list2 != null && list2.size() > 0))) {
                d();
                h(list2, g(list) || i(eVar));
                return;
            }
            l();
        }
    }
}
