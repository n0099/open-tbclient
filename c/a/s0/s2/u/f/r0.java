package c.a.s0.s2.u.f;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes8.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23128b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f23129c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f23130d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1365327786, "Lc/a/s0/s2/u/f/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1365327786, "Lc/a/s0/s2/u/f/r0;");
                return;
            }
        }
        a = c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds10);
        f23128b = c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds8);
        f23129c = new int[]{c.a.s0.s2.l.reply_hint_text_1, c.a.s0.s2.l.reply_hint_text_2, c.a.s0.s2.l.reply_hint_text_3};
    }

    public static void a(int i2, String str, TextView textView, TextView textView2, ImageView imageView, UserIconBox userIconBox, UserIconBox userIconBox2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, textView, textView2, imageView, userIconBox, userIconBox2}) == null) || TextUtils.isEmpty(str) || textView == null || textView2 == null || imageView == null || userIconBox == null || userIconBox2 == null) {
            return;
        }
        int measureText = (int) textView.getPaint().measureText(str);
        int width = textView2.getVisibility() == 8 ? 0 : textView2.getWidth() + a;
        int width2 = imageView.getVisibility() == 8 ? 0 : imageView.getWidth() + a;
        int width3 = (i2 - (userIconBox2.getVisibility() == 8 ? 0 : (userIconBox2.getWidth() + f23128b) + a)) - measureText;
        int i3 = width2 + width;
        if (width3 > (userIconBox.getVisibility() != 8 ? userIconBox.getWidth() + a : 0) + i3) {
            return;
        }
        if (width3 > i3) {
            userIconBox.setVisibility(8);
        } else if (width3 > width) {
            imageView.setVisibility(8);
            userIconBox.setVisibility(8);
        } else {
            textView2.setVisibility(8);
            imageView.setVisibility(8);
            userIconBox.setVisibility(8);
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f23129c[new Random().nextInt(f23129c.length)] : invokeV.intValue;
    }

    public static SpannableString c(d2 d2Var) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (d2Var.K() == 1) {
                string = TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.yuanchuang);
            } else {
                string = d2Var.K() == 2 ? TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.shoufa) : "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
            spannableString.setSpan(new c.a.r0.s.i0.r.a(c.a.s0.s2.f.CAM_X0204, UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds5), UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds26), c.a.s0.s2.f.CAM_X0105, UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds8), UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds9), UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)}) : (String) invokeL.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("id", str);
            intent.putExtra("from", "nas");
            intent.putExtra("key_start_from", 5);
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? UtilHelper.getDimenPixelSize(c.a.s0.s2.g.tbds88) : invokeV.intValue;
    }

    public static String h(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public static int i(c.a.s0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().o2()) {
                return (ListUtils.isEmpty(fVar.p()) && (fVar.h() == null || StringUtils.isNull(fVar.h().getForumName()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static Layout j(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, spannableStringBuilder)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int k2 = c.a.d.f.p.m.k(context) - (c.a.d.f.p.m.f(context, c.a.s0.s2.g.tbds44) * 2);
            int contentSize = TbConfig.getContentSize();
            try {
                if (f23130d == null) {
                    f23130d = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = f23130d;
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                textView.setText(spannableStringBuilder);
                textView.setTextSize(0, contentSize);
                textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
                textView.getPaint().setFakeBoldText(true);
                textView.measure(View.MeasureSpec.makeMeasureSpec(k2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                return textView.getLayout();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Layout) invokeL.objValue;
    }

    public static void k(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, textView) == null) || textView == null) {
            return;
        }
        textView.getPaint().setFakeBoldText(true);
    }
}
