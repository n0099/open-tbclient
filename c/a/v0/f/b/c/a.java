package c.a.v0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f21538b;

    /* renamed from: c  reason: collision with root package name */
    public String f21539c;

    /* renamed from: d  reason: collision with root package name */
    public float f21540d;

    /* renamed from: e  reason: collision with root package name */
    public String f21541e;

    /* renamed from: f  reason: collision with root package name */
    public String f21542f;

    /* renamed from: g  reason: collision with root package name */
    public String f21543g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = "";
            this.f21538b = "";
            this.f21539c = "";
            this.f21540d = 0.0f;
            this.f21541e = "";
            this.f21542f = "";
            this.f21543g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.a + ", bft : " + this.f21538b + ", fc : " + this.f21539c + ", time : " + this.f21540d + ", cpu : " + this.f21541e + ", mem : " + this.f21542f + ", gpu : " + this.f21543g;
        }
        return (String) invokeV.objValue;
    }
}
