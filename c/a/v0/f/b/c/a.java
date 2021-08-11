package c.a.v0.f.b.c;

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
    public String f30150a;

    /* renamed from: b  reason: collision with root package name */
    public String f30151b;

    /* renamed from: c  reason: collision with root package name */
    public String f30152c;

    /* renamed from: d  reason: collision with root package name */
    public float f30153d;

    /* renamed from: e  reason: collision with root package name */
    public String f30154e;

    /* renamed from: f  reason: collision with root package name */
    public String f30155f;

    /* renamed from: g  reason: collision with root package name */
    public String f30156g;

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
            this.f30150a = "";
            this.f30151b = "";
            this.f30152c = "";
            this.f30153d = 0.0f;
            this.f30154e = "";
            this.f30155f = "";
            this.f30156g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30150a + ", bft : " + this.f30151b + ", fc : " + this.f30152c + ", time : " + this.f30153d + ", cpu : " + this.f30154e + ", mem : " + this.f30155f + ", gpu : " + this.f30156g;
        }
        return (String) invokeV.objValue;
    }
}
