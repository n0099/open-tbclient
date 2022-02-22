package c.a.u0.o3.n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.u0.o3.b;
import c.a.u0.o3.e;
import c.a.u0.o3.g;
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
    public View f20203b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20204c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20205d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20206e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f20207f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20208g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20209h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f20210i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20211j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: c.a.u0.o3.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1243a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20212e;

        public C1243a(a aVar) {
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
            this.f20212e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f20212e.f20207f) {
                    this.f20212e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f20212e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f20212e.f20210i) {
                    this.f20212e.f20211j = switchState == BdSwitchView.SwitchState.ON;
                    this.f20212e.a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f20212e.f20207f ? 2 : 1));
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
        this.l = new C1243a(this);
        this.a = fVar;
        i(fVar.getPageActivity(), i2);
        j();
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20203b : (View) invokeV.objValue;
    }

    public final void i(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.u0.o3.f.privacy_mark_activity, (ViewGroup) null);
            this.f20203b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(e.navigation_bar);
            this.f20204c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(g.privacy_mark_setting));
            this.f20204c.showBottomLine();
            this.f20204c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20205d = (TextView) this.f20203b.findViewById(e.inside_text);
            this.f20206e = (TextView) this.f20203b.findViewById(e.inside_desc);
            this.f20207f = (BdSwitchView) this.f20203b.findViewById(e.inside_switch);
            this.f20208g = (TextView) this.f20203b.findViewById(e.outside_text);
            this.f20209h = (TextView) this.f20203b.findViewById(e.outside_desc);
            this.f20210i = (BdSwitchView) this.f20203b.findViewById(e.outside_switch);
            this.f20205d.setText(g.mark_show_inside);
            this.f20206e.setText(g.mark_show_everywhere);
            this.f20208g.setText(g.mark_show_outside);
            this.f20209h.setText(g.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f20210i.turnOffNoCallback();
            } else {
                this.f20210i.turnOnNoCallback();
            }
            if (i4 == 3) {
                this.f20207f.turnOffNoCallback();
            } else {
                this.f20207f.turnOnNoCallback();
            }
            this.f20211j = i3 != 3;
            this.k = i4 != 3;
            this.f20207f.setOnSwitchStateChangeListener(this.l);
            this.f20210i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f20205d, b.CAM_X0105);
            SkinManager.setViewTextColor(this.f20206e, b.CAM_X0109);
            SkinManager.setViewTextColor(this.f20208g, b.CAM_X0105);
            SkinManager.setViewTextColor(this.f20209h, b.CAM_X0109);
            this.f20204c.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f20207f.turnOnNoCallback();
            } else {
                this.f20207f.turnOffNoCallback();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.f20211j;
            this.f20211j = z;
            if (z) {
                this.f20210i.turnOnNoCallback();
            } else {
                this.f20210i.turnOffNoCallback();
            }
        }
    }
}
