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
    public String f1118b;

    /* renamed from: c  reason: collision with root package name */
    public String f1119c;

    /* renamed from: d  reason: collision with root package name */
    public float f1120d;

    /* renamed from: e  reason: collision with root package name */
    public String f1121e;

    /* renamed from: f  reason: collision with root package name */
    public String f1122f;

    /* renamed from: g  reason: collision with root package name */
    public String f1123g;

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
            this.f1118b = "";
            this.f1119c = "";
            this.f1120d = 0.0f;
            this.f1121e = "";
            this.f1122f = "";
            this.f1123g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.a + ", bft : " + this.f1118b + ", fc : " + this.f1119c + ", time : " + this.f1120d + ", cpu : " + this.f1121e + ", mem : " + this.f1122f + ", gpu : " + this.f1123g;
        }
        return (String) invokeV.objValue;
    }
}
