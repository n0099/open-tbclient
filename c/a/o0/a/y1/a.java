package c.a.o0.a.y1;

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
    public List<C0471a> f9816a;

    /* renamed from: b  reason: collision with root package name */
    public String f9817b;

    /* renamed from: c.a.o0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0471a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f9818a;

        /* renamed from: b  reason: collision with root package name */
        public String f9819b;

        /* renamed from: c  reason: collision with root package name */
        public String f9820c;

        public C0471a() {
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
            aVar.f9817b = jSONObject.optString(SwanAppRelatedSwanListAdapter.PAGE_ABOUT_MORE_RELATED_SWAN);
            JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        C0471a c0471a = new C0471a();
                        optJSONObject.optString("app_key");
                        c0471a.f9819b = optJSONObject.optString("app_name");
                        c0471a.f9818a = optJSONObject.optString("photo_addr");
                        c0471a.f9820c = optJSONObject.optString("scheme");
                        arrayList.add(c0471a);
                    }
                }
                aVar.f9816a = arrayList;
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}
