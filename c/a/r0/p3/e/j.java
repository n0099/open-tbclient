package c.a.r0.p3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f23956a;

    /* renamed from: b  reason: collision with root package name */
    public View f23957b;

    /* renamed from: c  reason: collision with root package name */
    public View f23958c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23959d;

    /* renamed from: e  reason: collision with root package name */
    public i f23960e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f23961f;

    /* renamed from: g  reason: collision with root package name */
    public g f23962g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f23963h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f23964i;

    /* renamed from: j  reason: collision with root package name */
    public d f23965j;
    public View.OnClickListener k;
    public c.a.e.c.g.a l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23966e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23966e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23966e.f23964i == null || this.f23966e.f23965j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f23966e.f23964i.getInUse()) {
                c.a.q0.s.a0.b.e(this.f23966e.f23956a.getPageContext().getPageActivity(), 8);
            } else {
                this.f23966e.f23965j.e(this.f23966e.f23964i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23967a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23967a = jVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f23967a.f23964i.getPropsId()).param("obj_type", this.f23967a.f23964i.getFreeUserLevel()));
                    this.f23967a.f23964i.setInUse(true);
                    this.f23967a.m();
                    c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                    j2.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f23967a.f23964i.getPropsId());
                    return;
                }
                int i2 = c.a.r0.p3.c.f23870b;
                if (responsedMessage.getError() == c.a.r0.p3.c.f23871c) {
                    i2 = c.a.r0.p3.c.f23869a;
                }
                this.f23967a.f23965j.d(i2, responsedMessage.getErrorString(), this.f23967a.f23964i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(917088412, "Lc/a/r0/p3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(917088412, "Lc/a/r0/p3/e/j;");
                return;
            }
        }
        m = l.g(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f23956a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f23957b = inflate;
        this.f23956a.setContentView(inflate);
        this.f23958c = this.f23957b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23957b.findViewById(R.id.view_navigation_bar);
        this.f23959d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23959d.showBottomLine(false);
        this.f23961f = (BdExpandListView) this.f23956a.findViewById(R.id.personcenter_list);
        this.f23963h = (SkinProgressView) this.f23957b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f23956a.getUniqueId());
        this.f23965j = dVar;
        dVar.c(this.f23956a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f23957b, R.color.CAM_X0204);
            this.f23956a.hideNetRefreshView(this.f23957b);
            this.f23958c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23957b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f23956a.getPageContext(), this.f23957b);
            NavigationBar navigationBar = this.f23959d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23956a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f23959d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f23961f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f23962g) == null) {
                return;
            }
            gVar.notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.j3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.r0.j3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f23961f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23958c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23957b, R.color.CAM_X0201);
            String string = this.f23956a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23956a.setNetRefreshViewTopMargin(m);
            this.f23956a.showNetRefreshView(this.f23957b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f23964i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f23960e == null) {
                i iVar = new i(this.f23956a);
                this.f23960e = iVar;
                iVar.e(dressItemData);
                this.f23961f.addHeaderView(this.f23960e.b());
                this.f23960e.d();
                this.f23961f.setExpandView(this.f23960e.b(), this.f23956a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f23956a.getPageContext(), dressItemData);
                this.f23962g = gVar;
                this.f23961f.setAdapter((ListAdapter) gVar);
                i();
                this.f23956a.registerListener(this.l);
            }
            this.f23963h.setDressData(this.f23964i);
            this.f23963h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f23964i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f23964i.getActivityFinish();
        this.f23963h.setFontSize(l.g(this.f23956a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f23963h.updateStatuesInSkinDetail(0, 0.0f, this.f23964i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f23963h.updateStatuesInSkinDetail(9, 0.0f, this.f23964i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
