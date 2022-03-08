package c.a.r0.d4.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f16972b;

    /* renamed from: c  reason: collision with root package name */
    public View f16973c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f16974d;

    /* renamed from: e  reason: collision with root package name */
    public i f16975e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f16976f;

    /* renamed from: g  reason: collision with root package name */
    public g f16977g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f16978h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f16979i;

    /* renamed from: j  reason: collision with root package name */
    public d f16980j;
    public View.OnClickListener k;
    public c.a.d.c.g.a l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16981e;

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
            this.f16981e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f16981e.f16979i == null || this.f16981e.f16980j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f16981e.f16979i.getInUse()) {
                c.a.q0.r.f0.b.e(this.f16981e.a.getPageContext().getPageActivity(), 8);
            } else {
                this.f16981e.f16980j.e(this.f16981e.f16979i, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.a.f16979i.getPropsId()).param("obj_type", this.a.f16979i.getFreeUserLevel()));
                    this.a.f16979i.setInUse(true);
                    this.a.m();
                    c.a.q0.r.j0.b k = c.a.q0.r.j0.b.k();
                    k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.a.f16979i.getPropsId());
                    return;
                }
                int i2 = c.a.r0.d4.c.f16899b;
                if (responsedMessage.getError() == c.a.r0.d4.c.f16900c) {
                    i2 = c.a.r0.d4.c.a;
                }
                this.a.f16980j.d(i2, responsedMessage.getErrorString(), this.a.f16979i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1114392017, "Lc/a/r0/d4/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1114392017, "Lc/a/r0/d4/e/j;");
                return;
            }
        }
        m = n.f(TbadkApplication.getInst().getContext(), R.dimen.ds320);
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
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f16972b = inflate;
        this.a.setContentView(inflate);
        this.f16973c = this.f16972b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f16972b.findViewById(R.id.view_navigation_bar);
        this.f16974d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16974d.showBottomLine(false);
        this.f16976f = (BdExpandListView) this.a.findViewById(R.id.personcenter_list);
        this.f16978h = (SkinProgressView) this.f16972b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.a.getUniqueId());
        this.f16980j = dVar;
        dVar.c(this.a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f16972b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f16972b);
            this.f16973c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16972b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f16972b);
            NavigationBar navigationBar = this.f16974d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f16974d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f16976f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f16977g) == null) {
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
            c.a.r0.y3.g0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.r0.y3.g0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f16976f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16973c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f16972b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(m);
            this.a.showNetRefreshView(this.f16972b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f16979i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f16975e == null) {
                i iVar = new i(this.a);
                this.f16975e = iVar;
                iVar.e(dressItemData);
                this.f16976f.addHeaderView(this.f16975e.b());
                this.f16975e.d();
                this.f16976f.setExpandView(this.f16975e.b(), this.a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.a.getPageContext(), dressItemData);
                this.f16977g = gVar;
                this.f16976f.setAdapter((ListAdapter) gVar);
                i();
                this.a.registerListener(this.l);
            }
            this.f16978h.setDressData(this.f16979i);
            this.f16978h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f16979i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f16979i.getActivityFinish();
        this.f16978h.setFontSize(n.f(this.a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f16978h.updateStatuesInSkinDetail(0, 0.0f, this.f16979i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f16978h.updateStatuesInSkinDetail(9, 0.0f, this.f16979i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
