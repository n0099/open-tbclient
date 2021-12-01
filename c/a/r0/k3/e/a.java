package c.a.r0.k3.e;

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
/* loaded from: classes6.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f18781b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f18782c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18783d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18784e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f18785f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18786g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18787h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f18788i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18789j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18790k;
    public BdSwitchView.b l;

    /* renamed from: c.a.r0.k3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1107a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18791e;

        public C1107a(a aVar) {
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
            this.f18791e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f18791e.f18785f) {
                    this.f18791e.f18790k = switchState == BdSwitchView.SwitchState.ON;
                    this.f18791e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f18791e.f18788i) {
                    this.f18791e.f18789j = switchState == BdSwitchView.SwitchState.ON;
                    this.f18791e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f18791e.f18785f ? 2 : 1));
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
        this.l = new C1107a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18781b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f18781b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f18782c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f18782c.showBottomLine();
            this.f18782c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18783d = (TextView) this.f18781b.findViewById(R.id.inside_text);
            this.f18784e = (TextView) this.f18781b.findViewById(R.id.inside_desc);
            this.f18785f = (BdSwitchView) this.f18781b.findViewById(R.id.inside_switch);
            this.f18786g = (TextView) this.f18781b.findViewById(R.id.outside_text);
            this.f18787h = (TextView) this.f18781b.findViewById(R.id.outside_desc);
            this.f18788i = (BdSwitchView) this.f18781b.findViewById(R.id.outside_switch);
            this.f18783d.setText(R.string.mark_show_inside);
            this.f18784e.setText(R.string.mark_show_everywhere);
            this.f18786g.setText(R.string.mark_show_outside);
            this.f18787h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f18788i.turnOffNoCallback();
            } else {
                this.f18788i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f18785f.turnOffNoCallback();
            } else {
                this.f18785f.turnOnNoCallback();
            }
            this.f18789j = i3 != 3;
            this.f18790k = i4 != 3;
            this.f18785f.setOnSwitchStateChangeListener(this.l);
            this.f18788i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f18783d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18784e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f18786g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f18787h, R.color.CAM_X0109);
            this.f18782c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.f18790k;
            this.f18790k = z;
            if (z) {
                this.f18785f.turnOnNoCallback();
            } else {
                this.f18785f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f18789j;
            this.f18789j = z;
            if (z) {
                this.f18788i.turnOnNoCallback();
            } else {
                this.f18788i.turnOffNoCallback();
            }
        }
    }
}
