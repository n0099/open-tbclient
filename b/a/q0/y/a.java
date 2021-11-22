package b.a.q0.y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f15070a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15071b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15072c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15073d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15074e;

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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
        this.f15070a = inflate;
        this.f15071b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f15073d = (TextView) this.f15070a.findViewById(R.id.floating_view_title);
        this.f15072c = (ImageView) this.f15070a.findViewById(R.id.floating_view_arrow);
        this.f15074e = (LinearLayout) this.f15070a.findViewById(R.id.floating_view_main);
        this.f15073d.setText(R.string.frs_forum_bcast_return_info);
        changeSkin();
    }

    @Override // b.a.q0.y.c
    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15070a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f15073d, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f15071b, R.drawable.pic_float_return_broadcast32);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15072c, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0305).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f15074e);
    }

    @Override // b.a.q0.y.c
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f15070a;
            return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.q0.y.c
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_FORUM_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
