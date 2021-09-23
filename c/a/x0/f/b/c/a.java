package c.a.x0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30744a;

    /* renamed from: b  reason: collision with root package name */
    public String f30745b;

    /* renamed from: c  reason: collision with root package name */
    public String f30746c;

    /* renamed from: d  reason: collision with root package name */
    public float f30747d;

    /* renamed from: e  reason: collision with root package name */
    public String f30748e;

    /* renamed from: f  reason: collision with root package name */
    public String f30749f;

    /* renamed from: g  reason: collision with root package name */
    public String f30750g;

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
            this.f30744a = "";
            this.f30745b = "";
            this.f30746c = "";
            this.f30747d = 0.0f;
            this.f30748e = "";
            this.f30749f = "";
            this.f30750g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30744a + ", bft : " + this.f30745b + ", fc : " + this.f30746c + ", time : " + this.f30747d + ", cpu : " + this.f30748e + ", mem : " + this.f30749f + ", gpu : " + this.f30750g;
        }
        return (String) invokeV.objValue;
    }
}
