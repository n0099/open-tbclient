package c.a.t0.m3.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19996b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19997c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19998d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19999e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f20000f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20001g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20002h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f20003i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20004j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20005k;
    public BdSwitchView.b l;

    /* renamed from: c.a.t0.m3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1201a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20006e;

        public C1201a(a aVar) {
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
            this.f20006e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f20006e.f20000f) {
                    this.f20006e.f20005k = switchState == BdSwitchView.SwitchState.ON;
                    this.f20006e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f20006e.f20003i) {
                    this.f20006e.f20004j = switchState == BdSwitchView.SwitchState.ON;
                    this.f20006e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f20006e.f20000f ? 2 : 1));
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
        this.l = new C1201a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19996b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f19996b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f19997c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f19997c.showBottomLine();
            this.f19997c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19998d = (TextView) this.f19996b.findViewById(R.id.inside_text);
            this.f19999e = (TextView) this.f19996b.findViewById(R.id.inside_desc);
            this.f20000f = (BdSwitchView) this.f19996b.findViewById(R.id.inside_switch);
            this.f20001g = (TextView) this.f19996b.findViewById(R.id.outside_text);
            this.f20002h = (TextView) this.f19996b.findViewById(R.id.outside_desc);
            this.f20003i = (BdSwitchView) this.f19996b.findViewById(R.id.outside_switch);
            this.f19998d.setText(R.string.mark_show_inside);
            this.f19999e.setText(R.string.mark_show_everywhere);
            this.f20001g.setText(R.string.mark_show_outside);
            this.f20002h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f20003i.turnOffNoCallback();
            } else {
                this.f20003i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f20000f.turnOffNoCallback();
            } else {
                this.f20000f.turnOnNoCallback();
            }
            this.f20004j = i3 != 3;
            this.f20005k = i4 != 3;
            this.f20000f.setOnSwitchStateChangeListener(this.l);
            this.f20003i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19998d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19999e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f20001g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f20002h, R.color.CAM_X0109);
            this.f19997c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.f20005k;
            this.f20005k = z;
            if (z) {
                this.f20000f.turnOnNoCallback();
            } else {
                this.f20000f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f20004j;
            this.f20004j = z;
            if (z) {
                this.f20003i.turnOnNoCallback();
            } else {
                this.f20003i.turnOffNoCallback();
            }
        }
    }
}
