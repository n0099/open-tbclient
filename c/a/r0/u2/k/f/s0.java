package c.a.r0.u2.k.f;

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
import c.a.q0.r.r.e2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes2.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23700b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f23701c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f23702d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1750053046, "Lc/a/r0/u2/k/f/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1750053046, "Lc/a/r0/u2/k/f/s0;");
                return;
            }
        }
        a = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        f23700b = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        f23701c = new int[]{R.string.reply_hint_text_1, R.string.reply_hint_text_2, R.string.reply_hint_text_3};
    }

    public static void a(int i2, String str, TextView textView, TextView textView2, ImageView imageView, UserIconBox userIconBox, UserIconBox userIconBox2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, textView, textView2, imageView, userIconBox, userIconBox2}) == null) || TextUtils.isEmpty(str) || textView == null || textView2 == null || imageView == null || userIconBox == null || userIconBox2 == null) {
            return;
        }
        int measureText = (int) textView.getPaint().measureText(str);
        int width = textView2.getVisibility() == 8 ? 0 : textView2.getWidth() + a;
        int width2 = imageView.getVisibility() == 8 ? 0 : imageView.getWidth() + a;
        int width3 = (i2 - (userIconBox2.getVisibility() == 8 ? 0 : (userIconBox2.getWidth() + f23700b) + a)) - measureText;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f23701c[new Random().nextInt(f23701c.length)] : invokeV.intValue;
    }

    public static SpannableString c(e2 e2Var) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            if (e2Var.K() == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
            } else {
                string = e2Var.K() == 2 ? TbadkCoreApplication.getInst().getString(R.string.shoufa) : "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
            spannableString.setSpan(new c.a.q0.r.l0.r.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)}) : (String) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds88) : invokeV.intValue;
    }

    public static String h(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public static int i(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().p2()) {
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
            int k = c.a.d.f.p.n.k(context) - (c.a.d.f.p.n.f(context, R.dimen.tbds44) * 2);
            int contentSize = TbConfig.getContentSize();
            try {
                if (f23702d == null) {
                    f23702d = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = f23702d;
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                textView.setText(spannableStringBuilder);
                textView.setTextSize(0, contentSize);
                textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
                textView.getPaint().setFakeBoldText(true);
                textView.measure(View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
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
