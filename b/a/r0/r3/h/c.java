package b.a.r0.r3.h;

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
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f23247a;

    /* renamed from: b  reason: collision with root package name */
    public View f23248b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f23249c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23250d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f23251e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<b.a.r0.r3.h.a> f23252f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f23253g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23254h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.r3.h.b f23255i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23256e;

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
            this.f23256e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            b.a.r0.r3.h.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f23256e.f23255i.getItem(i2)) == null) {
                return;
            }
            b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
            j2.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), item.c());
            this.f23256e.f23255i.notifyDataSetChanged();
            if (StringUtils.isNull(item.getType())) {
                return;
            }
            String type = item.getType();
            int e2 = b.a.e.e.m.b.e(type, 0);
            CustomMessage customMessage = null;
            if (e2 == 1) {
                TiebaStatic.log("c10263");
                this.f23256e.k();
            } else if (e2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f23256e.f23247a.getActivity()));
            } else if (e2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.f23256e.f23247a.getActivity()));
            } else if (e2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.f23256e.f23247a.getPageContext().getPageActivity()));
            } else if (e2 != 5) {
                UrlManager.getInstance().dealOneLink(this.f23256e.f23247a.getPageContext(), new String[]{type});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f23256e.f23247a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* renamed from: b.a.r0.r3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1136c implements b.a.q0.s.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1136c(c cVar) {
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

        @Override // b.a.q0.s.w.a
        public b.a.q0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.w.b.c cVar = new b.a.q0.s.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (b.a.q0.s.w.b.c) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
        public b.a.q0.s.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                b.a.q0.s.w.b.e eVar = new b.a.q0.s.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (b.a.q0.s.w.b.e) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.a
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

    /* loaded from: classes5.dex */
    public class d implements b.a.q0.s.w.b.d<b.a.r0.r3.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23257a;

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
            this.f23257a = cVar;
        }

        @Override // b.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.f23257a.f23247a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, b.a.r0.r3.h.a aVar) {
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
        this.j = 0;
        this.f23247a = dressupCenterActivity;
        this.j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f23247a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f23248b = inflate;
        this.f23247a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f23248b.findViewById(R.id.view_navigation_bar);
        this.f23250d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23250d.setCenterTextTitle(this.f23247a.getPageContext().getString(R.string.dressup_center_title));
        this.f23251e = (NoNetworkView) this.f23248b.findViewById(R.id.view_no_network);
        this.f23249c = (BdListView) this.f23248b.findViewById(R.id.dress_listview);
        this.f23252f = (CoverFlowView) this.f23248b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23248b.findViewById(R.id.dressup_center_recommend);
        this.f23253g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.f23255i = new b.a.r0.r3.h.b(this.f23247a.getPageContext());
        TextView textView = new TextView(this.f23247a.getActivity());
        this.f23254h = textView;
        textView.setHeight(l.g(this.f23247a.getActivity(), R.dimen.ds30));
        this.f23249c.setAdapter((ListAdapter) this.f23255i);
        this.f23249c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23247a.hideNetRefreshView(this.f23248b);
            this.f23249c.setVisibility(0);
            this.f23253g.setVisibility(0);
            this.f23252f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23248b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        b.a.r0.r3.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23247a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f23247a.getLayoutMode().j(this.f23248b);
            NavigationBar navigationBar = this.f23250d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23247a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f23251e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f23247a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<b.a.r0.r3.h.a> coverFlowView = this.f23252f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f23252f.onChangeSkinType();
            }
            BdListView bdListView = this.f23249c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f23255i) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f23253g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f23253g.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.f23254h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<b.a.r0.r3.h.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f23252f.setVisibility(0);
                this.f23252f.setData(list);
                return true;
            }
            this.f23252f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<b.a.r0.r3.h.d> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.f23249c.removeHeaderView(this.f23254h);
                    this.f23249c.addHeaderView(this.f23254h);
                } else {
                    this.f23249c.removeHeaderView(this.f23254h);
                }
                this.f23249c.setVisibility(0);
                this.f23255i.b(list);
                this.f23255i.notifyDataSetChanged();
                return;
            }
            this.f23249c.setVisibility(8);
        }
    }

    public final boolean i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23253g.setVisibility(0);
                this.f23253g.fillView(eVar);
                return true;
            }
            this.f23253g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<b.a.r0.r3.h.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f23252f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1136c(this));
        this.f23252f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23247a.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.function_unavailable_tip);
            aVar.setPositiveButton(R.string.confirm, new b(this));
            aVar.create(this.f23247a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f23249c.setVisibility(8);
            this.f23252f.setVisibility(8);
            this.f23253g.setVisibility(8);
            String string = this.f23247a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23247a.setNetRefreshViewTopMargin(this.j);
            this.f23247a.showNetRefreshView(this.f23248b, string, false);
        }
    }

    public void m(List<b.a.r0.r3.h.a> list, e eVar, List<b.a.r0.r3.h.d> list2, boolean z) {
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
