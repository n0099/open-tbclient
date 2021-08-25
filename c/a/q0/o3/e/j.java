package c.a.q0.o3.e;

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
    public BackgroundPreviewActivity f23366a;

    /* renamed from: b  reason: collision with root package name */
    public View f23367b;

    /* renamed from: c  reason: collision with root package name */
    public View f23368c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23369d;

    /* renamed from: e  reason: collision with root package name */
    public i f23370e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f23371f;

    /* renamed from: g  reason: collision with root package name */
    public g f23372g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f23373h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f23374i;

    /* renamed from: j  reason: collision with root package name */
    public d f23375j;
    public View.OnClickListener k;
    public c.a.e.c.g.a l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23376e;

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
            this.f23376e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23376e.f23374i == null || this.f23376e.f23375j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f23376e.f23374i.getInUse()) {
                c.a.p0.s.a0.b.e(this.f23376e.f23366a.getPageContext().getPageActivity(), 8);
            } else {
                this.f23376e.f23375j.e(this.f23376e.f23374i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23377a;

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
            this.f23377a = jVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f23377a.f23374i.getPropsId()).param("obj_type", this.f23377a.f23374i.getFreeUserLevel()));
                    this.f23377a.f23374i.setInUse(true);
                    this.f23377a.m();
                    c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                    j2.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f23377a.f23374i.getPropsId());
                    return;
                }
                int i2 = c.a.q0.o3.c.f23280b;
                if (responsedMessage.getError() == c.a.q0.o3.c.f23281c) {
                    i2 = c.a.q0.o3.c.f23279a;
                }
                this.f23377a.f23375j.d(i2, responsedMessage.getErrorString(), this.f23377a.f23374i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(226098236, "Lc/a/q0/o3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(226098236, "Lc/a/q0/o3/e/j;");
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
        this.f23366a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f23367b = inflate;
        this.f23366a.setContentView(inflate);
        this.f23368c = this.f23367b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23367b.findViewById(R.id.view_navigation_bar);
        this.f23369d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23369d.showBottomLine(false);
        this.f23371f = (BdExpandListView) this.f23366a.findViewById(R.id.personcenter_list);
        this.f23373h = (SkinProgressView) this.f23367b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f23366a.getUniqueId());
        this.f23375j = dVar;
        dVar.c(this.f23366a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f23367b, R.color.CAM_X0204);
            this.f23366a.hideNetRefreshView(this.f23367b);
            this.f23368c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23367b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f23366a.getPageContext(), this.f23367b);
            NavigationBar navigationBar = this.f23369d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23366a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f23369d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f23371f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f23372g) == null) {
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
            c.a.q0.i3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.q0.i3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f23371f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23368c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23367b, R.color.CAM_X0201);
            String string = this.f23366a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23366a.setNetRefreshViewTopMargin(m);
            this.f23366a.showNetRefreshView(this.f23367b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f23374i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f23370e == null) {
                i iVar = new i(this.f23366a);
                this.f23370e = iVar;
                iVar.e(dressItemData);
                this.f23371f.addHeaderView(this.f23370e.b());
                this.f23370e.d();
                this.f23371f.setExpandView(this.f23370e.b(), this.f23366a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f23366a.getPageContext(), dressItemData);
                this.f23372g = gVar;
                this.f23371f.setAdapter((ListAdapter) gVar);
                i();
                this.f23366a.registerListener(this.l);
            }
            this.f23373h.setDressData(this.f23374i);
            this.f23373h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f23374i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f23374i.getActivityFinish();
        this.f23373h.setFontSize(l.g(this.f23366a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f23373h.updateStatuesInSkinDetail(0, 0.0f, this.f23374i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f23373h.updateStatuesInSkinDetail(9, 0.0f, this.f23374i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
