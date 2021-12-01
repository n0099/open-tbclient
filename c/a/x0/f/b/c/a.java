package c.a.x0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26830b;

    /* renamed from: c  reason: collision with root package name */
    public String f26831c;

    /* renamed from: d  reason: collision with root package name */
    public float f26832d;

    /* renamed from: e  reason: collision with root package name */
    public String f26833e;

    /* renamed from: f  reason: collision with root package name */
    public String f26834f;

    /* renamed from: g  reason: collision with root package name */
    public String f26835g;

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
            this.f26830b = "";
            this.f26831c = "";
            this.f26832d = 0.0f;
            this.f26833e = "";
            this.f26834f = "";
            this.f26835g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.a + ", bft : " + this.f26830b + ", fc : " + this.f26831c + ", time : " + this.f26832d + ", cpu : " + this.f26833e + ", mem : " + this.f26834f + ", gpu : " + this.f26835g;
        }
        return (String) invokeV.objValue;
    }
}
