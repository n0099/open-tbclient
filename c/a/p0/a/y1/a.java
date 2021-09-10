package c.a.p0.a.y1;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0473a> f9844a;

    /* renamed from: b  reason: collision with root package name */
    public String f9845b;

    /* renamed from: c.a.p0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0473a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f9846a;

        /* renamed from: b  reason: collision with root package name */
        public String f9847b;

        /* renamed from: c  reason: collision with root package name */
        public String f9848c;

        public C0473a() {
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
    }

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

    @Nullable
    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f9845b = jSONObject.optString(SwanAppRelatedSwanListAdapter.PAGE_ABOUT_MORE_RELATED_SWAN);
            JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        C0473a c0473a = new C0473a();
                        optJSONObject.optString("app_key");
                        c0473a.f9847b = optJSONObject.optString("app_name");
                        c0473a.f9846a = optJSONObject.optString("photo_addr");
                        c0473a.f9848c = optJSONObject.optString("scheme");
                        arrayList.add(c0473a);
                    }
                }
                aVar.f9844a = arrayList;
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}
