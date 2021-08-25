package c.a.w0.f.b.c;

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
    public String f30491a;

    /* renamed from: b  reason: collision with root package name */
    public String f30492b;

    /* renamed from: c  reason: collision with root package name */
    public String f30493c;

    /* renamed from: d  reason: collision with root package name */
    public float f30494d;

    /* renamed from: e  reason: collision with root package name */
    public String f30495e;

    /* renamed from: f  reason: collision with root package name */
    public String f30496f;

    /* renamed from: g  reason: collision with root package name */
    public String f30497g;

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
            this.f30491a = "";
            this.f30492b = "";
            this.f30493c = "";
            this.f30494d = 0.0f;
            this.f30495e = "";
            this.f30496f = "";
            this.f30497g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f30491a + ", bft : " + this.f30492b + ", fc : " + this.f30493c + ", time : " + this.f30494d + ", cpu : " + this.f30495e + ", mem : " + this.f30496f + ", gpu : " + this.f30497g;
        }
        return (String) invokeV.objValue;
    }
}
