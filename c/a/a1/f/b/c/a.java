package c.a.a1.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1120b;

    /* renamed from: c  reason: collision with root package name */
    public String f1121c;

    /* renamed from: d  reason: collision with root package name */
    public float f1122d;

    /* renamed from: e  reason: collision with root package name */
    public String f1123e;

    /* renamed from: f  reason: collision with root package name */
    public String f1124f;

    /* renamed from: g  reason: collision with root package name */
    public String f1125g;

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
            this.f1120b = "";
            this.f1121c = "";
            this.f1122d = 0.0f;
            this.f1123e = "";
            this.f1124f = "";
            this.f1125g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.a + ", bft : " + this.f1120b + ", fc : " + this.f1121c + ", time : " + this.f1122d + ", cpu : " + this.f1123e + ", mem : " + this.f1124f + ", gpu : " + this.f1125g;
        }
        return (String) invokeV.objValue;
    }
}
