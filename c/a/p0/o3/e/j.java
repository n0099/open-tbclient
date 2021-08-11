package c.a.p0.o3.e;

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
    public BackgroundPreviewActivity f23034a;

    /* renamed from: b  reason: collision with root package name */
    public View f23035b;

    /* renamed from: c  reason: collision with root package name */
    public View f23036c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23037d;

    /* renamed from: e  reason: collision with root package name */
    public i f23038e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f23039f;

    /* renamed from: g  reason: collision with root package name */
    public g f23040g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f23041h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f23042i;

    /* renamed from: j  reason: collision with root package name */
    public d f23043j;
    public View.OnClickListener k;
    public c.a.e.c.g.a l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23044e;

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
            this.f23044e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23044e.f23042i == null || this.f23044e.f23043j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f23044e.f23042i.getInUse()) {
                c.a.o0.s.a0.b.e(this.f23044e.f23034a.getPageContext().getPageActivity(), 8);
            } else {
                this.f23044e.f23043j.e(this.f23044e.f23042i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23045a;

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
            this.f23045a = jVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f23045a.f23042i.getPropsId()).param("obj_type", this.f23045a.f23042i.getFreeUserLevel()));
                    this.f23045a.f23042i.setInUse(true);
                    this.f23045a.m();
                    c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
                    j2.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f23045a.f23042i.getPropsId());
                    return;
                }
                int i2 = c.a.p0.o3.c.f22948b;
                if (responsedMessage.getError() == c.a.p0.o3.c.f22949c) {
                    i2 = c.a.p0.o3.c.f22947a;
                }
                this.f23045a.f23043j.d(i2, responsedMessage.getErrorString(), this.f23045a.f23042i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(422611741, "Lc/a/p0/o3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(422611741, "Lc/a/p0/o3/e/j;");
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
        this.f23034a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f23035b = inflate;
        this.f23034a.setContentView(inflate);
        this.f23036c = this.f23035b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23035b.findViewById(R.id.view_navigation_bar);
        this.f23037d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23037d.showBottomLine(false);
        this.f23039f = (BdExpandListView) this.f23034a.findViewById(R.id.personcenter_list);
        this.f23041h = (SkinProgressView) this.f23035b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f23034a.getUniqueId());
        this.f23043j = dVar;
        dVar.c(this.f23034a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f23035b, R.color.CAM_X0204);
            this.f23034a.hideNetRefreshView(this.f23035b);
            this.f23036c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23035b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.u0.a.a(this.f23034a.getPageContext(), this.f23035b);
            NavigationBar navigationBar = this.f23037d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23034a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f23037d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f23039f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f23040g) == null) {
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
            c.a.p0.i3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.p0.i3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f23039f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23036c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23035b, R.color.CAM_X0201);
            String string = this.f23034a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23034a.setNetRefreshViewTopMargin(m);
            this.f23034a.showNetRefreshView(this.f23035b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f23042i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f23038e == null) {
                i iVar = new i(this.f23034a);
                this.f23038e = iVar;
                iVar.e(dressItemData);
                this.f23039f.addHeaderView(this.f23038e.b());
                this.f23038e.d();
                this.f23039f.setExpandView(this.f23038e.b(), this.f23034a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f23034a.getPageContext(), dressItemData);
                this.f23040g = gVar;
                this.f23039f.setAdapter((ListAdapter) gVar);
                i();
                this.f23034a.registerListener(this.l);
            }
            this.f23041h.setDressData(this.f23042i);
            this.f23041h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f23042i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f23042i.getActivityFinish();
        this.f23041h.setFontSize(l.g(this.f23034a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f23041h.updateStatuesInSkinDetail(0, 0.0f, this.f23042i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f23041h.updateStatuesInSkinDetail(9, 0.0f, this.f23042i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
