package b.a.x0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30369a;

    /* renamed from: b  reason: collision with root package name */
    public String f30370b;

    /* renamed from: c  reason: collision with root package name */
    public String f30371c;

    /* renamed from: d  reason: collision with root package name */
    public float f30372d;

    /* renamed from: e  reason: collision with root package name */
    public String f30373e;

    /* renamed from: f  reason: collision with root package name */
    public String f30374f;

    /* renamed from: g  reason: collision with root package name */
    public String f30375g;

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
            this.f30369a = "";
            this.f30370b = "";
            this.f30371c = "";
            this.f30372d = 0.0f;
            this.f30373e = "";
            this.f30374f = "";
            this.f30375g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30369a + ", bft : " + this.f30370b + ", fc : " + this.f30371c + ", time : " + this.f30372d + ", cpu : " + this.f30373e + ", mem : " + this.f30374f + ", gpu : " + this.f30375g;
        }
        return (String) invokeV.objValue;
    }
}
