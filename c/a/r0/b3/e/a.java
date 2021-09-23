package c.a.r0.b3.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.d;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f<?> f16127a;

    /* renamed from: b  reason: collision with root package name */
    public View f16128b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16129c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16130d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16131e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f16132f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16133g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16134h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f16135i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16136j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: c.a.r0.b3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0767a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16137e;

        public C0767a(a aVar) {
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
            this.f16137e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f16137e.f16132f) {
                    this.f16137e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f16137e.f16127a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f16137e.f16135i) {
                    this.f16137e.f16136j = switchState == BdSwitchView.SwitchState.ON;
                    this.f16137e.f16127a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f16137e.f16132f ? 2 : 1));
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
        this.l = new C0767a(this);
        this.f16127a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16128b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f16128b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f16129c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f16129c.showBottomLine();
            this.f16129c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16130d = (TextView) this.f16128b.findViewById(R.id.inside_text);
            this.f16131e = (TextView) this.f16128b.findViewById(R.id.inside_desc);
            this.f16132f = (BdSwitchView) this.f16128b.findViewById(R.id.inside_switch);
            this.f16133g = (TextView) this.f16128b.findViewById(R.id.outside_text);
            this.f16134h = (TextView) this.f16128b.findViewById(R.id.outside_desc);
            this.f16135i = (BdSwitchView) this.f16128b.findViewById(R.id.outside_switch);
            this.f16130d.setText(R.string.mark_show_inside);
            this.f16131e.setText(R.string.mark_show_everywhere);
            this.f16133g.setText(R.string.mark_show_outside);
            this.f16134h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f16135i.turnOffNoCallback();
            } else {
                this.f16135i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f16132f.turnOffNoCallback();
            } else {
                this.f16132f.turnOnNoCallback();
            }
            this.f16136j = i3 != 3;
            this.k = i4 != 3;
            this.f16132f.setOnSwitchStateChangeListener(this.l);
            this.f16135i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f16130d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16131e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f16133g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16134h, R.color.CAM_X0109);
            this.f16129c.onChangeSkinType(this.f16127a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f16132f.turnOnNoCallback();
            } else {
                this.f16132f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f16136j;
            this.f16136j = z;
            if (z) {
                this.f16135i.turnOnNoCallback();
            } else {
                this.f16135i.turnOffNoCallback();
            }
        }
    }
}
