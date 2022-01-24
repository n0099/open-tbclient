package c.a.t0.n3.n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.t0.n3.b;
import c.a.t0.n3.e;
import c.a.t0.n3.g;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19863b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19864c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19865d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19866e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f19867f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19868g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19869h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f19870i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19871j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: c.a.t0.n3.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1233a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19872e;

        public C1233a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19872e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f19872e.f19867f) {
                    this.f19872e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f19872e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f19872e.f19870i) {
                    this.f19872e.f19871j = switchState == BdSwitchView.SwitchState.ON;
                    this.f19872e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f19872e.f19867f ? 2 : 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new C1233a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19863b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.t0.n3.f.privacy_mark_activity, (ViewGroup) null);
            this.f19863b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(e.navigation_bar);
            this.f19864c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(g.privacy_mark_setting));
            this.f19864c.showBottomLine();
            this.f19864c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19865d = (TextView) this.f19863b.findViewById(e.inside_text);
            this.f19866e = (TextView) this.f19863b.findViewById(e.inside_desc);
            this.f19867f = (BdSwitchView) this.f19863b.findViewById(e.inside_switch);
            this.f19868g = (TextView) this.f19863b.findViewById(e.outside_text);
            this.f19869h = (TextView) this.f19863b.findViewById(e.outside_desc);
            this.f19870i = (BdSwitchView) this.f19863b.findViewById(e.outside_switch);
            this.f19865d.setText(g.mark_show_inside);
            this.f19866e.setText(g.mark_show_everywhere);
            this.f19868g.setText(g.mark_show_outside);
            this.f19869h.setText(g.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f19870i.turnOffNoCallback();
            } else {
                this.f19870i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f19867f.turnOffNoCallback();
            } else {
                this.f19867f.turnOnNoCallback();
            }
            this.f19871j = i3 != 3;
            this.k = i4 != 3;
            this.f19867f.setOnSwitchStateChangeListener(this.l);
            this.f19870i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19865d, b.CAM_X0105);
            SkinManager.setViewTextColor(this.f19866e, b.CAM_X0109);
            SkinManager.setViewTextColor(this.f19868g, b.CAM_X0105);
            SkinManager.setViewTextColor(this.f19869h, b.CAM_X0109);
            this.f19864c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f19867f.turnOnNoCallback();
            } else {
                this.f19867f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f19871j;
            this.f19871j = z;
            if (z) {
                this.f19870i.turnOnNoCallback();
            } else {
                this.f19870i.turnOffNoCallback();
            }
        }
    }
}
