package com.baidu.tbadk.core.util;

import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"shouldEllipsize", "", "maxWidth", "", "paint", "Landroid/graphics/Paint;", "source", "", "maxLen", "", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TextViewCutUtilsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean shouldEllipsize(float f, Paint paint, String source, int i) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f), paint, source, Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(source, "source");
            float f2 = 0.0f;
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z && i != 0) {
                if (source.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!StringsKt__StringsKt.contains$default((CharSequence) source, (CharSequence) "\n", false, 2, (Object) null)) {
                        if (paint.measureText(source) >= f * i) {
                            return true;
                        }
                        return false;
                    }
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) source, new String[]{"\n"}, false, 0, 6, (Object) null);
                    if (split$default.size() > i) {
                        return true;
                    }
                    int i2 = 0;
                    for (int i3 = 0; i3 < i && split$default.size() > i3; i3++) {
                        if (i3 < i - 1) {
                            measureText = paint.measureText((String) split$default.get(i3));
                            int ceil = (int) Math.ceil(measureText / f);
                            i2 += ceil;
                            if (i2 < i) {
                                measureText = ceil * f;
                            }
                        } else {
                            measureText = paint.measureText((String) split$default.get(i3));
                            i2++;
                        }
                        f2 += measureText;
                        if (i2 >= i) {
                            if (f2 >= f * i) {
                                return true;
                            }
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
