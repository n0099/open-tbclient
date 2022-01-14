package c.a.t0.c4.e;

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
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15558b;

    /* renamed from: c  reason: collision with root package name */
    public View f15559c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15560d;

    /* renamed from: e  reason: collision with root package name */
    public i f15561e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f15562f;

    /* renamed from: g  reason: collision with root package name */
    public g f15563g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f15564h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f15565i;

    /* renamed from: j  reason: collision with root package name */
    public d f15566j;
    public View.OnClickListener k;
    public c.a.d.c.g.a l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f15567e;

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
            this.f15567e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f15567e.f15565i == null || this.f15567e.f15566j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f15567e.f15565i.getInUse()) {
                c.a.s0.s.d0.b.e(this.f15567e.a.getPageContext().getPageActivity(), 8);
            } else {
                this.f15567e.f15566j.e(this.f15567e.f15565i, true);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.a.f15565i.getPropsId()).param("obj_type", this.a.f15565i.getFreeUserLevel()));
                    this.a.f15565i.setInUse(true);
                    this.a.m();
                    c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
                    k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.a.f15565i.getPropsId());
                    return;
                }
                int i2 = c.a.t0.c4.c.f15485b;
                if (responsedMessage.getError() == c.a.t0.c4.c.f15486c) {
                    i2 = c.a.t0.c4.c.a;
                }
                this.a.f15566j.d(i2, responsedMessage.getErrorString(), this.a.f15565i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1900044588, "Lc/a/t0/c4/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1900044588, "Lc/a/t0/c4/e/j;");
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
        this.f15558b = inflate;
        this.a.setContentView(inflate);
        this.f15559c = this.f15558b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f15558b.findViewById(R.id.view_navigation_bar);
        this.f15560d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15560d.showBottomLine(false);
        this.f15562f = (BdExpandListView) this.a.findViewById(R.id.personcenter_list);
        this.f15564h = (SkinProgressView) this.f15558b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.a.getUniqueId());
        this.f15566j = dVar;
        dVar.c(this.a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f15558b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15558b);
            this.f15559c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15558b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f15558b);
            NavigationBar navigationBar = this.f15560d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f15560d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f15562f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f15563g) == null) {
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
            c.a.t0.w3.f0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.t0.w3.f0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15562f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15559c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15558b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(m);
            this.a.showNetRefreshView(this.f15558b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f15565i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f15561e == null) {
                i iVar = new i(this.a);
                this.f15561e = iVar;
                iVar.e(dressItemData);
                this.f15562f.addHeaderView(this.f15561e.b());
                this.f15561e.d();
                this.f15562f.setExpandView(this.f15561e.b(), this.a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.a.getPageContext(), dressItemData);
                this.f15563g = gVar;
                this.f15562f.setAdapter((ListAdapter) gVar);
                i();
                this.a.registerListener(this.l);
            }
            this.f15564h.setDressData(this.f15565i);
            this.f15564h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f15565i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f15565i.getActivityFinish();
        this.f15564h.setFontSize(n.f(this.a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f15564h.updateStatuesInSkinDetail(0, 0.0f, this.f15565i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f15564h.updateStatuesInSkinDetail(9, 0.0f, this.f15565i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
