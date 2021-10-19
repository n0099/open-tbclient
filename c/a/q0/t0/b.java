package c.a.q0.t0;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.f0.s.e;
import c.a.q0.u.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15033a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(53925378, "Lc/a/q0/t0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(53925378, "Lc/a/q0/t0/b;");
                return;
            }
        }
        f15033a = Pattern.compile("#([^#(]+)#", 2);
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.charAt(0) == '#' && str.charAt(str.length() - 1) == '#') {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append("#");
            sb.append(str);
            sb.append("#");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) ? c(tbPageContext, true, true) : invokeL.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
            int length = str.length();
            if (length > 2 && str.charAt(0) == '#') {
                int i2 = length - 1;
                if (str.charAt(i2) == '#') {
                    str2 = str.substring(1, i2);
                    stringBuffer.append(str2);
                    return stringBuffer.toString();
                }
            }
            str2 = null;
            stringBuffer.append(str2);
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str != null && str.startsWith("#") && str.endsWith("#") && "".equals(str.substring(1, str.length() - 1).trim()) : invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? "#".equals(str) : invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? PluginPackageManager.O().b0("com.baidu.tieba.pluginHotTopic") : invokeV.booleanValue;
    }

    public static boolean h(boolean z) {
        InterceptResult invokeZ;
        boolean appResponseToIntentClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            if (PluginPackageManager.O().d0("com.baidu.tieba.pluginHotTopic")) {
                if (z) {
                    appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
                } else {
                    appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
                }
                return appResponseToIntentClass;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public static boolean i(Spannable spannable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, spannable, i2)) == null) {
            if (spannable != null && !StringUtils.isNull(spannable.toString())) {
                Matcher matcher = f15033a.matcher(spannable.toString());
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (i2 > start && end > i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void j(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, lVar) == null) {
            int i2 = lVar.f15073b;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "1" : TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM : "pb" : "frs" : "index"));
        }
    }

    public static SpannableString k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return new SpannableString("");
            }
            Matcher matcher = f15033a.matcher(str);
            SpannableString spannableString = new SpannableString(str);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!e(str.substring(start, end))) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void l(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, spannable) == null) || spannable == null) {
            return;
        }
        String obj = spannable.toString();
        if (StringUtils.isNull(obj)) {
            return;
        }
        Matcher matcher = f15033a.matcher(obj);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                spannable.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
    }

    public static void m(SpanGroupEditText spanGroupEditText) {
        int i2;
        int i3;
        ImageSpan[] imageSpanArr;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, spanGroupEditText) == null) || spanGroupEditText == null || spanGroupEditText.getText() == null || spanGroupEditText.getSpanGroupManager() == null) {
            return;
        }
        SpanGroupManager spanGroupManager = spanGroupEditText.getSpanGroupManager();
        if (spanGroupManager.G().size() > 0) {
            e eVar = spanGroupManager.G().get(0);
            i3 = eVar.f();
            i2 = eVar.c();
        } else {
            i2 = 0;
            i3 = 0;
        }
        Editable text = spanGroupEditText.getText();
        String obj = text.toString();
        if (StringUtils.isNull(obj)) {
            return;
        }
        Matcher matcher = f15033a.matcher(obj);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (end > i3 && i2 > end) {
                for (Object obj2 : text.getSpans(i3, text.length(), Object.class)) {
                    if ((obj2 instanceof EMRichTextAnyIconSpan) || (obj2 instanceof ForegroundColorSpan)) {
                        text.removeSpan(obj2);
                    }
                }
                spanGroupManager.s(i3, i2, true);
                i2 = -1;
                i3 = 0;
            }
            if (!e(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) text.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                text.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), start, end, 18);
            }
        }
    }
}
