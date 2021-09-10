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
    public String f30723a;

    /* renamed from: b  reason: collision with root package name */
    public String f30724b;

    /* renamed from: c  reason: collision with root package name */
    public String f30725c;

    /* renamed from: d  reason: collision with root package name */
    public float f30726d;

    /* renamed from: e  reason: collision with root package name */
    public String f30727e;

    /* renamed from: f  reason: collision with root package name */
    public String f30728f;

    /* renamed from: g  reason: collision with root package name */
    public String f30729g;

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
            this.f30723a = "";
            this.f30724b = "";
            this.f30725c = "";
            this.f30726d = 0.0f;
            this.f30727e = "";
            this.f30728f = "";
            this.f30729g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30723a + ", bft : " + this.f30724b + ", fc : " + this.f30725c + ", time : " + this.f30726d + ", cpu : " + this.f30727e + ", mem : " + this.f30728f + ", gpu : " + this.f30729g;
        }
        return (String) invokeV.objValue;
    }
}
