package b.n.a.g;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f33183a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-236659480, "Lb/n/a/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-236659480, "Lb/n/a/g/c;");
                return;
            }
        }
        f33183a = SetsKt__SetsKt.setOf((Object[]) new String[]{"M", "L", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "C", ExifInterface.LATITUDE_SOUTH, "Q", "R", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "m", "l", "h", "v", "c", "s", IAdRequestParam.COST_NAME, r.f40168a, "a", "z"});
    }
}
