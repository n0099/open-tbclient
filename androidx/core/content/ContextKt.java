package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aU\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a?\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0014¨\u0006\u0015"}, d2 = {"", "T", "Landroid/content/Context;", "getSystemService", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/util/AttributeSet;", "set", "", "attrs", "", "defStyleAttr", "defStyleRes", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "withStyledAttributes", "(Landroid/content/Context;Landroid/util/AttributeSet;[IIILkotlin/Function1;)V", "resourceId", "(Landroid/content/Context;I[ILkotlin/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ContextKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, @AttrRes int i2, @StyleRes int i3, Function1<? super TypedArray, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, attributeSet, iArr, Integer.valueOf(i2), Integer.valueOf(i3), function1}) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            function1.invoke(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i2, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65537, null, context, i2, iArr, function1) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, iArr);
            function1.invoke(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }
}
