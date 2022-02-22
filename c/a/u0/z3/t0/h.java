package c.a.u0.z3.t0;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import c.a.d.f.p.n;
import c.a.u0.a4.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(NetWork netWork, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, netWork, writeData) == null) && writeData != null && writeData.isHasLocationData()) {
            netWork.addPostData("is_location", "2");
            Address j2 = c.a.d.f.i.a.n().j(false);
            if (j2 != null) {
                netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(j2.getLatitude()));
                netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(j2.getLongitude()));
            }
            LocationData b2 = c.a.u0.z3.p0.b.a().b();
            if (b2 != null) {
                netWork.addPostData("name", b2.getFormatted_address());
                netWork.addPostData("sn", b2.getSn());
            }
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, str, str2, str3) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.u0.a4.h.post_write_or_reply_lay, (ViewGroup) null);
            inflate.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(context, c.a.u0.a4.e.tbds32), SkinManager.getColor(c.a.u0.a4.d.CAM_X0701)));
            View findViewById = inflate.findViewById(c.a.u0.a4.g.experience_score);
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.success_text);
            SkinManager.setViewTextColor(textView, c.a.u0.a4.d.CAM_X0101);
            TextView textView2 = (TextView) inflate.findViewById(c.a.u0.a4.g.pre_msg);
            SkinManager.setViewTextColor(textView2, c.a.u0.a4.d.CAM_X0101);
            TextView textView3 = (TextView) inflate.findViewById(c.a.u0.a4.g.color_msg);
            SkinManager.setViewTextColor(textView3, c.a.u0.a4.d.CAM_X0305);
            ImageView imageView = (ImageView) inflate.findViewById(c.a.u0.a4.g.success_img);
            if (imageView != null) {
                imageView.setBackgroundDrawable(SvgManager.getInstance().getPureDrawable(c.a.u0.a4.f.icon_pure_toast_succeed40_svg, c.a.u0.a4.d.CAM_X0101, null));
            }
            if (StringUtils.isNull(str)) {
                str = context.getString(j.send_success);
            }
            textView.setText(str);
            if (str2 != null || str3 != null) {
                findViewById.setVisibility(0);
                textView2.setText(str2);
                textView3.setText(str3);
            }
            c(context, inflate);
        }
    }

    public static void c(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, view) == null) {
            Toast toast = new Toast(context);
            toast.setView(view);
            toast.setGravity(17, 0, 0);
            toast.setDuration(3000);
            toast.show();
        }
    }
}
