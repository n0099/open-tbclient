package b.a.r0.s3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
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
    public BackgroundPreviewActivity f24950a;

    /* renamed from: b  reason: collision with root package name */
    public View f24951b;

    /* renamed from: c  reason: collision with root package name */
    public View f24952c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24953d;

    /* renamed from: e  reason: collision with root package name */
    public i f24954e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f24955f;

    /* renamed from: g  reason: collision with root package name */
    public g f24956g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f24957h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f24958i;
    public d j;
    public View.OnClickListener k;
    public b.a.e.c.g.a l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f24959e;

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
            this.f24959e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f24959e.f24958i == null || this.f24959e.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f24959e.f24958i.getInUse()) {
                b.a.q0.s.b0.b.e(this.f24959e.f24950a.getPageContext().getPageActivity(), 8);
            } else {
                this.f24959e.j.e(this.f24959e.f24958i, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f24960a;

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
            this.f24960a = jVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f24960a.f24958i.getPropsId()).param("obj_type", this.f24960a.f24958i.getFreeUserLevel()));
                    this.f24960a.f24958i.setInUse(true);
                    this.f24960a.m();
                    b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f24960a.f24958i.getPropsId());
                    return;
                }
                int i2 = b.a.r0.s3.c.f24867b;
                if (responsedMessage.getError() == b.a.r0.s3.c.f24868c) {
                    i2 = b.a.r0.s3.c.f24866a;
                }
                this.f24960a.j.d(i2, responsedMessage.getErrorString(), this.f24960a.f24958i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-209809216, "Lb/a/r0/s3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-209809216, "Lb/a/r0/s3/e/j;");
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
        this.f24950a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f24951b = inflate;
        this.f24950a.setContentView(inflate);
        this.f24952c = this.f24951b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f24951b.findViewById(R.id.view_navigation_bar);
        this.f24953d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24953d.showBottomLine(false);
        this.f24955f = (BdExpandListView) this.f24950a.findViewById(R.id.personcenter_list);
        this.f24957h = (SkinProgressView) this.f24951b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f24950a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f24950a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f24951b, R.color.CAM_X0204);
            this.f24950a.hideNetRefreshView(this.f24951b);
            this.f24952c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24951b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.v0.a.a(this.f24950a.getPageContext(), this.f24951b);
            NavigationBar navigationBar = this.f24953d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24950a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f24953d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f24955f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f24956g) == null) {
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
            b.a.r0.m3.f0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            b.a.r0.m3.f0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f24955f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24952c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24951b, R.color.CAM_X0201);
            String string = this.f24950a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24950a.setNetRefreshViewTopMargin(m);
            this.f24950a.showNetRefreshView(this.f24951b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f24958i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f24954e == null) {
                i iVar = new i(this.f24950a);
                this.f24954e = iVar;
                iVar.e(dressItemData);
                this.f24955f.addHeaderView(this.f24954e.b());
                this.f24954e.d();
                this.f24955f.setExpandView(this.f24954e.b(), this.f24950a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f24950a.getPageContext(), dressItemData);
                this.f24956g = gVar;
                this.f24955f.setAdapter((ListAdapter) gVar);
                i();
                this.f24950a.registerListener(this.l);
            }
            this.f24957h.setDressData(this.f24958i);
            this.f24957h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f24958i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f24958i.getActivityFinish();
        this.f24957h.setFontSize(l.g(this.f24950a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f24957h.updateStatuesInSkinDetail(0, 0.0f, this.f24958i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f24957h.updateStatuesInSkinDetail(9, 0.0f, this.f24958i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
