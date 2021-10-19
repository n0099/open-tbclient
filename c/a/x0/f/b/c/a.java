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
    public String f30791a;

    /* renamed from: b  reason: collision with root package name */
    public String f30792b;

    /* renamed from: c  reason: collision with root package name */
    public String f30793c;

    /* renamed from: d  reason: collision with root package name */
    public float f30794d;

    /* renamed from: e  reason: collision with root package name */
    public String f30795e;

    /* renamed from: f  reason: collision with root package name */
    public String f30796f;

    /* renamed from: g  reason: collision with root package name */
    public String f30797g;

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
            this.f30791a = "";
            this.f30792b = "";
            this.f30793c = "";
            this.f30794d = 0.0f;
            this.f30795e = "";
            this.f30796f = "";
            this.f30797g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30791a + ", bft : " + this.f30792b + ", fc : " + this.f30793c + ", time : " + this.f30794d + ", cpu : " + this.f30795e + ", mem : " + this.f30796f + ", gpu : " + this.f30797g;
        }
        return (String) invokeV.objValue;
    }
}
