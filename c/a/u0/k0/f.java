package c.a.u0.k0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f19012b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19013c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19014d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f19015e;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(c.a.u0.a4.h.widget_message_entrance, (ViewGroup) null);
        this.f19012b = inflate;
        this.f19013c = (RelativeLayout) inflate.findViewById(c.a.u0.a4.g.message_view_layout);
        this.f19014d = (ImageView) this.f19012b.findViewById(c.a.u0.a4.g.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f19012b.findViewById(c.a.u0.a4.g.img_red_tip);
        this.f19015e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19015e : (MessageRedDotView) invokeV.objValue;
    }

    public ImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19014d : (ImageView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19012b : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f19015e.onChangeSkinType();
            this.f19014d.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.a4.f.icon_pure_topbar_information40, SkinManager.getColor(c.a.u0.a4.d.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                this.f19015e.refresh(i2);
                this.f19015e.setVisibility(0);
                return;
            }
            this.f19015e.setVisibility(8);
        }
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, controlAlign, z) == null) && !z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.f19014d.getLayoutParams()).rightMargin = -n.f(this.a, c.a.u0.a4.e.tbds10);
            ((RelativeLayout.LayoutParams) this.f19015e.getLayoutParams()).rightMargin = -n.f(this.a, c.a.u0.a4.e.tbds10);
            this.f19013c.getLayoutParams().width = n.f(this.a, c.a.u0.a4.e.ds88);
        }
    }

    public void g(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f19012b) == null) {
            return;
        }
        view.setVisibility(i2);
    }
}
