package c.a.r0.q3.e;

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
    public BackgroundPreviewActivity f24147a;

    /* renamed from: b  reason: collision with root package name */
    public View f24148b;

    /* renamed from: c  reason: collision with root package name */
    public View f24149c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24150d;

    /* renamed from: e  reason: collision with root package name */
    public i f24151e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f24152f;

    /* renamed from: g  reason: collision with root package name */
    public g f24153g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f24154h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f24155i;

    /* renamed from: j  reason: collision with root package name */
    public d f24156j;
    public View.OnClickListener k;
    public c.a.e.c.g.a l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f24157e;

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
            this.f24157e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f24157e.f24155i == null || this.f24157e.f24156j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f24157e.f24155i.getInUse()) {
                c.a.q0.s.a0.b.e(this.f24157e.f24147a.getPageContext().getPageActivity(), 8);
            } else {
                this.f24157e.f24156j.e(this.f24157e.f24155i, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f24158a;

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
            this.f24158a = jVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f24158a.f24155i.getPropsId()).param("obj_type", this.f24158a.f24155i.getFreeUserLevel()));
                    this.f24158a.f24155i.setInUse(true);
                    this.f24158a.m();
                    c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                    j2.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f24158a.f24155i.getPropsId());
                    return;
                }
                int i2 = c.a.r0.q3.c.f24061b;
                if (responsedMessage.getError() == c.a.r0.q3.c.f24062c) {
                    i2 = c.a.r0.q3.c.f24060a;
                }
                this.f24158a.f24156j.d(i2, responsedMessage.getErrorString(), this.f24158a.f24155i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1804592093, "Lc/a/r0/q3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1804592093, "Lc/a/r0/q3/e/j;");
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
        this.f24147a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f24148b = inflate;
        this.f24147a.setContentView(inflate);
        this.f24149c = this.f24148b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f24148b.findViewById(R.id.view_navigation_bar);
        this.f24150d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24150d.showBottomLine(false);
        this.f24152f = (BdExpandListView) this.f24147a.findViewById(R.id.personcenter_list);
        this.f24154h = (SkinProgressView) this.f24148b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f24147a.getUniqueId());
        this.f24156j = dVar;
        dVar.c(this.f24147a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f24148b, R.color.CAM_X0204);
            this.f24147a.hideNetRefreshView(this.f24148b);
            this.f24149c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24148b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f24147a.getPageContext(), this.f24148b);
            NavigationBar navigationBar = this.f24150d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24147a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f24150d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f24152f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f24153g) == null) {
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
            c.a.r0.k3.e0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.r0.k3.e0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f24152f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24149c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24148b, R.color.CAM_X0201);
            String string = this.f24147a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24147a.setNetRefreshViewTopMargin(m);
            this.f24147a.showNetRefreshView(this.f24148b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f24155i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f24151e == null) {
                i iVar = new i(this.f24147a);
                this.f24151e = iVar;
                iVar.e(dressItemData);
                this.f24152f.addHeaderView(this.f24151e.b());
                this.f24151e.d();
                this.f24152f.setExpandView(this.f24151e.b(), this.f24147a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f24147a.getPageContext(), dressItemData);
                this.f24153g = gVar;
                this.f24152f.setAdapter((ListAdapter) gVar);
                i();
                this.f24147a.registerListener(this.l);
            }
            this.f24154h.setDressData(this.f24155i);
            this.f24154h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f24155i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f24155i.getActivityFinish();
        this.f24154h.setFontSize(l.g(this.f24147a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f24154h.updateStatuesInSkinDetail(0, 0.0f, this.f24155i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f24154h.updateStatuesInSkinDetail(9, 0.0f, this.f24155i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
