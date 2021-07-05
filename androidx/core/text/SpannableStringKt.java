package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a$\u0010\t\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\t\u0010\r\u001a\u0014\u0010\u000f\u001a\u00020\u0000*\u00020\u000eH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/text/Spannable;", "", "clearSpans", "(Landroid/text/Spannable;)V", "", "start", "end", "", "span", "set", "(Landroid/text/Spannable;IILjava/lang/Object;)V", "Lkotlin/ranges/IntRange;", "range", "(Landroid/text/Spannable;Lkotlin/ranges/IntRange;Ljava/lang/Object;)V", "", "toSpannable", "(Ljava/lang/CharSequence;)Landroid/text/Spannable;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SpannableStringKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, spannable) == null) {
            Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            for (Object obj : spans) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static final void set(Spannable spannable, int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{spannable, Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
            spannable.setSpan(obj, i2, i3, 17);
        }
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, charSequence)) == null) {
            SpannableString valueOf = SpannableString.valueOf(charSequence);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
            return valueOf;
        }
        return (Spannable) invokeL.objValue;
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, spannable, intRange, obj) == null) {
            spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
        }
    }
}
