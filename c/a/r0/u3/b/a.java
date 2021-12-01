package c.a.r0.u3.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f24560b;

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

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("splash_schedule")) == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
        if (optJSONArray != null) {
            this.a = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                b bVar = new b();
                bVar.d(optJSONArray.optJSONObject(i2));
                this.a.add(bVar);
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("next");
        if (optJSONArray != null) {
            this.f24560b = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                b bVar2 = new b();
                bVar2.d(optJSONArray2.optJSONObject(i3));
                this.f24560b.add(bVar2);
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject != null) {
            a(jSONObject);
        }
    }
}
