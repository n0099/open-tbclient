package b.o.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34097a;

    /* renamed from: b  reason: collision with root package name */
    public String f34098b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f34099c;

    public b6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34097a = 101;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            this.f34097a = jSONObject.optInt(Constants.KEYS.RET);
            this.f34098b = jSONObject.optString("msg");
            String optString = jSONObject.optString("data");
            try {
                optString = r0.x(optString);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(optString)) {
                this.f34099c = new JSONObject();
            } else {
                this.f34099c = new JSONObject(optString);
            }
        }
    }
}
