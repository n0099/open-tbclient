package c.a.c0.h;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f1661b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1662c;

    /* renamed from: d  reason: collision with root package name */
    public final i<?> f1663d;

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SubscribeInfo:{\n    threadMode:" + this.f1662c + "\n    tag:" + this.a + "\n    eventClass:" + this.f1661b + "\n    subscriber:" + this.f1663d + "\n}";
        }
        return (String) invokeV.objValue;
    }
}
