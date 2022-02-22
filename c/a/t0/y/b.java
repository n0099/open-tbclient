package c.a.t0.y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes6.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f14689b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f14690c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14691d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14692e;

    public b(Context context) {
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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(h.floating_view_from_rule_copy, (ViewGroup) null);
        this.a = inflate;
        this.f14689b = (ImageView) inflate.findViewById(g.floating_view_icon);
        this.f14691d = (TextView) this.a.findViewById(g.floating_view_title);
        this.f14690c = (ImageView) this.a.findViewById(g.floating_view_arrow);
        this.f14692e = (LinearLayout) this.a.findViewById(g.floating_view_main);
        this.f14691d.setText(j.frs_forum_rule_return_info);
        changeSkin();
    }

    @Override // c.a.t0.y.c
    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f14691d, c.a.u0.a4.d.CAM_X0101);
        this.f14690c.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_arrow12_right_n, SkinManager.getColor(c.a.u0.a4.d.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
        TBSelector.makeDrawableSelector().defaultColor(c.a.u0.a4.d.CAM_X0302).setShape(0).setAlpha(w0.A).tlRadius(n.f(TbadkCoreApplication.getInst(), e.tbds52)).blRadius(n.f(TbadkCoreApplication.getInst(), e.tbds52)).into(this.f14692e);
        this.f14689b.setImageDrawable(WebPManager.getMaskDrawable(f.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
    }

    @Override // c.a.t0.y.c
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.a;
            return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(h.floating_view_from_bcast_copy_link, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.y.c
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
