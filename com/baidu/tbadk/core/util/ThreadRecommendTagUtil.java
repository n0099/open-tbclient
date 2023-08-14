package com.baidu.tbadk.core.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendTagData;
import com.baidu.tieba.R;
import com.baidu.tieba.oa5;
import com.baidu.tieba.w65;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class ThreadRecommendTagUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_ERROR = 0;
    public static final int TEXT_LENGTH_INT = 8;
    public transient /* synthetic */ FieldHolder $fh;

    public ThreadRecommendTagUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getColor(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, themeColorInfo)) == null) {
            if (themeColorInfo == null) {
                return 0;
            }
            if (TbadkApplication.getInst().getSkinType() == 4) {
                if (!isElementValid(themeColorInfo.dark)) {
                    return 0;
                }
                return y9a.f(themeColorInfo.dark.common_color);
            } else if (!isElementValid(themeColorInfo.day)) {
                return 0;
            } else {
                return y9a.f(themeColorInfo.day.common_color);
            }
        }
        return invokeL.intValue;
    }

    public static boolean isElementValid(ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, themeElement)) == null) {
            if (themeElement != null && !StringUtils.isNull(themeElement.common_color)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setHotTopicReasonTag(SpannableStringBuilder spannableStringBuilder, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, spannableStringBuilder, threadData) == null) && spannableStringBuilder != null && threadData != null && threadData.getThreadRecommendTagData() != null) {
            ThreadRecommendTagData threadRecommendTagData = threadData.getThreadRecommendTagData();
            String text = threadRecommendTagData.getText();
            if (!TextUtils.isEmpty(text)) {
                spannableStringBuilder.insert(0, (CharSequence) text);
                int color = getColor(threadRecommendTagData.getTextColor());
                int color2 = getColor(threadRecommendTagData.getBackgroundColor());
                int color3 = getColor(threadData.getThreadRecommendTagData().getBoundaryColor());
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                float[] B = w65.B(R.string.J_X04);
                oa5.b bVar = new oa5.b();
                bVar.y(B[0]);
                bVar.B(R.dimen.T_X10);
                bVar.z(dimenPixelSize);
                bVar.x(dimenPixelSize2);
                bVar.A(dimenPixelSize2);
                bVar.u(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
                bVar.C(true);
                if (color != 0) {
                    bVar.D(color);
                }
                if (color3 != 0) {
                    bVar.t(UtilHelper.getDimenPixelSize(R.dimen.L_X02));
                    bVar.w(UtilHelper.getDimenPixelSize(R.dimen.L_X01));
                    bVar.s(color3);
                    bVar.r(w65.b(R.string.A_X04));
                }
                bVar.q(color2);
                spannableStringBuilder.setSpan(bVar.p(), 0, text.length(), 33);
            }
        }
    }

    public static void setTag(SpannableStringBuilder spannableStringBuilder, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, spannableStringBuilder, threadData) == null) && spannableStringBuilder != null && threadData != null && threadData.getThreadRecommendTagData() != null) {
            ThreadRecommendTagData threadRecommendTagData = threadData.getThreadRecommendTagData();
            String text = threadRecommendTagData.getText();
            if (!TextUtils.isEmpty(text)) {
                if (StringHelper.getChineseAndEnglishLength(text) > 8) {
                    text = StringHelper.cutChineseAndEnglishWithEmoji(text, 8, null);
                }
                spannableStringBuilder.insert(0, (CharSequence) text);
                int color = getColor(threadRecommendTagData.getTextColor());
                int color2 = getColor(threadRecommendTagData.getBackgroundColor());
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                oa5.b bVar = new oa5.b();
                bVar.y(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
                bVar.B(R.dimen.T_X10);
                bVar.z(dimenPixelSize);
                bVar.x(dimenPixelSize2);
                bVar.A(dimenPixelSize2);
                bVar.u(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
                if (color != 0) {
                    bVar.D(color);
                }
                if (color2 != 0) {
                    bVar.q(color2);
                }
                spannableStringBuilder.setSpan(bVar.p(), 0, text.length(), 33);
            }
        }
    }
}
