package c.a.p0.f4.h;

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
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressupCenterActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15113b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f15114c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15115d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15116e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<c.a.p0.f4.h.a> f15117f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f15118g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15119h;
    public c.a.p0.f4.h.b i;
    public int j;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.a.p0.f4.h.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.i.getItem(i)) == null) {
                return;
            }
            c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
            k.x("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), item.c());
            this.a.i.notifyDataSetChanged();
            if (StringUtils.isNull(item.getType())) {
                return;
            }
            String type = item.getType();
            int e2 = c.a.d.f.m.b.e(type, 0);
            CustomMessage customMessage = null;
            if (e2 == 1) {
                TiebaStatic.log("c10263");
                this.a.k();
            } else if (e2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.a.a.getActivity()));
            } else if (e2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.a.getActivity()));
            } else if (e2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(this.a.a.getPageContext().getPageActivity()));
            } else if (e2 != 5) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{type});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(this.a.a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* renamed from: c.a.p0.f4.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1138c implements c.a.o0.r.x.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1138c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.x.a
        public c.a.o0.r.x.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.o0.r.x.b.c cVar = new c.a.o0.r.x.b.c();
                cVar.c(R.drawable.obfuscated_res_0x7f0806ea);
                cVar.g(R.drawable.obfuscated_res_0x7f0806eb);
                cVar.h(R.dimen.obfuscated_res_0x7f070198);
                cVar.d(85);
                cVar.f(R.dimen.obfuscated_res_0x7f070201);
                cVar.e(R.dimen.obfuscated_res_0x7f0701d5);
                return cVar;
            }
            return (c.a.o0.r.x.b.c) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.a
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.a
        public c.a.o0.r.x.b.e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.a.o0.r.x.b.e eVar = new c.a.o0.r.x.b.e();
                eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
                return eVar;
            }
            return (c.a.o0.r.x.b.e) invokeV.objValue;
        }

        @Override // c.a.o0.r.x.a
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

    /* loaded from: classes2.dex */
    public class d implements c.a.o0.r.x.b.d<c.a.p0.f4.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.r.x.b.d
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                TiebaStatic.log("c10262");
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.r.x.b.d
        /* renamed from: c */
        public void a(int i, c.a.p0.f4.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, aVar) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.a = dressupCenterActivity;
        this.j = n.f(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070235);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0245, (ViewGroup) null);
        this.f15113b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f15113b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15115d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15115d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0504));
        this.f15116e = (NoNetworkView) this.f15113b.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f15114c = (BdListView) this.f15113b.findViewById(R.id.obfuscated_res_0x7f09083d);
        this.f15117f = (CoverFlowView) this.f15113b.findViewById(R.id.obfuscated_res_0x7f09083e);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15113b.findViewById(R.id.obfuscated_res_0x7f09083f);
        this.f15118g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new c.a.p0.f4.h.b(this.a.getPageContext());
        TextView textView = new TextView(this.a.getActivity());
        this.f15119h = textView;
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070201));
        this.f15114c.setAdapter((ListAdapter) this.i);
        this.f15114c.setOnItemClickListener(new a(this));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.f15113b);
            this.f15114c.setVisibility(0);
            this.f15118g.setVisibility(0);
            this.f15117f.setVisibility(0);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15113b : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        c.a.p0.f4.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.f15113b);
            NavigationBar navigationBar = this.f15115d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f15116e;
            if (noNetworkView != null) {
                noNetworkView.c(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            CoverFlowView<c.a.p0.f4.h.a> coverFlowView = this.f15117f;
            if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
                this.f15117f.s();
            }
            BdListView bdListView = this.f15114c;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.i) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f15118g;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f15118g.d();
            }
            SkinManager.setBackgroundColor(this.f15119h, R.color.CAM_X0204);
        }
    }

    public final boolean g(List<c.a.p0.f4.h.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                this.f15117f.setVisibility(0);
                this.f15117f.setData(list);
                return true;
            }
            this.f15117f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(List<c.a.p0.f4.h.d> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) {
            if (list != null && list.size() > 0) {
                if (z) {
                    this.f15114c.removeHeaderView(this.f15119h);
                    this.f15114c.addHeaderView(this.f15119h);
                } else {
                    this.f15114c.removeHeaderView(this.f15119h);
                }
                this.f15114c.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.f15114c.setVisibility(8);
        }
    }

    public final boolean i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15118g.setVisibility(0);
                this.f15118g.e(eVar);
                return true;
            }
            this.f15118g.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        CoverFlowView<c.a.p0.f4.h.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (coverFlowView = this.f15117f) == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1138c(this));
        this.f15117f.setCallback(new d(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.obfuscated_res_0x7f0f0772);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new b(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15114c.setVisibility(8);
            this.f15117f.setVisibility(8);
            this.f15118g.setVisibility(8);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.f15113b, string, false);
        }
    }

    public void m(List<c.a.p0.f4.h.a> list, e eVar, List<c.a.p0.f4.h.d> list2, boolean z) {
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
