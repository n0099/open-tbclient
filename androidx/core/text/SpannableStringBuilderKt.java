package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u001a)\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\b2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\b2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\t\u0010\u000b\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aA\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0012\"\u00020\u000e2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0015\u0010\r\u001a5\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001a\u0010\r\u001a-\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001b\u0010\r\u001a-\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001c\u0010\r\u001a-\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "Landroid/text/SpannedString;", "buildSpannedString", "(Lkotlin/Function1;)Landroid/text/SpannedString;", "", "color", "backgroundColor", "(Landroid/text/SpannableStringBuilder;ILkotlin/Function1;)Landroid/text/SpannableStringBuilder;", "bold", "(Landroid/text/SpannableStringBuilder;Lkotlin/Function1;)Landroid/text/SpannableStringBuilder;", "", "span", "inSpans", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;Lkotlin/Function1;)Landroid/text/SpannableStringBuilder;", "", "spans", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "", "proportion", "scale", "(Landroid/text/SpannableStringBuilder;FLkotlin/Function1;)Landroid/text/SpannableStringBuilder;", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, spannableStringBuilder, i2, function1)) == null) {
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i2);
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLIL.objValue;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, spannableStringBuilder, function1)) == null) {
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, function1)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            function1.invoke(spannableStringBuilder);
            return new SpannedString(spannableStringBuilder);
        }
        return (SpannedString) invokeL.objValue;
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, spannableStringBuilder, i2, function1)) == null) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLIL.objValue;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object[] objArr, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, spannableStringBuilder, objArr, function1)) == null) {
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            for (Object obj : objArr) {
                spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, spannableStringBuilder, function1)) == null) {
            StyleSpan styleSpan = new StyleSpan(2);
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder spannableStringBuilder, float f2, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{spannableStringBuilder, Float.valueOf(f2), function1})) == null) {
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, spannableStringBuilder, function1)) == null) {
            StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, spannableStringBuilder, function1)) == null) {
            SubscriptSpan subscriptSpan = new SubscriptSpan();
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, spannableStringBuilder, function1)) == null) {
            SuperscriptSpan superscriptSpan = new SuperscriptSpan();
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, spannableStringBuilder, function1)) == null) {
            UnderlineSpan underlineSpan = new UnderlineSpan();
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object obj, Function1<? super SpannableStringBuilder, Unit> function1) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, spannableStringBuilder, obj, function1)) == null) {
            int length = spannableStringBuilder.length();
            function1.invoke(spannableStringBuilder);
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }
}
