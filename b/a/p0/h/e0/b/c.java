package b.a.p0.h.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10391a;

    /* renamed from: b  reason: collision with root package name */
    public String f10392b;

    /* renamed from: c  reason: collision with root package name */
    public String f10393c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f10394d;

    /* renamed from: e  reason: collision with root package name */
    public d f10395e;

    public c() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{ videoPath=" + this.f10391a + " , query=" + this.f10392b + " , title=" + this.f10393c + ", extra=" + this.f10394d + ", videoEditorParams=" + this.f10395e + " }";
        }
        return (String) invokeV.objValue;
    }
}
