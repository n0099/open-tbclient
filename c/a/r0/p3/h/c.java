package c.a.r0.p3.h;

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
import c.a.q0.s.s.a;
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
    public DressupCenterActivity f24060a;

    /* renamed from: b  reason: collision with root package name */
    public View f24061b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f24062c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24063d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f24064e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<c.a.r0.p3.h.a> f24065f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f24066g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24067h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.p3.h.b f24068i;

    /* renamed from: j  reason: collision with root package name */
    public int f24069j;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24070e;

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
            this.f24070e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.r0.p3.h.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f24070e.f24068i.getItem(i2)) == null) {
                return;
            }
            c.a.q0.s.d0.b j3 = c.a.q0.s.d0.b.j();
            j3.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), item.d());
            this.f24070e.f24068i.notifyDataSetChanged();
            if (StringUtils.isNull(item.c())) {
                return;
            }
            String c2 = item.c();
            int e2 = c.a.e.e.m.b.e(c2, 0);
            CustomMessage customMessage = null;
            if (e2 == 1) {
                TiebaStatic.log("c10263");
                this.f24070e.k();
            } else if (e2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f24070e.f24060a.getActivity()));
            } else if (e2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.f24070e.f24060a.getActivity()));
            } else if (e2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.f24070e.f24060a.getPageContext().getPageActivity()));
            } else if (e2 != 5) {
                UrlManager.getInstance().dealOneLink(this.f24070e.f24060a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f24070e.f24060a.getActivity()));
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* renamed from: c.a.r0.p3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1115c implements c.a.q0.s.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1115c(c cVar) {
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

        @Override // c.a.q0.s.w.a
        public c.a.q0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.w.b.c cVar = new c.a.q0.s.w.b.c();
                cVar.c(R.drawable.icon_diandian_white_n);
                cVar.g(R.drawable.icon_diandian_white_s);
                cVar.h(R.dimen.ds1);
                cVar.d(85);
                cVar.f(R.dimen.ds30);
                cVar.e(R.dimen.ds20);
                return cVar;
            }
            return (c.a.q0.s.w.b.c) invokeV.objValue;
        }

        @Override // c.a.q0.s.w.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.q0.s.w.a
        public c.a.q0.s.w.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.a.q0.s.w.b.e eVar = new c.a.q0.s.w.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                return eVar;
            }
            return (c.a.q0.s.w.b.e) invokeV.objValue;
        }

        @Override // c.a.q0.s.w.a
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
    public class d implements c.a.q0.s.w.b.d<c.a.r0.p3.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24071a;

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
            this.f24071a = cVar;
        }

        @Override // c.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.f24071a.f24060a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, c.a.r0.p3.h.a aVar) {
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
        this.f24069j = 0;
        this.f24060a = dressupCenterActivity;
        this.f24069j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f24060a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f24061b = inflate;
        this.f24060a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f24061b.findViewById(R.id.view_navigation_bar);
        this.f24063d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24063d.setCenterTextTitle(this.f24060a.getPageContext().getString(R.string.dressup_center_title));
        this.f24064e = (NoNetworkView) this.f24061b.findViewById(R.id.view_no_network);
        this.f24062c = (BdListView) this.f24061b.findViewById(R.id.dress_listview);
        this.f24065f = (CoverFlowView) this.f24061b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f24061b.findViewById(R.id.dressup_center_recommend);
        this.f24066g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.f24068i = new c.a.r0.p3.h.b(this.f24060a.getPageContext());
        TextView textView = new TextView(this.f24060a.getActivity());
        this.f24067h = textView;
        textView.setHeight(l.g(this.f24060a.getActivity(), R.dimen.ds30));
        this.f24062c.setAdapter((ListAdapter) this.f24068i);
        this.f24062c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24060a.hideNetRefreshView(this.f24061b);
            this.f24062c.setVisibility(0);
            this.f24066g.setVisibility(0);
            this.f24065f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24061b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        c.a.r0.p3.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24060a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f24060a.getLayoutMode().j(this.f24061b);
            NavigationBar navigationBar = this.f24063d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24060a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f24064e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f24060a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<c.a.r0.p3.h.a> coverFlowView = this.f24065f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f24065f.onChangeSkinType();
            }
            BdListView bdListView = this.f24062c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f24068i) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f24066g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f24066g.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.f24067h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<c.a.r0.p3.h.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f24065f.setVisibility(0);
                this.f24065f.setData(list);
                return true;
            }
            this.f24065f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<c.a.r0.p3.h.d> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.f24062c.removeHeaderView(this.f24067h);
                    this.f24062c.addHeaderView(this.f24067h);
                } else {
                    this.f24062c.removeHeaderView(this.f24067h);
                }
                this.f24062c.setVisibility(0);
                this.f24068i.b(list);
                this.f24068i.notifyDataSetChanged();
                return;
            }
            this.f24062c.setVisibility(8);
        }
    }

    public final boolean i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24066g.setVisibility(0);
                this.f24066g.fillView(eVar);
                return true;
            }
            this.f24066g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<c.a.r0.p3.h.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f24065f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1115c(this));
        this.f24065f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f24060a.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.function_unavailable_tip);
            aVar.setPositiveButton(R.string.confirm, new b(this));
            aVar.create(this.f24060a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24062c.setVisibility(8);
            this.f24065f.setVisibility(8);
            this.f24066g.setVisibility(8);
            String string = this.f24060a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24060a.setNetRefreshViewTopMargin(this.f24069j);
            this.f24060a.showNetRefreshView(this.f24061b, string, false);
        }
    }

    public void m(List<c.a.r0.p3.h.a> list, e eVar, List<c.a.r0.p3.h.d> list2, boolean z) {
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
