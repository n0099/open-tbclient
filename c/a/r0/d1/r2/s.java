package c.a.r0.d1.r2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a.q0.r.t.m a(c.a.q0.r.t.m mVar, @StringRes int i2, @StringRes int i3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{mVar, Integer.valueOf(i2), Integer.valueOf(i3), onClickListener, onClickListener2})) == null) {
            if (mVar == null) {
                return null;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i2, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(i3, TBAlertConfig.OperateBtnStyle.SECONDARY);
            mVar.r(aVar2, aVar);
            mVar.g();
            aVar.a(onClickListener);
            aVar2.a(onClickListener2);
            return mVar;
        }
        return (c.a.q0.r.t.m) invokeCommon.objValue;
    }

    public static c.a.q0.r.t.m b(Activity activity, @StringRes int i2, @StringRes int i3, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), view})) == null) {
            c.a.q0.r.t.m mVar = new c.a.q0.r.t.m(activity);
            mVar.v(i2);
            mVar.l(i3);
            mVar.n(true);
            mVar.i(false);
            if (view != null) {
                mVar.j(view);
            }
            return mVar;
        }
        return (c.a.q0.r.t.m) invokeCommon.objValue;
    }

    public static View c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X013);
            linearLayout.setPadding(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds53), dimenPixelSize, 0);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            final ImageView imageView = new ImageView(activity);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_normal24, R.color.CAM_X0108, null);
            int f2 = c.a.d.f.p.n.f(activity, R.dimen.tbds53);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(f2, f2));
            TextView textView = new TextView(activity);
            textView.setText(R.string.booster_vpn_disconnect_alert_don_not_alert);
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.r2.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        s.d(linearLayout, imageView, view);
                    }
                }
            });
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public static /* synthetic */ void d(LinearLayout linearLayout, ImageView imageView, View view) {
        if (c.a.d.f.m.b.a(linearLayout.getTag(), false)) {
            c.a.q0.r.j0.b.k().u("key_vpb_booster_disconnect_alert", true);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_normal24, R.color.CAM_X0108, null);
            linearLayout.setTag(Boolean.FALSE);
            return;
        }
        c.a.q0.r.j0.b.k().u("key_vpb_booster_disconnect_alert", false);
        WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_check_select24, R.color.CAM_X0304, null);
        linearLayout.setTag(Boolean.TRUE);
    }

    public static void e(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onClickListener) == null) {
            a(b(activity, R.string.booster_vpn_change_route_title, R.string.booster_vpn_change_game_description, null), R.string.confirm, R.string.cancel, onClickListener, null).y();
        }
    }

    public static void f(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onClickListener) == null) {
            a(b(activity, R.string.booster_vpn_change_route_title, R.string.booster_vpn_change_route_description, null), R.string.confirm, R.string.cancel, onClickListener, null).y();
        }
    }

    public static void g(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, activity, onClickListener) == null) && c.a.q0.r.j0.b.k().h("key_vpb_booster_disconnect_alert", true)) {
            a(b(activity, R.string.booster_vpn_disconnect_alert_title, R.string.booster_vpn_disconnect_alert_description, c(activity)), R.string.booster_vpn_disconnect_alert_confirm, R.string.booster_vpn_disconnect_alert_cancel, onClickListener, null).y();
        }
    }

    public static void h(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, activity, onClickListener, onClickListener2) == null) {
            a(b(activity, R.string.booster_vpn_grant_fail_title, R.string.booster_vpn_grant_fail_description, null), R.string.booster_vpn_grant_fail_retry, R.string.booster_vpn_grant_fail_exit, onClickListener, onClickListener2).y();
        }
    }

    public static void i(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, onClickListener) == null) {
            a(b(activity, R.string.booster_vpn_stop_title, R.string.booster_vpn_stop_description, null), R.string.booster_vpn_stop_confirm, R.string.cancel, onClickListener, null).y();
        }
    }
}
