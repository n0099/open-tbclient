package c.a.p0.f4.e;

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
    public View f15054b;

    /* renamed from: c  reason: collision with root package name */
    public View f15055c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15056d;

    /* renamed from: e  reason: collision with root package name */
    public i f15057e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f15058f;

    /* renamed from: g  reason: collision with root package name */
    public g f15059g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f15060h;
    public DressItemData i;
    public d j;
    public View.OnClickListener k;
    public c.a.d.c.g.a l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.i == null || this.a.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.a.i.getInUse()) {
                c.a.o0.r.f0.b.e(this.a.a.getPageContext().getPageActivity(), 8);
            } else {
                this.a.j.e(this.a.i, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.a.i.getPropsId()).param("obj_type", this.a.i.getFreeUserLevel()));
                    this.a.i.setInUse(true);
                    this.a.m();
                    c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
                    k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.a.i.getPropsId());
                    return;
                }
                int i = c.a.p0.f4.c.f14994b;
                if (responsedMessage.getError() == c.a.p0.f4.c.f14995c) {
                    i = c.a.p0.f4.c.a;
                }
                this.a.j.d(i, responsedMessage.getErrorString(), this.a.i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1053642355, "Lc/a/p0/f4/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1053642355, "Lc/a/p0/f4/e/j;");
                return;
            }
        }
        m = n.f(TbadkApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070297);
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0131, (ViewGroup) null);
        this.f15054b = inflate;
        this.a.setContentView(inflate);
        this.f15055c = this.f15054b.findViewById(R.id.obfuscated_res_0x7f090392);
        NavigationBar navigationBar = (NavigationBar) this.f15054b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15056d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15056d.showBottomLine(false);
        this.f15058f = (BdExpandListView) this.a.findViewById(R.id.obfuscated_res_0x7f09181c);
        this.f15060h = (SkinProgressView) this.f15054b.findViewById(R.id.obfuscated_res_0x7f0923b0);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.a.getUniqueId());
        this.j = dVar;
        dVar.c(this.a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f15054b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15054b);
            this.f15055c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15054b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f15054b);
            NavigationBar navigationBar = this.f15056d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f15056d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f15058f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f15059g) == null) {
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
            c.a.p0.a4.g0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.p0.a4.g0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15058f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15055c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15054b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.setNetRefreshViewTopMargin(m);
            this.a.showNetRefreshView(this.f15054b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f15057e == null) {
                i iVar = new i(this.a);
                this.f15057e = iVar;
                iVar.e(dressItemData);
                this.f15058f.addHeaderView(this.f15057e.b());
                this.f15057e.d();
                this.f15058f.setExpandView(this.f15057e.b(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b0));
                g gVar = new g(this.a.getPageContext(), dressItemData);
                this.f15059g = gVar;
                this.f15058f.setAdapter((ListAdapter) gVar);
                i();
                this.a.registerListener(this.l);
            }
            this.f15060h.setDressData(this.i);
            this.f15060h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.i.getActivityFinish();
        this.f15060h.setFontSize(n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b7));
        if (inUse) {
            this.f15060h.b(0, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f15060h.b(9, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
