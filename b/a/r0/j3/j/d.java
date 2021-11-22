package b.a.r0.j3.j;

import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20041a;

    /* renamed from: b  reason: collision with root package name */
    public String f20042b;

    /* renamed from: c  reason: collision with root package name */
    public String f20043c;

    /* renamed from: d  reason: collision with root package name */
    public String f20044d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f20045e;

    public d() {
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

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f20041a = jSONObject.optString("menu_type");
            this.f20042b = jSONObject.optString(ForumListActivity.KEY_MENU_NAME);
            this.f20043c = jSONObject.optString(ForumListActivity.KEY_MENU_ID);
            String optString = jSONObject.optString("default_logo_url", null);
            this.f20044d = optString;
            this.f20044d = optString != null ? this.f20044d + "?v=2" : null;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<d> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.a(optJSONArray.getJSONObject(i2));
                    arrayList.add(dVar);
                }
                this.f20045e = arrayList;
            }
        }
    }
}
