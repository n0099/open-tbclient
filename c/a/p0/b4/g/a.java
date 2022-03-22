package c.a.p0.b4.g;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.p0.b4.e.b;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f12839b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f12840c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12841d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12842e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12843f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12844g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12845h;
    public TextView i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f12839b = i;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(this.f12839b == 3 ? R.layout.obfuscated_res_0x7f0d038c : R.layout.obfuscated_res_0x7f0d038b, (ViewGroup) null);
            this.f12840c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df));
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12840c : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f12841d = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090479);
            this.f12842e = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f09047c);
            this.f12843f = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090475);
            this.f12845h = (LinearLayout) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090472);
            this.i = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090471);
            this.j = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090470);
            this.f12844g = (TextView) this.f12840c.findViewById(R.id.obfuscated_res_0x7f090476);
        }
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || (iconInfo = bVar.f12835b) == null) {
            return;
        }
        this.f12841d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f12841d.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f12841d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f12843f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f12842e.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0896, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.a;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.a.vip_extra_percent.intValue() > 0) {
                this.i.setText(c.a.p0.b4.b.a((bVar.f12835b.non_member_t.intValue() * bVar.a.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df));
                this.i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f12845h.setVisibility(0);
            } else {
                this.f12845h.setVisibility(8);
            }
        } else {
            this.f12845h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i != 1 && i != 4) {
                this.f12840c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f12840c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.f12841d, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12843f, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12842e, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.f12844g, R.color.CAM_X0105, 1, i);
        }
    }
}
