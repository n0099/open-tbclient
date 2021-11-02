package b.a.r0.r3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f23163a;

    /* renamed from: b  reason: collision with root package name */
    public View f23164b;

    /* renamed from: c  reason: collision with root package name */
    public View f23165c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23166d;

    /* renamed from: e  reason: collision with root package name */
    public i f23167e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f23168f;

    /* renamed from: g  reason: collision with root package name */
    public g f23169g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f23170h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f23171i;
    public d j;
    public View.OnClickListener k;
    public b.a.e.c.g.a l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23172e;

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
            this.f23172e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23172e.f23171i == null || this.f23172e.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f23172e.f23171i.getInUse()) {
                b.a.q0.s.b0.b.e(this.f23172e.f23163a.getPageContext().getPageActivity(), 8);
            } else {
                this.f23172e.j.e(this.f23172e.f23171i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23173a;

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
            this.f23173a = jVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f23173a.f23171i.getPropsId()).param("obj_type", this.f23173a.f23171i.getFreeUserLevel()));
                    this.f23173a.f23171i.setInUse(true);
                    this.f23173a.m();
                    b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f23173a.f23171i.getPropsId());
                    return;
                }
                int i2 = b.a.r0.r3.c.f23080b;
                if (responsedMessage.getError() == b.a.r0.r3.c.f23081c) {
                    i2 = b.a.r0.r3.c.f23079a;
                }
                this.f23173a.j.d(i2, responsedMessage.getErrorString(), this.f23173a.f23171i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1097312897, "Lb/a/r0/r3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1097312897, "Lb/a/r0/r3/e/j;");
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
        this.f23163a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f23164b = inflate;
        this.f23163a.setContentView(inflate);
        this.f23165c = this.f23164b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23164b.findViewById(R.id.view_navigation_bar);
        this.f23166d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23166d.showBottomLine(false);
        this.f23168f = (BdExpandListView) this.f23163a.findViewById(R.id.personcenter_list);
        this.f23170h = (SkinProgressView) this.f23164b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f23163a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f23163a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f23164b, R.color.CAM_X0204);
            this.f23163a.hideNetRefreshView(this.f23164b);
            this.f23165c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23164b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f23163a.getPageContext(), this.f23164b);
            NavigationBar navigationBar = this.f23166d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23163a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f23166d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f23168f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f23169g) == null) {
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
            b.a.r0.l3.f0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f23168f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23165c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23164b, R.color.CAM_X0201);
            String string = this.f23163a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23163a.setNetRefreshViewTopMargin(m);
            this.f23163a.showNetRefreshView(this.f23164b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f23171i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f23167e == null) {
                i iVar = new i(this.f23163a);
                this.f23167e = iVar;
                iVar.e(dressItemData);
                this.f23168f.addHeaderView(this.f23167e.b());
                this.f23167e.d();
                this.f23168f.setExpandView(this.f23167e.b(), this.f23163a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f23163a.getPageContext(), dressItemData);
                this.f23169g = gVar;
                this.f23168f.setAdapter((ListAdapter) gVar);
                i();
                this.f23163a.registerListener(this.l);
            }
            this.f23170h.setDressData(this.f23171i);
            this.f23170h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f23171i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f23171i.getActivityFinish();
        this.f23170h.setFontSize(l.g(this.f23163a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f23170h.updateStatuesInSkinDetail(0, 0.0f, this.f23171i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f23170h.updateStatuesInSkinDetail(9, 0.0f, this.f23171i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
