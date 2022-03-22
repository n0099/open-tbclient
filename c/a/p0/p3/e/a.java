package c.a.p0.p3.e;

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
    public View f17000b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17001c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17002d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17003e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f17004f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17005g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17006h;
    public BdSwitchView i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: c.a.p0.p3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1275a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1275a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.a.f17004f) {
                    this.a.k = switchState == BdSwitchView.SwitchState.ON;
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.a.i) {
                    this.a.j = switchState == BdSwitchView.SwitchState.ON;
                    this.a.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.a.f17004f ? 2 : 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f<PrivacyMarkActivity> fVar, int i) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new C1275a(this);
        this.a = fVar;
        k(fVar.getPageActivity(), i);
        l();
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17000b : (View) invokeV.objValue;
    }

    public final void k(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0706, (ViewGroup) null);
            this.f17000b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091519);
            this.f17001c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.obfuscated_res_0x7f0f0eb8));
            this.f17001c.showBottomLine();
            this.f17001c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f17002d = (TextView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f090f06);
            this.f17003e = (TextView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f090f03);
            this.f17004f = (BdSwitchView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f090f04);
            this.f17005g = (TextView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f091631);
            this.f17006h = (TextView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f09162e);
            this.i = (BdSwitchView) this.f17000b.findViewById(R.id.obfuscated_res_0x7f09162f);
            this.f17002d.setText(R.string.obfuscated_res_0x7f0f0a87);
            this.f17003e.setText(R.string.obfuscated_res_0x7f0f0a86);
            this.f17005g.setText(R.string.obfuscated_res_0x7f0f0a88);
            this.f17006h.setText(R.string.obfuscated_res_0x7f0f0a89);
            int i2 = i & 3;
            int i3 = (i >> 2) & 3;
            if (i2 == 3) {
                this.i.h();
            } else {
                this.i.l();
            }
            if (i3 == 3) {
                this.f17004f.h();
            } else {
                this.f17004f.l();
            }
            this.j = i2 != 3;
            this.k = i3 != 3;
            this.f17004f.setOnSwitchStateChangeListener(this.l);
            this.i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f17002d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f17003e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f17005g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f17006h, (int) R.color.CAM_X0109);
            this.f17001c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f17004f.l();
            } else {
                this.f17004f.h();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.i.l();
            } else {
                this.i.h();
            }
        }
    }
}
