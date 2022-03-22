package c.m.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f23604b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f23605c;

    public w5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 101;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optInt(Constants.KEYS.RET);
            this.f23604b = jSONObject.optString("msg");
            String optString = jSONObject.optString("data");
            try {
                optString = r0.x(optString);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(optString)) {
                this.f23605c = new JSONObject();
            } else {
                this.f23605c = new JSONObject(optString);
            }
        }
    }
}
