package c.a.r0.n3.e;

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
/* loaded from: classes2.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19496b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19497c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19498d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19499e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f19500f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19501g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19502h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f19503i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19504j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: c.a.r0.n3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1221a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19505e;

        public C1221a(a aVar) {
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
            this.f19505e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f19505e.f19500f) {
                    this.f19505e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f19505e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f19505e.f19503i) {
                    this.f19505e.f19504j = switchState == BdSwitchView.SwitchState.ON;
                    this.f19505e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f19505e.f19500f ? 2 : 1));
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
        this.l = new C1221a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19496b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f19496b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f19497c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f19497c.showBottomLine();
            this.f19497c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19498d = (TextView) this.f19496b.findViewById(R.id.inside_text);
            this.f19499e = (TextView) this.f19496b.findViewById(R.id.inside_desc);
            this.f19500f = (BdSwitchView) this.f19496b.findViewById(R.id.inside_switch);
            this.f19501g = (TextView) this.f19496b.findViewById(R.id.outside_text);
            this.f19502h = (TextView) this.f19496b.findViewById(R.id.outside_desc);
            this.f19503i = (BdSwitchView) this.f19496b.findViewById(R.id.outside_switch);
            this.f19498d.setText(R.string.mark_show_inside);
            this.f19499e.setText(R.string.mark_show_everywhere);
            this.f19501g.setText(R.string.mark_show_outside);
            this.f19502h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f19503i.turnOffNoCallback();
            } else {
                this.f19503i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f19500f.turnOffNoCallback();
            } else {
                this.f19500f.turnOnNoCallback();
            }
            this.f19504j = i3 != 3;
            this.k = i4 != 3;
            this.f19500f.setOnSwitchStateChangeListener(this.l);
            this.f19503i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19498d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19499e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19501g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19502h, (int) R.color.CAM_X0109);
            this.f19497c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f19500f.turnOnNoCallback();
            } else {
                this.f19500f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f19504j;
            this.f19504j = z;
            if (z) {
                this.f19503i.turnOnNoCallback();
            } else {
                this.f19503i.turnOffNoCallback();
            }
        }
    }
}
