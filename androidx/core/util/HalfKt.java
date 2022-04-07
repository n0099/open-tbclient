package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"", "Landroid/util/Half;", "toHalf", "(D)Landroid/util/Half;", "", "(F)Landroid/util/Half;", "", "(S)Landroid/util/Half;", "", "(Ljava/lang/String;)Landroid/util/Half;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class HalfKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(26)
    public static final Half toHalf(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Short.valueOf(s)})) == null) {
            Half valueOf = Half.valueOf(s);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
            return valueOf;
        }
        return (Half) invokeCommon.objValue;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) {
            Half valueOf = Half.valueOf(f);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
            return valueOf;
        }
        return (Half) invokeF.objValue;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Half valueOf = Half.valueOf(str);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
            return valueOf;
        }
        return (Half) invokeL.objValue;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d)})) == null) {
            Half valueOf = Half.valueOf((float) d);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
            return valueOf;
        }
        return (Half) invokeCommon.objValue;
    }
}
