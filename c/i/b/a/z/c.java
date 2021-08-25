package c.i.b.a.z;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@TargetApi(16)
/* loaded from: classes4.dex */
public final class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MediaCrypto f33996a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f33997b;

    public MediaCrypto a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33996a : (MediaCrypto) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !this.f33997b && this.f33996a.requiresSecureDecoderComponent(str) : invokeL.booleanValue;
    }
}
