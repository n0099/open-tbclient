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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes6.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f14685b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f14686c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14687d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14688e;

    public a(Context context) {
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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(h.floating_view_from_bcast_copy_link, (ViewGroup) null);
        this.a = inflate;
        this.f14685b = (ImageView) inflate.findViewById(g.floating_view_icon);
        this.f14687d = (TextView) this.a.findViewById(g.floating_view_title);
        this.f14686c = (ImageView) this.a.findViewById(g.floating_view_arrow);
        this.f14688e = (LinearLayout) this.a.findViewById(g.floating_view_main);
        this.f14687d.setText(j.frs_forum_bcast_return_info);
        changeSkin();
    }

    @Override // c.a.t0.y.c
    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f14687d, c.a.u0.a4.d.CAM_X0101);
        SkinManager.setImageResource(this.f14685b, f.pic_float_return_broadcast32);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14686c, f.ic_icon_mybar_pure_list_arrow16_right, c.a.u0.a4.d.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.makeDrawableSelector().defaultColor(c.a.u0.a4.d.CAM_X0305).setShape(0).setAlpha(w0.A).tlRadius(n.f(TbadkCoreApplication.getInst(), e.tbds52)).blRadius(n.f(TbadkCoreApplication.getInst(), e.tbds52)).into(this.f14688e);
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
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_FORUM_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
