package c.a.y0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f27223b;

    /* renamed from: c  reason: collision with root package name */
    public String f27224c;

    /* renamed from: d  reason: collision with root package name */
    public float f27225d;

    /* renamed from: e  reason: collision with root package name */
    public String f27226e;

    /* renamed from: f  reason: collision with root package name */
    public String f27227f;

    /* renamed from: g  reason: collision with root package name */
    public String f27228g;

    public a() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = "";
            this.f27223b = "";
            this.f27224c = "";
            this.f27225d = 0.0f;
            this.f27226e = "";
            this.f27227f = "";
            this.f27228g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.a + ", bft : " + this.f27223b + ", fc : " + this.f27224c + ", time : " + this.f27225d + ", cpu : " + this.f27226e + ", mem : " + this.f27227f + ", gpu : " + this.f27228g;
        }
        return (String) invokeV.objValue;
    }
}
