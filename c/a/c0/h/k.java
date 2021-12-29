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
    public final Class<?> f2088b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2089c;

    /* renamed from: d  reason: collision with root package name */
    public final i<?> f2090d;

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SubscribeInfo:{\n    threadMode:" + this.f2089c + "\n    tag:" + this.a + "\n    eventClass:" + this.f2088b + "\n    subscriber:" + this.f2090d + "\n}";
        }
        return (String) invokeV.objValue;
    }
}
