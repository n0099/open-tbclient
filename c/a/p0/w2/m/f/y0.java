package c.a.p0.w2.m.f;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes3.dex */
public class y0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f20349b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f20350c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f20351d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218739086, "Lc/a/p0/w2/m/f/y0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218739086, "Lc/a/p0/w2/m/f/y0;");
                return;
            }
        }
        a = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        f20349b = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        f20350c = new int[]{R.string.obfuscated_res_0x7f0f0f8a, R.string.obfuscated_res_0x7f0f0f8b, R.string.obfuscated_res_0x7f0f0f8c};
    }

    public static void a(int i, String str, TextView textView, TextView textView2, ImageView imageView, UserIconBox userIconBox, UserIconBox userIconBox2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, textView, textView2, imageView, userIconBox, userIconBox2}) == null) || TextUtils.isEmpty(str) || textView == null || textView2 == null || imageView == null || userIconBox == null || userIconBox2 == null) {
            return;
        }
        int measureText = (int) textView.getPaint().measureText(str);
        int width = textView2.getVisibility() == 8 ? 0 : textView2.getWidth() + a;
        int width2 = imageView.getVisibility() == 8 ? 0 : imageView.getWidth() + a;
        int width3 = (i - (userIconBox2.getVisibility() == 8 ? 0 : (userIconBox2.getWidth() + f20349b) + a)) - measureText;
        int i2 = width2 + width;
        if (width3 > (userIconBox.getVisibility() != 8 ? userIconBox.getWidth() + a : 0) + i2) {
            return;
        }
        if (width3 > i2) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f20350c[new Random().nextInt(f20350c.length)] : invokeV.intValue;
    }

    public static SpannableString c(ThreadData threadData) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15da);
            } else {
                string = threadData.getBJHContentTag() == 2 ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1157) : "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
            spannableString.setSpan(new c.a.o0.r.l0.r.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03c0, new Object[]{UtilHelper.getFixedBarText(str, 7, false)}) : (String) invokeL.objValue;
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

    public static String h(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public static int i(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(fVar.p()) && (fVar.h() == null || StringUtils.isNull(fVar.h().a()))) ? 0 : 2;
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
                if (f20351d == null) {
                    f20351d = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = f20351d;
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
