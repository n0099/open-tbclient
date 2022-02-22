package c.a.s0.j.l0;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    @JvmField
    public final String address;
    @V8JavascriptField
    @JvmField
    public final String family;
    @V8JavascriptField
    @JvmField
    public final int port;
    @V8JavascriptField
    @JvmField
    public final int size;

    public f(String address, int i2, int i3, String family) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {address, Integer.valueOf(i2), Integer.valueOf(i3), family};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(family, "family");
        this.address = address;
        this.size = i2;
        this.port = i3;
        this.family = family;
    }
}
