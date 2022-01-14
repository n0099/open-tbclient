package c.a.t0.y3.g;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.t0.y3.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f25880b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f25881c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25882d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25883e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25884f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25885g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25886h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25887i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f25888j;

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f25880b = i2;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = R.layout.grid_view_2_column_item_layout;
            if (this.f25880b == 3) {
                i2 = R.layout.grid_view_3_column_item_layout;
            }
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(i2, (ViewGroup) null);
            this.f25881c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.ds6));
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25881c : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f25882d = (TextView) this.f25881c.findViewById(R.id.buy_tbean_t_dou_num);
            this.f25883e = (TextView) this.f25881c.findViewById(R.id.buy_tbean_yinji_time);
            this.f25884f = (TextView) this.f25881c.findViewById(R.id.buy_tbean_price);
            this.f25886h = (LinearLayout) this.f25881c.findViewById(R.id.buy_tbean_member_privilege_layout);
            this.f25887i = (TextView) this.f25881c.findViewById(R.id.buy_tbean_member_privilege);
            this.f25888j = (TextView) this.f25881c.findViewById(R.id.buy_tbean_member_prefix);
            this.f25885g = (TextView) this.f25881c.findViewById(R.id.buy_tbean_price_prefix);
        }
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || (iconInfo = bVar.f25875f) == null) {
            return;
        }
        this.f25882d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f25882d.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f25882d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f25884f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f25883e.setText(this.a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f25874e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f25874e.vip_extra_percent.intValue() > 0) {
                this.f25887i.setText(c.a.t0.y3.b.a((bVar.f25875f.non_member_t.intValue() * bVar.f25874e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f25887i.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f25887i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f25886h.setVisibility(0);
            } else {
                this.f25886h.setVisibility(8);
            }
        } else {
            this.f25886h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f25881c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f25881c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.f25882d, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25884f, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25883e, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f25887i, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f25888j, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f25885g, R.color.CAM_X0105, 1, i2);
        }
    }
}
