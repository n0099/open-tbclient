package b.a.r0.w.l.c;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.r0.w.l.d.e;
import b.a.r0.w.l.d.f;
import b.a.r0.w.l.d.j;
import b.a.r0.w.l.d.k;
import b.a.r0.w.l.d.l;
import b.a.r0.w.l.d.m;
import b.a.r0.w.l.d.n;
import b.a.r0.w.l.d.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a implements b.a.r0.w.l.f.a, b.a.r0.w.l.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterModel f25158a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.w.l.d.c f25159b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.w.l.b.d f25160c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f25161d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f25162e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f25163f;

    /* renamed from: g  reason: collision with root package name */
    public View f25164g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f25165h;

    /* renamed from: i  reason: collision with root package name */
    public g f25166i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public h q;
    public boolean r;
    public boolean s;

    /* renamed from: b.a.r0.w.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1228a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25167e;

        public View$OnClickListenerC1228a(a aVar) {
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
            this.f25167e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25167e.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25168a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25168a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f25168a.f25158a == null) {
                return;
            }
            this.f25168a.f25158a.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25169e;

        public c(a aVar) {
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
            this.f25169e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f25169e.f25161d.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25170e;

        public d(a aVar) {
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
            this.f25170e = aVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f25170e.v();
                this.f25170e.u();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
            }
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = 0;
        this.o = false;
        this.r = false;
        this.s = false;
        new b(this, AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH);
        this.f25161d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.ds400);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.f25158a = alaPersonCenterModel;
        alaPersonCenterModel.x(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // b.a.r0.w.l.e.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 1) {
            this.s = true;
        }
    }

    @Override // b.a.r0.w.l.f.a
    public void b(int i2, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, obj) == null) {
            g gVar = this.f25166i;
            if (gVar != null) {
                gVar.dettachView(this.f25164g);
            }
            this.f25163f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f25163f;
            if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
                return;
            }
            w();
        }
    }

    @Override // b.a.r0.w.l.f.a
    public void c(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i2) == null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof b.a.r0.w.l.d.c) && i2 == 1) {
            b.a.r0.w.l.d.c cVar = (b.a.r0.w.l.d.c) obj;
            this.f25159b = cVar;
            cVar.e(this.j);
            this.f25166i.dettachView(this.f25164g);
            this.f25163f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f25159b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            f fVar = new f();
            fVar.i(this.f25159b);
            arrayList.add(fVar);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                m mVar = new m();
                mVar.i(this.f25159b);
                arrayList.add(mVar);
            }
            j jVar = new j();
            jVar.i(this.f25159b);
            arrayList.add(jVar);
            k kVar = new k();
            kVar.i(this.f25159b);
            arrayList.add(kVar);
            if (this.f25159b.f25180h != null) {
                b.a.r0.w.l.d.d dVar = new b.a.r0.w.l.d.d();
                dVar.i(this.f25159b);
                arrayList.add(dVar);
            }
            b.a.r0.w.l.d.h hVar = new b.a.r0.w.l.d.h();
            hVar.i(this.f25159b);
            arrayList.add(hVar);
            l lVar = new l();
            lVar.i(this.f25159b);
            arrayList.add(lVar);
            b.a.r0.w.l.d.g gVar = new b.a.r0.w.l.d.g();
            gVar.i(this.f25159b);
            arrayList.add(gVar);
            e eVar = new e();
            eVar.i(this.f25159b);
            arrayList.add(eVar);
            o oVar = new o();
            oVar.i(this.f25159b);
            arrayList.add(oVar);
            n nVar = new n();
            nVar.i(this.f25159b);
            arrayList.add(nVar);
        } else {
            arrayList = new ArrayList(4);
            f fVar2 = new f();
            fVar2.i(this.f25159b);
            arrayList.add(fVar2);
        }
        this.f25160c.b(arrayList);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25164g : (View) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h hVar = this.q;
            if (hVar != null && hVar.b().getParent() != null) {
                ((ViewGroup) this.q.b().getParent()).removeView(this.q.b());
            }
            this.r = false;
        }
    }

    public void k(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f25158a.setUid(str);
            this.j = z;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25158a.loadData();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f25162e.onChangeSkinType(this.f25161d, i2);
            this.f25162e.getBackground().mutate().setAlpha(0);
            TextView textView = this.f25162e.mTextTitle;
            int i3 = R.color.CAM_X0101;
            SkinManager.setNavbarTitleColor(textView, i3, i3);
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            this.f25163f.setDivider(SkinManager.getDrawable(i2, R.color.CAM_X0204));
            this.f25163f.setDividerHeight(this.f25161d.getResources().getDimensionPixelSize(R.dimen.ds2));
            SkinManager.setBackgroundColor(this.f25164g, R.color.CAM_X0201);
            if (this.f25163f.getAdapter2() instanceof b.a.e.l.e.e) {
                this.f25163f.getAdapter2().notifyDataSetChanged();
                g gVar = this.f25166i;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                this.f25165h.onChangeSkinType(this.f25161d, i2);
                if (i2 == 1) {
                    this.f25162e.getBarBgView().setBackgroundColor(this.f25161d.getResources().getColor(R.color.CAM_X0207_1));
                    this.f25162e.getTopCoverBgView().setBackgroundColor(this.f25161d.getResources().getColor(R.color.CAM_X0201_1));
                } else if (i2 == 0) {
                    this.f25162e.getBarBgView().setBackgroundColor(this.f25161d.getResources().getColor(R.color.CAM_X0207));
                    this.f25162e.getTopCoverBgView().setBackgroundColor(this.f25161d.getResources().getColor(R.color.CAM_X0201));
                }
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            View inflate = View.inflate(context, R.layout.ala_person_center_layout, null);
            this.f25164g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.ala_person_center_navigation_bar);
            this.f25162e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.f25162e.showBottomLine(false);
            if (!this.o) {
                this.n = this.f25162e.setCenterTextTitle(this.f25161d.getString(R.string.ala_live));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f25161d.getResources().getString(R.string.forum));
                this.n = this.f25162e.setCenterTextTitle(sb.toString());
            }
            this.f25165h = (NoNetworkView) this.f25164g.findViewById(R.id.ala_person_center_no_network_view);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f25164g.findViewById(R.id.ala_person_center_listview);
            this.f25163f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f25163f.setVisibility(8);
            b.a.r0.w.l.b.d dVar = new b.a.r0.w.l.b.d(this.f25161d, this.f25163f, this);
            this.f25160c = dVar;
            dVar.f(this.o);
            if (this.o) {
                this.f25164g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            g gVar = new g(this.f25161d.getPageActivity());
            this.f25166i = gVar;
            gVar.attachView(this.f25164g, false);
            this.f25163f.setOnScrollListener(new d(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g gVar = this.f25166i;
            if (gVar != null) {
                gVar.m();
                this.f25166i.dettachView(this.f25164g);
            }
            AlaPersonCenterModel alaPersonCenterModel = this.f25158a;
            if (alaPersonCenterModel != null) {
                alaPersonCenterModel.destory();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.s) {
            this.s = false;
            l();
        }
    }

    public void q(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (!z && !this.r) {
                ImageView imageView = this.m;
                int i2 = R.drawable.icon_return_bg_s;
                SkinManager.setNavbarIconSrc(imageView, i2, i2);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                ImageView imageView2 = this.m;
                int i3 = R.drawable.icon_return_bg_s;
                SkinManager.setNavbarIconSrc(imageView2, i3, i3);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            }
            this.n.setAlpha(f2);
            this.m.setAlpha(f2);
        }
    }

    public void r(String str) {
        b.a.r0.w.l.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (dVar = this.f25160c) == null) {
            return;
        }
        dVar.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            b.a.r0.w.l.b.d dVar = this.f25160c;
            if (dVar != null) {
                dVar.d(str);
            }
            if (!this.o) {
                this.n = this.f25162e.setCenterTextTitle(this.f25161d.getString(R.string.ala_live));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f25161d.getResources().getString(R.string.forum));
            this.n = this.f25162e.setCenterTextTitle(sb.toString());
        }
    }

    public void t(String str) {
        b.a.r0.w.l.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (dVar = this.f25160c) == null) {
            return;
        }
        dVar.e(str);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || 2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.f25162e.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.k) {
                this.k = true;
            }
        } else if (this.k) {
            this.k = false;
        }
        q(alpha, !this.k);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11 || this.f25163f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.f25161d.getResources().getDimension(R.dimen.ds98);
        int i2 = this.l - (-this.f25163f.getChildAt(0).getTop());
        if (i2 < dimension) {
            if (this.f25162e.getBarBgView().getAlpha() != 1.0f) {
                this.f25162e.getBarBgView().setAlpha(1.0f);
                this.f25162e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i2 >= dimension && i2 <= dimension * 2) {
            float f2 = 1.0f - (((i2 - dimension) * 1.0f) / dimension);
            this.f25162e.getBarBgView().setAlpha(f2);
            this.f25162e.getTopCoverBgView().setAlpha(1.0f - f2);
        } else if (i2 > dimension * 2 && this.f25162e.getBarBgView().getAlpha() != 0.0f) {
            this.f25162e.getBarBgView().setAlpha(0.0f);
            this.f25162e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f25163f.getFirstVisiblePosition() <= 0 || this.f25162e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.f25162e.getBarBgView().setAlpha(1.0f);
        this.f25162e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                h hVar = new h(this.f25161d.getPageActivity(), new View$OnClickListenerC1228a(this));
                this.q = hVar;
                hVar.m(null);
                this.q.g(null);
                this.q.j(this.f25161d.getResources().getDimensionPixelSize(R.dimen.ds340));
                this.q.o();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.l(null);
            this.q.m(this.f25161d.getResources().getString(R.string.refresh_view_title_text));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.f25164g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
