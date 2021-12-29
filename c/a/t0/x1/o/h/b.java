package c.a.t0.x1.o.h;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface b {

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f25924b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f25925c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f25926d;

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
            this.f25925c = new ArrayList<>();
            this.f25926d = new ArrayList<>();
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
                        this.f25925c.add(optString);
                    }
                    String optString2 = optJSONObject.optString("click_url");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f25926d.add(optString2);
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
