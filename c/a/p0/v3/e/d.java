package c.a.p0.v3.e;

import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19260b;

    /* renamed from: c  reason: collision with root package name */
    public String f19261c;

    /* renamed from: d  reason: collision with root package name */
    public String f19262d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f19263e;

    public d() {
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

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.a = jSONObject.optString("menu_type");
            this.f19260b = jSONObject.optString(ForumListActivity.KEY_MENU_NAME);
            this.f19261c = jSONObject.optString(ForumListActivity.KEY_MENU_ID);
            String optString = jSONObject.optString("default_logo_url", null);
            this.f19262d = optString;
            this.f19262d = optString != null ? this.f19262d + "?v=2" : null;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<d> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    d dVar = new d();
                    dVar.a(optJSONArray.getJSONObject(i));
                    arrayList.add(dVar);
                }
                this.f19263e = arrayList;
            }
        }
    }
}
