package c.a.r0.p1.o.h;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f23558a;

        /* renamed from: b  reason: collision with root package name */
        public String f23559b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f23560c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f23561d;

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
                    return;
                }
            }
            this.f23560c = new ArrayList<>();
            this.f23561d = new ArrayList<>();
        }

        public void a(JSONObject jSONObject) {
            JSONArray optJSONArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("ad_monitor_url")) == null) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("show_url");
                    if (!TextUtils.isEmpty(optString)) {
                        this.f23560c.add(optString);
                    }
                    String optString2 = optJSONObject.optString("click_url");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f23561d.add(optString2);
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
