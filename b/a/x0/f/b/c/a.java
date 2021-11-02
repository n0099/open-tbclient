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
    public String f29500a;

    /* renamed from: b  reason: collision with root package name */
    public String f29501b;

    /* renamed from: c  reason: collision with root package name */
    public String f29502c;

    /* renamed from: d  reason: collision with root package name */
    public float f29503d;

    /* renamed from: e  reason: collision with root package name */
    public String f29504e;

    /* renamed from: f  reason: collision with root package name */
    public String f29505f;

    /* renamed from: g  reason: collision with root package name */
    public String f29506g;

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
            this.f29500a = "";
            this.f29501b = "";
            this.f29502c = "";
            this.f29503d = 0.0f;
            this.f29504e = "";
            this.f29505f = "";
            this.f29506g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f29500a + ", bft : " + this.f29501b + ", fc : " + this.f29502c + ", time : " + this.f29503d + ", cpu : " + this.f29504e + ", mem : " + this.f29505f + ", gpu : " + this.f29506g;
        }
        return (String) invokeV.objValue;
    }
}
