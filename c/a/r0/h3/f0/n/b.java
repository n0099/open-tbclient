package c.a.r0.h3.f0.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f17671b;

    /* renamed from: c  reason: collision with root package name */
    public long f17672c;

    /* renamed from: d  reason: collision with root package name */
    public int f17673d;

    /* renamed from: e  reason: collision with root package name */
    public long f17674e;

    /* renamed from: f  reason: collision with root package name */
    public String f17675f;

    /* renamed from: g  reason: collision with root package name */
    public String f17676g;

    /* renamed from: h  reason: collision with root package name */
    public int f17677h;

    /* renamed from: i  reason: collision with root package name */
    public String f17678i;

    /* renamed from: j  reason: collision with root package name */
    public String f17679j;

    /* renamed from: k  reason: collision with root package name */
    public String f17680k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return TextUtils.equals(this.a, bVar.a) && TextUtils.equals(this.f17671b, bVar.f17671b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.a + this.f17671b).hashCode();
        }
        return invokeV.intValue;
    }
}
