package c.a.p0.c0.l.c;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.p0.c0.l.d.e;
import c.a.p0.c0.l.d.f;
import c.a.p0.c0.l.d.j;
import c.a.p0.c0.l.d.k;
import c.a.p0.c0.l.d.l;
import c.a.p0.c0.l.d.m;
import c.a.p0.c0.l.d.n;
import c.a.p0.c0.l.d.o;
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
/* loaded from: classes2.dex */
public class a implements c.a.p0.c0.l.f.a, c.a.p0.c0.l.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.c0.l.d.c f13280b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.c0.l.b.d f13281c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f13282d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f13283e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f13284f;

    /* renamed from: g  reason: collision with root package name */
    public View f13285g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f13286h;
    public g i;
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

    /* renamed from: c.a.p0.c0.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1000a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1000a(a aVar) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null) {
                return;
            }
            this.a.a.loadData();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.f13282d.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.v();
                this.a.u();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f13282d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b0);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.z(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // c.a.p0.c0.l.e.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    @Override // c.a.p0.c0.l.f.a
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            g gVar = this.i;
            if (gVar != null) {
                gVar.dettachView(this.f13285g);
            }
            this.f13284f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f13284f;
            if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
                return;
            }
            w();
        }
    }

    @Override // c.a.p0.c0.l.f.a
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof c.a.p0.c0.l.d.c) && i == 1) {
            c.a.p0.c0.l.d.c cVar = (c.a.p0.c0.l.d.c) obj;
            this.f13280b = cVar;
            cVar.e(this.j);
            this.i.dettachView(this.f13285g);
            this.f13284f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f13280b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            f fVar = new f();
            fVar.g(this.f13280b);
            arrayList.add(fVar);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                m mVar = new m();
                mVar.g(this.f13280b);
                arrayList.add(mVar);
            }
            j jVar = new j();
            jVar.g(this.f13280b);
            arrayList.add(jVar);
            k kVar = new k();
            kVar.g(this.f13280b);
            arrayList.add(kVar);
            if (this.f13280b.f13293h != null) {
                c.a.p0.c0.l.d.d dVar = new c.a.p0.c0.l.d.d();
                dVar.g(this.f13280b);
                arrayList.add(dVar);
            }
            c.a.p0.c0.l.d.h hVar = new c.a.p0.c0.l.d.h();
            hVar.g(this.f13280b);
            arrayList.add(hVar);
            l lVar = new l();
            lVar.g(this.f13280b);
            arrayList.add(lVar);
            c.a.p0.c0.l.d.g gVar = new c.a.p0.c0.l.d.g();
            gVar.g(this.f13280b);
            arrayList.add(gVar);
            e eVar = new e();
            eVar.g(this.f13280b);
            arrayList.add(eVar);
            o oVar = new o();
            oVar.g(this.f13280b);
            arrayList.add(oVar);
            n nVar = new n();
            nVar.g(this.f13280b);
            arrayList.add(nVar);
        } else {
            arrayList = new ArrayList(4);
            f fVar2 = new f();
            fVar2.g(this.f13280b);
            arrayList.add(fVar2);
        }
        this.f13281c.b(arrayList);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13285g : (View) invokeV.objValue;
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
            this.a.setUid(str);
            this.j = z;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.loadData();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f13283e.onChangeSkinType(this.f13282d, i);
            this.f13283e.getBackground().mutate().setAlpha(0);
            SkinManager.setNavbarTitleColor(this.f13283e.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f081098);
            this.f13284f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f13284f.setDividerHeight(this.f13282d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.f13285g, R.color.CAM_X0201);
            if (this.f13284f.getAdapter2() instanceof c.a.d.o.e.e) {
                this.f13284f.getAdapter2().notifyDataSetChanged();
                g gVar = this.i;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                this.f13286h.c(this.f13282d, i);
                if (i == 1) {
                    this.f13283e.getBarBgView().setBackgroundColor(this.f13282d.getResources().getColor(R.color.CAM_X0207_1));
                    this.f13283e.getTopCoverBgView().setBackgroundColor(this.f13282d.getResources().getColor(R.color.CAM_X0201_1));
                } else if (i == 0) {
                    this.f13283e.getBarBgView().setBackgroundColor(this.f13282d.getResources().getColor(R.color.CAM_X0207));
                    this.f13283e.getTopCoverBgView().setBackgroundColor(this.f13282d.getResources().getColor(R.color.CAM_X0201));
                }
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d0105, null);
            this.f13285g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f09020c);
            this.f13283e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09246f);
            this.f13283e.showBottomLine(false);
            if (!this.o) {
                this.n = this.f13283e.setCenterTextTitle(this.f13282d.getString(R.string.obfuscated_res_0x7f0f021b));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f13282d.getResources().getString(R.string.obfuscated_res_0x7f0f063c));
                this.n = this.f13283e.setCenterTextTitle(sb.toString());
            }
            this.f13286h = (NoNetworkView) this.f13285g.findViewById(R.id.obfuscated_res_0x7f09020d);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f13285g.findViewById(R.id.obfuscated_res_0x7f09020b);
            this.f13284f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f13284f.setVisibility(8);
            c.a.p0.c0.l.b.d dVar = new c.a.p0.c0.l.b.d(this.f13282d, this.f13284f, this);
            this.f13281c = dVar;
            dVar.f(this.o);
            if (this.o) {
                this.f13285g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            g gVar = new g(this.f13282d.getPageActivity());
            this.i = gVar;
            gVar.attachView(this.f13285g, false);
            this.f13284f.setOnScrollListener(new d(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g gVar = this.i;
            if (gVar != null) {
                gVar.n();
                this.i.dettachView(this.f13285g);
            }
            AlaPersonCenterModel alaPersonCenterModel = this.a;
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
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            }
            this.n.setAlpha(f2);
            this.m.setAlpha(f2);
        }
    }

    public void r(String str) {
        c.a.p0.c0.l.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (dVar = this.f13281c) == null) {
            return;
        }
        dVar.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            c.a.p0.c0.l.b.d dVar = this.f13281c;
            if (dVar != null) {
                dVar.d(str);
            }
            if (!this.o) {
                this.n = this.f13283e.setCenterTextTitle(this.f13282d.getString(R.string.obfuscated_res_0x7f0f021b));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.f13282d.getResources().getString(R.string.obfuscated_res_0x7f0f063c));
            this.n = this.f13283e.setCenterTextTitle(sb.toString());
        }
    }

    public void t(String str) {
        c.a.p0.c0.l.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (dVar = this.f13281c) == null) {
            return;
        }
        dVar.e(str);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || 2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.f13283e.getBarBgView().getAlpha();
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11 || this.f13284f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.f13282d.getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        int i = this.l - (-this.f13284f.getChildAt(0).getTop());
        if (i < dimension) {
            if (this.f13283e.getBarBgView().getAlpha() != 1.0f) {
                this.f13283e.getBarBgView().setAlpha(1.0f);
                this.f13283e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= dimension && i <= dimension * 2) {
            float f2 = 1.0f - (((i - dimension) * 1.0f) / dimension);
            this.f13283e.getBarBgView().setAlpha(f2);
            this.f13283e.getTopCoverBgView().setAlpha(1.0f - f2);
        } else if (i > dimension * 2 && this.f13283e.getBarBgView().getAlpha() != 0.0f) {
            this.f13283e.getBarBgView().setAlpha(0.0f);
            this.f13283e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f13284f.getFirstVisiblePosition() <= 0 || this.f13283e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.f13283e.getBarBgView().setAlpha(1.0f);
        this.f13283e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                h hVar = new h(this.f13282d.getPageActivity(), new View$OnClickListenerC1000a(this));
                this.q = hVar;
                hVar.n(null);
                this.q.g(null);
                this.q.k(this.f13282d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029e));
                this.q.p();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.m(null);
            this.q.n(this.f13282d.getResources().getString(R.string.obfuscated_res_0x7f0f0f65));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.f13285g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
