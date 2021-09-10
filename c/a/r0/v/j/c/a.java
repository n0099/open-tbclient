package c.a.r0.v.j.c;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.r0.v.j.d.e;
import c.a.r0.v.j.d.f;
import c.a.r0.v.j.d.j;
import c.a.r0.v.j.d.k;
import c.a.r0.v.j.d.l;
import c.a.r0.v.j.d.m;
import c.a.r0.v.j.d.n;
import c.a.r0.v.j.d.o;
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
/* loaded from: classes4.dex */
public class a implements c.a.r0.v.j.f.a, c.a.r0.v.j.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaPersonCenterModel f26125a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.v.j.d.c f26126b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v.j.b.d f26127c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f26128d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f26129e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f26130f;

    /* renamed from: g  reason: collision with root package name */
    public View f26131g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f26132h;

    /* renamed from: i  reason: collision with root package name */
    public g f26133i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26134j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public h q;
    public boolean r;
    public boolean s;

    /* renamed from: c.a.r0.v.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1220a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26135e;

        public View$OnClickListenerC1220a(a aVar) {
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
            this.f26135e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26135e.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26136a;

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
            this.f26136a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f26136a.f26125a == null) {
                return;
            }
            this.f26136a.f26125a.x();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26137e;

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
            this.f26137e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f26137e.f26128d.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26138e;

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
            this.f26138e = aVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f26138e.v();
                this.f26138e.u();
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
        this.f26128d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.ds400);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.f26125a = alaPersonCenterModel;
        alaPersonCenterModel.y(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // c.a.r0.v.j.e.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 1) {
            this.s = true;
        }
    }

    @Override // c.a.r0.v.j.f.a
    public void b(int i2, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, obj) == null) {
            g gVar = this.f26133i;
            if (gVar != null) {
                gVar.dettachView(this.f26131g);
            }
            this.f26130f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f26130f;
            if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
                return;
            }
            w();
        }
    }

    @Override // c.a.r0.v.j.f.a
    public void c(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i2) == null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof c.a.r0.v.j.d.c) && i2 == 1) {
            c.a.r0.v.j.d.c cVar = (c.a.r0.v.j.d.c) obj;
            this.f26126b = cVar;
            cVar.e(this.f26134j);
            this.f26133i.dettachView(this.f26131g);
            this.f26130f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f26126b == null) {
            return;
        }
        if (this.f26134j) {
            arrayList = new ArrayList(10);
            f fVar = new f();
            fVar.i(this.f26126b);
            arrayList.add(fVar);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                m mVar = new m();
                mVar.i(this.f26126b);
                arrayList.add(mVar);
            }
            j jVar = new j();
            jVar.i(this.f26126b);
            arrayList.add(jVar);
            k kVar = new k();
            kVar.i(this.f26126b);
            arrayList.add(kVar);
            if (this.f26126b.f26148h != null) {
                c.a.r0.v.j.d.d dVar = new c.a.r0.v.j.d.d();
                dVar.i(this.f26126b);
                arrayList.add(dVar);
            }
            c.a.r0.v.j.d.h hVar = new c.a.r0.v.j.d.h();
            hVar.i(this.f26126b);
            arrayList.add(hVar);
            l lVar = new l();
            lVar.i(this.f26126b);
            arrayList.add(lVar);
            c.a.r0.v.j.d.g gVar = new c.a.r0.v.j.d.g();
            gVar.i(this.f26126b);
            arrayList.add(gVar);
            e eVar = new e();
            eVar.i(this.f26126b);
            arrayList.add(eVar);
            o oVar = new o();
            oVar.i(this.f26126b);
            arrayList.add(oVar);
            n nVar = new n();
            nVar.i(this.f26126b);
            arrayList.add(nVar);
        } else {
            arrayList = new ArrayList(4);
            f fVar2 = new f();
            fVar2.i(this.f26126b);
            arrayList.add(fVar2);
        }
        this.f26127c.b(arrayList);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26131g : (View) invokeV.objValue;
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
            this.f26125a.setUid(str);
            this.f26134j = z;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26125a.x();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f26129e.onChangeSkinType(this.f26128d, i2);
            this.f26129e.getBackground().mutate().setAlpha(0);
            TextView textView = this.f26129e.mTextTitle;
            int i3 = R.color.CAM_X0101;
            SkinManager.setNavbarTitleColor(textView, i3, i3);
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            this.f26130f.setDivider(SkinManager.getDrawable(i2, R.color.CAM_X0204));
            this.f26130f.setDividerHeight(this.f26128d.getResources().getDimensionPixelSize(R.dimen.ds2));
            SkinManager.setBackgroundColor(this.f26131g, R.color.CAM_X0201);
            if (this.f26130f.getAdapter2() instanceof c.a.e.l.e.e) {
                this.f26130f.getAdapter2().notifyDataSetChanged();
                g gVar = this.f26133i;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                this.f26132h.onChangeSkinType(this.f26128d, i2);
                if (i2 == 1) {
                    this.f26129e.getBarBgView().setBackgroundColor(this.f26128d.getResources().getColor(R.color.CAM_X0207_1));
                    this.f26129e.getTopCoverBgView().setBackgroundColor(this.f26128d.getResources().getColor(R.color.CAM_X0201_1));
                } else if (i2 == 0) {
                    this.f26129e.getBarBgView().setBackgroundColor(this.f26128d.getResources().getColor(R.color.CAM_X0207));
                    this.f26129e.getTopCoverBgView().setBackgroundColor(this.f26128d.getResources().getColor(R.color.CAM_X0201));
                }
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            View inflate = View.inflate(context, R.layout.ala_person_center_layout, null);
            this.f26131g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.ala_person_center_navigation_bar);
            this.f26129e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.f26129e.showBottomLine(false);
            if (!this.o) {
                this.n = this.f26129e.setCenterTextTitle(this.f26128d.getString(R.string.ala_live));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f26128d.getResources().getString(R.string.forum));
                this.n = this.f26129e.setCenterTextTitle(sb.toString());
            }
            this.f26132h = (NoNetworkView) this.f26131g.findViewById(R.id.ala_person_center_no_network_view);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f26131g.findViewById(R.id.ala_person_center_listview);
            this.f26130f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f26130f.setVisibility(8);
            c.a.r0.v.j.b.d dVar = new c.a.r0.v.j.b.d(this.f26128d, this.f26130f, this);
            this.f26127c = dVar;
            dVar.f(this.o);
            if (this.o) {
                this.f26131g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            g gVar = new g(this.f26128d.getPageActivity());
            this.f26133i = gVar;
            gVar.attachView(this.f26131g, false);
            this.f26130f.setOnScrollListener(new d(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g gVar = this.f26133i;
            if (gVar != null) {
                gVar.m();
                this.f26133i.dettachView(this.f26131g);
            }
            AlaPersonCenterModel alaPersonCenterModel = this.f26125a;
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
        c.a.r0.v.j.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (dVar = this.f26127c) == null) {
            return;
        }
        dVar.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            c.a.r0.v.j.b.d dVar = this.f26127c;
            if (dVar != null) {
                dVar.d(str);
            }
            if (!this.o) {
                this.n = this.f26129e.setCenterTextTitle(this.f26128d.getString(R.string.ala_live));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f26128d.getResources().getString(R.string.forum));
            this.n = this.f26129e.setCenterTextTitle(sb.toString());
        }
    }

    public void t(String str) {
        c.a.r0.v.j.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (dVar = this.f26127c) == null) {
            return;
        }
        dVar.e(str);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || 2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.f26129e.getBarBgView().getAlpha();
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11 || this.f26130f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.f26128d.getResources().getDimension(R.dimen.ds98);
        int i2 = this.l - (-this.f26130f.getChildAt(0).getTop());
        if (i2 < dimension) {
            if (this.f26129e.getBarBgView().getAlpha() != 1.0f) {
                this.f26129e.getBarBgView().setAlpha(1.0f);
                this.f26129e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i2 >= dimension && i2 <= dimension * 2) {
            float f2 = 1.0f - (((i2 - dimension) * 1.0f) / dimension);
            this.f26129e.getBarBgView().setAlpha(f2);
            this.f26129e.getTopCoverBgView().setAlpha(1.0f - f2);
        } else if (i2 > dimension * 2 && this.f26129e.getBarBgView().getAlpha() != 0.0f) {
            this.f26129e.getBarBgView().setAlpha(0.0f);
            this.f26129e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f26130f.getFirstVisiblePosition() <= 0 || this.f26129e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.f26129e.getBarBgView().setAlpha(1.0f);
        this.f26129e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                h hVar = new h(this.f26128d.getPageActivity(), new View$OnClickListenerC1220a(this));
                this.q = hVar;
                hVar.m(null);
                this.q.g(null);
                this.q.j(this.f26128d.getResources().getDimensionPixelSize(R.dimen.ds340));
                this.q.o();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.l(null);
            this.q.m(this.f26128d.getResources().getString(R.string.refresh_view_title_text));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.f26131g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
